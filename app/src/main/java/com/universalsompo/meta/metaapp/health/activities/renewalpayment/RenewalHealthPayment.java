package com.universalsompo.meta.metaapp.health.activities.renewalpayment;

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
import com.universalsompo.meta.metaapp.motor.activities.paymentmotor.PaymentMotorWeb;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

public class RenewalHealthPayment extends AppCompatActivity {
    private WebView myWebView;
    Dialog dialog;
    CustomProgressDialog customprogress;
    String QuotationHealthRenewal,PolicyURL,strPremiumDetails,str_policy_number_health;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renewal_health_payment);
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));

        QuotationHealthRenewal = getIntent().getStringExtra("QuotationHealthRenewal");
        strPremiumDetails = getIntent().getStringExtra("strPremiumDetails");
        str_policy_number_health = getIntent().getStringExtra("str_policy_number_health");
        customprogress = new CustomProgressDialog(RenewalHealthPayment.this);

        myWebView = findViewById(R.id.mWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.setWebChromeClient(new RenewalHealthPayment.MyWebViewClient());
        myWebView.getSettings().setBuiltInZoomControls(false);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        PolicyURL="http://124.124.15.42/PaymentGatewayUAT/PaymentGetMain.aspx?IdentityNo="+QuotationHealthRenewal+"&"+strPremiumDetails+"&Src=CHOLRNUS&RenFlag=R&"+str_policy_number_health+"&SubSrc=20000001";
        Log.e("healthPaymentPolicyUrl",PolicyURL);
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