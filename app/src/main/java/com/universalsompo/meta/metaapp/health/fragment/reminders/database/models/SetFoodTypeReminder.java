package com.universalsompo.meta.metaapp.health.fragment.reminders.database.models;

public class SetFoodTypeReminder {
    public static final String TABLE_NAME = "set_food_type_reminder";
    public static final String USER_ID = "user_id";
    public static final String TYPE_OF_REMINDER = "type_of_reminder";
    public static final String TYPE_OF_MEAL = "type_of_meal";
    public static final String TIME = "time";
    public static final String ACTIVE_DEACTIVE = "active_deactive";

    private String user_id, type_of_reminder, type_of_meal, time, active_deactive;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + TYPE_OF_REMINDER + " TEXT,"
                    + TYPE_OF_MEAL + " TEXT,"
                    + TIME + " TEXT,"
                    + ACTIVE_DEACTIVE + " TEXT"
                    + ")";

    public SetFoodTypeReminder(){}

    public SetFoodTypeReminder(String user_id, String type_of_reminder, String type_of_meal, String time, String active_deactive){
        this.user_id = user_id;
        this.type_of_reminder = type_of_reminder;
        this.type_of_meal = type_of_meal;
        this.time = time;
        this.active_deactive = active_deactive;
    }

    public String getUserid() {
        return user_id;
    }

    public void setUserid(String user_id) {
        this.user_id = user_id;
    }

    public String getTypeofreminder() {
        return type_of_reminder;
    }

    public void setTypeofreminder(String type_of_reminder) {
        this.type_of_reminder = type_of_reminder;
    }

    public String getTypeofmeal() {
        return type_of_meal;
    }

    public void setTypeofmeal(String type_of_meal) {
        this.type_of_meal = type_of_meal;
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

    public String toString(){
        return "User_id : " + user_id + " Type_of_reminder : " + type_of_reminder + " Type_of_meal : " + type_of_meal + " Time : " + time + " Active_deactive : " + active_deactive + "\n";
    }
}
