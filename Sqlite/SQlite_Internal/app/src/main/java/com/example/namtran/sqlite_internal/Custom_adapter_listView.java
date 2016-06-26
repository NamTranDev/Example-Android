package com.example.namtran.sqlite_internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Nam Tran on 6/9/2015.
 */
public class Custom_adapter_listView extends ArrayAdapter<Country> {
    Context mContext;
    int layoutid;
    List<Country> list;
    public Custom_adapter_listView(Context context, int textViewResourceId, List<Country> objects) {
        super(context, textViewResourceId, objects);
        mContext = context;
        layoutid = textViewResourceId;
        list = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GetId getId;
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutid,null);
            getId = new GetId(convertView);
            convertView.setTag(getId);
        }
        else
            getId = (GetId) convertView.getTag();
        getId.txtnamevi.setText(list.get(position).getNameVi());
        getId.txtnameen.setText(list.get(position).getNameEn());
        return convertView;
    }
    class GetId
    {
        TextView txtnamevi;
        TextView txtnameen;
        GetId(View view)
        {
            txtnamevi = (TextView) view.findViewById(R.id.txtnamevi);
            txtnameen = (TextView) view.findViewById(R.id.txtnameen);
        }
    }
}
