package com.universalsompo.meta.metaapp.health.fragment.weightlog.model;

public class LoggedWeight {
    private String Date;
    private String ImagePath;
    private String Weight;

    public LoggedWeight(String date, String imagePath, String weight)
    {
        Date = date;
        ImagePath = imagePath;
        Weight = weight;
    }

    public String getDate() {
        return Date;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public String getWeight() {
        return Weight;
    }
}
