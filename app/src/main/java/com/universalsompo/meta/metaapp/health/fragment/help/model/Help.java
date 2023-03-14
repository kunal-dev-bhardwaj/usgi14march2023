package com.universalsompo.meta.metaapp.health.fragment.help.model;

public class Help {
    private String CategoryName;
    private String ID;

    public Help(String categoryName, String id)
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
