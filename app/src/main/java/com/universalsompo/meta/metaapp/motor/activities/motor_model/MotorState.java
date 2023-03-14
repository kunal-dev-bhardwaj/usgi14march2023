package com.universalsompo.meta.metaapp.motor.activities.motor_model;

import java.io.Serializable;

public class MotorState implements Serializable {

        private String StateId;

        private String StateName;

        public void setStateId(String StateId){
        this.StateId = StateId;
    }
        public String getStateId(){
        return this.StateId;
    }
        public void setStateName(String StateName){
        this.StateName = StateName;
    }
        public String getStateName(){
        return this.StateName;
    }
}
