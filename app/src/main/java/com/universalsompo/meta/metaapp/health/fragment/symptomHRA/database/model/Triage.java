package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model;

public class Triage {
    public static final String TABLE_NAME = "triage";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String INTERVIEW_ID = "interview_id";
    public static final String TRIAGE_ID = "triage_id";
    public static final String TRIAGE_NAME = "triage_name";
    public static final String TRIAGE_COMMON_NAME = "triage_common_name";

    private String user_id, user_name, interview_id;
    private String triage_id, triage_name, triage_common_name;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + USER_NAME + " TEXT,"
                    + INTERVIEW_ID + " TEXT,"
                    + TRIAGE_ID + " TEXT,"
                    + TRIAGE_NAME + " TEXT,"
                    + TRIAGE_COMMON_NAME + " TEXT"
                    + ")";

    public Triage(){}

    public Triage(String user_id, String user_name, String interview_id, String triage_id, String triage_name, String triage_common_name){
        this.user_id = user_id;
        this.user_name = user_name;
        this.interview_id = interview_id;
        this.triage_id = triage_id;
        this.triage_name = triage_name;
        this.triage_common_name = triage_common_name;
    }

    public String getUserid() {
        return user_id;
    }

    public void setUserid(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return user_name;
    }

    public void setUsername(String user_name) {
        this.user_name = user_name;
    }

    public String getInterviewid() {
        return interview_id;
    }

    public void setInterviewid(String interview_id) {
        this.interview_id = interview_id;
    }

    public String getTriageid() {
        return triage_id;
    }

    public void setTriageid(String triage_id) {
        this.triage_id = triage_id;
    }

    public String getTriagename() {
        return triage_name;
    }

    public void setTriagename(String triage_name) {
        this.triage_name = triage_name;
    }

    public String getTriagecommonname() {
        return triage_common_name;
    }

    public void setTriagecommonname(String triage_common_name) {
        this.triage_common_name = triage_common_name;
    }

    public String toString(){
        return "User_id : " + user_id + " User_name : " + user_name + " Interview_id : " + interview_id + " Triage_id : " + triage_id + " Triage_name : " + triage_name + " Triage_common_name : " + triage_common_name + "\n";
    }
}
