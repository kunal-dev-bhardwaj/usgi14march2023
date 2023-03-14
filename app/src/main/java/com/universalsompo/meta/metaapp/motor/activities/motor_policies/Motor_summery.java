package com.universalsompo.meta.metaapp.motor.activities.motor_policies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Payment_Complete_healthCare;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.paymentweb.PaymentWebUrl;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.activities.paymentmotor.MotorPayemntWebURl;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Motor_summery extends AppCompatActivity {
    String strIDTypeName1,NCBStatus,strTpFromDateEdit,strTpEndDateEdit,VoluntarydeductableDiscountAmount,CNGLPGKITODSumInsured,AutoMobileValidityRadio,ELECTRICALACCESSORYODSumInsured,NONELECTRICALACCESSORYODSumInsured,strElectricalAccessoriesSumInsured,strNonelectricalAccessoriesSumInsured,PACOVERTOPASSENGERSSumInsured,UNNAMEDPACOVERTOPASSENGERSSumInsured, PACOVERTOPAIDDRIVERSumInsured,strCngKitSumInsured,AutoMobileRadio,AutomobileAssociationdiscountSumInsured,VoluntarydeductableSumInsured,strMinMax,AntitheftdevicediscountStatus,AutomobileAssociationdiscountStatus,TPPDDiscountStatus,HandicapDiscountStatus,VoluntarydeductableStatus,NCBPremium="",AdditionalNonElecticalODSumInsuredValue,AdditionalElectricalSumInsuredValue,AntitheftdeviceRateValue,AntitheftdeviceSumInsuredValue,AutomobileAssociationRateValue,AutomobileAssociationSumInsuredValue,HandicapRateValue,HandicapSumInsuredValue,TPPDDiscountRateValue,TPPDDiscountSumInsuredValue,VotaryRateValue,VotarySumInsuredValue,
            DiscountsVale, StrNCB="",strDiscountEdit,ChangeAddons="",WACode="",IDV_new="",DetarifficValueSumInsure="",DetarifficLoadingValueSumInsured="",BasicODRateSumInsured="",ELECTRICALCoverSumInsured="",NONELECTRICALSumInsured="",BasicTpRateSumInsured="",AdditionalFibertankODSumInsuredValue,AdditionalLegalLiabilityPaidSumInsured,AdditionalOtherODRateSumInsured,AdditionalOtherTpSumInsuredValue,AdditionalPaCoverToOwnerDriverSumInsuredValue,AdditionalPaidDriverSumInsuredValue,AdditionalPaToPassengersSumInsuredValue,AdditionalUnnamedPassengersSumInsuredValue,AdditionalCngKitODSumInsuredValue,AdditionalCngLpgTpSumInsuredValue,AdditionalBuiltinKitODSumInsuredValue,AdditionalBuiltinCngTPSumInsuredValue,DailyCashRateSumInsured,AccidentalSumInsuredValue,WrongFuelSumInsuredValue,CostOfConsumablesSumInsuredValue,dailyCashAllowanceMetroSumInsuredValue,dailyCashAllowanceNonMetroSumInsuredValue,EngineProtectorDieselSumInsuredValue,EngineProtectorPetrolSumInsuredValue,HydrostaticLockSumInsuredValue,KeyReplacementSumInsuredValue,NilDepreciationSumInsuredValue,ReturnToInvoiceSumInsuredValue,RoadSideAssistanceSumInsuredValue,SecureTowingSumInsuredValue,TyreRimsecureSumInsuredValue,drivingTrainProtectSumInsuredValue,ManufacturesellingSumInsuredValue,strVehicleCubicCapicity="",strVehicleImage="",strNewFor="",DetariffDiscountStatus,DetariffLoadingStatus="",DetarifficValuePremium="",DetarifficValueRate="",DetarifficLodingValuePremium="",DetarifficLoadingValueRate="",changeseekBar="",strIdvValueTxtSelect="",DAILYCASHALLOWANCEStatus="",WRONGFUELCOVERStatus="",BasicODRateValue,BasicTpRateValue,AdditionalLegalLiabilityPaidRate="",CheckString="",strNomineeName="",strNomineeRelationEdit="",strPreviousClaimRadio="",StrAdditionalCoverPremiumTp="",StrAdditionalCoverPremiumOD="",SeekbarStatus="",addOnsCover="",addOnsAditional="",vehicleManufacturerType="",strModelType="",FuleType,rc_cubic_cap="",rc_fuel_desc="",VEHICLECLASSCODE="",strClaimBonus="",StrPreviousPolicyRadio="",strEndDateEdit="",ProductName="",ProductCode="",VehicleClassCode="",addOns="",NCB="",strVehicleManufacturerCode="",strRTOCode="",strVehicleModelCode="",strVehicleAge="",yearOfManufacture="",NetPremiumValue="",TotalValue="",PosPolicyNo1="",PosPolicyNo="",GST="",strIdvValueTxt="",strLessIDVText="",strHighIDVText="",today,strThirdDString,strName="",strVehicleNo="",str_edt_city="",str_edt_phone="",str_edt_email="",strPolicyRadio="",strVehicleTypeRadio="",strVehicleRadio="",strFor="",strTitleEdit="",strRTOName="",str_vehicleManufacturerNm="",strStateName="",strStateCode="",str_edt_registration_date="",str_manufacture_year="",strVehicleModel="",strPolicyNumberEdit="",strRegisteredAddressEdit="",strStateRegisterAddressEdit="",strStateRegisterCode,strCityRegisterCode="",strCityRegisterEdit="",strCityCommunicationCode="",strPinCodeEditText="",strCommunicationAddressEdit="",strCommunicationPinCodeEdit="",strVehicleNumber="",strVehicleChasisNumber="",strVehicleEngineNumber="",strStateCommunicationEdit="",strStateCommunicationCode="",strCityCommunicationEdit="",strPlanType="",strPlanYear="",strCoverageType="",strPACover="",strGPACover="",strDrivingLicence="",strCheckedTermCondition="",strCheckboxCommunication="",
            BUILTINCNGKIT_LPGKITTPStatus="",StrPrev_Policy_Type="",nextYear="",strCompanyName="",strODPlanFromDateEdit="",strODPlanEndDateEdit="",strTpPlanFromDateEdit="",strTpPlanEndDateEdit="",CubicCapacity="",tomorrowDate="",VehicleExShowroomPrice="",BasicODStatus="",BasicTP="",ELECTRICALACCESSORYODStatus="",FIBERTANKODStatus="",LEGALLIABILITYTOPAIDDRIVERStatus="",NONELECTRICALACCESSORYODStatus="",OtherODStatus="",OtherTpStatus="",PACOVERTOEMPLOYEESOFINSUREDStatus="",PACOVERTOOWNERDRIVERStatus="",PACOVERTOPAIDDRIVERStatus="",PACOVERTOPASSENGERSStatus="",UNNAMEDPACOVERTOPASSENGERSStatus="",ACCIDENTALHOSPITALIZATIONStatus="",COSTOFCONSUMABLESStatus="",DAILYCASHALLOWANCEMETROStatus="",DAILYCASHALLOWANCENONMETROStatus="",ENGINEPROTECTORDIESELStatus="",ENGINEPROTECTORPETROLStatus="",HYDROSTATICLOCKCOVERStatus="",KEYREPLACEMENTStatus="",NilDepreciationWaivercoverStatus="",RETURNTOINVOICEStatus="",RoadsideAssistanceStatus="",SECURETOWINGStatus="",TyreandRimsecureStatus="",AdditionalElectricalRateValue="",AdditionalFibertankODRateValue="",AdditionalLegalLiabilityDriverRateValue="",AdditionalBuiltinCngTPRateValue="",AdditionalNonElecticalODRateValue="",AdditionalOtherODRateValue="",AdditionalOtherTpRateValue="",AdditionalPaCoversToEmployessRateValue="",AdditionalPaCoverToOwnerDriverRateValue="",AdditionalPaidDriverRateValue="",AdditionalPaToPassengersRateValue="",AdditionalUnnamedPassengersRateValue="",AdditionalCngKitODRateValue="",AdditionalCngLpgTpRateValue="",AdditionalBuiltinKitODRateValue="",AccidentalRateValue="",CostOfConsumablesRateValue="",dailyCashAllowanceMetroRateValue="",dailyCashAllowanceNonMetroRateValue="",EngineProtectorDieselRateValue="", EngineProtectorPetrolRateValue="",HydrostaticLockRateValue="", KeyReplacementRateValue="", NilDepreciationRateValue="", ReturnToInvoiceRateValue="", RoadSideAssistanceRateValue="",SecureTowingRateValue="",TyreRimsecureRateValue="", drivingTrainProtectRateValue="",WrongFuelRateValue="", DailyCashRateValue="",ManufacturesellingRateValue="",CNGLPGKITODStatus="",CNGLPGKITTPStatus="",BUILTINCNGKIT_LPGKITODStatus="",MANUFACTURERSELLINGPRICEStatus="",DRIVINGTRAINPROTECTStatus="",strBreaking="",previousDate="";
    TextView TXTBreaking,DiscountTxt,ViewDetails,OtherDiscountTxt,TxtViewVehicleType,VehicleNo,VehicleBrandTxt,VehicleModelTxt,VehicleRegistrationYearText,InsuredValueTxt,OwnerNameTxt,OwnerEmailTxt,OwnerPhoneTxt,OwnerPinCodeTxt,PlanTypeTXT,VehicleNameText,StartDateTxt,PolicyPlanTxt,IDVTxt,OwnDamageTxt,LiabilityTxt,AddOnsTxt,NCBTxt,GSTTxt,TotalPremiumTxt,totalValue;
    Date date;
    int progressChanged,a,b,c,selectYear,daysLeft,VehicleAgeAdd,MonthsLeft;
    Format formatter;
    String yearOfManufactureMonth,strSelectDateYear,ckycNo,uniqueTransactionNumber,strGenderSpinner = "",streditdob = "",strIDType = "",strIDTypeName = "",strIDNumberEdit = "";
    LinearLayout continue_button,InsuredIDVLiner,InsuredIDVLinerSummery;
    CheckBox checkBox;
    ImageView SummeryBack,imgeBike;
    Format formatter1;
    private MySharedPreference pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor_summery);
        pref = MySharedPreference.getInstance(Motor_summery.this);
        getWindow().setStatusBarColor(ContextCompat.getColor(Motor_summery.this, R.color.colorPrimaryDark));
        strVehicleNo = getIntent().getStringExtra("strVehicleNo");
        strName = getIntent().getStringExtra("strName");
        str_edt_city = getIntent().getStringExtra("str_edt_city");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        str_edt_email = getIntent().getStringExtra("str_edt_email");
        strFor = getIntent().getStringExtra("strFor");
        strPolicyRadio = getIntent().getStringExtra("strPolicyRadio");
        strVehicleTypeRadio = getIntent().getStringExtra("strVehicleTypeRadio");
        strVehicleRadio = getIntent().getStringExtra("strVehicleRadio");
        str_vehicleManufacturerNm = getIntent().getStringExtra("str_vehicleManufacturerNm");
        strVehicleModel = getIntent().getStringExtra("strVehicleModel");
        str_edt_registration_date = getIntent().getStringExtra("str_edt_registration_date");
        strStateName = getIntent().getStringExtra("strStateName");
        strStateRegisterCode = getIntent().getStringExtra("strStateRegisterCode");
        strRTOName = getIntent().getStringExtra("strRTOName");
        strPolicyNumberEdit = getIntent().getStringExtra("strPolicyNumberEdit");
        strPlanType = getIntent().getStringExtra("strPlanType");
        strCoverageType = getIntent().getStringExtra("strCoverageType");
        strPACover = getIntent().getStringExtra("strPACover");
        strGPACover = getIntent().getStringExtra("strGPACover");
        strDrivingLicence = getIntent().getStringExtra("strDrivingLicence");
        strPlanYear = getIntent().getStringExtra("strPlanYear");
        strRegisteredAddressEdit = getIntent().getStringExtra("strRegisteredAddressEdit");
        strTitleEdit = getIntent().getStringExtra("strTitleEdit");
        strPinCodeEditText = getIntent().getStringExtra("strPinCodeEditText");
        strStateRegisterAddressEdit = getIntent().getStringExtra("strStateRegisterAddressEdit");
        strCityRegisterEdit = getIntent().getStringExtra("strCityRegisterEdit");
        strCityRegisterCode = getIntent().getStringExtra("strCityRegisterCode");
        strCommunicationAddressEdit = getIntent().getStringExtra("strCommunicationAddressEdit");
        strCommunicationPinCodeEdit = getIntent().getStringExtra("strCommunicationPinCodeEdit");
        strStateCommunicationEdit = getIntent().getStringExtra("strStateCommunicationEdit");
        strCityCommunicationEdit = getIntent().getStringExtra("strCityCommunicationEdit");
        strVehicleEngineNumber = getIntent().getStringExtra("strVehicleEngineNumber");
        strCheckedTermCondition = getIntent().getStringExtra("strCheckedTermCondition");
        strCheckboxCommunication = getIntent().getStringExtra("strCheckboxCommunication");
        strCityCommunicationCode = getIntent().getStringExtra("strCityCommunicationCode");
        TotalValue = getIntent().getStringExtra("TotalValue");
        strIdvValueTxt = getIntent().getStringExtra("strIdvValueTxt");
        strLessIDVText = getIntent().getStringExtra("strLessIDVText");
        strHighIDVText = getIntent().getStringExtra("strHighIDVText");
        NetPremiumValue = getIntent().getStringExtra("NetPremiumValue");
        GST = getIntent().getStringExtra("GST");
        strVehicleNumber = getIntent().getStringExtra("strVehicleNumber");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        yearOfManufacture = getIntent().getStringExtra("yearOfManufacture");
        strVehicleAge = getIntent().getStringExtra("strVehicleAge");
        strVehicleManufacturerCode = getIntent().getStringExtra("strVehicleManufacturerCode");
        strRTOCode = getIntent().getStringExtra("strRTOCode");
        yearOfManufacture = getIntent().getStringExtra("yearOfManufacture");
        strVehicleModelCode = getIntent().getStringExtra("strVehicleModelCode");
        BasicODStatus = getIntent().getStringExtra("BasicODStatus");
        BasicTP = getIntent().getStringExtra("BasicTP");
        ELECTRICALACCESSORYODStatus = getIntent().getStringExtra("ELECTRICALACCESSORYODStatus");
        FIBERTANKODStatus = getIntent().getStringExtra("FIBERTANKODStatus");
        LEGALLIABILITYTOPAIDDRIVERStatus = getIntent().getStringExtra("LEGALLIABILITYTOPAIDDRIVERStatus");
        NONELECTRICALACCESSORYODStatus = getIntent().getStringExtra("NONELECTRICALACCESSORYODStatus");
        OtherODStatus = getIntent().getStringExtra("OtherODStatus");
        OtherTpStatus = getIntent().getStringExtra("OtherTpStatus");
        PACOVERTOEMPLOYEESOFINSUREDStatus = getIntent().getStringExtra("PACOVERTOEMPLOYEESOFINSUREDStatus");
        PACOVERTOOWNERDRIVERStatus = getIntent().getStringExtra("PACOVERTOOWNERDRIVERStatus");
        ACCIDENTALHOSPITALIZATIONStatus = getIntent().getStringExtra("ACCIDENTALHOSPITALIZATIONStatus");
        UNNAMEDPACOVERTOPASSENGERSStatus = getIntent().getStringExtra("UNNAMEDPACOVERTOPASSENGERSStatus");
        PACOVERTOPASSENGERSStatus = getIntent().getStringExtra("PACOVERTOPASSENGERSStatus");
        PACOVERTOPAIDDRIVERStatus = getIntent().getStringExtra("PACOVERTOPAIDDRIVERStatus");
        COSTOFCONSUMABLESStatus = getIntent().getStringExtra("COSTOFCONSUMABLESStatus");
        DAILYCASHALLOWANCEMETROStatus = getIntent().getStringExtra("DAILYCASHALLOWANCEMETROStatus");
        DAILYCASHALLOWANCENONMETROStatus = getIntent().getStringExtra("DAILYCASHALLOWANCENONMETROStatus");
        ENGINEPROTECTORDIESELStatus = getIntent().getStringExtra("ENGINEPROTECTORDIESELStatus");
        ENGINEPROTECTORPETROLStatus = getIntent().getStringExtra("ENGINEPROTECTORPETROLStatus");
        HYDROSTATICLOCKCOVERStatus = getIntent().getStringExtra("HYDROSTATICLOCKCOVERStatus");
        KEYREPLACEMENTStatus = getIntent().getStringExtra("KEYREPLACEMENTStatus");
        NilDepreciationWaivercoverStatus = getIntent().getStringExtra("NilDepreciationWaivercoverStatus");
        RETURNTOINVOICEStatus = getIntent().getStringExtra("RETURNTOINVOICEStatus");
        RoadsideAssistanceStatus = getIntent().getStringExtra("RoadsideAssistanceStatus");
        SECURETOWINGStatus = getIntent().getStringExtra("SECURETOWINGStatus");
        TyreandRimsecureStatus = getIntent().getStringExtra("TyreandRimsecureStatus");
        VehicleExShowroomPrice = getIntent().getStringExtra("VehicleExShowroomPrice");
        tomorrowDate = getIntent().getStringExtra("tomorrowDate");
        NCB = getIntent().getStringExtra("NCB");
        addOns = getIntent().getStringExtra("addOns");
        VehicleClassCode = getIntent().getStringExtra("VehicleClassCode");
        ProductCode = getIntent().getStringExtra("ProductCode");
        ProductName = getIntent().getStringExtra("ProductName");
        strClaimBonus = getIntent().getStringExtra("strClaimBonus");
        strEndDateEdit = getIntent().getStringExtra("strEndDateEdit");
        StrPreviousPolicyRadio = getIntent().getStringExtra("StrPreviousPolicyRadio");
        VEHICLECLASSCODE = getIntent().getStringExtra("VEHICLECLASSCODE");
        strVehicleChasisNumber = getIntent().getStringExtra("strVehicleChasisNumber");
        strVehicleEngineNumber = getIntent().getStringExtra("strVehicleEngineNumber");
        rc_fuel_desc = getIntent().getStringExtra("rc_fuel_desc");
        rc_cubic_cap = getIntent().getStringExtra("rc_cubic_cap");
        FuleType = getIntent().getStringExtra("FuleType");
        strCompanyName = getIntent().getStringExtra("strCompanyName");
        strODPlanFromDateEdit = getIntent().getStringExtra("strODPlanFromDateEdit");
        strODPlanEndDateEdit = getIntent().getStringExtra("strODPlanEndDateEdit");
        strTpPlanFromDateEdit = getIntent().getStringExtra("strTpPlanFromDateEdit");
        strTpPlanEndDateEdit = getIntent().getStringExtra("strTpPlanEndDateEdit");
        nextYear = getIntent().getStringExtra("nextYear");
        StrPrev_Policy_Type = getIntent().getStringExtra("StrPrev_Policy_Type");
        vehicleManufacturerType = getIntent().getStringExtra("vehicleManufacturerType");
        strModelType = getIntent().getStringExtra("strModelType");
        addOnsCover = getIntent().getStringExtra("addOnsCover");
        addOnsAditional = getIntent().getStringExtra("addOnsAditional");
        SeekbarStatus = getIntent().getStringExtra("SeekbarStatus");
        StrAdditionalCoverPremiumOD = getIntent().getStringExtra("StrAdditionalCoverPremiumOD");
        StrAdditionalCoverPremiumTp = getIntent().getStringExtra("StrAdditionalCoverPremiumTp");
        strPreviousClaimRadio = getIntent().getStringExtra("strPreviousClaimRadio");
        strNomineeName = getIntent().getStringExtra("strNomineeName");
        strNomineeRelationEdit = getIntent().getStringExtra("strNomineeRelationEdit");
        CNGLPGKITODStatus = getIntent().getStringExtra("CNGLPGKITODStatus");
        CNGLPGKITTPStatus = getIntent().getStringExtra("CNGLPGKITTPStatus");
        BUILTINCNGKIT_LPGKITODStatus = getIntent().getStringExtra("BUILTINCNGKIT_LPGKITODStatus");
        MANUFACTURERSELLINGPRICEStatus = getIntent().getStringExtra("MANUFACTURERSELLINGPRICEStatus");
        DRIVINGTRAINPROTECTStatus = getIntent().getStringExtra("DRIVINGTRAINPROTECTStatus");
        CheckString = getIntent().getStringExtra("CheckString");
        AdditionalElectricalRateValue = getIntent().getStringExtra("AdditionalElectricalRateValue");
        AdditionalFibertankODRateValue = getIntent().getStringExtra("AdditionalFibertankODRateValue");
        AdditionalLegalLiabilityDriverRateValue = getIntent().getStringExtra("AdditionalLegalLiabilityDriverRateValue");
        AdditionalNonElecticalODRateValue = getIntent().getStringExtra("AdditionalNonElecticalODRateValue");
        AdditionalOtherODRateValue = getIntent().getStringExtra("AdditionalOtherODRateValue");
        AdditionalOtherTpRateValue = getIntent().getStringExtra("AdditionalOtherTpRateValue");
        AdditionalPaCoversToEmployessRateValue = getIntent().getStringExtra("AdditionalPaCoversToEmployessRateValue");
        AdditionalPaCoverToOwnerDriverRateValue = getIntent().getStringExtra("AdditionalPaCoverToOwnerDriverRateValue");
        AdditionalPaidDriverRateValue = getIntent().getStringExtra("AdditionalPaidDriverRateValue");
        AdditionalPaToPassengersRateValue = getIntent().getStringExtra("AdditionalPaToPassengersRateValue");
        AdditionalUnnamedPassengersRateValue = getIntent().getStringExtra("AdditionalUnnamedPassengersRateValue");
        AdditionalCngKitODRateValue = getIntent().getStringExtra("AdditionalCngKitODRateValue");
        AdditionalCngLpgTpRateValue = getIntent().getStringExtra("AdditionalCngLpgTpRateValue");
        AdditionalBuiltinKitODRateValue = getIntent().getStringExtra("AdditionalBuiltinKitODRateValue");
        AdditionalBuiltinCngTPRateValue = getIntent().getStringExtra("AdditionalBuiltinCngTPRateValue");
        AccidentalRateValue = getIntent().getStringExtra("AccidentalRateValue");
        CostOfConsumablesRateValue = getIntent().getStringExtra("CostOfConsumablesRateValue");
        dailyCashAllowanceMetroRateValue = getIntent().getStringExtra("dailyCashAllowanceMetroRateValue");
        dailyCashAllowanceNonMetroRateValue = getIntent().getStringExtra("dailyCashAllowanceNonMetroRateValue");
        EngineProtectorDieselRateValue = getIntent().getStringExtra("EngineProtectorDieselRateValue");
        EngineProtectorPetrolRateValue = getIntent().getStringExtra("EngineProtectorPetrolRateValue");
        HydrostaticLockRateValue = getIntent().getStringExtra("HydrostaticLockRateValue");
        KeyReplacementRateValue = getIntent().getStringExtra("KeyReplacementRateValue");
        NilDepreciationRateValue = getIntent().getStringExtra("NilDepreciationRateValue");
        ReturnToInvoiceRateValue = getIntent().getStringExtra("ReturnToInvoiceRateValue");
        RoadSideAssistanceRateValue = getIntent().getStringExtra("RoadSideAssistanceRateValue");
        SecureTowingRateValue = getIntent().getStringExtra("SecureTowingRateValue");
        TyreRimsecureRateValue = getIntent().getStringExtra("TyreRimsecureRateValue");
        drivingTrainProtectRateValue = getIntent().getStringExtra("drivingTrainProtectRateValue");
        ManufacturesellingRateValue = getIntent().getStringExtra("ManufacturesellingRateValue");
        AdditionalLegalLiabilityPaidRate = getIntent().getStringExtra("AdditionalLegalLiabilityPaidRate");
        BUILTINCNGKIT_LPGKITTPStatus = getIntent().getStringExtra("BUILTINCNGKIT_LPGKITTPStatus");
        progressChanged =getIntent().getIntExtra("progressChanged", 0);
        selectYear =getIntent().getIntExtra("selectYear", 0);
        daysLeft =getIntent().getIntExtra("daysLeft", 0);
        VehicleAgeAdd =getIntent().getIntExtra("VehicleAgeAdd", 0);
        MonthsLeft =getIntent().getIntExtra("MonthsLeft", 0);
        BasicODRateValue = getIntent().getStringExtra("BasicODRateValue");
        BasicTpRateValue = getIntent().getStringExtra("BasicTpRateValue");
        strIdvValueTxtSelect = getIntent().getStringExtra("strIdvValueTxtSelect");
        strStateCode = getIntent().getStringExtra("strStateCode");
        changeseekBar = getIntent().getStringExtra("changeseekBar");
        DAILYCASHALLOWANCEStatus = getIntent().getStringExtra("DAILYCASHALLOWANCEStatus");
        WRONGFUELCOVERStatus = getIntent().getStringExtra("WRONGFUELCOVERStatus");
        WrongFuelRateValue = getIntent().getStringExtra("WrongFuelRateValue");
        DailyCashRateValue = getIntent().getStringExtra("DailyCashRateValue");
        DetarifficValuePremium = getIntent().getStringExtra("DetarifficValuePremium");
        DetarifficValueRate = getIntent().getStringExtra("DetarifficValueRate");
        DetarifficLodingValuePremium = getIntent().getStringExtra("DetarifficLodingValuePremium");
        DetarifficLoadingValueRate = getIntent().getStringExtra("DetarifficLoadingValueRate");
        strNewFor = getIntent().getStringExtra("strNewFor");
        a =getIntent().getIntExtra("a", 0);
        b =getIntent().getIntExtra("b", 0);
        c =getIntent().getIntExtra("c", 0);
        strVehicleCubicCapicity = getIntent().getStringExtra("strVehicleCubicCapicity");
        strVehicleImage = getIntent().getStringExtra("strVehicleImage");
        DetarifficValueSumInsure = getIntent().getStringExtra("DetarifficValueSumInsure");
        DetarifficLoadingValueSumInsured = getIntent().getStringExtra("DetarifficLoadingValueSumInsured");
        BasicODRateSumInsured = getIntent().getStringExtra("BasicODRateSumInsured");
        BasicTpRateSumInsured = getIntent().getStringExtra("BasicTpRateSumInsured");
        ELECTRICALCoverSumInsured = getIntent().getStringExtra("ELECTRICALCoverSumInsured");
        NONELECTRICALSumInsured = getIntent().getStringExtra("NONELECTRICALSumInsured");
        AdditionalFibertankODSumInsuredValue = getIntent().getStringExtra("AdditionalFibertankODSumInsuredValue");
        AdditionalLegalLiabilityPaidSumInsured = getIntent().getStringExtra("AdditionalLegalLiabilityPaidSumInsured");
        AdditionalOtherODRateSumInsured = getIntent().getStringExtra("AdditionalOtherODRateSumInsured");
        AdditionalOtherTpSumInsuredValue = getIntent().getStringExtra("AdditionalOtherTpSumInsuredValue");
        AdditionalPaCoverToOwnerDriverSumInsuredValue = getIntent().getStringExtra("AdditionalPaCoverToOwnerDriverSumInsuredValue");
        AdditionalPaidDriverSumInsuredValue = getIntent().getStringExtra("AdditionalPaidDriverSumInsuredValue");
        AdditionalPaToPassengersSumInsuredValue = getIntent().getStringExtra("AdditionalPaToPassengersSumInsuredValue");
        AdditionalUnnamedPassengersSumInsuredValue = getIntent().getStringExtra("AdditionalUnnamedPassengersSumInsuredValue");
        AdditionalCngKitODSumInsuredValue = getIntent().getStringExtra("AdditionalCngKitODSumInsuredValue");
        AdditionalCngLpgTpSumInsuredValue = getIntent().getStringExtra("AdditionalCngLpgTpSumInsuredValue");
        AdditionalBuiltinKitODSumInsuredValue = getIntent().getStringExtra("AdditionalBuiltinKitODSumInsuredValue");
        AdditionalBuiltinCngTPSumInsuredValue = getIntent().getStringExtra("AdditionalBuiltinCngTPSumInsuredValue");
        DailyCashRateSumInsured = getIntent().getStringExtra("DailyCashRateSumInsured");
        AccidentalSumInsuredValue = getIntent().getStringExtra("AccidentalSumInsuredValue");
        WrongFuelSumInsuredValue = getIntent().getStringExtra("WrongFuelSumInsuredValue");
        CostOfConsumablesSumInsuredValue = getIntent().getStringExtra("CostOfConsumablesSumInsuredValue");
        dailyCashAllowanceMetroSumInsuredValue = getIntent().getStringExtra("dailyCashAllowanceMetroSumInsuredValue");
        dailyCashAllowanceNonMetroSumInsuredValue = getIntent().getStringExtra("dailyCashAllowanceNonMetroSumInsuredValue");
        EngineProtectorDieselSumInsuredValue = getIntent().getStringExtra("EngineProtectorDieselSumInsuredValue");
        EngineProtectorPetrolSumInsuredValue = getIntent().getStringExtra("EngineProtectorPetrolSumInsuredValue");
        HydrostaticLockSumInsuredValue = getIntent().getStringExtra("HydrostaticLockSumInsuredValue");
        KeyReplacementSumInsuredValue = getIntent().getStringExtra("KeyReplacementSumInsuredValue");
        NilDepreciationSumInsuredValue = getIntent().getStringExtra("NilDepreciationSumInsuredValue");
        ReturnToInvoiceSumInsuredValue = getIntent().getStringExtra("ReturnToInvoiceSumInsuredValue");
        RoadSideAssistanceSumInsuredValue = getIntent().getStringExtra("RoadSideAssistanceSumInsuredValue");
        SecureTowingSumInsuredValue = getIntent().getStringExtra("SecureTowingSumInsuredValue");
        TyreRimsecureSumInsuredValue = getIntent().getStringExtra("TyreRimsecureSumInsuredValue");
        drivingTrainProtectSumInsuredValue = getIntent().getStringExtra("drivingTrainProtectSumInsuredValue");
        ManufacturesellingSumInsuredValue = getIntent().getStringExtra("ManufacturesellingSumInsuredValue");
        ChangeAddons = getIntent().getStringExtra("ChangeAddons");
        strDiscountEdit = getIntent().getStringExtra("strDiscountEdit");
        StrNCB = getIntent().getStringExtra("StrNCB");
        AdditionalNonElecticalODSumInsuredValue = getIntent().getStringExtra("AdditionalNonElecticalODSumInsuredValue");
        AdditionalElectricalSumInsuredValue = getIntent().getStringExtra("AdditionalElectricalSumInsuredValue");
        AntitheftdeviceRateValue = getIntent().getStringExtra("AntitheftdeviceRateValue");
        AntitheftdeviceSumInsuredValue = getIntent().getStringExtra("AntitheftdeviceSumInsuredValue");
        AutomobileAssociationRateValue = getIntent().getStringExtra("AutomobileAssociationRateValue");
        AutomobileAssociationSumInsuredValue = getIntent().getStringExtra("AutomobileAssociationSumInsuredValue");
        HandicapRateValue = getIntent().getStringExtra("HandicapRateValue");
        HandicapSumInsuredValue = getIntent().getStringExtra("HandicapSumInsuredValue");
        TPPDDiscountRateValue = getIntent().getStringExtra("TPPDDiscountRateValue");
        TPPDDiscountSumInsuredValue = getIntent().getStringExtra("TPPDDiscountSumInsuredValue");
        VotaryRateValue = getIntent().getStringExtra("VotaryRateValue");
        VotarySumInsuredValue = getIntent().getStringExtra("VotarySumInsuredValue");
        AntitheftdevicediscountStatus = getIntent().getStringExtra("AntitheftdevicediscountStatus");
        AutomobileAssociationdiscountStatus = getIntent().getStringExtra("AutomobileAssociationdiscountStatus");
        TPPDDiscountStatus = getIntent().getStringExtra("TPPDDiscountStatus");
        HandicapDiscountStatus = getIntent().getStringExtra("HandicapDiscountStatus");
        VoluntarydeductableStatus = getIntent().getStringExtra("VoluntarydeductableStatus");
        DiscountsVale = getIntent().getStringExtra("DiscountsVale");
        strMinMax = getIntent().getStringExtra("strMinMax");
        strElectricalAccessoriesSumInsured = getIntent().getStringExtra("strElectricalAccessoriesSumInsured");
        strNonelectricalAccessoriesSumInsured = getIntent().getStringExtra("strNonelectricalAccessoriesSumInsured");
        PACOVERTOPASSENGERSSumInsured = getIntent().getStringExtra("PACOVERTOPASSENGERSSumInsured");
        UNNAMEDPACOVERTOPASSENGERSSumInsured = getIntent().getStringExtra("UNNAMEDPACOVERTOPASSENGERSSumInsured");
        PACOVERTOPAIDDRIVERSumInsured = getIntent().getStringExtra("PACOVERTOPAIDDRIVERSumInsured");
        strCngKitSumInsured = getIntent().getStringExtra("strCngKitSumInsured");
        AutoMobileRadio = getIntent().getStringExtra("AutoMobileRadio");
        AutoMobileValidityRadio = getIntent().getStringExtra("AutoMobileValidityRadio");
        AutomobileAssociationdiscountSumInsured = getIntent().getStringExtra("AutomobileAssociationdiscountSumInsured");
        VoluntarydeductableSumInsured = getIntent().getStringExtra("VoluntarydeductableSumInsured");
        ELECTRICALACCESSORYODSumInsured = getIntent().getStringExtra("ELECTRICALACCESSORYODSumInsured");
        NONELECTRICALACCESSORYODSumInsured = getIntent().getStringExtra("NONELECTRICALACCESSORYODSumInsured");
        CNGLPGKITODSumInsured = getIntent().getStringExtra("CNGLPGKITODSumInsured");
        VoluntarydeductableDiscountAmount = getIntent().getStringExtra("VoluntarydeductableDiscountAmount");
        strTpFromDateEdit = getIntent().getStringExtra("strTpFromDateEdit");
        strTpEndDateEdit = getIntent().getStringExtra("strTpEndDateEdit");
        NCBStatus = getIntent().getStringExtra("NCBStatus");
        strBreaking = getIntent().getStringExtra("strBreaking");
        strGenderSpinner = getIntent().getStringExtra("strGenderSpinner");
        streditdob = getIntent().getStringExtra("streditdob");
        strIDType = getIntent().getStringExtra("strIDType");
        strIDTypeName = getIntent().getStringExtra("strIDTypeName");
        strIDNumberEdit = getIntent().getStringExtra("strIDNumberEdit");
        ckycNo = getIntent().getStringExtra("ckycNo");
        uniqueTransactionNumber = getIntent().getStringExtra("uniqueTransactionNumber");
        yearOfManufactureMonth = getIntent().getStringExtra("yearOfManufactureMonth");
        strSelectDateYear = getIntent().getStringExtra("strSelectDateYear");
        strIDTypeName1 = getIntent().getStringExtra("strIDTypeName1");
        if(getIntent().hasExtra("previousDate")){
            previousDate = getIntent().getStringExtra("previousDate");
            Log.d("fofkvo", "onCreate: "+previousDate);
        }

        Log.d("djdjiedf", "onCreate: "+strIdvValueTxtSelect);



        TXTBreaking=findViewById(R.id.TXTBreaking);
        VehicleNo=findViewById(R.id.VehicleNo);
        VehicleModelTxt=findViewById(R.id.VehicleModelTxt);
        VehicleBrandTxt=findViewById(R.id.VehicleBrandTxt);
        VehicleRegistrationYearText=findViewById(R.id.VehicleRegistrationYearText);
        InsuredValueTxt=findViewById(R.id.InsuredValueTxt);
        OwnerNameTxt=findViewById(R.id.OwnerNameTxt);
        OwnerEmailTxt=findViewById(R.id.OwnerEmailTxt);
        OwnerPhoneTxt=findViewById(R.id.OwnerPhoneTxt);
        OwnerPinCodeTxt=findViewById(R.id.OwnerPinCodeTxt);
        PlanTypeTXT=findViewById(R.id.PlanTypeTXT);
        VehicleNameText=findViewById(R.id.VehicleNameText);
        StartDateTxt=findViewById(R.id.StartDateTxt);
        PolicyPlanTxt=findViewById(R.id.PolicyPlanTxt);
        IDVTxt=findViewById(R.id.IDVTxt);
        OwnDamageTxt=findViewById(R.id.OwnDamageTxt);
        LiabilityTxt=findViewById(R.id.LiabilityTxt);
        AddOnsTxt=findViewById(R.id.AddOnsTxt);
        NCBTxt=findViewById(R.id.NCBTxt);
        GSTTxt=findViewById(R.id.GSTTxt);
        TotalPremiumTxt=findViewById(R.id.TotalPremiumTxt);
        totalValue=findViewById(R.id.totalValue);
        continue_button=findViewById(R.id.continue_button);
        checkBox=findViewById(R.id.checkBox);
        TxtViewVehicleType=findViewById(R.id.TxtViewVehicleType);
        SummeryBack=findViewById(R.id.SummeryBack);
        ViewDetails=findViewById(R.id.ViewDetails);
        imgeBike=findViewById(R.id.imgeBike);
        OtherDiscountTxt=findViewById(R.id.OtherDiscountTxt);
        DiscountTxt=findViewById(R.id.DiscountTxt);
        InsuredIDVLiner=findViewById(R.id.InsuredIDVLiner);
        InsuredIDVLinerSummery=findViewById(R.id.InsuredIDVLinerSummery);

        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        String[] strTDate=  today.split("/");
        String strFirstDString = strTDate[0];
        String strSecondDString = strTDate[1];
        strThirdDString = strTDate[2];
        Log.e("strThirdDString", strThirdDString);
        Log.e("Today",today);
        if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
            if ((strVehicleNo.equals("")||strVehicleNo.equals("New"))){
                strVehicleNo="Old";
            }

        }

//        //TODO Popup integrate
//
//        if (strBreaking.equals("checked") || previousDate.equals("Previous")){
//            alertPopup();
//        }

//        strVehicleChasisNumber="";
        if (strVehicleTypeRadio.equals("Four Wheeler")){
            TxtViewVehicleType.setText("Four Wheeler Insurance");
            imgeBike.setBackgroundResource(R.drawable.fourwheelerimg);

        }else{
            TxtViewVehicleType.setText("Two Wheeler Insurance");
            imgeBike.setBackgroundResource(R.drawable.scooty_motor_img);
        }
        if (strPolicyNumberEdit!=null){
            VehicleNo.setText(strVehicleNo);
        }else{
            if (strVehicleNo.equals("Vehicle Number: NA")||strVehicleNo.equals("NA")||strVehicleNo.equals("New")){
                VehicleNo.setText(strVehicleNo);
            }else if (strVehicleNo.equals("")){
                strVehicleNo="NA";
                VehicleNo.setText(strVehicleNo);
            }else{
                VehicleNo.setText(strVehicleNo);
            }
        }

//        if (!strPolicyNumberEdit.equals("") && !strPolicyNumberEdit.equals("null")&& strPolicyNumberEdit!=null){
//        }else {
//            if (strVehicleNo.equals("Vehicle Number: NA")||strVehicleNo.equals("NA")||strVehicleNo.equals("New")){
//                VehicleNo.setText(strVehicleNo);
//            }else if (strVehicleNo.equals("")){
//                strVehicleNo="NA";
//                VehicleNo.setText(strVehicleNo);
//            }else{
//                VehicleNo.setText(strVehicleNo);
//            }
//        }


        if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("New")) {
            NCB="0";
            strClaimBonus=NCB;
        }else{
            strVehicleCubicCapicity=rc_cubic_cap;
            Log.e("strVehicleCubicCapicity",strVehicleCubicCapicity);
        }
        if (CheckString.equals("0")){
            AdditionalElectricalRateValue="";
            AdditionalNonElecticalODRateValue="";
            AdditionalPaCoversToEmployessRateValue="";
            AdditionalPaToPassengersRateValue="";
            AdditionalPaidDriverRateValue="";
            AdditionalOtherTpRateValue="";
            AdditionalFibertankODRateValue="";
            AdditionalOtherODRateValue="";
            AdditionalUnnamedPassengersRateValue="";
            AdditionalLegalLiabilityPaidRate="";
            RoadSideAssistanceRateValue="";
            NilDepreciationRateValue="";
            dailyCashAllowanceNonMetroRateValue="";
            dailyCashAllowanceMetroRateValue="";
            KeyReplacementRateValue="";
            ReturnToInvoiceRateValue="";
            AccidentalRateValue="";
            HydrostaticLockRateValue="";
            CostOfConsumablesRateValue="";
            SecureTowingRateValue="";
            TyreRimsecureRateValue="";
            EngineProtectorPetrolRateValue="";
            EngineProtectorDieselRateValue="";
            drivingTrainProtectRateValue="";
            ManufacturesellingRateValue="";
            AdditionalCngKitODRateValue="";
            AdditionalCngLpgTpRateValue="";
            AdditionalBuiltinKitODRateValue="";
            AdditionalBuiltinCngTPRateValue="";
            DailyCashRateValue="";
            WrongFuelRateValue="";
            addOns="0.0";
            DiscountsVale="0.0";
            AddOnsTxt.setText(addOns);
        }
        else{
            AddOnsTxt.setText(addOns);
        }

        VehicleModelTxt.setText(strVehicleModel);
        VehicleBrandTxt.setText(str_vehicleManufacturerNm);
        VehicleRegistrationYearText.setText(yearOfManufacture);
        OwnerNameTxt.setText(strName);
        OwnerEmailTxt.setText(str_edt_email);
        OwnerPhoneTxt.setText(str_edt_phone);
        OwnerPinCodeTxt.setText(strPinCodeEditText);
        PlanTypeTXT.setText(strPlanType);
        PolicyPlanTxt.setText(strPlanType);
        VehicleNameText.setText(str_vehicleManufacturerNm+" "+strVehicleModel);

        TotalPremiumTxt.setText(TotalValue);
        totalValue.setText(TotalValue);
        GSTTxt.setText(GST);
        OtherDiscountTxt.setText(strDiscountEdit);

        DiscountTxt.setText(DiscountsVale);

        if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            if (StrPreviousPolicyRadio.equals("No")){
                calendar.add(Calendar.DATE, 1);
                date = calendar.getTime();
                String today_tt = sdf.format(date);
                Log.e("today_tt",today_tt);
                today=today_tt;
                StartDateTxt.setText(today);
                TXTBreaking.setVisibility(View.VISIBLE);
            }else if (StrPrev_Policy_Type.equals("Comprehensive") || StrPrev_Policy_Type.equals("Own damage (standalone)")){
                try {
                    Date  today_Date = sdf.parse(today);
                    Date strEndDate = sdf.parse(strEndDateEdit);
                    if (strEndDate.getTime()<today_Date.getTime()){
                        calendar.add(Calendar.DATE, 1);
                        date = calendar.getTime();
                        formatter = new SimpleDateFormat("dd/MM/yyyy");
                        String today_tt = formatter.format(date);
                        Log.e("today_tt",today_tt);
                        today=today_tt;
                        StartDateTxt.setText(today);
                        TXTBreaking.setVisibility(View.VISIBLE);
                    }else if (strEndDateEdit.equals(today)){
                        calendar.add(Calendar.DATE, 1);
                        date = calendar.getTime();
                        formatter = new SimpleDateFormat("dd/MM/yyyy");
                        String today_tt = formatter.format(date);
                        Log.e("today_tt",today_tt);
                        today=today_tt;
                        StartDateTxt.setText(today);
                        TXTBreaking.setVisibility(View.GONE);
                    }else if (strEndDate.getTime()>today_Date.getTime()){
                        try {
                            Date strEndDate1 = sdf.parse(strEndDateEdit);
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(strEndDate1);
                            cal.add(Calendar.DAY_OF_MONTH, 1); //Adds a day
                            Date yourDate1 = cal.getTime();
                            String today_tt = sdf.format(yourDate1);
                            Log.e("today_tt",today_tt);
                            today=today_tt;
                            StartDateTxt.setText(today);
                            TXTBreaking.setVisibility(View.GONE);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        if (strVehicleTypeRadio.equals("Four Wheeler")){
                            TXTBreaking.setVisibility(View.VISIBLE);
                        }else{
                            TXTBreaking.setVisibility(View.GONE);
                        }
                        StartDateTxt.setText(today);
                    }

                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            else {
                TXTBreaking.setVisibility(View.GONE);
                StartDateTxt.setText(today);
            }

        }
        else{
            TXTBreaking.setVisibility(View.GONE);
            StartDateTxt.setText(today);
        }
        if (strPlanType.equals("Third Party")){
            InsuredIDVLiner.setVisibility(View.GONE);
            InsuredIDVLinerSummery.setVisibility(View.GONE);
        }else{
            InsuredIDVLiner.setVisibility(View.VISIBLE);
            InsuredIDVLinerSummery.setVisibility(View.VISIBLE);
        }


        if (changeseekBar.equals("1")){
            InsuredValueTxt.setText(strIdvValueTxtSelect);
            IDVTxt.setText(strIdvValueTxtSelect);
            IDV_new=strIdvValueTxtSelect;
        }else{
            IDV_new=strIdvValueTxt;
            strIdvValueTxtSelect=IDV_new;
            InsuredValueTxt.setText(strIdvValueTxtSelect);
            IDVTxt.setText(strIdvValueTxtSelect);
        }
        if (DetarifficValuePremium.equals("")||DetarifficValuePremium.equals("0.00")){
            DetariffDiscountStatus="False";
            DetarifficValueRate="0";
        }else{
            DetariffDiscountStatus="True";
        }

        if (DetarifficLodingValuePremium.equals("")||DetarifficLodingValuePremium.equals("0.00")){
            DetariffLoadingStatus="False";
            DetarifficLoadingValueRate="0";
        }else{
            DetariffLoadingStatus="True";
        }

        ViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(Motor_summery.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.viewdetails_motor);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(alert_dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.gravity = Gravity.CENTER;

                Button buttonClose=alert_dialog.findViewById(R.id.buttonClose);
                EditText basicPremium=alert_dialog.findViewById(R.id.basicPremium);
                EditText VehicleModelEdit=alert_dialog.findViewById(R.id.VehicleModelEdit);
                EditText YearEdit=alert_dialog.findViewById(R.id.YearEdit);
                EditText addOnsEdit=alert_dialog.findViewById(R.id.addOnsEdit);
                EditText gstEdit=alert_dialog.findViewById(R.id.gstEdit);
                EditText addCoveragesEdit=alert_dialog.findViewById(R.id.addCoveragesEdit);
                EditText BasicODEdit=alert_dialog.findViewById(R.id.BasicODEdit);
                EditText BasicTpEdit=alert_dialog.findViewById(R.id.BasicTpEdit);
                EditText totalAmount=alert_dialog.findViewById(R.id.totalAmount);
                EditText DiscountEdit=alert_dialog.findViewById(R.id.DiscountEdit);
                EditText TotalDiscountEdit=alert_dialog.findViewById(R.id.TotalDiscountEdit);
                EditText NCBEdit=alert_dialog.findViewById(R.id.NCBEdit);
                basicPremium.setText(NetPremiumValue);
                VehicleModelEdit.setText(str_vehicleManufacturerNm+" "+strVehicleModel);
                YearEdit.setText(yearOfManufacture);
                gstEdit.setText(GST);
                BasicODEdit.setText(StrAdditionalCoverPremiumOD);
                BasicTpEdit.setText(StrAdditionalCoverPremiumTp);
                totalAmount.setText(TotalValue);
                DiscountEdit.setText(strDiscountEdit);
                NCBEdit.setText(StrNCB);
                TotalDiscountEdit.setText(DiscountsVale);
                if(CheckString.equals("1")){
                    addOnsEdit.setText(addOnsCover);
                    addCoveragesEdit.setText(addOnsAditional);
                }else{
                    addOnsCover="0.0";
                    addOnsAditional="0.0";
                    addOnsEdit.setText(addOnsCover);
                    addCoveragesEdit.setText(addOnsAditional);
                }
                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert_dialog.dismiss();
                    }
                });
                alert_dialog.show();
            }
        });
        SummeryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
        VehicleMotorProposal();
        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkBox.isChecked()){
                    Toast.makeText(Motor_summery.this, "Accept Terms & Condition", Toast.LENGTH_SHORT).show();
                }else if (strVehicleRadio.equals("Old")&& strVehicleTypeRadio.equals("Four Wheeler")){
                    if (StrPreviousPolicyRadio.equals("No")){
                        ApiCall();
                    }else if (StrPrev_Policy_Type.equals("Comprehensive") || StrPrev_Policy_Type.equals("Own damage (standalone)")){
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            Calendar calendar = Calendar.getInstance();
                            date = calendar.getTime();
                            String todayCheck = sdf.format(date);
                            Date  today_Date = sdf.parse(todayCheck);
                            Date strEndDate = sdf.parse(strEndDateEdit);
                            if (strEndDate.getTime()<today_Date.getTime()){
                                ApiCall();
                            }else{
                                Intent intent=new Intent(Motor_summery.this, MotorPayemntWebURl.class);
                                intent.putExtra("WACode",WACode);
                                intent.putExtra("PosPolicyNo",PosPolicyNo);
                                intent.putExtra("TotalValue",TotalValue);
                                intent.putExtra("checkPage","Summery");
                                startActivity(intent);
                            }
                        }
                        catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }else{
                        Intent intent=new Intent(Motor_summery.this, MotorPayemntWebURl.class);
                        intent.putExtra("WACode",WACode);
                        intent.putExtra("PosPolicyNo",PosPolicyNo);
                        intent.putExtra("TotalValue",TotalValue);
                        intent.putExtra("checkPage","Summery");
                        startActivity(intent);
                    }
                }else{
//                    VehicleMotorProposal();
                    Intent intent=new Intent(Motor_summery.this, MotorPayemntWebURl.class);
                    intent.putExtra("WACode",WACode);
                    intent.putExtra("PosPolicyNo",PosPolicyNo);
                    intent.putExtra("TotalValue",TotalValue);
                    intent.putExtra("checkPage","Summery");
                    startActivity(intent);
                }
            }
        });
    }
    private void back() {
        Intent intent=new Intent(Motor_summery.this,Motor_vehicle_details.class);
        intent.putExtra("strVehicleNo",strVehicleNo);
        intent.putExtra("strName",strName);
        intent.putExtra("strGenderSpinner",strGenderSpinner);
        intent.putExtra("streditdob",streditdob);
        intent.putExtra("strIDType",strIDType);
        intent.putExtra("strIDTypeName",strIDTypeName);
        intent.putExtra("strIDNumberEdit",strIDNumberEdit);
        intent.putExtra("str_edt_city",str_edt_city);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_edt_email",str_edt_email);
        intent.putExtra("strPolicyRadio",strPolicyRadio);
        intent.putExtra("strVehicleTypeRadio",strVehicleTypeRadio);
        intent.putExtra("strVehicleRadio",strVehicleRadio);
        intent.putExtra("str_vehicleManufacturerNm",str_vehicleManufacturerNm);
        intent.putExtra("strVehicleModel",strVehicleModel);
        intent.putExtra("str_edt_registration_date",str_edt_registration_date);
        intent.putExtra("strStateName",strStateName);
        intent.putExtra("strStateRegisterCode",strStateRegisterCode);
        intent.putExtra("strRTOName",strRTOName);
        intent.putExtra("strPolicyNumberEdit",strPolicyNumberEdit);
        intent.putExtra("strPlanType",strPlanType);
        intent.putExtra("strPlanYear",strPlanYear);
        intent.putExtra("strCoverageType",strCoverageType);
        intent.putExtra("strPACover",strPACover);
        intent.putExtra("strGPACover",strGPACover);
        intent.putExtra("strDrivingLicence",strDrivingLicence);
        intent.putExtra("strTitleEdit",strTitleEdit);
        intent.putExtra("strRegisteredAddressEdit",strRegisteredAddressEdit);
        intent.putExtra("strPinCodeEditText",strPinCodeEditText);
        intent.putExtra("strStateRegisterAddressEdit",strStateRegisterAddressEdit);
        intent.putExtra("strCityRegisterEdit",strCityRegisterEdit);
        intent.putExtra("strCommunicationAddressEdit",strCommunicationAddressEdit);
        intent.putExtra("strCommunicationPinCodeEdit",strCommunicationPinCodeEdit);
        intent.putExtra("strStateCommunicationEdit",strStateCommunicationEdit);
        intent.putExtra("strCityCommunicationEdit",strCityCommunicationEdit);
        intent.putExtra("strVehicleChasisNumber",strVehicleChasisNumber);
        intent.putExtra("strVehicleEngineNumber",strVehicleEngineNumber);
        intent.putExtra("strCheckedTermCondition",strCheckedTermCondition);
        intent.putExtra("strCheckboxCommunication",strCheckboxCommunication);
        intent.putExtra("strCityRegisterCode",strCityRegisterCode);
        intent.putExtra("strCityCommunicationCode",strCityCommunicationCode);
        intent.putExtra("TotalValue",TotalValue);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("GST",GST);
        intent.putExtra("strIdvValueTxt",strIdvValueTxt);
        intent.putExtra("strIdvValueTxt",strIdvValueTxt);
        intent.putExtra("strLessIDVText",strLessIDVText);
        intent.putExtra("strHighIDVText",strHighIDVText);
        intent.putExtra("yearOfManufacture",yearOfManufacture);
        intent.putExtra("yearOfManufactureMonth",yearOfManufactureMonth);
        intent.putExtra("strSelectDateYear",strSelectDateYear);
        intent.putExtra("strIDTypeName1",strIDTypeName1);
        intent.putExtra("strVehicleAge",strVehicleAge);
        intent.putExtra("strVehicleManufacturerCode",strVehicleManufacturerCode);
        intent.putExtra("strRTOCode",strRTOCode);
        intent.putExtra("strVehicleModelCode",strVehicleModelCode);
        intent.putExtra("BasicODStatus",BasicODStatus);
        intent.putExtra("BasicTP",BasicTP);
        intent.putExtra("ELECTRICALACCESSORYODStatus",ELECTRICALACCESSORYODStatus);
        intent.putExtra("FIBERTANKODStatus",FIBERTANKODStatus);
        intent.putExtra("LEGALLIABILITYTOPAIDDRIVERStatus",LEGALLIABILITYTOPAIDDRIVERStatus);
        intent.putExtra("NONELECTRICALACCESSORYODStatus",NONELECTRICALACCESSORYODStatus);
        intent.putExtra("OtherODStatus",OtherODStatus);
        intent.putExtra("OtherTpStatus",OtherTpStatus);
        intent.putExtra("PACOVERTOEMPLOYEESOFINSUREDStatus",PACOVERTOEMPLOYEESOFINSUREDStatus);
        intent.putExtra("PACOVERTOOWNERDRIVERStatus",PACOVERTOOWNERDRIVERStatus);
        intent.putExtra("PACOVERTOPAIDDRIVERStatus",PACOVERTOPAIDDRIVERStatus);
        intent.putExtra("PACOVERTOPASSENGERSStatus",PACOVERTOPASSENGERSStatus);
        intent.putExtra("UNNAMEDPACOVERTOPASSENGERSStatus",UNNAMEDPACOVERTOPASSENGERSStatus);
        intent.putExtra("ACCIDENTALHOSPITALIZATIONStatus",ACCIDENTALHOSPITALIZATIONStatus);
        intent.putExtra("COSTOFCONSUMABLESStatus",COSTOFCONSUMABLESStatus);
        intent.putExtra("DAILYCASHALLOWANCEMETROStatus",DAILYCASHALLOWANCEMETROStatus);
        intent.putExtra("DAILYCASHALLOWANCENONMETROStatus",DAILYCASHALLOWANCENONMETROStatus);
        intent.putExtra("ENGINEPROTECTORDIESELStatus",ENGINEPROTECTORDIESELStatus);
        intent.putExtra("ENGINEPROTECTORPETROLStatus",ENGINEPROTECTORPETROLStatus);
        intent.putExtra("HYDROSTATICLOCKCOVERStatus",HYDROSTATICLOCKCOVERStatus);
        intent.putExtra("KEYREPLACEMENTStatus",KEYREPLACEMENTStatus);
        intent.putExtra("NilDepreciationWaivercoverStatus",NilDepreciationWaivercoverStatus);
        intent.putExtra("RETURNTOINVOICEStatus",RETURNTOINVOICEStatus);
        intent.putExtra("RoadsideAssistanceStatus",RoadsideAssistanceStatus);
        intent.putExtra("SECURETOWINGStatus",SECURETOWINGStatus);
        intent.putExtra("TyreandRimsecureStatus",TyreandRimsecureStatus);
        intent.putExtra("VehicleExShowroomPrice",VehicleExShowroomPrice);
        intent.putExtra("tomorrowDate",tomorrowDate);
        intent.putExtra("NCB",NCB);
        intent.putExtra("addOns",addOns);
        intent.putExtra("VehicleClassCode",VehicleClassCode);
        intent.putExtra("ProductCode",ProductCode);
        intent.putExtra("ProductName",ProductName);
        intent.putExtra("strClaimBonus",strClaimBonus);
        intent.putExtra("strEndDateEdit",strEndDateEdit);
        intent.putExtra("StrPreviousPolicyRadio",StrPreviousPolicyRadio);
        intent.putExtra("VEHICLECLASSCODE",VEHICLECLASSCODE);
        intent.putExtra("strVehicleChasisNumber",strVehicleChasisNumber);
        intent.putExtra("strVehicleEngineNumber",strVehicleEngineNumber);
        intent.putExtra("rc_fuel_desc",rc_fuel_desc);
        intent.putExtra("rc_cubic_cap",rc_cubic_cap);
        intent.putExtra("FuleType",FuleType);
        intent.putExtra("strCompanyName",strCompanyName);
        intent.putExtra("strODPlanFromDateEdit",strODPlanFromDateEdit);
        intent.putExtra("strODPlanEndDateEdit",strODPlanEndDateEdit);
        intent.putExtra("strTpPlanFromDateEdit",strTpPlanFromDateEdit);
        intent.putExtra("strTpPlanEndDateEdit",strTpPlanEndDateEdit);
        intent.putExtra("nextYear",nextYear);
        intent.putExtra("StrPrev_Policy_Type",StrPrev_Policy_Type);
        intent.putExtra("vehicleManufacturerType",vehicleManufacturerType);
        intent.putExtra("strModelType",strModelType);
        intent.putExtra("addOnsCover",addOnsCover);
        intent.putExtra("addOnsAditional",addOnsAditional);
        intent.putExtra("SeekbarStatus",SeekbarStatus);
        intent.putExtra("StrAdditionalCoverPremiumOD",StrAdditionalCoverPremiumOD);
        intent.putExtra("StrAdditionalCoverPremiumTp",StrAdditionalCoverPremiumTp);
        intent.putExtra("strPreviousClaimRadio",strPreviousClaimRadio);
        intent.putExtra("strNomineeName",strNomineeName);
        intent.putExtra("strNomineeRelationEdit",strNomineeRelationEdit);
        intent.putExtra("AdditionalElectricalRateValue",AdditionalElectricalRateValue);
        intent.putExtra("AdditionalFibertankODRateValue",AdditionalFibertankODRateValue);
        intent.putExtra("AdditionalLegalLiabilityDriverRateValue",AdditionalLegalLiabilityDriverRateValue);
        intent.putExtra("AdditionalNonElecticalODRateValue",AdditionalNonElecticalODRateValue);
        intent.putExtra("AdditionalOtherODRateValue",AdditionalOtherODRateValue);
        intent.putExtra("AdditionalOtherTpRateValue",AdditionalOtherTpRateValue);
        intent.putExtra("AdditionalPaCoversToEmployessRateValue",AdditionalPaCoversToEmployessRateValue);
        intent.putExtra("AdditionalPaCoverToOwnerDriverRateValue",AdditionalPaCoverToOwnerDriverRateValue);
        intent.putExtra("AdditionalPaidDriverRateValue",AdditionalPaidDriverRateValue);
        intent.putExtra("AdditionalPaToPassengersRateValue",AdditionalPaToPassengersRateValue);
        intent.putExtra("AdditionalUnnamedPassengersRateValue",AdditionalUnnamedPassengersRateValue);
        intent.putExtra("AdditionalCngKitODRateValue",AdditionalCngKitODRateValue);
        intent.putExtra("AdditionalCngLpgTpRateValue",AdditionalCngLpgTpRateValue);
        intent.putExtra("AdditionalBuiltinKitODRateValue",AdditionalBuiltinKitODRateValue);
        intent.putExtra("AdditionalBuiltinCngTPRateValue",AdditionalBuiltinCngTPRateValue);
        intent.putExtra("AccidentalRateValue",AccidentalRateValue);
        intent.putExtra("CostOfConsumablesRateValue",CostOfConsumablesRateValue);
        intent.putExtra("dailyCashAllowanceMetroRateValue",dailyCashAllowanceMetroRateValue);
        intent.putExtra("dailyCashAllowanceNonMetroRateValue",dailyCashAllowanceNonMetroRateValue);
        intent.putExtra("EngineProtectorDieselRateValue",EngineProtectorDieselRateValue);
        intent.putExtra("EngineProtectorPetrolRateValue",EngineProtectorPetrolRateValue);
        intent.putExtra("HydrostaticLockRateValue",HydrostaticLockRateValue);
        intent.putExtra("KeyReplacementRateValue",KeyReplacementRateValue);
        intent.putExtra("NilDepreciationRateValue",NilDepreciationRateValue);
        intent.putExtra("ReturnToInvoiceRateValue",ReturnToInvoiceRateValue);
        intent.putExtra("RoadSideAssistanceRateValue",RoadSideAssistanceRateValue);
        intent.putExtra("SecureTowingRateValue",SecureTowingRateValue);
        intent.putExtra("TyreRimsecureRateValue",TyreRimsecureRateValue);
        intent.putExtra("drivingTrainProtectRateValue",drivingTrainProtectRateValue);
        intent.putExtra("ManufacturesellingRateValue",ManufacturesellingRateValue);
        intent.putExtra("CNGLPGKITODStatus",CNGLPGKITODStatus);
        intent.putExtra("CNGLPGKITTPStatus",CNGLPGKITTPStatus);
        intent.putExtra("BUILTINCNGKIT_LPGKITODStatus",BUILTINCNGKIT_LPGKITODStatus);
        intent.putExtra("MANUFACTURERSELLINGPRICEStatus",MANUFACTURERSELLINGPRICEStatus);
        intent.putExtra("DRIVINGTRAINPROTECTStatus",DRIVINGTRAINPROTECTStatus);
        intent.putExtra("AdditionalLegalLiabilityPaidRate",AdditionalLegalLiabilityPaidRate);
        intent.putExtra("BUILTINCNGKIT_LPGKITTPStatus",BUILTINCNGKIT_LPGKITTPStatus);
        intent.putExtra("progressChanged",progressChanged);
        intent.putExtra("BasicODRateValue",BasicODRateValue);
        intent.putExtra("BasicTpRateValue",BasicTpRateValue);
        intent.putExtra("strIdvValueTxtSelect",strIdvValueTxtSelect);
        intent.putExtra("changeseekBar",changeseekBar);
        intent.putExtra("DAILYCASHALLOWANCEStatus",DAILYCASHALLOWANCEStatus);
        intent.putExtra("WRONGFUELCOVERStatus",WRONGFUELCOVERStatus);
        intent.putExtra("DailyCashRateValue",DailyCashRateValue);
        intent.putExtra("WrongFuelRateValue",WrongFuelRateValue);
        intent.putExtra("DetarifficValuePremium",DetarifficValuePremium);
        intent.putExtra("DetarifficValueRate",DetarifficValueRate);
        intent.putExtra("DetarifficLodingValuePremium",DetarifficLodingValuePremium);
        intent.putExtra("DetarifficLoadingValueRate",DetarifficLoadingValueRate);
        intent.putExtra("DetarifficValueSumInsure",DetarifficValueSumInsure);
        intent.putExtra("DetarifficLoadingValueSumInsured",DetarifficLoadingValueSumInsured);
        intent.putExtra("BasicODRateSumInsured",BasicODRateSumInsured);
        intent.putExtra("BasicTpRateSumInsured",BasicTpRateSumInsured);
        intent.putExtra("ELECTRICALCoverSumInsured",ELECTRICALCoverSumInsured);
        intent.putExtra("NONELECTRICALSumInsured",NONELECTRICALSumInsured);
        intent.putExtra("AdditionalFibertankODSumInsuredValue",AdditionalFibertankODSumInsuredValue);
        intent.putExtra("AdditionalLegalLiabilityPaidSumInsured",AdditionalLegalLiabilityPaidSumInsured);
        intent.putExtra("AdditionalOtherODRateSumInsured",AdditionalOtherODRateSumInsured);
        intent.putExtra("AdditionalOtherTpSumInsuredValue",AdditionalOtherTpSumInsuredValue);
        intent.putExtra("AdditionalPaCoverToOwnerDriverSumInsuredValue",AdditionalPaCoverToOwnerDriverSumInsuredValue);
        intent.putExtra("AdditionalPaidDriverSumInsuredValue",AdditionalPaidDriverSumInsuredValue);
        intent.putExtra("AdditionalPaToPassengersSumInsuredValue",AdditionalPaToPassengersSumInsuredValue);
        intent.putExtra("AdditionalUnnamedPassengersSumInsuredValue",AdditionalUnnamedPassengersSumInsuredValue);
        intent.putExtra("AdditionalCngKitODSumInsuredValue",AdditionalCngKitODSumInsuredValue);
        intent.putExtra("AdditionalCngLpgTpSumInsuredValue",AdditionalCngLpgTpSumInsuredValue);
        intent.putExtra("AdditionalBuiltinKitODSumInsuredValue",AdditionalBuiltinKitODSumInsuredValue);
        intent.putExtra("AdditionalBuiltinCngTPSumInsuredValue",AdditionalBuiltinCngTPSumInsuredValue);
        intent.putExtra("DailyCashRateSumInsured",DailyCashRateSumInsured);
        intent.putExtra("AccidentalSumInsuredValue",AccidentalSumInsuredValue);
        intent.putExtra("WrongFuelSumInsuredValue",WrongFuelSumInsuredValue);
        intent.putExtra("CostOfConsumablesSumInsuredValue",CostOfConsumablesSumInsuredValue);
        intent.putExtra("dailyCashAllowanceMetroSumInsuredValue",dailyCashAllowanceMetroSumInsuredValue);
        intent.putExtra("dailyCashAllowanceNonMetroSumInsuredValue",dailyCashAllowanceNonMetroSumInsuredValue);
        intent.putExtra("EngineProtectorDieselSumInsuredValue",EngineProtectorDieselSumInsuredValue);
        intent.putExtra("EngineProtectorPetrolSumInsuredValue",EngineProtectorPetrolSumInsuredValue);
        intent.putExtra("HydrostaticLockSumInsuredValue",HydrostaticLockSumInsuredValue);
        intent.putExtra("KeyReplacementSumInsuredValue",KeyReplacementSumInsuredValue);
        intent.putExtra("NilDepreciationSumInsuredValue",NilDepreciationSumInsuredValue);
        intent.putExtra("ReturnToInvoiceSumInsuredValue",ReturnToInvoiceSumInsuredValue);
        intent.putExtra("RoadSideAssistanceSumInsuredValue",RoadSideAssistanceSumInsuredValue);
        intent.putExtra("SecureTowingSumInsuredValue",SecureTowingSumInsuredValue);
        intent.putExtra("TyreRimsecureSumInsuredValue",TyreRimsecureSumInsuredValue);
        intent.putExtra("drivingTrainProtectSumInsuredValue",drivingTrainProtectSumInsuredValue);
        intent.putExtra("ManufacturesellingSumInsuredValue",ManufacturesellingSumInsuredValue);
        intent.putExtra("ChangeAddons",ChangeAddons);
        intent.putExtra("strDiscountEdit",strDiscountEdit);
        intent.putExtra("a",a);
        intent.putExtra("b",b);
        intent.putExtra("VehicleAgeAdd",VehicleAgeAdd);
        intent.putExtra("MonthsLeft",MonthsLeft);
        intent.putExtra("c",c);
        intent.putExtra("CheckString",CheckString);
        intent.putExtra("strStateCode",strStateCode);
        intent.putExtra("strVehicleCubicCapicity",strVehicleCubicCapicity);
        intent.putExtra("strVehicleImage",strVehicleImage);
        intent.putExtra("StrNCB",StrNCB);
        intent.putExtra("AdditionalNonElecticalODSumInsuredValue",AdditionalNonElecticalODSumInsuredValue);
        intent.putExtra("AdditionalElectricalSumInsuredValue",AdditionalElectricalSumInsuredValue);
        intent.putExtra("AntitheftdeviceRateValue",AntitheftdeviceRateValue);
        intent.putExtra("AntitheftdeviceSumInsuredValue",AntitheftdeviceSumInsuredValue);
        intent.putExtra("AutomobileAssociationRateValue",AutomobileAssociationRateValue);
        intent.putExtra("AutomobileAssociationSumInsuredValue",AutomobileAssociationSumInsuredValue);
        intent.putExtra("HandicapRateValue",HandicapRateValue);
        intent.putExtra("HandicapSumInsuredValue",HandicapSumInsuredValue);
        intent.putExtra("TPPDDiscountRateValue",TPPDDiscountRateValue);
        intent.putExtra("TPPDDiscountSumInsuredValue",TPPDDiscountSumInsuredValue);
        intent.putExtra("VotaryRateValue",VotaryRateValue);
        intent.putExtra("VotarySumInsuredValue",VotarySumInsuredValue);
        intent.putExtra("AntitheftdevicediscountStatus",AntitheftdevicediscountStatus);
        intent.putExtra("AutomobileAssociationdiscountStatus",AutomobileAssociationdiscountStatus);
        intent.putExtra("TPPDDiscountStatus",TPPDDiscountStatus);
        intent.putExtra("HandicapDiscountStatus",HandicapDiscountStatus);
        intent.putExtra("VoluntarydeductableStatus",VoluntarydeductableStatus);
        intent.putExtra("DiscountsVale",DiscountsVale);
        intent.putExtra("strMinMax",strMinMax);
        intent.putExtra("strElectricalAccessoriesSumInsured",strElectricalAccessoriesSumInsured);
        intent.putExtra("strNonelectricalAccessoriesSumInsured",strNonelectricalAccessoriesSumInsured);
        intent.putExtra("PACOVERTOPASSENGERSSumInsured",PACOVERTOPASSENGERSSumInsured);
        intent.putExtra("UNNAMEDPACOVERTOPASSENGERSSumInsured",UNNAMEDPACOVERTOPASSENGERSSumInsured);
        intent.putExtra("PACOVERTOPAIDDRIVERSumInsured",PACOVERTOPAIDDRIVERSumInsured);
        intent.putExtra("strCngKitSumInsured",strCngKitSumInsured);
        intent.putExtra("AutoMobileRadio",AutoMobileRadio);
        intent.putExtra("AutoMobileValidityRadio",AutoMobileValidityRadio);
        intent.putExtra("AutomobileAssociationdiscountSumInsured",AutomobileAssociationdiscountSumInsured);
        intent.putExtra("VoluntarydeductableSumInsured",VoluntarydeductableSumInsured);
        intent.putExtra("ELECTRICALACCESSORYODSumInsured",ELECTRICALACCESSORYODSumInsured);
        intent.putExtra("NONELECTRICALACCESSORYODSumInsured",NONELECTRICALACCESSORYODSumInsured);
        intent.putExtra("CNGLPGKITODSumInsured",CNGLPGKITODSumInsured);
        intent.putExtra("VoluntarydeductableDiscountAmount",VoluntarydeductableDiscountAmount);
        intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
        intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
        intent.putExtra("NCBStatus",NCBStatus);
        intent.putExtra("selectYear",selectYear);
        intent.putExtra("daysLeft",daysLeft);
        intent.putExtra("ckycNo",ckycNo);
        intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
        intent.putExtra("strFor","1");
        intent.putExtra("strNewFor","1");
        startActivity(intent);
        overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);
        finish();
    }
    private void VehicleMotorProposal() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("CustomerType", strCoverageType);
            object.put("PosPolicyNo", PosPolicyNo);
            object.put("TotalPremium", "");
            object.put("ProductName", ProductName);
            object.put("MobileNo", str_edt_phone);
            object.put("UserEmail", str_edt_email);
            object.put("UserName", strName);
            object.put("RegistrationNumber", strVehicleNo);
            object.put("ProductCode", ProductCode);
            object.put("Product", "");
            object.put("BusinessType", strPolicyRadio);
            object.put("VehicleClassCode", VehicleClassCode);
            object.put("VehicleMakeCode", strVehicleManufacturerCode);
            object.put("YearofManufacture",yearOfManufacture);
            object.put("VehicleType", strVehicleRadio);
            object.put("CubicCapacity", strVehicleCubicCapicity);
//            object.put("CubicCapacity", Integer.parseInt(rc_cubic_cap));
            object.put("NumberOfWheels", "");
            object.put("ChassisNumber", strVehicleChasisNumber);
            object.put("EngineNumber", strVehicleEngineNumber);
            object.put("VehicleAge", strVehicleAge);
            object.put("VehicleModelCode", strVehicleModelCode);
            object.put("RTOLocationCode", strRTOCode);
            object.put("GrossVehicleWeight", "0");
            object.put("PlaceOfRegistration",strRTOName );
            object.put("VehicleModel", strVehicleModel);
            object.put("DateOfFirstRegistration", str_edt_registration_date);
            object.put("DateOfRegistration", str_edt_registration_date);
            object.put("City", strRTOName);
            object.put("SumInsured", IDV_new);
            object.put("IDV", IDV_new);
            object.put("FuelType", FuleType);
            object.put("VehicleMake", str_vehicleManufacturerNm);
            object.put("Fromdate", today);
            object.put("Todate", nextYear);
            object.put("BasicODStatus", BasicODStatus);
            object.put("BasicODRate", BasicODRateValue);
            object.put("BasicODSumInsured", BasicODRateSumInsured);
            object.put("ELECTRICALACCESSORYODStatus", ELECTRICALACCESSORYODStatus);
            object.put("ELECTRICALACCESSORYODRate", AdditionalElectricalRateValue);
            object.put("ELECTRICALACCESSORYODSumInsured", AdditionalElectricalSumInsuredValue);
//            object.put("ELECTRICALACCESSORYODSumInsured", ELECTRICALCoverSumInsured);
            object.put("NONELECTRICALACCESSORYODStatus", NONELECTRICALACCESSORYODStatus);
            object.put("NONELECTRICALACCESSORYODRate", AdditionalNonElecticalODRateValue);
            object.put("NONELECTRICALACCESSORYODSumInsured", AdditionalNonElecticalODSumInsuredValue);
            object.put("BasicTP",BasicTP);
            object.put("BasicTPRate",BasicTpRateValue);
            object.put("BasicTPSumInsured",BasicTpRateSumInsured);
            object.put("NCB", strClaimBonus);
            object.put("PACOVERTOEMPLOYEESOFINSUREDStatus", PACOVERTOEMPLOYEESOFINSUREDStatus);
            object.put("PACOVERTOEMPLOYEESOFINSUREDRate", AdditionalPaCoversToEmployessRateValue);
            object.put("PACOVERTOPASSENGERSStatus", PACOVERTOPASSENGERSStatus);
            object.put("PACOVERTOPASSENGERSRate", AdditionalPaToPassengersRateValue);
            object.put("PACOVERTOPASSENGERSSumInsured", AdditionalPaToPassengersSumInsuredValue);
            object.put("PACOVERTOPAIDDRIVERStatus", PACOVERTOPAIDDRIVERStatus);
            object.put("PACOVERTOPAIDDRIVERRate", AdditionalPaidDriverRateValue);
            object.put("PACOVERTOPAIDDRIVERSumInsured", AdditionalPaidDriverSumInsuredValue);
            object.put("OtherTPStatus", OtherTpStatus);
            object.put("OtherTPRate", AdditionalOtherTpRateValue);
            object.put("OtherTPSumInsured", AdditionalOtherTpSumInsuredValue);
            object.put("FIBERTANKODStatus", FIBERTANKODStatus);
            object.put("FIBERTANKODRate", AdditionalFibertankODRateValue);
            object.put("FIBERTANKODSumInsured", AdditionalFibertankODSumInsuredValue);
            object.put("OtherODStatus", OtherODStatus);
            object.put("OtherODRate", AdditionalOtherODRateValue);
            object.put("OtherODSumInsured", AdditionalOtherODRateSumInsured);
            object.put("UNNAMEDPACOVERTOPASSENGERSStatus", UNNAMEDPACOVERTOPASSENGERSStatus);
            object.put("UNNAMEDPACOVERTOPASSENGERSRate", AdditionalUnnamedPassengersRateValue);
            object.put("UNNAMEDPACOVERTOPASSENGERSSumInsured", AdditionalUnnamedPassengersSumInsuredValue);
            object.put("PACOVERTOOWNERDRIVERStatus", PACOVERTOOWNERDRIVERStatus);
            object.put("PACOVERTOOWNERDRIVERRate", AdditionalPaCoverToOwnerDriverRateValue);
            object.put("PACOVERTOOWNERDRIVERSumInsured", AdditionalPaCoverToOwnerDriverSumInsuredValue);
            object.put("LEGALLIABILITYTOPAIDDRIVERStatus", LEGALLIABILITYTOPAIDDRIVERStatus);
            object.put("LEGALLIABILITYTOPAIDDRIVERRate", AdditionalLegalLiabilityPaidRate);
            object.put("LEGALLIABILITYTOPAIDDRIVERSumInsured", AdditionalLegalLiabilityPaidSumInsured);
            object.put("RoadsideAssistanceStatus", RoadsideAssistanceStatus);
            object.put("RoadsideAssistanceRate", RoadSideAssistanceRateValue);
            object.put("RoadsideAssistanceSumInsured", RoadSideAssistanceSumInsuredValue);
            object.put("NilDepreciationWaivercoverStatus", NilDepreciationWaivercoverStatus);
            object.put("NilDepreciationWaivercoverRate", NilDepreciationRateValue);
            object.put("NilDepreciationWaivercoverSumInsured", NilDepreciationSumInsuredValue);
            object.put("DAILYCASHALLOWANCENONMETROStatus", DAILYCASHALLOWANCENONMETROStatus);
            object.put("DAILYCASHALLOWANCENONMETRORate", dailyCashAllowanceNonMetroRateValue);
            object.put("DAILYCASHALLOWANCENONMETROSumInsured", dailyCashAllowanceNonMetroSumInsuredValue);
            object.put("DAILYCASHALLOWANCEMETROStatus", DAILYCASHALLOWANCEMETROStatus);
            object.put("DAILYCASHALLOWANCEMETRORate", dailyCashAllowanceMetroRateValue);
            object.put("DAILYCASHALLOWANCEMETROSumInsured", dailyCashAllowanceMetroSumInsuredValue);
            object.put("KEYREPLACEMENTStatus", KEYREPLACEMENTStatus);
            object.put("KEYREPLACEMENTRate", KeyReplacementRateValue);
            object.put("RETURNTOINVOICEStatus", RETURNTOINVOICEStatus);
            object.put("RETURNTOINVOICERate", ReturnToInvoiceRateValue);
            object.put("RETURNTOINVOICESumInsured", ReturnToInvoiceSumInsuredValue);
            object.put("ACCIDENTALHOSPITALIZATIONStatus", ACCIDENTALHOSPITALIZATIONStatus);
            object.put("ACCIDENTALHOSPITALIZATIONRate", AccidentalRateValue);
            object.put("ACCIDENTALHOSPITALIZATIONSumInsured", AccidentalSumInsuredValue);
            object.put("HYDROSTATICLOCKCOVERStatus", HYDROSTATICLOCKCOVERStatus);
            object.put("HYDROSTATICLOCKCOVERRate", HydrostaticLockRateValue);
            object.put("HYDROSTATICLOCKCOVERSumInsured", HydrostaticLockSumInsuredValue);
            object.put("COSTOFCONSUMABLESStatus", COSTOFCONSUMABLESStatus);
            object.put("COSTOFCONSUMABLESRate", CostOfConsumablesRateValue);
            object.put("COSTOFCONSUMABLESSumInsured", CostOfConsumablesSumInsuredValue);
            object.put("SECURETOWINGStatus", SECURETOWINGStatus);
            object.put("SECURETOWINGRate", SecureTowingRateValue);
            object.put("TyreandRimsecureStatus", TyreandRimsecureStatus);
            object.put("TyreandRimsecureRate", TyreRimsecureRateValue);
            object.put("TyreandRimsecureSumInsured", TyreRimsecureSumInsuredValue);
            object.put("ENGINEPROTECTORPETROLStatus", ENGINEPROTECTORPETROLStatus);
            object.put("ENGINEPROTECTORPETROLRate", EngineProtectorPetrolRateValue);
            object.put("ENGINEPROTECTORPETROLSumInsured", EngineProtectorPetrolSumInsuredValue);
            object.put("ENGINEPROTECTORDIESELStatus", ENGINEPROTECTORDIESELStatus);
            object.put("ENGINEPROTECTORDIESELRate", EngineProtectorDieselRateValue);
            object.put("ENGINEPROTECTORDIESELSumInsured", EngineProtectorDieselSumInsuredValue);
            object.put("DRIVINGTRAINPROTECTStatus", DRIVINGTRAINPROTECTStatus);
            object.put("DRIVINGTRAINPROTECTRate", drivingTrainProtectRateValue);
            object.put("DRIVINGTRAINPROTECTSumInsured", drivingTrainProtectSumInsuredValue);
            object.put("MANUFACTURERSELLINGPRICERate", ManufacturesellingRateValue);
            object.put("MANUFACTURERSELLINGPRICEStatus", MANUFACTURERSELLINGPRICEStatus);
            object.put("MANUFACTURERSELLINGPRICESumInsured", ManufacturesellingSumInsuredValue);
            object.put("DetariffLoadingRate", DetarifficLoadingValueRate);
            object.put("DetariffLoadingStatus", DetariffLoadingStatus);
            object.put("DetariffLoadingSumInsured", DetarifficLoadingValueSumInsured);
            object.put("DetariffDiscountRate", DetarifficValueRate);
            object.put("DetariffDiscountStatus", DetariffDiscountStatus);
            object.put("DetariffDiscountSumInsured", DetarifficValueSumInsure);
            object.put("CNGLPGKITODRate", AdditionalCngKitODRateValue);
            object.put("CNGLPGKITODStatus", CNGLPGKITODStatus);
            object.put("CNGLPGKITODSumInsured", AdditionalCngKitODSumInsuredValue);
            object.put("CNGLPGKITTPRate", AdditionalCngLpgTpRateValue);
            object.put("CNGLPGKITTPStatus", CNGLPGKITTPStatus);
            object.put("CNGLPGKITTPSumInsured", AdditionalCngLpgTpSumInsuredValue);
            object.put("BUILTINCNGKIT_LPGKITODRate", AdditionalBuiltinKitODRateValue);
            object.put("BUILTINCNGKIT_LPGKITODStatus", BUILTINCNGKIT_LPGKITODStatus);
            object.put("BUILTINCNGKIT_LPGKITODSumInsured", AdditionalBuiltinKitODSumInsuredValue);
            object.put("BUILTINCNGKIT_LPGKITTPRate", AdditionalBuiltinCngTPRateValue);
            object.put("BUILTINCNGKIT_LPGKITTPStatus", BUILTINCNGKIT_LPGKITTPStatus);
            object.put("BUILTINCNGKIT_LPGKITTPSumInsured", AdditionalBuiltinCngTPSumInsuredValue);
            object.put("DAILYCASHALLOWANCEStatus", "False");
            object.put("DAILYCASHALLOWANCERate", "");
            object.put("DAILYCASHALLOWANCESumInsured", DailyCashRateSumInsured);
            object.put("WRONGFUELCOVERStatus", WRONGFUELCOVERStatus);
            object.put("WRONGFUELCOVERRate", WrongFuelRateValue);
            object.put("WRONGFUELCOVERSumInsured", WrongFuelSumInsuredValue);
            object.put("VehicleExShowroomPrice", VehicleExShowroomPrice);
            object.put("PolicyEffectiveFrom", today);
            object.put("PolicyEffectiveTo", nextYear);
            object.put("PolicyStatus", "Unexpired");
            object.put("PolicyPremium", TotalValue);
            object.put("PolicyNo", strPolicyNumberEdit);
            object.put("InsurerName", strCompanyName);
            object.put("NCBStatus", NCBStatus);
            object.put("NomineeName",strNomineeName);
            object.put("NomineeRelation", strNomineeRelationEdit);
            object.put("AntitheftdevicediscountStatus", AntitheftdevicediscountStatus);
            object.put("AntitheftdevicediscountRate", AntitheftdeviceRateValue);
            object.put("AntitheftdevicediscountSumInsured", AntitheftdeviceSumInsuredValue);
            object.put("AutomobileAssociationdiscountStatus", AutomobileAssociationdiscountStatus);
            object.put("AutomobileAssociationdiscountRate", AutomobileAssociationRateValue);
            object.put("AutomobileAssociationdiscountSumInsured", AutomobileAssociationSumInsuredValue);
            object.put("TPPDDiscountStatus", TPPDDiscountStatus);
            object.put("TPPDDiscountRate", TPPDDiscountRateValue);
            object.put("TPPDDiscountSumInsured", TPPDDiscountSumInsuredValue);
            object.put("HandicapDiscountStatus", HandicapDiscountStatus);
            object.put("HandicapDiscountRate", HandicapRateValue);
            object.put("HandicapDiscountSumInsured", HandicapSumInsuredValue);
            object.put("VoluntarydeductableStatus", VoluntarydeductableStatus);
            object.put("VoluntarydeductableRate", VotaryRateValue);
            object.put("VoluntarydeductableSumInsured", VotarySumInsuredValue);
            object.put("EkycNo", ckycNo);
            object.put("Ref_No_Unique_KYC", uniqueTransactionNumber);
            object.put("DOB", streditdob);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_summery.this, object, UrlConstants.BUY_VehicleMotorProposal, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    if (Tag == RequestConstants.BUY_POLICY_MOTOR_PRIVATE_PROPOSAL) {
                        try {
                            JSONObject AuthenticationJsonObject = object.getJSONObject("Authentication");
                            JSONObject CustomerJsonObject = object.getJSONObject("Customer");
                            JSONObject ProductJsonObject = object.getJSONObject("Product");
                            JSONObject GeneralProposalJsonObject = ProductJsonObject.getJSONObject("GeneralProposal");
                            Log.e("GeneralProposalJsonObject", String.valueOf(GeneralProposalJsonObject));
                            JSONObject PreviousPolicyDetailsJsonObject = GeneralProposalJsonObject.getJSONObject("PreviousPolicyDetails");
                            Log.e("PreviousPolicyDetailsJsonObject", String.valueOf(PreviousPolicyDetailsJsonObject));
                            JSONObject PreviousPolDtlGroupJsonObject = PreviousPolicyDetailsJsonObject.getJSONObject("PreviousPolDtlGroup");
                            Log.e("PreviousPolDtlGroupJsonObject", String.valueOf(PreviousPolDtlGroupJsonObject));
                            JSONObject PreviousPolDtlGroupDataJsonObject = PreviousPolDtlGroupJsonObject.getJSONObject("PreviousPolDtlGroupData");
                            Log.e("PreviousPolDtlGroupDataJsonObject", String.valueOf(PreviousPolDtlGroupDataJsonObject));
                            JSONObject PremiumCalculationJsonObject = ProductJsonObject.getJSONObject("PremiumCalculation");
                            JSONObject TotalPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("TotalPremium");
                            Log.e("TotalPremiumJsonObject",TotalPremiumJsonObject.toString());
                            WACode = AuthenticationJsonObject.getString("WACode");
                            TotalValue = TotalPremiumJsonObject.getString("Value");
                            Log.e("TotalValue",TotalValue);
                            PosPolicyNo = CustomerJsonObject.getString("PosPolicyNo");
                            Log.e("PosPolicyNo",PosPolicyNo);
                            JSONObject PolicyPremiumJsonObject = PreviousPolDtlGroupDataJsonObject.getJSONObject("PolicyPremium");
                            JSONObject RisksDataJsonObject = ProductJsonObject.getJSONObject("Risks");
                            JSONObject RiskDataJsonObject = RisksDataJsonObject.getJSONObject("Risk");
                            Log.e("RiskDataJsonObject",RiskDataJsonObject.toString());

                            JSONObject RisksDatasJsonObject = RiskDataJsonObject.getJSONObject("RisksData");
                            Log.e("RisksDatasJsonObject",RisksDatasJsonObject.toString());
                            JSONObject OtherDiscountsJsonObject = RisksDatasJsonObject.getJSONObject("OtherDiscounts");
                            JSONObject OtherDiscountGroupJsonObject = OtherDiscountsJsonObject.getJSONObject("OtherDiscountGroup");
                            JSONArray OtherDiscountGroupDataJsonObject = OtherDiscountGroupJsonObject.getJSONArray("OtherDiscountGroupData");
//                            TotalValue = PolicyPremiumJsonObject.getString("Value");
//                            Log.e("TotalValue",TotalValue);
//                            Intent intent=new Intent(Motor_summery.this, MotorPayemntWebURl.class);
//                            intent.putExtra("WACode",WACode);
//                            intent.putExtra("PosPolicyNo",PosPolicyNo);
//                            intent.putExtra("TotalValue",TotalValue);
//                            intent.putExtra("checkPage","Summery");
//                            startActivity(intent);
                            TotalPremiumTxt.setText(TotalValue);
                            totalValue.setText(TotalValue);

                            for (int l=0; l <OtherDiscountGroupDataJsonObject.length();l++) {
                                JSONObject DescriptionJson = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Description");
                                Log.e("DescriptionJson", DescriptionJson.toString());

                                String Value = DescriptionJson.getString("Value");
                                if (Value.equals("No claim bonus")) {
                                    NCBPremium = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                    Log.e("NCBPremium",NCBPremium);
                                    StrNCB =NCBPremium;
                                    NCBTxt.setText(NCBPremium);

                                }
                            }


                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    String message=object.optString("Message");
                    Toast.makeText(getApplication(), ""+message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE_PROPOSAL);
        req.execute();
    }
    private void alertPopup() {
        Dialog dialogPopup;
        dialogPopup = new Dialog(Motor_summery.this);
        dialogPopup.setCanceledOnTouchOutside(false);
        dialogPopup.setCancelable(false);
        dialogPopup.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialogPopup.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogPopup.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialogPopup.setContentView(R.layout.break_in_journey_popup);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialogPopup.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogPopup.show();
        LinearLayout continueButtonPopup = dialogPopup.findViewById(R.id.continueButtonPopup);
        ImageView cutImg = dialogPopup.findViewById(R.id.cutImg);
        continueButtonPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEndDateEdit="";
                strTpEndDateEdit="";
                ApiCall();
                dialogPopup.dismiss();
            }


        });

        cutImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogPopup.dismiss();
            }
        });
    }
    private void ApiCall() {

        JSONObject mainJson  = new JSONObject();
        JSONObject authentication  = new JSONObject();

        try {
            authentication.put("WACode", "20000001");
            authentication.put("WAAppCode", "30000004");
            authentication.put("ProductCode", ProductCode);
            mainJson.put("Authentication",authentication);
            mainJson.put("Name", strName);
            mainJson.put("Email", str_edt_email);
            mainJson.put("mobileNumber", str_edt_phone);
            mainJson.put("Address", strRegisteredAddressEdit);
            mainJson.put("regNumber", strVehicleNo);
            mainJson.put("VehicleType", strVehicleTypeRadio);
            mainJson.put("Make", strVehicleModel);
            mainJson.put("brand", str_vehicleManufacturerNm);
            mainJson.put("ModelYear", yearOfManufacture);
            mainJson.put("FuelType", FuleType);
            mainJson.put("regType", "non-commercial");
            mainJson.put("ReferenceId", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_summery.this, mainJson, UrlConstants.VehicleMotorBreaking, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {

                if (Tag == RequestConstants.VehicleMotorBreaking) {
                    String refId = object.optString("ReferenceId");

                    breakingRefApi(refId);


                }

            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestConstants.VehicleMotorBreaking);
        req.execute();

    }
    private void breakingRefApi(String refId) {
        JSONObject mainJson  = new JSONObject();
        JSONObject authentication  = new JSONObject();

        try {
            authentication.put("WACode", "20000001");
            authentication.put("WAAppCode", "30000004");
            authentication.put("ProductCode", ProductCode);
            mainJson.put("Authentication",authentication);
            mainJson.put("Name", strName);
            mainJson.put("ReferenceId", refId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_summery.this, mainJson, UrlConstants.VehicleMotorBreakingRefId, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {

                if (Tag == RequestConstants.VehicleMotorBreakingRefId) {

                    alertPopupBreak(refId);


                }

            }
            @Override
            public void onError(VolleyError error, int Tag) {
                Toast.makeText(Motor_summery.this, "Error"+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        }, RequestConstants.VehicleMotorBreakingRefId);
        req.execute();

    }
    private void alertPopupBreak(String refId) {
        Dialog dialogPopup;
        dialogPopup = new Dialog(Motor_summery.this);
        dialogPopup.setCanceledOnTouchOutside(false);
        dialogPopup.setCancelable(false);
        dialogPopup.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialogPopup.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogPopup.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialogPopup.setContentView(R.layout.breaking_reg_idpop_up);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialogPopup.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogPopup.show();

        ImageView cutImg = dialogPopup.findViewById(R.id.cutImg);
        TextView refid = dialogPopup.findViewById(R.id.refid);

        refid.setText(refId);


        cutImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Motor_summery.this, MainActivity.class);
                startActivity(in);
                Motor_summery.this.finish();
                dialogPopup.dismiss();

            }
        });
    }
    @Override
    public void onBackPressed() {
        back();
    }
}