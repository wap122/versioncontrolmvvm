package vn.neolab.versioncontrolmvvm.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import vn.neolab.versioncontrolmvvm.ui.main.MainActivity;
import vn.neolab.versioncontrolmvvm.ui.main.MainActivityModule;
import vn.neolab.versioncontrolmvvm.ui.main.detail.DetailFragmentProvider;
import vn.neolab.versioncontrolmvvm.ui.main.version.VersionFragmentProvider;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {MainActivityModule.class, VersionFragmentProvider.class,
            DetailFragmentProvider.class})
    abstract MainActivity bindMainActivity();
}
