package com.universalsompo.meta.metaapp.motor.activities.motor_model;

public class AdditionalCoverGroupModel {
    String AddonCoverGroupsValue;
    String AddonCoverGroupsPremiumValue;

    public AdditionalCoverGroupModel(String addonCoverGroupsValue, String addonCoverGroupsPremiumValue) {
        AddonCoverGroupsValue = addonCoverGroupsValue;
        AddonCoverGroupsPremiumValue = addonCoverGroupsPremiumValue;
    }
    public String getAddonCoverGroupsValue() {
        return AddonCoverGroupsValue;
    }

    public void setAddonCoverGroupsValue(String addonCoverGroupsValue) {
        AddonCoverGroupsValue = addonCoverGroupsValue;
    }

    public String getAddonCoverGroupsPremiumValue() {
        return AddonCoverGroupsPremiumValue;
    }

    public void setAddonCoverGroupsPremiumValue(String addonCoverGroupsPremiumValue) {
        AddonCoverGroupsPremiumValue = addonCoverGroupsPremiumValue;
    }


}
