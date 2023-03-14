package com.universalsompo.meta.metaapp.health.fragment.diary;

public class DietDiary {
    private String Datee;
    private String Target;
    private String TotalCalaries;

    public DietDiary(String datee, String target, String totalCalaries)
    {
        Datee = datee;
        Target = target;
        TotalCalaries = totalCalaries;
    }

    public String getDatee() {
        return Datee;
    }

    public String getTarget() {
        return Target;
    }

    public String getTotalCalaries() {
        return TotalCalaries;
    }
}
