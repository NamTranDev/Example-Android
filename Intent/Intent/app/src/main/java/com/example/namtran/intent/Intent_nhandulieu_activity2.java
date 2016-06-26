package com.example.namtran.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nam Tran on 5/31/2015.
 */
public class Intent_nhandulieu_activity2 extends Activity implements View.OnClickListener{
    Button btncong,btntru,btnnhan,btnchia;
    double x,y;
    public static final String Key_X ="123";
    public static final String Key_Y ="345";
    public static final String Key_KQ ="567";
    public static final String Key_ERROR ="789";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh2);
        btncong = (Button) findViewById(R.id.btncong);
        btntru = (Button) findViewById(R.id.btntru);
        btnnhan = (Button) findViewById(R.id.btnnhan);
        btnchia = (Button) findViewById(R.id.btnchia);
        btncong.setOnClickListener(this);
        btntru.setOnClickListener(this);
        btnnhan.setOnClickListener(this);
        btnchia.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        x = bundle.getDouble(Key_X);
        y = bundle.getDouble(Key_Y);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = getIntent();
        String error ="";
        int resultcode = 1;
        double kq = 0;
        if (id == R.id.btncong)
        {
            kq = x+y;
            resultcode = RESULT_OK;
        }else if (id == R.id.btntru)
        {
            kq = x-y;
            resultcode = RESULT_OK;
        }else if (id == R.id.btnnhan)
        {
            kq = x*y;
            resultcode = RESULT_OK;
        }else if (id == R.id.btnchia)
        {
            if (y == 0)
            {
                error = "Lỗi";
                resultcode = RESULT_CANCELED;
            }
            else
            {
                kq = x/y;
                resultcode = RESULT_OK;
            }
        }
        Bundle bundle = intent.getExtras();
        bundle.getDouble(Key_KQ,kq);
        bundle.putString(Key_ERROR,error);
        intent.putExtras(bundle);
        setResult(resultcode, intent);
        finish();
    }
}
