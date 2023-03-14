package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model;

public class BuyPolicyModel {
    private String Id;
    private String ProductName;
    private String ProductUrl;
    private String ThankPageUrl;
    private String ProductDesc;

    public BuyPolicyModel(String id, String productName, String productUrl, String thankPageUrl, String productDesc) {
        this.Id = id;
        this.ProductName = productName;
        this.ProductUrl = productUrl;
        this.ThankPageUrl = thankPageUrl;
        this.ProductDesc = productDesc;
    }

    public String getId() {
        return Id;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getProductUrl() {
        return ProductUrl;
    }

    public String getThankPageUrl() {
        return ThankPageUrl;
    }

    public String getProductDesc() {
        return ProductDesc;
    }
}
