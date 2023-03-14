package com.universalsompo.meta.metaapp.motor.models;

public class IntimationGetInformatonModel {
    private String Address;
    private String DrivingLicenceDocPath;
    private String EmailId;
    private String InsuredName;
    private String Message;
    private String MobileNo;
    private String PolicyDocPath;
    private String PolicyNo;
    private String VehicleNo;
    private String VehicleRegDocPath;

    public IntimationGetInformatonModel(String address, String drivingLicenceDocPath, String emailId, String insuredName, String message, String mobileNo, String policyDocPath, String policyNo, String vehicleNo, String vehicleRegDocPath) {
        Address = address;
        DrivingLicenceDocPath = drivingLicenceDocPath;
        EmailId = emailId;
        InsuredName = insuredName;
        Message = message;
        MobileNo = mobileNo;
        PolicyDocPath = policyDocPath;
        PolicyNo = policyNo;
        VehicleNo = vehicleNo;
        VehicleRegDocPath = vehicleRegDocPath;
    }

    public String getAddress() {
        return Address;
    }

    public String getDrivingLicenceDocPath() {
        return DrivingLicenceDocPath;
    }

    public String getEmailId() {
        return EmailId;
    }

    public String getInsuredName() {
        return InsuredName;
    }

    public String getMessage() {
        return Message;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public String getPolicyDocPath() {
        return PolicyDocPath;
    }

    public String getPolicyNo() {
        return PolicyNo;
    }

    public String getVehicleNo() {
        return VehicleNo;
    }

    public String getVehicleRegDocPath() {
        return VehicleRegDocPath;
    }
}
