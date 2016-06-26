package com.example.namtran.sqlite_internal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends Activity implements View.OnClickListener,AdapterView.OnItemClickListener{
    ListView listView;
    Button btninsert;
    Iprovider iprovider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        btninsert = (Button) findViewById(R.id.btninsert);
        Iprovider iprovider = new Provider(this);
        Custom_adapter_listView adapter = new Custom_adapter_listView(this,R.layout.layout_adapter_item,iprovider.get());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        btninsert.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btninsert)
        {
            Intent intent = new Intent(this,Insert_Activity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(this,Update_Delete_Activity.class);
            iprovider = new Provider(this);
            Bundle bundle = new Bundle();
            bundle.putInt(Country._ID,iprovider.get().get(i).get_id());
            bundle.putString(Country.NAME_VI,iprovider.get().get(i).getNameVi());
            bundle.putString(Country.NAME_EN,iprovider.get().get(i).getNameEn());
            intent.putExtras(bundle);
            startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        iprovider = new Provider(this);
        Custom_adapter_listView adapter = new Custom_adapter_listView(this,R.layout.layout_adapter_item,iprovider.get());
        listView.setAdapter(adapter);
    }


}
