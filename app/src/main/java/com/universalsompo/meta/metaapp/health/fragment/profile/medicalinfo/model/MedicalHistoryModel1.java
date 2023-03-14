package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model;

/**
 * Created by Flash_Netcomm on 6/5/2018.
 */

public class MedicalHistoryModel1 {
    String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    String Id;

    public String getDiseaseId() {
        return DiseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        DiseaseId = diseaseId;
    }

    String DiseaseId;

}
