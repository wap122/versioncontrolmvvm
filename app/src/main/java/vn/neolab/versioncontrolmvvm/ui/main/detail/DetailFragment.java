package vn.neolab.versioncontrolmvvm.ui.main.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;

import javax.inject.Inject;

import vn.neolab.versioncontrolmvvm.R;
import vn.neolab.versioncontrolmvvm.databinding.FragmentDetailBinding;
import vn.neolab.versioncontrolmvvm.ui.base.BaseFragment;

public class DetailFragment extends BaseFragment<FragmentDetailBinding, DetailViewModel> implements DetailNavigator {

    public static final String VERSION = "VERSION";

    @Inject
    DetailViewModel mDetailViewModel;

    FragmentDetailBinding mBinding;

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
        return mDetailViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetailViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = getViewDataBinding();
    }
}
