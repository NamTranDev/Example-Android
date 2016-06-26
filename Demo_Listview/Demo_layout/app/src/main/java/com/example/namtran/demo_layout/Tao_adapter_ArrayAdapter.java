package com.example.namtran.demo_layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nam Tran on 5/20/2015.
 */
public class Tao_adapter_ArrayAdapter extends ArrayAdapter<Lopstringarray> {
    Context mcontext;
    int layoutid;
    List<Lopstringarray> list;
    public Tao_adapter_ArrayAdapter(Context context, int resource, List<Lopstringarray> Danhsach) {
        super(context, resource, Danhsach);
        mcontext = context;
        layoutid = resource;
        list = Danhsach;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layoutid,null);

        TextView txttiengviet = (TextView) view.findViewById(R.id.txttiengviet);
        TextView txttienganh = (TextView) view.findViewById(R.id.txttienganh);
        ImageView imghinh = (ImageView) view.findViewById(R.id.imghinh);

        txttiengviet.setText(list.get(position).getViet());
        txttienganh.setText(list.get(position).getAnh());
        imghinh.setImageResource(list.get(position).getImage());

        return view;

    }


}
