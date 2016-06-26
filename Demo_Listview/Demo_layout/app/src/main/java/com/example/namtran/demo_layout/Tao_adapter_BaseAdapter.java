package com.example.namtran.demo_layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nam Tran on 5/19/2015.
 */
public class Tao_adapter_BaseAdapter extends BaseAdapter {
    Context mcontext;
    int layoutid;
    List<Lopstringarray> list;
    public Tao_adapter_BaseAdapter(Context context , int layout , List<Lopstringarray> List)
    {
        mcontext = context;
        layoutid = layout;
        list = List;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup)
    {
        View view = null;
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layoutid, null);

        TextView txttiengviet = (TextView) view.findViewById(R.id.txttiengviet);
        TextView txttienganh = (TextView) view.findViewById(R.id.txttienganh);
        ImageView imghinh = (ImageView) view.findViewById(R.id.imghinh);

        txttiengviet.setText(list.get(position).getViet());
        txttienganh.setText(list.get(position).getAnh());
        imghinh.setImageResource(list.get(position).getImage());

        return view ;
    }
}
