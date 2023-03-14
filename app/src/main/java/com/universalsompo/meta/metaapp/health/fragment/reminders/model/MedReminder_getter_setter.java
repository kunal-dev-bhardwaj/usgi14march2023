package com.universalsompo.meta.metaapp.health.fragment.reminders.model;

public class MedReminder_getter_setter {
    private String user_id, time, id, active_deactive;

    public MedReminder_getter_setter(String user_id, String time, String id, String active_deactive){
        this.user_id = user_id;

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
}
