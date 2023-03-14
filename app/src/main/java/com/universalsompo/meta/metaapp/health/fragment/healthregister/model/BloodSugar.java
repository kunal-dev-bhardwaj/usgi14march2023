package com.universalsompo.meta.metaapp.health.fragment.healthregister.model;

public class BloodSugar {
    private String Date;
    private String Fasting;
    private String FastingDiffrence;
    private String PP;
    private String PPDiffrence;

    public BloodSugar(String date, String fasting, String fastingDiffrence, String pP, String pPDiffrence)
    {
        Date = date;
        Fasting = fasting;
        FastingDiffrence = fastingDiffrence;
        PP = pP;
        PPDiffrence = pPDiffrence;
    }

    public String getDate() {
        return Date;
    }

    public String getFasting() {
        return Fasting;
    }

    public String getFastingDiffrence() {
        return FastingDiffrence;
    }

    public String getPP() {
        return PP;
    }

    public String getPPDiffrence() {
        return PPDiffrence;
    }
}
