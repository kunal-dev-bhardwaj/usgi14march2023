package com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.model;

public class FamilyModel {
    private String Age;
    private String FamilyName;
    private String MobileNo;
    private String Relationship;
    private String UserFamilyId;

    public FamilyModel(String age, String familyName, String mobileNo, String relationship, String userFamilyId)
    {
        Age = age;
        FamilyName = familyName;
        MobileNo = mobileNo;
        Relationship = relationship;
        UserFamilyId = userFamilyId;
    }

    public String getAge() {
        return Age;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public String getRelationship() {
        return Relationship;
    }

    public String getUserFamilyId() {
        return UserFamilyId;
    }
}
