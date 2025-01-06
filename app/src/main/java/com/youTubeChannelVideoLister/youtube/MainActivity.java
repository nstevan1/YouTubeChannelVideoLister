package com.youTubeChannelVideoLister.youtube;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(), "Android");
        String data = "<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head><meta charset=\"utf-8\"></head>" +
                "<body>" +
                "<section id=\"overlay\">" +
                "<form onsubmit=\"submitForm();\">" +
                "<h1>What is the channel id?</h1>" +
                "<section><input type=\"text\" id=\"channelId\"></section>" +
                "<hr>" +
                "<section class=\"submission\"><input type=\"submit\" value=\"Submit\"></section>" +
                "</form>" +
                "</section>" +
                "<p id=\"result\"></p>" +
                "<script>" +
                "function submitForm() {" +
                " var channelId = document.getElementById('channelId').value;" +
                " Android.sendChannelId(channelId);" +
                "}" +
                "</script>" +
                "</body>" +
                "</html>";
        webView.loadData(data, "text/html", "utf-8");
    }
    public class WebAppInterface {
        @JavascriptInterface
        public void sendChannelId(String channelId) {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("channelId", channelId);
            startActivity(intent);
        }
    }
}