package com.universalsompo.meta.metaapp.motor.models;

public class ClaimMapDataModel {
    private String Address;
    private String City;
    private String ContactEmail;
    private String ContactNo;
    private String ContactPerson;
    private String Country;
    private String LandlineNo;
    private String Latitude;
    private String Longitude;
    private String NameOfWorkshop;
    private String PinCode;
    private String State;
    private String VehicleMake;
    private String distance;

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public String getContactPerson() {
        return ContactPerson;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public String getLandlineNo() {
        return LandlineNo;
    }

    public String getCountry() {
        return Country;
    }

    public String getLatitude() {
        return Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public String getNameOfWorkshop() {
        return NameOfWorkshop;
    }

    public String getPinCode() {
        return PinCode;
    }

    public String getState() {
        return State;
    }

    public String getVehicleMake() {
        return VehicleMake;
    }

    public String getDistance() {
        return distance;
    }

    public ClaimMapDataModel(String address, String city, String contactEmail, String contactNo, String contactPerson, String country, String landlineNo, String latitude, String longitude, String nameOfWorkshop, String pinCode, String state, String vehicleMake, String distance) {
        Address = address;
        City = city;
        ContactEmail = contactEmail;
        ContactNo = contactNo;
        ContactPerson = contactPerson;
        Country = country;
        LandlineNo = landlineNo;
        Latitude = latitude;
        Longitude = longitude;
        NameOfWorkshop = nameOfWorkshop;
        PinCode = pinCode;
        State = state;
        VehicleMake = vehicleMake;
        this.distance = distance;
    }
}
