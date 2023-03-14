package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model;

public class BasicQuestion {
    public static final String TABLE_NAME = "basic_question";
    public static final String BASIC_USER_ID = "basic_user_id";
    public static final String BASIC_USER_NAME = "basic_user_name";
    public static final String BASIC_INTERVIEW_ID = "basic_interview_id";
    public static final String QUES_TYPE = "ques_type";
    public static final String QUES_TEXT = "ques_text";
    public static final String BASIC_SYMPTOM_ID = "basic_symptom_id";
    public static final String BASIC_SYMPTOM_NAME = "basic_symptom_name";
    public static final String BASIC_INITIAL = "basic_init";
    public static final String BASIC_CHOICE_ID = "basic_choice_id";
    public static final String BASIC_DATE = "basic_date";
    public static final String BASIC_FRAGMENT_NAME = "basic_fragment_name";

    private String basic_user_id, basic_user_name, basic_interview_id, basic_symptom_id;
    private String basic_symp_name, basic_ques_type, basic_ques_txt;
    private String basic_init;
    private String basic_choice_id;
    private String basic_date;
    private String basic_fragment_name;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + BASIC_USER_ID + " TEXT,"
                    + BASIC_USER_NAME + " TEXT,"
                    + BASIC_INTERVIEW_ID + " TEXT,"
                    + QUES_TYPE + " TEXT,"
                    + QUES_TEXT + " TEXT,"
                    + BASIC_SYMPTOM_ID + " TEXT,"
                    + BASIC_SYMPTOM_NAME + " TEXT,"
                    + BASIC_INITIAL + " TEXT,"
                    + BASIC_CHOICE_ID + " TEXT,"
                    + BASIC_DATE + " TEXT,"
                    + BASIC_FRAGMENT_NAME + " TEXT"
                    + ")";

    public BasicQuestion(){}

    public BasicQuestion(String basic_user_id, String basic_user_name, String basic_interview_id, String ques_type, String ques_txt, String basic_symptom_id, String basic_symp_name, String basic_init, String basic_choice_id, String basic_date, String basic_fragment_name){
        this.basic_user_id = basic_user_id;
        this.basic_user_name = basic_user_name;
        this.basic_interview_id = basic_interview_id;
        this.basic_ques_type = ques_type;
        this.basic_ques_txt = ques_txt;
        this.basic_symptom_id = basic_symptom_id;
        this.basic_symp_name = basic_symp_name;
        this.basic_init = basic_init;
        this.basic_choice_id = basic_choice_id;
        this.basic_date = basic_date;
        this.basic_fragment_name = basic_fragment_name;
    }

    public String getbasicUserid() {
        return basic_user_id;
    }

    public void setbasicUserid(String basic_user_id) {
        this.basic_user_id = basic_user_id;
    }

    public String getbasicUsername() {
        return basic_user_name;
    }

    public void setbasicUsername(String basic_user_name) {
        this.basic_user_name = basic_user_name;
    }

    public String getbasicInterviewid() {
        return basic_interview_id;
    }

    public void setbasicInterviewid(String basic_interview_id) {
        this.basic_interview_id = basic_interview_id;
    }

    public String getbasicQuestype() {
        return basic_ques_type;
    }

    public void setbasicQuestype(String basic_ques_type) {
        this.basic_ques_type = basic_ques_type;
    }

    public String getbasicQuestxt() {
        return basic_ques_txt;
    }

    public void setbasicQuestxt(String basic_ques_txt) {
        this.basic_ques_txt = basic_ques_txt;
    }

    public String getbasicSymptomid() {
        return basic_symptom_id;
    }

    public void setbasicSymptomid(String basic_symptom_id) {
        this.basic_symptom_id = basic_symptom_id;
    }

    public String getbasicName() {
        return basic_symp_name;
    }

    public void setbasicName(String basic_symp_name) {
        this.basic_symp_name = basic_symp_name;
    }

    public String getbasicInit() {
        return basic_init;
    }

    public void setbasicInit(String basic_init) {
        this.basic_init = basic_init;
    }

    public String getbasicChoiceid() {
        return basic_choice_id;
    }

    public void setbasicChoiceid(String basic_choice_id) {
        this.basic_choice_id = basic_choice_id;
    }

    public String getbasicDate() {
        return basic_date;
    }

    public void setbasicDate(String basic_date) {
        this.basic_date = basic_date;
    }

    public String getbasicFragmentname() {
        return basic_fragment_name;
    }

    public void setbasicFragmentname(String basic_fragment_name) {
        this.basic_fragment_name = basic_fragment_name;
    }

    public String toString(){
        return "basic_User_id : " + basic_user_id + " basic_User_name : " + basic_user_name + " basic_Interview_id : " + basic_interview_id + " basic_Symptom_id : " + basic_symptom_id + " basic_Symptom_name : " + basic_symp_name + " basic_Initial : " + basic_init + " basic_Choice_id : " + basic_choice_id + " basic_Date : " + basic_date + " basic_Fragment_name : " + basic_fragment_name + "\n";
    }
}
