package com.universalsompo.meta.metaapp.motor.activities.motor_policies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ImageView;
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
import com.squareup.picasso.Picasso;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.activities.hospital.adapter.Hospital_adapter;
import com.universalsompo.meta.metaapp.health.activities.hospital.model.HospitalModel;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.FragmentDashBoardHealth;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.BuyPolicySumInsured;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.RegisterActivity;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.MotorRTOModel;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.MotorState;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.MotorVehicleModel;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.VehicleManufacturerModel;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Add_Details_Old_Vehicle;
import com.universalsompo.meta.metaapp.motor.activities.policy_fragment.Motor_Private_car;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentDashBoard;
import com.universalsompo.meta.metaapp.motor.models.MyPolicyModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Private_car_vehicle_details extends AppCompatActivity {
    Button btn_previous,btn_next;
    EditText rto_location,edt_registration_date,StateEditText,vehicle_model,vehicleBrand;
    private SimpleDateFormat dateFormatter;
    public Period period;
    Spinner manufacture_year_spinner;
    String[] selectYear1;
    TextView ModelNameTxt;
    int check = 0;
    Date date,CurrentDate,SelectDate;
    int MonthsLeft,VehicleAgeAdd,SelectRegistrationMonth,strYearOfManufacture,progressChanged,progressChanged1,a,b,c,selectYear,daysLeft;
    String  strIDTypeName1,ckycNo,uniqueTransactionNumber,yearOfManufactureMonth,yearOfManufactureDay,strSelectDateYear,AutoMobileValidityRadio,strDiscountEdit,str_edt_registration_date1,uidStr,strTpFromDateEdit="",strTpEndDateEdit="",ELECTRICALACCESSORYODSumInsured,NONELECTRICALACCESSORYODSumInsured,strElectricalAccessoriesSumInsured,strNonelectricalAccessoriesSumInsured,PACOVERTOPASSENGERSSumInsured,UNNAMEDPACOVERTOPASSENGERSSumInsured, PACOVERTOPAIDDRIVERSumInsured,strCngKitSumInsured,AutoMobileRadio,AutomobileAssociationdiscountSumInsured,VoluntarydeductableSumInsured,strMinMax,AntitheftdevicediscountStatus,AutomobileAssociationdiscountStatus,TPPDDiscountStatus,HandicapDiscountStatus,VoluntarydeductableStatus,AdditionalNonElecticalODSumInsuredValue,AdditionalElectricalSumInsuredValue,AntitheftdeviceRateValue,AntitheftdeviceSumInsuredValue,AutomobileAssociationRateValue,AutomobileAssociationSumInsuredValue,HandicapRateValue,HandicapSumInsuredValue,TPPDDiscountRateValue,TPPDDiscountSumInsuredValue,VotaryRateValue,VotarySumInsuredValue,StrNCB,ChangeAddons,DetarifficValueSumInsure="",DetarifficLoadingValueSumInsured="",BasicODRateSumInsured="",ELECTRICALCoverSumInsured="",NONELECTRICALSumInsured="",BasicTpRateSumInsured="",AdditionalFibertankODSumInsuredValue,AdditionalLegalLiabilityPaidSumInsured,AdditionalOtherODRateSumInsured,AdditionalOtherTpSumInsuredValue,AdditionalPaCoverToOwnerDriverSumInsuredValue,AdditionalPaidDriverSumInsuredValue,AdditionalPaToPassengersSumInsuredValue,AdditionalUnnamedPassengersSumInsuredValue,AdditionalCngKitODSumInsuredValue,AdditionalCngLpgTpSumInsuredValue,AdditionalBuiltinKitODSumInsuredValue,AdditionalBuiltinCngTPSumInsuredValue,DailyCashRateSumInsured,AccidentalSumInsuredValue,WrongFuelSumInsuredValue,CostOfConsumablesSumInsuredValue,dailyCashAllowanceMetroSumInsuredValue,dailyCashAllowanceNonMetroSumInsuredValue,EngineProtectorDieselSumInsuredValue,EngineProtectorPetrolSumInsuredValue,HydrostaticLockSumInsuredValue,KeyReplacementSumInsuredValue,NilDepreciationSumInsuredValue,ReturnToInvoiceSumInsuredValue,RoadSideAssistanceSumInsuredValue,SecureTowingSumInsuredValue,TyreRimsecureSumInsuredValue,drivingTrainProtectSumInsuredValue,ManufacturesellingSumInsuredValue,strVehicleImage="",strVehicleCubicCapicity="",selected_country_code,strNewFor="",DetariffDiscountStatus,DetariffLoadingStatus="",DetarifficValuePremium="",DetarifficValueRate="",DetarifficLodingValuePremium="",DetarifficLoadingValueRate="",changeseekBar="",strIdvValueTxtSelect="",DAILYCASHALLOWANCEStatus="",WRONGFUELCOVERStatus="",BasicODRateValue,BasicTpRateValue,AdditionalLegalLiabilityPaidRate="",CheckString="",strNomineeName="",strNomineeRelationEdit="",strPreviousClaimRadio="",StrAdditionalCoverPremiumTp="",StrAdditionalCoverPremiumOD="",SeekbarStatus="",addOnsCover="",addOnsAditional="",vehicleManufacturerType="",strModelType="",FuleType,rc_cubic_cap="",rc_fuel_desc="",VEHICLECLASSCODE="",strClaimBonus="",StrPreviousPolicyRadio="",strEndDateEdit="",ProductName="",ProductCode="",VehicleClassCode="",addOns="",NCB="",strVehicleManufacturerCode="",strRTOCode="",strVehicleModelCode="",strVehicleAge="",yearOfManufacture="",NetPremiumValue="",TotalValue="",PosPolicyNo1="",PosPolicyNo="",GST="",strIdvValueTxt="",strLessIDVText="",strHighIDVText="",today,todayYear,strThirdDString,strName="",strVehicleNo="",str_edt_city="",str_edt_phone="",str_edt_email="",strPolicyRadio="",strVehicleTypeRadio="",strVehicleRadio="",strFor="",strTitleEdit="",strRTOName="",str_vehicleManufacturerNm="",strStateName="",strStateCode="",str_edt_registration_date="",str_manufacture_year="",strVehicleModel="",strPolicyNumberEdit="",strRegisteredAddressEdit="",strStateRegisterAddressEdit="",strStateRegisterCode,strCityRegisterCode="",strCityRegisterEdit="",strCityCommunicationCode="",strPinCodeEditText="",strCommunicationAddressEdit="",strCommunicationPinCodeEdit="",strVehicleNumber="",strVehicleChasisNumber="",strVehicleEngineNumber="",strStateCommunicationEdit="",strStateCommunicationCode="",strCityCommunicationEdit="",strPlanType="",strPlanYear="",strCoverageType="",strPACover="",strGPACover="",strDrivingLicence="",strCheckedTermCondition="",strCheckboxCommunication="",
            BUILTINCNGKIT_LPGKITTPStatus="",StrPrev_Policy_Type="",nextYear="",strCompanyName="",strODPlanFromDateEdit="",strODPlanEndDateEdit="",strTpPlanFromDateEdit="",strTpPlanEndDateEdit="",CubicCapacity="",tomorrowDate="",VehicleExShowroomPrice="",BasicODStatus="",BasicTP="",ELECTRICALACCESSORYODStatus="",FIBERTANKODStatus="",LEGALLIABILITYTOPAIDDRIVERStatus="",NONELECTRICALACCESSORYODStatus="",OtherODStatus="",OtherTpStatus="",PACOVERTOEMPLOYEESOFINSUREDStatus="",PACOVERTOOWNERDRIVERStatus="",PACOVERTOPAIDDRIVERStatus="",PACOVERTOPASSENGERSStatus="",UNNAMEDPACOVERTOPASSENGERSStatus="",ACCIDENTALHOSPITALIZATIONStatus="",COSTOFCONSUMABLESStatus="",DAILYCASHALLOWANCEMETROStatus="",DAILYCASHALLOWANCENONMETROStatus="",ENGINEPROTECTORDIESELStatus="",ENGINEPROTECTORPETROLStatus="",HYDROSTATICLOCKCOVERStatus="",KEYREPLACEMENTStatus="",NilDepreciationWaivercoverStatus="",RETURNTOINVOICEStatus="",RoadsideAssistanceStatus="",SECURETOWINGStatus="",TyreandRimsecureStatus="",AdditionalElectricalRateValue="",AdditionalFibertankODRateValue="",AdditionalLegalLiabilityDriverRateValue="",AdditionalBuiltinCngTPRateValue="",AdditionalNonElecticalODRateValue="",AdditionalOtherODRateValue="",AdditionalOtherTpRateValue="",AdditionalPaCoversToEmployessRateValue="",AdditionalPaCoverToOwnerDriverRateValue="",AdditionalPaidDriverRateValue="",AdditionalPaToPassengersRateValue="",AdditionalUnnamedPassengersRateValue="",AdditionalCngKitODRateValue="",AdditionalCngLpgTpRateValue="",AdditionalBuiltinKitODRateValue="",AccidentalRateValue="",CostOfConsumablesRateValue="",dailyCashAllowanceMetroRateValue="",dailyCashAllowanceNonMetroRateValue="",EngineProtectorDieselRateValue="", EngineProtectorPetrolRateValue="",HydrostaticLockRateValue="", KeyReplacementRateValue="", NilDepreciationRateValue="", ReturnToInvoiceRateValue="", RoadSideAssistanceRateValue="",SecureTowingRateValue="",TyreRimsecureRateValue="", drivingTrainProtectRateValue="",WrongFuelRateValue="", DailyCashRateValue="",ManufacturesellingRateValue="",CNGLPGKITODStatus="",CNGLPGKITTPStatus="",BUILTINCNGKIT_LPGKITODStatus="",MANUFACTURERSELLINGPRICEStatus="",DRIVINGTRAINPROTECTStatus="",strGenderSpinner="",streditdob = "",strIDType="",strIDNumberEdit="",strIDTypeName="";
    FragmentTransaction transaction;
    Format formatter;
    ImageView imageBike,vehicleBrandSpinner,stateNameSpinner,calendarIcon,vehicleModelSpinner,rtoLocationSpinner,AddDetailsBack;
    private MySharedPreference pref;
    CustomProgressDialog customprogress;
    MyOptionsPickerView singlePicker;
    final ArrayList<String> itemsBrand = new ArrayList<String>();
    final ArrayList<String> itemsModel = new ArrayList<String>();
    VehicleManufacturerModel vehicleManufacturerModel;
    MotorVehicleModel motorVehicleModel;
    MotorRTOModel motorRTOModel;
    ArrayList<MotorVehicleModel>  motorVehicleModelList = new ArrayList<MotorVehicleModel>();
    ArrayList<VehicleManufacturerModel> vehicleManufacturerList = new ArrayList<VehicleManufacturerModel>();
    ArrayList<MotorState>motorStateList = new ArrayList<MotorState>();
    ArrayList<MotorRTOModel>motorRTOList = new ArrayList<MotorRTOModel>();
    final ArrayList<String> itemsRTO = new ArrayList<String>();
    final ArrayList<String> itemsState = new ArrayList<String>();
    MotorState motorState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_car_vehicle_details);
        getWindow().setStatusBarColor(ContextCompat.getColor(Private_car_vehicle_details.this, R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(Private_car_vehicle_details.this);
        customprogress = new CustomProgressDialog(Private_car_vehicle_details.this);
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
        strSelectDateYear = getIntent().getStringExtra("strSelectDateYear");
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
        VehicleAgeAdd =getIntent().getIntExtra("VehicleAgeAdd", 0);
        progressChanged =getIntent().getIntExtra("progressChanged", 0);
        selectYear =getIntent().getIntExtra("selectYear", 0);
        daysLeft =getIntent().getIntExtra("daysLeft", 0);
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
        strDiscountEdit = getIntent().getStringExtra("strDiscountEdit");
        strGenderSpinner = getIntent().getStringExtra("strGenderSpinner");
        streditdob = getIntent().getStringExtra("streditdob");
        strIDType = getIntent().getStringExtra("strIDType");
        strIDNumberEdit = getIntent().getStringExtra("strIDNumberEdit");
        strIDTypeName = getIntent().getStringExtra("strIDTypeName");
        strTpEndDateEdit = getIntent().getStringExtra("strTpEndDateEdit");
        strTpFromDateEdit = getIntent().getStringExtra("strTpFromDateEdit");
        ckycNo = getIntent().getStringExtra("ckycNo");
        strIDTypeName1 = getIntent().getStringExtra("strIDTypeName1");
        uniqueTransactionNumber = getIntent().getStringExtra("uniqueTransactionNumber");
        yearOfManufactureMonth = getIntent().getStringExtra("yearOfManufactureMonth");
        strSelectDateYear = getIntent().getStringExtra("strSelectDateYear");
        MonthsLeft =getIntent().getIntExtra("MonthsLeft", 0);
        initView();


    }

    private void initView() {
        btn_next=findViewById(R.id.btn_next);
        btn_previous=findViewById(R.id.btn_previous);
        manufacture_year_spinner=findViewById(R.id.manufacture_year_spinner);
        edt_registration_date=findViewById(R.id.edt_registration_date);
        StateEditText=findViewById(R.id.StateEditText);
        vehicle_model=findViewById(R.id.vehicle_model);
        rto_location=findViewById(R.id.rto_location);
        vehicleBrandSpinner=findViewById(R.id.vehicleBrandSpinner);
        stateNameSpinner=findViewById(R.id.stateNameSpinner);
        vehicleBrand=findViewById(R.id.vehicleBrand);
        calendarIcon=findViewById(R.id.calendarIcon);
        vehicleModelSpinner=findViewById(R.id.vehicleModelSpinner);
        rtoLocationSpinner=findViewById(R.id.rtoLocationSpinner);
        AddDetailsBack=findViewById(R.id.AddDetailsBack);
        imageBike=findViewById(R.id.imageBike);
        ModelNameTxt=findViewById(R.id.ModelNameTxt);

        selectYear1=getResources().getStringArray(R.array.yearSelect);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,selectYear1);
        manufacture_year_spinner.setAdapter(adapter);

        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        Log.e("Today",today);

        String[] strParts1 = today.split("/");
        String strFirstString1= strParts1[0]; // I
        String strSecondString1 = strParts1[1]; // m a android developer and i
        todayYear = strParts1[2];
        Log.e("todayYear",todayYear);

        if (strVehicleTypeRadio.equals("Two Wheeler")){
            VEHICLECLASSCODE="37";
        }else{
            VEHICLECLASSCODE="45";
        }

        if (strFor.equals("0")){
            if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
                str_vehicleManufacturerNm="Select Vehicle Brand";
                strVehicleModel="Select Model";
                strStateName="Select State";
                strRTOName="Select RTO Name";
                str_edt_registration_date="";
                StateEditText.setText(strStateName);
                rto_location.setText(strRTOName);
                vehicleBrand.setText(str_vehicleManufacturerNm);
                vehicle_model.setText(strVehicleModel);
                vehicleBrandSpinner.setEnabled(true);
                vehicleModelSpinner.setEnabled(true);
                stateNameSpinner.setEnabled(true);
                rtoLocationSpinner.setEnabled(true);
                edt_registration_date.setEnabled(true);
                edt_registration_date.setFocusable(true);
                edt_registration_date.setClickable(true);
                calendarIcon.setEnabled(true);
                if (!(strVehicleNo.equals("")||strVehicleNo.equals("New"))){
                    variantAdrilla();
                    customprogress.showProgressBar();
                }
//                else{
//                    str_edt_registration_date=today;
//                    edt_registration_date.setText(str_edt_registration_date);
//                    String[] strParts = str_edt_registration_date.split("/");
//                    String strFirstString = strParts[0]; // I
//                    String strSecondString = strParts[1]; // m a android developer and i
//                    yearOfManufacture = strParts[2];
//                }
                if (strVehicleTypeRadio.equals("Four Wheeler")){
                    imageBike.setImageResource(R.drawable.car_motor_new_);
                }else{
                    imageBike.setImageResource(R.drawable.motor_bike_banner);
                }
            }
            else{
                str_vehicleManufacturerNm="Select Vehicle Brand";
                strVehicleModel="Select Model";
                strStateName="Select State";
                strRTOName="Select RTO Name";
                str_edt_registration_date="";
                vehicleBrand.setText(str_vehicleManufacturerNm);
                vehicle_model.setText(strVehicleModel);
                StateEditText.setText(strStateName);
                rto_location.setText(strRTOName);
                vehicleManufacturerType="All";
                strModelType="All";
                if (strVehicleTypeRadio.equals("Four Wheeler")){
                    imageBike.setImageResource(R.drawable.car_motor_new_);
                }else{
                    imageBike.setImageResource(R.drawable.motor_bike_banner);
                }
                str_edt_registration_date=today;
                edt_registration_date.setText(str_edt_registration_date);
                String[] strParts = str_edt_registration_date.split("/");
                strSelectDateYear= strParts[0]; // I
                yearOfManufactureMonth = strParts[1]; // m a android developer and i
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
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }


        }
        else{
            edt_registration_date.setText(str_edt_registration_date);
            if (str_vehicleManufacturerNm==null && strVehicleModel==null && strStateName==null&& strRTOName==null && str_edt_registration_date==null && strVehicleImage.isEmpty()){
                str_vehicleManufacturerNm="Select Vehicle Brand";
                strVehicleModel="Select Model";
                strStateName="Select State";
                strRTOName="Select RTO Name";
                str_edt_registration_date="";
                vehicleBrand.setText(str_vehicleManufacturerNm);
                vehicle_model.setText(strVehicleModel);
                StateEditText.setText(strStateName);
                rto_location.setText(strRTOName);
                vehicleManufacturerType="All";
                strModelType="All";
                if (strVehicleTypeRadio.equals("Four Wheeler")){
                    imageBike.setImageResource(R.drawable.car_motor_new_);
                }else{
                    imageBike.setImageResource(R.drawable.motor_bike_banner);
                }
            }
            else{
                if (str_vehicleManufacturerNm.equals("Select Vehicle Brand")||strVehicleModel.equals("Select Model")||strStateName.equals("Select State")||strRTOName.equals("Select RTO Name")){
                    if (!(strVehicleNo.equals("")||strVehicleNo.equals("New"))){
                        variantAdrilla();
                        customprogress.showProgressBar();
                    }else{
                        if (!str_edt_registration_date.equals("")){
                            edt_registration_date.setText(str_edt_registration_date);
                            String[] strParts = str_edt_registration_date.split("/");
                            strSelectDateYear= strParts[0]; // I
                            yearOfManufactureMonth = strParts[1]; // m a android developer and i
                            yearOfManufacture = strParts[2];
                        }
                    }
                    if (strVehicleTypeRadio.equals("Four Wheeler")){
                        imageBike.setImageResource(R.drawable.car_motor_new_);
                    }else{
                        imageBike.setImageResource(R.drawable.motor_bike_banner);
                    }
                }else{
                    vehicleBrand.setText(str_vehicleManufacturerNm);
                    vehicle_model.setText(strVehicleModel);
                    ModelNameTxt.setText(strVehicleModel);
                    StateEditText.setText(strStateName);
                    rto_location.setText(strRTOName);
                    edt_registration_date.setText(str_edt_registration_date);
                }
                if (strVehicleTypeRadio.equals("Four Wheeler")){
                    if (strVehicleImage.isEmpty()) {
                        imageBike.setImageResource(R.drawable.car_motor_new_);
                    } else{
                        Picasso.get().load(strVehicleImage).fit().centerCrop()
                                .placeholder(R.drawable.car_motor_new_)
                                .error(R.drawable.car_motor_new_)
                                .into(imageBike);
                    }
                }else{
                    if (strVehicleImage.isEmpty() || strVehicleImage.equals("")||strVehicleImage.equals(null)) {
                        imageBike.setImageResource(R.drawable.motor_bike_banner);
                    } else{
                        Picasso.get().load(strVehicleImage).fit().centerCrop()
                                .placeholder(R.drawable.motor_bike_banner)
                                .error(R.drawable.motor_bike_banner)
                                .into(imageBike);
                    }
                }
            }
        }

//        if (strVehicleTypeRadio.equals("Four Wheeler")){
//            imageBike.setBackgroundResource(R.drawable.fourwheelerimg);
//        }else{
//            imageBike.setBackgroundResource(R.drawable.scooty_motor_img);
//        }

        manufacture_year_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_manufacture_year = String.valueOf(selectYear1[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Private_car_vehicle_details.this,Private_Car_Motor.class);
                startActivity(intent);
                finish();
            }

        });
        edt_registration_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showCalender();
            }
        });
        calendarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
                    check = 1;
                    showCalender();
                }else{
                    calendarIcon.setEnabled(false);
                }
            }
        });
        vehicleBrandSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vehicleManufacturerType.equals("")){
                    vehicleManufacturerType="All";
                    VehicleManufacturerMaster();
                    strNewFor="0";
                    CheckString="0";
                }else{
                    strNewFor="0";
                    CheckString="0";
                    VehicleManufacturerMaster();
                }

            }
        });
        vehicleModelSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str_vehicleManufacturerNm.equals("Select Vehicle Brand")){
                    Toast.makeText(Private_car_vehicle_details.this, "Please Select Vehicle Brand", Toast.LENGTH_SHORT).show();
                }else{
                    strModelType="All";
                    strNewFor="0";
                    CheckString="0";
                    VehicleModelMasterAPI();
                }

            }
        });
        stateNameSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state();
            }
        });
        rtoLocationSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strStateName.equals("Select State")){
                    Toast.makeText(Private_car_vehicle_details.this, "Please Select State", Toast.LENGTH_SHORT).show();
                }else{
                    VehicleMasterRtoLocationZoneAPI();
                }
            }
        });
        AddDetailsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Private_car_vehicle_details.this,MotorPrivate.class);
                intent.putExtra("MonthsLeft",MonthsLeft);
                intent.putExtra("AutoMobileValidityRadio",AutoMobileValidityRadio);
                intent.putExtra("strDiscountEdit",strDiscountEdit);
                intent.putExtra("strVehicleNo",strVehicleNo);
                intent.putExtra("strGenderSpinner",strGenderSpinner);
                intent.putExtra("streditdob",streditdob);
                intent.putExtra("strIDType",strIDType);
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
                intent.putExtra("selectYear",selectYear);
                intent.putExtra("daysLeft",daysLeft);
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
                intent.putExtra("strNomineeName",strNomineeName);
                intent.putExtra("strNomineeRelationEdit",strNomineeRelationEdit);
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
                intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
                intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
                intent.putExtra("ckycNo",ckycNo);
                intent.putExtra("strIDTypeName1",strIDTypeName1);
                intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
                intent.putExtra("ChangeAddons","0");
                intent.putExtra("a",a);
                intent.putExtra("b",b);
                intent.putExtra("c",c);
                intent.putExtra("strFor","1");
                intent.putExtra("strNewFor","0");
                intent.putExtra("CheckString","0");
                intent.putExtra("changeseekBar","0");
                startActivity(intent);
                overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);
                finish();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str_vehicleManufacturerNm.equals("Select Vehicle Brand")){
                    Toast.makeText(Private_car_vehicle_details.this, "Select Vehicle Brand", Toast.LENGTH_SHORT).show();
                }else if (strVehicleModel.equals("Select Model")){
                    Toast.makeText(Private_car_vehicle_details.this, "Select Vehicle Model", Toast.LENGTH_SHORT).show();
                }else if (str_edt_registration_date.equals("")){
                    Toast.makeText(Private_car_vehicle_details.this, "Select Date", Toast.LENGTH_SHORT).show();
                }else if (strStateName.equals("Select State")){
                    Toast.makeText(Private_car_vehicle_details.this, "Select State Where Vehicle is Registered", Toast.LENGTH_SHORT).show();
                }else if (strRTOName.equals("Select RTO Name")){
                    Toast.makeText(Private_car_vehicle_details.this, "Select RTO", Toast.LENGTH_SHORT).show();
                }else{
                    if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
                        Intent intent=new Intent(Private_car_vehicle_details.this,Add_Details_Old_Vehicle.class);
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
                        intent.putExtra("yearOfManufactureMonth",yearOfManufactureMonth);
                        intent.putExtra("yearOfManufactureDay",yearOfManufactureDay);
                        intent.putExtra("strSelectDateYear",strSelectDateYear);
                        intent.putExtra("ckycNo",ckycNo);
                        intent.putExtra("strIDTypeName1",strIDTypeName1);
                        intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
                        intent.putExtra("check",check);
                        intent.putExtra("daysLeft",daysLeft);
                        startActivity(intent);
                        finish();
                    }else{
                        Intent intent=new Intent(Private_car_vehicle_details.this,Motor_AddOns.class);
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
                        intent.putExtra("strNomineeName",strNomineeName);
                        intent.putExtra("strNomineeRelationEdit",strNomineeRelationEdit);
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
                        intent.putExtra("daysLeft",daysLeft);
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
                        intent.putExtra("AutomobileAssociationdiscountSumInsured",AutomobileAssociationdiscountSumInsured);
                        intent.putExtra("VoluntarydeductableSumInsured",VoluntarydeductableSumInsured);
                        intent.putExtra("ELECTRICALACCESSORYODSumInsured",ELECTRICALACCESSORYODSumInsured);
                        intent.putExtra("NONELECTRICALACCESSORYODSumInsured",NONELECTRICALACCESSORYODSumInsured);
                        intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
                        intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
                        intent.putExtra("VehicleAgeAdd",VehicleAgeAdd);
                        intent.putExtra("yearOfManufactureMonth",yearOfManufactureMonth);
                        intent.putExtra("yearOfManufactureDay",yearOfManufactureDay);
                        intent.putExtra("strSelectDateYear",strSelectDateYear);
                        intent.putExtra("ckycNo",ckycNo);
                        intent.putExtra("strIDTypeName1",strIDTypeName1);
                        intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
                        intent.putExtra("ChangeAddons","0");
                        intent.putExtra("a",a);
                        intent.putExtra("b",b);
                        intent.putExtra("c",c);
                        intent.putExtra("strFor",strFor);
                        intent.putExtra("strNewFor","0");
                        intent.putExtra("CheckString","0");
                        intent.putExtra("changeseekBar","0");
                        startActivity(intent);
                        finish();
                    }

                }
            }
        });
    }

    //    private void variantAdrilla() {
//        JSONObject parameters = new JSONObject();
//        try {
//            parameters.put("rc_no", strVehicleNo);
//            parameters.put("consent", "Y");
//            parameters.put("rc_source", "45");
//        } catch (Exception e) {
//        }
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "https://uat.aadrila.com/api/v1/variant-id", parameters,new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.e("onResponse", response.toString());
//                customprogress.hideProgressBar();
//                btn_next.setVisibility(View.VISIBLE);
//                try {
//                    JSONObject jsonObject=response.getJSONObject("data");
//                    vehicleManufacturerType=jsonObject.getString("rc_maker_desc");
//                    strModelType=jsonObject.getString("rc_maker_model");
//                    str_edt_registration_date=jsonObject.getString("rc_regn_dt");
//                    strStateCode=jsonObject.getString("state_code");
//                    strStateName=jsonObject.getString("rc_registered_at");
//                    strRTOCode=jsonObject.getString("rc_rto_code");
//                    strVehicleChasisNumber=jsonObject.getString("rc_chasi_no");
//                    strVehicleEngineNumber=jsonObject.getString("rc_eng_no");
//                    rc_cubic_cap=jsonObject.getString("rc_cubic_cap");
//                    rc_fuel_desc=jsonObject.getString("rc_fuel_desc");
//                    String[] strFuel = rc_fuel_desc.split("/");
//                    String strFuel1 = strFuel[0];
//                    FuleType=strFuel1;
//
//                    edt_registration_date.setText(str_edt_registration_date);
////                    vehicle_model.setText(strVehicleModel);
////                    vehicleBrand.setText(str_vehicleManufacturerNm);
//                    StateEditText.setText(strStateName);
//                    String[] strCity = strStateName.split(",");
//                    String str1City = strCity[0]; // I
//                    strRTOName=str1City;
//                    rto_location.setText(strRTOName);
//                    String[] strParts = str_edt_registration_date.split("-");
//                    String strFirstString = strParts[0]; // I
//                    String strSecondString = strParts[1]; // m a android developer and i
//                    yearOfManufacture = strParts[2];
//                    VehicleManufacturerMaster();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    customprogress.hideProgressBar();
//                }
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//                Log.e("onErrorResponse", error.toString());
//                customprogress.hideProgressBar();
//                btn_next.setVisibility(View.GONE);
//                Toast.makeText(Private_car_vehicle_details.this, "No Data Found For This Vehicle Number...Please Enter Valid Vehicle Number ", Toast.LENGTH_SHORT).show();
//            }
//        }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String, String> headers = new HashMap<String, String>();
//                headers.put("Content-Type", "application/json; charset=utf-8");
//                headers.put("Authorization", "Bearer " + "af90858f6b3b8a3684fd80ad6b7c899e");
//                return headers;
//            }
//        };
//        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
////        queue.add(request);
//        request.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        queue.add(request);
//    }
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
                            btn_next.setVisibility(View.VISIBLE);
                        }else{
                            btn_next.setVisibility(View.GONE);
                            Toast.makeText(Private_car_vehicle_details.this, "It's not for Four Wheeler Please Enter Four Wheeler number  ", Toast.LENGTH_SHORT).show();
                        }
                    }else if (strVehicleTypeRadio.equals("Two Wheeler")){
                        if(uidStr.equals("2W")){
                            btn_next.setVisibility(View.VISIBLE);
                        }else{
                            btn_next.setVisibility(View.GONE);
                            Toast.makeText(Private_car_vehicle_details.this, "It's not for Two Wheeler Please Enter Two Wheeler number  ", Toast.LENGTH_SHORT).show();
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
                    strSelectDateYear= strParts[0]; // I
                    yearOfManufactureMonth = strParts[1]; // m a android developer and i
                    yearOfManufacture = strParts[2];
                    Log.e("yearOfManufacture",yearOfManufacture);
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
                            SelectRegistrationMonth = period.getMonths();
                            int SelectDays = period.getDays();
                            Log.e("SelectRegistrationMonth", String.valueOf(SelectRegistrationMonth));
                            Log.e("VehicleAgeAdd", String.valueOf(VehicleAgeAdd));

                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (!(strVehicleNo.equals("")||strVehicleNo.equals("New"))){
                        vehicleBrand.setText(str_vehicleManufacturerNm);
                        vehicle_model.setText(strVehicleModel);
                        edt_registration_date.setText(str_edt_registration_date);
                        StateEditText.setText(strStateName);
                        rto_location.setText(strRTOName);
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
                Toast.makeText(Private_car_vehicle_details.this, "No Data Found For This Vehicle Number...Please Enter Valid Vehicle Number ", Toast.LENGTH_SHORT).show();
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
    private void VehicleManufacturerMaster() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("VEHICLECLASSCODE",VEHICLECLASSCODE);
            object.put("Type",vehicleManufacturerType);
        }catch (Exception e) {
            e.printStackTrace();
        }ProjectVolleyRequest req = new ProjectVolleyRequest(Private_car_vehicle_details.this, object, UrlConstants.BUY_VehicleManufacturer_Master, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    if (Tag == RequestConstants.BUY_POLICY_MOTOR_PRIVATE) {
                        JSONArray arr = null;
                        try {
                            vehicleManufacturerList.clear();
                            itemsBrand.clear();
                            strVehicleModel="Select Model";
                            vehicle_model.setText(strVehicleModel);
                            arr = object.getJSONArray("VehicleMake");
                            for (int i = 0; i <arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(i);
                                vehicleManufacturerModel = new Gson().fromJson(obj.toString(), VehicleManufacturerModel.class);
                                vehicleManufacturerList.add(vehicleManufacturerModel);
                            }for(int k=0;k<vehicleManufacturerList.size();k++){
                                itemsBrand.add(vehicleManufacturerList.get(k).getVEHICLEMANUFACTURERNAME());
                            }
                            singlePicker = new MyOptionsPickerView(Private_car_vehicle_details.this);
                            singlePicker.setPicker(itemsBrand);
                            singlePicker.setCyclic(false);
                            singlePicker.setSelectOptions(0);
                            singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int option2, int options3) {
                                    str_vehicleManufacturerNm=vehicleManufacturerList.get(options1).getVEHICLEMANUFACTURERNAME();
                                    strVehicleManufacturerCode=vehicleManufacturerList.get(options1).getVEHICLEMANUFACTURERCODE();
                                    vehicleBrand.setText(str_vehicleManufacturerNm);
                                    strModelType="All";
                                    VehicleModelMasterAPI();
                                }
                            });
                            singlePicker.show();
//                            if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
//                                arr = object.getJSONArray("VehicleMake");
//                                for (int i = 0; i <arr.length(); i++) {
//                                    JSONObject obj = arr.getJSONObject(0);
//                                    str_vehicleManufacturerNm=obj.getString("VEHICLEMANUFACTURERNAME");
//                                    strVehicleManufacturerCode=obj.getString("VEHICLEMANUFACTURERCODE");
//                                    vehicleBrand.setText(str_vehicleManufacturerNm);
//                                    Log.e("strVehicleManufacturerCode11",strVehicleManufacturerCode);
//                                    VehicleModelMasterAPI();
//                                }
//                            }
//                            else{
//                                vehicleManufacturerList.clear();
//                                itemsBrand.clear();
//                                strVehicleModel="Select Model";
//                                vehicle_model.setText(strVehicleModel);
//                                arr = object.getJSONArray("VehicleMake");
//                                for (int i = 0; i <arr.length(); i++) {
//                                    JSONObject obj = arr.getJSONObject(i);
//                                    vehicleManufacturerModel = new Gson().fromJson(obj.toString(), VehicleManufacturerModel.class);
//                                    vehicleManufacturerList.add(vehicleManufacturerModel);
//                                }for(int k=0;k<vehicleManufacturerList.size();k++){
//                                    itemsBrand.add(vehicleManufacturerList.get(k).getVEHICLEMANUFACTURERNAME());
//                                }
//                                singlePicker = new MyOptionsPickerView(Private_car_vehicle_details.this);
//                                singlePicker.setPicker(itemsBrand);
//                                singlePicker.setCyclic(false);
//                                singlePicker.setSelectOptions(0);
//                                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                                    @Override
//                                    public void onOptionsSelect(int options1, int option2, int options3) {
//                                        str_vehicleManufacturerNm=vehicleManufacturerList.get(options1).getVEHICLEMANUFACTURERNAME();
//                                        strVehicleManufacturerCode=vehicleManufacturerList.get(options1).getVEHICLEMANUFACTURERCODE();
//                                        vehicleBrand.setText(str_vehicleManufacturerNm);
//                                        strModelType="All";
//                                        VehicleModelMasterAPI();
//                                    }
//                                });
//                                singlePicker.show();
//                            }

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
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE);
        req.execute();

    }
    private void VehicleModelMasterAPI() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("MANUFACTURERNAME", str_vehicleManufacturerNm);
//            object.put("ModelType", strModelType);
            object.put("VEHICLECLASSCODE", VEHICLECLASSCODE);

        }catch (Exception e) {
            e.printStackTrace();
        }ProjectVolleyRequest req = new ProjectVolleyRequest(Private_car_vehicle_details.this, object, UrlConstants.BUY_VehicleModel_Master, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    if (Tag == RequestConstants.BUY_POLICY_MOTOR_PRIVATE_MODEL) {
                        strVehicleModel="Select Model";
                        vehicle_model.setText(strVehicleModel);
                        JSONArray arr = null;
                        try {
//                            if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
//                                arr = object.getJSONArray("VehicleModel");
//                                for (int i = 0; i <arr.length(); i++) {
//                                    JSONObject obj = arr.getJSONObject(0);
//                                    strVehicleModel=obj.getString("VEHICLEMODEL");
//                                    strVehicleModelCode=obj.getString("VEHICLEMODELCODE");
//                                    vehicle_model.setText(strVehicleModel);
//                                }
//                            }else{
//                                motorVehicleModelList.clear();
//                                itemsModel.clear();
//                                arr = object.getJSONArray("VehicleModel");
//                                for (int i = 0; i <arr.length(); i++) {
//                                    JSONObject obj = arr.getJSONObject(i);
//                                    motorVehicleModel = new Gson().fromJson(obj.toString(), MotorVehicleModel.class);
//                                    motorVehicleModelList.add(motorVehicleModel);
//                                }for(int k=0;k<motorVehicleModelList.size();k++){
//                                    itemsModel.add(motorVehicleModelList.get(k).getVEHICLEMODEL());
//                                }
//                                singlePicker = new MyOptionsPickerView(Private_car_vehicle_details.this);
//                                singlePicker.setPicker(itemsModel);
//                                singlePicker.setCyclic(false);
//                                singlePicker.setSelectOptions(0);
//                                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                                    @Override
//                                    public void onOptionsSelect(int options1, int option2, int options3) {
//                                        strVehicleModel=motorVehicleModelList.get(options1).getVEHICLEMODEL();
//                                        strVehicleModelCode=motorVehicleModelList.get(options1).getVEHICLEMODELCODE();
//                                        strVehicleCubicCapicity=motorVehicleModelList.get(options1).getCUBICCAPACITY();
//                                        strVehicleImage=motorVehicleModelList.get(options1).getIMAGE();
//                                        FuleType=motorVehicleModelList.get(options1).getCNVM_FUEL_TYPE();
//                                        vehicle_model.setText(strVehicleModel);
//                                        ModelNameTxt.setText(strVehicleModel);
//                                        if (strVehicleTypeRadio.equals("Four Wheeler")){
//                                            if (strVehicleImage.isEmpty()) {
//                                                imageBike.setImageResource(R.drawable.car_motor_new_);
//                                            } else{
//                                                Picasso.get().load(strVehicleImage).fit().centerCrop()
//                                                        .placeholder(R.drawable.car_motor_new_)
//                                                        .error(R.drawable.car_motor_new_)
//                                                        .into(imageBike);
//                                            }
//                                        }else{
//                                            if (strVehicleImage.isEmpty()) {
//                                                imageBike.setImageResource(R.drawable.motor_bike_banner);
//                                            } else{
//                                                Picasso.get().load(strVehicleImage).fit().centerCrop()
//                                                        .placeholder(R.drawable.motor_bike_banner)
//                                                        .error(R.drawable.motor_bike_banner)
//                                                        .into(imageBike);
//                                            }
//                                        }
//                                    }
//                                });
//                                singlePicker.show();
//                            }
                            motorVehicleModelList.clear();
                            itemsModel.clear();
                            arr = object.getJSONArray("VehicleModel");
                            for (int i = 0; i <arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(i);
                                motorVehicleModel = new Gson().fromJson(obj.toString(), MotorVehicleModel.class);
                                motorVehicleModelList.add(motorVehicleModel);
                            }for(int k=0;k<motorVehicleModelList.size();k++){
                                itemsModel.add(motorVehicleModelList.get(k).getVEHICLEMODEL());
                            }
                            singlePicker = new MyOptionsPickerView(Private_car_vehicle_details.this);
                            singlePicker.setPicker(itemsModel);
                            singlePicker.setCyclic(false);
                            singlePicker.setSelectOptions(0);
                            singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int option2, int options3) {
                                    strVehicleModel=motorVehicleModelList.get(options1).getVEHICLEMODEL();
                                    strVehicleModelCode=motorVehicleModelList.get(options1).getVEHICLEMODELCODE();
                                    strVehicleCubicCapicity=motorVehicleModelList.get(options1).getCUBICCAPACITY();
                                    strVehicleImage=motorVehicleModelList.get(options1).getIMAGE();
                                    FuleType=motorVehicleModelList.get(options1).getCNVM_FUEL_TYPE();
                                    vehicle_model.setText(strVehicleModel);
                                    ModelNameTxt.setText(strVehicleModel);
                                    if (strVehicleTypeRadio.equals("Four Wheeler")){
                                        if (strVehicleImage.isEmpty()) {
                                            imageBike.setImageResource(R.drawable.car_motor_new_);
                                        } else{
                                            Picasso.get().load(strVehicleImage).fit().centerCrop()
                                                    .placeholder(R.drawable.car_motor_new_)
                                                    .error(R.drawable.car_motor_new_)
                                                    .into(imageBike);
                                        }
                                    }else{
                                        if (strVehicleImage.isEmpty()) {
                                            imageBike.setImageResource(R.drawable.motor_bike_banner);
                                        } else{
                                            Picasso.get().load(strVehicleImage).fit().centerCrop()
                                                    .placeholder(R.drawable.motor_bike_banner)
                                                    .error(R.drawable.motor_bike_banner)
                                                    .into(imageBike);
                                        }
                                    }
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
                    strVehicleModel="Select Model";
                    vehicle_model.setText(strVehicleModel);
                    Toast.makeText(getApplication(), ""+message+" for this Vehicle Brand Choose another brand", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE_MODEL);
        req.execute();
    }
    private void state() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
        }catch (Exception e) {
            e.printStackTrace();
        }ProjectVolleyRequest req = new ProjectVolleyRequest(Private_car_vehicle_details.this, object, UrlConstants.BUY_VehicleRtoState, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    if (Tag == RequestConstants.BUY_POLICY_MOTOR_PRIVATE_State) {
                        JSONArray arr = null;
                        try {
                            motorStateList.clear();
                            itemsState.clear();
                            strRTOName="Select RTO Name";
                            rto_location.setText(strRTOName);
                            arr = object.getJSONArray("StateDetails");
                            for (int i = 0; i <arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(i);
                                motorState = new Gson().fromJson(obj.toString(), MotorState.class);
                                motorStateList.add(motorState);
                            }
                            for(int k=0;k<motorStateList.size();k++){
                                itemsState.add(motorStateList.get(k).getStateName());
                            }
                            singlePicker = new MyOptionsPickerView(Private_car_vehicle_details.this);
                            singlePicker.setPicker(itemsState);
                            singlePicker.setCyclic(false);
                            singlePicker.setSelectOptions(0);
                            singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int option2, int options3) {
                                    strStateName=motorStateList.get(options1).getStateName();
                                    strStateCode=motorStateList.get(options1).getStateId();
                                    Log.e("strStateCode",strStateCode);
                                    StateEditText.setText(strStateName);
                                    VehicleMasterRtoLocationZoneAPI();

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
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE_State);
        req.execute();

    }
    private void VehicleMasterRtoLocationZoneAPI() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("StateCode", strStateCode);
        }catch (Exception e) {
            e.printStackTrace();
        }ProjectVolleyRequest req = new ProjectVolleyRequest(Private_car_vehicle_details.this, object, UrlConstants.BUY_VehicleMasterRtoLocationZone, new ResponseListener() {
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
                            singlePicker = new MyOptionsPickerView(Private_car_vehicle_details.this);
                            singlePicker.setPicker(itemsRTO);
                            singlePicker.setCyclic(false);
                            singlePicker.setSelectOptions(0);
                            singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int option2, int options3) {
                                    strRTOName=motorRTOList.get(options1).getRTOLOCName();
                                    strRTOCode=motorRTOList.get(options1).getRegionCode();
                                    Log.e("strRTOCode",strRTOCode);
                                    rto_location.setText(strRTOName);
//                                    VehicleMasterRtoLocationZoneAPI();


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
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE_RTO);
        req.execute();
    }
    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        DatePickerDialog datePicker = new DatePickerDialog(Private_car_vehicle_details.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            str_edt_registration_date=dateFormatter.format(newDate.getTime());
            edt_registration_date.setText(str_edt_registration_date);
            String[] strParts = str_edt_registration_date.split("/");
            strSelectDateYear= strParts[0]; // I
            yearOfManufactureMonth = strParts[1]; // m a android developer and i
            yearOfManufacture = strParts[2];

            try {
                Log.e("str_edt_registration_date",str_edt_registration_date);
                SelectDate = dateFormatter.parse(str_edt_registration_date);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate,TodayendDate, PeriodType.yearMonthDay());
                    VehicleAgeAdd = period.getYears();
                    SelectRegistrationMonth = period.getMonths();
                    int SelectDays = period.getDays();
                    Log.e("SelectRegistrationMonth", String.valueOf(SelectRegistrationMonth));
                }


                if (!strVehicleRadio.equals("Old")){
                    if (todayYear.equals(yearOfManufacture)){
                        if (SelectRegistrationMonth >=6) {
                            Toast.makeText(Private_car_vehicle_details.this, "Can't select date as your registration date is more than 6 months from today", Toast.LENGTH_LONG).show();
                            str_edt_registration_date="";
                            edt_registration_date.setText(str_edt_registration_date);
                        }
                    }else{
                        Toast.makeText(Private_car_vehicle_details.this, "Can't select date as your registration date is more than 6 months from today", Toast.LENGTH_LONG).show();
                        str_edt_registration_date="";
                        edt_registration_date.setText(str_edt_registration_date);
                    }
                }else{
                    edt_registration_date.setText(str_edt_registration_date);

                }

            }
            catch (ParseException e) {
                e.printStackTrace();
            }

//            edt_city.setText(dateFormatter.format(newDate.getTime()));
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    @Override
    public void onBackPressed() {
        if (strVehicleImage.isEmpty()) {
            strVehicleImage="";
            Intent intent=new Intent(Private_car_vehicle_details.this,MotorPrivate.class);
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
            intent.putExtra("AutomobileAssociationdiscountSumInsured",AutomobileAssociationdiscountSumInsured);
            intent.putExtra("VoluntarydeductableSumInsured",VoluntarydeductableSumInsured);
            intent.putExtra("ELECTRICALACCESSORYODSumInsured",ELECTRICALACCESSORYODSumInsured);
            intent.putExtra("NONELECTRICALACCESSORYODSumInsured",NONELECTRICALACCESSORYODSumInsured);
            intent.putExtra("daysLeft",daysLeft);
            intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
            intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
            intent.putExtra("VehicleAgeAdd",VehicleAgeAdd);
            intent.putExtra("ckycNo",ckycNo);
            intent.putExtra("strIDTypeName1",strIDTypeName1);
            intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
            intent.putExtra("a",a);
            intent.putExtra("b",b);
            intent.putExtra("c",c);
            intent.putExtra("strFor","1");
            intent.putExtra("strNewFor",strNewFor);
            intent.putExtra("CheckString",CheckString);
            intent.putExtra("changeseekBar","0");
            intent.putExtra("ChangeAddons","0");
            startActivity(intent);
            overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);
            finish();
        }
        else{
            Intent intent=new Intent(Private_car_vehicle_details.this,MotorPrivate.class);
            intent.putExtra("strVehicleNo",strVehicleNo);
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
            intent.putExtra("AutomobileAssociationdiscountSumInsured",AutomobileAssociationdiscountSumInsured);
            intent.putExtra("VoluntarydeductableSumInsured",VoluntarydeductableSumInsured);
            intent.putExtra("ELECTRICALACCESSORYODSumInsured",ELECTRICALACCESSORYODSumInsured);
            intent.putExtra("NONELECTRICALACCESSORYODSumInsured",NONELECTRICALACCESSORYODSumInsured);
            intent.putExtra("daysLeft",daysLeft);
            intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
            intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
            intent.putExtra("VehicleAgeAdd",VehicleAgeAdd);
            intent.putExtra("ckycNo",ckycNo);
            intent.putExtra("strIDTypeName1",strIDTypeName1);
            intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
            intent.putExtra("a",a);
            intent.putExtra("b",b);
            intent.putExtra("c",c);
            intent.putExtra("strFor","1");
            intent.putExtra("strNewFor",strNewFor);
            intent.putExtra("CheckString",CheckString);
            intent.putExtra("changeseekBar","0");
            intent.putExtra("ChangeAddons","0");
            startActivity(intent);
            overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);
            finish();
        }


    }

}