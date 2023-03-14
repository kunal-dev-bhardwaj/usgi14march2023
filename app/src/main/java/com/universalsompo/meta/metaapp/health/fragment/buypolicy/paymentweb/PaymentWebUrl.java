package com.universalsompo.meta.metaapp.health.fragment.buypolicy.paymentweb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.activities.renewalpayment.HealthRenewalSummary;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.ThankYouPageCHI;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.activities.Policies_web_Browser;
import com.universalsompo.meta.metaapp.motor.activities.PolicyInBrowser;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.PostPaymentSuccess;
import com.universalsompo.meta.metaapp.motor.activities.paymentmotor.MotorPayemntWebURl;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PaymentWebUrl extends AppCompatActivity {
    private WebView myWebView;
    Dialog dialog;
    CustomProgressDialog customprogress;
    String PolicyURL,WACode,PosPolicyNo,TotalValue,checkPage,downloadPolicy,checkPayment,QuotationID,strTotalPremiumTxt,str_policy_number_health;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_web_url);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        WACode = getIntent().getStringExtra("WACode");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        TotalValue = getIntent().getStringExtra("TotalValue");
        checkPage = getIntent().getStringExtra("checkPage");
        checkPayment = getIntent().getStringExtra("checkPayment");
        QuotationID = getIntent().getStringExtra("QuotationID");
        strTotalPremiumTxt = getIntent().getStringExtra("strTotalPremiumTxt");
        str_policy_number_health = getIntent().getStringExtra("str_policy_number_health");

        if (checkPage.equals("Download")){
            downloadPolicy = getIntent().getStringExtra("downloadPolicy");
        }
        customprogress = new CustomProgressDialog(PaymentWebUrl.this);
        myWebView = findViewById(R.id.mWebView);
        myWebView.setWebChromeClient(new PaymentWebUrl.MyWebViewClient());
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setSupportMultipleWindows(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setAllowFileAccess(true);
        myWebView.getSettings().setAllowContentAccess(true);
        myWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        myWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        myWebView.getSettings().setDomStorageEnabled(true);
        myWebView.getSettings().setAppCacheEnabled(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setDefaultTextEncodingName("utf-8");

        if (checkPage.equals("Summery")){
//            PolicyURL = "http://124.124.15.42/PaymentGatewayUAT/ExtIntityCallPage.aspx?PosPolicyNo=" + PosPolicyNo + "&FinalPremium=" + TotalValue + "&Src=WA&SubSrc=" + WACode;
            if (checkPayment.equals("Health")){
//                  UAT
                PolicyURL = "http://124.124.15.42/PaymentGatewayUAT/ExtIntityCallPage.aspx?PosPolicyNo=" + PosPolicyNo + "&FinalPremium=" + TotalValue + "&Src=CHOL&SubSrc=" + WACode;
//                PolicyURL = "https://www.usgi.co.in/PaymentGateway/ExtIntityCallPage.aspx?PosPolicyNo=" + PosPolicyNo + "&FinalPremium=" + TotalValue + "&Src=CHOL&SubSrc=" + "20000149";
            }else if (checkPayment.equals("HealthRenewal")){
//                  UAT
                PolicyURL = "https://webuat.universalsompo.com/PaymentGatewayUAT/PaymentGetMain.aspx?IdentityNo="+QuotationID+"&FinalPremium="+strTotalPremiumTxt+"&Src=CHOLRNUS&RenFlag=R&OldPolNo="+str_policy_number_health+"&SubSrc=20000001";
            }else{
                PolicyURL = "http://124.124.15.42/PaymentGatewayUAT/ExtIntityCallPage.aspx?PosPolicyNo=" + PosPolicyNo + "&FinalPremium=" + TotalValue + "&Src=WA&SubSrc=" + WACode;
            }
        }else{
            String pdf;
            pdf="https://drive.google.com/viewerng/viewer?embedded=true&url=" + downloadPolicy;
            PolicyURL=pdf;
        }
        Log.e("policyurl",PolicyURL);
        customprogress.showProgressBar();
        myWebView.loadUrl(PolicyURL);
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                myWebView.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                customprogress.hideProgressBar();
                String webUrl=myWebView.getUrl();
                Log.e("webUrl",webUrl);

//                https://webuat.universalsompo.com/CompleteHealthCare/ThankYou/ThankYouDtls?MSG=SOMPOGINS|51445803|403993715527104945|USGI/WEBAH/0022142/00/000|10500.00|NA|2022-08-23%2015:11:36|1001|Payment%20successfully.|https://webuat.universalsompo.com/WAPDFUAT/WAPDFGenerat.aspx?QuoteID=e03yTlkleBL9VEHmgozsAw==|NA|NA|NA|NA|NA
//                https://webuat.universalsompo.com/PaymentGatewayUAT/?MSG=SOMPOGINS|ASIP001988|403993715527075395|USGI/WEBASI/0000341/00/000|4007.00|NA|2022-08-19%2010:38:09|1001|Payment%20successfully.|https://webuat.universalsompo.com/WAPDFUAT/WAPDFGenerat.aspx?QuoteID=we1CCFPTmuERN2HQpebqSw==|NA|NA|NA|NA|NA
                if (webUrl.contains("https://webuat.universalsompo.com:3001/journey-payment-response/?MSG")) {
//                    String[] separated13 = webUrl.split("USGI");
//                    String one22= separated13[0];
//                    Log.e("one22",one22);
//                    String two22= separated13[1];
//                    Log.e("two22",two22);

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
                    Intent intent = new Intent(PaymentWebUrl.this, ThankYouPageCHI.class);
                    intent.putExtra("downloadPolicy",downloadPolicy);
                    startActivity(intent);
                    finish();
                }else if (webUrl.contains("https://webuat.universalsompo.com/PaymentGatewayUAT/?MSG=")) {
//                    String[] separated13 = webUrl.split("USGI");
//                    String one22= separated13[0];
//                    Log.e("one22",one22);
//                    String two22= separated13[1];
//                    Log.e("two22",two22);
//                    https://webuat.universalsompo.com/PaymentGatewayUAT/?MSG=SOMPOGINS|ASIP002040|403993715527631386|2825/OL/0015744|4007.00|NA|2022-11-03%2015:14:21|1001|Payment%20successfully.|https://webuat.universalsompo.com/WAPDFUAT/WAPDFGenerat.aspx?QuoteID=l9ZFLnfdn-vvvOZo5n-90g==|NA|NA|NA|NA|NA

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
                    Intent intent = new Intent(PaymentWebUrl.this, ThankYouPageCHI.class);
                    intent.putExtra("downloadPolicy",downloadPolicy);
                    startActivity(intent);
                    finish();
                }else if(webUrl.contains("https://webuat.universalsompo.com/CompleteHealthCare/ThankYou/ThankYouDtls?MSG=")){
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
                    Intent intent = new Intent(PaymentWebUrl.this, ThankYouPageCHI.class);
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
                    Intent intent = new Intent(PaymentWebUrl.this, ThankYouPageCHI.class);
                    intent.putExtra("downloadPolicy",downloadPolicy);
                    startActivity(intent);
                    finish();
                }else{
                    customprogress.hideProgressBar();
                }
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
            Intent intent=new Intent(PaymentWebUrl.this, MainActivityHealth.class);
            startActivity(intent);
            finish();
        }else{
            super.onBackPressed();
        }
    }
}