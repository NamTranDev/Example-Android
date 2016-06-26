package com.example.namtran.sqlite_internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 6/9/2015.
 */
public class Get_database extends BaseDao
{
    public Get_database(Context context) {
        super.setContext(context);
    }
    public List<Country> get()
    {
        Cursor cursor = load_database(Country.TABLE_NAME,null);
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

    Country take_data(Cursor cursor)
    {
        Country country = new Country();
        country.set_id(cursor.getInt(cursor.getColumnIndex(Country._ID)));
        country.setNameVi(cursor.getString(cursor.getColumnIndex(Country.NAME_VI)));
        country.setNameEn(cursor.getString(cursor.getColumnIndex(Country.NAME_EN)));
        return country;
    }
    public long insert (String NameVi,String NameEn)
    {
        ContentValues values = new ContentValues();
        values.put(Country.NAME_VI,NameVi);
        values.put(Country.NAME_EN,NameEn);
        return insert(Country.TABLE_NAME,values);
    }
    public long update(long id,String NameVi, String NameEn)
    {
        ContentValues values = new ContentValues();
        values.put(Country.NAME_VI,NameVi);
        values.put(Country.NAME_EN,NameEn);
        return update(Country.TABLE_NAME,values,Country._ID + "=?",new String[]{id+""});
    }
    public long delete(long id)
    {
        return delete(Country.TABLE_NAME,Country._ID + "=?",new String[]{id +""});
    }
    public ContentValues getContentValues(Country country)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Country._ID,country.get_id());
        contentValues.put(Country.NAME_VI,country.getNameVi());
        contentValues.put(Country.NAME_EN,country.getNameEn());
        return contentValues;
    }

}
