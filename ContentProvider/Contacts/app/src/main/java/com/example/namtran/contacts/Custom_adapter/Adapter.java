package com.example.namtran.contacts.Custom_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.namtran.contacts.Contacts_data.Mycontacts;
import com.example.namtran.contacts.R;

import java.util.List;

/**
 * Created by Nam Tran on 7/7/2015.
 */
public class Adapter extends ArrayAdapter<Mycontacts> {
    Context mContext;
    int layoutid;
    List<Mycontacts> mycontactses;
    public Adapter(Context context, int textViewResourceId, List<Mycontacts> objects) {
        super(context, textViewResourceId, objects);
        mContext = context;
        layoutid = textViewResourceId;
        mycontactses = objects;
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
        getView.txtname.setText(mycontactses.get(position).getName());
        getView.txtphone.setText(mycontactses.get(position).getPhone());
        getView.txtemail.setText(mycontactses.get(position).getEmail());
        getView.txtaddress.setText(mycontactses.get(position).getAddress());
        return convertView;
    }
    class GetView
    {
        TextView txtname;
        TextView txtphone;
        TextView txtemail;
        TextView txtaddress;
        GetView(View rootView)
        {
            txtname = (TextView) rootView.findViewById(R.id.txtname);
            txtphone = (TextView) rootView.findViewById(R.id.txtphone);
            txtemail = (TextView) rootView.findViewById(R.id.txtemail);
            txtaddress = (TextView) rootView.findViewById(R.id.txtaddress);
        }
    }
}
