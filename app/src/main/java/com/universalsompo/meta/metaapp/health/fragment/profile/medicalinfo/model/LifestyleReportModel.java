package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model;

public class LifestyleReportModel {
    private String Date;
    private String FileName;
    private String FilePath;

    public LifestyleReportModel(String date, String fileName, String filePath)
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
