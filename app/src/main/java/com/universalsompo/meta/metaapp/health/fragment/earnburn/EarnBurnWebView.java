package com.universalsompo.meta.metaapp.health.fragment.earnburn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Add_Details_Old_Vehicle;
import com.universalsompo.meta.metaapp.motor.activities.paymentmotor.PaymentMotorWeb;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

public class EarnBurnWebView extends AppCompatActivity {
    private WebView myWebView;
    Dialog dialog;
    CustomProgressDialog customprogress;
    String TokenNo,FunctionalityType,PolicyURL;
    TextView earn_burnTxt;
    ImageView backImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earn_burn_web_view);
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));

        TokenNo = getIntent().getStringExtra("TokenNo");
        FunctionalityType = getIntent().getStringExtra("FunctionalityType");
        customprogress = new CustomProgressDialog(EarnBurnWebView.this);

        earn_burnTxt = findViewById(R.id.earn_burnTxt);
        myWebView = findViewById(R.id.mWebView);
        backImage = findViewById(R.id.backImage);
        earn_burnTxt.setText(FunctionalityType+" "+"Reward");

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getFragmentManager().popBackStack();
                }else {
                    EarnBurnWebView.super.onBackPressed();
                    overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);
                }
//                Intent intent=new Intent(EarnBurnWebView.this, MainActivityHealth.class);
//                startActivity(intent);
                finish();
//                overridePendingTransition(R.anim.translate_left_side, R.anim.translate_right_side);

            }
        });

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.setWebChromeClient(new EarnBurnWebView.MyWebViewClient());
        myWebView.getSettings().setBuiltInZoomControls(false);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
//       PolicyURL="http://testusgiui.watchyourhealth.com/sso?_token="+TokenNo;
       PolicyURL="https://ddec1-0-en-ctp.trendmicro.com:443/wis/clicktime/v1/query?url=https%3a%2f%2fwyhmobile.universalsompo.in%2fuser%2fsso%3f%5ftoken%3d%257BOutputOfStep1%257D&umid=5d8ace35-8818-4a09-b19f-416db809e839&auth=1f026cc2f27458ed1634747a8d893652ef851070-34cb7412df44c4db24232498df6ec211fa90029e"+TokenNo;
//        PolicyURL="https://api.digitallocker.gov.in/public/oauth2/1/authorize?response_type=code&client_id=450EEFEA&state=YES";
        Log.e("EarnBurnPolicyUrl",PolicyURL);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        }else {
            EarnBurnWebView.super.onBackPressed();
            overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);
        }
//        Intent intent=new Intent(EarnBurnWebView.this, MainActivityHealth.class);
//        startActivity(intent);
        finish();
//        overridePendingTransition(R.anim.translate_left_side, R.anim.translate_right_side);

    }
}