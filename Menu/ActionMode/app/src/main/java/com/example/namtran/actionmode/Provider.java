package com.example.namtran.actionmode;

import android.content.Context;

import com.example.namtran.actionmode.Database.Get_database;
import com.example.namtran.actionmode.Interface.Iprovider;

import java.util.List;

/**
 * Created by Nam Tran on 6/20/2015.
 */
public class Provider implements Iprovider {
    Get_database getDatabase;

    public Provider(Context context) {
         getDatabase = new Get_database(context);
    }

    @Override
    public List<Country> get() {
        return getDatabase.get();
    }

    @Override
    public long insert( String NameVi,String NameEn) {
        return getDatabase.insert( NameVi,NameEn);
    }

    @Override
    public long update(long id, String NameVi, String NameEn) {
        return getDatabase.update(id,NameVi,NameEn);
    }

    @Override
    public long delete(long id) {
        return getDatabase.delete(id);
    }
}
