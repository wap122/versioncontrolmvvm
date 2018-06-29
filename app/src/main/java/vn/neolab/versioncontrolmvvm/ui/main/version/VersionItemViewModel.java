package vn.neolab.versioncontrolmvvm.ui.main.version;

import android.databinding.ObservableField;

import vn.neolab.versioncontrolmvvm.R;
import vn.neolab.versioncontrolmvvm.data.model.api.VersionResponse;

public class VersionItemViewModel {

    public final ObservableField<String> ver;
    public final ObservableField<String> build;
    public final ObservableField<String> time;
    public ObservableField<Integer> imageId;

    private final VersionItemViewModelListener mListener;
    private final VersionResponse.Version mVersion;

    VersionItemViewModel(VersionResponse.Version version, VersionItemViewModelListener listener) {
        mListener = listener;
        mVersion = version;

        ver = new ObservableField<>(mVersion.getVersion());
        build = new ObservableField<>(mVersion.getBuild());
        time = new ObservableField<>(mVersion.getCreatedAt());

        switch (mVersion.getEnv()) {
            case "prod":
                imageId = new ObservableField<>(R.drawable.ic_prod);
                break;
            case "dev":
                imageId = new ObservableField<>(R.drawable.ic_dev);
                break;
            case "test":
                imageId = new ObservableField<>(R.drawable.ic_test);
                break;
        }

    }

    public void onItemClick() {
        mListener.onItemClick(mVersion);
    }

    public interface VersionItemViewModelListener {
        void onItemClick(VersionResponse.Version version);
    }
}
