package com.example.namtran.notification;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.Key;


public class MainActivity extends Activity implements View.OnClickListener{
    public final static String KEY = "KEY";
   /* public final static String KEY2 = "KEY2";*/
    TextView txtnotification;
    EditText edt1,edt2;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnotification = (TextView) findViewById(R.id.txtnotification);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn1)
        {
            String notification1 = edt1.getText().toString();
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra(KEY,notification1);

            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(MainActivity.class);
            stackBuilder.addNextIntent(intent);

            PendingIntent pendingIntent = stackBuilder.getPendingIntent(2,PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setContentTitle("Notification")
                    .setContentText(notification1).setSmallIcon(R.drawable.pin1).setAutoCancel(true);
            builder.setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
            notificationManager.notify(1,builder.build());

            startActivity(intent);

        }else if (id == R.id.btn2)
        {
            String notification2 = edt2.getText().toString();
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra(KEY,notification2);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(MainActivity.class);
            stackBuilder.addNextIntent(intent);

            PendingIntent pendingIntent = stackBuilder.getPendingIntent(2,PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setContentTitle("Notification")
                    .setContentText(notification2).setSmallIcon(R.drawable.pin8).setAutoCancel(true);
            builder.setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
            notificationManager.notify(2,builder.build());

            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent i = getIntent();
        String text = i.getStringExtra(KEY);
       /* String text2 = i.getStringExtra(KEY2);*/
        txtnotification.setText(text);
/*        edt1.setText(text);
        edt2.setText(text2);*/
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
