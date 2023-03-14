package com.universalsompo.meta.metaapp.health.HRALifestyle.Database.Model;

public class ResultLifestyleModel {
    public static final String TABLE_NAME = "user_lifestyle_result_added";
    public static final String USER_ID = "user_id";
    public static final String LIFESTYLE_AUTH_TOKEN = "auth_token";
    public static final String RESULT = "result";

    String user_id, auth_token, result_value;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + LIFESTYLE_AUTH_TOKEN + " TEXT,"
                    + RESULT + " TEXT"
                    + ")";

    public ResultLifestyleModel(String user_id, String auth_token, String result_value){
        this.user_id = user_id;
        this.auth_token = auth_token;
        this.result_value = result_value;
    }

    public String getUserid() {
        return user_id;
    }

    public void setUserid(String user_id) {
        this.user_id = user_id;
    }

    public String getAuthToken() {
        return auth_token;
    }

    public void setAuthToken(String auth_token) {
        this.auth_token = auth_token;
    }

    public String getResultvalue() {
        return result_value;
    }

    public void setResultvalue(String result_value) {
        this.result_value = result_value;
    }
}
