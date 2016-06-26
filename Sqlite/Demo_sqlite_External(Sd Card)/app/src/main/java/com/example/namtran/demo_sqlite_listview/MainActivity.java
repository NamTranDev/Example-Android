package com.example.namtran.demo_sqlite_listview;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends Activity implements View.OnClickListener,AdapterView.OnItemClickListener{
    ListView listView;
    Button btninsert,btnupdate,btndelete;
    Custom_adapter_listview adapter;
    Iprovider iprovider;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        btninsert = (Button) findViewById(R.id.btninsert);
        btnupdate = (Button) findViewById(R.id.btnupdate);
        btndelete = (Button) findViewById(R.id.btndelete);
        String path = Environment.getExternalStorageDirectory() + "/Download/Mcountry";
        iprovider = new Provider(this,path);
        adapter = new Custom_adapter_listview(this,R.layout.layout_listview_item,iprovider.get());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        btninsert.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btninsert)
        {
            Intent intent = new Intent(this,Insert_Sdcard.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, Update_Delete_Sdcard.class);
        Bundle bundle= new Bundle();
        bundle.putInt(Country._ID, iprovider.get().get(i).get_id());
        bundle.putString(Country.NAMEVI, iprovider.get().get(i).getNameVi());
        bundle.putString(Country.NAMEEN, iprovider.get().get(i).getNameEn());
        intent.putExtras(bundle);
        startActivity(intent);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        String path = Environment.getExternalStorageDirectory() + "/Download/Mcountry";
        Iprovider iprovider = new Provider(this,path);
        Custom_adapter_listview adapter = new Custom_adapter_listview(this,R.layout.layout_listview_item,iprovider.get());
        listView.setAdapter(adapter);
    }
}
