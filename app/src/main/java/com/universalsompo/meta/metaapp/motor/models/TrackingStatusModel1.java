package com.universalsompo.meta.metaapp.motor.models;

public class TrackingStatusModel1{
    private String Status, Date;

    public TrackingStatusModel1(String status, String date) {
        this.Status = status;
        this.Date = date;
    }

    public String getStatus() {
        return Status;
    }

    public String getDate() {
        return Date;
    }
}
