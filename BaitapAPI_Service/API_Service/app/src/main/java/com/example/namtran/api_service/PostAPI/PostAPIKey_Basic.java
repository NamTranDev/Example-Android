package com.example.namtran.api_service.PostAPI;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.example.namtran.api_service.Class.APIPOST;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Nam Tran on 8/8/2015.
 */
public class PostAPIKey_Basic extends AsyncTask<String,Void,String[]> {
    public static final String KEYGETAPIPOST ="POSTAPI";
    public static final String KEYERROR ="ERROR";
    public static final String KEYSTATUS ="STATUS";
    public static final String KEYACCESS_TOKEN ="ACCESS_TOKEN";
    Context mContext;
    onCompletePOSTAPIKEY mcompletePOSTAPIKEY;
    String ApiKey ="";
    String user_name = "";
    String pass = "";



    public PostAPIKey_Basic(Context context, String apiKey,String user_name, String pass) {
        this.user_name = user_name;
        ApiKey = apiKey;
        this.pass = pass;
        mContext = context;
        mcompletePOSTAPIKEY = (onCompletePOSTAPIKEY) context;
    }

    @Override
    protected String[] doInBackground(String... strings) {
        String response ="";
        try {
            URL url = new URL(strings[0]);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = (HttpURLConnection) urlConnection;
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
            valuePairs.add(new BasicNameValuePair("APIKey", ApiKey));
            valuePairs.add(new BasicNameValuePair("user_name", user_name));
            valuePairs.add(new BasicNameValuePair("pass", pass));


            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(getQry(valuePairs));
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            connection.connect();

            int responsecode = connection.getResponseCode();
            if (responsecode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = br.readLine()) != null) {
                    response += line;
                }
            } else {
                response = "";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        APIPOST apipost = new APIPOST();
        try {
            JSONObject jsonObject = new JSONObject(response);
            apipost.setAccess_token(jsonObject.getString(APIPOST.ACCESS_TOKEN));
            apipost.setStatus(jsonObject.getInt(APIPOST.STATUS));
            apipost.setError(jsonObject.getString(APIPOST.ERROR));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        String status = String.valueOf(apipost.getStatus());
        String error = apipost.getError();
        String access_token = apipost.getAccess_token();
        String[] ab ={status,error,access_token};
        return ab;
    }
    private String getQry(List<NameValuePair> nameValuePairs) throws UnsupportedEncodingException
    {
        StringBuilder result = new StringBuilder();
        boolean frist = true;
        for (NameValuePair pair : nameValuePairs)
        {
            if (frist)
            {
                frist = false;
            }
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }
        return result.toString();
    }

    @Override
    protected void onPostExecute(String[] s) {
        super.onPostExecute(s);
        SharedPreferences.Editor editor = mContext.getSharedPreferences(KEYGETAPIPOST, Context.MODE_PRIVATE).edit();
        editor.putString(KEYSTATUS,s[0]);
        editor.putString(KEYERROR,s[1]);
        editor.putString(KEYACCESS_TOKEN,s[2]);
        editor.commit();
        mcompletePOSTAPIKEY.onCompletePOST(true);
    }
    public interface onCompletePOSTAPIKEY
    {
        void onCompletePOST(boolean isOk,String... error);
    }
}
