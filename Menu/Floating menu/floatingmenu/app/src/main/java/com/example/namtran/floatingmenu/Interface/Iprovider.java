package com.example.namtran.floatingmenu.Interface;

import com.example.namtran.floatingmenu.Database.Country;

import java.util.List;

/**
 * Created by Nam Tran on 6/16/2015.
 */
public interface Iprovider {
    List<Country> get();
    long insert(String NameVi, String NameEn);
    long update(long id,String NameVi, String NameEn);
    long delete(long id);
}
