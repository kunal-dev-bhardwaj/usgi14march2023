package com.universalsompo.meta.metaapp.health.HRA.database.model;

public class SelectedSymptom {
    public static final String TABLE_NAME = "symptom_selected";
    public static final String USER_ID = "user_id";
    public static final String INTERVIEW_ID = "interview_id";
    public static final String SYMPTOM_ID = "symptom_id";
    public static final String SYMPTOM_NAME = "symptom_name";
    public static final String INITIAL = "init";
    public static final String CHOICE_ID = "choice_id";

    private String user_id, interview_id, symptom_id;
    private String symp;
    private String init;
    private String choice_id;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + INTERVIEW_ID + " TEXT,"
                    + SYMPTOM_ID + " TEXT,"
                    + SYMPTOM_NAME + " TEXT,"
                    + INITIAL + " TEXT,"
                    + CHOICE_ID + " TEXT"
                    + ")";

    public SelectedSymptom(){}

    public SelectedSymptom(String user_id, String interview_id, String symptom_id, String symp, String init, String choice_id){
        this.user_id = user_id;
        this.interview_id = interview_id;
        this.symptom_id = symptom_id;
        this.symp = symp;
        this.init = init;
        this.choice_id = choice_id;
    }

    public String getUserid() {
        return user_id;
    }

    public void setUserid(String user_id) {
        this.user_id = user_id;
    }

    public String getInterviewid() {
        return interview_id;
    }

    public void setInterviewid(String interview_id) {
        this.interview_id = interview_id;
    }

    public String getSymptomid() {
        return symptom_id;
    }

    public void setSymptomid(String symptom_id) {
        this.symptom_id = symptom_id;
    }

    public String getName() {
        return symp;
    }

    public void setName(String symp) {
        this.symp = symp;
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
    }

    public String getChoiceid() {
        return choice_id;
    }

    public void setChoiceid(String choice_id) {
        this.choice_id = choice_id;
    }

    public String toString(){
        return "User_id : " + user_id + " Interview_id : " + interview_id + " Symptom_id : " + symptom_id + " Symptom_name : " + symp + " Initial : " + init + " Choice_id : " + choice_id + "\n";
    }
}
