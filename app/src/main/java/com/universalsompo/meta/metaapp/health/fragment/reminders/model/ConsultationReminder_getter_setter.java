package com.universalsompo.meta.metaapp.health.fragment.reminders.model;

public class ConsultationReminder_getter_setter {
    private String user_id, doctor_name, doctor_number, date, time, id, active_deactive;

    public ConsultationReminder_getter_setter(String user_id, String doctor_name, String doctor_number, String date, String time, String id, String active_deactive){
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
}
