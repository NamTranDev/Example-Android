package com.example.namtran.demo_layout;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class Listview extends Activity {
    ListView listView;
    List<Lopstringarray> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        Data();
        listView = (ListView) findViewById(R.id.list_view);
        Tao_adapter_BaseAdapter adapter = new Tao_adapter_BaseAdapter(this,R.layout.layout_adapter,data);
        listView.setAdapter(adapter);
    }
    void Data()
    {
        String[] arrayviet = getResources().getStringArray(R.array.tiengviet);
        String[] arrayanh = getResources().getStringArray(R.array.Tienganh);
        int[] hinh = {R.drawable.vietnam,R.drawable.japan,R.drawable.korea};
        data = new ArrayList<>();
        for (int i=0 ; i<arrayanh.length;i++)
        {
            Lopstringarray lopstringarray = new Lopstringarray(arrayviet[i],arrayanh[i],hinh[i]);
            data.add(lopstringarray);
        }
    }
}
