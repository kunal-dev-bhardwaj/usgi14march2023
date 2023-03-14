package com.universalsompo.meta.metaapp.motor.activities.paymentmotor;

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
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.paymentweb.PaymentWebUrl;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Health_Payment;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

public class PaymentMotorWeb extends AppCompatActivity {
    private WebView myWebView;
    Dialog dialog;
    CustomProgressDialog customprogress;
    String QuoteID,PolicyURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_motor_web);

        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));

        QuoteID = getIntent().getStringExtra("QuoteID");
        customprogress = new CustomProgressDialog(PaymentMotorWeb.this);

        myWebView = findViewById(R.id.mWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.setWebChromeClient(new PaymentMotorWeb.MyWebViewClient());
        myWebView.getSettings().setBuiltInZoomControls(false);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        PolicyURL="https://ddec1-0-en-ctp.trendmicro.com:443/wis/clicktime/v1/query?url=http%3a%2f%2f124.124.15.42%2fPaymentGatewayUAT%2fAPIPayment.aspx%3f" + QuoteID + "%3d%2a%2a%2a%2a%2a%2a%2a%2a%2a%26Src%3dRenewals%26SubSrc1%3dAPI&umid=0b3affc6-4b85-4560-a652-36902b40cf54&auth=1f026cc2f27458ed1634747a8d893652ef851070-fed3bdc8a7a0b12d33c45a8207a2f4a0c5a153e9";
        Log.e("motorPaymentPolicyUrl",PolicyURL);
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