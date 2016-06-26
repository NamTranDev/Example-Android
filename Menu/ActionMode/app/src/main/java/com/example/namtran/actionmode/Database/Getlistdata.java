package com.example.namtran.actionmode.Database;

import com.example.namtran.actionmode.Country;

import java.util.List;

/**
 * Created by Nam Tran on 6/20/2015.
 */
public class Getlistdata extends Listdata {
    public Getlistdata() {
        data.add(" CREATE TABLE " +  Country.TABLE_NAME
                + "( " + Country._ID + " INTEGER PRIMARY KEY, "
                + Country.NAME_VI + " TEXT, "
                + Country.NAME_EN + " TEXT )");
    }
}
