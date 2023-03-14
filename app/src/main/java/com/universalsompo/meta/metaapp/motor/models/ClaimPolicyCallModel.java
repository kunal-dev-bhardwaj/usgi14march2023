package com.universalsompo.meta.metaapp.motor.models;

public class ClaimPolicyCallModel {
    private String InsCompNo;
    private String Title;
    private String Description;
    private String CoverageId;
    private String InsCompName;

    public String getInsCompName() {
        return InsCompName;
    }

    public String getInsCompNo() {
        return InsCompNo;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getCoverageId() {
        return CoverageId;
    }

    public ClaimPolicyCallModel(String insCompNo, String title, String description, String coverageId,String InsCompName) {
        InsCompNo = insCompNo;
        Title = title;
        Description = description;
        CoverageId = coverageId;
        this.InsCompName=InsCompName;
    }
}
