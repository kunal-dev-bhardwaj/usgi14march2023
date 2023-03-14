package com.universalsompo.meta.metaapp.motor.activities.motorclaim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.renewalpayment.RenewalHealthPayment;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

public class ClaimIntimateWeb extends AppCompatActivity {
    private WebView myWebView;
    Dialog dialog;
    CustomProgressDialog customprogress;
    String PolicyURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_intimate_web);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        customprogress = new CustomProgressDialog(ClaimIntimateWeb.this);
        LinearLayout cross_icon = findViewById(R.id.cross_icon);
        myWebView = findViewById(R.id.mWebView);

        TextView back_button = findViewById(R.id.back_button);
        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back_button.setTypeface(fontAwesomeFont);
        cross_icon.setOnClickListener(v -> onBackPressed());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.setWebChromeClient(new ClaimIntimateWeb.MyWebViewClient());
        myWebView.getSettings().setBuiltInZoomControls(false);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        PolicyURL="https://www.universalsompo.com/ClaimIntimation/?DID=PULZ";
        customprogress.showProgressBar();
        myWebView.loadUrl(PolicyURL);
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                myWebView.loadUrl(url);
                return true;
            }
        });
    }
    private class MyWebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                customprogress.hideProgressBar();
                hide();
            }
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }
    }
    void hide() {
        if(dialog!=null)
            dialog.dismiss();
    }
}