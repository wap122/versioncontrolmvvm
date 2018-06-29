package vn.neolab.versioncontrolmvvm.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import vn.neolab.versioncontrolmvvm.data.AppDataManager;
import vn.neolab.versioncontrolmvvm.data.DataManager;
import vn.neolab.versioncontrolmvvm.data.remote.ApiHelper;
import vn.neolab.versioncontrolmvvm.data.remote.AppApiHelper;
import vn.neolab.versioncontrolmvvm.utils.rx.AppSchedulerProvider;
import vn.neolab.versioncontrolmvvm.utils.rx.SchedulerProvider;

@Module
public class AppModule {

    @Singleton
    @Provides
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Singleton
    @Provides
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
