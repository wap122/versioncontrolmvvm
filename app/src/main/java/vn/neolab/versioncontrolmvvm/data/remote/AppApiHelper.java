package vn.neolab.versioncontrolmvvm.data.remote;

import com.downloader.PRDownloader;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import org.apache.commons.io.FilenameUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;
import vn.neolab.versioncontrolmvvm.data.model.api.VersionResponse;

@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() {
    }

    @Override
    public Single<VersionResponse> getVersionApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG).build()
                .getObjectSingle(VersionResponse.class);
    }
}
