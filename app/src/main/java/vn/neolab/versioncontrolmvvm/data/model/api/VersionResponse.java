package vn.neolab.versioncontrolmvvm.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class VersionResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("error")
    @Expose
    private Error error;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public class Data {

        @SerializedName("data")
        @Expose
        private Data_ data;

        public Data_ getData() {
            return data;
        }

        public void setData(Data_ data) {
            this.data = data;
        }

    }

    public class Data_ {

        @SerializedName("prod")
        @Expose
        private List<Version> prod = null;
        @SerializedName("dev")
        @Expose
        private List<Version> dev = null;
        @SerializedName("test")
        @Expose
        private List<Version> test = null;

        public List<Version> getProd() {
            return prod;
        }

        public void setProd(List<Version> prod) {
            this.prod = prod;
        }

        public List<Version> getDev() {
            return dev;
        }

        public void setDev(List<Version> dev) {
            this.dev = dev;
        }

        public List<Version> getTest() {
            return test;
        }

        public void setTest(List<Version> test) {
            this.test = test;
        }

    }


    class Error {

        @SerializedName("code")
        @Expose
        private Integer code;
        @SerializedName("message")
        @Expose
        private Object message;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public Object getMessage() {
            return message;
        }

        public void setMessage(Object message) {
            this.message = message;
        }

    }


    public static class Version implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("env")
        @Expose
        private String env;
        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("ipa_s3_key")
        @Expose
        private String ipaS3Key;
        @SerializedName("plist_s3_key")
        @Expose
        private String plistS3Key;
        @SerializedName("version")
        @Expose
        private String version;
        @SerializedName("build")
        @Expose
        private String build;
        @SerializedName("is_latest_version")
        @Expose
        private Integer isLatestVersion;
        @SerializedName("device_type")
        @Expose
        private Integer deviceType;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("app_url")
        @Expose
        private String appUrl;

        public Version(Integer id, String env, String uuid, String ipaS3Key, String plistS3Key, String version, String build, Integer isLatestVersion, Integer deviceType, String createdAt, String appUrl) {
            this.id = id;
            this.env = env;
            this.uuid = uuid;
            this.ipaS3Key = ipaS3Key;
            this.plistS3Key = plistS3Key;
            this.version = version;
            this.build = build;
            this.isLatestVersion = isLatestVersion;
            this.deviceType = deviceType;
            this.createdAt = createdAt;
            this.appUrl = appUrl;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getEnv() {
            return env;
        }

        public void setEnv(String env) {
            this.env = env;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getIpaS3Key() {
            return ipaS3Key;
        }

        public void setIpaS3Key(String ipaS3Key) {
            this.ipaS3Key = ipaS3Key;
        }

        public String getPlistS3Key() {
            return plistS3Key;
        }

        public void setPlistS3Key(String plistS3Key) {
            this.plistS3Key = plistS3Key;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getBuild() {
            return build;
        }

        public void setBuild(String build) {
            this.build = build;
        }

        public Integer getIsLatestVersion() {
            return isLatestVersion;
        }

        public void setIsLatestVersion(Integer isLatestVersion) {
            this.isLatestVersion = isLatestVersion;
        }

        public Integer getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(Integer deviceType) {
            this.deviceType = deviceType;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getAppUrl() {
            return appUrl;
        }

        public void setAppUrl(String appUrl) {
            this.appUrl = appUrl;
        }

    }

}


