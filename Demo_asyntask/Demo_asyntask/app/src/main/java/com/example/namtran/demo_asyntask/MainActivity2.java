package com.example.namtran.demo_asyntask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Nam Tran on 7/8/2015.
 */
public class MainActivity2 extends Activity implements View.OnClickListener{
    ProgressBar progressBar;
    Button btndownload,btncancel;
    Download_asyntask asyntask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btndownload = (Button) findViewById(R.id.btndownload);
        btncancel = (Button) findViewById(R.id.btncancel);
        btndownload.setOnClickListener(this);
        btncancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btndownload)
        {
            asyntask = new Download_asyntask();
            asyntask.execute("File 1","File 2","File 3","File 4");
        }else if (id == R.id.btncancel)
        {

        }

    }
    class Download_asyntask extends AsyncTask<String,Integer,Long> {
        long downloadfile(String url)
        {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(2000) +10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return random.nextInt(500000);
        }
        @Override
        protected Long doInBackground(String... strings) {
            int count = strings.length;
            long totalSize = 0;
            for (int i=0;i<=count;i++) {
                totalSize += downloadfile(strings[i]);
                publishProgress((int) ((i / (float) count) * 100));
                if (isCancelled())
                    break;
            }
            return totalSize;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Toast.makeText(MainActivity2.this,values[0]+"%",Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPostExecute(Long result) {
            Toast.makeText(MainActivity2.this, "Downloaded " + result + " bytes", Toast.LENGTH_SHORT).show();
        }
    }
}
