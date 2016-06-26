package com.example.namtran.demo_layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class Listview_gridview_spinner extends Activity {
    ListView listView;
    List<Lopstringarray> data;
    GridView gridView;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_gridview_spinner);
        Data();
        listView = (ListView) findViewById(R.id.list_view);
       // gridView = (GridView) findViewById(R.id.gridView);
        //spinner = (Spinner) findViewById(R.id.spinner);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        Tao_adapter_BaseAdapter adapter = new Tao_adapter_BaseAdapter(this,R.layout.layout_adapter,data);
        //listView.setAdapter(adapter);
        gridView.setAdapter(adapter);
        spinner.setAdapter(adapter);
        //autoCompleteTextView.setAdapter(adapter);
        //multiAutoCompleteTextView.setAdapter(adapter);
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
