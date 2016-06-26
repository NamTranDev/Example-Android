package com.example.namtran.demo_layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Nam Tran on 5/21/2015.
 */
public class Custom_adapter_spinner extends ArrayAdapter<Lopstringarray>{
    Context mContext;
    int layoutid;
    List<Lopstringarray> list;
    public Custom_adapter_spinner(Context context, int resource, List<Lopstringarray> objects) {
        super(context, resource, objects);
        mContext = context;
        layoutid = resource;
        list = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustom(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustom(position, convertView, parent);
    }
    public View getCustom(int position,View convertView,ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layoutid,parent,false);

        TextView txttiengviet = (TextView) view.findViewById(R.id.txttiengviet);
        TextView txttienganh = (TextView) view.findViewById(R.id.txttienganh);
        ImageView imghinh = (ImageView) view.findViewById(R.id.imghinh);

        txttiengviet.setText(list.get(position).getViet());
        txttienganh.setText(list.get(position).getAnh());
        imghinh.setImageResource(list.get(position).getImage());

        return view;
    }
}
