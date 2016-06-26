package com.example.namtran.api_service.GetDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.namtran.api_service.Class.Email;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 8/10/2015.
 */
public class Getdatabase extends BaseDao {
    public Getdatabase(Context context) {
        super.setConText(context);
    }

    public void Getdatabase(Context context) {
        super.setConText(context);
    }
    public List<Email> get()
    {
        Cursor cursor = loadAll(Email.TABLE,null);
        return take_email(cursor);
    }
    List<Email> take_email(Cursor cursor)
    {
        List<Email> emails = new ArrayList<>();
        if (cursor.moveToFirst())
        {
            do {
                emails.add(email(cursor));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return emails;
    }

    Email email(Cursor cursor)
    {
        Email email = new Email();
        email.setId(cursor.getInt(cursor.getColumnIndex(Email.ID)));
        email.setTitle(cursor.getString(cursor.getColumnIndex(Email.TITLE)));
        email.setDescription(cursor.getString(cursor.getColumnIndex(Email.DESCRIPTION)));
        email.setDate(cursor.getString(cursor.getColumnIndex(Email.DATE)));
        return email;
    }
    public long insert(int id,String title,String decription, String date)
    {
        ContentValues values = new ContentValues();
        values.put(Email.ID,id);
        values.put(Email.TITLE,title);
        values.put(Email.DESCRIPTION,decription);
        values.put(Email.DATE,date);
        return insert(Email.TABLE,values);
    }
}

