package com.example.namtran.demo_asyntask;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.example.namtran.demo_asyntask.Adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener{
    Button btnasyntask;
    GridView gridview;
    ProgressBar progressBar;
    CustomAdapter adapter;
    List<Country> countries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnasyntask = (Button) findViewById(R.id.btnasyntask);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        gridview = (GridView) findViewById(R.id.gridview);

        btnasyntask.setOnClickListener(this);
    }


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

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnasyntask)
        {
            progressBar.setVisibility(View.VISIBLE);
            countries = new ArrayList<>();
            adapter = new CustomAdapter(this,R.layout.layout_item_adapter,countries);
            gridview.setAdapter(adapter);
            myAsyncTask.execute();
        }

    }
    AsyncTask<Void,Void,Void> myAsyncTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... voids) {
            for (int i=0;i<10;i++)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countries.add(new Country(R.drawable.afghanistan,"Afghanistan","Afghanistan"));
                publishProgress(null);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            progressBar.setVisibility(View.GONE);
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }
    };
}
