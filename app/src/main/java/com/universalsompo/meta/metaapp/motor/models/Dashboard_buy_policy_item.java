package com.universalsompo.meta.metaapp.motor.models;

public class Dashboard_buy_policy_item {
    private String Id;
    private String ProductName;
    private String ProductUrl;
    private String ThankPageUrl;

    public Dashboard_buy_policy_item(String id, String productName, String productUrl, String thankPageUrl) {
        this.Id = id;
        this.ProductName = productName;
        this.ProductUrl = productUrl;
        this.ThankPageUrl = thankPageUrl;
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
}
