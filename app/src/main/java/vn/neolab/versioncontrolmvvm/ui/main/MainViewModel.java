package vn.neolab.versioncontrolmvvm.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableBoolean;

import vn.neolab.versioncontrolmvvm.data.DataManager;
import vn.neolab.versioncontrolmvvm.ui.base.BaseViewModel;
import vn.neolab.versioncontrolmvvm.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    public ObservableBoolean isShow = new ObservableBoolean(false);


//    private Callback

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void setShow(boolean isShow) {
        this.isShow.set(isShow);
    }

    public void onBackClick() {
        getNavigator().onBackClick();
    }
}
