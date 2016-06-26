package com.example.namtran.actionmode.Database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.namtran.actionmode.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 6/19/2015.
 */
public class Tao_Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Database";
    public static final int VERSION = 1;
    /*List<String> list;*/
    /*void Tao_dulieu()
    {
        list = new ArrayList<String>();
        list.add("CREATE TABLE " +  Country.TABLE_NAME
                + "( " + Country._ID + "INTEGER PRIMARY KEY, "
                + Country.NAME_VI + "TEXT, "
                + Country.NAME_EN + "TEXT )");
    }*/
    public Tao_Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Getlistdata getlistdata = new Getlistdata();
        List<String> list = getlistdata.getData();
        for (int i = 0;i<list.size();i++)
        {
            db.execSQL(list.get(i));
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase dbase, int oldversion, int newversion) {
        switch (newversion)
        {
            case 3 :{
                if (oldversion == 2)
                    break;
            }
            case 2:{
                Getlistdata getlistdata = new Getlistdata();
                List<String> list = getlistdata.getData();
                for (int i = 0;i<list.size();i++)
                {
                    dbase.execSQL(list.get(i));
                }
            }
            default:
                break;
        }
    }
}
