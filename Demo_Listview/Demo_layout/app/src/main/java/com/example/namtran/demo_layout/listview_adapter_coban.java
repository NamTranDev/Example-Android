package com.example.namtran.demo_layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 5/20/2015.
 */
public class listview_adapter_coban extends ArrayAdapter<String> {
    Context mcontext;
    int layoutid;
    String[] text;

    public listview_adapter_coban(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        mcontext = context;
        layoutid = resource;
        text = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layoutid,null);

        TextView txttext = (TextView) view.findViewById(R.id.txttext);

        txttext.setText(text[position]);
        return view;
    }
}
