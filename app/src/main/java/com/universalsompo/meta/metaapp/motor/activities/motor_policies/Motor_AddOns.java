package com.universalsompo.meta.metaapp.motor.activities.motor_policies;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
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
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.BuyPolicySumInsured;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHIAddOns;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter.MyHealthPolicyAdapter;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthPolicyModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.adapter.AddOnCoverageRecy;
import com.universalsompo.meta.metaapp.motor.activities.adapter.AdditionalCoverageRecy;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.AdditionalCoverGroupModel;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.AddonCoverGroupsModel;
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

public class Motor_AddOns extends AppCompatActivity {
    private SimpleDateFormat dateFormatter;
    LinearLayout DrivingLiner,IndividualLiner,linerCenterBike,HighRiskLiner,LowRiskLiner,continue_button,BookNowLinerComprehensive,ThreeYearLiner,FiveYearLiner;
    String strIDTypeName1,ELECTRICALACCESSORYODStatus1, NONELECTRICALACCESSORYODStatus1, PACOVERTOEMPLOYEESOFINSUREDStatus1, PACOVERTOPASSENGERSStatus1, PACOVERTOPAIDDRIVERStatus1, OtherTpStatus1, FIBERTANKODStatus1, OtherODStatus1, UNNAMEDPACOVERTOPASSENGERSStatus1, PACOVERTOOWNERDRIVERStatus1, CNGLPGKITODStatus1, CNGLPGKITTPStatus1, BUILTINCNGKIT_LPGKITODStatus1, MANUFACTURERSELLINGPRICEStatus1, BUILTINCNGKIT_LPGKITTPStatus1, DRIVINGTRAINPROTECTStatus1, LEGALLIABILITYTOPAIDDRIVERStatus1, RoadsideAssistanceStatus1, NilDepreciationWaivercoverStatus1, DAILYCASHALLOWANCENONMETROStatus1, DAILYCASHALLOWANCEMETROStatus1, KEYREPLACEMENTStatus1, RETURNTOINVOICEStatus1, ACCIDENTALHOSPITALIZATIONStatus1, HYDROSTATICLOCKCOVERStatus1, COSTOFCONSUMABLESStatus1, SECURETOWINGStatus1, TyreandRimsecureStatus1, ENGINEPROTECTORPETROLStatus1, ENGINEPROTECTORDIESELStatus1, DAILYCASHALLOWANCEStatus1, WRONGFUELCOVERStatus1, DetariffDiscountStatus1, DetariffLoadingStatus1,AdditionalCoverBasicOdPremium,AdditionalBasicTpCoverPremium,strIdvValueEdit, AutoMobileRadio,AutoMobileValidityRadio,strMinMax,ChangeAddons="",strVehicleCubicCapicity="",strVehicleImage="",strNewFor,changeseekBar="",CheckString="",strElectricalAccessoriesSumInsured="",strNonelectricalAccessoriesSumInsured="",strCngKitSumInsured="",CNGLPGKITODSumInsured="",DAILYCASHALLOWANCEStatus="",AntitheftdevicediscountStatus="",AutomobileAssociationdiscountStatus="",AutomobileAssociationdiscountSumInsured="",VoluntarydeductableStatus="",TPPDDiscountStatus="",HandicapDiscountStatus="",DetariffDiscountStatus="",DetariffLoadingStatus="",strPreviousClaimRadio="",StrAdditionalCoverPremiumOD="",StrAdditionalCoverPremiumTp="",SeekbarStatus="",vehicleManufacturerType="",strModelType="",nextYear,strCompanyName="",CubicCapacity="",FuleType="",rc_cubic_cap="",rc_fuel_desc="",strVehicleEngineNumber="",strVehicleChasisNumber="",NumberOfWheels="",VEHICLECLASSCODE="",strClaimBonus="",StrPreviousPolicyRadio="",strEndDateEdit="",ProductName="",ProductCode="",VehicleClassCode="",addOns="",addOnsCover="",addOnsCover1="",addOnsAditional="",addOnsAditional1="",addOns1="",NCB="",DetarifficValuePremium="",DetarifficValueDiscount="",DetarifficValueRate="",DetarifficValueSumInsure="",StrDetarifficValuePremiumDouble="",DetarifficLodingValuePremium="",DetarifficLoadingValueRate="",DetarifficLoadingValueSumInsured="",BasicODRateSumInsured="",ELECTRICALCoverSumInsured="",NONELECTRICALSumInsured="",BasicTpRateSumInsured="",AdditionalFibertankODSumInsuredValue,AdditionalLegalLiabilityPaidSumInsured,AdditionalOtherODRateSumInsured,AdditionalOtherTpSumInsuredValue,AdditionalPaCoverToOwnerDriverSumInsuredValue,AdditionalPaidDriverSumInsuredValue,AdditionalPaToPassengersSumInsuredValue,AdditionalUnnamedPassengersSumInsuredValue,AdditionalCngKitODSumInsuredValue,AdditionalCngLpgTpSumInsuredValue,AdditionalBuiltinKitODSumInsuredValue,AdditionalBuiltinCngTPSumInsuredValue,DailyCashRateSumInsured,AccidentalSumInsuredValue,WrongFuelSumInsuredValue,CostOfConsumablesSumInsuredValue,dailyCashAllowanceMetroSumInsuredValue,dailyCashAllowanceNonMetroSumInsuredValue,EngineProtectorDieselSumInsuredValue,EngineProtectorPetrolSumInsuredValue,HydrostaticLockSumInsuredValue,KeyReplacementSumInsuredValue,NilDepreciationSumInsuredValue,ReturnToInvoiceSumInsuredValue,RoadSideAssistanceSumInsuredValue,SecureTowingSumInsuredValue,TyreRimsecureSumInsuredValue,drivingTrainProtectSumInsuredValue,ManufacturesellingSumInsuredValue,StrDetarifficLoadingValuePremiumDouble="",AdditionalCoverPremium="",PremiumValue="",NetPremiumValue="",VehicleExShowroomPrice="",TotalValue="",strDiscountEdit="",StrNCB="",strAntitheftdeviceDiscount="",AutomobileAssociationDiscount="",AntitheftdeviceRateValue="",AntitheftdeviceSumInsuredValue="",StrHandicapDiscount="",HandicapRateValue="",HandicapSumInsuredValue="",StrTPPDDiscount="",StrVotaryDeductablelun="",VotaryRateValue="",VotarySumInsuredValue="",PosPolicyNo="",GST="",strIdvValueTxt="",strIdvValueTxt1="",strIdvValueTxtSelect="",strLessIDVText="",strHighIDVText="",today="",tomorrowDate="",strThirdDString="",strVehicleAge="",yearOfManufacture="",strVehicleModelCode="",strName="",strVehicleNo="",str_edt_city="",str_edt_phone="",str_edt_email="",strPolicyRadio="",strVehicleTypeRadio="",VoluntarydeductableSumInsured="",VoluntarydeductableDiscountAmount="",strVehicleRadio="",strFor="",strVehicleManufacturerCode="",strRTOCode="",strRTOName="",str_vehicleManufacturerNm="",strStateName="",strStateCode="",str_edt_registration_date="",strVehicleModel="",strPolicyNumberEdit="",strPlanYear="",strPlanType="",strCoverageType="",strPACover="",strGPACover="",strDrivingLicence="",BasicODStatus="",BasicTP="",ELECTRICALACCESSORYODStatus="",ELECTRICALACCESSORYODSumInsured="",FIBERTANKODStatus="",LEGALLIABILITYTOPAIDDRIVERStatus="",NONELECTRICALACCESSORYODStatus="",NONELECTRICALACCESSORYODSumInsured="",OtherODStatus="",OtherTpStatus="",PACOVERTOEMPLOYEESOFINSUREDStatus="",PACOVERTOOWNERDRIVERStatus="",CNGLPGKITODStatus="",CNGLPGKITTPStatus="",BUILTINCNGKIT_LPGKITODStatus="",MANUFACTURERSELLINGPRICEStatus="",DRIVINGTRAINPROTECTStatus="",PACOVERTOPAIDDRIVERStatus="",PACOVERTOPAIDDRIVERSumInsured="",PACOVERTOPASSENGERSStatus="",PACOVERTOPASSENGERSSumInsured="",UNNAMEDPACOVERTOPASSENGERSStatus="",UNNAMEDPACOVERTOPASSENGERSSumInsured="",BUILTINCNGKIT_LPGKITTPStatus="",ACCIDENTALHOSPITALIZATIONStatus="",COSTOFCONSUMABLESStatus="",DAILYCASHALLOWANCEMETROStatus="",DAILYCASHALLOWANCENONMETROStatus="",ENGINEPROTECTORDIESELStatus="",WRONGFUELCOVERStatus="",ENGINEPROTECTORPETROLStatus="",HYDROSTATICLOCKCOVERStatus="",KEYREPLACEMENTStatus="",NilDepreciationWaivercoverStatus="",RETURNTOINVOICEStatus="",RoadsideAssistanceStatus="",SECURETOWINGStatus="",TyreandRimsecureStatus="",strRegisteredAddressEdit="",strTitleEdit="",strStateRegisterAddressEdit="",strStateRegisterCode,strCityRegisterCode="",strCityRegisterEdit="",strCityCommunicationCode="",strPinCodeEditText="",strCommunicationAddressEdit="",strCommunicationPinCodeEdit="",strStateCommunicationEdit="",strStateCommunicationCode="",strCityCommunicationEdit="",strCheckedTermCondition="",strCheckboxCommunication="",AutomobileAssociationRateValue="",AutomobileAssociationSumInsuredValue="",TPPDDiscountRateValue="",TPPDDiscountSumInsuredValue="";
    String strIDType ="",strIDTypeName="",strIDNumberEdit,streditdob,yearOfManufactureMonth,strSelectDateYear,ckycNo,uniqueTransactionNumber,strTpFromDateEdit,strTpEndDateEdit,StrPrev_Policy_Type,strMemberEditTxt,DiscountsVale,strValidityTxt,strVehicleNumber,BasicODRateValue="",BasicTpRateValue="",AdditionalElectricalRateValue="",AdditionalElectricalSumInsuredValue="",AdditionalNonElecticalODSumInsuredValue="",AdditionalFibertankODRateValue="",AdditionalLegalLiabilityPaidRate="",AdditionalLegalLiabilityDriverRateValue="",AdditionalBuiltinCngTPRateValue="",AdditionalNonElecticalODRateValue="",AdditionalOtherODRateValue="",AdditionalOtherTpRateValue="",AdditionalPaCoversToEmployessRateValue="",AdditionalPaCoverToOwnerDriverRateValue="",AdditionalPaidDriverRateValue="",AdditionalPaToPassengersRateValue="",AdditionalUnnamedPassengersRateValue="",AdditionalCngKitODRateValue="",AdditionalCngLpgTpRateValue="",AdditionalBuiltinKitODRateValue="",DailyCashRateValue="",AccidentalRateValue="",CostOfConsumablesRateValue="",WrongFuelRateValue="",dailyCashAllowanceMetroRateValue="",dailyCashAllowanceNonMetroRateValue="",EngineProtectorDieselRateValue="", EngineProtectorPetrolRateValue="",HydrostaticLockRateValue="", KeyReplacementRateValue="", NilDepreciationRateValue="", ReturnToInvoiceRateValue="", RoadSideAssistanceRateValue="",SecureTowingRateValue="",TyreRimsecureRateValue="", drivingTrainProtectRateValue="", ManufacturesellingRateValue="",strNomineeName="",strNomineeRelationEdit="";
    EditText IDVEdit,MemberEditTxt,ValidityTxt,addOnsEdit,addCoveragesEdit,basicPremium,VehicleModelEdit,YearEdit,DiscountEdit,TotalDiscountEdit,gstEdit,BasicODEdit,BasicTpEdit,totalAmount,NCBEdit;
    RadioButton VotaryTwoWheelerSevenFiveButton,VotaryTwoWheelerOneButton,VotaryTwoWheelerOneFiveButton,VotaryTwoWheelerThreeButton,VotaryPrivateTwoFiveButton,VotaryPrivateFiveButton,VotaryPrivateSevenFiveButton,VotaryPrivateOneFiveButton,VotaryTwoWheelerFiveButton,PassengerFiveThousnand,PassengerTenLakh,PassengerOneFiveLakh,PassengerTwoLakh,PARadioButtonFiveThousnand,PARadioButtonTenLakh,PARadioButtonOneFiveLakh,PARadioButtonTwoLakh,PAUnNamedFiveThousnand,PAUnNamedTenLakh,PAUnNamedOneFiveLakh,PAUnNamedTwoLakh,MembershipRadio,ValidityRadio,MinRadioButton,MaxRadioButton,OneYearComprehensiveRadio,ThreeYearComprehensiveRadio,FiveYearComprehensiveRadio,OneYearThirdPartyRadio,TwoYearThirdPartyRadio,ThreeYearThirdPartyRadio,OneYearStandardAloneRadio,TwoYearStandardAloneRadio,ThreeYearStandardAloneRadio,PolicyIndividualRadio,PolicyCorporateRadio,PolicyPACoverYesRadio,PolicyPACoverNoRadio,PolicyGPAYesCoverRadio,PolicyGPAYNoCoverRadio,PolicyDrivingLicenceYesRadio,PolicyDrivingLicenceNoRadio;
    SeekBar seekBarDistance;
    TextView AntitheftPremiumTxt,AutomobilePremiumTxt,HandicapPremiumTxt,TPPDPremiumTxt,VotaryPremiumTxt,saveTxt,ViewDetails,TxtViewVehicleType,BasicODPremiumTxt,BasicTPPremiumTxt,ElectricalPremiumTxt,FIBERTANKPremiumTxt,LegalPremiumTxt,NonElectricalPremiumTxt,OtherOdPremiumTxt,OtherTpPremiumTxt,EmployeesInsuredPremiumTxt,OwnerDriverPremiumTxt,PaidDriverPremiumTxt,PassengersPremiumTxt,UnnamedPassengersPremiumTxt,CNGLPGKITODPremiumTxt,CNGLPGKITTPPremiumTxt,BUILTINCNGKITPremiumTxt,BuiltinCngLPGTpPremiumTxt,ManufacturePricePremiumTxt,CoverAddOnText,CoverAdditionalText,VehicleNameText,VehicleNumberText,IdvValueTxt,clcikMy,lessIDVText,HighIDVText,IDVTotalPremium,TotalPremium,DailyCashAllowancePremium,AccidentalHospitalPremium,WrongFuelTxtPremium,CostOfConsumableNamePremium,DailyCashAllowanceNamePremium,DailyCashNonMetroPremium,EngineProtectorDieselPremium,EngineProtectorPetrolPremium,HydrostaticeLockcoverPremium,KeyReplacementPremium,NilDepreciationWaivercoverNamePremium,ReturnToInvoicePremium,RoadsideAssistancePremium,SecureTowingPremium,TyreAndRimSecurePremium,DrivingTrainProtectPremium,AccidentalHospitalRemoveButton,
            DailyCashAllowanceAddButton,DailyCashAllowanceRemoveButton,AccidentalHospitalAddButton,CostOfConsumableAddButton,CostOfConsumableRemoveButton,wrongFuelAddButton,WrongFuelRemoveButton,DailyCashAddButton,DailyCashRemoveButton,DailyCashNonADDButton,DailyCashNonRemoveButton,EngineAddButton,EngineRemoveButton,ENGINEPetrolAddButton,ENGINEPetrolRemoveButton,HydrostaticAddButton,HydrostaticRemoveButton,KeyReplacementAddButton,KeyReplacementRemoveButton,NilAddButton,NilRemoveButton,RetrunToVoiceAddButton,RetrunToVoiceRemoveButton,RoadsideAssistanceAddButton,RoadsideAssistanceRemoveButton,SecureTowingAddButton,SecureTowingRemoveButton,TyreAddButton,TyreRemoveButton,TotalPremiumComprehensive,FiveComprehensiveTxt,thirdComprehensiveTxt,StandardPlanPremium,StandardPlanPremiumTxt,TPTextView,TotalPremiumTp,OneYearComprehensiveTxt,ManufacturePriceButton,ManufacturePriceRemoveButton,DrivingTrainProtectAddButton,DrivingTrainProtectRemoveButton;
    final Calendar myCalendar= Calendar.getInstance();
    DatePickerDialog datePicker;
    int day,year,month,selectYear,daysLeft;
    private MySharedPreference pref;
    Date date,date1,date3;
    Format formatter;
    ImageView AddOnsBack,imgeBike;
    ArrayList<AdditionalCoverGroupModel> CoverGroupData = new ArrayList<>();
    ArrayList<AddonCoverGroupsModel> data1 = new ArrayList<>();
    AdditionalCoverageRecy additionalCoverageRecy;
    AddOnCoverageRecy addOnCoverageRecy;
    CustomProgressDialog customprogress;
    RecyclerView additionalCoverRecyclerview,addOnCoverRecyclerview;
    CardView BasicODCardView,BasicTPCardView,ElectricalCardView,FIBERTANKODCardView,LegalLiabilityCardView,NonLegalLiabilityCardView,OtherOdCardView,OtherTpCardView,EMPLOYEESCardView,OwnerDriverCardView,CngStatusCardView,CNGLPGKITTPStatusCardView,BUILTINCNGKITCardView,BuiltinCngLPGTpCardView,ManufacturePriceSellingCardView,PaidDriverCardView,PASSENGERSCardView,UnnamedPassengerCardView,AccidentalCardView,WrongFuelCardView,CostOfCardView,DailCashAllownceCardView,DailyCashCardView,DailyCardView,EngineProtectorCardView,EngineCardView,HydrostaticeCardView,KeyReplacementCardView,NilCardView,ReturnToInvoiceCardView,RoadsideAssistanceCardView,SecureTowingCardView,TyreCardView,DrivingTrainProtectCardView,AntitheftdeviceCardView,AutomobileCardView,TPPDCardView,VotaryCardView,HandicapDiscountCardView;
    CheckBox AntitheftCheckBox,HandicapCheckBox,TPPDCheckBox,AutomobileCheckBox,VotaryCheckBox,CoverageCheckBox,BasicTPCheckBox,ElectricalCheckBox,FIBERTANKCheckBox,LEGALCheckBox,NonLegalCheckBox,OtherOdCheckBox,OtherTpCheckBox,EmployeesInsuredCheckBox,OWNERDRIVERCheckBox,CNGLPGKITODCheckBox,CNGLPGKITTPCheckBox,BUILTINCNGKITCheckBox,PaidDriverCheckBox,PASSENGERSCheckBox,UnnamedCheckBox,BuiltinCngLPGTpCheckBox;
    double doubleIDVAmt,MathRound,DetarifficValuePremiumDouble,DetarifficLoadingValuePremiumDouble,AdditionalCoverPremiumOD,AdditionalCoverPremiumTP,AdditionalCoverPremiumEl,AdditionalCoverPremiumFI,AdditionalCoverPremiumLegal,AdditionalCoverPremiumNon,AdditionalCoverPremiumOtherOD,AdditionalCoverPremiumOtherTP,AdditionalCoverPremiumPACOVER,AdditionalCoverPremiumOWNERDRIVER,AdditionalCoverPremiumPAIDDRIVER,AdditionalCoverPremiumPASSENGERS,AdditionalCoverPremiumUNNAMED,AdditionalCoverPremiumCNGLPG,AdditionalCoverPremiumCNGLPGTP,AdditionalCoverPremiumManufacturePrice,AdditionalCoverPremiumBuiltinCngLPGTp,AdditionalCoverPremiumBUILTINOD,DailyCashAllowance,AdditionalHospitalization,WrongFuelCover,AdditionalCostOfConsumbales,AdditionalDailyCashMetro,AdditionalDailCash,AdditionalEngineDisesel,AdditionalEnginePetrol,AdditionalHydrosaticLock, AdditionalKeyReplacement, AdditionalNilDepreciation,AdditionalReturnInvoice,AdditionalRoadSide,AdditionalsecureTowing,AdditionalTyreRim,AdditionalDrivingTrainProtect,doubleAntitheftdeviceDiscount,doubleAutomobileAssociationDiscount,doubleTPPDDiscount,doubleVotaryDiscount,doubleHandicapDiscount;
    int strYearOfManufacture,progressChanged,progressChanged1,a,b,c;
    Dialog alert_dialog;
    Dialog CNGalert_dialog;
    Button buttonClose,SubmitIDvBtn;

    LinearLayout LinerPaidDriver,NamedLiner,UnnamedLiner,LinerAutoMobile,LinerPrivate,LinerTwo;
    String AdditionalCoverPremiumElectrical,AdditionalCoverPremiumFiberTank,AdditionalCoverPremiumPaidDriver,AdditionalCoverPremiumNonElectrical,AdditionalCoverPremiumCoverOtherOD,AdditionalCoverPremiumCoverOtherTP,AdditionalCoverPremiumOwnerDriver,AdditionalCoverPremiumPaPaidDriver,AdditionalCoverPremiumPaPassenger,AdditionalCoverPremiumUnnamedPassenger,AdditionalCoverPremiumCngLpgOd,AdditionalCoverPremiumCngLpgKitTp,
            AdditionalCoverPremiumBuiltingKitOD,AdditionalCoverPremiumBultinKitTp,PremiumValueDailyCash,PremiumValueAccidentalHospitalization,PremiumValueWrongFuelCover,PremiumValueCostConsumables,PremiumValueDailyCashMetro,PremiumValueNonMetro,PremiumValueEngineProtecterDiesel,PremiumValueEngineProtecterPetrol,PremiumValueHydrostaticLockDriver,PremiumValueKeyReplacement,PremiumValueNilDepreciation,PremiumValueReturnToInvoice,PremiumValueRoadAssistance,
            PremiumValueSecureTowing,PremiumValueTyreRim,PremiumValueManufacturerSelling,PremiumValueDrivinngTrain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor_add_ons);
        pref = MySharedPreference.getInstance(Motor_AddOns.this);
        getWindow().setStatusBarColor(ContextCompat.getColor(Motor_AddOns.this, R.color.colorPrimaryDark));
        customprogress = new CustomProgressDialog(Motor_AddOns.this);
        strVehicleNo = getIntent().getStringExtra("strVehicleNo");
        strName = getIntent().getStringExtra("strName");
        streditdob = getIntent().getStringExtra("streditdob");
        strVehicleNumber = getIntent().getStringExtra("strVehicleNumber");
        str_edt_city = getIntent().getStringExtra("str_edt_city");
        strMemberEditTxt = getIntent().getStringExtra("MemberEditTxt");
        strValidityTxt = getIntent().getStringExtra("ValidityTxt");
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
        strRTOName = getIntent().getStringExtra("strRTOName");
        strPolicyNumberEdit = getIntent().getStringExtra("strPolicyNumberEdit");
        strPlanType = getIntent().getStringExtra("strPlanType");
        strCoverageType = getIntent().getStringExtra("strCoverageType");
        strPACover = getIntent().getStringExtra("strPACover");
        strGPACover = getIntent().getStringExtra("strGPACover");
        strDrivingLicence = getIntent().getStringExtra("strDrivingLicence");
        strPlanYear = getIntent().getStringExtra("strPlanYear");
        strVehicleManufacturerCode = getIntent().getStringExtra("strVehicleManufacturerCode");
        strRTOCode = getIntent().getStringExtra("strRTOCode");
        yearOfManufacture = getIntent().getStringExtra("yearOfManufacture");
        strVehicleAge = getIntent().getStringExtra("strVehicleAge");
        strVehicleModelCode = getIntent().getStringExtra("strVehicleModelCode");
        TotalValue = getIntent().getStringExtra("TotalValue");
        strIdvValueTxt = getIntent().getStringExtra("strIdvValueTxt");
        strIdvValueTxtSelect = getIntent().getStringExtra("strIdvValueTxtSelect");
        strLessIDVText = getIntent().getStringExtra("strLessIDVText");
        strHighIDVText = getIntent().getStringExtra("strHighIDVText");
        NetPremiumValue = getIntent().getStringExtra("NetPremiumValue");
        GST = getIntent().getStringExtra("GST");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
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
        nextYear = getIntent().getStringExtra("nextYear");
        vehicleManufacturerType = getIntent().getStringExtra("vehicleManufacturerType");
        strModelType = getIntent().getStringExtra("strModelType");
        addOnsCover = getIntent().getStringExtra("addOnsCover");
        addOnsAditional = getIntent().getStringExtra("addOnsAditional");
        SeekbarStatus = getIntent().getStringExtra("SeekbarStatus");
        StrAdditionalCoverPremiumOD = getIntent().getStringExtra("StrAdditionalCoverPremiumOD");
        StrAdditionalCoverPremiumTp = getIntent().getStringExtra("StrAdditionalCoverPremiumTp");
        strPreviousClaimRadio = getIntent().getStringExtra("strPreviousClaimRadio");
        CNGLPGKITODStatus = getIntent().getStringExtra("CNGLPGKITODStatus");
        CNGLPGKITTPStatus = getIntent().getStringExtra("CNGLPGKITTPStatus");
        BUILTINCNGKIT_LPGKITODStatus = getIntent().getStringExtra("BUILTINCNGKIT_LPGKITODStatus");
        MANUFACTURERSELLINGPRICEStatus = getIntent().getStringExtra("MANUFACTURERSELLINGPRICEStatus");
        DRIVINGTRAINPROTECTStatus = getIntent().getStringExtra("DRIVINGTRAINPROTECTStatus");
        CheckString = getIntent().getStringExtra("CheckString");
        AdditionalElectricalRateValue = getIntent().getStringExtra("AdditionalElectricalRateValue");
        AdditionalFibertankODRateValue = getIntent().getStringExtra("AdditionalFibertankODRateValue");
        AdditionalLegalLiabilityPaidRate = getIntent().getStringExtra("AdditionalLegalLiabilityPaidRate");
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
        BUILTINCNGKIT_LPGKITTPStatus = getIntent().getStringExtra("BUILTINCNGKIT_LPGKITTPStatus");
        BasicODRateValue = getIntent().getStringExtra("BasicODRateValue");
        BasicTpRateValue = getIntent().getStringExtra("BasicTpRateValue");
        changeseekBar = getIntent().getStringExtra("changeseekBar");
        strStateCode = getIntent().getStringExtra("strStateCode");
        DAILYCASHALLOWANCEStatus = getIntent().getStringExtra("DAILYCASHALLOWANCEStatus");
        WRONGFUELCOVERStatus = getIntent().getStringExtra("WRONGFUELCOVERStatus");
        WrongFuelRateValue = getIntent().getStringExtra("WrongFuelRateValue");
        DailyCashRateValue = getIntent().getStringExtra("DailyCashRateValue");
        DetarifficValuePremium = getIntent().getStringExtra("DetarifficValuePremium");
        DetarifficValueRate = getIntent().getStringExtra("DetarifficValueRate");
        DetarifficLodingValuePremium = getIntent().getStringExtra("DetarifficLodingValuePremium");
        DetarifficLoadingValueRate = getIntent().getStringExtra("DetarifficLoadingValueRate");
        strNewFor = getIntent().getStringExtra("strNewFor");
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
        strCheckedTermCondition = getIntent().getStringExtra("strCheckedTermCondition");
        strCheckboxCommunication = getIntent().getStringExtra("strCheckboxCommunication");
        strCityCommunicationCode = getIntent().getStringExtra("strCityCommunicationCode");
        strNomineeName = getIntent().getStringExtra("strNomineeName");
        strVehicleCubicCapicity = getIntent().getStringExtra("strVehicleCubicCapicity");
        strVehicleImage = getIntent().getStringExtra("strVehicleImage");
        strNomineeRelationEdit = getIntent().getStringExtra("strNomineeRelationEdit");
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
        strDiscountEdit = getIntent().getStringExtra("strDiscountEdit");
        StrNCB = getIntent().getStringExtra("StrNCB");
        ChangeAddons = getIntent().getStringExtra("ChangeAddons");
        DetarifficValueDiscount = getIntent().getStringExtra("DetarifficValueDiscount");
        progressChanged =getIntent().getIntExtra("progressChanged", 0);
        selectYear =getIntent().getIntExtra("selectYear", 0);
        daysLeft =getIntent().getIntExtra("daysLeft", 0);
        a =getIntent().getIntExtra("a", 0);
        b =getIntent().getIntExtra("b", 0);
        c =getIntent().getIntExtra("c", 0);
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
        VoluntarydeductableDiscountAmount = getIntent().getStringExtra("VoluntarydeductableDiscountAmount");
        ELECTRICALACCESSORYODSumInsured = getIntent().getStringExtra("ELECTRICALACCESSORYODSumInsured");
        NONELECTRICALACCESSORYODSumInsured = getIntent().getStringExtra("NONELECTRICALACCESSORYODSumInsured");
        StrPrev_Policy_Type = getIntent().getStringExtra("StrPrev_Policy_Type");
        CNGLPGKITODSumInsured = getIntent().getStringExtra("CNGLPGKITODSumInsured");
        strTpFromDateEdit = getIntent().getStringExtra("strTpFromDateEdit");
        strTpEndDateEdit = getIntent().getStringExtra("strTpEndDateEdit");
        ckycNo = getIntent().getStringExtra("ckycNo");
        uniqueTransactionNumber = getIntent().getStringExtra("uniqueTransactionNumber");
        yearOfManufactureMonth = getIntent().getStringExtra("yearOfManufactureMonth");
        strSelectDateYear = getIntent().getStringExtra("strSelectDateYear");
        strIDType = getIntent().getStringExtra("strIDType");
        strIDTypeName = getIntent().getStringExtra("strIDTypeName");
        strIDTypeName1 = getIntent().getStringExtra("strIDTypeName1");
        strIDNumberEdit = getIntent().getStringExtra("strIDNumberEdit");

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
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        tomorrowDate = formatter.format(date);
        Log.e("tomorrowDate",tomorrowDate);

        int strThirdDString1= Integer.parseInt(strThirdDString);
        strYearOfManufacture= Integer.parseInt(yearOfManufacture);

//        if (strFor.equals("0")){
//          if (!(strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old"))) {
//             strYearOfManufacture= Integer.parseInt(yearOfManufacture);
//        }
//        }else{
//             if (!(strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old"))) {
//        }
//        }

        calendar.add(Calendar.DATE, 364);
        date1 = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        nextYear = formatter.format(date1);
        Log.e("nextYear", nextYear);

        strVehicleAge= String.valueOf(strThirdDString1-strYearOfManufacture);
        Log.e("strVehicleAge",strVehicleAge);

        if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("New")) {
            CubicCapacity= "0";
            rc_cubic_cap=CubicCapacity;
        }
        initView();
    }
    private void initView() {
        SubmitIDvBtn=findViewById(R.id.SubmitIDvBtn);
        IDVEdit=findViewById(R.id.IDVEdit);
        MemberEditTxt=findViewById(R.id.MemberEditTxt);
        ValidityTxt=findViewById(R.id.ValidityTxt);
        continue_button=findViewById(R.id.continue_button);
        IndividualLiner=findViewById(R.id.IndividualLiner);
        OneYearComprehensiveRadio=findViewById(R.id.OneYearComprehensiveRadio);
        ThreeYearComprehensiveRadio=findViewById(R.id.ThreeYearComprehensiveRadio);
        FiveYearComprehensiveRadio=findViewById(R.id.FiveYearComprehensiveRadio);
        OneYearThirdPartyRadio=findViewById(R.id.OneYearThirdPartyRadio);
        TwoYearThirdPartyRadio=findViewById(R.id.TwoYearThirdPartyRadio);
        ThreeYearThirdPartyRadio=findViewById(R.id.ThreeYearThirdPartyRadio);
        OneYearStandardAloneRadio=findViewById(R.id.OneYearStandardAloneRadio);
        TwoYearStandardAloneRadio=findViewById(R.id.TwoYearStandardAloneRadio);
        ThreeYearStandardAloneRadio=findViewById(R.id.ThreeYearStandardAloneRadio);
        BookNowLinerComprehensive=findViewById(R.id.BookNowLinerComprehensive);
        PolicyIndividualRadio=findViewById(R.id.PolicyIndividualRadio);
        PolicyCorporateRadio=findViewById(R.id.PolicyCorporateRadio);
        PolicyPACoverYesRadio=findViewById(R.id.PolicyPACoverYesRadio);
        PolicyPACoverNoRadio=findViewById(R.id.PolicyPACoverNoRadio);
        PolicyGPAYesCoverRadio=findViewById(R.id.PolicyGPAYesCoverRadio);
        PolicyGPAYNoCoverRadio=findViewById(R.id.PolicyGPAYNoCoverRadio);
        PolicyDrivingLicenceYesRadio=findViewById(R.id.PolicyDrivingLicenceYesRadio);
        PolicyDrivingLicenceNoRadio=findViewById(R.id.PolicyDrivingLicenceNoRadio);
        seekBarDistance=findViewById(R.id.seekBarDistance);
        IdvValueTxt=findViewById(R.id.IdvValueTxt);
        clcikMy=findViewById(R.id.clcikMy);
        lessIDVText=findViewById(R.id.lessIDVText);
        HighIDVText=findViewById(R.id.HighIDVText);
        VehicleNameText=findViewById(R.id.VehicleNameText);
        VehicleNumberText=findViewById(R.id.VehicleNumberText);
        IDVTotalPremium=findViewById(R.id.IDVTotalPremium);
        TotalPremium=findViewById(R.id.TotalPremium);
        additionalCoverRecyclerview=findViewById(R.id.AdditionalCoverRecyclerview);
        addOnCoverRecyclerview=findViewById(R.id.AddOnCoverRecyclerview);
        BasicODPremiumTxt=findViewById(R.id.BasicODPremiumTxt);
        BasicTPPremiumTxt=findViewById(R.id.BasicTPPremiumTxt);
        ElectricalPremiumTxt=findViewById(R.id.ElectricalPremiumTxt);
        FIBERTANKPremiumTxt=findViewById(R.id.FIBERTANKPremiumTxt);
        LegalPremiumTxt=findViewById(R.id.LegalPremiumTxt);
        NonElectricalPremiumTxt=findViewById(R.id.NonElectricalPremiumTxt);
        CoverAddOnText=findViewById(R.id.CoverAddOnText);
        CoverAdditionalText=findViewById(R.id.CoverAdditionalText);
        DailyCashAllowancePremium=findViewById(R.id.DailyCashAllowancePremium);
        AccidentalHospitalPremium=findViewById(R.id.AccidentalHospitalPremium);
        WrongFuelTxtPremium=findViewById(R.id.WrongFuelTxtPremium);
        CostOfConsumableNamePremium=findViewById(R.id.CostOfConsumableNamePremium);
        DailyCashAllowanceNamePremium=findViewById(R.id.DailyCashAllowanceNamePremium);
        DailyCashNonMetroPremium=findViewById(R.id.DailyCashNonMetroPremium);
        EngineProtectorDieselPremium=findViewById(R.id.EngineProtectorDieselPremium);
        EngineProtectorPetrolPremium=findViewById(R.id.EngineProtectorPetrolPremium);
        HydrostaticeLockcoverPremium=findViewById(R.id.HydrostaticeLockcoverPremium);
        KeyReplacementPremium=findViewById(R.id.KeyReplacementPremium);
        NilDepreciationWaivercoverNamePremium=findViewById(R.id.NilDepreciationWaivercoverNamePremium);
        ReturnToInvoicePremium=findViewById(R.id.ReturnToInvoicePremium);
        RoadsideAssistancePremium=findViewById(R.id.RoadsideAssistancePremium);
        SecureTowingPremium=findViewById(R.id.SecureTowingPremium);
        TyreAndRimSecurePremium=findViewById(R.id.TyreAndRimSecurePremium);
        DrivingTrainProtectPremium=findViewById(R.id.DrivingTrainProtectPremium);
        BasicODCardView=findViewById(R.id.BasicODCardView);
        BasicTPCardView=findViewById(R.id.BasicTPCardView);
        ElectricalCardView=findViewById(R.id.ElectricalCardView);
        FIBERTANKODCardView=findViewById(R.id.FIBERTANKODCardView);
        LegalLiabilityCardView=findViewById(R.id.LegalLiabilityCardView);
        NonLegalLiabilityCardView=findViewById(R.id.NonLegalLiabilityCardView);
        OtherOdCardView=findViewById(R.id.OtherOdCardView);
        OtherTpCardView=findViewById(R.id.OtherTpCardView);
        EMPLOYEESCardView=findViewById(R.id.EMPLOYEESCardView);
        OwnerDriverCardView=findViewById(R.id.OwnerDriverCardView);
        CngStatusCardView=findViewById(R.id.CngStatusCardView);
        CNGLPGKITTPStatusCardView=findViewById(R.id.CNGLPGKITTPStatusCardView);
        BUILTINCNGKITCardView=findViewById(R.id.BUILTINCNGKITCardView);
        BuiltinCngLPGTpCardView=findViewById(R.id.BuiltinCngLPGTpCardView);
        ManufacturePriceSellingCardView=findViewById(R.id.ManufacturePriceSellingCardView);
        PaidDriverCardView=findViewById(R.id.PaidDriverCardView);
        PASSENGERSCardView=findViewById(R.id.PASSENGERSCardView);
        UnnamedPassengerCardView=findViewById(R.id.UnnamedPassengerCardView);
        OtherOdPremiumTxt=findViewById(R.id.OtherOdPremiumTxt);
        OtherTpPremiumTxt=findViewById(R.id.OtherTpPremiumTxt);
        EmployeesInsuredPremiumTxt=findViewById(R.id.EmployeesInsuredPremiumTxt);
        OwnerDriverPremiumTxt=findViewById(R.id.OwnerDriverPremiumTxt);
        PaidDriverPremiumTxt=findViewById(R.id.PaidDriverPremiumTxt);
        PassengersPremiumTxt=findViewById(R.id.PassengersPremiumTxt);
        UnnamedPassengersPremiumTxt=findViewById(R.id.UnnamedPassengersPremiumTxt);
        CNGLPGKITODPremiumTxt=findViewById(R.id.CNGLPGKITODPremiumTxt);
        CNGLPGKITTPPremiumTxt=findViewById(R.id.CNGLPGKITTPPremiumTxt);
        BUILTINCNGKITPremiumTxt=findViewById(R.id.BUILTINCNGKITPremiumTxt);
        BuiltinCngLPGTpPremiumTxt=findViewById(R.id.BuiltinCngLPGTpPremiumTxt);
        ManufacturePricePremiumTxt=findViewById(R.id.ManufacturePricePremiumTxt);
        AccidentalCardView=findViewById(R.id.AccidentalCardView);
        WrongFuelCardView=findViewById(R.id.WrongFuelCardView);
        CostOfCardView=findViewById(R.id.CostOfCardView);
        DailCashAllownceCardView=findViewById(R.id.DailCashAllownceCardView);
        DailyCashCardView=findViewById(R.id.DailyCashCardView);
        DailyCardView=findViewById(R.id.DailyCardView);
        EngineProtectorCardView=findViewById(R.id.EngineProtectorCardView);
        EngineCardView=findViewById(R.id.EngineCardView);
        HydrostaticeCardView=findViewById(R.id.HydrostaticeCardView);
        KeyReplacementCardView=findViewById(R.id.KeyReplacementCardView);
        NilCardView=findViewById(R.id.NilCardView);
        ReturnToInvoiceCardView=findViewById(R.id.ReturnToInvoiceCardView);
        RoadsideAssistanceCardView=findViewById(R.id.RoadsideAssistanceCardView);
        SecureTowingCardView=findViewById(R.id.SecureTowingCardView);
        TyreCardView=findViewById(R.id.TyreCardView);
        DrivingTrainProtectCardView=findViewById(R.id.DrivingTrainProtectCardView);
        AntitheftdeviceCardView=findViewById(R.id.AntitheftdeviceCardView);
        AutomobileCardView=findViewById(R.id.AutomobileCardView);
        TPPDCardView=findViewById(R.id.TPPDCardView);
        VotaryCardView=findViewById(R.id.VotaryCardView);
        HandicapDiscountCardView=findViewById(R.id.HandicapDiscountCardView);
        AutomobileCheckBox=findViewById(R.id.AutomobileCheckBox);
        VotaryCheckBox=findViewById(R.id.VotaryCheckBox);
        CoverageCheckBox=findViewById(R.id.CoverageCheckBox);
        BasicTPCheckBox=findViewById(R.id.BasicTPCheckBox);
        ElectricalCheckBox=findViewById(R.id.ElectricalCheckBox);
        FIBERTANKCheckBox=findViewById(R.id.FIBERTANKCheckBox);
        LEGALCheckBox=findViewById(R.id.LEGALCheckBox);
        NonLegalCheckBox=findViewById(R.id.NonLegalCheckBox);
        OtherOdCheckBox=findViewById(R.id.OtherOdCheckBox);
        OtherTpCheckBox=findViewById(R.id.OtherTpCheckBox);
        EmployeesInsuredCheckBox=findViewById(R.id.EmployeesInsuredCheckBox);
        OWNERDRIVERCheckBox=findViewById(R.id.OWNERDRIVERCheckBox);
        CNGLPGKITODCheckBox=findViewById(R.id.CNGLPGKITODCheckBox);
        CNGLPGKITTPCheckBox=findViewById(R.id.CNGLPGKITTPCheckBox);
        BUILTINCNGKITCheckBox=findViewById(R.id.BUILTINCNGKITCheckBox);
        PaidDriverCheckBox=findViewById(R.id.PaidDriverCheckBox);
        LinerPaidDriver=findViewById(R.id.LinerPaidDriver);
        PASSENGERSCheckBox=findViewById(R.id.PASSENGERSCheckBox);
        NamedLiner=findViewById(R.id.NamedLiner);
        UnnamedCheckBox=findViewById(R.id.UnnamedCheckBox);
        UnnamedLiner=findViewById(R.id.UnnamedLiner);
        LinerAutoMobile=findViewById(R.id.LinerAutoMobile);
        LinerPrivate=findViewById(R.id.LinerPrivate);
        LinerTwo=findViewById(R.id.LinerTwo);
        BuiltinCngLPGTpCheckBox=findViewById(R.id.BuiltinCngLPGTpCheckBox);
        AccidentalHospitalAddButton=findViewById(R.id.AccidentalHospitalAddButton);
        DailyCashAllowanceAddButton=findViewById(R.id.DailyCashAllowanceAddButton);
        DailyCashAllowanceRemoveButton=findViewById(R.id.DailyCashAllowanceRemoveButton);
        ManufacturePriceButton=findViewById(R.id.ManufacturePriceButton);
        ManufacturePriceRemoveButton=findViewById(R.id.ManufacturePriceRemoveButton);
        DrivingTrainProtectAddButton=findViewById(R.id.DrivingTrainProtectAddButton);
        DrivingTrainProtectRemoveButton=findViewById(R.id.DrivingTrainProtectRemoveButton);
        CostOfConsumableAddButton=findViewById(R.id.CostOfConsumableAddButton);
        CostOfConsumableRemoveButton=findViewById(R.id.CostOfConsumableRemoveButton);
        wrongFuelAddButton=findViewById(R.id.wrongFuelAddButton);
        WrongFuelRemoveButton=findViewById(R.id.WrongFuelRemoveButton);
        DailyCashAddButton=findViewById(R.id.DailyCashAddButton);
        DailyCashRemoveButton=findViewById(R.id.DailyCashRemoveButton);
        DailyCashNonADDButton=findViewById(R.id.DailyCashNonADDButton);
        DailyCashNonRemoveButton=findViewById(R.id.DailyCashNonRemoveButton);
        EngineAddButton=findViewById(R.id.EngineAddButton);
        EngineRemoveButton=findViewById(R.id.EngineRemoveButton);
        ENGINEPetrolAddButton=findViewById(R.id.ENGINEPetrolAddButton);
        ENGINEPetrolRemoveButton=findViewById(R.id.ENGINEPetrolRemoveButton);
        HydrostaticAddButton=findViewById(R.id.HydrostaticAddButton);
        HydrostaticRemoveButton=findViewById(R.id.HydrostaticRemoveButton);
        KeyReplacementAddButton=findViewById(R.id.KeyReplacementAddButton);
        KeyReplacementRemoveButton=findViewById(R.id.KeyReplacementRemoveButton);
        NilAddButton=findViewById(R.id.NilAddButton);
        NilRemoveButton=findViewById(R.id.NilRemoveButton);
        RetrunToVoiceAddButton=findViewById(R.id.RetrunToVoiceAddButton);
        RetrunToVoiceRemoveButton=findViewById(R.id.RetrunToVoiceRemoveButton);
        RoadsideAssistanceAddButton=findViewById(R.id.RoadsideAssistanceAddButton);
        RoadsideAssistanceRemoveButton=findViewById(R.id.RoadsideAssistanceRemoveButton);
        SecureTowingAddButton=findViewById(R.id.SecureTowingAddButton);
        SecureTowingRemoveButton=findViewById(R.id.SecureTowingRemoveButton);
        TyreAddButton=findViewById(R.id.TyreAddButton);
        TyreRemoveButton=findViewById(R.id.TyreRemoveButton);
        ThreeYearLiner=findViewById(R.id.ThreeYearLiner);
        FiveYearLiner=findViewById(R.id.FiveYearLiner);
        TotalPremiumComprehensive=findViewById(R.id.TotalPremiumComprehensive);
        thirdComprehensiveTxt=findViewById(R.id.thirdComprehensiveTxt);
        FiveComprehensiveTxt=findViewById(R.id.FiveComprehensiveTxt);
        StandardPlanPremium=findViewById(R.id.StandardPlanPremium);
        StandardPlanPremiumTxt=findViewById(R.id.StandardPlanPremiumTxt);
        TPTextView=findViewById(R.id.TPTextView);
        TotalPremiumTp=findViewById(R.id.TotalPremiumTp);
        OneYearComprehensiveTxt=findViewById(R.id.OneYearComprehensiveTxt);
        TxtViewVehicleType=findViewById(R.id.TxtViewVehicleType);
        AddOnsBack=findViewById(R.id.AddOnsBack);
        ViewDetails=findViewById(R.id.ViewDetails);
        imgeBike=findViewById(R.id.imgeBike);
        saveTxt=findViewById(R.id.saveTxt);
        AntitheftPremiumTxt=findViewById(R.id.AntitheftPremiumTxt);
        AutomobilePremiumTxt=findViewById(R.id.AutomobilePremiumTxt);
        HandicapPremiumTxt=findViewById(R.id.HandicapPremiumTxt);
        VotaryPremiumTxt=findViewById(R.id.VotaryPremiumTxt);
        TPPDPremiumTxt=findViewById(R.id.TPPDPremiumTxt);
        linerCenterBike=findViewById(R.id.linerCenterBike);
        HighRiskLiner=findViewById(R.id.HighRiskLiner);
        LowRiskLiner=findViewById(R.id.LowRiskLiner);
        DrivingLiner=findViewById(R.id.DrivingLiner);
        AccidentalHospitalRemoveButton=findViewById(R.id.AccidentalHospitalRemoveButton);
        MembershipRadio=findViewById(R.id.MembershipRadio);
        ValidityRadio=findViewById(R.id.ValidityRadio);
        MinRadioButton=findViewById(R.id.MinRadioButton);
        MaxRadioButton=findViewById(R.id.MaxRadioButton);
        PARadioButtonFiveThousnand=findViewById(R.id.PARadioButtonFiveThousnand);
        PARadioButtonTenLakh=findViewById(R.id.PARadioButtonTenLakh);
        PARadioButtonOneFiveLakh=findViewById(R.id.PARadioButtonOneFiveLakh);
        PARadioButtonTwoLakh=findViewById(R.id.PARadioButtonTwoLakh);
        VotaryPrivateTwoFiveButton=findViewById(R.id.VotaryPrivateTwoFiveButton);
        VotaryPrivateFiveButton=findViewById(R.id.VotaryPrivateFiveButton);
        VotaryPrivateSevenFiveButton=findViewById(R.id.VotaryPrivateSevenFiveButton);
        VotaryPrivateOneFiveButton=findViewById(R.id.VotaryPrivateOneFiveButton);
        VotaryTwoWheelerFiveButton=findViewById(R.id.VotaryTwoWheelerFiveButton);
        VotaryTwoWheelerSevenFiveButton=findViewById(R.id.VotaryTwoWheelerSevenFiveButton);
        VotaryTwoWheelerOneButton=findViewById(R.id.VotaryTwoWheelerOneButton);
        VotaryTwoWheelerOneFiveButton=findViewById(R.id.VotaryTwoWheelerOneFiveButton);
        VotaryTwoWheelerThreeButton=findViewById(R.id.VotaryTwoWheelerThreeButton);
        PassengerFiveThousnand=findViewById(R.id.PassengerFiveThousnand);
        PassengerTenLakh=findViewById(R.id.PassengerTenLakh);
        PassengerOneFiveLakh=findViewById(R.id.PassengerOneFiveLakh);
        PassengerTwoLakh=findViewById(R.id.PassengerTwoLakh);
        PAUnNamedFiveThousnand=findViewById(R.id.PAUnNamedFiveThousnand);
        PAUnNamedTenLakh=findViewById(R.id.PAUnNamedTenLakh);
        PAUnNamedOneFiveLakh=findViewById(R.id.PAUnNamedOneFiveLakh);
        PAUnNamedTwoLakh=findViewById(R.id.PAUnNamedTwoLakh);
        AntitheftCheckBox=findViewById(R.id.AntitheftCheckBox);
        HandicapCheckBox=findViewById(R.id.HandicapCheckBox);
        TPPDCheckBox=findViewById(R.id.TPPDCheckBox);

        VehicleNameText.setText(str_vehicleManufacturerNm+" "+strVehicleModel);

        strVehicleNo="New";
        VehicleNumberText.setText(strVehicleNo);
        if (strVehicleTypeRadio.equals("Four Wheeler")){
            TxtViewVehicleType.setText("Four Wheeler Insurance");
            OneYearComprehensiveRadio.setText("1 Year OD + 3 Year TP  ");
            imgeBike.setBackgroundResource(R.drawable.fourwheelerimg);
            Drawable thumb = ContextCompat.getDrawable(Motor_AddOns.this,R.drawable.car_seekbar);
            seekBarDistance.setThumb(thumb);
        }else{
            TxtViewVehicleType.setText("Two Wheeler Insurance");
            OneYearComprehensiveRadio.setText("1 Year OD + 5 Year TP  ");
            imgeBike.setBackgroundResource(R.drawable.scooty_motor_img);
            Drawable thumb = ContextCompat.getDrawable(Motor_AddOns.this,R.drawable.bike_motor_seekbar);
            seekBarDistance.setThumb(thumb);
        }

        strFor=strNewFor;
        if (strFor.equals("0")){
            strIdvValueTxt="";
            strCoverageType="Individual";
            strPACover="No";
            strGPACover="No";
            strDrivingLicence="No";
            strPlanYear="1 Year";
            strPlanType="Comprehensive";
            SeekbarStatus="Center";
            strMinMax="";
            AutoMobileValidityRadio="False";
            AutoMobileRadio="False";
            PolicyIndividualRadio.setChecked(true);
            PolicyPACoverNoRadio.setChecked(true);
            PolicyGPAYNoCoverRadio.setChecked(true);
            PolicyDrivingLicenceNoRadio.setChecked(true);
            DrivingLiner.setVisibility(View.GONE);
            if (strVehicleTypeRadio.equals("Four Wheeler")){
                VehicleClassCode="45";
                NumberOfWheels="6";
                strPlanYear="1 Year OD + 3 Year TP ";
                OneYearComprehensiveRadio.setText("1 Year OD + 3 Year TP  ");
                Calendar calendar = Calendar.getInstance();
                date = calendar.getTime();
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                today = formatter.format(date);
                String[] strTDate = today.split("/");
                String strFirstDString = strTDate[0];
                String strSecondDString = strTDate[1];
                strThirdDString = strTDate[2];
                Log.e("strThirdDString", strThirdDString);
                Log.e("Today", today);

                calendar.add(Calendar.DATE, 1);
                date = calendar.getTime();
                formatter = new SimpleDateFormat("dd/MM/yyyy");

                calendar.add(Calendar.DATE, 364*3);
                date1 = calendar.getTime();
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                nextYear = formatter.format(date1);
                Log.e("nextYear", nextYear);
                ProductName="MOTOR - MOTOR PRIVATE CAR - BUNDLED";
                ProductCode="2367";
            }
            else{
                VehicleClassCode="37";
                NumberOfWheels="2";
                strPlanYear="1 Year OD + 5 Year TP ";
                OneYearComprehensiveRadio.setText("1 Year OD + 5 Year TP  ");
                Calendar calendar = Calendar.getInstance();
                date = calendar.getTime();
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                today = formatter.format(date);
                String[] strTDate = today.split("/");
                String strFirstDString = strTDate[0];
                String strSecondDString = strTDate[1];
                strThirdDString = strTDate[2];
                Log.e("strThirdDString", strThirdDString);
                Log.e("Today", today);

                calendar.add(Calendar.DATE, 1);
                date = calendar.getTime();
                formatter = new SimpleDateFormat("dd/MM/yyyy");

                calendar.add(Calendar.DATE, 364*5);
                date1 = calendar.getTime();
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                nextYear = formatter.format(date1);
                Log.e("nextYear", nextYear);
                ProductName="MOTOR - MOTOR TWO WHEELER  - BUNDLED";
                ProductCode="2369";
            }
            BasicODStatus="True";
            BasicTP="True";
            ELECTRICALACCESSORYODStatus="False";
            ELECTRICALACCESSORYODSumInsured="1000";
            NONELECTRICALACCESSORYODStatus="False";
            NONELECTRICALACCESSORYODSumInsured="1000";
            PACOVERTOEMPLOYEESOFINSUREDStatus="False";
            PACOVERTOPASSENGERSStatus="False";
            PACOVERTOPASSENGERSSumInsured="50000";
            PACOVERTOPAIDDRIVERStatus="False";
            PACOVERTOPAIDDRIVERSumInsured="50000";
            OtherTpStatus="False";
            FIBERTANKODStatus="False";
            OtherODStatus="False";
            UNNAMEDPACOVERTOPASSENGERSStatus="False";
            UNNAMEDPACOVERTOPASSENGERSSumInsured="50000";
            PACOVERTOOWNERDRIVERStatus="False";
            MANUFACTURERSELLINGPRICEStatus="False";
            DRIVINGTRAINPROTECTStatus="False";
            LEGALLIABILITYTOPAIDDRIVERStatus="False";
            RoadsideAssistanceStatus="False";
            NilDepreciationWaivercoverStatus="False";
            DAILYCASHALLOWANCENONMETROStatus="False";
            DAILYCASHALLOWANCEMETROStatus="False";
            KEYREPLACEMENTStatus="False";
            RETURNTOINVOICEStatus="False";
            ACCIDENTALHOSPITALIZATIONStatus="False";
            HYDROSTATICLOCKCOVERStatus="False";
            COSTOFCONSUMABLESStatus="False";
            SECURETOWINGStatus="False";
            TyreandRimsecureStatus="False";
            ENGINEPROTECTORPETROLStatus="False";
            ENGINEPROTECTORDIESELStatus="False";
            DAILYCASHALLOWANCEStatus="False";
            WRONGFUELCOVERStatus="False";
            AntitheftdevicediscountStatus="False";
            AutomobileAssociationdiscountStatus="False";
            VoluntarydeductableStatus="False";
            TPPDDiscountStatus="False";
            HandicapDiscountStatus="False";
            AutomobileAssociationdiscountSumInsured="";
            DetariffDiscountStatus="True";
            DetariffLoadingStatus="True";

            if (strVehicleTypeRadio.equals("Four Wheeler")){
                VoluntarydeductableSumInsured="2500";
                if (FuleType.equals("Petrol")){
                    CNGLPGKITODStatus1="True";
                    CNGLPGKITTPStatus1="True";
                    CNGLPGKITODStatus="False";
                    CNGLPGKITTPStatus="False";
                    BUILTINCNGKIT_LPGKITODStatus1="False";
                    BUILTINCNGKIT_LPGKITTPStatus1="False";
                    BUILTINCNGKITCheckBox.setChecked(false);
                    BuiltinCngLPGTpCheckBox.setChecked(false);
                    BUILTINCNGKITCheckBox.setClickable(true);
                    BuiltinCngLPGTpCheckBox.setClickable(true);
                }else if (FuleType.equals("LPG")||FuleType.equals("CNG")){
                    BUILTINCNGKIT_LPGKITODStatus1="True";
                    BUILTINCNGKIT_LPGKITTPStatus1="True";
                    CNGLPGKITODStatus1="False";
                    CNGLPGKITTPStatus1="False";
                    CNGLPGKITODStatus="False";
                    CNGLPGKITODSumInsured="1000";
                    CNGLPGKITTPStatus="False";
                    BUILTINCNGKIT_LPGKITODStatus="True";
                    BUILTINCNGKIT_LPGKITTPStatus="True";
                    BUILTINCNGKITCheckBox.setChecked(true);
                    BuiltinCngLPGTpCheckBox.setChecked(true);
                    BUILTINCNGKITCheckBox.setClickable(false);
                    BuiltinCngLPGTpCheckBox.setClickable(false);
                }else{
                    BUILTINCNGKIT_LPGKITODStatus1="False";
                    BUILTINCNGKIT_LPGKITTPStatus1="False";
                    CNGLPGKITODStatus1="False";
                    CNGLPGKITTPStatus1="False";
                    CNGLPGKITODStatus="False";
                    CNGLPGKITODSumInsured="1000";
                    CNGLPGKITTPStatus="False";
                    BUILTINCNGKIT_LPGKITODStatus="False";
                    BUILTINCNGKIT_LPGKITTPStatus="False";
                    BUILTINCNGKITCheckBox.setChecked(false);
                    BuiltinCngLPGTpCheckBox.setChecked(false);
                    BUILTINCNGKITCheckBox.setClickable(true);
                    BuiltinCngLPGTpCheckBox.setClickable(true);
                }

            }
            else{
                VoluntarydeductableSumInsured="500";
                BUILTINCNGKIT_LPGKITODStatus1="False";
                BUILTINCNGKIT_LPGKITTPStatus1="False";
                CNGLPGKITODStatus1="False";
                CNGLPGKITTPStatus1="False";
                BUILTINCNGKIT_LPGKITODStatus="False";
                BUILTINCNGKIT_LPGKITTPStatus="False";
                CNGLPGKITODStatus="False";
                CNGLPGKITODSumInsured="1000";
                CNGLPGKITTPStatus="False";
                BUILTINCNGKITCheckBox.setChecked(false);
                BuiltinCngLPGTpCheckBox.setChecked(false);
                BUILTINCNGKITCheckBox.setClickable(true);
                BuiltinCngLPGTpCheckBox.setClickable(true);
            }
            addOnsShow();
            VehicleMotorQuotation();
        }
        else{
            if (CheckString.equals("1")){
                DetariffDiscountStatus="True";
                DetariffLoadingStatus="True";
                VehicleMotorQuotation();
                addOnsShow();

                IDVTotalPremium.setText(strIdvValueTxtSelect);
                IdvValueTxt.setText(strIdvValueTxt);
                lessIDVText.setText(strLessIDVText);
                HighIDVText.setText(strHighIDVText);
                if (ELECTRICALACCESSORYODStatus.equals("True")){
                    ElectricalCheckBox.setChecked(true);
                }else{
                    ElectricalCheckBox.setChecked(false);
                }
                if (NONELECTRICALACCESSORYODStatus.equals("True")){
                    NonLegalCheckBox.setChecked(true);
                }else{
                    NonLegalCheckBox.setChecked(false);
                }
                if (PACOVERTOEMPLOYEESOFINSUREDStatus.equals("True")){
                    PolicyPACoverYesRadio.setChecked(true);
                }else{
                    PolicyPACoverYesRadio.setChecked(false);
                }

                if (PACOVERTOPASSENGERSStatus.equals("True")){
                    PASSENGERSCheckBox.setChecked(true);
                }else{
                    PASSENGERSCheckBox.setChecked(false);
                }

                if (PACOVERTOPAIDDRIVERStatus.equals("True")){
                    PaidDriverCheckBox.setChecked(true);
                }else{
                    PaidDriverCheckBox.setChecked(false);
                }
                if (OtherTpStatus.equals("True")){
                    OtherTpCheckBox.setChecked(true);
                }else{
                    OtherTpCheckBox.setChecked(false);
                }
                if (FIBERTANKODStatus.equals("True")){
                    FIBERTANKCheckBox.setChecked(true);
                }else{
                    FIBERTANKCheckBox.setChecked(false);
                }
                if (OtherODStatus.equals("True")){
                    OtherOdCheckBox.setChecked(true);
                }else{
                    OtherOdCheckBox.setChecked(false);
                }
                if (UNNAMEDPACOVERTOPASSENGERSStatus.equals("True")){
                    UnnamedCheckBox.setChecked(true);
                }else{
                    UnnamedCheckBox.setChecked(false);
                }
                if (PACOVERTOOWNERDRIVERStatus.equals("True")){
                    OWNERDRIVERCheckBox.setChecked(true);
                }else{
                    OWNERDRIVERCheckBox.setChecked(false);
                }
                if (CNGLPGKITODStatus.equals("True")){
                    CNGLPGKITODCheckBox.setChecked(true);
                }else{
                    CNGLPGKITODCheckBox.setChecked(false);
                }
                if (CNGLPGKITTPStatus.equals("True")){
                    CNGLPGKITTPCheckBox.setChecked(true);
                }else{
                    CNGLPGKITTPCheckBox.setChecked(false);
                }

                if (BUILTINCNGKIT_LPGKITODStatus.equals("True")){
                    BUILTINCNGKITCheckBox.setChecked(true);
                    BuiltinCngLPGTpCheckBox.setChecked(true);
                }else{
                    BUILTINCNGKITCheckBox.setChecked(false);
                    BuiltinCngLPGTpCheckBox.setChecked(false);
                }
                if (BUILTINCNGKIT_LPGKITTPStatus.equals("True")){
                    BuiltinCngLPGTpCheckBox.setChecked(true);
                    BUILTINCNGKITCheckBox.setChecked(true);
                }else{
                    BuiltinCngLPGTpCheckBox.setChecked(false);
                    BUILTINCNGKITCheckBox.setChecked(false);
                }
                if (MANUFACTURERSELLINGPRICEStatus.equals("True")){
                    ManufacturePriceRemoveButton.setVisibility(View.VISIBLE);
                    ManufacturePriceButton.setVisibility(View.GONE);
                }else{
                    ManufacturePriceRemoveButton.setVisibility(View.GONE);
                    ManufacturePriceButton.setVisibility(View.VISIBLE);
                }


                if (DRIVINGTRAINPROTECTStatus.equals("True")){
                    DrivingTrainProtectAddButton.setVisibility(View.GONE);
                    DrivingTrainProtectRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    DrivingTrainProtectAddButton.setVisibility(View.VISIBLE);
                    DrivingTrainProtectRemoveButton.setVisibility(View.GONE);
                }
                if (LEGALLIABILITYTOPAIDDRIVERStatus.equals("True")){
                    LEGALCheckBox.setChecked(true);
                }else{
                    LEGALCheckBox.setChecked(false);
                }

                if (RoadsideAssistanceStatus.equals("True")){
                    RoadsideAssistanceAddButton.setVisibility(View.GONE);
                    RoadsideAssistanceRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    RoadsideAssistanceAddButton.setVisibility(View.VISIBLE);
                    RoadsideAssistanceRemoveButton.setVisibility(View.GONE);
                }
                if (NilDepreciationWaivercoverStatus.equals("True")){
                    NilAddButton.setVisibility(View.GONE);
                    NilRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    NilAddButton.setVisibility(View.VISIBLE);
                    NilRemoveButton.setVisibility(View.GONE);
                }
                if (DAILYCASHALLOWANCENONMETROStatus.equals("True")){
                    DailyCashNonADDButton.setVisibility(View.GONE);
                    DailyCashNonRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    DailyCashNonADDButton.setVisibility(View.VISIBLE);
                    DailyCashNonRemoveButton.setVisibility(View.GONE);
                }
                if (DAILYCASHALLOWANCEMETROStatus.equals("True")){
                    DailyCashAddButton.setVisibility(View.GONE);
                    DailyCashRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    DailyCashAddButton.setVisibility(View.VISIBLE);
                    DailyCashRemoveButton.setVisibility(View.GONE);
                }


                if (DAILYCASHALLOWANCEStatus.equals("True")){
                    DailyCashAllowanceAddButton.setVisibility(View.GONE);
                    DailyCashAllowanceRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    DailyCashAllowanceAddButton.setVisibility(View.VISIBLE);
                    DailyCashAllowanceRemoveButton.setVisibility(View.GONE);
                }

                if (KEYREPLACEMENTStatus.equals("True")){
                    KeyReplacementAddButton.setVisibility(View.GONE);
                    KeyReplacementRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    KeyReplacementAddButton.setVisibility(View.VISIBLE);
                    KeyReplacementRemoveButton.setVisibility(View.GONE);
                }
                if (RETURNTOINVOICEStatus.equals("True")){
                    RetrunToVoiceAddButton.setVisibility(View.GONE);
                    RetrunToVoiceRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    RetrunToVoiceAddButton.setVisibility(View.VISIBLE);
                    RetrunToVoiceRemoveButton.setVisibility(View.GONE);
                }
                if (ACCIDENTALHOSPITALIZATIONStatus.equals("True")){
                    AccidentalHospitalAddButton.setVisibility(View.GONE);
                    AccidentalHospitalRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    AccidentalHospitalAddButton.setVisibility(View.VISIBLE);
                    AccidentalHospitalRemoveButton.setVisibility(View.GONE);
                }
                if (HYDROSTATICLOCKCOVERStatus.equals("True")){
                    HydrostaticAddButton.setVisibility(View.GONE);
                    HydrostaticRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    HydrostaticAddButton.setVisibility(View.VISIBLE);
                    HydrostaticRemoveButton.setVisibility(View.GONE);
                }
                if (COSTOFCONSUMABLESStatus.equals("True")){
                    CostOfConsumableAddButton.setVisibility(View.GONE);
                    CostOfConsumableRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    CostOfConsumableAddButton.setVisibility(View.VISIBLE);
                    CostOfConsumableRemoveButton.setVisibility(View.GONE);
                }
                if (WRONGFUELCOVERStatus.equals("True")){
                    wrongFuelAddButton.setVisibility(View.GONE);
                    WrongFuelRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    wrongFuelAddButton.setVisibility(View.VISIBLE);
                    WrongFuelRemoveButton.setVisibility(View.GONE);
                }


                if (SECURETOWINGStatus.equals("True")){
                    SecureTowingAddButton.setVisibility(View.GONE);
                    SecureTowingRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    SecureTowingAddButton.setVisibility(View.VISIBLE);
                    SecureTowingRemoveButton.setVisibility(View.GONE);
                }
                if (TyreandRimsecureStatus.equals("True")){
                    TyreAddButton.setVisibility(View.GONE);
                    TyreRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    TyreAddButton.setVisibility(View.VISIBLE);
                    TyreRemoveButton.setVisibility(View.GONE);
                }
                if (ENGINEPROTECTORPETROLStatus.equals("True")){
                    ENGINEPetrolAddButton.setVisibility(View.GONE);
                    ENGINEPetrolRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    ENGINEPetrolAddButton.setVisibility(View.VISIBLE);
                    ENGINEPetrolRemoveButton.setVisibility(View.GONE);
                }

                if (ENGINEPROTECTORDIESELStatus.equals("True")){
                    EngineAddButton.setVisibility(View.GONE);
                    EngineRemoveButton.setVisibility(View.VISIBLE);
                }else{
                    EngineAddButton.setVisibility(View.VISIBLE);
                    EngineRemoveButton.setVisibility(View.GONE);
                }

                if(strCoverageType.equals("Individual")){
                    PolicyIndividualRadio.setChecked(true);
                    PolicyCorporateRadio.setChecked(false);

                }else{
                    PolicyIndividualRadio.setChecked(false);
                    PolicyCorporateRadio.setChecked(true);
                }
                if (AutomobileAssociationdiscountStatus.equals("True")){
                    AutomobileCheckBox.setChecked(true);
                    LinerAutoMobile.setVisibility(View.VISIBLE);

                    if (AutoMobileRadio != null){
                        if (AutoMobileRadio.equals("Membership")){
                            MemberEditTxt.setVisibility(View.VISIBLE);
                            if (!strMemberEditTxt.isEmpty()) {
                                MemberEditTxt.setText(strMemberEditTxt);
                            }
                            MembershipRadio.setChecked(true);
                        }else{
                            MembershipRadio.setChecked(false);
                            MemberEditTxt.setVisibility(View.VISIBLE);
                        }
                        if (AutoMobileValidityRadio.equals("Validity")){
                            ValidityTxt.setVisibility(View.GONE);

                            if (!strValidityTxt.isEmpty()) {
                                ValidityTxt.setText(strValidityTxt);
                            }
                            ValidityRadio.setChecked(true);
                        }else{
                            ValidityRadio.setChecked(false);
                            ValidityTxt.setVisibility(View.GONE);
                        }
                    }
                }
                else {
                    ValidityRadio.setChecked(false);
                    MembershipRadio.setChecked(false);
                    AutomobileCheckBox.setChecked(false);
                    LinerAutoMobile.setVisibility(View.GONE);
                }
                if (VoluntarydeductableStatus.equals("True")){
                    VotaryCheckBox.setChecked(true);
                    if (strVehicleTypeRadio.equals("Four Wheeler")) {
                        LinerPrivate.setVisibility(View.VISIBLE);
                        LinerTwo.setVisibility(View.GONE);
                        if (VoluntarydeductableDiscountAmount.equals("2500")){
                            VotaryPrivateTwoFiveButton.setChecked(true);
                            VotaryPrivateFiveButton.setChecked(false);
                            VotaryPrivateSevenFiveButton.setChecked(false);
                            VotaryPrivateOneFiveButton.setChecked(false);
                        }else if  (VoluntarydeductableDiscountAmount.equals("5000")){
                            VotaryPrivateTwoFiveButton.setChecked(false);
                            VotaryPrivateFiveButton.setChecked(true);
                            VotaryPrivateSevenFiveButton.setChecked(false);
                            VotaryPrivateOneFiveButton.setChecked(false);
                        }else if  (VoluntarydeductableDiscountAmount.equals("7500")){
                            VotaryPrivateTwoFiveButton.setChecked(false);
                            VotaryPrivateFiveButton.setChecked(false);
                            VotaryPrivateSevenFiveButton.setChecked(true);
                            VotaryPrivateOneFiveButton.setChecked(false);
                        }else if  (VoluntarydeductableDiscountAmount.equals("15000")){
                            VotaryPrivateTwoFiveButton.setChecked(false);
                            VotaryPrivateFiveButton.setChecked(false);
                            VotaryPrivateSevenFiveButton.setChecked(false);
                            VotaryPrivateOneFiveButton.setChecked(true);
                        }
                    } else {
                        LinerPrivate.setVisibility(View.GONE);
                        LinerTwo.setVisibility(View.VISIBLE);
                        if (VoluntarydeductableDiscountAmount.equals("500")){
                            VotaryTwoWheelerFiveButton.setChecked(true);
                            VotaryTwoWheelerSevenFiveButton.setChecked(false);
                            VotaryTwoWheelerOneButton.setChecked(false);
                            VotaryTwoWheelerOneFiveButton.setChecked(false);
                            VotaryTwoWheelerThreeButton.setChecked(false);
                            VotaryTwoWheelerOneButton.setChecked(false);
                            VotaryPrivateTwoFiveButton.setChecked(false);
                            VotaryPrivateFiveButton.setChecked(false);
                            VotaryPrivateSevenFiveButton.setChecked(false);
                            VotaryPrivateOneFiveButton.setChecked(false);
                        }else if (VoluntarydeductableDiscountAmount.equals("750")){
                            VotaryTwoWheelerSevenFiveButton.setChecked(true);
                            VotaryTwoWheelerOneFiveButton.setChecked(false);
                            VotaryTwoWheelerThreeButton.setChecked(false);
                            VotaryTwoWheelerFiveButton.setChecked(false);
                            VotaryTwoWheelerOneButton.setChecked(false);
                            VotaryPrivateTwoFiveButton.setChecked(false);
                            VotaryPrivateFiveButton.setChecked(false);
                            VotaryPrivateSevenFiveButton.setChecked(false);
                            VotaryPrivateOneFiveButton.setChecked(false);
                        }else if (VoluntarydeductableDiscountAmount.equals("1000")){
                            VotaryTwoWheelerOneButton.setChecked(true);
                            VotaryTwoWheelerSevenFiveButton.setChecked(false);
                            VotaryTwoWheelerOneFiveButton.setChecked(false);
                            VotaryTwoWheelerThreeButton.setChecked(false);
                            VotaryTwoWheelerFiveButton.setChecked(false);
                            VotaryPrivateTwoFiveButton.setChecked(false);
                            VotaryPrivateFiveButton.setChecked(false);
                            VotaryPrivateSevenFiveButton.setChecked(false);
                            VotaryPrivateOneFiveButton.setChecked(false);
                        }else if (VoluntarydeductableDiscountAmount.equals("1500")){
                            VotaryTwoWheelerOneFiveButton.setChecked(true);
                            VotaryTwoWheelerSevenFiveButton.setChecked(false);
                            VotaryTwoWheelerThreeButton.setChecked(false);
                            VotaryTwoWheelerFiveButton.setChecked(false);
                            VotaryTwoWheelerOneButton.setChecked(false);
                            VotaryPrivateTwoFiveButton.setChecked(false);
                            VotaryPrivateFiveButton.setChecked(false);
                            VotaryPrivateSevenFiveButton.setChecked(false);
                            VotaryPrivateOneFiveButton.setChecked(false);
                        }else if (VoluntarydeductableDiscountAmount.equals("3000")){
                            VotaryTwoWheelerThreeButton.setChecked(true);
                            VotaryTwoWheelerOneFiveButton.setChecked(false);
                            VotaryTwoWheelerSevenFiveButton.setChecked(false);
                            VotaryTwoWheelerFiveButton.setChecked(false);
                            VotaryTwoWheelerOneButton.setChecked(false);
                            VotaryPrivateTwoFiveButton.setChecked(false);
                            VotaryPrivateFiveButton.setChecked(false);
                            VotaryPrivateSevenFiveButton.setChecked(false);
                            VotaryPrivateOneFiveButton.setChecked(false);

                        }



                    }
                }
                else{
                    VotaryCheckBox.setChecked(false);
                    LinerPrivate.setVisibility(View.GONE);
                    LinerTwo.setVisibility(View.GONE);
                    VotaryPrivateTwoFiveButton.setChecked(false);
                    VotaryPrivateFiveButton.setChecked(false);
                    VotaryPrivateSevenFiveButton.setChecked(false);
                    VotaryPrivateOneFiveButton.setChecked(false);
                    VotaryTwoWheelerFiveButton.setChecked(false);
                    VotaryTwoWheelerSevenFiveButton.setChecked(false);
                    VotaryTwoWheelerOneButton.setChecked(false);
                    VotaryTwoWheelerOneFiveButton.setChecked(false);
                    VotaryTwoWheelerThreeButton.setChecked(false);
                    VotaryTwoWheelerOneButton.setChecked(false);
                    VotaryPrivateTwoFiveButton.setChecked(false);
                    VotaryPrivateFiveButton.setChecked(false);
                    VotaryPrivateSevenFiveButton.setChecked(false);
                    VotaryPrivateOneFiveButton.setChecked(false);
                }
            }
            else{
                DetariffDiscountStatus="True";
                DetariffLoadingStatus="True";
                addOnsShow();
                VehicleMotorQuotation();
                ElectricalCheckBox.setChecked(false);
                FIBERTANKCheckBox.setChecked(false);
                LEGALCheckBox.setChecked(false);
                NonLegalCheckBox.setChecked(false);
                OtherOdCheckBox.setChecked(false);
                OtherTpCheckBox.setChecked(false);
                EmployeesInsuredCheckBox.setChecked(false);
                OWNERDRIVERCheckBox.setChecked(false);
                PaidDriverCheckBox.setChecked(false);
                PASSENGERSCheckBox.setChecked(false);
                UnnamedCheckBox.setChecked(false);
                CNGLPGKITODCheckBox.setChecked(false);
                CNGLPGKITTPCheckBox.setChecked(false);
                if (BUILTINCNGKIT_LPGKITODStatus.equals("True")){
                    BUILTINCNGKITCheckBox.setChecked(true);
                    BuiltinCngLPGTpCheckBox.setChecked(true);
                }else{
                    BUILTINCNGKITCheckBox.setChecked(false);
                    BuiltinCngLPGTpCheckBox.setChecked(false);
                }
                if (BUILTINCNGKIT_LPGKITTPStatus.equals("True")){
                    BuiltinCngLPGTpCheckBox.setChecked(true);
                    BUILTINCNGKITCheckBox.setChecked(true);
                }else{
                    BuiltinCngLPGTpCheckBox.setChecked(false);
                    BUILTINCNGKITCheckBox.setChecked(false);
                }
                AccidentalHospitalAddButton.setVisibility(View.VISIBLE);
                CostOfConsumableAddButton.setVisibility(View.VISIBLE);
                DailyCashAddButton.setVisibility(View.VISIBLE);
                DrivingTrainProtectAddButton.setVisibility(View.VISIBLE);
                DailyCashNonADDButton.setVisibility(View.VISIBLE);
                EngineAddButton.setVisibility(View.VISIBLE);
                ENGINEPetrolAddButton.setVisibility(View.VISIBLE);
                HydrostaticAddButton.setVisibility(View.VISIBLE);
                KeyReplacementAddButton.setVisibility(View.VISIBLE);
                NilAddButton.setVisibility(View.VISIBLE);
                RetrunToVoiceAddButton.setVisibility(View.VISIBLE);
                RoadsideAssistanceAddButton.setVisibility(View.VISIBLE);
                SecureTowingAddButton.setVisibility(View.VISIBLE);
                TyreAddButton.setVisibility(View.VISIBLE);
                ManufacturePriceButton.setVisibility(View.VISIBLE);
                IDVTotalPremium.setText(strIdvValueTxtSelect);

            }
            if (changeseekBar.equals("1")){
                if (progressChanged==b){
                    seekBarDistance.setProgress(0);
                }else if (progressChanged==c){
                    seekBarDistance.setProgress(100);
                }else if (progressChanged==a){
                    seekBarDistance.setProgress(50);
                }else if (progressChanged>a){
                    seekBarDistance.setProgress(75);
                }else if (progressChanged<a){
                    seekBarDistance.setProgress(25);
                }else{
                    seekBarDistance.setProgress(50);
                }
            }else{
                seekBarDistance.setProgress(50);
            }

            IDVTotalPremium.setText(strIdvValueTxtSelect);
            if (OneYearComprehensiveRadio.isChecked()){
                OneYearComprehensiveTxt.setText(TotalValue);
                TotalPremiumComprehensive.setText(TotalValue);
            }else if (ThreeYearComprehensiveRadio.isChecked()){
                thirdComprehensiveTxt.setText(TotalValue);
                TotalPremiumComprehensive.setText(TotalValue);
            }else if (FiveYearComprehensiveRadio.isChecked()){
                FiveComprehensiveTxt.setText(TotalValue);
                TotalPremiumComprehensive.setText(TotalValue);
            }else if (OneYearThirdPartyRadio.isChecked()){
                TPTextView.setText(TotalValue);
                TotalPremiumTp.setText(TotalValue);
            }else if (OneYearStandardAloneRadio.isChecked()){
                StandardPlanPremiumTxt.setText(TotalValue);
                StandardPlanPremium.setText(TotalValue);
            }

            if (strPlanType.equals("Comprehensive")){
                if (strPlanYear.equals("1 Year OD + 3 Year TP  ")){
                    OneYearComprehensiveRadio.setChecked(true);
//                    ThreeYearComprehensiveRadio.setChecked(false);
//                    FiveYearComprehensiveRadio.setChecked(false);
//                    OneYearThirdPartyRadio.setChecked(false);
//                    OneYearStandardAloneRadio.setChecked(false);
                }else if(strPlanYear.equals("1 Year OD + 5 Year TP  ")) {
                    OneYearComprehensiveRadio.setChecked(true);
//                    ThreeYearComprehensiveRadio.setChecked(true);
//                    FiveYearComprehensiveRadio.setChecked(false);
//                    OneYearThirdPartyRadio.setChecked(false);
//                    OneYearStandardAloneRadio.setChecked(false);
                }else if(strPlanYear.equals("5 Year")) {
                    OneYearComprehensiveRadio.setChecked(false);
                    ThreeYearComprehensiveRadio.setChecked(false);
                    FiveYearComprehensiveRadio.setChecked(true);
                    OneYearThirdPartyRadio.setChecked(false);
                    OneYearStandardAloneRadio.setChecked(false);
                }
            }else if (strPlanType.equals("Third Party")){
                if (strPlanYear.equals("1 Year")){
                    OneYearThirdPartyRadio.setChecked(true);
                    OneYearComprehensiveRadio.setChecked(false);
                    ThreeYearComprehensiveRadio.setChecked(false);
                    FiveYearComprehensiveRadio.setChecked(false);
                    OneYearStandardAloneRadio.setChecked(false);
                }

            }else if (strPlanType.equals("Own damage (standalone)")){
                if (strPlanYear.equals("1 Year")){
                    OneYearStandardAloneRadio.setChecked(true);
                    TwoYearStandardAloneRadio.setChecked(false);
                    ThreeYearStandardAloneRadio.setChecked(false);
                    OneYearThirdPartyRadio.setChecked(false);
                    OneYearComprehensiveRadio.setChecked(false);
                    ThreeYearComprehensiveRadio.setChecked(false);
                    FiveYearComprehensiveRadio.setChecked(false);

                }
            }

            if (strCoverageType.equals("Individual")){
                PolicyIndividualRadio.setChecked(true);
                PolicyCorporateRadio.setChecked(false);
                IndividualLiner.setVisibility(View.VISIBLE);
            }else{
                PolicyIndividualRadio.setChecked(false);
                PolicyCorporateRadio.setChecked(true);
                IndividualLiner.setVisibility(View.GONE);
            }
            if (strPACover.equals("Yes")){
                PolicyPACoverYesRadio.setChecked(true);
                PolicyPACoverNoRadio.setChecked(false);
            }else {
                PolicyPACoverYesRadio.setChecked(false);
                PolicyPACoverNoRadio.setChecked(true);
            }

            if (strGPACover.equals("Yes")){
                PolicyGPAYesCoverRadio.setChecked(true);
                PolicyGPAYNoCoverRadio.setChecked(false);
            }else{
                PolicyGPAYesCoverRadio.setChecked(false);
                PolicyGPAYNoCoverRadio.setChecked(true);
            }

            if (strDrivingLicence.equals("Yes")){
                PolicyDrivingLicenceYesRadio.setChecked(true);
                PolicyDrivingLicenceNoRadio.setChecked(false);
                DrivingLiner.setVisibility(View.VISIBLE);
            }else{
                PolicyDrivingLicenceYesRadio.setChecked(false);
                PolicyDrivingLicenceNoRadio.setChecked(true);
                DrivingLiner.setVisibility(View.GONE);
            }
            if(TPPDDiscountStatus.equals("True")){
                TPPDCheckBox.setChecked(true);
            }else{
                TPPDCheckBox.setChecked(false);
            }

            if(HandicapDiscountStatus.equals("True")){
                HandicapCheckBox.setChecked(true);
            }else{
                HandicapCheckBox.setChecked(false);
            }

            if(AntitheftdevicediscountStatus.equals("True")){
                AntitheftCheckBox.setChecked(true);
            }else{
                AntitheftCheckBox.setChecked(false);
            }
            if(strMinMax.equals("Min")){
                MinRadioButton.setChecked(true);
                MaxRadioButton.setChecked(false);
            }else if(strMinMax.equals("Max")){
                MaxRadioButton.setChecked(true);
                MinRadioButton.setChecked(false);
            }else{
                MaxRadioButton.setChecked(false);
                MinRadioButton.setChecked(false);
            }
            if (AutomobileAssociationdiscountStatus.equals("True")){
                AutomobileCheckBox.setChecked(true);
                LinerAutoMobile.setVisibility(View.VISIBLE);
                if (AutoMobileRadio != null){
                    if (AutoMobileRadio.equals("Membership")){
                        MemberEditTxt.setVisibility(View.VISIBLE);
                        MembershipRadio.setChecked(true);
                    }else{
                        MembershipRadio.setChecked(false);
                        MemberEditTxt.setVisibility(View.VISIBLE);
                    }
                    if (AutoMobileValidityRadio.equals("Validity")){
                        ValidityTxt.setVisibility(View.GONE);
                        ValidityRadio.setChecked(true);
                    }else{
                        ValidityRadio.setChecked(false);
                        ValidityTxt.setVisibility(View.GONE);
                    }
                }
            }
            else {
                MembershipRadio.setChecked(false);
                ValidityRadio.setChecked(false);
                AutomobileCheckBox.setChecked(false);
                LinerAutoMobile.setVisibility(View.GONE);
            }
            if (VoluntarydeductableStatus.equals("True")){
                VotaryCheckBox.setChecked(true);
                if (strVehicleTypeRadio.equals("Four Wheeler")) {
                    LinerPrivate.setVisibility(View.VISIBLE);
                    LinerTwo.setVisibility(View.GONE);
                    if (VoluntarydeductableDiscountAmount.equals("2500")){
                        VotaryPrivateTwoFiveButton.setChecked(true);
                        VotaryPrivateFiveButton.setChecked(false);
                        VotaryPrivateSevenFiveButton.setChecked(false);
                        VotaryPrivateOneFiveButton.setChecked(false);
                    }else if  (VoluntarydeductableDiscountAmount.equals("5000")){
                        VotaryPrivateTwoFiveButton.setChecked(false);
                        VotaryPrivateFiveButton.setChecked(true);
                        VotaryPrivateSevenFiveButton.setChecked(false);
                        VotaryPrivateOneFiveButton.setChecked(false);
                    }else if  (VoluntarydeductableDiscountAmount.equals("7500")){
                        VotaryPrivateTwoFiveButton.setChecked(false);
                        VotaryPrivateFiveButton.setChecked(false);
                        VotaryPrivateSevenFiveButton.setChecked(true);
                        VotaryPrivateOneFiveButton.setChecked(false);
                    }else if  (VoluntarydeductableDiscountAmount.equals("15000")){
                        VotaryPrivateTwoFiveButton.setChecked(false);
                        VotaryPrivateFiveButton.setChecked(false);
                        VotaryPrivateSevenFiveButton.setChecked(false);
                        VotaryPrivateOneFiveButton.setChecked(true);
                    }
                } else {
                    LinerPrivate.setVisibility(View.GONE);
                    LinerTwo.setVisibility(View.VISIBLE);
                    if (VoluntarydeductableDiscountAmount.equals("500")){
                        VotaryTwoWheelerFiveButton.setChecked(true);
                        VotaryTwoWheelerSevenFiveButton.setChecked(false);
                        VotaryTwoWheelerOneButton.setChecked(false);
                        VotaryTwoWheelerOneFiveButton.setChecked(false);
                        VotaryTwoWheelerThreeButton.setChecked(false);
                        VotaryTwoWheelerOneButton.setChecked(false);
                        VotaryPrivateTwoFiveButton.setChecked(false);
                        VotaryPrivateFiveButton.setChecked(false);
                        VotaryPrivateSevenFiveButton.setChecked(false);
                        VotaryPrivateOneFiveButton.setChecked(false);
                    }else if (VoluntarydeductableDiscountAmount.equals("750")){
                        VotaryTwoWheelerSevenFiveButton.setChecked(true);
                        VotaryTwoWheelerOneFiveButton.setChecked(false);
                        VotaryTwoWheelerThreeButton.setChecked(false);
                        VotaryTwoWheelerFiveButton.setChecked(false);
                        VotaryTwoWheelerOneButton.setChecked(false);
                        VotaryPrivateTwoFiveButton.setChecked(false);
                        VotaryPrivateFiveButton.setChecked(false);
                        VotaryPrivateSevenFiveButton.setChecked(false);
                        VotaryPrivateOneFiveButton.setChecked(false);
                    }else if (VoluntarydeductableDiscountAmount.equals("1000")){
                        VotaryTwoWheelerOneButton.setChecked(true);
                        VotaryTwoWheelerSevenFiveButton.setChecked(false);
                        VotaryTwoWheelerOneFiveButton.setChecked(false);
                        VotaryTwoWheelerThreeButton.setChecked(false);
                        VotaryTwoWheelerFiveButton.setChecked(false);
                        VotaryPrivateTwoFiveButton.setChecked(false);
                        VotaryPrivateFiveButton.setChecked(false);
                        VotaryPrivateSevenFiveButton.setChecked(false);
                        VotaryPrivateOneFiveButton.setChecked(false);
                    }else if (VoluntarydeductableDiscountAmount.equals("1500")){
                        VotaryTwoWheelerOneFiveButton.setChecked(true);
                        VotaryTwoWheelerSevenFiveButton.setChecked(false);
                        VotaryTwoWheelerThreeButton.setChecked(false);
                        VotaryTwoWheelerFiveButton.setChecked(false);
                        VotaryTwoWheelerOneButton.setChecked(false);
                        VotaryPrivateTwoFiveButton.setChecked(false);
                        VotaryPrivateFiveButton.setChecked(false);
                        VotaryPrivateSevenFiveButton.setChecked(false);
                        VotaryPrivateOneFiveButton.setChecked(false);
                    }else if (VoluntarydeductableDiscountAmount.equals("3000")){
                        VotaryTwoWheelerThreeButton.setChecked(true);
                        VotaryTwoWheelerOneFiveButton.setChecked(false);
                        VotaryTwoWheelerSevenFiveButton.setChecked(false);
                        VotaryTwoWheelerFiveButton.setChecked(false);
                        VotaryTwoWheelerOneButton.setChecked(false);
                        VotaryPrivateTwoFiveButton.setChecked(false);
                        VotaryPrivateFiveButton.setChecked(false);
                        VotaryPrivateSevenFiveButton.setChecked(false);
                        VotaryPrivateOneFiveButton.setChecked(false);

                    }



                }
            }
            else{
                VotaryCheckBox.setChecked(false);
                LinerPrivate.setVisibility(View.GONE);
                LinerTwo.setVisibility(View.GONE);
                VotaryPrivateTwoFiveButton.setChecked(false);
                VotaryPrivateFiveButton.setChecked(false);
                VotaryPrivateSevenFiveButton.setChecked(false);
                VotaryPrivateOneFiveButton.setChecked(false);
                VotaryTwoWheelerFiveButton.setChecked(false);
                VotaryTwoWheelerSevenFiveButton.setChecked(false);
                VotaryTwoWheelerOneButton.setChecked(false);
                VotaryTwoWheelerOneFiveButton.setChecked(false);
                VotaryTwoWheelerThreeButton.setChecked(false);
                VotaryTwoWheelerOneButton.setChecked(false);
                VotaryPrivateTwoFiveButton.setChecked(false);
                VotaryPrivateFiveButton.setChecked(false);
                VotaryPrivateSevenFiveButton.setChecked(false);
                VotaryPrivateOneFiveButton.setChecked(false);
            }
        }

        OneYearComprehensiveRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (OneYearComprehensiveRadio.isChecked()){
                    OneYearComprehensiveRadio.setChecked(true);
                    ThreeYearComprehensiveRadio.setChecked(false);
                    FiveYearComprehensiveRadio.setChecked(false);
                    OneYearThirdPartyRadio.setChecked(false);
                    OneYearStandardAloneRadio.setChecked(false);
                    strPlanType="Comprehensive";
                    // if (strVehicleTypeRadio.equals("Four Wheeler")){
                    //                        ProductName="PRIVATE CAR PACKAGE POLICY";
//                        ProductCode="2311";
//                        VehicleMotorQuotation();
//                    }else{
//                        ProductName="TWO WHEELER PACKAGE POLICY";
//                        ProductCode="2312";
//                        VehicleMotorQuotation();
//                    }
                    if (strVehicleTypeRadio.equals("Four Wheeler")){
                        strPlanYear="1 Year OD + 3 Year TP ";
                        OneYearComprehensiveRadio.setText("1 Year OD + 3 Year TP  ");
                        Calendar calendar = Calendar.getInstance();
                        date = calendar.getTime();
                        formatter = new SimpleDateFormat("dd/MM/yyyy");
                        today = formatter.format(date);
                        String[] strTDate = today.split("/");
                        String strFirstDString = strTDate[0];
                        String strSecondDString = strTDate[1];
                        strThirdDString = strTDate[2];
                        Log.e("strThirdDString", strThirdDString);
                        Log.e("Today", today);

                        calendar.add(Calendar.DATE, 1);
                        date = calendar.getTime();
                        formatter = new SimpleDateFormat("dd/MM/yyyy");

                        calendar.add(Calendar.DATE, 364*3);
                        date1 = calendar.getTime();
                        formatter = new SimpleDateFormat("dd/MM/yyyy");
                        nextYear = formatter.format(date1);
                        Log.e("nextYear", nextYear);
                        ProductName="MOTOR - MOTOR PRIVATE CAR - BUNDLED";
                        ProductCode="2367";
                        CheckString="1";
                        VehicleMotorQuotation();
                        addOnsShow();
                    }
                    else{
                        strPlanYear="1 Year OD + 5 Year TP ";
                        OneYearComprehensiveRadio.setText("1 Year OD + 5 Year TP  ");
                        Calendar calendar = Calendar.getInstance();
                        date = calendar.getTime();
                        formatter = new SimpleDateFormat("dd/MM/yyyy");
                        today = formatter.format(date);
                        String[] strTDate = today.split("/");
                        String strFirstDString = strTDate[0];
                        String strSecondDString = strTDate[1];
                        strThirdDString = strTDate[2];
                        Log.e("strThirdDString", strThirdDString);
                        Log.e("Today", today);

                        calendar.add(Calendar.DATE, 1);
                        date = calendar.getTime();
                        formatter = new SimpleDateFormat("dd/MM/yyyy");

                        calendar.add(Calendar.DATE, 364*5);
                        date1 = calendar.getTime();
                        formatter = new SimpleDateFormat("dd/MM/yyyy");
                        nextYear = formatter.format(date1);
                        Log.e("nextYear", nextYear);
                        ProductName="MOTOR - MOTOR TWO WHEELER  - BUNDLED";
                        ProductCode="2369";
                        CheckString="1";
                        VehicleMotorQuotation();
                        addOnsShow();
                    }

                }
            }
        });
        ThreeYearComprehensiveRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ThreeYearComprehensiveRadio.isChecked()){
                    OneYearComprehensiveRadio.setChecked(false);
                    ThreeYearComprehensiveRadio.setChecked(true);
                    FiveYearComprehensiveRadio.setChecked(false);
                    OneYearThirdPartyRadio.setChecked(false);
                    OneYearStandardAloneRadio.setChecked(false);
                    strPlanType="Comprehensive";
                    strPlanYear="3 Year";
                    ProductName="MOTOR - MOTOR PRIVATE CAR - BUNDLED";
                    ProductCode="2367";

                    Calendar calendar = Calendar.getInstance();
                    date = calendar.getTime();
                    formatter = new SimpleDateFormat("dd/MM/yyyy");
                    today = formatter.format(date);
                    String[] strTDate = today.split("/");
                    String strFirstDString = strTDate[0];
                    String strSecondDString = strTDate[1];
                    strThirdDString = strTDate[2];
                    Log.e("strThirdDString", strThirdDString);
                    Log.e("Today", today);

                    calendar.add(Calendar.DATE, 1);
                    date = calendar.getTime();
                    formatter = new SimpleDateFormat("dd/MM/yyyy");

                    calendar.add(Calendar.DATE, 364 * 3);
                    date3 = calendar.getTime();
                    formatter = new SimpleDateFormat("dd/MM/yyyy");
                    nextYear = formatter.format(date3);
                    Log.e("next3Year", nextYear);
                    VehicleMotorQuotation();

                }
            }
        });
        FiveYearComprehensiveRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (FiveYearComprehensiveRadio.isChecked()){
                    OneYearComprehensiveRadio.setChecked(false);
                    ThreeYearComprehensiveRadio.setChecked(false);
                    FiveYearComprehensiveRadio.setChecked(true);
                    OneYearThirdPartyRadio.setChecked(false);
                    OneYearStandardAloneRadio.setChecked(false);
                    strPlanType="Comprehensive";
                    strPlanYear="5 Year";

                    ProductName="MOTOR - MOTOR TWO WHEELER  - BUNDLED";
                    ProductCode="2369";

                    Calendar calendar = Calendar.getInstance();
                    date = calendar.getTime();
                    formatter = new SimpleDateFormat("dd/MM/yyyy");
                    today = formatter.format(date);
                    String[] strTDate = today.split("/");
                    String strFirstDString = strTDate[0];
                    String strSecondDString = strTDate[1];
                    strThirdDString = strTDate[2];
                    Log.e("strThirdDString", strThirdDString);
                    Log.e("Today", today);

                    calendar.add(Calendar.DATE, 1);
                    date = calendar.getTime();
                    formatter = new SimpleDateFormat("dd/MM/yyyy");

                    calendar.add(Calendar.DATE, 364*5);
                    date3 = calendar.getTime();
                    formatter = new SimpleDateFormat("dd/MM/yyyy");
                    nextYear = formatter.format(date3);
                    Log.e("next5Year", nextYear);
                    VehicleMotorQuotation();

                }
            }
        });

        OneYearThirdPartyRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (OneYearThirdPartyRadio.isChecked()){
                    OneYearComprehensiveRadio.setChecked(false);
                    ThreeYearComprehensiveRadio.setChecked(false);
                    FiveYearComprehensiveRadio.setChecked(false);
                    OneYearThirdPartyRadio.setChecked(true);
                    OneYearStandardAloneRadio.setChecked(false);
                    strPlanType="Third Party";
                    strPlanYear="1 Year";
                    Calendar calendar = Calendar.getInstance();
                    date = calendar.getTime();
                    formatter = new SimpleDateFormat("dd/MM/yyyy");
                    today = formatter.format(date);
                    String[] strTDate = today.split("/");
                    String strFirstDString = strTDate[0];
                    String strSecondDString = strTDate[1];
                    strThirdDString = strTDate[2];
                    Log.e("strThirdDString", strThirdDString);
                    Log.e("Today", today);

                    calendar.add(Calendar.DATE, 1);
                    date = calendar.getTime();
                    formatter = new SimpleDateFormat("dd/MM/yyyy");

                    calendar.add(Calendar.DATE, 364);
                    date1 = calendar.getTime();
                    formatter = new SimpleDateFormat("dd/MM/yyyy");
                    nextYear = formatter.format(date1);
                    Log.e("nextYear", nextYear);

                    if (strVehicleTypeRadio.equals("Four Wheeler")){
                        ProductName="PRIVATE CAR PACKAGE POLICY";
                        ProductCode="2319";
                        VehicleMotorQuotation();
                    }else{
                        ProductName="TWO WHEELER PACKAGE POLICY";
                        ProductCode="2320";
                        VehicleMotorQuotation();
                    }
                    addOnsShow();
                }
            }
        });
        TwoYearThirdPartyRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (TwoYearThirdPartyRadio.isChecked()){
                    TwoYearThirdPartyRadio.setChecked(true);
                    OneYearThirdPartyRadio.setChecked(false);
                    ThreeYearThirdPartyRadio.setChecked(false);
                    strPlanType="Third Party";
                    strPlanYear="2 Year";
                }
            }
        });
        ThreeYearThirdPartyRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ThreeYearThirdPartyRadio.isChecked()){
                    ThreeYearThirdPartyRadio.setChecked(true);
                    TwoYearThirdPartyRadio.setChecked(false);
                    OneYearThirdPartyRadio.setChecked(false);
                    strPlanType="Third Party";
                    strPlanYear="3 Year";
                }
            }
        });

        OneYearStandardAloneRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (OneYearStandardAloneRadio.isChecked()){
                    OneYearComprehensiveRadio.setChecked(false);
                    ThreeYearComprehensiveRadio.setChecked(false);
                    FiveYearComprehensiveRadio.setChecked(false);
                    OneYearThirdPartyRadio.setChecked(false);
                    OneYearStandardAloneRadio.setChecked(true);
                    strPlanType="Own damage (standalone)";
                    strPlanYear="1 Year";
                    Calendar calendar = Calendar.getInstance();
                    date = calendar.getTime();
                    formatter = new SimpleDateFormat("dd/MM/yyyy");
                    today = formatter.format(date);
                    String[] strTDate = today.split("/");
                    String strFirstDString = strTDate[0];
                    String strSecondDString = strTDate[1];
                    strThirdDString = strTDate[2];
                    Log.e("strThirdDString", strThirdDString);
                    Log.e("Today", today);

                    calendar.add(Calendar.DATE, 1);
                    date = calendar.getTime();
                    formatter = new SimpleDateFormat("dd/MM/yyyy");

                    calendar.add(Calendar.DATE, 364);
                    date1 = calendar.getTime();
                    formatter = new SimpleDateFormat("dd/MM/yyyy");
                    nextYear = formatter.format(date1);
                    Log.e("nextYear", nextYear);

                    if (strVehicleTypeRadio.equals("Four Wheeler")){
                        ProductName="PRIVATE CAR - OD";
                        ProductCode="2398";
                        VehicleMotorQuotation();
                    }else{
                        ProductName="TWO WHEELER - OD";
                        ProductCode="2397";
                        VehicleMotorQuotation();
                    }
                    addOnsShow();
                }
            }
        });
        TwoYearStandardAloneRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (TwoYearStandardAloneRadio.isChecked()){
                    TwoYearStandardAloneRadio.setChecked(true);
                    OneYearStandardAloneRadio.setChecked(false);
                    ThreeYearStandardAloneRadio.setChecked(false);
                    strPlanType="Own damage (standalone)";
                    strPlanYear="2 Year";
                }
            }
        });
        ThreeYearStandardAloneRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ThreeYearStandardAloneRadio.isChecked()){
                    ThreeYearStandardAloneRadio.setChecked(true);
                    OneYearStandardAloneRadio.setChecked(false);
                    TwoYearStandardAloneRadio.setChecked(false);
                    strPlanType="Own damage (standalone)";
                    strPlanYear="3 Year";
                }
            }
        });

        PolicyIndividualRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PolicyIndividualRadio.isChecked()){
                    PolicyIndividualRadio.setChecked(true);
                    PolicyCorporateRadio.setChecked(false);
                    strCoverageType="Individual";
                    IndividualLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        PolicyCorporateRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PolicyCorporateRadio.isChecked()){
                    PolicyCorporateRadio.setChecked(true);
                    PolicyIndividualRadio.setChecked(false);
                    strCoverageType="Corporate";
                    PACOVERTOOWNERDRIVERStatus="False";
                    CheckString="1";
                    ChangeAddons="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                    IndividualLiner.setVisibility(View.GONE);
                }
            }
        });
        PolicyPACoverYesRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PolicyPACoverYesRadio.isChecked()){
                    PolicyPACoverYesRadio.setChecked(true);
                    PolicyPACoverNoRadio.setChecked(false);
                    strPACover="Yes";
                    PACOVERTOOWNERDRIVERStatus="False";
                    CheckString="1";
                    ChangeAddons="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        PolicyPACoverNoRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PolicyPACoverNoRadio.isChecked()){
                    if (strGPACover.equals("Yes")){
                        PolicyPACoverNoRadio.setChecked(true);
                        PolicyPACoverYesRadio.setChecked(false);
                        strPACover="No";
                        PACOVERTOOWNERDRIVERStatus="False";
                        CheckString="1";
                        ChangeAddons="1";
                        VehicleMotorQuotation();
//                        addOnsShow();
                    }else{
                        PolicyPACoverNoRadio.setChecked(true);
                        PolicyPACoverYesRadio.setChecked(false);
                        strPACover="No";
                        PACOVERTOOWNERDRIVERStatus="True";
                        CheckString="1";
                        ChangeAddons="1";
                        VehicleMotorQuotation();
//                        addOnsShow();
                    }
                }
            }
        });
        PolicyGPAYesCoverRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PolicyGPAYesCoverRadio.isChecked()){
                    PolicyGPAYesCoverRadio.setChecked(true);
                    PolicyGPAYNoCoverRadio.setChecked(false);
                    strGPACover="Yes";
                    PACOVERTOOWNERDRIVERStatus="False";
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        PolicyGPAYNoCoverRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PolicyGPAYNoCoverRadio.isChecked()){
                    if (strPACover.equals("Yes")){
                        PolicyGPAYNoCoverRadio.setChecked(true);
                        PolicyGPAYesCoverRadio.setChecked(false);
                        strGPACover="No";
                        PACOVERTOOWNERDRIVERStatus="False";
                        CheckString="1";
                        VehicleMotorQuotation();
//                        addOnsShow();
                    }else {
                        PolicyGPAYNoCoverRadio.setChecked(true);
                        PolicyGPAYesCoverRadio.setChecked(false);
                        strGPACover="No";
                        PACOVERTOOWNERDRIVERStatus="True";
                        CheckString="1";
                        VehicleMotorQuotation();
//                        addOnsShow();
                    }
                }
            }
        });
        PolicyDrivingLicenceYesRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PolicyDrivingLicenceYesRadio.isChecked()){
                    PolicyDrivingLicenceYesRadio.setChecked(true);
                    PolicyDrivingLicenceNoRadio.setChecked(false);
                    strDrivingLicence="Yes";
                    DrivingLiner.setVisibility(View.VISIBLE);
                    PACOVERTOOWNERDRIVERStatus="True";
                    CheckString="1";
                    ChangeAddons="1";
                    VehicleMotorQuotation();
//                    addOnsShow();

                }
            }
        });
        PolicyDrivingLicenceNoRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PolicyDrivingLicenceNoRadio.isChecked()){
                    PolicyDrivingLicenceNoRadio.setChecked(true);
                    PolicyDrivingLicenceYesRadio.setChecked(false);
                    strDrivingLicence="No";
                    DrivingLiner.setVisibility(View.GONE);
                    PACOVERTOOWNERDRIVERStatus="False";
                    CheckString="1";
                    ChangeAddons="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(100); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        clcikMy.startAnimation(anim);

        MaxRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (MaxRadioButton.isChecked()){
                    changeseekBar="1";
                    CheckString="1";
                    ChangeAddons="1";
                    strMinMax="Max";
                    strIdvValueTxtSelect=strHighIDVText;
                    IDVTotalPremium.setText(strIdvValueTxtSelect);
                    MaxRadioButton.setChecked(true);
                    MinRadioButton.setChecked(false);
                    VehicleMotorQuotation();
//                    addOnsShow();
                }

            }
        });
        MinRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (MinRadioButton.isChecked()){
                    changeseekBar="1";
                    CheckString="1";
                    ChangeAddons="1";
                    strMinMax="Min";
                    strIdvValueTxtSelect=strLessIDVText;
                    IDVTotalPremium.setText(strIdvValueTxtSelect);
                    MaxRadioButton.setChecked(false);
                    MinRadioButton.setChecked(true);
                    VehicleMotorQuotation();
//                    addOnsShow();
                }

            }
        });

        SubmitIDvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strIdvValueEdit = IDVEdit.getText().toString();
                if (!strIdvValueEdit.equals("")){
                    if(!(strIdvValueEdit.equals("0.0")||strIdvValueEdit.equals("0.00"))){
                        if (Double.parseDouble(strIdvValueEdit)>Double.parseDouble(strLessIDVText) && (Double.parseDouble(strIdvValueEdit)<Double.parseDouble(strHighIDVText))) {
                            strIdvValueTxtSelect=strIdvValueEdit;
                            IDVTotalPremium.setText(strIdvValueTxtSelect);
                            CheckString="1";
                            ChangeAddons="1";
                            VehicleMotorQuotation();
//                            addOnsShow();
                        }else{
                            Toast.makeText(Motor_AddOns.this, "IDV must be between min IDV and max IDV", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Motor_AddOns.this, "Can't Take Addons because idv is 0", Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(Motor_AddOns.this, "IDV must be between min IDV and max IDV", Toast.LENGTH_SHORT).show();
                }
            }
        });


        AutomobileCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (AutomobileCheckBox.isChecked()){
                    LinerAutoMobile.setVisibility(View.VISIBLE);
                    AutomobileAssociationdiscountSumInsured="";
                    AutomobileAssociationdiscountStatus="True";
                    CheckString="1";
                    ChangeAddons = "1";
                    VehicleMotorQuotation();
                    addOnsShow();
                }else{
                    CheckString="1";
                    ChangeAddons = "1";
                    strMemberEditTxt="";
                    strValidityTxt="";
                    AutomobileAssociationdiscountStatus="False";
                    AutomobileAssociationdiscountSumInsured="";
                    MemberEditTxt.setText(strMemberEditTxt);
                    ValidityTxt.setText(strValidityTxt);
                    VehicleMotorQuotation();
                    addOnsShow();
                    MemberEditTxt.setVisibility(View.GONE);
                    ValidityTxt.setVisibility(View.GONE);
                    LinerAutoMobile.setVisibility(View.GONE);
                    AutomobileCheckBox.setChecked(false);
                    MembershipRadio.setChecked(false);
                    ValidityRadio.setChecked(false);
                }
            }
        });

        MembershipRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (MembershipRadio.isChecked()){
                    CheckString="1";
                    AutoMobileRadio="Membership";
                    AutomobileCheckBox.setChecked(true);
                    MembershipRadio.setChecked(true);
                    MemberEditTxt.setVisibility(View.VISIBLE);
                    ValidityTxt.setVisibility(View.GONE);
                }
            }
        });
        ValidityRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ValidityRadio.isChecked()){
                    CheckString="1";
                    AutoMobileValidityRadio="Validity";
                    AutomobileCheckBox.setChecked(true);
                    ValidityRadio.setChecked(true);
                    MemberEditTxt.setVisibility(View.VISIBLE);
                    ValidityTxt.setVisibility(View.GONE);
                }
            }
        });
        MemberEditTxt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,int count) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
                // TODO Auto-generated method stub
            }@Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

                // TODO Auto-generated method stub
                Is_Valid_refer(MemberEditTxt); // pass your EditText Obj here.
            }

            public void Is_Valid_refer(EditText edt_refer) {
                if (edt_refer.length()== 2) {
                    strMemberEditTxt = edt_refer.getText().toString();
                    CheckString="1";
                    ChangeAddons = "1";
                    AutomobileAssociationdiscountStatus="True";
                    AutomobileAssociationdiscountSumInsured=strMemberEditTxt;
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
//                else {
//                    CheckString="1";
//                    ChangeAddons="1";
//                    AutomobileAssociationdiscountSumInsured="";
//                    AutomobileAssociationdiscountStatus="False";
//                    VehicleMotorQuotation();
//                    addOnsShow();
//                }
            }
        });
        ValidityTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLabel();
            }
        });


        day = myCalendar.get(Calendar.DAY_OF_MONTH);
        year = myCalendar.get(Calendar.YEAR);
        month = myCalendar.get(Calendar.MONTH);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            datePicker = new DatePickerDialog(Motor_AddOns.this);
        }

        VotaryCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (VotaryCheckBox.isChecked()){
                    if (strVehicleTypeRadio.equals("Four Wheeler")){
                        LinerPrivate.setVisibility(View.VISIBLE);
                        LinerTwo.setVisibility(View.GONE);
                    }else{
                        LinerPrivate.setVisibility(View.GONE);
                        LinerTwo.setVisibility(View.VISIBLE);
                    }
                    VoluntarydeductableStatus="True";
                    VoluntarydeductableDiscountAmount="";
                    VoluntarydeductableSumInsured = VoluntarydeductableDiscountAmount;
//                    VehicleMotorQuotation();
//                    addOnsShow();
                }else{
                    LinerPrivate.setVisibility(View.GONE);
                    LinerTwo.setVisibility(View.GONE);
                    CheckString="1";
                    ChangeAddons="1";
                    VoluntarydeductableSumInsured = VoluntarydeductableDiscountAmount;
                    VoluntarydeductableStatus="False";
                    VotaryPrivateTwoFiveButton.setChecked(false);
                    VotaryPrivateFiveButton.setChecked(false);
                    VotaryPrivateSevenFiveButton.setChecked(false);
                    VotaryPrivateOneFiveButton.setChecked(false);
                    VotaryTwoWheelerFiveButton.setChecked(false);
                    VotaryTwoWheelerSevenFiveButton.setChecked(false);
                    VotaryTwoWheelerOneButton.setChecked(false);
                    VotaryTwoWheelerOneFiveButton.setChecked(false);
                    VotaryTwoWheelerThreeButton.setChecked(false);
                    VotaryTwoWheelerOneButton.setChecked(false);
                    VotaryPrivateTwoFiveButton.setChecked(false);
                    VotaryPrivateFiveButton.setChecked(false);
                    VotaryPrivateSevenFiveButton.setChecked(false);
                    VotaryPrivateOneFiveButton.setChecked(false);
                    VehicleMotorQuotation();
//                    addOnsShow();

                }
            }
        });
        VotaryPrivateTwoFiveButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (VotaryPrivateTwoFiveButton.isChecked()){
                    VotaryPrivateTwoFiveButton.setChecked(true);
                    VotaryPrivateFiveButton.setChecked(false);
                    VotaryPrivateSevenFiveButton.setChecked(false);
                    VotaryPrivateOneFiveButton.setChecked(false);
                    VoluntarydeductableSumInsured="2500";
                    VoluntarydeductableDiscountAmount="2500";
                    VoluntarydeductableStatus="True";
                    CheckString="1";
                    ChangeAddons="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        VotaryPrivateFiveButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (VotaryPrivateFiveButton.isChecked()){
                    VotaryPrivateTwoFiveButton.setChecked(false);
                    VotaryPrivateFiveButton.setChecked(true);
                    VotaryPrivateSevenFiveButton.setChecked(false);
                    VotaryPrivateOneFiveButton.setChecked(false);
                    VoluntarydeductableSumInsured="5000";
                    VoluntarydeductableDiscountAmount="5000";
                    VoluntarydeductableStatus="True";
                    CheckString="1";
                    ChangeAddons="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        VotaryPrivateSevenFiveButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (VotaryPrivateSevenFiveButton.isChecked()){
                    VotaryPrivateTwoFiveButton.setChecked(false);
                    VotaryPrivateFiveButton.setChecked(false);
                    VotaryPrivateSevenFiveButton.setChecked(true);
                    VotaryPrivateOneFiveButton.setChecked(false);
                    VoluntarydeductableSumInsured="7500";
                    VoluntarydeductableDiscountAmount="7500";
                    VoluntarydeductableStatus="True";
                    CheckString="1";
                    ChangeAddons="1";
                    VehicleMotorQuotation();
//                    addOnsShow();

                }
            }
        });
        VotaryPrivateOneFiveButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (VotaryPrivateOneFiveButton.isChecked()){
                    VotaryPrivateTwoFiveButton.setChecked(false);
                    VotaryPrivateFiveButton.setChecked(false);
                    VotaryPrivateSevenFiveButton.setChecked(false);
                    VotaryPrivateOneFiveButton.setChecked(true);
                    VoluntarydeductableSumInsured="15000";
                    VoluntarydeductableDiscountAmount="15000";
                    VoluntarydeductableStatus="True";
                    CheckString="1";
                    ChangeAddons="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        VotaryTwoWheelerFiveButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (VotaryTwoWheelerFiveButton.isChecked()){
                    VotaryTwoWheelerFiveButton.setChecked(true);
                    VotaryTwoWheelerSevenFiveButton.setChecked(false);
                    VotaryTwoWheelerOneButton.setChecked(false);
                    VotaryTwoWheelerOneFiveButton.setChecked(false);
                    VotaryTwoWheelerThreeButton.setChecked(false);
                    VotaryTwoWheelerOneButton.setChecked(false);
                    VotaryPrivateTwoFiveButton.setChecked(false);
                    VotaryPrivateFiveButton.setChecked(false);
                    VotaryPrivateSevenFiveButton.setChecked(false);
                    VotaryPrivateOneFiveButton.setChecked(false);
                    VoluntarydeductableSumInsured="500";
                    VoluntarydeductableDiscountAmount="500";
                    VoluntarydeductableStatus="True";
                    CheckString="1";
                    ChangeAddons="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        VotaryTwoWheelerSevenFiveButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (VotaryTwoWheelerSevenFiveButton.isChecked()){
                    VotaryTwoWheelerSevenFiveButton.setChecked(true);
                    VotaryTwoWheelerOneFiveButton.setChecked(false);
                    VotaryTwoWheelerThreeButton.setChecked(false);
                    VotaryTwoWheelerFiveButton.setChecked(false);
                    VotaryTwoWheelerOneButton.setChecked(false);
                    VotaryPrivateTwoFiveButton.setChecked(false);
                    VotaryPrivateFiveButton.setChecked(false);
                    VotaryPrivateSevenFiveButton.setChecked(false);
                    VotaryPrivateOneFiveButton.setChecked(false);
                    VoluntarydeductableSumInsured="750";
                    VoluntarydeductableDiscountAmount="750";
                    VoluntarydeductableStatus="True";
                    CheckString="1";
                    ChangeAddons="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        VotaryTwoWheelerOneButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (VotaryTwoWheelerOneButton.isChecked()){
                    VotaryTwoWheelerOneButton.setChecked(true);
                    VotaryTwoWheelerSevenFiveButton.setChecked(false);
                    VotaryTwoWheelerOneFiveButton.setChecked(false);
                    VotaryTwoWheelerThreeButton.setChecked(false);
                    VotaryTwoWheelerFiveButton.setChecked(false);
                    VotaryPrivateTwoFiveButton.setChecked(false);
                    VotaryPrivateFiveButton.setChecked(false);
                    VotaryPrivateSevenFiveButton.setChecked(false);
                    VotaryPrivateOneFiveButton.setChecked(false);
                    VoluntarydeductableSumInsured="1000";
                    VoluntarydeductableDiscountAmount="1000";
                    VoluntarydeductableStatus="True";
                    CheckString="1";
                    ChangeAddons="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        VotaryTwoWheelerOneFiveButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (VotaryTwoWheelerOneFiveButton.isChecked()){
                    VotaryTwoWheelerOneFiveButton.setChecked(true);
                    VotaryTwoWheelerSevenFiveButton.setChecked(false);
                    VotaryTwoWheelerThreeButton.setChecked(false);
                    VotaryTwoWheelerFiveButton.setChecked(false);
                    VotaryTwoWheelerOneButton.setChecked(false);
                    VotaryPrivateTwoFiveButton.setChecked(false);
                    VotaryPrivateFiveButton.setChecked(false);
                    VotaryPrivateSevenFiveButton.setChecked(false);
                    VotaryPrivateOneFiveButton.setChecked(false);
                    VoluntarydeductableSumInsured="1500";
                    VoluntarydeductableDiscountAmount="1500";
                    VoluntarydeductableStatus="True";
                    CheckString="1";
                    ChangeAddons="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        VotaryTwoWheelerThreeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (VotaryTwoWheelerThreeButton.isChecked()){
                    VotaryTwoWheelerThreeButton.setChecked(true);
                    VotaryTwoWheelerOneFiveButton.setChecked(false);
                    VotaryTwoWheelerSevenFiveButton.setChecked(false);
                    VotaryTwoWheelerFiveButton.setChecked(false);
                    VotaryTwoWheelerOneButton.setChecked(false);
                    VotaryPrivateTwoFiveButton.setChecked(false);
                    VotaryPrivateFiveButton.setChecked(false);
                    VotaryPrivateSevenFiveButton.setChecked(false);
                    VotaryPrivateOneFiveButton.setChecked(false);
                    VoluntarydeductableSumInsured="3000";
                    VoluntarydeductableDiscountAmount="3000";
                    VoluntarydeductableStatus="True";
                    CheckString="1";
                    ChangeAddons="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        seekBarDistance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged=progress;
                changeseekBar="1";
                float lessIDV= Float.parseFloat(strLessIDVText);
                float highIDV= Float.parseFloat(strHighIDVText);
                float AllIDV= Float.parseFloat(strIdvValueTxt);
                b = Math.round(lessIDV);
                c = Math.round(highIDV);
                a = Math.round(AllIDV);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    seekBarDistance.setMin(b);
                    seekBarDistance.setMax(c);
                    seekBarDistance.setProgress(progressChanged);
                    strIdvValueTxtSelect= valueOf(progressChanged);
                    IDVTotalPremium.setText(strIdvValueTxtSelect);
                    Log.e("strIdvValueTxteeee", strIdvValueTxtSelect);
                }


            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // This method will automatically
                // called when the user touches the SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                CheckString="1";
                ChangeAddons="1";
                VehicleMotorQuotation();
                addOnsShow();
            }
        });
        AntitheftCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (AntitheftCheckBox.isChecked()){
                    CheckString="1";
                    AntitheftdevicediscountStatus="True";
                    VehicleMotorQuotation();
//                    addOnsShow();
                    AntitheftCheckBox.setChecked(true);
                }else{
                    CheckString="1";
                    AntitheftdevicediscountStatus="False";
                    VehicleMotorQuotation();
//                    addOnsShow();
                    AntitheftCheckBox.setChecked(false);
                }
            }
        });
        HandicapCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (HandicapCheckBox.isChecked()){
                    CheckString="1";
                    HandicapDiscountStatus="True";
                    VehicleMotorQuotation();
//                    addOnsShow();
                    HandicapCheckBox.setChecked(true);
                }else{
                    CheckString="1";
                    HandicapDiscountStatus="False";
                    VehicleMotorQuotation();
//                    addOnsShow();
                    HandicapCheckBox.setChecked(false);
                }
            }
        });
        TPPDCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (TPPDCheckBox.isChecked()){
                    TPPDDiscountStatus="True";
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                    TPPDCheckBox.setChecked(true);
                }else{
                    CheckString="1";
                    TPPDDiscountStatus="False";
                    VehicleMotorQuotation();
//                    addOnsShow();
                    TPPDCheckBox.setChecked(false);
                }
            }
        });
        CoverageCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CoverageCheckBox.isChecked()){
                    BasicODStatus="True";
                    VehicleMotorQuotation();
                    CoverageCheckBox.setChecked(true);
                }else{
                    BasicODStatus="False";
                    VehicleMotorQuotation();
                    CoverageCheckBox.setChecked(false);
                }
//                addOnsShow();
            }
        });
        BasicTPCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (BasicTPCheckBox.isChecked()){
                    BasicTP="True";
                    VehicleMotorQuotation();
//                    addOnsShow();
                    BasicTPCheckBox.setChecked(true);
                }else{
                    BasicTP="False";
                    VehicleMotorQuotation();
//                    addOnsShow();
                    BasicTPCheckBox.setChecked(false);
                }
            }
        });
        ElectricalCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ElectricalCheckBox.isChecked()){
                    Dialog alert_dialog;
                    alert_dialog = new Dialog(Motor_AddOns.this);
                    alert_dialog.setCanceledOnTouchOutside(false);
                    alert_dialog.setCancelable(false);
                    alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                    alert_dialog.setContentView(R.layout.elcetric_popup);
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                    lp.copyFrom(alert_dialog.getWindow().getAttributes());
                    lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                    lp.gravity = Gravity.CENTER;

                    ImageView CancelBtn=alert_dialog.findViewById(R.id.CancelBtn);
                    EditText electricalAccessoriesSumInsured=alert_dialog.findViewById(R.id.electricalAccessoriesSumInsured);
                    if (!CheckString.equals("1")&&!ChangeAddons.equals("1")){
                        strIdvValueTxtSelect=strIdvValueTxt;
                    }else if (strMinMax.equals("Min")){
                        strIdvValueTxtSelect=strLessIDVText;
                    }else if (strMinMax.equals("Max")){
                        strIdvValueTxtSelect=strHighIDVText;
                    }else{
                        strIdvValueTxtSelect=strIdvValueTxt1;
                    }


                    if(!(strIdvValueTxtSelect.equals("")||strIdvValueTxtSelect.equals("0.0")||strIdvValueTxtSelect.equals("0.00"))){
                        doubleIDVAmt=(Double.parseDouble(strIdvValueTxtSelect))*.40;
                        MathRound=(Math.round(doubleIDVAmt * 100.0) / 100.0);
                        Log.e("MathRoundElectric", valueOf(MathRound));
                    }else{
                        Toast.makeText(Motor_AddOns.this, "Can't Take Addons because idv is 0", Toast.LENGTH_SHORT).show();
                        ELECTRICALACCESSORYODStatus="False";
                        ElectricalCheckBox.setChecked(false);
                        alert_dialog.dismiss();
                    }

                    Button electricalAccessoriesBtn=alert_dialog.findViewById(R.id.electricalAccessoriesBtn);
                    electricalAccessoriesBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            strElectricalAccessoriesSumInsured=electricalAccessoriesSumInsured.getText().toString();
                            if (strElectricalAccessoriesSumInsured.equals("")){
                                Toast.makeText(Motor_AddOns.this, "Enter Value (Limit max 40% of IDV)", Toast.LENGTH_SHORT).show();
                                ELECTRICALACCESSORYODStatus="False";
                                ElectricalCheckBox.setChecked(false);
                            }else{
                                if (Double.parseDouble(strElectricalAccessoriesSumInsured)>MathRound){
                                    Toast.makeText(Motor_AddOns.this, "Limit max 40% of IDV", Toast.LENGTH_SHORT).show();
                                    ELECTRICALACCESSORYODStatus="False";
                                    ElectricalCheckBox.setChecked(false);
                                }else{
                                    ELECTRICALACCESSORYODStatus="True";
                                    ELECTRICALACCESSORYODSumInsured=strElectricalAccessoriesSumInsured;
                                    ElectricalCheckBox.setChecked(true);
                                    CheckString="1";
                                    VehicleMotorQuotation();
//                                    addOnsShow();
                                    alert_dialog.dismiss();
                                }
//                                if (strVehicleTypeRadio.equals("Four Wheeler")){
//                                    if (Double.parseDouble(strElectricalAccessoriesSumInsured)<1000.0 || (Double.parseDouble(strElectricalAccessoriesSumInsured)>MathRound)){
//                                        Toast.makeText(Motor_AddOns.this, "Limit Up-To min 1000 and max 40% of IDV", Toast.LENGTH_SHORT).show();
//                                        ELECTRICALACCESSORYODStatus="False";
//                                        ElectricalCheckBox.setChecked(false);
//                                    }else{
//                                        ELECTRICALACCESSORYODStatus="True";
//                                        ELECTRICALACCESSORYODSumInsured=strElectricalAccessoriesSumInsured;
//                                        ElectricalCheckBox.setChecked(true);
//                                        CheckString="1";
//                                        VehicleMotorQuotation();
//                                        addOnsShow();
//                                        alert_dialog.dismiss();
//                                    }
//                                }



                            }

                        }
                    });

                    alert_dialog.show();

                    CancelBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ELECTRICALACCESSORYODStatus="False";
                            ElectricalCheckBox.setChecked(false);
                            alert_dialog.dismiss();
                        }
                    });

                }else{
                    ELECTRICALACCESSORYODStatus="False";
                    ELECTRICALACCESSORYODSumInsured="1000";
                    ElectricalCheckBox.setChecked(false);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }

            }
        });
        FIBERTANKCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (FIBERTANKCheckBox.isChecked()){
                    FIBERTANKODStatus="True";
                    FIBERTANKCheckBox.setChecked(true);
                }else{
                    FIBERTANKODStatus="False";
                    FIBERTANKCheckBox.setChecked(false);
                }
                CheckString="1";
                VehicleMotorQuotation();
//                addOnsShow();
            }
        });
        LEGALCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (LEGALCheckBox.isChecked()){
                    LEGALLIABILITYTOPAIDDRIVERStatus="True";
                    LEGALCheckBox.setChecked(true);
                }else{
                    LEGALLIABILITYTOPAIDDRIVERStatus="False";
                    LEGALCheckBox.setChecked(false);
                }
                CheckString="1";
                VehicleMotorQuotation();
//                addOnsShow();
            }
        });
        NonLegalCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NonLegalCheckBox.isChecked()){
                    Dialog alert_dialog;
                    alert_dialog = new Dialog(Motor_AddOns.this);
                    alert_dialog.setCanceledOnTouchOutside(false);
                    alert_dialog.setCancelable(false);
                    alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                    alert_dialog.setContentView(R.layout.nonelcetric_popup);
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                    lp.copyFrom(alert_dialog.getWindow().getAttributes());
                    lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                    lp.gravity = Gravity.CENTER;
                    ImageView CancelBtn=alert_dialog.findViewById(R.id.CancelBtn);
                    EditText nonelectricalAccessoriesSumInsured=alert_dialog.findViewById(R.id.nonelectricalAccessoriesSumInsured);
                    if (!CheckString.equals("1")&&!ChangeAddons.equals("1")){
                        strIdvValueTxtSelect=strIdvValueTxt;
                    }else if (strMinMax.equals("Min")){
                        strIdvValueTxtSelect=strLessIDVText;
                    }else if (strMinMax.equals("Max")){
                        strIdvValueTxtSelect=strHighIDVText;
                    }else{
                        strIdvValueTxtSelect=strIdvValueTxt1;
                    }


                    if(!(strIdvValueTxtSelect.equals("")||strIdvValueTxtSelect.equals("0.0")||strIdvValueTxtSelect.equals("0.00"))){
                        doubleIDVAmt=(Double.parseDouble(strIdvValueTxtSelect))*.40;
                        MathRound=(Math.round(doubleIDVAmt * 100.0) / 100.0);
                        Log.e("MathRoundNonElectric", valueOf(MathRound));
                    }else{
                        Toast.makeText(Motor_AddOns.this, "Can't Take Addons because idv is 0", Toast.LENGTH_SHORT).show();
                        NONELECTRICALACCESSORYODStatus="False";
                        NonLegalCheckBox.setChecked(false);
                        alert_dialog.dismiss();
                    }
                    Button NonElectricalBtn=alert_dialog.findViewById(R.id.NonElectricalBtn);
                    NonElectricalBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            strNonelectricalAccessoriesSumInsured=nonelectricalAccessoriesSumInsured.getText().toString();
                            if (strNonelectricalAccessoriesSumInsured.equals("")){
                                Toast.makeText(Motor_AddOns.this, "Enter Value (Limit max 40% of IDV)", Toast.LENGTH_SHORT).show();
                                NONELECTRICALACCESSORYODStatus="False";
                                NonLegalCheckBox.setChecked(false);
                            }else{
                                if (Double.parseDouble(strNonelectricalAccessoriesSumInsured)>MathRound){
                                    Toast.makeText(Motor_AddOns.this, "max 40% of IDV", Toast.LENGTH_SHORT).show();
                                    NONELECTRICALACCESSORYODStatus="False";
                                    NonLegalCheckBox.setChecked(false);
                                }else{
                                    NONELECTRICALACCESSORYODStatus="True";
                                    NONELECTRICALACCESSORYODSumInsured=strNonelectricalAccessoriesSumInsured;
                                    NonLegalCheckBox.setChecked(true);
                                    CheckString="1";
                                    VehicleMotorQuotation();
//                                    addOnsShow();
                                    alert_dialog.dismiss();
                                }
//                                if (strVehicleTypeRadio.equals("Four Wheeler")){
//                                    if (Double.parseDouble(strNonelectricalAccessoriesSumInsured)<1000.0 || (Double.parseDouble(strNonelectricalAccessoriesSumInsured)>MathRound)){
//                                        Toast.makeText(Motor_AddOns.this, "Limit Up-To min 1000 and max 40% of IDV", Toast.LENGTH_SHORT).show();
//                                        NONELECTRICALACCESSORYODStatus="False";
//                                        NonLegalCheckBox.setChecked(false);
//                                    }else{
//                                        NONELECTRICALACCESSORYODStatus="True";
//                                        NONELECTRICALACCESSORYODSumInsured=strNonelectricalAccessoriesSumInsured;
//                                        NonLegalCheckBox.setChecked(true);
//                                        CheckString="1";
//                                        VehicleMotorQuotation();
//                                        addOnsShow();
//                                        alert_dialog.dismiss();
//                                    }
//                                }else{
//
//                                }
                            }
                        }
                    });

                    alert_dialog.show();
                    CancelBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            NONELECTRICALACCESSORYODStatus="False";
                            NonLegalCheckBox.setChecked(false);
                            alert_dialog.dismiss();
                        }
                    });

                }else{
                    NONELECTRICALACCESSORYODStatus="False";
                    NONELECTRICALACCESSORYODSumInsured="1000";
                    NonLegalCheckBox.setChecked(false);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }

            }
        });
        OtherOdCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (OtherOdCheckBox.isChecked()){
                    OtherODStatus="True";
                    OtherOdCheckBox.setChecked(true);
                }else{
                    OtherOdCheckBox.setChecked(false);
                    OtherODStatus="False";
                }
                CheckString="1";
                VehicleMotorQuotation();
//                addOnsShow();
            }
        });
        OtherTpCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (OtherTpCheckBox.isChecked()){
                    OtherTpStatus="True";
                    OtherTpCheckBox.setChecked(true);
                }else{
                    OtherTpCheckBox.setChecked(false);
                    OtherTpStatus="False";
                }
                CheckString="1";
                VehicleMotorQuotation();
//                addOnsShow();
            }
        });
        EmployeesInsuredCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (EmployeesInsuredCheckBox.isChecked()){
                    PACOVERTOEMPLOYEESOFINSUREDStatus="True";
                    EmployeesInsuredCheckBox.setChecked(true);
                }else{
                    EmployeesInsuredCheckBox.setChecked(false);
                    PACOVERTOEMPLOYEESOFINSUREDStatus="False";
                }
                CheckString="1";
                VehicleMotorQuotation();
//                addOnsShow();
            }
        });
        OWNERDRIVERCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (OWNERDRIVERCheckBox.isChecked()){
                    PACOVERTOOWNERDRIVERStatus="True";
                    OWNERDRIVERCheckBox.setChecked(true);
                }else{
                    PACOVERTOOWNERDRIVERStatus="False";
                    OWNERDRIVERCheckBox.setChecked(false);
                }
                CheckString="1";
                VehicleMotorQuotation();
//                addOnsShow();
            }
        });
        CNGLPGKITODCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CNGLPGKITODCheckBox.isChecked()){
                    if(CNGLPGKITTPStatus.equals("False")){
                        dialogCNG();
                    }
                }else{
                    CNGLPGKITODStatus="False";
                    CNGLPGKITTPStatus="False";
                    CNGLPGKITODSumInsured="1000";
                    CNGLPGKITODCheckBox.setChecked(false);
                    CNGLPGKITTPCheckBox.setChecked(false);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();

                }

            }
        });
        CNGLPGKITTPCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CNGLPGKITTPCheckBox.isChecked()){
                    if(CNGLPGKITODStatus.equals("False")){
                        dialogCNG();
                    }
                }else{
                    CNGLPGKITTPStatus="False";
                    CNGLPGKITODStatus="False";
                    CNGLPGKITTPCheckBox.setChecked(false);
                    CNGLPGKITODCheckBox.setChecked(false);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }

            }
        });
        BUILTINCNGKITCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (BUILTINCNGKITCheckBox.isChecked()){
                    BUILTINCNGKIT_LPGKITODStatus="True";
                    BUILTINCNGKIT_LPGKITTPStatus="True";

                    BUILTINCNGKITCheckBox.setChecked(true);
                    BuiltinCngLPGTpCheckBox.setChecked(true);
                }
//                else{
//                    BUILTINCNGKIT_LPGKITODStatus="False";
//                    BUILTINCNGKITCheckBox.setChecked(false);
//                    BUILTINCNGKIT_LPGKITTPStatus="False";
//                    BuiltinCngLPGTpCheckBox.setChecked(false);
//                }
                BUILTINCNGKITCheckBox.setClickable(false);
                BuiltinCngLPGTpCheckBox.setClickable(false);
                CheckString="1";
                VehicleMotorQuotation();
//                addOnsShow();
            }
        });
        BuiltinCngLPGTpCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (BuiltinCngLPGTpCheckBox.isChecked()){
                    BUILTINCNGKIT_LPGKITTPStatus="True";
                    BUILTINCNGKIT_LPGKITODStatus="True";
                    BuiltinCngLPGTpCheckBox.setChecked(true);
                    BUILTINCNGKITCheckBox.setChecked(true);
                }
//                else{
//                    BUILTINCNGKIT_LPGKITTPStatus="False";
//                    BuiltinCngLPGTpCheckBox.setChecked(false);
//                    BUILTINCNGKIT_LPGKITODStatus="False";
//                    BUILTINCNGKITCheckBox.setChecked(false);
//                }
                BUILTINCNGKITCheckBox.setClickable(false);
                BuiltinCngLPGTpCheckBox.setClickable(false);
                CheckString="1";
                VehicleMotorQuotation();
//                addOnsShow();
            }
        });
        PaidDriverCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PaidDriverCheckBox.isChecked()){
                    PaidDriverCheckBox.setChecked(true);
                    LinerPaidDriver.setVisibility(View.VISIBLE);
                }else{
                    PACOVERTOPAIDDRIVERStatus="False";
                    PACOVERTOPAIDDRIVERSumInsured="50000";
                    PaidDriverCheckBox.setChecked(false);
                    PARadioButtonFiveThousnand.setChecked(false);
                    PARadioButtonTenLakh.setChecked(false);
                    PARadioButtonOneFiveLakh.setChecked(false);
                    PARadioButtonTwoLakh.setChecked(false);
                    LinerPaidDriver.setVisibility(View.GONE);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        PARadioButtonFiveThousnand.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PARadioButtonFiveThousnand.isChecked()){
                    PACOVERTOPAIDDRIVERStatus="True";
                    PACOVERTOPAIDDRIVERSumInsured="50000";
                    PaidDriverCheckBox.setChecked(true);
                    PARadioButtonFiveThousnand.setChecked(true);
                    PARadioButtonTenLakh.setChecked(false);
                    PARadioButtonOneFiveLakh.setChecked(false);
                    PARadioButtonTwoLakh.setChecked(false);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        PARadioButtonTenLakh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PARadioButtonTenLakh.isChecked()){
                    PACOVERTOPAIDDRIVERStatus="True";
                    PACOVERTOPAIDDRIVERSumInsured="100000";
                    PaidDriverCheckBox.setChecked(true);
                    PARadioButtonFiveThousnand.setChecked(false);
                    PARadioButtonTenLakh.setChecked(true);
                    PARadioButtonOneFiveLakh.setChecked(false);
                    PARadioButtonTwoLakh.setChecked(false);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        PARadioButtonOneFiveLakh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PARadioButtonOneFiveLakh.isChecked()){
                    PACOVERTOPAIDDRIVERStatus="True";
                    PACOVERTOPAIDDRIVERSumInsured="150000";
                    PaidDriverCheckBox.setChecked(true);
                    PARadioButtonFiveThousnand.setChecked(false);
                    PARadioButtonTenLakh.setChecked(false);
                    PARadioButtonOneFiveLakh.setChecked(true);
                    PARadioButtonTwoLakh.setChecked(false);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        PARadioButtonTwoLakh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PARadioButtonTwoLakh.isChecked()){
                    PACOVERTOPAIDDRIVERStatus="True";
                    PACOVERTOPAIDDRIVERSumInsured="200000";
                    PaidDriverCheckBox.setChecked(true);
                    PARadioButtonFiveThousnand.setChecked(false);
                    PARadioButtonTenLakh.setChecked(false);
                    PARadioButtonOneFiveLakh.setChecked(false);
                    PARadioButtonTwoLakh.setChecked(true);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        PASSENGERSCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PASSENGERSCheckBox.isChecked()){
                    PASSENGERSCheckBox.setChecked(true);
                    NamedLiner.setVisibility(View.VISIBLE);
                }else{
                    PACOVERTOPASSENGERSStatus="False";
                    PACOVERTOPASSENGERSSumInsured="50000";
                    NamedLiner.setVisibility(View.GONE);
                    PASSENGERSCheckBox.setChecked(false);
                    PassengerFiveThousnand.setChecked(false);
                    PassengerTenLakh.setChecked(false);
                    PassengerOneFiveLakh.setChecked(false);
                    PassengerTwoLakh.setChecked(false);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }

            }
        });
        PassengerFiveThousnand.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PassengerFiveThousnand.isChecked()){
                    PACOVERTOPASSENGERSStatus="True";
                    PACOVERTOPASSENGERSSumInsured="50000";
                    PASSENGERSCheckBox.setChecked(true);
                    PassengerFiveThousnand.setChecked(true);
                    PassengerTenLakh.setChecked(false);
                    PassengerOneFiveLakh.setChecked(false);
                    PassengerTwoLakh.setChecked(false);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        PassengerTenLakh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PassengerTenLakh.isChecked()){
                    PACOVERTOPASSENGERSStatus="True";
                    PACOVERTOPASSENGERSSumInsured="100000";
                    PASSENGERSCheckBox.setChecked(true);
                    PassengerFiveThousnand.setChecked(false);
                    PassengerTenLakh.setChecked(true);
                    PassengerOneFiveLakh.setChecked(false);
                    PassengerTwoLakh.setChecked(false);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        PassengerOneFiveLakh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PassengerOneFiveLakh.isChecked()){
                    PACOVERTOPASSENGERSStatus="True";
                    PACOVERTOPASSENGERSSumInsured="150000";
                    PASSENGERSCheckBox.setChecked(true);
                    PassengerFiveThousnand.setChecked(false);
                    PassengerTenLakh.setChecked(false);
                    PassengerOneFiveLakh.setChecked(true);
                    PassengerTwoLakh.setChecked(false);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        PassengerTwoLakh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PassengerTwoLakh.isChecked()){
                    PACOVERTOPASSENGERSStatus="True";
                    PACOVERTOPASSENGERSSumInsured="200000";
                    PASSENGERSCheckBox.setChecked(true);
                    PassengerFiveThousnand.setChecked(false);
                    PassengerTenLakh.setChecked(false);
                    PassengerOneFiveLakh.setChecked(false);
                    PassengerTwoLakh.setChecked(true);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        UnnamedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (UnnamedCheckBox.isChecked()){
                    UnnamedCheckBox.setChecked(true);
                    UnnamedLiner.setVisibility(View.VISIBLE);
                }else{
                    UNNAMEDPACOVERTOPASSENGERSStatus="False";
                    UNNAMEDPACOVERTOPASSENGERSSumInsured="50000";
                    UnnamedCheckBox.setChecked(false);
                    UnnamedLiner.setVisibility(View.GONE);
                    PAUnNamedFiveThousnand.setChecked(false);
                    PAUnNamedOneFiveLakh.setChecked(false);
                    PAUnNamedTenLakh.setChecked(false);
                    PAUnNamedTwoLakh.setChecked(false);
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }

            }
        });
        PAUnNamedFiveThousnand.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PAUnNamedFiveThousnand.isChecked()){
                    PAUnNamedFiveThousnand.setChecked(true);
                    PAUnNamedOneFiveLakh.setChecked(false);
                    PAUnNamedTenLakh.setChecked(false);
                    PAUnNamedTwoLakh.setChecked(false);
                    UNNAMEDPACOVERTOPASSENGERSStatus="True";
                    UNNAMEDPACOVERTOPASSENGERSSumInsured="50000";
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        PAUnNamedOneFiveLakh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PAUnNamedOneFiveLakh.isChecked()){
                    PAUnNamedFiveThousnand.setChecked(false);
                    PAUnNamedOneFiveLakh.setChecked(true);
                    PAUnNamedTenLakh.setChecked(false);
                    PAUnNamedTwoLakh.setChecked(false);
                    UNNAMEDPACOVERTOPASSENGERSStatus="True";
                    UNNAMEDPACOVERTOPASSENGERSSumInsured="150000";
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        PAUnNamedTenLakh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PAUnNamedTenLakh.isChecked()){
                    PAUnNamedFiveThousnand.setChecked(false);
                    PAUnNamedOneFiveLakh.setChecked(false);
                    PAUnNamedTenLakh.setChecked(true);
                    PAUnNamedTwoLakh.setChecked(false);
                    UNNAMEDPACOVERTOPASSENGERSStatus="True";
                    UNNAMEDPACOVERTOPASSENGERSSumInsured="100000";
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });
        PAUnNamedTwoLakh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PAUnNamedTwoLakh.isChecked()){
                    PAUnNamedFiveThousnand.setChecked(false);
                    PAUnNamedOneFiveLakh.setChecked(false);
                    PAUnNamedTenLakh.setChecked(false);
                    PAUnNamedTwoLakh.setChecked(true);
                    UNNAMEDPACOVERTOPASSENGERSStatus="True";
                    UNNAMEDPACOVERTOPASSENGERSSumInsured="200000";
                    CheckString="1";
                    VehicleMotorQuotation();
//                    addOnsShow();
                }
            }
        });

        DailyCashAllowanceAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAILYCASHALLOWANCEStatus="True";
                CheckString="1";
                VehicleMotorQuotation();
//                addOnsShow();
                DailyCashAllowanceAddButton.setVisibility(View.GONE);
                DailyCashAllowanceRemoveButton.setVisibility(View.VISIBLE);
            }
        });
        DailyCashAllowanceRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAILYCASHALLOWANCEStatus="False";
                CheckString="1";
                VehicleMotorQuotation();
//                addOnsShow();
                DailyCashAllowanceRemoveButton.setVisibility(View.GONE);
                DailyCashAllowanceAddButton.setVisibility(View.VISIBLE);
            }
        });
        AccidentalHospitalAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACCIDENTALHOSPITALIZATIONStatus="True";
                CheckString="1";
                VehicleMotorQuotation();
//                addOnsShow();
                AccidentalHospitalAddButton.setVisibility(View.GONE);
                AccidentalHospitalRemoveButton.setVisibility(View.VISIBLE);
            }
        });
        AccidentalHospitalRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                ACCIDENTALHOSPITALIZATIONStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                AccidentalHospitalAddButton.setVisibility(View.VISIBLE);
                AccidentalHospitalRemoveButton.setVisibility(View.GONE);
            }
        });
        CostOfConsumableAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                COSTOFCONSUMABLESStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                CostOfConsumableAddButton.setVisibility(View.GONE);
                CostOfConsumableRemoveButton.setVisibility(View.VISIBLE);
            }
        });
        CostOfConsumableRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                COSTOFCONSUMABLESStatus="False";
                CheckString="1";
                VehicleMotorQuotation();
//                addOnsShow();
                CostOfConsumableAddButton.setVisibility(View.VISIBLE);
                CostOfConsumableRemoveButton.setVisibility(View.GONE);
            }
        });
        wrongFuelAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                WRONGFUELCOVERStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                wrongFuelAddButton.setVisibility(View.GONE);
                WrongFuelRemoveButton.setVisibility(View.VISIBLE);
            }
        });
        WrongFuelRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                WRONGFUELCOVERStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                WrongFuelRemoveButton.setVisibility(View.GONE);
                wrongFuelAddButton.setVisibility(View.VISIBLE);
            }
        });
        DailyCashAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                DAILYCASHALLOWANCEMETROStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                DailyCashAddButton.setVisibility(View.GONE);
                DailyCashRemoveButton.setVisibility(View.VISIBLE);
            }
        });
        DailyCashRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                DAILYCASHALLOWANCEMETROStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                DailyCashAddButton.setVisibility(View.VISIBLE);
                DailyCashRemoveButton.setVisibility(View.GONE);
            }
        });
        DailyCashNonADDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                DAILYCASHALLOWANCENONMETROStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                DailyCashNonADDButton.setVisibility(View.GONE);
                DailyCashNonRemoveButton.setVisibility(View.VISIBLE);

            }
        });
        DailyCashNonRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                DAILYCASHALLOWANCENONMETROStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                DailyCashNonADDButton.setVisibility(View.VISIBLE);
                DailyCashNonRemoveButton.setVisibility(View.GONE);


            }
        });
        EngineAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                ENGINEPROTECTORDIESELStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                EngineAddButton.setVisibility(View.GONE);
                EngineRemoveButton.setVisibility(View.VISIBLE);
            }
        });
        EngineRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                ENGINEPROTECTORDIESELStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                EngineAddButton.setVisibility(View.VISIBLE);
                EngineRemoveButton.setVisibility(View.GONE);
            }
        });
        ENGINEPetrolAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                ENGINEPROTECTORPETROLStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                ENGINEPetrolAddButton.setVisibility(View.GONE);
                ENGINEPetrolRemoveButton.setVisibility(View.VISIBLE);
            }
        });
        ENGINEPetrolRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                ENGINEPROTECTORPETROLStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                ENGINEPetrolAddButton.setVisibility(View.VISIBLE);
                ENGINEPetrolRemoveButton.setVisibility(View.GONE);
            }
        });
        HydrostaticAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                HYDROSTATICLOCKCOVERStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                HydrostaticAddButton.setVisibility(View.GONE);
                HydrostaticRemoveButton.setVisibility(View.VISIBLE);
            }
        });
        HydrostaticRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                HYDROSTATICLOCKCOVERStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                HydrostaticAddButton.setVisibility(View.VISIBLE);
                HydrostaticRemoveButton.setVisibility(View.GONE);
            }
        });

        KeyReplacementAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                KEYREPLACEMENTStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                KeyReplacementAddButton.setVisibility(View.GONE);
                KeyReplacementRemoveButton.setVisibility(View.VISIBLE);
            }
        });
        KeyReplacementRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                KEYREPLACEMENTStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                KeyReplacementAddButton.setVisibility(View.VISIBLE);
                KeyReplacementRemoveButton.setVisibility(View.GONE);

            }
        });

        NilAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                NilDepreciationWaivercoverStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                NilAddButton.setVisibility(View.GONE);
                NilRemoveButton.setVisibility(View.VISIBLE);
            }
        });

        NilRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                NilDepreciationWaivercoverStatus="False";
//                addOnsShow();
                VehicleMotorQuotation();
                NilAddButton.setVisibility(View.VISIBLE);
                NilRemoveButton.setVisibility(View.GONE);
            }
        });

        RetrunToVoiceAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                RETURNTOINVOICEStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                RetrunToVoiceAddButton.setVisibility(View.GONE);
                RetrunToVoiceRemoveButton.setVisibility(View.VISIBLE);
            }
        });

        RetrunToVoiceRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                RETURNTOINVOICEStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                RetrunToVoiceAddButton.setVisibility(View.VISIBLE);
                RetrunToVoiceRemoveButton.setVisibility(View.GONE);
            }
        });
        RoadsideAssistanceAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                RoadsideAssistanceStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                RoadsideAssistanceAddButton.setVisibility(View.GONE);
                RoadsideAssistanceRemoveButton.setVisibility(View.VISIBLE);
            }
        });
        RoadsideAssistanceRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                RoadsideAssistanceStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                RoadsideAssistanceAddButton.setVisibility(View.VISIBLE);
                RoadsideAssistanceRemoveButton.setVisibility(View.GONE);
            }
        });

        SecureTowingAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                SECURETOWINGStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                SecureTowingAddButton.setVisibility(View.GONE);
                SecureTowingRemoveButton.setVisibility(View.VISIBLE);
            }
        });
        SecureTowingRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                SECURETOWINGStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                SecureTowingAddButton.setVisibility(View.VISIBLE);
                SecureTowingRemoveButton.setVisibility(View.GONE);
            }
        });

        TyreAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                TyreandRimsecureStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                TyreAddButton.setVisibility(View.GONE);
                TyreRemoveButton.setVisibility(View.VISIBLE);
            }
        });

        TyreRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                TyreandRimsecureStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                TyreAddButton.setVisibility(View.VISIBLE);
                TyreRemoveButton.setVisibility(View.GONE);
            }
        });

        ManufacturePriceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                MANUFACTURERSELLINGPRICEStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                ManufacturePriceRemoveButton.setVisibility(View.VISIBLE);
                ManufacturePriceButton.setVisibility(View.GONE);
            }
        });
        ManufacturePriceRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                MANUFACTURERSELLINGPRICEStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                ManufacturePriceButton.setVisibility(View.VISIBLE);
                ManufacturePriceRemoveButton.setVisibility(View.GONE);
            }
        });

        DrivingTrainProtectAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                DRIVINGTRAINPROTECTStatus="True";
                VehicleMotorQuotation();
//                addOnsShow();
                DrivingTrainProtectAddButton.setVisibility(View.GONE);
                DrivingTrainProtectRemoveButton.setVisibility(View.VISIBLE);
            }
        });

        DrivingTrainProtectRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckString="1";
                DRIVINGTRAINPROTECTStatus="False";
                VehicleMotorQuotation();
//                addOnsShow();
                DrivingTrainProtectAddButton.setVisibility(View.VISIBLE);
                DrivingTrainProtectRemoveButton.setVisibility(View.GONE);
            }
        });
        ViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialog = new Dialog(Motor_AddOns.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.viewdetails_motor);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(alert_dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.gravity = Gravity.CENTER;

                buttonClose=alert_dialog.findViewById(R.id.buttonClose);
                basicPremium=alert_dialog.findViewById(R.id.basicPremium);
                VehicleModelEdit=alert_dialog.findViewById(R.id.VehicleModelEdit);
                YearEdit=alert_dialog.findViewById(R.id.YearEdit);
                addOnsEdit=alert_dialog.findViewById(R.id.addOnsEdit);
                DiscountEdit=alert_dialog.findViewById(R.id.DiscountEdit);
                TotalDiscountEdit=alert_dialog.findViewById(R.id.TotalDiscountEdit);
                gstEdit=alert_dialog.findViewById(R.id.gstEdit);
                addCoveragesEdit=alert_dialog.findViewById(R.id.addCoveragesEdit);
                BasicODEdit=alert_dialog.findViewById(R.id.BasicODEdit);
                BasicTpEdit=alert_dialog.findViewById(R.id.BasicTpEdit);
                totalAmount=alert_dialog.findViewById(R.id.totalAmount);
                NCBEdit=alert_dialog.findViewById(R.id.NCBEdit);
                basicPremium.setText(NetPremiumValue);
                VehicleModelEdit.setText(str_vehicleManufacturerNm+" "+strVehicleModel);
                YearEdit.setText(yearOfManufacture);

                if(!(CheckString.equals("1"))){
                    addOnsAditional="0.0";
                    DiscountsVale="0.0";
                }
                addOnsEdit.setText(addOnsCover);
                addCoveragesEdit.setText(addOnsAditional);
                TotalDiscountEdit.setText(DiscountsVale);
                gstEdit.setText(GST);
                BasicODEdit.setText(StrAdditionalCoverPremiumOD);
                BasicTpEdit.setText(StrAdditionalCoverPremiumTp);
                totalAmount.setText(TotalValue);
                DiscountEdit.setText(strDiscountEdit);

                NCBEdit.setText(StrNCB);
                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert_dialog.dismiss();
                    }
                });

                alert_dialog.show();
            }
        });

        AddOnsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
                    Intent intent=new Intent(Motor_AddOns.this, Add_Details_Old_Vehicle.class);
                    intent.putExtra("strVehicleNo",strVehicleNo);
                    intent.putExtra("str_edt_city",str_edt_city);
                    intent.putExtra("str_edt_phone",str_edt_phone);
                    intent.putExtra("str_edt_email",str_edt_email);
                    intent.putExtra("strPolicyRadio",strPolicyRadio);
                    intent.putExtra("strVehicleTypeRadio",strVehicleTypeRadio);
                    intent.putExtra("strVehicleRadio",strVehicleRadio);
                    intent.putExtra("strPolicyNumberEdit",strPolicyNumberEdit);
                    intent.putExtra("strClaimBonus",strClaimBonus);
                    intent.putExtra("strEndDateEdit",strEndDateEdit);
                    intent.putExtra("StrPreviousPolicyRadio",StrPreviousPolicyRadio);
                    intent.putExtra("strCompanyName",strCompanyName);
                    intent.putExtra("strPreviousClaimRadio",strPreviousClaimRadio);
                    intent.putExtra("ckycNo",ckycNo);
                    intent.putExtra("streditdob",streditdob);
                    intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
                    intent.putExtra("strFor","1");
                    intent.putExtra("strNewFor","1");
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent=new Intent(Motor_AddOns.this,Private_car_vehicle_details.class);
                    intent.putExtra("strVehicleNo",strVehicleNo);
                    intent.putExtra("strName",strName);
                    intent.putExtra("strIDType",strIDType);
                    intent.putExtra("strIDTypeName",strIDTypeName);
                    intent.putExtra("strIDTypeName1",strIDTypeName1);
                    intent.putExtra("strIDNumberEdit",strIDNumberEdit);
                    intent.putExtra("streditdob",streditdob);
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
                    intent.putExtra("DetarifficValueDiscount",DetarifficValueDiscount);
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
                    intent.putExtra("VoluntarydeductableDiscountAmount",VoluntarydeductableDiscountAmount);
                    intent.putExtra("ELECTRICALACCESSORYODSumInsured",ELECTRICALACCESSORYODSumInsured);
                    intent.putExtra("NONELECTRICALACCESSORYODSumInsured",NONELECTRICALACCESSORYODSumInsured);
                    intent.putExtra("CNGLPGKITODSumInsured",CNGLPGKITODSumInsured);
                    intent.putExtra("selectYear",selectYear);
                    intent.putExtra("daysLeft",daysLeft);
                    intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
                    intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
                    intent.putExtra("ckycNo",ckycNo);
                    intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
                    intent.putExtra("a",a);
                    intent.putExtra("b",b);
                    intent.putExtra("c",c);
                    intent.putExtra("strFor","1");
                    intent.putExtra("strNewFor","1");
                    intent.putExtra("CheckString","1");
                    intent.putExtra("changeseekBar","0");
                    intent.putExtra("ChangeAddons",ChangeAddons);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);

                    finish();
                }
            }
        });

        saveTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveGetQuote();
            }
        });

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Motor_AddOns.this,Motor_vehicle_details.class);
                intent.putExtra("strVehicleNo",strVehicleNo);
                intent.putExtra("streditdob",streditdob);
                intent.putExtra("strIDType",strIDType);
                intent.putExtra("strIDTypeName",strIDTypeName);
                intent.putExtra("strIDTypeName1",strIDTypeName1);
                intent.putExtra("strIDNumberEdit",strIDNumberEdit);
                intent.putExtra("str_edt_city",str_edt_city);
                intent.putExtra("str_edt_phone",str_edt_phone);
                intent.putExtra("MemberEditTxt", strMemberEditTxt);
                intent.putExtra("ValidityTxt", strValidityTxt);
                intent.putExtra("str_edt_email",str_edt_email);
                intent.putExtra("strPolicyRadio",strPolicyRadio);
                intent.putExtra("strVehicleTypeRadio",strVehicleTypeRadio);
                intent.putExtra("strVehicleRadio",strVehicleRadio);
                intent.putExtra("str_vehicleManufacturerNm",str_vehicleManufacturerNm);
                intent.putExtra("strVehicleModel",strVehicleModel);
                intent.putExtra("str_edt_registration_date",str_edt_registration_date);
                intent.putExtra("strStateName",strStateName);
                intent.putExtra("strRTOName",strRTOName);
                intent.putExtra("strPolicyNumberEdit",strPolicyNumberEdit);
                intent.putExtra("strPlanType",strPlanType);
                intent.putExtra("strPlanYear",strPlanYear);
                intent.putExtra("strCoverageType",strCoverageType);
                intent.putExtra("strPACover",strPACover);
                intent.putExtra("strGPACover",strGPACover);
                intent.putExtra("strDrivingLicence",strDrivingLicence);
                intent.putExtra("strName",strName);
                intent.putExtra("streditdob",streditdob);
                intent.putExtra("TotalValue",TotalValue);
                intent.putExtra("NetPremiumValue",NetPremiumValue);
                intent.putExtra("PosPolicyNo",PosPolicyNo);
                intent.putExtra("tomorrowDate",tomorrowDate);
                intent.putExtra("GST",GST);
                intent.putExtra("strIdvValueTxt",strIdvValueTxt);
                intent.putExtra("strIdvValueTxtSelect",strIdvValueTxtSelect);
                intent.putExtra("strLessIDVText",strLessIDVText);
                intent.putExtra("strHighIDVText",strHighIDVText);
                intent.putExtra("yearOfManufacture",yearOfManufacture);
                intent.putExtra("strVehicleAge",strVehicleAge);
                intent.putExtra("strVehicleManufacturerCode",strVehicleManufacturerCode);
                intent.putExtra("strRTOCode",strRTOCode);
                intent.putExtra("yearOfManufactureMonth",yearOfManufactureMonth);
                intent.putExtra("strSelectDateYear",strSelectDateYear);
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
                intent.putExtra("addOns",addOns);
                intent.putExtra("NCB",NCB);
                intent.putExtra("VehicleClassCode",VehicleClassCode);
                intent.putExtra("ProductCode",ProductCode);
                intent.putExtra("ProductName",ProductName);
                intent.putExtra("strClaimBonus",strClaimBonus);
                intent.putExtra("strEndDateEdit",strEndDateEdit);
                intent.putExtra("StrPreviousPolicyRadio",StrPreviousPolicyRadio);
                intent.putExtra("VEHICLECLASSCODE",VEHICLECLASSCODE);
                intent.putExtra("NumberOfWheels",NumberOfWheels);
                intent.putExtra("strVehicleChasisNumber",strVehicleChasisNumber);
                intent.putExtra("strVehicleEngineNumber",strVehicleEngineNumber);
                intent.putExtra("rc_fuel_desc",rc_fuel_desc);
                intent.putExtra("rc_cubic_cap",rc_cubic_cap);
                intent.putExtra("FuleType",FuleType);
                intent.putExtra("strCompanyName",strCompanyName);
                intent.putExtra("nextYear",nextYear);
                intent.putExtra("vehicleManufacturerType",vehicleManufacturerType);
                intent.putExtra("strModelType",strModelType);
                intent.putExtra("addOnsCover",addOnsCover);
                intent.putExtra("addOnsAditional",addOnsAditional);
                intent.putExtra("SeekbarStatus",SeekbarStatus);
                intent.putExtra("StrAdditionalCoverPremiumOD",StrAdditionalCoverPremiumOD);
                intent.putExtra("StrAdditionalCoverPremiumTp",StrAdditionalCoverPremiumTp);
                intent.putExtra("strPreviousClaimRadio",strPreviousClaimRadio);
                intent.putExtra("AdditionalElectricalRateValue",AdditionalElectricalRateValue);
                intent.putExtra("AdditionalFibertankODRateValue",AdditionalFibertankODRateValue);
                intent.putExtra("AdditionalLegalLiabilityPaidRate",AdditionalLegalLiabilityPaidRate);
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
                intent.putExtra("BUILTINCNGKIT_LPGKITTPStatus",BUILTINCNGKIT_LPGKITTPStatus);
                intent.putExtra("MANUFACTURERSELLINGPRICEStatus",MANUFACTURERSELLINGPRICEStatus);
                intent.putExtra("DRIVINGTRAINPROTECTStatus",DRIVINGTRAINPROTECTStatus);
                intent.putExtra("CheckString",CheckString);
                intent.putExtra("progressChanged",progressChanged);
                intent.putExtra("BasicODRateValue",BasicODRateValue);
                intent.putExtra("BasicTpRateValue",BasicTpRateValue);
                intent.putExtra("changeseekBar",changeseekBar);
                intent.putExtra("strStateCode",strStateCode);
                intent.putExtra("DAILYCASHALLOWANCEStatus",DAILYCASHALLOWANCEStatus);
                intent.putExtra("DailyCashRateValue",DailyCashRateValue);
                intent.putExtra("WrongFuelRateValue",WrongFuelRateValue);
                intent.putExtra("WRONGFUELCOVERStatus",WRONGFUELCOVERStatus);
                intent.putExtra("DetarifficValuePremium",DetarifficValuePremium);
                intent.putExtra("DetarifficValueDiscount",DetarifficValueDiscount);
                intent.putExtra("DetarifficValueRate",DetarifficValueRate);
                intent.putExtra("DetarifficLodingValuePremium",DetarifficLodingValuePremium);
                intent.putExtra("DetarifficLoadingValueRate",DetarifficLoadingValueRate);
                intent.putExtra("strTitleEdit",strTitleEdit);
                intent.putExtra("strRegisteredAddressEdit",strRegisteredAddressEdit);
                intent.putExtra("strPinCodeEditText",strPinCodeEditText);
                intent.putExtra("strStateRegisterAddressEdit",strStateRegisterAddressEdit);
                intent.putExtra("strCityRegisterEdit",strCityRegisterEdit);
                intent.putExtra("strCommunicationAddressEdit",strCommunicationAddressEdit);
                intent.putExtra("strCommunicationPinCodeEdit",strCommunicationPinCodeEdit);
                intent.putExtra("strStateCommunicationEdit",strStateCommunicationEdit);
                intent.putExtra("strCityCommunicationEdit",strCityCommunicationEdit);
                intent.putExtra("strCheckedTermCondition",strCheckedTermCondition);
                intent.putExtra("strCheckboxCommunication",strCheckboxCommunication);
                intent.putExtra("strCityRegisterCode",strCityRegisterCode);
                intent.putExtra("strCityCommunicationCode",strCityCommunicationCode);
                intent.putExtra("strVehicleCubicCapicity",strVehicleCubicCapicity);
                intent.putExtra("strVehicleImage",strVehicleImage);
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
                intent.putExtra("ChangeAddons",ChangeAddons);
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
                intent.putExtra("VoluntarydeductableDiscountAmount",VoluntarydeductableDiscountAmount);
                intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
                intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
                intent.putExtra("StrPrev_Policy_Type",StrPrev_Policy_Type);
                intent.putExtra("CNGLPGKITODSumInsured",CNGLPGKITODSumInsured);
                intent.putExtra("selectYear",selectYear);
                intent.putExtra("daysLeft",daysLeft);
                intent.putExtra("ckycNo",ckycNo);
                intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
                intent.putExtra("a",a);
                intent.putExtra("b",b);
                intent.putExtra("c",c);
                intent.putExtra("strFor","1");
                intent.putExtra("strNewFor","1");
                startActivity(intent);
                finish();

            }
        });
    }
    private void addOnsShow() {
        if (strVehicleTypeRadio.equals("Four Wheeler")) {
            if (str_vehicleManufacturerNm.equals("MARUTI") || str_vehicleManufacturerNm.equals("MARUTI SUZUKI") || str_vehicleManufacturerNm.equals("MARUTI SUZUKI INDIA LTD")) {
                BasicODStatus = "True";
                BasicTP = "True";
                PACOVERTOEMPLOYEESOFINSUREDStatus1 = "True";
                PACOVERTOPASSENGERSStatus1 = "True";
                PACOVERTOPAIDDRIVERStatus1 = "True";
                OtherTpStatus1 = "True";
                FIBERTANKODStatus1 = "True";
                OtherODStatus1 = "True";
                UNNAMEDPACOVERTOPASSENGERSStatus1 = "True";
                PACOVERTOOWNERDRIVERStatus1 = "False";
                LEGALLIABILITYTOPAIDDRIVERStatus1 = "True";
                DRIVINGTRAINPROTECTStatus1 = "True";
                RoadsideAssistanceStatus1 = "True";
                NilDepreciationWaivercoverStatus1 = "True";
                DAILYCASHALLOWANCENONMETROStatus1 = "False";
                DAILYCASHALLOWANCEMETROStatus1 = "False";
                KEYREPLACEMENTStatus1 = "False";
                RETURNTOINVOICEStatus1 = "True";
                ACCIDENTALHOSPITALIZATIONStatus1 = "False";
                HYDROSTATICLOCKCOVERStatus1 = "True";
                COSTOFCONSUMABLESStatus1 = "True";
                SECURETOWINGStatus1 = "False";
                TyreandRimsecureStatus1 = "False";
                ENGINEPROTECTORPETROLStatus1 = "True";
                ENGINEPROTECTORDIESELStatus1 = "True";
                DAILYCASHALLOWANCEStatus1 = "False";
                WRONGFUELCOVERStatus1 = "False";
                MANUFACTURERSELLINGPRICEStatus1 = "False";
                DetariffDiscountStatus1 = "True";
                DetariffLoadingStatus1 = "True";
                VehicleMotorAddOnsQuotation();
            }
            else if (str_vehicleManufacturerNm.equalsIgnoreCase("Honda")) {
                BasicODStatus = "True";
                BasicTP = "True";
                PACOVERTOEMPLOYEESOFINSUREDStatus1 = "True";
                PACOVERTOPASSENGERSStatus1 = "True";
                PACOVERTOPAIDDRIVERStatus1 = "True";
                OtherTpStatus1 = "True";
                FIBERTANKODStatus1 = "True";
                OtherODStatus1 = "True";
                UNNAMEDPACOVERTOPASSENGERSStatus1 = "True";
                PACOVERTOOWNERDRIVERStatus1 = "False";
                MANUFACTURERSELLINGPRICEStatus1 = "False";
                DRIVINGTRAINPROTECTStatus1 = "True";
                LEGALLIABILITYTOPAIDDRIVERStatus1 = "True";
                RoadsideAssistanceStatus1 = "False";
                NilDepreciationWaivercoverStatus1 = "True";
                DAILYCASHALLOWANCENONMETROStatus1 = "False";
                DAILYCASHALLOWANCEMETROStatus1 = "False";
                KEYREPLACEMENTStatus1 = "True";
                RETURNTOINVOICEStatus1 = "True";
                ACCIDENTALHOSPITALIZATIONStatus1 = "False";
                HYDROSTATICLOCKCOVERStatus1 = "True";
                COSTOFCONSUMABLESStatus1 = "False";
                SECURETOWINGStatus1 = "False";
                TyreandRimsecureStatus1 = "True";
                ENGINEPROTECTORPETROLStatus1 = "True";
                ENGINEPROTECTORDIESELStatus1 = "True";
                DAILYCASHALLOWANCEStatus1 = "True";
                WRONGFUELCOVERStatus1 = "False";
                DetariffDiscountStatus1 = "True";
                DetariffLoadingStatus1 = "True";
                VehicleMotorAddOnsQuotation();
            }
            else if (str_vehicleManufacturerNm.equals("Tata") || str_vehicleManufacturerNm.equals("TATA MOTORS LIMITED")) {
                BasicODStatus = "True";
                BasicTP = "True";
                PACOVERTOEMPLOYEESOFINSUREDStatus1 = "True";
                PACOVERTOPASSENGERSStatus1 = "True";
                PACOVERTOPAIDDRIVERStatus1 = "True";
                OtherTpStatus1 = "True";
                FIBERTANKODStatus1 = "True";
                OtherODStatus1 = "True";
                UNNAMEDPACOVERTOPASSENGERSStatus1 = "True";
                PACOVERTOOWNERDRIVERStatus1 = "False";
                MANUFACTURERSELLINGPRICEStatus1 = "False";
                DRIVINGTRAINPROTECTStatus1 = "True";
                LEGALLIABILITYTOPAIDDRIVERStatus1 = "True";
                RoadsideAssistanceStatus1 = "True";
                NilDepreciationWaivercoverStatus1 = "True";
                DAILYCASHALLOWANCENONMETROStatus1 = "False";
                DAILYCASHALLOWANCEMETROStatus1 = "False";
                KEYREPLACEMENTStatus1 = "True";
                RETURNTOINVOICEStatus1 = "True";
                ACCIDENTALHOSPITALIZATIONStatus1 = "False";
                HYDROSTATICLOCKCOVERStatus1 = "True";
                COSTOFCONSUMABLESStatus1 = "True";
                SECURETOWINGStatus1 = "True";
                TyreandRimsecureStatus1 = "False";
                ENGINEPROTECTORPETROLStatus1 = "True";
                ENGINEPROTECTORDIESELStatus1 = "True";
                DAILYCASHALLOWANCEStatus1 = "False";
                WRONGFUELCOVERStatus1 = "False";
                DetariffDiscountStatus1 = "True";
                DetariffLoadingStatus1 = "True";
                VehicleMotorAddOnsQuotation();
            }
            else {
                BasicODStatus = "True";
                BasicTP = "True";
                PACOVERTOEMPLOYEESOFINSUREDStatus1 = "True";
                PACOVERTOPASSENGERSStatus1 = "True";
                PACOVERTOPAIDDRIVERStatus1 = "True";
                OtherTpStatus1 = "True";
                FIBERTANKODStatus1 = "True";
                OtherODStatus1 = "True";
                UNNAMEDPACOVERTOPASSENGERSStatus1 = "True";
                PACOVERTOOWNERDRIVERStatus1 = "False";
                MANUFACTURERSELLINGPRICEStatus1 = "False";
                DRIVINGTRAINPROTECTStatus1 = "True";
                LEGALLIABILITYTOPAIDDRIVERStatus1 = "True";
                RoadsideAssistanceStatus1 = "True";
                NilDepreciationWaivercoverStatus1 = "True";
                DAILYCASHALLOWANCENONMETROStatus1 = "False";
                DAILYCASHALLOWANCEMETROStatus1 = "False";
                KEYREPLACEMENTStatus1 = "True";
                RETURNTOINVOICEStatus1 = "True";
                ACCIDENTALHOSPITALIZATIONStatus1 = "False";
                HYDROSTATICLOCKCOVERStatus1 = "True";
                COSTOFCONSUMABLESStatus1 = "True";
                SECURETOWINGStatus1 = "True";
                TyreandRimsecureStatus1 = "True";
                ENGINEPROTECTORPETROLStatus1 = "True";
                ENGINEPROTECTORDIESELStatus1 = "True";
                DAILYCASHALLOWANCEStatus1 = "True";
                WRONGFUELCOVERStatus1 = "True";
                DetariffDiscountStatus1 = "True";
                DetariffLoadingStatus1 = "True";

                VehicleMotorAddOnsQuotation();

            }
        }
        else {
            BasicODStatus = "True";
            BasicTP = "True";
            PACOVERTOEMPLOYEESOFINSUREDStatus1 = "False";
            PACOVERTOPASSENGERSStatus1 = "True";
            PACOVERTOPAIDDRIVERStatus1 = "True";
            OtherTpStatus1 = "True";
            FIBERTANKODStatus1 = "True";
            OtherODStatus1 = "True";
            UNNAMEDPACOVERTOPASSENGERSStatus1 = "True";
            PACOVERTOOWNERDRIVERStatus1 = "False";
            MANUFACTURERSELLINGPRICEStatus1 = "True";
            DRIVINGTRAINPROTECTStatus1 = "True";
            LEGALLIABILITYTOPAIDDRIVERStatus1 = "True";
            RoadsideAssistanceStatus1 = "True";
            NilDepreciationWaivercoverStatus1 = "False";
            DAILYCASHALLOWANCENONMETROStatus1 = "False";
            DAILYCASHALLOWANCEMETROStatus1 = "False";
            KEYREPLACEMENTStatus1 = "False";
            RETURNTOINVOICEStatus1 = "False";
            HYDROSTATICLOCKCOVERStatus1 = "True";
            COSTOFCONSUMABLESStatus1 = "False";
            SECURETOWINGStatus1 = "False";
            TyreandRimsecureStatus1 = "True";
            WRONGFUELCOVERStatus1 = "True";
            DetariffLoadingStatus1 = "True";
            DetariffDiscountStatus1 = "True";
            ACCIDENTALHOSPITALIZATIONStatus1 = "False";
            ENGINEPROTECTORDIESELStatus1 = "False";
            ENGINEPROTECTORPETROLStatus1 = "False";
            DAILYCASHALLOWANCEStatus1 = "False";
            VehicleMotorAddOnsQuotation();
        }
    }

    private void dialogCNG() {
        CNGalert_dialog = new Dialog(Motor_AddOns.this);
        CNGalert_dialog.setCanceledOnTouchOutside(false);
        CNGalert_dialog.setCancelable(false);
        CNGalert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(CNGalert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        CNGalert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        CNGalert_dialog.setContentView(R.layout.cngkitod_popup);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(CNGalert_dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        CNGalert_dialog.show();
        EditText CngKitSumInsured=CNGalert_dialog.findViewById(R.id.CngKitSumInsured);
        ImageView CancelBtn=CNGalert_dialog.findViewById(R.id.CancelBtn);
        strCngKitSumInsured=CngKitSumInsured.getText().toString();
        if (!CheckString.equals("1")&&!ChangeAddons.equals("1")){
            strIdvValueTxtSelect=strIdvValueTxt;
        }else if (strMinMax.equals("Min")){
            strIdvValueTxtSelect=strLessIDVText;
        }else if (strMinMax.equals("Max")){
            strIdvValueTxtSelect=strHighIDVText;
        }else{
            strIdvValueTxtSelect=strIdvValueTxt1;
        }

        if(!(strIdvValueTxtSelect.equals("")||strIdvValueTxtSelect.equals("0.0")||strIdvValueTxtSelect.equals("0.00"))){
            doubleIDVAmt=(Double.parseDouble(strIdvValueTxtSelect))*.40;
            MathRound=(Math.round(doubleIDVAmt * 100.0) / 100.0);
            Log.e("MathRoundNonElectric", valueOf(MathRound));
        }else{
            Toast.makeText(Motor_AddOns.this, "Can't Take Addons because idv is 0", Toast.LENGTH_SHORT).show();
            CNGLPGKITODStatus="False";
            CNGLPGKITODCheckBox.setChecked(false);
            CNGalert_dialog.dismiss();
        }
        Button CngKitBtn=CNGalert_dialog.findViewById(R.id.CngKitBtn);
        CngKitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strCngKitSumInsured=CngKitSumInsured.getText().toString();
                if (strCngKitSumInsured.equals("")){
                    Toast.makeText(Motor_AddOns.this, "Enter Value (Limit Up-To min 1000 and max 40% of IDV)", Toast.LENGTH_SHORT).show();
                    CNGLPGKITODStatus="False";
                    CNGLPGKITTPStatus="False";
                    CNGLPGKITODCheckBox.setChecked(false);
                    CNGLPGKITTPCheckBox.setChecked(false);
                    CNGalert_dialog.dismiss();
                }else{
                    if (Double.parseDouble(strCngKitSumInsured)<1000.0 || (Double.parseDouble(strCngKitSumInsured)>MathRound)){
                        Toast.makeText(Motor_AddOns.this, "Limit Up-To min 1000 and max 40% of IDV", Toast.LENGTH_SHORT).show();
                        CNGLPGKITODStatus="False";
                        CNGLPGKITTPStatus="False";
                        CNGLPGKITODCheckBox.setChecked(false);
                        CNGLPGKITTPCheckBox.setChecked(false);
                        CNGalert_dialog.dismiss();
                    }else{
                        CNGLPGKITODStatus="True";
                        CNGLPGKITTPStatus="True";
                        CNGLPGKITODCheckBox.setChecked(true);
                        CNGLPGKITTPCheckBox.setChecked(true);
                        CNGLPGKITODSumInsured=strCngKitSumInsured;
                        CheckString="1";
                        CNGalert_dialog.dismiss();
                        VehicleMotorQuotation();
                        addOnsShow();

                    }
                }
            }
        });
        CancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CNGLPGKITODStatus="False";
                CNGLPGKITTPStatus="False";
                CNGLPGKITTPCheckBox.setChecked(false);
                CNGLPGKITODCheckBox.setChecked(false);
                CNGalert_dialog.dismiss();
            }
        });

    }
    private void VehicleMotorAddOnsQuotation() {
        String IDV_new;
        if (changeseekBar.equals("1")){
            IDV_new=strIdvValueTxtSelect;
        }else{
            IDV_new=strIdvValueTxt;
        }

        if (strVehicleTypeRadio.equals("Four Wheeler")){
            VoluntarydeductableSumInsured="2500";
            if (FuleType.equals("Petrol")){
                CNGLPGKITODStatus1="True";
                ENGINEPROTECTORPETROLStatus1="True";
                CNGLPGKITTPStatus1="True";
                ENGINEPROTECTORDIESELStatus1="False";
                BUILTINCNGKIT_LPGKITODStatus1="False";
                BUILTINCNGKIT_LPGKITTPStatus1="False";
                BUILTINCNGKITCheckBox.setChecked(false);
                BuiltinCngLPGTpCheckBox.setChecked(false);
            }else if (FuleType.equals("LPG")||FuleType.equals("CNG")){
                BUILTINCNGKIT_LPGKITODStatus1="True";
                BUILTINCNGKIT_LPGKITTPStatus1="True";
                CNGLPGKITODStatus1="False";
                CNGLPGKITTPStatus1="False";
                ENGINEPROTECTORPETROLStatus1="False";
                ENGINEPROTECTORDIESELStatus1="False";
                BUILTINCNGKITCheckBox.setChecked(true);
                BuiltinCngLPGTpCheckBox.setChecked(true);
            }else if (FuleType.equals("Diesel")){
                ENGINEPROTECTORPETROLStatus1="False";
                ENGINEPROTECTORDIESELStatus1="True";
                BUILTINCNGKIT_LPGKITODStatus1="False";
                BUILTINCNGKIT_LPGKITTPStatus1="False";
                CNGLPGKITODStatus1="False";
                CNGLPGKITTPStatus1="False";
                BUILTINCNGKITCheckBox.setChecked(false);
                BuiltinCngLPGTpCheckBox.setChecked(false);
            }else{
                ENGINEPROTECTORPETROLStatus1="False";
                ENGINEPROTECTORDIESELStatus1="False";
                BUILTINCNGKIT_LPGKITODStatus1="False";
                BUILTINCNGKIT_LPGKITTPStatus1="False";
                CNGLPGKITODStatus1="False";
                CNGLPGKITTPStatus1="False";
                BUILTINCNGKITCheckBox.setChecked(false);
                BuiltinCngLPGTpCheckBox.setChecked(false);
            }
        }
        else{
            if (FuleType.equals("Petrol")){
                ENGINEPROTECTORPETROLStatus1="True";
                ENGINEPROTECTORDIESELStatus1="False";
            }else if (FuleType.equals("Diesel")){
                ENGINEPROTECTORPETROLStatus1="False";
                ENGINEPROTECTORDIESELStatus1="True";
            }else{
                ENGINEPROTECTORPETROLStatus1="False";
                ENGINEPROTECTORDIESELStatus1="False";
            }
            VoluntarydeductableSumInsured="500";
            BUILTINCNGKIT_LPGKITODStatus1="False";
            BUILTINCNGKIT_LPGKITTPStatus1="False";
            CNGLPGKITODStatus1="False";
            CNGLPGKITTPStatus1="False";
        }

        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("ProductName", ProductName);
            object.put("MobileNo", str_edt_phone);
            object.put("UserEmail", str_edt_email);
            object.put("UserName", strName);
            object.put("RegistrationNumber",strVehicleNo);
            object.put("ProductCode", ProductCode);
            object.put("Product", "");
            object.put("BusinessType", strPolicyRadio);
            object.put("VehicleClassCode", VehicleClassCode);
            object.put("VehicleMakeCode", strVehicleManufacturerCode);
            object.put("YearofManufacture",yearOfManufacture);
            object.put("VehicleType", strVehicleRadio);
            object.put("CubicCapacity", strVehicleCubicCapicity);
            object.put("NumberOfWheels", "");
            object.put("ChassisNumber", strVehicleChasisNumber);
            object.put("EngineNumber", strVehicleEngineNumber);
            object.put("VehicleAge", strVehicleAge);
            object.put("VehicleModelCode", strVehicleModelCode);
            object.put("RTOLocationCode", strRTOCode);
            object.put("GrossVehicleWeight", "0");
            object.put("PlaceOfRegistration",strRTOName);
            object.put("VehicleModel", strVehicleModel);
            object.put("DateOfFirstRegistration", str_edt_registration_date);
            object.put("DateOfRegistration", str_edt_registration_date);
            object.put("City", strRTOName);
            object.put("SumInsured", "");
            object.put("IDV", IDV_new);
            object.put("FuelType", FuleType);
            object.put("VehicleMake",str_vehicleManufacturerNm);
            object.put("Fromdate", today);
            object.put("Todate", nextYear);
            object.put("NCB", "0");
            object.put("BasicODStatus","True");
            object.put("ELECTRICALACCESSORYODStatus", "True");
            object.put("ELECTRICALACCESSORYODSumInsured", "1000");
            object.put("NONELECTRICALACCESSORYODStatus", "True");
            object.put("NONELECTRICALACCESSORYODSumInsured", "1000");
            object.put("BasicTP","True");
            object.put("PACOVERTOEMPLOYEESOFINSUREDStatus", "False");
            object.put("PACOVERTOPASSENGERSStatus", "True");
            object.put("PACOVERTOPASSENGERSSumInsured", "50000");
            object.put("PACOVERTOPAIDDRIVERStatus", "True");
            object.put("PACOVERTOPAIDDRIVERSumInsured", "50000");
            object.put("OtherTPStatus", "True");
            object.put("FIBERTANKODStatus", "True");
            object.put("OtherODStatus", "True");
            object.put("UNNAMEDPACOVERTOPASSENGERSStatus", "True");
            object.put("UNNAMEDPACOVERTOPASSENGERSSumInsured", "50000");
            object.put("PACOVERTOOWNERDRIVERStatus", "True");
            object.put("CNGLPGKITODStatus", CNGLPGKITODStatus1);
            object.put("CNGLPGKITODSumInsured", "1000");
            object.put("CNGLPGKITTPStatus", CNGLPGKITTPStatus1);
            object.put("BUILTINCNGKIT_LPGKITODStatus", BUILTINCNGKIT_LPGKITODStatus1);
            object.put("MANUFACTURERSELLINGPRICEStatus", MANUFACTURERSELLINGPRICEStatus1);
            object.put("BUILTINCNGKIT_LPGKITTPStatus", BUILTINCNGKIT_LPGKITTPStatus1);
            object.put("DRIVINGTRAINPROTECTStatus", DRIVINGTRAINPROTECTStatus1);
            object.put("LEGALLIABILITYTOPAIDDRIVERStatus", "True");
            object.put("RoadsideAssistanceStatus", "True");
            object.put("NilDepreciationWaivercoverStatus", NilDepreciationWaivercoverStatus1);
            object.put("DAILYCASHALLOWANCENONMETROStatus", DAILYCASHALLOWANCENONMETROStatus1);
            object.put("DAILYCASHALLOWANCEMETROStatus", DAILYCASHALLOWANCEMETROStatus1);
            object.put("KEYREPLACEMENTStatus", KEYREPLACEMENTStatus1);
            object.put("RETURNTOINVOICEStatus", RETURNTOINVOICEStatus1);
            object.put("ACCIDENTALHOSPITALIZATIONStatus", ACCIDENTALHOSPITALIZATIONStatus1);
            object.put("HYDROSTATICLOCKCOVERStatus", HYDROSTATICLOCKCOVERStatus1);
            object.put("COSTOFCONSUMABLESStatus", COSTOFCONSUMABLESStatus1);
            object.put("SECURETOWINGStatus", SECURETOWINGStatus1);
            object.put("TyreandRimsecureStatus", TyreandRimsecureStatus1);
            object.put("ENGINEPROTECTORPETROLStatus", ENGINEPROTECTORPETROLStatus1);
            object.put("ENGINEPROTECTORDIESELStatus", ENGINEPROTECTORDIESELStatus1);
            object.put("WRONGFUELCOVERStatus", WRONGFUELCOVERStatus1);
            object.put("DetariffLoadingStatus", "True");
            object.put("DetariffDiscountStatus", "True");
            object.put("AntitheftdevicediscountStatus", "False");
            object.put("AntitheftdevicediscountSumInsured", "");
            object.put("AutomobileAssociationdiscountStatus", "False");
            object.put("AutomobileAssociationdiscountSumInsured", "");
            object.put("VoluntarydeductableStatus", "True");
            object.put("VoluntarydeductableSumInsured", VoluntarydeductableSumInsured);
            object.put("VoluntarydeductableDiscountAmount", VoluntarydeductableDiscountAmount);
            object.put("TPPDDiscountStatus", "False");
            object.put("TPPDDiscountSumInsured", "6000");
            object.put("HandicapDiscountStatus", "False");
            object.put("HandicapDiscountSumInsured", "1000");
            object.put("DAILYCASHALLOWANCEStatus", DAILYCASHALLOWANCEStatus1);
            object.put("NCBStatus", "True");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_AddOns.this, object, UrlConstants.BUY_VehicleMotorQuotation, new ResponseListener()
        {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    if (Tag == RequestConstants.BUY_POLICY_MOTOR_PRIVATE_Quotation) {
                        try {
                            JSONObject ErrorsJsonObject = object.getJSONObject("Errors");
                            String ErrDescription = ErrorsJsonObject.getString("ErrDescription");
                            String ErrorCode = ErrorsJsonObject.getString("ErrorCode");
                            if (ErrorCode.equals("0")){
                            }else{
                                final Dialog alert_dialog = new Dialog(Motor_AddOns.this);
                                alert_dialog.setCanceledOnTouchOutside(false);
                                alert_dialog.setCancelable(false);
                                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                                alert_dialog.setContentView(R.layout.rti_dialog_motor);
                                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                                lp.copyFrom(alert_dialog.getWindow().getAttributes());
                                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                                lp.gravity = Gravity.CENTER;

                                TextView ok_dialog,KnowMoreText,error;
                                KnowMoreText = alert_dialog.findViewById(R.id.KnowMoreText);
                                error = alert_dialog.findViewById(R.id.error);
                                ok_dialog = alert_dialog.findViewById(R.id.ok_dialog);
                                KnowMoreText.setVisibility(View.GONE);
                                alert_dialog.show();
                                ok_dialog.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        RETURNTOINVOICEStatus1="False";
                                        VehicleMotorAddOnsQuotation();
                                        VehicleMotorQuotation();
                                        alert_dialog.dismiss();
                                    }
                                });

                                }
                            JSONObject CustomerJsonObject = object.getJSONObject("Customer");
                            JSONObject ProductJsonObject = object.getJSONObject("Product");
                            Log.e("ProductJsonObject",ProductJsonObject.toString());
                            JSONObject RisksDataJsonObject = ProductJsonObject.getJSONObject("Risks");
                            JSONObject RiskDataJsonObject = RisksDataJsonObject.getJSONObject("Risk");
                            Log.e("RiskDataJsonObject",RiskDataJsonObject.toString());

                            JSONObject RisksDatasJsonObject = RiskDataJsonObject.getJSONObject("RisksData");
                            Log.e("RisksDatasJsonObject",RisksDatasJsonObject.toString());

                            JSONObject DetariffDiscountsJsonObject = RisksDatasJsonObject.getJSONObject("DetariffDiscounts");
                            Log.e("DetariffDiscountsJsonObject",DetariffDiscountsJsonObject.toString());
                            JSONObject DetariffDiscountGroupJsonObject = DetariffDiscountsJsonObject.getJSONObject("DetariffDiscountGroup");
                            Log.e("DetariffDiscountGroupJsonObject",DetariffDiscountGroupJsonObject.toString());

                            JSONObject DetariffLoadingsJsonObject = RisksDatasJsonObject.getJSONObject("DetariffLoadings");
                            Log.e("DetariffLoadingsJsonObject",DetariffLoadingsJsonObject.toString());

                            JSONObject DetariffLoadingGroupJsonObject = DetariffLoadingsJsonObject.getJSONObject("DetariffLoadingGroup");
                            Log.e("DetariffLoadingGroupJsonObject",DetariffLoadingGroupJsonObject.toString());

                            JSONObject AddonCoverDetailsJsonObject = RisksDatasJsonObject.getJSONObject("AddonCoverDetails");
                            Log.e("AddonCoverDetailsJsonObject",AddonCoverDetailsJsonObject.toString());
                            JSONObject AddonCoversJsonObject = AddonCoverDetailsJsonObject.getJSONObject("AddonCovers");
                            Log.e("AddonCoversJsonObject",AddonCoversJsonObject.toString());
                            JSONArray AddonCoversDataJsonObject = AddonCoversJsonObject.getJSONArray("AddonCoversData");
                            Log.e("AddonCoversDataJsonObject",AddonCoversDataJsonObject.toString());

                            JSONObject CoverDetailsJsonObject = RisksDatasJsonObject.getJSONObject("CoverDetails");
                            Log.e("CoverDetailsJsonObject",CoverDetailsJsonObject.toString());
                            JSONObject CoversJsonObject = CoverDetailsJsonObject.getJSONObject("Covers");
                            Log.e("CoversJsonObject",CoversJsonObject.toString());
                            JSONArray CoversDataJsonObject = CoversJsonObject.getJSONArray("CoversData");
                            Log.e("CoversDataJsonObject",CoversDataJsonObject.toString());

                            JSONObject PremiumCalculationJsonObject = ProductJsonObject.getJSONObject("PremiumCalculation");
                            Log.e("PremiumCalculationJsonObject",PremiumCalculationJsonObject.toString());
                            JSONObject NetPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("NetPremium");
                            Log.e("NetPremiumJsonObject",NetPremiumJsonObject.toString());
                            JSONObject TotalPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("TotalPremium");
                            Log.e("TotalPremiumJsonObject",TotalPremiumJsonObject.toString());
                            JSONObject ServiceTaxJsonObject = PremiumCalculationJsonObject.getJSONObject("ServiceTax");
                            Log.e("ServiceTaxJsonObject",ServiceTaxJsonObject.toString());
                            JSONObject VehicleExShowroomPriceJsonObject = RisksDataJsonObject.getJSONObject("VehicleExShowroomPrice");
                            Log.e("VehicleExShowroomPriceJsonObject",VehicleExShowroomPriceJsonObject.toString());
                            JSONObject VehicleIDVJsonObject = RisksDataJsonObject.getJSONObject("VehicleIDV");
                            Log.e("VehicleIDVJsonObject",VehicleIDVJsonObject.toString());
                            JSONObject OtherDiscountsJsonObject = RisksDatasJsonObject.getJSONObject("OtherDiscounts");
                            JSONObject OtherDiscountGroupJsonObject = OtherDiscountsJsonObject.getJSONObject("OtherDiscountGroup");
                            JSONArray OtherDiscountGroupDataJsonObject = OtherDiscountGroupJsonObject.getJSONArray("OtherDiscountGroupData");
                            JSONObject DetariffDiscountGroupData = DetariffDiscountGroupJsonObject.getJSONObject("DetariffDiscountGroupData");
                            JSONObject DetariffLoadingGroupData = DetariffLoadingGroupJsonObject.getJSONObject("DetariffLoadingGroupData");
                            VehicleExShowroomPrice = VehicleExShowroomPriceJsonObject.getString("Value");
                            strIdvValueTxt1 = VehicleIDVJsonObject.getString("Value");

                            if (!CheckString.equals("1")&&!ChangeAddons.equals("1")){
                                if (!strIdvValueTxt1.equals("")){
                                    float AllIDV= Float.parseFloat(strIdvValueTxt1);
                                    int a = Math.round(AllIDV);
                                    strIdvValueTxt=String.valueOf(a);
                                    int lest= a*10/100;
                                    strLessIDVText= String.valueOf(a-lest);
                                    strHighIDVText= String.valueOf(lest+a);
                                    IdvValueTxt.setText(strIdvValueTxt);
                                    lessIDVText.setText(strLessIDVText);
                                    HighIDVText.setText(strHighIDVText);
                                    IDVTotalPremium.setText(strIdvValueTxt);
                                    Log.e("strLessIDVText",strLessIDVText);
                                    Log.e("strHighIDVText",strHighIDVText);
                                }
                                else{
                                    strIdvValueTxt1="0.0";
                                    IdvValueTxt.setText(strIdvValueTxt1);
                                    float lest= Float.parseFloat(strIdvValueTxt1)*10/100;
                                    strLessIDVText= String.valueOf(Float.parseFloat(strIdvValueTxt1)-lest);
                                    strHighIDVText= String.valueOf(lest+Float.parseFloat(strIdvValueTxt1));
                                    lessIDVText.setText(strLessIDVText);
                                    HighIDVText.setText(strHighIDVText);
                                }
                            }
                            if(ChangeAddons.equals("0")){
                                JSONObject DetarifficDescription = DetariffDiscountGroupData.getJSONObject("Description");
                                String DetarifficValue = DetarifficDescription.getString("Value");
                                if (DetarifficValue.equals("De-tariff Discount")) {
                                    DetarifficValuePremium = DetariffDiscountGroupData.getJSONObject("Premium").getString("Value");
                                    DetarifficValueRate = DetariffDiscountGroupData.getJSONObject("Rate").getString("Value");
                                    if (!DetarifficValuePremium.equals("")){
                                        DetarifficValuePremiumDouble= Double.parseDouble(DetarifficValuePremium);
                                        StrDetarifficValuePremiumDouble= String.valueOf(DetarifficValuePremiumDouble);
                                        Log.e("DetarifficValuePremium",DetarifficValuePremium);
                                    }else{
                                        DetarifficValuePremium="0.0";
                                    }
                                }

                                JSONObject DeTariffLoadingDescription = DetariffLoadingGroupData.getJSONObject("Description");
                                String DetarifficLodingValue = DeTariffLoadingDescription.getString("Value");
                                if (DetarifficLodingValue.equals("De -tariff Loading")) {
                                    DetarifficLodingValuePremium = DetariffLoadingGroupData.getJSONObject("Premium").getString("Value");
                                    DetarifficLoadingValueRate = DetariffLoadingGroupData.getJSONObject("Rate").getString("Value");
                                    if (!DetarifficLodingValuePremium.equals("")){
                                        DetarifficLoadingValuePremiumDouble= Double.parseDouble(DetarifficLodingValuePremium);
                                        StrDetarifficLoadingValuePremiumDouble= String.valueOf(DetarifficLoadingValuePremiumDouble);
                                        Log.e("StrDetarifficLoadingValuePremiumDouble",StrDetarifficLoadingValuePremiumDouble);
                                    }else{
                                        DetarifficLodingValuePremium="0.0";
                                    }
                                }

                                for (int n=0; n <CoversDataJsonObject.length();n++) {
                                    JSONObject CoverGroupsJson = CoversDataJsonObject.getJSONObject(n).optJSONObject("CoverGroups");
                                    Log.e("CoverGroupsJson", CoverGroupsJson.toString());

                                    String CoversValue = CoverGroupsJson.getString("Value");
                                    if (CoversValue.equals("Basic OD")) {
                                        BasicODCardView.setVisibility(View.GONE);
                                        AdditionalCoverBasicOdPremium = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
                                        BasicODRateValue = CoversDataJsonObject.getJSONObject(n).optJSONObject("Rate").getString("Value");
                                        BasicODRateSumInsured = CoversDataJsonObject.getJSONObject(n).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverBasicOdPremium.equals("")){
                                            AdditionalCoverPremiumOD= Double.parseDouble(AdditionalCoverBasicOdPremium);
                                            StrAdditionalCoverPremiumOD= String.valueOf(AdditionalCoverPremiumOD);
                                            Log.e("AdditionalCoverPremiumOD",AdditionalCoverBasicOdPremium);
                                            if (!AdditionalCoverBasicOdPremium.equals("0.00")) {
                                                BasicODCardView.setVisibility(View.GONE);
                                                BasicODPremiumTxt.setText(AdditionalCoverBasicOdPremium);
                                            } else {
                                                BasicODCardView.setVisibility(View.GONE);
                                                BasicODPremiumTxt.setText(AdditionalCoverBasicOdPremium);
                                            }
                                        }else{
                                            BasicODCardView.setVisibility(View.GONE);
                                            AdditionalCoverBasicOdPremium="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("Basic TP")) {
                                        BasicTPCardView.setVisibility(View.GONE);
                                        AdditionalBasicTpCoverPremium = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
                                        BasicTpRateValue = CoversDataJsonObject.getJSONObject(n).optJSONObject("Rate").getString("Value");
                                        BasicTpRateSumInsured = CoversDataJsonObject.getJSONObject(n).optJSONObject("SumInsured").getString("Value");
                                        Log.e("AdditionalCoverPremiumTp",AdditionalBasicTpCoverPremium);
                                        if (!AdditionalBasicTpCoverPremium.equals("")){
                                            AdditionalCoverPremiumTP= Double.parseDouble(AdditionalBasicTpCoverPremium);
                                            StrAdditionalCoverPremiumTp= String.valueOf(AdditionalCoverPremiumTP);
                                            Log.e("AdditionalCoverPremiumTP",AdditionalBasicTpCoverPremium);
                                            if (!AdditionalBasicTpCoverPremium.equals("0.00")) {
                                                BasicTPCardView.setVisibility(View.GONE);
                                                BasicTPPremiumTxt.setText(AdditionalBasicTpCoverPremium);
                                            } else {
                                                BasicTPCardView.setVisibility(View.GONE);
                                                BasicTPPremiumTxt.setText(AdditionalBasicTpCoverPremium);
                                            }
                                        }else{
                                            BasicTPCardView.setVisibility(View.GONE);
                                            AdditionalBasicTpCoverPremium="0.0";
                                        }
                                    }
                                    else if (CoversValue.equals("ELECTRICAL ACCESSORY OD")) {
                                        AdditionalCoverPremiumElectrical = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                             ELECTRICALCoverSumInsured = CoversDataJsonObject.getJSONObject(n).optJSONObject("SumInsured").getString("Value");
//                                        AdditionalElectricalRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        if (!AdditionalCoverPremiumElectrical.equals("")){
//                                            AdditionalCoverPremiumEl= Double.parseDouble(AdditionalCoverPremium);
                                            Log.e("AdditionalCoverPremiumElectrical",AdditionalCoverPremiumElectrical);
                                            if (!AdditionalCoverPremiumElectrical.equals("0.00")) {
                                                ElectricalCardView.setVisibility(View.VISIBLE);
//                                                     ElectricalPremiumTxt.setText(AdditionalCoverPremium);
                                            } else {
                                                ElectricalCardView.setVisibility(View.GONE);
                                                ElectricalPremiumTxt.setText(AdditionalCoverPremiumElectrical);
                                            }
                                        }else{
                                            ElectricalCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumElectrical="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("FIBERTANK OD")) {
                                        AdditionalCoverPremiumFiberTank = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalFibertankODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        if (!AdditionalCoverPremiumFiberTank.equals("")){
                                            AdditionalCoverPremiumFI= Double.parseDouble(AdditionalCoverPremiumFiberTank);
                                            if (!AdditionalCoverPremiumFiberTank.equals("0.00")) {
                                                FIBERTANKODCardView.setVisibility(View.VISIBLE);
                                                FIBERTANKPremiumTxt.setText(AdditionalCoverPremiumFiberTank);
                                            } else {
                                                FIBERTANKODCardView.setVisibility(View.GONE);
                                                FIBERTANKPremiumTxt.setText(AdditionalCoverPremiumFiberTank);
                                            }
                                        }else{
                                            FIBERTANKODCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumFiberTank="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("LEGAL LIABILITY TO PAID DRIVER")) {
                                        AdditionalCoverPremiumPaidDriver = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalLegalLiabilityDriverRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        if (!AdditionalCoverPremiumPaidDriver.equals("")){
                                            AdditionalCoverPremiumLegal= Double.parseDouble(AdditionalCoverPremiumPaidDriver);
                                            if (!AdditionalCoverPremiumPaidDriver.equals("0.00")) {
                                                LegalLiabilityCardView.setVisibility(View.VISIBLE);
                                                LegalPremiumTxt.setText(AdditionalCoverPremiumPaidDriver);
                                            } else {
                                                LegalLiabilityCardView.setVisibility(View.GONE);
                                                LegalPremiumTxt.setText(AdditionalCoverPremiumPaidDriver);
                                            }
                                        }else{
                                            LegalLiabilityCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumPaidDriver="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("NON ELECTRICAL ACCESSORY OD")) {
                                        AdditionalCoverPremiumNonElectrical = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                             NONELECTRICALSumInsured = CoversDataJsonObject.getJSONObject(n).optJSONObject("SumInsured").getString("Value");
//                                        AdditionalNonElecticalODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumNonElectrical.equals("")){
//                                            AdditionalCoverPremiumNon= Double.parseDouble(AdditionalCoverPremium);
                                            if (!AdditionalCoverPremiumNonElectrical.equals("0.00")) {
                                                NonLegalLiabilityCardView.setVisibility(View.VISIBLE);
//                                                     NonElectricalPremiumTxt.setText(AdditionalCoverPremium);
                                            } else {
                                                NonLegalLiabilityCardView.setVisibility(View.GONE);
                                                NonElectricalPremiumTxt.setText(AdditionalCoverPremiumNonElectrical);
                                            }
                                        }else{
                                            NonLegalLiabilityCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumNonElectrical="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("Other OD")) {
                                        AdditionalCoverPremiumCoverOtherOD = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalOtherODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumCoverOtherOD.equals("")){
                                            AdditionalCoverPremiumOtherOD= Double.parseDouble(AdditionalCoverPremiumCoverOtherOD);
                                            if (!AdditionalCoverPremiumCoverOtherOD.equals("0.00")) {
                                                OtherOdCardView.setVisibility(View.VISIBLE);
                                                OtherOdPremiumTxt.setText(AdditionalCoverPremiumCoverOtherOD);
                                            } else {
                                                OtherOdCardView.setVisibility(View.GONE);
                                                OtherOdPremiumTxt.setText(AdditionalCoverPremiumCoverOtherOD);
                                            }
                                        }else{
                                            OtherOdCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCoverOtherOD="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("Other TP")) {
                                        AdditionalCoverPremiumCoverOtherTP = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalOtherTpRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        if (!AdditionalCoverPremiumCoverOtherTP.equals("")){
                                            AdditionalCoverPremiumOtherTP= Double.parseDouble(AdditionalCoverPremiumCoverOtherTP);
                                            if (!AdditionalCoverPremiumCoverOtherTP.equals("0.00")) {
                                                OtherTpCardView.setVisibility(View.VISIBLE);
                                                OtherTpPremiumTxt.setText(AdditionalCoverPremiumCoverOtherTP);
                                            } else {
                                                OtherTpCardView.setVisibility(View.GONE);
                                                OtherTpPremiumTxt.setText(AdditionalCoverPremiumCoverOtherTP);
                                            }
                                        }else{
                                            OtherTpCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCoverOtherTP="0.0";
                                        }
                                    }
//                                    else if (Value.equals("PA COVER TO EMPLOYEES OF INSURED")) {
//                                        AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
//                                        AdditionalPaCoversToEmployessRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
//                                        if (!AdditionalCoverPremium.equals("")){
//                                            AdditionalCoverPremiumPACOVER= Double.parseDouble(AdditionalCoverPremium);
//                                            if (!AdditionalCoverPremium.equals("0.00")) {
//                                                EMPLOYEESCardView.setVisibility(View.GONE);
//                                                EmployeesInsuredPremiumTxt.setText(AdditionalCoverPremium);
//                                            } else {
//                                                EMPLOYEESCardView.setVisibility(View.GONE);
//                                                EmployeesInsuredPremiumTxt.setText(AdditionalCoverPremium);
//                                            }
//                                        }else{
//                                            EMPLOYEESCardView.setVisibility(View.GONE);
//                                            AdditionalCoverPremium="0.0";
//                                        }
//
//                                    }

                                    else if (CoversValue.equals("PA COVER TO OWNER DRIVER")) {
                                        AdditionalCoverPremiumOwnerDriver = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
                                        AdditionalPaCoverToOwnerDriverRateValue = CoversDataJsonObject.getJSONObject(n).optJSONObject("Rate").getString("Value");
                                        if (strGPACover.equals("Yes")||strPACover.equals("Yes")){
                                            OwnerDriverCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumOwnerDriver="0.0";
                                            AdditionalCoverPremiumOWNERDRIVER= Double.parseDouble(AdditionalCoverPremiumOwnerDriver);
                                        }else{
                                            if (!AdditionalCoverPremiumOwnerDriver.equals("")){
                                                AdditionalCoverPremiumOWNERDRIVER= Double.parseDouble(AdditionalCoverPremiumOwnerDriver);
                                                if (!AdditionalCoverPremiumOwnerDriver.equals("0.00")) {
                                                    OwnerDriverCardView.setVisibility(View.GONE);
                                                    OwnerDriverPremiumTxt.setText(AdditionalCoverPremiumOwnerDriver);
                                                } else {
                                                    OwnerDriverCardView.setVisibility(View.GONE);
                                                    OwnerDriverPremiumTxt.setText(AdditionalCoverPremiumOwnerDriver);
                                                }
                                            }else{
                                                OwnerDriverCardView.setVisibility(View.GONE);
                                                AdditionalCoverPremiumOwnerDriver="0.0";
                                            }
                                        }
                                    }
                                    else if (CoversValue.equals("PA COVER TO PAID DRIVER")) {
                                        AdditionalCoverPremiumPaPaidDriver = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalPaidDriverRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        if (!AdditionalCoverPremiumPaPaidDriver.equals("")){
                                            AdditionalCoverPremiumPAIDDRIVER= Double.parseDouble(AdditionalCoverPremiumPaPaidDriver);
                                            if (!AdditionalCoverPremiumPaPaidDriver.equals("0.00")) {
                                                PaidDriverCardView.setVisibility(View.VISIBLE);

                                            } else {
                                                PaidDriverCardView.setVisibility(View.GONE);
                                                PaidDriverPremiumTxt.setText(AdditionalCoverPremiumPaPaidDriver);
                                            }
                                        }else{
                                            PaidDriverCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumPaPaidDriver="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("PA COVER TO PASSENGERS")) {
                                        AdditionalCoverPremiumPaPassenger = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalPaToPassengersRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumPaPassenger.equals("")){
                                            AdditionalCoverPremiumPASSENGERS= Double.parseDouble(AdditionalCoverPremiumPaPassenger);
                                            if (!AdditionalCoverPremiumPaPassenger.equals("0.00")) {
                                                PASSENGERSCardView.setVisibility(View.VISIBLE);
//                                                     PassengersPremiumTxt.setText(AdditionalCoverPremium);
                                            } else {
                                                PASSENGERSCardView.setVisibility(View.GONE);
                                                PassengersPremiumTxt.setText(AdditionalCoverPremiumPaPassenger);
                                            }
                                        }else{
                                            PASSENGERSCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumPaPassenger="0.0";
                                        }



                                    }
                                    else if (CoversValue.equals("UNNAMED PA COVER TO PASSENGERS")) {
                                        AdditionalCoverPremiumUnnamedPassenger = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalUnnamedPassengersRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumUnnamedPassenger.equals("")){
                                            AdditionalCoverPremiumUNNAMED= Double.parseDouble(AdditionalCoverPremiumUnnamedPassenger);
                                            if (!AdditionalCoverPremiumUnnamedPassenger.equals("0.00")) {
                                                UnnamedPassengerCardView.setVisibility(View.VISIBLE);

                                            } else {
                                                UnnamedPassengerCardView.setVisibility(View.GONE);
                                                UnnamedPassengersPremiumTxt.setText(AdditionalCoverPremiumUnnamedPassenger);
                                            }
                                        }else{
                                            UnnamedPassengerCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumUnnamedPassenger="0.0";
                                        }
                                    }
                                    else if (CoversValue.equals("CNGLPG KIT OD")) {
                                        AdditionalCoverPremiumCngLpgOd = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalCngKitODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumCngLpgOd.equals("")){
                                            AdditionalCoverPremiumCNGLPG= Double.parseDouble(AdditionalCoverPremiumCngLpgOd);
                                            if (!AdditionalCoverPremiumCngLpgOd.equals("0.00")) {
                                                CngStatusCardView.setVisibility(View.VISIBLE);
//                                                     CNGLPGKITODPremiumTxt.setText(AdditionalCoverPremium);
                                            }else{
                                                CngStatusCardView.setVisibility(View.GONE);
//                                                CNGLPGKITODPremiumTxt.setText(AdditionalCoverPremiumCngLpgOd);
                                            }
                                        }else{
                                            CngStatusCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCngLpgOd="0.0";
                                        }
                                    }
                                    else if (CoversValue.equals("CNGLPG KIT TP")) {
                                        AdditionalCoverPremiumCngLpgKitTp = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalCngLpgTpRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumCngLpgKitTp.equals("")){
                                            AdditionalCoverPremiumCNGLPGTP= Double.parseDouble(AdditionalCoverPremiumCngLpgKitTp);
                                            if (!AdditionalCoverPremiumCngLpgKitTp.equals("0.00")) {
                                                CNGLPGKITTPStatusCardView.setVisibility(View.VISIBLE);
//                                                CNGLPGKITTPPremiumTxt.setText(AdditionalCoverPremiumCngLpgKitTp);
                                            }else{
                                                CNGLPGKITTPStatusCardView.setVisibility(View.GONE);
//                                                CNGLPGKITTPPremiumTxt.setText(AdditionalCoverPremiumCngLpgKitTp);
                                            }
                                        }else{
                                            CNGLPGKITTPStatusCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCngLpgKitTp="0.0";
                                        }
                                    }
                                    else if (CoversValue.equals("BUILTIN CNGLPG KIT OD")) {
                                        AdditionalCoverPremiumBuiltingKitOD = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalBuiltinKitODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumBuiltingKitOD.equals("")){
                                            AdditionalCoverPremiumBUILTINOD= Double.parseDouble(AdditionalCoverPremiumBuiltingKitOD);
                                            if (!AdditionalCoverPremiumBuiltingKitOD.equals("0.00")) {
                                                BUILTINCNGKITCardView.setVisibility(View.VISIBLE);
//                                                BUILTINCNGKITPremiumTxt.setText(AdditionalCoverPremiumBuiltingKitOD);
                                            }else{
                                                BUILTINCNGKITCardView.setVisibility(View.GONE);
//                                                BUILTINCNGKITPremiumTxt.setText(AdditionalCoverPremiumBuiltingKitOD);
                                            }
                                        }else{
                                            BUILTINCNGKITCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumBuiltingKitOD="0.0";
                                        }
                                    }
                                    else if (CoversValue.equals("BUILTIN CNGLPG KIT TP")) {
                                        AdditionalCoverPremiumBultinKitTp = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalBuiltinCngTPRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        if (!AdditionalCoverPremiumBultinKitTp.equals("")){
                                            AdditionalCoverPremiumBuiltinCngLPGTp= Double.parseDouble(AdditionalCoverPremiumBultinKitTp);
                                            if (!AdditionalCoverPremiumBultinKitTp.equals("0.00")) {
                                                BuiltinCngLPGTpCardView.setVisibility(View.VISIBLE);
//                                                BuiltinCngLPGTpPremiumTxt.setText(AdditionalCoverPremiumBultinKitTp);
                                            }else{
                                                BuiltinCngLPGTpCardView.setVisibility(View.GONE);
//                                                BuiltinCngLPGTpPremiumTxt.setText(AdditionalCoverPremiumBultinKitTp);
                                            }
                                        }else{
                                            BuiltinCngLPGTpCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumBultinKitTp="0.0";
                                        }
                                    }
                                }
                                //    if (CoverGroupsJson.getString("Value").equals(Value)){
//                                    CoverGroupData.clear();
//                                    for (int i = 0; i < CoversDataJsonObject.length(); i++) {
//                                        String PremiumValue = CoversDataJsonObject.getJSONObject(i).optJSONObject("Premium").getString("Value");
//                                        if (!PremiumValue.equals("0.00")){
//                                            JSONObject CoverJsonPremium=CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium");
//                                            Log.e("CoverJsonPremium",CoverJsonPremium.toString());
//                                            CoverGroupData.add(
//                                                    new AdditionalCoverGroupModel(
//                                                            CoversDataJsonObject.getJSONObject(i).optJSONObject("CoverGroups").getString("Value"),
//                                                            CoversDataJsonObject.getJSONObject(i).optJSONObject("Premium").getString("Value")
//                                                    )
//                                            );
//                                        }
//                                        if (CoverGroupData.size() != 0) {
//                                            CoverAdditionalText.setVisibility(View.GONE);
//                                            additionalCoverRecyclerview.setVisibility(View.VISIBLE);
//                                            additionalCoverageRecy = new AdditionalCoverageRecy(Motor_AddOns.this,CoverGroupData);
//                                            additionalCoverRecyclerview.setLayoutManager(new LinearLayoutManager(Motor_AddOns.this,LinearLayoutManager.HORIZONTAL,false));
//                                            additionalCoverRecyclerview.setHasFixedSize(true);
//                                            additionalCoverRecyclerview.setAdapter(additionalCoverageRecy);
//
//                                        }else{
//                                            CoverAdditionalText.setVisibility(View.VISIBLE);
//                                            additionalCoverRecyclerview.setVisibility(View.GONE);
//                                        }
//
//
//                                    }
//                                }
                                for (int m=0; m <AddonCoversDataJsonObject.length();m++){
                                    JSONObject addOnCoverJson=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("AddonCoverGroups");
                                    Log.e("addOnCoverJson",addOnCoverJson.toString());
                                    String Value  = addOnCoverJson.getString("Value");
                                    Log.e("Value",Value);
                                    if (Value.equals("DAILY CASH ALLOWANCE")){
                                        PremiumValueDailyCash=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
                                        DailyCashRateSumInsured=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("SumInsured").getString("Value");
//                                           DailyCashRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueDailyCash.equals("")){
//                                            DailyCashAllowance= Double.parseDouble(PremiumValue);
                                            if (!PremiumValueDailyCash.equals("0.00")){
                                                DailCashAllownceCardView.setVisibility(View.GONE);
                                                DailyCashAllowancePremium.setText(PremiumValueDailyCash);
                                            }else{
                                                DailyCashAllowancePremium.setText(PremiumValueDailyCash);
                                                DailCashAllownceCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            DailCashAllownceCardView.setVisibility(View.GONE);
                                            PremiumValueDailyCash="0.0";
                                        }

                                    }
                                    else if (Value.equals("ACCIDENTAL HOSPITALIZATION")){
                                        PremiumValueAccidentalHospitalization=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        AccidentalRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueAccidentalHospitalization.equals("")){
                                            AdditionalHospitalization= Double.parseDouble(PremiumValueAccidentalHospitalization);
                                            if (!PremiumValueAccidentalHospitalization.equals("0.00")){
                                                AccidentalCardView.setVisibility(View.VISIBLE);
                                                AccidentalHospitalPremium.setText(PremiumValueAccidentalHospitalization);
                                            }else{
                                                AccidentalHospitalPremium.setText(PremiumValueAccidentalHospitalization);
                                                AccidentalCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            AccidentalCardView.setVisibility(View.GONE);
                                            PremiumValueAccidentalHospitalization="0.0";
                                        }

                                    }
                                    else if (Value.equals("WRONG FUEL COVER")){
                                        PremiumValueWrongFuelCover=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        WrongFuelRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueWrongFuelCover.equals("")){
                                            WrongFuelCover= Double.parseDouble(PremiumValueWrongFuelCover);
                                            if (!PremiumValueWrongFuelCover.equals("0.00")){
                                                WrongFuelCardView.setVisibility(View.VISIBLE);
                                                WrongFuelTxtPremium.setText(PremiumValueWrongFuelCover);
                                            }else{
                                                WrongFuelTxtPremium.setText(PremiumValueWrongFuelCover);
                                                WrongFuelCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            WrongFuelCardView.setVisibility(View.GONE);
                                            PremiumValueWrongFuelCover="0.0";
                                        }

                                    }
                                    else if (Value.equals("COST OF CONSUMABLES")){
                                        PremiumValueCostConsumables=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        CostOfConsumablesRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueCostConsumables.equals("")){
                                            AdditionalCostOfConsumbales= Double.parseDouble(PremiumValueCostConsumables);
                                            if (!PremiumValueCostConsumables.equals("0.00")){
                                                CostOfCardView.setVisibility(View.VISIBLE);
                                                CostOfConsumableNamePremium.setText(PremiumValueCostConsumables);
                                            }else{
                                                CostOfConsumableNamePremium.setText(PremiumValueCostConsumables);
                                                CostOfCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            CostOfCardView.setVisibility(View.GONE);
                                            PremiumValueCostConsumables="0.0";
                                        }
                                    }
                                    else if (Value.equals("DAILY CASH ALLOWANCE - METRO")){
                                        PremiumValueDailyCashMetro=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        dailyCashAllowanceMetroRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueDailyCashMetro.equals("")){
                                            AdditionalDailyCashMetro= Double.parseDouble(PremiumValueDailyCashMetro);
                                            if (!PremiumValueDailyCashMetro.equals("0.00")){
                                                DailyCashCardView.setVisibility(View.VISIBLE);
                                                DailyCashAllowanceNamePremium.setText(PremiumValueDailyCashMetro);
                                            }else{
                                                DailyCashAllowanceNamePremium.setText(PremiumValueDailyCashMetro);
                                                DailyCashCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            DailyCashCardView.setVisibility(View.GONE);
                                            PremiumValueDailyCashMetro="0.0";
                                        }


                                    }
                                    else if (Value.equals("DAILY CASH ALLOWANCE - NONMETRO")){
                                        PremiumValueNonMetro=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        dailyCashAllowanceNonMetroRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueNonMetro.equals("")){
                                            AdditionalDailCash= Double.parseDouble(PremiumValueNonMetro);
                                            if (!PremiumValueNonMetro.equals("0.00")){
                                                DailyCardView.setVisibility(View.VISIBLE);
                                                DailyCashNonMetroPremium.setText(PremiumValueNonMetro);
                                            }else{
                                                DailyCashNonMetroPremium.setText(PremiumValueNonMetro);
                                                DailyCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            PremiumValueNonMetro="0.0";
                                            DailyCardView.setVisibility(View.GONE);
                                        }

                                    }
                                    else if (Value.equals("ENGINE PROTECTOR - DIESEL")){
                                        PremiumValueEngineProtecterDiesel=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        EngineProtectorDieselRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueEngineProtecterDiesel.equals("")){
                                            AdditionalEngineDisesel= Double.parseDouble(PremiumValueEngineProtecterDiesel);
                                            if (!PremiumValueEngineProtecterDiesel.equals("0.00")){
                                                EngineProtectorCardView.setVisibility(View.VISIBLE);
                                                EngineProtectorDieselPremium.setText(PremiumValueEngineProtecterDiesel);
                                            }else{
                                                EngineProtectorDieselPremium.setText(PremiumValueEngineProtecterDiesel);
                                                EngineProtectorCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            EngineProtectorCardView.setVisibility(View.GONE);
                                            PremiumValueEngineProtecterDiesel="0.0";
                                        }
                                    }
                                    else if (Value.equals("ENGINE PROTECTOR - PETROL")){
                                        PremiumValueEngineProtecterPetrol=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        EngineProtectorPetrolRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueEngineProtecterPetrol.equals("")){
                                            AdditionalEnginePetrol= Double.parseDouble(PremiumValueEngineProtecterPetrol);
                                            if (!PremiumValueEngineProtecterPetrol.equals("0.00")){
                                                EngineCardView.setVisibility(View.VISIBLE);
                                                EngineProtectorPetrolPremium.setText(PremiumValueEngineProtecterPetrol);
                                            }else{
                                                EngineProtectorPetrolPremium.setText(PremiumValueEngineProtecterPetrol);
                                                EngineCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            EngineCardView.setVisibility(View.GONE);
                                            PremiumValueEngineProtecterPetrol="0.0";
                                        }

                                    }
                                    else if (Value.equals("HYDROSTATIC LOCK COVER")){
                                        PremiumValueHydrostaticLockDriver=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        HydrostaticLockRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueHydrostaticLockDriver.equals("")){
                                            AdditionalHydrosaticLock= Double.parseDouble(PremiumValueHydrostaticLockDriver);
                                            if (!PremiumValueHydrostaticLockDriver.equals("0.00")){
                                                HydrostaticeCardView.setVisibility(View.VISIBLE);
                                                HydrostaticeLockcoverPremium.setText(PremiumValueHydrostaticLockDriver);
                                            }else{
                                                HydrostaticeLockcoverPremium.setText(PremiumValueHydrostaticLockDriver);
                                                HydrostaticeCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            HydrostaticeCardView.setVisibility(View.GONE);
                                            PremiumValueHydrostaticLockDriver="0.0";
                                        }

                                    }
                                    else if (Value.equals("KEY REPLACEMENT")){
                                        PremiumValueKeyReplacement=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        KeyReplacementRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueKeyReplacement.equals("")){
                                            AdditionalKeyReplacement= Double.parseDouble(PremiumValueKeyReplacement);
                                            if (!PremiumValueKeyReplacement.equals("0.00")){
                                                KeyReplacementCardView.setVisibility(View.VISIBLE);
                                                KeyReplacementPremium.setText(PremiumValueKeyReplacement);
                                            }else{
                                                KeyReplacementPremium.setText(PremiumValueKeyReplacement);
                                                KeyReplacementCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            KeyReplacementCardView.setVisibility(View.GONE);
                                            PremiumValueKeyReplacement="0.0";
                                        }

                                    }
                                    else if (Value.equals("Nil Depreciation Waiver cover")){
                                        PremiumValueNilDepreciation=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        NilDepreciationRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueNilDepreciation.equals("")){
                                            AdditionalNilDepreciation= Double.parseDouble(PremiumValueNilDepreciation);
                                            if (!PremiumValueNilDepreciation.equals("0.00")){
                                                NilCardView.setVisibility(View.VISIBLE);
                                                NilDepreciationWaivercoverNamePremium.setText(PremiumValueNilDepreciation);
                                            }else{
                                                NilDepreciationWaivercoverNamePremium.setText(PremiumValueNilDepreciation);
                                                NilCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            NilCardView.setVisibility(View.GONE);
                                            PremiumValueNilDepreciation="0.0";
                                        }

                                    }
                                    else if (Value.equals("RETURN TO INVOICE")){
                                        PremiumValueReturnToInvoice=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        ReturnToInvoiceRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueReturnToInvoice.equals("")){
                                            AdditionalReturnInvoice= Double.parseDouble(PremiumValueReturnToInvoice);
                                            if (!PremiumValueReturnToInvoice.equals("0.00")){
                                                ReturnToInvoiceCardView.setVisibility(View.VISIBLE);
                                                ReturnToInvoicePremium.setText(PremiumValueReturnToInvoice);
                                            }else{
                                                ReturnToInvoicePremium.setText(PremiumValueReturnToInvoice);
                                                ReturnToInvoiceCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            ReturnToInvoiceCardView.setVisibility(View.GONE);
                                            PremiumValueReturnToInvoice="0.0";
                                        }
                                    }
                                    else if (Value.equals("Road side Assistance")){
                                        PremiumValueRoadAssistance=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        RoadSideAssistanceRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueRoadAssistance.equals("")){
                                            AdditionalRoadSide= Double.parseDouble(PremiumValueRoadAssistance);
                                            if (!PremiumValueRoadAssistance.equals("0.00")){
                                                RoadsideAssistanceCardView.setVisibility(View.VISIBLE);
                                                RoadsideAssistancePremium.setText(PremiumValueRoadAssistance);
                                            }else{
                                                RoadsideAssistancePremium.setText(PremiumValueRoadAssistance);
                                                RoadsideAssistanceCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            RoadsideAssistanceCardView.setVisibility(View.GONE);
                                            PremiumValueRoadAssistance="0.0";
                                        }

                                    }
                                    else if (Value.equals("SECURE TOWING")){
                                        PremiumValueSecureTowing=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        SecureTowingRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueSecureTowing.equals("")){
                                            AdditionalsecureTowing= Double.parseDouble(PremiumValueSecureTowing);
                                            if (!PremiumValueSecureTowing.equals("0.00")){
                                                SecureTowingCardView.setVisibility(View.VISIBLE);
                                                SecureTowingPremium.setText(PremiumValueSecureTowing);
                                            }else{
                                                SecureTowingPremium.setText(PremiumValueSecureTowing);
                                                SecureTowingCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            SecureTowingCardView.setVisibility(View.GONE);
                                            PremiumValueSecureTowing="0.0";
                                        }

                                    }
                                    else if (Value.equals("Tyre and Rim secure")){
                                        PremiumValueTyreRim=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        TyreRimsecureRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueTyreRim.equals("")){
                                            AdditionalTyreRim= Double.parseDouble(PremiumValueTyreRim);
                                            if (!PremiumValueTyreRim.equals("0.00")){
                                                TyreCardView.setVisibility(View.VISIBLE);
                                                TyreAndRimSecurePremium.setText(PremiumValueTyreRim);
                                            }else{
                                                TyreAndRimSecurePremium.setText(PremiumValueTyreRim);
                                                TyreCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            TyreCardView.setVisibility(View.GONE);
                                            PremiumValueTyreRim="0.0";
                                        }
                                    }
                                    else if (Value.equals("MANUFACTURER SELLING PRICE")) {
                                        PremiumValueManufacturerSelling=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        ManufacturesellingRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueManufacturerSelling.equals("")){
                                            AdditionalCoverPremiumManufacturePrice= Double.parseDouble(PremiumValueManufacturerSelling);
                                            if (!PremiumValueManufacturerSelling.equals("0.00")) {
                                                ManufacturePriceSellingCardView.setVisibility(View.VISIBLE);
                                                ManufacturePricePremiumTxt.setText(PremiumValueManufacturerSelling);
                                            }else{
                                                ManufacturePricePremiumTxt.setText(PremiumValueManufacturerSelling);
                                                ManufacturePriceSellingCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            ManufacturePriceSellingCardView.setVisibility(View.GONE);
                                            PremiumValueManufacturerSelling="0.0";
                                        }
                                    }
                                    else if (Value.equals("DRIVING TRAIN PROTECT")){
                                        PremiumValueDrivinngTrain=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        drivingTrainProtectRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");

                                        if (!PremiumValueDrivinngTrain.equals("")){
                                            AdditionalDrivingTrainProtect= Double.parseDouble(PremiumValueDrivinngTrain);
                                            if (!PremiumValueDrivinngTrain.equals("0.00")){
                                                DrivingTrainProtectCardView.setVisibility(View.VISIBLE);
                                                DrivingTrainProtectPremium.setText(PremiumValueDrivinngTrain);
                                            }else{
                                                DrivingTrainProtectPremium.setText(PremiumValueDrivinngTrain);
                                                DrivingTrainProtectCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            DrivingTrainProtectCardView.setVisibility(View.GONE);
                                            PremiumValueDrivinngTrain="0.0";
                                        }
                                    }

//                                     if (addOnCoverJson.getString("Value").equals(Value)){
//                                         data1.clear();
//                                         for (int i = 0; i < AddonCoversDataJsonObject.length(); i++) {
//                                             String PremiumValueAddOn = AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("Premium").getString("Value");
//                                             if (!PremiumValueAddOn.equals("0.00")){
//                                                 JSONObject addOnCoverJsonPremium=AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("Premium");
//                                                 Log.e("addOnCoverJsonPremium",addOnCoverJsonPremium.toString());
//                                                 data1.add(
//                                                         new AddonCoverGroupsModel(
//                                                                 AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("AddonCoverGroups").getString("Value"),
//                                                                 AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("Premium").getString("Value")
//                                                         )
//                                                 );
//                                             }
//
//                                             if (data1.size() != 0) {
//                                                 CoverAddOnText.setVisibility(View.GONE);
//                                                 addOnCoverRecyclerview.setVisibility(View.VISIBLE);
//                                                 addOnCoverageRecy = new AddOnCoverageRecy(Motor_AddOns.this,data1);
//                                                 addOnCoverRecyclerview.setLayoutManager(new LinearLayoutManager(Motor_AddOns.this,LinearLayoutManager.HORIZONTAL,false));
//                                                 addOnCoverRecyclerview.setHasFixedSize(true);
//                                                 addOnCoverRecyclerview.setAdapter(addOnCoverageRecy);
//
//                                             }else{
//                                                 CoverAddOnText.setVisibility(View.VISIBLE);
//                                                 addOnCoverRecyclerview.setVisibility(View.GONE);
//                                             }
//
//
//                                         }
//                                     }
                                }

                                for (int l=0; l <OtherDiscountGroupDataJsonObject.length();l++) {
                                    JSONObject DescriptionJson = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Description");
                                    Log.e("DescriptionJson", DescriptionJson.toString());

                                    String DiscountValue = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Description").getString("Value");
                                    if (DiscountValue.equals("Antitheft device discount")) {
                                        strAntitheftdeviceDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        if (!strAntitheftdeviceDiscount.equals("")){
                                            if (!strAntitheftdeviceDiscount.equals("0.00")){
//                                                AntitheftdeviceCardView.setVisibility(View.VISIBLE);
                                                AntitheftdeviceCardView.setVisibility(View.GONE);
                                            }else{
                                                AntitheftdeviceCardView.setVisibility(View.GONE);
                                            }
                                            AntitheftPremiumTxt.setText(strAntitheftdeviceDiscount);
                                        }else{
                                            AntitheftdeviceCardView.setVisibility(View.GONE);
                                            strAntitheftdeviceDiscount="0.0";
                                        }

                                        Log.e("strAntitheftdevicediscount",strAntitheftdeviceDiscount);
                                    }else if (DiscountValue.equals("Automobile Association discount")) {
                                        AutomobileAssociationDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        if (!AutomobileAssociationDiscount.equals("")){
                                            if (!AutomobileAssociationDiscount.equals("0.00")){
//                                                AutomobileCardView.setVisibility(View.VISIBLE);
                                                AutomobileCardView.setVisibility(View.GONE);
                                            }else{
                                                AutomobileCardView.setVisibility(View.GONE);
                                            }
//                                                 AutomobilePremiumTxt.setText(AutomobileAssociationDiscount);
                                        }else{
                                            AutomobileCardView.setVisibility(View.GONE);
                                            AutomobileAssociationDiscount="0.0";
                                        }
                                        Log.e("AutomobileAssociationDiscount",AutomobileAssociationDiscount);

                                    } else if (DiscountValue.equals("Handicap Discount")) {
                                        StrHandicapDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        if (!StrHandicapDiscount.equals("")){
                                            if (!StrHandicapDiscount.equals("0.00")){
                                                HandicapDiscountCardView.setVisibility(View.GONE);
//                                                HandicapDiscountCardView.setVisibility(View.VISIBLE);
                                            }else{
                                                HandicapDiscountCardView.setVisibility(View.GONE);
                                            }
                                            HandicapPremiumTxt.setText(StrHandicapDiscount);
                                        }else{
                                            HandicapDiscountCardView.setVisibility(View.GONE);
                                            StrHandicapDiscount="0.0";
                                        }

                                        Log.e("StrHandicapDiscount",StrHandicapDiscount);

                                    } else if (DiscountValue.equals("TPPD Discount")) {
                                        StrTPPDDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        if (!StrTPPDDiscount.equals("")){
                                            if (!StrTPPDDiscount.equals("0.00")){
//                                                TPPDCardView.setVisibility(View.VISIBLE);
                                                TPPDCardView.setVisibility(View.GONE);
                                            }else{
                                                TPPDCardView.setVisibility(View.GONE);
                                            }
                                            TPPDPremiumTxt.setText(StrTPPDDiscount);
                                        }else{
                                            TPPDCardView.setVisibility(View.GONE);
                                            StrTPPDDiscount="0.0";
                                        }
                                        Log.e("StrTPPDDiscount",StrTPPDDiscount);

                                    }
                                    else if (DiscountValue.equals("Voluntary deductable")) {
                                        StrVotaryDeductablelun = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        if (!StrVotaryDeductablelun.equals("")){
                                            if (!(StrVotaryDeductablelun.equals("0.00"))){
                                                VotaryCardView.setVisibility(View.VISIBLE);
                                            }else{
                                                VotaryCardView.setVisibility(View.VISIBLE);
                                            }
                                            VotaryPremiumTxt.setText(StrVotaryDeductablelun);
                                        }else{
                                            VotaryCardView.setVisibility(View.GONE);
                                            StrVotaryDeductablelun="0.0";
                                        }
                                        Log.e("StrVotaryDeductablelun",StrVotaryDeductablelun);

                                    }
                                }
                            }
                            else{
                                JSONObject DetarifficDescription = DetariffDiscountGroupData.getJSONObject("Description");
                                String DetarifficValue = DetarifficDescription.getString("Value");
                                if (DetarifficValue.equals("De-tariff Discount")) {
                                    DetarifficValuePremium = DetariffDiscountGroupData.getJSONObject("Premium").getString("Value");
                                    DetarifficValueRate = DetariffDiscountGroupData.getJSONObject("Rate").getString("Value");
                                    if (!DetarifficValuePremium.equals("")){
                                        DetarifficValuePremiumDouble= Double.parseDouble(DetarifficValuePremium);
                                        StrDetarifficValuePremiumDouble= String.valueOf(DetarifficValuePremiumDouble);
                                        Log.e("DetarifficValuePremium",DetarifficValuePremium);
                                    }else{
                                        DetarifficValuePremium="0.0";
                                    }
                                }

                                JSONObject DeTariffLoadingDescription = DetariffLoadingGroupData.getJSONObject("Description");
                                String DetarifficLodingValue = DeTariffLoadingDescription.getString("Value");
                                if (DetarifficLodingValue.equals("De -tariff Loading")) {
                                    DetarifficLodingValuePremium = DetariffLoadingGroupData.getJSONObject("Premium").getString("Value");
                                    DetarifficLoadingValueRate = DetariffLoadingGroupData.getJSONObject("Rate").getString("Value");
                                    if (!DetarifficLodingValuePremium.equals("")){
                                        DetarifficLoadingValuePremiumDouble= Double.parseDouble(DetarifficLodingValuePremium);
                                        StrDetarifficLoadingValuePremiumDouble= String.valueOf(DetarifficLoadingValuePremiumDouble);
                                        Log.e("StrDetarifficLoadingValuePremiumDouble",StrDetarifficLoadingValuePremiumDouble);
                                    }else{
                                        DetarifficLodingValuePremium="0.0";
                                    }
                                }


                                for (int n=0; n <CoversDataJsonObject.length();n++) {
                                    JSONObject CoverGroupsJson = CoversDataJsonObject.getJSONObject(n).optJSONObject("CoverGroups");
                                    Log.e("CoverGroupsJson", CoverGroupsJson.toString());

                                    String CoversValue = CoverGroupsJson.getString("Value");
                                    if (CoversValue.equals("Basic OD")) {
                                        BasicODCardView.setVisibility(View.GONE);
                                        AdditionalCoverBasicOdPremium = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
                                        BasicODRateValue = CoversDataJsonObject.getJSONObject(n).optJSONObject("Rate").getString("Value");
                                        BasicODRateSumInsured = CoversDataJsonObject.getJSONObject(n).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverBasicOdPremium.equals("")){
                                            AdditionalCoverPremiumOD= Double.parseDouble(AdditionalCoverBasicOdPremium);
                                            StrAdditionalCoverPremiumOD= String.valueOf(AdditionalCoverPremiumOD);
                                            Log.e("AdditionalCoverPremiumOD",AdditionalCoverBasicOdPremium);
                                            if (!AdditionalCoverBasicOdPremium.equals("0.00")) {
                                                BasicODCardView.setVisibility(View.GONE);
                                                BasicODPremiumTxt.setText(AdditionalCoverBasicOdPremium);
                                            } else {
                                                BasicODCardView.setVisibility(View.GONE);
                                                BasicODPremiumTxt.setText(AdditionalCoverBasicOdPremium);
                                            }
                                        }else{
                                            BasicODCardView.setVisibility(View.GONE);
                                            AdditionalCoverBasicOdPremium="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("Basic TP")) {
                                        BasicTPCardView.setVisibility(View.GONE);
                                        AdditionalBasicTpCoverPremium = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
                                        BasicTpRateValue = CoversDataJsonObject.getJSONObject(n).optJSONObject("Rate").getString("Value");
                                        BasicTpRateSumInsured = CoversDataJsonObject.getJSONObject(n).optJSONObject("SumInsured").getString("Value");
                                        Log.e("AdditionalCoverPremiumTp",AdditionalBasicTpCoverPremium);
                                        if (!AdditionalBasicTpCoverPremium.equals("")){
                                            AdditionalCoverPremiumTP= Double.parseDouble(AdditionalBasicTpCoverPremium);
                                            StrAdditionalCoverPremiumTp= String.valueOf(AdditionalCoverPremiumTP);
                                            Log.e("AdditionalCoverPremiumTP",AdditionalBasicTpCoverPremium);
                                            if (!AdditionalBasicTpCoverPremium.equals("0.00")) {
                                                BasicTPCardView.setVisibility(View.GONE);
                                                BasicTPPremiumTxt.setText(AdditionalBasicTpCoverPremium);
                                            } else {
                                                BasicTPCardView.setVisibility(View.GONE);
                                                BasicTPPremiumTxt.setText(AdditionalBasicTpCoverPremium);
                                            }
                                        }else{
                                            BasicTPCardView.setVisibility(View.GONE);
                                            AdditionalBasicTpCoverPremium="0.0";
                                        }
                                    }
                                    else if (CoversValue.equals("ELECTRICAL ACCESSORY OD")) {
                                        AdditionalCoverPremiumElectrical = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                             ELECTRICALCoverSumInsured = CoversDataJsonObject.getJSONObject(n).optJSONObject("SumInsured").getString("Value");
//                                        AdditionalElectricalRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        if (!AdditionalCoverPremiumElectrical.equals("")){
//                                            AdditionalCoverPremiumEl= Double.parseDouble(AdditionalCoverPremium);
                                            Log.e("AdditionalCoverPremiumElectrical",AdditionalCoverPremiumElectrical);
                                            if (!AdditionalCoverPremiumElectrical.equals("0.00")) {
                                                ElectricalCardView.setVisibility(View.VISIBLE);
//                                                     ElectricalPremiumTxt.setText(AdditionalCoverPremium);
                                            } else {
                                                ElectricalCardView.setVisibility(View.GONE);
                                                ElectricalPremiumTxt.setText(AdditionalCoverPremiumElectrical);
                                            }
                                        }else{
                                            ElectricalCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumElectrical="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("FIBERTANK OD")) {
                                        AdditionalCoverPremiumFiberTank = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalFibertankODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        if (!AdditionalCoverPremiumFiberTank.equals("")){
                                            AdditionalCoverPremiumFI= Double.parseDouble(AdditionalCoverPremiumFiberTank);
                                            if (!AdditionalCoverPremiumFiberTank.equals("0.00")) {
                                                FIBERTANKODCardView.setVisibility(View.VISIBLE);
                                                FIBERTANKPremiumTxt.setText(AdditionalCoverPremiumFiberTank);
                                            } else {
                                                FIBERTANKODCardView.setVisibility(View.GONE);
                                                FIBERTANKPremiumTxt.setText(AdditionalCoverPremiumFiberTank);
                                            }
                                        }else{
                                            FIBERTANKODCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumFiberTank="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("LEGAL LIABILITY TO PAID DRIVER")) {
                                        AdditionalCoverPremiumPaidDriver = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalLegalLiabilityDriverRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        if (!AdditionalCoverPremiumPaidDriver.equals("")){
                                            AdditionalCoverPremiumLegal= Double.parseDouble(AdditionalCoverPremiumPaidDriver);
                                            if (!AdditionalCoverPremiumPaidDriver.equals("0.00")) {
                                                LegalLiabilityCardView.setVisibility(View.VISIBLE);
                                                LegalPremiumTxt.setText(AdditionalCoverPremiumPaidDriver);
                                            } else {
                                                LegalLiabilityCardView.setVisibility(View.GONE);
                                                LegalPremiumTxt.setText(AdditionalCoverPremiumPaidDriver);
                                            }
                                        }else{
                                            LegalLiabilityCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumPaidDriver="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("NON ELECTRICAL ACCESSORY OD")) {
                                        AdditionalCoverPremiumNonElectrical = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                             NONELECTRICALSumInsured = CoversDataJsonObject.getJSONObject(n).optJSONObject("SumInsured").getString("Value");
//                                        AdditionalNonElecticalODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumNonElectrical.equals("")){
//                                            AdditionalCoverPremiumNon= Double.parseDouble(AdditionalCoverPremium);
                                            if (!AdditionalCoverPremiumNonElectrical.equals("0.00")) {
                                                NonLegalLiabilityCardView.setVisibility(View.VISIBLE);
//                                                     NonElectricalPremiumTxt.setText(AdditionalCoverPremium);
                                            } else {
                                                NonLegalLiabilityCardView.setVisibility(View.GONE);
                                                NonElectricalPremiumTxt.setText(AdditionalCoverPremiumNonElectrical);
                                            }
                                        }else{
                                            NonLegalLiabilityCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumNonElectrical="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("Other OD")) {
                                        AdditionalCoverPremiumCoverOtherOD = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalOtherODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumCoverOtherOD.equals("")){
                                            AdditionalCoverPremiumOtherOD= Double.parseDouble(AdditionalCoverPremiumCoverOtherOD);
                                            if (!AdditionalCoverPremiumCoverOtherOD.equals("0.00")) {
                                                OtherOdCardView.setVisibility(View.VISIBLE);
                                                OtherOdPremiumTxt.setText(AdditionalCoverPremiumCoverOtherOD);
                                            } else {
                                                OtherOdCardView.setVisibility(View.GONE);
                                                OtherOdPremiumTxt.setText(AdditionalCoverPremiumCoverOtherOD);
                                            }
                                        }else{
                                            OtherOdCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCoverOtherOD="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("Other TP")) {
                                        AdditionalCoverPremiumCoverOtherTP = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalOtherTpRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        if (!AdditionalCoverPremiumCoverOtherTP.equals("")){
                                            AdditionalCoverPremiumOtherTP= Double.parseDouble(AdditionalCoverPremiumCoverOtherTP);
                                            if (!AdditionalCoverPremiumCoverOtherTP.equals("0.00")) {
                                                OtherTpCardView.setVisibility(View.VISIBLE);
                                                OtherTpPremiumTxt.setText(AdditionalCoverPremiumCoverOtherTP);
                                            } else {
                                                OtherTpCardView.setVisibility(View.GONE);
                                                OtherTpPremiumTxt.setText(AdditionalCoverPremiumCoverOtherTP);
                                            }
                                        }else{
                                            OtherTpCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCoverOtherTP="0.0";
                                        }
                                    }
//                                    else if (Value.equals("PA COVER TO EMPLOYEES OF INSURED")) {
//                                        AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
//                                        AdditionalPaCoversToEmployessRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
//                                        if (!AdditionalCoverPremium.equals("")){
//                                            AdditionalCoverPremiumPACOVER= Double.parseDouble(AdditionalCoverPremium);
//                                            if (!AdditionalCoverPremium.equals("0.00")) {
//                                                EMPLOYEESCardView.setVisibility(View.GONE);
//                                                EmployeesInsuredPremiumTxt.setText(AdditionalCoverPremium);
//                                            } else {
//                                                EMPLOYEESCardView.setVisibility(View.GONE);
//                                                EmployeesInsuredPremiumTxt.setText(AdditionalCoverPremium);
//                                            }
//                                        }else{
//                                            EMPLOYEESCardView.setVisibility(View.GONE);
//                                            AdditionalCoverPremium="0.0";
//                                        }
//
//                                    }

                                    else if (CoversValue.equals("PA COVER TO OWNER DRIVER")) {
                                        AdditionalCoverPremiumOwnerDriver = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
                                        AdditionalPaCoverToOwnerDriverRateValue = CoversDataJsonObject.getJSONObject(n).optJSONObject("Rate").getString("Value");
                                        if (strGPACover.equals("Yes")||strPACover.equals("Yes")){
                                            OwnerDriverCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumOwnerDriver="0.0";
                                            AdditionalCoverPremiumOWNERDRIVER= Double.parseDouble(AdditionalCoverPremiumOwnerDriver);
                                        }else{
                                            if (!AdditionalCoverPremiumOwnerDriver.equals("")){
                                                AdditionalCoverPremiumOWNERDRIVER= Double.parseDouble(AdditionalCoverPremiumOwnerDriver);
                                                if (!AdditionalCoverPremiumOwnerDriver.equals("0.00")) {
                                                    OwnerDriverCardView.setVisibility(View.GONE);
                                                    OwnerDriverPremiumTxt.setText(AdditionalCoverPremiumOwnerDriver);
                                                } else {
                                                    OwnerDriverCardView.setVisibility(View.GONE);
                                                    OwnerDriverPremiumTxt.setText(AdditionalCoverPremiumOwnerDriver);
                                                }
                                            }else{
                                                OwnerDriverCardView.setVisibility(View.GONE);
                                                AdditionalCoverPremiumOwnerDriver="0.0";
                                            }
                                        }
                                    }
                                    else if (CoversValue.equals("PA COVER TO PAID DRIVER")) {
                                        AdditionalCoverPremiumPaPaidDriver = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalPaidDriverRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        if (!AdditionalCoverPremiumPaPaidDriver.equals("")){
                                            AdditionalCoverPremiumPAIDDRIVER= Double.parseDouble(AdditionalCoverPremiumPaPaidDriver);
                                            if (!AdditionalCoverPremiumPaPaidDriver.equals("0.00")) {
                                                PaidDriverCardView.setVisibility(View.VISIBLE);

                                            } else {
                                                PaidDriverCardView.setVisibility(View.GONE);
                                                PaidDriverPremiumTxt.setText(AdditionalCoverPremiumPaPaidDriver);
                                            }
                                        }else{
                                            PaidDriverCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumPaPaidDriver="0.0";
                                        }

                                    }
                                    else if (CoversValue.equals("PA COVER TO PASSENGERS")) {
                                        AdditionalCoverPremiumPaPassenger = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalPaToPassengersRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumPaPassenger.equals("")){
                                            AdditionalCoverPremiumPASSENGERS= Double.parseDouble(AdditionalCoverPremiumPaPassenger);
                                            if (!AdditionalCoverPremiumPaPassenger.equals("0.00")) {
                                                PASSENGERSCardView.setVisibility(View.VISIBLE);
//                                                     PassengersPremiumTxt.setText(AdditionalCoverPremium);
                                            } else {
                                                PASSENGERSCardView.setVisibility(View.GONE);
                                                PassengersPremiumTxt.setText(AdditionalCoverPremiumPaPassenger);
                                            }
                                        }else{
                                            PASSENGERSCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumPaPassenger="0.0";
                                        }



                                    }
                                    else if (CoversValue.equals("UNNAMED PA COVER TO PASSENGERS")) {
                                        AdditionalCoverPremiumUnnamedPassenger = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalUnnamedPassengersRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumUnnamedPassenger.equals("")){
                                            AdditionalCoverPremiumUNNAMED= Double.parseDouble(AdditionalCoverPremiumUnnamedPassenger);
                                            if (!AdditionalCoverPremiumUnnamedPassenger.equals("0.00")) {
                                                UnnamedPassengerCardView.setVisibility(View.VISIBLE);

                                            } else {
                                                UnnamedPassengerCardView.setVisibility(View.GONE);
                                                UnnamedPassengersPremiumTxt.setText(AdditionalCoverPremiumUnnamedPassenger);
                                            }
                                        }else{
                                            UnnamedPassengerCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumUnnamedPassenger="0.0";
                                        }
                                    }
                                    else if (CoversValue.equals("CNGLPG KIT OD")) {
                                        AdditionalCoverPremiumCngLpgOd = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalCngKitODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumCngLpgOd.equals("")){
                                            AdditionalCoverPremiumCNGLPG= Double.parseDouble(AdditionalCoverPremiumCngLpgOd);
                                            if (!AdditionalCoverPremiumCngLpgOd.equals("0.00")) {
                                                CngStatusCardView.setVisibility(View.VISIBLE);
//                                                     CNGLPGKITODPremiumTxt.setText(AdditionalCoverPremium);
                                            }else{
                                                CngStatusCardView.setVisibility(View.GONE);
//                                                CNGLPGKITODPremiumTxt.setText(AdditionalCoverPremiumCngLpgOd);
                                            }
                                        }else{
                                            CngStatusCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCngLpgOd="0.0";
                                        }
                                    }
                                    else if (CoversValue.equals("CNGLPG KIT TP")) {
                                        AdditionalCoverPremiumCngLpgKitTp = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalCngLpgTpRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumCngLpgKitTp.equals("")){
                                            AdditionalCoverPremiumCNGLPGTP= Double.parseDouble(AdditionalCoverPremiumCngLpgKitTp);
                                            if (!AdditionalCoverPremiumCngLpgKitTp.equals("0.00")) {
                                                CNGLPGKITTPStatusCardView.setVisibility(View.VISIBLE);
//                                                CNGLPGKITTPPremiumTxt.setText(AdditionalCoverPremiumCngLpgKitTp);
                                            }else{
                                                CNGLPGKITTPStatusCardView.setVisibility(View.GONE);
//                                                CNGLPGKITTPPremiumTxt.setText(AdditionalCoverPremiumCngLpgKitTp);
                                            }
                                        }else{
                                            CNGLPGKITTPStatusCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCngLpgKitTp="0.0";
                                        }
                                    }
                                    else if (CoversValue.equals("BUILTIN CNGLPG KIT OD")) {
                                        AdditionalCoverPremiumBuiltingKitOD = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalBuiltinKitODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");

                                        if (!AdditionalCoverPremiumBuiltingKitOD.equals("")){
                                            AdditionalCoverPremiumBUILTINOD= Double.parseDouble(AdditionalCoverPremiumBuiltingKitOD);
                                            if (!AdditionalCoverPremiumBuiltingKitOD.equals("0.00")) {
                                                BUILTINCNGKITCardView.setVisibility(View.VISIBLE);
//                                                BUILTINCNGKITPremiumTxt.setText(AdditionalCoverPremiumBuiltingKitOD);
                                            }else{
                                                BUILTINCNGKITCardView.setVisibility(View.GONE);
                                                BUILTINCNGKITPremiumTxt.setText(AdditionalCoverPremiumBuiltingKitOD);
                                            }
                                        }else{
                                            BUILTINCNGKITCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumBuiltingKitOD="0.0";
                                        }
                                    }
                                    else if (CoversValue.equals("BUILTIN CNGLPG KIT TP")) {
                                        AdditionalCoverPremiumBultinKitTp = CoversDataJsonObject.getJSONObject(n).optJSONObject("Premium").getString("Value");
//                                        AdditionalBuiltinCngTPRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        if (!AdditionalCoverPremiumBultinKitTp.equals("")){
                                            AdditionalCoverPremiumBuiltinCngLPGTp= Double.parseDouble(AdditionalCoverPremiumBultinKitTp);
                                            if (!AdditionalCoverPremiumBultinKitTp.equals("0.00")) {
                                                BuiltinCngLPGTpCardView.setVisibility(View.VISIBLE);
//                                                BuiltinCngLPGTpPremiumTxt.setText(AdditionalCoverPremiumBultinKitTp);
                                            }else{
                                                BuiltinCngLPGTpCardView.setVisibility(View.GONE);
                                                BuiltinCngLPGTpPremiumTxt.setText(AdditionalCoverPremiumBultinKitTp);
                                            }
                                        }else{
                                            BuiltinCngLPGTpCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumBultinKitTp="0.0";
                                        }
                                    }
                                }

                                for (int m=0; m <AddonCoversDataJsonObject.length();m++){
                                    JSONObject addOnCoverJson=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("AddonCoverGroups");
                                    Log.e("addOnCoverJson",addOnCoverJson.toString());
                                    String Value  = addOnCoverJson.getString("Value");
                                    Log.e("Value",Value);
                                    if (Value.equals("DAILY CASH ALLOWANCE")){
                                        PremiumValueDailyCash=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
                                        DailyCashRateSumInsured=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("SumInsured").getString("Value");
//                                           DailyCashRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueDailyCash.equals("")){
//                                            DailyCashAllowance= Double.parseDouble(PremiumValue);
                                            if (!PremiumValueDailyCash.equals("0.00")){
                                                DailCashAllownceCardView.setVisibility(View.GONE);
                                                DailyCashAllowancePremium.setText(PremiumValueDailyCash);
                                            }else{
                                                DailyCashAllowancePremium.setText(PremiumValueDailyCash);
                                                DailCashAllownceCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            DailCashAllownceCardView.setVisibility(View.GONE);
                                            PremiumValueDailyCash="0.0";
                                        }

                                    }
                                    else if (Value.equals("ACCIDENTAL HOSPITALIZATION")){
                                        PremiumValueAccidentalHospitalization=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        AccidentalRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueAccidentalHospitalization.equals("")){
                                            AdditionalHospitalization= Double.parseDouble(PremiumValueAccidentalHospitalization);
                                            if (!PremiumValueAccidentalHospitalization.equals("0.00")){
                                                AccidentalCardView.setVisibility(View.VISIBLE);
                                                AccidentalHospitalPremium.setText(PremiumValueAccidentalHospitalization);
                                            }else{
                                                AccidentalHospitalPremium.setText(PremiumValueAccidentalHospitalization);
                                                AccidentalCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            AccidentalCardView.setVisibility(View.GONE);
                                            PremiumValueAccidentalHospitalization="0.0";
                                        }

                                    }
                                    else if (Value.equals("WRONG FUEL COVER")){
                                        PremiumValueWrongFuelCover=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        WrongFuelRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueWrongFuelCover.equals("")){
                                            WrongFuelCover= Double.parseDouble(PremiumValueWrongFuelCover);
                                            if (!PremiumValueWrongFuelCover.equals("0.00")){
                                                WrongFuelCardView.setVisibility(View.VISIBLE);
                                                WrongFuelTxtPremium.setText(PremiumValueWrongFuelCover);
                                            }else{
                                                WrongFuelTxtPremium.setText(PremiumValueWrongFuelCover);
                                                WrongFuelCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            WrongFuelCardView.setVisibility(View.GONE);
                                            PremiumValueWrongFuelCover="0.0";
                                        }

                                    }
                                    else if (Value.equals("COST OF CONSUMABLES")){
                                        PremiumValueCostConsumables=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        CostOfConsumablesRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueCostConsumables.equals("")){
                                            AdditionalCostOfConsumbales= Double.parseDouble(PremiumValueCostConsumables);
                                            if (!PremiumValueCostConsumables.equals("0.00")){
                                                CostOfCardView.setVisibility(View.VISIBLE);
                                                CostOfConsumableNamePremium.setText(PremiumValueCostConsumables);
                                            }else{
                                                CostOfConsumableNamePremium.setText(PremiumValueCostConsumables);
                                                CostOfCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            CostOfCardView.setVisibility(View.GONE);
                                            PremiumValueCostConsumables="0.0";
                                        }
                                    }
                                    else if (Value.equals("DAILY CASH ALLOWANCE - METRO")){
                                        PremiumValueDailyCashMetro=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        dailyCashAllowanceMetroRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueDailyCashMetro.equals("")){
                                            AdditionalDailyCashMetro= Double.parseDouble(PremiumValueDailyCashMetro);
                                            if (!PremiumValueDailyCashMetro.equals("0.00")){
                                                DailyCashCardView.setVisibility(View.VISIBLE);
                                                DailyCashAllowanceNamePremium.setText(PremiumValueDailyCashMetro);
                                            }else{
                                                DailyCashAllowanceNamePremium.setText(PremiumValueDailyCashMetro);
                                                DailyCashCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            DailyCashCardView.setVisibility(View.GONE);
                                            PremiumValueDailyCashMetro="0.0";
                                        }


                                    }
                                    else if (Value.equals("DAILY CASH ALLOWANCE - NONMETRO")){
                                        PremiumValueNonMetro=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        dailyCashAllowanceNonMetroRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueNonMetro.equals("")){
                                            AdditionalDailCash= Double.parseDouble(PremiumValueNonMetro);
                                            if (!PremiumValueNonMetro.equals("0.00")){
                                                DailyCardView.setVisibility(View.VISIBLE);
                                                DailyCashNonMetroPremium.setText(PremiumValueNonMetro);
                                            }else{
                                                DailyCashNonMetroPremium.setText(PremiumValueNonMetro);
                                                DailyCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            PremiumValueNonMetro="0.0";
                                            DailyCardView.setVisibility(View.GONE);
                                        }

                                    }
                                    else if (Value.equals("ENGINE PROTECTOR - DIESEL")){
                                        PremiumValueEngineProtecterDiesel=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        EngineProtectorDieselRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueEngineProtecterDiesel.equals("")){
                                            AdditionalEngineDisesel= Double.parseDouble(PremiumValueEngineProtecterDiesel);
                                            if (!PremiumValueEngineProtecterDiesel.equals("0.00")){
                                                EngineProtectorCardView.setVisibility(View.VISIBLE);
                                                EngineProtectorDieselPremium.setText(PremiumValueEngineProtecterDiesel);
                                            }else{
                                                EngineProtectorDieselPremium.setText(PremiumValueEngineProtecterDiesel);
                                                EngineProtectorCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            EngineProtectorCardView.setVisibility(View.GONE);
                                            PremiumValueEngineProtecterDiesel="0.0";
                                        }
                                    }
                                    else if (Value.equals("ENGINE PROTECTOR - PETROL")){
                                        PremiumValueEngineProtecterPetrol=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        EngineProtectorPetrolRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueEngineProtecterPetrol.equals("")){
                                            AdditionalEnginePetrol= Double.parseDouble(PremiumValueEngineProtecterPetrol);
                                            if (!PremiumValueEngineProtecterPetrol.equals("0.00")){
                                                EngineCardView.setVisibility(View.VISIBLE);
                                                EngineProtectorPetrolPremium.setText(PremiumValueEngineProtecterPetrol);
                                            }else{
                                                EngineProtectorPetrolPremium.setText(PremiumValueEngineProtecterPetrol);
                                                EngineCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            EngineCardView.setVisibility(View.GONE);
                                            PremiumValueEngineProtecterPetrol="0.0";
                                        }

                                    }
                                    else if (Value.equals("HYDROSTATIC LOCK COVER")){
                                        PremiumValueHydrostaticLockDriver=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        HydrostaticLockRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueHydrostaticLockDriver.equals("")){
                                            AdditionalHydrosaticLock= Double.parseDouble(PremiumValueHydrostaticLockDriver);
                                            if (!PremiumValueHydrostaticLockDriver.equals("0.00")){
                                                HydrostaticeCardView.setVisibility(View.VISIBLE);
                                                HydrostaticeLockcoverPremium.setText(PremiumValueHydrostaticLockDriver);
                                            }else{
                                                HydrostaticeLockcoverPremium.setText(PremiumValueHydrostaticLockDriver);
                                                HydrostaticeCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            HydrostaticeCardView.setVisibility(View.GONE);
                                            PremiumValueHydrostaticLockDriver="0.0";
                                        }

                                    }
                                    else if (Value.equals("KEY REPLACEMENT")){
                                        PremiumValueKeyReplacement=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        KeyReplacementRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueKeyReplacement.equals("")){
                                            AdditionalKeyReplacement= Double.parseDouble(PremiumValueKeyReplacement);
                                            if (!PremiumValueKeyReplacement.equals("0.00")){
                                                KeyReplacementCardView.setVisibility(View.VISIBLE);
                                                KeyReplacementPremium.setText(PremiumValueKeyReplacement);
                                            }else{
                                                KeyReplacementPremium.setText(PremiumValueKeyReplacement);
                                                KeyReplacementCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            KeyReplacementCardView.setVisibility(View.GONE);
                                            PremiumValueKeyReplacement="0.0";
                                        }

                                    }
                                    else if (Value.equals("Nil Depreciation Waiver cover")){
                                        PremiumValueNilDepreciation=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        NilDepreciationRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueNilDepreciation.equals("")){
                                            AdditionalNilDepreciation= Double.parseDouble(PremiumValueNilDepreciation);
                                            if (!PremiumValueNilDepreciation.equals("0.00")){
                                                NilCardView.setVisibility(View.VISIBLE);
                                                NilDepreciationWaivercoverNamePremium.setText(PremiumValueNilDepreciation);
                                            }else{
                                                NilDepreciationWaivercoverNamePremium.setText(PremiumValueNilDepreciation);
                                                NilCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            NilCardView.setVisibility(View.GONE);
                                            PremiumValueNilDepreciation="0.0";
                                        }

                                    }
                                    else if (Value.equals("RETURN TO INVOICE")){
                                        PremiumValueReturnToInvoice=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        ReturnToInvoiceRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueReturnToInvoice.equals("")){
                                            AdditionalReturnInvoice= Double.parseDouble(PremiumValueReturnToInvoice);
                                            if (!PremiumValueReturnToInvoice.equals("0.00")){
                                                ReturnToInvoiceCardView.setVisibility(View.VISIBLE);
                                                ReturnToInvoicePremium.setText(PremiumValueReturnToInvoice);
                                            }else{
                                                ReturnToInvoicePremium.setText(PremiumValueReturnToInvoice);
                                                ReturnToInvoiceCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            ReturnToInvoiceCardView.setVisibility(View.GONE);
                                            PremiumValueReturnToInvoice="0.0";
                                        }
                                    }
                                    else if (Value.equals("Road side Assistance")){
                                        PremiumValueRoadAssistance=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        RoadSideAssistanceRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueRoadAssistance.equals("")){
                                            AdditionalRoadSide= Double.parseDouble(PremiumValueRoadAssistance);
                                            if (!PremiumValueRoadAssistance.equals("0.00")){
                                                RoadsideAssistanceCardView.setVisibility(View.VISIBLE);
                                                RoadsideAssistancePremium.setText(PremiumValueRoadAssistance);
                                            }else{
                                                RoadsideAssistancePremium.setText(PremiumValueRoadAssistance);
                                                RoadsideAssistanceCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            RoadsideAssistanceCardView.setVisibility(View.GONE);
                                            PremiumValueRoadAssistance="0.0";
                                        }

                                    }
                                    else if (Value.equals("SECURE TOWING")){
                                        PremiumValueSecureTowing=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        SecureTowingRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueSecureTowing.equals("")){
                                            AdditionalsecureTowing= Double.parseDouble(PremiumValueSecureTowing);
                                            if (!PremiumValueSecureTowing.equals("0.00")){
                                                SecureTowingCardView.setVisibility(View.VISIBLE);
                                                SecureTowingPremium.setText(PremiumValueSecureTowing);
                                            }else{
                                                SecureTowingPremium.setText(PremiumValueSecureTowing);
                                                SecureTowingCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            SecureTowingCardView.setVisibility(View.GONE);
                                            PremiumValueSecureTowing="0.0";
                                        }

                                    }
                                    else if (Value.equals("Tyre and Rim secure")){
                                        PremiumValueTyreRim=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        TyreRimsecureRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        if (!PremiumValueTyreRim.equals("")){
                                            AdditionalTyreRim= Double.parseDouble(PremiumValueTyreRim);
                                            if (!PremiumValueTyreRim.equals("0.00")){
                                                TyreCardView.setVisibility(View.VISIBLE);
                                                TyreAndRimSecurePremium.setText(PremiumValueTyreRim);
                                            }else{
                                                TyreAndRimSecurePremium.setText(PremiumValueTyreRim);
                                                TyreCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            TyreCardView.setVisibility(View.GONE);
                                            PremiumValueTyreRim="0.0";
                                        }
                                    }
                                    else if (Value.equals("MANUFACTURER SELLING PRICE")) {
                                        PremiumValueManufacturerSelling=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        ManufacturesellingRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        Log.e("PremiumValueManufacturerSelling",PremiumValueManufacturerSelling);
                                        if (!PremiumValueManufacturerSelling.equals("")){
                                            AdditionalCoverPremiumManufacturePrice= Double.parseDouble(PremiumValueManufacturerSelling);
                                            if (!PremiumValueManufacturerSelling.equals("0.00")) {
                                                ManufacturePriceSellingCardView.setVisibility(View.VISIBLE);
                                                ManufacturePricePremiumTxt.setText(PremiumValueManufacturerSelling);
                                            }else{
                                                ManufacturePricePremiumTxt.setText(PremiumValueManufacturerSelling);
                                                ManufacturePriceSellingCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            ManufacturePriceSellingCardView.setVisibility(View.GONE);
                                            PremiumValueManufacturerSelling="0.0";
                                        }
                                    }
                                    else if (Value.equals("DRIVING TRAIN PROTECT")){
                                        PremiumValueDrivinngTrain=AddonCoversDataJsonObject.getJSONObject(m).optJSONObject("Premium").getString("Value");
//                                        drivingTrainProtectRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");

                                        if (!PremiumValueDrivinngTrain.equals("")){
                                            AdditionalDrivingTrainProtect= Double.parseDouble(PremiumValueDrivinngTrain);
                                            if (!PremiumValueDrivinngTrain.equals("0.00")){
                                                DrivingTrainProtectCardView.setVisibility(View.VISIBLE);
                                                DrivingTrainProtectPremium.setText(PremiumValueDrivinngTrain);
                                            }else{
                                                DrivingTrainProtectPremium.setText(PremiumValueDrivinngTrain);
                                                DrivingTrainProtectCardView.setVisibility(View.GONE);
                                            }
                                        }else{
                                            DrivingTrainProtectCardView.setVisibility(View.GONE);
                                            PremiumValueDrivinngTrain="0.0";
                                        }
                                    }

//                                     if (addOnCoverJson.getString("Value").equals(Value)){
//                                         data1.clear();
//                                         for (int i = 0; i < AddonCoversDataJsonObject.length(); i++) {
//                                             String PremiumValueAddOn = AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("Premium").getString("Value");
//                                             if (!PremiumValueAddOn.equals("0.00")){
//                                                 JSONObject addOnCoverJsonPremium=AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("Premium");
//                                                 Log.e("addOnCoverJsonPremium",addOnCoverJsonPremium.toString());
//                                                 data1.add(
//                                                         new AddonCoverGroupsModel(
//                                                                 AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("AddonCoverGroups").getString("Value"),
//                                                                 AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("Premium").getString("Value")
//                                                         )
//                                                 );
//                                             }
//
//                                             if (data1.size() != 0) {
//                                                 CoverAddOnText.setVisibility(View.GONE);
//                                                 addOnCoverRecyclerview.setVisibility(View.VISIBLE);
//                                                 addOnCoverageRecy = new AddOnCoverageRecy(Motor_AddOns.this,data1);
//                                                 addOnCoverRecyclerview.setLayoutManager(new LinearLayoutManager(Motor_AddOns.this,LinearLayoutManager.HORIZONTAL,false));
//                                                 addOnCoverRecyclerview.setHasFixedSize(true);
//                                                 addOnCoverRecyclerview.setAdapter(addOnCoverageRecy);
//
//                                             }else{
//                                                 CoverAddOnText.setVisibility(View.VISIBLE);
//                                                 addOnCoverRecyclerview.setVisibility(View.GONE);
//                                             }
//
//
//                                         }
//                                     }
                                }
                                for (int l=0; l <OtherDiscountGroupDataJsonObject.length();l++) {
                                    JSONObject DescriptionJson = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Description");
                                    Log.e("DescriptionJson", DescriptionJson.toString());

                                    String DiscountValue = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Description").getString("Value");

                                    if (DiscountValue.equals("Antitheft device discount")) {
                                        strAntitheftdeviceDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        if (!strAntitheftdeviceDiscount.equals("")){
                                            if (!strAntitheftdeviceDiscount.equals("0.00")){
//                                                AntitheftdeviceCardView.setVisibility(View.VISIBLE);
                                                AntitheftdeviceCardView.setVisibility(View.GONE);
                                            }else{
                                                AntitheftdeviceCardView.setVisibility(View.GONE);
                                            }
                                            AntitheftPremiumTxt.setText(strAntitheftdeviceDiscount);
                                        }else{
                                            AntitheftdeviceCardView.setVisibility(View.GONE);
                                            strAntitheftdeviceDiscount="0.0";
                                        }

                                        Log.e("strAntitheftdevicediscount",strAntitheftdeviceDiscount);
                                    }else if (DiscountValue.equals("Automobile Association discount")) {
                                        AutomobileAssociationDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        if (!AutomobileAssociationDiscount.equals("")){
                                            if (!AutomobileAssociationDiscount.equals("0.00")){
//                                                AutomobileCardView.setVisibility(View.VISIBLE);
                                                AutomobileCardView.setVisibility(View.GONE);
                                                AutomobilePremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                AutomobileCardView.setVisibility(View.GONE);
                                            }
//                                                 AutomobilePremiumTxt.setText(AutomobileAssociationDiscount);
                                        }else{
                                            AutomobileCardView.setVisibility(View.GONE);
                                            AutomobileAssociationDiscount="0.0";
                                        }
                                        Log.e("AutomobileAssociationDiscount",AutomobileAssociationDiscount);

                                    } else if (DiscountValue.equals("Handicap Discount")) {
                                        StrHandicapDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        if (!StrHandicapDiscount.equals("")){
                                            if (!StrHandicapDiscount.equals("0.00")){
//                                                HandicapDiscountCardView.setVisibility(View.VISIBLE);
                                                HandicapDiscountCardView.setVisibility(View.GONE);
                                            }else{
                                                HandicapDiscountCardView.setVisibility(View.GONE);
                                            }
                                            HandicapPremiumTxt.setText(StrHandicapDiscount);
                                        }else{
                                            HandicapDiscountCardView.setVisibility(View.GONE);
                                            StrHandicapDiscount="0.0";
                                        }

                                        Log.e("StrHandicapDiscount",StrHandicapDiscount);

                                    } else if (DiscountValue.equals("TPPD Discount")) {
                                        StrTPPDDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        if (!StrTPPDDiscount.equals("")){
                                            if (!StrTPPDDiscount.equals("0.00")){
//                                                TPPDCardView.setVisibility(View.VISIBLE);
                                                TPPDCardView.setVisibility(View.GONE);
                                            }else{
                                                TPPDCardView.setVisibility(View.GONE);
                                            }
                                            TPPDPremiumTxt.setText(StrTPPDDiscount);
                                        }else{
                                            TPPDCardView.setVisibility(View.GONE);
                                            StrTPPDDiscount="0.0";
                                        }
                                        Log.e("StrTPPDDiscount",StrTPPDDiscount);

                                    }else if (DiscountValue.equals("Voluntary deductable")) {
                                        StrVotaryDeductablelun = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        if (!StrVotaryDeductablelun.equals("")){
                                            if (!(StrVotaryDeductablelun.equals("0.00"))){
                                                VotaryCardView.setVisibility(View.VISIBLE);
                                            }else{
                                                VotaryCardView.setVisibility(View.VISIBLE);
                                            }

                                            VotaryPremiumTxt.setText(StrVotaryDeductablelun);
                                        }else{
                                            VotaryCardView.setVisibility(View.GONE);
                                            StrVotaryDeductablelun="0.0";
                                        }
                                        Log.e("StrVotaryDeductablelun",StrVotaryDeductablelun);

                                    }
                                }


                            }
//                            }
//                            else{
//                                Toast.makeText(getApplication(), ""+ErrDescription, Toast.LENGTH_SHORT).show();
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
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE_Quotation);
        req.execute();


    }
    private void VehicleMotorQuotation() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("ProductName", ProductName);
            object.put("MobileNo", str_edt_phone);
            object.put("UserEmail", str_edt_email);
            object.put("UserName", strName);
            object.put("RegistrationNumber",strVehicleNo);
            object.put("ProductCode", ProductCode);
            object.put("Product", "");
            object.put("BusinessType", strPolicyRadio);
            object.put("VehicleClassCode", VehicleClassCode);
            object.put("VehicleMakeCode", strVehicleManufacturerCode);
            object.put("YearofManufacture",yearOfManufacture);
            object.put("VehicleType", strVehicleRadio);
            object.put("CubicCapacity", strVehicleCubicCapicity);
            object.put("NumberOfWheels", "");
            object.put("ChassisNumber", strVehicleChasisNumber);
            object.put("EngineNumber", strVehicleEngineNumber);
            object.put("VehicleAge", strVehicleAge);
            object.put("VehicleModelCode", strVehicleModelCode);
            object.put("RTOLocationCode", strRTOCode);
            object.put("GrossVehicleWeight", "0");
            object.put("PlaceOfRegistration",strRTOName);
            object.put("VehicleModel", strVehicleModel);
            object.put("DateOfFirstRegistration", str_edt_registration_date);
            object.put("DateOfRegistration", str_edt_registration_date);
            object.put("City", strRTOName);
            object.put("SumInsured", "");
            object.put("IDV", strIdvValueTxtSelect);
            object.put("FuelType", FuleType);
            object.put("NCB", "0");
            object.put("VehicleMake",str_vehicleManufacturerNm);
            object.put("Fromdate", today);
            object.put("Todate", nextYear);
            object.put("BasicODStatus",BasicODStatus);
            object.put("ELECTRICALACCESSORYODStatus", ELECTRICALACCESSORYODStatus);
            object.put("ELECTRICALACCESSORYODSumInsured", ELECTRICALACCESSORYODSumInsured);
            object.put("NONELECTRICALACCESSORYODStatus", NONELECTRICALACCESSORYODStatus);
            object.put("NONELECTRICALACCESSORYODSumInsured",NONELECTRICALACCESSORYODSumInsured);
            object.put("BasicTP",BasicTP);
            object.put("PACOVERTOEMPLOYEESOFINSUREDStatus", PACOVERTOEMPLOYEESOFINSUREDStatus);
            object.put("PACOVERTOPASSENGERSStatus", PACOVERTOPASSENGERSStatus);
            object.put("PACOVERTOPASSENGERSSumInsured", PACOVERTOPASSENGERSSumInsured);
            object.put("PACOVERTOPAIDDRIVERStatus", PACOVERTOPAIDDRIVERStatus);
            object.put("PACOVERTOPAIDDRIVERSumInsured", PACOVERTOPAIDDRIVERSumInsured);
            object.put("OtherTPStatus", OtherTpStatus);
            object.put("FIBERTANKODStatus", FIBERTANKODStatus);
            object.put("OtherODStatus", OtherODStatus);
            object.put("UNNAMEDPACOVERTOPASSENGERSStatus", UNNAMEDPACOVERTOPASSENGERSStatus);
            object.put("UNNAMEDPACOVERTOPASSENGERSSumInsured", UNNAMEDPACOVERTOPASSENGERSSumInsured);
            object.put("PACOVERTOOWNERDRIVERStatus", PACOVERTOOWNERDRIVERStatus);
            object.put("CNGLPGKITODStatus", CNGLPGKITODStatus);
            object.put("CNGLPGKITODSumInsured", CNGLPGKITODSumInsured);
            object.put("CNGLPGKITTPStatus", CNGLPGKITTPStatus);
            object.put("BUILTINCNGKIT_LPGKITODStatus", BUILTINCNGKIT_LPGKITODStatus);
            object.put("MANUFACTURERSELLINGPRICEStatus", MANUFACTURERSELLINGPRICEStatus);
            object.put("BUILTINCNGKIT_LPGKITTPStatus", BUILTINCNGKIT_LPGKITTPStatus);
            object.put("DRIVINGTRAINPROTECTStatus", DRIVINGTRAINPROTECTStatus);
            object.put("LEGALLIABILITYTOPAIDDRIVERStatus", LEGALLIABILITYTOPAIDDRIVERStatus);
            object.put("RoadsideAssistanceStatus", RoadsideAssistanceStatus);
            object.put("NilDepreciationWaivercoverStatus", NilDepreciationWaivercoverStatus);
            object.put("DAILYCASHALLOWANCENONMETROStatus", DAILYCASHALLOWANCENONMETROStatus);
            object.put("DAILYCASHALLOWANCEMETROStatus", DAILYCASHALLOWANCEMETROStatus);
            object.put("KEYREPLACEMENTStatus", KEYREPLACEMENTStatus);
            object.put("RETURNTOINVOICEStatus", RETURNTOINVOICEStatus);
            object.put("ACCIDENTALHOSPITALIZATIONStatus", ACCIDENTALHOSPITALIZATIONStatus);
            object.put("HYDROSTATICLOCKCOVERStatus", HYDROSTATICLOCKCOVERStatus);
            object.put("COSTOFCONSUMABLESStatus", COSTOFCONSUMABLESStatus);
            object.put("SECURETOWINGStatus", SECURETOWINGStatus);
            object.put("TyreandRimsecureStatus", TyreandRimsecureStatus);
            object.put("ENGINEPROTECTORPETROLStatus", ENGINEPROTECTORPETROLStatus);
            object.put("ENGINEPROTECTORDIESELStatus", ENGINEPROTECTORDIESELStatus);
            object.put("WRONGFUELCOVERStatus", WRONGFUELCOVERStatus);
            object.put("DetariffLoadingStatus", DetariffLoadingStatus);
            object.put("DetariffDiscountStatus", DetariffDiscountStatus);
            object.put("DAILYCASHALLOWANCEStatus", DAILYCASHALLOWANCEStatus);
            object.put("AntitheftdevicediscountStatus", AntitheftdevicediscountStatus);
            object.put("AntitheftdevicediscountSumInsured", "");
            object.put("AutomobileAssociationdiscountStatus", AutomobileAssociationdiscountStatus);
            object.put("AutomobileAssociationdiscountSumInsured", AutomobileAssociationdiscountSumInsured);
            object.put("VoluntarydeductableStatus", VoluntarydeductableStatus);
            object.put("VoluntarydeductableSumInsured", VoluntarydeductableSumInsured);
            object.put("VoluntarydeductableDiscountAmount", VoluntarydeductableDiscountAmount);
            object.put("TPPDDiscountStatus", TPPDDiscountStatus);
            object.put("TPPDDiscountSumInsured", "6000");
            object.put("HandicapDiscountStatus", HandicapDiscountStatus);
            object.put("HandicapDiscountSumInsured", "1000");
            object.put("NCBStatus", "True");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_AddOns.this, object, UrlConstants.BUY_VehicleMotorQuotation, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    if (Tag == RequestConstants.BUY_POLICY_MOTOR_PRIVATE_Quotation) {
                        try {
                            JSONObject ErrorsJsonObject = object.getJSONObject("Errors");
                            String ErrDescription = ErrorsJsonObject.getString("ErrDescription");
                            String ErrorCode = ErrorsJsonObject.getString("ErrorCode");
                            if (ErrorCode.equals("0")){
                            }else{
//                                Toast.makeText(getApplication(), ""+ErrDescription, Toast.LENGTH_SHORT).show();
                            }
                            JSONObject CustomerJsonObject = object.getJSONObject("Customer");
                            JSONObject ProductJsonObject = object.getJSONObject("Product");
                            Log.e("ProductJsonObject",ProductJsonObject.toString());
                            JSONObject RisksDataJsonObject = ProductJsonObject.getJSONObject("Risks");
                            JSONObject RiskDataJsonObject = RisksDataJsonObject.getJSONObject("Risk");
                            Log.e("RiskDataJsonObject",RiskDataJsonObject.toString());

                            JSONObject RisksDatasJsonObject = RiskDataJsonObject.getJSONObject("RisksData");
                            Log.e("RisksDatasJsonObject",RisksDatasJsonObject.toString());
                            JSONObject DetariffDiscountsJsonObject = RisksDatasJsonObject.getJSONObject("DetariffDiscounts");
                            Log.e("DetariffDiscountsJsonObject",DetariffDiscountsJsonObject.toString());
                            JSONObject DetariffDiscountGroupJsonObject = DetariffDiscountsJsonObject.getJSONObject("DetariffDiscountGroup");
                            Log.e("DetariffDiscountGroupJsonObject",DetariffDiscountGroupJsonObject.toString());
                            JSONObject DetariffLoadingsJsonObject = RisksDatasJsonObject.getJSONObject("DetariffLoadings");
                            Log.e("DetariffLoadingsJsonObject",DetariffLoadingsJsonObject.toString());

                            JSONObject DetariffLoadingGroupJsonObject = DetariffLoadingsJsonObject.getJSONObject("DetariffLoadingGroup");
                            Log.e("DetariffLoadingGroupJsonObject",DetariffLoadingGroupJsonObject.toString());

                            JSONObject AddonCoverDetailsJsonObject = RisksDatasJsonObject.getJSONObject("AddonCoverDetails");
                            Log.e("AddonCoverDetailsJsonObject",AddonCoverDetailsJsonObject.toString());
                            JSONObject AddonCoversJsonObject = AddonCoverDetailsJsonObject.getJSONObject("AddonCovers");
                            Log.e("AddonCoversJsonObject",AddonCoversJsonObject.toString());
                            JSONArray AddonCoversDataJsonObject = AddonCoversJsonObject.getJSONArray("AddonCoversData");
                            Log.e("AddonCoversDataJsonObject",AddonCoversDataJsonObject.toString());

                            JSONObject CoverDetailsJsonObject = RisksDatasJsonObject.getJSONObject("CoverDetails");
                            Log.e("CoverDetailsJsonObject",CoverDetailsJsonObject.toString());
                            JSONObject CoversJsonObject = CoverDetailsJsonObject.getJSONObject("Covers");
                            Log.e("CoversJsonObject",CoversJsonObject.toString());
                            JSONArray CoversDataJsonObject = CoversJsonObject.getJSONArray("CoversData");
                            Log.e("CoversDataJsonObject",CoversDataJsonObject.toString());

                            JSONObject PremiumCalculationJsonObject = ProductJsonObject.getJSONObject("PremiumCalculation");
                            Log.e("PremiumCalculationJsonObject",PremiumCalculationJsonObject.toString());
                            JSONObject NetPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("NetPremium");
                            Log.e("NetPremiumJsonObject",NetPremiumJsonObject.toString());
                            JSONObject TotalPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("TotalPremium");
                            Log.e("TotalPremiumJsonObject",TotalPremiumJsonObject.toString());
                            JSONObject ServiceTaxJsonObject = PremiumCalculationJsonObject.getJSONObject("ServiceTax");
                            Log.e("ServiceTaxJsonObject",ServiceTaxJsonObject.toString());
                            JSONObject VehicleExShowroomPriceJsonObject = RisksDataJsonObject.getJSONObject("VehicleExShowroomPrice");
                            Log.e("VehicleExShowroomPriceJsonObject",VehicleExShowroomPriceJsonObject.toString());
                            JSONObject VehicleIDVJsonObject = RisksDataJsonObject.getJSONObject("VehicleIDV");
                            Log.e("VehicleIDVJsonObject",VehicleIDVJsonObject.toString());
                            JSONObject OtherDiscountsJsonObject = RisksDatasJsonObject.getJSONObject("OtherDiscounts");
                            JSONObject OtherDiscountGroupJsonObject = OtherDiscountsJsonObject.getJSONObject("OtherDiscountGroup");
                            JSONArray OtherDiscountGroupDataJsonObject = OtherDiscountGroupJsonObject.getJSONArray("OtherDiscountGroupData");
                            JSONObject DetariffDiscountGroupData = DetariffDiscountGroupJsonObject.getJSONObject("DetariffDiscountGroupData");
                            JSONObject DetariffLoadingGroupData = DetariffLoadingGroupJsonObject.getJSONObject("DetariffLoadingGroupData");
                            VehicleExShowroomPrice = VehicleExShowroomPriceJsonObject.getString("Value");
                            NetPremiumValue = NetPremiumJsonObject.getString("Value");
                            TotalValue = TotalPremiumJsonObject.getString("Value");
                            Log.e("TotalValue",TotalValue);
                            PosPolicyNo = CustomerJsonObject.getString("PosPolicyNo");
                            Log.e("PosPolicyNoCheck",PosPolicyNo);

                            GST = ServiceTaxJsonObject.getString("Value");
//                                    strIdvValueTxt1 = VehicleIDVJsonObject.getString("Value");
                            TotalPremium.setText(TotalValue);
//                                    if (!strIdvValueTxt1.equals("")){
//                                        float AllIDV= Float.parseFloat(strIdvValueTxt1);
//                                        int a = Math.round(AllIDV);
//                                        strIdvValueTxt=String.valueOf(a);
//                                        int lest= a*10/100;
//                                        strLessIDVText= String.valueOf(a-lest);
//                                        strHighIDVText= String.valueOf(lest+a);
//                                        IdvValueTxt.setText(strIdvValueTxt);
//                                        lessIDVText.setText(strLessIDVText);
//                                        HighIDVText.setText(strHighIDVText);
//                                        IDVTotalPremium.setText(strIdvValueTxt);
//                                        Log.e("strLessIDVText",strLessIDVText);
//                                        Log.e("strHighIDVText",strHighIDVText);
//                                    }else{
//                                        strIdvValueTxt1="0.0";
//                                    }
                            if (OneYearComprehensiveRadio.isChecked()){
                                OneYearComprehensiveTxt.setText(TotalValue);
                                TotalPremiumComprehensive.setText(TotalValue);
                                thirdComprehensiveTxt.setText("");
                                FiveComprehensiveTxt.setText("");
                                StandardPlanPremiumTxt.setText("");
                                TotalPremiumTp.setText("");
                                StandardPlanPremium.setText("");
                                TPTextView.setText("");
                            }
                            else if (ThreeYearComprehensiveRadio.isChecked()){
                                OneYearComprehensiveTxt.setText("");
                                FiveComprehensiveTxt.setText("");
                                StandardPlanPremiumTxt.setText("");
                                TPTextView.setText("");
                                TotalPremiumTp.setText("");
                                StandardPlanPremium.setText("");
                                thirdComprehensiveTxt.setText(TotalValue);
                                TotalPremiumComprehensive.setText(TotalValue);
                            }
                            else if (FiveYearComprehensiveRadio.isChecked()){
                                OneYearComprehensiveTxt.setText("");
                                thirdComprehensiveTxt.setText("");
                                TPTextView.setText("");
                                TotalPremiumTp.setText("");
                                StandardPlanPremium.setText("");
                                FiveComprehensiveTxt.setText(TotalValue);
                                TotalPremiumComprehensive.setText(TotalValue);
                            }
                            else if (OneYearThirdPartyRadio.isChecked()){
                                OneYearComprehensiveTxt.setText("");
                                thirdComprehensiveTxt.setText("");
                                FiveComprehensiveTxt.setText("");
                                StandardPlanPremiumTxt.setText("");
                                TotalPremiumComprehensive.setText("");
                                StandardPlanPremium.setText("");
                                TPTextView.setText(TotalValue);
                                TotalPremiumTp.setText(TotalValue);
                            }
                            else if (OneYearStandardAloneRadio.isChecked()){
                                OneYearComprehensiveTxt.setText("");
                                thirdComprehensiveTxt.setText("");
                                FiveComprehensiveTxt.setText("");
                                TotalPremiumComprehensive.setText("");
                                TotalPremiumTp.setText("");
                                TPTextView.setText("");
                                StandardPlanPremiumTxt.setText(TotalValue);
                                StandardPlanPremium.setText(TotalValue);
                            }
                            if (CheckString.equals("1")){
                                JSONObject DetarifficDescription = DetariffDiscountGroupData.getJSONObject("Description");
                                String DetarifficValue = DetarifficDescription.getString("Value");
                                if (DetarifficValue.equals("De-tariff Discount")) {
                                    DetarifficValuePremium = DetariffDiscountGroupData.getJSONObject("Premium").getString("Value");
                                    strDiscountEdit = DetariffDiscountGroupData.getJSONObject("Premium").getString("Value");
                                    DetarifficValueRate = DetariffDiscountGroupData.getJSONObject("Rate").getString("Value");
                                    DetarifficValueSumInsure = DetariffDiscountGroupData.getJSONObject("SumInsured").getString("Value");
                                    if (!DetarifficValuePremium.equals("")){
                                        DetarifficValuePremiumDouble= Double.parseDouble(DetarifficValuePremium);
                                        StrDetarifficValuePremiumDouble= String.valueOf(DetarifficValuePremiumDouble);
                                        Log.e("DetarifficValuePremium",DetarifficValuePremium);
                                    }else{
                                        DetarifficValuePremium="0.0";
                                    }
                                }
                                JSONObject DeTariffLoadingDescription = DetariffLoadingGroupData.getJSONObject("Description");
                                String DetarifficLodingValue = DeTariffLoadingDescription.getString("Value");
                                if (DetarifficLodingValue.equals("De -tariff Loading")) {
                                    DetarifficLodingValuePremium = DetariffLoadingGroupData.getJSONObject("Premium").getString("Value");
                                    DetarifficLoadingValueRate = DetariffLoadingGroupData.getJSONObject("Rate").getString("Value");
                                    DetarifficLoadingValueSumInsured= DetariffLoadingGroupData.getJSONObject("SumInsured").getString("Value");
                                    if (!DetarifficLodingValuePremium.equals("")){
                                        DetarifficLoadingValuePremiumDouble= Double.parseDouble(DetarifficLodingValuePremium);
                                        StrDetarifficLoadingValuePremiumDouble= String.valueOf(DetarifficLoadingValuePremiumDouble);
                                        Log.e("StrDetarifficLoadingValuePremiumDouble",StrDetarifficLoadingValuePremiumDouble);
                                    }else{
                                        DetarifficLodingValuePremium="0.0";
                                    }
                                }
                                for (int k=0; k <CoversDataJsonObject.length();k++) {
                                    JSONObject CoverGroupsJson = CoversDataJsonObject.getJSONObject(k).optJSONObject("CoverGroups");
                                    Log.e("CoverGroupsJson", CoverGroupsJson.toString());

                                    String Value = CoverGroupsJson.getString("Value");
                                    if (Value.equals("Basic OD")) {
                                        BasicODCardView.setVisibility(View.GONE);
                                        AdditionalCoverBasicOdPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        if (!AdditionalCoverBasicOdPremium.equals("")){
                                            AdditionalCoverPremiumOD= Double.parseDouble(AdditionalCoverBasicOdPremium);
                                            StrAdditionalCoverPremiumOD= String.valueOf(AdditionalCoverPremiumOD);
                                            Log.e("AdditionalCoverPremiumOD",AdditionalCoverBasicOdPremium);
                                            if (!AdditionalCoverBasicOdPremium.equals("0.00")) {
                                                BasicODCardView.setVisibility(View.GONE);
                                                BasicODPremiumTxt.setText(AdditionalCoverBasicOdPremium);
                                            } else {
                                                BasicODCardView.setVisibility(View.GONE);
                                                BasicODPremiumTxt.setText(AdditionalCoverBasicOdPremium);
                                            }
                                        }else{
                                            BasicODCardView.setVisibility(View.GONE);
                                            AdditionalCoverBasicOdPremium="0.0";
                                        }

                                    }
                                    else if (Value.equals("Basic TP")) {
                                        BasicTPCardView.setVisibility(View.GONE);
                                        AdditionalBasicTpCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        Log.e("AdditionalCoverPremiumTp",AdditionalBasicTpCoverPremium);
                                        if (!AdditionalBasicTpCoverPremium.equals("")){
                                            AdditionalCoverPremiumTP= Double.parseDouble(AdditionalBasicTpCoverPremium);
                                            StrAdditionalCoverPremiumTp= String.valueOf(AdditionalCoverPremiumTP);
                                            Log.e("AdditionalCoverPremiumTP",AdditionalBasicTpCoverPremium);
                                            if (!AdditionalBasicTpCoverPremium.equals("0.00")) {
                                                BasicTPCardView.setVisibility(View.GONE);
                                                BasicTPPremiumTxt.setText(AdditionalBasicTpCoverPremium);
                                            } else {
                                                BasicTPCardView.setVisibility(View.GONE);
                                                BasicTPPremiumTxt.setText(AdditionalBasicTpCoverPremium);
                                            }
                                        }else{
                                            BasicTPCardView.setVisibility(View.GONE);
                                            AdditionalBasicTpCoverPremium="0.0";
                                        }
                                    }
                                    else if (Value.equals("ELECTRICAL ACCESSORY OD")) {
                                        AdditionalCoverPremiumElectrical = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalElectricalRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalElectricalSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumElectrical.equals("")){
                                            AdditionalCoverPremiumEl= Double.parseDouble(AdditionalCoverPremiumElectrical);
                                            Log.e("AdditionalCoverPremiumEl",AdditionalCoverPremiumElectrical);
                                            if (AdditionalCoverPremiumElectrical.equals("0.00")) {
                                                ElectricalPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                ElectricalPremiumTxt.setVisibility(View.VISIBLE);
                                            }

                                            ElectricalPremiumTxt.setText(AdditionalCoverPremiumElectrical);
//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    ElectricalCardView.setVisibility(View.VISIBLE);
//                                                    ElectricalPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    ElectricalCardView.setVisibility(View.VISIBLE);
//                                                    ElectricalPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }
                                        else{
                                            ElectricalCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumElectrical="0.0";
                                        }

                                    }
                                    else if (Value.equals("FIBERTANK OD")) {
                                        AdditionalCoverPremiumFiberTank = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalFibertankODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalFibertankODSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumFiberTank.equals("")){
                                            AdditionalCoverPremiumFI= Double.parseDouble(AdditionalCoverPremiumFiberTank);
                                            Log.e("AdditionalCoverPremiumFI", String.valueOf(AdditionalCoverPremiumFiberTank));

//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    FIBERTANKODCardView.setVisibility(View.VISIBLE);
//                                                    FIBERTANKPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    FIBERTANKODCardView.setVisibility(View.VISIBLE);
//                                                    FIBERTANKPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            FIBERTANKODCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumFiberTank="0.0";
                                        }

                                    }
                                    else if (Value.equals("LEGAL LIABILITY TO PAID DRIVER")) {
                                        AdditionalCoverPremiumPaidDriver = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalLegalLiabilityPaidRate = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalLegalLiabilityPaidSumInsured = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumPaidDriver.equals("")){
                                            AdditionalCoverPremiumLegal= Double.parseDouble(AdditionalCoverPremiumPaidDriver);
                                            Log.e("AdditionalCoverPremiumLegal", String.valueOf(AdditionalCoverPremiumPaidDriver));
//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    LegalLiabilityCardView.setVisibility(View.VISIBLE);
//                                                    LegalPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    LegalLiabilityCardView.setVisibility(View.VISIBLE);
//                                                    LegalPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            LegalLiabilityCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumPaidDriver="0.0";
                                        }
                                    }
                                    else if (Value.equals("NON ELECTRICAL ACCESSORY OD")) {
                                        AdditionalCoverPremiumNonElectrical = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalNonElecticalODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalNonElecticalODSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumNonElectrical.equals("")){
                                            AdditionalCoverPremiumNon= Double.parseDouble(AdditionalCoverPremiumNonElectrical);

                                            if (AdditionalCoverPremiumNonElectrical.equals("0.00")) {
                                                NonElectricalPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                NonElectricalPremiumTxt.setVisibility(View.VISIBLE);
                                            }


                                            NonElectricalPremiumTxt.setText(AdditionalCoverPremiumNonElectrical);
//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    NonLegalLiabilityCardView.setVisibility(View.VISIBLE);
//                                                    NonElectricalPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    NonLegalLiabilityCardView.setVisibility(View.VISIBLE);
//                                                    NonElectricalPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            NonLegalLiabilityCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumNonElectrical="0.0";
                                        }

                                    }
                                    else if (Value.equals("Other OD")) {
                                        AdditionalCoverPremiumCoverOtherOD = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalOtherODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalOtherODRateSumInsured = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");

                                        if (!AdditionalCoverPremiumCoverOtherOD.equals("")){
                                            AdditionalCoverPremiumOtherOD= Double.parseDouble(AdditionalCoverPremiumCoverOtherOD);
                                            Log.e("AdditionalCoverPremiumOtherOD", String.valueOf(AdditionalCoverPremiumCoverOtherOD));

//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    OtherOdCardView.setVisibility(View.VISIBLE);
//                                                    OtherOdPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    OtherOdCardView.setVisibility(View.VISIBLE);
//                                                    OtherOdPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            OtherOdCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCoverOtherOD="0.0";
                                        }
                                    }
                                    else if (Value.equals("Other TP")) {
                                        AdditionalCoverPremiumCoverOtherTP = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalOtherTpRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalOtherTpSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumCoverOtherTP.equals("")){
                                            AdditionalCoverPremiumOtherTP= Double.parseDouble(AdditionalCoverPremiumCoverOtherTP);
                                            Log.e("AdditionalCoverPremiumOtherTP", String.valueOf(AdditionalCoverPremiumOtherTP));
//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    OtherTpCardView.setVisibility(View.VISIBLE);
//                                                    OtherTpPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    OtherTpCardView.setVisibility(View.VISIBLE);
//                                                    OtherTpPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            OtherTpCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCoverOtherTP="0.0";
                                        }
                                    }
//                                            else if (Value.equals("PA COVER TO EMPLOYEES OF INSURED")) {
//                                                AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
//                                                AdditionalPaCoversToEmployessRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
//                                                if (!AdditionalCoverPremium.equals("")){
//                                                    AdditionalCoverPremiumPACOVER= Double.parseDouble(AdditionalCoverPremium);
//                                                    if (!AdditionalCoverPremium.equals("0.00")) {
//                                                        EMPLOYEESCardView.setVisibility(View.VISIBLE);
//                                                        EmployeesInsuredPremiumTxt.setText(AdditionalCoverPremium);
//                                                    } else {
//                                                        EMPLOYEESCardView.setVisibility(View.VISIBLE);
//                                                        EmployeesInsuredPremiumTxt.setText(AdditionalCoverPremium);
//                                                    }
//                                                }else{
//                                                    EMPLOYEESCardView.setVisibility(View.GONE);
//                                                    AdditionalCoverPremium="0.0";
//                                                }
//
//                                            }
                                    else if (Value.equals("PA COVER TO OWNER DRIVER")) {
                                        AdditionalCoverPremiumOwnerDriver = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalPaCoverToOwnerDriverRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalPaCoverToOwnerDriverSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (strGPACover.equals("Yes")||strPACover.equals("Yes")){
                                            OwnerDriverCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumOwnerDriver="0.0";
                                            AdditionalCoverPremiumOWNERDRIVER= Double.parseDouble(AdditionalCoverPremiumOwnerDriver);
                                        }else{
                                            if (!AdditionalCoverPremiumOwnerDriver.equals("")){
                                                AdditionalCoverPremiumOWNERDRIVER= Double.parseDouble(AdditionalCoverPremiumOwnerDriver);
                                                Log.e("AdditionalCoverPremiumOWNERDRIVER", String.valueOf(AdditionalCoverPremiumOWNERDRIVER));
                                                if (!AdditionalCoverPremiumOwnerDriver.equals("0.00")) {
                                                    OwnerDriverCardView.setVisibility(View.GONE);
                                                    OwnerDriverPremiumTxt.setText(AdditionalCoverPremiumOwnerDriver);
                                                } else {
                                                    OwnerDriverCardView.setVisibility(View.GONE);
                                                    OwnerDriverPremiumTxt.setText(AdditionalCoverPremiumOwnerDriver);
                                                }
                                            }else{
                                                OwnerDriverCardView.setVisibility(View.GONE);
                                                AdditionalCoverPremiumOwnerDriver="0.0";
                                            }
                                        }
                                    }
                                    else if (Value.equals("PA COVER TO PAID DRIVER")) {
                                        AdditionalCoverPremiumPaPaidDriver = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalPaidDriverRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalPaidDriverSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumPaPaidDriver.equals("")){
                                            AdditionalCoverPremiumPAIDDRIVER= Double.parseDouble(AdditionalCoverPremiumPaPaidDriver);
                                            Log.e("AdditionalCoverPremiumPAIDDRIVER", String.valueOf(AdditionalCoverPremiumPAIDDRIVER));
                                            PaidDriverPremiumTxt.setText(AdditionalCoverPremiumPaPaidDriver);
                                            if (AdditionalCoverPremiumPaPaidDriver.equals("0.00")) {
                                                PaidDriverPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                PaidDriverPremiumTxt.setVisibility(View.VISIBLE);
                                            }

//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    PaidDriverCardView.setVisibility(View.VISIBLE);
//                                                    PaidDriverPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    PaidDriverCardView.setVisibility(View.VISIBLE);
//                                                    PaidDriverPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            PaidDriverCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumPaPaidDriver="0.0";
                                        }
                                    }
                                    else if (Value.equals("PA COVER TO PASSENGERS")) {
                                        AdditionalCoverPremiumPaPassenger = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalPaToPassengersRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalPaToPassengersSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");

                                        if (!AdditionalCoverPremiumPaPassenger.equals("")){
                                            AdditionalCoverPremiumPASSENGERS= Double.parseDouble(AdditionalCoverPremiumPaPassenger);
                                            Log.e("AdditionalCoverPremiumPASSENGERS", String.valueOf(AdditionalCoverPremiumPASSENGERS));
                                            if (AdditionalCoverPremiumPaPassenger.equals("0.00")) {
                                                PassengersPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                PassengersPremiumTxt.setVisibility(View.VISIBLE);
                                            }
                                            PassengersPremiumTxt.setText(AdditionalCoverPremiumPaPassenger);
//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    PASSENGERSCardView.setVisibility(View.VISIBLE);
//                                                    PassengersPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    PASSENGERSCardView.setVisibility(View.VISIBLE);
//                                                    PassengersPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            PASSENGERSCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumPaPassenger="0.0";
                                        }
                                    }
                                    else if (Value.equals("UNNAMED PA COVER TO PASSENGERS")) {
                                        AdditionalCoverPremiumUnnamedPassenger = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalUnnamedPassengersRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalUnnamedPassengersSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumUnnamedPassenger.equals("")){
                                            AdditionalCoverPremiumUNNAMED= Double.parseDouble(AdditionalCoverPremiumUnnamedPassenger);
                                            Log.e("AdditionalCoverPremiumUNNAMED", String.valueOf(AdditionalCoverPremiumUNNAMED));
                                            UnnamedPassengersPremiumTxt.setText(AdditionalCoverPremiumUnnamedPassenger);
                                            if (AdditionalCoverPremiumUnnamedPassenger.equals("0.00")) {
                                                UnnamedPassengersPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                UnnamedPassengersPremiumTxt.setVisibility(View.VISIBLE);
                                            }

//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    UnnamedPassengerCardView.setVisibility(View.VISIBLE);
//                                                    UnnamedPassengersPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    UnnamedPassengerCardView.setVisibility(View.VISIBLE);
//                                                    UnnamedPassengersPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            UnnamedPassengerCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumUnnamedPassenger="0.0";
                                        }
                                    }
                                    else if (Value.equals("CNGLPG KIT OD")) {
                                        AdditionalCoverPremiumCngLpgOd = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalCngKitODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalCngKitODSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");

                                        if (!AdditionalCoverPremiumCngLpgOd.equals("")){
                                            AdditionalCoverPremiumCNGLPG= Double.parseDouble(AdditionalCoverPremiumCngLpgOd);
                                            Log.e("AdditionalCoverPremiumCNGLPG", String.valueOf(AdditionalCoverPremiumCNGLPG));
                                            if (AdditionalCoverPremiumCngLpgOd.equals("0.00")) {
                                                CNGLPGKITODPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                CNGLPGKITODPremiumTxt.setVisibility(View.VISIBLE);
                                            }
                                            CNGLPGKITODPremiumTxt.setText(AdditionalCoverPremiumCngLpgOd);
                                        }else{
                                            CngStatusCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCngLpgOd="0.0";
                                        }
                                    }
                                    else if (Value.equals("CNGLPG KIT TP")) {
                                        AdditionalCoverPremiumCngLpgKitTp = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalCngLpgTpRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalCngLpgTpSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");

                                        if (!AdditionalCoverPremiumCngLpgKitTp.equals("")){
                                            AdditionalCoverPremiumCNGLPGTP= Double.parseDouble(AdditionalCoverPremiumCngLpgKitTp);
                                            Log.e("AdditionalCoverPremiumCNGLPGTP", String.valueOf(AdditionalCoverPremiumCNGLPGTP));
                                            if (AdditionalCoverPremiumCngLpgKitTp.equals("0.00")) {
                                                CNGLPGKITTPPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                CNGLPGKITTPPremiumTxt.setVisibility(View.VISIBLE);
                                            }
                                            CNGLPGKITTPPremiumTxt.setText(AdditionalCoverPremiumCngLpgKitTp);
                                        }else{
                                            CNGLPGKITTPStatusCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCngLpgKitTp="0.0";
                                        }
                                    }
                                    else if (Value.equals("BUILTIN CNGLPG KIT OD")) {
                                        AdditionalCoverPremiumBuiltingKitOD = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalBuiltinKitODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalBuiltinKitODSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");

                                        if (!AdditionalCoverPremiumBuiltingKitOD.equals("")){
                                            AdditionalCoverPremiumBUILTINOD= Double.parseDouble(AdditionalCoverPremiumBuiltingKitOD);
                                            Log.e("AdditionalCoverPremiumBUILTINOD", String.valueOf(AdditionalCoverPremiumBUILTINOD));
                                            if (AdditionalCoverPremiumBuiltingKitOD.equals("0.00")) {
                                                BUILTINCNGKITPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                BUILTINCNGKITPremiumTxt.setVisibility(View.VISIBLE);
                                            }
                                            BUILTINCNGKITPremiumTxt.setText(AdditionalCoverPremiumBuiltingKitOD);
                                        }else{
                                            BUILTINCNGKITCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumBuiltingKitOD="0.0";
                                        }
                                    }
                                    else if (Value.equals("BUILTIN CNGLPG KIT TP")) {
                                        AdditionalCoverPremiumBultinKitTp = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalBuiltinCngTPRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalBuiltinCngTPSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumBultinKitTp.equals("")){
                                            AdditionalCoverPremiumBuiltinCngLPGTp= Double.parseDouble(AdditionalCoverPremiumBultinKitTp);
                                            Log.e("AdditionalCoverPremiumBuiltinCngLPGTp", String.valueOf(AdditionalCoverPremiumBuiltinCngLPGTp));
                                            if (AdditionalCoverPremiumBultinKitTp.equals("0.00")) {
                                                BuiltinCngLPGTpPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                BuiltinCngLPGTpPremiumTxt.setVisibility(View.VISIBLE);
                                            }
                                            BuiltinCngLPGTpPremiumTxt.setText(AdditionalCoverPremiumBultinKitTp);
                                        }else{
                                            BuiltinCngLPGTpCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumBultinKitTp="0.0";
                                        }
                                    }
                                }

                                double DoubleValue=AdditionalCoverPremiumNon+AdditionalCoverPremiumEl+AdditionalCoverPremiumFI+AdditionalCoverPremiumLegal+AdditionalCoverPremiumOtherOD+AdditionalCoverPremiumOtherTP+AdditionalCoverPremiumPAIDDRIVER+AdditionalCoverPremiumPASSENGERS+AdditionalCoverPremiumUNNAMED+AdditionalCoverPremiumCNGLPG+AdditionalCoverPremiumCNGLPGTP+AdditionalCoverPremiumBUILTINOD+AdditionalCoverPremiumBuiltinCngLPGTp+AdditionalCoverPremiumOWNERDRIVER;
                                addOnsCover=String.format("%.2f", DoubleValue);
                                Log.e("addOnsCover1", addOnsCover);
                                for (int j=0; j <AddonCoversDataJsonObject.length();j++){
                                    JSONObject addOnCoverJson=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("AddonCoverGroups");
                                    Log.e("addOnCoverJson",addOnCoverJson.toString());

                                    String Value  = addOnCoverJson.getString("Value");

                                    if (Value.equals("DAILY CASH ALLOWANCE")){
                                        PremiumValueDailyCash=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        DailyCashRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        DailyCashRateSumInsured=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueDailyCash.equals("")){
//                                                DailyCashAllowance= Double.parseDouble(PremiumValue);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    DailCashAllownceCardView.setVisibility(View.GONE);
//                                                    DailyCashAllowancePremium.setText(PremiumValue);
//                                                }else{
//                                                    DailyCashAllowancePremium.setText(PremiumValue);
//                                                    DailCashAllownceCardView.setVisibility(View.GONE);
//                                                }
                                        }else{
                                            DailCashAllownceCardView.setVisibility(View.GONE);
                                            PremiumValueDailyCash="0.0";
                                        }

                                    }
                                    else if (Value.equals("ACCIDENTAL HOSPITALIZATION")){
                                        PremiumValueAccidentalHospitalization=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        AccidentalRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        AccidentalSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueAccidentalHospitalization.equals("")){
                                            AdditionalHospitalization= Double.parseDouble(PremiumValueAccidentalHospitalization);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    AccidentalCardView.setVisibility(View.VISIBLE);
//                                                    AccidentalHospitalPremium.setText(PremiumValue);
//                                                }else{
//                                                    AccidentalHospitalPremium.setText(PremiumValue);
//                                                    AccidentalCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            AccidentalCardView.setVisibility(View.GONE);
                                            PremiumValueAccidentalHospitalization="0.0";
                                        }

                                    }
                                    else if (Value.equals("WRONG FUEL COVER")){
                                        PremiumValueWrongFuelCover=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        WrongFuelRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        WrongFuelSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueWrongFuelCover.equals("")){
                                            WrongFuelCover= Double.parseDouble(PremiumValueWrongFuelCover);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    WrongFuelCardView.setVisibility(View.VISIBLE);
//                                                    WrongFuelTxtPremium.setText(PremiumValue);
//                                                }else{
//                                                    WrongFuelTxtPremium.setText(PremiumValue);
//                                                    WrongFuelCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            WrongFuelCardView.setVisibility(View.GONE);
                                            PremiumValueWrongFuelCover="0.0";
                                        }

                                    }
                                    else if (Value.equals("COST OF CONSUMABLES")){
                                        PremiumValueCostConsumables=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        CostOfConsumablesRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        CostOfConsumablesSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueCostConsumables.equals("")){
                                            AdditionalCostOfConsumbales= Double.parseDouble(PremiumValueCostConsumables);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    CostOfCardView.setVisibility(View.VISIBLE);
//                                                    CostOfConsumableNamePremium.setText(PremiumValue);
//                                                }else{
//                                                    CostOfConsumableNamePremium.setText(PremiumValue);
//                                                    CostOfCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            CostOfCardView.setVisibility(View.GONE);
                                            PremiumValueCostConsumables="0.0";
                                        }
                                    }
                                    else if (Value.equals("DAILY CASH ALLOWANCE - METRO")){
                                        PremiumValueDailyCashMetro=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        dailyCashAllowanceMetroRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        dailyCashAllowanceMetroSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueDailyCashMetro.equals("")){
                                            AdditionalDailyCashMetro= Double.parseDouble(PremiumValueDailyCashMetro);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    DailyCashCardView.setVisibility(View.VISIBLE);
//                                                    DailyCashAllowanceNamePremium.setText(PremiumValue);
//                                                }else{
//                                                    DailyCashAllowanceNamePremium.setText(PremiumValue);
//                                                    DailyCashCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            DailyCashCardView.setVisibility(View.GONE);
                                            PremiumValueDailyCashMetro="0.0";
                                        }


                                    }
                                    else if (Value.equals("DAILY CASH ALLOWANCE - NONMETRO")){
                                        PremiumValueNonMetro=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        dailyCashAllowanceNonMetroRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        dailyCashAllowanceNonMetroSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueNonMetro.equals("")){
                                            AdditionalDailCash= Double.parseDouble(PremiumValueNonMetro);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    DailyCardView.setVisibility(View.VISIBLE);
//                                                    DailyCashNonMetroPremium.setText(PremiumValue);
//                                                }else{
//                                                    DailyCashNonMetroPremium.setText(PremiumValue);
//                                                    DailyCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            PremiumValueNonMetro="0.0";
                                            DailyCardView.setVisibility(View.GONE);
                                        }

                                    }
                                    else if (Value.equals("ENGINE PROTECTOR - DIESEL")){
                                        PremiumValueEngineProtecterDiesel=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        EngineProtectorDieselRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        EngineProtectorDieselSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueEngineProtecterDiesel.equals("")){
                                            AdditionalEngineDisesel= Double.parseDouble(PremiumValueEngineProtecterDiesel);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    EngineProtectorCardView.setVisibility(View.VISIBLE);
//                                                    EngineProtectorDieselPremium.setText(PremiumValue);
//                                                }else{
//                                                    EngineProtectorDieselPremium.setText(PremiumValue);
//                                                    EngineProtectorCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            EngineProtectorCardView.setVisibility(View.GONE);
                                            PremiumValueEngineProtecterDiesel="0.0";
                                        }
                                    }
                                    else if (Value.equals("ENGINE PROTECTOR - PETROL")){
                                        PremiumValueEngineProtecterPetrol=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        EngineProtectorPetrolRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        EngineProtectorPetrolSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueEngineProtecterPetrol.equals("")){
                                            AdditionalEnginePetrol= Double.parseDouble(PremiumValueEngineProtecterPetrol);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    EngineCardView.setVisibility(View.VISIBLE);
//                                                    EngineProtectorPetrolPremium.setText(PremiumValue);
//                                                }else{
//                                                    EngineProtectorPetrolPremium.setText(PremiumValue);
//                                                    EngineCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            EngineCardView.setVisibility(View.GONE);
                                            PremiumValueEngineProtecterPetrol="0.0";
                                        }

                                    }
                                    else if (Value.equals("HYDROSTATIC LOCK COVER")){
                                        PremiumValueHydrostaticLockDriver=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        HydrostaticLockRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        HydrostaticLockSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueHydrostaticLockDriver.equals("")){
                                            AdditionalHydrosaticLock= Double.parseDouble(PremiumValueHydrostaticLockDriver);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    HydrostaticeCardView.setVisibility(View.VISIBLE);
//                                                    HydrostaticeLockcoverPremium.setText(PremiumValue);
//                                                }else{
//                                                    HydrostaticeLockcoverPremium.setText(PremiumValue);
//                                                    HydrostaticeCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            HydrostaticeCardView.setVisibility(View.GONE);
                                            PremiumValueHydrostaticLockDriver="0.0";
                                        }

                                    }
                                    else if (Value.equals("KEY REPLACEMENT")){
                                        PremiumValueKeyReplacement=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        KeyReplacementRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        KeyReplacementSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueKeyReplacement.equals("")){
                                            AdditionalKeyReplacement= Double.parseDouble(PremiumValueKeyReplacement);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    KeyReplacementCardView.setVisibility(View.VISIBLE);
//                                                    KeyReplacementPremium.setText(PremiumValue);
//                                                }else{
//                                                    KeyReplacementPremium.setText(PremiumValue);
//                                                    KeyReplacementCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            KeyReplacementCardView.setVisibility(View.GONE);
                                            PremiumValueKeyReplacement="0.0";
                                        }

                                    }
                                    else if (Value.equals("Nil Depreciation Waiver cover")){
                                        PremiumValueNilDepreciation=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        NilDepreciationRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        NilDepreciationSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueNilDepreciation.equals("")){
                                            AdditionalNilDepreciation= Double.parseDouble(PremiumValueNilDepreciation);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    NilCardView.setVisibility(View.VISIBLE);
//                                                    NilDepreciationWaivercoverNamePremium.setText(PremiumValue);
//                                                }else{
//                                                    NilDepreciationWaivercoverNamePremium.setText(PremiumValue);
//                                                    NilCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            NilCardView.setVisibility(View.GONE);
                                            PremiumValueNilDepreciation="0.0";
                                        }

                                    }
                                    else if (Value.equals("RETURN TO INVOICE")){
                                        PremiumValueReturnToInvoice=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        ReturnToInvoiceRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        ReturnToInvoiceSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueReturnToInvoice.equals("")){
                                            AdditionalReturnInvoice= Double.parseDouble(PremiumValueReturnToInvoice);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    ReturnToInvoiceCardView.setVisibility(View.VISIBLE);
//                                                    ReturnToInvoicePremium.setText(PremiumValue);
//                                                }else{
//                                                    ReturnToInvoicePremium.setText(PremiumValue);
//                                                    ReturnToInvoiceCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            ReturnToInvoiceCardView.setVisibility(View.GONE);
                                            PremiumValueReturnToInvoice="0.0";
                                        }
                                    }
                                    else if (Value.equals("Road side Assistance")){
                                        PremiumValueRoadAssistance=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        RoadSideAssistanceRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        RoadSideAssistanceSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueRoadAssistance.equals("")){
                                            AdditionalRoadSide= Double.parseDouble(PremiumValueRoadAssistance);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    RoadsideAssistanceCardView.setVisibility(View.VISIBLE);
//                                                    RoadsideAssistancePremium.setText(PremiumValue);
//                                                }else{
//                                                    RoadsideAssistancePremium.setText(PremiumValue);
//                                                    RoadsideAssistanceCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            RoadsideAssistanceCardView.setVisibility(View.GONE);
                                            PremiumValueRoadAssistance="0.0";
                                        }

                                    }
                                    else if (Value.equals("SECURE TOWING")){
                                        PremiumValueSecureTowing=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        SecureTowingRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        SecureTowingSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueSecureTowing.equals("")){
                                            AdditionalsecureTowing= Double.parseDouble(PremiumValueSecureTowing);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    SecureTowingCardView.setVisibility(View.VISIBLE);
//                                                    SecureTowingPremium.setText(PremiumValue);
//                                                }else{
//                                                    SecureTowingPremium.setText(PremiumValue);
//                                                    SecureTowingCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            SecureTowingCardView.setVisibility(View.GONE);
                                            PremiumValueSecureTowing="0.0";
                                        }

                                    }
                                    else if (Value.equals("MANUFACTURER SELLING PRICE")) {
                                        PremiumValueManufacturerSelling=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        ManufacturesellingRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        ManufacturesellingSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueManufacturerSelling.equals("")){
                                            AdditionalCoverPremiumManufacturePrice= Double.parseDouble(PremiumValueManufacturerSelling);

//                                                if (!PremiumValue.equals("0.00")) {
//                                                    ManufacturePriceSellingCardView.setVisibility(View.VISIBLE);
//                                                    ManufacturePricePremiumTxt.setText(PremiumValue);
//                                                }else{
//                                                    ManufacturePricePremiumTxt.setText(PremiumValue);
//                                                    ManufacturePriceSellingCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            ManufacturePriceSellingCardView.setVisibility(View.GONE);
                                            PremiumValueManufacturerSelling="0.0";
                                        }
                                    }
                                    else if (Value.equals("Tyre and Rim secure")){
                                        PremiumValueTyreRim=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        TyreRimsecureRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        TyreRimsecureSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueTyreRim.equals("")){
                                            AdditionalTyreRim= Double.parseDouble(PremiumValueTyreRim);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    TyreCardView.setVisibility(View.VISIBLE);
//                                                    TyreAndRimSecurePremium.setText(PremiumValue);
//                                                }else{
//                                                    TyreAndRimSecurePremium.setText(PremiumValue);
//                                                    TyreCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            TyreCardView.setVisibility(View.GONE);
                                            PremiumValueTyreRim="0.0";
                                        }
                                    }
                                    else if (Value.equals("DRIVING TRAIN PROTECT")){
                                        PremiumValueDrivinngTrain=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        drivingTrainProtectRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        drivingTrainProtectSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");

                                        if (!PremiumValueDrivinngTrain.equals("")){
                                            AdditionalDrivingTrainProtect= Double.parseDouble(PremiumValueDrivinngTrain);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    DrivingTrainProtectCardView.setVisibility(View.VISIBLE);
//                                                    DrivingTrainProtectPremium.setText(PremiumValue);
//                                                }else{
//                                                    DrivingTrainProtectPremium.setText(PremiumValue);
//                                                    DrivingTrainProtectCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            DrivingTrainProtectCardView.setVisibility(View.GONE);
                                            PremiumValueDrivinngTrain="0.0";
                                        }
                                    }

//                                     if (addOnCoverJson.getString("Value").equals(Value)){
//                                         data1.clear();
//                                         for (int i = 0; i < AddonCoversDataJsonObject.length(); i++) {
//                                             String PremiumValueAddOn = AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("Premium").getString("Value");
//                                             if (!PremiumValueAddOn.equals("0.00")){
//                                                 JSONObject addOnCoverJsonPremium=AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("Premium");
//                                                 Log.e("addOnCoverJsonPremium",addOnCoverJsonPremium.toString());
//                                                 data1.add(
//                                                         new AddonCoverGroupsModel(
//                                                                 AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("AddonCoverGroups").getString("Value"),
//                                                                 AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("Premium").getString("Value")
//                                                         )
//                                                 );
//                                             }
//
//                                             if (data1.size() != 0) {
//                                                 CoverAddOnText.setVisibility(View.GONE);
//                                                 addOnCoverRecyclerview.setVisibility(View.VISIBLE);
//                                                 addOnCoverageRecy = new AddOnCoverageRecy(Motor_AddOns.this,data1);
//                                                 addOnCoverRecyclerview.setLayoutManager(new LinearLayoutManager(Motor_AddOns.this,LinearLayoutManager.HORIZONTAL,false));
//                                                 addOnCoverRecyclerview.setHasFixedSize(true);
//                                                 addOnCoverRecyclerview.setAdapter(addOnCoverageRecy);
//
//                                             }else{
//                                                 CoverAddOnText.setVisibility(View.VISIBLE);
//                                                 addOnCoverRecyclerview.setVisibility(View.GONE);
//                                             }
//
//
//                                         }
//                                     }
                                }

                                double DoubleValueAddition= AdditionalHospitalization+WrongFuelCover+AdditionalCostOfConsumbales+AdditionalDailyCashMetro+AdditionalDailCash+AdditionalEngineDisesel+AdditionalEnginePetrol+AdditionalHydrosaticLock+AdditionalKeyReplacement+AdditionalNilDepreciation+AdditionalReturnInvoice+AdditionalRoadSide+AdditionalsecureTowing+AdditionalTyreRim+AdditionalDrivingTrainProtect+AdditionalCoverPremiumManufacturePrice;
                                addOnsAditional=String.format("%.2f", DoubleValueAddition);
                                Log.e("addOnsAditional", addOnsAditional);


                                double addOnsDouble= (Double.parseDouble(addOnsCover)+Double.parseDouble(addOnsAditional));
                                addOns= String.valueOf(Math.round(addOnsDouble * 100) / 100.0);
                                Log.e("addOns", addOns);

                                String  TotalValue = TotalPremiumJsonObject.getString("Value");
                                TotalPremium.setText(TotalValue);
                                Log.e("dbjhdfbhf",TotalValue);

                                if (OneYearComprehensiveRadio.isChecked()){
                                    OneYearComprehensiveTxt.setText(TotalValue);
                                    TotalPremiumComprehensive.setText(TotalValue);
                                    thirdComprehensiveTxt.setText("");
                                    FiveComprehensiveTxt.setText("");
                                    StandardPlanPremiumTxt.setText("");
                                    TotalPremiumTp.setText("");
                                    StandardPlanPremium.setText("");
                                    TPTextView.setText("");
                                }

                                for (int l=0; l <OtherDiscountGroupDataJsonObject.length();l++) {
                                    JSONObject DescriptionJson = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Description");
                                    Log.e("DescriptionJson", DescriptionJson.toString());

                                    String DiscountValue = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Description").getString("Value");
                                    if (DiscountValue.equals("Antitheft device discount")) {
                                        strAntitheftdeviceDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        AntitheftdeviceRateValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Rate").getString("Value");
                                        AntitheftdeviceSumInsuredValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("SumInsured").getString("Value");
                                        if (!strAntitheftdeviceDiscount.equals("")){
                                            doubleAntitheftdeviceDiscount= Double.parseDouble(strAntitheftdeviceDiscount);
                                        }else{
                                            AntitheftdeviceCardView.setVisibility(View.GONE);
                                            strAntitheftdeviceDiscount="0.0";
                                        }

                                        Log.e("strAntitheftdevicediscount",strAntitheftdeviceDiscount);
                                    }
                                    else if (DiscountValue.equals("Automobile Association discount")) {
                                        AutomobileAssociationDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        AutomobileAssociationRateValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Rate").getString("Value");
                                        AutomobileAssociationSumInsuredValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("SumInsured").getString("Value");
                                        if (!AutomobileAssociationDiscount.equals("")){
                                            doubleAutomobileAssociationDiscount= Double.parseDouble(AutomobileAssociationDiscount);
                                            Log.e("doubleAutomobileAssociationDiscount",AutomobileAssociationDiscount);
                                            if (!AutomobileAssociationDiscount.equals("0.00")) {
                                                AutomobilePremiumTxt.setText(String.valueOf(doubleAutomobileAssociationDiscount));
                                                AutomobilePremiumTxt.setVisibility(View.VISIBLE);
                                            }else{
                                                AutomobilePremiumTxt.setVisibility(View.INVISIBLE);
                                            }
                                        }
                                        else{
                                            AutomobileCardView.setVisibility(View.GONE);
                                            AutomobileAssociationDiscount="0.0";
                                        }

                                    }
                                    else if (DiscountValue.equals("Handicap Discount")) {
                                        StrHandicapDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        HandicapRateValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Rate").getString("Value");
                                        HandicapSumInsuredValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("SumInsured").getString("Value");
                                        if (!StrHandicapDiscount.equals("")){
                                            doubleHandicapDiscount= Double.parseDouble(StrHandicapDiscount);
                                        }else{
                                            HandicapDiscountCardView.setVisibility(View.GONE);
                                            StrHandicapDiscount="0.0";
                                        }

                                        Log.e("StrHandicapDiscount",StrHandicapDiscount);

                                    }
                                    else if (DiscountValue.equals("TPPD Discount")) {
                                        StrTPPDDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        TPPDDiscountRateValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Rate").getString("Value");
                                        TPPDDiscountSumInsuredValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("SumInsured").getString("Value");
                                        if (!StrTPPDDiscount.equals("")){
                                            doubleTPPDDiscount= Double.parseDouble(StrTPPDDiscount);
                                        }else{
                                            TPPDCardView.setVisibility(View.GONE);
                                            StrTPPDDiscount="0.0";
                                        }
                                        Log.e("StrTPPDDiscount",StrTPPDDiscount);

                                    }
                                    else if (DiscountValue.equals("Voluntary deductable")) {
                                        StrVotaryDeductablelun = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        VotaryRateValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Rate").getString("Value");
                                        VotarySumInsuredValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("SumInsured").getString("Value");
                                        if (!StrVotaryDeductablelun.equals("")){
                                            doubleVotaryDiscount= Double.parseDouble(StrVotaryDeductablelun);
                                            if (StrVotaryDeductablelun.equals("0.00")) {
                                                VotaryPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                VotaryPremiumTxt.setVisibility(View.VISIBLE);
                                            }
                                            VotaryPremiumTxt.setText(StrVotaryDeductablelun);
                                        }else{
                                            VotaryCardView.setVisibility(View.GONE);
                                            StrVotaryDeductablelun="0.0";
                                        }
                                        Log.e("StrVotaryDeductablelun",StrVotaryDeductablelun);

                                    }
                                    else if (DiscountValue.equals("No claim bonus")) {
                                        StrNCB = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        Log.e("NCB",StrNCB);

                                    }
                                }

                                double DoubleValueDiscount= doubleAntitheftdeviceDiscount+doubleAutomobileAssociationDiscount+doubleHandicapDiscount+doubleTPPDDiscount+doubleVotaryDiscount;
                                DiscountsVale=String.format("%.2f", DoubleValueDiscount);
                                Log.e("DiscountsVale", DiscountsVale);
                            }
                            else{
                                JSONObject DetarifficDescription = DetariffDiscountGroupData.getJSONObject("Description");
                                String DetarifficValue = DetarifficDescription.getString("Value");
                                if (DetarifficValue.equals("De-tariff Discount")) {
                                    DetarifficValuePremium = DetariffDiscountGroupData.getJSONObject("Premium").getString("Value");
                                    strDiscountEdit = DetariffDiscountGroupData.getJSONObject("Premium").getString("Value");
                                    DetarifficValueRate = DetariffDiscountGroupData.getJSONObject("Rate").getString("Value");
                                    DetarifficValueSumInsure = DetariffDiscountGroupData.getJSONObject("SumInsured").getString("Value");
                                    if (!DetarifficValuePremium.equals("")){
                                        DetarifficValuePremiumDouble= Double.parseDouble(DetarifficValuePremium);
                                        StrDetarifficValuePremiumDouble= String.valueOf(DetarifficValuePremiumDouble);
                                        Log.e("DetarifficValuePremium",DetarifficValuePremium);
                                    }else{
                                        DetarifficValuePremium="0.0";
                                    }
                                }
                                JSONObject DeTariffLoadingDescription = DetariffLoadingGroupData.getJSONObject("Description");
                                String DetarifficLodingValue = DeTariffLoadingDescription.getString("Value");
                                if (DetarifficLodingValue.equals("De -tariff Loading")) {
                                    DetarifficLodingValuePremium = DetariffLoadingGroupData.getJSONObject("Premium").getString("Value");
                                    DetarifficLoadingValueRate = DetariffLoadingGroupData.getJSONObject("Rate").getString("Value");
                                    DetarifficLoadingValueSumInsured= DetariffLoadingGroupData.getJSONObject("SumInsured").getString("Value");
                                    if (!DetarifficLodingValuePremium.equals("")){
                                        DetarifficLoadingValuePremiumDouble= Double.parseDouble(DetarifficLodingValuePremium);
                                        StrDetarifficLoadingValuePremiumDouble= String.valueOf(DetarifficLoadingValuePremiumDouble);
                                        Log.e("StrDetarifficLoadingValuePremiumDouble",StrDetarifficLoadingValuePremiumDouble);
                                    }else{
                                        DetarifficLodingValuePremium="0.0";
                                    }
                                }

                                for (int k=0; k <CoversDataJsonObject.length();k++) {
                                    JSONObject CoverGroupsJson = CoversDataJsonObject.getJSONObject(k).optJSONObject("CoverGroups");
                                    Log.e("CoverGroupsJson", CoverGroupsJson.toString());

                                    String Value = CoverGroupsJson.getString("Value");
                                    if (Value.equals("Basic OD")) {
                                        BasicODCardView.setVisibility(View.GONE);
                                        AdditionalCoverBasicOdPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        if (!AdditionalCoverBasicOdPremium.equals("")){
                                            AdditionalCoverPremiumOD= Double.parseDouble(AdditionalCoverBasicOdPremium);
                                            StrAdditionalCoverPremiumOD= String.valueOf(AdditionalCoverPremiumOD);
                                            Log.e("AdditionalCoverPremiumOD",AdditionalCoverBasicOdPremium);
                                            if (!AdditionalCoverBasicOdPremium.equals("0.00")) {
                                                BasicODCardView.setVisibility(View.GONE);
                                                BasicODPremiumTxt.setText(AdditionalCoverBasicOdPremium);
                                            } else {
                                                BasicODCardView.setVisibility(View.GONE);
                                                BasicODPremiumTxt.setText(AdditionalCoverBasicOdPremium);
                                            }
                                        }else{
                                            BasicODCardView.setVisibility(View.GONE);
                                            AdditionalCoverBasicOdPremium="0.0";
                                        }

                                    }
                                    else if (Value.equals("Basic TP")) {
                                        BasicTPCardView.setVisibility(View.GONE);
                                        AdditionalBasicTpCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        Log.e("AdditionalCoverPremiumTp",AdditionalBasicTpCoverPremium);
                                        if (!AdditionalBasicTpCoverPremium.equals("")){
                                            AdditionalCoverPremiumTP= Double.parseDouble(AdditionalBasicTpCoverPremium);
                                            StrAdditionalCoverPremiumTp= String.valueOf(AdditionalCoverPremiumTP);
                                            Log.e("AdditionalCoverPremiumTP",AdditionalBasicTpCoverPremium);
                                            if (!AdditionalBasicTpCoverPremium.equals("0.00")) {
                                                BasicTPCardView.setVisibility(View.GONE);
                                                BasicTPPremiumTxt.setText(AdditionalBasicTpCoverPremium);
                                            } else {
                                                BasicTPCardView.setVisibility(View.GONE);
                                                BasicTPPremiumTxt.setText(AdditionalBasicTpCoverPremium);
                                            }
                                        }else{
                                            BasicTPCardView.setVisibility(View.GONE);
                                            AdditionalBasicTpCoverPremium="0.0";
                                        }
                                    }
                                    else if (Value.equals("ELECTRICAL ACCESSORY OD")) {
                                        AdditionalCoverPremiumElectrical = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalElectricalRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalElectricalSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumElectrical.equals("")){
                                            AdditionalCoverPremiumEl= Double.parseDouble(AdditionalCoverPremiumElectrical);
                                            ElectricalPremiumTxt.setText(AdditionalCoverPremiumElectrical);
                                            if (AdditionalCoverPremiumElectrical.equals("0.00")) {
                                                ElectricalPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                ElectricalPremiumTxt.setVisibility(View.VISIBLE);
                                            }

                                            Log.e("AdditionalCoverPremiumEl",AdditionalCoverPremiumElectrical);
//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    ElectricalCardView.setVisibility(View.VISIBLE);
//                                                    ElectricalPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    ElectricalCardView.setVisibility(View.VISIBLE);
//                                                    ElectricalPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            ElectricalCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumElectrical="0.0";
                                        }

                                    }
                                    else if (Value.equals("FIBERTANK OD")) {
                                        AdditionalCoverPremiumFiberTank = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalFibertankODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalFibertankODSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumFiberTank.equals("")){
                                            AdditionalCoverPremiumFI= Double.parseDouble(AdditionalCoverPremiumFiberTank);
                                            Log.e("AdditionalCoverPremiumFI", String.valueOf(AdditionalCoverPremiumFiberTank));

//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    FIBERTANKODCardView.setVisibility(View.VISIBLE);
//                                                    FIBERTANKPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    FIBERTANKODCardView.setVisibility(View.VISIBLE);
//                                                    FIBERTANKPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            FIBERTANKODCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumFiberTank="0.0";
                                        }

                                    }
                                    else if (Value.equals("LEGAL LIABILITY TO PAID DRIVER")) {
                                        AdditionalCoverPremiumPaidDriver = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalLegalLiabilityPaidRate = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalLegalLiabilityPaidSumInsured = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumPaidDriver.equals("")){
                                            AdditionalCoverPremiumLegal= Double.parseDouble(AdditionalCoverPremiumPaidDriver);
                                            Log.e("AdditionalCoverPremiumLegal", String.valueOf(AdditionalCoverPremiumPaidDriver));
//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    LegalLiabilityCardView.setVisibility(View.VISIBLE);
//                                                    LegalPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    LegalLiabilityCardView.setVisibility(View.VISIBLE);
//                                                    LegalPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            LegalLiabilityCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumPaidDriver="0.0";
                                        }
                                    }
                                    else if (Value.equals("NON ELECTRICAL ACCESSORY OD")) {
                                        AdditionalCoverPremiumNonElectrical = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalNonElecticalODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalNonElecticalODSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumNonElectrical.equals("")){
                                            AdditionalCoverPremiumNon= Double.parseDouble(AdditionalCoverPremiumNonElectrical);
                                            NonElectricalPremiumTxt.setText(AdditionalCoverPremiumNonElectrical);

                                            if (AdditionalCoverPremiumNonElectrical.equals("0.00")) {
                                                NonElectricalPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                NonElectricalPremiumTxt.setVisibility(View.VISIBLE);
                                            }
//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    NonLegalLiabilityCardView.setVisibility(View.VISIBLE);
//                                                    NonElectricalPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    NonLegalLiabilityCardView.setVisibility(View.VISIBLE);
//                                                    NonElectricalPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            NonLegalLiabilityCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumNonElectrical="0.0";
                                        }

                                    }
                                    else if (Value.equals("Other OD")) {
                                        AdditionalCoverPremiumCoverOtherOD = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalOtherODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalOtherODRateSumInsured = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");

                                        if (!AdditionalCoverPremiumCoverOtherOD.equals("")){
                                            AdditionalCoverPremiumOtherOD= Double.parseDouble(AdditionalCoverPremiumCoverOtherOD);
                                            Log.e("AdditionalCoverPremiumOtherOD", String.valueOf(AdditionalCoverPremiumOtherOD));

//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    OtherOdCardView.setVisibility(View.VISIBLE);
//                                                    OtherOdPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    OtherOdCardView.setVisibility(View.VISIBLE);
//                                                    OtherOdPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            OtherOdCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCoverOtherOD="0.0";
                                        }
                                    }
                                    else if (Value.equals("Other TP")) {
                                        AdditionalCoverPremiumCoverOtherTP = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalOtherTpRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalOtherTpSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumCoverOtherTP.equals("")){
                                            AdditionalCoverPremiumOtherTP= Double.parseDouble(AdditionalCoverPremiumCoverOtherTP);
                                            Log.e("AdditionalCoverPremiumOtherTP", String.valueOf(AdditionalCoverPremiumOtherTP));
//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    OtherTpCardView.setVisibility(View.VISIBLE);
//                                                    OtherTpPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    OtherTpCardView.setVisibility(View.VISIBLE);
//                                                    OtherTpPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            OtherTpCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCoverOtherTP="0.0";
                                        }
                                    }
//                                            else if (Value.equals("PA COVER TO EMPLOYEES OF INSURED")) {
//                                                AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
//                                                AdditionalPaCoversToEmployessRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
//                                                if (!AdditionalCoverPremium.equals("")){
//                                                    AdditionalCoverPremiumPACOVER= Double.parseDouble(AdditionalCoverPremium);
//                                                    if (!AdditionalCoverPremium.equals("0.00")) {
//                                                        EMPLOYEESCardView.setVisibility(View.VISIBLE);
//                                                        EmployeesInsuredPremiumTxt.setText(AdditionalCoverPremium);
//                                                    } else {
//                                                        EMPLOYEESCardView.setVisibility(View.VISIBLE);
//                                                        EmployeesInsuredPremiumTxt.setText(AdditionalCoverPremium);
//                                                    }
//                                                }else{
//                                                    EMPLOYEESCardView.setVisibility(View.GONE);
//                                                    AdditionalCoverPremium="0.0";
//                                                }
//
//                                            }
                                    else if (Value.equals("PA COVER TO OWNER DRIVER")) {
                                        AdditionalCoverPremiumOwnerDriver = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalPaCoverToOwnerDriverRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalPaCoverToOwnerDriverSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (strGPACover.equals("Yes")||strPACover.equals("Yes")){
                                            OwnerDriverCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumOwnerDriver="0.0";
                                            AdditionalCoverPremiumOWNERDRIVER= Double.parseDouble(AdditionalCoverPremiumOwnerDriver);
                                        }else{
                                            if (!AdditionalCoverPremiumOwnerDriver.equals("")){
                                                AdditionalCoverPremiumOWNERDRIVER= Double.parseDouble(AdditionalCoverPremiumOwnerDriver);
                                                Log.e("AdditionalCoverPremiumOWNERDRIVER", String.valueOf(AdditionalCoverPremiumOWNERDRIVER));
                                                if (!AdditionalCoverPremiumOwnerDriver.equals("0.00")) {
                                                    OwnerDriverCardView.setVisibility(View.GONE);
                                                    OwnerDriverPremiumTxt.setText(AdditionalCoverPremiumOwnerDriver);
                                                } else {
                                                    OwnerDriverCardView.setVisibility(View.GONE);
                                                    OwnerDriverPremiumTxt.setText(AdditionalCoverPremiumOwnerDriver);
                                                }
                                            }else{
                                                OwnerDriverCardView.setVisibility(View.GONE);
                                                AdditionalCoverPremiumOwnerDriver="0.0";
                                            }
                                        }
                                    }
                                    else if (Value.equals("PA COVER TO PAID DRIVER")) {
                                        AdditionalCoverPremiumPaPaidDriver = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalPaidDriverRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalPaidDriverSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumPaPaidDriver.equals("")){
                                            AdditionalCoverPremiumPAIDDRIVER= Double.parseDouble(AdditionalCoverPremiumPaPaidDriver);
                                            Log.e("AdditionalCoverPremiumPAIDDRIVER", String.valueOf(AdditionalCoverPremiumPaPaidDriver));
                                            PaidDriverPremiumTxt.setText(AdditionalCoverPremiumPaPaidDriver);
                                            if (AdditionalCoverPremiumPaPaidDriver.equals("0.00")) {
                                                PaidDriverPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                PaidDriverPremiumTxt.setVisibility(View.VISIBLE);
                                            }

//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    PaidDriverCardView.setVisibility(View.VISIBLE);
//                                                    PaidDriverPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    PaidDriverCardView.setVisibility(View.VISIBLE);
//                                                    PaidDriverPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            PaidDriverCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumPaPaidDriver="0.0";
                                        }
                                    }
                                    else if (Value.equals("PA COVER TO PASSENGERS")) {
                                        AdditionalCoverPremiumPaPassenger = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalPaToPassengersRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalPaToPassengersSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");

                                        if (!AdditionalCoverPremiumPaPassenger.equals("")){
                                            AdditionalCoverPremiumPASSENGERS= Double.parseDouble(AdditionalCoverPremiumPaPassenger);
                                            Log.e("AdditionalCoverPremiumPASSENGERS", String.valueOf(AdditionalCoverPremiumPASSENGERS));
                                            PassengersPremiumTxt.setText(AdditionalCoverPremiumPaPassenger);
                                            if (AdditionalCoverPremiumPaPassenger.equals("0.00")) {
                                                PassengersPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                PassengersPremiumTxt.setVisibility(View.VISIBLE);
                                            }
//                                                if (!AdditionalCoverPremium.equals("0.00")) {
//                                                    PASSENGERSCardView.setVisibility(View.VISIBLE);
//                                                    PassengersPremiumTxt.setText(AdditionalCoverPremium);
//                                                } else {
//                                                    PASSENGERSCardView.setVisibility(View.VISIBLE);
//                                                    PassengersPremiumTxt.setText(AdditionalCoverPremium);
//                                                }
                                        }else{
                                            PASSENGERSCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumPaPassenger="0.0";
                                        }
                                    }
                                    else if (Value.equals("UNNAMED PA COVER TO PASSENGERS")) {
                                        AdditionalCoverPremiumUnnamedPassenger = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalUnnamedPassengersRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalUnnamedPassengersSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");

                                        if (!AdditionalCoverPremiumUnnamedPassenger.equals("")){
                                            AdditionalCoverPremiumUNNAMED= Double.parseDouble(AdditionalCoverPremiumUnnamedPassenger);
                                            Log.e("AdditionalCoverPremiumUNNAMED", String.valueOf(AdditionalCoverPremiumUNNAMED));
                                            UnnamedPassengersPremiumTxt.setText(AdditionalCoverPremiumUnnamedPassenger);
                                            if (AdditionalCoverPremiumUnnamedPassenger.equals("0.00")) {
                                                UnnamedPassengersPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                UnnamedPassengersPremiumTxt.setVisibility(View.VISIBLE);
                                            }
                                        }else{
                                            UnnamedPassengerCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumUnnamedPassenger="0.0";
                                        }
                                    }
                                    else if (Value.equals("CNGLPG KIT OD")) {
                                        AdditionalCoverPremiumCngLpgOd = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalCngKitODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalCngKitODSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");

                                        if (!AdditionalCoverPremiumCngLpgOd.equals("")){
                                            AdditionalCoverPremiumCNGLPG= Double.parseDouble(AdditionalCoverPremiumCngLpgOd);
                                            Log.e("AdditionalCoverPremiumCNGLPG", String.valueOf(AdditionalCoverPremiumCNGLPG));
                                            if (AdditionalCoverPremiumCngLpgOd.equals("0.00")) {
                                                CNGLPGKITODPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                CNGLPGKITODPremiumTxt.setVisibility(View.VISIBLE);
                                            }
                                            CNGLPGKITODPremiumTxt.setText(AdditionalCoverPremiumCngLpgOd);
                                        }else{
                                            CngStatusCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCngLpgOd="0.0";
                                        }
                                    }
                                    else if (Value.equals("CNGLPG KIT TP")) {
                                        AdditionalCoverPremiumCngLpgKitTp = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalCngLpgTpRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalCngLpgTpSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");

                                        if (!AdditionalCoverPremiumCngLpgKitTp.equals("")){
                                            AdditionalCoverPremiumCNGLPGTP= Double.parseDouble(AdditionalCoverPremiumCngLpgKitTp);
                                            Log.e("AdditionalCoverPremiumCNGLPGTP", String.valueOf(AdditionalCoverPremiumCNGLPGTP));
                                            if (AdditionalCoverPremiumCngLpgKitTp.equals("0.00")) {
                                                CNGLPGKITTPPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                CNGLPGKITTPPremiumTxt.setVisibility(View.VISIBLE);
                                            }
                                            CNGLPGKITTPPremiumTxt.setText(AdditionalCoverPremiumCngLpgKitTp);
                                        }else{
                                            CNGLPGKITTPStatusCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumCngLpgKitTp="0.0";
                                        }
                                    }
                                    else if (Value.equals("BUILTIN CNGLPG KIT OD")) {
                                        AdditionalCoverPremiumBuiltingKitOD = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalBuiltinKitODRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalBuiltinKitODSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");

                                        if (!AdditionalCoverPremiumBuiltingKitOD.equals("")){
                                            AdditionalCoverPremiumBUILTINOD= Double.parseDouble(AdditionalCoverPremiumBuiltingKitOD);
                                            Log.e("AdditionalCoverPremiumBUILTINOD", String.valueOf(AdditionalCoverPremiumBUILTINOD));
                                            if (AdditionalCoverPremiumBuiltingKitOD.equals("0.00")) {
                                                BUILTINCNGKITPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                BUILTINCNGKITPremiumTxt.setVisibility(View.VISIBLE);
                                            }
                                            BUILTINCNGKITPremiumTxt.setText(AdditionalCoverPremiumBuiltingKitOD);
                                        }else{
                                            BUILTINCNGKITCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumBuiltingKitOD="0.0";
                                        }
                                    }
                                    else if (Value.equals("BUILTIN CNGLPG KIT TP")) {
                                        AdditionalCoverPremiumBultinKitTp = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                        AdditionalBuiltinCngTPRateValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("Rate").getString("Value");
                                        AdditionalBuiltinCngTPSumInsuredValue = CoversDataJsonObject.getJSONObject(k).optJSONObject("SumInsured").getString("Value");
                                        if (!AdditionalCoverPremiumBultinKitTp.equals("")){
                                            AdditionalCoverPremiumBuiltinCngLPGTp= Double.parseDouble(AdditionalCoverPremiumBultinKitTp);
                                            Log.e("AdditionalCoverPremiumBuiltinCngLPGTp", String.valueOf(AdditionalCoverPremiumBuiltinCngLPGTp));
                                            if (AdditionalCoverPremiumBultinKitTp.equals("0.00")) {
                                                BuiltinCngLPGTpPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                BuiltinCngLPGTpPremiumTxt.setVisibility(View.VISIBLE);
                                            }
                                            BuiltinCngLPGTpPremiumTxt.setText(AdditionalCoverPremiumBultinKitTp);
                                        }else{
                                            BuiltinCngLPGTpCardView.setVisibility(View.GONE);
                                            AdditionalCoverPremiumBultinKitTp="0.0";
                                        }
                                    }


                                }
                                double DoubleValue=AdditionalCoverPremiumNon+AdditionalCoverPremiumEl+AdditionalCoverPremiumFI+AdditionalCoverPremiumLegal+AdditionalCoverPremiumOtherOD+AdditionalCoverPremiumOtherTP+AdditionalCoverPremiumPAIDDRIVER+AdditionalCoverPremiumPASSENGERS+AdditionalCoverPremiumUNNAMED+AdditionalCoverPremiumCNGLPG+AdditionalCoverPremiumCNGLPGTP+AdditionalCoverPremiumBUILTINOD+AdditionalCoverPremiumBuiltinCngLPGTp+AdditionalCoverPremiumOWNERDRIVER;
                                addOnsCover=String.format("%.2f", DoubleValue);

                                for (int j=0; j <AddonCoversDataJsonObject.length();j++){
                                    JSONObject addOnCoverJson=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("AddonCoverGroups");
                                    Log.e("addOnCoverJson",addOnCoverJson.toString());

                                    String Value  = addOnCoverJson.getString("Value");
                                    if (Value.equals("DAILY CASH ALLOWANCE")){
                                        PremiumValueDailyCash=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        DailyCashRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        DailyCashRateSumInsured=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueDailyCash.equals("")){
//                                                DailyCashAllowance= Double.parseDouble(PremiumValue);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    DailCashAllownceCardView.setVisibility(View.GONE);
//                                                    DailyCashAllowancePremium.setText(PremiumValue);
//                                                }else{
//                                                    DailyCashAllowancePremium.setText(PremiumValue);
//                                                    DailCashAllownceCardView.setVisibility(View.GONE);
//                                                }
                                        }else{
                                            DailCashAllownceCardView.setVisibility(View.GONE);
                                            PremiumValueDailyCash="0.0";
                                        }

                                    }
                                    else if (Value.equals("ACCIDENTAL HOSPITALIZATION")){
                                        PremiumValueAccidentalHospitalization=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        AccidentalRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        AccidentalSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueAccidentalHospitalization.equals("")){
                                            AdditionalHospitalization= Double.parseDouble(PremiumValueAccidentalHospitalization);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    AccidentalCardView.setVisibility(View.VISIBLE);
//                                                    AccidentalHospitalPremium.setText(PremiumValue);
//                                                }else{
//                                                    AccidentalHospitalPremium.setText(PremiumValue);
//                                                    AccidentalCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            AccidentalCardView.setVisibility(View.GONE);
                                            PremiumValueAccidentalHospitalization="0.0";
                                        }

                                    }
                                    else if (Value.equals("WRONG FUEL COVER")){
                                        PremiumValueWrongFuelCover=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        WrongFuelRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        WrongFuelSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueWrongFuelCover.equals("")){
                                            WrongFuelCover= Double.parseDouble(PremiumValueWrongFuelCover);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    WrongFuelCardView.setVisibility(View.VISIBLE);
//                                                    WrongFuelTxtPremium.setText(PremiumValue);
//                                                }else{
//                                                    WrongFuelTxtPremium.setText(PremiumValue);
//                                                    WrongFuelCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            WrongFuelCardView.setVisibility(View.GONE);
                                            PremiumValueWrongFuelCover="0.0";
                                        }

                                    }
                                    else if (Value.equals("COST OF CONSUMABLES")){
                                        PremiumValueCostConsumables=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        CostOfConsumablesRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        CostOfConsumablesSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueCostConsumables.equals("")){
                                            AdditionalCostOfConsumbales= Double.parseDouble(PremiumValueCostConsumables);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    CostOfCardView.setVisibility(View.VISIBLE);
//                                                    CostOfConsumableNamePremium.setText(PremiumValue);
//                                                }else{
//                                                    CostOfConsumableNamePremium.setText(PremiumValue);
//                                                    CostOfCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            CostOfCardView.setVisibility(View.GONE);
                                            PremiumValueCostConsumables="0.0";
                                        }
                                    }
                                    else if (Value.equals("DAILY CASH ALLOWANCE - METRO")){
                                        PremiumValueDailyCashMetro=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        dailyCashAllowanceMetroRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        dailyCashAllowanceMetroSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueDailyCashMetro.equals("")){
                                            AdditionalDailyCashMetro= Double.parseDouble(PremiumValueDailyCashMetro);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    DailyCashCardView.setVisibility(View.VISIBLE);
//                                                    DailyCashAllowanceNamePremium.setText(PremiumValue);
//                                                }else{
//                                                    DailyCashAllowanceNamePremium.setText(PremiumValue);
//                                                    DailyCashCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            DailyCashCardView.setVisibility(View.GONE);
                                            PremiumValueDailyCashMetro="0.0";
                                        }


                                    }
                                    else if (Value.equals("DAILY CASH ALLOWANCE - NONMETRO")){
                                        PremiumValueNonMetro=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        dailyCashAllowanceNonMetroRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        dailyCashAllowanceNonMetroSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueNonMetro.equals("")){
                                            AdditionalDailCash= Double.parseDouble(PremiumValueNonMetro);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    DailyCardView.setVisibility(View.VISIBLE);
//                                                    DailyCashNonMetroPremium.setText(PremiumValue);
//                                                }else{
//                                                    DailyCashNonMetroPremium.setText(PremiumValue);
//                                                    DailyCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            PremiumValueNonMetro="0.0";
                                            DailyCardView.setVisibility(View.GONE);
                                        }

                                    }
                                    else if (Value.equals("ENGINE PROTECTOR - DIESEL")){
                                        PremiumValueEngineProtecterDiesel=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        EngineProtectorDieselRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        EngineProtectorDieselSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueEngineProtecterDiesel.equals("")){
                                            AdditionalEngineDisesel= Double.parseDouble(PremiumValueEngineProtecterDiesel);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    EngineProtectorCardView.setVisibility(View.VISIBLE);
//                                                    EngineProtectorDieselPremium.setText(PremiumValue);
//                                                }else{
//                                                    EngineProtectorDieselPremium.setText(PremiumValue);
//                                                    EngineProtectorCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            EngineProtectorCardView.setVisibility(View.GONE);
                                            PremiumValueEngineProtecterDiesel="0.0";
                                        }
                                    }
                                    else if (Value.equals("ENGINE PROTECTOR - PETROL")){
                                        PremiumValueEngineProtecterPetrol=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        EngineProtectorPetrolRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        EngineProtectorPetrolSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueEngineProtecterPetrol.equals("")){
                                            AdditionalEnginePetrol= Double.parseDouble(PremiumValueEngineProtecterPetrol);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    EngineCardView.setVisibility(View.VISIBLE);
//                                                    EngineProtectorPetrolPremium.setText(PremiumValue);
//                                                }else{
//                                                    EngineProtectorPetrolPremium.setText(PremiumValue);
//                                                    EngineCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            EngineCardView.setVisibility(View.GONE);
                                            PremiumValueEngineProtecterPetrol="0.0";
                                        }

                                    }
                                    else if (Value.equals("HYDROSTATIC LOCK COVER")){
                                        PremiumValueHydrostaticLockDriver=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        HydrostaticLockRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        HydrostaticLockSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueHydrostaticLockDriver.equals("")){
                                            AdditionalHydrosaticLock= Double.parseDouble(PremiumValueHydrostaticLockDriver);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    HydrostaticeCardView.setVisibility(View.VISIBLE);
//                                                    HydrostaticeLockcoverPremium.setText(PremiumValue);
//                                                }else{
//                                                    HydrostaticeLockcoverPremium.setText(PremiumValue);
//                                                    HydrostaticeCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            HydrostaticeCardView.setVisibility(View.GONE);
                                            PremiumValueHydrostaticLockDriver="0.0";
                                        }

                                    }
                                    else if (Value.equals("KEY REPLACEMENT")){
                                        PremiumValueKeyReplacement=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        KeyReplacementRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        KeyReplacementSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueKeyReplacement.equals("")){
                                            AdditionalKeyReplacement= Double.parseDouble(PremiumValueKeyReplacement);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    KeyReplacementCardView.setVisibility(View.VISIBLE);
//                                                    KeyReplacementPremium.setText(PremiumValue);
//                                                }else{
//                                                    KeyReplacementPremium.setText(PremiumValue);
//                                                    KeyReplacementCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            KeyReplacementCardView.setVisibility(View.GONE);
                                            PremiumValueKeyReplacement="0.0";
                                        }

                                    }
                                    else if (Value.equals("Nil Depreciation Waiver cover")){
                                        PremiumValueNilDepreciation=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        NilDepreciationRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        NilDepreciationSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueNilDepreciation.equals("")){
                                            AdditionalNilDepreciation= Double.parseDouble(PremiumValueNilDepreciation);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    NilCardView.setVisibility(View.VISIBLE);
//                                                    NilDepreciationWaivercoverNamePremium.setText(PremiumValue);
//                                                }else{
//                                                    NilDepreciationWaivercoverNamePremium.setText(PremiumValue);
//                                                    NilCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            NilCardView.setVisibility(View.GONE);
                                            PremiumValueNilDepreciation="0.0";
                                        }

                                    }
                                    else if (Value.equals("RETURN TO INVOICE")){
                                        PremiumValueReturnToInvoice=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        ReturnToInvoiceRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        ReturnToInvoiceSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueReturnToInvoice.equals("")){
                                            AdditionalReturnInvoice= Double.parseDouble(PremiumValueReturnToInvoice);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    ReturnToInvoiceCardView.setVisibility(View.VISIBLE);
//                                                    ReturnToInvoicePremium.setText(PremiumValue);
//                                                }else{
//                                                    ReturnToInvoicePremium.setText(PremiumValue);
//                                                    ReturnToInvoiceCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            ReturnToInvoiceCardView.setVisibility(View.GONE);
                                            PremiumValueReturnToInvoice="0.0";
                                        }
                                    }
                                    else if (Value.equals("Road side Assistance")){
                                        PremiumValueRoadAssistance=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        RoadSideAssistanceRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        RoadSideAssistanceSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueRoadAssistance.equals("")){
                                            AdditionalRoadSide= Double.parseDouble(PremiumValueRoadAssistance);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    RoadsideAssistanceCardView.setVisibility(View.VISIBLE);
//                                                    RoadsideAssistancePremium.setText(PremiumValue);
//                                                }else{
//                                                    RoadsideAssistancePremium.setText(PremiumValue);
//                                                    RoadsideAssistanceCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            RoadsideAssistanceCardView.setVisibility(View.GONE);
                                            PremiumValueRoadAssistance="0.0";
                                        }

                                    }
                                    else if (Value.equals("MANUFACTURER SELLING PRICE")) {
                                        PremiumValueManufacturerSelling=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        ManufacturesellingRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        ManufacturesellingSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueManufacturerSelling.equals("")){
                                            AdditionalCoverPremiumManufacturePrice= Double.parseDouble(PremiumValueManufacturerSelling);
//                                                if (!PremiumValue.equals("0.00")) {
//                                                    ManufacturePriceSellingCardView.setVisibility(View.VISIBLE);
//                                                    ManufacturePricePremiumTxt.setText(PremiumValue);
//                                                }else{
//                                                    ManufacturePricePremiumTxt.setText(PremiumValue);
//                                                    ManufacturePriceSellingCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            ManufacturePriceSellingCardView.setVisibility(View.GONE);
                                            PremiumValueManufacturerSelling="0.0";
                                        }
                                    }

                                    else if (Value.equals("SECURE TOWING")){
                                        PremiumValueSecureTowing=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        SecureTowingRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        SecureTowingSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueSecureTowing.equals("")){
                                            AdditionalsecureTowing= Double.parseDouble(PremiumValueSecureTowing);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    SecureTowingCardView.setVisibility(View.VISIBLE);
//                                                    SecureTowingPremium.setText(PremiumValue);
//                                                }else{
//                                                    SecureTowingPremium.setText(PremiumValue);
//                                                    SecureTowingCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            SecureTowingCardView.setVisibility(View.GONE);
                                            PremiumValueSecureTowing="0.0";
                                        }

                                    }
                                    else if (Value.equals("Tyre and Rim secure")){
                                        PremiumValueTyreRim=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        TyreRimsecureRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        TyreRimsecureSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");
                                        if (!PremiumValueTyreRim.equals("")){
                                            AdditionalTyreRim= Double.parseDouble(PremiumValueTyreRim);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    TyreCardView.setVisibility(View.VISIBLE);
//                                                    TyreAndRimSecurePremium.setText(PremiumValue);
//                                                }else{
//                                                    TyreAndRimSecurePremium.setText(PremiumValue);
//                                                    TyreCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            TyreCardView.setVisibility(View.GONE);
                                            PremiumValueTyreRim="0.0";
                                        }
                                    }
                                    else if (Value.equals("DRIVING TRAIN PROTECT")){
                                        PremiumValueDrivinngTrain=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                        drivingTrainProtectRateValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Rate").getString("Value");
                                        drivingTrainProtectSumInsuredValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("SumInsured").getString("Value");

                                        if (!PremiumValueDrivinngTrain.equals("")){
                                            AdditionalDrivingTrainProtect= Double.parseDouble(PremiumValueDrivinngTrain);
//                                                if (!PremiumValue.equals("0.00")){
//                                                    DrivingTrainProtectCardView.setVisibility(View.VISIBLE);
//                                                    DrivingTrainProtectPremium.setText(PremiumValue);
//                                                }else{
//                                                    DrivingTrainProtectPremium.setText(PremiumValue);
//                                                    DrivingTrainProtectCardView.setVisibility(View.VISIBLE);
//                                                }
                                        }else{
                                            DrivingTrainProtectCardView.setVisibility(View.GONE);
                                            PremiumValueDrivinngTrain="0.0";
                                        }
                                    }

//                                     if (addOnCoverJson.getString("Value").equals(Value)){
//                                         data1.clear();
//                                         for (int i = 0; i < AddonCoversDataJsonObject.length(); i++) {
//                                             String PremiumValueAddOn = AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("Premium").getString("Value");
//                                             if (!PremiumValueAddOn.equals("0.00")){
//                                                 JSONObject addOnCoverJsonPremium=AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("Premium");
//                                                 Log.e("addOnCoverJsonPremium",addOnCoverJsonPremium.toString());
//                                                 data1.add(
//                                                         new AddonCoverGroupsModel(
//                                                                 AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("AddonCoverGroups").getString("Value"),
//                                                                 AddonCoversDataJsonObject.getJSONObject(i).optJSONObject("Premium").getString("Value")
//                                                         )
//                                                 );
//                                             }
//
//                                             if (data1.size() != 0) {
//                                                 CoverAddOnText.setVisibility(View.GONE);
//                                                 addOnCoverRecyclerview.setVisibility(View.VISIBLE);
//                                                 addOnCoverageRecy = new AddOnCoverageRecy(Motor_AddOns.this,data1);
//                                                 addOnCoverRecyclerview.setLayoutManager(new LinearLayoutManager(Motor_AddOns.this,LinearLayoutManager.HORIZONTAL,false));
//                                                 addOnCoverRecyclerview.setHasFixedSize(true);
//                                                 addOnCoverRecyclerview.setAdapter(addOnCoverageRecy);
//
//                                             }else{
//                                                 CoverAddOnText.setVisibility(View.VISIBLE);
//                                                 addOnCoverRecyclerview.setVisibility(View.GONE);
//                                             }
//
//
//                                         }
//                                     }
                                }
                                for (int l=0; l <OtherDiscountGroupDataJsonObject.length();l++) {
                                    JSONObject DescriptionJson = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Description");
                                    Log.e("DescriptionJson", DescriptionJson.toString());

                                    String DiscountValue = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Description").getString("Value");
                                    if (DiscountValue.equals("Antitheft device discount")) {
                                        strAntitheftdeviceDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        AntitheftdeviceRateValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Rate").getString("Value");
                                        AntitheftdeviceSumInsuredValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("SumInsured").getString("Value");
                                        if (!strAntitheftdeviceDiscount.equals("")){
                                            doubleAntitheftdeviceDiscount= Double.parseDouble(strAntitheftdeviceDiscount);
                                        }else{
                                            AntitheftdeviceCardView.setVisibility(View.GONE);
                                            strAntitheftdeviceDiscount="0.0";
                                        }

                                        Log.e("strAntitheftdevicediscount",strAntitheftdeviceDiscount);
                                    }
                                    else if (DiscountValue.equals("Automobile Association discount")) {
                                        AutomobileAssociationDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        AutomobileAssociationRateValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Rate").getString("Value");
                                        AutomobileAssociationSumInsuredValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("SumInsured").getString("Value");
                                        if (!AutomobileAssociationDiscount.equals("")){
                                            doubleAutomobileAssociationDiscount= Double.parseDouble(AutomobileAssociationDiscount);
                                            Log.e("doubleAutomobileAssociationDiscount",AutomobileAssociationDiscount);
                                            if (!AutomobileAssociationDiscount.equals("0.00")) {
                                                AutomobilePremiumTxt.setText(String.valueOf(doubleAutomobileAssociationDiscount));
                                                AutomobilePremiumTxt.setVisibility(View.VISIBLE);
                                            }else{
                                                AutomobilePremiumTxt.setVisibility(View.INVISIBLE);
                                            }
                                        }
                                        else{
                                            AutomobileCardView.setVisibility(View.GONE);
                                            AutomobileAssociationDiscount="0.0";
                                        }
                                    }
                                    else if (DiscountValue.equals("Handicap Discount")) {
                                        StrHandicapDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        HandicapRateValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Rate").getString("Value");
                                        HandicapSumInsuredValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("SumInsured").getString("Value");
                                        if (!StrHandicapDiscount.equals("")){
                                            doubleHandicapDiscount= Double.parseDouble(StrHandicapDiscount);
                                        }else{
                                            HandicapDiscountCardView.setVisibility(View.GONE);
                                            StrHandicapDiscount="0.0";
                                        }

                                        Log.e("StrHandicapDiscount",StrHandicapDiscount);

                                    } else if (DiscountValue.equals("TPPD Discount")) {
                                        StrTPPDDiscount = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        TPPDDiscountRateValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Rate").getString("Value");
                                        TPPDDiscountSumInsuredValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("SumInsured").getString("Value");
                                        if (!StrTPPDDiscount.equals("")){
                                            doubleTPPDDiscount= Double.parseDouble(StrTPPDDiscount);
                                        }else{
                                            TPPDCardView.setVisibility(View.GONE);
                                            StrTPPDDiscount="0.0";
                                        }
                                        Log.e("StrTPPDDiscount",StrTPPDDiscount);

                                    }else if (DiscountValue.equals("Voluntary deductable")) {
                                        StrVotaryDeductablelun = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        VotaryRateValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Rate").getString("Value");
                                        VotarySumInsuredValue=OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("SumInsured").getString("Value");
                                        if (!StrVotaryDeductablelun.equals("")){
                                            doubleVotaryDiscount= Double.parseDouble(StrVotaryDeductablelun);
                                            if (StrVotaryDeductablelun.equals("0.00")) {
                                                VotaryPremiumTxt.setVisibility(View.INVISIBLE);
                                            }else{
                                                VotaryPremiumTxt.setVisibility(View.VISIBLE);
                                            }
                                            VotaryPremiumTxt.setText(StrVotaryDeductablelun);
                                        }else{
                                            VotaryCardView.setVisibility(View.GONE);
                                            StrVotaryDeductablelun="0.0";
                                        }
                                        Log.e("StrVotaryDeductablelun",StrVotaryDeductablelun);

                                    }else if (DiscountValue.equals("No claim bonus")) {
                                        StrNCB = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Premium").getString("Value");
                                        Log.e("NCB",StrNCB);

                                    }
                                }



                                String  TotalValue = TotalPremiumJsonObject.getString("Value");
                                TotalPremium.setText(TotalValue);
                                Log.e("dbjhdfbhf",TotalValue);
                                if (OneYearComprehensiveRadio.isChecked()){
                                    OneYearComprehensiveTxt.setText(TotalValue);
                                    TotalPremiumComprehensive.setText(TotalValue);
                                    thirdComprehensiveTxt.setText("");
                                    FiveComprehensiveTxt.setText("");
                                    StandardPlanPremiumTxt.setText("");
                                    TotalPremiumTp.setText("");
                                    StandardPlanPremium.setText("");
                                    TPTextView.setText("");
                                }
                            }

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                            Intent intent = new Intent(Motor_AddOns.this,Private_car_vehicle_details.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                } else {
                    String message=object.optString("Message");
                    Toast.makeText(getApplication(), ""+message, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Motor_AddOns.this,Private_car_vehicle_details.class);
                    startActivity(intent);
                    finish();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE_Quotation);
        req.execute();
    }
    private void errorBack() {
        Intent intent = new Intent(Motor_AddOns.this, Private_car_vehicle_details.class);
        intent.putExtra("strVehicleNo", strVehicleNo);
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
        intent.putExtra("strRTOName", strRTOName);
        intent.putExtra("strPolicyNumberEdit", strPolicyNumberEdit);
        intent.putExtra("strPlanType", strPlanType);
        intent.putExtra("strPlanYear", strPlanYear);
        intent.putExtra("strCoverageType", strCoverageType);
        intent.putExtra("strPACover", strPACover);
        intent.putExtra("strGPACover", strGPACover);
        intent.putExtra("strDrivingLicence", strDrivingLicence);
        intent.putExtra("strName", strName);
        intent.putExtra("streditdob", streditdob);
        intent.putExtra("TotalValue", TotalValue);
        intent.putExtra("NetPremiumValue", NetPremiumValue);
        intent.putExtra("PosPolicyNo", PosPolicyNo);
        intent.putExtra("tomorrowDate", tomorrowDate);
        intent.putExtra("GST", GST);
        intent.putExtra("strIdvValueTxt", strIdvValueTxt);
        intent.putExtra("strIdvValueTxtSelect", strIdvValueTxtSelect);
        intent.putExtra("strLessIDVText", strLessIDVText);
        intent.putExtra("strHighIDVText", strHighIDVText);
        intent.putExtra("yearOfManufacture", yearOfManufacture);
        intent.putExtra("strVehicleAge", strVehicleAge);
        intent.putExtra("strVehicleManufacturerCode", strVehicleManufacturerCode);
        intent.putExtra("strRTOCode", strRTOCode);
        intent.putExtra("yearOfManufactureMonth",yearOfManufactureMonth);
        intent.putExtra("strSelectDateYear",strSelectDateYear);
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
        intent.putExtra("addOns", addOns);
        intent.putExtra("NCB", NCB);
        intent.putExtra("VehicleClassCode", VehicleClassCode);
        intent.putExtra("ProductCode", ProductCode);
        intent.putExtra("ProductName", ProductName);
        intent.putExtra("strClaimBonus", strClaimBonus);
        intent.putExtra("strEndDateEdit", strEndDateEdit);
        intent.putExtra("StrPreviousPolicyRadio", StrPreviousPolicyRadio);
        intent.putExtra("VEHICLECLASSCODE", VEHICLECLASSCODE);
        intent.putExtra("NumberOfWheels", NumberOfWheels);
        intent.putExtra("strVehicleChasisNumber", strVehicleChasisNumber);
        intent.putExtra("strVehicleEngineNumber", strVehicleEngineNumber);
        intent.putExtra("rc_fuel_desc", rc_fuel_desc);
        intent.putExtra("rc_cubic_cap", rc_cubic_cap);
        intent.putExtra("FuleType", FuleType);
        intent.putExtra("strCompanyName", strCompanyName);
        intent.putExtra("nextYear", nextYear);
        intent.putExtra("vehicleManufacturerType", vehicleManufacturerType);
        intent.putExtra("strModelType", strModelType);
        intent.putExtra("addOnsCover", addOnsCover);
        intent.putExtra("addOnsAditional", addOnsAditional);
        intent.putExtra("SeekbarStatus", SeekbarStatus);
        intent.putExtra("StrAdditionalCoverPremiumOD", StrAdditionalCoverPremiumOD);
        intent.putExtra("StrAdditionalCoverPremiumTp", StrAdditionalCoverPremiumTp);
        intent.putExtra("strPreviousClaimRadio", strPreviousClaimRadio);
        intent.putExtra("AdditionalElectricalRateValue", AdditionalElectricalRateValue);
        intent.putExtra("AdditionalFibertankODRateValue", AdditionalFibertankODRateValue);
        intent.putExtra("AdditionalLegalLiabilityPaidRate", AdditionalLegalLiabilityPaidRate);
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
        intent.putExtra("BUILTINCNGKIT_LPGKITTPStatus", BUILTINCNGKIT_LPGKITTPStatus);
        intent.putExtra("MANUFACTURERSELLINGPRICEStatus", MANUFACTURERSELLINGPRICEStatus);
        intent.putExtra("DRIVINGTRAINPROTECTStatus", DRIVINGTRAINPROTECTStatus);
        intent.putExtra("progressChanged", progressChanged);
        intent.putExtra("BasicODRateValue", BasicODRateValue);
        intent.putExtra("BasicTpRateValue", BasicTpRateValue);
        intent.putExtra("strStateCode", strStateCode);
        intent.putExtra("DAILYCASHALLOWANCEStatus", DAILYCASHALLOWANCEStatus);
        intent.putExtra("DailyCashRateValue", DailyCashRateValue);
        intent.putExtra("WrongFuelRateValue", WrongFuelRateValue);
        intent.putExtra("WRONGFUELCOVERStatus", WRONGFUELCOVERStatus);
        intent.putExtra("DetarifficValuePremium", DetarifficValuePremium);
        intent.putExtra("DetarifficValueRate", DetarifficValueRate);
        intent.putExtra("DetarifficLodingValuePremium", DetarifficLodingValuePremium);
        intent.putExtra("DetarifficLoadingValueRate", DetarifficLoadingValueRate);
        intent.putExtra("strTitleEdit", strTitleEdit);
        intent.putExtra("strRegisteredAddressEdit", strRegisteredAddressEdit);
        intent.putExtra("strPinCodeEditText", strPinCodeEditText);
        intent.putExtra("strStateRegisterAddressEdit", strStateRegisterAddressEdit);
        intent.putExtra("strCityRegisterEdit", strCityRegisterEdit);
        intent.putExtra("strCommunicationAddressEdit", strCommunicationAddressEdit);
        intent.putExtra("strCommunicationPinCodeEdit", strCommunicationPinCodeEdit);
        intent.putExtra("strStateCommunicationEdit", strStateCommunicationEdit);
        intent.putExtra("strCityCommunicationEdit", strCityCommunicationEdit);
        intent.putExtra("strCheckedTermCondition", strCheckedTermCondition);
        intent.putExtra("strCheckboxCommunication", strCheckboxCommunication);
        intent.putExtra("strCityRegisterCode", strCityRegisterCode);
        intent.putExtra("strCityCommunicationCode", strCityCommunicationCode);
        intent.putExtra("strVehicleCubicCapicity", strVehicleCubicCapicity);
        intent.putExtra("strVehicleImage", strVehicleImage);
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
        intent.putExtra("strNomineeName", strNomineeName);
        intent.putExtra("strNomineeRelationEdit", strNomineeRelationEdit);
        intent.putExtra("ChangeAddons", ChangeAddons);
        intent.putExtra("strDiscountEdit", strDiscountEdit);
        intent.putExtra("StrNCB", StrNCB);
        intent.putExtra("AdditionalNonElecticalODSumInsuredValue", AdditionalNonElecticalODSumInsuredValue);
        intent.putExtra("AdditionalElectricalSumInsuredValue", AdditionalElectricalSumInsuredValue);
        intent.putExtra("AntitheftdeviceRateValue", AntitheftdeviceRateValue);
        intent.putExtra("AntitheftdeviceSumInsuredValue", AntitheftdeviceSumInsuredValue);
        intent.putExtra("AutomobileAssociationRateValue", AutomobileAssociationRateValue);
        intent.putExtra("AutomobileAssociationSumInsuredValue", AutomobileAssociationSumInsuredValue);
        intent.putExtra("HandicapRateValue", HandicapRateValue);
        intent.putExtra("HandicapSumInsuredValue", HandicapSumInsuredValue);
        intent.putExtra("TPPDDiscountRateValue", TPPDDiscountRateValue);
        intent.putExtra("TPPDDiscountSumInsuredValue", TPPDDiscountSumInsuredValue);
        intent.putExtra("VotaryRateValue", VotaryRateValue);
        intent.putExtra("VotarySumInsuredValue", VotarySumInsuredValue);
        intent.putExtra("AntitheftdevicediscountStatus", AntitheftdevicediscountStatus);
        intent.putExtra("AutomobileAssociationdiscountStatus", AutomobileAssociationdiscountStatus);
        intent.putExtra("TPPDDiscountStatus", TPPDDiscountStatus);
        intent.putExtra("HandicapDiscountStatus", HandicapDiscountStatus);
        intent.putExtra("VoluntarydeductableStatus", VoluntarydeductableStatus);
        intent.putExtra("strMinMax", strMinMax);
        intent.putExtra("DiscountsVale", DiscountsVale);
        intent.putExtra("strElectricalAccessoriesSumInsured", strElectricalAccessoriesSumInsured);
        intent.putExtra("strNonelectricalAccessoriesSumInsured", strNonelectricalAccessoriesSumInsured);
        intent.putExtra("PACOVERTOPASSENGERSSumInsured", PACOVERTOPASSENGERSSumInsured);
        intent.putExtra("UNNAMEDPACOVERTOPASSENGERSSumInsured", UNNAMEDPACOVERTOPASSENGERSSumInsured);
        intent.putExtra("PACOVERTOPAIDDRIVERSumInsured", PACOVERTOPAIDDRIVERSumInsured);
        intent.putExtra("strCngKitSumInsured", strCngKitSumInsured);
        intent.putExtra("AutoMobileRadio", AutoMobileRadio);
        intent.putExtra("AutoMobileValidityRadio", AutoMobileValidityRadio);
        intent.putExtra("AutomobileAssociationdiscountSumInsured", AutomobileAssociationdiscountSumInsured);
        intent.putExtra("VoluntarydeductableSumInsured", VoluntarydeductableSumInsured);
        intent.putExtra("VoluntarydeductableDiscountAmount", VoluntarydeductableDiscountAmount);
        intent.putExtra("ELECTRICALACCESSORYODSumInsured", ELECTRICALACCESSORYODSumInsured);
        intent.putExtra("NONELECTRICALACCESSORYODSumInsured", NONELECTRICALACCESSORYODSumInsured);
        intent.putExtra("StrPrev_Policy_Type", StrPrev_Policy_Type);
        intent.putExtra("CNGLPGKITODSumInsured", CNGLPGKITODSumInsured);
        intent.putExtra("selectYear", selectYear);
        intent.putExtra("daysLeft", daysLeft);
        intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
        intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
        intent.putExtra("ckycNo",ckycNo);
        intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
        intent.putExtra("a", a);
        intent.putExtra("b", b);
        intent.putExtra("c", c);
        intent.putExtra("strFor", "1");
        intent.putExtra("strNewFor", "1");
        intent.putExtra("CheckString", "0");
        intent.putExtra("changeseekBar", "0");
        startActivity(intent);
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
        finish();
    }
    private void saveGetQuote() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("QuotationNo",PosPolicyNo);
            object.put("PolicyType",strPolicyRadio);
            object.put("VehicleType",strVehicleTypeRadio);
            object.put("VehicleAge",strVehicleAge);
            object.put("VehicleNumber",strVehicleNo);
            object.put("BrandName",str_vehicleManufacturerNm);
            object.put("BrandCode",strVehicleManufacturerCode);
            object.put("ModelName",strVehicleModel );
            object.put("ModelCode",strVehicleModelCode);
            object.put("DateOfRegistration",str_edt_registration_date);
            object.put("StateName",strStateName);
            object.put("CityName",strRTOName);
            object.put("PolicyPlan",strPlanType);
            object.put("YearOfPlan",strPlanYear);
            object.put("IDV",strIdvValueTxt);
            object.put("Category",strCoverageType);
            object.put("PA_Value",strPACover);
            object.put("GPA_Value",strGPACover);
            object.put("DL",strDrivingLicence);
            object.put("TotalPremium",TotalValue);
            JSONArray array=new JSONArray();
            JSONObject obj1=new JSONObject();
            JSONObject obj2=new JSONObject();
            JSONObject obj3=new JSONObject();
            JSONObject obj4=new JSONObject();
            JSONObject obj5=new JSONObject();
            JSONObject obj6=new JSONObject();
            JSONObject obj7=new JSONObject();
            JSONObject obj8=new JSONObject();
            JSONObject obj9=new JSONObject();
            JSONObject obj10=new JSONObject();
            JSONObject obj11=new JSONObject();
            JSONObject obj12=new JSONObject();
            JSONObject obj13=new JSONObject();
            JSONObject obj14=new JSONObject();
            JSONObject obj15=new JSONObject();
            JSONObject obj16=new JSONObject();
            JSONObject obj17=new JSONObject();
            JSONObject obj18=new JSONObject();
            JSONObject obj19=new JSONObject();
            JSONObject obj20=new JSONObject();
            JSONObject obj21=new JSONObject();
            JSONObject obj22=new JSONObject();
            JSONObject obj23=new JSONObject();
            JSONObject obj24=new JSONObject();
            JSONObject obj25=new JSONObject();
            JSONObject obj26=new JSONObject();
            if(AdditionalCoverPremiumOD != Double.parseDouble("0.0")){
                obj1.put("CoverName", "Basic OD");
                obj1.put("CoverValue",AdditionalCoverPremiumOD);
                obj1.put("TypeValue", "Cover");
                array.put(obj1);
            }
            if(AdditionalCoverPremiumTP != Double.parseDouble("0.0")){
                obj2.put("CoverName", "Basic TP");
                obj2.put("CoverValue",AdditionalCoverPremiumTP);
                obj2.put("TypeValue", "Cover");
                array.put(obj2);
            }
            if(AdditionalCoverPremiumEl != Double.parseDouble("0.0")){
                obj3.put("CoverName", "ELECTRICAL ACCESSORY OD");
                obj3.put("CoverValue",AdditionalCoverPremiumEl);
                obj3.put("TypeValue", "Cover");
                array.put(obj3);
            }
            if(AdditionalCoverPremiumFI != Double.parseDouble("0.0")){
                obj4.put("CoverName", "FIBERTANK OD");
                obj4.put("CoverValue",AdditionalCoverPremiumFI);
                obj4.put("TypeValue", "Cover");
                array.put(obj4);
            }
            if(AdditionalCoverPremiumLegal != Double.parseDouble("0.0")){
                obj5.put("CoverName", "LEGAL LIABILITY TO PAID DRIVER");
                obj5.put("CoverValue",AdditionalCoverPremiumLegal);
                obj5.put("TypeValue", "Cover");
                array.put(obj5);
            }

            if(AdditionalCoverPremiumNon != Double.parseDouble("0.0")){
                obj6.put("CoverName", "NON ELECTRICAL ACCESSORY OD");
                obj6.put("CoverValue",AdditionalCoverPremiumNon);
                obj6.put("TypeValue", "Cover");
                array.put(obj6);
            }
            if(AdditionalCoverPremiumOtherOD != Double.parseDouble("0.0")){
                obj7.put("CoverName", "Other OD");
                obj7.put("CoverValue",AdditionalCoverPremiumOtherOD);
                obj7.put("TypeValue", "Cover");
                array.put(obj7);
            }

            if(AdditionalCoverPremiumOtherTP != Double.parseDouble("0.0")){
                obj8.put("CoverName", "Other TP");
                obj8.put("CoverValue",AdditionalCoverPremiumOtherTP);
                obj8.put("TypeValue", "Cover");
                array.put(obj8);
            }

            if(AdditionalCoverPremiumPACOVER != Double.parseDouble("0.0")){
                obj9.put("CoverName", "PA COVER TO EMPLOYEES OF INSURED");
                obj9.put("CoverValue",AdditionalCoverPremiumPACOVER);
                obj9.put("TypeValue", "Cover");
                array.put(obj9);
            }

            if(AdditionalCoverPremiumOWNERDRIVER != Double.parseDouble("0.0")){
                obj10.put("CoverName", "PA COVER TO OWNER DRIVER");
                obj10.put("CoverValue",AdditionalCoverPremiumOWNERDRIVER);
                obj10.put("TypeValue", "Cover");
                array.put(obj10);
            }

            if(AdditionalCoverPremiumPAIDDRIVER != Double.parseDouble("0.0")){
                obj11.put("CoverName", "PA COVER TO PAID DRIVER");
                obj11.put("CoverValue",AdditionalCoverPremiumPAIDDRIVER);
                obj11.put("TypeValue", "Cover");
                array.put(obj11);
            }

            if(AdditionalCoverPremiumPASSENGERS != Double.parseDouble("0.0")){
                obj12.put("CoverName", "PA COVER TO PASSENGERS");
                obj12.put("CoverValue",AdditionalCoverPremiumPASSENGERS);
                obj12.put("TypeValue", "Cover");
                array.put(obj12);
            }

            if(AdditionalCoverPremiumUNNAMED != Double.parseDouble("0.0")){
                obj13.put("CoverName", "UNNAMED PA COVER TO PASSENGERS");
                obj13.put("CoverValue",AdditionalCoverPremiumUNNAMED);
                obj13.put("TypeValue", "Cover");
                array.put(obj13);
            }

            if(AdditionalHospitalization != Double.parseDouble("0.0")) {
                obj14.put("CoverName", "ACCIDENTAL HOSPITALIZATION");
                obj14.put("CoverValue", AdditionalHospitalization);
                obj14.put("TypeValue", "AddOn's");
                array.put(obj14);
            }

            if(AdditionalCostOfConsumbales != Double.parseDouble("0.0")){
                obj15.put("CoverName", "COST OF CONSUMABLES");
                obj15.put("CoverValue",AdditionalCostOfConsumbales);
                obj15.put("TypeValue", "AddOn's");
                array.put(obj15);
            }

            if(AdditionalDailyCashMetro != Double.parseDouble("0.0")){
                obj16.put("CoverName", "DAILY CASH ALLOWANCE - METRO");
                obj16.put("CoverValue",AdditionalDailyCashMetro);
                obj16.put("TypeValue", "AddOn's");
                array.put(obj16);
            }

            if(AdditionalDailCash != Double.parseDouble("0.0")){
                obj17.put("CoverName", "DAILY CASH ALLOWANCE - NONMETRO");
                obj17.put("CoverValue",AdditionalDailCash);
                obj17.put("TypeValue", "AddOn's");
                array.put(obj17);
            }
            if(AdditionalEngineDisesel != Double.parseDouble("0.0")){
                obj18.put("CoverName", "ENGINE PROTECTOR - DIESEL");
                obj18.put("CoverValue",AdditionalEngineDisesel);
                obj18.put("TypeValue", "AddOn's");
                array.put(obj18);
            }

            if(AdditionalEnginePetrol != Double.parseDouble("0.0")){
                obj19.put("CoverName", "ENGINE PROTECTOR - PETROL");
                obj19.put("CoverValue",AdditionalEnginePetrol);
                obj19.put("TypeValue", "AddOn's");
                array.put(obj19);
            }

            if(AdditionalHydrosaticLock != Double.parseDouble("0.0")){
                obj20.put("CoverName", "HYDROSTATIC LOCK COVER");
                obj20.put("CoverValue",AdditionalHydrosaticLock);
                obj20.put("TypeValue", "AddOn's");
                array.put(obj20);
            }
            if(AdditionalKeyReplacement != Double.parseDouble("0.0")){
                obj21.put("CoverName", "KEY REPLACEMENT");
                obj21.put("CoverValue",AdditionalKeyReplacement);
                obj21.put("TypeValue", "AddOn's");
                array.put(obj21);
            }
            if(AdditionalNilDepreciation != Double.parseDouble("0.0")){
                obj22.put("CoverName", "Nil Depreciation Waiver cover");
                obj22.put("CoverValue",AdditionalNilDepreciation);
                obj22.put("TypeValue", "AddOn's");
                array.put(obj22);

            }
            if(AdditionalReturnInvoice != Double.parseDouble("0.0")){
                obj23.put("CoverName", "RETURN TO INVOICE");
                obj23.put("CoverValue",AdditionalReturnInvoice);
                obj23.put("TypeValue", "AddOn's");
                array.put(obj23);
            }
            if(AdditionalRoadSide != Double.parseDouble("0.0")){
                obj24.put("CoverName", "Road side Assistance");
                obj24.put("CoverValue",AdditionalRoadSide);
                obj24.put("TypeValue", "AddOn's");
                array.put(obj24);
            }
            if(AdditionalsecureTowing != Double.parseDouble("0.0")){
                obj25.put("CoverName", "SECURE TOWING");
                obj25.put("CoverValue",AdditionalsecureTowing);
                obj25.put("TypeValue", "AddOn's");
                array.put(obj25);
            }

            if(AdditionalTyreRim != Double.parseDouble("0.0")){
                obj26.put("CoverName", "Tyre and Rim secure");
                obj26.put("CoverValue",AdditionalTyreRim);
                obj26.put("TypeValue", "AddOn's");
                array.put(obj26);
            }
            object.put("AddonAndCovers",array);


        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Motor_AddOns.this, object, UrlConstants.BUYSaveQuotationDetails, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    final Dialog alert_dialog = new Dialog(Motor_AddOns.this);
                    alert_dialog.setCanceledOnTouchOutside(false);
                    alert_dialog.setCancelable(false);
                    alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                    alert_dialog.setContentView(R.layout.save_quotation_dialog);
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                    lp.copyFrom(alert_dialog.getWindow().getAttributes());
                    lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                    lp.gravity = Gravity.CENTER;
                    TextView ok_dialog=alert_dialog.findViewById(R.id.ok_dialog);
                    TextView QuotationIDTxt=alert_dialog.findViewById(R.id.QuotationIDTxt);
                    QuotationIDTxt.setText(PosPolicyNo);

                    ok_dialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alert_dialog.dismiss();
                        }
                    });

                    alert_dialog.show();
                }else{
                    Toast.makeText(getApplicationContext(), ""+object.optString("Message"), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestConstants.BUY_SaveQuotationDetails);
        req.execute();
    }
    @Override
    public void onBackPressed() {
        if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
            Intent intent=new Intent(Motor_AddOns.this, Add_Details_Old_Vehicle.class);
            intent.putExtra("strVehicleNo",strVehicleNo);
            intent.putExtra("str_edt_city",str_edt_city);
            intent.putExtra("str_edt_phone",str_edt_phone);
            intent.putExtra("str_edt_email",str_edt_email);
            intent.putExtra("strPolicyRadio",strPolicyRadio);
            intent.putExtra("strVehicleTypeRadio",strVehicleTypeRadio);
            intent.putExtra("strVehicleRadio",strVehicleRadio);
            intent.putExtra("strPolicyNumberEdit",strPolicyNumberEdit);
            intent.putExtra("strClaimBonus",strClaimBonus);
            intent.putExtra("strEndDateEdit",strEndDateEdit);
            intent.putExtra("StrPreviousPolicyRadio",StrPreviousPolicyRadio);
            intent.putExtra("strCompanyName",strCompanyName);
            intent.putExtra("strPreviousClaimRadio",strPreviousClaimRadio);
            intent.putExtra("strStateCode",strStateCode);
            intent.putExtra("ckycNo",ckycNo);
            intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
            intent.putExtra("strFor","1");
            startActivity(intent);
            finish();
        }else {
            Intent intent=new Intent(Motor_AddOns.this,Private_car_vehicle_details.class);
            intent.putExtra("strVehicleNo",strVehicleNo);
            intent.putExtra("strName",strName);
            intent.putExtra("strIDType",strIDType);
            intent.putExtra("strIDTypeName",strIDTypeName);
            intent.putExtra("strIDTypeName1",strIDTypeName1);
            intent.putExtra("strIDNumberEdit",strIDNumberEdit);
            intent.putExtra("streditdob",streditdob);
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
            intent.putExtra("DetarifficValueDiscount",DetarifficValueDiscount);
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
            intent.putExtra("VoluntarydeductableDiscountAmount",VoluntarydeductableDiscountAmount);
            intent.putExtra("CNGLPGKITODSumInsured",CNGLPGKITODSumInsured);
            intent.putExtra("selectYear",selectYear);
            intent.putExtra("daysLeft",daysLeft);
            intent.putExtra("strTpFromDateEdit",strTpFromDateEdit);
            intent.putExtra("strTpEndDateEdit",strTpEndDateEdit);
            intent.putExtra("ckycNo",ckycNo);
            intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
            intent.putExtra("a",a);
            intent.putExtra("b",b);
            intent.putExtra("c",c);
            intent.putExtra("strFor","1");
            intent.putExtra("strNewFor","1");
            intent.putExtra("CheckString","1");
            intent.putExtra("changeseekBar","0");
            startActivity(intent);
            overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);
            finish();
        }
    }
    private void updateLabel() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        DatePickerDialog datePicker = new DatePickerDialog(Motor_AddOns.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strValidityTxt=dateFormatter.format(newDate.getTime());
            ValidityTxt.setText(strValidityTxt);
            CheckString="1";
            ChangeAddons = "1";
            AutomobileAssociationdiscountStatus="True";
            AutomobileAssociationdiscountSumInsured=strValidityTxt;
            VehicleMotorQuotation();
            addOnsShow();
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

//    datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
        datePicker.show();
    }

}