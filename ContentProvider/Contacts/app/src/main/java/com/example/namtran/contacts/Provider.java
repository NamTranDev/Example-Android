package com.example.namtran.contacts;

import android.content.Context;
import android.widget.ProgressBar;

import com.example.namtran.contacts.Contacts_data.ContactDao;
import com.example.namtran.contacts.Contacts_data.Mycontacts;

import java.util.List;

/**
 * Created by Nam Tran on 7/6/2015.
 */
public class Provider implements Iprovider {
    ContactDao dao;
    public Provider(Context context)
    {
        dao = new ContactDao(context);
    }
    @Override
    public List<Mycontacts> get() {
        return dao.get();
    }
}
