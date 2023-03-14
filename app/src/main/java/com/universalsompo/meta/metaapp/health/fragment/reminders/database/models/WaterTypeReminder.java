package com.universalsompo.meta.metaapp.health.fragment.reminders.database.models;

public class WaterTypeReminder {
    public static final String TABLE_NAME = "water_type_reminder";
    public static final String USER_ID = "user_id";
    public static final String TYPE_OF_REMINDER = "type_of_reminder";
    public static final String TIME_OF_INTERVAL = "type_of_interval";
    public static final String START_TIME = "start_time";
    public static final String END_TIME = "end_time";
    public static final String NO_OF_TIMES = "no_of_times";
    public static final String ACTIVE_DEACTIVE = "active_deactive";
    private String user_id;
    private String type_of_reminder;
    private String type_of_interval;
    private String start_time;
    private String end_time;
    private String no_of_times;

    public String getNo_of_times() {
        return no_of_times;
    }

    public void setNo_of_times(String no_of_times) {
        this.no_of_times = no_of_times;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getType_of_reminder() {
        return type_of_reminder;
    }

    public void setType_of_reminder(String type_of_reminder) {
        this.type_of_reminder = type_of_reminder;
    }

    public String getType_of_interval() {
        return type_of_interval;
    }

    public void setType_of_interval(String type_of_interval) {
        this.type_of_interval = type_of_interval;
    }


    public String getActive_deactive() {
        return active_deactive;
    }

    public void setActive_deactive(String active_deactive) {
        this.active_deactive = active_deactive;
    }

    private String active_deactive;

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + TYPE_OF_REMINDER + " TEXT,"
                    + TIME_OF_INTERVAL + " TEXT,"
                    + START_TIME + " TEXT,"
                    + END_TIME + " TEXT,"
                    + NO_OF_TIMES + " TEXT,"
                    + ACTIVE_DEACTIVE + " TEXT"
                    + ")";
    public WaterTypeReminder(){}


    public String toString(){
        return "User_id : " + user_id + " Type_of_reminder : " + type_of_reminder + " Type_of_interval : " + type_of_interval + " Start_time : " + start_time + " End_time : " + end_time + " No_of_times : " + no_of_times + " Active_deactive : " + active_deactive + "\n";
    }
}
