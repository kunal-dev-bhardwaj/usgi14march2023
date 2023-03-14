package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model;

public class Conditions {
    public static final String TABLE_NAME = "condition";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String INTERVIEW_ID = "interview_id";
    public static final String CONDITION_ID = "condition_id";
    public static final String CONDITION_NAME = "condition_name";
    public static final String CONDITION_COMMON_NAME = "condition_common_name";
    public static final String CONDITION_PROBABILITY = "condition_probability";

    private String user_id, user_name, interview_id;
    private String condition_id, condition_name, condition_common_name, condition_probability;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + USER_NAME + " TEXT,"
                    + INTERVIEW_ID + " TEXT,"
                    + CONDITION_ID + " TEXT,"
                    + CONDITION_NAME + " TEXT,"
                    + CONDITION_COMMON_NAME + " TEXT,"
                    + CONDITION_PROBABILITY + " TEXT"
                    + ")";

    public Conditions(){}

    public Conditions(String user_id, String user_name, String interview_id, String condition_id, String condition_name, String condition_common_name, String condition_probability){
        this.user_id = user_id;
        this.user_name = user_name;
        this.interview_id = interview_id;
        this.condition_id = condition_id;
        this.condition_name = condition_name;
        this.condition_common_name = condition_common_name;
        this.condition_probability = condition_probability;
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

    public String getConditionid() {
        return condition_id;
    }

    public void setConditionid(String condition_id) {
        this.condition_id = condition_id;
    }

    public String getConditionname() {
        return condition_name;
    }

    public void setConditionname(String condition_name) {
        this.condition_name = condition_name;
    }

    public String getConditioncommonname() {
        return condition_common_name;
    }

    public void setConditioncommonname(String condition_common_name) {
        this.condition_common_name = condition_common_name;
    }

    public String getConditionprobability() {
        return condition_probability;
    }

    public void setConditionprobability(String condition_probability) {
        this.condition_probability = condition_probability;
    }

    public String toString(){
        return "User_id : " + user_id + " User_name : " + user_name + " Interview_id : " + interview_id + " Condition_id : " + condition_id + " Condition_name : " + condition_name + " Condition_common_name : " + condition_common_name + " Condition_probability : " + condition_probability + "\n";
    }
}
