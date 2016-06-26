package com.example.namtran.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nam Tran on 5/31/2015.
 */
public class Intent_truyendulieu_activity extends Activity implements View.OnClickListener{
    public static final int REQUEST_CODE_1 = 111;
    EditText edtx,edty,edtkq;
    Button btntinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh1);
        edtx = (EditText) findViewById(R.id.edtx);
        edty = (EditText) findViewById(R.id.edty);
        edtkq = (EditText) findViewById(R.id.edtketqua);
        btntinh = (Button) findViewById(R.id.btntinh);
        btntinh.setOnClickListener(this);
        edtkq.setEnabled(false);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btntinh)
        {
            String x = edtx.getText().toString();
            String y = edty.getText().toString();
            if (x.isEmpty() || y.isEmpty() )
            {
                Toast.makeText(this,"Bạn vui lòng nhập x và y",Toast.LENGTH_LONG).show();
            }
            else if (!kiemtranhap(x) || !kiemtranhap(y))
            {
                Toast.makeText(this,"Bạn vui lòng nhập x và y",Toast.LENGTH_LONG).show();
            }
            else
            {
                Intent intent = new Intent(this,Intent_nhandulieu_activity2.class);
                Bundle bundle = new Bundle();
                bundle.putDouble(Intent_nhandulieu_activity2.Key_X,Double.parseDouble(x));
                bundle.putDouble(Intent_nhandulieu_activity2.Key_Y,Double.parseDouble(y));
                intent.putExtras(bundle);
                startActivityForResult(intent,REQUEST_CODE_1);
            }
        }
    }
    public boolean kiemtranhap(String s)
    {
        int n = s.length();
        for (int i = 0; i<n; i++)
        {
            if (Character.isDigit(s.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String error;
        if (requestCode == REQUEST_CODE_1)
        {
            if (resultCode == RESULT_OK)
            {
                Bundle bundle = data.getExtras();
                Double kq = bundle.getDouble(Intent_nhandulieu_activity2.Key_KQ);
                edtkq.setText(kq+"");
            }
            else if(resultCode == RESULT_CANCELED)
            {
                if (data != null)
                {
                    Bundle bundle = data.getExtras();
                    error = bundle.getString(Intent_nhandulieu_activity2.Key_ERROR);
                    edtkq.setText(error);
                }
            }
        }
    }
}
