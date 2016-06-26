package com.example.namtran.baitap;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nam Tran on 8/17/2015.
 */
public class fragment extends Fragment {
    public static final String KEY_IMAGE = "image";
    public static final String KEY_NAME = "name";

    String path;
    String name;
    TextView txttext;
    ImageView image;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment,null);
        txttext = (TextView) view.findViewById(R.id.txttext);
        image = (ImageView) view.findViewById(R.id.image);
        txttext.setText(name.toString());
        Bitmap bitmap = BitmapFactory.decodeFile(path.toString());
        image.setImageBitmap(bitmap);
        return view;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();

        name = bundle.getString(KEY_NAME);

        path = bundle.getString(KEY_IMAGE);



    }
}
