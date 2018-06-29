package vn.neolab.versioncontrolmvvm.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

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

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements HasSupportFragmentInjector {

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
    }

    private void setup() {
        setSupportActionBar(findViewById(R.id.my_toolbar));
        showVersionFragment();
    }

    private void showVersionFragment() {
        FragmentUtils.replaceFragment(this, VersionFragment.class, R.id.fragment_container, false, null);
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
