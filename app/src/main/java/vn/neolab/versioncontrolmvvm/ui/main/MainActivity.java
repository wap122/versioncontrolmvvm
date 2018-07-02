package vn.neolab.versioncontrolmvvm.ui.main;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.downloader.PRDownloader;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import vn.neolab.versioncontrolmvvm.BR;
import vn.neolab.versioncontrolmvvm.R;
import vn.neolab.versioncontrolmvvm.databinding.ActivityMainBinding;
import vn.neolab.versioncontrolmvvm.ui.base.BaseActivity;
import vn.neolab.versioncontrolmvvm.ui.main.version.VersionFragment;
import vn.neolab.versioncontrolmvvm.utils.FragmentUtils;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements
        HasSupportFragmentInjector, MainNavigator {

    @Inject
    MainViewModel mMainViewModel;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    private ActivityMainBinding mActivityMainBinding;

//    public static Intent newIntent(Context context) {
//        return new Intent(context, MainActivity.class);
//    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return mMainViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = getViewDataBinding();
        setup();
        subscribeToLiveData();
    }

    private void subscribeToLiveData() {
        getViewModel().getBackEvent().observe(this, fragmentName -> {
            onBackClick();
        });
    }

    private void setup() {
        setSupportActionBar(findViewById(R.id.my_toolbar));
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mActivityMainBinding.shadowView.setVisibility(View.GONE);
        }
        showVersionFragment();
    }

    private void showVersionFragment() {
        FragmentUtils.replaceFragmentInActivity(this, VersionFragment.class, R.id.fragment_container, false, null);
    }

    @Override
    public void onBackPressed() {
        if (onBackClick()) super.onBackPressed();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public boolean onBackClick() {
        int countChildFragment = getSupportFragmentManager().getFragments().get(0)
                .getChildFragmentManager().getBackStackEntryCount();
        if (countChildFragment == 1) {
            getViewModel().setShow(false);
        }
        if (countChildFragment >= 1) {
            getSupportFragmentManager().getFragments().get(0).getChildFragmentManager().popBackStack();
            return false;
        }

        return true;
    }

    @Override
    public void changeBackButtonVisibility(boolean isShow) {
        mMainViewModel.setShow(isShow);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PRDownloader.cancelAll();
    }
}
