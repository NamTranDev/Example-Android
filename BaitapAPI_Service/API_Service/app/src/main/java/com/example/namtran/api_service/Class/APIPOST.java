package com.example.namtran.api_service.Class;

/**
 * Created by Nam Tran on 8/10/2015.
 */
public class APIPOST {
    public static final String STATUS = "status";
    public static final String ERROR = "error";
    public static final String ACCESS_TOKEN = "access_token";
    int status;
    String error;
    String access_token;

    public APIPOST() {
        this.status = status;
        this.error = error;
        this.access_token = access_token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public String toString() {
        return access_token;
    }
}
