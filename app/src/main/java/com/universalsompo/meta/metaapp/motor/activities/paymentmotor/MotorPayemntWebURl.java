package com.universalsompo.meta.metaapp.motor.activities.paymentmotor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.paymentweb.PaymentWebUrl;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.activities.PolicyInBrowser;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Motor_summery;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.PostPaymentFailure;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.PostPaymentSuccess;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

public class MotorPayemntWebURl extends AppCompatActivity {
     WebView myWebView;
    Dialog dialog;
    CustomProgressDialog customprogress;
    String PolicyURL,WACode,PosPolicyNo,TotalValue,checkPage,downloadPolicy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor_payemnt_web_url);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        customprogress = new CustomProgressDialog(MotorPayemntWebURl.this);
        WACode = getIntent().getStringExtra("WACode");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        TotalValue = getIntent().getStringExtra("TotalValue");
        checkPage = getIntent().getStringExtra("checkPage");
        if (checkPage.equals("Download")){
            downloadPolicy = getIntent().getStringExtra("downloadPolicy");
        }
        myWebView = findViewById(R.id.mWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.setWebChromeClient(new MotorPayemntWebURl.MyWebViewClient());
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setAllowFileAccess(true);
        myWebView.getSettings().setSupportMultipleWindows(true);
        myWebView.getSettings().setAllowContentAccess(true);
        myWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        myWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);

        if (checkPage.equals("Summery")){
            PolicyURL = "http://124.124.15.42/PaymentGatewayUAT/ExtIntityCallPage.aspx?PosPolicyNo=" + PosPolicyNo + "&FinalPremium=" + TotalValue + "&Src=WA&SubSrc=" + WACode;
        }else{

            String pdf;
            pdf="https://drive.google.com/viewerng/viewer?embedded=true&url=" + downloadPolicy;
            PolicyURL=pdf;
        }
        Log.e("policyUrlMotor",PolicyURL);
        customprogress.showProgressBar();
        myWebView.loadUrl(PolicyURL);
        Log.e("PolicyURLDownlaod",PolicyURL);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String urlNewString) {
                customprogress.hideProgressBar();
                myWebView.loadUrl(urlNewString);
                return true;

            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap facIcon) {
                customprogress.hideProgressBar();
                if (checkPage.equals("Summery")){
                    String webUrl=myWebView.getUrl();
                    Log.e("wweburl",webUrl);
//                https://webuat.universalsompo.com/PaymentGatewayUAT/?MSG=SOMPOGINS|51050942|403993715526495776|USGI/WEBAG/0073982/00/000|11622.00|NA|2022-06-17%2011:31:54|1001|Payment%20successfully.|http://124.124.15.42/WAPDFUAT/WAPDFGenerat.aspx?QuoteID=7x_84Hk9WH-fcTCu8hVc-Q==|NA|NA|NA|NA|NA
                    if (webUrl.contains("https://webuat.universalsompo.com/PaymentGatewayUAT/?MSG=")) {
                        String[] separated = webUrl.split("successfully");
                        String one= separated[0];
                        Log.e("one",one);
                        String two= separated[1];
                        Log.e("two",two);
                        String three=two.substring(2);
                        String[] separated1 = three.split("\\|");
                        String downloadPolicy= separated1[0];
                        Log.e("downloadPolicy",downloadPolicy);
                        String two1= separated1[1];
                        Log.e("two1",two1);
                        Intent intent = new Intent(MotorPayemntWebURl.this, PostPaymentSuccess.class);
                        intent.putExtra("downloadPolicy",downloadPolicy);
                        startActivity(intent);
                        finish();
                    }else if (webUrl.contains("https://webuat.universalsompo.com:3001/journey-payment-response?MSG=")) {
                        String[] separated = webUrl.split("successfully");
                        String one= separated[0];
                        Log.e("one",one);
                        String two= separated[1];
                        Log.e("two",two);
                        String three=two.substring(2);
                        String[] separated1 = three.split("\\|");
                        String downloadPolicy= separated1[0];
                        Log.e("downloadPolicy",downloadPolicy);
                        String two1= separated1[1];
                        Log.e("two1",two1);
                        Intent intent = new Intent(MotorPayemntWebURl.this, PostPaymentSuccess.class);
                        intent.putExtra("downloadPolicy",downloadPolicy);
                        startActivity(intent);
                        finish();
                    }
                }else{
                    customprogress.hideProgressBar();
                }
//                if (webUrl.contains("https://acssimuat.payubiz.in/pg/axis/getOtp?txnid=")){
//                    String[] separated = webUrl.split("\\=");
//                    String one= separated[0];
//                    Log.e("one",one);
//                    String two= separated[1];
//                    Log.e("two",two);
//                    String[] separatedtwo = two.split("\\&");
//                    TxnId= separatedtwo[0];
//                    Log.e("TxnId",TxnId);
//                    String two1= separatedtwo[1];
//                    Log.e("two1",two1);
//                }else
//
//                    if (webUrl.contains("https://webuat.universalsompo.com/PaymentGatewayUAT/?MSG=")){
//                    Intent intent=new Intent(MotorPayemntWebURl.this,PostPaymentSuccess.class);
//                    startActivity(intent);
//                    finish();
//                }
//                else{
//                    Intent intent=new Intent(MotorPayemntWebURl.this, PostPaymentFailure.class);
//                    startActivity(intent);
//                    finish();
//                }
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

    @Override
    public void onBackPressed() {
        if (checkPage.equals("Download")){
            Intent intent=new Intent(MotorPayemntWebURl.this, MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            super.onBackPressed();
        }
    }
}