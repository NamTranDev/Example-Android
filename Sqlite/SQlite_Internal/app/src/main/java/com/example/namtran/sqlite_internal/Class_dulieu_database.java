package com.example.namtran.sqlite_internal;

/**
 * Created by Nam Tran on 6/8/2015.
 */
public class Class_dulieu_database extends Class_dulieu {
    public Class_dulieu_database()
    {
        list.add(" CREATE TABLE " +  Country.TABLE_NAME
               + "( " + Country._ID + " INTEGER PRIMARY KEY, "
               + Country.NAME_VI + " TEXT, "
               + Country.NAME_EN + " TEXT )");
    }
}
