package com.example.namtran.broadcastreceiverandservice;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.namtran.broadcastreceiverandservice.Service.ServiceMain;


public class MainActivity extends Activity implements View.OnClickListener{
    BatteryChange batteryChange;
    IntentFilter intentFilterbattery,intentFilterNetwork;
    NetworkReceiver networkReceiver;
    Button btnservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        batteryChange = new BatteryChange();
        networkReceiver = new NetworkReceiver();
        btnservice = (Button) findViewById(R.id.btnservice);
        btnservice.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        intentFilterbattery = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        intentFilterNetwork = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(networkReceiver,intentFilterNetwork);
        registerReceiver(batteryChange,intentFilterbattery);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(batteryChange);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnservice)
        {
            Intent intent = new Intent(this, ServiceMain.class);
            startActivity(intent);
        }
    }

    //<editor-fold desc="menu">
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //</editor-fold>
}
