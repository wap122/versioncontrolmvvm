package vn.neolab.versioncontrolmvvm.data.remote;

import io.reactivex.Single;
import vn.neolab.versioncontrolmvvm.data.model.api.VersionResponse;

public interface ApiHelper {
    Single<VersionResponse> getVersionApiCall();
}
