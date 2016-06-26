package com.example.namtran.api_service.Provider;

import android.content.Context;

import com.example.namtran.api_service.Class.Email;
import com.example.namtran.api_service.GetDatabase.Getdatabase;

import java.util.List;

/**
 * Created by Nam Tran on 8/10/2015.
 */
public class Provider implements Iprovider {
    Getdatabase getdatabase;

    public Provider(Context context)
    {
        getdatabase = new Getdatabase(context);
    }

    @Override
    public List<Email> get() {
        return getdatabase.get();
    }

    @Override
    public long insert(int id, String title, String decription, String date) {
        return getdatabase.insert(id,title,decription,date);
    }
}
