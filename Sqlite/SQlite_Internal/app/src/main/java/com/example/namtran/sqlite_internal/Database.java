package com.example.namtran.sqlite_internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by Nam Tran on 6/8/2015.
 */
public class Database extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "Database";
    public final static int VERSION = 1;
    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Class_dulieu_database Dulieu_database = new Class_dulieu_database();
        List<String> List_Database = Dulieu_database.getSQLITE_qry();
        for (int i = 0 ; i<List_Database.size();i++)
            sqLiteDatabase.execSQL(List_Database.get(i));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion)
    {
        switch (newversion)
        {
            case 3 :
            {
                if (oldversion == 2)
                    break;
            }
            case 2 :
                Class_dulieu_database Dulieu_database = new Class_dulieu_database();
                List<String> List_Database = Dulieu_database.getSQLITE_qry();
                for (int i = 0 ; i<List_Database.size();i++)
                    sqLiteDatabase.execSQL(List_Database.get(i));
            default:
                break;
        }

    }
}
