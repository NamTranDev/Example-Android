package com.example.namtran.broadcastreceiverandservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Nam Tran on 7/12/2015.
 */
public class BatteryLow extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Hết pin",Toast.LENGTH_LONG).show();
    }
}
