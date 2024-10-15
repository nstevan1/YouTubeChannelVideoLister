package com.example.youtube;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        String data = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"utf-8\"></head><body><section id=\"overlay\"><form action=\"https://www.google.com\" method=\"GET\"><h1>What is the channel id?</h1><section><input type=\"text\"></section><hr><section class=\"submission\"><form><input type=\"submit\" value=\"Submit\"></form></section></form></section></body></html>";
        webView.loadData(data, "text/html", "utf-8");
    }
}