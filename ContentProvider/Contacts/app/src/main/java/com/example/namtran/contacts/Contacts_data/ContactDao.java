package com.example.namtran.contacts.Contacts_data;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nam Tran on 7/6/2015.
 */
public class ContactDao {
    Context mContext;
    public ContactDao(Context context)
    {
        mContext = context;
    }
    public List<Mycontacts> get()
    {
        ContentResolver contentResolver = mContext.getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Data.CONTENT_URI,null,null,null
                , ContactsContract.Data.RAW_CONTACT_ID +" ASC");
        return fetchAll(cursor);
    }
    List<Mycontacts> fetchAll(Cursor cursor)
    {
        List<Mycontacts> mycontactses = new ArrayList<>();
        long row_id = 0;
        if (cursor != null)
        {
            Mycontacts mycontacts = null;
            if (cursor.moveToFirst())
            {
                do {
                    long id = cursor.getLong(cursor.getColumnIndex(ContactsContract.Data.RAW_CONTACT_ID));
                    if (row_id != id)
                    {
                        mycontacts = new Mycontacts();
                        mycontactses.add(mycontacts);
                        row_id = id;
                    }
                    String mime_type = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.MIMETYPE));
                    switch (mime_type)
                    {
                        case ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE :
                            mycontacts.setName(cursor.getString(cursor.getColumnIndex(ContactsContract.
                                    CommonDataKinds.StructuredName.DISPLAY_NAME)));
                            break;
                        case ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE :
                            int typePhone = cursor.getInt(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
                            String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                            if (typePhone == ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
                            {
                                mycontacts.setPhone(phone);
                            }
                            else
                                mycontacts.setPhone("null");
                            break;
                        case ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE :
                            mycontacts.setEmail(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.
                            Email.ADDRESS)));
                            break;
                        case ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE :
                            int typeaddress = cursor.getInt(cursor.getColumnIndex(ContactsContract.CommonDataKinds.
                                    StructuredPostal.TYPE));
                            String address = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.
                                    StructuredPostal.FORMATTED_ADDRESS));
                            if (typeaddress == ContactsContract.CommonDataKinds.StructuredPostal.TYPE_HOME)
                        {
                            mycontacts.setAddress(address);
                        }
                            else
                            mycontacts.setAddress("null");
                            break;
                    }
                }while (cursor.moveToNext());
            }
        }
        cursor.close();
        return mycontactses;
    }
    long insert(String name)
    {

        Intent insertIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
        insertIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        insertIntent.putExtra(ContactsContract.Intents.Insert.NAME,name);

        ArrayList<ContentValues> contentValueses = new ArrayList<ContentValues>();

        ContentValues rawContactRow = new ContentValues();


    }
}
