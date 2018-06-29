package vn.neolab.versioncontrolmvvm.ui.main.version;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import java.util.List;

import vn.neolab.versioncontrolmvvm.data.DataManager;
import vn.neolab.versioncontrolmvvm.data.model.api.VersionResponse;
import vn.neolab.versioncontrolmvvm.ui.base.BaseViewModel;
import vn.neolab.versioncontrolmvvm.utils.rx.SchedulerProvider;

public class VersionViewModel extends BaseViewModel<VersionNavigator> {

    public final ObservableList<VersionResponse.Version> versionObservable = new ObservableArrayList<>();

    private final MutableLiveData<List<VersionResponse.Version>> versionListLiveData;

    VersionViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        versionListLiveData = new MutableLiveData<>();
        fetchVersion();
    }

    public void fetchVersion() {
        getCompositeDisposable().add(getDataManager().getVersionApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(versionResponse -> {
                    if (versionResponse != null && versionResponse.getData() != null) {
                        VersionResponse.Data_ data = versionResponse.getData().getData();
                        List<VersionResponse.Version> finalList = data.getDev();
                        finalList.addAll(data.getProd());
                        finalList.addAll(data.getTest());
                        versionListLiveData.setValue(finalList);
                    }
                }, throwable -> {
                    getNavigator().handleError(throwable);
                }));
    }

    public void addVersionItemToList(List<VersionResponse.Version> list) {
        versionObservable.clear();
        versionObservable.addAll(list);
    }

    public MutableLiveData<List<VersionResponse.Version>> getVersionListLiveData() {
        return versionListLiveData;
    }
}
