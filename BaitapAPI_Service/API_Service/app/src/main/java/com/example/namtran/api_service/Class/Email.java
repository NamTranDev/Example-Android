package com.example.namtran.api_service.Class;

/**
 * Created by Nam Tran on 8/10/2015.
 */
public class Email {
    public static final String TABLE = "EMAIL";
    public static final String ID = "Id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String DATE = "date";


    int id;
    String title;
    String description;
    String date;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
