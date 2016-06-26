package com.example.namtran.demo_sqlite_listview;

import java.util.List;

/**
 * Created by Nam Tran on 6/6/2015.
 */
public interface Iprovider {
    List<Country> get();
    long insert(String NameVi,String NameEn);
    int update(long id, String NameVi, String NameEn);
    int delete(long id);
}
