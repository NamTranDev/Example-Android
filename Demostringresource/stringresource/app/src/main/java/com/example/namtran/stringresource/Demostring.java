package com.example.namtran.stringresource;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Demostring extends Activity {
        TextView txt1,txt4,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stringformat_stringplurals);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt4 = (TextView) findViewById(R.id.txt4);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt1.setText(String.format(getString(R.string.stringformat1),5));
        txt4.setText(String.format(getString(R.string.stringformat2),"Nam",8));
        Resources res = getResources();
        String stringplurals = res.getQuantityString(R.plurals.VietNam,7,64);
        txt3.setText(stringplurals);
    }
}
