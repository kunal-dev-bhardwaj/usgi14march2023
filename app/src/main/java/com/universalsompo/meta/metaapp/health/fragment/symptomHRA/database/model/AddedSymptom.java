package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model;

public class AddedSymptom {
    public static final String TABLE_NAME = "user_symptom_added";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String INTERVIEW_ID = "interview_id";
    public static final String QUES_TYPE = "ques_type";
    public static final String QUES_TEXT = "ques_text";
    public static final String SYMPTOM_ID = "symptom_id";
    public static final String SYMPTOM_NAME = "symptom_name";
    public static final String INITIAL = "init";
    public static final String CHOICE_ID = "choice_id";
    public static final String DATE = "date";
    public static final String SYMPTOM_FRAG = "symptom_frag";

    private String user_id, user_name, interview_id, ques_type, ques_text, symptom_id, symptom_name, init, choice_id, date, symptom_frag;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + USER_NAME + " TEXT,"
                    + INTERVIEW_ID + " TEXT,"
                    + QUES_TYPE + " TEXT,"
                    + QUES_TEXT + " TEXT,"
                    + SYMPTOM_ID + " TEXT,"
                    + SYMPTOM_NAME + " TEXT,"
                    + INITIAL + " TEXT,"
                    + CHOICE_ID + " TEXT,"
                    + DATE + " TEXT,"
                    + SYMPTOM_FRAG + " TEXT"
                    + ")";

    public AddedSymptom(){}

    public AddedSymptom(String user_id, String user_name, String interview_id, String ques_type, String ques_text, String symptom_id, String symptom_name, String init, String choice_id, String date, String symptom_frag){
        this.user_id = user_id;
        this.user_name = user_name;
        this.interview_id = interview_id;
        this.ques_type = ques_type;
        this.ques_text = ques_text;
        this.symptom_id = symptom_id;
        this.symptom_name = symptom_name;
        this.init = init;
        this.choice_id = choice_id;
        this.date = date;
        this.symptom_frag = symptom_frag;
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

    public String getQuestype() {
        return ques_type;
    }

    public void setQuestype(String ques_type) {
        this.ques_type = ques_type;
    }

    public String getQuestext() {
        return ques_text;
    }

    public void setQuestext(String ques_text) {
        this.ques_text = ques_text;
    }

    public String getSymptomid() {
        return symptom_id;
    }

    public void setSymptomid(String symptom_id) {
        this.symptom_id = symptom_id;
    }

    public String getName() {
        return symptom_name;
    }

    public void setName(String symptom_name) {
        this.symptom_name = symptom_name;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSymptomfrag() {
        return symptom_frag;
    }

    public void setSymptomfrag(String symptom_frag) {
        this.symptom_frag = symptom_frag;
    }

    public String toString(){
        return "User_id : " + user_id + " User_name : " + user_name + " Interview_id : " + interview_id + " Ques_type : " + ques_type + " Ques_text : " + ques_text + " Symptom_id : " + symptom_id + " Symptom_name : " + symptom_name + " Initial : " + init + " Choice_id : " + choice_id + " Date : " + date + " Symptom_frag : " + symptom_frag + "\n";
    }
}
