package com.universalsompo.meta.metaapp.health.activities.renewal_model;

public class TenureModel {
    String Quoteid;
    String Tenure;
    String SumInsured;
    String BasicCoverPremium;
    String Netpremium;
    String Finalpremium;
    String CGST;
    String SGST;
    String IGST;
    String UGST;
    public TenureModel(String quoteid, String tenure, String sumInsured, String basicCoverPremium, String netpremium, String finalpremium, String cgst, String sgst, String igst, String ugst) {
        Quoteid = quoteid;
        Tenure = tenure;
        SumInsured = sumInsured;
        BasicCoverPremium = basicCoverPremium;
        Netpremium = netpremium;
        Finalpremium = finalpremium;
        CGST = cgst;
        SGST = sgst;
        IGST = igst;
        UGST = ugst;
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

    public String getCGST() {
        return CGST;
    }

    public void setCGST(String CGST) {
        this.CGST = CGST;
    }

    public String getSGST() {
        return SGST;
    }

    public void setSGST(String SGST) {
        this.SGST = SGST;
    }

    public String getIGST() {
        return IGST;
    }

    public void setIGST(String IGST) {
        this.IGST = IGST;
    }

    public String getUGST() {
        return UGST;
    }

    public void setUGST(String UGST) {
        this.UGST = UGST;
    }


}
