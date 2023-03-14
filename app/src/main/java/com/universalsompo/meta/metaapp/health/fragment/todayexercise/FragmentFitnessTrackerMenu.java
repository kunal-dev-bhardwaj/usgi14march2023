package com.universalsompo.meta.metaapp.health.fragment.todayexercise;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.data.DataType;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FragmentFitnessTrackerMenu extends Fragment implements View.OnClickListener {
    private View v;
    private MySharedPreference prefrences;
    private SelectorListener binder;
    private LinearLayout connect_google_fit, connect_fitbit, connect_device_layout, fitbit_connect_layout;
    private static final int REQUEST_OAUTH_REQUEST_CODE = 0x1001;
    private TextView status,fitbit_text;
    String from;
    private TextView token;
    private static final String PACKAGE_NAME = "com.google.android.apps.fitness";
    private static final String PACKAGE_NAME_FITBIT = "com.fitbit.FitbitMobile";

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dialog!=null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    Dialog dialog;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_fitness_tracker_menu, container,false);

        ((MainActivityHealth)getActivity()).show_elevation();
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        prefrences = MySharedPreference.getInstance(getActivity());
        assert getArguments() != null;
        from = getArguments().getString("from");
        init();
        return v;
    }

    void init() {
        connect_google_fit = v.findViewById(R.id.connect_google_fit);
        connect_fitbit = v.findViewById(R.id.connect_fitbit);
        connect_device_layout = v.findViewById(R.id.connect_device_layout);
        fitbit_connect_layout = v.findViewById(R.id.fitbit_connect_layout);
        status = v.findViewById(R.id.status);
        fitbit_text = v.findViewById(R.id.fitbit_text);

        connect_google_fit.setOnClickListener(this);
        connect_fitbit.setOnClickListener(this);
        checkIfLoggedIn();
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    @CheckResult
    public boolean GooglefitInstalled() {
        try {
            getActivity().getPackageManager().getPackageInfo(PACKAGE_NAME, PackageManager.GET_ACTIVITIES);
            connectGoogleFit();
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            GoogleFitErrorDialog();
            return false;
        }
    }

    @CheckResult
    public boolean FitbitInstalled() {
        try {
            getActivity().getPackageManager().getPackageInfo(PACKAGE_NAME_FITBIT, PackageManager.GET_ACTIVITIES);
            FitBitDialog();
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            FitBitErrorDialog();
            return false;
        }
    }

    private void FitBitErrorDialog() {
        final Dialog alert_dialog = new Dialog(getActivity());
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alert_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert_fitbit);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText("Please install fitbit for tracking your fitness activities.");
        alert_heading.setText("Alert!");

        alert_dialog.show();
        ok_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String appPackageName = getActivity().getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + PACKAGE_NAME_FITBIT)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + PACKAGE_NAME_FITBIT)));
                }
                alert_dialog.dismiss();
            }
        });
    }

    private void GoogleFitErrorDialog() {
        final Dialog alert_dialog = new Dialog(getActivity());
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alert_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert_googlefit);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText("Please install google fit for tracking your fitness activities.");
        alert_heading.setText("Alert");

        alert_dialog.show();
        ok_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String appPackageName = getActivity().getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + PACKAGE_NAME)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + PACKAGE_NAME)));
                }
                alert_dialog.dismiss();
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.connect_google_fit:
                if (status.getText().toString().equalsIgnoreCase("Connect")) {
                    if (fitbit_text.getText().toString().equalsIgnoreCase("Connect")) {
                        GooglefitInstalled();
                    } else {
                        disContinueDialog("FitBit");
                    }
                } else {
                    disConnectGoogleFit();
                }
                break;

            case R.id.connect_fitbit:
                if (fitbit_text.getText().toString().equalsIgnoreCase("Connect")) {
                    if (status.getText().toString().equalsIgnoreCase("Connect")) {
                        FitbitInstalled();
                    } else {
                        disContinueDialog("GoogleFit");
                    }
                }else {
                    disConnectFitBit();
                }
                break;

        }
    }
    private void disContinueDialog(final String message){
        final Dialog dialog = new Dialog(getActivity());
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.discontinue_dialog);
        TextView title = dialog.findViewById(R.id.delete_dialog_text);
        title.setText("Are you sure you want to disconnect "+message+"?");
        TextView no = dialog.findViewById(R.id.no_discontinue);
        TextView yes = dialog.findViewById(R.id.yes_discontinue);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (message.equalsIgnoreCase("GoogleFit")) {
                    disConnectGoogleFit();
                    dialog.dismiss();
                    FitBitDialog();
                }else if (message.equalsIgnoreCase("FitBit")){
                    disConnectFitBit();
                    dialog.dismiss();
                    connectGoogleFit();
                }
            }
        });

        dialog.show();
    }

    private void disConnectFitBit(){
        Toast.makeText(getActivity(), "Fitbit Disconnected", Toast.LENGTH_SHORT).show();
        fitbit_connect_layout.setBackground(getResources().getDrawable(R.drawable.rounded_corner_with_colorprimary));
        fitbit_text.setTextColor(getResources().getColor(R.color.lightblack));
        fitbit_text.setText("Connect");
        prefrences.addFitBitUserId(null);
        prefrences.addFitBitToken(null);
        prefrences.addFitBitAccessToken(null);
    }

    private void FitBitDialog() {
        dialog = new Dialog(getActivity(), R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fitbit_login_dialog);
        final WebView myWebView = dialog.findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setBuiltInZoomControls(false);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        myWebView.setWebChromeClient(new WebChromeClient());

        Button ok = dialog.findViewById(R.id.okay);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
                view.loadUrl(url);
                String [] code;
                code = url.split("=");
                String code1 = code[0];
                String code2 = code[1];
                String code3 = code2.substring(0,code2.length()-2);
                prefrences.addFitBitToken(code3);
                callData(code3);
                return true;
            }
        });
        myWebView.loadUrl("https://www.fitbit.com/oauth2/authorize?response_type=code&client_id=22B7TW&redirect_uri=https%3A%2F%2Fwww.google.com%2F&scope=activity&expires_in=604800");
        dialog.show();
    }

    private void callData(final String code3){

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://api.fitbit.com/oauth2/token";
        StringRequest postr = new StringRequest(com.android.volley.Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String acc = jsonObject.getString("access_token");
                    String userid = jsonObject.getString("user_id");
                    prefrences.addFitBitAccessToken(acc);
                    prefrences.addFitBitUserId(userid);

                    fitbit_connect_layout.setBackground(getResources().getDrawable(R.drawable.rounded_counded_with_filled_colorprimary));
                    fitbit_text.setTextColor(getResources().getColor(R.color.white));
                    fitbit_text.setText("Connected");
                    replaceFragment(new FragmentTodayExerciseTab(), FragmentsHealthTags.FRAGMENT_TODAY_EXERCISE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> object = new HashMap<String, String>();
                object.put("clientId", "22B7TW");
                object.put("grant_type",  "authorization_code");
                object.put("redirect_uri",  "https://www.google.com/");
                object.put("code",  prefrences.getFitbitToken());
                Log.e("fitbitcode",prefrences.getFitbitToken());
                return object;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Authorization", "Basic MjJCN1RXOjU5NzdiYTliMDUxNDVhOTI0MGM5MzQ4NjNjNDJjOTg0");
                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded";
            }
        };
        queue.add(postr);
    }

    void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void checkIfLoggedIn() {
        FitnessOptions fitnessOptions = FitnessOptions.builder()
                .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .build();
        if (GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(getActivity()), fitnessOptions)) {
            if (from.equalsIgnoreCase("1")) {
                replaceFragment(new FragmentTodayExerciseTab(), FragmentsHealthTags.FRAGMENT_TODAY_EXERCISE);
            }
            connect_device_layout.setBackground(getResources().getDrawable(R.drawable.rounded_counded_with_filled_colorprimary));
            status.setTextColor(getResources().getColor(R.color.white));
            status.setText("Connected");
        } else if (prefrences.getFibitUserId()!=null){
            fitbit_connect_layout.setBackground(getResources().getDrawable(R.drawable.rounded_counded_with_filled_colorprimary));
            fitbit_text.setTextColor(getResources().getColor(R.color.white));
            fitbit_text.setText("Connected");
        } else {
            connect_device_layout.setBackground(getResources().getDrawable(R.drawable.rounded_corner_with_colorprimary));
            status.setTextColor(getResources().getColor(R.color.lightblack));
            status.setText("Connect");
            fitbit_connect_layout.setBackground(getResources().getDrawable(R.drawable.rounded_corner_with_colorprimary));
            fitbit_text.setTextColor(getResources().getColor(R.color.lightblack));
            fitbit_text.setText("Connect");
        }
    }

    private void disConnectGoogleFit() {
        FitnessOptions fitnessOptions = FitnessOptions.builder()
                .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .build();
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder().addExtension(fitnessOptions).build();
        GoogleSignInClient client = GoogleSignIn.getClient(getActivity(),signInOptions);
        client.revokeAccess();
        connect_device_layout.setBackground(getResources().getDrawable(R.drawable.rounded_corner_with_colorprimary));
        status.setTextColor(getResources().getColor(R.color.lightblack));
        status.setText("Connect");
        Toast.makeText(getActivity(), "GoogleFit Disconnected", Toast.LENGTH_SHORT).show();
    }

    private void connectGoogleFit() {
        FitnessOptions fitnessOptions = FitnessOptions.builder()
                .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .build();
        if (!GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(getActivity()), fitnessOptions)) {
            GoogleSignIn.requestPermissions(
                    this,
                    REQUEST_OAUTH_REQUEST_CODE,
                    GoogleSignIn.getLastSignedInAccount(getActivity()),
                    fitnessOptions);
        } else {

        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_OAUTH_REQUEST_CODE) {
                replaceFragment(new FragmentTodayExerciseTab(), FragmentsHealthTags.FRAGMENT_TODAY_EXERCISE);
            }
        }
    }
}
