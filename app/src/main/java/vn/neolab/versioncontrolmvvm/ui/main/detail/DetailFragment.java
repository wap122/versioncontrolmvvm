package vn.neolab.versioncontrolmvvm.ui.main.detail;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.downloader.OnProgressListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Objects;

import javax.inject.Inject;

import vn.neolab.versioncontrolmvvm.BuildConfig;
import vn.neolab.versioncontrolmvvm.R;
import vn.neolab.versioncontrolmvvm.databinding.FragmentDetailBinding;
import vn.neolab.versioncontrolmvvm.ui.base.BaseFragment;
import vn.neolab.versioncontrolmvvm.ui.main.MainNavigator;
import vn.neolab.versioncontrolmvvm.utils.AppLogger;

public class DetailFragment extends BaseFragment<FragmentDetailBinding, DetailViewModel> implements
        DetailNavigator, OnProgressListener, OnDownloadListener {

    public static final String VERSION = "version";

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @Inject
    MainNavigator mMainNavigator;

    private FragmentDetailBinding mBinding;
    private DetailViewModel mViewModel;
    private String fileName;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_detail;
    }

    @Override
    public DetailViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(DetailViewModel.class);
        return mViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = getViewDataBinding();
        setup();
    }

    private void setup() {
        mMainNavigator.changeBackButtonVisibility(true);
    }

    @Override
    public void onDownloadClick(String appUrl) {
//        appUrl = "http://androidpala.com/tutorial/app-debug.apk";
        fileName = FilenameUtils.getName(appUrl);
        mBinding.pgBar.setVisibility(View.VISIBLE);
        PRDownloader.download(appUrl, Objects.requireNonNull(
                Objects.requireNonNull(getContext()).getExternalFilesDir("")).toString(),
                fileName).build().setOnProgressListener(this).start(this);
        mBinding.btnDownload.setEnabled(false);
    }

    @Override
    public void onProgress(Progress progress) {
        double per = (double) progress.currentBytes / progress.totalBytes * 100;
        mViewModel.onProgressUpdate((int) per);
    }

    @Override
    public void onDownloadComplete() {
        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        String dirFolder = Objects.requireNonNull(getBaseActivity().getExternalFilesDir("")).toString();
        Uri uri = FileProvider.getUriForFile(getBaseActivity(), BuildConfig.APPLICATION_ID, new File(dirFolder + "/" + fileName));
        intent.setDataAndType(uri, "application/vnd.android.package-archive");

        PackageManager pm = getBaseActivity().getPackageManager();
        if (intent.resolveActivity(pm) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onError(Error error) {
        AppLogger.d(error.toString());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        PRDownloader.cancelAll();
    }
}
