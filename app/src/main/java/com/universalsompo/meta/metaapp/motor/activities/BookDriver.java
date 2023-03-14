package com.universalsompo.meta.metaapp.motor.activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
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

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.BaseActivity;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.zl.reik.dilatingdotsprogressbar.DilatingDotsProgressBar;

import org.json.JSONObject;

import java.util.Objects;

public class BookDriver extends BaseActivity implements ResponseListener {
    private WebView myWebView;
    Dialog dialog;
    String url,domain,name;
    private LinearLayout dialog_btn_llayout;
    private String vendor_id,veh_type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);*/
        setContentView(R.layout.activity_book_driver);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        LinearLayout cross_icon = findViewById(R.id.cross_icon);
        TextView back_button = findViewById(R.id.back_button);
        TextView title = findViewById(R.id.title);
        title.setText(getIntent().getStringExtra("title"));
        url = getIntent().getStringExtra("URL");
        name = getIntent().getStringExtra("name");
        domain = getIntent().getStringExtra("domain");
        domain = getIntent().getStringExtra("domain");
        vendor_id = getIntent().getStringExtra("VendorId");
        veh_type = getIntent().getStringExtra("VehicleType");

        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back_button.setTypeface(fontAwesomeFont);

        myWebView = findViewById(R.id.mWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.setWebChromeClient(new MyWebViewClient());
        myWebView.getSettings().setBuiltInZoomControls(false);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);

        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                myWebView.loadUrl(url);
                return true;
            }
        });

        customDialoig();
        cross_icon.setOnClickListener(v -> finish());
    }

    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private class MyWebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                hide();
            }
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }
    }

    @SuppressLint("SetTextI18n")
    void customDialoig() {
        dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.custom_loading_layout_for_browser_2);

        DilatingDotsProgressBar mDilatingDotsProgressBar = dialog.findViewById(R.id.progress);
        TextView domain1 = dialog.findViewById(R.id.domain);
        TextView heading1 = dialog.findViewById(R.id.heading1);
        TextView footer_text = dialog.findViewById(R.id.footer_text);
        final CheckBox ch = dialog.findViewById(R.id.terms_condition);
        heading1.setText("You are being redirected to " + name + " site");
        footer_text.setText("Purchases made will be fulfilled by " + name + " and " + name + " is solely responsible for servicing and claims arising out of such transaction.");
        domain1.setText(domain);
        mDilatingDotsProgressBar.showNow();
        dialog.show();

        dialog_btn_llayout = dialog.findViewById(R.id.dialog_btn_llayout);
        TextView ok_dialog_txt = dialog.findViewById(R.id.ok_dialog_txt);
        TextView cancel_dialog_txt = dialog.findViewById(R.id.cancel_dialog_txt);
        ok_dialog_txt.setOnClickListener(v -> {
            if(ch.isChecked()){
                if (veh_type.equalsIgnoreCase("Wellness Center")) {
                    callApi(RequestHealthConstants.SAVE_USERS_WELLNESS_CENTER_DETAIL);
                } else if (veh_type.equalsIgnoreCase("Doctor Consultation")) {
                    callApi(RequestHealthConstants.SAVE_USERS_DOCTOR_CONSULTATION_DETAIL);
                } else if (veh_type.equalsIgnoreCase("Medicine")) {
                    callApi(RequestHealthConstants.SAVE_USERS_MEDICINE_DETAIL);
                } else if (veh_type.equalsIgnoreCase("Lab Test")) {
                    callApi(RequestHealthConstants.SAVE_USERS_LAB_TEST_DETAIL);
                } else if (veh_type.equalsIgnoreCase("Health Packages")) {
                    callApi(RequestHealthConstants.SAVE_USERS_HEALTH_PACKAGES_DETAIL);
                } else if (veh_type.equalsIgnoreCase("Homecare")) {
                } else if (veh_type.equalsIgnoreCase("Baby Chakra")) {
                } else if (veh_type.equalsIgnoreCase("Emotional Wellness")) {
                } else if (veh_type.equalsIgnoreCase("Spiritual Wellness")) {
                } else if (veh_type.equalsIgnoreCase("Healthy Living")) {
                } else if (veh_type.equalsIgnoreCase("Ayush Medicine")) {
                } else if (veh_type.equalsIgnoreCase("Wellness Packages")) {
                } else if (veh_type.equalsIgnoreCase("")) {
                } else {
                    hitAPi(veh_type,vendor_id);
                }

                myWebView.loadUrl(url);
                dialog_btn_llayout.setVisibility(View.GONE);
                ch.setVisibility(View.GONE);
            } else {
                ch.setTextColor(getResources().getColor(R.color.red));
                Toast.makeText(BookDriver.this, "Please accept the terms & conditions before proceeding.", Toast.LENGTH_SHORT).show();
            }
        });

        cancel_dialog_txt.setOnClickListener(v -> {
            dialog.dismiss();
            finish();
        });

        dialog.setOnKeyListener((dialog, keyCode, event) -> {
            dialog.dismiss();
            finish();
            return true;
        });
    }

    void hide() {
        if(dialog!=null)
            dialog.dismiss();
    }

    private void hitAPi(String veh_type,String vendor_id)
    {   JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, MySharedPreference.getInstance(this).getToken_no());
            //******************************************** Get visitor count REQUEST**********************************
            object.put("VendorId", vendor_id);
            object.put("VehicleType", veh_type);
            object.put("Uid", MySharedPreference.getInstance(this).getUID());
            ProjectVolleyRequest req = new ProjectVolleyRequest(this, object, UrlConstants.GET_VISITOR_COUNT, this, RequestConstants.GET_VISITOR_COUNT);
            req.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void callApi(Integer id) {
        if (id == RequestHealthConstants.SAVE_USERS_WELLNESS_CENTER_DETAIL) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH,MySharedPreference.getInstance(this).getToken_no());
                object.put("VendorID", vendor_id);
                object.put("UserID", MySharedPreference.getInstance(this).getUID());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(BookDriver.this, object, UrlHealthConstants.SAVE_USERS_WELLNESS_CENTER_DETAIL, this, RequestHealthConstants.SAVE_USERS_WELLNESS_CENTER_DETAIL);
            req.execute();
        } else if (id == RequestHealthConstants.SAVE_USERS_DOCTOR_CONSULTATION_DETAIL) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(this).getToken_no());
                object.put("VendorID", vendor_id);
                object.put("UserID", MySharedPreference.getInstance(this).getUID());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(BookDriver.this, object, UrlHealthConstants.SAVE_USERS_DOCTOR_CONSULTATION_DETAIL, this, RequestHealthConstants.SAVE_USERS_DOCTOR_CONSULTATION_DETAIL);
            req.execute();
        } else if (id == RequestHealthConstants.SAVE_USERS_MEDICINE_DETAIL) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH,MySharedPreference.getInstance(this).getToken_no());
                object.put("VendorID", vendor_id);
                object.put("UserID", MySharedPreference.getInstance(this).getUID());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(BookDriver.this, object, UrlHealthConstants.SAVE_USERS_MEDICINE_DETAIL, this, RequestHealthConstants.SAVE_USERS_MEDICINE_DETAIL);
            req.execute();
        } else if (id == RequestHealthConstants.SAVE_USERS_LAB_TEST_DETAIL) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH,MySharedPreference.getInstance(this).getToken_no());
                object.put("VendorID", vendor_id);
                object.put("UserID", MySharedPreference.getInstance(this).getUID());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(BookDriver.this, object, UrlHealthConstants.SAVE_USERS_LAB_TEST_DETAIL, this, RequestHealthConstants.SAVE_USERS_LAB_TEST_DETAIL);
            req.execute();
        } else if (id == RequestHealthConstants.SAVE_USERS_HEALTH_PACKAGES_DETAIL) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH,MySharedPreference.getInstance(this).getToken_no());
                object.put("VendorID", vendor_id);
                object.put("UserID", MySharedPreference.getInstance(this).getUID());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(BookDriver.this, object, UrlHealthConstants.SAVE_USERS_HEALTH_PACKAGES_DETAIL, this, RequestHealthConstants.SAVE_USERS_HEALTH_PACKAGES_DETAIL);
            req.execute();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        //******************************************** Get visitor count response**********************************
        if (Tag == RequestConstants.GET_VISITOR_COUNT) {
            LogUtils.showLog("@@@MESSAGE", object.optString("Message"));
        } else if (Tag == RequestHealthConstants.SAVE_USERS_WELLNESS_CENTER_DETAIL) {
            LogUtils.showLog("@@@MESSAGE", object.optString("Message"));
        } else if (Tag == RequestHealthConstants.SAVE_USERS_DOCTOR_CONSULTATION_DETAIL) {
            LogUtils.showLog("@@@MESSAGE", object.optString("Message"));
        } else if (Tag == RequestHealthConstants.SAVE_USERS_MEDICINE_DETAIL) {
            LogUtils.showLog("@@@MESSAGE", object.optString("Message"));
        } else if (Tag == RequestHealthConstants.SAVE_USERS_LAB_TEST_DETAIL) {
            LogUtils.showLog("@@@MESSAGE", object.optString("Message"));
        } else if (Tag == RequestHealthConstants.SAVE_USERS_HEALTH_PACKAGES_DETAIL) {
            LogUtils.showLog("@@@MESSAGE", object.optString("Message"));
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
