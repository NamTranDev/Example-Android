package com.example.namtran.animation;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity implements View.OnClickListener {
    ImageView imganimationdrawable;
    Button btnstart,btnstop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imganimationdrawable = (ImageView) findViewById(R.id.imganimationdrawable);
        btnstart = (Button) findViewById(R.id.btnstart);
        btnstop = (Button) findViewById(R.id.btnstop);
        btnstart.setOnClickListener(this);
        btnstop.setOnClickListener(this);
        imganimationdrawable.setBackgroundResource(R.drawable.animation_drawable);
    }

    @Override
    public void onClick(View view) {
        AnimationDrawable animationDrawable = (AnimationDrawable) imganimationdrawable.getBackground();
    int id = view.getId();
        if (id == R.id.btnstart)
        {
            animationDrawable.start();
        }
        else if (id == R.id.btnstop)
        {
            animationDrawable.stop();
        }
    }

}
