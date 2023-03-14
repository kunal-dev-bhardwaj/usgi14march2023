package com.universalsompo.meta.metaapp.motor.models;

public class MyPolicyStatus {
    private String ChasisNo;
    private String ClientUserID;
    private String CoverageDetails;
    private String EngineNo;
    private String IDV;
    private String InsCompContactNo;
    private String InsCompID;
    private String InsCompName;
    private String InsCompURL;
    private String IsClaimInitiated;
    private String Make;
    private String ManufacturingYear;
    private String Model;
    private String NoOfDaysLeft;
    private String PolicyDoc;
    private String PolicyHolderName;
    private String PolicyID;
    private String PolicyNumber;
    private String PolicyStartDate;
    private String PolicyToDate;
    private String PolicyType;
    private String Premium;
    private String RegistrationNumber;
    private String Riders;
    private String Variant;
    private String VehicleClass;
    private String VehicleType;

    public MyPolicyStatus(String chasisNo, String clientUserID, String coverageDetails, String engineNo, String iDV, String insCompContactNo, String insCompID, String insCompName, String insCompURL, String isClaimInitiated, String make, String manufacturingYear, String model, String noOfDaysLeft, String policyDoc, String policyHolderName, String policyID, String policyNumber, String policyStartDate, String policyToDate, String policyType, String premium, String registrationNumber, String riders, String variant, String vehicleClass, String vehicleType)  //Anirudh
    {
        ChasisNo = chasisNo;
        ClientUserID = clientUserID;
        CoverageDetails = coverageDetails;
        EngineNo = engineNo;
        IDV = iDV;
        InsCompContactNo = insCompContactNo;
        InsCompID = insCompID;
        InsCompName = insCompName;
        InsCompURL = insCompURL;
        IsClaimInitiated = isClaimInitiated;
        Make = make;
        ManufacturingYear = manufacturingYear;
        Model = model;
        NoOfDaysLeft = noOfDaysLeft;
        PolicyDoc = policyDoc;
        PolicyHolderName = policyHolderName;
        PolicyID = policyID;
        PolicyNumber = policyNumber;
        PolicyStartDate = policyStartDate;
        PolicyToDate = policyToDate;
        PolicyType = policyType;
        Premium = premium;
        RegistrationNumber = registrationNumber;
        Riders = riders;
        Variant = variant;
        VehicleClass = vehicleClass;
        VehicleType = vehicleType;
    }

    public String getChasisNo() {
        return ChasisNo;
    }

    public String getClientUserID() {
        return ClientUserID;
    }

    public String getCoverageDetails() {
        return CoverageDetails;
    }

    public String getEngineNo() {
        return EngineNo;
    }

    public String getIDV() {
        return IDV;
    }

    public String getInsCompContactNo() {
        return InsCompContactNo;
    }

    public String getInsCompID() {
        return InsCompID;
    }

    public String getInsCompName() {
        return InsCompName;
    }

    public String getInsCompURL() {
        return InsCompURL;
    }

    public String getIsClaimInitiated() {
        return IsClaimInitiated;
    }

    public String getMake() {
        return Make;
    }

    public String getManufacturingYear() {
        return ManufacturingYear;
    }

    public String getModel() {
        return Model;
    }

    public String getNoOfDaysLeft() {
        return NoOfDaysLeft;
    }

    public String getPolicyDoc() {
        return PolicyDoc;
    }

    public String getPolicyHolderName() {
        return PolicyHolderName;
    }

    public String getPolicyID() {
        return PolicyID;
    }

    public String getPolicyNumber() {
        return PolicyNumber;
    }

    public String getPolicyStartDate() {
        return PolicyStartDate;
    }

    public String getPolicyToDate() {
        return PolicyToDate;
    }

    public String getPolicyType() {
        return PolicyType;
    }

    public String getPremium() {
        return Premium;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public String getRiders() {
        return Riders;
    }

    public String getVehicleClass() {
        return VehicleClass;
    }

    public String getVariant() {
        return Variant;
    }

    public String getVehicleType() {
        return VehicleType;
    }
}
