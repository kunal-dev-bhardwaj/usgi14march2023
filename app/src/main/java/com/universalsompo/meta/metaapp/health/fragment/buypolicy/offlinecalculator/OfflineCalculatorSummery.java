package com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.ChiSummery;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OfflineCalculatorSummery extends AppCompatActivity {
    String CheckBoxPersonalCoverAStatus,strGenderEditSpinner,AmountStr="",PosPolicyNo="",str_policyType_spinner="",strSelfAgeEditText="",str_IndividualTypeEdit="",strTotalPremium="";
    TextView DiscountTotalTxt,addOnsTxtClick,addonsTxt,SelfName,selfEmailId,selfMobileNumber,SelfDOB,NomineeName,NomineeRelation,SumInsuredTxt,PolicyStartDateTxt,PolicyTenureTxt,NetPremiumTxt,GSTTxt,TotalPremiumTxt,TotalValue,PolicyPlanTxt;
    MySharedPreference pref;
    CustomProgressDialog customProgress;
    String today="",nextYear="",strSumInsured="",strPlanTypeTXT="",NetPremium="",strPolicyTenure="",PlanType="",strEdtNameSelf="",strEmailIDEditSelf="",strEditGenderSelf="",strEditOccupationSelf="",strPinCodeEdit="",strPermanentAddressEdit2="",strPermanentAddressEdit="",strStateEdit="",strCityEdit="",strRelationAdultOneEdit="",strEditInchesSelf="",strEditFtSelf="",strWeightEditSelf="",strBMIEdit="",strNomineeRelationEdit="",strNomineeName="",strContactNominee="",strNomineeDobEdit="",strBloodSugar="",strBloodPressure="",strBloodPressureDiastolic="",strcholesterol="",GlobalCoverCoverPremium="",MaternityChildcareCoverPremium="",ExtensionPreHospitalizationCoverPremium="",ExtensionProHospitalizationCoverPremium="",ModernTreatmentCoverPremium="",PremiumWaiverCoverPremium="",PreExistingDiseaseCoverPremium="",ConditionWaiverCoverPremium="",OutpatientDentalCoverPremium="",RestCureCoverPremium="",HomeCareCoverPremium="",WellnessBenefitCoverPremium="",SterilityInfertilityCoverPremium="",ObesityWeightCoverPremium="",SecondOpinionCoverPremium="",EmergencyTravellingCoverPremium="",DailyHospitalCoverPremium="",CriticalIllnessCoverPremium="",MedicallyAdvisedCoverPremium="",EnhancedCoverPremium="",strPersonalPremiumA="",strPersonalBPremiumTxt="",EmergencyAssistanceCoverPremium="",DiseaseManagementCoverPremium="",CoverageNonMedicalCoverPremium="";
    Date date;
    double addons,DiscountTotal;
    CheckBox checkBox;
    Format formatter;
    int selectYearAdult;
    CheckBox checkBoxLoyaltyDiscount,CheckBoxDailyCash,CheckBoxCriticalIllnes,CheckBoxPreHospitalization,CheckBoxProHospitalization,CheckBoxMaternityChildcare,CheckBoxCoverageNonMedical,CheckBoxConditionWaiver,CheckBoxPersonalCoverA,CheckBoxPersonalCoverB,CheckBoxPreExistingDisease,CheckBoxOutpatientDental,CheckBoxEmergencyTravelling,CheckBoxSecondOpinion,CheckBoxRestCure,CheckBoxObesityWeight,CheckBoxSterilityInfertility,CheckBoxEnhancedOrgan,CheckBoxMedicallyAdvised,CheckBoxHomeCare,CheckBoxWellnessBenefit,CheckBoxDiseaseManagement,CheckBoxModernTreatments,CheckBoxPremiumWaiver,CheckBoxGlobalCover,CheckBoxEmergencyAssistance;
    String strPolicyNumber="",CoPaymentLoading="",BasicStatus="",PersonalStatus="",CriticalStatus="",DailyHospitalSatus="",ModernTreatmentsStatus="",ExtensionPreHospitalization="",ExtensionPr0Hospitalization="",MaternityAndChildcare="",CoverageNonMedical="",ConditionWaiverStatus="",PersonalAccidentACoverStatus="", PersonalAccidentBCoverStatus="",PreExistingDiseaseStatus="",OutpatientDentalStatus="",SecondOpinionStatus="",RestCureStatus="",ObesityWeightStatus="", SterilityInfertilityStatus="",EnhancedOrganStatus="",GlobalCoverStatus="",MedicallyAdvisedStatus="",EmergencyAssistanceStatus="",HomeCareStatus="", WellnessBenefitStatus="",DiseaseManagementStatus="",LoyaltyDiscountStatus="",CoPaymentStatus="",EmergencyTravellingStatus="",PremiumWaiverStatus="",strGenderSpinner="",strCheckBoxSpouse="",strSpouseAgeEditText="",strCheckBoxMother="",strMotherAgeEditText="",strFatherAgeEditText="",strCheckBoxFather="",strCheckBoxMotherLaw="",strMotherLawAgeEditText="",strCheckBoxFatherLaw="",strFatherLawAgeEditText="",strFirstSonAgeEditText="",strSecondSonAgeEditText="",strThirdSonAgeEditText="",strFourSonAgeEditText="",strCheckBoxSon="",mCounter="",strFor="",dailyCheckBoxClick="";
    LinearLayout continueButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_calculator_summery);
        getWindow().setStatusBarColor(ContextCompat.getColor(OfflineCalculatorSummery.this, R.color.colorPrimaryDark));

        pref = MySharedPreference.getInstance(OfflineCalculatorSummery.this);
        customProgress = new CustomProgressDialog(OfflineCalculatorSummery.this);


        addons = getIntent().getDoubleExtra("addons",0.00);
        DiscountTotal = getIntent().getDoubleExtra("DiscountTotal",0.00);
        str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
        str_IndividualTypeEdit = getIntent().getStringExtra("str_IndividualTypeEdit");
        strSelfAgeEditText = getIntent().getStringExtra("strSelfAgeEditText");
        strTotalPremium = getIntent().getStringExtra("strTotalPremium");
        strEdtNameSelf = getIntent().getStringExtra("strEdtNameSelf");
        strEmailIDEditSelf = getIntent().getStringExtra("strEmailIDEditSelf");
        strEditGenderSelf = getIntent().getStringExtra("strEditGenderSelf");
        strEditOccupationSelf = getIntent().getStringExtra("strEditOccupationSelf");
        strPinCodeEdit = getIntent().getStringExtra("strPinCodeEdit");
        strPermanentAddressEdit2 = getIntent().getStringExtra("strPermanentAddressEdit2");
        strPermanentAddressEdit = getIntent().getStringExtra("strPermanentAddressEdit");
        strStateEdit = getIntent().getStringExtra("strStateEdit");
        strCityEdit = getIntent().getStringExtra("strCityEdit");
        strRelationAdultOneEdit = getIntent().getStringExtra("strRelationAdultOneEdit");
        strEditInchesSelf = getIntent().getStringExtra("strEditInchesSelf");
        strEditFtSelf = getIntent().getStringExtra("strEditFtSelf");
        strWeightEditSelf = getIntent().getStringExtra("strWeightEditSelf");
        strBMIEdit = getIntent().getStringExtra("strBMIEdit");
        strNomineeRelationEdit = getIntent().getStringExtra("strNomineeRelationEdit");
        strNomineeName = getIntent().getStringExtra("strNomineeName");
        strContactNominee = getIntent().getStringExtra("strContactNominee");
        strNomineeDobEdit = getIntent().getStringExtra("strNomineeDobEdit");
        strSumInsured = getIntent().getStringExtra("strSumInsured");
        strPlanTypeTXT = getIntent().getStringExtra("strPlanTypeTXT");
        NetPremium = getIntent().getStringExtra("NetPremium");
        strPolicyTenure = getIntent().getStringExtra("strPolicyTenure");
        PlanType = getIntent().getStringExtra("PlanType");
        BasicStatus = getIntent().getStringExtra("BasicStatus");
        PersonalStatus = getIntent().getStringExtra("PersonalStatus");
        CriticalStatus = getIntent().getStringExtra("CriticalStatus");
        DailyHospitalSatus = getIntent().getStringExtra("DailyHospitalSatus");
        ModernTreatmentsStatus = getIntent().getStringExtra("ModernTreatmentsStatus");
        ExtensionPreHospitalization = getIntent().getStringExtra("ExtensionPreHospitalization");
        ExtensionPr0Hospitalization = getIntent().getStringExtra("ExtensionPr0Hospitalization");
        MaternityAndChildcare = getIntent().getStringExtra("MaternityAndChildcare");
        CoverageNonMedical = getIntent().getStringExtra("CoverageNonMedical");
        ConditionWaiverStatus = getIntent().getStringExtra("ConditionWaiverStatus");
        PersonalAccidentACoverStatus = getIntent().getStringExtra("PersonalAccidentACoverStatus");
        PersonalAccidentBCoverStatus = getIntent().getStringExtra("PersonalAccidentBCoverStatus");
        PreExistingDiseaseStatus = getIntent().getStringExtra("PreExistingDiseaseStatus");
        OutpatientDentalStatus = getIntent().getStringExtra("OutpatientDentalStatus");
        SecondOpinionStatus = getIntent().getStringExtra("SecondOpinionStatus");
        RestCureStatus = getIntent().getStringExtra("RestCureStatus");
        ObesityWeightStatus = getIntent().getStringExtra("ObesityWeightStatus");
        SterilityInfertilityStatus = getIntent().getStringExtra("SterilityInfertilityStatus");
        EnhancedOrganStatus = getIntent().getStringExtra("EnhancedOrganStatus");
        GlobalCoverStatus = getIntent().getStringExtra("GlobalCoverStatus");
        MedicallyAdvisedStatus = getIntent().getStringExtra("MedicallyAdvisedStatus");
        EmergencyAssistanceStatus = getIntent().getStringExtra("EmergencyAssistanceStatus");
        HomeCareStatus = getIntent().getStringExtra("HomeCareStatus");
        WellnessBenefitStatus = getIntent().getStringExtra("WellnessBenefitStatus");
        DiseaseManagementStatus = getIntent().getStringExtra("DiseaseManagementStatus");
        LoyaltyDiscountStatus = getIntent().getStringExtra("LoyaltyDiscountStatus");
        CoPaymentStatus = getIntent().getStringExtra("CoPaymentStatus");
        strPolicyNumber = getIntent().getStringExtra("strPolicyNumber");
        CoPaymentLoading = getIntent().getStringExtra("CoPaymentLoading");
        EmergencyTravellingStatus = getIntent().getStringExtra("EmergencyTravellingStatus");
        PremiumWaiverStatus = getIntent().getStringExtra("PremiumWaiverStatus");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        strBloodSugar = getIntent().getStringExtra("strBloodSugar");
        strBloodPressure = getIntent().getStringExtra("strBloodPressure");
        strBloodPressureDiastolic = getIntent().getStringExtra("strBloodPressureDiastolic");
        strcholesterol = getIntent().getStringExtra("strcholesterol");
        strCheckBoxSon = getIntent().getStringExtra("strCheckBoxSon");
        mCounter = getIntent().getStringExtra("mCounter");
        strGenderSpinner = getIntent().getStringExtra("strGenderSpinner");
        strCheckBoxSpouse = getIntent().getStringExtra("strCheckBoxSpouse");
        strSpouseAgeEditText = getIntent().getStringExtra("strSpouseAgeEditText");
        strCheckBoxMother = getIntent().getStringExtra("strCheckBoxMother");
        strMotherAgeEditText = getIntent().getStringExtra("strMotherAgeEditText");
        strFatherAgeEditText = getIntent().getStringExtra("strFatherAgeEditText");
        strCheckBoxFather = getIntent().getStringExtra("strCheckBoxFather");
        strCheckBoxMotherLaw = getIntent().getStringExtra("strCheckBoxMotherLaw");
        strMotherLawAgeEditText = getIntent().getStringExtra("strMotherLawAgeEditText");
        strCheckBoxFatherLaw = getIntent().getStringExtra("strCheckBoxFatherLaw");
        strFatherLawAgeEditText = getIntent().getStringExtra("strFatherLawAgeEditText");
        strFirstSonAgeEditText = getIntent().getStringExtra("strFirstSonAgeEditText");
        strSecondSonAgeEditText = getIntent().getStringExtra("strSecondSonAgeEditText");
        strThirdSonAgeEditText = getIntent().getStringExtra("strThirdSonAgeEditText");
        strFourSonAgeEditText = getIntent().getStringExtra("strFourSonAgeEditText");
        AmountStr = getIntent().getStringExtra("AmountStr");
        strGenderEditSpinner = getIntent().getStringExtra("strGenderEditSpinner");
        strFor = getIntent().getStringExtra("strFor");
        dailyCheckBoxClick = getIntent().getStringExtra("dailyCheckBoxClick");
        GlobalCoverCoverPremium = getIntent().getStringExtra("GlobalCoverCoverPremium");
        MaternityChildcareCoverPremium = getIntent().getStringExtra("MaternityChildcareCoverPremium");
        ExtensionPreHospitalizationCoverPremium = getIntent().getStringExtra("ExtensionPreHospitalizationCoverPremium");
        ExtensionProHospitalizationCoverPremium = getIntent().getStringExtra("ExtensionProHospitalizationCoverPremium");
        ModernTreatmentCoverPremium = getIntent().getStringExtra("ModernTreatmentCoverPremium");
        PremiumWaiverCoverPremium = getIntent().getStringExtra("PremiumWaiverCoverPremium");
        PreExistingDiseaseCoverPremium = getIntent().getStringExtra("PreExistingDiseaseCoverPremium");
        ConditionWaiverCoverPremium = getIntent().getStringExtra("ConditionWaiverCoverPremium");
        OutpatientDentalCoverPremium = getIntent().getStringExtra("OutpatientDentalCoverPremium");
        RestCureCoverPremium = getIntent().getStringExtra("RestCureCoverPremium");
        HomeCareCoverPremium = getIntent().getStringExtra("HomeCareCoverPremium");
        WellnessBenefitCoverPremium = getIntent().getStringExtra("WellnessBenefitCoverPremium");
        SterilityInfertilityCoverPremium = getIntent().getStringExtra("SterilityInfertilityCoverPremium");
        ObesityWeightCoverPremium = getIntent().getStringExtra("ObesityWeightCoverPremium");
        SecondOpinionCoverPremium = getIntent().getStringExtra("SecondOpinionCoverPremium");
        EmergencyTravellingCoverPremium = getIntent().getStringExtra("EmergencyTravellingCoverPremium");
        DailyHospitalCoverPremium = getIntent().getStringExtra("DailyHospitalCoverPremium");
        CriticalIllnessCoverPremium = getIntent().getStringExtra("CriticalIllnessCoverPremium");
        MedicallyAdvisedCoverPremium = getIntent().getStringExtra("MedicallyAdvisedCoverPremium");
        EnhancedCoverPremium = getIntent().getStringExtra("EnhancedCoverPremium");
        strPersonalPremiumA = getIntent().getStringExtra("strPersonalPremiumA");
        strPersonalBPremiumTxt = getIntent().getStringExtra("strPersonalBPremiumTxt");
        EmergencyAssistanceCoverPremium = getIntent().getStringExtra("EmergencyAssistanceCoverPremium");
        DiseaseManagementCoverPremium = getIntent().getStringExtra("DiseaseManagementCoverPremium");
        CoverageNonMedicalCoverPremium = getIntent().getStringExtra("CoverageNonMedicalCoverPremium");
        MaternityChildcareCoverPremium = getIntent().getStringExtra("MaternityChildcareCoverPremium");
        CheckBoxPersonalCoverAStatus = getIntent().getStringExtra("CheckBoxPersonalCoverAStatus");
        selectYearAdult  = getIntent().getIntExtra("selectYearAdult", 0);

        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        calendar.add(Calendar.DATE, 364);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        nextYear = formatter.format(date);

        SelfName=findViewById(R.id.SelfName);
        selfEmailId=findViewById(R.id.selfEmailId);
        selfMobileNumber=findViewById(R.id.selfMobileNumber);
        SelfDOB=findViewById(R.id.SelfDOB);
        NomineeName=findViewById(R.id.NomineeName);
        NomineeRelation=findViewById(R.id.NomineeRelation);
        SumInsuredTxt=findViewById(R.id.SumInsuredTxt);
        PolicyStartDateTxt=findViewById(R.id.PolicyStartDateTxt);
        PolicyTenureTxt=findViewById(R.id.PolicyTenureTxt);
        NetPremiumTxt=findViewById(R.id.NetPremiumTxt);
        addonsTxt=findViewById(R.id.addonsTxt);
        GSTTxt=findViewById(R.id.GSTTxt);
        TotalPremiumTxt=findViewById(R.id.TotalPremiumTxt);
        TotalValue=findViewById(R.id.TotalValue);
        PolicyPlanTxt=findViewById(R.id.PolicyPlanTxt);
        continueButton=findViewById(R.id.continueButton);
        checkBox=findViewById(R.id.checkBox);
        addOnsTxtClick=findViewById(R.id.addOnsTxtClick);
        DiscountTotalTxt=findViewById(R.id.DiscountTotalTxt);


        SelfName.setText(strEdtNameSelf);
        SelfDOB.setText(strSelfAgeEditText);
        selfMobileNumber.setText(pref.getMOBILE());
        selfEmailId.setText(strEmailIDEditSelf);
        NomineeName.setText(strNomineeName);
        NomineeRelation.setText(strNomineeRelationEdit);
        SumInsuredTxt.setText(strSumInsured);
        PolicyPlanTxt.setText(PlanType);
        PolicyStartDateTxt.setText(today);
        NetPremiumTxt.setText(NetPremium);
        addonsTxt.setText(String.valueOf(addons));
        DiscountTotalTxt.setText(String.valueOf(DiscountTotal));

        PolicyTenureTxt.setText(strPolicyTenure+" Year");
        double GSTAmount= Double.parseDouble(AmountStr);
        double FinalAmount =(GSTAmount*.18)+GSTAmount;
        AmountStr=String.valueOf(Math.round(FinalAmount * 100.0) / 100.0);
        TotalPremiumTxt.setText(AmountStr);
        TotalValue.setText(AmountStr);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strBloodSugar="75";
                strBloodPressure="95";
                strBloodPressureDiastolic="65";
                strcholesterol="155";
                if (!checkBox.isChecked()){
                    Toast.makeText(OfflineCalculatorSummery.this, "Accept Terms & Condition", Toast.LENGTH_SHORT).show();
                }else{
//                    health_quote();
                }

            }
        });
        addOnsTxtClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addons==0.00){

                }else {
                    BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(OfflineCalculatorSummery.this,R.style.BottomSheetTheme);
                    View viewBottomSheet= LayoutInflater.from(OfflineCalculatorSummery.this).inflate(R.layout.chi_bottom_addons,null);
                    bottomSheetDialog.setContentView(viewBottomSheet);
                    bottomSheetDialog.setCanceledOnTouchOutside(false);

                    LinearLayout DailyCashLiner=viewBottomSheet.findViewById(R.id.DailyCashLiner);
                    LinearLayout CriticalIllnesLiner=viewBottomSheet.findViewById(R.id.CriticalIllnesLiner);
                    LinearLayout ExtensionPreHospLiner=viewBottomSheet.findViewById(R.id.ExtensionPreHospLiner);
                    LinearLayout ExtensionProHospLiner=viewBottomSheet.findViewById(R.id.ExtensionProHospLiner);
                    CheckBoxDailyCash=viewBottomSheet.findViewById(R.id.CheckBoxDailyCash);
                    CheckBoxCriticalIllnes=viewBottomSheet.findViewById(R.id.CheckBoxCriticalIllnes);
                    CheckBoxPreHospitalization=viewBottomSheet.findViewById(R.id.CheckBoxPreHospitalization);
                    CheckBoxProHospitalization=viewBottomSheet.findViewById(R.id.CheckBoxProHospitalization);
                    CheckBoxMaternityChildcare=viewBottomSheet.findViewById(R.id.CheckBoxMaternityChildcare);
                    CheckBoxCoverageNonMedical=viewBottomSheet.findViewById(R.id.CheckBoxCoverageNonMedical);
                    CheckBoxConditionWaiver=viewBottomSheet.findViewById(R.id.CheckBoxConditionWaiver);
                    CheckBoxPersonalCoverA=viewBottomSheet.findViewById(R.id.CheckBoxPersonalCoverA);
                    CheckBoxPersonalCoverB=viewBottomSheet.findViewById(R.id.CheckBoxPersonalCoverB);
                    CheckBoxPreExistingDisease=viewBottomSheet.findViewById(R.id.CheckBoxPreExistingDisease);
                    CheckBoxOutpatientDental=viewBottomSheet.findViewById(R.id.CheckBoxOutpatientDental);
                    CheckBoxEmergencyTravelling=viewBottomSheet.findViewById(R.id.CheckBoxEmergencyTravelling);
                    CheckBoxSecondOpinion=viewBottomSheet.findViewById(R.id.CheckBoxSecondOpinion);
                    CheckBoxRestCure=viewBottomSheet.findViewById(R.id.CheckBoxRestCure);
                    CheckBoxObesityWeight=viewBottomSheet.findViewById(R.id.CheckBoxObesityWeight);
                    CheckBoxSterilityInfertility=viewBottomSheet.findViewById(R.id.CheckBoxSterilityInfertility);
                    CheckBoxEnhancedOrgan=viewBottomSheet.findViewById(R.id.CheckBoxEnhancedOrgan);
                    CheckBoxMedicallyAdvised=viewBottomSheet.findViewById(R.id.CheckBoxMedicallyAdvised);
                    CheckBoxHomeCare=viewBottomSheet.findViewById(R.id.CheckBoxHomeCare);
                    CheckBoxWellnessBenefit=viewBottomSheet.findViewById(R.id.CheckBoxWellnessBenefit);
                    CheckBoxDiseaseManagement=viewBottomSheet.findViewById(R.id.CheckBoxDiseaseManagement);
                    CheckBoxModernTreatments=viewBottomSheet.findViewById(R.id.CheckBoxModernTreatments);
                    CheckBoxPremiumWaiver=viewBottomSheet.findViewById(R.id.CheckBoxPremiumWaiver);
                    CheckBoxGlobalCover=viewBottomSheet.findViewById(R.id.CheckBoxGlobalCover);
                    CheckBoxEmergencyAssistance=viewBottomSheet.findViewById(R.id.CheckBoxEmergencyAssistance);
                    TextView DailyCashPremiumTxt=viewBottomSheet.findViewById(R.id.DailyCashPremiumTxt);
                    TextView CriticalIllnessPremiumTxt=viewBottomSheet.findViewById(R.id.CriticalIllnessPremiumTxt);
                    TextView PreHospitalizationPremiumTxt=viewBottomSheet.findViewById(R.id.PreHospitalizationPremiumTxt);
                    TextView ProHospitalizationPremiumTxt=viewBottomSheet.findViewById(R.id.ProHospitalizationPremiumTxt);
                    TextView MaternityChildcarePremiumTxt=viewBottomSheet.findViewById(R.id.MaternityChildcarePremiumTxt);
                    TextView NoMedicalPremiumTxt=viewBottomSheet.findViewById(R.id.NoMedicalPremiumTxt);
                    TextView ConditionPremiumTxt=viewBottomSheet.findViewById(R.id.ConditionPremiumTxt);
                    TextView PersonalAPremiumTxt=viewBottomSheet.findViewById(R.id.PersonalAPremiumTxt);
                    TextView PersonalBPremiumTxt=viewBottomSheet.findViewById(R.id.PersonalBPremiumTxt);
                    TextView PreexistingDiseasePremiumTxt=viewBottomSheet.findViewById(R.id.PreexistingDiseasePremiumTxt);
                    TextView OutPatientPremiumTxt=viewBottomSheet.findViewById(R.id.OutPatientPremiumTxt);
                    TextView EmergencyTravellingPremiumTxt=viewBottomSheet.findViewById(R.id.EmergencyTravellingPremiumTxt);
                    TextView SecondOpinionPremiumTxt=viewBottomSheet.findViewById(R.id.SecondOpinionPremiumTxt);
                    TextView RestCurePremiumTxt=viewBottomSheet.findViewById(R.id.RestCurePremiumTxt);
                    TextView ObesityPremiumTxt=viewBottomSheet.findViewById(R.id.ObesityPremiumTxt);
                    TextView SterilityPremiumTxt=viewBottomSheet.findViewById(R.id.SterilityPremiumTxt);
                    TextView EnhancedOrganPremiumTxt=viewBottomSheet.findViewById(R.id.EnhancedOrganPremiumTxt);
                    TextView MedicallyPremiumTxt=viewBottomSheet.findViewById(R.id.MedicallyPremiumTxt);
                    TextView HomeCarePremiumTxt=viewBottomSheet.findViewById(R.id.HomeCarePremiumTxt);
                    TextView WellnessBenefitPremiumTxt=viewBottomSheet.findViewById(R.id.WellnessBenefitPremiumTxt);
                    TextView DiseaseManagementPremiumTxt=viewBottomSheet.findViewById(R.id.DiseaseManagementPremiumTxt);
                    TextView ModernTreatmentsPremiumTxt=viewBottomSheet.findViewById(R.id.ModernTreatmentsPremiumTxt);
                    TextView PremiumWaiverPremiumTxt=viewBottomSheet.findViewById(R.id.PremiumWaiverPremiumTxt);
                    TextView GlobalCoverPremiumTxt=viewBottomSheet.findViewById(R.id.GlobalCoverPremiumTxt);
                    TextView EmergencyAssistancePremiumTxt=viewBottomSheet.findViewById(R.id.EmergencyAssistancePremiumTxt);
                    ImageView bottomCancel=viewBottomSheet.findViewById(R.id.bottomCancel);
                    LinearLayout LinerMaternity=viewBottomSheet.findViewById(R.id.LinerMaternity);
                    LinearLayout SterilityLiner=viewBottomSheet.findViewById(R.id.SterilityLiner);
                    LinearLayout GlobalLiner=viewBottomSheet.findViewById(R.id.GlobalLiner);
                    LinearLayout PersonalCoverBLiner=viewBottomSheet.findViewById(R.id.PersonalCoverBLiner);
                    LinearLayout NonMedicalLiner=viewBottomSheet.findViewById(R.id.NonMedicalLiner);
                    LinearLayout ConditionWaiverLiner=viewBottomSheet.findViewById(R.id.ConditionWaiverLiner);
                    LinearLayout PreExistingLiner=viewBottomSheet.findViewById(R.id.PreExistingLiner);
                    LinearLayout OutpatientDentalLiner=viewBottomSheet.findViewById(R.id.OutpatientDentalLiner);
                    LinearLayout EmergencyAssistanceLiner=viewBottomSheet.findViewById(R.id.EmergencyAssistanceLiner);
                    LinearLayout SecondLiner=viewBottomSheet.findViewById(R.id.SecondLiner);
                    LinearLayout RestCureLiner=viewBottomSheet.findViewById(R.id.RestCureLiner);
                    LinearLayout ObesityLiner=viewBottomSheet.findViewById(R.id.ObesityLiner);
                    LinearLayout EnhancedLiner=viewBottomSheet.findViewById(R.id.EnhancedLiner);
                    LinearLayout EmergencyLiner=viewBottomSheet.findViewById(R.id.EmergencyLiner);
                    LinearLayout LinerHomeCare=viewBottomSheet.findViewById(R.id.LinerHomeCare);
                    LinearLayout LinerMedically=viewBottomSheet.findViewById(R.id.LinerMedically);
                    LinearLayout WellnessLiner=viewBottomSheet.findViewById(R.id.WellnessLiner);
                    LinearLayout DiseaseLiner=viewBottomSheet.findViewById(R.id.DiseaseLiner);
                    LinearLayout ModernLiner=viewBottomSheet.findViewById(R.id.ModernLiner);
                    LinearLayout PremiumLiner=viewBottomSheet.findViewById(R.id.PremiumLiner);

                    PreHospitalizationPremiumTxt.setText(ExtensionPreHospitalizationCoverPremium);
                    ProHospitalizationPremiumTxt.setText(ExtensionProHospitalizationCoverPremium);
                    ModernTreatmentsPremiumTxt.setText(ModernTreatmentCoverPremium);
                    PremiumWaiverPremiumTxt.setText(PremiumWaiverCoverPremium);
                    PreexistingDiseasePremiumTxt.setText(PreExistingDiseaseCoverPremium);
                    ConditionPremiumTxt.setText(ConditionWaiverCoverPremium);
                    OutPatientPremiumTxt.setText(OutpatientDentalCoverPremium);
                    RestCurePremiumTxt.setText(RestCureCoverPremium);
                    HomeCarePremiumTxt.setText(HomeCareCoverPremium);
                    WellnessBenefitPremiumTxt.setText(WellnessBenefitCoverPremium);
                    SterilityPremiumTxt.setText(SterilityInfertilityCoverPremium);
                    ObesityPremiumTxt.setText(ObesityWeightCoverPremium);
                    SecondOpinionPremiumTxt.setText(SecondOpinionCoverPremium);
                    EmergencyTravellingPremiumTxt.setText(EmergencyTravellingCoverPremium);
                    DailyCashPremiumTxt.setText(DailyHospitalCoverPremium);
                    CriticalIllnessPremiumTxt.setText(CriticalIllnessCoverPremium);
                    MedicallyPremiumTxt.setText(MedicallyAdvisedCoverPremium);
                    EnhancedOrganPremiumTxt.setText(EnhancedCoverPremium);
                    PersonalAPremiumTxt.setText(strPersonalPremiumA);
                    PersonalBPremiumTxt.setText(strPersonalBPremiumTxt);
                    GlobalCoverPremiumTxt.setText(GlobalCoverCoverPremium);
                    EmergencyAssistancePremiumTxt.setText(EmergencyAssistanceCoverPremium);
                    DiseaseManagementPremiumTxt.setText(DiseaseManagementCoverPremium);
                    NoMedicalPremiumTxt.setText(CoverageNonMedicalCoverPremium);
                    if (strGenderEditSpinner.equals("Female")){
                        if (selectYearAdult > 18 && (selectYearAdult < 45)) {
                            LinerMaternity.setVisibility(View.GONE);
                            MaternityChildcareCoverPremium="0.0";
                            MaternityChildcarePremiumTxt.setText(MaternityChildcareCoverPremium);
                        }
                        else{
                            MaternityChildcarePremiumTxt.setText(MaternityChildcareCoverPremium);
                        }
                    }else{
                        LinerMaternity.setVisibility(View.GONE);
                    }



                    if (GlobalCoverCoverPremium.equals("0.00")||GlobalCoverCoverPremium.equals("")){
                        GlobalLiner.setVisibility(View.GONE);
                        GlobalCoverCoverPremium="0.0";
                        GlobalCoverPremiumTxt.setText(GlobalCoverCoverPremium);
                    }else {
                        GlobalLiner.setVisibility(View.GONE);
                        GlobalCoverPremiumTxt.setText(GlobalCoverCoverPremium);
                    }

                    if (dailyCheckBoxClick.equals("True")){
                        CheckBoxDailyCash.setChecked(true);
                        DailyCashLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxDailyCash.setChecked(false);
                        DailyCashLiner.setVisibility(View.GONE);
                    }
                    if (CriticalStatus.equals("True")){
                        CheckBoxCriticalIllnes.setChecked(true);
                        CriticalIllnesLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxCriticalIllnes.setChecked(true);
                        CriticalIllnesLiner.setVisibility(View.GONE);
                    }
                    if (ExtensionPreHospitalization.equals("True")){
                        CheckBoxPreHospitalization.setChecked(true);
                        ExtensionPreHospLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxPreHospitalization.setChecked(true);
                        ExtensionPreHospLiner.setVisibility(View.GONE);
                    }
                    if (ExtensionPr0Hospitalization.equals("True")){
                        CheckBoxProHospitalization.setChecked(true);
                        ExtensionProHospLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxProHospitalization.setChecked(true);
                        ExtensionProHospLiner.setVisibility(View.GONE);
                    }

                    if (MaternityAndChildcare.equals("True")){
                        CheckBoxMaternityChildcare.setChecked(true);
                        LinerMaternity.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxMaternityChildcare.setChecked(true);
                        LinerMaternity.setVisibility(View.GONE);
                    }

                    if (CoverageNonMedical.equals("True")){
                        CheckBoxCoverageNonMedical.setChecked(true);
                        NonMedicalLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxCoverageNonMedical.setChecked(true);
                        NonMedicalLiner.setVisibility(View.GONE);
                    }
                    if (ConditionWaiverStatus.equals("True")){
                        CheckBoxConditionWaiver.setChecked(true);
                        ConditionWaiverLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxConditionWaiver.setChecked(true);
                        ConditionWaiverLiner.setVisibility(View.GONE);
                    }
                    if (PreExistingDiseaseStatus.equals("True")){
                        CheckBoxPreExistingDisease.setChecked(true);
                        PreExistingLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxPreExistingDisease.setChecked(true);
                        PreExistingLiner.setVisibility(View.GONE);
                    }
                    if (OutpatientDentalStatus.equals("True")){
                        CheckBoxOutpatientDental.setChecked(true);
                        OutpatientDentalLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxOutpatientDental.setChecked(true);
                        OutpatientDentalLiner.setVisibility(View.GONE);
                    }

                    if (EmergencyTravellingStatus.equals("True")){
                        CheckBoxEmergencyTravelling.setChecked(true);
                        EmergencyAssistanceLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxEmergencyTravelling.setChecked(true);
                        EmergencyAssistanceLiner.setVisibility(View.GONE);
                    }

                    if (SecondOpinionStatus.equals("True")){
                        CheckBoxSecondOpinion.setChecked(true);
                        SecondLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxSecondOpinion.setChecked(true);
                        SecondLiner.setVisibility(View.GONE);
                    }

                    if (RestCureStatus.equals("True")){
                        CheckBoxRestCure.setChecked(true);
                        RestCureLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxRestCure.setChecked(true);
                        RestCureLiner.setVisibility(View.GONE);
                    }

                    if (ObesityWeightStatus.equals("True")){
                        CheckBoxObesityWeight.setChecked(true);
                        ObesityLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxObesityWeight.setChecked(true);
                        ObesityLiner.setVisibility(View.GONE);
                    }

                    if (SterilityInfertilityStatus.equals("True")){
                        CheckBoxSterilityInfertility.setChecked(true);
                        SterilityLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxSterilityInfertility.setChecked(true);
                        SterilityLiner.setVisibility(View.GONE);
                    }

                    if (EnhancedOrganStatus.equals("True")){
                        CheckBoxEnhancedOrgan.setChecked(true);
                        EnhancedLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxEnhancedOrgan.setChecked(true);
                        EnhancedLiner.setVisibility(View.GONE);
                    }
                    if (MedicallyAdvisedStatus.equals("True")){
                        CheckBoxMedicallyAdvised.setChecked(true);
                        LinerMedically.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxMedicallyAdvised.setChecked(true);
                        LinerMedically.setVisibility(View.GONE);

                    }
                    if (EmergencyAssistanceStatus.equals("True")){
                        CheckBoxEmergencyAssistance.setChecked(true);
                        EmergencyLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxEmergencyAssistance.setChecked(true);
                        EmergencyLiner.setVisibility(View.GONE);
                    }

                    if (HomeCareStatus.equals("True")){
                        CheckBoxHomeCare.setChecked(true);
                        LinerHomeCare.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxHomeCare.setChecked(true);
                        LinerHomeCare.setVisibility(View.GONE);
                    }
                    if (WellnessBenefitStatus.equals("True")){
                        CheckBoxWellnessBenefit.setChecked(true);
                        WellnessLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxWellnessBenefit.setChecked(true);
                        WellnessLiner.setVisibility(View.GONE);
                    }

                    if (DiseaseManagementStatus.equals("True")){
                        CheckBoxDiseaseManagement.setChecked(true);
                        DiseaseLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxDiseaseManagement.setChecked(true);
                        DiseaseLiner.setVisibility(View.GONE);
                    }
                    if (GlobalCoverStatus.equals("True")){
                        CheckBoxGlobalCover.setChecked(true);
                        GlobalLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxGlobalCover.setChecked(true);
                        GlobalLiner.setVisibility(View.GONE);
                    }
                    if (ModernTreatmentsStatus.equals("True")){
                        CheckBoxModernTreatments.setChecked(true);
                        ModernLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxModernTreatments.setChecked(true);
                        ModernLiner.setVisibility(View.GONE);
                    }

                    if (PremiumWaiverStatus.equals("True")){
                        CheckBoxPremiumWaiver.setChecked(true);
                        PremiumLiner.setVisibility(View.VISIBLE);
                    }else{
                        CheckBoxPremiumWaiver.setChecked(true);
                        PremiumLiner.setVisibility(View.GONE);
                    }
                    if (CheckBoxPersonalCoverAStatus.equals("True")){
                        CheckBoxPersonalCoverA.setChecked(true);
                    }else{
                        CheckBoxPersonalCoverA.setChecked(true);
                    }
                    if (CheckBoxPersonalCoverAStatus.equals("True")){
                        CheckBoxPersonalCoverB.setChecked(true);
                    }else{
                        CheckBoxPersonalCoverB.setChecked(true);
                    }
                    CheckBoxDailyCash.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxDailyCash.isChecked()){
                                CheckBoxDailyCash.setChecked(true);
                            }else {
                                CheckBoxDailyCash.setChecked(true);
                            }
                        }
                    });
                    CheckBoxCriticalIllnes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxCriticalIllnes.isChecked()){
                                CheckBoxCriticalIllnes.setChecked(true);
                            }else {
                                CheckBoxCriticalIllnes.setChecked(true);
                            }
                        }
                    });
                    CheckBoxPreHospitalization.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxPreHospitalization.isChecked()){
                                CheckBoxPreHospitalization.setChecked(true);
                            }else {
                                CheckBoxPreHospitalization.setChecked(true);
                            }
                        }
                    });
                    CheckBoxProHospitalization.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxProHospitalization.isChecked()){
                                CheckBoxProHospitalization.setChecked(true);
                            }else {
                                CheckBoxProHospitalization.setChecked(true);
                            }


                        }
                    });
                    CheckBoxPersonalCoverA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxPersonalCoverA.isChecked()){
                                CheckBoxPersonalCoverA.setChecked(true);
                            }else {
                                CheckBoxPersonalCoverA.setChecked(true);
                            }


                        }
                    });
                    CheckBoxPersonalCoverB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxPersonalCoverB.isChecked()){
                                CheckBoxPersonalCoverB.setChecked(true);
                            }else {
                                CheckBoxPersonalCoverB.setChecked(true);
                            } }
                    });
                    CheckBoxMaternityChildcare.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxMaternityChildcare.isChecked()){
                                CheckBoxMaternityChildcare.setChecked(true);
                            }else {
                                CheckBoxMaternityChildcare.setChecked(true);
                            }
                        }
                    });
                    CheckBoxCoverageNonMedical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxCoverageNonMedical.isChecked()){
                                CheckBoxCoverageNonMedical.setChecked(true);
                            }else {
                                CheckBoxCoverageNonMedical.setChecked(true);
                            }
                        }
                    });
                    CheckBoxConditionWaiver.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxConditionWaiver.isChecked()){
                                CheckBoxConditionWaiver.setChecked(true);
                            }else {
                                CheckBoxConditionWaiver.setChecked(true);
                            }
                        }
                    });
                    CheckBoxPreExistingDisease.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxPreExistingDisease.isChecked()){
                                CheckBoxPreExistingDisease.setChecked(true);
                            }else {
                                CheckBoxPreExistingDisease.setChecked(true);

                            } }
                    });
                    CheckBoxOutpatientDental.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxOutpatientDental.isChecked()){
                                CheckBoxOutpatientDental.setChecked(true);
                            }else {
                                CheckBoxOutpatientDental.setChecked(true);
                            }
                        }
                    });
                    CheckBoxEmergencyTravelling.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxEmergencyTravelling.isChecked()){
                                CheckBoxEmergencyTravelling.setChecked(true);
                            }else {
                                CheckBoxEmergencyTravelling.setChecked(true);
                            } }
                    });
                    CheckBoxSecondOpinion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxSecondOpinion.isChecked()){
                                CheckBoxSecondOpinion.setChecked(true);
                            }else {
                                CheckBoxSecondOpinion.setChecked(true);
                            }
                        }
                    });
                    CheckBoxRestCure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxRestCure.isChecked()){
                                CheckBoxRestCure.setChecked(true);
                            }else {
                                CheckBoxRestCure.setChecked(true);

                            }
                        }
                    });
                    CheckBoxObesityWeight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxObesityWeight.isChecked()){
                                CheckBoxObesityWeight.setChecked(true);
                            }else {
                                CheckBoxObesityWeight.setChecked(true);
                            }
                        }
                    });
                    CheckBoxSterilityInfertility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxSterilityInfertility.isChecked()){
                                CheckBoxSterilityInfertility.setChecked(true);
                            }else {
                                CheckBoxSterilityInfertility.setChecked(true);

                            } }
                    });
                    CheckBoxEnhancedOrgan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxEnhancedOrgan.isChecked()){
                                CheckBoxEnhancedOrgan.setChecked(true);

                            }else {
                                CheckBoxEnhancedOrgan.setChecked(true);

                            }
                        }
                    });
                    CheckBoxMedicallyAdvised.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxMedicallyAdvised.isChecked()){
                                CheckBoxMedicallyAdvised.setChecked(true);
                            }else {
                                CheckBoxMedicallyAdvised.setChecked(true);
                            } }
                    });
                    CheckBoxEmergencyAssistance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxEmergencyAssistance.isChecked()){
                                CheckBoxEmergencyAssistance.setChecked(true);
                            }else {
                                CheckBoxEmergencyAssistance.setChecked(true);
                            }
                        }
                    });
                    CheckBoxHomeCare.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxHomeCare.isChecked()){
                                CheckBoxHomeCare.setChecked(true);
                            }else {
                                CheckBoxHomeCare.setChecked(true);
                            }
                        }
                    });
                    CheckBoxWellnessBenefit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxWellnessBenefit.isChecked()){
                                CheckBoxWellnessBenefit.setChecked(true);
                            }else {
                                CheckBoxWellnessBenefit.setChecked(true);
                            }
                        }
                    });
                    CheckBoxDiseaseManagement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxDiseaseManagement.isChecked()){
                                CheckBoxDiseaseManagement.setChecked(true);
                            }else {
                                CheckBoxDiseaseManagement.setChecked(true);
                            }
                        }
                    });
                    CheckBoxGlobalCover.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxGlobalCover.isChecked()){
                                CheckBoxGlobalCover.setChecked(true);
                            }else {
                                CheckBoxGlobalCover.setChecked(true);
                            }


                        }
                    });
                    CheckBoxModernTreatments.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxModernTreatments.isChecked()){
                                CheckBoxModernTreatments.setChecked(true);
                            }else {
                                CheckBoxModernTreatments.setChecked(true);
                            }
                        }
                    });
                    CheckBoxPremiumWaiver.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (CheckBoxPremiumWaiver.isChecked()){
                                CheckBoxPremiumWaiver.setChecked(true);
                            }else {
                                CheckBoxPremiumWaiver.setChecked(true);
                            }
                        }
                    });
                    bottomCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            bottomSheetDialog.dismiss();
                        }
                    });

                    bottomSheetDialog.show();
                }
            }
        });



    }
}