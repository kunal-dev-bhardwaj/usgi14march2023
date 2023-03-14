package com.universalsompo.meta.metaapp.motor.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharePref {
    private static MySharePref object;
    private Context mContext;
    public static final String MyPREF = "MyPref";

    public static final String INSURER_NAME = "insurer_name";
    public static final String PRODUCT_NAME = "product_name";
    public static final String POLICY_NUMBER = "policy_number";
    public static final String MEM_ID = "mem_id";
    public static final String COMPOSITION = "composition";
    public static final String SUM_INSURED = "sum_insured";
    public static final String PREMIUM = "premium";
    public static final String PURCHASE_YEAR = "purchase_year";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";

    public static final String END_DAY = "end_day";
    public static final String END_MONTH = "end_month";
    public static final String END_YEAR = "end_year";
    public static final String START_DAY = "start_day";
    public static final String START_MONTH = "start_month";
    public static final String START_YEAR = "start_year";
    public static final String POLICY_DOC = "policy_doc";

    public static final String INSURER_ID = "insurer_id";
    public static final String PRODUCT_ID = "product_id";
    public static final String COMP_ID = "comp_id";

    public static final String EXTENSION = "ext";

    SharedPreferences sharedpreferences1;

    public MySharePref(Context mContext) {
        this.mContext = mContext;
        sharedpreferences1 = mContext.getSharedPreferences(MyPREF, Context.MODE_PRIVATE);
    }

    public static MySharePref getInstance(Context mContext) {
        if (object == null) {
            object = new MySharePref(mContext);
        }
        return object;
    }

    public void setInsurerName(String insurer_name) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(INSURER_NAME, insurer_name);
        editor.commit();
    }

    public void setInsurerProduct(String product_name) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(PRODUCT_NAME, product_name);
        editor.commit();
    }

    public void setPolicyNumber(String policy_number) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(POLICY_NUMBER, policy_number);
        editor.commit();
    }

    public void setComp(String composition) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(COMPOSITION, composition);
        editor.commit();
    }

    public void setSumInsured(String sum_insured) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(SUM_INSURED, sum_insured);
        editor.commit();
    }

    public void setPremium(String premium) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(PREMIUM, premium);
        editor.commit();
    }

    public void setPurchaseYear(String purchase_year) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(PURCHASE_YEAR, purchase_year);
        editor.commit();
    }

    public void setStartDate(String start_date) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(START_DATE, start_date);
        editor.commit();
    }

    public void setEndDay(String end_day) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(END_DAY, end_day);
        editor.commit();
    }

    public void setEndMonth(String end_month) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(END_MONTH, end_month);
        editor.commit();
    }

    public void setEndYear(String end_year) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(END_YEAR, end_year);
        editor.commit();
    }

    public void setStartDay(String start_day) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(START_DAY, start_day);
        editor.commit();
    }

    public void setStartMonth(String start_month) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(START_MONTH, start_month);
        editor.commit();
    }

    public void setStartYear(String start_year) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(START_YEAR, start_year);
        editor.commit();
    }

    public void setEndDate(String end_date) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(END_DATE, end_date);
        editor.commit();
    }

    public void setPolicyDoc(String policy_doc) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(POLICY_DOC, policy_doc);
        editor.commit();
    }

    public void setInsurerId(String insurer_id) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(INSURER_ID, insurer_id);
        editor.commit();
    }

    public void setProductId(String product_id) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(PRODUCT_ID, product_id);
        editor.commit();
    }

    public void setCompositionId(String comp_id) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(COMP_ID, comp_id);
        editor.commit();
    }

    public void setExtension(String ext) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(EXTENSION, ext);
        editor.commit();
    }

    public void setMemId(String mem_id) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(MEM_ID, mem_id);
        editor.commit();
    }

    public String getInsurerName() {
        return sharedpreferences1.getString(INSURER_NAME, null);
    }

    public String getProductName() {
        return sharedpreferences1.getString(PRODUCT_NAME, null);
    }

    public String getPolicyNumber() {
        return sharedpreferences1.getString(POLICY_NUMBER, null);
    }

    public String getComposition() {
        return sharedpreferences1.getString(COMPOSITION, null);
    }

    public String getSumInsured() {
        return sharedpreferences1.getString(SUM_INSURED, null);
    }

    public String getPremium() {
        return sharedpreferences1.getString(PREMIUM, null);
    }

    public String getPurchaseYear() {
        return sharedpreferences1.getString(PURCHASE_YEAR, null);
    }

    public String getStartDate() {
        return sharedpreferences1.getString(START_DATE, null);
    }

    public String getEndDate() {
        return sharedpreferences1.getString(END_DATE, null);
    }

    public String getStartDay() {
        return sharedpreferences1.getString(START_DAY, null);
    }

    public String getStartMonth() {
        return sharedpreferences1.getString(START_MONTH, null);
    }

    public String getStartYear() {
        return sharedpreferences1.getString(START_YEAR, null);
    }

    public String getEndDay() {
        return sharedpreferences1.getString(END_DAY, null);
    }

    public String getEndMonth() {
        return sharedpreferences1.getString(END_MONTH, null);
    }

    public String getEndYear() {
        return sharedpreferences1.getString(END_YEAR, null);
    }

    public String getPolicyDoc() {
        return sharedpreferences1.getString(POLICY_DOC, null);
    }

    public String getInsurerId() {
        return sharedpreferences1.getString(INSURER_ID, null);
    }

    public String getProductId() {
        return sharedpreferences1.getString(PRODUCT_ID, null);
    }

    public String getCompositionId() {
        return sharedpreferences1.getString(COMP_ID, null);
    }

    public String getExtension() {
        return sharedpreferences1.getString(EXTENSION, null);
    }

    public String getMemId() {
        return sharedpreferences1.getString(MEM_ID, null);
    }

    public void clearAll() {
        sharedpreferences1.edit().clear().commit();
    }
}
