package com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.ThankYouPageCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.paymentweb.PaymentWebUrl;
import com.universalsompo.meta.metaapp.health.fragment.earnburn.EarnBurnWebView;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.MyCheckPermission;

public class CKYCWebPage extends AppCompatActivity {
    String manualKYCurl;
    private WebView myWebView;
    Dialog dialog;
    CustomProgressDialog customprogress;;
    ValueCallback<Uri[]> uploadMessage;
    private static final int WRITE_EXTERNAL_STORAGE_RC = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ckycweb_page);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        manualKYCurl = getIntent().getStringExtra("manualKYCurl");
        Log.e("manualKYCurlWebURL",manualKYCurl);

        customprogress = new CustomProgressDialog(CKYCWebPage.this);
        myWebView = findViewById(R.id.mWebView);
//        myWebView.setWebChromeClient(new CKYCWebPage.MyWebViewClient());
//        myWebView.setWebViewClient(new WebViewClient());
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
        myWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        String permission = Manifest.permission.WRITE_EXTERNAL_STORAGE;
        if (ActivityCompat.checkSelfPermission(CKYCWebPage.this, permission)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(CKYCWebPage.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    WRITE_EXTERNAL_STORAGE_RC);
        }
        checkAppPermission();
        myWebView.getSettings().setDefaultTextEncodingName("utf-8");
//        customprogress.showProgressBar();
        myWebView.loadUrl(manualKYCurl);
//        myWebView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                myWebView.loadUrl(url);
//                return true;
//            }
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                customprogress.hideProgressBar();
//                String webUrl=myWebView.getUrl();
//                Log.e("webUrl",webUrl);
//            }
//        });
//        myWebView.setWebChromeClient(new WebChromeClient(){
//            // Need to accept permissions to use the camera
//            @Override
//            public void onPermissionRequest(final PermissionRequest request) {
//                request.grant(request.getResources());
//            }
//        });
    }
    void checkAppPermission() {
        if (MyCheckPermission.checkAppPermission(CKYCWebPage.this, android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
            if (MyCheckPermission.checkAppPermission(CKYCWebPage.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                if (MyCheckPermission.checkAppPermission(CKYCWebPage.this, android.Manifest.permission.CAMERA)) {
                    if (MyCheckPermission.checkAppPermission(CKYCWebPage.this, android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                        if (MyCheckPermission.checkAppPermission(CKYCWebPage.this, android.Manifest.permission.ACCESS_COARSE_LOCATION)) {
                            ActivityCompat.requestPermissions(this,
                                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                        } else {
                            MyCheckPermission.requestPermissionNow(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA, android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION
                            }, RequestConstants.INITIAL_PERMISSION);
                        }
                    } else {
                        MyCheckPermission.requestPermissionNow(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA, android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION
                        }, RequestConstants.INITIAL_PERMISSION);
                    }
                } else {
                    MyCheckPermission.requestPermissionNow(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA, android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION
                    }, RequestConstants.INITIAL_PERMISSION);
                }
            } else {
                MyCheckPermission.requestPermissionNow(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA, android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION
                }, RequestConstants.INITIAL_PERMISSION);
            }
        } else {
            MyCheckPermission.requestPermissionNow(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA, android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            }, RequestConstants.INITIAL_PERMISSION);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == RequestConstants.INITIAL_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    if (grantResults[2] == PackageManager.PERMISSION_GRANTED) {
                        if (grantResults[3] == PackageManager.PERMISSION_GRANTED) {
                            if (grantResults[4] == PackageManager.PERMISSION_GRANTED) {
                            } else {
                                Toast.makeText(CKYCWebPage.this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(CKYCWebPage.this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(CKYCWebPage.this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(CKYCWebPage.this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(CKYCWebPage.this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
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
        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            if (file_permission()) {
                // make sure there is no existing message
                if (uploadMessage != null) {
                    uploadMessage.onReceiveValue(null);
                    uploadMessage = null;
                }
                uploadMessage = filePathCallback;

                Intent fileChooserIntent = getFileChooserIntent();
                startActivityForResult(fileChooserIntent, 100);
                return true;
            } else {
                return false;
            }
        }
    }
    void hide() {
        if(dialog!=null)
            dialog.dismiss();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    private Intent getFileChooserIntent() {
        String[] mimeTypes = {"image/*", "application/pdf"};

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            intent.setType(mimeTypes.length == 1 ? mimeTypes[0] : "*/*");
            if (mimeTypes.length > 0) {
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
            }
        } else {
            String mimeTypesStr = "";
            for (String mimeType : mimeTypes) {
                mimeTypesStr += mimeType + "|";
            }
            intent.setType(mimeTypesStr.substring(0, mimeTypesStr.length() - 1));
        }
        return intent;
    }
    public boolean file_permission() {
        if (Build.VERSION.SDK_INT >= 23 && (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(CKYCWebPage.this,
                    new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            return false;
        } else {
            return true;
        }
    }
}