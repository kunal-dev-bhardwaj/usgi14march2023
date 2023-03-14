package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model;

public class InsurerProductNameModel {
    String InsCompProductID;
    String InsCompProductName;

    public InsurerProductNameModel(String insCompProductID, String insCompProductName)
    {
        InsCompProductID = insCompProductID;
        InsCompProductName = insCompProductName;
    }

    public String getInsCompProductID() {
        return InsCompProductID;
    }

    public String getInsCompProductName() {
        return InsCompProductName;
    }
}
