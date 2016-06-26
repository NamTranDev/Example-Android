package com.example.namtran.actionmode.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.namtran.actionmode.Country;

/**
 * Created by Nam Tran on 6/20/2015.
 */
public class BaseDao {
    protected Tao_Database DATA;
    protected Context context;
    public Cursor LoadData(String Table,String[] columns)
    {
        return DATA.getWritableDatabase().query(Table,columns,null,null,null,null,null);
    }
    public void setContext(Context context)
    {
        DATA = new Tao_Database(context);
        this.context = context;
    }
    public long insert(String table,ContentValues values)
    {
        return DATA.getWritableDatabase().insert(table,null,values);
    }
    public long update(String table, ContentValues contentValues,String selection, String[] args)
    {
        return DATA.getWritableDatabase().update(table,contentValues,selection,args);
    }
    public long delete(String table,String selection, String[] args)
    {
        return DATA.getWritableDatabase().delete(table,selection,args);
    }
}
