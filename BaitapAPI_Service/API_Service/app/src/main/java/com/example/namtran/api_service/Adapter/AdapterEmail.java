package com.example.namtran.api_service.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.namtran.api_service.Class.Email;
import com.example.namtran.api_service.R;

import java.util.List;

/**
 * Created by Nam Tran on 8/10/2015.
 */
public class AdapterEmail extends ArrayAdapter<Email> {
    Context mContext;
    int layout;
    List<Email> emails;
    public AdapterEmail(Context context, int resource, List<Email> objects) {
        super(context, resource, objects);
        mContext = context;
        layout = resource;
        emails = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GetView getView;
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);

            getView = new GetView(convertView);
            convertView.setTag(getView);
        }
        else {
            getView = (GetView) convertView.getTag();
        }

        getView.title.setText(emails.get(position).getTitle());
        getView.decription.setText(emails.get(position).getDescription());
        getView.date.setText(emails.get(position).getDate());
        return convertView;
    }
    private class GetView
    {
        TextView title;
        TextView decription;
        TextView date;
        GetView(View rootView)
        {
            title = (TextView) rootView.findViewById(R.id.title);
            decription = (TextView) rootView.findViewById(R.id.decription);
            date = (TextView) rootView.findViewById(R.id.date);
        }
    }
}
