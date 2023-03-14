package com.universalsompo.meta.metaapp.motor.models;

public class CashLessModel {
    private String FormId;
    private String FormPath;
    private String FormType;
    private String InsCompName;

    public String getFormId() {
        return FormId;
    }

    public String getFormPath() {
        return FormPath;
    }

    public String getInsCompName() {
        return InsCompName;
    }

    public String getFormType() {
        return FormType;
    }

    public CashLessModel(String formId, String formPath, String formType, String insCompName) {
        FormId = formId;
        FormPath = formPath;
        FormType = formType;
        InsCompName = insCompName;
    }
}
