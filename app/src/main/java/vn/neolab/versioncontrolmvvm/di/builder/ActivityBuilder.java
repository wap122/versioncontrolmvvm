package vn.neolab.versioncontrolmvvm.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import vn.neolab.versioncontrolmvvm.ui.main.MainActivity;
import vn.neolab.versioncontrolmvvm.ui.main.MainActivityModule;
import vn.neolab.versioncontrolmvvm.ui.main.detail.DetailFragmentProvider;
import vn.neolab.versioncontrolmvvm.ui.main.version.VersionFragment;
import vn.neolab.versioncontrolmvvm.ui.main.version.VersionFragmentModule;
import vn.neolab.versioncontrolmvvm.ui.main.version.VersionFragmentProvider;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {MainActivityModule.class, VersionFragmentProvider.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {VersionFragmentModule.class, DetailFragmentProvider.class})
    abstract VersionFragment bindVersionFragment();
}
