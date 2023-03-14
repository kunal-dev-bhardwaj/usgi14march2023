package com.universalsompo.meta.metaapp.motor.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.zl.reik.dilatingdotsprogressbar.DilatingDotsProgressBar;

import java.util.Objects;

public class Policies_web_Browser extends AppCompatActivity {
    private WebView myWebView;
    Dialog dialog;
    private TextView ok_dialog_txt;
    private TextView cancel_dialog_txt;
    private LinearLayout dialog_btn_llayout;
    CustomProgressDialog customprogress;
   String url="https://www.universalsompo.com/Motor-renewal/pages/#/Home";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policies_web__browser);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        customprogress = new CustomProgressDialog(Policies_web_Browser.this);
        TextView back_button = findViewById(R.id.back_button);
        LinearLayout cross_icon = findViewById(R.id.cross_icon);

        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back_button.setTypeface(fontAwesomeFont);

        TextView policy_no_text = findViewById(R.id.policy_no_text);
        policy_no_text.setText("Renewal Policy");

        cross_icon.setOnClickListener(v -> onBackPressed());

        myWebView = findViewById(R.id.mWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.setWebChromeClient(new Policies_web_Browser.MyWebViewClient());
        myWebView.getSettings().setBuiltInZoomControls(false);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
//        customDialoig();
        customprogress.showProgressBar();
        myWebView.loadUrl(UrlConstants.Renewal_url);

        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                myWebView.loadUrl(url);
                return true;
            }
        });
    }
    void customDialoig() {
        dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.custom_loading_layout_for_browser);

        DilatingDotsProgressBar mDilatingDotsProgressBar = dialog.findViewById(R.id.progress);
        TextView domain = dialog.findViewById(R.id.domain);
        final CheckBox ch = dialog.findViewById(R.id.terms_condition);
        mDilatingDotsProgressBar.showNow();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        dialog_btn_llayout = dialog.findViewById(R.id.dialog_btn_llayout);
        ok_dialog_txt = dialog.findViewById(R.id.ok_dialog_txt);
        cancel_dialog_txt = dialog.findViewById(R.id.cancel_dialog_txt);
        ok_dialog_txt.setOnClickListener(v -> {
            if(ch.isChecked()){
                myWebView.loadUrl(url);
                ch.setVisibility(View.GONE);
            } else {
                ch.setTextColor(ContextCompat.getColor(this, R.color.red));
                Toast.makeText(Policies_web_Browser.this, "Please accept terms and conditions before proceeding.", Toast.LENGTH_SHORT).show();
            }
        });
        cancel_dialog_txt.setOnClickListener(v -> {
            dialog.dismiss();
            finish();
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