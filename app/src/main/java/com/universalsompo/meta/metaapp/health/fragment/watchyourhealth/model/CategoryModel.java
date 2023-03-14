package com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.model;

public class CategoryModel {
    private String Id;
    private String Name;

    public CategoryModel(String id,String name){
        Id = id;
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }
}
