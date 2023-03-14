package com.universalsompo.meta.metaapp.health.HRALifestyle.APIRequest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Toast;

import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.Model.LifestyleHRAModel;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Utility.NetworkUtility;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Utility.OKHTTPService;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class SaveHRA extends AsyncTask<String, String, HashMap<String, String>> {
    Context mContext;
    private MySharedPreference pref;
    private ProgressDialog mProgressDialog;
    LifestyleHRADatabaseHelper db;
    private List<LifestyleHRAModel> reportedfamilyList;
    private List<LifestyleHRAModel> reporteduserList;
    boolean savewhr, savebp;
    String save_sys, save_dia;
    String familyhis = "", user_bp, user_alcohol, user_cig, genhis = "", user_fruits, user_fried, user_work_bal, user_job_offer, user_laptop, user_work_shift, user_exercise, user_sleep, user_life, user_stress, user_social, gen_health, user_his;
    String FullDate;

    public SaveHRA(Context context) {
        this.mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (NetworkUtility.isOnline(mContext)) {
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.setMessage("Please wait while we generate your wellness score");
            mProgressDialog.setCancelable(false);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.show();
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
                db = new LifestyleHRADatabaseHelper(mContext);
                String strUrl ="https://core.allizhealthtest.in/PHR/api/PrimaryHRA/SaveHRA";
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
                    header.put("PartnerCode", "ZOIK");
                    header.put("ApplicationCode", "AIH_HRA_PORTAL");
                    header.put("EntityType", "P");
                } catch (JSONException e){}


                /* Response builder */

                String json_data = responsebuilder();

                JSONObject request = new JSONObject();
                try {
                    request.put("Header", header);
                    request.put("JSONData", json_data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                final String requestStr = request.toString();
                System.out.println("Request sent : " + requestStr);
                hashMap = OKHTTPService.requestACallToServer(strUrl,requestStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    private String responsebuilder() {

        /* Vitals */
        double height = Double.parseDouble(db.getLifestyleCol3Value(pref.getUID(), "FragmentBMI"));
        String height_d = String.format("%.2f", height);
        String weight = db.getLifestyleCol4Value(pref.getUID(), "FragmentBMI");
        double bmi = Double.parseDouble(db.getLifestyleCol5Value(pref.getUID(), "FragmentBMI"));
        String bmi_d = String.format("%.2f", bmi);
        String waist = db.getLifestyleCol1Value(pref.getUID(), "FragmentWHR");
        String hip = db.getLifestyleCol2Value(pref.getUID(), "FragmentWHR");
        savewhr = !waist.equalsIgnoreCase("0") || !hip.equalsIgnoreCase("0");
        String sys = db.getLifestyleCol1Value(pref.getUID(), "FragmentBP");
        String dia = db.getLifestyleCol2Value(pref.getUID(), "FragmentBP");
        if (sys.equalsIgnoreCase("0")) {
            save_sys = "";
        } else {
            save_sys = sys;
        }

        if (dia.equalsIgnoreCase("0")) {
            save_dia = "";
        } else {
            save_dia = dia;
        }

        savebp = !sys.equalsIgnoreCase("0") || !dia.equalsIgnoreCase("0");

        JSONObject vitals_Obj = new JSONObject();
        try {
            vitals_Obj.put("R", "SETVITALS");
            vitals_Obj.put("Height", height_d);
            vitals_Obj.put("Weight", weight);
            vitals_Obj.put("BMI", bmi_d);
            vitals_Obj.put("SystolicBP", save_sys);
            vitals_Obj.put("DiastolicBP", save_dia);
            vitals_Obj.put("SaveBMI", true);
            vitals_Obj.put("SaveWHR", savewhr);
            vitals_Obj.put("SaveBP", savebp);
            vitals_Obj.put("Mode", "SAVE");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /* Blood Pressure */
        String bp_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentBP");
        String bp_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentBP");
        String bp_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentBP");

        user_bp = bp_ans_code + "," + bp_ques_code + "," + "0" + "," + bp_cat + "|";

        /* Alcohol */
        String alc_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentAlcohol");
        String alc_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentAlcohol");
        String alc_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentAlcohol");

        user_alcohol = alc_ans_code + "," + alc_ques_code + "," + "0" + "," + alc_cat + "|";

        /* Cigarettes */
        String cig_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentCigarettes");
        String cig_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentCigarettes");
        String cig_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentCigarettes");

        user_cig = cig_ans_code + "," + cig_ques_code + "," + "0" + "," + cig_cat + "|";

        /* Family Health */
        reportedfamilyList = new ArrayList<>();
        reportedfamilyList.addAll(db.getAllFamilyHist(pref.getUID(), pref.getsessionid(), "FragmentFamilyHealth"));
        JSONArray jsonArray = new JSONArray();
        for (LifestyleHRAModel cn : reportedfamilyList) {
            JSONObject famhis = new JSONObject();
            if (cn.getYesno().equalsIgnoreCase("yes") && !cn.getCol1().equalsIgnoreCase("Other")) {
                familyhis = familyhis + cn.getAnswercode() + "," + cn.getQuestioncode() + "," + "0" + "," + cn.getCategory() + "|";
                System.out.println("Forward array" + familyhis);
            }
        }

        /* User Disease */
        reporteduserList = new ArrayList<>();
        reporteduserList.addAll(db.getAllUserHist(pref.getUID(), pref.getsessionid(), "FragmentGeneralHealth"));
        JSONArray jsonArray1 = new JSONArray();
        for (LifestyleHRAModel cn : reporteduserList) {
            JSONObject userhis = new JSONObject();
            if (cn.getYesno().equalsIgnoreCase("yes")) {
                genhis = genhis + cn.getAnswercode() + "," + cn.getQuestioncode() + "," + "0" + "," + cn.getCategory() + "|";
                System.out.println("Forward array" + familyhis);
            }
        }


        /* Fruits */
        String fruit_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentFruitServing");
        String fruit_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentFruitServing");
        String fruit_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentFruitServing");

        user_fruits = fruit_ans_code + "," + fruit_ques_code + "," + "0" + "," + fruit_cat + "|";

        /* Fried */
        String fried_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentFriedFood");
        String fried_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentFriedFood");
        String fried_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentFriedFood");

        user_fried = fried_ans_code + "," + fried_ques_code + "," + "0" + "," + fried_cat + "|";

        /* Work Balance */
        String work_bal_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentWorkBalance");
        String work_bal_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentWorkBalance");
        String work_bal_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentWorkBalance");

        user_work_bal = work_bal_ans_code + "," + work_bal_ques_code + "," + "0" + "," + work_bal_cat + "|";

        /* Job Offering */
        String job_offer_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentWorking");
        String job_offer_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentWorking");
        String job_offer_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentWorking");

        user_job_offer = job_offer_ans_code + "," + job_offer_ques_code + "," + "0" + "," + job_offer_cat + "|";

        /* Laptop */
        String lap_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentLaptopWorking");
        String lap_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentLaptopWorking");
        String lap_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentLaptopWorking");

        user_laptop = lap_ans_code + "," + lap_ques_code + "," + "0" + "," + lap_cat + "|";

        /* Work Shifts */
        String work_shift_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentWorkShift");
        String work_shift_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentWorkShift");
        String work_shift_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentWorkShift");

        user_work_shift = work_shift_ans_code + "," + work_shift_ques_code + "," + "0" + "," + work_shift_cat + "|";

        /* Exercise */
        String exe_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentExercise");
        String exe_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentExercise");
        String exe_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentExercise");

        user_exercise = exe_ans_code + "," + exe_ques_code + "," + "0" + "," + exe_cat + "|";

        /* Sound Sleep */
        String sleep_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentSleep");
        String sleep_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentSleep");
        String sleep_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentSleep");

        user_sleep = sleep_ans_code + "," + sleep_ques_code + "," + "0" + "," + sleep_cat + "|";

        /* User Life */
        String life_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentUserLife");
        String life_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentUserLife");
        String life_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentUserLife");

        user_life = life_ans_code + "," + life_ques_code + "," + "0" + "," + life_cat + "|";

        /* Stress */
        String stress_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentStress");
        String stress_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentStress");
        String stress_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentStress");

        user_stress = stress_ans_code + "," + stress_ques_code + "," + "0" + "," + stress_cat + "|";

        /* Social Ties */
        String social_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentSocialLife");
        String social_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentSocialLife");
        String social_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentSocialLife");

        user_social = social_ans_code + "," + social_ques_code + "," + "0" + "," + social_cat + "|";

        gen_health = user_bp + user_alcohol + user_cig + genhis + user_fruits + user_fried + user_work_bal + user_job_offer + user_laptop + user_work_shift + user_exercise + user_sleep + user_life + user_stress + user_social;


        JSONObject hra_resp_Obj = new JSONObject();
        try {
            hra_resp_Obj.put("VITALS", vitals_Obj);
            hra_resp_Obj.put("SETGENHEALTH", gen_health);
            if (!familyhis.isEmpty() || familyhis != null) {
                hra_resp_Obj.put("SETFAMILYHIST", familyhis);
            }
            hra_resp_Obj.put("PERSONID", pref.getpersonid());
            hra_resp_Obj.put("TEMPLATEID", pref.gettempid());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject hra_resp_main_Obj = new JSONObject();
        try {
            hra_resp_main_Obj.put("HRARESPONSE", hra_resp_Obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /* Lab Records */
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        FullDate = sdf.format(cal.getTime());

        JSONObject chol_total_json = null, chol_hdl_json = null, chol_ldl_json = null, chol_trig_json = null, diab_fast_json = null, diab_pp_json = null;

        String chol_total = db.getLifestyleCol4Value(pref.getUID(), "FragmentCholestrol");
        if (!chol_total.equalsIgnoreCase("0")) {
            chol_total_json = new JSONObject();
            try {
                chol_total_json.put("ParameterCode", "CHOL_TOTAL");
                chol_total_json.put("RecordDate", FullDate);
                chol_total_json.put("Value", chol_total);
                chol_total_json.put("PersonID", pref.getpersonid());
                chol_total_json.put("Unit", "mg/dL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String chol_hdl = db.getLifestyleCol2Value(pref.getUID(), "FragmentCholestrol");
        if (!chol_hdl.equalsIgnoreCase("0")) {
            chol_hdl_json = new JSONObject();
            try {
                chol_hdl_json.put("ParameterCode", "CHOL_HDL");
                chol_hdl_json.put("RecordDate", FullDate);
                chol_hdl_json.put("Value", chol_hdl);
                chol_hdl_json.put("PersonID", pref.getpersonid());
                chol_hdl_json.put("Unit", "mg/dL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String chol_ldl = db.getLifestyleCol1Value(pref.getUID(), "FragmentCholestrol");
        if (!chol_ldl.equalsIgnoreCase("0")) {
            chol_ldl_json = new JSONObject();
            try {
                chol_ldl_json.put("ParameterCode", "CHOL_LDL");
                chol_ldl_json.put("RecordDate", FullDate);
                chol_ldl_json.put("Value", chol_ldl);
                chol_ldl_json.put("PersonID", pref.getpersonid());
                chol_ldl_json.put("Unit", "mg/dL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String chol_trig = db.getLifestyleCol3Value(pref.getUID(), "FragmentCholestrol");
        if (!chol_trig.equalsIgnoreCase("0")) {
            chol_trig_json = new JSONObject();
            try {
                chol_trig_json.put("ParameterCode", "CHOL_TRY");
                chol_trig_json.put("RecordDate", FullDate);
                chol_trig_json.put("Value", chol_trig);
                chol_trig_json.put("PersonID", pref.getpersonid());
                chol_trig_json.put("Unit", "mg/dL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String diab_fast = db.getLifestyleCol1Value(pref.getUID(), "FragmentBloodSugar");
        if (!diab_fast.equalsIgnoreCase("0")) {
            diab_fast_json = new JSONObject();
            try {
                diab_fast_json.put("ParameterCode", "DIAB_FS");
                diab_fast_json.put("RecordDate", FullDate);
                diab_fast_json.put("Value", diab_fast);
                diab_fast_json.put("PersonID", pref.getpersonid());
                diab_fast_json.put("Unit", "mg/dL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String diab_pp = db.getLifestyleCol2Value(pref.getUID(), "FragmentBloodSugar");
        if (!diab_pp.equalsIgnoreCase("0")) {
            diab_pp_json = new JSONObject();
            try {
                diab_pp_json.put("ParameterCode", "DIAB_PM");
                diab_pp_json.put("RecordDate", FullDate);
                diab_pp_json.put("Value", diab_pp);
                diab_pp_json.put("PersonID", pref.getpersonid());
                diab_pp_json.put("Unit", "mg/dL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        JSONArray jsonArraylab = new JSONArray();
        if (!chol_total.equalsIgnoreCase("0") && !diab_fast.equalsIgnoreCase("0")) {
            jsonArraylab.put(chol_total_json);
            jsonArraylab.put(chol_hdl_json);
            jsonArraylab.put(chol_ldl_json);
            jsonArraylab.put(chol_trig_json);
            jsonArraylab.put(diab_fast_json);
            jsonArraylab.put(diab_pp_json);
        } else if (chol_total.equalsIgnoreCase("0") && !diab_fast.equalsIgnoreCase("0")) {
            jsonArraylab.put(diab_fast_json);
            jsonArraylab.put(diab_pp_json);
        } else if (!chol_total.equalsIgnoreCase("0") && diab_fast.equalsIgnoreCase("0")) {
            jsonArraylab.put(chol_total_json);
            jsonArraylab.put(chol_hdl_json);
            jsonArraylab.put(chol_ldl_json);
            jsonArraylab.put(chol_trig_json);
        }

        JSONObject hra_resp_main1_Obj = new JSONObject();
        try {
            hra_resp_main1_Obj.put("HraResponse", hra_resp_main_Obj);
            if (!chol_total.equalsIgnoreCase("0") && !diab_fast.equalsIgnoreCase("0")) {
                hra_resp_main1_Obj.put("LabRecords", jsonArraylab); // LabRecords array
            } else if (chol_total.equalsIgnoreCase("0") && !diab_fast.equalsIgnoreCase("0")) {
                hra_resp_main1_Obj.put("LabRecords", jsonArraylab); // LabRecords array
            } else if (!chol_total.equalsIgnoreCase("0") && diab_fast.equalsIgnoreCase("0")) {
                hra_resp_main1_Obj.put("LabRecords", jsonArraylab); // LabRecords array
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return hra_resp_main1_Obj.toString();
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
                String json_str = json_response.getString("JSONData");
                JSONObject json_data = new JSONObject(json_str);
                String json_str1 = json_data.getString("IsProcessed");
                if (json_str1.equalsIgnoreCase("TRUE")) {
                    SubmitHRA submithra = new SubmitHRA(mContext,mProgressDialog);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        submithra.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                    } else {
                        submithra.execute();
                    }
                } else {
                    Toast.makeText(mContext, "Data not saved", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
