package com.example.namtran.allcountrys.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 7/27/2015.
 */
public class Get_Database {
    SQLiteDatabase database;
    public Get_Database(Context context, String path)
    {
        database = context.openOrCreateDatabase(path, Context.MODE_PRIVATE,null);
    }

    public List<Country> get()
    {
        Cursor cursor = database.query(Country.TABLE,null,null,null,null,null,null);
        return takeall_data(cursor);
    }

    List<Country> takeall_data(Cursor cursor)
    {
        List<Country> countries = new ArrayList<>();
        if (cursor.moveToFirst())
        {
            do {
                countries.add(take_data(cursor));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return countries;
    }
    Country take_data(Cursor cursor)
    {
        Country country = new Country();
        country.setId(cursor.getInt(cursor.getColumnIndex(Country.ID)));
        country.setNameVi(cursor.getString(cursor.getColumnIndex(Country.NAME_VI)));
        country.setNameEn(cursor.getString(cursor.getColumnIndex(Country.NAME_EN)));
        country.setImage(cursor.getString(cursor.getColumnIndex(Country.IMAGE)));
        country.setLanguage(cursor.getString(cursor.getColumnIndex(Country.LANGUAGE)));
        country.setCaption(cursor.getString(cursor.getColumnIndex(Country.CAPTION)));
        country.setPopulation(cursor.getLong(cursor.getColumnIndex(Country.POPULATION)));
        country.setAcreage(cursor.getDouble(cursor.getColumnIndex(Country.ACREAGE)));
        return country;
    }
}
