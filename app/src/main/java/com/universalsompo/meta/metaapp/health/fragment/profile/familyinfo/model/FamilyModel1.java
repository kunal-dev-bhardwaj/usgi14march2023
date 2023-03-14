package com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.model;

public class FamilyModel1 {
    private String FamilyName;
    private String MobileNo;
    private String UserFamilyId;

    public FamilyModel1(String familyName, String mobileNo, String userFamilyId)
    {
        FamilyName = familyName;
        MobileNo = mobileNo;
        UserFamilyId = userFamilyId;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public String getUserFamilyId() {
        return UserFamilyId;
    }
}
