package com.example.namtran.demo_sqlite_listview;

import android.content.Context;

import java.util.List;

/**
 * Created by Nam Tran on 6/6/2015.
 */
public class Provider implements Iprovider {
    getData_SQLite dataSqLite;
    public Provider(Context context,String path)
    {
        dataSqLite = new getData_SQLite(context,path);
    }
    @Override
    public List<Country> get() {
        return dataSqLite.get();
    }

    @Override
    public long insert(String NameVi, String NameEn) {

        return dataSqLite.insert(NameVi,NameEn);
    }

    @Override
    public int update(long id, String NameVi, String NameEn) {
        return dataSqLite.update(id, NameVi, NameEn);
    }

    @Override
    public int delete(long id) {
        return dataSqLite.delete(id);
    }


}
