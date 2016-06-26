package com.example.namtran.api_service;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.namtran.api_service.Adapter.AdapterEmail;
import com.example.namtran.api_service.Class.Email;
import com.example.namtran.api_service.Provider.Iprovider;
import com.example.namtran.api_service.Provider.Provider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 8/10/2015.
 */
public class ActivityEmail extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        listView = (ListView) findViewById(R.id.listView);
        Iprovider iprovider = new Provider(this);
        List<Email> emails = new ArrayList<Email>();
        emails = iprovider.get();
        AdapterEmail adapterEmail = new AdapterEmail(this,R.layout.layout_item_email,emails);
        listView.setAdapter(adapterEmail);
    }
}
