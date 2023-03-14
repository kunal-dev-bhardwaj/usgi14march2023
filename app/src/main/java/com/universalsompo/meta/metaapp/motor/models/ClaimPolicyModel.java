package com.universalsompo.meta.metaapp.motor.models;

public class ClaimPolicyModel {
    private String ExpiryDate;
    private String FilePath;
    private String InsComp;
    private String InsCompContactNo;
    private String InsCompId;
    private String InsCompURL;
    private String NoOfDaysLeft;
    private String PolicyId;
    private String PolicyNo;
    private String PolicyThrough;
    private String RegNo;
    private String VehicleModel;
    private String PolicyDocPath;
    private String VehicleType;

    /* -------------  Anirudh  -----------------*/
    private String Fullname;
    private String SettleDate;
    private String IsClaimIntimate;
    private String RefNo;



    public ClaimPolicyModel(String expiryDate, String filePath, String insComp, String insCompContactNo, String insCompId, String insCompURL, String noOfDaysLeft, String policyId, String policyNo, String policyThrough, String regNo, String vehicleModel, String policyDocPath, String fullname, String settledate, String isClaimIntimate, String refno, String VehicleType)  //Anirudh
     {
        ExpiryDate = expiryDate;
        FilePath = filePath;
        InsComp = insComp;
        InsCompContactNo = insCompContactNo;
        InsCompId = insCompId;
        InsCompURL = insCompURL;
        NoOfDaysLeft = noOfDaysLeft;
        PolicyId = policyId;
        PolicyNo = policyNo;
        PolicyThrough = policyThrough;
        RegNo = regNo;
        VehicleModel = vehicleModel;
        PolicyDocPath=policyDocPath;
        this.VehicleType=VehicleType;
         /* -----------------  Anirudh  ------------------- */
         Fullname=fullname;
         SettleDate=settledate;
         IsClaimIntimate=isClaimIntimate;
         RefNo=refno;



     }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public String getVehicleModel() {
        return VehicleModel;
    }

    public String getRegNo() {
        return RegNo;
    }

    public String getPolicyThrough() {
        return PolicyThrough;
    }

    public String getPolicyNo() {
        return PolicyNo;
    }

    public String getPolicyId() {
        return PolicyId;
    }

    public String getNoOfDaysLeft() {
        return NoOfDaysLeft;
    }

    public String getInsCompId() {
        return InsCompId;
    }

    public String getInsCompURL() {
        return InsCompURL;
    }

    public String getInsCompContactNo() {
        return InsCompContactNo;
    }

    public String getInsComp() {
        return InsComp;
    }

    public String getFilePath() {
        return FilePath;
    }

    public String getPolicyDocPath() {
        return PolicyDocPath;
    }

    public String getVehicleType() {
        return VehicleType;
    }


    /* ---------------------  Anirudh  ---------------------- */
    public String getFullname() {
        return Fullname;
    }

    public String getSettleDate() {
        return SettleDate;
    }

    public String getIsClaimIntimate() {
        return IsClaimIntimate;
    }

    public String getRefNo() {
        return RefNo;
    }

}
