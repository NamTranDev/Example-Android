package com.example.namtran.broadcastreceiverandservice.Service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.namtran.broadcastreceiverandservice.R;

/**
 * Created by Nam Tran on 7/12/2015.
 */
public class ServiceMain extends Activity implements View.OnClickListener {
    TextView txtkq;
    Button btnservice;
    Myservice myservice;
    boolean mBound;
    int KQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_demo_service);
        txtkq = (TextView) findViewById(R.id.txtkq);
        btnservice = (Button) findViewById(R.id.btnservice);
        btnservice.setOnClickListener(this);
    }
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Myservice.LocalBinder binder = (Myservice.LocalBinder) iBinder;
            myservice = binder.getService();
            KQ = binder.cong(5,6);
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
                mBound = false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent i = new Intent(this,Myservice.class);
        bindService(i,mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound)
        {
            myservice.unbindService(mConnection);
            mBound = false;
        }
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnservice)
        {
            if (mBound)
            {
                txtkq.setText(String.valueOf(KQ));
            }
        }
    }
}
