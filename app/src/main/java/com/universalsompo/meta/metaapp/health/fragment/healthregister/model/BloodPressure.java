package com.universalsompo.meta.metaapp.health.fragment.healthregister.model;

public class BloodPressure {
    private String Date;
    private String Diastolic;
    private String DiastolicDiffrence;
    private String Systolic;
    private String SystolicDiffrence;

    public BloodPressure(String date, String diastolic, String diastolicDiffrence, String systolic, String systolicDiffrence)
    {
        Date = date;
        Diastolic = diastolic;
        DiastolicDiffrence = diastolicDiffrence;
        Systolic = systolic;
        SystolicDiffrence = systolicDiffrence;
    }

    public String getDate() {
        return Date;
    }

    public String getDiastolic() {
        return Diastolic;
    }

    public String getDiastolicDiffrence() {
        return DiastolicDiffrence;
    }

    public String getSystolic() {
        return Systolic;
    }

    public String getSystolicDiffrence() {
        return SystolicDiffrence;
    }
}
