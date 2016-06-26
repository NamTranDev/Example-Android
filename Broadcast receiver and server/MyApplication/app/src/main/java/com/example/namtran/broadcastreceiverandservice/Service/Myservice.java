package com.example.namtran.broadcastreceiverandservice.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by Nam Tran on 7/12/2015.
 */
public class Myservice extends Service {
    private final IBinder iBinder = new LocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }
    public class LocalBinder extends Binder
    {
        public Myservice getService()
        {
            return Myservice.this;
        }
        public int cong(int a,int b)
        {
            return a+b;
        }
    }
}
