package com.universalsompo.meta.metaapp.health.HRALifestyle.APIRequest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Toast;

import com.universalsompo.meta.metaapp.health.HRALifestyle.Utility.NetworkUtility;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Utility.OKHTTPService;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;

public class GetByAccountID extends AsyncTask<String, String, HashMap<String, String>> {
    Context mContext;
    private MySharedPreference pref;
    private ProgressDialog mProgressDialog;

    public GetByAccountID(Context context, ProgressDialog mProgressDialog) {
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
                String strUrl ="https://core.allizhealthtest.in/PHR/api/Person/GetByAccountID";
                JSONObject header = new JSONObject();
                try{
                    Random ran = new Random();
                    String code= String.valueOf((100000 + ran.nextInt(900000)));
                    long date = System.currentTimeMillis();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
                    String dateString = sdf.format(date);
                    header.put("ApplicationCode", "AIH_HRA_PORTAL");
                    header.put("EntityType", "P");
                    header.put("APIAccessToken", "pYu5y07a6eQ=");
                    header.put("AuthTicket", pref.getsessionid());
                    header.put("DateTime", dateString);
                    header.put("RequestID", code);
                    header.put("PartnerCode", "ZOIK");
                } catch (JSONException e){}

                JSONObject JSONData = new JSONObject();
                try{
                    String accountid = pref.getaccid();
                    if(accountid != null && !accountid.isEmpty()){
                        JSONData.put("AccountID", pref.getaccid());
                    } else {
                        JSONData.put("AccountID", "0");
                    }
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
                String json_str1 = json_data.getString("Person");
                JSONObject json_data1 = new JSONObject(json_str1);
                String json_str2 = json_data1.getString("ClusterAssociation");
                JSONArray json_array = new JSONArray(json_str2);
                JSONObject json_data2 = json_array.getJSONObject(0);
                String person_id = json_data2.getString("PersonID");
                pref.setpersonid(person_id);
                StartHRA starthra = new StartHRA(mContext,mProgressDialog);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    starthra.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                } else {
                    starthra.execute();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void requestbuilder() {

    }
}
