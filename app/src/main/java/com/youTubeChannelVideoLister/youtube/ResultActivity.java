package com.youTubeChannelVideoLister.youtube;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String channelId = getIntent().getStringExtra("channelId");
        String url = "http://164.92.78.19/cgi-bin/YouTube_Fetch.py?channel_id=" + channelId;
        WebView webView = findViewById(R.id.resultWebView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}