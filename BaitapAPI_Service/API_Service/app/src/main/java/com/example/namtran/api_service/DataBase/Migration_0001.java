package com.example.namtran.api_service.DataBase;


import com.example.namtran.api_service.Class.Email;

public class Migration_0001 extends Migration {
    public Migration_0001() {
        steps.add("CREATE TABLE " + Email.TABLE
                + " (" + Email.ID + " INTEGER PRIMARY KEY, "
                + Email.TITLE + " TEXT, "
                + Email.DESCRIPTION + " TEXT, "
                + Email.DATE + " TEXT)");

    }
}