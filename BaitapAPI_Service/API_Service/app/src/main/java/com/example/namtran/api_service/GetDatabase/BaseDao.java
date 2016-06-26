package com.example.namtran.api_service.GetDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.namtran.api_service.DataBase.DBContext;

/**
 * Created by Nam Tran on 8/10/2015.
 */
public class BaseDao {
    protected DBContext dbContext;
    protected Context context;

    public Cursor loadAll(String Table,String[] columb)
    {
        return dbContext.getReadableDatabase().query(Table,columb,null,null,null,null,null);
    }
    public void setConText(Context context)
    {
        dbContext = new DBContext(context);
        this.context = context;
    }
    public long insert(String table, ContentValues contentValues) {

        return dbContext.getWritableDatabase().insert(table, null, contentValues);
    }
}
