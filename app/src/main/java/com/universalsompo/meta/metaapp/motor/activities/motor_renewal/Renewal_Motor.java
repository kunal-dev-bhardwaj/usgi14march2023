package com.universalsompo.meta.metaapp.motor.activities.motor_renewal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.google.gson.Gson;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.MotorVehicleModel;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.VehicleManufacturerModel;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Motor_AddOns;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Private_car_vehicle_details;
import com.universalsompo.meta.metaapp.motor.activities.paymentmotor.PaymentMotorWeb;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Renewal_Motor extends AppCompatActivity {
       LinearLayout customize_policy_btn_liner,LinerCustomize,continue_button,save_get_quote_btn,ThreeYearLiner,FiveYearLiner;
       RadioButton IndividualRadioBtnRenewal,CorporateRadioBtnRenewal,PaCoverYesRadioBtn,PaCoverNoRadioBtn,GpaCoverYesRadioBtn,GpaCoverNoRadioBtn,ActiveDrivingYesRadioBtn,ActiveDrivingNoRadioBtn,OneYearComprehensiveRadio,TwoYearComprehensiveRadio,ThreeYearComprehensiveRadio,OneYearThirdPartyRadio,ThreeYearThirdPartyRadio,FiveYearThirdPartyRadio,OneYearStandardAloneRadio,ThreeYearStandardAloneRadio,FiveYearStandardAloneRadio,FiveYearComprehensiveRadio;
       String  RegistrationDate="",days="",strPlanType="",strPlanYear="",VehicleNumber="",strVehicleAge="",str_edt_registration_date="",rc_fuel_desc="",strStateName="",strRTOCode="",strRTOName="",strStateCode="",yearOfManufacture="",FuleType="",str_vehicleManufacturerNm="",strVehicleManufacturerCode="",VEHICLECLASSCODE="",strVehicleModelCode="",ProductName="",VehicleClassCode="",NumberOfWheels="",VehicleType="",addOns="",today="",strThirdDString="",str_new_dob="",strFirstString="",tomorrowDate="",nextYear="",strFirstTString="",QuoteID="",FinalPremium="",RegistrationNo="",GST="",NewIDV="",ManufatureName="",VehicleModel="",ProductCode="",NetPremium="",NCB="",PremiumValue="",VehiclePolicyHolderName="",VehiclePolicyNumber="",strCoverageTye="",strPACover="",strGPACover="",strDrivingLicence="",VehicleEndDate="",VehicleManufactureYear="",VehicleNoOFDateLeft="",strPolicyPlan="",VehicleChasisNo="",VehicleEngineNo="",BasicODStatus="",BasicTP="",ELECTRICALACCESSORYODStatus="",FIBERTANKODStatus="",LEGALLIABILITYTOPAIDDRIVERStatus="",NONELECTRICALACCESSORYODStatus="",OtherODStatus="",OtherTpStatus="",PACOVERTOEMPLOYEESOFINSUREDStatus="",PACOVERTOOWNERDRIVERStatus="",PACOVERTOPAIDDRIVERStatus="",PACOVERTOPASSENGERSStatus="",UNNAMEDPACOVERTOPASSENGERSStatus="",ACCIDENTALHOSPITALIZATIONStatus="",COSTOFCONSUMABLESStatus="",DAILYCASHALLOWANCEMETROStatus="",DAILYCASHALLOWANCENONMETROStatus="",ENGINEPROTECTORDIESELStatus="",ENGINEPROTECTORPETROLStatus="",HYDROSTATICLOCKCOVERStatus="",KEYREPLACEMENTStatus="",NilDepreciationWaivercoverStatus="",RETURNTOINVOICEStatus="",RoadsideAssistanceStatus="",SECURETOWINGStatus="",TyreandRimsecureStatus="",VehicleExShowroomPrice="",NetPremiumValue="",TotalValue="",PosPolicyNo="",GSTNew,strIdvValueTxt="",strLessIDVText="",strHighIDVText="",AdditionalCoverPremium="",VehicleModelnew="",addOnsCover,addOnsAditional;
      private MySharedPreference pref;
      int day_left_to_expire;
      CustomProgressDialog customprogress;
      Date date,date1,date2,date3;
      Format formatter;
      TextView RenewalTxtView,RenewalPolicyType,VehiclePolicyHolderNameTxt,VehicleManufactureYearTxt,EndDateTxt,leftDateTxt,ModelTxt,ManufatureTxt,nameVehicle,RegistrationNoTxt,NetPremiumTxt,PolicyPlanTxt,TotalPremium,NCBTxt,GSTTxt,RenewalIDVTxt,PremiumTxt,TotalPremiumComprehensive,FiveComprehensiveTxt,thirdComprehensiveTxt,StandardPlanPremium,StandardPlanPremiumTxt,TPTextView,TotalPremiumTp,OneYearComprehensiveTxt;
    double AdditionalCoverPremiumOD,AdditionalCoverPremiumTP,AdditionalCoverPremiumEl,AdditionalCoverPremiumFI,AdditionalCoverPremiumLegal,AdditionalCoverPremiumNon,AdditionalCoverPremiumOtherOD,AdditionalCoverPremiumOtherTP,AdditionalCoverPremiumPACOVER,AdditionalCoverPremiumOWNERDRIVER,AdditionalCoverPremiumPAIDDRIVER,AdditionalCoverPremiumPASSENGERS,AdditionalCoverPremiumUNNAMED,AdditionalHospitalization,AdditionalCostOfConsumbales,AdditionalDailyCashMetro,AdditionalDailCash,AdditionalEngineDisesel,AdditionalEnginePetrol,AdditionalHydrosaticLock, AdditionalKeyReplacement, AdditionalNilDepreciation,AdditionalReturnInvoice,AdditionalRoadSide,AdditionalsecureTowing,AdditionalTyreRim;
    CardView BasicODCardView,BasicTPCardView,ElectricalCardView,FIBERTANKODCardView,LegalLiabilityCardView,NonLegalLiabilityCardView,OtherOdCardView,OtherTpCardView,EMPLOYEESCardView,OwnerDriverCardView,PaidDriverCardView,PASSENGERSCardView,UnnamedPassengerCardView,AccidentalCardView,CostOfCardView,DailyCashCardView,DailyCardView,EngineProtectorCardView,EngineCardView,HydrostaticeCardView,KeyReplacementCardView,NilCardView,ReturnToInvoiceCardView,RoadsideAssistanceCardView,SecureTowingCardView,TyreCardView;
    TextView BasicODPremiumTxt,BasicTPPremiumTxt,ElectricalPremiumTxt,FIBERTANKPremiumTxt,LegalPremiumTxt,NonElectricalPremiumTxt,OtherOdPremiumTxt,OtherTpPremiumTxt,EmployeesInsuredPremiumTxt,OwnerDriverPremiumTxt,PaidDriverPremiumTxt,PassengersPremiumTxt,UnnamedPassengersPremiumTxt,CoverAddOnText,CoverAdditionalText,VehicleNameText,VehicleNumberText,IdvValueTxt,lessIDVText,HighIDVText,IDVTotalPremium,AccidentalHospitalPremium,CostOfConsumableNamePremium,DailyCashAllowanceNamePremium,DailyCashNonMetroPremium,EngineProtectorDieselPremium,EngineProtectorPetrolPremium,HydrostaticeLockcoverPremium,KeyReplacementPremium,NilDepreciationWaivercoverNamePremium,ReturnToInvoicePremium,RoadsideAssistancePremium,SecureTowingPremium,TyreAndRimSecurePremium,
    ComprehensivePremium, ThirdPartyPremium,StandardPlanTotalPremium, AccidentalHospitalAddButton,CostOfConsumableAddButton,DailyCashAddButton,DailyCashNonADDButton,EngineAddButton,ENGINEPetrolAddButton,HydrostaticAddButton,KeyReplacementAddButton,NilAddButton,RetrunToVoiceAddButton,RoadsideAssistanceAddButton,SecureTowingAddButton,TyreAddButton;
    CheckBox CoverageCheckBox,BasicTPCheckBox,ElectricalCheckBox,FIBERTANKCheckBox,LEGALCheckBox,NonLegalCheckBox,OtherOdCheckBox,OtherTpCheckBox,EmployeesInsuredCheckBox,OWNERDRIVERCheckBox,PaidDriverCheckBox,PASSENGERSCheckBox,UnnamedCheckBox;
    SeekBar seekBarDistance;
      ImageView RenewalDetailsBack,imgeBike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renewal_motor);

        getWindow().setStatusBarColor(ContextCompat.getColor(Renewal_Motor.this, R.color.colorPrimaryDark));

        pref = MySharedPreference.getInstance(Renewal_Motor.this);
        customprogress = new CustomProgressDialog(Renewal_Motor.this);
//        VehiclePolicyHolderName = getIntent().getStringExtra("VehiclePolicyHolderName");
        VehiclePolicyNumber = getIntent().getStringExtra("VehiclePolicyNumber");
        VehicleEndDate = getIntent().getStringExtra("VehicleEndDate");
//        VehicleEndDate = getIntent().getStringExtra("VehicleEndDate");
//        VehicleManufactureYear = getIntent().getStringExtra("VehicleManufactureYear");
//        VehicleNoOFDateLeft = getIntent().getStringExtra("VehicleNoOFDateLeft");
//        VehicleChasisNo = getIntent().getStringExtra("VehicleChasisNo");
//        VehicleEngineNo = getIntent().getStringExtra("VehicleEngineNo");
//        VehicleType = getIntent().getStringExtra("VehicleType");
//        VehicleNumber = getIntent().getStringExtra("VehicleNumber");
//        VehicleModel= getIntent().getStringExtra("VehicleModel");
//        str_vehicleManufacturerNm = getIntent().getStringExtra("str_vehicleManufacturerNm");
//        VehiclePolicyNumber="2312/57184423/02/000";
//        VehiclePolicyNumber="2311/50764322/10/000";
             Log.e("VehiclePolicyNumber",VehiclePolicyNumber);

//        BasicODStatus="True";
//        BasicTP="True";
//        ELECTRICALACCESSORYODStatus="True";
//        FIBERTANKODStatus="True";
//        LEGALLIABILITYTOPAIDDRIVERStatus="True";
//        NONELECTRICALACCESSORYODStatus="True";
//        OtherODStatus="True";
//        OtherTpStatus="True";
//        PACOVERTOEMPLOYEESOFINSUREDStatus="True";
//        PACOVERTOOWNERDRIVERStatus="True";
//        PACOVERTOPAIDDRIVERStatus="True";
//        PACOVERTOPASSENGERSStatus="True";
//        UNNAMEDPACOVERTOPASSENGERSStatus="True";
//        ACCIDENTALHOSPITALIZATIONStatus="True";
//        COSTOFCONSUMABLESStatus="True";
//        DAILYCASHALLOWANCEMETROStatus="True";
//        DAILYCASHALLOWANCENONMETROStatus="True";
//        ENGINEPROTECTORDIESELStatus="True";
//        ENGINEPROTECTORPETROLStatus="True";
//        HYDROSTATICLOCKCOVERStatus="True";
//        KEYREPLACEMENTStatus="True";
//        NilDepreciationWaivercoverStatus="True";
//        RETURNTOINVOICEStatus="True";
//        RoadsideAssistanceStatus="True";
//        SECURETOWINGStatus="True";
//        TyreandRimsecureStatus="True";


        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        Log.e("today",today);
        String[] strTDate=  today.split("/");
        String strFirstDString = strTDate[0];
        String strSecondDString = strTDate[1];
        strThirdDString = strTDate[2];
        Log.e("strThirdDString", strThirdDString);
        Log.e("Today",today);
//
//        calendar.add(Calendar.DATE, 1);
//        date = calendar.getTime();
//        formatter = new SimpleDateFormat("dd/MM/yyyy");
//        tomorrowDate = formatter.format(date);
//        Log.e("tomorrowDate",tomorrowDate);
//
//        calendar.add(Calendar.DATE, 364);
//        date = calendar.getTime();
//        formatter = new SimpleDateFormat("dd/MM/yyyy");
//        nextYear = formatter.format(date);
//        Log.e("nextYear",nextYear);
//        int strThirdDString1= Integer.parseInt(strThirdDString);
//        int strYearOfManufacture= Integer.parseInt(VehicleManufactureYear);
//        strVehicleAge= String.valueOf(strThirdDString1-strYearOfManufacture);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate start = LocalDate.parse(today,formatter);
            LocalDate end = LocalDate.parse(VehicleEndDate,formatter);
             days=String.valueOf(ChronoUnit.DAYS.between(start, end));
            day_left_to_expire= Integer.parseInt(days);
            Log.e("daysLeft", String.valueOf(ChronoUnit.DAYS.between(start, end)));
        }

        save_get_quote_btn=findViewById(R.id.save_get_quote_btn);
        customize_policy_btn_liner=findViewById(R.id.customize_policy_btn_liner);
        LinerCustomize=findViewById(R.id.LinerCustomize);
        continue_button=findViewById(R.id.continue_button);
        IndividualRadioBtnRenewal=findViewById(R.id.IndividualRadioBtnRenewal);
        CorporateRadioBtnRenewal=findViewById(R.id.CorporateRadioBtnRenewal);
        PaCoverYesRadioBtn=findViewById(R.id.PaCoverYesRadioBtn);
        PaCoverNoRadioBtn=findViewById(R.id.PaCoverNoRadioBtn);
        GpaCoverYesRadioBtn=findViewById(R.id.GpaCoverYesRadioBtn);
        GpaCoverNoRadioBtn=findViewById(R.id.GpaCoverNoRadioBtn);
        ActiveDrivingYesRadioBtn=findViewById(R.id.ActiveDrivingYesRadioBtn);
        ActiveDrivingNoRadioBtn=findViewById(R.id.ActiveDrivingNoRadioBtn);
        EndDateTxt=findViewById(R.id.EndDateTxt);
        leftDateTxt=findViewById(R.id.leftDateTxt);
        NetPremiumTxt=findViewById(R.id.NetPremiumTxt);
        PolicyPlanTxt=findViewById(R.id.PolicyPlanTxt);
        NCBTxt=findViewById(R.id.NCBTxt);
        ModelTxt=findViewById(R.id.ModelTxt);
        nameVehicle=findViewById(R.id.nameVehicle);
        ManufatureTxt=findViewById(R.id.ManufatureTxt);
        GSTTxt=findViewById(R.id.GSTTxt);
        PremiumTxt=findViewById(R.id.PremiumTxt);
        RenewalIDVTxt=findViewById(R.id.RenewalIDVTxt);
        TotalPremium=findViewById(R.id.TotalPremium);
        RegistrationNoTxt=findViewById(R.id.RegistrationNoTxt);
        VehicleManufactureYearTxt=findViewById(R.id.VehicleManufactureYearTxt);
        VehiclePolicyHolderNameTxt=findViewById(R.id.VehiclePolicyHolderNameTxt);
        OneYearComprehensiveRadio=findViewById(R.id.OneYearComprehensiveRadio);
        ThreeYearComprehensiveRadio=findViewById(R.id.ThreeYearComprehensiveRadio);
        OneYearThirdPartyRadio=findViewById(R.id.OneYearThirdPartyRadio);
        ThreeYearThirdPartyRadio=findViewById(R.id.ThreeYearThirdPartyRadio);
        RenewalPolicyType=findViewById(R.id.RenewalPolicyType);


        OneYearStandardAloneRadio=findViewById(R.id.OneYearStandardAloneRadio);
        ThreeYearStandardAloneRadio=findViewById(R.id.ThreeYearStandardAloneRadio);

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
        FiveYearComprehensiveRadio=findViewById(R.id.FiveYearComprehensiveRadio);

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
        AccidentalCardView=findViewById(R.id.AccidentalCardView);
        CostOfCardView=findViewById(R.id.CostOfCardView);
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
        PaidDriverCheckBox=findViewById(R.id.PaidDriverCheckBox);
        PASSENGERSCheckBox=findViewById(R.id.PASSENGERSCheckBox);
        UnnamedCheckBox=findViewById(R.id.UnnamedCheckBox);
        AccidentalHospitalAddButton=findViewById(R.id.AccidentalHospitalAddButton);
        CostOfConsumableAddButton=findViewById(R.id.CostOfConsumableAddButton);
        DailyCashAddButton=findViewById(R.id.DailyCashAddButton);
        DailyCashNonADDButton=findViewById(R.id.DailyCashNonADDButton);
        EngineAddButton=findViewById(R.id.EngineAddButton);
        ENGINEPetrolAddButton=findViewById(R.id.ENGINEPetrolAddButton);
        HydrostaticAddButton=findViewById(R.id.HydrostaticAddButton);
        KeyReplacementAddButton=findViewById(R.id.KeyReplacementAddButton);
        NilAddButton=findViewById(R.id.NilAddButton);
        RetrunToVoiceAddButton=findViewById(R.id.RetrunToVoiceAddButton);
        RoadsideAssistanceAddButton=findViewById(R.id.RoadsideAssistanceAddButton);
        SecureTowingAddButton=findViewById(R.id.SecureTowingAddButton);
        TyreAddButton=findViewById(R.id.TyreAddButton);

//        VehiclePolicyHolderNameTxt.setText(VehiclePolicyHolderName);
        EndDateTxt.setText(VehicleEndDate);
//        VehicleManufactureYearTxt.setText(VehicleManufactureYear);
//        day_left_to_expire= Integer.parseInt(VehicleNoOFDateLeft);
        seekBarDistance=findViewById(R.id.seekBarDistance);
        IdvValueTxt=findViewById(R.id.IdvValueTxt);
        IDVTotalPremium=findViewById(R.id.IDVTotalPremium);
        lessIDVText=findViewById(R.id.lessIDVText);
        HighIDVText=findViewById(R.id.HighIDVText);
        BasicODPremiumTxt=findViewById(R.id.BasicODPremiumTxt);
        BasicTPPremiumTxt=findViewById(R.id.BasicTPPremiumTxt);
        ElectricalPremiumTxt=findViewById(R.id.ElectricalPremiumTxt);
        FIBERTANKPremiumTxt=findViewById(R.id.FIBERTANKPremiumTxt);
        LegalPremiumTxt=findViewById(R.id.LegalPremiumTxt);
        NonElectricalPremiumTxt=findViewById(R.id.NonElectricalPremiumTxt);
        CoverAddOnText=findViewById(R.id.CoverAddOnText);
        CoverAdditionalText=findViewById(R.id.CoverAdditionalText);
        AccidentalHospitalPremium=findViewById(R.id.AccidentalHospitalPremium);
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
        RenewalDetailsBack=findViewById(R.id.RenewalDetailsBack);
        RenewalTxtView=findViewById(R.id.RenewalTxtView);
        imgeBike=findViewById(R.id.imgeBike);
        renewQuotation();
        if (day_left_to_expire < 1) {
            leftDateTxt.setText(days+" Expired");
        } else if (day_left_to_expire == 1) {
            leftDateTxt.setText(days + " Day Left");
        } else if (day_left_to_expire < 31) {
            leftDateTxt.setText(days + " Days Left");
        } else {
            leftDateTxt.setText(days + " Days Left");
        }

//        if (VehicleType.equals("FW")){
//            RenewalPolicyType.setText("Four Wheeler Insurance");
//            ProductName="PRIVATE CAR PACKAGE POLICY";
//            ProductCode="2311";
//            VehicleClassCode="45";
//            NumberOfWheels="6";
//            VEHICLECLASSCODE="45";
//            VehicleNumber="MH01AE3184";
//            ThreeYearLiner.setVisibility(View.VISIBLE);
//            FiveYearLiner.setVisibility(View.GONE);
//            imgeBike.setBackgroundResource(R.drawable.fourwheelerimg);
//        }
//        else{
//            RenewalPolicyType.setText("Two Wheeler Insurance");
//            ProductName="TWO WHEELER PACKAGE POLICY";
//            ProductCode="2312";
//            VehicleClassCode="37";
//            NumberOfWheels="2";
//            VEHICLECLASSCODE="37";
//            VehicleNumber="MH04HQ8035";
//            ThreeYearLiner.setVisibility(View.GONE);
//            FiveYearLiner.setVisibility(View.VISIBLE);
//            imgeBike.setBackgroundResource(R.drawable.scooty_motor_img);
//        }


        customize_policy_btn_liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinerCustomize.setVisibility(View.VISIBLE);
                customize_policy_btn_liner.setVisibility(View.GONE);

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

                strFirstTString = "1";
                calendar.add(Calendar.DATE, 364);
                date1 = calendar.getTime();
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                nextYear = formatter.format(date1);
                Log.e("nextYear", nextYear);
                VehicleManufacturerMaster();
                variantAdrilla();
//                VehicleMotorQuotation();
            }
        });
        save_get_quote_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveGetQuote();
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
            }
        });
        BasicTPCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (BasicTPCheckBox.isChecked()){
                    BasicTP="True";
                    VehicleMotorQuotation();
                    BasicTPCheckBox.setChecked(true);
                }else{
                    BasicTP="False";
                    VehicleMotorQuotation();
                    BasicTPCheckBox.setChecked(false);
                }
            }
        });
        ElectricalCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ElectricalCheckBox.isChecked()){
                    ELECTRICALACCESSORYODStatus="True";
                    VehicleMotorQuotation();
                    ElectricalCheckBox.setChecked(true);
                }else{
                    ELECTRICALACCESSORYODStatus="False";
                    ElectricalCheckBox.setChecked(false);
                    VehicleMotorQuotation();
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
                VehicleMotorQuotation();
            }
        });
        LEGALCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (LEGALCheckBox.isChecked()){
                    LEGALCheckBox.setChecked(true);
                    LEGALLIABILITYTOPAIDDRIVERStatus="True";
                }else{
                    LEGALCheckBox.setChecked(false);
                    LEGALLIABILITYTOPAIDDRIVERStatus="False";
                }
                VehicleMotorQuotation();
            }
        });
        NonLegalCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NonLegalCheckBox.isChecked()){
                    NonLegalCheckBox.setChecked(true);
                    NONELECTRICALACCESSORYODStatus="True";
                }else{
                    NonLegalCheckBox.setChecked(false);
                    NONELECTRICALACCESSORYODStatus="False";
                }
                VehicleMotorQuotation();
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
                VehicleMotorQuotation();
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
                VehicleMotorQuotation();
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
                VehicleMotorQuotation();
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
                VehicleMotorQuotation();
            }
        });
        PaidDriverCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PaidDriverCheckBox.isChecked()){
                    PACOVERTOPAIDDRIVERStatus="True";
                    PaidDriverCheckBox.setChecked(true);
                }else{
                    PACOVERTOPAIDDRIVERStatus="False";
                    PaidDriverCheckBox.setChecked(false);
                }
                VehicleMotorQuotation();
            }
        });

        RenewalTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(Renewal_Motor.this);
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
                TextView basicPremium=alert_dialog.findViewById(R.id.basicPremium);
                TextView VehicleModelEdit=alert_dialog.findViewById(R.id.VehicleModelEdit);
                TextView YearEdit=alert_dialog.findViewById(R.id.YearEdit);
                TextView addOnsEdit=alert_dialog.findViewById(R.id.addOnsEdit);
                TextView gstEdit=alert_dialog.findViewById(R.id.gstEdit);
                TextView totalAmount=alert_dialog.findViewById(R.id.totalAmount);
                basicPremium.setText(NetPremiumValue);
                VehicleModelEdit.setText(VehicleModel+" "+ManufatureName);
                YearEdit.setText(yearOfManufacture);
                addOnsEdit.setText("0");
                gstEdit.setText(GST);
                totalAmount.setText(TotalValue);
                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert_dialog.dismiss();
                    }
                });

                alert_dialog.show();
            }
        });

        PASSENGERSCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PASSENGERSCheckBox.isChecked()){
                    PACOVERTOPASSENGERSStatus="True";
                    PASSENGERSCheckBox.setChecked(true);
                }else{
                    PACOVERTOPASSENGERSStatus="False";
                    PASSENGERSCheckBox.setChecked(false);
                }
                VehicleMotorQuotation();
            }
        });
        UnnamedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (UnnamedCheckBox.isChecked()){
                    UNNAMEDPACOVERTOPASSENGERSStatus="True";
                    UnnamedCheckBox.setChecked(true);
                }else{
                    UNNAMEDPACOVERTOPASSENGERSStatus="False";
                    UnnamedCheckBox.setChecked(false);
                }
                VehicleMotorQuotation();
            }
        });
        AccidentalHospitalAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACCIDENTALHOSPITALIZATIONStatus="False";
                VehicleMotorQuotation();
            }
        });
        CostOfConsumableAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                COSTOFCONSUMABLESStatus="False";
                VehicleMotorQuotation();
            }
        });
        DailyCashAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAILYCASHALLOWANCEMETROStatus="False";
                VehicleMotorQuotation();
            }
        });
        DailyCashNonADDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAILYCASHALLOWANCENONMETROStatus="False";
                VehicleMotorQuotation();
            }
        });
        EngineAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ENGINEPROTECTORDIESELStatus="False";
                VehicleMotorQuotation();
            }
        });
        ENGINEPetrolAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ENGINEPROTECTORPETROLStatus="False";
                VehicleMotorQuotation();
            }
        });
        HydrostaticAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HYDROSTATICLOCKCOVERStatus="False";
                VehicleMotorQuotation();
            }
        });
        KeyReplacementAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KEYREPLACEMENTStatus="False";
                VehicleMotorQuotation();
            }
        });
        NilAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NilDepreciationWaivercoverStatus="False";
                VehicleMotorQuotation();
            }
        });
        RetrunToVoiceAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RETURNTOINVOICEStatus="False";
                VehicleMotorQuotation();
            }
        });
        RoadsideAssistanceAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoadsideAssistanceStatus="False";
                VehicleMotorQuotation();
            }
        });
        SecureTowingAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SECURETOWINGStatus="False";
                VehicleMotorQuotation();
            }
        });
        TyreAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TyreandRimsecureStatus="False";
                VehicleMotorQuotation();
            }
        });
        IdvValueTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBarDistance.setProgress(50);
            }
        });
        seekBarDistance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 50;


            @Override
            // increment or decrement on process changed
            // increase the textsize
            // with the value of progress
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged=progress;

                if (progressChanged<50){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        seekBarDistance.setProgress(0);
                        IDVTotalPremium.setText(strLessIDVText);

                    }
                }else if (progressChanged>50){
                    seekBarDistance.setProgress(100);
                    IDVTotalPremium.setText(strHighIDVText);

                }else {
                    seekBarDistance.setProgress(50);
                    IDVTotalPremium.setText(NewIDV);
                }


            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // This method will automatically
                // called when the user touches the SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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


                    if (VehicleType.equals("FW")){
                        ProductName="PRIVATE CAR PACKAGE POLICY";
                        ProductCode="2311";
                        VehicleMotorQuotation();
                    }else{
                        ProductName="TWO WHEELER PACKAGE POLICY";
                        ProductCode="2312";
                        VehicleMotorQuotation();
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

                    if (VehicleType.equals("FW")){
                        ProductName="PRIVATE CAR PACKAGE POLICY";
                        ProductCode="2311";
                        VehicleMotorQuotation();
                    }else{
                        ProductName="TWO WHEELER PACKAGE POLICY";
                        ProductCode="2312";
                        VehicleMotorQuotation();
                    }

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
                    strPlanType="Standard Alone";
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


                    if (VehicleType.equals("FW")){
                        ProductName="PRIVATE CAR - OD";
                        ProductCode="2398";
                        VehicleMotorQuotation();
                    }else{
                        ProductName="TWO WHEELER - OD";
                        ProductCode="2397";
                        VehicleMotorQuotation();
                    }

                }
            }
        });
        IndividualRadioBtnRenewal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (IndividualRadioBtnRenewal.isChecked()){
                    IndividualRadioBtnRenewal.setChecked(true);
                    CorporateRadioBtnRenewal.setChecked(false);
                    strCoverageTye="Individual";
                }
            }
        });
        CorporateRadioBtnRenewal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CorporateRadioBtnRenewal.isChecked()){
                    CorporateRadioBtnRenewal.setChecked(true);
                    IndividualRadioBtnRenewal.setChecked(false);
                    strCoverageTye="Corporate";

                }
            }
        });
        PaCoverYesRadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PaCoverYesRadioBtn.isChecked()){
                    PaCoverYesRadioBtn.setChecked(true);
                    PaCoverNoRadioBtn.setChecked(false);
                    strPACover="Yes";
                }
            }
        });
        PaCoverNoRadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (PaCoverNoRadioBtn.isChecked()){
                    PaCoverNoRadioBtn.setChecked(true);
                    PaCoverYesRadioBtn.setChecked(false);
                    strPACover="No";
                }
            }
        });

        GpaCoverYesRadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (GpaCoverYesRadioBtn.isChecked()){
                    GpaCoverYesRadioBtn.setChecked(true);
                    GpaCoverNoRadioBtn.setChecked(false);
                    strGPACover="Yes";
                }
            }
        });
        GpaCoverNoRadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (GpaCoverNoRadioBtn.isChecked()){
                    GpaCoverNoRadioBtn.setChecked(true);
                    GpaCoverYesRadioBtn.setChecked(false);
                    strGPACover="No";
                }
            }
        });

        ActiveDrivingYesRadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ActiveDrivingYesRadioBtn.isChecked()){
                    ActiveDrivingYesRadioBtn.setChecked(true);
                    ActiveDrivingNoRadioBtn.setChecked(false);
                    strDrivingLicence="Yes";
                }
            }
        });
        ActiveDrivingNoRadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ActiveDrivingNoRadioBtn.isChecked()){
                    ActiveDrivingNoRadioBtn.setChecked(true);
                    ActiveDrivingYesRadioBtn.setChecked(false);
                    strDrivingLicence="No";
                }
            }
        });

        RenewalDetailsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Renewal_Motor.super.onBackPressed();
            }
        });

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Renewal_Motor.this,RenewalFinalMotor.class);
                intent.putExtra("VehiclePolicyHolderName",VehiclePolicyHolderName);
                intent.putExtra("VehiclePolicyNumber",VehiclePolicyNumber);
                intent.putExtra("VehicleManufactureYear",RegistrationDate);
                intent.putExtra("VehicleNoOFDateLeft",VehicleNoOFDateLeft);
                intent.putExtra("VehicleEndDate",VehicleEndDate);
                intent.putExtra("FinalPremium",FinalPremium);
                intent.putExtra("QuoteID",QuoteID);
                intent.putExtra("RegistrationNo",RegistrationNo);
                intent.putExtra("GST",GST);
                intent.putExtra("NewIDV",NewIDV);
                intent.putExtra("ManufatureName",ManufatureName);
                intent.putExtra("VehicleModel",VehicleModel);
                intent.putExtra("ProductCode",ProductCode);
                intent.putExtra("NetPremium",NetPremium);
                intent.putExtra("strPolicyPlan",strPolicyPlan);
                intent.putExtra("VehicleType",VehicleType);
                intent.putExtra("NCB",NCB);
                startActivity(intent);
                finish();
            }
        });

    }

    private void VehicleManufacturerMaster() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("VEHICLECLASSCODE",VEHICLECLASSCODE);
            object.put("Type",ManufatureName);
        }catch (Exception e) {
            e.printStackTrace();
        }ProjectVolleyRequest req = new ProjectVolleyRequest(Renewal_Motor.this, object, UrlConstants.BUY_VehicleManufacturer_Master, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    if (Tag == RequestConstants.BUY_POLICY_MOTOR_PRIVATE) {
                        JSONArray arr = null;
                        try {
                            arr = object.getJSONArray("VehicleMake");
                            for (int i = 0; i <arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(0);
                                ManufatureName=obj.getString("VEHICLEMANUFACTURERNAME");
                                strVehicleManufacturerCode=obj.getString("VEHICLEMANUFACTURERCODE");

                                Log.e("strVehicleManufacturerCode11",strVehicleManufacturerCode);
                                VehicleModelMasterAPI();
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
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE);
        req.execute();

    }
    private void VehicleModelMasterAPI() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("MANUFACTURERNAME", ManufatureName);
            object.put("ModelType", VehicleModel);
        }catch (Exception e) {
            e.printStackTrace();
        }ProjectVolleyRequest req = new ProjectVolleyRequest(Renewal_Motor.this, object, UrlConstants.BUY_VehicleModel_Master, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    if (Tag == RequestConstants.BUY_POLICY_MOTOR_PRIVATE_MODEL) {
                        JSONArray arr = null;
                        try {
                            arr = object.getJSONArray("VehicleModel");
                            for (int i = 0; i <arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(0);
                                VehicleModel=obj.getString("VEHICLEMODEL");
                                strVehicleModelCode=obj.getString("VEHICLEMODELCODE");
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
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE_MODEL);
        req.execute();
    }

    private void variantAdrilla() {
        JSONObject parameters = new JSONObject();
        try {
            parameters.put("rc_no", VehicleNumber);
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
//                    str_vehicleManufacturerNm=jsonObject.getString("rc_maker_desc");
                    str_edt_registration_date=jsonObject.getString("rc_regn_dt");
                    strStateCode=jsonObject.getString("state_code");
                    strStateName=jsonObject.getString("rc_registered_at");
                    strRTOCode=jsonObject.getString("rc_rto_code");
                    rc_fuel_desc=jsonObject.getString("rc_fuel_desc");
                    String[] strFuel = rc_fuel_desc.split("/");
                    String strFuel1 = strFuel[0];
                    FuleType=strFuel1;
                    String[] strCity = strStateName.split("[ ,]+");

                    String str1City = strCity[0]; // I
                    strRTOName=str1City;
                    String[] strParts = str_edt_registration_date.split("-");
                    String strFirstString = strParts[0]; // I
                    String strSecondString = strParts[1]; // m a android developer and i
                    yearOfManufacture = strParts[2];


                    if (VehicleType.equals("FW")){
                        RenewalPolicyType.setText("Four Wheeler Insurance");
                        ProductName="PRIVATE CAR PACKAGE POLICY";
                        ProductCode="2311";
                        VehicleClassCode="45";
                        NumberOfWheels="6";
                        VEHICLECLASSCODE="45";
                        VehicleNumber="MH01AE3184";
                        ThreeYearLiner.setVisibility(View.VISIBLE);
                        FiveYearLiner.setVisibility(View.GONE);
                        imgeBike.setBackgroundResource(R.drawable.fourwheelerimg);
                        if (ManufatureName.equalsIgnoreCase("MARUTI")||ManufatureName.equalsIgnoreCase("MARUTI SUZUKI")||ManufatureName.equalsIgnoreCase("MARUTI SUZUKI INDIA LTD")){
                            int ageVehicle=Integer.parseInt(strVehicleAge);
                            if (ageVehicle<=10 && ageVehicle<=5){
                                BasicODStatus="False";
                                BasicTP="False";
                                ELECTRICALACCESSORYODStatus="False";
                                FIBERTANKODStatus="False";
                                LEGALLIABILITYTOPAIDDRIVERStatus="False";
                                NONELECTRICALACCESSORYODStatus="False";
                                OtherODStatus="False";
                                OtherTpStatus="False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus="False";
                                PACOVERTOOWNERDRIVERStatus="False";
                                PACOVERTOPAIDDRIVERStatus="False";
                                PACOVERTOPASSENGERSStatus="False";
                                UNNAMEDPACOVERTOPASSENGERSStatus="False";
                                ACCIDENTALHOSPITALIZATIONStatus="False";
                                DAILYCASHALLOWANCEMETROStatus="False";
                                DAILYCASHALLOWANCENONMETROStatus="False";
                                ENGINEPROTECTORDIESELStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                HYDROSTATICLOCKCOVERStatus="False";
                                KEYREPLACEMENTStatus="False";
                                NilDepreciationWaivercoverStatus="True";
                                RETURNTOINVOICEStatus="True";
                                RoadsideAssistanceStatus="True";
                                ENGINEPROTECTORPETROLStatus="True";
                                COSTOFCONSUMABLESStatus="True";
                                SECURETOWINGStatus="False";
                                TyreandRimsecureStatus="False";
                                VehicleMotorQuotation();
                            }
                            else if (ageVehicle<=10 && ageVehicle>5){
                                BasicODStatus="False";
                                BasicTP="False";
                                ELECTRICALACCESSORYODStatus="False";
                                FIBERTANKODStatus="False";
                                LEGALLIABILITYTOPAIDDRIVERStatus="False";
                                NONELECTRICALACCESSORYODStatus="False";
                                OtherODStatus="False";
                                OtherTpStatus="False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus="False";
                                PACOVERTOOWNERDRIVERStatus="False";
                                PACOVERTOPAIDDRIVERStatus="False";
                                PACOVERTOPASSENGERSStatus="False";
                                UNNAMEDPACOVERTOPASSENGERSStatus="False";
                                ACCIDENTALHOSPITALIZATIONStatus="False";
                                DAILYCASHALLOWANCEMETROStatus="False";
                                DAILYCASHALLOWANCENONMETROStatus="False";
                                ENGINEPROTECTORDIESELStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                HYDROSTATICLOCKCOVERStatus="False";
                                KEYREPLACEMENTStatus="False";
                                NilDepreciationWaivercoverStatus="True";
                                COSTOFCONSUMABLESStatus="True";
                                RoadsideAssistanceStatus="True";
                                RETURNTOINVOICEStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                SECURETOWINGStatus="False";
                                TyreandRimsecureStatus="False";
                                VehicleMotorQuotation();
                            }
                            else{
                                BasicODStatus="False";
                                BasicTP="False";
                                ELECTRICALACCESSORYODStatus="False";
                                FIBERTANKODStatus="False";
                                LEGALLIABILITYTOPAIDDRIVERStatus="False";
                                NONELECTRICALACCESSORYODStatus="False";
                                OtherODStatus="False";
                                OtherTpStatus="False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus="False";
                                PACOVERTOOWNERDRIVERStatus="False";
                                PACOVERTOPAIDDRIVERStatus="False";
                                PACOVERTOPASSENGERSStatus="False";
                                UNNAMEDPACOVERTOPASSENGERSStatus="False";
                                ACCIDENTALHOSPITALIZATIONStatus="False";
                                COSTOFCONSUMABLESStatus="False";
                                DAILYCASHALLOWANCEMETROStatus="False";
                                DAILYCASHALLOWANCENONMETROStatus="False";
                                ENGINEPROTECTORDIESELStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                HYDROSTATICLOCKCOVERStatus="False";
                                KEYREPLACEMENTStatus="False";
                                NilDepreciationWaivercoverStatus="False";
                                RoadsideAssistanceStatus="False";
                                RETURNTOINVOICEStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                SECURETOWINGStatus="False";
                                TyreandRimsecureStatus="False";
                                VehicleMotorQuotation();
                            }
                        }
                        else if (ManufatureName.equalsIgnoreCase("Honda")){
                            int ageVehicle=Integer.parseInt(strVehicleAge);
                            if (ageVehicle<=5 && ageVehicle<=7 ){
                                BasicODStatus="False";
                                BasicTP="False";
                                ELECTRICALACCESSORYODStatus="False";
                                FIBERTANKODStatus="False";
                                LEGALLIABILITYTOPAIDDRIVERStatus="False";
                                NONELECTRICALACCESSORYODStatus="False";
                                OtherODStatus="False";
                                OtherTpStatus="False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus="False";
                                PACOVERTOOWNERDRIVERStatus="False";
                                PACOVERTOPAIDDRIVERStatus="False";
                                PACOVERTOPASSENGERSStatus="False";
                                UNNAMEDPACOVERTOPASSENGERSStatus="False";
                                ACCIDENTALHOSPITALIZATIONStatus="False";
                                DAILYCASHALLOWANCEMETROStatus="True";
                                DAILYCASHALLOWANCENONMETROStatus="True";
                                ENGINEPROTECTORDIESELStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                HYDROSTATICLOCKCOVERStatus="False";
                                KEYREPLACEMENTStatus="True";
                                NilDepreciationWaivercoverStatus="True";
                                RETURNTOINVOICEStatus="True";
                                RoadsideAssistanceStatus="False";
                                COSTOFCONSUMABLESStatus="False";
                                SECURETOWINGStatus="False";
                                TyreandRimsecureStatus="True";
                                VehicleMotorQuotation();
                            }
                            else if (ageVehicle<=7 && ageVehicle>5){
                                BasicODStatus="False";
                                BasicTP="False";
                                ELECTRICALACCESSORYODStatus="False";
                                FIBERTANKODStatus="False";
                                LEGALLIABILITYTOPAIDDRIVERStatus="False";
                                NONELECTRICALACCESSORYODStatus="False";
                                OtherODStatus="False";
                                OtherTpStatus="False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus="False";
                                PACOVERTOOWNERDRIVERStatus="False";
                                PACOVERTOPAIDDRIVERStatus="False";
                                PACOVERTOPASSENGERSStatus="False";
                                UNNAMEDPACOVERTOPASSENGERSStatus="False";
                                ACCIDENTALHOSPITALIZATIONStatus="False";
                                COSTOFCONSUMABLESStatus="False";
                                DAILYCASHALLOWANCEMETROStatus="False";
                                DAILYCASHALLOWANCENONMETROStatus="False";
                                ENGINEPROTECTORDIESELStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                HYDROSTATICLOCKCOVERStatus="False";
                                KEYREPLACEMENTStatus="False";
                                NilDepreciationWaivercoverStatus="True";
                                RoadsideAssistanceStatus="False";
                                RETURNTOINVOICEStatus="False";
                                SECURETOWINGStatus="False";
                                TyreandRimsecureStatus="False";
                                VehicleMotorQuotation();
                            } else if (ageVehicle>7 && ageVehicle>5){
                                BasicODStatus="False";
                                BasicTP="False";
                                ELECTRICALACCESSORYODStatus="False";
                                FIBERTANKODStatus="False";
                                LEGALLIABILITYTOPAIDDRIVERStatus="False";
                                NONELECTRICALACCESSORYODStatus="False";
                                OtherODStatus="False";
                                OtherTpStatus="False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus="False";
                                PACOVERTOOWNERDRIVERStatus="False";
                                PACOVERTOPAIDDRIVERStatus="False";
                                PACOVERTOPASSENGERSStatus="False";
                                UNNAMEDPACOVERTOPASSENGERSStatus="False";
                                ACCIDENTALHOSPITALIZATIONStatus="False";
                                COSTOFCONSUMABLESStatus="False";
                                DAILYCASHALLOWANCEMETROStatus="False";
                                DAILYCASHALLOWANCENONMETROStatus="False";
                                ENGINEPROTECTORDIESELStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                HYDROSTATICLOCKCOVERStatus="False";
                                KEYREPLACEMENTStatus="False";
                                NilDepreciationWaivercoverStatus="False";
                                RoadsideAssistanceStatus="False";
                                RETURNTOINVOICEStatus="False";
                                SECURETOWINGStatus="False";
                                TyreandRimsecureStatus="False";
                                VehicleMotorQuotation();
                            }
                            else{
                                BasicODStatus="False";
                                BasicTP="False";
                                ELECTRICALACCESSORYODStatus="False";
                                FIBERTANKODStatus="False";
                                LEGALLIABILITYTOPAIDDRIVERStatus="False";
                                NONELECTRICALACCESSORYODStatus="False";
                                OtherODStatus="False";
                                OtherTpStatus="False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus="False";
                                PACOVERTOOWNERDRIVERStatus="False";
                                PACOVERTOPAIDDRIVERStatus="False";
                                PACOVERTOPASSENGERSStatus="False";
                                UNNAMEDPACOVERTOPASSENGERSStatus="False";
                                ACCIDENTALHOSPITALIZATIONStatus="False";
                                DAILYCASHALLOWANCEMETROStatus="False";
                                DAILYCASHALLOWANCENONMETROStatus="False";
                                ENGINEPROTECTORDIESELStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                HYDROSTATICLOCKCOVERStatus="False";
                                KEYREPLACEMENTStatus="False";
                                NilDepreciationWaivercoverStatus="False";
                                COSTOFCONSUMABLESStatus="False";
                                RoadsideAssistanceStatus="False";
                                RETURNTOINVOICEStatus="False";
                                SECURETOWINGStatus="False";
                                TyreandRimsecureStatus="False";
                                VehicleMotorQuotation();
                            }
                        }
                        else if (ManufatureName.equalsIgnoreCase("Tata")|| ManufatureName.equalsIgnoreCase("TATA MOTORS LIMITED")){
                            int ageVehicle=Integer.parseInt(strVehicleAge);
                            if (ageVehicle<=10 && ageVehicle<=5 && ageVehicle<=7 ){
                                BasicODStatus="False";
                                BasicTP="False";
                                ELECTRICALACCESSORYODStatus="False";
                                FIBERTANKODStatus="False";
                                LEGALLIABILITYTOPAIDDRIVERStatus="False";
                                NONELECTRICALACCESSORYODStatus="False";
                                OtherODStatus="False";
                                OtherTpStatus="False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus="False";
                                PACOVERTOOWNERDRIVERStatus="False";
                                PACOVERTOPAIDDRIVERStatus="False";
                                PACOVERTOPASSENGERSStatus="False";
                                UNNAMEDPACOVERTOPASSENGERSStatus="False";
                                ACCIDENTALHOSPITALIZATIONStatus="False";

                                DAILYCASHALLOWANCEMETROStatus="False";
                                DAILYCASHALLOWANCENONMETROStatus="False";
                                ENGINEPROTECTORDIESELStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                HYDROSTATICLOCKCOVERStatus="False";
                                KEYREPLACEMENTStatus="True";
                                NilDepreciationWaivercoverStatus="True";
                                RETURNTOINVOICEStatus="True";
                                RoadsideAssistanceStatus="True";
                                ENGINEPROTECTORPETROLStatus="True";
                                COSTOFCONSUMABLESStatus="True";
                                SECURETOWINGStatus="True";
                                TyreandRimsecureStatus="False";
                                VehicleMotorQuotation();
                            }
                            else if (ageVehicle<=10 && ageVehicle<=7 && ageVehicle>5){
                                BasicODStatus="False";
                                BasicTP="False";
                                ELECTRICALACCESSORYODStatus="False";
                                FIBERTANKODStatus="False";
                                LEGALLIABILITYTOPAIDDRIVERStatus="False";
                                NONELECTRICALACCESSORYODStatus="False";
                                OtherODStatus="False";
                                OtherTpStatus="False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus="False";
                                PACOVERTOOWNERDRIVERStatus="False";
                                PACOVERTOPAIDDRIVERStatus="False";
                                PACOVERTOPASSENGERSStatus="False";
                                UNNAMEDPACOVERTOPASSENGERSStatus="False";
                                ACCIDENTALHOSPITALIZATIONStatus="False";
                                DAILYCASHALLOWANCEMETROStatus="False";
                                DAILYCASHALLOWANCENONMETROStatus="False";
                                ENGINEPROTECTORDIESELStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                HYDROSTATICLOCKCOVERStatus="False";
                                KEYREPLACEMENTStatus="True";
                                NilDepreciationWaivercoverStatus="True";
                                RETURNTOINVOICEStatus="False";
                                RoadsideAssistanceStatus="True";
                                ENGINEPROTECTORPETROLStatus="True";
                                COSTOFCONSUMABLESStatus="True";
                                SECURETOWINGStatus="False";
                                TyreandRimsecureStatus="False";
                                VehicleMotorQuotation();
                            }
                            else if (ageVehicle<=10 && ageVehicle>7 && ageVehicle>5){
                                BasicODStatus="False";
                                BasicTP="False";
                                ELECTRICALACCESSORYODStatus="False";
                                FIBERTANKODStatus="False";
                                LEGALLIABILITYTOPAIDDRIVERStatus="False";
                                NONELECTRICALACCESSORYODStatus="False";
                                OtherODStatus="False";
                                OtherTpStatus="False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus="False";
                                PACOVERTOOWNERDRIVERStatus="False";
                                PACOVERTOPAIDDRIVERStatus="False";
                                PACOVERTOPASSENGERSStatus="False";
                                UNNAMEDPACOVERTOPASSENGERSStatus="False";
                                ACCIDENTALHOSPITALIZATIONStatus="False";
                                DAILYCASHALLOWANCEMETROStatus="False";
                                DAILYCASHALLOWANCENONMETROStatus="False";
                                ENGINEPROTECTORDIESELStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                HYDROSTATICLOCKCOVERStatus="False";
                                KEYREPLACEMENTStatus="False";
                                NilDepreciationWaivercoverStatus="False";
                                RETURNTOINVOICEStatus="False";
                                RoadsideAssistanceStatus="True";
                                ENGINEPROTECTORPETROLStatus="False";
                                COSTOFCONSUMABLESStatus="False";
                                SECURETOWINGStatus="False";
                                TyreandRimsecureStatus="False";
                                VehicleMotorQuotation();
                            }
                            else{
                                BasicODStatus="False";
                                BasicTP="False";
                                ELECTRICALACCESSORYODStatus="False";
                                FIBERTANKODStatus="False";
                                LEGALLIABILITYTOPAIDDRIVERStatus="False";
                                NONELECTRICALACCESSORYODStatus="False";
                                OtherODStatus="False";
                                OtherTpStatus="False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus="False";
                                PACOVERTOOWNERDRIVERStatus="False";
                                PACOVERTOPAIDDRIVERStatus="False";
                                PACOVERTOPASSENGERSStatus="False";
                                UNNAMEDPACOVERTOPASSENGERSStatus="False";
                                ACCIDENTALHOSPITALIZATIONStatus="False";
                                DAILYCASHALLOWANCEMETROStatus="False";
                                DAILYCASHALLOWANCENONMETROStatus="False";
                                ENGINEPROTECTORDIESELStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                HYDROSTATICLOCKCOVERStatus="False";
                                KEYREPLACEMENTStatus="False";
                                NilDepreciationWaivercoverStatus="False";
                                COSTOFCONSUMABLESStatus="False";
                                RoadsideAssistanceStatus="False";
                                RETURNTOINVOICEStatus="False";
                                ENGINEPROTECTORPETROLStatus="False";
                                SECURETOWINGStatus="False";
                                TyreandRimsecureStatus="False";
                                VehicleMotorQuotation();
                            }
                        }
                        else {
                            int ageVehicle = Integer.parseInt(strVehicleAge);
                            if (ageVehicle <= 10 && ageVehicle <= 5 && ageVehicle <= 7) {
                                BasicODStatus = "False";
                                BasicTP = "False";
                                ELECTRICALACCESSORYODStatus = "False";
                                FIBERTANKODStatus = "False";
                                LEGALLIABILITYTOPAIDDRIVERStatus = "False";
                                NONELECTRICALACCESSORYODStatus = "False";
                                OtherODStatus = "False";
                                OtherTpStatus = "False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus = "False";
                                PACOVERTOOWNERDRIVERStatus = "False";
                                PACOVERTOPAIDDRIVERStatus = "False";
                                PACOVERTOPASSENGERSStatus = "False";
                                UNNAMEDPACOVERTOPASSENGERSStatus = "False";
                                ACCIDENTALHOSPITALIZATIONStatus = "True";
                                DAILYCASHALLOWANCEMETROStatus = "True";
                                DAILYCASHALLOWANCENONMETROStatus = "True";
                                ENGINEPROTECTORDIESELStatus = "True";
                                HYDROSTATICLOCKCOVERStatus = "False";
                                KEYREPLACEMENTStatus = "True";
                                NilDepreciationWaivercoverStatus = "True";
                                RETURNTOINVOICEStatus = "True";
                                RoadsideAssistanceStatus = "True";
                                ENGINEPROTECTORPETROLStatus = "True";
                                COSTOFCONSUMABLESStatus = "True";
                                SECURETOWINGStatus = "True";
                                TyreandRimsecureStatus = "False";
                                VehicleMotorQuotation();
                            } else if (ageVehicle <= 10 && ageVehicle <= 7 && ageVehicle > 5) {
                                BasicODStatus = "False";
                                BasicTP = "False";
                                ELECTRICALACCESSORYODStatus = "False";
                                FIBERTANKODStatus = "False";
                                LEGALLIABILITYTOPAIDDRIVERStatus = "False";
                                NONELECTRICALACCESSORYODStatus = "False";
                                OtherODStatus = "False";
                                OtherTpStatus = "False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus = "False";
                                PACOVERTOOWNERDRIVERStatus = "False";
                                PACOVERTOPAIDDRIVERStatus = "False";
                                PACOVERTOPASSENGERSStatus = "False";
                                UNNAMEDPACOVERTOPASSENGERSStatus = "False";
                                ACCIDENTALHOSPITALIZATIONStatus = "False";
                                DAILYCASHALLOWANCEMETROStatus = "False";
                                DAILYCASHALLOWANCENONMETROStatus = "False";
                                ENGINEPROTECTORDIESELStatus = "True";
                                HYDROSTATICLOCKCOVERStatus = "False";
                                KEYREPLACEMENTStatus = "False";
                                NilDepreciationWaivercoverStatus = "True";
                                RETURNTOINVOICEStatus = "False";
                                RoadsideAssistanceStatus = "True";
                                ENGINEPROTECTORPETROLStatus = "True";
                                COSTOFCONSUMABLESStatus = "True";
                                SECURETOWINGStatus = "False";
                                TyreandRimsecureStatus = "False";
                                VehicleMotorQuotation();
                            } else if (ageVehicle <= 10 && ageVehicle > 7 && ageVehicle > 5) {
                                BasicODStatus = "False";
                                BasicTP = "False";
                                ELECTRICALACCESSORYODStatus = "False";
                                FIBERTANKODStatus = "False";
                                LEGALLIABILITYTOPAIDDRIVERStatus = "False";
                                NONELECTRICALACCESSORYODStatus = "False";
                                OtherODStatus = "False";
                                OtherTpStatus = "False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus = "False";
                                PACOVERTOOWNERDRIVERStatus = "False";
                                PACOVERTOPAIDDRIVERStatus = "False";
                                PACOVERTOPASSENGERSStatus = "False";
                                UNNAMEDPACOVERTOPASSENGERSStatus = "False";
                                ACCIDENTALHOSPITALIZATIONStatus = "False";
                                DAILYCASHALLOWANCEMETROStatus = "False";
                                DAILYCASHALLOWANCENONMETROStatus = "False";
                                ENGINEPROTECTORDIESELStatus = "False";
                                HYDROSTATICLOCKCOVERStatus = "False";
                                KEYREPLACEMENTStatus = "False";
                                NilDepreciationWaivercoverStatus = "False";
                                RETURNTOINVOICEStatus = "False";
                                RoadsideAssistanceStatus = "True";
                                ENGINEPROTECTORPETROLStatus = "False";
                                COSTOFCONSUMABLESStatus = "False";
                                SECURETOWINGStatus = "False";
                                TyreandRimsecureStatus = "False";
                                VehicleMotorQuotation();
                            } else {
                                BasicODStatus = "False";
                                BasicTP = "False";
                                ELECTRICALACCESSORYODStatus = "False";
                                FIBERTANKODStatus = "False";
                                LEGALLIABILITYTOPAIDDRIVERStatus = "False";
                                NONELECTRICALACCESSORYODStatus = "False";
                                OtherODStatus = "False";
                                OtherTpStatus = "False";
                                PACOVERTOEMPLOYEESOFINSUREDStatus = "False";
                                PACOVERTOOWNERDRIVERStatus = "False";
                                PACOVERTOPAIDDRIVERStatus = "False";
                                PACOVERTOPASSENGERSStatus = "False";
                                UNNAMEDPACOVERTOPASSENGERSStatus = "False";
                                ACCIDENTALHOSPITALIZATIONStatus = "False";
                                DAILYCASHALLOWANCEMETROStatus = "False";
                                DAILYCASHALLOWANCENONMETROStatus = "False";
                                ENGINEPROTECTORDIESELStatus = "False";
                                ENGINEPROTECTORPETROLStatus = "False";
                                HYDROSTATICLOCKCOVERStatus = "False";
                                KEYREPLACEMENTStatus = "False";
                                NilDepreciationWaivercoverStatus = "False";
                                COSTOFCONSUMABLESStatus = "False";
                                RoadsideAssistanceStatus = "False";
                                RETURNTOINVOICEStatus = "False";
                                ENGINEPROTECTORPETROLStatus = "False";
                                SECURETOWINGStatus = "False";
                                TyreandRimsecureStatus = "False";
                                VehicleMotorQuotation();
                            }
                        }
                    }
                    else{
                        RenewalPolicyType.setText("Two Wheeler Insurance");
                        ProductName="TWO WHEELER PACKAGE POLICY";
                        ProductCode="2312";
                        VehicleClassCode="37";
                        NumberOfWheels="2";
                        VEHICLECLASSCODE="37";
                        VehicleNumber="MH04HQ8035";
                        ThreeYearLiner.setVisibility(View.GONE);
                        FiveYearLiner.setVisibility(View.VISIBLE);
                        imgeBike.setBackgroundResource(R.drawable.scooty_motor_img);
                        BasicODStatus="False";
                        BasicTP="False";
                        ELECTRICALACCESSORYODStatus="False";
                        FIBERTANKODStatus="False";
                        LEGALLIABILITYTOPAIDDRIVERStatus="False";
                        NONELECTRICALACCESSORYODStatus="False";
                        OtherODStatus="False";
                        OtherTpStatus="False";
                        PACOVERTOEMPLOYEESOFINSUREDStatus="False";
                        PACOVERTOOWNERDRIVERStatus="False";
                        PACOVERTOPAIDDRIVERStatus="False";
                        PACOVERTOPASSENGERSStatus="False";
                        UNNAMEDPACOVERTOPASSENGERSStatus="False";
                        ACCIDENTALHOSPITALIZATIONStatus="True";
                        COSTOFCONSUMABLESStatus="True";
                        DAILYCASHALLOWANCEMETROStatus="True";
                        DAILYCASHALLOWANCENONMETROStatus="False";
                        ENGINEPROTECTORDIESELStatus="False";
                        HYDROSTATICLOCKCOVERStatus="False";
                        KEYREPLACEMENTStatus="True";
                        NilDepreciationWaivercoverStatus="True";
                        RoadsideAssistanceStatus="True";
                        RETURNTOINVOICEStatus="True";
                        ENGINEPROTECTORPETROLStatus="True";
                        SECURETOWINGStatus="True";
                        TyreandRimsecureStatus="False";
                        VehicleMotorQuotation();
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
        queue.add(request);
    }

    private void renewQuotation() {
        customprogress.showProgressBar();
        StringRequest request = new StringRequest(Request.Method.GET, UrlConstants.RENEWAL_MOTOR_URL + VehiclePolicyNumber + "&WACode=20000001&WAAppCode=30000004&DocType=WebAPI", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    try {
                        customprogress.hideProgressBar();
                        JSONObject object = new JSONObject(response);
                        if (object != null){
                            Log.e("@@@@@", String.valueOf(object));
                             String ErrorDesc = object.getString("ErrorDesc");
                             if (ErrorDesc.equals("Quotation Successfully Generate.")){
                                 FinalPremium = object.getString("FinalPremium");
                                 QuoteID = object.getString("QuoteID");
                                 RegistrationNo = object.getString("RegistrationNo");
                                 GST = object.getString("IGST");
                                 NewIDV = object.getString("NewIDV");
                                 ManufatureName = object.getString("ManufatureName");
                                 VehicleModel = object.getString("VehicleModel");
                                 ProductCode = object.getString("ProductCode");
                                 NetPremium = object.getString("NetPremium");
                                 VehiclePolicyHolderName = object.getString("ProposerName");
                                 NCB = object.getString("NCB");
//                                 RegistrationDate = object.getString("RegistrationDate");
                                 Log.e("nameVehicle_check",VehicleModel);

                                 nameVehicle.setText(VehicleModel+" "+ManufatureName);


                                 RegistrationNoTxt.setText(RegistrationNo);
                                 ManufatureTxt.setText(ManufatureName);
                                 ModelTxt.setText(VehicleModel);
                                 NetPremiumTxt.setText(NetPremium);
                                 PremiumTxt.setText("₹ "+FinalPremium);
                                 TotalPremium.setText("₹ "+FinalPremium);
                                 NCBTxt.setText(NCB+" %");
                                 GSTTxt.setText(GST);
                                 RenewalIDVTxt.setText(NewIDV);
                                 VehicleManufactureYearTxt.setText(RegistrationDate);
                                 VehiclePolicyHolderNameTxt.setText("Hello "+VehiclePolicyHolderName);
                                 if (ProductCode.equals("2311")){
                                     strPolicyPlan="Comprehensive";
                                     PolicyPlanTxt.setText(strPolicyPlan);
                                 }else {
                                     strPolicyPlan="Standard Plan";
                                     PolicyPlanTxt.setText(strPolicyPlan);
                                 }
                             }else {
                                 Toast.makeText(getApplication(), ""+ErrorDesc, Toast.LENGTH_SHORT).show();
                             }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        customprogress.hideProgressBar();

                    }
                } else {
                    customprogress.hideProgressBar();
                    Toast.makeText(Renewal_Motor.this, "We're facing technical issue ,Please try again later", Toast.LENGTH_SHORT).show();

                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                customprogress.hideProgressBar();
                Log.e("error is ", "" + error);
            }
        }) ;

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
//        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);

//        RequestQueue queue = Volley.newRequestQueue(Renewal_Motor.this);
//        queue.add(request);
    }
    private void VehicleMotorQuotation() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("ProductName", ProductName);
            object.put("MobileNo", pref.getMOBILE());
            object.put("UserEmail", pref.getEmailId());
            object.put("UserName", VehiclePolicyHolderName);
            object.put("RegistrationNumber", RegistrationNo);
            object.put("ProductCode", ProductCode);
            object.put("Product", "");
            object.put("BusinessType", "RollOver");
            object.put("VehicleClassCode", VehicleClassCode);
            object.put("VehicleMakeCode", strVehicleManufacturerCode);
            object.put("YearofManufacture",VehicleManufactureYear);
            object.put("VehicleType", "Old");
            object.put("CubicCapacity", "0");
            object.put("NumberOfWheels", "");
            object.put("ChassisNumber", VehicleChasisNo);
            object.put("EngineNumber", VehicleEngineNo);
            object.put("VehicleAge", strVehicleAge);
            object.put("VehicleModelCode", strVehicleModelCode);
            object.put("RTOLocationCode", strRTOCode);
            object.put("GrossVehicleWeight", "0");
            object.put("PlaceOfRegistration",strRTOName);
            object.put("VehicleModel", VehicleModel);
            object.put("DateOfFirstRegistration", str_edt_registration_date);
            object.put("DateOfRegistration", str_edt_registration_date);
            object.put("City", strRTOName);
            object.put("SumInsured", "");
            object.put("IDV", "");
            object.put("FuelType", FuleType);
            object.put("VehicleMake", ManufatureName);
            object.put("Fromdate", today);
            object.put("Todate", nextYear);
            object.put("BasicODStatus", BasicODStatus);
            object.put("ELECTRICALACCESSORYODStatus", ELECTRICALACCESSORYODStatus);
            object.put("NONELECTRICALACCESSORYODStatus", NONELECTRICALACCESSORYODStatus);
            object.put("BasicTP", BasicTP);
            object.put("PACOVERTOEMPLOYEESOFINSUREDStatus", PACOVERTOEMPLOYEESOFINSUREDStatus);
            object.put("PACOVERTOPASSENGERSStatus", PACOVERTOPASSENGERSStatus);
            object.put("PACOVERTOPAIDDRIVERStatus", PACOVERTOPAIDDRIVERStatus);
            object.put("OtherTPStatus", OtherTpStatus);
            object.put("FIBERTANKODStatus", FIBERTANKODStatus);
            object.put("OtherODStatus", OtherODStatus);
            object.put("UNNAMEDPACOVERTOPASSENGERSStatus", UNNAMEDPACOVERTOPASSENGERSStatus);
            object.put("PACOVERTOOWNERDRIVERStatus", PACOVERTOOWNERDRIVERStatus);
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

        }catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Renewal_Motor.this, object, UrlConstants.BUY_VehicleMotorQuotation, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    if (Tag == RequestConstants.BUY_POLICY_MOTOR_PRIVATE_Quotation) {
                        try {
                            JSONObject CustomerJsonObject = object.getJSONObject("Customer");
                            JSONObject ProductJsonObject = object.getJSONObject("Product");
                            Log.e("ProductJsonObject",ProductJsonObject.toString());
                            JSONObject RisksDataJsonObject = ProductJsonObject.getJSONObject("Risks");
                            JSONObject RiskDataJsonObject = RisksDataJsonObject.getJSONObject("Risk");
                            Log.e("RiskDataJsonObject",RiskDataJsonObject.toString());

                            JSONObject RisksDatasJsonObject = RiskDataJsonObject.getJSONObject("RisksData");
                            Log.e("RisksDatasJsonObject",RisksDatasJsonObject.toString());


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

                            VehicleExShowroomPrice = VehicleExShowroomPriceJsonObject.getString("Value");
                            NetPremium = NetPremiumJsonObject.getString("Value");
                            FinalPremium = TotalPremiumJsonObject.getString("Value");
                            Log.e("TotalValue",FinalPremium);
                            QuoteID = CustomerJsonObject.getString("PosPolicyNo");
                            GST = ServiceTaxJsonObject.getString("Value");
                            NewIDV = VehicleIDVJsonObject.getString("Value");

                            TotalPremium.setText("₹ "+FinalPremium);
                            PremiumTxt.setText("₹ "+FinalPremium);
                            IdvValueTxt.setText(NewIDV);
                            IDVTotalPremium.setText(NewIDV);
//                            ComprehensivePremium.setText(FinalPremium);
//                            ThirdPartyPremium.setText(FinalPremium);
//                            StandardPlanTotalPremium.setText(FinalPremium);

                            if (OneYearComprehensiveRadio.isChecked()){
                                OneYearComprehensiveTxt.setText(FinalPremium);
                                TotalPremiumComprehensive.setText(FinalPremium);
                                thirdComprehensiveTxt.setText("");
                                FiveComprehensiveTxt.setText("");
                                StandardPlanPremiumTxt.setText("");
                                TPTextView.setText("");
                            }else if (ThreeYearComprehensiveRadio.isChecked()){
                                OneYearComprehensiveTxt.setText("");
                                FiveComprehensiveTxt.setText("");
                                StandardPlanPremiumTxt.setText("");
                                TPTextView.setText("");
                                thirdComprehensiveTxt.setText(FinalPremium);
                                TotalPremiumComprehensive.setText(FinalPremium);
                            }else if (FiveYearComprehensiveRadio.isChecked()){
                                OneYearComprehensiveTxt.setText("");
                                thirdComprehensiveTxt.setText("");
                                TPTextView.setText("");
                                FiveComprehensiveTxt.setText(FinalPremium);
                                TotalPremiumComprehensive.setText(FinalPremium);
                            }else if (OneYearThirdPartyRadio.isChecked()){
                                OneYearComprehensiveTxt.setText("");
                                thirdComprehensiveTxt.setText("");
                                FiveComprehensiveTxt.setText("");
                                StandardPlanPremiumTxt.setText("");
                                TPTextView.setText(FinalPremium);
                                TotalPremiumTp.setText(FinalPremium);
                            }else if (OneYearStandardAloneRadio.isChecked()){
                                OneYearComprehensiveTxt.setText("");
                                thirdComprehensiveTxt.setText("");
                                FiveComprehensiveTxt.setText("");
                                TPTextView.setText("");
                                StandardPlanPremiumTxt.setText(FinalPremium);
                                StandardPlanPremium.setText(FinalPremium);
                            }

                            if (!NewIDV.equals("")){
                                float lest= Float.parseFloat(NewIDV)*20/100;
                                strLessIDVText= String.valueOf(Float.parseFloat(NewIDV)-lest);
                                strHighIDVText= String.valueOf(lest+Float.parseFloat(NewIDV));
                                lessIDVText.setText(strLessIDVText);
                                HighIDVText.setText(strHighIDVText);
                            }else{
                                NewIDV="0.0";
                                IdvValueTxt.setText(NewIDV);
                                float lest= Float.parseFloat(NewIDV)*20/100;
                                strLessIDVText= String.valueOf(Float.parseFloat(NewIDV)-lest);
                                strHighIDVText= String.valueOf(lest+Float.parseFloat(NewIDV));
                                lessIDVText.setText(strLessIDVText);
                                HighIDVText.setText(strHighIDVText);
                            }

                            for (int k=0; k <CoversDataJsonObject.length();k++) {
                                JSONObject CoverGroupsJson = CoversDataJsonObject.getJSONObject(k).optJSONObject("CoverGroups");
                                Log.e("CoverGroupsJson", CoverGroupsJson.toString());

                                String Value = CoverGroupsJson.getString("Value");
                                if (Value.equals("Basic OD")) {
                                    AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                    if (!AdditionalCoverPremium.equals("")){
                                        AdditionalCoverPremiumOD= Double.parseDouble(AdditionalCoverPremium);
                                        Log.e("AdditionalCoverPremiumOD",AdditionalCoverPremium);
                                        if (!AdditionalCoverPremium.equals("0.00")) {
                                            BasicODCardView.setVisibility(View.VISIBLE);
                                            BasicODPremiumTxt.setText(AdditionalCoverPremium);
                                        } else {
                                            BasicODCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        BasicODCardView.setVisibility(View.GONE);
                                        AdditionalCoverPremium="0.0";
                                    }

                                } else if (Value.equals("Basic TP")) {
                                    AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                    Log.e("AdditionalCoverPremiumTp",AdditionalCoverPremium);
                                    if (!AdditionalCoverPremium.equals("")){
                                        AdditionalCoverPremiumTP= Double.parseDouble(AdditionalCoverPremium);
                                        Log.e("AdditionalCoverPremiumOD",AdditionalCoverPremium);
                                        if (!AdditionalCoverPremium.equals("0.00")) {
                                            BasicTPCardView.setVisibility(View.VISIBLE);
                                            BasicTPPremiumTxt.setText(AdditionalCoverPremium);
                                        } else {
                                            BasicTPCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        BasicTPCardView.setVisibility(View.GONE);
                                        AdditionalCoverPremium="0.0";
                                    }
                                } else if (Value.equals("ELECTRICAL ACCESSORY OD")) {
                                    AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                    if (!AdditionalCoverPremium.equals("")){
                                        AdditionalCoverPremiumEl= Double.parseDouble(AdditionalCoverPremium);
                                        Log.e("AdditionalCoverPremiumEl",AdditionalCoverPremium);
                                        if (!AdditionalCoverPremium.equals("0.00")) {
                                            ElectricalCardView.setVisibility(View.VISIBLE);
                                            ElectricalPremiumTxt.setText(AdditionalCoverPremium);
                                        } else {
                                            ElectricalCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        ElectricalCardView.setVisibility(View.GONE);
                                        AdditionalCoverPremium="0.0";
                                    }

                                } else if (Value.equals("FIBERTANK OD")) {
                                    AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                    if (!AdditionalCoverPremium.equals("")){
                                        AdditionalCoverPremiumFI= Double.parseDouble(AdditionalCoverPremium);
                                        if (!AdditionalCoverPremium.equals("0.00")) {
                                            FIBERTANKODCardView.setVisibility(View.VISIBLE);
                                            FIBERTANKPremiumTxt.setText(AdditionalCoverPremium);
                                        } else {
                                            FIBERTANKODCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        FIBERTANKODCardView.setVisibility(View.GONE);
                                        AdditionalCoverPremium="0.0";
                                    }

                                }
                                else if (Value.equals("LEGAL LIABILITY TO PAID DRIVER")) {
                                    AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                    if (!AdditionalCoverPremium.equals("")){
                                        AdditionalCoverPremiumLegal= Double.parseDouble(AdditionalCoverPremium);
                                        if (!AdditionalCoverPremium.equals("0.00")) {
                                            LegalLiabilityCardView.setVisibility(View.VISIBLE);
                                            LegalPremiumTxt.setText(AdditionalCoverPremium);
                                        } else {
                                            LegalLiabilityCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        LegalLiabilityCardView.setVisibility(View.GONE);
                                        AdditionalCoverPremium="0.0";
                                    }

                                }
                                else if (Value.equals("NON ELECTRICAL ACCESSORY OD")) {
                                    AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                    if (!AdditionalCoverPremium.equals("")){
                                        AdditionalCoverPremiumNon= Double.parseDouble(AdditionalCoverPremium);
                                        if (!AdditionalCoverPremium.equals("0.00")) {
                                            NonLegalLiabilityCardView.setVisibility(View.VISIBLE);
                                            NonElectricalPremiumTxt.setText(AdditionalCoverPremium);
                                        } else {
                                            NonLegalLiabilityCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        NonLegalLiabilityCardView.setVisibility(View.GONE);
                                        AdditionalCoverPremium="0.0";
                                    }

                                }
                                else if (Value.equals("Other OD")) {
                                    AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                    if (!AdditionalCoverPremium.equals("")){
                                        AdditionalCoverPremiumOtherOD= Double.parseDouble(AdditionalCoverPremium);
                                        if (!AdditionalCoverPremium.equals("0.00")) {
                                            OtherOdCardView.setVisibility(View.VISIBLE);
                                            OtherOdPremiumTxt.setText(AdditionalCoverPremium);
                                        } else {
                                            OtherOdCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        OtherOdCardView.setVisibility(View.GONE);
                                        AdditionalCoverPremium="0.0";
                                    }

                                }
                                else if (Value.equals("Other TP")) {
                                    AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                    if (!AdditionalCoverPremium.equals("")){
                                        AdditionalCoverPremiumOtherTP= Double.parseDouble(AdditionalCoverPremium);
                                        if (!AdditionalCoverPremium.equals("0.00")) {
                                            OtherTpCardView.setVisibility(View.VISIBLE);
                                            OtherTpPremiumTxt.setText(AdditionalCoverPremium);
                                        } else {
                                            OtherTpCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        OtherTpCardView.setVisibility(View.GONE);
                                        AdditionalCoverPremium="0.0";
                                    }
                                }
                                else if (Value.equals("PA COVER TO EMPLOYEES OF INSURED")) {
                                    AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                    if (!AdditionalCoverPremium.equals("")){
                                        AdditionalCoverPremiumPACOVER= Double.parseDouble(AdditionalCoverPremium);
                                        if (!AdditionalCoverPremium.equals("0.00")) {
                                            EMPLOYEESCardView.setVisibility(View.VISIBLE);
                                            EmployeesInsuredPremiumTxt.setText(AdditionalCoverPremium);
                                        } else {
                                            EMPLOYEESCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        EMPLOYEESCardView.setVisibility(View.GONE);
                                        AdditionalCoverPremium="0.0";
                                    }

                                }
                                else if (Value.equals("PA COVER TO OWNER DRIVER")) {
                                    AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                    if (!AdditionalCoverPremium.equals("")){
                                        AdditionalCoverPremiumOWNERDRIVER= Double.parseDouble(AdditionalCoverPremium);
                                        if (!AdditionalCoverPremium.equals("0.00")) {
                                            OwnerDriverCardView.setVisibility(View.VISIBLE);
                                            OwnerDriverPremiumTxt.setText(AdditionalCoverPremium);
                                        } else {
                                            OwnerDriverCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        OwnerDriverCardView.setVisibility(View.GONE);
                                        AdditionalCoverPremium="0.0";
                                    }

                                }
                                else if (Value.equals("PA COVER TO PAID DRIVER")) {
                                    AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                    if (!AdditionalCoverPremium.equals("")){
                                        AdditionalCoverPremiumPAIDDRIVER= Double.parseDouble(AdditionalCoverPremium);
                                        if (!AdditionalCoverPremium.equals("0.00")) {
                                            PaidDriverCardView.setVisibility(View.VISIBLE);
                                            PaidDriverPremiumTxt.setText(AdditionalCoverPremium);
                                        } else {
                                            PaidDriverCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        AdditionalCoverPremium="0.0";
                                        PaidDriverCardView.setVisibility(View.GONE);
                                    }

                                }
                                else if (Value.equals("PA COVER TO PASSENGERS")) {
                                    AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                    if (!AdditionalCoverPremium.equals("")){
                                        AdditionalCoverPremiumPASSENGERS= Double.parseDouble(AdditionalCoverPremium);
                                        if (!AdditionalCoverPremium.equals("0.00")) {
                                            PASSENGERSCardView.setVisibility(View.VISIBLE);
                                            PassengersPremiumTxt.setText(AdditionalCoverPremium);
                                        } else {
                                            PASSENGERSCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        AdditionalCoverPremium="0.0";
                                        PASSENGERSCardView.setVisibility(View.GONE);
                                    }
                                }
                                else if (Value.equals("UNNAMED PA COVER TO PASSENGERS")) {
                                    AdditionalCoverPremium = CoversDataJsonObject.getJSONObject(k).optJSONObject("Premium").getString("Value");
                                    if (!AdditionalCoverPremium.equals("")){
                                        AdditionalCoverPremiumUNNAMED= Double.parseDouble(AdditionalCoverPremium);
                                        if (!AdditionalCoverPremium.equals("0.00")) {
                                            UnnamedPassengerCardView.setVisibility(View.VISIBLE);
                                            UnnamedPassengersPremiumTxt.setText(AdditionalCoverPremium);
                                        } else {
                                            UnnamedPassengerCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        AdditionalCoverPremium="0.0";
                                        UnnamedPassengerCardView.setVisibility(View.GONE);
                                    }
                                }
                                double DoubleValue= AdditionalCoverPremiumOD+AdditionalCoverPremiumTP+AdditionalCoverPremiumEl+AdditionalCoverPremiumFI+AdditionalCoverPremiumLegal+AdditionalCoverPremiumNon+AdditionalCoverPremiumOtherOD+AdditionalCoverPremiumOtherTP+AdditionalCoverPremiumPACOVER+AdditionalCoverPremiumOWNERDRIVER+AdditionalCoverPremiumPAIDDRIVER+AdditionalCoverPremiumPASSENGERS+AdditionalCoverPremiumUNNAMED;
                                addOnsCover= String.valueOf(DoubleValue);
                                Log.e("addOnsCover", addOnsCover);
                            }
                            //                                if (CoverGroupsJson.getString("Value").equals(Value)){
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

                            for (int j=0; j <AddonCoversDataJsonObject.length();j++){
                                JSONObject addOnCoverJson=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("AddonCoverGroups");
                                Log.e("addOnCoverJson",addOnCoverJson.toString());

                                String Value  = addOnCoverJson.getString("Value");
                                if (Value.equals("ACCIDENTAL HOSPITALIZATION")){
                                    PremiumValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                    if (!PremiumValue.equals("")){
                                        AdditionalHospitalization= Double.parseDouble(PremiumValue);
                                        if (!PremiumValue.equals("0.00")){
                                            AccidentalCardView.setVisibility(View.VISIBLE);
                                            AccidentalHospitalPremium.setText(PremiumValue);
                                        }else{
                                            AccidentalCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        AccidentalCardView.setVisibility(View.GONE);
                                        PremiumValue="0.0";
                                    }

                                }
                                else if (Value.equals("COST OF CONSUMABLES")){
                                    PremiumValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                    if (!PremiumValue.equals("")){
                                        AdditionalCostOfConsumbales= Double.parseDouble(PremiumValue);
                                        if (!PremiumValue.equals("0.00")){
                                            CostOfCardView.setVisibility(View.VISIBLE);
                                            CostOfConsumableNamePremium.setText(PremiumValue);
                                        }else{
                                            CostOfCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        CostOfCardView.setVisibility(View.GONE);
                                        PremiumValue="0.0";
                                    }
                                }
                                else if (Value.equals("DAILY CASH ALLOWANCE - METRO")){
                                    PremiumValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                    if (!PremiumValue.equals("")){
                                        AdditionalDailyCashMetro= Double.parseDouble(PremiumValue);
                                        if (!PremiumValue.equals("0.00")){
                                            DailyCashCardView.setVisibility(View.VISIBLE);
                                            DailyCashAllowanceNamePremium.setText(PremiumValue);
                                        }else{
                                            DailyCashCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        DailyCashCardView.setVisibility(View.GONE);
                                        PremiumValue="0.0";
                                    }


                                }
                                else if (Value.equals("DAILY CASH ALLOWANCE - NONMETRO")){
                                    PremiumValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                    if (!PremiumValue.equals("")){
                                        AdditionalDailCash= Double.parseDouble(PremiumValue);
                                        if (!PremiumValue.equals("0.00")){
                                            DailyCardView.setVisibility(View.VISIBLE);
                                            DailyCashNonMetroPremium.setText(PremiumValue);
                                        }else{
                                            DailyCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        PremiumValue="0.0";
                                        DailyCardView.setVisibility(View.GONE);
                                    }

                                }
                                else if (Value.equals("ENGINE PROTECTOR - DIESEL")){
                                    PremiumValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                    if (!PremiumValue.equals("")){
                                        AdditionalEngineDisesel= Double.parseDouble(PremiumValue);
                                        if (!PremiumValue.equals("0.00")){
                                            EngineProtectorCardView.setVisibility(View.VISIBLE);
                                            EngineProtectorDieselPremium.setText(PremiumValue);
                                        }else{
                                            EngineProtectorCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        EngineProtectorCardView.setVisibility(View.GONE);
                                        PremiumValue="0.0";
                                    }
                                }
                                else if (Value.equals("ENGINE PROTECTOR - PETROL")){
                                    PremiumValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                    if (!PremiumValue.equals("")){
                                        AdditionalEnginePetrol= Double.parseDouble(PremiumValue);
                                        if (!PremiumValue.equals("0.00")){
                                            EngineCardView.setVisibility(View.VISIBLE);
                                            EngineProtectorPetrolPremium.setText(PremiumValue);
                                        }else{
                                            EngineCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        EngineCardView.setVisibility(View.GONE);
                                        PremiumValue="0.0";
                                    }

                                }
                                else if (Value.equals("HYDROSTATIC LOCK COVER")){
                                    PremiumValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                    if (!PremiumValue.equals("")){
                                        AdditionalHydrosaticLock= Double.parseDouble(PremiumValue);
                                        if (!PremiumValue.equals("0.00")){
                                            HydrostaticeCardView.setVisibility(View.VISIBLE);
                                            HydrostaticeLockcoverPremium.setText(PremiumValue);
                                        }else{
                                            HydrostaticeCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        HydrostaticeCardView.setVisibility(View.GONE);
                                        PremiumValue="0.0";
                                    }

                                }
                                else if (Value.equals("KEY REPLACEMENT")){
                                    PremiumValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                    if (!PremiumValue.equals("")){
                                        AdditionalKeyReplacement= Double.parseDouble(PremiumValue);
                                        if (!PremiumValue.equals("0.00")){
                                            KeyReplacementCardView.setVisibility(View.VISIBLE);
                                            KeyReplacementPremium.setText(PremiumValue);
                                        }else{
                                            KeyReplacementCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        KeyReplacementCardView.setVisibility(View.GONE);
                                        PremiumValue="0.0";
                                    }

                                }
                                else if (Value.equals("Nil Depreciation Waiver cover")){
                                    PremiumValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                    if (!PremiumValue.equals("")){
                                        AdditionalNilDepreciation= Double.parseDouble(PremiumValue);
                                        if (!PremiumValue.equals("0.00")){
                                            NilCardView.setVisibility(View.VISIBLE);
                                            NilDepreciationWaivercoverNamePremium.setText(PremiumValue);
                                        }else{
                                            NilCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        NilCardView.setVisibility(View.GONE);
                                        PremiumValue="0.0";
                                    }

                                }
                                else if (Value.equals("RETURN TO INVOICE")){
                                    PremiumValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                    if (!PremiumValue.equals("")){
                                        AdditionalReturnInvoice= Double.parseDouble(PremiumValue);
                                        if (!PremiumValue.equals("0.00")){
                                            ReturnToInvoiceCardView.setVisibility(View.VISIBLE);
                                            ReturnToInvoicePremium.setText(PremiumValue);
                                        }else{
                                            ReturnToInvoiceCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        ReturnToInvoiceCardView.setVisibility(View.GONE);
                                        PremiumValue="0.0";
                                    }
                                }
                                else if (Value.equals("Road side Assistance")){
                                    PremiumValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                    if (!PremiumValue.equals("")){
                                        AdditionalRoadSide= Double.parseDouble(PremiumValue);
                                        if (!PremiumValue.equals("0.00")){
                                            RoadsideAssistanceCardView.setVisibility(View.VISIBLE);
                                            RoadsideAssistancePremium.setText(PremiumValue);
                                        }else{
                                            RoadsideAssistanceCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        RoadsideAssistanceCardView.setVisibility(View.GONE);
                                        PremiumValue="0.0";
                                    }

                                }
                                else if (Value.equals("SECURE TOWING")){
                                    PremiumValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                    if (!PremiumValue.equals("")){
                                        AdditionalsecureTowing= Double.parseDouble(PremiumValue);
                                        if (!PremiumValue.equals("0.00")){
                                            SecureTowingCardView.setVisibility(View.VISIBLE);
                                            SecureTowingPremium.setText(PremiumValue);
                                        }else{
                                            SecureTowingCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        SecureTowingCardView.setVisibility(View.GONE);
                                        PremiumValue="0.0";
                                    }

                                }
                                else if (Value.equals("Tyre and Rim secure")){
                                    PremiumValue=AddonCoversDataJsonObject.getJSONObject(j).optJSONObject("Premium").getString("Value");
                                    if (!PremiumValue.equals("")){
                                        AdditionalTyreRim= Double.parseDouble(PremiumValue);
                                        if (!PremiumValue.equals("0.00")){
                                            TyreCardView.setVisibility(View.VISIBLE);
                                            TyreAndRimSecurePremium.setText(PremiumValue);
                                        }else{
                                            TyreCardView.setVisibility(View.GONE);
                                        }
                                    }else{
                                        TyreCardView.setVisibility(View.GONE);
                                        PremiumValue="0.0";
                                    }
                                }
                                double DoubleValueAddition= AdditionalHospitalization+AdditionalCostOfConsumbales+AdditionalDailyCashMetro+AdditionalDailCash+AdditionalEngineDisesel+AdditionalEnginePetrol+AdditionalHydrosaticLock+AdditionalKeyReplacement+AdditionalNilDepreciation+AdditionalReturnInvoice+AdditionalRoadSide+AdditionalsecureTowing+AdditionalTyreRim;
                                addOnsAditional= String.valueOf(DoubleValueAddition);
                                Log.e("addOnsAditional", addOnsAditional);
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
                            addOns= String.valueOf(Double.parseDouble(addOnsCover)+Double.parseDouble(addOnsAditional));
                            Log.e("addOns", addOns);


                            for (int l=0; l <OtherDiscountGroupDataJsonObject.length();l++) {
                                JSONObject DescriptionJson = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("Description");
                                Log.e("DescriptionJson", DescriptionJson.toString());

                                String Value = DescriptionJson.getString("Value");
                                if (Value.equals("No claim bonus")) {
                                    NCB = OtherDiscountGroupDataJsonObject.getJSONObject(l).optJSONObject("DiscountAmount").getString("Value");
                                    Log.e("NCB",NCB);

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
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE_Quotation);
        req.execute();
    }
    private void saveGetQuote() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("QuotationNo",PosPolicyNo);
            object.put("PolicyType","RollOver");
            object.put("VehicleType","Old");
            object.put("VehicleAge",strVehicleAge);
            object.put("VehicleNumber",RegistrationNo);
            object.put("BrandName",str_vehicleManufacturerNm);
            object.put("BrandCode",strVehicleManufacturerCode);
            object.put("ModelName",VehicleModel );
            object.put("ModelCode",strVehicleModelCode);
            object.put("DateOfRegistration",str_edt_registration_date);
            object.put("StateName",strStateName);
            object.put("CityName",strRTOName);
            object.put("PolicyPlan",strPlanType);
            object.put("YearOfPlan",strPlanYear);
            object.put("IDV",strIdvValueTxt);
            object.put("Category",strCoverageTye);
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
        ProjectVolleyRequest req = new ProjectVolleyRequest(Renewal_Motor.this, object, UrlConstants.BUYSaveQuotationDetails, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    LinerCustomize.setVisibility(View.GONE);
                    customize_policy_btn_liner.setVisibility(View.VISIBLE);

                    final Dialog alert_dialog = new Dialog(Renewal_Motor.this);
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
                    QuotationIDTxt.setText(QuoteID);

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


}