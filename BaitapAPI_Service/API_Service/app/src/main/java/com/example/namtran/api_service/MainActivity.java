package com.example.namtran.api_service;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.namtran.api_service.Class.Email;
import com.example.namtran.api_service.GetAPIKey.GetAPIKey_Basic;
import com.example.namtran.api_service.PostAPI.PostAPIKey_Basic;
import com.example.namtran.api_service.PostAPI.PostEmail_Basic;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener, GetAPIKey_Basic.onCompleteGETAPIKEY
                        , PostAPIKey_Basic.onCompletePOSTAPIKEY,PostEmail_Basic.onCompletePOSTEMAIL {

    public static final String KEYGETAPI ="GETAPI";
    public static final String KEYAPI ="APIKEY";
    public static final String KEYGETAPIPOST ="POSTAPI";
    public static final String KEYERROR ="ERROR";
    public static final String KEYSTATUS ="STATUS";
    public static final String KEYACCESS_TOKEN ="ACCESS_TOKEN";
    public static final String KEYEMAIL ="POSTEMAIL";
    public static final String KEYPOSTEMAIL ="MAILPOST";

    Button btngetAPI;
    Button btnpostAPI;
    EditText edtgetAPI;
    EditText edtpostAPI;
    Button btnpostEMAIL;
    EditText edtEMAIL;
    String ACCESS_TOKEN;
    String APIKEY;
    int STATUS_POST1;
    String STATUS_POST;
    String ERROR_POST;
    EditText edtuser,edtpass;
    Button btnlogin;
    GetAPIKey_Basic getAPIKey_basic;
    String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngetAPI = (Button) findViewById(R.id.btngetAPI);
        edtgetAPI = (EditText) findViewById(R.id.edtgetAPI);
        btnpostAPI = (Button) findViewById(R.id.btnpostAPI);
        edtpostAPI = (EditText) findViewById(R.id.edtpostAPI);
        btnpostEMAIL = (Button) findViewById(R.id.btnpostEAMAIL);
        edtEMAIL= (EditText) findViewById(R.id.edtEMAIL);

        edtuser = (EditText) findViewById(R.id.edtuser);
        edtpass = (EditText) findViewById(R.id.edtpass);
        btnlogin = (Button) findViewById(R.id.btnlogin);

        btngetAPI.setOnClickListener(this);
        btnpostAPI.setOnClickListener(this);
        btnpostEMAIL.setOnClickListener(this);
        btnlogin.setOnClickListener(this);
    }




    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btngetAPI)
        {
            GetAPIKey_Basic getAPIKey_basic = new GetAPIKey_Basic(this);
            getAPIKey_basic.execute("http://logical-river-834.appspot.com/api/getAPIKey");
        }
        else if (id == R.id.btnpostAPI)
        {
            PostAPIKey_Basic postAPIKey_basic = new PostAPIKey_Basic(this,APIKEY,"midu","midu");
            postAPIKey_basic.execute("http://logical-river-834.appspot.com/api/login");
        }
        else if (id == R.id.btnpostEAMAIL)
        {
            PostEmail_Basic postEmail_basic = new PostEmail_Basic(this,ACCESS_TOKEN);
            postEmail_basic.execute("http://logical-river-834.appspot.com/api/getEmails");
        }
        else if (id == R.id.btnlogin)
        {
            getAPIKey_basic = new GetAPIKey_Basic(this);
            getAPIKey_basic.execute("http://logical-river-834.appspot.com/api/getAPIKey");
            onComplete(true);
            Log.d("APIKEY",APIKEY);
            if (APIKEY == null)
            {
                GetAPIKey_Basic getAPIKey = new GetAPIKey_Basic(this);
                getAPIKey_basic.execute("http://logical-river-834.appspot.com/api/getAPIKey");
            }
            else
            {
                String user = edtuser.getText().toString();
                String pass = edtpass.getText().toString();

                if (user.equals("midu") && pass.equals("midu"))
                {
     PostAPIKey_Basic postAPIKey_basic = new PostAPIKey_Basic(this,APIKEY,user,pass);
                    postAPIKey_basic.execute("http://logical-river-834.appspot.com/api/login");
                    onCompletePOST(true);
                    if (STATUS_POST1 == 1)
                    {
                        PostEmail_Basic postEmail_basic = new PostEmail_Basic(this,ACCESS_TOKEN);
                        postEmail_basic.execute("http://logical-river-834.appspot.com/api/getEmails");
                        onCompletePOSTEMAIL(true);
                    }
                    else
                    {
                        Toast.makeText(this,ERROR_POST.toString(),Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(this,"Sai username hoặc password",Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public void onComplete(boolean isOk, String... error) {
        if (isOk)
        {
            SharedPreferences sharedPreferences = getSharedPreferences(KEYGETAPI,MODE_PRIVATE);
            APIKEY = sharedPreferences.getString(KEYAPI,"Default");
            edtgetAPI.setText(APIKEY);
        }
    }

    @Override
    public void onCompletePOST(boolean isOk, String... error) {
        if (isOk)
        {
            SharedPreferences sharedPreferences = getSharedPreferences(KEYGETAPIPOST,MODE_PRIVATE);
            ACCESS_TOKEN = sharedPreferences.getString(KEYACCESS_TOKEN,"Default");
            STATUS_POST = sharedPreferences.getString(KEYSTATUS,"Default");
            Log.d("Namtran",STATUS_POST);
            STATUS_POST1 = Integer.parseInt(STATUS_POST);
            Log.d("Trannam", String.valueOf(STATUS_POST1));
            ERROR_POST = sharedPreferences.getString(KEYERROR,"Default");
            edtpostAPI.setText(ACCESS_TOKEN);
        }
    }


    @Override
    public void onCompletePOSTEMAIL(boolean isOk, String... error) {
        if (isOk)
        {
            Intent intent = new Intent(this,ActivityEmail.class);
            startActivity(intent);
        }
    }
}
