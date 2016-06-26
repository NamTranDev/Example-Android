package com.example.namtran.sqlite_internal;

import android.content.ContentValues;

import java.util.List;

/**
 * Created by Nam Tran on 6/9/2015.
 */
public interface Iprovider {
    List<Country> get();
    long insert(String NameVi,String NameEn);
    long update( long id , String NameVi , String NameEn);
    long delete(long id);
}
