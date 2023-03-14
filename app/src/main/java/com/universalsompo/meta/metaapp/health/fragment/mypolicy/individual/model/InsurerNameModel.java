package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model;

public class InsurerNameModel {
    String InsCompanyID;
    String InsCompanyName;

    public InsurerNameModel(String insCompanyID, String insCompanyName)
    {
        InsCompanyID = insCompanyID;
        InsCompanyName = insCompanyName;
    }

    public String getInsCompanyID() {
        return InsCompanyID;
    }

    public String getInsCompanyName() {
        return InsCompanyName;
    }
}
