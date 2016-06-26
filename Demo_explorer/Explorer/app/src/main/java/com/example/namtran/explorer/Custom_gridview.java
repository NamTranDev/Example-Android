package com.example.namtran.explorer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nam Tran on 5/30/2015.
 */
public class Custom_gridview extends BaseAdapter {
    Context mContext;
    int layoutid;
    ArrayList<String> list;

    public Custom_gridview(Context context,int layout, ArrayList<String> listarray) {
        mContext = context;
        layoutid = layout;
        list = listarray;
    }

    @Override
    public int getCount() {
        return 0;
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        GetView getViews = null;
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutid,null);
            getViews = new GetView(convertView);
            convertView.setTag(getViews);
        }
        else
            getViews = (GetView) convertView.getTag();
        getViews.txttenfile.setText(list.get(position));
        getViews.imgfolder.setImageDrawable(mContext.getResources().getDrawable(R.drawable.folder));
        return convertView;
    }
    class GetView
    {
        TextView txttenfile;
        ImageView imgfolder;
        GetView(View rootView)
        {
            txttenfile = (TextView) rootView.findViewById(R.id.txttenfile);
            imgfolder = (ImageView) rootView.findViewById(R.id.imgfolder);
        }
    }
}
