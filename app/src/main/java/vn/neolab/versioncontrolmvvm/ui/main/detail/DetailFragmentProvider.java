package vn.neolab.versioncontrolmvvm.ui.main.detail;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DetailFragmentProvider {
    @ContributesAndroidInjector(modules = {DetailFragmentModule.class})
    abstract DetailFragment provideDetailFragmentFactory();
}
