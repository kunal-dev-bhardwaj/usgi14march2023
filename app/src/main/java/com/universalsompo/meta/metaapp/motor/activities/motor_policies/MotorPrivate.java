package com.universalsompo.meta.metaapp.motor.activities.motor_policies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.hbb20.CountryCodePicker;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Add_Details_Old_Vehicle;
import com.universalsompo.meta.metaapp.motor.activities.policy_fragment.Motor_Private_car;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class MotorPrivate extends AppCompatActivity {
    RecyclerView RcyRenewMotor;
    EditText edt_phone,edt_email,VehicleNo,edt_city,edt_name,edt_Dob,IDNumberEdit_motor,edt_phoneNumber,edt_GenderSpinner_motor,edt_IdType_motor;
    Button btn_next;
    LinearLayout GenderSpinner_motor,IDTypeSpinner_motor;
    String[] gender;
    String[] IDType;
    Date date,CurrentDate,SelectDate;
    int selectYearAdult,SelectMonthDOB,SelectDaysDOB;
    String strIDTypeName1,ckycNo,strGenderSpinner="",streditdob = "",strEditdobString="",str_age="",strIDTypeName="",strIDType="",strIDNumberEdit="",uniqueTransactionNumber="",strCityEdit="",strStateEdit="",strPinCodeEdit="",strEmailIDEditSelf="",strSelfAgeEditText="",manualKYCurl="",stredt_Dob ="",strGender="";
    private SimpleDateFormat dateFormatter;
    private MySharedPreference pref;
    private CheckBox chkCondition;
    CountryCodePicker ccp;
    TextView textViewNoPolicy;
    LinearLayout term_condition;
    CustomProgressDialog customDialog;
    String VehicleNumberRegex="^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$",PanExpression="[A-Z]{5}[0-9]{4}[A-Z]{1}",VoterIDExpression="^[A-Z]{3}[0-9]{7}$",AadharExpression="^[2-9][0-9]{11}$",PassportExpression="^[A-PR-WYa-pr-wy][1-9]\\d\\s?\\d{4}[1-9]$",DrivingExpression="^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$";
    RadioButton New_Policy_Radio,Renewal_Radio,TwoWheelerRadio,FourWheelerRadio,NewVehicleRadio,OldVehicleRadio;
    int VehicleAgeAdd,strYearOfManufacture,progressChanged,progressChanged1,a,b,c,selectYear,daysLeft,MonthsLeft;
    String  yearOfManufactureMonth,strSelectDateYear,strUID,uidStr,newVehicleStr="",strTpFromDateEdit,strTpEndDateEdit,AutoMobileValidityRadio,ELECTRICALACCESSORYODSumInsured,NONELECTRICALACCESSORYODSumInsured,strElectricalAccessoriesSumInsured,strNonelectricalAccessoriesSumInsured,PACOVERTOPASSENGERSSumInsured,UNNAMEDPACOVERTOPASSENGERSSumInsured, PACOVERTOPAIDDRIVERSumInsured,strCngKitSumInsured,AutoMobileRadio,AutomobileAssociationdiscountSumInsured,VoluntarydeductableSumInsured,strMinMax,AntitheftdevicediscountStatus,AutomobileAssociationdiscountStatus,TPPDDiscountStatus,HandicapDiscountStatus,VoluntarydeductableStatus,AdditionalNonElecticalODSumInsuredValue,AdditionalElectricalSumInsuredValue,AntitheftdeviceRateValue,AntitheftdeviceSumInsuredValue,AutomobileAssociationRateValue,AutomobileAssociationSumInsuredValue,HandicapRateValue,HandicapSumInsuredValue,TPPDDiscountRateValue,TPPDDiscountSumInsuredValue,VotaryRateValue,VotarySumInsuredValue,StrNCB,strDiscountEdit,ChangeAddons,DetarifficValueSumInsure="",DetarifficLoadingValueSumInsured="",BasicODRateSumInsured="",ELECTRICALCoverSumInsured="",NONELECTRICALSumInsured="",BasicTpRateSumInsured="",AdditionalFibertankODSumInsuredValue,AdditionalLegalLiabilityPaidSumInsured,AdditionalOtherODRateSumInsured,AdditionalOtherTpSumInsuredValue,AdditionalPaCoverToOwnerDriverSumInsuredValue,AdditionalPaidDriverSumInsuredValue,AdditionalPaToPassengersSumInsuredValue,AdditionalUnnamedPassengersSumInsuredValue,AdditionalCngKitODSumInsuredValue,AdditionalCngLpgTpSumInsuredValue,AdditionalBuiltinKitODSumInsuredValue,AdditionalBuiltinCngTPSumInsuredValue,DailyCashRateSumInsured,AccidentalSumInsuredValue,WrongFuelSumInsuredValue,CostOfConsumablesSumInsuredValue,dailyCashAllowanceMetroSumInsuredValue,dailyCashAllowanceNonMetroSumInsuredValue,EngineProtectorDieselSumInsuredValue,EngineProtectorPetrolSumInsuredValue,HydrostaticLockSumInsuredValue,KeyReplacementSumInsuredValue,NilDepreciationSumInsuredValue,ReturnToInvoiceSumInsuredValue,RoadSideAssistanceSumInsuredValue,SecureTowingSumInsuredValue,TyreRimsecureSumInsuredValue,drivingTrainProtectSumInsuredValue,ManufacturesellingSumInsuredValue,strVehicleImage="",strVehicleCubicCapicity="",selected_country_code,strNewFor="",DetariffDiscountStatus,DetariffLoadingStatus="",DetarifficValuePremium="",DetarifficValueRate="",DetarifficLodingValuePremium="",DetarifficLoadingValueRate="",changeseekBar="",strIdvValueTxtSelect="",DAILYCASHALLOWANCEStatus="",WRONGFUELCOVERStatus="",BasicODRateValue,BasicTpRateValue,AdditionalLegalLiabilityPaidRate="",CheckString="",strNomineeName="",strNomineeRelationEdit="",strPreviousClaimRadio="",StrAdditionalCoverPremiumTp="",StrAdditionalCoverPremiumOD="",SeekbarStatus="",addOnsCover="",addOnsAditional="",vehicleManufacturerType="",strModelType="",FuleType,rc_cubic_cap="",rc_fuel_desc="",VEHICLECLASSCODE="",strClaimBonus="",StrPreviousPolicyRadio="",strEndDateEdit="",ProductName="",ProductCode="",VehicleClassCode="",addOns="",NCB="",strVehicleManufacturerCode="",strRTOCode="",strVehicleModelCode="",strVehicleAge="",yearOfManufacture="",NetPremiumValue="",TotalValue="",PosPolicyNo1="",PosPolicyNo="",GST="",strIdvValueTxt="",strLessIDVText="",strHighIDVText="",today,strThirdDString,strName="",strVehicleNo="",str_edt_city="",str_edt_phone="",str_edt_email="",strPolicyRadio="",strVehicleTypeRadio="",strVehicleRadio="",strFor="",strTitleEdit="",strRTOName="",str_vehicleManufacturerNm="",strStateName="",strStateCode="",str_edt_registration_date="",str_manufacture_year="",strVehicleModel="",strPolicyNumberEdit="",strRegisteredAddressEdit="",strStateRegisterAddressEdit="",strStateRegisterCode,strCityRegisterCode="",strCityRegisterEdit="",strCityCommunicationCode="",strPinCodeEditText="",strCommunicationAddressEdit="",strCommunicationPinCodeEdit="",strVehicleNumber="",strVehicleChasisNumber="",strVehicleEngineNumber="",strStateCommunicationEdit="",strStateCommunicationCode="",strCityCommunicationEdit="",strPlanType="",strPlanYear="",strCoverageType="",strPACover="",strGPACover="",strDrivingLicence="",strCheckedTermCondition="",strCheckboxCommunication="",
            BUILTINCNGKIT_LPGKITTPStatus="",StrPrev_Policy_Type="",nextYear="",strCompanyName="",strODPlanFromDateEdit="",strODPlanEndDateEdit="",strTpPlanFromDateEdit="",strTpPlanEndDateEdit="",CubicCapacity="",tomorrowDate="",VehicleExShowroomPrice="",BasicODStatus="",BasicTP="",ELECTRICALACCESSORYODStatus="",FIBERTANKODStatus="",LEGALLIABILITYTOPAIDDRIVERStatus="",NONELECTRICALACCESSORYODStatus="",OtherODStatus="",OtherTpStatus="",PACOVERTOEMPLOYEESOFINSUREDStatus="",PACOVERTOOWNERDRIVERStatus="",PACOVERTOPAIDDRIVERStatus="",PACOVERTOPASSENGERSStatus="",UNNAMEDPACOVERTOPASSENGERSStatus="",ACCIDENTALHOSPITALIZATIONStatus="",COSTOFCONSUMABLESStatus="",DAILYCASHALLOWANCEMETROStatus="",DAILYCASHALLOWANCENONMETROStatus="",ENGINEPROTECTORDIESELStatus="",ENGINEPROTECTORPETROLStatus="",HYDROSTATICLOCKCOVERStatus="",KEYREPLACEMENTStatus="",NilDepreciationWaivercoverStatus="",RETURNTOINVOICEStatus="",RoadsideAssistanceStatus="",SECURETOWINGStatus="",TyreandRimsecureStatus="",AdditionalElectricalRateValue="",AdditionalFibertankODRateValue="",AdditionalLegalLiabilityDriverRateValue="",AdditionalBuiltinCngTPRateValue="",AdditionalNonElecticalODRateValue="",AdditionalOtherODRateValue="",AdditionalOtherTpRateValue="",AdditionalPaCoversToEmployessRateValue="",AdditionalPaCoverToOwnerDriverRateValue="",AdditionalPaidDriverRateValue="",AdditionalPaToPassengersRateValue="",AdditionalUnnamedPassengersRateValue="",AdditionalCngKitODRateValue="",AdditionalCngLpgTpRateValue="",AdditionalBuiltinKitODRateValue="",AccidentalRateValue="",CostOfConsumablesRateValue="",dailyCashAllowanceMetroRateValue="",dailyCashAllowanceNonMetroRateValue="",EngineProtectorDieselRateValue="", EngineProtectorPetrolRateValue="",HydrostaticLockRateValue="", KeyReplacementRateValue="", NilDepreciationRateValue="", ReturnToInvoiceRateValue="", RoadSideAssistanceRateValue="",SecureTowingRateValue="",TyreRimsecureRateValue="", drivingTrainProtectRateValue="",WrongFuelRateValue="", DailyCashRateValue="",ManufacturesellingRateValue="",CNGLPGKITODStatus="",CNGLPGKITTPStatus="",BUILTINCNGKIT_LPGKITODStatus="",MANUFACTURERSELLINGPRICEStatus="",DRIVINGTRAINPROTECTStatus="";
    ImageView backImage,calendarIconSelf_motor;
    CustomProgressDialog customprogress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor_private);
        getWindow().setStatusBarColor(ContextCompat.getColor(MotorPrivate.this, R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(MotorPrivate.this);
        customprogress = new CustomProgressDialog(MotorPrivate.this);
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
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        yearOfManufacture = getIntent().getStringExtra("yearOfManufacture");
        strVehicleAge = getIntent().getStringExtra("strVehicleAge");
        strVehicleManufacturerCode = getIntent().getStringExtra("strVehicleManufacturerCode");
        strRTOCode = getIntent().getStringExtra("strRTOCode");
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
        MonthsLeft =getIntent().getIntExtra("MonthsLeft", 0);
        VehicleAgeAdd =getIntent().getIntExtra("VehicleAgeAdd", 0);
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
        strVehicleCubicCapicity = getIntent().getStringExtra("strVehicleCubicCapicity");
        strVehicleImage = getIntent().getStringExtra("strVehicleImage");
        a =getIntent().getIntExtra("a", 0);
        b =getIntent().getIntExtra("b", 0);
        c =getIntent().getIntExtra("c", 0);
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
        strMinMax = getIntent().getStringExtra("strMinMax");
        strElectricalAccessoriesSumInsured = getIntent().getStringExtra("strElectricalAccessoriesSumInsured");
        strNonelectricalAccessoriesSumInsured = getIntent().getStringExtra("strNonelectricalAccessoriesSumInsured");
        PACOVERTOPASSENGERSSumInsured = getIntent().getStringExtra("PACOVERTOPASSENGERSSumInsured");
        UNNAMEDPACOVERTOPASSENGERSSumInsured = getIntent().getStringExtra("UNNAMEDPACOVERTOPASSENGERSSumInsured");
        PACOVERTOPAIDDRIVERSumInsured = getIntent().getStringExtra("PACOVERTOPAIDDRIVERSumInsured");
        strCngKitSumInsured = getIntent().getStringExtra("strCngKitSumInsured");
        AutoMobileRadio = getIntent().getStringExtra("AutoMobileRadio");
        AutomobileAssociationdiscountSumInsured = getIntent().getStringExtra("AutomobileAssociationdiscountSumInsured");
        VoluntarydeductableSumInsured = getIntent().getStringExtra("VoluntarydeductableSumInsured");
        ELECTRICALACCESSORYODSumInsured = getIntent().getStringExtra("ELECTRICALACCESSORYODSumInsured");
        NONELECTRICALACCESSORYODSumInsured = getIntent().getStringExtra("NONELECTRICALACCESSORYODSumInsured");
        AutoMobileValidityRadio = getIntent().getStringExtra("AutoMobileValidityRadio");
        strTpFromDateEdit = getIntent().getStringExtra("strTpFromDateEdit");
        strTpEndDateEdit = getIntent().getStringExtra("strTpEndDateEdit");
        newVehicleStr = getIntent().getStringExtra("strVehicleNo");
        strGenderSpinner = getIntent().getStringExtra("strGenderSpinner");
        streditdob = getIntent().getStringExtra("streditdob");
        strIDType = getIntent().getStringExtra("strIDType");
        strIDNumberEdit = getIntent().getStringExtra("strIDNumberEdit");
        strIDTypeName = getIntent().getStringExtra("strIDTypeName");
        yearOfManufactureMonth = getIntent().getStringExtra("yearOfManufactureMonth");
        strSelectDateYear = getIntent().getStringExtra("strSelectDateYear");
        strIDTypeName1 = getIntent().getStringExtra("strIDTypeName1");

        Log.d("djicdhjid", "onCreate: "+edt_GenderSpinner_motor);

        backImage=findViewById(R.id.backImage);
        edt_phone=findViewById(R.id.edt_phone);
        edt_email=findViewById(R.id.edt_email);
        btn_next=findViewById(R.id.btn_next);
        edt_city=findViewById(R.id.edt_city);
        edt_name=findViewById(R.id.edt_name);
        term_condition = findViewById(R.id.term_condition);
        chkCondition=findViewById(R.id.checkbox);
        New_Policy_Radio=findViewById(R.id.New_Policy_Radio);
        Renewal_Radio=findViewById(R.id.Renewal_Radio);
        TwoWheelerRadio=findViewById(R.id.TwoWheelerRadio);
        FourWheelerRadio=findViewById(R.id.FourWheelerRadio);
        NewVehicleRadio=findViewById(R.id.NewVehicleRadio);
        OldVehicleRadio=findViewById(R.id.OldVehicleRadio);
        VehicleNo=findViewById(R.id.VehicleNo);
        GenderSpinner_motor=findViewById(R.id.GenderSpinner_motor);
        calendarIconSelf_motor=findViewById(R.id.calendarIconSelf_motor);
        IDTypeSpinner_motor=findViewById(R.id.IDTypeSpinner_motor);
        ccp = findViewById(R.id.ccp);
        edt_Dob = findViewById(R.id.edt_Dob);
        edt_phoneNumber = findViewById(R.id.edt_phoneNumber);
        IDNumberEdit_motor = findViewById(R.id.IDNumberEdit_motor);
        edt_GenderSpinner_motor = findViewById(R.id.edt_GenderSpinner_motor);
        edt_IdType_motor = findViewById(R.id.edt_IdType_motor);
        selected_country_code = ccp.getSelectedCountryCodeWithPlus();
        str_edt_phone=pref.getMOBILE();
        str_edt_email=pref.getEmailId();
        strName=pref.getUserName();
        strUID=pref.getUID();

        edt_phoneNumber.setText(str_edt_phone);
        edt_email.setText(str_edt_email);
        edt_name.setText(strName);



        calendarIconSelf_motor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCalender();
            }
        });

        strPolicyRadio="New";

        if (strFor.equals("1")){
            if (strVehicleNo!=null){
                VehicleNo.setText(strVehicleNo);
                edt_Dob.setText(streditdob);
                IDNumberEdit_motor.setText(strIDNumberEdit);

            }
            edt_GenderSpinner_motor.setText(strGenderSpinner);
            edt_IdType_motor.setText(strIDTypeName);

            if (strVehicleRadio.equals("New")){
                NewVehicleRadio.setChecked(true);
                OldVehicleRadio.setChecked(false);
                strVehicleRadio="New";
            }else{
                NewVehicleRadio.setChecked(false);
                OldVehicleRadio.setChecked(true);
                strVehicleRadio="Old";
            }

            if (strVehicleTypeRadio.equals("Two Wheeler")){
                TwoWheelerRadio.setChecked(true);
                FourWheelerRadio.setChecked(false);
                strVehicleTypeRadio="Two Wheeler";
            }else{
                TwoWheelerRadio.setChecked(false);
                FourWheelerRadio.setChecked(true);
                strVehicleTypeRadio="Four Wheeler";
            }
        }
        else{
            strVehicleRadio="";
            strVehicleTypeRadio="";
            strVehicleNo="New";
            VehicleNo.setText(strVehicleNo);
            edt_Dob.setText(streditdob);
            IDNumberEdit_motor.setText(strIDNumberEdit);
            strGenderSpinner = "Select Gender";
            edt_GenderSpinner_motor.setText(strGenderSpinner);
            strIDTypeName = "Select ID Type";
            edt_IdType_motor.setText(strIDTypeName);

        }

//        strVehicleNo="MH04HQ8035";
//        VehicleNo.setText(strVehicleNo);


        GenderSpinner_motor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MotorPrivate.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select Gender");
                items1.add("Male");
                items1.add("Female");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strGenderSpinner=items1.get(options1);
                        edt_GenderSpinner_motor.setText(strGenderSpinner);
                    }
                });
                singlePicker.show();

            }
        });


        IDTypeSpinner_motor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MotorPrivate.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select ID Type");
                items1.add("PAN Card");
                items1.add("Voter ID");
//                items1.add("Aadhar Card");
                items1.add("Passport");
                items1.add("Driving Licence");
                items1.add("Existing CKYC Number");
                items1.add("Reference Number");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strIDTypeName=items1.get(options1);
                        edt_IdType_motor.setText(strIDTypeName);

                        if (strIDTypeName.equals("PAN Card")){
                            strIDType="PAN";
                            strIDNumberEdit="";
                            IDNumberEdit_motor.setText(strIDNumberEdit);
                        }else if (strIDTypeName.equals("Voter ID")){
                            strIDType="VOTER_ID";
                            strIDNumberEdit="";
                            IDNumberEdit_motor.setText(strIDNumberEdit);
                        }
//                else if (strIDTypeName.equals("Aadhar Card")){
//                    strIDType="AADHAAR";
//                    strIDNumberEdit="";
//                    Toast.makeText(getContext(), "Enter last 4 digits of your Aadhar Card", Toast.LENGTH_SHORT).show();
//                    IDNumberEdit.setText(strIDNumberEdit);
//                }
                        else if (strIDTypeName.equals("Passport")){
                            strIDType="PASSPORT";
                            strIDNumberEdit="";
                            IDNumberEdit_motor.setText(strIDNumberEdit);
                        }else if (strIDTypeName.equals("Driving Licence")){
                            strIDType="DRIVING_LICENCE";
                            strIDNumberEdit="";
                            IDNumberEdit_motor.setText(strIDNumberEdit);
                        }else if (strIDTypeName.equals("Existing CKYC Number")){
                            strIDType="CKYC_NO";
                            strIDNumberEdit="";
                            IDNumberEdit_motor.setText(strIDNumberEdit);
                        }else if (strIDTypeName.equals("Reference Number")){
                            strIDType="CKYC_NO";
                            strIDNumberEdit="";
//                            strIDNumberEdit= "ONLINE/261122/6GulCnHJe/hEDpZswYF5iw==";
                            IDNumberEdit_motor.setText(strIDNumberEdit);
                        }
                    }

                });
                singlePicker.show();
//                strIDTypeName= String.valueOf(IDType[i]);
//
            }
        });



        New_Policy_Radio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (New_Policy_Radio.isChecked()){
                    New_Policy_Radio.setChecked(true);
                    Renewal_Radio.setChecked(false);
                    strPolicyRadio="New";

                }
            }
        });
        Renewal_Radio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Renewal_Radio.isChecked()){
                    strPolicyRadio="Renew Policy";
                    Renewal_Radio.setChecked(true);
                    New_Policy_Radio.setChecked(false);
                    FourWheelerRadio.setChecked(false);
                    TwoWheelerRadio.setChecked(false);
                    OldVehicleRadio.setChecked(false);
                    NewVehicleRadio.setChecked(false);
                    BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(MotorPrivate.this,R.style.BottomSheetTheme);
                    View view= LayoutInflater.from(MotorPrivate.this).inflate(R.layout.bottom_navigation_motor_renewal,null);
                    bottomSheetDialog.setContentView(view);
                    ImageView bottomCancel=view.findViewById(R.id.bottomCancel);
                    RcyRenewMotor=view.findViewById(R.id.RcyRenewMotor);
                    textViewNoPolicy=view.findViewById(R.id.textViewNoPolicy);
//                    init();
                    customDialog.showProgressBar();
                    bottomCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            bottomSheetDialog.dismiss();
                            New_Policy_Radio.setChecked(true);
                        }
                    });

                    bottomSheetDialog.show();
                }
            }
        });

        TwoWheelerRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (TwoWheelerRadio.isChecked()){
                    TwoWheelerRadio.setChecked(true);
                    FourWheelerRadio.setChecked(false);
                    strVehicleTypeRadio="Two Wheeler";
                    strFor="0";
                    str_vehicleManufacturerNm="";
                    strVehicleModel="";
                    str_edt_registration_date="";
                    strStateName="";
                    strStateRegisterCode="";
                    strRTOName="";
                    strPolicyNumberEdit="";
                    strPlanType="";
                    strPlanYear="";
                    strCoverageType="";
                    strPACover="";
                    strGPACover="";
                    strDrivingLicence="";
                    strTitleEdit="Select Title";
                    strRegisteredAddressEdit="";
                    strPinCodeEditText="";
                    strStateRegisterAddressEdit="";
                    strCityRegisterEdit="";
                    strCommunicationAddressEdit="";
                    strCommunicationPinCodeEdit="";
                    strStateCommunicationEdit="";
                    strCityCommunicationEdit="";
                    strVehicleNumber="";
                    strVehicleChasisNumber="";
                    strVehicleEngineNumber="";
                    strCheckedTermCondition="";
                    strCheckboxCommunication="";
                    strCityRegisterCode="";
                    strCityCommunicationCode="";
                    TotalValue="";
                    NetPremiumValue="";
                    PosPolicyNo="";
                    GST="";
                    strIdvValueTxt="";
                    strLessIDVText="";
                    strHighIDVText="";
                    yearOfManufacture="";
                    yearOfManufactureMonth="";
                    strSelectDateYear="";
                    strVehicleAge="";
                    strVehicleManufacturerCode="";
                    strRTOCode="";
                    strVehicleModelCode="";
                    BasicODStatus="";
                    BasicTP="";
                    ELECTRICALACCESSORYODStatus="";
                    FIBERTANKODStatus="";
                    LEGALLIABILITYTOPAIDDRIVERStatus="";
                    NONELECTRICALACCESSORYODStatus="";
                    OtherODStatus="";
                    OtherTpStatus="";
                    PACOVERTOEMPLOYEESOFINSUREDStatus="";
                    PACOVERTOOWNERDRIVERStatus="";
                    PACOVERTOPAIDDRIVERStatus="";
                    PACOVERTOPASSENGERSStatus="";
                    UNNAMEDPACOVERTOPASSENGERSStatus="";
                    ACCIDENTALHOSPITALIZATIONStatus="";
                    COSTOFCONSUMABLESStatus="";
                    DAILYCASHALLOWANCEMETROStatus="";
                    DAILYCASHALLOWANCENONMETROStatus="";
                    ENGINEPROTECTORDIESELStatus="";
                    ENGINEPROTECTORPETROLStatus="";
                    HYDROSTATICLOCKCOVERStatus="";
                    KEYREPLACEMENTStatus="";
                    NilDepreciationWaivercoverStatus="";
                    RETURNTOINVOICEStatus="";
                    RoadsideAssistanceStatus="";
                    SECURETOWINGStatus="";
                    TyreandRimsecureStatus="";
                    VehicleExShowroomPrice="";
                    tomorrowDate="";
                    NCB="";
                    StrNCB="";
                    VehicleClassCode="";
                    ProductCode="";
                    ProductName="";
                    strClaimBonus="";
                    strEndDateEdit="";
                    StrPreviousPolicyRadio="";
                    VEHICLECLASSCODE="";
                    strVehicleEngineNumber="";
                    rc_fuel_desc="";
                    rc_cubic_cap="";
                    FuleType="";
                    strCompanyName="";
                    strODPlanFromDateEdit="";
                    strODPlanEndDateEdit="";
                    strTpPlanFromDateEdit="";
                    strTpPlanEndDateEdit="";
                    nextYear="";
                    addOns="";
                    StrPrev_Policy_Type="";
                    vehicleManufacturerType="";
                    strModelType="";
                    addOnsCover="";
                    addOnsAditional="";
                    SeekbarStatus="";
                    StrAdditionalCoverPremiumOD="";
                    StrAdditionalCoverPremiumTp="";
                    strPreviousClaimRadio="";
                    strNomineeName="";
                    strNomineeRelationEdit="";
                    AdditionalElectricalRateValue="";
                    AdditionalFibertankODRateValue="";
                    AdditionalLegalLiabilityDriverRateValue="";
                    AdditionalNonElecticalODRateValue="";
                    AdditionalOtherODRateValue="";
                    AdditionalOtherTpRateValue="";
                    AdditionalPaCoversToEmployessRateValue="";
                    AdditionalPaCoverToOwnerDriverRateValue="";
                    AdditionalPaidDriverRateValue="";
                    AdditionalPaToPassengersRateValue="";
                    AdditionalUnnamedPassengersRateValue="";
                    AdditionalCngKitODRateValue="";
                    AdditionalCngLpgTpRateValue="";
                    AdditionalBuiltinKitODRateValue="";
                    AdditionalBuiltinCngTPRateValue="";
                    AccidentalRateValue="";
                    CostOfConsumablesRateValue="";
                    dailyCashAllowanceMetroRateValue="";
                    dailyCashAllowanceNonMetroRateValue="";
                    EngineProtectorDieselRateValue="";
                    EngineProtectorPetrolRateValue="";
                    HydrostaticLockRateValue="";
                    KeyReplacementRateValue="";
                    NilDepreciationRateValue="";
                    ReturnToInvoiceRateValue="";
                    RoadSideAssistanceRateValue="";
                    SecureTowingRateValue="";
                    TyreRimsecureRateValue="";
                    drivingTrainProtectRateValue="";
                    ManufacturesellingRateValue="";
                    CheckString="0";
                    CNGLPGKITODStatus="";
                    CNGLPGKITTPStatus="";
                    BUILTINCNGKIT_LPGKITODStatus="";
                    MANUFACTURERSELLINGPRICEStatus="";
                    DRIVINGTRAINPROTECTStatus="";
                    AdditionalLegalLiabilityPaidRate="";
                    BUILTINCNGKIT_LPGKITTPStatus="";
                    progressChanged=0;
                    BasicODRateValue="";
                    BasicTpRateValue="";
                    strIdvValueTxtSelect="";
                    changeseekBar="";
                    strStateCode="";
                    DAILYCASHALLOWANCEStatus="";
                    WRONGFUELCOVERStatus="";
                    DailyCashRateValue="";
                    WrongFuelRateValue="";
                    DetarifficValuePremium="";
                    DetarifficValueRate="";
                    DetarifficLodingValuePremium="";
                    DetarifficLoadingValueRate="";
                    strVehicleCubicCapicity="";
                    strVehicleImage="";
                    DetarifficValueSumInsure="";
                    DetarifficLoadingValueSumInsured="";
                    BasicODRateSumInsured="";
                    ELECTRICALCoverSumInsured="";
                    NONELECTRICALSumInsured="";
                    BasicTpRateSumInsured="";
                    AdditionalFibertankODSumInsuredValue="";
                    AdditionalLegalLiabilityPaidSumInsured="";
                    AdditionalOtherODRateSumInsured="";
                    AdditionalOtherTpSumInsuredValue="";
                    AdditionalPaCoverToOwnerDriverSumInsuredValue="";
                    AdditionalPaidDriverSumInsuredValue="";
                    AdditionalPaToPassengersSumInsuredValue="";
                    AdditionalUnnamedPassengersSumInsuredValue="";
                    AdditionalCngKitODSumInsuredValue="";
                    AdditionalCngLpgTpSumInsuredValue="";
                    AdditionalBuiltinKitODSumInsuredValue="";
                    AdditionalBuiltinCngTPSumInsuredValue="";
                    DailyCashRateSumInsured="";
                    AccidentalSumInsuredValue="";
                    WrongFuelSumInsuredValue="";
                    CostOfConsumablesSumInsuredValue="";
                    dailyCashAllowanceMetroSumInsuredValue="";
                    dailyCashAllowanceNonMetroSumInsuredValue="";
                    EngineProtectorDieselSumInsuredValue="";
                    EngineProtectorPetrolSumInsuredValue="";
                    HydrostaticLockSumInsuredValue="";
                    KeyReplacementSumInsuredValue="";
                    NilDepreciationSumInsuredValue="";
                    ReturnToInvoiceSumInsuredValue="";
                    RoadSideAssistanceSumInsuredValue="";
                    SecureTowingSumInsuredValue="";
                    TyreRimsecureSumInsuredValue="";
                    drivingTrainProtectSumInsuredValue="";
                    ManufacturesellingSumInsuredValue="";
                    ChangeAddons="";
                    strDiscountEdit="";
                    strMinMax="";
                    strNewFor="0";
                    a=0;
                    b=0;
                    c=0;
                    daysLeft=0;
                    MonthsLeft=0;
                }
            }
        });

        FourWheelerRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (FourWheelerRadio.isChecked()){
                    FourWheelerRadio.setChecked(true);
                    TwoWheelerRadio.setChecked(false);
                    strVehicleTypeRadio="Four Wheeler";
                    strFor="0";
                    str_vehicleManufacturerNm="";
                    strVehicleModel="";
                    str_edt_registration_date="";
                    strStateName="";
                    strStateRegisterCode="";
                    strRTOName="";
                    strPolicyNumberEdit="";
                    strPlanType="";
                    strPlanYear="";
                    strCoverageType="";
                    strPACover="";
                    strGPACover="";
                    strDrivingLicence="";
                    strTitleEdit="Select Title";
                    strRegisteredAddressEdit="";
                    strPinCodeEditText="";
                    strStateRegisterAddressEdit="";
                    strCityRegisterEdit="";
                    strCommunicationAddressEdit="";
                    strCommunicationPinCodeEdit="";
                    strStateCommunicationEdit="";
                    strCityCommunicationEdit="";
                    strVehicleNumber="";
                    strVehicleChasisNumber="";
                    strVehicleEngineNumber="";
                    strCheckedTermCondition="";
                    strCheckboxCommunication="";
                    strCityRegisterCode="";
                    strCityCommunicationCode="";
                    TotalValue="";
                    NetPremiumValue="";
                    PosPolicyNo="";
                    GST="";
                    strIdvValueTxt="";
                    strLessIDVText="";
                    strHighIDVText="";
                    yearOfManufacture="";
                    yearOfManufactureMonth="";
                    strSelectDateYear="";
                    strVehicleAge="";
                    strVehicleManufacturerCode="";
                    strRTOCode="";
                    strVehicleModelCode="";
                    BasicODStatus="";
                    BasicTP="";
                    ELECTRICALACCESSORYODStatus="";
                    FIBERTANKODStatus="";
                    LEGALLIABILITYTOPAIDDRIVERStatus="";
                    NONELECTRICALACCESSORYODStatus="";
                    OtherODStatus="";
                    OtherTpStatus="";
                    PACOVERTOEMPLOYEESOFINSUREDStatus="";
                    PACOVERTOOWNERDRIVERStatus="";
                    PACOVERTOPAIDDRIVERStatus="";
                    PACOVERTOPASSENGERSStatus="";
                    UNNAMEDPACOVERTOPASSENGERSStatus="";
                    ACCIDENTALHOSPITALIZATIONStatus="";
                    COSTOFCONSUMABLESStatus="";
                    DAILYCASHALLOWANCEMETROStatus="";
                    DAILYCASHALLOWANCENONMETROStatus="";
                    ENGINEPROTECTORDIESELStatus="";
                    ENGINEPROTECTORPETROLStatus="";
                    HYDROSTATICLOCKCOVERStatus="";
                    KEYREPLACEMENTStatus="";
                    NilDepreciationWaivercoverStatus="";
                    RETURNTOINVOICEStatus="";
                    RoadsideAssistanceStatus="";
                    SECURETOWINGStatus="";
                    TyreandRimsecureStatus="";
                    VehicleExShowroomPrice="";
                    tomorrowDate="";
                    NCB="";
                    StrNCB="";
                    VehicleClassCode="";
                    ProductCode="";
                    ProductName="";
                    strClaimBonus="";
                    strEndDateEdit="";
                    StrPreviousPolicyRadio="";
                    VEHICLECLASSCODE="";
                    strVehicleEngineNumber="";
                    rc_fuel_desc="";
                    rc_cubic_cap="";
                    FuleType="";
                    strCompanyName="";
                    strODPlanFromDateEdit="";
                    strODPlanEndDateEdit="";
                    strTpPlanFromDateEdit="";
                    strTpPlanEndDateEdit="";
                    nextYear="";
                    addOns="";
                    StrPrev_Policy_Type="";
                    vehicleManufacturerType="";
                    strModelType="";
                    addOnsCover="";
                    addOnsAditional="";
                    SeekbarStatus="";
                    StrAdditionalCoverPremiumOD="";
                    StrAdditionalCoverPremiumTp="";
                    strPreviousClaimRadio="";
                    strNomineeName="";
                    strNomineeRelationEdit="";
                    AdditionalElectricalRateValue="";
                    AdditionalFibertankODRateValue="";
                    AdditionalLegalLiabilityDriverRateValue="";
                    AdditionalNonElecticalODRateValue="";
                    AdditionalOtherODRateValue="";
                    AdditionalOtherTpRateValue="";
                    AdditionalPaCoversToEmployessRateValue="";
                    AdditionalPaCoverToOwnerDriverRateValue="";
                    AdditionalPaidDriverRateValue="";
                    AdditionalPaToPassengersRateValue="";
                    AdditionalUnnamedPassengersRateValue="";
                    AdditionalCngKitODRateValue="";
                    AdditionalCngLpgTpRateValue="";
                    AdditionalBuiltinKitODRateValue="";
                    AdditionalBuiltinCngTPRateValue="";
                    AccidentalRateValue="";
                    CostOfConsumablesRateValue="";
                    dailyCashAllowanceMetroRateValue="";
                    dailyCashAllowanceNonMetroRateValue="";
                    EngineProtectorDieselRateValue="";
                    EngineProtectorPetrolRateValue="";
                    HydrostaticLockRateValue="";
                    KeyReplacementRateValue="";
                    NilDepreciationRateValue="";
                    ReturnToInvoiceRateValue="";
                    RoadSideAssistanceRateValue="";
                    SecureTowingRateValue="";
                    TyreRimsecureRateValue="";
                    drivingTrainProtectRateValue="";
                    ManufacturesellingRateValue="";
                    CheckString="0";
                    CNGLPGKITODStatus="";
                    CNGLPGKITTPStatus="";
                    BUILTINCNGKIT_LPGKITODStatus="";
                    MANUFACTURERSELLINGPRICEStatus="";
                    DRIVINGTRAINPROTECTStatus="";
                    AdditionalLegalLiabilityPaidRate="";
                    BUILTINCNGKIT_LPGKITTPStatus="";
                    progressChanged=0;
                    BasicODRateValue="";
                    BasicTpRateValue="";
                    strIdvValueTxtSelect="";
                    changeseekBar="";
                    strStateCode="";
                    DAILYCASHALLOWANCEStatus="";
                    WRONGFUELCOVERStatus="";
                    DailyCashRateValue="";
                    WrongFuelRateValue="";
                    DetarifficValuePremium="";
                    DetarifficValueRate="";
                    DetarifficLodingValuePremium="";
                    DetarifficLoadingValueRate="";
                    strVehicleCubicCapicity="";
                    strVehicleImage="";
                    DetarifficValueSumInsure="";
                    DetarifficLoadingValueSumInsured="";
                    BasicODRateSumInsured="";
                    ELECTRICALCoverSumInsured="";
                    NONELECTRICALSumInsured="";
                    BasicTpRateSumInsured="";
                    AdditionalFibertankODSumInsuredValue="";
                    AdditionalLegalLiabilityPaidSumInsured="";
                    AdditionalOtherODRateSumInsured="";
                    AdditionalOtherTpSumInsuredValue="";
                    AdditionalPaCoverToOwnerDriverSumInsuredValue="";
                    AdditionalPaidDriverSumInsuredValue="";
                    AdditionalPaToPassengersSumInsuredValue="";
                    AdditionalUnnamedPassengersSumInsuredValue="";
                    AdditionalCngKitODSumInsuredValue="";
                    AdditionalCngLpgTpSumInsuredValue="";
                    AdditionalBuiltinKitODSumInsuredValue="";
                    AdditionalBuiltinCngTPSumInsuredValue="";
                    DailyCashRateSumInsured="";
                    AccidentalSumInsuredValue="";
                    WrongFuelSumInsuredValue="";
                    CostOfConsumablesSumInsuredValue="";
                    dailyCashAllowanceMetroSumInsuredValue="";
                    dailyCashAllowanceNonMetroSumInsuredValue="";
                    EngineProtectorDieselSumInsuredValue="";
                    EngineProtectorPetrolSumInsuredValue="";
                    HydrostaticLockSumInsuredValue="";
                    KeyReplacementSumInsuredValue="";
                    NilDepreciationSumInsuredValue="";
                    ReturnToInvoiceSumInsuredValue="";
                    RoadSideAssistanceSumInsuredValue="";
                    SecureTowingSumInsuredValue="";
                    TyreRimsecureSumInsuredValue="";
                    drivingTrainProtectSumInsuredValue="";
                    ManufacturesellingSumInsuredValue="";
                    ChangeAddons="";
                    strDiscountEdit="";
                    strNewFor="0";
                    a=0;
                    b=0;
                    c=0;
                    daysLeft=0;
                    MonthsLeft=0;
                }
            }
        });

        NewVehicleRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NewVehicleRadio.isChecked()){
                    NewVehicleRadio.setChecked(true);
                    OldVehicleRadio.setChecked(false);
                    strVehicleRadio="New";
                    strFor="0";
                    strVehicleNo="New";
                    VehicleNo.setText(strVehicleNo);
                    str_vehicleManufacturerNm="";
                    strVehicleModel="";
                    str_edt_registration_date="";
                    strStateName="";
                    strStateRegisterCode="";
                    strRTOName="";
                    strPolicyNumberEdit="";
                    strPlanType="";
                    strPlanYear="";
                    strCoverageType="";
                    strPACover="";
                    strGPACover="";
                    strDrivingLicence="";
                    strTitleEdit="Select Title";
                    strRegisteredAddressEdit="";
                    strPinCodeEditText="";
                    strStateRegisterAddressEdit="";
                    strCityRegisterEdit="";
                    strCommunicationAddressEdit="";
                    strCommunicationPinCodeEdit="";
                    strStateCommunicationEdit="";
                    strCityCommunicationEdit="";
                    strVehicleNumber="";
                    strVehicleChasisNumber="";
                    strVehicleEngineNumber="";
                    strCheckedTermCondition="";
                    strCheckboxCommunication="";
                    strCityRegisterCode="";
                    strCityCommunicationCode="";
                    TotalValue="";
                    NetPremiumValue="";
                    PosPolicyNo="";
                    GST="";
                    strIdvValueTxt="";
                    strLessIDVText="";
                    strHighIDVText="";
                    yearOfManufacture="";
                    yearOfManufactureMonth="";
                    strSelectDateYear="";
                    strVehicleAge="";
                    strVehicleManufacturerCode="";
                    strRTOCode="";
                    strVehicleModelCode="";
                    BasicODStatus="";
                    BasicTP="";
                    ELECTRICALACCESSORYODStatus="";
                    FIBERTANKODStatus="";
                    LEGALLIABILITYTOPAIDDRIVERStatus="";
                    NONELECTRICALACCESSORYODStatus="";
                    OtherODStatus="";
                    OtherTpStatus="";
                    PACOVERTOEMPLOYEESOFINSUREDStatus="";
                    PACOVERTOOWNERDRIVERStatus="";
                    PACOVERTOPAIDDRIVERStatus="";
                    PACOVERTOPASSENGERSStatus="";
                    UNNAMEDPACOVERTOPASSENGERSStatus="";
                    ACCIDENTALHOSPITALIZATIONStatus="";
                    COSTOFCONSUMABLESStatus="";
                    DAILYCASHALLOWANCEMETROStatus="";
                    DAILYCASHALLOWANCENONMETROStatus="";
                    ENGINEPROTECTORDIESELStatus="";
                    ENGINEPROTECTORPETROLStatus="";
                    HYDROSTATICLOCKCOVERStatus="";
                    KEYREPLACEMENTStatus="";
                    NilDepreciationWaivercoverStatus="";
                    RETURNTOINVOICEStatus="";
                    RoadsideAssistanceStatus="";
                    SECURETOWINGStatus="";
                    TyreandRimsecureStatus="";
                    VehicleExShowroomPrice="";
                    tomorrowDate="";
                    NCB="";
                    StrNCB="";
                    VehicleClassCode="";
                    ProductCode="";
                    ProductName="";
                    strClaimBonus="";
                    strEndDateEdit="";
                    StrPreviousPolicyRadio="";
                    VEHICLECLASSCODE="";
                    strVehicleEngineNumber="";
                    rc_fuel_desc="";
                    rc_cubic_cap="";
                    FuleType="";
                    strCompanyName="";
                    strODPlanFromDateEdit="";
                    strODPlanEndDateEdit="";
                    strTpPlanFromDateEdit="";
                    strTpPlanEndDateEdit="";
                    nextYear="";
                    addOns="";
                    StrPrev_Policy_Type="";
                    vehicleManufacturerType="";
                    strModelType="";
                    addOnsCover="";
                    addOnsAditional="";
                    SeekbarStatus="";
                    StrAdditionalCoverPremiumOD="";
                    StrAdditionalCoverPremiumTp="";
                    strPreviousClaimRadio="";
                    strNomineeName="";
                    strNomineeRelationEdit="";
                    AdditionalElectricalRateValue="";
                    AdditionalFibertankODRateValue="";
                    AdditionalLegalLiabilityDriverRateValue="";
                    AdditionalNonElecticalODRateValue="";
                    AdditionalOtherODRateValue="";
                    AdditionalOtherTpRateValue="";
                    AdditionalPaCoversToEmployessRateValue="";
                    AdditionalPaCoverToOwnerDriverRateValue="";
                    AdditionalPaidDriverRateValue="";
                    AdditionalPaToPassengersRateValue="";
                    AdditionalUnnamedPassengersRateValue="";
                    AdditionalCngKitODRateValue="";
                    AdditionalCngLpgTpRateValue="";
                    AdditionalBuiltinKitODRateValue="";
                    AdditionalBuiltinCngTPRateValue="";
                    AccidentalRateValue="";
                    CostOfConsumablesRateValue="";
                    dailyCashAllowanceMetroRateValue="";
                    dailyCashAllowanceNonMetroRateValue="";
                    EngineProtectorDieselRateValue="";
                    EngineProtectorPetrolRateValue="";
                    HydrostaticLockRateValue="";
                    KeyReplacementRateValue="";
                    NilDepreciationRateValue="";
                    ReturnToInvoiceRateValue="";
                    RoadSideAssistanceRateValue="";
                    SecureTowingRateValue="";
                    TyreRimsecureRateValue="";
                    drivingTrainProtectRateValue="";
                    ManufacturesellingRateValue="";
                    CheckString="0";
                    CNGLPGKITODStatus="";
                    CNGLPGKITTPStatus="";
                    BUILTINCNGKIT_LPGKITODStatus="";
                    MANUFACTURERSELLINGPRICEStatus="";
                    DRIVINGTRAINPROTECTStatus="";
                    AdditionalLegalLiabilityPaidRate="";
                    BUILTINCNGKIT_LPGKITTPStatus="";
                    progressChanged=0;
                    BasicODRateValue="";
                    BasicTpRateValue="";
                    strIdvValueTxtSelect="";
                    changeseekBar="";
                    strStateCode="";
                    DAILYCASHALLOWANCEStatus="";
                    WRONGFUELCOVERStatus="";
                    DailyCashRateValue="";
                    WrongFuelRateValue="";
                    DetarifficValuePremium="";
                    DetarifficValueRate="";
                    DetarifficLodingValuePremium="";
                    DetarifficLoadingValueRate="";
                    strVehicleCubicCapicity="";
                    strVehicleImage="";
                    DetarifficValueSumInsure="";
                    DetarifficLoadingValueSumInsured="";
                    BasicODRateSumInsured="";
                    ELECTRICALCoverSumInsured="";
                    NONELECTRICALSumInsured="";
                    BasicTpRateSumInsured="";
                    AdditionalFibertankODSumInsuredValue="";
                    AdditionalLegalLiabilityPaidSumInsured="";
                    AdditionalOtherODRateSumInsured="";
                    AdditionalOtherTpSumInsuredValue="";
                    AdditionalPaCoverToOwnerDriverSumInsuredValue="";
                    AdditionalPaidDriverSumInsuredValue="";
                    AdditionalPaToPassengersSumInsuredValue="";
                    AdditionalUnnamedPassengersSumInsuredValue="";
                    AdditionalCngKitODSumInsuredValue="";
                    AdditionalCngLpgTpSumInsuredValue="";
                    AdditionalBuiltinKitODSumInsuredValue="";
                    AdditionalBuiltinCngTPSumInsuredValue="";
                    DailyCashRateSumInsured="";
                    AccidentalSumInsuredValue="";
                    WrongFuelSumInsuredValue="";
                    CostOfConsumablesSumInsuredValue="";
                    dailyCashAllowanceMetroSumInsuredValue="";
                    dailyCashAllowanceNonMetroSumInsuredValue="";
                    EngineProtectorDieselSumInsuredValue="";
                    EngineProtectorPetrolSumInsuredValue="";
                    HydrostaticLockSumInsuredValue="";
                    KeyReplacementSumInsuredValue="";
                    NilDepreciationSumInsuredValue="";
                    ReturnToInvoiceSumInsuredValue="";
                    RoadSideAssistanceSumInsuredValue="";
                    SecureTowingSumInsuredValue="";
                    TyreRimsecureSumInsuredValue="";
                    drivingTrainProtectSumInsuredValue="";
                    ManufacturesellingSumInsuredValue="";
                    ChangeAddons="";
                    selectYear=0;
                    strDiscountEdit="";
                    StrPrev_Policy_Type="";
                    strNewFor="0";
                    a=0;
                    b=0;
                    c=0;
                    daysLeft=0;
                    MonthsLeft=0;
                    VehicleAgeAdd=0;
                }
            }
        });

        OldVehicleRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (OldVehicleRadio.isChecked()){
                    OldVehicleRadio.setChecked(true);
                    NewVehicleRadio.setChecked(false);
                    strVehicleNo="";
                    clearMethod();
                }
            }
        });
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getFragmentManager().popBackStack();
                }else {
                    MotorPrivate.super.onBackPressed();
                }
            }
        });

        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                selected_country_code = ccp.getSelectedCountryCodeWithPlus();
                edt_phone.setText("");

            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                strVehicleNo="MH05CF5008";
//                strVehicleNo="MH04HQ8035";
//                VehicleNo.setText(strVehicleNo);
//                str_edt_phone=edt_phone.getText().toString();
                str_edt_phone=edt_phoneNumber.getText().toString();
                str_edt_email=edt_email.getText().toString();
                strName=edt_name.getText().toString();
                strVehicleNo=VehicleNo.getText().toString();
                strIDNumberEdit = IDNumberEdit_motor.getText().toString();
                stredt_Dob = edt_Dob.getText().toString();
                int count = 000;
                DecimalFormat decimalFormat = null;
                for(count = 0 ; count <=0; count++){
                    decimalFormat = new DecimalFormat("000");
                    Log.e("khjugfdx", decimalFormat.format(count));
                }
                uniqueTransactionNumber="ONLINE/261122/"+strUID;
//                uniqueTransactionNumber="AVO/261122/"+decimalFormat.format(count);
                Log.e("uniqueTransactionNumber",uniqueTransactionNumber);
                if (str_edt_email.equals("")){
                    Toast.makeText(MotorPrivate.this, "Enter Email id", Toast.LENGTH_SHORT).show();
                }else if (edt_email.getText().toString().length() == 0) {
                    edt_email.setFocusableInTouchMode(true);
                    edt_email.setCursorVisible(true);
                    edt_email.requestFocus();
                    Toast.makeText(MotorPrivate.this, "Email is mandatory.", Toast.LENGTH_SHORT).show();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(edt_email.getText().toString()).matches()) {
                    edt_email.setFocusableInTouchMode(true);
                    edt_email.setCursorVisible(true);
                    edt_email.requestFocus();
                    Toast.makeText(MotorPrivate.this, "Email address is not valid.", Toast.LENGTH_SHORT).show();
                }else if (strName.equals("")){
                    Toast.makeText(MotorPrivate.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }else if (strVehicleRadio.equals("")){
                    Toast.makeText(MotorPrivate.this, "Select One New Vehicle & Old Vehicle ", Toast.LENGTH_SHORT).show();
                }else if (strVehicleTypeRadio.equals("")){
                    Toast.makeText(MotorPrivate.this, "Select Vehicle Type ", Toast.LENGTH_SHORT).show();
                }
//                 else if (edt_phoneNumber.getText().toString().isEmpty()){
//                    Toast.makeText(MotorPrivate.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
//                }else if (edt_phoneNumber.getText().toString().length()<10){
//                    Toast.makeText(MotorPrivate.this, "Please Enter 10 digits Mobile Number", Toast.LENGTH_SHORT).show();
//                }
//                 else if (strGenderSpinner.equals("Select Gender")){
//                    Toast.makeText(MotorPrivate.this, "Select Gender", Toast.LENGTH_SHORT).show();
//                } else if (edt_Dob.getText().toString().isEmpty()){
//                    Toast.makeText(MotorPrivate.this, "Please Select DOB", Toast.LENGTH_SHORT).show();
//                }else if (strIDTypeName.equals("Select ID Type")){
//                    Toast.makeText(MotorPrivate.this, "Select ID Type", Toast.LENGTH_SHORT).show();
//                }else if (strIDNumberEdit.equals("")){
//                    Toast.makeText(MotorPrivate.this, "Enter ID Number", Toast.LENGTH_SHORT).show();
//                }else if (strIDTypeName.equals("PAN Card")){
//                    if (!strIDNumberEdit.matches(PanExpression)){
//                        Toast.makeText(MotorPrivate.this, "Enter Valid PAN Card Number", Toast.LENGTH_SHORT).show();
//                    }else{
//                        CKYURL();
//                        customprogress.showProgressBar();
//                    }
//                }else if (strIDTypeName.equals("Voter ID")){
//                    if (!strIDNumberEdit.matches(VoterIDExpression)){
//                        Toast.makeText(MotorPrivate.this, "Enter Valid Voter ID Number", Toast.LENGTH_SHORT).show();
//                    }else{
//                        CKYURL();
//                        customprogress.showProgressBar();
//                    }
//                }
////                 else if (strIDTypeName.equals("Aadhar Card")){
////                    if (!strIDNumberEdit.matches(AadharExpression)){
////                        Toast.makeText(MotorPrivate.this, "Enter Valid Aadhar Number", Toast.LENGTH_SHORT).show();
////                    }else{
////                        CKYURL();
////                        customprogress.showProgressBar();
////                    }
////                }
//                 else if (strIDTypeName.equals("Passport")){
//                    if (!strIDNumberEdit.matches(PassportExpression)){
//                        Toast.makeText(MotorPrivate.this, "Enter Valid Passport Number", Toast.LENGTH_SHORT).show();
//                    }else{
//                        CKYURL();
//                        customprogress.showProgressBar();
//                    }
//                }else if (strIDTypeName.equals("Driving Licence")){
//                    if (!strIDNumberEdit.matches(DrivingExpression)){
//                        Toast.makeText(MotorPrivate.this, "Enter Valid Driving Licence Number", Toast.LENGTH_SHORT).show();
//                    }else{
////                        nextMethod();
//                        CKYURL();
//                        customprogress.showProgressBar();
//                    }
//                }else if (strIDTypeName.equals("Reference Number")){
//
//                     if (!strIDNumberEdit.contains("/")){
//                         Toast.makeText(MotorPrivate.this, "Reference Number should be (xxxx/xxxx/xxxx)", Toast.LENGTH_SHORT).show();
//                     }else if (!chkCondition.isChecked()) {
//                         Toast.makeText(MotorPrivate.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
//                     }else {
//                         ResultStatusURL();
////                        customprogress.showProgressBar();
//                     }
//                 }
                else if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
//                    || strVehicleNo.equals("New")
//                    if (strVehicleNo.equals("") ){
//                        Toast.makeText(MotorPrivate.this, "Enter Vehicle Number ", Toast.LENGTH_SHORT).show();
//                    }else
                    if (!(strVehicleNo.equals("")||strVehicleNo.equals("New"))){
                        if (strVehicleNo.length()<9){
                            Toast.makeText(MotorPrivate.this, "Enter Valid Vehicle No. ", Toast.LENGTH_SHORT).show();
                        }else if (newVehicleStr==null) {
                            if (!chkCondition.isChecked()){
                                Toast.makeText(MotorPrivate.this, "Please agree the conditions", Toast.LENGTH_SHORT).show();
                            }else {
                                elseMethod();

                            }
                        }else if (!strVehicleNo.equals(newVehicleStr)){
                            clearMethod();
                            if (!chkCondition.isChecked()){
                                Toast.makeText(MotorPrivate.this, "Please agree the conditions", Toast.LENGTH_SHORT).show();
                            }else {
                                elseMethod();

                            }
                        }else if (!chkCondition.isChecked()){
                            Toast.makeText(MotorPrivate.this, "Please agree the conditions", Toast.LENGTH_SHORT).show();
                        }else {
                            elseMethod();

                        }
                    }
//                    else if (strVehicleNo.length()<9){
//                        Toast.makeText(MotorPrivate.this, "Enter Valid Vehicle No. ", Toast.LENGTH_SHORT).show();
//                    }
                    else if (newVehicleStr==null) {
                        clearMethod();
                        if (!chkCondition.isChecked()){
                            Toast.makeText(MotorPrivate.this, "Please agree the conditions", Toast.LENGTH_SHORT).show();
                        }else {
                            elseMethod();

                        }
                    }else if (!strVehicleNo.equals(newVehicleStr)){
                        clearMethod();
                        if (!chkCondition.isChecked()){
                            Toast.makeText(MotorPrivate.this, "Please agree the conditions", Toast.LENGTH_SHORT).show();
                        }else {
                            elseMethod();

                        }
                    }else if (!chkCondition.isChecked()){
                        Toast.makeText(MotorPrivate.this, "Please agree the conditions", Toast.LENGTH_SHORT).show();
                    }else {
                        elseMethod();

                    }
                }else if (!chkCondition.isChecked()){
                    Toast.makeText(MotorPrivate.this, "Please agree the conditions", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent=new Intent(MotorPrivate.this, Private_car_vehicle_details.class);
                    intent.putExtra("strVehicleNo",strVehicleNo);
                    intent.putExtra("strName",strName);
                    intent.putExtra("str_edt_city",str_edt_city);
                    intent.putExtra("streditdob",streditdob);
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
                    intent.putExtra("strVehicleNumber",strVehicleNumber);
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
                    intent.putExtra("StrNCB",StrNCB);
                    intent.putExtra("VehicleClassCode",VehicleClassCode);
                    intent.putExtra("ProductCode",ProductCode);
                    intent.putExtra("ProductName",ProductName);
                    intent.putExtra("strClaimBonus",strClaimBonus);
                    intent.putExtra("strEndDateEdit",strEndDateEdit);
                    intent.putExtra("StrPreviousPolicyRadio",StrPreviousPolicyRadio);
                    intent.putExtra("VEHICLECLASSCODE",VEHICLECLASSCODE);
                    intent.putExtra("strVehicleEngineNumber",strVehicleEngineNumber);
                    intent.putExtra("rc_fuel_desc",rc_fuel_desc);
                    intent.putExtra("rc_cubic_cap",rc_cubic_cap);
                    intent.putExtra("FuleType",FuleType);
                    intent.putExtra("strCompanyName",strCompanyName);
                    intent.putExtra("strVehicleCubicCapicity",strVehicleCubicCapicity);
                    intent.putExtra("strVehicleImage",strVehicleImage);
//                  intent.putExtra("strODPlanFromDateEdit",strODPlanFromDateEdit);
//                  intent.putExtra("strODPlanEndDateEdit",strODPlanEndDateEdit);
//                  intent.putExtra("strTpPlanFromDateEdit",strTpPlanFromDateEdit);
//                  intent.putExtra("strTpPlanEndDateEdit",strTpPlanEndDateEdit);
                    intent.putExtra("nextYear",nextYear);
                    intent.putExtra("addOns",addOns);
                    intent.putExtra("selectYear",selectYear);
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
                    intent.putExtra("CheckString",CheckString);
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
                    intent.putExtra("strStateCode",strStateCode);
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
                    intent.putExtra("a",a);
                    intent.putExtra("b",b);
                    intent.putExtra("c",c);
                    intent.putExtra("strFor",strFor);
                    intent.putExtra("strDiscountEdit",strDiscountEdit);
                    intent.putExtra("strNewFor",strNewFor);
                    intent.putExtra("ChangeAddons","0");
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
                    intent.putExtra("strMinMax",strMinMax);
                    intent.putExtra("strElectricalAccessoriesSumInsured",strElectricalAccessoriesSumInsured);
                    intent.putExtra("strNonelectricalAccessoriesSumInsured",strNonelectricalAccessoriesSumInsured);
                    intent.putExtra("PACOVERTOPASSENGERSSumInsured",PACOVERTOPASSENGERSSumInsured);
                    intent.putExtra("UNNAMEDPACOVERTOPASSENGERSSumInsured",UNNAMEDPACOVERTOPASSENGERSSumInsured);
                    intent.putExtra("PACOVERTOPAIDDRIVERSumInsured",PACOVERTOPAIDDRIVERSumInsured);
                    intent.putExtra("strCngKitSumInsured",strCngKitSumInsured);
                    intent.putExtra("AutoMobileRadio",AutoMobileRadio);
                    intent.putExtra("AutomobileAssociationdiscountSumInsured",AutomobileAssociationdiscountSumInsured);
                    intent.putExtra("VoluntarydeductableSumInsured",VoluntarydeductableSumInsured);
                    intent.putExtra("ELECTRICALACCESSORYODSumInsured",ELECTRICALACCESSORYODSumInsured);
                    intent.putExtra("NONELECTRICALACCESSORYODSumInsured",NONELECTRICALACCESSORYODSumInsured);
                    intent.putExtra("AutoMobileValidityRadio",AutoMobileValidityRadio);
                    intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
                    intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
                    intent.putExtra("ckycNo",ckycNo);
                    intent.putExtra("strIDTypeName1",strIDTypeName1);
                    intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
                    startActivity(intent);
                    finish();
                }
            }

        });

        term_condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(MotorPrivate.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.dialog_term_condition);
                ImageView crossImg;
                crossImg = alert_dialog.findViewById(R.id.crossImg);
                alert_dialog.show();
                crossImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert_dialog.dismiss();
                    }
                });
            }
        });


    }
    private void clearMethod() {
        strVehicleRadio="Old";
        strFor="0";
        VehicleNo.setText(strVehicleNo);
        str_vehicleManufacturerNm="";
        strVehicleModel="";
        str_edt_registration_date="";
        strStateName="";
        strStateRegisterCode="";
        strRTOName="";
        strPolicyNumberEdit="";
        strPlanType="";
        strPlanYear="";
        strCoverageType="";
        strPACover="";
        strGPACover="";
        strDrivingLicence="";
        strTitleEdit="Select Title";
        strRegisteredAddressEdit="";
        strPinCodeEditText="";
        strStateRegisterAddressEdit="";
        strCityRegisterEdit="";
        strCommunicationAddressEdit="";
        strCommunicationPinCodeEdit="";
        strStateCommunicationEdit="";
        strCityCommunicationEdit="";
        strVehicleNumber="";
        strVehicleChasisNumber="";
        strVehicleEngineNumber="";
        strCheckedTermCondition="";
        strCheckboxCommunication="";
        strCityRegisterCode="";
        strCityCommunicationCode="";
        TotalValue="";
        NetPremiumValue="";
        PosPolicyNo="";
        GST="";
        strIdvValueTxt="";
        strLessIDVText="";
        strHighIDVText="";
        yearOfManufacture="";
        yearOfManufactureMonth="";
        strSelectDateYear="";
        strVehicleAge="";
        strVehicleManufacturerCode="";
        strRTOCode="";
        strVehicleModelCode="";
        BasicODStatus="";
        BasicTP="";
        ELECTRICALACCESSORYODStatus="";
        FIBERTANKODStatus="";
        LEGALLIABILITYTOPAIDDRIVERStatus="";
        NONELECTRICALACCESSORYODStatus="";
        OtherODStatus="";
        OtherTpStatus="";
        PACOVERTOEMPLOYEESOFINSUREDStatus="";
        PACOVERTOOWNERDRIVERStatus="";
        PACOVERTOPAIDDRIVERStatus="";
        PACOVERTOPASSENGERSStatus="";
        UNNAMEDPACOVERTOPASSENGERSStatus="";
        ACCIDENTALHOSPITALIZATIONStatus="";
        COSTOFCONSUMABLESStatus="";
        DAILYCASHALLOWANCEMETROStatus="";
        DAILYCASHALLOWANCENONMETROStatus="";
        ENGINEPROTECTORDIESELStatus="";
        ENGINEPROTECTORPETROLStatus="";
        HYDROSTATICLOCKCOVERStatus="";
        KEYREPLACEMENTStatus="";
        NilDepreciationWaivercoverStatus="";
        RETURNTOINVOICEStatus="";
        RoadsideAssistanceStatus="";
        SECURETOWINGStatus="";
        TyreandRimsecureStatus="";
        VehicleExShowroomPrice="";
        tomorrowDate="";
        NCB="";
        StrNCB="";
        VehicleClassCode="";
        ProductCode="";
        ProductName="";
        strClaimBonus="";
        strEndDateEdit="";
        StrPreviousPolicyRadio="";
        VEHICLECLASSCODE="";
        strVehicleEngineNumber="";
        rc_fuel_desc="";
        rc_cubic_cap="";
        FuleType="";
        strCompanyName="";
        strODPlanFromDateEdit="";
        strODPlanEndDateEdit="";
        strTpPlanFromDateEdit="";
        strTpPlanEndDateEdit="";
        nextYear="";
        addOns="";
        StrPrev_Policy_Type="";
        vehicleManufacturerType="";
        strModelType="";
        addOnsCover="";
        addOnsAditional="";
        SeekbarStatus="";
        StrAdditionalCoverPremiumOD="";
        StrAdditionalCoverPremiumTp="";
        strPreviousClaimRadio="";
        strNomineeName="";
        strNomineeRelationEdit="";
        AdditionalElectricalRateValue="";
        AdditionalFibertankODRateValue="";
        AdditionalLegalLiabilityDriverRateValue="";
        AdditionalNonElecticalODRateValue="";
        AdditionalOtherODRateValue="";
        AdditionalOtherTpRateValue="";
        AdditionalPaCoversToEmployessRateValue="";
        AdditionalPaCoverToOwnerDriverRateValue="";
        AdditionalPaidDriverRateValue="";
        AdditionalPaToPassengersRateValue="";
        AdditionalUnnamedPassengersRateValue="";
        AdditionalCngKitODRateValue="";
        AdditionalCngLpgTpRateValue="";
        AdditionalBuiltinKitODRateValue="";
        AdditionalBuiltinCngTPRateValue="";
        AccidentalRateValue="";
        CostOfConsumablesRateValue="";
        dailyCashAllowanceMetroRateValue="";
        dailyCashAllowanceNonMetroRateValue="";
        EngineProtectorDieselRateValue="";
        EngineProtectorPetrolRateValue="";
        HydrostaticLockRateValue="";
        KeyReplacementRateValue="";
        NilDepreciationRateValue="";
        ReturnToInvoiceRateValue="";
        RoadSideAssistanceRateValue="";
        SecureTowingRateValue="";
        TyreRimsecureRateValue="";
        drivingTrainProtectRateValue="";
        ManufacturesellingRateValue="";
        CheckString="0";
        CNGLPGKITODStatus="";
        CNGLPGKITTPStatus="";
        BUILTINCNGKIT_LPGKITODStatus="";
        MANUFACTURERSELLINGPRICEStatus="";
        DRIVINGTRAINPROTECTStatus="";
        AdditionalLegalLiabilityPaidRate="";
        BUILTINCNGKIT_LPGKITTPStatus="";
        progressChanged=0;
        BasicODRateValue="";
        BasicTpRateValue="";
        strIdvValueTxtSelect="";
        changeseekBar="";
        strStateCode="";
        DAILYCASHALLOWANCEStatus="";
        WRONGFUELCOVERStatus="";
        DailyCashRateValue="";
        WrongFuelRateValue="";
        DetarifficValuePremium="";
        DetarifficValueRate="";
        DetarifficLodingValuePremium="";
        DetarifficLoadingValueRate="";
        strVehicleCubicCapicity="";
        strVehicleImage="";
        DetarifficValueSumInsure="";
        DetarifficLoadingValueSumInsured="";
        BasicODRateSumInsured="";
        ELECTRICALCoverSumInsured="";
        NONELECTRICALSumInsured="";
        BasicTpRateSumInsured="";
        AdditionalFibertankODSumInsuredValue="";
        AdditionalLegalLiabilityPaidSumInsured="";
        AdditionalOtherODRateSumInsured="";
        AdditionalOtherTpSumInsuredValue="";
        AdditionalPaCoverToOwnerDriverSumInsuredValue="";
        AdditionalPaidDriverSumInsuredValue="";
        AdditionalPaToPassengersSumInsuredValue="";
        AdditionalUnnamedPassengersSumInsuredValue="";
        AdditionalCngKitODSumInsuredValue="";
        AdditionalCngLpgTpSumInsuredValue="";
        AdditionalBuiltinKitODSumInsuredValue="";
        AdditionalBuiltinCngTPSumInsuredValue="";
        DailyCashRateSumInsured="";
        AccidentalSumInsuredValue="";
        WrongFuelSumInsuredValue="";
        CostOfConsumablesSumInsuredValue="";
        dailyCashAllowanceMetroSumInsuredValue="";
        dailyCashAllowanceNonMetroSumInsuredValue="";
        EngineProtectorDieselSumInsuredValue="";
        EngineProtectorPetrolSumInsuredValue="";
        HydrostaticLockSumInsuredValue="";
        KeyReplacementSumInsuredValue="";
        NilDepreciationSumInsuredValue="";
        ReturnToInvoiceSumInsuredValue="";
        RoadSideAssistanceSumInsuredValue="";
        SecureTowingSumInsuredValue="";
        TyreRimsecureSumInsuredValue="";
        drivingTrainProtectSumInsuredValue="";
        ManufacturesellingSumInsuredValue="";
        ChangeAddons="";
        strDiscountEdit="";
        AutoMobileValidityRadio="";
        strTpEndDateEdit="";
        strTpFromDateEdit="";
        strRegisteredAddressEdit="";
        strPinCodeEditText="";
        strStateRegisterAddressEdit="";
        strCityRegisterEdit="";
        strCommunicationAddressEdit="";
        strCommunicationPinCodeEdit="";
        strStateCommunicationEdit="";
        strCityCommunicationEdit="";
        strCheckboxCommunication="false";
        strCheckedTermCondition="false";
        strNewFor="0";
        a=0;
        b=0;
        c=0;
        daysLeft=0;
        MonthsLeft=0;
    }
    private void elseMethod() {
        if (!(strVehicleNo.equals("")||strVehicleNo.equals("New"))){
            customprogress.showProgressBar();
            variantAdrilla();
        }else{
            nextMethod();
        }

    }
    private void variantAdrilla() {
        JSONObject parameters = new JSONObject();
        try {
            parameters.put("rc_no", strVehicleNo);
            parameters.put("consent", "Y");
            parameters.put("rc_source", "45");
        } catch (Exception e) {
        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "https://uat.aadrila.com/api/v1/variant-id", parameters,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("onResponse", response.toString());
                customprogress.hideProgressBar();
                try {
                    JSONObject jsonObject=response.getJSONObject("data");
                    JSONArray jsonArray=jsonObject.getJSONArray("pass_id_data");
                    for (int i=0; i <jsonArray.length();i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                        uidStr=jsonObject1.getString("uid");
                    }
                    if (strVehicleTypeRadio.equals("Four Wheeler")){
                        if(uidStr.equals("4W")){
                            nextMethod();

                        }else{
                            Toast.makeText(MotorPrivate.this, "It's not for Four Wheeler Please Enter Four Wheeler number  ", Toast.LENGTH_SHORT).show();
                        }
                    }else if (strVehicleTypeRadio.equals("Two Wheeler")){
                        if(uidStr.equals("2W")){
                            nextMethod();
                        }else{
                            Toast.makeText(MotorPrivate.this, "It's not for Two Wheeler Please Enter Two Wheeler number  ", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    customprogress.hideProgressBar();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("onErrorResponse", error.toString());
                customprogress.hideProgressBar();
                Toast.makeText(MotorPrivate.this, "No Data Found For This Vehicle Number...Please Enter Valid Vehicle Number ", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("Authorization", "Bearer " + "af90858f6b3b8a3684fd80ad6b7c899e");
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
//        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }
    private void nextMethod() {
        Intent intent=new Intent(MotorPrivate.this, Private_car_vehicle_details.class);
        intent.putExtra("strVehicleNo",strVehicleNo);
        intent.putExtra("strName",strName);
        intent.putExtra("strGenderSpinner",strGenderSpinner);
        intent.putExtra("streditdob",streditdob);
        intent.putExtra("strIDType",strIDType);
        intent.putExtra("strIDNumberEdit",strIDNumberEdit);
        intent.putExtra("strIDTypeName",strIDTypeName);
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
        intent.putExtra("strVehicleNumber",strVehicleNumber);
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
        intent.putExtra("StrNCB",StrNCB);
        intent.putExtra("VehicleClassCode",VehicleClassCode);
        intent.putExtra("ProductCode",ProductCode);
        intent.putExtra("ProductName",ProductName);
        intent.putExtra("strClaimBonus",strClaimBonus);
        intent.putExtra("strEndDateEdit",strEndDateEdit);
        intent.putExtra("StrPreviousPolicyRadio",StrPreviousPolicyRadio);
        intent.putExtra("VEHICLECLASSCODE",VEHICLECLASSCODE);
        intent.putExtra("strVehicleEngineNumber",strVehicleEngineNumber);
        intent.putExtra("rc_fuel_desc",rc_fuel_desc);
        intent.putExtra("rc_cubic_cap",rc_cubic_cap);
        intent.putExtra("FuleType",FuleType);
        intent.putExtra("strCompanyName",strCompanyName);
        intent.putExtra("strVehicleCubicCapicity",strVehicleCubicCapicity);
        intent.putExtra("strVehicleImage",strVehicleImage);
//            intent.putExtra("strODPlanFromDateEdit",strODPlanFromDateEdit);
//            intent.putExtra("strODPlanEndDateEdit",strODPlanEndDateEdit);
//            intent.putExtra("strTpPlanFromDateEdit",strTpPlanFromDateEdit);
//            intent.putExtra("strTpPlanEndDateEdit",strTpPlanEndDateEdit);
        intent.putExtra("nextYear",nextYear);
        intent.putExtra("addOns",addOns);
        intent.putExtra("selectYear",selectYear);
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
        intent.putExtra("CheckString",CheckString);
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
        intent.putExtra("strStateCode",strStateCode);
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
        intent.putExtra("a",a);
        intent.putExtra("b",b);
        intent.putExtra("c",c);
        intent.putExtra("MonthsLeft",MonthsLeft);
        intent.putExtra("strFor",strFor);
        intent.putExtra("strDiscountEdit",strDiscountEdit);
        intent.putExtra("strNewFor",strNewFor);
        intent.putExtra("ChangeAddons","0");
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
        intent.putExtra("strMinMax",strMinMax);
        intent.putExtra("strElectricalAccessoriesSumInsured",strElectricalAccessoriesSumInsured);
        intent.putExtra("strNonelectricalAccessoriesSumInsured",strNonelectricalAccessoriesSumInsured);
        intent.putExtra("PACOVERTOPASSENGERSSumInsured",PACOVERTOPASSENGERSSumInsured);
        intent.putExtra("UNNAMEDPACOVERTOPASSENGERSSumInsured",UNNAMEDPACOVERTOPASSENGERSSumInsured);
        intent.putExtra("PACOVERTOPAIDDRIVERSumInsured",PACOVERTOPAIDDRIVERSumInsured);
        intent.putExtra("strCngKitSumInsured",strCngKitSumInsured);
        intent.putExtra("AutoMobileRadio",AutoMobileRadio);
        intent.putExtra("AutomobileAssociationdiscountSumInsured",AutomobileAssociationdiscountSumInsured);
        intent.putExtra("VoluntarydeductableSumInsured",VoluntarydeductableSumInsured);
        intent.putExtra("ELECTRICALACCESSORYODSumInsured",ELECTRICALACCESSORYODSumInsured);
        intent.putExtra("NONELECTRICALACCESSORYODSumInsured",NONELECTRICALACCESSORYODSumInsured);
        intent.putExtra("AutoMobileValidityRadio",AutoMobileValidityRadio);
        intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
        intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
        intent.putExtra("VehicleAgeAdd",VehicleAgeAdd);
        intent.putExtra("ckycNo",ckycNo);
        intent.putExtra("strIDTypeName1",strIDTypeName1);
        intent.putExtra("daysLeft",daysLeft);
        intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
        startActivity(intent);
        finish();
    }
    private void CKYURL() {
        JSONObject object = new JSONObject();
        try {
            object.put("source", "AVO");
            object.put("customerType","I");
            object.put("uniqueTransactionNumber",uniqueTransactionNumber);
            object.put("idNo",strIDNumberEdit);
            object.put("idType",strIDType);
            object.put("dob",streditdob);
            object.put("mobileNo","");
            object.put("pincode","");
            object.put("cKYCNo","");
            object.put("extraField1","");
            object.put("extraField2","");
            object.put("extraField3","");
            object.put("extraField4","");
            object.put("extraField5","");
        } catch (Exception e) {
        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, UrlHealthConstants.CKYC_URL, object,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("onResponse", response.toString());
                customprogress.hideProgressBar();
                if (response.optString("status").equals("success")) {
                    try {
                        JSONObject objectResult=response.getJSONObject("result");
                        uniqueTransactionNumber =response.optString("uniqueTransactionNumber");
                        ckycNo = objectResult.getString("ckycNo");
                        String firstName = objectResult.getString("firstName");
                        String middleName = objectResult.getString("middleName");
                        String lastName = objectResult.getString("lastName");
                        streditdob = objectResult.getString("dob");
                        String address1 = objectResult.getString("address1");
                        String address2 = objectResult.getString("address2");
                        String address3 = objectResult.getString("address3");
                        strCityEdit = objectResult.getString("city");
                        String district = objectResult.getString("district");
                        strStateEdit = objectResult.getString("state");
                        String country= objectResult.getString("country");
                        strPinCodeEdit = objectResult.getString("pincode");
                        String corresAddress1 = objectResult.getString("corresAddress1");
                        String corresAddress2 = objectResult.getString("corresAddress2");
                        String corresAddress3 = objectResult.getString("corresAddress3");
                        String corresCity = objectResult.getString("corresCity");
                        String corresDist = objectResult.getString("corresDist");
                        String corresState = objectResult.getString("corresState");
                        String corresCountry = objectResult.getString("corresCountry");
                        String corresPin = objectResult.getString("corresPin");
                        String aadhaar = objectResult.getString("aadhaar");
                        String pan = objectResult.getString("pan");
                        strEmailIDEditSelf = objectResult.getString("email");
                        String mobileNumber = objectResult.getString("mobileNumber");
                        String permAndCorresAddSame = objectResult.getString("permAndCorresAddSame");
                        //Format change dd-mm-yyy to dd/mm/yyyy

//                        str_edt_name=firstName+" "+middleName+" "+lastName;
                        nextMethod();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    try {
                        JSONObject error1=response.getJSONObject("error");
                        String message = error1.getString("message");
                        if (message.equals("source is not configured in system so please connect with system administrator")){
                            Toast.makeText(MotorPrivate.this, message, Toast.LENGTH_SHORT).show();
                        }else{
                            JSONObject object1=response.getJSONObject("result");
                            String manualKYCurl_intent = object1.getString("manualKYCurl");
                            Log.e("manualKYCurl1",manualKYCurl_intent);
                            EmailConsumeAPI();
                            SMSConsumeAPI();
                            final Dialog alert_dialog1 = new Dialog(MotorPrivate.this);
                            alert_dialog1.setCanceledOnTouchOutside(false);
                            alert_dialog1.setCancelable(false);
                            alert_dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            Objects.requireNonNull(alert_dialog1.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                            alert_dialog1.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                            alert_dialog1.setContentView(R.layout.ckycpopup);
                            ImageView cutImg;
                            TextView TextViewLink;
                            cutImg = alert_dialog1.findViewById(R.id.cutImg);
                            TextViewLink = alert_dialog1.findViewById(R.id.TextViewLink);
                            alert_dialog1.show();
                            cutImg.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    alert_dialog1.dismiss();
                                }
                            });

                            TextViewLink.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(manualKYCurl_intent));
                                    startActivity(browserIntent);
                                    alert_dialog1.dismiss();
//                                    Intent intent=new Intent(getContext(), CKYCWebPage.class);
//                                    intent.putExtra("manualKYCurl",manualKYCurl_intent);
//                                    Log.e("manualKYCurl_intent",manualKYCurl_intent);
//                                    startActivity(intent);
                                }
                            });
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("onErrorResponse", error.toString());
                customprogress.hideProgressBar();
                Toast.makeText(MotorPrivate.this, "" +error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("userid", "usgi_ckyc_user");
                headers.put("password", "Usgi!@2022");
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
//        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }
    private void ResultStatusURL() {
        JSONObject object = new JSONObject();
        try {
            object.put("source", "ONLINE");
            object.put("uniqueTransactionNumber",strIDNumberEdit);
            object.put("extraField1","");
            object.put("extraField2","");
            object.put("extraField3","");
            object.put("extraField4","");
            object.put("extraField5","");

        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(MotorPrivate.this, object, UrlHealthConstants.ResultStatusAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("status").equals("success")) {
                    try {
                        JSONObject objectResult = object.getJSONObject("result");
                        String idNo = objectResult.getString("idNo");
                        ckycNo = objectResult.getString("ckycNo");
                        String firstName = objectResult.getString("name");
                        streditdob = objectResult.getString("dob");
                        String address1 = objectResult.getString("address");
                        String pincode = objectResult.getString("pincode");
                        String maskedAadhaarNumber = objectResult.getString("maskedAadhaarNumber");
                        String pan = objectResult.getString("pan");
                        String email = objectResult.getString("email");
                        String mobileNumber = objectResult.getString("mobileNumber");
                        String uploadedDocument = objectResult.getString("uploadedDocument");
                        String capturedLiveFace = objectResult.getString("capturedLiveFace");
                        String kycVerifiedStatus = objectResult.getString("kycVerifiedStatus");
                        String kycVerifiedDate = objectResult.getString("kycVerifiedDate");

                        if (kycVerifiedStatus.equals("True")){
                            nextMethod();
                        }else{
                            Toast.makeText(MotorPrivate.this, "You KYC Verification not completed yet Please wait...", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        JSONObject objectResult = object.getJSONObject("error");
                        String message =objectResult.getString("message");
                        Toast.makeText(MotorPrivate.this, ""+message, Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }

        }, RequestHealthConstants.RevisedResultStatusAPI);
        req.execute();
    }


    private void EmailConsumeAPI() {
        JSONObject object = new JSONObject();
        try {
            object.put("subject", "POC Net Core Application for USGI Transactional Bulk Email");
            object.put("toEmail",str_edt_email);
            object.put("toName",strName);
            object.put("contentValue","Hi "+ strName +" ,Thank you for choosing Universal Sompo General Insurance as your Insurance Partner.  Please complete your KYC by clicking https://www.usgi.co.in/p?q=ed3ASVwPRK .We promise to be there for you 24x7, whenever you need us. In case you have any queries, feel free to reach us at 1800 200 4030 or mail at contactus@universalsompo.com.Don’t forget to download PULZ App on which you can manage your policy easily and explore a host of value-added services.Explore the app: Download LINK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(MotorPrivate.this, object, UrlHealthConstants.EmailConsumeAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("status").equals("true")) {
                    String message =object.optString("message");
                    Toast.makeText(MotorPrivate.this, ""+message, Toast.LENGTH_SHORT).show();
                }
                else {
                    String message =object.optString("message");
                    Toast.makeText(MotorPrivate.this, ""+message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }

        }, RequestHealthConstants.RevisedCHIEmail);
        req.execute();
    }
    private void SMSConsumeAPI() {
        JSONObject object = new JSONObject();
        try {
            object.put("MobileNo", str_edt_phone);
            object.put("SMS","Dear "+strName+ " ,Greetings from Universal Sompo General Insurance!  Click here https://www.usgi.co.in/p?q=ed3ASVwPRK to complete your KYC. Please ignore if you have completed the KYC.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(MotorPrivate.this, object, UrlHealthConstants.SMSConsumeAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    String message =object.optString("Message");
                    Toast.makeText(MotorPrivate.this, ""+message, Toast.LENGTH_SHORT).show();
                }
                else {
                    String message =object.optString("Message");
                    Toast.makeText(MotorPrivate.this, ""+message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }

        }, RequestHealthConstants.RevisedCHISMS);
        req.execute();
    }
    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            streditdob=dateFormatter.format(newDate.getTime());
            String[] strdDate=  streditdob.split("-");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            strEditdobString = strdDate[2];
            edt_Dob.setText(streditdob);
            Calendar calendar = Calendar.getInstance();
            date = calendar.getTime();
            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
            String today1 = formatter.format(date);
            try {
                SelectDate = dateFormatter.parse(streditdob);
                CurrentDate = dateFormatter.parse(today1);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    Period period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearAdult = period.getYears();
                    SelectMonthDOB = period.getMonths();
                    SelectDaysDOB = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearAdult < 18 || (selectYearAdult > 75)) {
                Toast.makeText(this, "Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
                streditdob="Select Dob";
                edt_Dob.setText(streditdob);
            }
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                str_age="18yrs-25yrs";
            }else if (selectYearAdult >= 26 && selectYearAdult <= 30) {
                str_age="26yrs-30yrs";
            }else if (selectYearAdult >= 31 && selectYearAdult <= 35) {
                str_age="31yrs-35yrs";
            }else if (selectYearAdult >= 36 && selectYearAdult <= 40) {
                str_age="36yrs-40yrs";
            }else if (selectYearAdult >= 41 && selectYearAdult <= 45) {
                str_age="41yrs-45yrs";
            }else if (selectYearAdult >= 46 && selectYearAdult <= 50) {
                str_age="46yrs-50yrs";
            }else if (selectYearAdult >= 51 && selectYearAdult <= 55) {
                str_age="51yrs-55yrs";
            }else if (selectYearAdult >= 56 && selectYearAdult <= 60) {
                str_age="56yrs-60yrs";
            }else if (selectYearAdult >= 61 && selectYearAdult <= 65) {
                str_age="61yrs-65yrs";
            }else if (selectYearAdult >= 66 && selectYearAdult <= 70) {
                str_age="66yrs-70yrs";
            } else if (selectYearAdult >= 71 && selectYearAdult <= 75){
                str_age="71yrs-75yrs";
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(MotorPrivate.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

//    else if (!strVehicleNo.matches(VehicleNumberRegex)){
//        Toast.makeText(MotorPrivate.this, "Enter Valid Vehicle Number ", Toast.LENGTH_SHORT).show();
//    }
}