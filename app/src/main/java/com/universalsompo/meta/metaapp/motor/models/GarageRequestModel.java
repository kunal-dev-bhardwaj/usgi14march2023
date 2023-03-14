package com.universalsompo.meta.metaapp.motor.models;

public class GarageRequestModel {
    private String InsCompId;
    private String TokenNo;
    private String Latitude;
    private String Longitude;

    public String getInsCompId() {
        return InsCompId;
    }

    public void setInsCompId(String insCompId) {
        InsCompId = insCompId;
    }

    public String getTokenNo() {
        return TokenNo;
    }

    public void setTokenNo(String tokenNo) {
        TokenNo = tokenNo;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getVehicleMake() {
        return VehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        VehicleMake = vehicleMake;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    private String VehicleMake;
    private String State;
    private String City;
}
