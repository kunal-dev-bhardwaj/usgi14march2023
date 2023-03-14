package com.universalsompo.meta.metaapp.motor.models;

public class ClaimStatusPolicy {
    private String ClaimNo;
    private String ExpiryDate;
    private String InsuredName;
    private String InsurerName;
    private String Make;
    private String Model;
    private String PolicyId;
    private String PolicyNumber;
    private String Variant;
    private String VechileRegNo;
    private String VechileType;

    public ClaimStatusPolicy(String claimNo, String expiryDate, String insuredName, String insurerName, String make, String model, String policyId, String policyNumber, String variant, String vechileRegNo, String vechileType)  //Anirudh
    {
        ClaimNo = claimNo;
        ExpiryDate = expiryDate;
        InsuredName = insuredName;
        InsurerName = insurerName;
        Make = make;
        Model = model;
        PolicyId = policyId;
        PolicyNumber = policyNumber;
        Variant = variant;
        VechileRegNo = vechileRegNo;
        VechileType = vechileType;
    }

    public String getClaimNo() {
        return ClaimNo;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public String getInsuredName() {
        return InsuredName;
    }

    public String getInsurerName() {
        return InsurerName;
    }

    public String getMake() {
        return Make;
    }

    public String getModel() {
        return Model;
    }

    public String getPolicyId() {
        return PolicyId;
    }

    public String getPolicyNumber() {
        return PolicyNumber;
    }

    public String getVariant() {
        return Variant;
    }

    public String getVechileRegNo() {
        return VechileRegNo;
    }

    public String getVechileType() {
        return VechileType;
    }
}
