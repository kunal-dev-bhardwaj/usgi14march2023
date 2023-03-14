package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model;

public class Allergy {
    private String Allergies;
    private String AllergiesID;
    private String AllergiesType;
    private String AllergiesTypeID;
    private String ID;
    private String Reaction;
    private String ReactionID;

    public Allergy(String allergies, String allergiesID, String allergiesType, String allergiesTypeID, String iD, String reaction, String reactionID)
    {
        Allergies = allergies;
        AllergiesID = allergiesID;
        AllergiesType = allergiesType;
        AllergiesTypeID = allergiesTypeID;
        ID = iD;
        Reaction = reaction;
        ReactionID = reactionID;
    }

    public String getAllergies() {
        return Allergies;
    }

    public String getAllergiesID() {
        return AllergiesID;
    }

    public String getAllergiesType() {
        return AllergiesType;
    }

    public String getAllergiesTypeID() {
        return AllergiesTypeID;
    }

    public String getID() {
        return ID;
    }

    public String getReaction() {
        return Reaction;
    }

    public String getReactionID() {
        return ReactionID;
    }
}
