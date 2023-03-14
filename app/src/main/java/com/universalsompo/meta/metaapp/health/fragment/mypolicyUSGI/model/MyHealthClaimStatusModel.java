package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model;

public class MyHealthClaimStatusModel {
    private String ClaimNo;
    private String ExpiryDate;
    private String InsuredName;
    private String InsurerName;
    private String PolicyId;
    private String PolicyNumber;
    private String Product_Name;
    private String SumInsured;

    public MyHealthClaimStatusModel(String claimNo, String expiryDate, String insuredName, String insurerName, String policyId, String policyNumber, String product_Name, String sumInsured)
    {
        ClaimNo = claimNo;
        ExpiryDate = expiryDate;
        InsuredName = insuredName;
        InsurerName = insurerName;
        PolicyId = policyId;
        PolicyNumber = policyNumber;
        Product_Name = product_Name;
        SumInsured = sumInsured;
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

    public String getPolicyId() {
        return PolicyId;
    }

    public String getPolicyNumber() {
        return PolicyNumber;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public String getSumInsured() {
        return SumInsured;
    }
}
