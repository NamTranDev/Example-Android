package com.example.namtran.baitap;

import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Gallery;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_activity);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        InitData();
        Mypageradapter mypageradapter = new Mypageradapter(getFragmentManager(),listImage);
        viewPager.setAdapter(mypageradapter);
    }

    String root = Environment.getExternalStorageDirectory().toString() + "/Download/";
    String[] listImage;

    void InitData()
    {
        File file = new File(root);
        String[] listimages = file.list(new ExtensionsNameFilter(ExtensionsNameFilter.IMAGE_FILTER));
        for (int i=0;i<listimages.length;i++)
        {
            listimages[i] = root + listimages[i];
            Log.d("NamTran",listimages[i]);
        }
    }
}
