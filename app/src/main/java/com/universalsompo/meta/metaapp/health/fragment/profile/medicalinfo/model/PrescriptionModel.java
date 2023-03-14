package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model;

public class PrescriptionModel {
    private String ConsultDate;
    private String MedRecordID;
    private String PatientName;
    private String ReportPath;

    public PrescriptionModel(String consultDate, String medRecordID, String patientName, String reportPath)
    {
        ConsultDate = consultDate;
        MedRecordID = medRecordID;
        PatientName = patientName;
        ReportPath = reportPath;
    }

    public String getConsultDate() {
        return ConsultDate;
    }

    public String getMedRecordID() {
        return MedRecordID;
    }

    public String getPatientName() {
        return PatientName;
    }

    public String getReportPath() {
        return ReportPath;
    }
}
