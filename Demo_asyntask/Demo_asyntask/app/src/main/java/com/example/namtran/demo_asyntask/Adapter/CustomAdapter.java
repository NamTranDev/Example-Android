package com.example.namtran.demo_asyntask.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.namtran.demo_asyntask.Country;
import com.example.namtran.demo_asyntask.R;

import java.util.List;

/**
 * Created by Nam Tran on 7/2/2015.
 */
public class CustomAdapter extends ArrayAdapter<Country> {
    Context mContext;
    int layoutid;
    List<Country> countries;
    public CustomAdapter(Context context, int resource, List<Country> objects) {
        super(context, resource, objects);
        mContext = context;
        layoutid = resource;
        countries = objects;
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
        }
        else
            getview = (Getview) convertView.getTag();

        getview.txtnamevi.setText(countries.get(position).getNameVi());
        getview.txtnameen.setText(countries.get(position).getNameEn());
        getview.imgimage.setImageResource(countries.get(position).getImage());
        return convertView;
    }

    class Getview
    {
        TextView txtnamevi;
        TextView txtnameen;
        ImageView imgimage;
        Getview(View rootView)
        {
            txtnamevi = (TextView) rootView.findViewById(R.id.txtnamevi);
            txtnameen = (TextView) rootView.findViewById(R.id.txtnameen);
            imgimage = (ImageView) rootView.findViewById(R.id.imgimage);
        }
    }
}
