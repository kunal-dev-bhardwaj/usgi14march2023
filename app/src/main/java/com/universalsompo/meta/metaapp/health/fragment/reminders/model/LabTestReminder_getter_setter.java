package com.universalsompo.meta.metaapp.health.fragment.reminders.model;

public class LabTestReminder_getter_setter {
    private String user_id, test_name, lab_name, date, time, id, active_deactive;

    public LabTestReminder_getter_setter(String user_id, String test_name, String lab_name, String date, String time, String id, String active_deactive){
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
}
