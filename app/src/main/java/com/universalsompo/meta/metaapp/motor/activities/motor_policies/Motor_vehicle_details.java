package com.universalsompo.meta.metaapp.motor.activities.motor_policies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
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
import com.google.gson.Gson;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Complete_health_member_info;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PersonalInformationCHI;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.CompanyModel;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.MotorRTOModel;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.MotorState;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.VehicleManufacturerModel;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Add_Details_Old_Vehicle;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class Motor_vehicle_details extends AppCompatActivity {
    LinearLayout VerifyButton,IDTypeSpinner_motor,SAODLinerEffective,SAODLiner,NomineeRelationImage,liabilityLiner,continue_button,PolicyLiner,iconLiner,NomineeLiner,NCBLiner,linear_TpEffectivieToDate,linear_TpEffectivieFromDate;
    RadioButton ComprehensivePolicyRadio,LiabilityRadio,OwnDamagedRadio;
    String strUID,stredt_Dob,yearOfManufactureMonth,strSelectDateYear,ckycNo="",uniqueTransactionNumber,NCBStatus,strTpFromDateEdit,strTpEndDateEdit,VoluntarydeductableDiscountAmount, CNGLPGKITODSumInsured,AutoMobileValidityRadio,ELECTRICALACCESSORYODSumInsured,NONELECTRICALACCESSORYODSumInsured,strElectricalAccessoriesSumInsured,strNonelectricalAccessoriesSumInsured,PACOVERTOPASSENGERSSumInsured,UNNAMEDPACOVERTOPASSENGERSSumInsured, PACOVERTOPAIDDRIVERSumInsured,strCngKitSumInsured,AutoMobileRadio,AutomobileAssociationdiscountSumInsured,VoluntarydeductableSumInsured,strMinMax,DiscountsVale,AntitheftdevicediscountStatus,AutomobileAssociationdiscountStatus,TPPDDiscountStatus,HandicapDiscountStatus,VoluntarydeductableStatus,AdditionalNonElecticalODSumInsuredValue,AdditionalElectricalSumInsuredValue,AntitheftdeviceRateValue,AntitheftdeviceSumInsuredValue,AutomobileAssociationRateValue,AutomobileAssociationSumInsuredValue,HandicapRateValue,HandicapSumInsuredValue,TPPDDiscountRateValue,TPPDDiscountSumInsuredValue,VotaryRateValue,VotarySumInsuredValue, strDiscountEdit,StrNCB,ChangeAddons,DetarifficValueSumInsure="",DetarifficLoadingValueSumInsured="",BasicODRateSumInsured="",ELECTRICALCoverSumInsured="",NONELECTRICALSumInsured="",BasicTpRateSumInsured="",AdditionalFibertankODSumInsuredValue,AdditionalLegalLiabilityPaidSumInsured,AdditionalOtherODRateSumInsured,AdditionalOtherTpSumInsuredValue,AdditionalPaCoverToOwnerDriverSumInsuredValue,AdditionalPaidDriverSumInsuredValue,AdditionalPaToPassengersSumInsuredValue,AdditionalUnnamedPassengersSumInsuredValue,AdditionalCngKitODSumInsuredValue,AdditionalCngLpgTpSumInsuredValue,AdditionalBuiltinKitODSumInsuredValue,AdditionalBuiltinCngTPSumInsuredValue,DailyCashRateSumInsured,AccidentalSumInsuredValue,WrongFuelSumInsuredValue,CostOfConsumablesSumInsuredValue,dailyCashAllowanceMetroSumInsuredValue,dailyCashAllowanceNonMetroSumInsuredValue,EngineProtectorDieselSumInsuredValue,EngineProtectorPetrolSumInsuredValue,HydrostaticLockSumInsuredValue,KeyReplacementSumInsuredValue,NilDepreciationSumInsuredValue,ReturnToInvoiceSumInsuredValue,RoadSideAssistanceSumInsuredValue,SecureTowingSumInsuredValue,TyreRimsecureSumInsuredValue,drivingTrainProtectSumInsuredValue,ManufacturesellingSumInsuredValue,strVehicleCubicCapicity="",strVehicleImage="",strNewFor="",DetarifficValuePremium="",DetarifficValueRate="",DetarifficLodingValuePremium="",DetarifficLoadingValueRate="",changeseekBar="",strIdvValueTxtSelect="",CheckString="",WrongFuelRateValue="", DailyCashRateValue="",BasicODRateValue="",BasicTpRateValue="",BUILTINCNGKIT_LPGKITTPStatus="",AdditionalLegalLiabilityPaidRate="",strNomineeName="",strNomineeRelationEdit="",strPreviousClaimRadio="",StrAdditionalCoverPremiumTp="",StrAdditionalCoverPremiumOD="",SeekbarStatus="",addOnsCover="",addOnsAditional="",vehicleManufacturerType="",strModelType="",nextYear="",StrPrev_Policy_Type="",strCompanyName="",strCompanyCode="",FuleType,rc_cubic_cap="",rc_fuel_desc="",VEHICLECLASSCODE="",strClaimBonus="",StrPreviousPolicyRadio="",strEndDateEdit="",ProductName="",ProductCode="",VehicleClassCode="",addOns,NCB,VehicleExShowroomPrice="",strVehicleAge="",yearOfManufacture="",NetPremiumValue="",TotalValue="",PosPolicyNo="",GST="",strIdvValueTxt="",strLessIDVText="",strHighIDVText="",strName="",strVehicleNo="",str_edt_city="",str_edt_phone="",str_edt_email="",strPolicyRadio="",strVehicleTypeRadio="",strVehicleRadio="",strFor="",strTitleEdit="",strRTOName="",str_vehicleManufacturerNm="",strStateName="",strVehicleManufacturerCode="",strRTOCode="",strStateCode="",DAILYCASHALLOWANCEStatus="",WRONGFUELCOVERStatus="",str_edt_registration_date="",strVehicleModelCode="",strVehicleModel="",strPolicyNumberEdit="",strRegisteredAddressEdit="",strStateRegisterAddressEdit="",strStateRegisterCode,strCityRegisterCode="",strCityRegisterEdit="",strCityCommunicationCode="",strPinCodeEditText="",strCommunicationAddressEdit="",strCommunicationPinCodeEdit="",strVehicleNumber="",strVehicleChasisNumber="",strVehicleEngineNumber="",strStateCommunicationEdit="",strStateCommunicationCode="",strCityCommunicationEdit="",strPlanType="",strPlanYear="",strCoverageType="",strPACover="",strGPACover="",strDrivingLicence="",strCheckedTermCondition="",strCheckboxCommunication="",
            tomorrowDate="", BasicODStatus="",BasicTP="",ELECTRICALACCESSORYODStatus="",FIBERTANKODStatus="",LEGALLIABILITYTOPAIDDRIVERStatus="",NONELECTRICALACCESSORYODStatus="",OtherODStatus="",OtherTpStatus="",PACOVERTOEMPLOYEESOFINSUREDStatus="",PACOVERTOOWNERDRIVERStatus="",PACOVERTOPAIDDRIVERStatus="",PACOVERTOPASSENGERSStatus="",UNNAMEDPACOVERTOPASSENGERSStatus="",ACCIDENTALHOSPITALIZATIONStatus="",COSTOFCONSUMABLESStatus="",DAILYCASHALLOWANCEMETROStatus="",DAILYCASHALLOWANCENONMETROStatus="",ENGINEPROTECTORDIESELStatus="",ENGINEPROTECTORPETROLStatus="",HYDROSTATICLOCKCOVERStatus="",KEYREPLACEMENTStatus="",NilDepreciationWaivercoverStatus="",RETURNTOINVOICEStatus="",RoadsideAssistanceStatus="",SECURETOWINGStatus="",TyreandRimsecureStatus="",strendRegistrationDate="",strODPlanFromDateEdit="",strODPlanEndDateEdit="",strTpPlanFromDateEdit="",strTpPlanEndDateEdit="",AdditionalElectricalRateValue="",AdditionalFibertankODRateValue="",AdditionalLegalLiabilityDriverRateValue="",AdditionalBuiltinCngTPRateValue="",AdditionalNonElecticalODRateValue="",AdditionalOtherODRateValue="",AdditionalOtherTpRateValue="",AdditionalPaCoversToEmployessRateValue="",AdditionalPaCoverToOwnerDriverRateValue="",AdditionalPaidDriverRateValue="",AdditionalPaToPassengersRateValue="",AdditionalUnnamedPassengersRateValue="",AdditionalCngKitODRateValue="",AdditionalCngLpgTpRateValue="",AdditionalBuiltinKitODRateValue="",AccidentalRateValue="",CostOfConsumablesRateValue="",dailyCashAllowanceMetroRateValue="",dailyCashAllowanceNonMetroRateValue="",EngineProtectorDieselRateValue="", EngineProtectorPetrolRateValue="",HydrostaticLockRateValue="", KeyReplacementRateValue="", NilDepreciationRateValue="", ReturnToInvoiceRateValue="", RoadSideAssistanceRateValue="",SecureTowingRateValue="",TyreRimsecureRateValue="", drivingTrainProtectRateValue="", ManufacturesellingRateValue="",CNGLPGKITODStatus="",CNGLPGKITTPStatus="",BUILTINCNGKIT_LPGKITODStatus="",MANUFACTURERSELLINGPRICEStatus="",DRIVINGTRAINPROTECTStatus="",strBreaking = "",previousDate="";
    EditText edt_phoneNumber,IDNumberEdit_motor,edt_IdType_motor,edt_Dob,TpFromDateEdit,TpEndDateEdit,NomineeName,NomineeRelationEdit,NCBValueEditSpinner,titleEdit,policyNumberEdit,fullNameEdit,emailIDText,registeredAddressEdit,StateRegisterAddressEdit,CityRegisterEdit,PinCodeEditText,CommunicationAddressEdit,CommunicationPinCodeEdit,VehicleNumber,VehicleChasisNumber,VehicleEngineNumber,StateCommunicationEdit,CityCommunicationEdit,CompanyNameEdit,endRegistrationDate,ODPlanFromDateEdit,ODPlanEndDateEdit,TpPlanFromDateEdit,TpPlanEndDateEdit,TpEffectiveFromDate,TpEffectiveToDate;
    ImageView calendarIconSelf_motor,vehicleDetailsBack,titleImage,StateRegisterAddressSpinner,CityRegisterSpinner,StateCommunicationSpinner,CityCommunicationSpinner,CompanyPolicySpinner,NCBValueSpinnerIcon;
    MySharedPreference pref;
    TextView PreviousEndDateTxt,FullNameTittle,TotalPremiumTxt,TxtViewVehicleType,NameVehicleTxt,ViewDetails;
    ArrayList<MotorState>motorStateList = new ArrayList<MotorState>();
    final ArrayList<String> itemsState = new ArrayList<String>();
    MotorState motorState;
    MotorRTOModel motorRTOModel;
    String strEditdobString,strGenderSpinner = "",streditdob = "",strIDType ="",strIDTypeName="",strIDNumberEdit,strIDTypeName1="";
    String PanExpression="[A-Z]{5}[0-9]{4}[A-Z]{1}",VoterIDExpression="^[A-Z]{3}[0-9]{7}$",AadharExpression="^[2-9][0-9]{11}$",PassportExpression="^[A-PR-WYa-pr-wy][1-9]\\d\\s?\\d{4}[1-9]$",DrivingExpression="^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$";
    ArrayList<MotorRTOModel>motorRTOList = new ArrayList<MotorRTOModel>();
    final ArrayList<String> itemsRTO = new ArrayList<String>();
    MyOptionsPickerView singlePicker;
    String click="",strMemberEditTxt="",strValidityTxt="";
    CheckBox CheckboxCommunication,CheckedTermCondition;
    ArrayList<CompanyModel> vehicleCompanyList = new ArrayList<CompanyModel>();
    final ArrayList<String> itemsCompany = new ArrayList<String>();
    CompanyModel companyModel;
    int progressChanged,a,b,c,selectYear,daysLeft,VehicleAgeAdd,MonthsLeft;
    private SimpleDateFormat dateFormatter;
    final Calendar myCalendar= Calendar.getInstance();
    String PinCodeRegex= "([1-9]{1}[0-9]{5})";
    String VehicleNumberRegex="^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$";
    Date strEndDate,strTpEndDate;
    CustomProgressDialog customprogress;
    Date date,CurrentDate,SelectDate;
    int selectYearAdult,SelectMonthDOB,SelectDaysDOB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor_vehicle_details);
        getWindow().setStatusBarColor(ContextCompat.getColor(Motor_vehicle_details.this, R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(Motor_vehicle_details.this);
        customprogress = new CustomProgressDialog(Motor_vehicle_details.this);
        strUID=pref.getUID();

        strMemberEditTxt = getIntent().getStringExtra("MemberEditTxt");
        strValidityTxt = getIntent().getStringExtra("ValidityTxt");
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
        strCoverageType = getIntent().getStringExtra("strCoverageType");
        strPACover = getIntent().getStringExtra("strPACover");
        strGPACover = getIntent().getStringExtra("strGPACover");
        strDrivingLicence = getIntent().getStringExtra("strDrivingLicence");
        strPlanType = getIntent().getStringExtra("strPlanType");
        strPlanYear = getIntent().getStringExtra("strPlanYear");
        strRegisteredAddressEdit = getIntent().getStringExtra("strRegisteredAddressEdit");
        strTitleEdit = getIntent().getStringExtra("strTitleEdit");
        strPinCodeEditText = getIntent().getStringExtra("strPinCodeEditText");
        strStateRegisterAddressEdit = getIntent().getStringExtra("strStateRegisterAddressEdit");
        strCityRegisterEdit = getIntent().getStringExtra("strCityRegisterEdit");
        strCommunicationAddressEdit = getIntent().getStringExtra("strCommunicationAddressEdit");
        strCommunicationPinCodeEdit = getIntent().getStringExtra("strCommunicationPinCodeEdit");
        strStateCommunicationEdit = getIntent().getStringExtra("strStateCommunicationEdit");
        strCityCommunicationEdit = getIntent().getStringExtra("strCityCommunicationEdit");
        strVehicleChasisNumber = getIntent().getStringExtra("strVehicleChasisNumber");
        strVehicleEngineNumber = getIntent().getStringExtra("strVehicleEngineNumber");
        strCheckedTermCondition = getIntent().getStringExtra("strCheckedTermCondition");
        strCheckboxCommunication = getIntent().getStringExtra("strCheckboxCommunication");
        strCityRegisterCode = getIntent().getStringExtra("strCityRegisterCode");
        strCityCommunicationCode = getIntent().getStringExtra("strCityCommunicationCode");
        TotalValue = getIntent().getStringExtra("TotalValue");
        strIdvValueTxt = getIntent().getStringExtra("strIdvValueTxt");
        strLessIDVText = getIntent().getStringExtra("strLessIDVText");
        strHighIDVText = getIntent().getStringExtra("strHighIDVText");
        NetPremiumValue = getIntent().getStringExtra("NetPremiumValue");
        GST = getIntent().getStringExtra("GST");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        strVehicleManufacturerCode = getIntent().getStringExtra("strVehicleManufacturerCode");
        strRTOCode = getIntent().getStringExtra("strRTOCode");
        yearOfManufacture = getIntent().getStringExtra("yearOfManufacture");
        strVehicleModelCode = getIntent().getStringExtra("strVehicleModelCode");
        strVehicleAge = getIntent().getStringExtra("strVehicleAge");
        strVehicleNumber = getIntent().getStringExtra("strVehicleNumber");
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
        addOns = getIntent().getStringExtra("addOns");
        NCB = getIntent().getStringExtra("NCB");
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
        WrongFuelRateValue = getIntent().getStringExtra("WrongFuelRateValue");
        DailyCashRateValue = getIntent().getStringExtra("DailyCashRateValue");
        strStateCode = getIntent().getStringExtra("strStateCode");
        progressChanged =getIntent().getIntExtra("progressChanged", 0);
        selectYear =getIntent().getIntExtra("selectYear", 0);
        daysLeft =getIntent().getIntExtra("daysLeft", 0);
        VehicleAgeAdd =getIntent().getIntExtra("VehicleAgeAdd", 0);
        MonthsLeft =getIntent().getIntExtra("MonthsLeft", 0);
        a =getIntent().getIntExtra("a", 0);
        b =getIntent().getIntExtra("b", 0);
        c =getIntent().getIntExtra("c", 0);
        BasicODRateValue = getIntent().getStringExtra("BasicODRateValue");
        BasicTpRateValue = getIntent().getStringExtra("BasicTpRateValue");
        strIdvValueTxtSelect = getIntent().getStringExtra("strIdvValueTxtSelect");
        changeseekBar = getIntent().getStringExtra("changeseekBar");
        DAILYCASHALLOWANCEStatus = getIntent().getStringExtra("DAILYCASHALLOWANCEStatus");
        WRONGFUELCOVERStatus = getIntent().getStringExtra("WRONGFUELCOVERStatus");
        DetarifficValuePremium = getIntent().getStringExtra("DetarifficValuePremium");
        DetarifficValueRate = getIntent().getStringExtra("DetarifficValueRate");
        DetarifficLodingValuePremium = getIntent().getStringExtra("DetarifficLodingValuePremium");
        DetarifficLoadingValueRate = getIntent().getStringExtra("DetarifficLoadingValueRate");
        strNewFor = getIntent().getStringExtra("strNewFor");
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
        strIDTypeName1 = getIntent().getStringExtra("strIDTypeName1");
        strIDNumberEdit = getIntent().getStringExtra("strIDNumberEdit");
        ckycNo = getIntent().getStringExtra("ckycNo");
        uniqueTransactionNumber = getIntent().getStringExtra("uniqueTransactionNumber");
        yearOfManufactureMonth = getIntent().getStringExtra("yearOfManufactureMonth");
        strSelectDateYear = getIntent().getStringExtra("strSelectDateYear");
        if(getIntent().hasExtra("previousDate")){
            previousDate = getIntent().getStringExtra("previousDate");
        }
        edt_phoneNumber = findViewById(R.id.edt_phoneNumber);
        edt_Dob = findViewById(R.id.edt_Dob);
        TpEndDateEdit=findViewById(R.id.TpEndDateEdit);
        TpFromDateEdit=findViewById(R.id.TpFromDateEdit);
        SAODLinerEffective=findViewById(R.id.SAODLinerEffective);
        IDTypeSpinner_motor=findViewById(R.id.IDTypeSpinner_motor);
        edt_IdType_motor = findViewById(R.id.edt_IdType_motor);
        IDNumberEdit_motor = findViewById(R.id.IDNumberEdit_motor);
        SAODLiner=findViewById(R.id.SAODLiner);
        NCBLiner=findViewById(R.id.NCBLiner);
        liabilityLiner=findViewById(R.id.liabilityLiner);
        linear_TpEffectivieFromDate=findViewById(R.id.linear_TpEffectivieFromDate);
        linear_TpEffectivieToDate=findViewById(R.id.linear_TpEffectivieToDate);
        PolicyLiner=findViewById(R.id.PolicyLiner);
        PreviousEndDateTxt=findViewById(R.id.PreviousEndDateTxt);
        continue_button=findViewById(R.id.continue_button);
        ComprehensivePolicyRadio=findViewById(R.id.ComprehensivePolicyRadio);
        OwnDamagedRadio=findViewById(R.id.OwnDamagedRadio);
        LiabilityRadio=findViewById(R.id.LiabilityRadio);
        policyNumberEdit=findViewById(R.id.policyNumberEdit);
        titleImage=findViewById(R.id.titleImage);
        titleEdit=findViewById(R.id.titleEdit);
        fullNameEdit=findViewById(R.id.fullNameEdit);
        emailIDText=findViewById(R.id.emailIDText);
        registeredAddressEdit=findViewById(R.id.registeredAddressEdit);
        PinCodeEditText=findViewById(R.id.PinCodeEditText);
        CommunicationAddressEdit=findViewById(R.id.CommunicationAddressEdit);
        CommunicationPinCodeEdit=findViewById(R.id.CommunicationPinCodeEdit);
        VehicleNumber=findViewById(R.id.VehicleNumber);
        VehicleChasisNumber=findViewById(R.id.VehicleChasisNumber);
        VehicleEngineNumber=findViewById(R.id.VehicleEngineNumber);
        StateRegisterAddressSpinner=findViewById(R.id.StateRegisterAddressSpinner);
        StateRegisterAddressEdit=findViewById(R.id.StateRegisterAddressEdit);
        CityRegisterSpinner=findViewById(R.id.CityRegisterSpinner);
        CityRegisterEdit=findViewById(R.id.CityRegisterEdit);
        StateCommunicationSpinner=findViewById(R.id.StateCommunicationSpinner);
        StateCommunicationEdit=findViewById(R.id.StateCommunicationEdit);
        CityCommunicationEdit=findViewById(R.id.CityCommunicationEdit);
        CityCommunicationSpinner=findViewById(R.id.CityCommunicationSpinner);
        CheckedTermCondition=findViewById(R.id.CheckedTermCondition);
        CheckboxCommunication=findViewById(R.id.CheckboxCommunication);
        TotalPremiumTxt=findViewById(R.id.TotalPremiumTxt);
        CompanyPolicySpinner=findViewById(R.id.CompanyPolicySpinner);
        CompanyNameEdit=findViewById(R.id.CompanyNameEdit);
        endRegistrationDate=findViewById(R.id.endRegistrationDate);
        iconLiner=findViewById(R.id.iconLiner);
        NomineeLiner=findViewById(R.id.NomineeLiner);
        NCBValueEditSpinner=findViewById(R.id.NCBValueEditSpinner);
        NCBValueSpinnerIcon=findViewById(R.id.NCBValueSpinnerIcon);
        ODPlanFromDateEdit=findViewById(R.id.ODPlanFromDateEdit);
        ODPlanEndDateEdit=findViewById(R.id.ODPlanEndDateEdit);
        TpPlanFromDateEdit=findViewById(R.id.TpPlanFromDateEdit);
        TpPlanEndDateEdit=findViewById(R.id.TpPlanEndDateEdit);
        TxtViewVehicleType=findViewById(R.id.TxtViewVehicleType);
        vehicleDetailsBack=findViewById(R.id.vehicleDetailsBack);
        NomineeRelationImage=findViewById(R.id.NomineeRelationImage);
        calendarIconSelf_motor=findViewById(R.id.calendarIconSelf_motor);
        NameVehicleTxt=findViewById(R.id.NameVehicleTxt);
        FullNameTittle=findViewById(R.id.FullNameTittle);
        ViewDetails=findViewById(R.id.ViewDetails);
        NomineeName=findViewById(R.id.NomineeName);
        VerifyButton=findViewById(R.id.VerifyButton);
        NomineeRelationEdit=findViewById(R.id.NomineeRelationEdit);
        TpEffectiveFromDate=findViewById(R.id.TpEffectiveFromDate);
        TpEffectiveToDate=findViewById(R.id.TpEffectiveToDate);
        NameVehicleTxt.setText(strName);


        if (strVehicleTypeRadio.equals("Four Wheeler")){
            TxtViewVehicleType.setText("Four Wheeler Insurance");
        }else{
            TxtViewVehicleType.setText("Two Wheeler Insurance");
        }
        if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
            VehicleChasisNumber.setText(strVehicleChasisNumber);
            VehicleEngineNumber.setText(strVehicleEngineNumber);
            VehicleNumber.setText(strVehicleNo);
            VehicleChasisNumber.setEnabled(true);
            VehicleChasisNumber.setFocusable(true);
            VehicleChasisNumber.setClickable(true);
            if (strVehicleNo.equals("")){
                VehicleNumber.setEnabled(true);
                VehicleNumber.setClickable(true);
                VehicleNumber.setFocusable(true);
            }else{
                VehicleNumber.setEnabled(false);
                VehicleNumber.setClickable(false);
                VehicleNumber.setFocusable(false);
            }
            VehicleEngineNumber.setEnabled(true);
            VehicleEngineNumber.setClickable(true);
            VehicleEngineNumber.setFocusable(true);
            endRegistrationDate.setText(strEndDateEdit);
            TpEndDateEdit.setText(strTpEndDateEdit);
            TpFromDateEdit.setText(strTpFromDateEdit);



            if (strPreviousClaimRadio.equals("Yes")){
                NCBLiner.setVisibility(View.GONE);
            }else {
                NCBLiner.setVisibility(View.VISIBLE);
            }
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                strTpEndDate = sdf.parse(strTpEndDateEdit);
                strEndDate = sdf.parse(strEndDateEdit);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            PolicyLiner.setVisibility(View.VISIBLE);
        }
        else{
            PolicyLiner.setVisibility(View.GONE);
        }
        if (strCoverageType.equals("Individual")){
            if (strDrivingLicence.equals("Yes")){
                if (strPACover.equals("No")&&strGPACover.equals("No")){
                    NomineeLiner.setVisibility(View.VISIBLE);
                }else {
                    NomineeLiner.setVisibility(View.GONE);
                }
            }else{
                NomineeLiner.setVisibility(View.GONE);
            }
        }
        else{
            NomineeLiner.setVisibility(View.GONE);
            strTitleEdit="MS";
            titleEdit.setText(strTitleEdit);
            titleEdit.setEnabled(false);
            titleImage.setVisibility(View.GONE);
//            titleImage.setClickable(false);
            FullNameTittle.setText("Enter Your Company Name");
            strName="";
            fullNameEdit.setText(strName);

        }


        if (strFor.equals("0")){
            if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
                VehicleNumber.setText(strVehicleNo);
            }else{
                strVehicleNo="New";
                VehicleNumber.setText(strVehicleNo);
            }
            strTitleEdit="Select Title";
            titleEdit.setText(strTitleEdit);
            emailIDText.setText(str_edt_email);
            fullNameEdit.setText(strName);

            strCheckboxCommunication="true";
            strStateRegisterAddressEdit="Select Registered State";
            strStateCommunicationEdit="Select Communication State";
            strCityRegisterEdit="Select Registered City";
            strCityCommunicationEdit="Select Communication City";
            StateRegisterAddressEdit.setText(strStateRegisterAddressEdit);
            StateCommunicationEdit.setText(strStateCommunicationEdit);
            CityRegisterEdit.setText(strCityRegisterEdit);
            CityCommunicationEdit.setText(strCityCommunicationEdit);
            TotalPremiumTxt.setText(TotalValue);
            if (!strPolicyNumberEdit.equals("") && !strPolicyNumberEdit.equals("null")&& strPolicyNumberEdit!=null){
                PolicyLiner.setVisibility(View.VISIBLE);
                policyNumberEdit.setText(strPolicyNumberEdit);
                CompanyNameEdit.setText(strCompanyName);
                NCBValueEditSpinner.setText(strClaimBonus+" %");
                StrPrev_Policy_Type="Comprehensive";
                strTpPlanFromDateEdit="";
                strTpPlanEndDateEdit="";
                strODPlanFromDateEdit="";
                strODPlanEndDateEdit="";
            }else {
                PolicyLiner.setVisibility(View.GONE);

            }

        }
        else{
            if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
                VehicleNumber.setText(strVehicleNo);
            }else{
                strVehicleNo="New";
                VehicleNumber.setText(strVehicleNo);
            }

            if (strTitleEdit==null && strStateRegisterAddressEdit==null && strStateCommunicationEdit==null&& strCityRegisterEdit==null && strCityCommunicationEdit==null && strNomineeName==null && strNomineeRelationEdit==null){
                strTitleEdit="Select Title";
                streditdob="Select DOB";
                strIDTypeName="Select ID Type";
                strIDNumberEdit="";
                str_edt_phone=pref.getMOBILE();
                titleEdit.setText(strTitleEdit);
                emailIDText.setText(str_edt_email);
                fullNameEdit.setText(strName);
                strCheckboxCommunication="false";
                strStateRegisterAddressEdit="Select Registered State";
                strStateCommunicationEdit="Select Communication State";
                strCityRegisterEdit="Select Registered City";
                strCityCommunicationEdit="Select Communication City";
                StateRegisterAddressEdit.setText(strStateRegisterAddressEdit);
                StateCommunicationEdit.setText(strStateCommunicationEdit);
                CityRegisterEdit.setText(strCityRegisterEdit);
                CityCommunicationEdit.setText(strCityCommunicationEdit);
                TotalPremiumTxt.setText(TotalValue);
                edt_Dob.setText(streditdob);
                edt_IdType_motor.setText(strIDTypeName);
                IDNumberEdit_motor.setText(strIDNumberEdit);
                edt_phoneNumber.setText(str_edt_phone);


            }else {
                if (strTitleEdit.equals("Select Title")){
                    streditdob="Select DOB";
                    strIDTypeName="Select ID Type";
                    strIDNumberEdit="";
                }
                emailIDText.setText(str_edt_email);
                fullNameEdit.setText(strName);
                titleEdit.setText(strTitleEdit);
                PinCodeEditText.setText(strPinCodeEditText);
                registeredAddressEdit.setText(strRegisteredAddressEdit);
                StateRegisterAddressEdit.setText(strStateRegisterAddressEdit);
                CityRegisterEdit.setText(strCityRegisterEdit);
                CommunicationAddressEdit.setText(strCommunicationAddressEdit);
                CommunicationPinCodeEdit.setText(strCommunicationPinCodeEdit);
                StateCommunicationEdit.setText(strStateCommunicationEdit);
                CityCommunicationEdit.setText(strCityCommunicationEdit);
                VehicleChasisNumber.setText(strVehicleChasisNumber);
                VehicleEngineNumber.setText(strVehicleEngineNumber);
                TotalPremiumTxt.setText(TotalValue);
                VehicleNumber.setText(strVehicleNo);
                endRegistrationDate.setText(strEndDateEdit);
                NomineeName.setText(strNomineeName);
                NomineeRelationEdit.setText(strNomineeRelationEdit);
                edt_Dob.setText(streditdob);
                edt_IdType_motor.setText(strIDTypeName);
                IDNumberEdit_motor.setText(strIDNumberEdit);
                edt_phoneNumber.setText(str_edt_phone);
            }
            if (strCheckedTermCondition!=null){
                if (strCheckedTermCondition.equals("true")){
                    CheckedTermCondition.setChecked(true);
                }else {
                    CheckedTermCondition.setChecked(false);
                }
            }
            if (strCheckboxCommunication!=null){
                if (strCheckboxCommunication.equals("true")){
                    CheckboxCommunication.setChecked(true);
                }else {
                    CheckboxCommunication.setChecked(false);
                }
            }

            if (strPolicyNumberEdit!=null && strCompanyName!=null && strClaimBonus!=null){
//                StrPrev_Policy_Type="Comprehensive";
                policyNumberEdit.setText(strPolicyNumberEdit);
                CompanyNameEdit.setText(strCompanyName);
                ODPlanFromDateEdit.setText(strODPlanFromDateEdit);
                NCBValueEditSpinner.setText(strClaimBonus+" %");
                ODPlanEndDateEdit.setText(strODPlanEndDateEdit);
                TpPlanFromDateEdit.setText(strTpPlanFromDateEdit);
                TpPlanEndDateEdit.setText(strTpPlanEndDateEdit);
            }else{
                PolicyLiner.setVisibility(View.GONE);
            }
            if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")){
                if (strVehicleTypeRadio.equals("Four Wheeler")) {
                    if (VehicleAgeAdd <3) {
                        PreviousEndDateTxt.setText("OD policy end date");
                        ComprehensivePolicyRadio.setVisibility(View.VISIBLE);
                        OwnDamagedRadio.setVisibility(View.VISIBLE);
                        SAODLiner.setVisibility(View.VISIBLE);
                        SAODLinerEffective.setVisibility(View.VISIBLE);
                        LiabilityRadio.setVisibility(View.GONE);
                        LiabilityRadio.setChecked(false);
                        if (StrPreviousPolicyRadio.equals("No")){
                            PolicyLiner.setVisibility(View.GONE);
                        }
                        if (StrPrev_Policy_Type.equals("Comprehensive")){
                            ComprehensivePolicyRadio.setChecked(true);
                            OwnDamagedRadio.setChecked(false);
                        }else if (StrPrev_Policy_Type.equals("Own damage (standalone)")){
                            ComprehensivePolicyRadio.setChecked(false);
                            OwnDamagedRadio.setChecked(true);
                        }
                        ComprehensivePolicyRadio.setEnabled(false);
                        OwnDamagedRadio.setEnabled(false);
                    }
                    else{
                        SAODLiner.setVisibility(View.GONE);
                        SAODLinerEffective.setVisibility(View.GONE);
                        OwnDamagedRadio.setVisibility(View.GONE);
                        LiabilityRadio.setVisibility(View.VISIBLE);
                        OwnDamagedRadio.setChecked(false);
                        if (StrPreviousPolicyRadio.equals("No")){
                            PolicyLiner.setVisibility(View.GONE);
                        }
                        if (StrPrev_Policy_Type.equals("Comprehensive")){
                            ComprehensivePolicyRadio.setChecked(true);
                            LiabilityRadio.setChecked(false);
                        }else if (StrPrev_Policy_Type.equals("Liability")){
                            ComprehensivePolicyRadio.setChecked(false);
                            LiabilityRadio.setChecked(true);
                        }
                        ComprehensivePolicyRadio.setEnabled(false);
                        LiabilityRadio.setEnabled(false);
                    }
                }
                else{
                    if (VehicleAgeAdd <5) {
                        ComprehensivePolicyRadio.setVisibility(View.VISIBLE);
                        OwnDamagedRadio.setVisibility(View.VISIBLE);
                        SAODLiner.setVisibility(View.VISIBLE);
                        SAODLinerEffective.setVisibility(View.VISIBLE);
                        LiabilityRadio.setVisibility(View.GONE);
                        LiabilityRadio.setChecked(false);
                        if (StrPreviousPolicyRadio.equals("No")){
                            PolicyLiner.setVisibility(View.GONE);
                        }
                        PreviousEndDateTxt.setText("OD policy end date");
                        if (StrPrev_Policy_Type.equals("Comprehensive")){
                            ComprehensivePolicyRadio.setChecked(true);
                            OwnDamagedRadio.setChecked(false);
                        }else if (StrPrev_Policy_Type.equals("Own damage (standalone)")){
                            ComprehensivePolicyRadio.setChecked(false);
                            OwnDamagedRadio.setChecked(true);
                        }
                        ComprehensivePolicyRadio.setEnabled(false);
                        OwnDamagedRadio.setEnabled(false);
                    }
                    else{
                        SAODLiner.setVisibility(View.GONE);
                        SAODLinerEffective.setVisibility(View.GONE);
                        OwnDamagedRadio.setVisibility(View.GONE);
                        LiabilityRadio.setVisibility(View.VISIBLE);
                        OwnDamagedRadio.setChecked(false);

                        if (StrPreviousPolicyRadio.equals("No")){
                            PolicyLiner.setVisibility(View.GONE);
                        }

                        if (StrPrev_Policy_Type.equals("Comprehensive")){
                            ComprehensivePolicyRadio.setChecked(true);
                            LiabilityRadio.setChecked(false);
                        }else if (StrPrev_Policy_Type.equals("Liability")){
                            ComprehensivePolicyRadio.setChecked(false);
                            LiabilityRadio.setChecked(true);
                        }
                        ComprehensivePolicyRadio.setEnabled(false);
                        LiabilityRadio.setEnabled(false);
                    }
                }
            }
        }

        titleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Motor_vehicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select Title");
                items1.add("Mr.");
                items1.add("Mrs.");
                items1.add("Ms.");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTitleEdit=items1.get(options1);
                        titleEdit.setText(strTitleEdit);
                    }
                });
                singlePicker.show(); }
        });

        IDTypeSpinner_motor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Motor_vehicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select ID Type");
                items1.add("PAN Card");
                items1.add("Voter ID");
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
                            strIDTypeName1="PAN";
                            strIDNumberEdit="";
                            ckycNo="";
                            IDNumberEdit_motor.setText(strIDNumberEdit);
                        }else if (strIDTypeName.equals("Voter ID")){
                            strIDType="VOTER_ID";
                            strIDTypeName1="VOTER";
                            strIDNumberEdit="";
                            ckycNo="";
                            IDNumberEdit_motor.setText(strIDNumberEdit);
                        } else if (strIDTypeName1.equals("Passport")){
                            strIDType="PASSPORT";
                            strIDTypeName="PASSPORT";
                            strIDNumberEdit="";
                            ckycNo="";
                            IDNumberEdit_motor.setText(strIDNumberEdit);
                        }else if (strIDTypeName.equals("Driving Licence")){
                            strIDType="DRIVING_LICENCE";
                            strIDTypeName1="DRIVING";
                            strIDNumberEdit="";
                            ckycNo="";
                            IDNumberEdit_motor.setText(strIDNumberEdit);
                        }else if (strIDTypeName.equals("Existing CKYC Number")){
                            strIDType="CKYC_NO";
                            strIDTypeName1="EXISTING";
                            strIDNumberEdit="";
                            ckycNo="";
                            IDNumberEdit_motor.setText(strIDNumberEdit);

                        }else if (strIDTypeName.equals("Reference Number")){
                            strIDType="CKYC_NO";
                            strIDTypeName1="REFERENCE";
                            strIDNumberEdit="";
                            ckycNo="";
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
        VerifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CKYCMethod();
            }
        });

        calendarIconSelf_motor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCalender1();
            }
        });
        NCBValueSpinnerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Motor_vehicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("0");
                items1.add("20");
                items1.add("25");
                items1.add("35");
                items1.add("40");
                items1.add("50");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strClaimBonus=items1.get(options1);
                        NCBValueEditSpinner.setText(strClaimBonus+" %");
                    }
                });
                singlePicker.show();
            }
        });
        StateRegisterAddressSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click="1";
                state();
            }
        });
        CityRegisterSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  if(StateRegisterAddressEdit.getText().toString().isEmpty()){
                //Toast.makeText(Motor_vehicle_details.this, "Please Select State First", Toast.LENGTH_SHORT).show();


//             }else{
//
//                 click="1";
//                 VehicleMasterRtoLocationZoneAPI();
//
//             }

//                click="1";
//                VehicleMasterRtoLocationZoneAPI();
            }
        });
        StateCommunicationSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click="2";
                state();
            }
        });
        CityCommunicationSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click="2";
                VehicleMasterRtoLocationZoneAPI();

            }
        });
        ComprehensivePolicyRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ComprehensivePolicyRadio.isChecked()){
                    ComprehensivePolicyRadio.setChecked(true);
                    LiabilityRadio.setChecked(false);
                    liabilityLiner.setVisibility(View.GONE);
                    StrPrev_Policy_Type="Comprehensive";
                }
            }
        });
        LiabilityRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (LiabilityRadio.isChecked()){
                    LiabilityRadio.setChecked(true);
                    ComprehensivePolicyRadio.setChecked(false);
                    liabilityLiner.setVisibility(View.GONE);
                    StrPrev_Policy_Type="Liability";
                }
            }
        });
        CompanyPolicySpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VehicleAllCompanyMaster();
            }
        });


        PinCodeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                Is_Valid_refer(PinCodeEditText);
            }

            public void Is_Valid_refer(EditText edt_refer) {
                if (edt_refer.length() == 6) {
                    strPinCodeEditText = edt_refer.getText().toString();
                    pincodeURL();
//                    if (!strPinCodeEditText.matches(PinCodeRegex)){
//                        Toast.makeText(Motor_vehicle_details.this, "Enter Valid PinCode", Toast.LENGTH_SHORT).show();
//                        strPinCodeEditText="";
//                        PinCodeEditText.setText(strPinCodeEditText);
//                    }else{
//                        pincodeURL();
//                        PinCodeEditText.setText(strPinCodeEditText);
//                    }
                } else if (edt_refer.getText().toString().equals("")) {
                    Toast.makeText(Motor_vehicle_details.this, "Please Enter 6 Digit PinCode/ZipCode", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CommunicationPinCodeEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                Is_Valid_refer(CommunicationPinCodeEdit);
            }

            public void Is_Valid_refer(EditText edt_refer1) {
                if (edt_refer1.length() == 6) {
                    strCommunicationPinCodeEdit = edt_refer1.getText().toString();
                    pincodeSecondURL();
//                    if (!strCommunicationPinCodeEdit.matches(PinCodeRegex)){
//                        Toast.makeText(Motor_vehicle_details.this, "Enter Valid PinCode", Toast.LENGTH_SHORT).show();
//                        strCommunicationPinCodeEdit="";
//                        CommunicationPinCodeEdit.setText(strCommunicationPinCodeEdit);
//                    }else{
//                        pincodeSecondURL();
//                        CommunicationPinCodeEdit.setText(strCommunicationPinCodeEdit);
//                    }
                } else if (edt_refer1.getText().toString().equals("")) {
                    Toast.makeText(Motor_vehicle_details.this, "Please Enter 6 Digit PinCode/ZipCode", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CheckboxCommunication.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    strPinCodeEditText=PinCodeEditText.getText().toString();
                    if (!strPinCodeEditText.matches(PinCodeRegex)){
                        Toast.makeText(Motor_vehicle_details.this, "Enter Valid PinCode", Toast.LENGTH_SHORT).show();
                        strPinCodeEditText="";
                        PinCodeEditText.setText(strPinCodeEditText);
                    }else{
                        PinCodeEditText.setText(strPinCodeEditText);
                    }

                    strRegisteredAddressEdit=registeredAddressEdit.getText().toString();
                    registeredAddressEdit.setText(strRegisteredAddressEdit);

                    strCheckboxCommunication="true";
//                    CheckboxCommunication.setChecked(true);
                    CommunicationAddressEdit.setClickable(false);
                    CommunicationAddressEdit.setEnabled(false);
                    CommunicationAddressEdit.setCursorVisible(false);
                    CommunicationPinCodeEdit.setClickable(false);
                    CommunicationPinCodeEdit.setCursorVisible(false);
                    CommunicationPinCodeEdit.setEnabled(false);
                    StateCommunicationSpinner.setEnabled(false);
                    CityCommunicationSpinner.setEnabled(false);
                    strCommunicationAddressEdit=strRegisteredAddressEdit;
                    strCommunicationPinCodeEdit=strPinCodeEditText;
                    strStateCommunicationEdit=strStateRegisterAddressEdit;
                    strStateCommunicationCode=strStateRegisterCode;
                    strCityCommunicationEdit=strCityRegisterEdit;
                    strCityCommunicationCode=strCityRegisterCode;
                    CommunicationAddressEdit.setText(strCommunicationAddressEdit);
                    CommunicationPinCodeEdit.setText(strCommunicationPinCodeEdit);
                    StateRegisterAddressEdit.setText(strStateRegisterAddressEdit);
                    StateCommunicationEdit.setText(strStateCommunicationEdit);
                    CityRegisterEdit.setText(strCityRegisterEdit);
                    CityCommunicationEdit.setText(strCityCommunicationEdit);
                }else{
                    strCheckboxCommunication="false";
                    CommunicationAddressEdit.setText("");
                    CommunicationPinCodeEdit.setText("");
                    strStateCommunicationEdit="Select Communication State";
                    strCityCommunicationEdit="Select Communication City";
                    StateCommunicationEdit.setText(strStateCommunicationEdit);
                    CityCommunicationEdit.setText(strCityCommunicationEdit);
//                    CheckboxCommunication.setChecked(false);
//                    CommunicationAddressEdit.setEnabled(true);
                    CommunicationAddressEdit.setEnabled(true);
                    CommunicationAddressEdit.setClickable(true);
                    CommunicationAddressEdit.setCursorVisible(true);
//                    CommunicationAddressEdit.setFocusable(true);
//                    CommunicationPinCodeEdit.setEnabled(true);
                    CommunicationPinCodeEdit.setEnabled(true);
                    CommunicationPinCodeEdit.setClickable(true);
                    CommunicationPinCodeEdit.setCursorVisible(true);
//                    CommunicationPinCodeEdit.setFocusable(true);
                    StateCommunicationSpinner.setEnabled(true);
                    CityCommunicationSpinner.setEnabled(true);
                }
            }
        });
        CheckedTermCondition.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CheckedTermCondition.isChecked()){
                    strCheckedTermCondition="true";
                    CheckedTermCondition.setChecked(true);
                }else{
                    strCheckedTermCondition="false";
                    CheckedTermCondition.setChecked(false);
                }
            }
        });
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        endRegistrationDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showCalender();
//                new DatePickerDialog(Motor_vehicle_details.this,R.style.MyDatePickerStyle_,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
        iconLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showCalender();
                //hide

//                new DatePickerDialog(Motor_vehicle_details.this,R.style.MyDatePickerStyle_,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
        ODPlanFromDateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderODFrom();
            }
        });
        ODPlanEndDateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderODEnd();
            }
        });
        TpPlanFromDateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderTPFrom();
            }
        });
        TpPlanEndDateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderTPEnd();

            }
        });
        NomineeRelationImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Motor_vehicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Spouse");
                items1.add("Mother");
                items1.add("Father");
                items1.add("Brother");
                items1.add("Sister");
                items1.add("Son");
                items1.add("Daughter");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strNomineeRelationEdit = items1.get(options1);
                        NomineeRelationEdit.setText(strNomineeRelationEdit);
                    }
                });
                singlePicker.show();
            }
        });
        ViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(Motor_vehicle_details.this);
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

                if(!CheckString.equals("1")){
                    addOnsCover="0.0";
                    addOnsAditional="0.0";
                    DiscountsVale="0.0";
                    addOnsEdit.setText(addOnsCover);
                    addCoveragesEdit.setText(addOnsAditional);
                }
                addOnsEdit.setText(addOnsCover);
                addCoveragesEdit.setText(addOnsAditional);
                TotalDiscountEdit.setText(DiscountsVale);
                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert_dialog.dismiss();
                    }
                });

                alert_dialog.show();
            }
        });
        vehicleDetailsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
                    Intent intent = new Intent(Motor_vehicle_details.this, OldMotorAddOns.class);
                    str_edt_email=emailIDText.getText().toString();
                    strName=fullNameEdit.getText().toString();
                    strRegisteredAddressEdit=registeredAddressEdit.getText().toString();
                    strPinCodeEditText=PinCodeEditText.getText().toString();
                    strCommunicationAddressEdit=CommunicationAddressEdit.getText().toString();
                    strCommunicationPinCodeEdit=CommunicationPinCodeEdit.getText().toString();
                    strVehicleNo=VehicleNumber.getText().toString();
                    strVehicleChasisNumber=VehicleChasisNumber.getText().toString();
                    strVehicleEngineNumber=VehicleEngineNumber.getText().toString();
                    strNomineeName=NomineeName.getText().toString();
                    strNomineeRelationEdit=NomineeRelationEdit.getText().toString();
                    intent.putExtra("strVehicleNo",strVehicleNo);
                    intent.putExtra("strName",strName);
                    intent.putExtra("strGenderSpinner",strGenderSpinner);
                    intent.putExtra("streditdob",streditdob);
                    intent.putExtra("strIDType",strIDType);
                    intent.putExtra("strIDTypeName",strIDTypeName);
                    intent.putExtra("strIDTypeName1",strIDTypeName1);
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
                    intent.putExtra("strVehicleNumber",strVehicleNumber);
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
                    intent.putExtra("CheckString",CheckString);
                    intent.putExtra("CNGLPGKITODStatus",CNGLPGKITODStatus);
                    intent.putExtra("CNGLPGKITTPStatus",CNGLPGKITTPStatus);
                    intent.putExtra("BUILTINCNGKIT_LPGKITODStatus",BUILTINCNGKIT_LPGKITODStatus);
                    intent.putExtra("BUILTINCNGKIT_LPGKITTPStatus",BUILTINCNGKIT_LPGKITTPStatus);
                    intent.putExtra("MANUFACTURERSELLINGPRICEStatus",MANUFACTURERSELLINGPRICEStatus);
                    intent.putExtra("DRIVINGTRAINPROTECTStatus",DRIVINGTRAINPROTECTStatus);
                    intent.putExtra("AdditionalLegalLiabilityPaidRate",AdditionalLegalLiabilityPaidRate);
                    intent.putExtra("BasicODRateValue",BasicODRateValue);
                    intent.putExtra("BasicTpRateValue",BasicTpRateValue);
                    intent.putExtra("progressChanged",progressChanged);
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
                    intent.putExtra("ChangeAddons",ChangeAddons);
                    intent.putExtra("a",a);
                    intent.putExtra("b",b);
                    intent.putExtra("c",c);
                    intent.putExtra("strFor",strFor);
                    intent.putExtra("strNewFor",strNewFor);
                    intent.putExtra("strVehicleCubicCapicity",strVehicleCubicCapicity);
                    intent.putExtra("strVehicleImage",strVehicleImage);
                    intent.putExtra("strDiscountEdit",strDiscountEdit);
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
                    intent.putExtra("VehicleAgeAdd",VehicleAgeAdd);
                    intent.putExtra("MonthsLeft",MonthsLeft);
                    intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
                    intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
                    intent.putExtra("NCBStatus",NCBStatus);
                    intent.putExtra("ckycNo",ckycNo);
                    intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);
                    finish();
                }
                else {
                    Intent intent = new Intent(Motor_vehicle_details.this, Motor_AddOns.class);
                    str_edt_email=emailIDText.getText().toString();
                    strName=fullNameEdit.getText().toString();
                    strRegisteredAddressEdit=registeredAddressEdit.getText().toString();
                    strPinCodeEditText=PinCodeEditText.getText().toString();
                    strCommunicationAddressEdit=CommunicationAddressEdit.getText().toString();
                    strCommunicationPinCodeEdit=CommunicationPinCodeEdit.getText().toString();
                    strVehicleNo=VehicleNumber.getText().toString();
                    strVehicleChasisNumber=VehicleChasisNumber.getText().toString();
                    strVehicleEngineNumber=VehicleEngineNumber.getText().toString();
                    strNomineeName=NomineeName.getText().toString();
                    strNomineeRelationEdit=NomineeRelationEdit.getText().toString();
                    intent.putExtra("strVehicleNo",strVehicleNo);
                    intent.putExtra("strName",strName);
                    intent.putExtra("strGenderSpinner",strGenderSpinner);
                    intent.putExtra("streditdob",streditdob);
                    intent.putExtra("strIDType",strIDType);
                    intent.putExtra("strIDTypeName",strIDTypeName);
                    intent.putExtra("strIDTypeName1",strIDTypeName1);
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
                    intent.putExtra("strVehicleNumber",strVehicleNumber);
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
                    intent.putExtra("CheckString",CheckString);
                    intent.putExtra("CNGLPGKITODStatus",CNGLPGKITODStatus);
                    intent.putExtra("CNGLPGKITTPStatus",CNGLPGKITTPStatus);
                    intent.putExtra("BUILTINCNGKIT_LPGKITODStatus",BUILTINCNGKIT_LPGKITODStatus);
                    intent.putExtra("BUILTINCNGKIT_LPGKITTPStatus",BUILTINCNGKIT_LPGKITTPStatus);
                    intent.putExtra("MANUFACTURERSELLINGPRICEStatus",MANUFACTURERSELLINGPRICEStatus);
                    intent.putExtra("DRIVINGTRAINPROTECTStatus",DRIVINGTRAINPROTECTStatus);
                    intent.putExtra("AdditionalLegalLiabilityPaidRate",AdditionalLegalLiabilityPaidRate);
                    intent.putExtra("BasicODRateValue",BasicODRateValue);
                    intent.putExtra("BasicTpRateValue",BasicTpRateValue);
                    intent.putExtra("progressChanged",progressChanged);
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
                    intent.putExtra("ChangeAddons",ChangeAddons);
                    intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
                    intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
                    intent.putExtra("NCBStatus",NCBStatus);
                    intent.putExtra("a",a);
                    intent.putExtra("b",b);
                    intent.putExtra("c",c);
                    intent.putExtra("VehicleAgeAdd",VehicleAgeAdd);
                    intent.putExtra("MonthsLeft",MonthsLeft);
                    intent.putExtra("strFor",strFor);
                    intent.putExtra("strNewFor",strNewFor);
                    intent.putExtra("strVehicleCubicCapicity",strVehicleCubicCapicity);
                    intent.putExtra("strVehicleImage",strVehicleImage);
                    intent.putExtra("strDiscountEdit",strDiscountEdit);
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
                    intent.putExtra("StrNCB",StrNCB);
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
                    intent.putExtra("selectYear",selectYear);
                    intent.putExtra("daysLeft",daysLeft);
                    intent.putExtra("VehicleAgeAdd",VehicleAgeAdd);
                    intent.putExtra("MonthsLeft",MonthsLeft);
                    intent.putExtra("ckycNo",ckycNo);
                    intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);
                    finish();
                }
            }
        });
        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_edt_email=emailIDText.getText().toString();
                str_edt_phone=edt_phoneNumber.getText().toString();
                strName=fullNameEdit.getText().toString();
                strRegisteredAddressEdit=registeredAddressEdit.getText().toString();
                strPinCodeEditText=PinCodeEditText.getText().toString();
                strCommunicationAddressEdit=CommunicationAddressEdit.getText().toString();
                strCommunicationPinCodeEdit=CommunicationPinCodeEdit.getText().toString();
                strVehicleNo=VehicleNumber.getText().toString();
                strVehicleChasisNumber=VehicleChasisNumber.getText().toString();
                strVehicleEngineNumber=VehicleEngineNumber.getText().toString();
                strNomineeName=NomineeName.getText().toString();
                strNomineeRelationEdit=NomineeRelationEdit.getText().toString();
                streditdob = edt_Dob.getText().toString();
                strIDNumberEdit = IDNumberEdit_motor.getText().toString();
                strIDTypeName=edt_IdType_motor.getText().toString();
                if (str_edt_phone.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Please Select DOB", Toast.LENGTH_SHORT).show();
                }else if (edt_phoneNumber.getText().toString().length()<10){
                    Toast.makeText(Motor_vehicle_details.this, "Please Enter 10 digits Mobile Number", Toast.LENGTH_SHORT).show();
                }else if (streditdob.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Please Select DOB", Toast.LENGTH_SHORT).show();
                }else if (streditdob.equals("Select DOB")){
                    Toast.makeText(Motor_vehicle_details.this, "Please Select DOB", Toast.LENGTH_SHORT).show();
                }else if (strIDTypeName.equals("Select ID Type")){
                    Toast.makeText(Motor_vehicle_details.this, "Select ID Type", Toast.LENGTH_SHORT).show();
                }else if (strIDNumberEdit.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Enter ID Number", Toast.LENGTH_SHORT).show();
                }else if (ckycNo.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Please Complete your CKYC", Toast.LENGTH_SHORT).show();
                }else if (strTitleEdit.equals("Select Title")){
                    Toast.makeText(Motor_vehicle_details.this, "Select Title", Toast.LENGTH_SHORT).show();
                }else if (strName.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }else if (str_edt_email.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }else if (emailIDText.getText().toString().length() == 0) {
                    emailIDText.setFocusableInTouchMode(true);
                    emailIDText.setCursorVisible(true);
                    emailIDText.requestFocus();
                    Toast.makeText(Motor_vehicle_details.this, "Email is mandatory.", Toast.LENGTH_SHORT).show();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(emailIDText.getText().toString()).matches()) {
                    emailIDText.setFocusableInTouchMode(true);
                    emailIDText.setCursorVisible(true);
                    emailIDText.requestFocus();
                    Toast.makeText(Motor_vehicle_details.this, "Email address is not valid.", Toast.LENGTH_SHORT).show();
                } else if (strRegisteredAddressEdit.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Enter Vehicle Registered address ", Toast.LENGTH_SHORT).show();
                }else if (strPinCodeEditText.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Enter PinCode", Toast.LENGTH_SHORT).show();
                }else if (strPinCodeEditText.length()!=6){
                    Toast.makeText(Motor_vehicle_details.this, "Enter Valid PinCode", Toast.LENGTH_SHORT).show();
                }else if (!strPinCodeEditText.matches(PinCodeRegex)){
                    Toast.makeText(Motor_vehicle_details.this, "Enter Valid PinCode", Toast.LENGTH_SHORT).show();
                    PinCodeEditText.setText("");
                }else if (strStateRegisterAddressEdit.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Select Registered State", Toast.LENGTH_SHORT).show();
                }else if (strCityRegisterEdit.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Select Registered City", Toast.LENGTH_SHORT).show();
                }else if (strCommunicationAddressEdit.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Enter Vehicle Communication address ", Toast.LENGTH_SHORT).show();
                }else if (strCommunicationPinCodeEdit.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Enter PinCode", Toast.LENGTH_SHORT).show();
                }else if (strCommunicationPinCodeEdit.length()!=6){
                    Toast.makeText(Motor_vehicle_details.this, "Enter Valid PinCode", Toast.LENGTH_SHORT).show();
                }else if (!strCommunicationPinCodeEdit.matches(PinCodeRegex)){
                    Toast.makeText(Motor_vehicle_details.this, "Enter Valid PinCode", Toast.LENGTH_SHORT).show();
                    CommunicationPinCodeEdit.setText("");
                }else if(strStateCommunicationEdit.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Select Communication State", Toast.LENGTH_SHORT).show();
                }else if (strCityCommunicationEdit.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Select Communication City", Toast.LENGTH_SHORT).show();
                } else if  (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
                    if (strVehicleNo.equals("")){
                        Toast.makeText(Motor_vehicle_details.this, "Enter Vehicle Number. ", Toast.LENGTH_SHORT).show();
                    }else if (strVehicleNo.length()<9){
                        Toast.makeText(Motor_vehicle_details.this, "Enter Valid Vehicle Number. ", Toast.LENGTH_SHORT).show();
                    }else if (strVehicleChasisNumber.equals("")){
                        Toast.makeText(Motor_vehicle_details.this, "Enter Vehicle Chassis Number", Toast.LENGTH_SHORT).show();
                    }else if (strVehicleChasisNumber.length()<5){
                        Toast.makeText(Motor_vehicle_details.this, "Enter Minimum 5 digits Chassis Number", Toast.LENGTH_SHORT).show();
                    } else if (strVehicleEngineNumber.equals("")){
                        Toast.makeText(Motor_vehicle_details.this, "Enter Vehicle Engine Number", Toast.LENGTH_SHORT).show();
                    }else if (!(strVehicleNo.equals("")||strVehicleNo.equals("New"))){
                        if (strVehicleNo.length()<9){
                            Toast.makeText(Motor_vehicle_details.this, "Enter Valid Vehicle Number. ", Toast.LENGTH_SHORT).show();
                        } else if (strCoverageType.equals("Individual")) {
                            if (strDrivingLicence.equals("Yes")){
                                if (strPACover.equals("No") && strGPACover.equals("No")) {
                                    if (strNomineeName.equals("")) {
                                        Toast.makeText(Motor_vehicle_details.this, "Enter Nominee Name", Toast.LENGTH_SHORT).show();
                                    } else if (strNomineeRelationEdit.equals("")) {
                                        Toast.makeText(Motor_vehicle_details.this, "Enter Nominee RelationShip", Toast.LENGTH_SHORT).show();
                                    }
                                    else if (!CheckedTermCondition.isChecked()) {
                                        Toast.makeText(Motor_vehicle_details.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        elseNext();
                                    }
                                }

                            }
                            else if (!CheckedTermCondition.isChecked()){
                                Toast.makeText(Motor_vehicle_details.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                elseNext();
                            }
                        }
                        else if (!CheckedTermCondition.isChecked()){
                            Toast.makeText(Motor_vehicle_details.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                        } else{
                            elseNext();
                        }
                    }
//                  else if (VehicleEngineNumber.length()<5){
//                        Toast.makeText(Motor_vehicle_details.this, "Enter Valid Vehicle Engine Number", Toast.LENGTH_SHORT).show();
//                    }
                    else if (VehicleEngineNumber.getText().toString().equals(VehicleChasisNumber.getText().toString())){
                        Toast.makeText(Motor_vehicle_details.this, "Please Enter Valid Chassis num. or Vehicle Engine Num.", Toast.LENGTH_SHORT).show();
                    }else if (strCoverageType.equals("Individual")) {
                        if (strDrivingLicence.equals("Yes")) {
                            if (strPACover.equals("No") && strGPACover.equals("No")) {
                                if (strNomineeName.equals("")) {
                                    Toast.makeText(Motor_vehicle_details.this, "Enter Nominee Name", Toast.LENGTH_SHORT).show();
                                } else if (strNomineeRelationEdit.equals("")) {
                                    Toast.makeText(Motor_vehicle_details.this, "Enter Nominee RelationShip", Toast.LENGTH_SHORT).show();
                                } else if (!CheckedTermCondition.isChecked()) {
                                    Toast.makeText(Motor_vehicle_details.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                                } else {
                                    elseNext();
                                }
                            }

                        } else if (!CheckedTermCondition.isChecked()) {
                            Toast.makeText(Motor_vehicle_details.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                        } else {
                            elseNext();
                        }
                    }
//                  else if (!(strVehicleNo.equals("Vehicle Number: NA")||strVehicleNo.equals("NA")||strVehicleNo.equals("")||strVehicleNo.equals("New"))) {
//                      if (strVehicleNo.length()<9){
//                          Toast.makeText(Motor_vehicle_details.this, "Enter Valid Vehicle Number. ", Toast.LENGTH_SHORT).show();
//                      }
//                      else if (strCoverageType.equals("Individual")) {
//                          if (strDrivingLicence.equals("Yes")){
//                              if (strPACover.equals("No") && strGPACover.equals("No")) {
//                                  if (strNomineeName.equals("")) {
//                                      Toast.makeText(Motor_vehicle_details.this, "Enter Nominee Name", Toast.LENGTH_SHORT).show();
//                                  } else if (strNomineeRelationEdit.equals("")) {
//                                      Toast.makeText(Motor_vehicle_details.this, "Enter Nominee RelationShip", Toast.LENGTH_SHORT).show();
//                                  }
//                                  else if (!CheckedTermCondition.isChecked()) {
//                                      Toast.makeText(Motor_vehicle_details.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
//                                  }
//                                  else {
//                                      elseNext();
//                                  }
//                              }
//
//                          }
//                          else if (!CheckedTermCondition.isChecked()){
//                              Toast.makeText(Motor_vehicle_details.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
//                          }
//                          else{
//                              elseNext();
//                          }
//                      }
//                  }
                }
                else if (strVehicleChasisNumber.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Enter Vehicle Chassis Number", Toast.LENGTH_SHORT).show();
                }else if (strVehicleChasisNumber.length()<17){
                    Toast.makeText(Motor_vehicle_details.this, "Enter Minimum 17 digits Chassis Number", Toast.LENGTH_SHORT).show();
                } else if (strVehicleEngineNumber.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Enter Vehicle Engine Number", Toast.LENGTH_SHORT).show();
                }
//                else if (VehicleEngineNumber.length()<17){
//                    Toast.makeText(Motor_vehicle_details.this, "Enter Valid Vehicle Engine Number", Toast.LENGTH_SHORT).show();
//                }
                else if (VehicleEngineNumber.getText().toString().equals(VehicleChasisNumber.getText().toString())){
                    Toast.makeText(Motor_vehicle_details.this, "Please Enter Valid Chassis num. or Vehicle Engine Num.", Toast.LENGTH_SHORT).show();
                }else if (strCoverageType.equals("Individual")){
                    if (strDrivingLicence.equals("Yes")){
                        if (strPACover.equals("No") && strGPACover.equals("No")) {
                            if (strNomineeName.equals("")) {
                                Toast.makeText(Motor_vehicle_details.this, "Enter Nominee Name", Toast.LENGTH_SHORT).show();
                            } else if (strNomineeRelationEdit.equals("")) {
                                Toast.makeText(Motor_vehicle_details.this, "Enter Nominee RelationShip", Toast.LENGTH_SHORT).show();
                            }
                            else if (!CheckedTermCondition.isChecked()) {
                                Toast.makeText(Motor_vehicle_details.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                elseNext();
                            }
                        }

                    }
                    else if (!CheckedTermCondition.isChecked()){
                        Toast.makeText(Motor_vehicle_details.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    } else{
                        elseNext();
                    }
                }else if (!CheckedTermCondition.isChecked()){
                    Toast.makeText(Motor_vehicle_details.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                }else{
                    elseNext();
                }
            }
        });
    }
    private void pincodeURL() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("pincode", strPinCodeEditText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_vehicle_details.this, object, UrlHealthConstants.GetStateCity_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    if (Tag == RequestHealthConstants.GetCity) {
                        try {
                            strCityRegisterEdit = object.getString("CityName");
                            strStateRegisterAddressEdit = object.getString("StateName");
                            CityRegisterEdit.setText(strCityRegisterEdit);
                            StateRegisterAddressEdit.setText(strStateRegisterAddressEdit);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Toast.makeText(getApplication(), "PinCode is Wrong " + object.optString("Message"), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) {
            }
        }, RequestHealthConstants.GetCity);
        req.execute();

    }
    private void pincodeSecondURL() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("pincode", strCommunicationPinCodeEdit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_vehicle_details.this, object, UrlHealthConstants.GetStateCity_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    if (Tag == RequestHealthConstants.GetCity) {
                        try {
                            strCityCommunicationEdit = object.getString("CityName");
                            strStateCommunicationEdit = object.getString("StateName");
                            CityCommunicationEdit.setText(strCityCommunicationEdit);
                            StateCommunicationEdit.setText(strStateCommunicationEdit);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Toast.makeText(getApplication(), "PinCode is Wrong " + object.optString("Message"), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) {
            }
        }, RequestHealthConstants.GetCity);
        req.execute();

    }
    private void CKYCMethod() {
        uniqueTransactionNumber="ONLINE/261122/"+strIDTypeName1+strIDNumberEdit+strEditdobString;
        strIDNumberEdit = IDNumberEdit_motor.getText().toString();
        if (str_edt_phone.equals("")){
            Toast.makeText(Motor_vehicle_details.this, "Please Select DOB", Toast.LENGTH_SHORT).show();
        }else if (edt_phoneNumber.getText().toString().length()<10){
            Toast.makeText(Motor_vehicle_details.this, "Please Enter 10 digits Mobile Number", Toast.LENGTH_SHORT).show();
        }else if (streditdob.equals("")){
            Toast.makeText(Motor_vehicle_details.this, "Please Select DOB", Toast.LENGTH_SHORT).show();
        }else if (strIDTypeName.equals("Select ID Type")){
            Toast.makeText(Motor_vehicle_details.this, "Select ID Type", Toast.LENGTH_SHORT).show();
        }else if (strIDNumberEdit.equals("")){
            Toast.makeText(Motor_vehicle_details.this, "Enter ID Number", Toast.LENGTH_SHORT).show();
        }else if (strIDTypeName.equals("PAN Card")){
            if (!strIDNumberEdit.matches(PanExpression)){
                Toast.makeText(Motor_vehicle_details.this, "Enter Valid PAN Card Number", Toast.LENGTH_SHORT).show();
            }else{
                CKYURL();
                customprogress.showProgressBar();
            }
        }else if (strIDTypeName.equals("Voter ID")){
            if (!strIDNumberEdit.matches(VoterIDExpression)){
                Toast.makeText(Motor_vehicle_details.this, "Enter Valid Voter ID Number", Toast.LENGTH_SHORT).show();
            }else{
                CKYURL();
                customprogress.showProgressBar();
            }
        }else if (strIDTypeName.equals("Passport")){
            if (!strIDNumberEdit.matches(PassportExpression)){
                Toast.makeText(Motor_vehicle_details.this, "Enter Valid Passport Number", Toast.LENGTH_SHORT).show();
            }else{
                CKYURL();
                customprogress.showProgressBar();
            }
        }else if (strIDTypeName.equals("Driving Licence")){
            if (!strIDNumberEdit.matches(DrivingExpression)){
                Toast.makeText(Motor_vehicle_details.this, "Enter Valid Driving Licence Number", Toast.LENGTH_SHORT).show();
            }else{
                CKYURL();
                customprogress.showProgressBar();
            }
        }else if (strIDTypeName.equals("Reference Number")){

            if (!strIDNumberEdit.contains("/")){
                Toast.makeText(Motor_vehicle_details.this, "Reference Number should be (xxxx/xxxx/xxxx)", Toast.LENGTH_SHORT).show();
            }else {
                ResultStatusURL();
            }
        }
    }
    private void CKYURL() {
        uniqueTransactionNumber="ONLINE/261122/"+strIDTypeName1+strIDNumberEdit+strEditdobString;
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
                        streditdob = objectResult.getString("dob");
                        String firstName = objectResult.getString("firstName");
                        String middleName = objectResult.getString("middleName");
                        String lastName = objectResult.getString("lastName");
                        String dob = objectResult.getString("dob");
                        String address1 = objectResult.getString("address1");
                        String address2 = objectResult.getString("address2");
                        String address3 = objectResult.getString("address3");
                        strCityRegisterEdit = objectResult.getString("city");
                        String district = objectResult.getString("district");
                        strStateRegisterAddressEdit = objectResult.getString("state");
                        String country= objectResult.getString("country");
                        strPinCodeEditText = objectResult.getString("pincode");
                        String corresAddress1 = objectResult.getString("corresAddress1");
                        String corresAddress2 = objectResult.getString("corresAddress2");
                        String corresAddress3 = objectResult.getString("corresAddress3");
                        String corresCity = objectResult.getString("corresCity");
                        String corresDist = objectResult.getString("corresDist");
                        strStateCommunicationEdit = objectResult.getString("corresState");
                        String corresCountry = objectResult.getString("corresCountry");
                        strCommunicationPinCodeEdit = objectResult.getString("corresPin");
                        String aadhaar = objectResult.getString("aadhaar");
                        String pan = objectResult.getString("pan");
                        str_edt_email = objectResult.getString("email");
                        String mobileNumber = objectResult.getString("mobileNumber");
                        String permAndCorresAddSame = objectResult.getString("permAndCorresAddSame");

                        Dialog KYCDialog = new Dialog(Motor_vehicle_details.this);
                        KYCDialog.setCanceledOnTouchOutside(false);
                        KYCDialog.setCancelable(false);
                        KYCDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        Objects.requireNonNull(KYCDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                        KYCDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                        KYCDialog.setContentView(R.layout.ckyc_done_alert);
                        ImageView cutImg;
                        TextView TextViewLink;
                        LinearLayout continueButtonPopup;
                        cutImg = KYCDialog.findViewById(R.id.cutImg);
                        TextViewLink = KYCDialog.findViewById(R.id.TextViewLink);
                        continueButtonPopup = KYCDialog.findViewById(R.id.continueButtonPopup);
                        KYCDialog.show();
                        cutImg.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                KYCDialog.dismiss();
                            }
                        });

                        continueButtonPopup.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                strName=firstName+" "+middleName+" "+lastName;
                                fullNameEdit.setText(strName);
                                PinCodeEditText.setText(strPinCodeEditText);
                                StateRegisterAddressEdit.setText(strStateRegisterAddressEdit);
                                CityRegisterEdit.setText(strCityRegisterEdit);
                                emailIDText.setText(str_edt_email);
                                strRegisteredAddressEdit=address1+" "+address2+" "+address3;
                                registeredAddressEdit.setText(strRegisteredAddressEdit);
                                strCommunicationAddressEdit=corresAddress1+" "+corresAddress2+" "+corresAddress3;
                                CommunicationAddressEdit.setText(strCommunicationAddressEdit);
                                CommunicationPinCodeEdit.setText(strCommunicationPinCodeEdit);
                                StateCommunicationEdit.setText(strStateCommunicationEdit);
                                CityCommunicationEdit.setText(strCityCommunicationEdit);

                                fullNameEdit.setClickable(false);
                                fullNameEdit.setEnabled(false);
                                fullNameEdit.setFocusable(false);

                                emailIDText.setClickable(false);
                                emailIDText.setEnabled(false);
                                emailIDText.setFocusable(false);

                                registeredAddressEdit.setClickable(false);
                                registeredAddressEdit.setEnabled(false);
                                registeredAddressEdit.setFocusable(false);

                                PinCodeEditText.setClickable(false);
                                PinCodeEditText.setEnabled(false);
                                PinCodeEditText.setFocusable(false);

                                StateRegisterAddressEdit.setClickable(false);
                                StateRegisterAddressEdit.setEnabled(false);
                                StateRegisterAddressEdit.setFocusable(false);

                                CityRegisterEdit.setClickable(false);
                                CityRegisterEdit.setEnabled(false);
                                CityRegisterEdit.setFocusable(false);

                                CommunicationAddressEdit.setClickable(false);
                                CommunicationAddressEdit.setEnabled(false);
                                CommunicationAddressEdit.setFocusable(false);

                                CommunicationPinCodeEdit.setClickable(false);
                                CommunicationPinCodeEdit.setEnabled(false);
                                CommunicationPinCodeEdit.setFocusable(false);

                                StateCommunicationEdit.setClickable(false);
                                StateCommunicationEdit.setEnabled(false);
                                StateCommunicationEdit.setFocusable(false);

                                CityCommunicationEdit.setClickable(false);
                                CityCommunicationEdit.setEnabled(false);
                                CityCommunicationEdit.setFocusable(false);
                                strCheckboxCommunication="true";
                                CheckboxCommunication.setChecked(true);


                                KYCDialog.dismiss();
                            }
                        });



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    try {
                        JSONObject error1=response.getJSONObject("error");
                        String message = error1.getString("message");
                        if (message.equals("source is not configured in system so please connect with system administrator")){
                            Toast.makeText(Motor_vehicle_details.this, message, Toast.LENGTH_SHORT).show();
                        }else{
                            JSONObject object1=response.getJSONObject("result");
                            String manualKYCurl_intent = object1.getString("manualKYCurl");
                            Log.e("manualKYCurl1",manualKYCurl_intent);
                            EmailConsumeAPI();
                            SMSConsumeAPI();
                            final Dialog alert_dialog1 = new Dialog(Motor_vehicle_details.this);
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
                Toast.makeText(Motor_vehicle_details.this, "" +error, Toast.LENGTH_SHORT).show();
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
        ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_vehicle_details.this, object, UrlHealthConstants.ResultStatusAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("status").equals("success")) {
                    try {
                        JSONObject objectResult = object.getJSONObject("result");
                        String idNo = objectResult.getString("idNo");
                        ckycNo = objectResult.getString("ckycNo");
                        strName= objectResult.getString("name");
                        streditdob = objectResult.getString("dob");
                        strRegisteredAddressEdit = objectResult.getString("address");
                        strPinCodeEditText= objectResult.getString("pincode");
                        String maskedAadhaarNumber = objectResult.getString("maskedAadhaarNumber");
                        String pan = objectResult.getString("pan");
                        String email = objectResult.getString("email");
                        String mobileNumber = objectResult.getString("mobileNumber");
                        String uploadedDocument = objectResult.getString("uploadedDocument");
                        String capturedLiveFace = objectResult.getString("capturedLiveFace");
                        String kycVerifiedStatus = objectResult.getString("kycVerifiedStatus");
                        String kycVerifiedDate = objectResult.getString("kycVerifiedDate");

                        if (kycVerifiedStatus.equals("True")){
                            fullNameEdit.setText(strName);
                            registeredAddressEdit.setText(strRegisteredAddressEdit);
                            PinCodeEditText.setText(strPinCodeEditText);

                            fullNameEdit.setClickable(false);
                            fullNameEdit.setEnabled(false);
                            fullNameEdit.setFocusable(false);

                            registeredAddressEdit.setClickable(false);
                            registeredAddressEdit.setEnabled(false);
                            registeredAddressEdit.setFocusable(false);

                            PinCodeEditText.setClickable(false);
                            PinCodeEditText.setEnabled(false);
                            PinCodeEditText.setFocusable(false);

                            pincodeURL();
                        }else{
                            Toast.makeText(Motor_vehicle_details.this, "You KYC Verification not completed yet Please wait...", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(Motor_vehicle_details.this, ""+message, Toast.LENGTH_SHORT).show();
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
        ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_vehicle_details.this, object, UrlHealthConstants.EmailConsumeAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("status").equals("true")) {
                    String message =object.optString("message");
                    Toast.makeText(Motor_vehicle_details.this, ""+message, Toast.LENGTH_SHORT).show();
                }
                else {
                    String message =object.optString("message");
                    Toast.makeText(Motor_vehicle_details.this, ""+message, Toast.LENGTH_SHORT).show();
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
        ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_vehicle_details.this, object, UrlHealthConstants.SMSConsumeAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    String message =object.optString("Message");
                    Toast.makeText(Motor_vehicle_details.this, ""+message, Toast.LENGTH_SHORT).show();
                }
                else {
                    String message =object.optString("Message");
                    Toast.makeText(Motor_vehicle_details.this, ""+message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }

        }, RequestHealthConstants.RevisedCHISMS);
        req.execute();
    }
    private void elseNext() {
        Intent intent = new Intent(Motor_vehicle_details.this, Motor_summery.class);
        intent.putExtra("strBreaking", strBreaking);
        intent.putExtra("previousDate", previousDate);
        intent.putExtra("strVehicleNo", strVehicleNo);
        intent.putExtra("strGenderSpinner",strGenderSpinner);
        intent.putExtra("streditdob",streditdob);
        intent.putExtra("strIDType",strIDType);
        intent.putExtra("strIDTypeName",strIDTypeName);
        intent.putExtra("strIDTypeName1",strIDTypeName1);
        intent.putExtra("strIDNumberEdit",strIDNumberEdit);
        intent.putExtra("strName", strName);
        intent.putExtra("str_edt_city", str_edt_city);
        intent.putExtra("str_edt_phone", str_edt_phone);
        intent.putExtra("str_edt_email", str_edt_email);
        intent.putExtra("strPolicyRadio", strPolicyRadio);
        intent.putExtra("strVehicleTypeRadio", strVehicleTypeRadio);
        intent.putExtra("strVehicleRadio", strVehicleRadio);
        intent.putExtra("str_vehicleManufacturerNm", str_vehicleManufacturerNm);
        intent.putExtra("strVehicleModel", strVehicleModel);
        intent.putExtra("str_edt_registration_date", str_edt_registration_date);
        intent.putExtra("strStateName", strStateName);
        intent.putExtra("strStateRegisterCode", strStateRegisterCode);
        intent.putExtra("strRTOName", strRTOName);
        intent.putExtra("strPolicyNumberEdit", strPolicyNumberEdit);
        intent.putExtra("strPlanType", strPlanType);
        intent.putExtra("strPlanYear", strPlanYear);
        intent.putExtra("strCoverageType", strCoverageType);
        intent.putExtra("strPACover", strPACover);
        intent.putExtra("strGPACover", strGPACover);
        intent.putExtra("strDrivingLicence", strDrivingLicence);
        intent.putExtra("strTitleEdit", strTitleEdit);
        intent.putExtra("strRegisteredAddressEdit", strRegisteredAddressEdit);
        intent.putExtra("strPinCodeEditText", strPinCodeEditText);
        intent.putExtra("strStateRegisterAddressEdit", strStateRegisterAddressEdit);
        intent.putExtra("strCityRegisterEdit", strCityRegisterEdit);
        intent.putExtra("strCommunicationAddressEdit", strCommunicationAddressEdit);
        intent.putExtra("strCommunicationPinCodeEdit", strCommunicationPinCodeEdit);
        intent.putExtra("strStateCommunicationEdit", strStateCommunicationEdit);
        intent.putExtra("strCityCommunicationEdit", strCityCommunicationEdit);
        intent.putExtra("strVehicleChasisNumber", strVehicleChasisNumber);
        intent.putExtra("strVehicleEngineNumber", strVehicleEngineNumber);
        intent.putExtra("strCheckedTermCondition", strCheckedTermCondition);
        intent.putExtra("strCheckboxCommunication", strCheckboxCommunication);
        intent.putExtra("strCityRegisterCode", strCityRegisterCode);
        intent.putExtra("strCityCommunicationCode", strCityCommunicationCode);
        intent.putExtra("TotalValue", TotalValue);
        intent.putExtra("NetPremiumValue", NetPremiumValue);
        intent.putExtra("PosPolicyNo", PosPolicyNo);
        intent.putExtra("GST", GST);
        intent.putExtra("strIdvValueTxt", strIdvValueTxt);
        intent.putExtra("strIdvValueTxt", strIdvValueTxt);
        intent.putExtra("strLessIDVText", strLessIDVText);
        intent.putExtra("strHighIDVText", strHighIDVText);
        intent.putExtra("yearOfManufacture", yearOfManufacture);
        intent.putExtra("yearOfManufactureMonth",yearOfManufactureMonth);
        intent.putExtra("strSelectDateYear",strSelectDateYear);
        intent.putExtra("strVehicleAge", strVehicleAge);
        intent.putExtra("strVehicleManufacturerCode", strVehicleManufacturerCode);
        intent.putExtra("strRTOCode", strRTOCode);
        intent.putExtra("strVehicleModelCode", strVehicleModelCode);
        intent.putExtra("BasicODStatus", BasicODStatus);
        intent.putExtra("BasicTP", BasicTP);
        intent.putExtra("ELECTRICALACCESSORYODStatus", ELECTRICALACCESSORYODStatus);
        intent.putExtra("FIBERTANKODStatus", FIBERTANKODStatus);
        intent.putExtra("LEGALLIABILITYTOPAIDDRIVERStatus", LEGALLIABILITYTOPAIDDRIVERStatus);
        intent.putExtra("NONELECTRICALACCESSORYODStatus", NONELECTRICALACCESSORYODStatus);
        intent.putExtra("OtherODStatus", OtherODStatus);
        intent.putExtra("OtherTpStatus", OtherTpStatus);
        intent.putExtra("PACOVERTOEMPLOYEESOFINSUREDStatus", PACOVERTOEMPLOYEESOFINSUREDStatus);
        intent.putExtra("PACOVERTOOWNERDRIVERStatus", PACOVERTOOWNERDRIVERStatus);
        intent.putExtra("PACOVERTOPAIDDRIVERStatus", PACOVERTOPAIDDRIVERStatus);
        intent.putExtra("PACOVERTOPASSENGERSStatus", PACOVERTOPASSENGERSStatus);
        intent.putExtra("UNNAMEDPACOVERTOPASSENGERSStatus", UNNAMEDPACOVERTOPASSENGERSStatus);
        intent.putExtra("ACCIDENTALHOSPITALIZATIONStatus", ACCIDENTALHOSPITALIZATIONStatus);
        intent.putExtra("COSTOFCONSUMABLESStatus", COSTOFCONSUMABLESStatus);
        intent.putExtra("DAILYCASHALLOWANCEMETROStatus", DAILYCASHALLOWANCEMETROStatus);
        intent.putExtra("DAILYCASHALLOWANCENONMETROStatus", DAILYCASHALLOWANCENONMETROStatus);
        intent.putExtra("ENGINEPROTECTORDIESELStatus", ENGINEPROTECTORDIESELStatus);
        intent.putExtra("ENGINEPROTECTORPETROLStatus", ENGINEPROTECTORPETROLStatus);
        intent.putExtra("HYDROSTATICLOCKCOVERStatus", HYDROSTATICLOCKCOVERStatus);
        intent.putExtra("KEYREPLACEMENTStatus", KEYREPLACEMENTStatus);
        intent.putExtra("NilDepreciationWaivercoverStatus", NilDepreciationWaivercoverStatus);
        intent.putExtra("RETURNTOINVOICEStatus", RETURNTOINVOICEStatus);
        intent.putExtra("RoadsideAssistanceStatus", RoadsideAssistanceStatus);
        intent.putExtra("SECURETOWINGStatus", SECURETOWINGStatus);
        intent.putExtra("TyreandRimsecureStatus", TyreandRimsecureStatus);
        intent.putExtra("VehicleExShowroomPrice", VehicleExShowroomPrice);
        intent.putExtra("tomorrowDate", tomorrowDate);
        intent.putExtra("NCB", NCB);
        intent.putExtra("addOns", addOns);
        intent.putExtra("VehicleClassCode", VehicleClassCode);
        intent.putExtra("ProductCode", ProductCode);
        intent.putExtra("ProductName", ProductName);
        intent.putExtra("strClaimBonus", strClaimBonus);
        intent.putExtra("strEndDateEdit", strEndDateEdit);
        intent.putExtra("StrPreviousPolicyRadio", StrPreviousPolicyRadio);
        intent.putExtra("VEHICLECLASSCODE", VEHICLECLASSCODE);
        intent.putExtra("strVehicleChasisNumber", strVehicleChasisNumber);
        intent.putExtra("strVehicleEngineNumber", strVehicleEngineNumber);
        intent.putExtra("rc_fuel_desc", rc_fuel_desc);
        intent.putExtra("rc_cubic_cap", rc_cubic_cap);
        intent.putExtra("FuleType", FuleType);
        intent.putExtra("strCompanyName", strCompanyName);
        intent.putExtra("strODPlanFromDateEdit", strODPlanFromDateEdit);
        intent.putExtra("strODPlanEndDateEdit", strODPlanEndDateEdit);
        intent.putExtra("strTpPlanFromDateEdit", strTpPlanFromDateEdit);
        intent.putExtra("strTpPlanEndDateEdit", strTpPlanEndDateEdit);
        intent.putExtra("nextYear", nextYear);
        intent.putExtra("StrPrev_Policy_Type", StrPrev_Policy_Type);
        intent.putExtra("vehicleManufacturerType", vehicleManufacturerType);
        intent.putExtra("strModelType", strModelType);
        intent.putExtra("addOnsCover", addOnsCover);
        intent.putExtra("addOnsAditional", addOnsAditional);
        intent.putExtra("SeekbarStatus", SeekbarStatus);
        intent.putExtra("StrAdditionalCoverPremiumOD", StrAdditionalCoverPremiumOD);
        intent.putExtra("StrAdditionalCoverPremiumTp", StrAdditionalCoverPremiumTp);
        intent.putExtra("strPreviousClaimRadio", strPreviousClaimRadio);
        intent.putExtra("strNomineeName", strNomineeName);
        intent.putExtra("strNomineeRelationEdit", strNomineeRelationEdit);
        intent.putExtra("AdditionalElectricalRateValue", AdditionalElectricalRateValue);
        intent.putExtra("AdditionalFibertankODRateValue", AdditionalFibertankODRateValue);
        intent.putExtra("AdditionalLegalLiabilityDriverRateValue", AdditionalLegalLiabilityDriverRateValue);
        intent.putExtra("AdditionalNonElecticalODRateValue", AdditionalNonElecticalODRateValue);
        intent.putExtra("AdditionalOtherODRateValue", AdditionalOtherODRateValue);
        intent.putExtra("AdditionalOtherTpRateValue", AdditionalOtherTpRateValue);
        intent.putExtra("AdditionalPaCoversToEmployessRateValue", AdditionalPaCoversToEmployessRateValue);
        intent.putExtra("AdditionalPaCoverToOwnerDriverRateValue", AdditionalPaCoverToOwnerDriverRateValue);
        intent.putExtra("AdditionalPaidDriverRateValue", AdditionalPaidDriverRateValue);
        intent.putExtra("AdditionalPaToPassengersRateValue", AdditionalPaToPassengersRateValue);
        intent.putExtra("AdditionalUnnamedPassengersRateValue", AdditionalUnnamedPassengersRateValue);
        intent.putExtra("AdditionalCngKitODRateValue", AdditionalCngKitODRateValue);
        intent.putExtra("AdditionalCngLpgTpRateValue", AdditionalCngLpgTpRateValue);
        intent.putExtra("AdditionalBuiltinKitODRateValue", AdditionalBuiltinKitODRateValue);
        intent.putExtra("AdditionalBuiltinCngTPRateValue", AdditionalBuiltinCngTPRateValue);
        intent.putExtra("AccidentalRateValue", AccidentalRateValue);
        intent.putExtra("CostOfConsumablesRateValue", CostOfConsumablesRateValue);
        intent.putExtra("dailyCashAllowanceMetroRateValue", dailyCashAllowanceMetroRateValue);
        intent.putExtra("dailyCashAllowanceNonMetroRateValue", dailyCashAllowanceNonMetroRateValue);
        intent.putExtra("EngineProtectorDieselRateValue", EngineProtectorDieselRateValue);
        intent.putExtra("EngineProtectorPetrolRateValue", EngineProtectorPetrolRateValue);
        intent.putExtra("HydrostaticLockRateValue", HydrostaticLockRateValue);
        intent.putExtra("KeyReplacementRateValue", KeyReplacementRateValue);
        intent.putExtra("NilDepreciationRateValue", NilDepreciationRateValue);
        intent.putExtra("ReturnToInvoiceRateValue", ReturnToInvoiceRateValue);
        intent.putExtra("RoadSideAssistanceRateValue", RoadSideAssistanceRateValue);
        intent.putExtra("SecureTowingRateValue", SecureTowingRateValue);
        intent.putExtra("TyreRimsecureRateValue", TyreRimsecureRateValue);
        intent.putExtra("drivingTrainProtectRateValue", drivingTrainProtectRateValue);
        intent.putExtra("ManufacturesellingRateValue", ManufacturesellingRateValue);
        intent.putExtra("CNGLPGKITODStatus", CNGLPGKITODStatus);
        intent.putExtra("CNGLPGKITTPStatus", CNGLPGKITTPStatus);
        intent.putExtra("BUILTINCNGKIT_LPGKITODStatus", BUILTINCNGKIT_LPGKITODStatus);
        intent.putExtra("MANUFACTURERSELLINGPRICEStatus", MANUFACTURERSELLINGPRICEStatus);
        intent.putExtra("DRIVINGTRAINPROTECTStatus", DRIVINGTRAINPROTECTStatus);
        intent.putExtra("AdditionalLegalLiabilityPaidRate", AdditionalLegalLiabilityPaidRate);
        intent.putExtra("BUILTINCNGKIT_LPGKITTPStatus", BUILTINCNGKIT_LPGKITTPStatus);
        intent.putExtra("progressChanged", progressChanged);
        intent.putExtra("BasicODRateValue", BasicODRateValue);
        intent.putExtra("BasicTpRateValue", BasicTpRateValue);
        intent.putExtra("strIdvValueTxtSelect", strIdvValueTxtSelect);
        intent.putExtra("changeseekBar", changeseekBar);
        intent.putExtra("DAILYCASHALLOWANCEStatus", DAILYCASHALLOWANCEStatus);
        intent.putExtra("WRONGFUELCOVERStatus", WRONGFUELCOVERStatus);
        intent.putExtra("DailyCashRateValue", DailyCashRateValue);
        intent.putExtra("WrongFuelRateValue", WrongFuelRateValue);
        intent.putExtra("DetarifficValuePremium", DetarifficValuePremium);
        intent.putExtra("DetarifficValueRate", DetarifficValueRate);
        intent.putExtra("DetarifficLodingValuePremium", DetarifficLodingValuePremium);
        intent.putExtra("DetarifficLoadingValueRate", DetarifficLoadingValueRate);
        intent.putExtra("DetarifficValueSumInsure", DetarifficValueSumInsure);
        intent.putExtra("DetarifficLoadingValueSumInsured", DetarifficLoadingValueSumInsured);
        intent.putExtra("BasicODRateSumInsured", BasicODRateSumInsured);
        intent.putExtra("BasicTpRateSumInsured", BasicTpRateSumInsured);
        intent.putExtra("ELECTRICALCoverSumInsured", ELECTRICALCoverSumInsured);
        intent.putExtra("NONELECTRICALSumInsured", NONELECTRICALSumInsured);
        intent.putExtra("AdditionalFibertankODSumInsuredValue", AdditionalFibertankODSumInsuredValue);
        intent.putExtra("AdditionalLegalLiabilityPaidSumInsured", AdditionalLegalLiabilityPaidSumInsured);
        intent.putExtra("AdditionalOtherODRateSumInsured", AdditionalOtherODRateSumInsured);
        intent.putExtra("AdditionalOtherTpSumInsuredValue", AdditionalOtherTpSumInsuredValue);
        intent.putExtra("AdditionalPaCoverToOwnerDriverSumInsuredValue", AdditionalPaCoverToOwnerDriverSumInsuredValue);
        intent.putExtra("AdditionalPaidDriverSumInsuredValue", AdditionalPaidDriverSumInsuredValue);
        intent.putExtra("AdditionalPaToPassengersSumInsuredValue", AdditionalPaToPassengersSumInsuredValue);
        intent.putExtra("AdditionalUnnamedPassengersSumInsuredValue", AdditionalUnnamedPassengersSumInsuredValue);
        intent.putExtra("AdditionalCngKitODSumInsuredValue", AdditionalCngKitODSumInsuredValue);
        intent.putExtra("AdditionalCngLpgTpSumInsuredValue", AdditionalCngLpgTpSumInsuredValue);
        intent.putExtra("AdditionalBuiltinKitODSumInsuredValue", AdditionalBuiltinKitODSumInsuredValue);
        intent.putExtra("AdditionalBuiltinCngTPSumInsuredValue", AdditionalBuiltinCngTPSumInsuredValue);
        intent.putExtra("DailyCashRateSumInsured", DailyCashRateSumInsured);
        intent.putExtra("AccidentalSumInsuredValue", AccidentalSumInsuredValue);
        intent.putExtra("WrongFuelSumInsuredValue", WrongFuelSumInsuredValue);
        intent.putExtra("CostOfConsumablesSumInsuredValue", CostOfConsumablesSumInsuredValue);
        intent.putExtra("dailyCashAllowanceMetroSumInsuredValue", dailyCashAllowanceMetroSumInsuredValue);
        intent.putExtra("dailyCashAllowanceNonMetroSumInsuredValue", dailyCashAllowanceNonMetroSumInsuredValue);
        intent.putExtra("EngineProtectorDieselSumInsuredValue", EngineProtectorDieselSumInsuredValue);
        intent.putExtra("EngineProtectorPetrolSumInsuredValue", EngineProtectorPetrolSumInsuredValue);
        intent.putExtra("HydrostaticLockSumInsuredValue", HydrostaticLockSumInsuredValue);
        intent.putExtra("KeyReplacementSumInsuredValue", KeyReplacementSumInsuredValue);
        intent.putExtra("NilDepreciationSumInsuredValue", NilDepreciationSumInsuredValue);
        intent.putExtra("ReturnToInvoiceSumInsuredValue", ReturnToInvoiceSumInsuredValue);
        intent.putExtra("RoadSideAssistanceSumInsuredValue", RoadSideAssistanceSumInsuredValue);
        intent.putExtra("SecureTowingSumInsuredValue", SecureTowingSumInsuredValue);
        intent.putExtra("TyreRimsecureSumInsuredValue", TyreRimsecureSumInsuredValue);
        intent.putExtra("drivingTrainProtectSumInsuredValue", drivingTrainProtectSumInsuredValue);
        intent.putExtra("ManufacturesellingSumInsuredValue", ManufacturesellingSumInsuredValue);
        intent.putExtra("a", a);
        intent.putExtra("b", b);
        intent.putExtra("c", c);
        intent.putExtra("CheckString", CheckString);
        intent.putExtra("strStateCode", strStateCode);
        intent.putExtra("strFor", strFor);
        intent.putExtra("strNewFor", strNewFor);
        intent.putExtra("strVehicleCubicCapicity", strVehicleCubicCapicity);
        intent.putExtra("strVehicleImage", strVehicleImage);
        intent.putExtra("ChangeAddons", ChangeAddons);
        intent.putExtra("strDiscountEdit", strDiscountEdit);
        intent.putExtra("StrNCB", StrNCB);
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
        intent.putExtra("selectYear",selectYear);
        intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
        intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
        intent.putExtra("NCBStatus",NCBStatus);
        intent.putExtra("daysLeft",daysLeft);
        intent.putExtra("VehicleAgeAdd",VehicleAgeAdd);
        intent.putExtra("MonthsLeft",MonthsLeft);
        intent.putExtra("ckycNo",ckycNo);
        intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
        startActivity(intent);
        finish();
    }
    private void state() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
        }catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_vehicle_details.this, object, UrlConstants.BUY_VehicleRtoState, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    if (Tag == RequestConstants.BUY_POLICY_MOTOR_PRIVATE_State) {
                        JSONArray arr = null;
                        try {
                            motorStateList.clear();
                            itemsState.clear();
                            arr = object.getJSONArray("StateDetails");
                            for (int i = 0; i <arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(i);
                                motorState = new Gson().fromJson(obj.toString(), MotorState.class);
                                motorStateList.add(motorState);
                            }
                            for(int k=0;k<motorStateList.size();k++){
                                itemsState.add(motorStateList.get(k).getStateName());
                            }

                            if (click.equals("1") ){
                                singlePicker = new MyOptionsPickerView(Motor_vehicle_details.this);
                                singlePicker.setPicker(itemsState);
                                singlePicker.setCyclic(false);
                                singlePicker.setSelectOptions(0);
                                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                                    @Override
                                    public void onOptionsSelect(int options1, int option2, int options3) {
                                        strStateRegisterAddressEdit=motorStateList.get(options1).getStateName();
                                        strStateRegisterCode=motorStateList.get(options1).getStateId();
                                        Log.e("strStateRegisterCode",strStateRegisterCode);
                                        StateRegisterAddressEdit.setText(strStateRegisterAddressEdit);

                                        SelectCityy();
                                        VehicleMasterRtoLocationZoneAPI();
                                        CityRegisterEdit.setText("");
                                    }
                                });
                                singlePicker.show();
                            }else{
                                singlePicker = new MyOptionsPickerView(Motor_vehicle_details.this);
                                singlePicker.setPicker(itemsState);
                                singlePicker.setCyclic(false);
                                singlePicker.setSelectOptions(0);
                                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                                    @Override
                                    public void onOptionsSelect(int options1, int option2, int options3) {
                                        strStateCommunicationEdit=motorStateList.get(options1).getStateName();
                                        strStateCommunicationCode=motorStateList.get(options1).getStateId();
                                        Log.e("strStateCommunicationCode",strStateCommunicationCode);
                                        StateCommunicationEdit.setText(strStateCommunicationEdit);
                                        VehicleMasterRtoLocationZoneAPI();
                                        CityCommunicationEdit.setText("");
                                    }
                                });
                                singlePicker.show();
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
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE_State);
        req.execute();

    }
    private void SelectCityy() {

        CityRegisterSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click="1";
                VehicleMasterRtoLocationZoneAPI();
//                click="1";
//                VehicleMasterRtoLocationZoneAPI();
            }
        });

    }
    private void VehicleMasterRtoLocationZoneAPI() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            if (click.equals("1")){
                object.put("StateCode", strStateRegisterCode);
            }else{
                object.put("StateCode", strStateCommunicationCode);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_vehicle_details.this, object, UrlConstants.BUY_VehicleMasterRtoLocationZone, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    if (Tag == RequestConstants.BUY_POLICY_MOTOR_PRIVATE_RTO) {
                        JSONArray arr = null;
                        try {
                            motorRTOList.clear();
                            itemsRTO.clear();
                            arr = object.getJSONArray("VehicleMasterRtoLocationZone");
                            for (int i = 0; i <arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(i);
                                motorRTOModel = new Gson().fromJson(obj.toString(), MotorRTOModel.class);
                                motorRTOList.add(motorRTOModel);
                            }
                            for(int k=0;k<motorRTOList.size();k++){
                                itemsRTO.add(motorRTOList.get(k).getRTOLOCName());
                            }
                            if (click.equals("1")){
                                singlePicker = new MyOptionsPickerView(Motor_vehicle_details.this);
                                singlePicker.setPicker(itemsRTO);
                                singlePicker.setCyclic(false);
                                singlePicker.setSelectOptions(0);
                                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                                    @Override
                                    public void onOptionsSelect(int options1, int option2, int options3) {
                                        strCityRegisterEdit=motorRTOList.get(options1).getRTOLOCName();
                                        strCityRegisterCode=motorRTOList.get(options1).getRegionCode();
                                        Log.e("strCityRegisterCode",strCityRegisterCode);
                                        CityRegisterEdit.setText(strCityRegisterEdit);
                                    }
                                });
                                singlePicker.show();
                            }else{
                                singlePicker = new MyOptionsPickerView(Motor_vehicle_details.this);
                                singlePicker.setPicker(itemsRTO);
                                singlePicker.setCyclic(false);
                                singlePicker.setSelectOptions(0);
                                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                                    @Override
                                    public void onOptionsSelect(int options1, int option2, int options3) {
                                        strCityCommunicationEdit=motorRTOList.get(options1).getRTOLOCName();
                                        strCityCommunicationCode=motorRTOList.get(options1).getRegionCode();
                                        Log.e("strCityCommunicationCode",strCityCommunicationCode);
                                        CityCommunicationEdit.setText(strCityCommunicationEdit);
                                    }
                                });
                                singlePicker.show();
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
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE_RTO);
        req.execute();
    }
    private void VehicleAllCompanyMaster() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
        }catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_vehicle_details.this, object, UrlConstants.BUYVehicleAllCompany_Master, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    if (Tag == RequestConstants.BUY_POLICY_MOTOR_PRIVATE_Company) {
                        JSONArray arr = null;
                        try {
                            vehicleCompanyList.clear();
                            itemsCompany.clear();
                            arr = object.getJSONArray("ALLCOMPANY");
                            for (int i = 0; i <arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(i);
                                companyModel = new Gson().fromJson(obj.toString(), CompanyModel.class);
                                vehicleCompanyList.add(companyModel);
                            }for(int k=0;k<vehicleCompanyList.size();k++){
                                itemsCompany.add(vehicleCompanyList.get(k).getCOMPANYNAME());
                            }
                            singlePicker = new MyOptionsPickerView(Motor_vehicle_details.this);
                            singlePicker.setPicker(itemsCompany);
                            singlePicker.setCyclic(false);
                            singlePicker.setSelectOptions(0);
                            singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int option2, int options3) {
                                    strCompanyName=vehicleCompanyList.get(options1).getCOMPANYNAME();
                                    strCompanyCode=vehicleCompanyList.get(options1).getTXT_COMPANY_CODE();
                                    CompanyNameEdit.setText(strCompanyName);


                                }
                            });
                            singlePicker.show();
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
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE_Company);
        req.execute();
    }
    @Override
    public void onBackPressed() {
        if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
            Intent intent = new Intent(Motor_vehicle_details.this, OldMotorAddOns.class);
            str_edt_email=emailIDText.getText().toString();
            strName=fullNameEdit.getText().toString();
            strRegisteredAddressEdit=registeredAddressEdit.getText().toString();
            strPinCodeEditText=PinCodeEditText.getText().toString();
            strCommunicationAddressEdit=CommunicationAddressEdit.getText().toString();
            strCommunicationPinCodeEdit=CommunicationPinCodeEdit.getText().toString();
            strVehicleNo=VehicleNumber.getText().toString();
            strVehicleChasisNumber=VehicleChasisNumber.getText().toString();
            strVehicleEngineNumber=VehicleEngineNumber.getText().toString();
            strNomineeName=NomineeName.getText().toString();
            strNomineeRelationEdit=NomineeRelationEdit.getText().toString();

            intent.putExtra("strVehicleNo",strVehicleNo);
            intent.putExtra("MemberEditTxt",strMemberEditTxt);
            intent.putExtra("ValidityTxt",strValidityTxt);
            intent.putExtra("strName",strName);
            intent.putExtra("strGenderSpinner",strGenderSpinner);
            intent.putExtra("streditdob",streditdob);
            intent.putExtra("strIDType",strIDType);
            intent.putExtra("strIDTypeName",strIDTypeName);
            intent.putExtra("strIDTypeName1",strIDTypeName1);
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
            intent.putExtra("a",a);
            intent.putExtra("b",b);
            intent.putExtra("c",c);
            intent.putExtra("CheckString",CheckString);
            intent.putExtra("strStateCode",strStateCode);
            intent.putExtra("strFor",strFor);
            intent.putExtra("strNewFor",strNewFor);
            intent.putExtra("strVehicleCubicCapicity",strVehicleCubicCapicity);
            intent.putExtra("strVehicleImage",strVehicleImage);
            intent.putExtra("ChangeAddons",ChangeAddons);
            intent.putExtra("strDiscountEdit",strDiscountEdit);
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
            intent.putExtra("selectYear",selectYear);
            intent.putExtra("daysLeft",daysLeft);
            intent.putExtra("VehicleAgeAdd",VehicleAgeAdd);
            intent.putExtra("MonthsLeft",MonthsLeft);
            intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
            intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
            intent.putExtra("NCBStatus",NCBStatus);
            intent.putExtra("ckycNo",ckycNo);
            intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
            startActivity(intent);
            overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);
            finish();
        }

        else {
            str_edt_email=emailIDText.getText().toString();
            strName=fullNameEdit.getText().toString();
            strRegisteredAddressEdit=registeredAddressEdit.getText().toString();
            strPinCodeEditText=PinCodeEditText.getText().toString();
            strCommunicationAddressEdit=CommunicationAddressEdit.getText().toString();
            strCommunicationPinCodeEdit=CommunicationPinCodeEdit.getText().toString();
            strVehicleNo=VehicleNumber.getText().toString();
            strVehicleChasisNumber=VehicleChasisNumber.getText().toString();
            strVehicleEngineNumber=VehicleEngineNumber.getText().toString();
            strNomineeName=NomineeName.getText().toString();
            strNomineeRelationEdit=NomineeRelationEdit.getText().toString();

            Intent intent = new Intent(Motor_vehicle_details.this, Motor_AddOns.class);
            intent.putExtra("strVehicleNo",strVehicleNo);
            intent.putExtra("strName",strName);
            intent.putExtra("MemberEditTxt",strMemberEditTxt);
            intent.putExtra("ValidityTxt",strValidityTxt);
            intent.putExtra("strGenderSpinner",strGenderSpinner);
            intent.putExtra("streditdob",streditdob);
            intent.putExtra("strIDType",strIDType);
            intent.putExtra("strIDTypeName",strIDTypeName);
            intent.putExtra("strIDTypeName1",strIDTypeName1);
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
            intent.putExtra("a",a);
            intent.putExtra("b",b);
            intent.putExtra("c",c);
            intent.putExtra("CheckString",CheckString);
            intent.putExtra("strStateCode",strStateCode);
            intent.putExtra("strFor",strFor);
            intent.putExtra("strNewFor",strNewFor);
            intent.putExtra("strVehicleCubicCapicity",strVehicleCubicCapicity);
            intent.putExtra("strVehicleImage",strVehicleImage);
            intent.putExtra("strDiscountEdit",strDiscountEdit);
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
            intent.putExtra("selectYear",selectYear);
            intent.putExtra("daysLeft",daysLeft);
            intent.putExtra("VehicleAgeAdd",VehicleAgeAdd);
            intent.putExtra("MonthsLeft",MonthsLeft);
            intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
            intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
            intent.putExtra("NCBStatus",NCBStatus);
            intent.putExtra("ckycNo",ckycNo);
            intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
            startActivity(intent);
            overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);
            finish();
        }
    }
    private void showCalender1() {
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
            ckycNo="";
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


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        DatePickerDialog datePicker = new DatePickerDialog(Motor_vehicle_details.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strEndDateEdit=dateFormatter.format(newDate.getTime());
            endRegistrationDate.setText(strEndDateEdit);

            String[] strParts = strEndDateEdit.split("/");
            String strFirstString = strParts[0];
            String strSecondString = strParts[1];
//            yearOfManufactureEndDate = strParts[2];
//            edt_city.setText(dateFormatter.format(newDate.getTime()));
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalenderODFrom() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        DatePickerDialog datePicker = new DatePickerDialog(Motor_vehicle_details.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strODPlanFromDateEdit=dateFormatter.format(newDate.getTime());
            ODPlanFromDateEdit.setText(strODPlanFromDateEdit);
            String[] strParts = strODPlanFromDateEdit.split("/");
            String strFirstString = strParts[0];
            String strSecondString = strParts[1];
//            yearOfManufactureEndDate = strParts[2];
//            edt_city.setText(dateFormatter.format(newDate.getTime()));
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalenderODEnd() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        DatePickerDialog datePicker = new DatePickerDialog(Motor_vehicle_details.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strODPlanEndDateEdit=dateFormatter.format(newDate.getTime());
            ODPlanEndDateEdit.setText(strODPlanEndDateEdit);
            String[] strParts = strODPlanEndDateEdit.split("/");
            String strFirstString = strParts[0];
            String strSecondString = strParts[1];
//            yearOfManufactureEndDate = strParts[2];
//            edt_city.setText(dateFormatter.format(newDate.getTime()));
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalenderTPFrom() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        DatePickerDialog datePicker = new DatePickerDialog(Motor_vehicle_details.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strTpPlanFromDateEdit=dateFormatter.format(newDate.getTime());
            TpPlanFromDateEdit.setText(strTpPlanFromDateEdit);
            String[] strParts = strTpPlanFromDateEdit.split("/");
            String strFirstString = strParts[0];
            String strSecondString = strParts[1];
//            yearOfManufactureEndDate = strParts[2];
//            edt_city.setText(dateFormatter.format(newDate.getTime()));
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalenderTPEnd() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        DatePickerDialog datePicker = new DatePickerDialog(Motor_vehicle_details.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strTpPlanEndDateEdit=dateFormatter.format(newDate.getTime());
            TpPlanEndDateEdit.setText(strTpPlanEndDateEdit);
            String[] strParts = strTpPlanEndDateEdit.split("/");
            String strFirstString = strParts[0];
            String strSecondString = strParts[1];
//            yearOfManufactureEndDate = strParts[2];
            if (StrPrev_Policy_Type.equals("")){
                Toast.makeText(Motor_vehicle_details.this, "Select Previous Policy Type", Toast.LENGTH_SHORT).show();
            }else if(StrPrev_Policy_Type.equals("Liability")) {
                if (strTpPlanFromDateEdit.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Select TP Start Date", Toast.LENGTH_SHORT).show();
                }else if(strTpPlanEndDateEdit.equals("")){
                    Toast.makeText(Motor_vehicle_details.this, "Select TP End Date", Toast.LENGTH_SHORT).show();
                }else{
                    PreviousPolicyType();
                }
            } else if (strODPlanFromDateEdit.equals("")){
                Toast.makeText(Motor_vehicle_details.this, "Select OD Start Date", Toast.LENGTH_SHORT).show();
            }else if (strODPlanEndDateEdit.equals("")){
                Toast.makeText(Motor_vehicle_details.this, "Select OD End Date", Toast.LENGTH_SHORT).show();
            }else if (strTpPlanFromDateEdit.equals("")){
                Toast.makeText(Motor_vehicle_details.this, "Select TP Start Date", Toast.LENGTH_SHORT).show();
            }else if(strTpPlanEndDateEdit.equals("")){
                Toast.makeText(Motor_vehicle_details.this, "Select TP End Date", Toast.LENGTH_SHORT).show();
            }else{
                PreviousPolicyType();
            }


//            edt_city.setText(dateFormatter.format(newDate.getTime()));
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void PreviousPolicyType() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("Prev_Policy_Type",StrPrev_Policy_Type);
            object.put("NCB_Value",strClaimBonus);
            object.put("OD_Plan_FromDateRange",strODPlanFromDateEdit);
            object.put("OD_Plan_ToDateRange",strODPlanEndDateEdit);
            object.put("TP_Plan_FromDateRange",strTpPlanFromDateEdit);
            object.put("TP_Plan_ToDateRange",strTpPlanEndDateEdit);
        }catch (Exception e) {
            e.printStackTrace();
        }ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_vehicle_details.this, object, UrlConstants.BUYPreviousPolicyType, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    Toast.makeText(getApplication(), ""+object.optString("Message"), Toast.LENGTH_SHORT).show();
                } else {
                    String message=object.optString("Message");
                    Toast.makeText(getApplication(), ""+message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE);
        req.execute();

    }
    private void updateLabel() {
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        strEndDateEdit=dateFormat.format(myCalendar.getTime());
        endRegistrationDate.setText(strEndDateEdit);
        String[] strParts = strEndDateEdit.split("/");
        String strFirstString = strParts[0];
        String strSecondString = strParts[1];
    }
}