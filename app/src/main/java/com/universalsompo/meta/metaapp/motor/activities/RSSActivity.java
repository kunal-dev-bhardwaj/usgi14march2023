package com.universalsompo.meta.metaapp.motor.activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.universalsompo.meta.R;

import dmax.dialog.SpotsDialog;

public class RSSActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);*/
        if (android.os.Build.VERSION.SDK_INT >= 21)
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        LinearLayout cross_icon = findViewById(R.id.cross_icon2);
        WebView inapp_browser = findViewById(R.id.inapp_browser);

        TextView back_button = findViewById(R.id.back_button);
        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back_button.setTypeface(fontAwesomeFont);

        cross_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        inapp_browser.getSettings().setJavaScriptEnabled(true);
        inapp_browser.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(RSSActivity.this, description, Toast.LENGTH_SHORT).show();
            }
        });

        inapp_browser.loadUrl(getIntent().getStringExtra("url"));
        RSSActivity.WebClientClass webViewClient = new RSSActivity.WebClientClass();
        inapp_browser.setWebViewClient(webViewClient);
        WebChromeClient webChromeClient=new WebChromeClient();
        inapp_browser.setWebChromeClient(webChromeClient);
    }

    public class WebClientClass extends WebViewClient {
        SpotsDialog pd = null;

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            pd = new SpotsDialog(RSSActivity.this , R.style.Custom);
            pd.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            pd.dismiss();
        }
    }
}