package com.universalsompo.meta.metaapp.health.fragment.reminders.database.models;

public class LabTestReminder {
    public static final String TABLE_NAME = "lab_test_reminders";
    public static final String USER_ID = "user_id";
    public static final String TEST_NAME = "test_name";
    public static final String LAB_NAME = "lab_name";
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String LAB_REMIN_ID = "id";
    public static final String ACTIVE_DEACTIVE = "active_deactive";

    private String user_id, test_name, lab_name, date, time, id, active_deactive;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + TEST_NAME + " TEXT,"
                    + LAB_NAME + " TEXT,"
                    + DATE + " TEXT,"
                    + TIME + " TEXT,"
                    + LAB_REMIN_ID + " TEXT,"
                    + ACTIVE_DEACTIVE + " TEXT"
                    + ")";

    public LabTestReminder(){}

    public LabTestReminder(String user_id, String test_name, String lab_name, String date, String time, String id, String active_deactive){
        this.user_id = user_id;
        this.test_name = test_name;
        this.lab_name = lab_name;
        this.date = date;
        this.time = time;
        this.id = id;
        this.active_deactive = active_deactive;
    }

    public String getUserid() {
        return user_id;
    }

    public void setUserid(String user_id) {
        this.user_id = user_id;
    }

    public String getTestname() {
        return test_name;
    }

    public void setTestname(String test_name) {
        this.test_name = test_name;
    }

    public String getLabname() {
        return lab_name;
    }

    public void setLabname(String lab_name) {
        this.lab_name = lab_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivedeactive() {
        return active_deactive;
    }

    public void setActivedeactive(String active_deactive) {
        this.active_deactive = active_deactive;
    }

    public String toString(){
        return "User_id : " + user_id + " Test_name : " + test_name + " Lab_name : " + lab_name + " Date : " + date + " Time : " + time + " Id : " + id + " Active_Deactive : " + active_deactive + "\n";
    }
}
