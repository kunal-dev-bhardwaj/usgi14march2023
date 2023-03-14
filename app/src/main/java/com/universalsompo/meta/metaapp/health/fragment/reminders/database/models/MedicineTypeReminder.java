package com.universalsompo.meta.metaapp.health.fragment.reminders.database.models;

public class MedicineTypeReminder {
    public static final String TABLE_NAME = "medicine_reminder_db";
    public static final String USER_ID = "user_id";
    public static final String TIME = "time";
    public static final String MED_REMIN_ID = "id";
    public static final String ACTIVE_DEACTIVE = "active_deactive";

    private String user_id, date, time, id, active_deactive;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + TIME + " TEXT,"
                    + MED_REMIN_ID + " TEXT,"
                    + ACTIVE_DEACTIVE + " TEXT"
                    + ")";
    public MedicineTypeReminder(){}



    public MedicineTypeReminder(String user_id, String date, String time, String id, String active_deactive){
        this.user_id = user_id;
        this.date = date;
        this.time = time;
        this.id = id;
        this.active_deactive = active_deactive;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getActive_deactive() {
        return active_deactive;
    }

    public void setActive_deactive(String active_deactive) {
        this.active_deactive = active_deactive;
    }

    public String toString(){
        return "User_id : " + user_id + " Time : " + time + " Id : " + id + " Active_Deactive : " + active_deactive + "\n";
    }
}
