package com.universalsompo.meta.metaapp.health.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.Policies_web_Browser;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

public class Web_Loan extends AppCompatActivity {
    private WebView myWebView;
    Dialog dialog;
    String url="",title="";
    CustomProgressDialog customprogress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web__loan);
        customprogress = new CustomProgressDialog(Web_Loan.this);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        TextView back_button = findViewById(R.id.back_button);
        LinearLayout cross_icon = findViewById(R.id.cross_icon);
        title=getIntent().getStringExtra("text_nm");
        url = getIntent().getStringExtra("policy_health_url");

        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back_button.setTypeface(fontAwesomeFont);

        TextView policy_no_text = findViewById(R.id.policy_no_text);
        policy_no_text.setText(title);

        cross_icon.setOnClickListener(v -> onBackPressed());

        myWebView = findViewById(R.id.mWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.setWebChromeClient(new Web_Loan.MyWebViewClient());
        myWebView.getSettings().setBuiltInZoomControls(false);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
//        customDialoig();
        customprogress.showProgressBar();
        myWebView.loadUrl(url);

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