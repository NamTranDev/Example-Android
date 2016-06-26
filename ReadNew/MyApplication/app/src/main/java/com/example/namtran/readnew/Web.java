package com.example.namtran.readnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import java.net.URI;

/**
 * Created by Nam Tran on 7/22/2015.
 */
public class Web extends Activity {
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_web);
        web = (WebView) findViewById(R.id.web);
        String link ="";
        Bundle bundle = getIntent().getExtras();
        link = bundle.getString(News.LINK);
        web.loadUrl(link);
    }
}
