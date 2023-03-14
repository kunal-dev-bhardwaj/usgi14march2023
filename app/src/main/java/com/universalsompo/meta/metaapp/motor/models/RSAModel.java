package com.universalsompo.meta.metaapp.motor.models;

public class RSAModel {
    private String OEM;
    private String OEMTollFreeNo;
    private String Policy;
    private String PolicyTollFreeNo;
    private String OtherStatus;
    private String ServProviderExpiryDate;
    private String ServProviderName;
    private String ServProviderRSANo;
    private String ServProviderTollFreeNo;
    private String policy_id;


    private String vendor_name;
    private String vendor_id;
    private String vendor_discount;
    private String vendor_title;
    private String vendor_description;
    private String offers;
    String vendor_img;

    int int_vendor_img;


//******************************Service Provider Model **************************************************


    public void setServProviderTollFreeNo(String servProviderTollFreeNo) {
        ServProviderTollFreeNo = servProviderTollFreeNo;
    }

    public void setServProviderName(String ServProviderName) {
        this.ServProviderName = ServProviderName;
    }

    public void setServProviderRSANo(String ServProviderRSANo) {
        this.ServProviderRSANo = ServProviderRSANo;
    }

    public void setServProviderExpiryDate(String ServProviderExpiryDate) {
        this.ServProviderExpiryDate = ServProviderExpiryDate;
    }

    public RSAModel(String OEM, String OEMTollFreeNo, String policy, String policyTollFreeNo, String OtherStatus, String ServProviderExpiryDate,
                    String ServProviderName, String ServProviderRSANo, String ServProviderTollFreeNo, String policy_id) {
        this.OEM = OEM;
        this.OEMTollFreeNo = OEMTollFreeNo;
        this.Policy = policy;
        this.PolicyTollFreeNo = policyTollFreeNo;

        this.OtherStatus = OtherStatus;
        this.ServProviderExpiryDate = ServProviderExpiryDate;
        this.ServProviderName = ServProviderName;
        this.ServProviderRSANo = ServProviderRSANo;
        this.policy_id = policy_id;
        this.ServProviderTollFreeNo = ServProviderTollFreeNo;
    }

    public String getOEM() {
        return OEM;
    }

    public String getOEMTollFreeNo() {
        return OEMTollFreeNo;
    }

    public String getPolicy_id() {
        return policy_id;
    }

    public String getPolicy() {
        return Policy;
    }

    public String getPolicyTollFreeNo() {
        return PolicyTollFreeNo;
    }

    public String getOtherStatus() {
        return OtherStatus;
    }

    public String getServProviderExpiryDate() {
        return ServProviderExpiryDate;
    }

    public String getServProviderRSANo() {
        return ServProviderRSANo;
    }

    public String getServProviderTollFreeNo() {
        return ServProviderTollFreeNo;
    }

    public String getServProviderName() {
        return ServProviderName;
    }


    //************************************ Vendor Model ******************************************


    public String getVendor_name() {
        return vendor_name;
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public String getVendor_discount() {
        return vendor_discount;
    }

    public String getVendor_title() {
        return vendor_title;
    }

    public String getVendor_description() {
        return vendor_description;
    }

    public String getOffers() {
        return offers;
    }

    public String getVendor_img() {
        return vendor_img;
    }

    public int getIntVendor_img() {
        return int_vendor_img;
    }

    public RSAModel(String vendor_id, String vendor_name, String vendor_discount, String offers, String vendor_img) {
        this.vendor_id = vendor_id;
        this.vendor_name = vendor_name;
        this.vendor_discount = vendor_discount;
        this.offers = offers;
        this.vendor_img = vendor_img;

    }


    public RSAModel(String vendor_name, int int_vendor_img, String vendor_discount, String vendor_title, String vendor_description) {
        this.vendor_name = vendor_name;
        this.int_vendor_img = int_vendor_img;
        this.vendor_discount = vendor_discount;
        this.vendor_title = vendor_title;
        this.vendor_description = vendor_description;
    }
}
