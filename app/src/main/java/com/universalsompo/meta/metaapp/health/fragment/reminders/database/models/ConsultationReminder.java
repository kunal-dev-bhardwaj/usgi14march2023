package com.universalsompo.meta.metaapp.health.fragment.reminders.database.models;

public class ConsultationReminder {
    public static final String TABLE_NAME = "consultation_reminders";
    public static final String USER_ID = "user_id";
    public static final String DOCTOR_NAME = "doctor_name";
    public static final String DOCTOR_NUMBER = "doctor_number";
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String CON_REMIN_ID = "id";
    public static final String ACTIVE_DEACTIVE = "active_deactive";

    private String user_id, doctor_name, doctor_number, date, time, id, active_deactive;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + DOCTOR_NAME + " TEXT,"
                    + DOCTOR_NUMBER + " TEXT,"
                    + DATE + " TEXT,"
                    + TIME + " TEXT,"
                    + CON_REMIN_ID + " TEXT,"
                    + ACTIVE_DEACTIVE + " TEXT"
                    + ")";

    public ConsultationReminder(){}

    public ConsultationReminder(String user_id, String doctor_name, String doctor_number, String date, String time, String id, String active_deactive){
        this.user_id = user_id;
        this.doctor_name = doctor_name;
        this.doctor_number = doctor_number;
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

    public String getDoctorname() {
        return doctor_name;
    }

    public void setDoctorname(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctornumber() {
        return doctor_number;
    }

    public void setDoctornumber(String doctor_number) {
        this.doctor_number = doctor_number;
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
        return "User_id : " + user_id + " Doctor_name : " + doctor_name + " Doctor_number : " + doctor_number + " Date : " + date + " Time : " + time + " Id : " + id + " Active_Deactive : " + active_deactive + "\n";
    }
}
