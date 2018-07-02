package vn.neolab.versioncontrolmvvm.ui.main.detail;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import vn.neolab.versioncontrolmvvm.ViewModelProviderFactory;
import vn.neolab.versioncontrolmvvm.data.DataManager;
import vn.neolab.versioncontrolmvvm.data.model.api.VersionResponse;
import vn.neolab.versioncontrolmvvm.ui.main.MainActivity;
import vn.neolab.versioncontrolmvvm.ui.main.MainNavigator;
import vn.neolab.versioncontrolmvvm.utils.rx.SchedulerProvider;

import static vn.neolab.versioncontrolmvvm.ui.main.detail.DetailFragment.VERSION;

@Module
public class DetailFragmentModule {

    @Provides
    DetailViewModel provideDetailViewModel(DetailFragment fragment, DataManager dataManager,
                                           SchedulerProvider schedulerProvider) {
        DetailViewModel viewModel = new DetailViewModel(dataManager, schedulerProvider);
        if (fragment.getArguments() != null) {
            VersionResponse.Version version = (VersionResponse.Version) fragment.getArguments()
                    .getSerializable(VERSION);
            viewModel.setVersion(version);
        }
        return viewModel;
    }

    @Provides
    ViewModelProvider.Factory provideFactory(DetailViewModel detailViewModel) {
        return new ViewModelProviderFactory<>(detailViewModel);
    }

    @Provides
    MainNavigator provideMainNavigator(MainActivity mainActivity) {
        return mainActivity;
    }
}
