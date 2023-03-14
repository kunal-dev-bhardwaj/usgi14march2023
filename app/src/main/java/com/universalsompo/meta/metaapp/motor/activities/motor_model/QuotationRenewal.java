package com.universalsompo.meta.metaapp.motor.activities.motor_model;

public class QuotationRenewal {
    private String FinalPremium;
    private String QuoteID;
    private String NewIDV;
    private String ManufatureName;
    private String NetPremium;
    private String Ncb;
    public QuotationRenewal(String finalPremium, String quoteID, String newIDV, String manufatureName, String netPremium, String ncb) {
        FinalPremium = finalPremium;
        QuoteID = quoteID;
        NewIDV = newIDV;
        ManufatureName = manufatureName;
        NetPremium = netPremium;
        Ncb = ncb;
    }
    public String getFinalPremium() {
        return FinalPremium;
    }

    public void setFinalPremium(String finalPremium) {
        FinalPremium = finalPremium;
    }

    public String getQuoteID() {
        return QuoteID;
    }

    public void setQuoteID(String quoteID) {
        QuoteID = quoteID;
    }

    public String getNewIDV() {
        return NewIDV;
    }

    public void setNewIDV(String newIDV) {
        NewIDV = newIDV;
    }

    public String getManufatureName() {
        return ManufatureName;
    }

    public void setManufatureName(String manufatureName) {
        ManufatureName = manufatureName;
    }

    public String getNetPremium() {
        return NetPremium;
    }

    public void setNetPremium(String netPremium) {
        NetPremium = netPremium;
    }

    public String getNcb() {
        return Ncb;
    }

    public void setNcb(String ncb) {
        Ncb = ncb;
    }


}
