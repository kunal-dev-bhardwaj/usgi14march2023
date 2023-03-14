package com.universalsompo.meta.metaapp.motor.models;

import java.io.Serializable;

public class TipsModel implements Serializable{
    private String imgPath;
    private String tipsTxt;
    private String tipId;
    private String readStatus;
    private String date;


    public String getDate() {
        return date;
    }

    public TipsModel(String tipId,String imgPath, String tipsTxt,String readStatus,   String date) {

        this.imgPath = imgPath;

        this.tipsTxt = tipsTxt;
        this.tipId=tipId;
        this.readStatus=readStatus;
        this.date=date;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getTipsTxt() {
        return tipsTxt;
    }

    public String getTipId() {
        return tipId;
    }

    public String getReadStatus() {
        return readStatus;
    }

}
