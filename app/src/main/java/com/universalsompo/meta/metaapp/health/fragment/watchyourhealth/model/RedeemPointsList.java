package com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.model;

public class RedeemPointsList {
    private String Id;
    private String CategoryName;
    private String ActivityDescription;
    private String AllowdUserLimit;

    public RedeemPointsList(String id,String categoryName, String activityDescription, String allowdUserLimit){
        Id = id;
        CategoryName = categoryName;
        ActivityDescription = activityDescription;
        AllowdUserLimit = allowdUserLimit;
    }

    public String getId() {
        return Id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public String getActivityDescription() {
        return ActivityDescription;
    }

    public String getAllowdUserLimit() {
        return AllowdUserLimit;
    }
}
