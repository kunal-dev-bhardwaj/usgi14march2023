package com.universalsompo.meta.metaapp.motor.models;

public class ServiceModel {
    private String CoupanCode;
    private String Description;
    private String Discount;
    private String IconPath;
    private String Title;
    private String TollFreeNo;

    public ServiceModel(String coupanCode, String description, String title, String tollFreeNo, String vendorCode, String vendorId, String vendorName, String URL, String iconPath, String discount) {
        CoupanCode = coupanCode;
        Description = description;
        Title = title;
        TollFreeNo = tollFreeNo;
        VendorCode = vendorCode;
        VendorId = vendorId;
        VendorName = vendorName;
        this.URL = URL;
        IconPath = iconPath;
        Discount = discount;
    }

    String URL;
    String VendorCode;
    String VendorId;
    String VendorName;

    public String getCoupanCode() {
        return CoupanCode;
    }

    public String getDescription() {
        return Description;
    }

    public String getDiscount() {
        return Discount;
    }

    public String getIconPath() {
        return IconPath;
    }

    public String getTitle() {
        return Title;
    }

    public String getTollFreeNo() {
        return TollFreeNo;
    }

    public String getURL() {
        return URL;
    }

    public String getVendorCode() {
        return VendorCode;
    }

    public String getVendorId() {
        return VendorId;
    }

    public String getVendorName() {
        return VendorName;
    }
}
