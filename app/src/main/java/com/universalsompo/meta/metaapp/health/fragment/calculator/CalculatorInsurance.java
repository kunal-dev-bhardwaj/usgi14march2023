package com.universalsompo.meta.metaapp.health.fragment.calculator;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.paymentmotor.MotorPayemntWebURl;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

public class CalculatorInsurance extends Fragment {
    WebView myWebView;
    Dialog dialog;
    CustomProgressDialog customprogress;
    String PolicyURL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_calculator_insurance, container, false);
        myWebView=view.findViewById(R.id.webView);
        customprogress = new CustomProgressDialog(getContext());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.setWebChromeClient(new CalculatorInsurance.MyWebViewClient());
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setAllowFileAccess(true);
        myWebView.getSettings().setSupportMultipleWindows(true);
        myWebView.getSettings().setAllowContentAccess(true);
        myWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        myWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);

        PolicyURL = "https://www.universalsompo.com/CompleteHealthCare/";
        Log.e("PolicyURL",PolicyURL);

        customprogress.showProgressBar();
        myWebView.loadUrl(PolicyURL);
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                myWebView.loadUrl(url);
                return true;
            }
        });
        return view;
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