package com.universalsompo.meta.metaapp.motor.activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
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
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.zl.reik.dilatingdotsprogressbar.DilatingDotsProgressBar;

import org.json.JSONObject;

import java.util.Objects;

public class PolicyInBrowser extends BaseActivity implements ResponseListener {
    private String PolicyUrl;
    private WebView myWebView;
    private String fragmnetTag = "";
    private TextView ok_dialog_txt;
    private TextView cancel_dialog_txt;
    private LinearLayout dialog_btn_llayout;
    private String veh_type ,vendor_id, type;
    Dialog dialog;
    private MySharedPreference pref;
    CustomProgressDialog customprogress;
    @SuppressLint({"SetTextI18n", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.policy_in_browser);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);*/
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(this);
        String policyNo = getIntent().getStringExtra("PolicyNo");
        PolicyUrl = getIntent().getStringExtra("Url");
        fragmnetTag = getIntent().getStringExtra("fargmentTag");
        String isFromPdfFull = getIntent().getStringExtra("ISFROMPDFFULL");
        veh_type = getIntent().getStringExtra("VehicleType");
        vendor_id = getIntent().getStringExtra("vendor_id");
        type = getIntent().getStringExtra("type");
        TextView policy_no_text = findViewById(R.id.policy_no_text);
        customprogress = new CustomProgressDialog(PolicyInBrowser.this);
        LinearLayout cross_icon = findViewById(R.id.cross_icon);

        TextView back_button = findViewById(R.id.back_button);
        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back_button.setTypeface(fontAwesomeFont);

        myWebView = findViewById(R.id.mWebView);
        myWebView.setWebChromeClient(new MyWebViewClient());
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        if (!policyNo.equals("")) {
            policy_no_text.setText("Renew- " + policyNo);
        }

        if (isFromPdfFull.equals("PDFFull")) {
            policy_no_text.setText(policyNo);
        } else {
            if (fragmnetTag != null && !fragmnetTag.isEmpty() && fragmnetTag.equals("RSA")) {
                policy_no_text.setText("crossroadshelpline");
            } else if (fragmnetTag.equalsIgnoreCase("Buy Policy")) {
                policy_no_text.setText("Buy Policy");
            } else if (fragmnetTag.equalsIgnoreCase("Renew Policy")) {
                policy_no_text.setText("Renew Policy");
            } else {
                policy_no_text.setText(getDoamin(PolicyUrl).split("\\.")[0]);
            }
        }
        myWebView.getSettings().setJavaScriptEnabled(true);
        if (isFromPdfFull.equals("PDFFull")) {
            PDFCustomDialoig();
        } else {
            customprogress.showProgressBar();
            myWebView.loadUrl(PolicyUrl);
            if(veh_type!=null)
                hitAPi(veh_type,vendor_id);
//            customDialoig();
        }

        cross_icon.setOnClickListener(v -> onBackPressed());

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.d("WebView", "your current url when webpage loading.." + url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if (!type.equalsIgnoreCase("")) {
                    Uri uri = Uri.parse(url);
                    String CustomerId = uri.getQueryParameter("CustomerId");
                    String Status = uri.getQueryParameter("Status");

                    if (CustomerId != null && Status != null) {
                        pref.setCustID(CustomerId);
                        if (type.equalsIgnoreCase("Private Car") || type.equalsIgnoreCase("Two Wheeler")) {
                            hitapi(RequestConstants.UPDATE_CUSTOMER_ID, CustomerId, Status);
                        } else {
                            hitapi(RequestHealthConstants.UPDATE_CUSTOMER_ID, CustomerId, Status);
                        }
                    }
                    Log.d("WebView", "your current url when webpage loading.. finish" + url + " " + CustomerId + " " + Status);
                }
                super.onPageFinished(view, url);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                // TODO Auto-generated method stub
                super.onLoadResource(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
            hide();
        } else {
            if (fragmnetTag != null && !fragmnetTag.isEmpty()) {
                if(fragmnetTag.equals("RSA")) {
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                }
                hide();
                finish();
            } else
                super.onBackPressed();
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.GET_VISITOR_COUNT) {
            LogUtils.showLog("@@@MESSAGE", object.optString("Message"));
        } else if (Tag == RequestHealthConstants.UPDATE_CUSTOMER_ID) {
            if (object.optString("Message").equals("Success")) {
                final Dialog alert_dialog = new Dialog(this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.custom_success_policy_issue);
                TextView ok_txt, alert_heading, alert_msg;
                ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
                alert_heading = alert_dialog.findViewById(R.id.alert_heading);
                alert_msg = alert_dialog.findViewById(R.id.alert_msg);
                alert_msg.setText("Payment done successfully. Go to My Policy section in the app to download policy document.");
                alert_heading.setText("Success");

                alert_dialog.show();
                ok_txt.setOnClickListener(v -> {
                    alert_dialog.dismiss();
                    finish();
                });
            } else {
                final Dialog alert_dialog = new Dialog(this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.custom_alert_policy_issue);
                TextView ok_txt, alert_heading, alert_msg;
                ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
                alert_heading = alert_dialog.findViewById(R.id.alert_heading);
                alert_msg = alert_dialog.findViewById(R.id.alert_msg);
                alert_msg.setText("We are sorry to inform you that your transaction has failed. Please contact universal sompo customer support for more details.");
                alert_heading.setText("Error!!!");

                alert_dialog.show();
                ok_txt.setOnClickListener(v -> {
                    alert_dialog.dismiss();
                    finish();
                });
            }
        } else if (Tag == RequestConstants.UPDATE_CUSTOMER_ID) {
            if (object.optString("Message").equals("Success")) {
                final Dialog alert_dialog = new Dialog(this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.custom_success_policy_issue);
                TextView ok_txt, alert_heading, alert_msg;
                ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
                alert_heading = alert_dialog.findViewById(R.id.alert_heading);
                alert_msg = alert_dialog.findViewById(R.id.alert_msg);
                alert_msg.setText("Payment done successfully. Go to My Policy section in the app to download policy document.");
                alert_heading.setText("Success");

                alert_dialog.show();
                ok_txt.setOnClickListener(v -> {
                    alert_dialog.dismiss();
                    finish();
                });
            } else {
                final Dialog alert_dialog = new Dialog(this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.custom_alert_policy_issue);
                TextView ok_txt, alert_heading, alert_msg;
                ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
                alert_heading = alert_dialog.findViewById(R.id.alert_heading);
                alert_msg = alert_dialog.findViewById(R.id.alert_msg);
                alert_msg.setText("We are sorry to inform you that your transaction has failed. Please contact universal sompo customer support for more details.");
                alert_heading.setText("Error!!!");

                alert_dialog.show();
                ok_txt.setOnClickListener(v -> {
                    alert_dialog.dismiss();
                    finish();
                });
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }


    private class MyWebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
//                if(dialog.isShowing())
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


    void PDFCustomDialoig() {
        dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.pdf_custome_dialog);
        dialog.show();

        dialog_btn_llayout = dialog.findViewById(R.id.dialog_btn_llayout);
        ok_dialog_txt = dialog.findViewById(R.id.ok_dialog_txt);
        cancel_dialog_txt = dialog.findViewById(R.id.cancel_dialog_txt);
        ok_dialog_txt.setOnClickListener(v -> {
            myWebView.loadUrl(PolicyUrl);
            dialog_btn_llayout.setVisibility(View.GONE);
        });
        cancel_dialog_txt.setOnClickListener(v -> {
            dialog.dismiss();
            finish();
        });

        dialog.setOnKeyListener((dialog, keyCode, event) -> {
            if(fragmnetTag!= null) {
                if (fragmnetTag.equals("RSA"))
                    onBackPressed();
                else
                    finish();
            }else finish();
            return true;
        });

    }


//    void customDialoig() {
//        dialog = new Dialog(this);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.setCancelable(true);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        dialog.setContentView(R.layout.custom_loading_layout_for_browser);
//
//        DilatingDotsProgressBar mDilatingDotsProgressBar = dialog.findViewById(R.id.progress);
//        TextView domain = dialog.findViewById(R.id.domain);
//        final CheckBox ch = dialog.findViewById(R.id.terms_condition);
//        domain.setText(getDoamin(PolicyUrl));
//        mDilatingDotsProgressBar.showNow();
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.show();
//
//        dialog_btn_llayout = dialog.findViewById(R.id.dialog_btn_llayout);
//        ok_dialog_txt = dialog.findViewById(R.id.ok_dialog_txt);
//        cancel_dialog_txt = dialog.findViewById(R.id.cancel_dialog_txt);
//        ok_dialog_txt.setOnClickListener(v -> {
//            if(ch.isChecked()){
//                myWebView.loadUrl(PolicyUrl);
//                if(veh_type!=null)
//                    hitAPi(veh_type,vendor_id);
//                dialog_btn_llayout.setVisibility(View.GONE);
//                ch.setVisibility(View.GONE);
//            } else {
//                ch.setTextColor(ContextCompat.getColor(this, R.color.red));
//                Toast.makeText(PolicyInBrowser.this, "Please accept terms and conditions before proceeding.", Toast.LENGTH_SHORT).show();
//            }
//        });
//        cancel_dialog_txt.setOnClickListener(v -> {
//            dialog.dismiss();
//            finish();
//        });
//        dialog.setOnKeyListener((dialog, keyCode, event) -> {
//            if(fragmnetTag!= null) {
//                if (fragmnetTag.equals("RSA"))
//                    onBackPressed();
//                else
//                    finish();
//            }else
//                finish();
//            return true;
//        });
//    }

    void hide() {
        try {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String getDoamin(String url) {
        String urlWithoutWWW;
        if (url.contains("www")) {
            urlWithoutWWW = url.split("www.")[1];
        } else if (url.contains("http") || url.contains("https")) {
            urlWithoutWWW = url.split("://")[1];
        } else
            urlWithoutWWW = url;
        String[] finalDomain = urlWithoutWWW.split("/", 0);
        return finalDomain[0];
    }


    private void hitAPi(String veh_type,String vendor_id) {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, MySharedPreference.getInstance(this).getToken_no());
            object.put("VendorId", vendor_id);
            object.put("VehicleType", veh_type);
            object.put("Uid", MySharedPreference.getInstance(this).getUID());
            ProjectVolleyRequest req = new ProjectVolleyRequest(this, object, UrlConstants.GET_VISITOR_COUNT, this, RequestConstants.GET_VISITOR_COUNT);
            req.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void hitapi(Integer id, String custid, String status) {
        JSONObject object = new JSONObject();
        if (id == RequestHealthConstants.UPDATE_CUSTOMER_ID) {
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("Userid", pref.getUID());
                object.put("ClientUserId", custid);
                object.put("Payment_result", status);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(this, object, UrlHealthConstants.UPDATE_CUSTOMER_ID, this, RequestHealthConstants.UPDATE_CUSTOMER_ID);
            req.execute();
        } else {
            try {
                object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
                object.put("Userid", pref.getUID());
                object.put("ClientUserId", custid);
                object.put("Payment_result", status);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(this, object, UrlConstants.UPDATE_CUSTOMER_ID, this, RequestConstants.UPDATE_CUSTOMER_ID);
            req.execute();
        }
    }
}
