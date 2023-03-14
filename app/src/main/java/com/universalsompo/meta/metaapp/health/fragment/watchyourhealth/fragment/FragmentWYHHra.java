package com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.fragment;

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

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FragmentWYHHra extends Fragment {
    private View v;
    private String policy_no;
    private String mem_id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_wyh_hra, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).hidefooter();
        /*assert getArguments() != null;
        policy_no = getArguments().getString("PolicyNo");
        mem_id = getArguments().getString("MemberID");*/
        policy_no = "2841/61176505/00/000";
        mem_id = "101234939211";
        init();
        return v;
    }

    private void init() {
        WebView wyh_hra = v.findViewById(R.id.wyh_hra);

        byte[] data;
        byte[] data1;
        data = policy_no.getBytes(StandardCharsets.UTF_8);
        data1 = mem_id.getBytes(StandardCharsets.UTF_8);
        String policy_no1 = android.util.Base64.encodeToString(data, android.util.Base64.DEFAULT);
        String mem_id1 = android.util.Base64.encodeToString(data1, android.util.Base64.DEFAULT);
        String url = "http://wyh.universalsompo.in/chatbot/assessment/hraquestionnairev2?policyno=" + policy_no1 + "&memberid=" + mem_id1;

        WebSettings webSettings = wyh_hra.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wyh_hra.setWebChromeClient(new MyWebViewClient());
        wyh_hra.setWebViewClient(new WebViewClient());
        wyh_hra.getSettings().setBuiltInZoomControls(true);
        wyh_hra.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        wyh_hra.loadUrl(url);

        wyh_hra.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                //do whatever you want with url
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    private class MyWebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }
    }
}
