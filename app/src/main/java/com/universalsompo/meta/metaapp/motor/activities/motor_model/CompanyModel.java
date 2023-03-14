package com.universalsompo.meta.metaapp.motor.activities.motor_model;

import java.io.Serializable;

public class CompanyModel implements Serializable {
    public String getCOMPANYNAME() {
        return COMPANYNAME;
    }

    public void setCOMPANYNAME(String COMPANYNAME) {
        this.COMPANYNAME = COMPANYNAME;
    }

    public String getTXT_COMPANY_CODE() {
        return TXT_COMPANY_CODE;
    }

    public void setTXT_COMPANY_CODE(String TXT_COMPANY_CODE) {
        this.TXT_COMPANY_CODE = TXT_COMPANY_CODE;
    }

    private String COMPANYNAME;

    private String TXT_COMPANY_CODE;


}
