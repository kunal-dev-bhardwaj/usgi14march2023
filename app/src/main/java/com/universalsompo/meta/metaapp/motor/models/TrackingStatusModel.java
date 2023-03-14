package com.universalsompo.meta.metaapp.motor.models;

import android.content.Context;

public class TrackingStatusModel {
    private String policy_no,reg_no,ref_no;
    private String status_date,status_detail,status_time,vehicleType;
    private Context context;

    public TrackingStatusModel(String policy_no, String reg_no, String ref_no, String vehicleType) {
        this.policy_no = policy_no;
        this.reg_no = reg_no;
        this.ref_no = ref_no;
        this.vehicleType=vehicleType;
    }

    public String getPolicy_no() {
        return policy_no;
    }

    public String getReg_no() {
        return reg_no;
    }

    public String getRef_no() {
        return ref_no;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public TrackingStatusModel(Context context,String status_time,String status_date, String status_detail) {
        this.status_date = status_date;
        this.status_detail = status_detail;
        this.status_time=status_time;
        this.context=context;

    }

    public String getStatus_time() {
        return status_time;
    }

    public Context getContext() {
        return context;
    }

    public String getStatus_date() {
        return status_date;
    }

    public String getStatus_detail() {
        return status_detail;
    }
}
