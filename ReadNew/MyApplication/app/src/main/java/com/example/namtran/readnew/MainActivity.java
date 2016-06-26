package com.example.namtran.readnew;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends Activity implements View.OnClickListener,AdapterView.OnItemClickListener ,Asystank_ReadNew.GetResult{
    Button btnNew;
    ListView listView;
    List<News> newsList;
    Adapter_ReadNew adapter_readNew;
    ProgressBar progressBar;
    Asystank_ReadNew asyncTask;
    Asystank_ReadNew.GetResult getResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnNew = (Button) findViewById(R.id.btnNew);
        newsList = new ArrayList<>();

        btnNew.setOnClickListener(this);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnNew) {

            //progressBar.setVisibility(View.VISIBLE);
             asyncTask = new Asystank_ReadNew(this);
            try {
                asyncTask.execute(new URL("http://vnexpress.net/rss/the-thao.rss"));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
           // Log.d("NamTran", String.valueOf(newsList));
           // newsList = new ArrayList<>();


        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(this,Web.class);
            Bundle bundle = new Bundle();
            bundle.putString(News.LINK,newsList.get(i).getLink());
            intent.putExtras(bundle);
            startActivity(intent);
    }

    @Override
    public void GetResult(boolean isOK, List<News> result) {
        newsList = result;
        adapter_readNew = new Adapter_ReadNew(this,R.layout.layout_item_new,newsList);
        listView.setAdapter(adapter_readNew);
    }
}

   /* class Asystank_ReadNew1 extends AsyncTask<URL, Void, List<News>> {
        @Override
        protected List<News> doInBackground(URL... urls) {
            for (URL url : urls) {
                try {
                    URLConnection urlConnection = url.openConnection();
                    if (url.getPath().contains("HTTPS")) {
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlConnection;
                        if (httpsURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                            return RSSUtil.readRSSDanTri(httpsURLConnection.getInputStream());
                        }
                    } else {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                        if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                             return RSSUtil.readRSSDanTri(httpURLConnection.getInputStream());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
               // publishProgress(null);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            adapter_readNew.notifyDataSetChanged();
        }

        @Override
        protected void onPostExecute(List<News> newses) {
            super.onPostExecute(newses);

            if (newses != null) {
                for (News news : newses) {
                    newsList.add(news);
                }
            }
            Log.d("TranNam", String.valueOf(newsList));
            adapter_readNew = new Adapter_ReadNew(getApplicationContext(),R.layout.layout_item_new,newsList);
            listView.setAdapter(adapter_readNew);
          // progressBar.setVisibility(View.GONE);

        }
    }*/

