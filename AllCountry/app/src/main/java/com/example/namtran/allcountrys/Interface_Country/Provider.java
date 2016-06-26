package com.example.namtran.allcountrys.Interface_Country;

import android.content.Context;

import com.example.namtran.allcountrys.Database.Country;
import com.example.namtran.allcountrys.Database.Get_Database;


import java.util.List;

/**
 * Created by Nam Tran on 7/27/2015.
 */
public class Provider implements Iprovider {
    Get_Database getDatabase;
    public Provider(Context context,String path)
    {
        getDatabase = new Get_Database(context,path);
    }

    @Override
    public List<Country> get() {
        return getDatabase.get();
    }
}
