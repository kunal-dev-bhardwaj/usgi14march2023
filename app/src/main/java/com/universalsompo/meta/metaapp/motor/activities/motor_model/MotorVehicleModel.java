package com.universalsompo.meta.metaapp.motor.activities.motor_model;

import java.io.Serializable;

public class MotorVehicleModel implements Serializable {
    private String CUBICCAPACITY;

    private String IMAGE;

    private String VEHICLEMODEL;

    private String VEHICLEMODELCODE;



    private String CNVM_FUEL_TYPE;

    public void setCUBICCAPACITY(String CUBICCAPACITY){
        this.CUBICCAPACITY = CUBICCAPACITY;
    }
    public String getCUBICCAPACITY(){
        return this.CUBICCAPACITY;
    }
    public void setIMAGE(String IMAGE){
        this.IMAGE = IMAGE;
    }
    public String getIMAGE(){
        return this.IMAGE;
    }
    public void setVEHICLEMODEL(String VEHICLEMODEL){
        this.VEHICLEMODEL = VEHICLEMODEL;
    }
    public String getVEHICLEMODEL(){
        return this.VEHICLEMODEL;
    }
    public void setVEHICLEMODELCODE(String VEHICLEMODELCODE){
        this.VEHICLEMODELCODE = VEHICLEMODELCODE;
    }
    public String getVEHICLEMODELCODE(){
        return this.VEHICLEMODELCODE;
    }

    public String getCNVM_FUEL_TYPE() {
        return CNVM_FUEL_TYPE;
    }

    public void setCNVM_FUEL_TYPE(String CNVM_FUEL_TYPE) {
        this.CNVM_FUEL_TYPE = CNVM_FUEL_TYPE;
    }
}
