package com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.model;

public class TransactionHistoryList {
    private String Id;
    private String OpeningBalance;
    private String Amount;
    private String ClosingBalance;
    private String TransactionType;
    private String Perticular;
    private String CreatedOn;

    public TransactionHistoryList(String id,String openingBalance, String amount, String closingBalance, String transactionType, String perticular, String createdOn){
        Id = id;
        OpeningBalance = openingBalance;
        Amount = amount;
        ClosingBalance = closingBalance;
        TransactionType = transactionType;
        Perticular = perticular;
        CreatedOn = createdOn;
    }

    public String getId() {
        return Id;
    }

    public String getOpeningBalance() {
        return OpeningBalance;
    }

    public String getAmount() {
        return Amount;
    }

    public String getClosingBalance() {
        return ClosingBalance;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public String getPerticular() {
        return Perticular;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }
}
