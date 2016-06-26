package com.example.namtran.baitap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nam Tran on 4/30/2015.
 */
public class Login extends ActionBarActivity implements View.OnClickListener,CheckBox.OnCheckedChangeListener
{
    EditText edtPassword,edtEmail;
    TextView txtDangnhap;
    CheckBox ckbShowpassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Log.d("Nam", "onCreate() - " + getClass().getName());

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        txtDangnhap = (TextView) findViewById(R.id.txtDangnhap);
        ckbShowpassword = (CheckBox) findViewById(R.id.ckbShowpassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        ckbShowpassword.setOnCheckedChangeListener(this);
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
        if (view == btnLogin)
        {
          if(kiemtra()==true)
          {
              Intent i = new Intent(this, MainActivity.class);
              startActivity(i);
          }
          else
          {
             Thongbao("Email hoac Password sai !!!");
          }
        }

    }
    public void Thongbao (String str)
    {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
    public boolean kiemtra()
    {
        if (edtEmail.getText().toString().equals("nam") && edtPassword.getText().toString().equals("nam"))
            return true;
        else
            return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b)
    {
            if (!b)
            {
                //Show password
                edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            else
            {
                //Hide password
                edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
    }
}
