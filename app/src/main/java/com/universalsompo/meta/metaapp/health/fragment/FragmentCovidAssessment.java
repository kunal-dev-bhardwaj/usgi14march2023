package com.universalsompo.meta.metaapp.health.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.motor.activities.Commercial_browser;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import java.util.Objects;

public class FragmentCovidAssessment extends Fragment {
    private View v;
    CustomProgressDialog customprogress;
    WebView wyh_hra;
    Dialog dialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_covid_hra, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).showfooter();
        init();

        return v;
    }

    private void init() {

        customprogress = new CustomProgressDialog(getContext());
         wyh_hra = v.findViewById(R.id.wyh_hra);
        String url = "https://www.apollo247.com/covid19/scan/";

        wyh_hra = v.findViewById(R.id.wyh_hra);
        WebSettings webSettings = wyh_hra.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        wyh_hra.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wyh_hra.setWebChromeClient(new FragmentCovidAssessment.MyWebViewClient());
        wyh_hra.getSettings().setBuiltInZoomControls(false);
        wyh_hra.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wyh_hra.getSettings().setLoadWithOverviewMode(true);
        wyh_hra.getSettings().setUseWideViewPort(true);
        wyh_hra.getSettings().setPluginState(WebSettings.PluginState.ON);
        customprogress.showProgressBar();
        wyh_hra.loadUrl(url);

        wyh_hra.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                wyh_hra.loadUrl(url);
                return true;
            }
        });

//        WebSettings webSettings = wyh_hra.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        wyh_hra.setWebChromeClient(new MyWebViewClient());
//        wyh_hra.setWebViewClient(new WebViewClient());
//        wyh_hra.getSettings().setBuiltInZoomControls(true);
//        wyh_hra.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//
//        wyh_hra.loadUrl(url);
//
//        wyh_hra.setWebViewClient(new WebViewClient()
//        {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url)
//            {
//                //do whatever you want with url
//                return super.shouldOverrideUrlLoading(view, url);
//            }
//        });
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
