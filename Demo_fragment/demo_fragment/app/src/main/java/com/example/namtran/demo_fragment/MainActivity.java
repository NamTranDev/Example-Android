package com.example.namtran.demo_fragment;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {
    Button btnfragment1,btnfragment2,btnfragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnfragment1 = (Button) findViewById(R.id.btnfragment1);
        btnfragment2 = (Button) findViewById(R.id.btnfragment2);
        btnfragment3 = (Button) findViewById(R.id.btnfragment3);
        btnfragment1.setOnClickListener(this);
        btnfragment2.setOnClickListener(this);
        btnfragment3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
