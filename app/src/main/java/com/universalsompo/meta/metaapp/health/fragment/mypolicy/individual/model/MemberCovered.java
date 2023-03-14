package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model;

public class MemberCovered {
    private String MemberAge;
    private String MemberID;
    private String MemberName;
    private String MemberRelationship;

    public MemberCovered(String memberAge, String memberID, String memberName, String memberRelationship)
    {
        MemberAge = memberAge;
        MemberID = memberID;
        MemberName = memberName;
        MemberRelationship = memberRelationship;
    }

    public String getMemberAge() {
        return MemberAge;
    }

    public String getMemberID() {
        return MemberID;
    }

    public String getMemberName() {
        return MemberName;
    }

    public String getMemberRelationship() {
        return MemberRelationship;
    }
}
