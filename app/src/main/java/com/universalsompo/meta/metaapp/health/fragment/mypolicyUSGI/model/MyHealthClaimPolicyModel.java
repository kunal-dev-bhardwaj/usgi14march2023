package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model;

public class MyHealthClaimPolicyModel {
    private String ClaimContactNumber;
    private String ClaimEmailID;
    private String Composition;
    private String ExpiryDate;
    private String InsCompLogoPath;
    private String InsCompName;
    private String IsClaimInitiated;
    private String PolicyID;
    private String Policy_Category;
    private String Policy_Holder_Name;
    private String Policy_Number;
    private String Premium;
    private String Product_Name;
    private String RemainingDay;
    private String SumInsured;

    public MyHealthClaimPolicyModel(String claimContactNumber, String claimEmailID, String composition, String expiryDate, String insCompLogoPath, String insCompName, String isClaimInitiated, String policyID, String policy_Category, String policy_Holder_Name, String policy_Number, String premium, String product_Name, String remainingDay, String sumInsured)  //Anirudh
    {
        ClaimContactNumber = claimContactNumber;
        ClaimEmailID = claimEmailID;
        Composition = composition;
        ExpiryDate = expiryDate;
        InsCompLogoPath = insCompLogoPath;
        InsCompName = insCompName;
        IsClaimInitiated = isClaimInitiated;
        PolicyID = policyID;
        Policy_Category = policy_Category;
        Policy_Holder_Name = policy_Holder_Name;
        Policy_Number = policy_Number;
        Premium = premium;
        Product_Name = product_Name;
        RemainingDay = remainingDay;
        SumInsured = sumInsured;
    }

    public String getClaimContactNumber() {
        return ClaimContactNumber;
    }

    public String getClaimEmailID() {
        return ClaimEmailID;
    }

    public String getComposition() {
        return Composition;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public String getInsCompLogoPath() {
        return InsCompLogoPath;
    }

    public String getInsCompName() {
        return InsCompName;
    }

    public String getIsClaimInitiated() {
        return IsClaimInitiated;
    }

    public String getPolicyID() {
        return PolicyID;
    }

    public String getPolicy_Category() {
        return Policy_Category;
    }

    public String getPolicy_Holder_Name() {
        return Policy_Holder_Name;
    }

    public String getPolicy_Number() {
        return Policy_Number;
    }

    public String getPremium() {
        return Premium;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public String getRemainingDay() {
        return RemainingDay;
    }

    public String getSumInsured() {
        return SumInsured;
    }
}
