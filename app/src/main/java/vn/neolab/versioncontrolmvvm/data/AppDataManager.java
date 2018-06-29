package vn.neolab.versioncontrolmvvm.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import vn.neolab.versioncontrolmvvm.data.model.api.VersionResponse;
import vn.neolab.versioncontrolmvvm.data.remote.ApiHelper;

@Singleton
public class AppDataManager implements DataManager {

    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(ApiHelper apiHelper) {
        mApiHelper = apiHelper;
    }

    @Override
    public Single<VersionResponse> getVersionApiCall() {
        return mApiHelper.getVersionApiCall();
    }
}
