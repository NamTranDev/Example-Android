package com.example.namtran.demo_sqlite_listview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 6/6/2015.
 */
public class getData_SQLite {
    SQLiteDatabase database;
    getData_SQLite(Context context,String path){
        database = context.openOrCreateDatabase(path,Context.MODE_PRIVATE,null);
    }
    public List<Country> get()
    {
        Cursor cursor = database.query(Country.TABLE,null,null,null,null,null,null);
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
        country.setNameVi(cursor.getString(cursor.getColumnIndex(Country.NAMEVI)));
        country.setNameEn(cursor.getString(cursor.getColumnIndex(Country.NAMEEN)));
        return country;
    }
    public long insert (String NameVi, String NameEn)
    {
        ContentValues values = new ContentValues();
        values.put(Country.NAMEVI,NameVi);
        values.put(Country.NAMEEN,NameEn);
        return database.insert(Country.TABLE,null,values);
    }
    public int update (long id,String nameVI,String nameEn)
        {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Country.NAMEVI,nameVI);
        contentValues.put(Country.NAMEEN,nameEn);
        return database.update(Country.TABLE,contentValues,Country._ID +"=?",new String[]{id+ ""});
    }
    public int delete(long id)
    {
        return database.delete(Country.TABLE,Country._ID + "=?",new String[]{id +""});
    }
    private ContentValues getContentValues(Country country)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Country._ID, country.get_id());
        contentValues.put(Country.NAMEEN, country.getNameEn());
        contentValues.put(Country.NAMEVI, country.getNameVi());
        return contentValues;
    }
}
