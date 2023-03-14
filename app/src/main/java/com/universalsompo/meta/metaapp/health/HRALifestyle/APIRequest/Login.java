package com.universalsompo.meta.metaapp.health.HRALifestyle.APIRequest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Toast;

import com.universalsompo.meta.metaapp.health.HRALifestyle.Utility.NetworkUtility;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Utility.OKHTTPService;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;

public class Login extends AsyncTask<String, String, HashMap<String, String>> {
    Context mContext;
    private MySharedPreference pref;
    private ProgressDialog mProgressDialog;

    public Login(Context context, ProgressDialog mProgressDialog) {
        this.mContext = context;
        this.mProgressDialog = mProgressDialog;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (NetworkUtility.isOnline(mContext)) {
//            mProgressDialog = new ProgressDialog(mContext);
//            mProgressDialog.setMessage("Loading...");
//            mProgressDialog.setCancelable(false);
//            mProgressDialog.setCanceledOnTouchOutside(false);
//            mProgressDialog.show();
        } else {
            Toast.makeText(mContext, "Not connected to Internet", Toast.LENGTH_SHORT).show();
            cancel(true);
        }
    }

    @Override
    protected HashMap<String, String> doInBackground(String... params) {
        HashMap<String, String> hashMap=null;
        if (!isCancelled()) {
            try {
                pref = MySharedPreference.getInstance(mContext);
                String strUrl ="https://core.allizhealthtest.in/Security/api/Security/Login";
                JSONObject header = new JSONObject();
                try{
                    Random ran = new Random();
                    String code= String.valueOf((100000 + ran.nextInt(900000)));
                    long date = System.currentTimeMillis();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
                    String dateString = sdf.format(date);
                    header.put("RequestID", code);
                    header.put("APIAccessToken", "pYu5y07a6eQ=");
                    header.put("DateTime", dateString);
                    header.put("AuthTicket", "");
                    header.put("PartnerCode", "ZOIK");
                    header.put("ApplicationCode", "AIH_HRA_PORTAL");
                    header.put("EntityType", "P");
                } catch (JSONException e){}

                JSONObject Credentials = new JSONObject();
                try{
                    String firstWord = pref.getUserName();
                    if(firstWord.contains(" ")){
                        firstWord= firstWord.substring(0, firstWord.indexOf(" "));
                        Credentials.put("LoginName", "ZOIK_" + firstWord + pref.getEmpid() + pref.getUID());
                        Credentials.put("Password", "ZOIK_" + firstWord + pref.getEmpid() + pref.getUID());
                    }
                    Credentials.put("AuthenticationProvider", 0);
                    Credentials.put("LoginMode", 0);
                    Credentials.put("PartnerCode", "ZOIK");
                } catch (JSONException e){}

                JSONObject JSONData = new JSONObject();
                try{
                    JSONData.put("Message", "Login to Account");
                    JSONData.put("Credentials", Credentials);
                    JSONData.put("from",0);
                } catch (JSONException e){}

                JSONObject request = new JSONObject();
                try {
                    request.put("Header", header);
                    request.put("JSONData", JSONData.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                final String requestStr = request.toString();
                hashMap = OKHTTPService.requestACallToServer(strUrl,requestStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    @Override
    protected void onPostExecute(HashMap<String, String> resultMap) {
        super.onPostExecute(resultMap);
        try {
//            if (mProgressDialog != null && mProgressDialog.isShowing() == true) {
//                mProgressDialog.dismiss();
//            }
            if(resultMap!=null && resultMap.size()>0){
                JSONObject json_response = new JSONObject(resultMap.get(OKHTTPService.mStrResponseJson));
                System.out.println(json_response);
                String json_str = json_response.getString("JSONData");
                JSONObject json_data = new JSONObject(json_str);
                String json_str1 = json_data.getString("Context");
                String json_str2 = json_data.getString("A");
                pref.setsessionid(json_str1);
                pref.setaccid(json_str2);
                GetByAccountID getbyaccid = new GetByAccountID(mContext,mProgressDialog);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    getbyaccid.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                } else {
                    getbyaccid.execute();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
