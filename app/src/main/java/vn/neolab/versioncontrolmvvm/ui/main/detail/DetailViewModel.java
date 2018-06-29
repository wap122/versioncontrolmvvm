package vn.neolab.versioncontrolmvvm.ui.main.detail;

import vn.neolab.versioncontrolmvvm.data.DataManager;
import vn.neolab.versioncontrolmvvm.ui.base.BaseViewModel;
import vn.neolab.versioncontrolmvvm.utils.rx.SchedulerProvider;

public class DetailViewModel extends BaseViewModel<DetailNavigator> {

    public DetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
