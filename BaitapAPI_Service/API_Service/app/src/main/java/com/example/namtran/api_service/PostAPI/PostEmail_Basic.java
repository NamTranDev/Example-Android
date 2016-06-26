package com.example.namtran.api_service.PostAPI;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.example.namtran.api_service.Class.Email;
import com.example.namtran.api_service.Class.EmailPost;
import com.example.namtran.api_service.Provider.Iprovider;
import com.example.namtran.api_service.Provider.Provider;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
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
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 8/9/2015.
 */
public class PostEmail_Basic extends AsyncTask<String,Void,List<Email>> {

    public static final String KEYEMAIL ="POSTEMAIL";
    public static final String KEYPOSTEMAIL ="MAILPOST";

    Context mContext;
    String access_token;
    onCompletePOSTEMAIL onCompletePOSTEMAIL;

    public PostEmail_Basic(Context context, String access_token) {
        this.mContext = context;
        this.access_token = access_token;
        onCompletePOSTEMAIL = (PostEmail_Basic.onCompletePOSTEMAIL) context;
    }

    @Override
    protected List<Email> doInBackground(String... strings) {
        String response = "";
        List<Email> emails;
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            List<NameValuePair> valuePairs = new ArrayList<>();
            valuePairs.add(new BasicNameValuePair("access_token",access_token));

            OutputStream stream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(stream,"UTF-8"));
            bufferedWriter.write(getQry(valuePairs));
            bufferedWriter.flush();
            bufferedWriter.close();
            stream.close();

            int responsecode = connection.getResponseCode();
            if (responsecode == HttpURLConnection.HTTP_OK)
            {
                String line ="";
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = bufferedReader.readLine())!= null)
                {
                    response += line;
                }
            }
            else{
                response = "";
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        emails = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            EmailPost emailPost = new EmailPost();
            emailPost.setStatusEmail(jsonObject.getInt(EmailPost.STATUSEMAIL));
            emailPost.setErrorEmail(jsonObject.getString(EmailPost.ERROREMAIL));
            emailPost.setEmail(jsonObject.getString(EmailPost.EMAIL));
            JSONArray jsonArray = jsonObject.getJSONArray("emails");
            for (int i=0;i<jsonArray.length();i++)
            {
                Email email = new Email();
                JSONObject jsonObjectEmail = jsonArray.getJSONObject(i);
                email.setTitle(jsonObjectEmail.getString(Email.TITLE));
                email.setDescription(jsonObjectEmail.getString(Email.DESCRIPTION));
                email.setId(jsonObjectEmail.getInt(Email.ID));
                email.setDate(jsonObjectEmail.getString(Email.DATE));
                emails.add(email);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return emails;
    }



    @Override
    protected void onPostExecute(List<Email> s) {
        super.onPostExecute(s);
       /* SharedPreferences.Editor editor = mContext.getSharedPreferences(KEYPOSTEMAIL, Context.MODE_PRIVATE).edit();
        editor.putString(KEYEMAIL,s);
        editor.commit();*/
        Iprovider iprovider = new Provider(mContext);
        for (int i = 0; i<s.size();i++)
        {
            iprovider.insert(s.get(i).getId(),s.get(i).getTitle(),s.get(i).getDescription(),s.get(i).getDate());
        }
        List<Email> emails = iprovider.get();

        onCompletePOSTEMAIL.onCompletePOSTEMAIL(true);
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
    public interface onCompletePOSTEMAIL
    {
        void onCompletePOSTEMAIL(boolean isOk,String... error);
    }

}
