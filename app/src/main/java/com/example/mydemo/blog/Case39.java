package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.example.mydemo.R;

public class Case39 extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case39);
        //WebView
        WebView webView = findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
//        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.jianshu.com/p/9c8779dede1e");
    }
}

