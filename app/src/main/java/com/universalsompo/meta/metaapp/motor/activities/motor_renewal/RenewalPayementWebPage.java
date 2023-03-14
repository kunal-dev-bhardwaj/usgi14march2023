package com.universalsompo.meta.metaapp.motor.activities.motor_renewal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.paymentmotor.MotorPayemntWebURl;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

public class RenewalPayementWebPage extends AppCompatActivity {
    private WebView myWebView;
    Dialog dialog;
    CustomProgressDialog customprogress;
    String PolicyURL,WACode,PosPolicyNo,TotalValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renewal_payement_web_page);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        WACode = getIntent().getStringExtra("WACode");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        TotalValue = getIntent().getStringExtra("TotalValue");

        customprogress = new CustomProgressDialog(RenewalPayementWebPage.this);

        myWebView = findViewById(R.id.mWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.setWebChromeClient(new RenewalPayementWebPage.MyWebViewClient());
        myWebView.getSettings().setBuiltInZoomControls(false);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);

//        PolicyURL = "http://124.124.15.42/PaymentGatewayUAT/ExtIntityCallPage.aspx?PosPolicyNo=" + PosPolicyNo + "&FinalPremium=" + TotalValue + "&Src=WA&SubSrc=" + WACode;


        PolicyURL = "https://webuat.universalsompo.com/PaymentGatewayUAT/APIPayment.aspx?IdentityNo="+PosPolicyNo+"&Src=Renewals&SubSrc1=API";
        Log.e("policyUrlMotor",PolicyURL);



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