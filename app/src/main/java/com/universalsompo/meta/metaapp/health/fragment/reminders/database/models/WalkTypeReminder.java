package com.universalsompo.meta.metaapp.health.fragment.reminders.database.models;

public class WalkTypeReminder {
    public static final String TABLE_NAME = "walk_type_reminder";
    public static final String USER_ID = "user_id";
    public static final String TYPE_OF_REMINDER = "type_of_reminder";
    public static final String TIME_OF_WALK = "time_of_walk";
    public static final String TIME = "time";
    public static final String ACTIVE_DEACTIVE = "active_deactive";
    public static final String SELECTED_DAYS = "selected_days";

    private String user_id, type_of_reminder, time_of_walk, time, active_deactive, selected_days;
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + TYPE_OF_REMINDER + " TEXT,"
                    + TIME_OF_WALK + " TEXT,"
                    + TIME + " TEXT,"
                    + ACTIVE_DEACTIVE + " TEXT,"
                    + SELECTED_DAYS + " TEXT"
                    + ")";
    public WalkTypeReminder(){}

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

    public String getTime_of_walk() {
        return time_of_walk;
    }

    public void setTime_of_walk(String time_of_walk) {
        this.time_of_walk = time_of_walk;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getActive_deactive() {
        return active_deactive;
    }

    public void setActive_deactive(String active_deactive) {
        this.active_deactive = active_deactive;
    }

    public String getSelected_days() {
        return selected_days;
    }

    public void setSelected_days(String selected_days) {
        this.selected_days = selected_days;
    }

    public String toString(){
        return "User_id : " + user_id + " Type_of_reminder : " + type_of_reminder + " Time_of_walk : " + time_of_walk + " Time : " + time + " Active_deactive : " + active_deactive + " Selected_days : " + selected_days + "\n";
    }
}
