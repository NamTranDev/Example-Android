package com.example.namtran.allcountrys;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;



import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by Nam Tran on 7/28/2015.
 */
public class Countries extends ActionBarActivity
{
    private static final String KEY_IMAGE = "image";
    private static final String KEY_NAMEVI = "namevi";
    private static final String KEY_LANGUAGE = "language";
    private static final String KEY_CAPTION = "caption";
    private static final String KEY_POPULATION = "population";
    private static final String KEY_ACREAGE = "acreage";
    ImageView imgcountries;
    TextView txtNAMEVI,txtLANGUAGE,txtCAPTION,txtPOPULATION,txtACREAGE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_countries);
        imgcountries = (ImageView) findViewById(R.id.imgcountries);
        txtNAMEVI = (TextView) findViewById(R.id.txtNAMEVI);
        txtLANGUAGE = (TextView) findViewById(R.id.txtLANGUAGE);
        txtCAPTION = (TextView) findViewById(R.id.txtCAPTION);
        txtPOPULATION = (TextView) findViewById(R.id.txtPOPULATION);
        txtACREAGE = (TextView) findViewById(R.id.txtACREAGE);
        Bundle bundle = getIntent().getExtras();
        String image = "";
        image = bundle.getString(KEY_IMAGE);
        Picasso.with(this).load(image).resize(300,300).centerCrop().into(imgcountries);
        txtNAMEVI.setText(bundle.getString(KEY_NAMEVI));
        txtLANGUAGE.setText(bundle.getString(KEY_LANGUAGE));
        txtCAPTION.setText(bundle.getString(KEY_CAPTION));
        txtPOPULATION.setText(bundle.getString(KEY_POPULATION));
        txtACREAGE.setText(bundle.getString(KEY_ACREAGE));
        ActionBar mActionBar = getActionBar();
        mActionBar.setDisplayShowCustomEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_country,menu);

        return true;
    }
}
