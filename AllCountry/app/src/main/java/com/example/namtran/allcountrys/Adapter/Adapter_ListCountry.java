package com.example.namtran.allcountrys.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.namtran.allcountrys.Database.Country;
import com.example.namtran.allcountrys.R;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by Nam Tran on 7/27/2015.
 */
public class Adapter_ListCountry extends ArrayAdapter<Country> {
    Context mContext;
    int mlayout;
    List<Country> countries_new;
    List<Country> countries_old;
    public Adapter_ListCountry(Context context, int resource, List<Country> objects) {
        super(context, resource, objects);
        mContext = context;
        mlayout = resource;
        countries_new = objects;
        countries_old = new ArrayList<>(objects);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                String text = charSequence.toString().toUpperCase();
                List<Country> countries = new ArrayList<>();
                for (Country country : countries_old)
                {
                    if (country.getNameVi().toUpperCase().contains(text))
                    {
                        countries.add(country);
                    }
                }
                filterResults.values = countries;
                filterResults.count = countries.size();
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                countries_new.clear();
                countries_new.addAll((List<Country>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

    @Override
     public View getView(int position, View convertView, ViewGroup parent) {
        Getview getview;
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mlayout,null);

            getview = new Getview(convertView);
            convertView.setTag(getview);
        }
        else
            getview = (Getview) convertView.getTag();


        getview.txtnameVi.setText(countries_new.get(position).getNameVi());
        getview.txtnameEn.setText(countries_new.get(position).getNameEn());
        Picasso.with(mContext).load(countries_new.get(position).getImage()).resize(250,250).centerCrop().into(getview.imgImage);
        return convertView;
    }

    class Getview
    {
        ImageView imgImage;
        TextView txtnameVi;
        TextView txtnameEn;
        Getview(View rootView)
        {
            imgImage = (ImageView) rootView.findViewById(R.id.imgImage);
            txtnameVi = (TextView) rootView.findViewById(R.id.txtnameVi);
            txtnameEn = (TextView) rootView.findViewById(R.id.txtnameEn);
        }
    }
}
