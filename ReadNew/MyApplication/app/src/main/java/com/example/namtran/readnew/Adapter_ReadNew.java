package com.example.namtran.readnew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 7/22/2015.
 */
public class Adapter_ReadNew extends ArrayAdapter<News> {
    Context mContext;
    int layoutid;
    List<News> newsList;
    public Adapter_ReadNew(Context context,  int textViewResourceId, List<News> objects) {
        super(context, textViewResourceId, objects);
        mContext = context;
        layoutid = textViewResourceId;
        newsList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GetView getView;
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutid,null);

            getView = new GetView(convertView);
            convertView.setTag(getView);
        }
        else
            getView = (GetView) convertView.getTag();

        getView.txttitle.setText(newsList.get(position).getTitle());
        getView.txtpubdate.setText(newsList.get(position).getPubdate());
        getView.txtlink.setText(newsList.get(position).getLink());
        return convertView;
    }
    class GetView
    {
        TextView txttitle;
        TextView txtpubdate;
        TextView txtlink;
        GetView(View rootView)
        {
            txttitle = (TextView) rootView.findViewById(R.id.txttitle);
            txtpubdate = (TextView) rootView.findViewById(R.id.txtpubdate);
            txtlink = (TextView) rootView.findViewById(R.id.txtlink);
            txtlink.setVisibility(View.GONE);
        }
    }
}
