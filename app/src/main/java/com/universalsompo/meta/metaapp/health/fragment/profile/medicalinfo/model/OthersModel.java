package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model;

public class OthersModel {
    private String Date;
    private String DocID;
    private String DocumentPath;
    private String PatientName;

    public OthersModel(String date, String docID, String documentPath, String patientName)
    {
        Date = date;
        DocID = docID;
        DocumentPath = documentPath;
        PatientName = patientName;
    }

    public String getDate() {
        return Date;
    }

    public String getDocID() {
        return DocID;
    }

    public String getDocumentPath() {
        return DocumentPath;
    }

    public String getPatientName() {
        return PatientName;
    }
}
