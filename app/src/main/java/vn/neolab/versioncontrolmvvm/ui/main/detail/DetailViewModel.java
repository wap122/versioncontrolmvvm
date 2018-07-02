package vn.neolab.versioncontrolmvvm.ui.main.detail;

import android.databinding.ObservableField;

import java.util.Objects;

import vn.neolab.versioncontrolmvvm.R;
import vn.neolab.versioncontrolmvvm.data.DataManager;
import vn.neolab.versioncontrolmvvm.data.model.api.VersionResponse.Version;
import vn.neolab.versioncontrolmvvm.ui.base.BaseViewModel;
import vn.neolab.versioncontrolmvvm.utils.rx.SchedulerProvider;

public class DetailViewModel extends BaseViewModel<DetailNavigator> {

    public ObservableField<Version> mVersion = new ObservableField<>();
    public ObservableField<String> build = new ObservableField<>();
    public ObservableField<Integer> progress = new ObservableField<>(0);
    public ObservableField<Integer> imageId = new ObservableField<>();

    DetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void setVersion(Version version) {
        mVersion.set(version);
        build.set("Build " + version.getBuild() + " (" + version.getCreatedAt() + ")");
        switch (version.getEnv()) {
            case "prod":
                imageId.set(R.drawable.ic_prod);
                break;
            case "dev":
                imageId.set(R.drawable.ic_dev);
                break;
            case "test":
                imageId.set(R.drawable.ic_test);
                break;
        }
    }

    public void onDownloadClick() {
        getNavigator().onDownloadClick(Objects.requireNonNull(mVersion.get()).getAppUrl());
    }

    public void onProgressUpdate(int per) {
        progress.set(per);
    }
}
