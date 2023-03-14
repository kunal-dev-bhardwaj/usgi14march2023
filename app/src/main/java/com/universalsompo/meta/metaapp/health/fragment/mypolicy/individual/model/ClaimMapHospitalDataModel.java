package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model;

public class ClaimMapHospitalDataModel {
    private String Address;
    private String ContactNo;
    private String EmailID;
    private String HospitalID;
    private String HospitalName;
    private String Latitude;
    private String Longitude;
    private String PinCode;

    public String getAddress() {
        return Address;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public String getEmailID() {
        return EmailID;
    }

    public String getHospitalID() {
        return HospitalID;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public String getLatitude() {
        return Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public String getPinCode() {
        return PinCode;
    }

    public ClaimMapHospitalDataModel(String address, String contactNo, String emailId, String hospitalId, String hospitalName, String latitude, String longitude, String pinCode) {
        Address = address;
        ContactNo = contactNo;
        EmailID = emailId;
        HospitalID = hospitalId;
        HospitalName = hospitalName;
        Latitude = latitude;
        Longitude = longitude;
        PinCode = pinCode;
    }
}
