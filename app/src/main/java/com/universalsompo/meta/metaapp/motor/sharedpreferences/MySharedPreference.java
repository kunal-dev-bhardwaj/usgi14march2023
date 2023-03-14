package com.universalsompo.meta.metaapp.motor.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Netcomm on 10/18/2016.
 */

public class MySharedPreference {
    private static final String COUPON_CODE = "couponCode";
    private static final String URL_BENDER = "urlBender";
    private static MySharedPreference object;
    private Context mContext;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String INSKEY = "inskey";
    public static final String Contact_Key = "contact_key";

    public static final String POLICY_ID = "pid";
    public static final String INSURE_COMP_ID = "insureCompId";
    public static final String Token_NO = "token_no";
    public static final String USER_ID = "uid";
    public static final String OTP = "otp";
    public static final String ISLOGGEDIN = "Login";
    public static final String Android_Id = "androidId";

    public static final String RENEWAL_POLICY_DETAIL = "renewal_policy_detail";
    public static final String COVERAGE_DETAIL = "coveragedetail";

    //********************************** Profile **************************************
    public static final String EMAIL_ID = "email_id";
    public static final String MOBILE = "mobile";
    public static final String USER_NAME = "user_name";
    public static final String PROFILE_PIC = "profile_pic";
    public static final String NOTIFY_COUNT = "notify_count";
    public static final String TOTAL_NOTIFY_COUNT = "total_notify_count";
    public static final String WEIGHT = "weight";
    public static final String FEET = "feet";
    public static final String INCHES = "inches";
    public static final String GENDER = "gender";
    public static final String TARGETWEIGHT = "target_weight";
    public static final String DAILYACTIVITY = "daily_activity";
    public static final String AGE = "age";
    public static final String CALORIE_GOAL = "calorie_goal";
    public static final String SPINNER_VALUE = "spinner_value";
    public static final String EMERGENCY_CONTACT_NAME = "emergency_contact_name";
    public static final String EMERGENCY_CONTACT_NUMBER = "emergency_contact_number";
    public static final String WATER_TARGET = "water_target";
    public static final String STEP_TARGET = "step_target";
    public static final String LOSS_GAIN = "loss_gain";
    public static final String LOSS_GAIN_TXT = "loss_gain_txt";
    public static final String WEIGHT_BURN = "weight_burn";
    public static final String CORPORATE_ID = "corp_id";
    public static final String SYMPTOM_INTERVIEW_ID = "symptom_interview_id";
    public static final String EXERCISE_ALARM = "exercise_alarm";
    public static final String EMP_ID = "empid";

    //****************************************************** RSA ******************************************
    public static final String HELPLINE_NO = "helpline_no";
    public static final String RSA_POLICY_ID = "policy_id";
    public static final String MULITPLE_CAR_FLAG = "multiple_car_flag";
    public static final String RSA_OTHER_FORM_FLAG = "form_flag";

    public static final String Nearby_Tag = "nearby_tag";
    public static final String Fragment_Tag = "fragment_tag";
    public static final String DEVICE_TOKEN = "device_token";
    public static final String VEHICLE_TYPE = "vehicle_type";
    public static final String EDIT_VEHICLE_TYPE = "edit_vehicle_type";
    public static final String CLAIM_VEHICLE_TYPE = "claim_vehicle_type";

    /***************** Health Profile ********************/
    public static final String Address = "address";
    public static final String Pincode = "pincode";
    public static final String LandLine = "landline";
    public static final String DOB = "dob";
    public static final String City = "city";
    public static final String State = "state";
    public static final String CLIENT_USERID = "clientUserID";

    /**************** ALLIZHEALTH ******************/
    public static final String accountID = "account_id";
    public static final String personID = "person_id";
    public static final String sessionID = "session_id";
    public static final String templateID = "template_id";
    public static final String WELLNESS_SCORE = "wellness_score";
    public static final String OBSERVATION = "observation";
    public static final String LIFE_HRA_STATUS = "hra_status";
    public static final String LIFE_HRA_LAB_JSONDATA = "lab_jsondata";
    public static final String LIFE_CURRENT_BP_JSONDATA = "currentbp_jsondata";
    public static final String LIFE_RISK_SUMMARY_JSONDATA = "risksummary_jsondata";
    public static final String LIFE_HEARTRISK = "heart_risk";
    public static final String LIFE_DIABETESRISK = "diabetes_risk";
    public static final String LIFE_STROKERISK = "stroke_risk";
    public static final String LIFE_JOBSTRESS = "job_stress";
    public static final String LIFE_EMOTIONALHEALTH = "emotional_health";
    public static final String LIFE_RANDOM1 = "random1";
    public static final String LIFE_RANDOM2 = "random2";
    public static final String LIFE_RANDOM3 = "random3";
    public static final String LIFE_RANDOM4 = "random4";
    public static final String LIFE_RANDOM5 = "random5";
    public static final String FIRST_TIME_USER = "demoPages";
    public static final String POLICY_ID_HEALTH = "policy_id_health";
    public static final String POLICY_INFORMATION = "policy_information";
    public static final String POLICY_NUMBER_HEALTH = "policy_number";
    public static final String HEALTH_CLAIM_NUMBER = "claim_number";
    public static final String HEALTH_CLAIM_EMAIL = "claim_email";
    public static final String HEALTH_POLICY_REMAINING_DAYS = "remaining_days";
    public static final String HEALTH_INS_COMP_ID = "ins_comp_id";

    /**************** FITBIT ******************/
    public static final String FITBIT_TOKEN = "fitbit_token";
    public static final String FITBIT_ACCESS_TOKEN = "fitbit_access_token";
    public static final String FIBIT_USER_ID = "fitbit_user_id";

    /**************** CHALLENGES ******************/
    public static final String CHALLENGE_GROUP_NAME = "challenge_group_name";
    public static final String CHALLENGE_GROUP_ID = "challenge_group_id";
    public static final String CHALLENGE_GROUP_CODE = "challenge_group_code";
    public static final String NOTIFICATION_ON_OFF = "notification_on_off";
    public static final String START_SMOKING_DATE = "start_smoking_date";
    public static final String STOP_SMOKING_DATE = "stop_smoking_date";
    public static final String NOTIFICATION_SOUND = "notification_sound";

    public static final String POLICY_TYPE = "policy_type";
    public static final String FINGURE_PRINT = "fingure_print";

    public static final String WYH_AUTH_TOKEN = "wyh_auth_token";
    public static final String IS_POLICY_STATUS = "is_policy_status";
    public static final String IS_USGI_USER = "is_usgi_user";
    public static final String CUSTOMER_ID = "customer_id";

    SharedPreferences sharedpreferences;



    public MySharedPreference(Context mContext) {
        this.mContext = mContext;
        sharedpreferences = mContext.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    public static MySharedPreference getInstance(Context mContext) {
        if (object == null) {
            object = new MySharedPreference(mContext);
        }
        return object;
    }

    public void setaddress(String address) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Address, address);
        editor.commit();
    }

    public void setpincode(String pincode) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Pincode, pincode);
        editor.commit();
    }

    public void setLandLine(String landLine) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LandLine, landLine);
        editor.commit();
    }

    public void setAndroidId(String androidId){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Android_Id,androidId);
        editor.commit();
    }

    public void setIsPolicyStatus(String isPolicyStatus){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(IS_POLICY_STATUS ,isPolicyStatus);
        editor.commit();
    }

    public void setDOB(String Dob) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(DOB, Dob);
        editor.commit();
    }

    public void setcity(String city) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(City, city);
        editor.commit();
    }

    public void setstate(String state) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(State, state);
        editor.commit();
    }

    public void setClientUserID(String clientUserID1) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CLIENT_USERID, clientUserID1);
        editor.commit();
    }

    public void setaccid(String accounid) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(accountID, accounid);
        editor.commit();
    }

    public void setpersonid(String perid) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(personID, perid);
        editor.commit();
    }

    public void setsessionid(String sessid) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(sessionID, sessid);
        editor.commit();
    }

    public void settempid(String tempid) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(templateID, tempid);
        editor.commit();
    }

    public void setweight(String weight) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(WEIGHT, weight);
        editor.commit();
    }

    public void setCorporateId(String corp_id) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CORPORATE_ID, corp_id);
        editor.commit();
    }

    public void setfeet(String feet) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(FEET, feet);
        editor.commit();
    }

    public void setinches(String inches) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(INCHES, inches);
        editor.commit();
    }

    public void setgender(String gender) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(GENDER, gender);
        editor.commit();
    }

    public void setTargetweight(String target_weight) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(TARGETWEIGHT, target_weight);
        editor.commit();
    }

    public void setDailyactivity(String daily_activity) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(DAILYACTIVITY, daily_activity);
        editor.commit();
    }

    public void setAge(String age) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(AGE, age);
        editor.commit();
    }

    public void setcaloriegoal(String calorie_goal) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CALORIE_GOAL, calorie_goal);
        editor.commit();
    }

    public void setSpinnervalue(String spin_value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(SPINNER_VALUE, spin_value);
        editor.commit();
    }

    public void setEmergencyContactName(String emergencycontactname) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(EMERGENCY_CONTACT_NAME, emergencycontactname);
        editor.commit();
    }

    public void setWYHAuthToken(String wyh_auth_token) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(WYH_AUTH_TOKEN, wyh_auth_token);
        editor.commit();
    }

    public void setEmergencyContactNumber(String emergencycontactnumber) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(EMERGENCY_CONTACT_NUMBER, emergencycontactnumber);
        editor.commit();
    }

    public void setWaterGlassTarget(String water_target) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(WATER_TARGET, water_target);
        editor.commit();
    }

    public void setStepTarget(String step_target) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(STEP_TARGET, step_target);
        editor.commit();
    }

    public void setlossgain(String loss_gain) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LOSS_GAIN, loss_gain);
        editor.commit();
    }

    public void setlossgain_txt(String loss_gain_txt) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LOSS_GAIN_TXT, loss_gain_txt);
        editor.commit();
    }

    public void setWeightBurn(String weight_burn) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(WEIGHT_BURN, weight_burn);
        editor.commit();
    }

    public void setSymptom_interview_id(String symptom_interview_id) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(SYMPTOM_INTERVIEW_ID, symptom_interview_id);
        editor.commit();
    }

    public void setEmpid(String empid) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(EMP_ID, empid);
        editor.commit();
    }

    public void setWellnessscore(String wellness_score) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(WELLNESS_SCORE, wellness_score);
        editor.commit();
    }

    public void setObservation(String observation) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(OBSERVATION, observation);
        editor.commit();
    }

    public void setLifeHraStatus(String hra_status) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_HRA_STATUS, hra_status);
        editor.commit();
    }

    public void setLifelabjsondata(String lab_jsondata) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_HRA_LAB_JSONDATA, lab_jsondata);
        editor.commit();
    }

    public void setLifecurrentbpjsondata(String currentbp_jsondata) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_CURRENT_BP_JSONDATA, currentbp_jsondata);
        editor.commit();
    }

    public void setLiferisksummaryjsondata(String risksummary_jsondata) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_RISK_SUMMARY_JSONDATA, risksummary_jsondata);
        editor.commit();
    }

    public void setLifeheartrisk(String heart_risk) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_HEARTRISK, heart_risk);
        editor.commit();
    }

    public void setLifediabetesrisk(String diabetes_risk) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_DIABETESRISK, diabetes_risk);
        editor.commit();
    }

    public void setLifestrokerisk(String stroke_risk) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_STROKERISK, stroke_risk);
        editor.commit();
    }

    public void setLifejobstress(String job_stress) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_JOBSTRESS, job_stress);
        editor.commit();
    }

    public void setLifeemotionalhealth(String emotional_health) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_EMOTIONALHEALTH, emotional_health);
        editor.commit();
    }

    public void setLiferandom1(String random1) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_RANDOM1, random1);
        editor.commit();
    }

    public void setLiferandom2(String random2) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_RANDOM2, random2);
        editor.commit();
    }

    public void setLiferandom3(String random3) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_RANDOM3, random3);
        editor.commit();
    }

    public void setLiferandom4(String random4) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_RANDOM4, random4);
        editor.commit();
    }

    public void setLiferandom5(String random5) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LIFE_RANDOM5, random5);
        editor.commit();
    }

    public void setHealthClaimNumber(String claim_number) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(HEALTH_CLAIM_NUMBER, claim_number);
        editor.commit();
    }

    public void setHealthClaimEmail(String claim_email) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(HEALTH_CLAIM_EMAIL, claim_email);
        editor.commit();
    }

    public void setisUSGIUser(String is_usgi_user) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(IS_USGI_USER, is_usgi_user);
        editor.commit();
    }

    public void setCustID(String cust_id) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CUSTOMER_ID, cust_id);
        editor.commit();
    }

    public String getAndroid_Id(){
        return sharedpreferences.getString(Android_Id,null );
    }
    public String getaddress() {
        return sharedpreferences.getString(Address, null);
    }
    public String getpincode() {
        return sharedpreferences.getString(Pincode, null);
    }
    public String getlandline() {
        return sharedpreferences.getString(LandLine, null);
    }
    public String getDOB() {
        return sharedpreferences.getString(DOB, null);
    }
    public String getcity() {
        return sharedpreferences.getString(City, null);
    }
    public String getstate() {
        return sharedpreferences.getString(State, null);
    }
    public String getClientUserID() {
        return sharedpreferences.getString(CLIENT_USERID, null);
    }
    public String getaccid() {
        return sharedpreferences.getString(accountID, null);
    }
    public String getpersonid() {
        return sharedpreferences.getString(personID, null);
    }
    public String getsessionid() {
        return sharedpreferences.getString(sessionID, null);
    }
    public String gettempid() {
        return sharedpreferences.getString(templateID, null);
    }
    public String getweight() {
        return sharedpreferences.getString(WEIGHT, null);
    }
    public String getCorporateId() {
        return sharedpreferences.getString(CORPORATE_ID, null);
    }
    public String getEmpid() {
        return sharedpreferences.getString(EMP_ID, null);
    }
    public String getHealthClaimNumber() {
        return sharedpreferences.getString(HEALTH_CLAIM_NUMBER, null);
    }
    public String getHealthClaimEmail() {
        return sharedpreferences.getString(HEALTH_CLAIM_EMAIL, null);
    }

    public String getWellnessscore() {
        return sharedpreferences.getString(WELLNESS_SCORE, null);
    }
    public String getWYHAuthToken() {
        return sharedpreferences.getString(WYH_AUTH_TOKEN, null);
    }
    public String getObservation() {
        return sharedpreferences.getString(OBSERVATION, null);
    }
    public String getLifehrastatus() {
        return sharedpreferences.getString(LIFE_HRA_STATUS, null);
    }
    public String getLifelabjsondata() {
        return sharedpreferences.getString(LIFE_HRA_LAB_JSONDATA, null);
    }
    public String getLifecurrentbpjsondata() {
        return sharedpreferences.getString(LIFE_CURRENT_BP_JSONDATA, null);
    }
    public String getLiferisksummaryjsondata() {
        return sharedpreferences.getString(LIFE_RISK_SUMMARY_JSONDATA, null);
    }
    public String getLifeheartrisk() {
        return sharedpreferences.getString(LIFE_HEARTRISK, null);
    }
    public String getLifediabetesrisk() {
        return sharedpreferences.getString(LIFE_DIABETESRISK, null);
    }
    public String getLifestrokerisk() {
        return sharedpreferences.getString(LIFE_STROKERISK, null);
    }
    public String getLifejobstress() {
        return sharedpreferences.getString(LIFE_JOBSTRESS, null);
    }
    public String getLifeemotionalhealth() {
        return sharedpreferences.getString(LIFE_EMOTIONALHEALTH, null);
    }
    public String getLiferandom1() {
        return sharedpreferences.getString(LIFE_RANDOM1, null);
    }
    public String getLiferandom2() {
        return sharedpreferences.getString(LIFE_RANDOM2, null);
    }
    public String getLiferandom3() {
        return sharedpreferences.getString(LIFE_RANDOM3, null);
    }
    public String getLiferandom4() {
        return sharedpreferences.getString(LIFE_RANDOM4, null);
    }
    public String getLiferandom5() {
        return sharedpreferences.getString(LIFE_RANDOM5, null);
    }

    public String getfeet() {
        return sharedpreferences.getString(FEET, null);
    }
    public String getinches() {
        return sharedpreferences.getString(INCHES, null);
    }
    public String getgender() {
        return sharedpreferences.getString(GENDER, null);
    }
    public String getTargetweight() {
        return sharedpreferences.getString(TARGETWEIGHT, null);
    }
    public String getDailyactivity() {
        return sharedpreferences.getString(DAILYACTIVITY, null);
    }
    public String getAge() {
        return sharedpreferences.getString(AGE, null);
    }
    public String getcaloriegoal() {
        return sharedpreferences.getString(CALORIE_GOAL, null);
    }
    public String getSpinnervalue() {
        return sharedpreferences.getString(SPINNER_VALUE, null);
    }
    public String getEmergencyContactName() {
        return sharedpreferences.getString(EMERGENCY_CONTACT_NAME, null);
    }
    public String getEmergencyContactNumber() {
        return sharedpreferences.getString(EMERGENCY_CONTACT_NUMBER, null);
    }
    public String getWaterGlassTarget() {
        return sharedpreferences.getString(WATER_TARGET, null);
    }
    public String getStepTarget() {
        return sharedpreferences.getString(STEP_TARGET, null);
    }
    public String getlossgain() {
        return sharedpreferences.getString(LOSS_GAIN, null);
    }
    public String getlossgain_txt() {
        return sharedpreferences.getString(LOSS_GAIN_TXT, null);
    }
    public String getWeightBurn() {
        return sharedpreferences.getString(WEIGHT_BURN, null);
    }
    public String getSymptominterviewid() {
        return sharedpreferences.getString(SYMPTOM_INTERVIEW_ID, null);
    }

    public void setINSkey(String key) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(INSKEY, key);
        editor.commit();
    }

    public void setContact(String key) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Contact_Key, key);
        editor.commit();
    }


    public String getINSkey() {
        return sharedpreferences.getString(INSKEY, null);
    }

    public String getContact() {
        return sharedpreferences.getString(Contact_Key, null);
    }

    public String getIsPolicyStatus() {
        return sharedpreferences.getString(IS_POLICY_STATUS, null);
    }


    public void clearAll() {
        sharedpreferences.edit().clear().commit();
    }


    public void addToken_no(String token) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Token_NO, token);
        editor.commit();
    }

    public String getToken_no() {
        return sharedpreferences.getString(Token_NO, null);
    }


    public void addUID(String uid) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_ID, uid);
        editor.commit();
    }

    public String getUID() {
        return sharedpreferences.getString(USER_ID, null);
    }

    public void addPID(String pid) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(POLICY_ID, pid);
        editor.commit();
    }

    public void addPolicy_id_health(String pid) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(POLICY_ID_HEALTH, pid);
        editor.commit();
    }

    public void addPolicy_no_health(String pno) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(POLICY_NUMBER_HEALTH, pno);
        editor.commit();
    }

    public String getPID() {
        return sharedpreferences.getString(POLICY_ID, null);
    }

    public String getPolicy_id_health() {
        return sharedpreferences.getString(POLICY_ID_HEALTH, null);
    }

    public String getPolicy_no_health() {
        return sharedpreferences.getString(POLICY_NUMBER_HEALTH, null);
    }

    public void addVehicheType(String insureCompId) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(VEHICLE_TYPE, insureCompId);
        editor.commit();
    }

    public String getVehcileType() {
        return sharedpreferences.getString(VEHICLE_TYPE, null);
    }




    public void editVehicleType(String editVeh_type)
    {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(EDIT_VEHICLE_TYPE, editVeh_type);
        editor.commit();
    }


    public String getEditVehicleType() {
        return sharedpreferences.getString(EDIT_VEHICLE_TYPE, null);
    }


    public void claimVehicleType(String Veh_type)
    {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CLAIM_VEHICLE_TYPE, Veh_type);
        editor.commit();
    }


    public String getClaimVehicleType() {
        return sharedpreferences.getString(CLAIM_VEHICLE_TYPE, null);
    }



    public void addInsureCompID(String insureCompId) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(INSURE_COMP_ID, insureCompId);
        editor.commit();
    }

    public String getInsureCompId() {
        return sharedpreferences.getString(INSURE_COMP_ID, null);
    }


    public void addIsLoggedIn(boolean isLoggedIn) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(ISLOGGEDIN, isLoggedIn);
        editor.commit();
    }

    public void addExerciseAlarm(boolean exercise_alarm) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(EXERCISE_ALARM, exercise_alarm);
        editor.commit();
    }

    public boolean getIsLoggedIn() {
        return sharedpreferences.getBoolean(ISLOGGEDIN, false);
    }

    public boolean getIsExerciseAlarm() {
        return sharedpreferences.getBoolean(EXERCISE_ALARM, false);
    }

    public void addDeviceToken(String token) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(DEVICE_TOKEN, token);
        editor.commit();
    }

    public String getDeviecToken() {
        return sharedpreferences.getString(DEVICE_TOKEN, null);
    }

    public String getRenewalPolicyDetail() {
        return sharedpreferences.getString(RENEWAL_POLICY_DETAIL, null);
    }

    public String getPolicyInformation() {
        return sharedpreferences.getString(POLICY_INFORMATION, null);
    }


    public void setRenewalPolicyDetail(String detail) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(RENEWAL_POLICY_DETAIL, detail);
        editor.commit();
    }

    public void setPolicyInformation(String detail) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(POLICY_INFORMATION, detail);
        editor.commit();
    }


    public String getCovarageDetail() {
        return sharedpreferences.getString(COVERAGE_DETAIL, null);
    }


    public void setCovarageDetail(String detail) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(COVERAGE_DETAIL, detail);
        editor.commit();
    }

    // ************************************ Profile *************************************
    public String getProfilePic() {
        return sharedpreferences.getString(PROFILE_PIC, null);
    }

    public String getUserName() {
        return sharedpreferences.getString(USER_NAME, null);
    }

    public String getMOBILE() {
        return sharedpreferences.getString(MOBILE, null);
    }

    public String getEmailId() {
        return sharedpreferences.getString(EMAIL_ID, null);
    }


    public void setUserName(String name) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_NAME, name);
        editor.commit();
    }

    public void setMobile(String mobile) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(MOBILE, mobile);
        editor.commit();
    }

    public void setEmailId(String email) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(EMAIL_ID, email);
        editor.commit();
    }

    public void setProfilePic(String img) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(PROFILE_PIC, img);
        editor.commit();
    }

 public void setNotifyUnreadCount(String count) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(NOTIFY_COUNT, count);
        editor.commit();
    }
    public String getNotifyUnreadCount() {
        return sharedpreferences.getString(NOTIFY_COUNT, null);
    }


    public void setTotalNotificationCount(String count) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(TOTAL_NOTIFY_COUNT, count);
        editor.commit();
    }
    public String getTotalNotificationCount() {
        return sharedpreferences.getString(TOTAL_NOTIFY_COUNT, null);
    }
    //************************************* RSA ***********************************
    public void setHelplineNo(String no) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(HELPLINE_NO, no);
        editor.commit();
    }

    public void setRsaPolicyId(String status) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(RSA_POLICY_ID, status);
        editor.commit();
    }

    public void setMulitpleCarFlag(String status) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(MULITPLE_CAR_FLAG, status);
        editor.commit();
    }


    public String getMulitpleCarFlags() {
        return sharedpreferences.getString(MULITPLE_CAR_FLAG, "False");
    }


    public String getHelplineNo() {
        return sharedpreferences.getString(HELPLINE_NO, null);
    }


    public String getRsaPolicyId() {
        return sharedpreferences.getString(RSA_POLICY_ID, null);
    }


    public void setNearby_Tag(String TAg) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Nearby_Tag, TAg);
        editor.commit();
    }

    public String getNearby_Tag() {
        return sharedpreferences.getString(Nearby_Tag, "False");
    }

    public void setURLBender(String urlBender) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(URL_BENDER, urlBender);
        editor.commit();

    }

    public String getURLBender() {
        return sharedpreferences.getString(URL_BENDER, null);
    }

    public void setCouponCode(String cc) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(COUPON_CODE, cc);
        editor.commit();
    }

    public String getCouponCode() {
        return sharedpreferences.getString(COUPON_CODE, "");
    }

    public String getFragment_Tag() {
        return sharedpreferences.getString(Fragment_Tag, "");
    }

    public void setFragment_Tag(String tag) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Fragment_Tag, tag);
        editor.commit();
    }

    public void firstTimeUser(String first){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(FIRST_TIME_USER,first);
        editor.commit();
    }

    public void addFitBitToken(String token) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(FITBIT_TOKEN, token);
        editor.commit();
    }

    public void addFitBitAccessToken(String token) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(FITBIT_ACCESS_TOKEN, token);
        editor.commit();
    }

    public void addFitBitUserId(String userid) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(FIBIT_USER_ID, userid);
        editor.commit();
    }

    public  String getFitbitAccessToken() {
        return sharedpreferences.getString(FITBIT_ACCESS_TOKEN,null) ;
    }

    public  String getFibitUserId() {
        return sharedpreferences.getString(FIBIT_USER_ID,null);
    }

    public  String getFitbitToken() {
        return sharedpreferences.getString(FITBIT_TOKEN, null);
    }

    public void setChallengeGroupName(String groupName){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CHALLENGE_GROUP_NAME, groupName);
        editor.commit();
    }
    public void setChallengeGroupCode(String groupCode){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CHALLENGE_GROUP_NAME, groupCode);
        editor.commit();
    }

    public void setChallengeGroupId(String groupId){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CHALLENGE_GROUP_NAME, groupId);
        editor.commit();
    }

    public String getChallengeGroupName(){
        return sharedpreferences.getString(CHALLENGE_GROUP_NAME,null);
    }

    public String getChallengeGroupCode(){
        return sharedpreferences.getString(CHALLENGE_GROUP_CODE,null);
    }

    public  String getChallengeGroupId(){
        return sharedpreferences.getString(CHALLENGE_GROUP_ID,null);
    }

    public String getIns_comp_ID_health() {
        return sharedpreferences.getString(HEALTH_INS_COMP_ID, null);
    }


    public void setIns_comp_ID_health(String inscomid) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(HEALTH_INS_COMP_ID, inscomid);
        editor.commit();
    }

    public void setHealthPolicyRemainingDays(String remainingDays){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(HEALTH_POLICY_REMAINING_DAYS, remainingDays);
        editor.commit();
    }

    public String getHealthPolicyRemainingDays(){
        return sharedpreferences.getString(HEALTH_POLICY_REMAINING_DAYS,null);
    }

    public void addNotificationOnOrOff(boolean status) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(NOTIFICATION_ON_OFF, status);
        editor.commit();
    }

    public boolean getNotificationOnOrOff() {
        return sharedpreferences.getBoolean(NOTIFICATION_ON_OFF, false);
    }

    public void setStartSmokingDate(String start_date) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(START_SMOKING_DATE, start_date);
        editor.commit();
    }

    public String getStartSmokingDate() {
        return sharedpreferences.getString(START_SMOKING_DATE, null);
    }

    public void setStopSmokingDate(String stop_date) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(STOP_SMOKING_DATE, stop_date);
        editor.commit();
    }

    public String getStopSmokingDate() {
        return sharedpreferences.getString(STOP_SMOKING_DATE, null);
    }

    public void addNotificationSound(boolean status) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(NOTIFICATION_SOUND, status);
        editor.commit();
    }

    public boolean getNotificationSound() {
        return sharedpreferences.getBoolean(NOTIFICATION_SOUND  , true);
    }

    public void addPolicyType(String policy_type) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(POLICY_TYPE, policy_type);
        editor.commit();
    }

    public String getPolicyType() {
        return sharedpreferences.getString(POLICY_TYPE  , "");
    }

    public void addFingurePrint(boolean fingure_print) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(FINGURE_PRINT, fingure_print);
        editor.commit();
    }

    public boolean getFingurePrint() {
        return sharedpreferences.getBoolean(FINGURE_PRINT  , false);
    }

    public String getisUSGIUser() {
        return sharedpreferences.getString(IS_USGI_USER  , "");
    }

    public String getCustID() {
        return sharedpreferences.getString(CUSTOMER_ID  , "");
    }


}
