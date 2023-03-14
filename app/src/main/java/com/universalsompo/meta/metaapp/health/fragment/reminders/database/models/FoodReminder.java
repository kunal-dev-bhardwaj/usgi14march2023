package com.universalsompo.meta.metaapp.health.fragment.reminders.database.models;

public class FoodReminder {
    public static final String TABLE_NAME = "types_of_reminders";
    public static final String USER_ID = "user_id";
    public static final String TYPE_OF_ALARM = "type_of_alarm";
    public static final String ACTIVE_DEACTIVE = "active_deactive";

    private String user_id, type_of_alarm, active_deactive;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + TYPE_OF_ALARM + " TEXT,"
                    + ACTIVE_DEACTIVE + " TEXT"
                    + ")";

    public FoodReminder(){}

    public FoodReminder(String user_id, String type_of_alarm, String active_deactive){
        this.user_id = user_id;
        this.type_of_alarm = type_of_alarm;
        this.active_deactive = active_deactive;
    }

    public String getUserid() {
        return user_id;
    }

    public void setUserid(String user_id) {
        this.user_id = user_id;
    }

    public String getTypeofalarm() {
        return type_of_alarm;
    }

    public void setTypeofalarm(String type_of_alarm) {
        this.type_of_alarm = type_of_alarm;
    }

    public String getActive_deactive() {
        return active_deactive;
    }

    public void setActive_deactive(String active_deactive) {
        this.active_deactive = active_deactive;
    }

    public String toString(){
        return "User_id : " + user_id + " Type_of_alarm : " + type_of_alarm + " Active_deactive : " + active_deactive + "\n";
    }
}
