package vn.neolab.versioncontrolmvvm.ui.main;

import vn.neolab.versioncontrolmvvm.data.DataManager;
import vn.neolab.versioncontrolmvvm.ui.base.BaseViewModel;
import vn.neolab.versioncontrolmvvm.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel {

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }


}
