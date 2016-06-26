package com.example.namtran.xml_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dzumi on 16/05/2015.
 */
public class Adapter extends ArrayAdapter<Employee> {
    Context mContext;
    int mLayoutID;
    List<Employee> memployees;

    public Adapter(Context context, int layoutID, List<Employee> employees) {
        super(context, layoutID, employees);
        mContext = context;
        mLayoutID = layoutID;
        memployees = employees;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        //lan dau
        if (convertView == null) {
            //buoc 1: tu layoutID(R.layout.name) --> view
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(mLayoutID, null);

            //buoc 2: find view member trong view
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else //lan tiep theo
            viewHolder = (ViewHolder) convertView.getTag();

        //buoc 3: set info

        viewHolder.txtid.setText(String.valueOf(memployees.get(position).getId()));
        viewHolder.txtFname.setText(memployees.get(position).getFName());
        viewHolder.txtlname.setText(memployees.get(position).getLName());
        viewHolder.txtsex.setText(memployees.get(position).getSex());
        viewHolder.txtaddress.setText(memployees.get(position).getAddress());
        viewHolder.txtbdate.setText(memployees.get(position).getBDate());
        viewHolder.txtminit.setText(memployees.get(position).getMinit());
        viewHolder.txtssn.setText(memployees.get(position).getSsn());
        viewHolder.txtsuperssn.setText(memployees.get(position).getSuperSsn());
        viewHolder.txtdno.setText(String.valueOf(memployees.get(position).getDno()));
        viewHolder.txtsalary.setText(String.valueOf(memployees.get(position).getSalary()));


        return convertView;
    }

    class ViewHolder {
        //lop quan ly cac member view trong convertview
        TextView txtid;
        TextView txtFname;
        TextView txtlname;
        TextView txtminit;
        TextView txtssn;
        TextView txtsuperssn;
        TextView txtsex;
        TextView txtbdate;
        TextView txtaddress;
        TextView txtsalary;
        TextView txtdno;
        ViewHolder(View rootView) {
            txtid = (TextView) rootView.findViewById(R.id.txtid);
            txtFname = (TextView) rootView.findViewById(R.id.txtFname);
            txtlname = (TextView) rootView.findViewById(R.id.txtlname);
            txtminit = (TextView) rootView.findViewById(R.id.txtminit);
            txtssn = (TextView) rootView.findViewById(R.id.txtssn);
            txtsuperssn = (TextView) rootView.findViewById(R.id.txtsuperssn);
            txtbdate = (TextView) rootView.findViewById(R.id.txtbdate);
            txtaddress = (TextView) rootView.findViewById(R.id.txtaddress);
            txtsex = (TextView) rootView.findViewById(R.id.txtsex);
            txtsalary = (TextView) rootView.findViewById(R.id.txtsalary);
            txtdno = (TextView) rootView.findViewById(R.id.txtdno);
        }
    }
}
