package com.example.namtran.actionmode.Adapter;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.example.namtran.actionmode.Country;
import com.example.namtran.actionmode.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 6/20/2015.
 */
public class Setadapter extends ArrayAdapter<Country> {
    Context mContext;
    int layoutid;
    List<Country> list_moi;
    List<Country> list_cu;
    private SparseBooleanArray mSelectedItemsIds;
    public Setadapter(Context context,  int textViewResourceId, List<Country> objects) {
        super(context, textViewResourceId, objects);
        mSelectedItemsIds = new SparseBooleanArray();
        mContext = context;
        layoutid = textViewResourceId;
        list_moi = objects;
        list_cu = new ArrayList<>(objects);
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                String text = charSequence.toString().toUpperCase();
                List<Country> countries = new ArrayList<>();
                for (Country country :list_cu)
                {
                 if (country.getNameEn().toUpperCase().contains(text))
                    countries.add(country);
                }
                filterResults.values = countries;
                filterResults.count = countries.size();
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                list_moi.clear();
                list_moi.addAll((List<Country>)filterResults.values);
                notifyDataSetChanged();
            }
        };
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
        getView.txtnamevi.setText(list_moi.get(position).getNameVi());
        getView.txtnameen.setText(list_moi.get(position).getNameEn());
        return convertView;
    }

    class GetView
    {
        TextView txtnamevi;
        TextView txtnameen;
        GetView(View view)
        {
            txtnamevi = (TextView) view.findViewById(R.id.txtnamevi);
            txtnameen = (TextView) view.findViewById(R.id.txtnameen);
        }
    }

    @Override
    public void remove(Country object) {
        list_moi.remove(object);
        notifyDataSetChanged();
    }
    public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }
    public SparseBooleanArray getSelectedIds() {
        return mSelectedItemsIds;
    }
}
