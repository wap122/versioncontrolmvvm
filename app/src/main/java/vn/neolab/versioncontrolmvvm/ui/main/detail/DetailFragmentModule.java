package vn.neolab.versioncontrolmvvm.ui.main.detail;

import dagger.Module;
import dagger.Provides;
import vn.neolab.versioncontrolmvvm.data.DataManager;
import vn.neolab.versioncontrolmvvm.utils.rx.SchedulerProvider;

@Module
public class DetailFragmentModule {

    @Provides
    DetailViewModel provideDetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new DetailViewModel(dataManager, schedulerProvider);
    }
}
