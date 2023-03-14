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

public class AddingPersonToPHR extends AsyncTask<String, String, HashMap<String, String>> {
    Context mContext;
    private MySharedPreference pref;
    private ProgressDialog mProgressDialog;

    public AddingPersonToPHR(Context context, ProgressDialog mProgressDialog) {
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
                String strUrl ="https://core.allizhealthtest.in/PHR/api/Person/Add";
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

                JSONObject Address = new JSONObject();
                try{
                    Address.put("CityID", 0);
                    Address.put("StateID", 0);
                    Address.put("CountryID", 0);
                } catch (JSONException e){}

                JSONObject Contact = new JSONObject();
                try{
                    Contact.put("EmailAddress", "");
                    Contact.put("PrimaryContactNo", "");
                    Contact.put("DialingCode", "");
                } catch (JSONException e){}

                JSONArray jsonArray = new JSONArray();
                JSONObject clusterass = new JSONObject();
                try {
                    long date1 = System.currentTimeMillis();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
                    String dateString1 = sdf.format(date1);
                    clusterass.put("PersonID", 0);
                    String firstWord = pref.getUserName();
                    if(firstWord.contains(" ")){
                        firstWord= firstWord.substring(0, firstWord.indexOf(" "));
                        clusterass.put("ClusterAssociationNo", "ZOIK_" + firstWord + pref.getEmpid() +pref.getUID());
                        clusterass.put("ClusterRegistrationNo", "ZOIK_" + firstWord + pref.getEmpid() +pref.getUID());
                    }
                    clusterass.put("PartnerCode", "ZOIK");
                    clusterass.put("RegistrationDate", dateString1);
                    clusterass.put("ExpiryDate", dateString1);
                    clusterass.put("IsActive", true);
                    clusterass.put("ID", 0);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                jsonArray.put(clusterass);

                JSONObject Person = new JSONObject();
                try{
                    Person.put("AccountID", pref.getaccid());
                    Person.put("FirstName", pref.getUserName());
                    Person.put("LastName", "");
                    /*String dob = pref.getDOB();
                    String[] dob_split = dob.split("/");
                    String part1 = dob_split[0];
                    String part2 = getmonth(dob_split[1]);
                    String part3 = dob_split[2];*/
                    Person.put("DateOfBirth", pref.getDOB());
                    if (pref.getgender().equalsIgnoreCase("Male")) {
                        Person.put("Gender", 0);
                    } else {
                        Person.put("Gender", 1);
                    }
                    Person.put("MaritalStatus", 0);
                    Person.put("NumberOfKids", 0);
                    Person.put("IsActive", true);
                    Person.put("Age", 0);
                    Person.put("Address", Address);
                    Person.put("Contact", Contact);
                    Person.put("ClusterAssociation", jsonArray);
                    Person.put("ID", 0);
                } catch (JSONException e){}

                JSONObject JSONData = new JSONObject();
                try{
                    JSONData.put("Person", Person);
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
                Login login_person = new Login(mContext,mProgressDialog);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    login_person.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                } else {
                    login_person.execute();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getmonth(String s) {
        String s1 = null;
        if(s.equalsIgnoreCase("1")) {
            s1 = "Jan";
        } else if (s.equalsIgnoreCase("2")) {
            s1 = "Feb";
        } else if (s.equalsIgnoreCase("3")) {
            s1 = "Mar";
        } else if (s.equalsIgnoreCase("4")) {
            s1 = "Apr";
        } else if (s.equalsIgnoreCase("5")) {
            s1 = "May";
        } else if (s.equalsIgnoreCase("6")) {
            s1 = "Jun";
        } else if (s.equalsIgnoreCase("7")) {
            s1 = "Jul";
        } else if (s.equalsIgnoreCase("8")) {
            s1 = "Aug";
        } else if (s.equalsIgnoreCase("9")) {
            s1 = "Sep";
        } else if (s.equalsIgnoreCase("10")) {
            s1 = "Oct";
        } else if (s.equalsIgnoreCase("11")) {
            s1 = "Nov";
        } else if (s.equalsIgnoreCase("12")) {
            s1 = "Dec";
        }
        return s1;
    }
}
