package com.example.namtran.api_service.GetAPIKey;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.transform.Result;

/**
 * Created by Nam Tran on 8/8/2015.
 */
public class GetAPIKey_Basic extends AsyncTask<String,Void,String> {

    public static final String KEYGETAPI ="GETAPI";
    public static final String KEYAPI ="APIKEY";



    Context mContext;
    onCompleteGETAPIKEY mcompleteGETAPIKEY;

    public GetAPIKey_Basic(Context mContext) {
        this.mContext = mContext;
        this.mcompleteGETAPIKEY = (onCompleteGETAPIKEY) mContext;
    }


    @Override
    protected String doInBackground(String... strings) {
        String APIKEY = "";

        try {
                URL url = new URL(strings[0]);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    byte[] buffer = new byte[1000];
                    int i = 0;
                    while ((i = inputStream.read(buffer)) != -1) {
                        APIKEY += new String(buffer, 0, i);
                    }
                    Log.d("Trannam",APIKEY);
                } else {
                    mcompleteGETAPIKEY.onComplete(false, "Lỗi hệ thống");
                }
        } catch (MalformedURLException e1) {
        e1.printStackTrace();
        } catch (IOException e1) {
        e1.printStackTrace();
        }
        Gson gson = new Gson();
        APIKeyCLASS apiKeyCLASS = new APIKeyCLASS();
        try {
            JSONObject jsonObject = new JSONObject(APIKEY);

            apiKeyCLASS.setApiKey(jsonObject.getString(APIKeyCLASS.APIKEY));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //APIKeyCLASS apiKeyCLASS = gson.fromJson(APIKEY,APIKeyCLASS.class);


        return apiKeyCLASS.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        SharedPreferences.Editor editor = mContext.getSharedPreferences(KEYGETAPI,Context.MODE_PRIVATE).edit();
        editor.putString(KEYAPI, s);
        editor.commit();
        mcompleteGETAPIKEY.onComplete(true);
    }

    public interface onCompleteGETAPIKEY
    {
        void onComplete(boolean isOk,String... error);
    }
    private class APIKeyCLASS
    {
        public static final String APIKEY = "APIKey";
        String ApiKey;



        public APIKeyCLASS() {

        }

        public String getApiKey() {
            return ApiKey;
        }

        public void setApiKey(String apiKey) {
            ApiKey = apiKey;
        }

        @Override
        public String toString() {
            return ApiKey;
        }
    }
}
