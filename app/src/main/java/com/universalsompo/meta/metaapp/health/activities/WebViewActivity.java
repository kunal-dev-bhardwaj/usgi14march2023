package com.universalsompo.meta.metaapp.health.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

public class WebViewActivity extends AppCompatActivity {
    WebView view;
    String policy_number="";
    private MySharedPreference pref;
    private CustomProgressDialog customprogress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        pref = MySharedPreference.getInstance(getApplicationContext());
        policy_number = getIntent().getStringExtra("policy_number");
         view = (WebView) findViewById(R.id.webView1);

         view.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return false;
            }
        });
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl("https://wyhmobile.universalsompo.in/chatbot/assessment/hraquestionnairev2?policyno="+policy_number+"&amp;memberid="+ pref.getCustID());


//        https://wyhmobile.universalsompo.in/chatbot/assessment/hraquestionnairev2?policyno=[policyno]&amp;memberid=[memberid]


    }
}