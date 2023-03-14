package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model;

public class ReportsModel {
    private String PatientName;
    private String ReportID;
    private String ReportPath;
    private String TestDate;

    public ReportsModel(String patientName, String reportID, String reportPath, String testDate)
    {
        PatientName = patientName;
        ReportID = reportID;
        ReportPath = reportPath;
        TestDate = testDate;
    }

    public String getPatientName() {
        return PatientName;
    }

    public String getReportID() {
        return ReportID;
    }

    public String getReportPath() {
        return ReportPath;
    }

    public String getTestDate() {
        return TestDate;
    }
}
