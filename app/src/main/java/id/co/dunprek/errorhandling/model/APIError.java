package id.co.dunprek.errorhandling.model;

/**
 * Created by gideon on 11/8/17.
 */

public class APIError {

    private boolean status;
    private String error;

    public APIError() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}