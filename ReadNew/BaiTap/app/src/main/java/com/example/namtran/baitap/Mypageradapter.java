package com.example.namtran.baitap;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;

import java.io.File;

/**
 * Created by Nam Tran on 8/17/2015.
 */
public class Mypageradapter extends FragmentStatePagerAdapter {

    String[] listIMage;

    public Mypageradapter(FragmentManager fm,String[] list) {
        super(fm);
        listIMage = list;
    }


    @Override
    public Fragment getItem(int i) {
        fragment fragment1 = new fragment();
        Bundle bundle = new Bundle();
        File file = new File(listIMage[i]);
        bundle.putString("path",file.getAbsolutePath());
        bundle.putString("parent",file.getName());
        return fragment1;
    }

    @Override
    public int getCount() {
        return listIMage.length;
    }
}
