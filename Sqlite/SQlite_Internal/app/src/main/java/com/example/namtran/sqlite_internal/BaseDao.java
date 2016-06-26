package com.example.namtran.sqlite_internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by Nam Tran on 6/9/2015.
 */
public class BaseDao {
    protected Database db;
    protected Context context;
    public Cursor load_database (String table , String[] column)
    {
        return db.getReadableDatabase().query(table,column,null,null,null,null,null);
    }
    public void setContext(Context context)
    {
        db = new Database(context);
        this.context = context;
    }
    public long insert(String table,ContentValues contentValues)
    {
        return db.getWritableDatabase().insert(table,null,contentValues);
    }
    public long update(String table,ContentValues contentValues,String selection,String[] args)
    {
        return db.getWritableDatabase().update(table,contentValues,selection,args);
    }
    public long delete(String table,String whereClause , String[] args)
    {
        return db.getWritableDatabase().delete(table,whereClause,args);
    }
}
