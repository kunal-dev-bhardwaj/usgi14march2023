package com.universalsompo.meta.metaapp.health.fragment.marketplace.model;

public class MultipleVendor {
    private String Address;
    private String Details;
    private String Latitude;
    private String LogoURL;
    private String Longitude;
    private String VendorID;
    private String VendorName;
    private String WebsiteURL;

    public MultipleVendor(String address, String details, String latitude, String logoURL, String longitude, String vendorID, String vendorName, String websiteURL)
    {
        Address = address;
        Details = details;
        Latitude = latitude;
        LogoURL = logoURL;
        Longitude = longitude;
        VendorID = vendorID;
        VendorName = vendorName;
        WebsiteURL = websiteURL;
    }

    public String getAddress() {
        return Address;
    }

    public String getDetails() {
        return Details;
    }

    public String getLatitude() {
        return Latitude;
    }

    public String getLogoURL() {
        return LogoURL;
    }

    public String getLongitude() {
        return Longitude;
    }

    public String getVendorID() {
        return VendorID;
    }

    public String getVendorName() {
        return VendorName;
    }

    public String getWebsiteURL() {
        return WebsiteURL;
    }
}
