package com.example.namtran.contacts;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.namtran.contacts.Contacts_data.Mycontacts;
import com.example.namtran.contacts.Custom_adapter.Adapter;

import java.util.List;


public class MainActivity extends Activity {
    ListView listView;
    Iprovider iprovider;
    Adapter adapter;
    List<Mycontacts> mycontactses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        iprovider = new Provider(this);
        mycontactses = iprovider.get();
        adapter = new Adapter(this,R.layout.layout_item_adapter_contact,mycontactses);
        listView.setAdapter(adapter);
    }


    //<editor-fold desc="Menu">
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //</editor-fold>
}
