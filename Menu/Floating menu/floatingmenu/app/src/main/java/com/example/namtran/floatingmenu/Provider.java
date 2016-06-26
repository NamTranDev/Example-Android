package com.example.namtran.floatingmenu;

import android.content.Context;

import com.example.namtran.floatingmenu.Database.Country;
import com.example.namtran.floatingmenu.Database.Get_database;
import com.example.namtran.floatingmenu.Interface.Iprovider;

import java.util.List;

/**
 * Created by Nam Tran on 6/16/2015.
 */
public class Provider implements Iprovider {
    Get_database get_database;

    public Provider(Context context,String path) {
        get_database = new Get_database(context,path);
    }

    @Override
    public List<Country> get() {
        return get_database.get();
    }

    @Override
    public long insert(String NameVi,String NameEn) {
        return get_database.insert(NameVi,NameEn);
    }

    @Override
    public long update(long id, String NameVi, String NameEn) {
        return get_database.update(id,NameVi,NameEn);
    }

    @Override
    public long delete(long id) {
        return get_database.delete(id);
    }
}
