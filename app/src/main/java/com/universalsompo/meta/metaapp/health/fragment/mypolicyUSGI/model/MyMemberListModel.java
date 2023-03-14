package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model;

public class MyMemberListModel {
    private String Age;
    private String CoverageDetails;
    private String Date_Of_Birth;
    private String E_Card_URL;
    private String Exclusions;
    private String Name;
    private String PolicyURL;
    private String RelationShip;

    public MyMemberListModel(String age, String coverageDetails, String date_Of_Birth, String e_Card_URL, String exclusions, String name, String policyURL, String relationShip)  //Anirudh
    {
        Age = age;
        CoverageDetails = coverageDetails;
        Date_Of_Birth = date_Of_Birth;
        E_Card_URL = e_Card_URL;
        Exclusions = exclusions;
        Name = name;
        PolicyURL = policyURL;
        RelationShip = relationShip;
    }

    public String getAge() {
        return Age;
    }

    public String getCoverageDetails() {
        return CoverageDetails;
    }

    public String getDate_Of_Birth() {
        return Date_Of_Birth;
    }

    public String getE_Card_URL() {
        return E_Card_URL;
    }

    public String getExclusions() {
        return Exclusions;
    }

    public String getName() {
        return Name;
    }

    public String getPolicyURL() {
        return PolicyURL;
    }

    public String getRelationShip() {
        return RelationShip;
    }
}
