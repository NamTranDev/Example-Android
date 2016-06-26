package com.example.namtran.demo_sqlite_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nam Tran on 6/6/2015.
 */
public class Custom_adapter_listview extends ArrayAdapter<Country> {
    Context mContext;
    int layoutid;
    List<Country> data;
    public Custom_adapter_listview(Context context, int layout, List<Country> objects) {
        super(context, layout, objects);
        mContext = context;
        layoutid = layout;
        data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Getview getview;
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutid,null);

            getview = new Getview(convertView);
            convertView.setTag(getview);
            convertView.getTag();
        }
        else
            getview = (Getview) convertView.getTag();
            getview.txtnameVi.setText(data.get(position).getNameVi());
            getview.txtnameEn.setText(data.get(position).getNameEn());
        return convertView;
    }
    class Getview
    {
        TextView txtnameVi;
        TextView txtnameEn;
        Getview(View view)
        {
            txtnameVi = (TextView) view.findViewById(R.id.txtnamevi);
            txtnameEn = (TextView) view.findViewById(R.id.txtnameen);
        }
    }
}
