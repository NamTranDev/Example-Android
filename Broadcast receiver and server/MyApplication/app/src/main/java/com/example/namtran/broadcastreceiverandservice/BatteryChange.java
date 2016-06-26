package com.example.namtran.broadcastreceiverandservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

/**
 * Created by Nam Tran on 7/12/2015.
 */
public class BatteryChange extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
        Toast.makeText(context,level+" %" ,Toast.LENGTH_LONG).show();
    }
}
