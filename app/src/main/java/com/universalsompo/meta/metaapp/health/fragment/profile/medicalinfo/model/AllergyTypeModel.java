package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model;

public class AllergyTypeModel {
    private String TypeId;
    private String TypeName;

    public AllergyTypeModel(String typeId, String typeName)
    {
        TypeId = typeId;
        TypeName = typeName;
    }

    public String getTypeId() {
        return TypeId;
    }

    public String getTypeName() {
        return TypeName;
    }
}
