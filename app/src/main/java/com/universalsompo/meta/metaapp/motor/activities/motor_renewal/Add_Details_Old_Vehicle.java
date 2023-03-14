package com.universalsompo.meta.metaapp.motor.activities.motor_renewal;

import static com.bigkoo.pickerview.view.MyWheelTime.dateFormat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
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
import com.universalsompo.meta.metaapp.health.activities.Health_Insurance_Renewal;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya.Arogya_Member_info;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHIAddOns;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PolicyTypeCHI;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.RegisterActivity;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.CompanyModel;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.VehicleManufacturerModel;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.MotorPrivate;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Motor_AddOns;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.OldMotorAddOns;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Private_car_vehicle_details;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.models.DocumentModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Add_Details_Old_Vehicle extends AppCompatActivity  {
    private MySharedPreference pref;
    CustomProgressDialog customprogress;
    Button confirmButton;
    String previousDate = "";
    TextView PreviousEndDateTxt,TxtViewVehicleType;
    EditText SaodEndDateEdit,TpFromDateEdit,TpEndDateEdit,policyNumberEdit,endDateEdit,CompanyNameEdit;
    LinearLayout SAODLiner,SAODLinerEffective,BonusLiner,ClaimLiner,CompanyLiner,PreviousPolicyLiner,companySpinner,EndDateIcon,zeroLiner,tenLiner,twentyLiner,FortyLiner,fiftyLiner,sixtyLiner;
    String strIDTypeName1,yearOfManufactureMonth,strSelectDateYear,yearOfManufactureDay,NCBStatus,AutoMobileValidityRadio,ELECTRICALACCESSORYODSumInsured,NONELECTRICALACCESSORYODSumInsured,strElectricalAccessoriesSumInsured,strNonelectricalAccessoriesSumInsured,PACOVERTOPASSENGERSSumInsured,UNNAMEDPACOVERTOPASSENGERSSumInsured, PACOVERTOPAIDDRIVERSumInsured,strCngKitSumInsured,AutoMobileRadio,AutomobileAssociationdiscountSumInsured,VoluntarydeductableSumInsured,strMinMax,AntitheftdevicediscountStatus,AutomobileAssociationdiscountStatus,TPPDDiscountStatus,HandicapDiscountStatus,VoluntarydeductableStatus,AdditionalNonElecticalODSumInsuredValue,AdditionalElectricalSumInsuredValue,AntitheftdeviceRateValue,AntitheftdeviceSumInsuredValue,AutomobileAssociationRateValue,AutomobileAssociationSumInsuredValue,HandicapRateValue,HandicapSumInsuredValue,TPPDDiscountRateValue,TPPDDiscountSumInsuredValue,VotaryRateValue,VotarySumInsuredValue,StrNCB,strDiscountEdit,ChangeAddons,DetarifficValueSumInsure="",DetarifficLoadingValueSumInsured="",BasicODRateSumInsured="",ELECTRICALCoverSumInsured="",NONELECTRICALSumInsured="",BasicTpRateSumInsured="",AdditionalFibertankODSumInsuredValue,AdditionalLegalLiabilityPaidSumInsured,AdditionalOtherODRateSumInsured,AdditionalOtherTpSumInsuredValue,AdditionalPaCoverToOwnerDriverSumInsuredValue,AdditionalPaidDriverSumInsuredValue,AdditionalPaToPassengersSumInsuredValue,AdditionalUnnamedPassengersSumInsuredValue,AdditionalCngKitODSumInsuredValue,AdditionalCngLpgTpSumInsuredValue,AdditionalBuiltinKitODSumInsuredValue,AdditionalBuiltinCngTPSumInsuredValue,DailyCashRateSumInsured,AccidentalSumInsuredValue,WrongFuelSumInsuredValue,CostOfConsumablesSumInsuredValue,dailyCashAllowanceMetroSumInsuredValue,dailyCashAllowanceNonMetroSumInsuredValue,EngineProtectorDieselSumInsuredValue,EngineProtectorPetrolSumInsuredValue,HydrostaticLockSumInsuredValue,KeyReplacementSumInsuredValue,NilDepreciationSumInsuredValue,ReturnToInvoiceSumInsuredValue,RoadSideAssistanceSumInsuredValue,SecureTowingSumInsuredValue,TyreRimsecureSumInsuredValue,drivingTrainProtectSumInsuredValue,ManufacturesellingSumInsuredValue,today,VEHICLECLASSCODE,str_vehicleManufacturerNm="",strVehicleModel="",str_edt_registration_date="",strStateCode="",strStateName="",strRTOCode="",strVehicleChasisNumber="",strVehicleEngineNumber="", rc_cubic_cap="",rc_fuel_desc="",FuleType="",strVehicleManufacturerCode="",strVehicleModelCode="",str_edt_registration_date1="",strRTOName="",yearOfManufacture="",strName="",strCompanyName="",strCompanyCode="",strVehicleNo="",str_edt_city="",str_edt_phone="",str_edt_email="",strPolicyRadio="",strVehicleTypeRadio="",strVehicleRadio="",strFor="",strEndDateEdit="",strPolicyNumberEdit="",yearOfManufactureEndDate="",strClaimBonus="",StrPreviousPolicyRadio="",strPreviousClaimRadio="";
    private SimpleDateFormat dateFormatter;
    RadioButton OwnDamagedRadio,YesPreviousRadio,NoPreviousRadio,YesPreviousClaimRadio,NoPreviousClaimRadio,ComprehensivePolicyRadio,LiabilityRadio;
    ArrayList<CompanyModel> vehicleCompanyList = new ArrayList<CompanyModel>();
    final ArrayList<String> itemsCompany = new ArrayList<String>();
    CompanyModel companyModel;
    MyOptionsPickerView singlePicker;
    ImageView backAddDetails;
    Format formatter;
    String ckycNo,uniqueTransactionNumber,strGenderSpinner = "",streditdob="",strIDType="",strIDTypeName="",strIDNumberEdit="";
    Date date,CurrentDate,SelectDate,strEndDate,strToday;
    Calendar myCalendar= Calendar.getInstance();
    final Calendar TpEndCalendar= Calendar.getInstance();
    Spinner SpinnerCompany;
    LocalDate dateRegistration;
    public Period period;
    Calendar newDate1;
    private int startyear, startmonth, startday;
    private String start_day, start_month, start_year;
    private int curYear, curMonth, curDay;
    int strYearOfManufacture,progressChanged,progressChanged1,a,b,c,check;
    int selectYear,SelectMonth,SelectDays,daysLeft,daysLeft1,MonthsLeft,VehicleAgeAdd;
    String  uidStr,strSaodEndDateEdit="",strTpFromDateEdit="",strTpEndDateEdit="",strVehicleImage="",strVehicleCubicCapicity="",selected_country_code,strNewFor="",DetariffDiscountStatus,DetariffLoadingStatus="",DetarifficValuePremium="",DetarifficValueRate="",DetarifficLodingValuePremium="",DetarifficLoadingValueRate="",changeseekBar="",strIdvValueTxtSelect="",DAILYCASHALLOWANCEStatus="",WRONGFUELCOVERStatus="",BasicODRateValue,BasicTpRateValue,AdditionalLegalLiabilityPaidRate="",CheckString="",strNomineeName="",strNomineeRelationEdit="",StrAdditionalCoverPremiumTp="",StrAdditionalCoverPremiumOD="",SeekbarStatus="",addOnsCover="",addOnsAditional="",vehicleManufacturerType="",strModelType="",ProductName="",ProductCode="",VehicleClassCode="",addOns="",NCB="",strVehicleAge="",NetPremiumValue="",TotalValue="",PosPolicyNo1="",PosPolicyNo="",GST="",strIdvValueTxt="",strLessIDVText="",strHighIDVText="",strThirdDString,strTitleEdit="",str_manufacture_year="",strRegisteredAddressEdit="",strStateRegisterAddressEdit="",strStateRegisterCode,strCityRegisterCode="",strCityRegisterEdit="",strCityCommunicationCode="",strPinCodeEditText="",strCommunicationAddressEdit="",strCommunicationPinCodeEdit="",strVehicleNumber="",strStateCommunicationEdit="",strStateCommunicationCode="",strCityCommunicationEdit="",strPlanType="",strPlanYear="",strCoverageType="",strPACover="",strGPACover="",strDrivingLicence="",strCheckedTermCondition="",strCheckboxCommunication="",strBreaking = "",
            BUILTINCNGKIT_LPGKITTPStatus="",StrPrev_Policy_Type="",nextYear="",strODPlanFromDateEdit="",strODPlanEndDateEdit="",strTpPlanFromDateEdit="",strTpPlanEndDateEdit="",CubicCapacity="",tomorrowDate="",VehicleExShowroomPrice="",BasicODStatus="",BasicTP="",ELECTRICALACCESSORYODStatus="",FIBERTANKODStatus="",LEGALLIABILITYTOPAIDDRIVERStatus="",NONELECTRICALACCESSORYODStatus="",OtherODStatus="",OtherTpStatus="",PACOVERTOEMPLOYEESOFINSUREDStatus="",PACOVERTOOWNERDRIVERStatus="",PACOVERTOPAIDDRIVERStatus="",PACOVERTOPASSENGERSStatus="",UNNAMEDPACOVERTOPASSENGERSStatus="",ACCIDENTALHOSPITALIZATIONStatus="",COSTOFCONSUMABLESStatus="",DAILYCASHALLOWANCEMETROStatus="",DAILYCASHALLOWANCENONMETROStatus="",ENGINEPROTECTORDIESELStatus="",ENGINEPROTECTORPETROLStatus="",HYDROSTATICLOCKCOVERStatus="",KEYREPLACEMENTStatus="",NilDepreciationWaivercoverStatus="",RETURNTOINVOICEStatus="",RoadsideAssistanceStatus="",SECURETOWINGStatus="",TyreandRimsecureStatus="",AdditionalElectricalRateValue="",AdditionalFibertankODRateValue="",AdditionalLegalLiabilityDriverRateValue="",AdditionalBuiltinCngTPRateValue="",AdditionalNonElecticalODRateValue="",AdditionalOtherODRateValue="",AdditionalOtherTpRateValue="",AdditionalPaCoversToEmployessRateValue="",AdditionalPaCoverToOwnerDriverRateValue="",AdditionalPaidDriverRateValue="",AdditionalPaToPassengersRateValue="",AdditionalUnnamedPassengersRateValue="",AdditionalCngKitODRateValue="",AdditionalCngLpgTpRateValue="",AdditionalBuiltinKitODRateValue="",AccidentalRateValue="",CostOfConsumablesRateValue="",dailyCashAllowanceMetroRateValue="",dailyCashAllowanceNonMetroRateValue="",EngineProtectorDieselRateValue="", EngineProtectorPetrolRateValue="",HydrostaticLockRateValue="", KeyReplacementRateValue="", NilDepreciationRateValue="", ReturnToInvoiceRateValue="", RoadSideAssistanceRateValue="",SecureTowingRateValue="",TyreRimsecureRateValue="", drivingTrainProtectRateValue="",WrongFuelRateValue="", DailyCashRateValue="",ManufacturesellingRateValue="",CNGLPGKITODStatus="",CNGLPGKITTPStatus="",BUILTINCNGKIT_LPGKITODStatus="",MANUFACTURERSELLINGPRICEStatus="",DRIVINGTRAINPROTECTStatus="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details_old_vehicle);
        getWindow().setStatusBarColor(ContextCompat.getColor(Add_Details_Old_Vehicle.this, R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(Add_Details_Old_Vehicle.this);
        customprogress = new CustomProgressDialog(Add_Details_Old_Vehicle.this);
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
        NCBStatus = getIntent().getStringExtra("NCBStatus");
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
        strVehicleCubicCapicity = getIntent().getStringExtra("strVehicleCubicCapicity");
        strVehicleImage = getIntent().getStringExtra("strVehicleImage");
        selectYear =getIntent().getIntExtra("selectYear", 0);
        daysLeft =getIntent().getIntExtra("daysLeft", 0);
        a =getIntent().getIntExtra("a", 0);
        b =getIntent().getIntExtra("b", 0);
        c =getIntent().getIntExtra("c", 0);
        check =getIntent().getIntExtra("check", 0);
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
        AutoMobileValidityRadio = getIntent().getStringExtra("AutoMobileValidityRadio");
        AutomobileAssociationdiscountSumInsured = getIntent().getStringExtra("AutomobileAssociationdiscountSumInsured");
        VoluntarydeductableSumInsured = getIntent().getStringExtra("VoluntarydeductableSumInsured");
        ELECTRICALACCESSORYODSumInsured = getIntent().getStringExtra("ELECTRICALACCESSORYODSumInsured");
        NONELECTRICALACCESSORYODSumInsured = getIntent().getStringExtra("NONELECTRICALACCESSORYODSumInsured");
        strTpFromDateEdit = getIntent().getStringExtra("strTpFromDateEdit");
        strTpEndDateEdit = getIntent().getStringExtra("strTpEndDateEdit");
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

        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        Log.e("today",today);

        confirmButton=findViewById(R.id.confirmButton);
        policyNumberEdit=findViewById(R.id.policyNumberEdit);
        EndDateIcon=findViewById(R.id.EndDateIcon);
        endDateEdit=findViewById(R.id.endDateEdit);
        zeroLiner=findViewById(R.id.zeroLiner);
        tenLiner=findViewById(R.id.tenLiner);
        twentyLiner=findViewById(R.id.twentyLiner);
        FortyLiner=findViewById(R.id.FortyLiner);
        fiftyLiner=findViewById(R.id.fiftyLiner);
        sixtyLiner=findViewById(R.id.sixtyLiner);
        YesPreviousRadio=findViewById(R.id.YesPreviousRadio);
        NoPreviousRadio=findViewById(R.id.NoPreviousRadio);
        companySpinner=findViewById(R.id.companySpinner);
        CompanyNameEdit=findViewById(R.id.CompanyNameEdit);
        TxtViewVehicleType=findViewById(R.id.TxtViewVehicleType);
        PreviousEndDateTxt=findViewById(R.id.PreviousEndDateTxt);
        backAddDetails=findViewById(R.id.backAddDetails);
        PreviousPolicyLiner=findViewById(R.id.PreviousPolicyLiner);
        SpinnerCompany=findViewById(R.id.SpinnerCompany);
        CompanyLiner=findViewById(R.id.CompanyLiner);
        YesPreviousClaimRadio=findViewById(R.id.YesPreviousClaimRadio);
        NoPreviousClaimRadio=findViewById(R.id.NoPreviousClaimRadio);
        ComprehensivePolicyRadio=findViewById(R.id.ComprehensivePolicyRadio);
        LiabilityRadio=findViewById(R.id.LiabilityRadio);
        ClaimLiner=findViewById(R.id.ClaimLiner);
        BonusLiner=findViewById(R.id.BonusLiner);
        SAODLiner=findViewById(R.id.SAODLiner);
        SAODLinerEffective=findViewById(R.id.SAODLinerEffective);
        OwnDamagedRadio=findViewById(R.id.OwnDamagedRadio);
        SaodEndDateEdit=findViewById(R.id.SaodEndDateEdit);
        TpFromDateEdit=findViewById(R.id.TpFromDateEdit);
        TpEndDateEdit=findViewById(R.id.TpEndDateEdit);



        if (strVehicleTypeRadio.equals("Four Wheeler")){
            TxtViewVehicleType.setText("Four Wheeler Insurance");
            VEHICLECLASSCODE="45";
        }else{
            TxtViewVehicleType.setText("Two Wheeler Insurance");
            VEHICLECLASSCODE="37";
        }


        if (strFor.equals("1")){
            if(StrPreviousPolicyRadio==null&&strPreviousClaimRadio==null&&StrPrev_Policy_Type==null){
                VehicleAllCompanyMaster();
                StrPreviousPolicyRadio="Yes";
                YesPreviousRadio.setChecked(true);
                strClaimBonus="0";
                NCBStatus="True";
                strCompanyName="Select Company";
                PreviousPolicyLiner.setVisibility(View.VISIBLE);
                CompanyLiner.setVisibility(View.GONE);
                SpinnerCompany.setVisibility(View.VISIBLE);
                CompanyNameEdit.setText(strCompanyName);
                strPreviousClaimRadio="No";
                NoPreviousClaimRadio.setChecked(true);
                StrPrev_Policy_Type="Comprehensive";
                ComprehensivePolicyRadio.setChecked(true);

            }
            else{
                if (StrPreviousPolicyRadio.equals("Yes")){
                    PreviousPolicyLiner.setVisibility(View.VISIBLE);
                    CompanyLiner.setVisibility(View.VISIBLE);
                    SpinnerCompany.setVisibility(View.GONE);
                    YesPreviousRadio.setChecked(true);
                    NoPreviousRadio.setChecked(false);
                    strBreaking = "Unchecked";
                    if (check==0){
                        policyNumberEdit.setText(strPolicyNumberEdit);
                        endDateEdit.setText(strEndDateEdit);
                        CompanyNameEdit.setText(strCompanyName);
                        TpEndDateEdit.setText(strTpEndDateEdit);
                        TpFromDateEdit.setText(strTpFromDateEdit);
                    }else{
                        strPolicyNumberEdit="";
                        strEndDateEdit="";
                        strCompanyName="Select Company";
                        strTpEndDateEdit="";
                        strTpFromDateEdit="";
                        policyNumberEdit.setText(strPolicyNumberEdit);
                        endDateEdit.setText(strEndDateEdit);
                        CompanyNameEdit.setText(strCompanyName);
                        TpEndDateEdit.setText(strTpEndDateEdit);
                        TpFromDateEdit.setText(strTpFromDateEdit);
                    }


                    if (strPreviousClaimRadio.equals("Yes")){
                        YesPreviousClaimRadio.setChecked(true);
                        NoPreviousClaimRadio.setChecked(false);
                        ClaimLiner.setVisibility(View.GONE);
                    }else{
                        NoPreviousClaimRadio.setChecked(true);
                        YesPreviousClaimRadio.setChecked(false);
                        ClaimLiner.setVisibility(View.VISIBLE);
                    }
                    if (strClaimBonus.equals("0")){
                        zeroLiner.setBackgroundResource(R.drawable.red_border_line);
                    }else if (strClaimBonus.equals("20")){
                        tenLiner.setBackgroundResource(R.drawable.red_border_line);
                    }else if (strClaimBonus.equals("25")){
                        twentyLiner.setBackgroundResource(R.drawable.red_border_line);
                    }else if (strClaimBonus.equals("35")){
                        FortyLiner.setBackgroundResource(R.drawable.red_border_line);
                    }else if (strClaimBonus.equals("40")){
                        fiftyLiner.setBackgroundResource(R.drawable.red_border_line);
                    }else if (strClaimBonus.equals("50")){
                        sixtyLiner.setBackgroundResource(R.drawable.red_border_line);
                    }
                    TpFromDateEdit.setText(strTpFromDateEdit);
                    TpEndDateEdit.setText(strTpEndDateEdit);

                    if (strVehicleTypeRadio.equals("Four Wheeler")) {
                        if (VehicleAgeAdd <3) {
                            OwnDamagedRadio.setVisibility(View.VISIBLE);
                            LiabilityRadio.setVisibility(View.GONE);
                            SAODLiner.setVisibility(View.VISIBLE);
                            SAODLinerEffective.setVisibility(View.VISIBLE);
                            LiabilityRadio.setChecked(false);
                            BonusLiner.setVisibility(View.VISIBLE);
                            PreviousEndDateTxt.setText("OD policy end date");
                            if (StrPrev_Policy_Type.equals("Comprehensive")){
                                ComprehensivePolicyRadio.setChecked(true);
                                OwnDamagedRadio.setChecked(false);
                            }else if (StrPrev_Policy_Type.equals("Own damage (standalone)")){
                                ComprehensivePolicyRadio.setChecked(false);
                                OwnDamagedRadio.setChecked(true);
                            }
                            if (daysLeft > 91 ) {
                                BonusLiner.setVisibility(View.GONE);
                                strClaimBonus="0";
                                NCBStatus="False";
                                confirmButton.setVisibility(View.VISIBLE);
                            }
                        }
                        else{
                            OwnDamagedRadio.setVisibility(View.GONE);
                            LiabilityRadio.setVisibility(View.VISIBLE);
                            SAODLiner.setVisibility(View.GONE);
                            SAODLinerEffective.setVisibility(View.GONE);
                            OwnDamagedRadio.setChecked(false);
                            if (StrPrev_Policy_Type.equals("Comprehensive")){
                                ComprehensivePolicyRadio.setChecked(true);
                                LiabilityRadio.setChecked(false);
                                if (daysLeft > 91 ) {
                                    BonusLiner.setVisibility(View.GONE);
                                    strClaimBonus="0";
                                    NCBStatus="False";
                                    confirmButton.setVisibility(View.VISIBLE);
                                }
                            }
                            else if (StrPrev_Policy_Type.equals("Liability")){
                                ComprehensivePolicyRadio.setChecked(false);
                                LiabilityRadio.setChecked(true);
                            }

                        }
                    }
                    else{
                        if (VehicleAgeAdd <5) {
                            OwnDamagedRadio.setVisibility(View.VISIBLE);
                            LiabilityRadio.setVisibility(View.GONE);
                            SAODLiner.setVisibility(View.VISIBLE);
                            SAODLinerEffective.setVisibility(View.VISIBLE);
                            LiabilityRadio.setChecked(false);
                            BonusLiner.setVisibility(View.VISIBLE);
                            PreviousEndDateTxt.setText("OD policy end date");
                            if (StrPrev_Policy_Type.equals("Comprehensive")){
                                ComprehensivePolicyRadio.setChecked(true);
                                OwnDamagedRadio.setChecked(false);
                            }else if (StrPrev_Policy_Type.equals("Own damage (standalone)")){
                                ComprehensivePolicyRadio.setChecked(false);
                                OwnDamagedRadio.setChecked(true);
                            }
                            if (daysLeft > 91 ) {
                                BonusLiner.setVisibility(View.GONE);
                                strClaimBonus="0";
                                NCBStatus="False";
                                confirmButton.setVisibility(View.VISIBLE);
                            }
                        }
                        else{
                            OwnDamagedRadio.setVisibility(View.GONE);
                            LiabilityRadio.setVisibility(View.VISIBLE);
                            SAODLiner.setVisibility(View.GONE);
                            SAODLinerEffective.setVisibility(View.GONE);
                            OwnDamagedRadio.setChecked(false);
                            if (StrPrev_Policy_Type.equals("Comprehensive")){
                                ComprehensivePolicyRadio.setChecked(true);
                                LiabilityRadio.setChecked(false);
                                if (daysLeft > 91 ) {
                                    BonusLiner.setVisibility(View.GONE);
                                    strClaimBonus="0";
                                    NCBStatus="False";
                                    confirmButton.setVisibility(View.VISIBLE);
                                }

                            }else if (StrPrev_Policy_Type.equals("Liability")){
                                ComprehensivePolicyRadio.setChecked(false);
                                LiabilityRadio.setChecked(true);
                            }
                        }
                    }
                }
                else{
                    PreviousPolicyLiner.setVisibility(View.GONE);
                    NoPreviousRadio.setChecked(true);
                    strBreaking = "checked";
                    YesPreviousRadio.setChecked(false);
                    strCompanyName="Select Company";
                    CompanyLiner.setVisibility(View.GONE);
                    SpinnerCompany.setVisibility(View.VISIBLE);
                    CompanyNameEdit.setText(strCompanyName);
                }
            }

        }
        else{
            VehicleAllCompanyMaster();
            StrPreviousPolicyRadio="Yes";
            YesPreviousRadio.setChecked(true);
            strClaimBonus="0";
            NCBStatus="True";
            strCompanyName="Select Company";
            PreviousPolicyLiner.setVisibility(View.VISIBLE);
            CompanyLiner.setVisibility(View.GONE);
            SpinnerCompany.setVisibility(View.VISIBLE);
            CompanyNameEdit.setText(strCompanyName);
            strPreviousClaimRadio="No";
            NoPreviousClaimRadio.setChecked(true);
            StrPrev_Policy_Type="Comprehensive";
            ComprehensivePolicyRadio.setChecked(true);
            ComprehensivePolicyRadio.setVisibility(View.VISIBLE);
            if (strVehicleTypeRadio.equals("Four Wheeler")) {
                if (VehicleAgeAdd <3) {
                    PreviousEndDateTxt.setText("OD policy end date");
                    OwnDamagedRadio.setVisibility(View.VISIBLE);
                    LiabilityRadio.setVisibility(View.GONE);
                    SAODLiner.setVisibility(View.VISIBLE);
                    SAODLinerEffective.setVisibility(View.VISIBLE);
                    LiabilityRadio.setChecked(false);
                    BonusLiner.setVisibility(View.VISIBLE);
                    ComprehensivePolicyRadio.setChecked(true);
                    OwnDamagedRadio.setChecked(false);
                }
                else{
                    OwnDamagedRadio.setVisibility(View.GONE);
                    LiabilityRadio.setVisibility(View.VISIBLE);
                    SAODLiner.setVisibility(View.GONE);
                    SAODLinerEffective.setVisibility(View.GONE);
                    OwnDamagedRadio.setChecked(false);
                    ComprehensivePolicyRadio.setChecked(true);
                    LiabilityRadio.setChecked(false);

                }

                if (daysLeft > 91 ) {
                    BonusLiner.setVisibility(View.GONE);
                    strClaimBonus="0";
                    NCBStatus="False";
                    confirmButton.setVisibility(View.VISIBLE);
                }
            }
            else{
                if (VehicleAgeAdd <5) {
                    OwnDamagedRadio.setVisibility(View.VISIBLE);
                    LiabilityRadio.setVisibility(View.GONE);
                    SAODLiner.setVisibility(View.VISIBLE);
                    SAODLinerEffective.setVisibility(View.VISIBLE);
                    LiabilityRadio.setChecked(false);
                    BonusLiner.setVisibility(View.VISIBLE);
                    ComprehensivePolicyRadio.setChecked(true);
                    OwnDamagedRadio.setChecked(false);
                    PreviousEndDateTxt.setText("OD policy end date");
                }
                else{
                    OwnDamagedRadio.setVisibility(View.GONE);
                    LiabilityRadio.setVisibility(View.VISIBLE);
                    SAODLiner.setVisibility(View.GONE);
                    SAODLinerEffective.setVisibility(View.GONE);
                    OwnDamagedRadio.setChecked(false);
                    ComprehensivePolicyRadio.setChecked(true);
                    LiabilityRadio.setChecked(false);
                }
                if (daysLeft > 91 ) {
                    BonusLiner.setVisibility(View.GONE);
                    strClaimBonus="0";
                    NCBStatus="False";
                    confirmButton.setVisibility(View.VISIBLE);
                }
            }

        }


        companySpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CompanyLiner.setVisibility(View.GONE);
                SpinnerCompany.setVisibility(View.VISIBLE);
                VehicleAllCompanyMaster();
            }
        });
        YesPreviousRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPreviousRadio.isChecked()){
                    StrPreviousPolicyRadio="Yes";
                    YesPreviousRadio.setChecked(true);
                    NoPreviousRadio.setChecked(false);
                    strBreaking = "Unchecked";

                    if (strVehicleTypeRadio.equals("Four Wheeler")) {
                        if (VehicleAgeAdd <3) {
                            PreviousEndDateTxt.setText("OD policy end date");
                            OwnDamagedRadio.setVisibility(View.VISIBLE);
                            LiabilityRadio.setVisibility(View.GONE);
                            SAODLiner.setVisibility(View.VISIBLE);
                            SAODLinerEffective.setVisibility(View.VISIBLE);
                            LiabilityRadio.setChecked(false);
                            BonusLiner.setVisibility(View.VISIBLE);
                            ComprehensivePolicyRadio.setChecked(true);
                            OwnDamagedRadio.setChecked(false);
                        }
                        else{
                            OwnDamagedRadio.setVisibility(View.GONE);
                            LiabilityRadio.setVisibility(View.VISIBLE);
                            SAODLiner.setVisibility(View.GONE);
                            SAODLinerEffective.setVisibility(View.GONE);
                            OwnDamagedRadio.setChecked(false);
                            ComprehensivePolicyRadio.setChecked(true);
                            LiabilityRadio.setChecked(false);

                        }
                    }
                    else{
                        if (VehicleAgeAdd <5) {
                            OwnDamagedRadio.setVisibility(View.VISIBLE);
                            LiabilityRadio.setVisibility(View.GONE);
                            SAODLiner.setVisibility(View.VISIBLE);
                            SAODLinerEffective.setVisibility(View.VISIBLE);
                            LiabilityRadio.setChecked(false);
                            BonusLiner.setVisibility(View.VISIBLE);
                            ComprehensivePolicyRadio.setChecked(true);
                            OwnDamagedRadio.setChecked(false);
                            PreviousEndDateTxt.setText("OD policy end date");
                        }
                        else{
                            OwnDamagedRadio.setVisibility(View.GONE);
                            LiabilityRadio.setVisibility(View.VISIBLE);
                            SAODLiner.setVisibility(View.GONE);
                            SAODLinerEffective.setVisibility(View.GONE);
                            OwnDamagedRadio.setChecked(false);
                            ComprehensivePolicyRadio.setChecked(true);
                            LiabilityRadio.setChecked(false);
                        }

                    }

                    BonusLiner.setVisibility(View.VISIBLE);

                    PreviousPolicyLiner.setVisibility(View.VISIBLE);
                    VehicleAllCompanyMaster();
//                    customprogress.showProgressBar();
//                    variantAdrilla();

                }
            }
        });
        NoPreviousRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPreviousRadio.isChecked()){
                    StrPreviousPolicyRadio="No";
                    strClaimBonus="0";
                    NoPreviousRadio.setChecked(true);
                    strBreaking = "checked";
                    YesPreviousRadio.setChecked(false);
                    PreviousPolicyLiner.setVisibility(View.GONE);
                    MonthsLeft=0;
                    strEndDateEdit="";
                    strTpEndDateEdit="";
                    strTpFromDateEdit="";
                    if (strVehicleTypeRadio.equals("Four Wheeler")){
                        // alertPopup();
                    }

                }
            }
        });

        ComprehensivePolicyRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ComprehensivePolicyRadio.isChecked()){
                    ComprehensivePolicyRadio.setChecked(true);
                    LiabilityRadio.setChecked(false);
                    OwnDamagedRadio.setChecked(false);
                    strEndDateEdit="";
                    endDateEdit.setText(strEndDateEdit);
                    StrPrev_Policy_Type="Comprehensive";

                    if (daysLeft < 91 && (!previousDate.equals("Previous"))) {
                        BonusLiner.setVisibility(View.VISIBLE);
                        NCBStatus="True";
                    }else if (daysLeft < 181 && (previousDate.equals("Previous"))) {
                        BonusLiner.setVisibility(View.VISIBLE);
                        NCBStatus="True";
                    }else{
                        if (daysLeft > 91 && (!previousDate.equals("Previous"))) {
                            Toast.makeText(Add_Details_Old_Vehicle.this, "Can't take Claim bonus as your previous policy end date is more than 90 days from today", Toast.LENGTH_SHORT).show();
                            BonusLiner.setVisibility(View.VISIBLE);
                            strClaimBonus="0";
                            NCBStatus="False";
                        }else{
                            Toast.makeText(Add_Details_Old_Vehicle.this, "Can't take Claim bonus as your previous policy end date is more than 6 Months from today", Toast.LENGTH_SHORT).show();
                            BonusLiner.setVisibility(View.VISIBLE);
                            strClaimBonus="0";
                            NCBStatus="False";
                        }

                    }
                }
            }
        });

        OwnDamagedRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (OwnDamagedRadio.isChecked()){
                    OwnDamagedRadio.setChecked(true);
                    ComprehensivePolicyRadio.setChecked(false);
                    StrPrev_Policy_Type="Own damage (standalone)";
                    strClaimBonus="0";
                    strEndDateEdit="";
                    strTpEndDateEdit="";
                    strTpFromDateEdit="";
                    TpEndDateEdit.setText(strEndDateEdit);
                    endDateEdit.setText(strEndDateEdit);
                    TpFromDateEdit.setText(strTpFromDateEdit);
                    SAODLiner.setVisibility(View.VISIBLE);
                    SAODLinerEffective.setVisibility(View.VISIBLE);
                }
            }
        });

        LiabilityRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (LiabilityRadio.isChecked()){
                    LiabilityRadio.setChecked(true);
                    ComprehensivePolicyRadio.setChecked(false);
                    StrPrev_Policy_Type="Liability";
                    BonusLiner.setVisibility(View.GONE);
                    SAODLiner.setVisibility(View.GONE);
                    strEndDateEdit="";
                    endDateEdit.setText(strEndDateEdit);
                    SAODLinerEffective.setVisibility(View.GONE);
                    strClaimBonus="0";
                    NCBStatus="False";
                }
            }
        });


        SpinnerCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    strCompanyName = vehicleCompanyList.get(position - 1).getCOMPANYNAME();
                    strCompanyCode=vehicleCompanyList.get(position - 1).getTXT_COMPANY_CODE();
                    CompanyNameEdit.setText(strCompanyName);
                    Log.e("CompanyNameCode",strCompanyName+strCompanyCode);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        YesPreviousClaimRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPreviousClaimRadio.isChecked()){
                    strPreviousClaimRadio="Yes";
                    strClaimBonus="0";
                    ClaimLiner.setVisibility(View.GONE);
                    YesPreviousClaimRadio.setChecked(true);
                    NoPreviousClaimRadio.setChecked(false);
                }
            }
        });

        NoPreviousClaimRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPreviousClaimRadio.isChecked()){
                    strPreviousClaimRadio="No";
                    ClaimLiner.setVisibility(View.VISIBLE);
                    YesPreviousClaimRadio.setChecked(false);
                    NoPreviousClaimRadio.setChecked(true);
                }
            }
        });

        zeroLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strClaimBonus="0";
                zeroLiner.setBackgroundResource(R.drawable.red_border_line);
                tenLiner.setBackgroundResource(R.drawable.light_grey_border_);
                twentyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                FortyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                fiftyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                sixtyLiner.setBackgroundResource(R.drawable.light_grey_border_);
            }
        });
        tenLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strClaimBonus="20";
                zeroLiner.setBackgroundResource(R.drawable.light_grey_border_);
                tenLiner.setBackgroundResource(R.drawable.red_border_line);
                twentyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                FortyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                fiftyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                sixtyLiner.setBackgroundResource(R.drawable.light_grey_border_);
            }
        });
        twentyLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strClaimBonus="25";
                zeroLiner.setBackgroundResource(R.drawable.light_grey_border_);
                tenLiner.setBackgroundResource(R.drawable.light_grey_border_);
                twentyLiner.setBackgroundResource(R.drawable.red_border_line);
                FortyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                fiftyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                sixtyLiner.setBackgroundResource(R.drawable.light_grey_border_);
            }
        });
        FortyLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strClaimBonus="35";
                zeroLiner.setBackgroundResource(R.drawable.light_grey_border_);
                tenLiner.setBackgroundResource(R.drawable.light_grey_border_);
                twentyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                FortyLiner.setBackgroundResource(R.drawable.red_border_line);
                fiftyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                sixtyLiner.setBackgroundResource(R.drawable.light_grey_border_);
            }
        });
        fiftyLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strClaimBonus="40";
                zeroLiner.setBackgroundResource(R.drawable.light_grey_border_);
                tenLiner.setBackgroundResource(R.drawable.light_grey_border_);
                twentyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                FortyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                fiftyLiner.setBackgroundResource(R.drawable.red_border_line);
                sixtyLiner.setBackgroundResource(R.drawable.light_grey_border_);
            }
        });
        sixtyLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strClaimBonus="50";
                zeroLiner.setBackgroundResource(R.drawable.light_grey_border_);
                tenLiner.setBackgroundResource(R.drawable.light_grey_border_);
                twentyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                FortyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                fiftyLiner.setBackgroundResource(R.drawable.light_grey_border_);
                sixtyLiner.setBackgroundResource(R.drawable.red_border_line);
            }
        });
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                try {
                    updateLabel();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };
        DatePickerDialog.OnDateSetListener date1 =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                showCalenderSaodEnd();
            }
        };

//        DatePickerDialog.OnDateSetListener date2 =new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int day) {
//                myCalendar.set(Calendar.YEAR, year);
//                myCalendar.set(Calendar.MONTH,month);
//                myCalendar.set(Calendar.DAY_OF_MONTH,day);
//                showCalenderTPEnd();
//            }
//        };
        DatePickerDialog.OnDateSetListener date3 =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                myCalendar = Calendar.getInstance();
                myCalendar.set(year, month, day);
                if (VehicleAgeAdd <3) {
                    TpEndCalendar.set(Calendar.YEAR, year);
                    TpEndCalendar.set(Calendar.MONTH, month);
                    TpEndCalendar.set(Calendar.DAY_OF_MONTH,day);
                    newDate1 = Calendar.getInstance();
                    newDate1.set(year+3, month, day-1);
                }else{
                    if (VehicleAgeAdd <5) {
                        TpEndCalendar.set(Calendar.YEAR, year);
                        TpEndCalendar.set(Calendar.MONTH, month);
                        TpEndCalendar.set(Calendar.DAY_OF_MONTH,day);
                        newDate1 = Calendar.getInstance();
                        newDate1.set(year+5, month, day-1);
                    }
                }


                TpEndCalendar.set(Calendar.YEAR, year);
                TpEndCalendar.set(Calendar.MONTH, month);
                TpEndCalendar.set(Calendar.DAY_OF_MONTH,day);
                showCalenderTPEnd();
            }
        };
        DatePickerDialog.OnDateSetListener date4 =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                TpEndCalendar.set(Calendar.YEAR, year);
                TpEndCalendar.set(Calendar.MONTH,month);
                TpEndCalendar.set(Calendar.DAY_OF_MONTH,day);
                showCalenderTPFrom();
            }
        };

        endDateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Add_Details_Old_Vehicle.this,R.style.MyDatePickerStyle_,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
        EndDateIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Add_Details_Old_Vehicle.this,R.style.MyDatePickerStyle_,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//                showCalender();

            }
        });

        SaodEndDateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Add_Details_Old_Vehicle.this,R.style.MyDatePickerStyle_,date1,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        TpEndDateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderTPEnd();
//                new DatePickerDialog(Add_Details_Old_Vehicle.this,R.style.MyDatePickerStyle_,date3,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        TpFromDateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new DatePickerDialog(Add_Details_Old_Vehicle.this,R.style.MyDatePickerStyle_,date4,TpEndCalendar.get(Calendar.YEAR),TpEndCalendar.get(Calendar.MONTH)+1,TpEndCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        backAddDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backMethod();
//                if (getFragmentManager().getBackStackEntryCount() > 0) {
//                    getFragmentManager().popBackStack();
//                    Add_Details_Old_Vehicle.super.onBackPressed();
//
//                }else {
//                    Add_Details_Old_Vehicle.super.onBackPressed();
//                }
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NoPreviousRadio.isChecked()){
                    nextMethod();
                }else{
                    strPolicyNumberEdit=policyNumberEdit.getText().toString();
                    strEndDateEdit=endDateEdit.getText().toString();
                    strTpEndDateEdit=TpEndDateEdit.getText().toString();
                    strTpFromDateEdit=TpFromDateEdit.getText().toString();
                    if (strPolicyNumberEdit.equals("")){
                        Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Policy Number", Toast.LENGTH_SHORT).show();
                    }else  if (strCompanyName.equals("Select Company")){
                        Toast.makeText(Add_Details_Old_Vehicle.this, "Select company ", Toast.LENGTH_SHORT).show();
                    }else if (strEndDateEdit.equals("")){
                        Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Policy End Date", Toast.LENGTH_SHORT).show();
                    }else{
                        if (strVehicleTypeRadio.equals("Four Wheeler")) {
                            if (VehicleAgeAdd <3) {
                                if (strTpFromDateEdit.equals("")){
                                    Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Policy From Date", Toast.LENGTH_SHORT).show();
                                }else if (strTpEndDateEdit.equals("")){
                                    Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Policy To Date", Toast.LENGTH_SHORT).show();
                                }else{
                                    nextMethod();
                                }
                            }else{
                                nextMethod();
                            }
                        }else{
                            if (VehicleAgeAdd <5) {
                                if (strTpFromDateEdit.equals("")){
                                    Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Policy From Date", Toast.LENGTH_SHORT).show();
                                }else if (strTpEndDateEdit.equals("")){
                                    Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Policy To Date", Toast.LENGTH_SHORT).show();
                                }else{
                                    nextMethod();
                                }
                            }else{
                                nextMethod();
                            }
                        }
                    }
                }

            }
        });

    }


    private void nextMethod() {
        strPolicyNumberEdit=policyNumberEdit.getText().toString();
        strEndDateEdit=endDateEdit.getText().toString();
        strTpEndDateEdit=TpEndDateEdit.getText().toString();
        strTpFromDateEdit=TpFromDateEdit.getText().toString();
        if (StrPreviousPolicyRadio.equals("Yes")){
            if (strPolicyNumberEdit.equals("")){
                Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Policy Number", Toast.LENGTH_SHORT).show();
            }
//                    else if (!strPolicyNumberEdit.contains("/")){
//                        Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Valid Policy Number", Toast.LENGTH_SHORT).show();
//                    }
            else  if (strCompanyName.equals("Select Company")){
                Toast.makeText(Add_Details_Old_Vehicle.this, "Select company ", Toast.LENGTH_SHORT).show();
            }else if (strEndDateEdit.equals("")){
                Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Policy End Date", Toast.LENGTH_SHORT).show();
            }else if(StrPrev_Policy_Type.equals("Own damage (standalone)")){
                if (strVehicleTypeRadio.equals("Four Wheeler")) {
                    if (VehicleAgeAdd <3) {
                        if (strTpEndDateEdit.equals("")){
                            Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Tp Policy effective From Date", Toast.LENGTH_SHORT).show();
                        }else if (strEndDateEdit.equals(strTpEndDateEdit)){
                            if (strTpFromDateEdit.equals("")){
                                Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Tp Policy effective To Date", Toast.LENGTH_SHORT).show();
                            }else if (strTpEndDateEdit.equals(strTpFromDateEdit)){
                                Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Tp Policy effective To Date and From Date not to be same", Toast.LENGTH_SHORT).show();
                            }else if (strPreviousClaimRadio.equals("No")){
                                if (strClaimBonus.equals("")){
                                    Toast.makeText(Add_Details_Old_Vehicle.this, "Choose Claim Bonus", Toast.LENGTH_SHORT).show();
                                }else{
                                    continueMethod();
                                }
                            }else{
                                continueMethod();
                            }
                        }else if (strTpFromDateEdit.equals("")){
                            Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Tp Policy effective From Date", Toast.LENGTH_SHORT).show();
                        }else if (strTpEndDateEdit.equals(strTpFromDateEdit)){
                            Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Tp Policy effective To Date and From Date not to be same", Toast.LENGTH_SHORT).show();
                        }else if (strPreviousClaimRadio.equals("No")){
                            if (strClaimBonus.equals("")){
                                Toast.makeText(Add_Details_Old_Vehicle.this, "Choose Claim Bonus", Toast.LENGTH_SHORT).show();
                            }else{
                                continueMethod();
                            }
                        }else{
                            continueMethod();
                        }
                    }else{
                        if (strPreviousClaimRadio.equals("No")){
                            if (strClaimBonus.equals("")){
                                Toast.makeText(Add_Details_Old_Vehicle.this, "Choose Claim Bonus", Toast.LENGTH_SHORT).show();
                            }else{
                                continueMethod();
                            }
                        }else{
                            continueMethod();
                        }
                    }
                }
                else if (strVehicleTypeRadio.equals("Two Wheeler")){
                    if (VehicleAgeAdd <5) {
                        if (strTpEndDateEdit.equals("")){
                            Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Tp Policy effective From Date", Toast.LENGTH_SHORT).show();
                        }else if (strEndDateEdit.equals(strTpEndDateEdit)){
                            if (strTpFromDateEdit.equals("")){
                                Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Tp Policy effective To Date", Toast.LENGTH_SHORT).show();
                            }else if (strTpEndDateEdit.equals(strTpFromDateEdit)){
                                Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Tp Policy effective To Date and From Date not to be same", Toast.LENGTH_SHORT).show();
                            }else if (strPreviousClaimRadio.equals("No")){
                                if (strClaimBonus.equals("")){
                                    Toast.makeText(Add_Details_Old_Vehicle.this, "Choose Claim Bonus", Toast.LENGTH_SHORT).show();
                                }else{
                                    continueMethod();
                                }
                            }else{
                                continueMethod();
                            }
                        }else if (strTpFromDateEdit.equals("")){
                            Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Tp Policy effective To Date", Toast.LENGTH_SHORT).show();
                        }else if (strTpEndDateEdit.equals(strTpFromDateEdit)){
                            Toast.makeText(Add_Details_Old_Vehicle.this, "Enter Tp Policy effective To Date and From Date not to be same", Toast.LENGTH_SHORT).show();
                        }else if (strPreviousClaimRadio.equals("No")){
                            if (strClaimBonus.equals("")){
                                Toast.makeText(Add_Details_Old_Vehicle.this, "Choose Claim Bonus", Toast.LENGTH_SHORT).show();
                            }else{
                                continueMethod();
                            }
                        }else{
                            continueMethod();
                        }
                    }else{
                        if (strPreviousClaimRadio.equals("No")){
                            if (strClaimBonus.equals("")){
                                Toast.makeText(Add_Details_Old_Vehicle.this, "Choose Claim Bonus", Toast.LENGTH_SHORT).show();
                            }else{
                                continueMethod();
                            }
                        }else{
                            continueMethod();
                        }
                    }
                }
                else if (strPreviousClaimRadio.equals("No")){
                    if (strClaimBonus.equals("")){
                        Toast.makeText(Add_Details_Old_Vehicle.this, "Choose Claim Bonus", Toast.LENGTH_SHORT).show();
                    }else{
                        continueMethod();
                    }
                }
                else{
                    continueMethod();
                }
            }else if (strPreviousClaimRadio.equals("No")){
                if (strClaimBonus.equals("")){
                    Toast.makeText(Add_Details_Old_Vehicle.this, "Choose Claim Bonus", Toast.LENGTH_SHORT).show();
                }else{
                    continueMethod();
                }
            }
            else{
                continueMethod();
            }
        }
        else {
            strEndDateEdit="";
            strTpEndDateEdit="";
            continueMethod();
        }
    }

    private void continueMethod() {
        Intent intent=new Intent(Add_Details_Old_Vehicle.this, OldMotorAddOns.class);
        intent.putExtra("strBreaking",strBreaking);
        intent.putExtra("previousDate",previousDate);
        intent.putExtra("strVehicleNo",strVehicleNo);
        intent.putExtra("strGenderSpinner",strGenderSpinner);
        intent.putExtra("streditdob",streditdob);
        intent.putExtra("ckycNo",ckycNo);
        intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
        intent.putExtra("strIDType",strIDType);
        intent.putExtra("strIDTypeName",strIDTypeName);
        intent.putExtra("strIDNumberEdit",strIDNumberEdit);
        intent.putExtra("strName",strName);
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
        intent.putExtra("strIDTypeName1",strIDTypeName1);
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
        intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
        intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
        intent.putExtra("selectYear",selectYear);
        intent.putExtra("VehicleAgeAdd",VehicleAgeAdd);
        intent.putExtra("MonthsLeft",MonthsLeft);
        intent.putExtra("daysLeft",daysLeft);
        intent.putExtra("NCBStatus",NCBStatus);
        intent.putExtra("a",a);
        intent.putExtra("b",b);
        intent.putExtra("c",c);
        intent.putExtra("strFor",strFor);
        intent.putExtra("strNewFor","0");
        intent.putExtra("CheckString","0");
        intent.putExtra("changeseekBar","0");
        intent.putExtra("ChangeAddons","0");
        startActivity(intent);
        finish();
    }
    private void backMethod() {
        strPolicyNumberEdit=policyNumberEdit.getText().toString();
        Intent intent=new Intent(Add_Details_Old_Vehicle.this, Private_car_vehicle_details.class);
        intent.putExtra("strVehicleNo",strVehicleNo);
        intent.putExtra("strName",strName);
        intent.putExtra("strGenderSpinner",strGenderSpinner);
        intent.putExtra("streditdob",streditdob);
        intent.putExtra("ckycNo",ckycNo);
        intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
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
        intent.putExtra("strIDTypeName1",strIDTypeName1);
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
        intent.putExtra("NCBStatus",NCBStatus);
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
        intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
        intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
        intent.putExtra("selectYear",selectYear);
        intent.putExtra("VehicleAgeAdd",VehicleAgeAdd);
        intent.putExtra("MonthsLeft",MonthsLeft);
        intent.putExtra("daysLeft",daysLeft);
        intent.putExtra("a",a);
        intent.putExtra("b",b);
        intent.putExtra("c",c);
        intent.putExtra("strFor","1");
        intent.putExtra("strNewFor","0");
        intent.putExtra("CheckString","0");
        intent.putExtra("changeseekBar","0");
        intent.putExtra("ChangeAddons","0");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
//        overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);
        finish();
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
                    str_vehicleManufacturerNm=jsonObject.getString("rc_maker_desc");
                    strVehicleModel=jsonObject.getString("rc_maker_model");
                    str_edt_registration_date1=jsonObject.getString("rc_regn_dt");
                    strStateCode=jsonObject.getString("state_code");
                    strStateName=jsonObject.getString("rc_registered_at");
                    strRTOCode=jsonObject.getString("rc_rto_code");
                    strVehicleChasisNumber=jsonObject.getString("rc_chasi_no");
                    strVehicleEngineNumber=jsonObject.getString("rc_eng_no");
                    String rc_cubic_cap1=jsonObject.getString("rc_cubic_cap");
                    rc_fuel_desc=jsonObject.getString("rc_fuel_desc");

                    String[] str_rc_cubic_cap = rc_cubic_cap1.split("[.]", 0);
                    rc_cubic_cap= str_rc_cubic_cap[0];
                    Log.e("rc_cubic_cap1",rc_cubic_cap);
                    String str_rc_cubic_cap2 = str_rc_cubic_cap[1];
                    Log.e("str_rc_cubic_cap2",str_rc_cubic_cap2);


                    String[] strFuel = rc_fuel_desc.split("/");
                    String strFuel1 = strFuel[0];
                    FuleType=strFuel1;
                    JSONArray jsonArray=jsonObject.getJSONArray("pass_id_data");

                    for (int i=0; i <jsonArray.length();i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                        strVehicleManufacturerCode=jsonObject1.getString("make_id");
                        strVehicleModelCode=jsonObject1.getString("model_id");
                        uidStr=jsonObject1.getString("uid");
                    }
                    if (strVehicleTypeRadio.equals("Four Wheeler")){
                        if(uidStr.equals("4W")){
                            confirmButton.setVisibility(View.VISIBLE);
                        }else{
                            confirmButton.setVisibility(View.GONE);
                            Toast.makeText(Add_Details_Old_Vehicle.this, "It's not for Four Wheeler Please Enter Four Wheeler number  ", Toast.LENGTH_SHORT).show();
                        }
                    }else if (strVehicleTypeRadio.equals("Two Wheeler")){
                        if(uidStr.equals("2W")){
                            confirmButton.setVisibility(View.VISIBLE);
                        }else{
                            confirmButton.setVisibility(View.GONE);
                            Toast.makeText(Add_Details_Old_Vehicle.this, "It's not for Two Wheeler Please Enter Two Wheeler number  ", Toast.LENGTH_SHORT).show();
                        }
                    }

                    String[] strCity = strStateName.split("[ ,]+");
                    String str1City = strCity[0]; // I
                    strRTOName=str1City;

                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy  hh:mm a");
                    String date = format.format(Date.parse(str_edt_registration_date1));
                    Log.e("date", String.valueOf(date));

                    String[] str_date = date.split("\\s+");
                    str_edt_registration_date = str_date[0];
                    String str_edt_registration_date23 = str_date[1];

                    Log.e("str_edt_registration_date11",str_edt_registration_date);
//                    str_edt_registration_date = String.valueOf(dateRegistration).replace("-","/");
                    String[] strParts = str_edt_registration_date.split("/");
                    String strFirstString = strParts[0];
                    String strSecondString = strParts[1];
                    yearOfManufacture = strParts[2];
                    String myFormat="dd/MM/yyyy";
                    SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
                    try {
                        Log.e("str_edt_registration_date",str_edt_registration_date);
                        SelectDate = dateFormat.parse(str_edt_registration_date);
                        CurrentDate = dateFormat.parse(today);
                        long selectNewDate = SelectDate.getTime();
                        long TodayendDate = CurrentDate.getTime();
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            period = new Period(selectNewDate,TodayendDate, PeriodType.yearMonthDay());
                            VehicleAgeAdd = period.getYears();
                            int SelectMonth1 = period.getMonths();
                            int SelectDays1 = period.getDays();
                            Log.e("VehicleAgeAdd", String.valueOf(VehicleAgeAdd));
                        }
                        if (strVehicleTypeRadio.equals("Four Wheeler")) {
                            if (VehicleAgeAdd <3) {
                                OwnDamagedRadio.setVisibility(View.VISIBLE);
                                LiabilityRadio.setVisibility(View.GONE);
                                SAODLiner.setVisibility(View.VISIBLE);
                                SAODLinerEffective.setVisibility(View.VISIBLE);
//                                if (!(strEndDateEdit.equals("")&&strTpEndDateEdit.equals(""))){
//                                    if (MonthsLeft >3){
//                                        OwnDamagedRadio.setVisibility(View.VISIBLE);
//                                        OwnDamagedRadio.setClickable(true);
//                                    } else{
//                                        OwnDamagedRadio.setVisibility(View.VISIBLE);
//                                    }
//                                }else{
//                                    OwnDamagedRadio.setVisibility(View.VISIBLE);
//                                    OwnDamagedRadio.setClickable(true);
//                                }
                            }else{
                                OwnDamagedRadio.setVisibility(View.GONE);
                                LiabilityRadio.setVisibility(View.VISIBLE);
                                SAODLiner.setVisibility(View.GONE);
                                SAODLinerEffective.setVisibility(View.GONE);
                            }
                        }else{
                            if (VehicleAgeAdd <5) {
                                OwnDamagedRadio.setVisibility(View.VISIBLE);
                                LiabilityRadio.setVisibility(View.GONE);
                                SAODLiner.setVisibility(View.VISIBLE);
                                SAODLinerEffective.setVisibility(View.VISIBLE);
//                                if(!strEndDateEdit.equals("")&&strTpEndDateEdit.equals("")){
//                                    if (MonthsLeft >3){
//                                        OwnDamagedRadio.setVisibility(View.VISIBLE);
//                                        OwnDamagedRadio.setClickable(true);
//                                    } else{
//                                        OwnDamagedRadio.setVisibility(View.VISIBLE);
//                                    }
//                                }else{
//                                    OwnDamagedRadio.setVisibility(View.VISIBLE);
//                                    OwnDamagedRadio.setClickable(true);
//                                }
                            }else{
                                OwnDamagedRadio.setVisibility(View.GONE);
                                LiabilityRadio.setVisibility(View.VISIBLE);
                                SAODLiner.setVisibility(View.GONE);
                                SAODLinerEffective.setVisibility(View.GONE);
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
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
                Toast.makeText(Add_Details_Old_Vehicle.this, "No Data Found For This Vehicle Number...Please Enter Valid Vehicle Number ", Toast.LENGTH_SHORT).show();
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
    private void VehicleAllCompanyMaster() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
        }catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Add_Details_Old_Vehicle.this, object, UrlConstants.BUYVehicleAllCompany_Master, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    if (Tag == RequestConstants.BUY_POLICY_MOTOR_PRIVATE_Company) {
                        JSONArray arr = null;
                        try {
                            vehicleCompanyList.clear();
                            itemsCompany.clear();
                            itemsCompany.add("Select Company");

                            arr = object.getJSONArray("ALLCOMPANY");
                            for (int i = 0; i <arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(i);
                                companyModel = new Gson().fromJson(obj.toString(), CompanyModel.class);
                                vehicleCompanyList.add(companyModel);
                            }for(int k=0;k<vehicleCompanyList.size();k++){
                                itemsCompany.add(vehicleCompanyList.get(k).getCOMPANYNAME());
                            }
                            SpinnerCompany.setAdapter(new ArrayAdapter<>(Objects.requireNonNull(getApplicationContext()),R.layout.spinner_motor, itemsCompany));
//                            singlePicker = new MyOptionsPickerView(Add_Details_Old_Vehicle.this);
//                            singlePicker.setPicker(itemsCompany);
//                            singlePicker.setCyclic(false);
//                            singlePicker.setSelectOptions(0);
//                            singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                                @Override
//                                public void onOptionsSelect(int options1, int option2, int options3) {
//                                    strCompanyName=vehicleCompanyList.get(options1).getCOMPANYNAME();
//                                    strCompanyCode=vehicleCompanyList.get(options1).getTXT_COMPANY_CODE();
//                                    CompanyNameEdit.setText(strCompanyName);
//
//
//                                }
//                            });
//                            singlePicker.show();
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
    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        DatePickerDialog datePicker = new DatePickerDialog(Add_Details_Old_Vehicle.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strEndDateEdit=dateFormatter.format(newDate.getTime());
            endDateEdit.setText(strEndDateEdit);
            String[] strParts = strEndDateEdit.split("/");
            String strFirstString = strParts[0];
            String strSecondString = strParts[1];
            yearOfManufactureEndDate = strParts[2];

//            edt_city.setText(dateFormatter.format(newDate.getTime()));
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalenderSaodEnd() {
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        strSaodEndDateEdit=dateFormat.format(myCalendar.getTime());
        SaodEndDateEdit.setText(strSaodEndDateEdit);
    }

    public void showCalenderTPEnd() {
        int newYearOfManufacture= Integer.parseInt(yearOfManufacture);
        int newYearOfManufactureMonth= Integer.parseInt(yearOfManufactureMonth);
        int newYearOfManufactureDay= Integer.parseInt(strSelectDateYear);
        Calendar newCalendar = Calendar.getInstance();
        Calendar newCalendar1 = Calendar.getInstance();
        newCalendar.set(newYearOfManufacture, newYearOfManufactureMonth, newYearOfManufactureDay);
        if (newYearOfManufactureMonth <7){
            newCalendar1.set(newYearOfManufacture-1, 6, 1);
        }else{
            newCalendar1.set(newYearOfManufacture, 6, 1);
        }

        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Add_Details_Old_Vehicle.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strTpEndDateEdit=dateFormatter.format(newDate.getTime());
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(str_edt_registration_date,formatter);
                LocalDate end = LocalDate.parse(strTpEndDateEdit,formatter);
                String MonthsPolicyFromDate = String.valueOf(ChronoUnit.MONTHS.between(end, start));
                int MonthsPolicyFromDateInt= Integer.parseInt(MonthsPolicyFromDate);
                Log.e("MonthsPolicyFromDate",MonthsPolicyFromDate);
                if(MonthsPolicyFromDateInt >= 6){
                    Toast.makeText(Add_Details_Old_Vehicle.this, "Can't select date as your OD Policy effective date is more than 6 Month days from purchase date", Toast.LENGTH_LONG).show();
                    strTpEndDateEdit="";
                }
            }
            TpEndDateEdit.setText(strTpEndDateEdit);
            if (strVehicleTypeRadio.equals("Four Wheeler")) {
                if (VehicleAgeAdd <3) {
                    TpEndCalendar.set(Calendar.YEAR, year);
                    TpEndCalendar.set(Calendar.MONTH, monthOfYear);
                    TpEndCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                    newDate1 = Calendar.getInstance();
                    newDate1.set(year+3, monthOfYear, dayOfMonth-1);
                    dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
                    strTpFromDateEdit=dateFormatter.format(newDate1.getTime());
                    TpFromDateEdit.setText(strTpFromDateEdit);
                }
            }else{
                if (VehicleAgeAdd <5) {
                    TpEndCalendar.set(Calendar.YEAR, year);
                    TpEndCalendar.set(Calendar.MONTH, monthOfYear);
                    TpEndCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                    newDate1 = Calendar.getInstance();
                    newDate1.set(year+5, monthOfYear, dayOfMonth-1);
                    dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
                    strTpFromDateEdit=dateFormatter.format(newDate1.getTime());
                    TpFromDateEdit.setText(strTpFromDateEdit);

                }
            }
            if (!(strEndDateEdit.equals("")&&strTpEndDateEdit.equals(""))){
                if (strEndDateEdit.equals(strTpEndDateEdit)){
//                    OwnDamagedRadio.setClickable(false);
                    OwnDamagedRadio.setVisibility(View.VISIBLE);
//                    ComprehensivePolicyRadio.setChecked(true);
//                    OwnDamagedRadio.setChecked(false);
//                    StrPrev_Policy_Type="Comprehensive";
                }
                else {
                    if (!strEndDateEdit.equals("")) {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate start = LocalDate.parse(strEndDateEdit, formatter);
                            LocalDate end = LocalDate.parse(strTpEndDateEdit, formatter);
                            String MonthsPolicy = String.valueOf(ChronoUnit.MONTHS.between(start, end));
                            int MonthsLeft1= Integer.parseInt(MonthsPolicy);
                            Log.e("MonthsLeft",String.valueOf(ChronoUnit.MONTHS.between(start, end)));

                            if (0<=MonthsLeft1){
                                MonthsLeft=MonthsLeft1;
                                Log.e("MonthsLeft", String.valueOf(MonthsLeft));
                            }else{
                                String strYear= String.valueOf(MonthsLeft1);
                                String[] strParts1 = strYear.split("-");
                                String strFirstString1 = strParts1[0];
                                String strSecondString1 = strParts1[1];
                                MonthsLeft= Integer.parseInt(strSecondString1);
                                Log.e("MonthsLeft", String.valueOf(MonthsLeft));
                            }
                        }
                        if (MonthsLeft >3) {
                            OwnDamagedRadio.setVisibility(View.VISIBLE);
                            OwnDamagedRadio.setClickable(true);
                        } else {
//                            OwnDamagedRadio.setClickable(false);
                            OwnDamagedRadio.setVisibility(View.VISIBLE);
//                            ComprehensivePolicyRadio.setChecked(true);
//                            OwnDamagedRadio.setChecked(false);
//                            StrPrev_Policy_Type = "Comprehensive";
                        }
                    } else {
                        if (strVehicleTypeRadio.equals("Four Wheeler")) {
                            if (VehicleAgeAdd < 3) {
                                OwnDamagedRadio.setVisibility(View.VISIBLE);
                                LiabilityRadio.setVisibility(View.GONE);
                            } else {
                                OwnDamagedRadio.setVisibility(View.GONE);
                                LiabilityRadio.setVisibility(View.VISIBLE);
                            }
                        } else {
                            if (VehicleAgeAdd < 5) {
                                OwnDamagedRadio.setVisibility(View.VISIBLE);
                                LiabilityRadio.setVisibility(View.GONE);
                            } else {
                                OwnDamagedRadio.setVisibility(View.GONE);
                                LiabilityRadio.setVisibility(View.VISIBLE);
                            }

                        }
                    }
                }
            }
            else{
                OwnDamagedRadio.setVisibility(View.VISIBLE);
                OwnDamagedRadio.setClickable(true);
            }

        },
                newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePicker.getDatePicker().setMinDate(newCalendar1.getTimeInMillis());
        datePicker.getDatePicker().setMaxDate(newCalendar.getTimeInMillis());

        datePicker.show();

    }
    private void showCalenderTPFrom() {
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        strTpFromDateEdit=dateFormat.format(TpEndCalendar.getTime());
        TpFromDateEdit.setText(strTpFromDateEdit);

//        Calendar newCalendar = Calendar.getInstance();
//        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
//        DatePickerDialog datePicker = new DatePickerDialog(Add_Details_Old_Vehicle.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
//            Calendar newDate = Calendar.getInstance();
//            newDate.set(year, monthOfYear, dayOfMonth);
//            strTpFromDateEdit=dateFormatter.format(newDate.getTime());
//            TpFromDateEdit.setText(strTpFromDateEdit);
//        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
//
//        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
//        datePicker.show();
    }
    private void updateLabel() throws ParseException {
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        strEndDateEdit=dateFormat.format(myCalendar.getTime());
        endDateEdit.setText(strEndDateEdit);
        String[] strParts = strEndDateEdit.split("/");
        String strFirstString = strParts[0];
        String strSecondString = strParts[1];
        yearOfManufactureEndDate = strParts[2];
        try {
            Log.e("strEndDateEdit",strEndDateEdit);
            SelectDate = dateFormat.parse(strEndDateEdit);
            CurrentDate = dateFormat.parse(today);
            long selectNewDate = SelectDate.getTime();
            long TodayendDate = CurrentDate.getTime();
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                period = new Period(TodayendDate,selectNewDate, PeriodType.yearMonthDay());
                int selectYear1 = period.getYears();
                int SelectMonth1 = period.getMonths();
                SelectDays = period.getDays();
                Log.e("selectYear", String.valueOf(selectYear1));
                Log.e("SelectMonth", String.valueOf(SelectMonth1));
                Log.e("SelectDays", String.valueOf(SelectDays));

                if (0<=selectYear1){

                }else{
                    String strYear= String.valueOf(selectYear1);
                    String[] strParts1 = strYear.split("-");
                    String strFirstString1 = strParts1[0];
                    String strSecondString1 = strParts1[1];
                    selectYear= Integer.parseInt(strSecondString1);
                    Log.e("selectYear", String.valueOf(selectYear));
                }
            }
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(today,formatter);
                LocalDate end = LocalDate.parse(strEndDateEdit,formatter);
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date  today_Date = sdf.parse(today);
                    strEndDate = sdf.parse(strEndDateEdit);
                    if (strEndDate.getTime()>today_Date.getTime()){
                        String day1=String.valueOf(ChronoUnit.DAYS.between(start, end));
                        daysLeft= Integer.parseInt(day1);
                        Log.e("daysLeft", String.valueOf(ChronoUnit.DAYS.between(end, start)));
                        if (daysLeft > 91) {
                            Toast.makeText(Add_Details_Old_Vehicle.this, "Can't select date as your previous policy end date is more than 90 days from today", Toast.LENGTH_LONG).show();
                            strEndDateEdit="";
                        }
                        endDateEdit.setText(strEndDateEdit);

                    }else if (strEndDate.getTime()<today_Date.getTime()){
                        String days=String.valueOf(ChronoUnit.DAYS.between(end, start));
                        String Month=String.valueOf(ChronoUnit.MONTHS.between(end, start));
                        daysLeft= Integer.parseInt(days);
                        int MonthLeft= Integer.parseInt(Month);
                        Log.e("MonthLeft",Month);
                        Log.e("daysLeft", String.valueOf(ChronoUnit.DAYS.between(end, start)));
                        if(MonthLeft > 6){
                            Toast.makeText(Add_Details_Old_Vehicle.this, "Can't select date as your previous policy end date is more than 6 Month days from today", Toast.LENGTH_LONG).show();
                            strEndDateEdit="";

                        }else if (daysLeft > 91 ) {
                            Toast.makeText(Add_Details_Old_Vehicle.this, "Can't take Claim bonus as your previous policy end date is more than 90 days from today", Toast.LENGTH_LONG).show();
                            BonusLiner.setVisibility(View.GONE);
                            strClaimBonus="0";
                            NCBStatus="False";
                            confirmButton.setVisibility(View.VISIBLE);
                        }
                        endDateEdit.setText(strEndDateEdit);
                    }else{
                        String day1=String.valueOf(ChronoUnit.DAYS.between(start, end));
                        daysLeft= Integer.parseInt(day1);
                        Log.e("daysLeft", String.valueOf(ChronoUnit.DAYS.between(end, start)));
                        endDateEdit.setText(strEndDateEdit);
                    }

                }
                catch (ParseException e) {
                    e.printStackTrace();
                }

            }

            if (!(strEndDateEdit.equals("")&&strTpEndDateEdit.equals("")||strTpEndDateEdit==null||strTpEndDateEdit.equals("null"))){
                if (strEndDateEdit.equals(strTpEndDateEdit)){
                    OwnDamagedRadio.setVisibility(View.VISIBLE);
                    ComprehensivePolicyRadio.setChecked(true);
                }
                else{
                    if (!strEndDateEdit.equals("")){
                        if (!strTpEndDateEdit.equals("")){
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate start = LocalDate.parse(strEndDateEdit,formatter);
                                LocalDate end = LocalDate.parse(strTpEndDateEdit,formatter);
                                String MonthsPolicy=String.valueOf(ChronoUnit.MONTHS.between(start, end));
                                int MonthsLeft1= Integer.parseInt(MonthsPolicy);
                                Log.e("MonthsLeft",String.valueOf(ChronoUnit.MONTHS.between(start, end)));
                                if (0<=MonthsLeft1){
                                    MonthsLeft=MonthsLeft1;
                                }else{
                                    String strYear= String.valueOf(MonthsLeft1);
                                    String[] strParts1 = strYear.split("-");
                                    String strFirstString1 = strParts1[0];
                                    String strSecondString1 = strParts1[1];
                                    MonthsLeft= Integer.parseInt(strSecondString1);
                                }
                                Log.e("MonthsLeft", String.valueOf(MonthsLeft));
                            }
                            if (MonthsLeft >3){
                                OwnDamagedRadio.setVisibility(View.VISIBLE);
                                OwnDamagedRadio.setClickable(true);
                            }else{
//                                OwnDamagedRadio.setClickable(false);
                                OwnDamagedRadio.setVisibility(View.VISIBLE);
                                //   ComprehensivePolicyRadio.setChecked(true);
                                //   OwnDamagedRadio.setChecked(false);
                                //   StrPrev_Policy_Type="Comprehensive";
                            }
                        }
                        else{
                            if (strVehicleTypeRadio.equals("Four Wheeler")) {
                                if (VehicleAgeAdd < 3) {
                                    OwnDamagedRadio.setVisibility(View.VISIBLE);
                                    LiabilityRadio.setVisibility(View.GONE);
                                } else {
                                    OwnDamagedRadio.setVisibility(View.GONE);
                                    LiabilityRadio.setVisibility(View.VISIBLE);
                                }
                            }
                            else {
                                if (VehicleAgeAdd < 5) {
                                    OwnDamagedRadio.setVisibility(View.VISIBLE);
                                    LiabilityRadio.setVisibility(View.GONE);
                                } else {
                                    OwnDamagedRadio.setVisibility(View.GONE);
                                    LiabilityRadio.setVisibility(View.VISIBLE);
                                }

                            }
                        }
                    }
                }
            }
            else{
                if (strVehicleTypeRadio.equals("Four Wheeler")) {
                    if (VehicleAgeAdd <3) {
                        OwnDamagedRadio.setVisibility(View.VISIBLE);
                        LiabilityRadio.setVisibility(View.GONE);
                        SAODLiner.setVisibility(View.VISIBLE);
                        SAODLinerEffective.setVisibility(View.VISIBLE);
                    }else{
                        OwnDamagedRadio.setVisibility(View.GONE);
                        LiabilityRadio.setVisibility(View.VISIBLE);
                        SAODLiner.setVisibility(View.GONE);
                        SAODLinerEffective.setVisibility(View.GONE);
                    }
                }
                else{
                    if (VehicleAgeAdd <5) {
                        OwnDamagedRadio.setVisibility(View.VISIBLE);
                        LiabilityRadio.setVisibility(View.GONE);
                        SAODLiner.setVisibility(View.VISIBLE);
                        SAODLinerEffective.setVisibility(View.VISIBLE);
                    }else{
                        OwnDamagedRadio.setVisibility(View.GONE);
                        LiabilityRadio.setVisibility(View.VISIBLE);
                        SAODLiner.setVisibility(View.GONE);
                        SAODLinerEffective.setVisibility(View.GONE);
                    }
                }
//                OwnDamagedRadio.setVisibility(View.VISIBLE);
//                OwnDamagedRadio.setClickable(true);
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        switch (parent.getId()) {
//            case R.id.SpinnerCompany:
//                if (position > 0) {
//                    strCompanyName = vehicleCompanyList.get(position - 1).getCOMPANYNAME();
//                    strCompanyCode=vehicleCompanyList.get(position - 1).getTXT_COMPANY_CODE();
//                   CompanyNameEdit.setText(strCompanyName);
//                    Log.e("CompanyNameCode",strCompanyName);
//                }
//                break;
//        }
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }

    @Override
    public void onBackPressed() {
        backMethod();

    }

    private void clearMethod() {
        strVehicleRadio="Old";
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
        strVehicleNumber="";
        strVehicleChasisNumber="";
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
    private void alertPopup() {
        Dialog dialogPopup;
        dialogPopup = new Dialog(Add_Details_Old_Vehicle.this);
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
                if (daysLeft < 91) {
                    nextMethod();
                }

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

}