package vn.neolab.versioncontrolmvvm.ui.main.detail;

import android.databinding.ObservableField;

import vn.neolab.versioncontrolmvvm.data.DataManager;
import vn.neolab.versioncontrolmvvm.data.model.api.VersionResponse.Version;
import vn.neolab.versioncontrolmvvm.ui.base.BaseViewModel;
import vn.neolab.versioncontrolmvvm.utils.rx.SchedulerProvider;

public class DetailViewModel extends BaseViewModel<DetailNavigator> {

    public ObservableField<Version> mVersion = new ObservableField<>();

    DetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void setVersion(Version version) {
        mVersion.set(version);
    }

    public void onDownloadClick() {

    }

}
