package com.example.namtran.broadcastreceiverandservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Nam Tran on 7/12/2015.
 */
public class NetworkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connect = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connect.getActiveNetworkInfo();
        if (info != null)
        {
            Toast.makeText(context,"Có mạng",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(context,"Mất mạng",Toast.LENGTH_LONG).show();
        }
    }
}
