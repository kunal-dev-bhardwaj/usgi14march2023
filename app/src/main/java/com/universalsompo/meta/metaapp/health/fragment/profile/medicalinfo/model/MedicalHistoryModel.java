package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model;

public class MedicalHistoryModel {
    private String ConditionID;
    private String ConditionName;
    private String IsUserSuffer;

    public MedicalHistoryModel(String conditionID, String conditionName, String isUserSuffer)
    {
        ConditionID = conditionID;
        ConditionName = conditionName;
        IsUserSuffer = isUserSuffer;
    }

    public String getConditionID() {
        return ConditionID;
    }

    public String getConditionName() {
        return ConditionName;
    }

    public String getIsUserSuffer() {
        return IsUserSuffer;
    }
}
