package com.example.namtran.floatingmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.namtran.floatingmenu.Database.Country;

import java.util.List;

/**
 * Created by Nam Tran on 6/16/2015.
 */
public class Custom_Adapter extends ArrayAdapter<Country> {
    Context mContext;
    int layoutid;
    List<Country> list;
    public Custom_Adapter(Context context, int textViewResourceId, List<Country> objects) {
        super(context, textViewResourceId, objects);
        mContext = context;
        layoutid = textViewResourceId;
        list = objects;
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
        getView.txtnamevi.setText(list.get(position).getNameVi());
        getView.txtnameen.setText(list.get(position).getNameEn());

        return convertView;
    }
    class GetView
    {
        TextView txtnamevi;
        TextView txtnameen;
        GetView( View view)
        {
            txtnamevi = (TextView) view.findViewById(R.id.txtnamevi);
            txtnameen = (TextView) view.findViewById(R.id.txtnameen);
        }

    }
}
