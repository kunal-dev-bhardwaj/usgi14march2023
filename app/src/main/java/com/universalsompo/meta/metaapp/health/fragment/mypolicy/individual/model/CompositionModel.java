package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model;

public class CompositionModel {
    String CompositionID;
    String CompositionName;

    public CompositionModel(String compositionID, String compositionName)
    {
        CompositionID = compositionID;
        CompositionName = compositionName;
    }

    public String getCompositionID() {
        return CompositionID;
    }

    public String getCompositionName() {
        return CompositionName;
    }
}
