package com.example.namtran.api_service.Class;

/**
 * Created by Nam Tran on 8/10/2015.
 */
public class EmailPost {

    public static final String STATUSEMAIL = "status";
    public static final String ERROREMAIL = "error_message";
    public static final String EMAIL = "emails";

    int StatusEmail;
    String ErrorEmail;
    Email email;

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public int getStatusEmail() {
        return StatusEmail;
    }

    public void setStatusEmail(int statusEmail) {
        StatusEmail = statusEmail;
    }

    public String getErrorEmail() {
        return ErrorEmail;
    }

    public void setErrorEmail(String errorEmail) {
        ErrorEmail = errorEmail;
    }


    public void setEmail(String string) {

    }
}
