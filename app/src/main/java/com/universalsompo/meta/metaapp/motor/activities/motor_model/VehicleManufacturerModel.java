package com.universalsompo.meta.metaapp.motor.activities.motor_model;

import java.io.Serializable;

public class VehicleManufacturerModel implements Serializable {
        private String VEHICLEMANUFACTURERCODE;

        private String VEHICLEMANUFACTURERNAME;

        public void setVEHICLEMANUFACTURERCODE(String VEHICLEMANUFACTURERCODE){
        this.VEHICLEMANUFACTURERCODE = VEHICLEMANUFACTURERCODE;
    }
        public String getVEHICLEMANUFACTURERCODE(){
        return this.VEHICLEMANUFACTURERCODE;
    }
        public void setVEHICLEMANUFACTURERNAME(String VEHICLEMANUFACTURERNAME){
        this.VEHICLEMANUFACTURERNAME = VEHICLEMANUFACTURERNAME;
    }
        public String getVEHICLEMANUFACTURERNAME(){
        return this.VEHICLEMANUFACTURERNAME;
    }
}
