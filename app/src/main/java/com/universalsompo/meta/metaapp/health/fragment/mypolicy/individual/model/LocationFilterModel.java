package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model;

public class LocationFilterModel {
    private String Id;
    private String Name;

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public LocationFilterModel(String id, String name) {
        Id = id;
        Name = name;
    }
}
