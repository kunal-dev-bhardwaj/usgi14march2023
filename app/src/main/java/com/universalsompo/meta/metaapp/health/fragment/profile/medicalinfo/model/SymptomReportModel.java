package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model;

public class SymptomReportModel {
    private String Date;
    private String FileName;
    private String FilePath;

    public SymptomReportModel(String date, String fileName, String filePath)
    {
        Date = date;
        FileName = fileName;
        FilePath = filePath;
    }

    public String getDate() {
        return Date;
    }

    public String getFileName() {
        return FileName;
    }

    public String getFilePath() {
        return FilePath;
    }
}
