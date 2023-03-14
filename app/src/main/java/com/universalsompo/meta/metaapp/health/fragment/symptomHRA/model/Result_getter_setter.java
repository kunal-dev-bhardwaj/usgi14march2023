package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model;

public class Result_getter_setter {
    private String id, name, common_name, probability;

    public Result_getter_setter() {
    }

    public Result_getter_setter(String id, String name, String common_name, String probability) {
        this.id = id;
        this.name = name;
        this.common_name = common_name;
        this.probability = probability;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getcommon_name() {
        return common_name;
    }

    public void setcommon_name(String common_name) {
        this.common_name = common_name;
    }

    public String getprobability() {
        return probability;
    }

    public void setprobability(String probability) {
        this.probability = probability;
    }
}

