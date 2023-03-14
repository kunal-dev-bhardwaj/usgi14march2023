package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model;

public class OwnPolicyHealth {
    private String ContactNo;
    private String DayRemaining;
    private String EmailID;
    private String ExpiryDate;
    private String InsCompLogoPath;
    private String InsuranceComp;
    private String InsuranceCompID;
    private String IsClaimInitiated;
    private String PolicyDocPath;
    private String PolicyFlag;
    private String PolicyID;
    private String PolicyNo;
    private String SumInsured;
    private String YearlyPremium;

    public OwnPolicyHealth(String contactno, String dayRemaining, String emailid, String expiryDate, String insCompLogoPath, String insComp, String insCompId, String isClaimInitiated, String policyDocPath, String policyflag, String policyId, String policyNo, String sumInsured, String yearlyPremium)
    {
        ContactNo = contactno;
        DayRemaining = dayRemaining;
        EmailID = emailid;
        ExpiryDate = expiryDate;
        InsCompLogoPath = insCompLogoPath;
        InsuranceComp = insComp;
        InsuranceCompID = insCompId;
        IsClaimInitiated = isClaimInitiated;
        PolicyDocPath =  policyDocPath;
        PolicyFlag =  policyflag;
        PolicyID = policyId;
        PolicyNo = policyNo;
        SumInsured = sumInsured;
        YearlyPremium = yearlyPremium;
    }

    public OwnPolicyHealth(String dayRemaining, String expiryDate, String insCompLogoPath, String insComp, String insCompId, String policyDocPath, String policyId, String policyNo, String sumInsured, String yearlyPremium)
    {
        DayRemaining = dayRemaining;
        ExpiryDate = expiryDate;
        InsCompLogoPath = insCompLogoPath;
        InsuranceComp = insComp;
        InsuranceCompID = insCompId;
        PolicyDocPath =  policyDocPath;
        PolicyID = policyId;
        PolicyNo = policyNo;
        SumInsured = sumInsured;
        YearlyPremium = yearlyPremium;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public String getDayRemaining() {
        return DayRemaining;
    }

    public String getEmailID() {
        return EmailID;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public String getInsCompLogoPath() {
        return InsCompLogoPath;
    }

    public String getInsuranceComp() {
        return InsuranceComp;
    }

    public String getInsuranceCompID() {
        return InsuranceCompID;
    }

    public String getIsClaimInitiated() {
        return IsClaimInitiated;
    }

    public String getPolicyDocPath() {
        return PolicyDocPath;
    }

    public String getPolicyFlag() {
        return PolicyFlag;
    }

    public String getPolicyID() {
        return PolicyID;
    }

    public String getPolicyNo() {
        return PolicyNo;
    }

    public String getSumInsured() {
        return SumInsured;
    }

    public String getYearlyPremium() {
        return YearlyPremium;
    }
}
