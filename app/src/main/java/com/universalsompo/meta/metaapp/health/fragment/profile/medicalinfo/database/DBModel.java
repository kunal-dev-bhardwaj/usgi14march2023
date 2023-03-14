package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.database;

public class DBModel {
    public static final String TABLE_NAME = "user_medical_history";
    public static final String USER_ID = "user_id";
    public static final String DISEASE_ID = "diseases_id";
    public static final String DISEASE_NAME = "diseases_name";
    public static final String USER_SUFFER = "is_user_suffer";

    private String user_id, diseases_id, diseases_name, is_user_suffer;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + DISEASE_ID + " TEXT,"
                    + DISEASE_NAME + " TEXT,"
                    + USER_SUFFER + " TEXT"
                    + ")";

    public DBModel(){}

    public DBModel(String user_id, String diseases_id, String diseases_name, String is_user_suffer){
        this.user_id = user_id;
        this.diseases_id = diseases_id;
        this.diseases_name = diseases_name;
        this.is_user_suffer = is_user_suffer;
    }

    public DBModel(String diseases_id, String diseases_name, String is_user_suffer){
        this.diseases_id = diseases_id;
        this.diseases_name = diseases_name;
        this.is_user_suffer = is_user_suffer;
    }

    public String getUserid() {
        return user_id;
    }

    public void setUserid(String user_id) {
        this.user_id = user_id;
    }

    public String getDiseasesid() {
        return diseases_id;
    }

    public void setDiseasesid(String diseases_id) {
        this.diseases_id = diseases_id;
    }

    public String getDiseasesname() {
        return diseases_name;
    }

    public void setDiseasesname(String diseases_name) {
        this.diseases_name = diseases_name;
    }

    public String getIsusersuffer() {
        return is_user_suffer;
    }

    public void setIsusersuffer(String is_user_suffer) {
        this.is_user_suffer = is_user_suffer;
    }

    public String toString(){
        return "User_id : " + user_id + " Disease_id : " + diseases_id + " Disease_name : " + diseases_name + " Is_User_Suffer : " + is_user_suffer + "\n";
    }
}
