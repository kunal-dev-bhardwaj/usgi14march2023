package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model;

public class Result {
    public static final String TABLE_NAME = "user_symptom_result_added";
    public static final String USER_ID = "user_id";
    public static final String SYMPTOM_ID = "symptom_id";
    public static final String RESULT = "result";

    String user_id, symptom_id, result_value;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + SYMPTOM_ID + " TEXT,"
                    + RESULT + " TEXT"
                    + ")";

    public Result(String user_id, String symptom_id, String result_value){
        this.user_id = user_id;
        this.symptom_id = symptom_id;
        this.result_value = result_value;
    }

    public String getUserid() {
        return user_id;
    }

    public void setUserid(String user_id) {
        this.user_id = user_id;
    }

    public String getSymptomId() {
        return symptom_id;
    }

    public void setSymptomId(String symptom_id) {
        this.symptom_id = symptom_id;
    }

    public String getResultvalue() {
        return result_value;
    }

    public void setResultvalue(String result_value) {
        this.result_value = result_value;
    }
}
