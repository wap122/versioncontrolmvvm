package vn.neolab.versioncontrolmvvm.ui.main.version;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class VersionFragmentProvider {
    @ContributesAndroidInjector(modules = {VersionFragmentModule.class})
    abstract VersionFragment provideVersionFragmentFactory();
}
