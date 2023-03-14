package com.universalsompo.meta.metaapp.motor.models;

public class DocumentModel {
    private String doc_img_id;
    private String doc_type;
    private String doc_img_url;
    private String doc_exp_date;

    private String doc_category;
    private String doc_category_id;


    //************************************* document Preview *******************************
    public DocumentModel(String doc_img_id, String doc_type, String doc_img_url, String doc_exp_date,String doc_category) {
        this.doc_img_id = doc_img_id;
        this.doc_type = doc_type;
        this.doc_img_url = doc_img_url;
        this.doc_exp_date = doc_exp_date;
        this.doc_category=doc_category;
    }

    public String getDoc_img_id() {
        return doc_img_id;
    }

    public String getDoc_type() {
        return doc_type;
    }

    public String getDoc_img_url() {
        return doc_img_url;
    }

    public String getDoc_exp_date() {
        return doc_exp_date;
    }

    //******************************** Document Ctaegory ******************************


    public String getDoc_category_id() {
        return doc_category_id;
    }

    public String getDoc_category() {
        return doc_category;
    }

    public DocumentModel(String doc_category_id, String doc_category) {
        this.doc_category_id = doc_category_id;
        this.doc_category = doc_category;

    }
}
