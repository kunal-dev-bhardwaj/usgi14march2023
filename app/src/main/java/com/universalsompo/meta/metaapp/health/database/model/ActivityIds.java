package com.universalsompo.meta.metaapp.health.database.model;

public class ActivityIds {
    public static final String TABLE_NAME = "activity_ids";
    public static final String USER_ID = "user_id";
    public static final String ACTIVITY_NAME = "act_name";
    public static final String ACTIVITY_ID = "act_id";
    public static final String ACTIVITY_UNIQUE_NAME = "act_uni_name";
    private String activity_name, activity_id, activity_uni_name,user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
    }

    public String getActivity_uni_name() {
        return activity_uni_name;
    }

    public void setActivity_uni_name(String activity_uni_name) {
        this.activity_uni_name = activity_uni_name;
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + ACTIVITY_NAME + " TEXT,"
                    + ACTIVITY_ID + " TEXT,"
                    + ACTIVITY_UNIQUE_NAME + " TEXT"
                    + ")";

    public ActivityIds(){}

    public ActivityIds(String user_id,String activity_name,String activity_id,String activity_uni_name){
        this.user_id = user_id;
        this.activity_name = activity_name;
        this.activity_id = activity_id;
        this.activity_uni_name = activity_uni_name;
    }
    public String toString(){
        return "User_id : " + user_id + " Activity_name : " + activity_name + " Activity_id : " + activity_id + " Activity_uni_name : " + activity_uni_name + "\n";
    }
}
