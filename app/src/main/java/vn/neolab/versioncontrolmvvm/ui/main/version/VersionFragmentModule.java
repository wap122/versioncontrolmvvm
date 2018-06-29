package vn.neolab.versioncontrolmvvm.ui.main.version;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import vn.neolab.versioncontrolmvvm.ViewModelProviderFactory;
import vn.neolab.versioncontrolmvvm.data.DataManager;
import vn.neolab.versioncontrolmvvm.utils.rx.SchedulerProvider;

@Module
public class VersionFragmentModule {

    @Provides
    VersionViewModel provideVersionViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new VersionViewModel(dataManager, schedulerProvider);
    }

    @Provides
    ViewModelProvider.Factory provideFactory(VersionViewModel versionViewModel) {
        return new ViewModelProviderFactory<>(versionViewModel);
    }

    @Provides
    VersionAdapter provideVersionAdapter() {
        return new VersionAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(VersionFragment fragment) {
        return new LinearLayoutManager(fragment.getContext());
    }
}
