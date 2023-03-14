package com.universalsompo.meta.metaapp.health.fragment.reminders.database.models;

public class WeightReminder {
    public static final String TABLE_NAME = "weight_reminders";
    public static final String USER_ID = "user_id";
    public static final String WEEKLY_MONTHLY = "weekly_monthly";
    public static final String DAY = "day";
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String WEIGHT_REMIN_ID = "id";
    public static final String ACTIVE_DEACTIVE = "active_deactive";

    private String user_id, weekly_monthly, day, date, time, id, active_deactive;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + WEEKLY_MONTHLY + " TEXT,"
                    + DAY + " TEXT,"
                    + DATE + " TEXT,"
                    + TIME + " TEXT,"
                    + WEIGHT_REMIN_ID + " TEXT,"
                    + ACTIVE_DEACTIVE + " TEXT"
                    + ")";

    public WeightReminder(){}

    public WeightReminder(String user_id, String weekly_monthly, String day, String date, String time, String id, String active_deactive){
        this.user_id = user_id;
        this.weekly_monthly = weekly_monthly;
        this.day = day;
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

    public String getWeeklymonthly() {
        return weekly_monthly;
    }

    public void setWeeklymonthly(String weekly_monthly) {
        this.weekly_monthly = weekly_monthly;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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
        return "User_id : " + user_id + " Weekly_monthly : " + weekly_monthly + " Day : " + day + " Date : " + date + " Time : " + time + " Id : " + id + " Active_Deactive : " + active_deactive + "\n";
    }
}
