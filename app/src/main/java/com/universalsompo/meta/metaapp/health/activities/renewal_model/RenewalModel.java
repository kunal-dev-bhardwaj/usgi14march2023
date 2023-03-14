package com.universalsompo.meta.metaapp.health.activities.renewal_model;



import java.io.Serializable;

public class RenewalModel implements Serializable {

    private String Quoteid;
    private String Tenure;
    private String SumInsured;
    private String BasicCoverPremium;
    private String Netpremium;
    private String Finalpremium;


    public RenewalModel(String quoteid, String tenure, String sumInsured, String basicCoverPremium, String netpremium, String finalpremium) {
        this.Quoteid = quoteid;
        this.Tenure = tenure;
        this.SumInsured = sumInsured;
        this.BasicCoverPremium = basicCoverPremium;
        this.Netpremium = netpremium;
        this.Finalpremium = finalpremium;

    }

    public String getQuoteid() {
        return Quoteid;
    }

    public void setQuoteid(String quoteid) {
        Quoteid = quoteid;
    }

    public String getTenure() {
        return Tenure;
    }

    public void setTenure(String tenure) {
        Tenure = tenure;
    }

    public String getSumInsured() {
        return SumInsured;
    }

    public void setSumInsured(String sumInsured) {
        SumInsured = sumInsured;
    }

    public String getBasicCoverPremium() {
        return BasicCoverPremium;
    }

    public void setBasicCoverPremium(String basicCoverPremium) {
        BasicCoverPremium = basicCoverPremium;
    }

    public String getNetpremium() {
        return Netpremium;
    }

    public void setNetpremium(String netpremium) {
        Netpremium = netpremium;
    }

    public String getFinalpremium() {
        return Finalpremium;
    }

    public void setFinalpremium(String finalpremium) {
        Finalpremium = finalpremium;
    }

}
