package com.universalsompo.meta.metaapp.health.activities.hospital.model;

public class HospitalModel {
    private String Address;

    public String getFullAddress() {
        return FullAddress;
    }

    public void setFullAddress(String fullAddress) {
        FullAddress = fullAddress;
    }

    private String FullAddress;
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



    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    private String Status;
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public void setContactEmail(String contactEmail) {
        ContactEmail = contactEmail;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public String getContactPerson() {
        return ContactPerson;
    }

    public void setContactPerson(String contactPerson) {
        ContactPerson = contactPerson;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getLandlineNo() {
        return LandlineNo;
    }

    public void setLandlineNo(String landlineNo) {
        LandlineNo = landlineNo;
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

    public String getNameOfWorkshop() {
        return NameOfWorkshop;
    }

    public void setNameOfWorkshop(String nameOfWorkshop) {
        NameOfWorkshop = nameOfWorkshop;
    }

    public String getPinCode() {
        return PinCode;
    }

    public void setPinCode(String pinCode) {
        PinCode = pinCode;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
    public HospitalModel(String address,String fullAddress, String city, String contactEmail, String contactNo, String contactPerson, String country, String landlineNo, String latitude, String longitude, String nameOfWorkshop, String pinCode, String state, String vehicleMake, String status,String distance) {
        Address = address;
        FullAddress = fullAddress;
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
        Status = status;
        this.distance = distance;
    }
  
}
