package com.universalsompo.meta.metaapp.motor.models;

public class ClaimFilterModel {
    private String Id;
    private String Name;
    private String veh_type;

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getVeh_type() {
        return veh_type;
    }

    public ClaimFilterModel(String id, String name) {
        Id = id;
        Name = name;
    }

    public ClaimFilterModel(String Id, String Name, String veh_type) {
        this.Id = Id;
        this.Name = Name;
        this.veh_type=veh_type;
    }
}
