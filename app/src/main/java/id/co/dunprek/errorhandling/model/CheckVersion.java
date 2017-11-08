package id.co.dunprek.errorhandling.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CheckVersion {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("timestamp")
    @Expose
    public String timestamp;

    @SerializedName("result")
    @Expose
    public Result result;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result {

        @SerializedName("ver_apk")
        @Expose
        public String verApk;
        @SerializedName("ver_display")
        @Expose
        public String verDisplay;

        public String getVerApk() {
            return verApk;
        }

        public void setVerApk(String verApk) {
            this.verApk = verApk;
        }

        public String getVerDisplay() {
            return verDisplay;
        }

        public void setVerDisplay(String verDisplay) {
            this.verDisplay = verDisplay;
        }
    }

}
