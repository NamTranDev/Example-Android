package com.example.namtran.readnew;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Nam Tran on 7/20/2015.
 */
public class Asystank_ReadNew extends AsyncTask<URL, Void, List<News>>  {

    GetResult mgetResult;

    public Asystank_ReadNew(Context context) {
        mgetResult = (GetResult) context;
    }

    @Override
protected List<News> doInBackground(URL... urls) {
    List<News> newses = new ArrayList<News>();
        for (URL url : urls) {
                 try {
                         URLConnection urlConnection = url.openConnection();
                            if (url.getPath().contains("HTTPS")) {
                                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlConnection;
                            if (httpsURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                                newses= RSSUtil.readRSSDanTri(httpsURLConnection.getInputStream());
                            }
                            } else {
                                HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                                newses = RSSUtil.readRSSDanTri(httpURLConnection.getInputStream());
                            }
                                    }
                    } catch (IOException e) {
                 e.printStackTrace();
                    }
                             }
        return newses;
   }

@Override
protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

        }

@Override
protected void onPostExecute(List<News> newses)
    {
        super.onPostExecute(newses);
        if (newses != null)
        {
            mgetResult.GetResult(true,newses);
        }
    }
    public interface GetResult{
        void GetResult(boolean isOK,List<News> result);
    }
}
