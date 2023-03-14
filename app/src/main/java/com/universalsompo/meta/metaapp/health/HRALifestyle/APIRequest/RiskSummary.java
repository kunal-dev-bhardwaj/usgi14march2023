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
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class RiskSummary extends AsyncTask<String, String, HashMap<String, String>> {
    Context mContext;
    private MySharedPreference pref;
    private ProgressDialog mProgressDialog;
    String risk_summary_response;
    private String HeartRisk, DiabetesRisk, StrokeRisk, JobStress, EmotionalHealth;
    private float random1, random2, random3, random4, random5;

    public RiskSummary(Context context, ProgressDialog mProgressDialog) {
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
                String strUrl ="https://core.allizhealthtest.in/PHR/api/MedicalProfile/ListRiskSummary";
                JSONObject header = new JSONObject();
                try{
                    Random ran = new Random();
                    String code= String.valueOf((100000 + ran.nextInt(900000)));
                    long date = System.currentTimeMillis();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
                    String dateString = sdf.format(date);
                    header.put("RequestID", code);
                    header.put("DateTime", dateString);
                    header.put("APIAccessToken", "pYu5y07a6eQ=");
                    header.put("AuthTicket", pref.getsessionid());
                    header.put("ApplicationCode", "AIH_HRA_PORTAL");
                    header.put("PartnerCode", "ZOIK");
                    header.put("EntityType", "P");
                } catch (JSONException e){}

                JSONObject JSONData = new JSONObject();
                try{
                    JSONData.put("PersonID", pref.getpersonid());
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
                json_str = json_str.replaceAll("\\r\\n", "");
                risk_summary_response = json_str;

                pref.setLiferisksummaryjsondata(risk_summary_response);

                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
                final String currentDate = sdf.format(new Date());

                JSONObject jsonObject = new JSONObject(json_str);
                JSONObject jsonObject1 = jsonObject.getJSONObject("RiskSummaryProfile");
                JSONArray jsonArray = jsonObject1.getJSONArray("Records");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jorecords = jsonArray.getJSONObject(i);
                    String Code = jorecords.getString("Code");
                    JSONObject jAriskhistory = jorecords.getJSONObject("RiskHistory");

                    String Risk = jAriskhistory.getString(currentDate);

                    if (Code.equals("HRT")) {
                        HeartRisk = Risk;
                        if (Risk.equals("No Risk")) {
                            random1 = 1;
                        } else if (Risk.equals("Low")) {
                            random1 = 2;
                        } else if (Risk.equals("High")) {
                            random1 = 4;
                        } else if (Risk.equals("Moderate")) {
                            random1 = 3;
                        } else {
                            random1 = 5;
                        }
                    } else if (Code.equals("DIA")) {
                        DiabetesRisk = Risk;
                        if (Risk.equals("No Risk")) {
                            random2 = 1;
                        } else if (Risk.equals("Low")) {
                            random2 = 2;
                        } else if (Risk.equals("High")) {
                            random2 = 4;
                        } else if (Risk.equals("Moderate")) {
                            random2 = 3;
                        } else {
                            random2 = 5;
                        }
                    } else if (Code.equals("STR")) {
                        StrokeRisk = Risk;
                        if (Risk.equals("No Risk")) {
                            random3 = 1;
                        } else if (Risk.equals("Low")) {
                            random3 = 2;
                        } else if (Risk.equals("High")) {
                            random3 = 4;
                        } else if (Risk.equals("Moderate")) {
                            random3 = 3;
                        } else {
                            random3 = 5;
                        }
                    } else if (Code.equals("JOB")) {
                        JobStress = Risk;
                        if (Risk.equals("No Risk")) {
                            random4 = 1;
                        } else if (Risk.equals("Low")) {
                            random4 = 2;
                        } else if (Risk.equals("High")) {
                            random4 = 4;
                        } else if (Risk.equals("Moderate")) {
                            random4 = 3;
                        } else {
                            random4 = 5;
                        }
                    } else if (Code.equals("EMO")) {
                        EmotionalHealth = Risk;
                        if (Risk.equals("No Risk")) {
                            random5 = 1;
                        } else if (Risk.equals("Low")) {
                            random5 = 2;
                        } else if (Risk.equals("High")) {
                            random5 = 4;
                        } else if (Risk.equals("Moderate")) {
                            random5 = 3;
                        } else {
                            random5 = 5;
                        }
                    }
                }

                pref.setLifeheartrisk(HeartRisk);
                pref.setLifediabetesrisk(DiabetesRisk);
                pref.setLifestrokerisk(StrokeRisk);
                pref.setLifejobstress(JobStress);
                pref.setLifeemotionalhealth(EmotionalHealth);

                pref.setLiferandom1(String.valueOf(random1));
                pref.setLiferandom2(String.valueOf(random2));
                pref.setLiferandom3(String.valueOf(random3));
                pref.setLiferandom4(String.valueOf(random4));
                pref.setLiferandom5(String.valueOf(random5));

                GetCurrent get_current = new GetCurrent(mContext,mProgressDialog);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    get_current.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                } else {
                    get_current.execute();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
