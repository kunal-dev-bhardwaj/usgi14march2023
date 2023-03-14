package com.universalsompo.meta.metaapp.motor.models;

public class SaveClaimIntimationModel {
    private String DateOfAccident;
    private String TimeOfAccident;
    private String AccidentPlace;
    private String AccidentLocation;
    private String AccidentCity;
    private String AccidentState;
    private String TypeOfLoss;
    private String IsPoliceNotify;
    private String Description;
    private String FIR_No;
    private String FIR_Date;
    private String PoliceStation;
    private String InchargeContactNo;
    private String DriverName;
    private String Relation;
    private String Age;
    private String DrivingLicence;
    private String DL_Type;
    private String DriverExpiryDate;
    private String AccountHolderName;
    private String AccountNo;
    private String BankName;
    private String BranchName;
    private String IFSCCode;
    private String DeclarationPlace;
    private String DeclarationDate;
    private String Image1;
    private String Image2;
    private String Image3;
    private String Image4;
    private String Image5;
    private String Image6;
    private String VehicleRegDocPath;
    private String PolicyDocPath;
    private String DLDocPath;
    private String VehiclaType;
    private String ClaimDate;
    private String ClaimTime;
    private String ClaimContactNumber;
    private String ClaimRemark;
    private String PUCValidUpto;
    private String PUCNumber;
    private String PUCCenter;
    private String EstimatedAmount;
    private final String extension = ".png";


    private static SaveClaimIntimationModel object;

    public static SaveClaimIntimationModel getInstance() {
        if (object == null) {
            object = new SaveClaimIntimationModel();
        }
        return object;
    }

    public static SaveClaimIntimationModel getObject() {
        return object;
    }

    public static void setObject(SaveClaimIntimationModel object) {
        SaveClaimIntimationModel.object = object;
    }

    public String getDLDocPath() {
        return DLDocPath;
    }

    public void setDLDocPath(String DLDocPath) {
        this.DLDocPath = DLDocPath;
    }

    public String getPolicyDocPath() {
        return PolicyDocPath;
    }

    public void setPolicyDocPath(String policyDocPath) {
        PolicyDocPath = policyDocPath;
    }

    public String getVehicleRegDocPath() {
        return VehicleRegDocPath;
    }

    public void setVehicleRegDocPath(String vehicleRegDocPath) {
        VehicleRegDocPath = vehicleRegDocPath;
    }

    public String getImage6() {
        return Image6;
    }

    public void setImage6(String image6) {
        Image6 = image6;
    }

    public String getImage5() {
        return Image5;
    }

    public void setImage5(String image5) {
        Image5 = image5;
    }

    public String getImage4() {
        return Image4;
    }

    public void setImage4(String image4) {
        Image4 = image4;
    }

    public String getImage3() {
        return Image3;
    }

    public void setImage3(String image3) {
        Image3 = image3;
    }

    public String getImage2() {
        return Image2;
    }

    public void setImage2(String image2) {
        Image2 = image2;
    }

    public String getImage1() {
        return Image1;
    }

    public void setImage1(String image1) {
        Image1 = image1;
    }

    public String getDeclarationDate() {
        return DeclarationDate;
    }

    public void setDeclarationDate(String declarationDate) {
        DeclarationDate = declarationDate;
    }

    public String getDeclarationPlace() {
        return DeclarationPlace;
    }

    public void setDeclarationPlace(String declarationPlace) {
        DeclarationPlace = declarationPlace;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String accountNo) {
        AccountNo = accountNo;
    }

    public String getAccountHolderName() {
        return AccountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        AccountHolderName = accountHolderName;
    }

    public String getDriverExpiryDate() {
        return DriverExpiryDate;
    }

    public void setDriverExpiryDate(String driverExpiryDate) {
        DriverExpiryDate = driverExpiryDate;
    }

    public String getDL_Type() {
        return DL_Type;
    }

    public void setDL_Type(String DL_Type) {
        this.DL_Type = DL_Type;
    }

    public String getDrivingLicence() {
        return DrivingLicence;
    }

    public void setDrivingLicence(String drivingLicence) {
        DrivingLicence = drivingLicence;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getInchargeContactNo() {
        return InchargeContactNo;
    }

    public void setInchargeContactNo(String inchargeContactNo) {
        InchargeContactNo = inchargeContactNo;
    }

    public String getPoliceStation() {
        return PoliceStation;
    }

    public void setPoliceStation(String policeStation) {
        PoliceStation = policeStation;
    }

    public String getFIR_Date() {
        return FIR_Date;
    }

    public void setFIR_Date(String FIR_Date) {
        this.FIR_Date = FIR_Date;
    }

    public String getFIR_No() {
        return FIR_No;
    }

    public void setFIR_No(String FIR_No) {
        this.FIR_No = FIR_No;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getIsPoliceNotify() {
        return IsPoliceNotify;
    }

    public void setIsPoliceNotify(String isPoliceNotify) {
        IsPoliceNotify = isPoliceNotify;
    }

    public String getTypeOfLoss() {
        return TypeOfLoss;
    }

    public void setTypeOfLoss(String typeOfLoss) {
        TypeOfLoss = typeOfLoss;
    }

    public String getAccidentLocation() {
        return AccidentLocation;
    }

    public void setAccidentLocation(String accidentLocation) {
        AccidentLocation = accidentLocation;
    }

    public String getTimeOfAccident() {
        return TimeOfAccident;
    }

    public void setTimeOfAccident(String timeOfAccident) {
        TimeOfAccident = timeOfAccident;
    }

    public String getDateOfAccident() {
        return DateOfAccident;
    }

    public void setDateOfAccident(String dateOfAccident) {
        DateOfAccident = dateOfAccident;
    }


    public String getExtension() {
        return extension;
    }

    public String getAccidentPlace() {
        return AccidentPlace;
    }

    public void setAccidentPlace(String AccidentPlace) {
        this.AccidentPlace = AccidentPlace;
    }

    public String getAccidentCity() {
        return AccidentCity;
    }

    public void setAccidentCity(String AccidentCity) {
        this.AccidentCity = AccidentCity;
    }

    public String getAccidentState() {
        return AccidentState;
    }

    public void setAccidentState(String AccidentState) {
        this.AccidentState = AccidentState;
    }

    public String getDriverRelation() {
        return Relation;
    }

    public void setDriverRelation(String Relation) {
        this.Relation = Relation;
    }

    public String getVehicleType() {
        return VehiclaType;
    }

    public void setVehicleType(String VehiclaType) {
        this.VehiclaType = VehiclaType;
    }

    public String getClaimDate() {
        return ClaimDate;
    }

    public void setClaimDate(String ClaimDate) {
        this.ClaimDate = ClaimDate;
    }

    public String getClaimTime() {
        return ClaimTime;
    }

    public void setClaimTime(String ClaimTime) {
        this.ClaimTime = ClaimTime;
    }

    public String getClaimContactNumber() {
        return ClaimContactNumber;
    }

    public void setClaimContactNumber(String ClaimContactNumber) {
        this.ClaimContactNumber = ClaimContactNumber;
    }

    public String getClaimRemark() {
        return ClaimRemark;
    }

    public void setClaimRemark(String ClaimRemark) {
        this.ClaimRemark = ClaimRemark;
    }

    public String getPUCValidUpto() {
        return PUCValidUpto;
    }

    public void setPUCValidUpto(String PUCValidUpto) {
        this.PUCValidUpto = PUCValidUpto;
    }

    public String getPUCNumber() {
        return PUCNumber;
    }

    public void setPUCNumber(String PUCNumber) {
        this.PUCNumber = PUCNumber;
    }

    public String getPUCCenter() {
        return PUCCenter;
    }

    public void setPUCCenter(String PUCCenter) {
        this.PUCCenter = PUCCenter;
    }

    public String getClaimEstimate() {
        return EstimatedAmount;
    }

    public void setClaimEstimate(String EstimatedAmount) {
        this.EstimatedAmount = EstimatedAmount;
    }
}
