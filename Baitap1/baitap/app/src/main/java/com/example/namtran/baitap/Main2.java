package com.example.namtran.baitap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Nam Tran on 4/30/2015.
 */
public class Main2 extends ActionBarActivity implements View.OnClickListener
{
    Button btnNext, btnBack,btnExit;
    EditText edtNhap;
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh2);
        Log.d("Nam", "onCreate() - " + getClass().getName());

        btnNext = (Button) findViewById(R.id.btnNext);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnExit = (Button) findViewById(R.id.btnExit);
        edtNhap = (EditText) findViewById(R.id.edtNhap);
        txt1 = (TextView) findViewById(R.id.txt1);
        btnNext.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Nam"," onStart() -"+getClass().getName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Nam", "onResume() - " + getClass().getName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Nam", "onPause() - " + getClass().getName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("dzumi", "onRestart() - " + getClass().getName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Nam", "onStop() - " + getClass().getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Nam", "onDestroy() - " + getClass().getName());
    }

    @Override
    public void onClick(View view)
    {
        if (view == btnNext)
        {
            Intent intent = new Intent(this, Main3.class );
            startActivity(intent);
        }
        if (view == btnBack)
        {
            Intent intent = new Intent(this, MainActivity.class );
            startActivity(intent);
        }
        if  (view == btnExit)
        {
            Intent starMain = new Intent(Intent.ACTION_MAIN);
            starMain.addCategory(Intent.CATEGORY_HOME);
            startActivity(starMain);
            finish();
        }
    }
}
