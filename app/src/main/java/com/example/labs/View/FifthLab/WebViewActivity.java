package com.example.labs.View.FifthLab;

import androidx.appcompat.app.AppCompatActivity;
import com.example.labs.R;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Intent intent = getIntent();
        //if (Objects.equals(intent.getAction(), Intent.ACTION_VIEW)) {
        WebView webView = findViewById(R.id.webView);
        webView.loadUrl(intent.getData().toString());
    }
}
