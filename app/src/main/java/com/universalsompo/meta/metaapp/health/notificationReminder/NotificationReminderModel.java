package com.universalsompo.meta.metaapp.health.notificationReminder;

public class NotificationReminderModel {
    public static final String TABLE_NAME = "notification_reminders";
    public static final String USER_ID = "user_id";
    public static final String ACTIVITY_NAME = "activity_name";
    public static final String PENDING_INTENT = "pending_intent";
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String STATUS = "status";
    public static final String ACTIVE_DEACTIVE = "active_deactive";

    private String user_id, activity_name, pending_intent, date, time, status, active_deactive;

    public NotificationReminderModel(String user_id,String activity_name, String pending_intent,
                                     String date, String time, String status, String active_deactive){
        this.user_id = user_id;
        this.activity_name = activity_name;
        this.pending_intent = pending_intent;
        this.date = date;
        this.time = time;
        this.status = status;
        this.active_deactive = active_deactive;

    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " TEXT,"
                    + ACTIVITY_NAME + " TEXT,"
                    + PENDING_INTENT + " TEXT,"
                    + DATE + " TEXT,"
                    + TIME + " TEXT,"
                    + STATUS + " TEXT,"
                    + ACTIVE_DEACTIVE + " TEXT"
                    + ")";

    public NotificationReminderModel() {
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getPending_intent() {
        return pending_intent;
    }

    public void setPending_intent(String pending_intent) {
        this.pending_intent = pending_intent;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActive_deactive() {
        return active_deactive;
    }

    public void setActive_deactive(String active_deactive) {
        this.active_deactive = active_deactive;
    }

    public String toString(){
        return "User_id : " + user_id + " Activity_name : " + activity_name + " Pending_intent : " + pending_intent + " Date : " + date + " Time : " + time + " Status : " + status + " Active_Deactive : " + active_deactive + "\n";
    }
}
