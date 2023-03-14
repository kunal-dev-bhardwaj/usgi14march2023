package com.universalsompo.meta.metaapp.health.fragment.homecare;

public class HomecareList {
    private String Details;
    private String IconPath;
    private String TypeID;
    private String TypeName;

    public String getDetails() {
        return Details;
    }

    public String getIconPath() {
        return IconPath;
    }

    public String getTypeID() {
        return TypeID;
    }

    public String getTypeName() {
        return TypeName;
    }

    public HomecareList(String details, String iconPath, String typeID, String typeName) {
        Details = details;
        IconPath = iconPath;
        TypeID = typeID;
        TypeName = typeName;
    }
}
