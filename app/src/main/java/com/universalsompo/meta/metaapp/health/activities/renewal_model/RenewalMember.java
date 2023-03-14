package com.universalsompo.meta.metaapp.health.activities.renewal_model;

public class RenewalMember {
    private String Name;
    private String DOB;

    public RenewalMember(String name, String dob) {
        this.Name = name;
        this.DOB = dob;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
}
