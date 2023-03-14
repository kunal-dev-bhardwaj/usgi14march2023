package com.universalsompo.meta.metaapp.motor.activities.motor_model;

import java.io.Serializable;

public class MotorRTOModel implements Serializable {
    private String RTOLOCDesc;

    private String RTOLOCName;

    private String RegionCode;

    public void setRTOLOCDesc(String RTOLOCDesc){
        this.RTOLOCDesc = RTOLOCDesc;
    }
    public String getRTOLOCDesc(){
        return this.RTOLOCDesc;
    }
    public void setRTOLOCName(String RTOLOCName){
        this.RTOLOCName = RTOLOCName;
    }
    public String getRTOLOCName(){
        return this.RTOLOCName;
    }
    public void setRegionCode(String RegionCode){
        this.RegionCode = RegionCode;
    }
    public String getRegionCode(){
        return this.RegionCode;
    }
}
