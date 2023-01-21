package com.example.tryintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textView = findViewById(R.id.textView);
        WebView webView = findViewById(R.id.webView);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b != null && !b.getString("Message").isEmpty()) {
            String s = b.getString("Message");
            textView.setText(s);
        }else {
            textView.setText("No data Passed");
        }

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadUrl("https://www.google.com/");



    }
}