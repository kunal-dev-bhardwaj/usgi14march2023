package com.universalsompo.meta.metaapp.motor.models;

public class MotorHelp {
    private String CategoryName;
    private String ID;

    public MotorHelp(String categoryName, String id)
    {
        CategoryName = categoryName;
        ID = id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public String getID() {
        return ID;
    }
}
