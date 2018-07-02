package vn.neolab.versioncontrolmvvm.data.remote;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.Single;
import vn.neolab.versioncontrolmvvm.data.model.api.VersionResponse;

public interface ApiHelper {
    Single<VersionResponse> getVersionApiCall();

//    Observable<Integer> getFileDownload(String url, String dirPath);
}
