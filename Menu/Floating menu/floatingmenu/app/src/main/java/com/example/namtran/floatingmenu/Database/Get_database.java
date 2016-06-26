package com.example.namtran.floatingmenu.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 6/16/2015.
 */
public class Get_database {
    SQLiteDatabase database;

    public Get_database(Context context, String path)
    {
        database = context.openOrCreateDatabase(path,Context.MODE_PRIVATE,null);
    }

    public List<Country> get()
    {
        Cursor cursor = database.query(Country.TABLE_NAME,null,null,null,null,null,null);
        return take_all_data(cursor);
    }

    List<Country> take_all_data(Cursor cursor)
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
    public long insert (String NameVi,String NameEn)
    {
        ContentValues values = new ContentValues();
        values.put(Country.NAME_VI,NameVi);
        values.put(Country.NAME_EN,NameEn);
        return database.insert(Country.TABLE_NAME,null,values);
    }
    public long update(long id,String NameVi,String NameEn )
    {
        ContentValues values = new ContentValues();
        values.put(Country.NAME_VI,NameVi);
        values.put(Country.NAME_EN,NameEn);
        return database.update(Country.TABLE_NAME,values,Country._ID + "=?" ,new String[]{id + ""});
    }
    public long delete(long id)
    {
        return database.delete(Country.TABLE_NAME,Country._ID +"=?",new String[]{id + ""});
    }
    Country take_data(Cursor cursor)
    {
        Country country = new Country();
        country.set_id(cursor.getInt(cursor.getColumnIndex(Country._ID)));
        country.setNameVi(cursor.getString(cursor.getColumnIndex(Country.NAME_VI)));
        country.setNameEn(cursor.getString(cursor.getColumnIndex(Country.NAME_EN)));
        return country;
    }
    private ContentValues getValue (Country country)
    {
        ContentValues values = new ContentValues();
        values.put(Country._ID,country.get_id());
        values.put(Country.NAME_VI,country.getNameVi());
        values.put(Country.NAME_EN,country.getNameEn());
        return values;
    }
}
