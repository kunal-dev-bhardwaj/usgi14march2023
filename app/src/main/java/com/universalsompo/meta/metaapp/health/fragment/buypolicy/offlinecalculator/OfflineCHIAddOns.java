package com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator;

import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHICalculation.AdultFourChild;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHICalculation.AdultOneChild;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHICalculation.AdultThreeChild;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHICalculation.AdultTwoChild;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHICalculation.ParentsFather;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHICalculation.ParentsFatherInLaw;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHICalculation.ParentsMother;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHICalculation.ParentsMotherInLaw;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHICalculation.TwoAdult;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHICalculation.TwoAdultFourChild;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHICalculation.TwoAdultOneChild;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHICalculation.TwoAdultThreeChild;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHICalculation.TwoAdultTwoChild;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation.AddOnCalculation.CriticalIllnessCoverPremium;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation.AddOnCalculation.DailyHospitalCoverPremium;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation.AddOnCalculation.EmergencyTravellingCoverPremium;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation.AddOnCalculation.EnhancedCoverPremium;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation.AddOnCalculation.HomeCareCoverPremium;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation.AddOnCalculation.MedicallyAdvisedCoverPremium;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation.AddOnCalculation.NoMedicalPremiumTxt;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation.AddOnCalculation.ObesityWeightCoverPremium;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation.AddOnCalculation.OutPatientPremium;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation.AddOnCalculation.RestCureCoverPremium;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation.AddOnCalculation.SecondOpinionCoverPremium;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation.AddOnCalculation.SterilityInfertilityCoverPremium;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation.AddOnCalculation.WellnessBenefitCoverPremium;

import static java.lang.String.valueOf;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.modelcalculator.PriceRateModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.io.InputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class OfflineCHIAddOns extends AppCompatActivity {
       LinearLayout CoPaymentLiner,LinerSubLimit,SumInsuredDropDown,DailyHospitalLiner,CriticalIllnessLiner,ExtensionPreLiner,ExtensionPostLiner,MaternityLiner,CoverageLiner,ConditionWaiverLiner,PreExistingDiseaseLiner,OutpatientDentalLiner,EmergencyTravellingLiner,SecondOpinionLiner,RestCureLiner,ObesityWeightLiner,SterilityInfertilityLiner,EnhancedOrganLiner,MedicallyAdvisedLiner,EmergencyAssistanceLine,HomeCareLiner,WellnessBenefitLiner,DiseaseManagementLiner,GlobalCoverLiner,ModernTreatmentsLiner,PremiumWaiverLiner,LinerPackage;
       TextView SelfNameText,PlanTypeTXT,PlanTypeTXT2,SumInsuredSelectPlan,SumInsuredDiGiProTxt,TotalPremium,TotalPremiumSelectPlan,TotalPremiumSecond,ConditionWaiverPackageOne,ConditionWaiverPackageTwo,ConditionWaiverPackageThree,ConditionWaiverPackageFour,ExtensionPreHospitalizationPackageOne,ExtensionProHospitalizationPackageOne,EmergencyAssistancePackageOe,PersonalAccidentPackageOne,WellnessBenefitPackageOne,TotalPremiumPackageOne,PremiumWaiverPackageTwo,SecondOpinionPackageTwo,ModernTreatments,PersonalAccidentPackageTwo,EmergencyAssistancePackageTwo,NonMedicalPackageThree,MedicallyAdvisedPackageThree,EnhancedOrganPackageThree,PersonalAccidentPackageThree,HomeCarePackageThree,PersonalAccidentPackageFour,CriticalIllnessPackageFour,ModernTreatmentPackageFour,HospitalDailyCashPackageFour,TreatmentTiredNetworkPackageFive,WellnessBenefitPackageFive;
       String ParentsFatherLawAmount="",ParentsMotherLawAmount="",ParentsFatherAmount="",ParentsMotherAmount="",ParentsAmount="",strCheckBoxSelf,strGenderEditSpinner,dailyCheckBoxClick="",AmountStr="",amount="",CardAmount="",strFor="",strGenderSpinner="",strGender="",today="",nextYear="",str_policyType_spinner="",strPolicyNumber="",str_IndividualTypeEdit="",strPolicyTenure="",CoPaymentLoading="",strSelfAgeEditText="",strSumInsured="",PlanType="",strPlanTypeTXT="",strPlanTypeTXT2="",NetPremium="",strTotalPremium="",PosPolicyNo="",BasicStatus="",PersonalStatus="",CriticalStatus="",DailyHospitalSatus="",ModernTreatmentsStatus="",ExtensionPreHospitalization="",ExtensionPr0Hospitalization="",CheckBoxPersonalCoverAStatus="",CheckBoxPersonalCoverBStatus="",MaternityAndChildcare="", CoverageNonMedical="",ConditionWaiverStatus="",PersonalAccidentACoverStatus="",PersonalAccidentBCoverStatus="",PreExistingDiseaseStatus="",OutpatientDentalStatus="",EmergencyTravellingStatus="",
               SecondOpinionStatus="",RestCureStatus="",ObesityWeightStatus="",SterilityInfertilityStatus="",EnhancedOrganStatus="",PremiumWaiverStatus="",GlobalCoverStatus="",MedicallyAdvisedStatus="", EmergencyAssistanceStatus="",HomeCareStatus="",WellnessBenefitStatus="",DiseaseManagementStatus="",BasicInsuranceCoverPremium="",PersonalAccidentCoverPremium="",CriticalIllnessCoverPremium="",DailyHospitalCoverPremium="",ModernTreatmentCoverPremium="",ExtensionPreHospitalizationCoverPremium="",ExtensionProHospitalizationCoverPremium="",MaternityChildcareCoverPremium="",CoverageNonMedicalCoverPremium="",ConditionWaiverCoverPremium="",PreExistingDiseaseCoverPremium="",OutpatientDentalCoverPremium="",EmergencyTravellingCoverPremium="",SecondOpinionCoverPremium="",RestCureCoverPremium="",ObesityWeightCoverPremium="",SterilityInfertilityCoverPremium="",EnhancedCoverPremium="",PremiumWaiverCoverPremium="",
               strPersonalPremiumA="",strPersonalBPremiumTxt="",GlobalCoverCoverPremium="",MedicallyAdvisedCoverPremium="",EmergencyAssistanceCoverPremium="",HomeCareCoverPremium="",WellnessBenefitCoverPremium="",DiseaseManagementCoverPremium="",LoyaltyDiscountStatus="",CoPaymentStatus="";
       EditText SumInsuredEditText,PolicyNumber;
       LinearLayout relativeSecond;
       LinearLayout continueButton;
       CheckBox checkBoxLoyaltyDiscount,CheckBoxDailyCash,CheckBoxCriticalIllnes,CheckBoxPreHospitalization,CheckBoxProHospitalization,CheckBoxMaternityChildcare,CheckBoxCoverageNonMedical,CheckBoxConditionWaiver,CheckBoxPersonalCoverA,CheckBoxPersonalCoverB,CheckBoxPreExistingDisease,CheckBoxOutpatientDental,CheckBoxEmergencyTravelling,CheckBoxSecondOpinion,CheckBoxRestCure,CheckBoxObesityWeight,CheckBoxSterilityInfertility,CheckBoxEnhancedOrgan,CheckBoxMedicallyAdvised,CheckBoxHomeCare,CheckBoxWellnessBenefit,CheckBoxDiseaseManagement,CheckBoxModernTreatments,CheckBoxPremiumWaiver,CheckBoxGlobalCover,CheckBoxEmergencyAssistance,CoPaymentCheckBox,PackageOne,PackageTwo,PackageThree,PackageFour,PackageFive;
       Button SelectAddOnsButton;
      Date date;
      Format formatter;
      String TotalAmountStr="";
      RadioButton None,TieredDiscount,SubLimitDiscount,DirectPolicyDiscount,LoyaltyDiscount,SubLimitADiscount,SubLimitBDiscount,SubLimitCDiscount,OneYear,TwoYearRadio,ThreeYearRadio,oneYearSecondRadio,TwoYearSecondRadio,ThreeYearSecondRadio,TenCheckBox,TwentyCheckBox,ThirtyCheckBox,fortyCheckBox,FiftyCheckBox;
      ImageView DailyHospitalAddImg,CriticalIllnessImg,ExtensionPreImg,ExtensionPostImg,MaternityImg,CoverageImg,ConditionWaiverImg,PreExistingDiseaseImg,OutpatientDentalImg,EmergencyTravellingImg,SecondOpinionImg,RestCureImg,ObesityWeightImg,SterilityInfertilityImg,EnhancedOrganImg,MedicallyAdvisedImg,EmergencyAssistanceImg,HomeCareImg,WellnessBenefitImg,DiseaseManagementImg,GlobalCoverImg,ModernTreatmentsImg,PremiumWaiverImg;
      HorizontalScrollView horizontalScroll;
      int CountScroll = 0;
      int FamilyTypeCounter,selectYearSecondAdult,selectYearAdult,selectYearMotherAdult,selectYearFatherAdult,selectMotherLawAdult,selectFatherLawAdult,mCounter;
      String strPackageOne,sumPremiumPackageOne="",sumPremiumPackageTwo="",sumPremiumPackageThree="",sumPremiumPackageFour="",strCheckBoxSpouse="",strSpouseAgeEditText="",strCheckBoxMother="",strMotherAgeEditText="",strFatherAgeEditText="",strCheckBoxFather="",strCheckBoxMotherLaw="",strMotherLawAgeEditText="",strCheckBoxFatherLaw="",strFatherLawAgeEditText="",strFirstSonAgeEditText="",strSecondSonAgeEditText="",strThirdSonAgeEditText="",strFourSonAgeEditText="",strCheckBoxSon="";
      MySharedPreference mySharedPreference;
    AssetManager assetManager;
    Button Calculate;
    TextView txtamount,LoyaltyTxt,SumPremiumPackageTwo,SumPremiumPackageThree,SumPremiumPackageFour,SumPremiumPackageFive;
    String strage,strinsurance;
    EditText age,insurance;
    double  SubLimitDiscountAmt1,DirectDiscountAmt1,TieredDiscountAmt1,DiscountTotal,newAmountStr,PremiumBeforeDiscounts,CoPaymentDiscount,TieredDiscountAmt,DirectDiscountAmt,LoyaltyDiscountAmt,LoyaltyDiscountAmt1,SubLimitDiscountAmt;
    ArrayList<PriceRateModel> priceRateModels = new ArrayList<>();
       double addons,twoYearAmount,coPaymentValueAdd,TotalCoPayment,doubleDailyHospitalCoverPremium=0.0,doubleCriticalIllnessCoverPremium=0.0,doubleExtensionPreHospitalizationCoverPremium=0.0,doubleExtensionProHospitalizationCoverPremium=0.0,doublePersonalPremiumA=0.0,doublePersonalPremiumB=0.0,doubleMaternityChildcareCoverPremium=0.0,doubleCoverageNonMedicalCoverPremium=0.0,doubleConditionWaiverCoverPremium=0.0,doublePreExistingDiseaseCoverPremium=0.0,doubleObesityWeightCoverPremium=0.0,doubleEmergencyAssistanceCoverPremium=0.0,doubleSecondOpinionCoverPremium=0.0,doubleRestCureCoverPremium=0.0,doubleOutpatientDentalCoverPremium=0.0,doubleSterilityInfertilityCoverPremium=0.0,doubleEnhancedCoverPremium=0.0,doubleMedicallyAdvisedCoverPremium=0.0,doubleEmergencyTravellingCoverPremium=0.0,doubleHomeCareCoverPremium=0.0,doubleWellnessBenefitCoverPremium=0.0,doubleDiseaseManagementCoverPremium=0.0,doubleGlobalCoverCoverPremium=0.0,doubleModernTreatmentCoverPremium=0.0,doublePremiumWaiverCoverPremium=0.0;
    String OutpatientDentalCoverPremium1,RestCureCoverPremium1,HomeCareCoverPremium1,WellnessBenefitCoverPremium1,SterilityInfertilityCoverPremium1,ObesityWeightCoverPremium1,SecondOpinionCoverPremium1,EmergencyTravellingCoverPremium1,DailyHospitalCoverPremium1,CriticalIllnessCoverPremium1,MedicallyAdvisedCoverPremium1,EnhancedCoverPremium1,CoverageNonMedicalCoverPremium1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_chiadd_ons);
        getWindow().setStatusBarColor(ContextCompat.getColor(OfflineCHIAddOns.this, R.color.colorPrimaryDark));
          mySharedPreference= MySharedPreference.getInstance(OfflineCHIAddOns.this);

          str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
          str_IndividualTypeEdit = getIntent().getStringExtra("str_IndividualTypeEdit");
          strSelfAgeEditText = getIntent().getStringExtra("strSelfAgeEditText");
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
          strCheckBoxSon = getIntent().getStringExtra("strCheckBoxSon");
          strCheckBoxSelf = getIntent().getStringExtra("strCheckBoxSelf");
          strFor = getIntent().getStringExtra("strFor");
          strGenderEditSpinner = getIntent().getStringExtra("strGenderEditSpinner");
          selectYearAdult  = getIntent().getIntExtra("selectYearAdult", 0);
         FamilyTypeCounter  = getIntent().getIntExtra("FamilyTypeCounter", 0);
         selectYearSecondAdult  = getIntent().getIntExtra("selectYearSecondAdult", 0);
          selectYearMotherAdult  = getIntent().getIntExtra("selectYearMotherAdult", 0);
          selectYearFatherAdult  = getIntent().getIntExtra("selectYearFatherAdult", 0);
          selectMotherLawAdult  = getIntent().getIntExtra("selectMotherLawAdult", 0);
          selectFatherLawAdult  = getIntent().getIntExtra("selectFatherLawAdult", 0);
          mCounter  = getIntent().getIntExtra("mCounter", 0);

          Log.e("selectYearAdult", valueOf(selectYearAdult));
          Log.e("selectYearSecondAdult", valueOf(selectYearSecondAdult));

          CoPaymentLiner=findViewById(R.id.CoPaymentLiner);
          LinerSubLimit=findViewById(R.id.LinerSubLimit);
        SumInsuredDropDown=findViewById(R.id.SumInsuredDropDown);
        SumInsuredEditText=findViewById(R.id.SumInsuredEditText);
        PlanTypeTXT=findViewById(R.id.PlanTypeTXT);
          LoyaltyTxt=findViewById(R.id.LoyaltyTxt);
          SumPremiumPackageTwo=findViewById(R.id.SumPremiumPackageTwo);
          SumPremiumPackageThree=findViewById(R.id.SumPremiumPackageThree);
          SumPremiumPackageFour=findViewById(R.id.SumPremiumPackageFour);
          SumPremiumPackageFive=findViewById(R.id.SumPremiumPackageFive);
          SelfNameText=findViewById(R.id.SelfNameText);
        SumInsuredSelectPlan=findViewById(R.id.SumInsuredSelectPlan);
        relativeSecond=findViewById(R.id.relativeSecond);
        PlanTypeTXT2=findViewById(R.id.PlanTypeTXT2);
        SumInsuredDiGiProTxt=findViewById(R.id.SumInsuredDiGiProTxt);
        continueButton=findViewById(R.id.continueButton);
        SelectAddOnsButton=findViewById(R.id.SelectAddOnsButton);
        TotalPremium=findViewById(R.id.TotalPremium);
        TotalPremiumSelectPlan=findViewById(R.id.TotalPremiumSelectPlan);
        checkBoxLoyaltyDiscount=findViewById(R.id.checkBoxLoyaltyDiscount);
        PolicyNumber=findViewById(R.id.PolicyNumber);
          TieredDiscount=findViewById(R.id.TieredDiscount);
          SubLimitDiscount=findViewById(R.id.SubLimitDiscount);
          DirectPolicyDiscount=findViewById(R.id.DirectPolicyDiscount);
          LoyaltyDiscount=findViewById(R.id.LoyaltyDiscount);
          SubLimitADiscount=findViewById(R.id.SubLimitADiscount);
          SubLimitBDiscount=findViewById(R.id.SubLimitBDiscount);
          SubLimitCDiscount=findViewById(R.id.SubLimitCDiscount);
          PackageOne=findViewById(R.id.PackageOne);
          PackageTwo=findViewById(R.id.PackageTwo);
          PackageThree=findViewById(R.id.PackageThree);
          PackageFour=findViewById(R.id.PackageFour);
          PackageFive=findViewById(R.id.PackageFive);
         OneYear=findViewById(R.id.OneYear);
        TwoYearRadio=findViewById(R.id.TwoYearRadio);
        ThreeYearRadio=findViewById(R.id.ThreeYearRadio);
        oneYearSecondRadio=findViewById(R.id.oneYearSecondRadio);
        TwoYearSecondRadio=findViewById(R.id.TwoYearSecondRadio);
        ThreeYearSecondRadio=findViewById(R.id.ThreeYearSecondRadio);
        TotalPremiumSecond=findViewById(R.id.TotalPremiumSecond);
        CoPaymentCheckBox=findViewById(R.id.CoPaymentCheckBox);
        TenCheckBox=findViewById(R.id.TenCheckBox);
        TwentyCheckBox=findViewById(R.id.TwentyCheckBox);
        ThirtyCheckBox=findViewById(R.id.ThirtyCheckBox);
        fortyCheckBox=findViewById(R.id.fortyCheckBox);
        FiftyCheckBox=findViewById(R.id.FiftyCheckBox);
        DailyHospitalAddImg=findViewById(R.id.DailyHospitalAddImg);
        horizontalScroll=findViewById(R.id.horizontalScroll);
        DailyHospitalLiner=findViewById(R.id.DailyHospitalLiner);
        CriticalIllnessLiner=findViewById(R.id.CriticalIllnessLiner);
        CriticalIllnessImg=findViewById(R.id.CriticalIllnessImg);
          ExtensionPreLiner=findViewById(R.id.ExtensionPreLiner);
          ExtensionPreImg=findViewById(R.id.ExtensionPreImg);
          ExtensionPostImg=findViewById(R.id.ExtensionPostImg);
          ExtensionPostLiner=findViewById(R.id.ExtensionPostLiner);
          MaternityLiner=findViewById(R.id.MaternityLiner);
          MaternityImg=findViewById(R.id.MaternityImg);
          CoverageLiner=findViewById(R.id.CoverageLiner);
          CoverageImg=findViewById(R.id.CoverageImg);
          ConditionWaiverImg=findViewById(R.id.ConditionWaiverImg);
          ConditionWaiverLiner=findViewById(R.id.ConditionWaiverLiner);
          PreExistingDiseaseLiner=findViewById(R.id.PreExistingDiseaseLiner);
          PreExistingDiseaseImg=findViewById(R.id.PreExistingDiseaseImg);
          OutpatientDentalLiner=findViewById(R.id.OutpatientDentalLiner);
          OutpatientDentalImg=findViewById(R.id.OutpatientDentalImg);
          EmergencyTravellingLiner=findViewById(R.id.EmergencyTravellingLiner);
          EmergencyTravellingImg=findViewById(R.id.EmergencyTravellingImg);
          SecondOpinionLiner=findViewById(R.id.SecondOpinionLiner);
          SecondOpinionImg=findViewById(R.id.SecondOpinionImg);
          RestCureLiner=findViewById(R.id.RestCureLiner);
          RestCureImg=findViewById(R.id.RestCureImg);
          ObesityWeightLiner=findViewById(R.id.ObesityWeightLiner);
          ObesityWeightImg=findViewById(R.id.ObesityWeightImg);
          SterilityInfertilityLiner=findViewById(R.id.SterilityInfertilityLiner);
          SterilityInfertilityImg=findViewById(R.id.SterilityInfertilityImg);
          EnhancedOrganLiner=findViewById(R.id.EnhancedOrganLiner);
          EnhancedOrganImg=findViewById(R.id.EnhancedOrganImg);
          MedicallyAdvisedLiner=findViewById(R.id.MedicallyAdvisedLiner);
          MedicallyAdvisedImg=findViewById(R.id.MedicallyAdvisedImg);
          EmergencyAssistanceLine=findViewById(R.id.EmergencyAssistanceLine);
          EmergencyAssistanceImg=findViewById(R.id.EmergencyAssistanceImg);
          HomeCareLiner=findViewById(R.id.HomeCareLiner);
          HomeCareImg=findViewById(R.id.HomeCareImg);
          WellnessBenefitLiner=findViewById(R.id.WellnessBenefitLiner);
          WellnessBenefitImg=findViewById(R.id.WellnessBenefitImg);
          DiseaseManagementLiner=findViewById(R.id.DiseaseManagementLiner);
          DiseaseManagementImg=findViewById(R.id.DiseaseManagementImg);
          GlobalCoverLiner=findViewById(R.id.GlobalCoverLiner);
          GlobalCoverImg=findViewById(R.id.GlobalCoverImg);
          ModernTreatmentsLiner=findViewById(R.id.ModernTreatmentsLiner);
          ModernTreatmentsImg=findViewById(R.id.ModernTreatmentsImg);
          PremiumWaiverLiner=findViewById(R.id.PremiumWaiverLiner);
          PremiumWaiverImg=findViewById(R.id.PremiumWaiverImg);
          ConditionWaiverPackageOne=findViewById(R.id.ConditionWaiverPackageOne);
          ConditionWaiverPackageTwo=findViewById(R.id.ConditionWaiverPackageTwo);
          ConditionWaiverPackageThree=findViewById(R.id.ConditionWaiverPackageThree);
          ConditionWaiverPackageFour=findViewById(R.id.ConditionWaiverPackageFour);
          ExtensionPreHospitalizationPackageOne=findViewById(R.id.ExtensionPreHospitalizationPackageOne);
          ExtensionProHospitalizationPackageOne=findViewById(R.id.ExtensionProHospitalizationPackageOne);
          EmergencyAssistancePackageOe=findViewById(R.id.EmergencyAssistancePackageOe);
          PersonalAccidentPackageOne=findViewById(R.id.PersonalAccidentPackageOne);
          WellnessBenefitPackageOne=findViewById(R.id.WellnessBenefitPackageOne);
          TotalPremiumPackageOne=findViewById(R.id.TotalPremiumPackageOne);
          PremiumWaiverPackageTwo=findViewById(R.id.PremiumWaiverPackageTwo);
          SecondOpinionPackageTwo=findViewById(R.id.SecondOpinionPackageTwo);
          ModernTreatments=findViewById(R.id.ModernTreatments);
          PersonalAccidentPackageTwo=findViewById(R.id.PersonalAccidentPackageTwo);
          EmergencyAssistancePackageTwo=findViewById(R.id.EmergencyAssistancePackageTwo);
          NonMedicalPackageThree=findViewById(R.id.NonMedicalPackageThree);
          MedicallyAdvisedPackageThree=findViewById(R.id.MedicallyAdvisedPackageThree);
          EnhancedOrganPackageThree=findViewById(R.id.EnhancedOrganPackageThree);
          PersonalAccidentPackageThree=findViewById(R.id.PersonalAccidentPackageThree);
          HomeCarePackageThree=findViewById(R.id.HomeCarePackageThree);
          PersonalAccidentPackageFour=findViewById(R.id.PersonalAccidentPackageFour);
          CriticalIllnessPackageFour=findViewById(R.id.CriticalIllnessPackageFour);
          ModernTreatmentPackageFour=findViewById(R.id.ModernTreatmentPackageFour);
          HospitalDailyCashPackageFour=findViewById(R.id.HospitalDailyCashPackageFour);
          TreatmentTiredNetworkPackageFive=findViewById(R.id.TreatmentTiredNetworkPackageFive);
          WellnessBenefitPackageFive=findViewById(R.id.WellnessBenefitPackageFive);
          LinerPackage=findViewById(R.id.LinerPackage);
          None=findViewById(R.id.None);

        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        Log.e("today",today);
        calendar.add(Calendar.DATE, 364);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        nextYear = formatter.format(date);
        Log.e("nextYear",nextYear);

        strSumInsured="500000";
        SumInsuredEditText.setText(strSumInsured);
        strPlanTypeTXT="Essential";
        strPlanTypeTXT2="Digi-Pro";
        strPolicyTenure="1";
        PlanType=strPlanTypeTXT;
        relativeSecond.setVisibility(View.VISIBLE);
        PlanTypeTXT.setText(strPlanTypeTXT);
        PlanTypeTXT2.setText(strPlanTypeTXT2);
        SumInsuredSelectPlan.setText(strSumInsured);
        SumInsuredDiGiProTxt.setText(strSumInsured);

          dailyCheckBoxClick="False";
          PersonalStatus="False";
          CriticalStatus="False";
          DailyHospitalSatus="False";
          ModernTreatmentsStatus="False";
          ExtensionPreHospitalization="False";
          ExtensionPr0Hospitalization="False";
          CheckBoxPersonalCoverAStatus="False";
          CheckBoxPersonalCoverBStatus="False";
          MaternityAndChildcare="False";
          CoverageNonMedical="False";
          ConditionWaiverStatus="False";
          PersonalAccidentACoverStatus="False";
          PersonalAccidentBCoverStatus="False";
          PreExistingDiseaseStatus="False";
          OutpatientDentalStatus="False";
          EmergencyTravellingStatus="False";
          SecondOpinionStatus="False";
          RestCureStatus="False";
          ObesityWeightStatus="False";
          SterilityInfertilityStatus="False";
          EnhancedOrganStatus="False";
          PremiumWaiverStatus="False";
          GlobalCoverStatus="False";
          MedicallyAdvisedStatus="False";
          EmergencyAssistanceStatus="False";
          HomeCareStatus="False";
          WellnessBenefitStatus="False";
          DiseaseManagementStatus="False";
          LoyaltyDiscountStatus="False";
          CoPaymentStatus="False";

          SelfNameText.setText(mySharedPreference.getUserName());


          if (str_policyType_spinner.equals("Individual")){
              assetManager =getAssets();
              readExcelFileFromAssets();
              GetCalculatedData(selectYearAdult+".0",strSumInsured);
              Log.e("totalAmountXL",""+amount);
              AmountStr=amount;
              TotalAmountStr=amount;
              CardAmount=amount;
              TotalPremiumSelectPlan.setText(CardAmount);
              TotalPremium.setText(AmountStr);
          }
          else{
              if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                 if (mCounter==0){
                     if (selectYearAdult>selectYearSecondAdult){
                         CardAmount=TwoAdult(selectYearAdult,strSumInsured);
                         TotalAmountStr=CardAmount;
                         AmountStr=CardAmount;
                         TotalPremiumSelectPlan.setText(CardAmount);
                         TotalPremium.setText(AmountStr);
                     }else if (selectYearAdult<selectYearSecondAdult){
                         CardAmount=TwoAdult(selectYearSecondAdult,strSumInsured);
                         TotalAmountStr=CardAmount;
                         AmountStr=CardAmount;
                         TotalPremiumSelectPlan.setText(CardAmount);
                         TotalPremium.setText(AmountStr);
                     }
                 }else if (mCounter==1){
                      if (selectYearAdult>selectYearSecondAdult){
                          CardAmount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                          TotalAmountStr=CardAmount;
                          AmountStr=CardAmount;
                          TotalPremiumSelectPlan.setText(CardAmount);
                         TotalPremium.setText(AmountStr);
                     }else if (selectYearAdult<selectYearSecondAdult){
                          CardAmount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                          TotalAmountStr=CardAmount;
                          AmountStr=CardAmount;
                          TotalPremiumSelectPlan.setText(CardAmount);
                          TotalPremium.setText(AmountStr);
                     }
                 }else if (mCounter==2){
                      if (selectYearAdult>selectYearSecondAdult){
                          CardAmount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                          TotalAmountStr=CardAmount;
                          AmountStr=CardAmount;
                          TotalPremiumSelectPlan.setText(CardAmount);
                         TotalPremium.setText(AmountStr);
                     }else if (selectYearAdult<selectYearSecondAdult){
                          CardAmount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                          TotalAmountStr=CardAmount;
                          AmountStr=CardAmount;
                          TotalPremiumSelectPlan.setText(CardAmount);
                          TotalPremium.setText(AmountStr);
                     }

              }else if (mCounter==3){
                      if (selectYearAdult>selectYearSecondAdult){
                          CardAmount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                          TotalAmountStr=CardAmount;
                          AmountStr=CardAmount;
                          TotalPremiumSelectPlan.setText(CardAmount);
                         TotalPremium.setText(AmountStr);
                     }else if (selectYearAdult<selectYearSecondAdult){
                          CardAmount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                          TotalAmountStr=CardAmount;
                          AmountStr=CardAmount;
                          TotalPremiumSelectPlan.setText(CardAmount);
                          TotalPremium.setText(AmountStr);
                     }
                 }else if (mCounter==4) {
                      if (selectYearAdult>selectYearSecondAdult){
                          CardAmount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                          TotalAmountStr=CardAmount;
                          AmountStr=CardAmount;
                          TotalPremiumSelectPlan.setText(CardAmount);
                         TotalPremium.setText(AmountStr);
                     }else if (selectYearAdult<selectYearSecondAdult){
                          CardAmount = TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                          TotalAmountStr=CardAmount;
                          AmountStr=CardAmount;
                          TotalPremiumSelectPlan.setText(CardAmount);
                          TotalPremium.setText(AmountStr);
                     }

               }
                 if (strCheckBoxMother.equals("Checked")){
                  ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                  double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                     CardAmount= valueOf(addParentAmount);
                     TotalAmountStr=CardAmount;
                     AmountStr=CardAmount;
                     TotalPremiumSelectPlan.setText(CardAmount);
                  TotalPremium.setText(AmountStr);
              }
              if (strCheckBoxFather.equals("Checked")){
                  ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                  double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                  CardAmount= valueOf(addParentAmount);
                  Log.e("FatherAmount",AmountStr);
                  TotalAmountStr=CardAmount;
                  AmountStr=CardAmount;
                  TotalPremiumSelectPlan.setText(CardAmount);
                  TotalPremium.setText(AmountStr);
              }
              if (strCheckBoxMotherLaw.equals("Checked")){
                  ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                  double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                  CardAmount= valueOf(addParentAmount);
                  TotalAmountStr=CardAmount;
                  AmountStr=CardAmount;
                  TotalPremiumSelectPlan.setText(CardAmount);
                  TotalPremium.setText(AmountStr);
              }
              if (strCheckBoxFatherLaw.equals("Checked")){
                  ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                  double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                  CardAmount= valueOf(addParentAmount);
                  TotalAmountStr=CardAmount;
                  AmountStr=CardAmount;
                  TotalPremiumSelectPlan.setText(CardAmount);
                  TotalPremium.setText(AmountStr);
              }
              }
              else{
                if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                    CardAmount=AdultOneChild(selectYearAdult,strSumInsured);
                    TotalAmountStr=CardAmount;
                    AmountStr=CardAmount;
                    TotalPremiumSelectPlan.setText(CardAmount);
                  TotalPremium.setText(AmountStr);
              }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                    CardAmount=AdultTwoChild(selectYearAdult,strSumInsured);
                    TotalAmountStr=CardAmount;
                    AmountStr=CardAmount;
                    TotalPremiumSelectPlan.setText(CardAmount);
                  TotalPremium.setText(AmountStr);
              }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                    CardAmount=AdultThreeChild(selectYearAdult,strSumInsured);
                    TotalAmountStr=CardAmount;
                    AmountStr=CardAmount;
                    TotalPremiumSelectPlan.setText(CardAmount);
                  TotalPremium.setText(AmountStr);
              }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                    CardAmount=AdultFourChild(selectYearAdult,strSumInsured);
                    TotalAmountStr=CardAmount;
                    AmountStr=CardAmount;
                    TotalPremiumSelectPlan.setText(CardAmount);
                  TotalPremium.setText(AmountStr);
              }
              if (strCheckBoxMother.equals("Checked")){
                  ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                  double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                  CardAmount= valueOf(addParentAmount);
                  TotalAmountStr=CardAmount;
                  AmountStr=CardAmount;
                  TotalPremiumSelectPlan.setText(CardAmount);
                  TotalPremium.setText(AmountStr);
              }
              if (strCheckBoxFather.equals("Checked")){
                  ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                  double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                  CardAmount= valueOf(addParentAmount);
                  Log.e("FatherAmount",AmountStr);
                  TotalAmountStr=CardAmount;
                  AmountStr=CardAmount;
                  TotalPremiumSelectPlan.setText(CardAmount);
                  TotalPremium.setText(AmountStr);
              }
              if (strCheckBoxMotherLaw.equals("Checked")){
                  ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                  double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                  CardAmount= valueOf(addParentAmount);
                  TotalAmountStr=CardAmount;
                  AmountStr=CardAmount;
                  TotalPremiumSelectPlan.setText(CardAmount);
                  TotalPremium.setText(AmountStr);
              }
              if (strCheckBoxFatherLaw.equals("Checked")){
                  ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                  double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                  CardAmount= valueOf(addParentAmount);
                  TotalAmountStr=CardAmount;
                  AmountStr=CardAmount;
                  TotalPremiumSelectPlan.setText(CardAmount);
                  TotalPremium.setText(AmountStr);
              }
              }

          }

        SumInsuredDropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(OfflineCHIAddOns.this);
                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("100000");
//                items1.add("200000");
//                items1.add("300000");
                items1.add("400000");
                items1.add("500000");
                items1.add("600000");
                items1.add("700000");
                items1.add("800000");
                items1.add("900000");
                items1.add("1000000");
                items1.add("1500000");
                items1.add("2000000");
                items1.add("2500000");
                items1.add("3000000");
                items1.add("4000000");
                items1.add("5000000");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSumInsured=items1.get(options1);
                        SumInsuredEditText.setText(strSumInsured);

                         if (PackageOne.isChecked()){
                             PackageOne.setChecked(false); }
                          if (PackageTwo.isChecked()){
                              PackageTwo.setChecked(false); }
                           if (PackageThree.isChecked()){
                               PackageThree.setChecked(false); }
                            if (PackageFour.isChecked()){
                                PackageFour.setChecked(false); }
                             if (PackageFive.isChecked()){
                                 PackageFive.setChecked(false); }
                             if (CoPaymentCheckBox.isChecked()){
                                  CoPaymentCheckBox.setChecked(false); }
                              if (TenCheckBox.isChecked()){
                                  TenCheckBox.setChecked(false);
                         }
                              if (TwentyCheckBox.isChecked()){
                            TwentyCheckBox.setChecked(false);
                         }
                              if (ThirtyCheckBox.isChecked()){
                            ThirtyCheckBox.setChecked(false);
                         }
                              if (fortyCheckBox.isChecked()){
                            fortyCheckBox.setChecked(false);
                         } if (FiftyCheckBox.isChecked()){
                            FiftyCheckBox.setChecked(false);
                         }if (TieredDiscount.isChecked()){
                            TieredDiscount.setChecked(false);
                         }if (SubLimitDiscount.isChecked()){
                            SubLimitDiscount.setChecked(false);
                            LinerSubLimit.setVisibility(View.GONE);
                         }if (SubLimitADiscount.isChecked()){
                            SubLimitADiscount.setChecked(false);
                         }if (SubLimitBDiscount.isChecked()){
                            SubLimitBDiscount.setChecked(false);
                         }if (SubLimitCDiscount.isChecked()){
                            SubLimitCDiscount.setChecked(false);
                         }if (DirectPolicyDiscount.isChecked()){
                            DirectPolicyDiscount.setChecked(false);
                         }if (LoyaltyDiscount.isChecked()){
                            LoyaltyDiscount.setChecked(false);
                            LoyaltyTxt.setVisibility(View.GONE);
                         }
                        PackageValue();
                        if (strSumInsured.equals("100000") || strSumInsured.equals("200000")) {
                            strPlanTypeTXT = "Basic";
                            strPlanTypeTXT2 = "Digi-Pro";
                            relativeSecond.setVisibility(View.VISIBLE);
                            PlanTypeTXT.setText(strPlanTypeTXT);
                            PlanTypeTXT2.setText(strPlanTypeTXT2);
                            SumInsuredSelectPlan.setText(strSumInsured);
                            SumInsuredDiGiProTxt.setText(strSumInsured);

                        }
                        else if (strSumInsured.equals("500000") || strSumInsured.equals("400000") || strSumInsured.equals("300000")) {
                            strPlanTypeTXT = "Essential";
                            strPlanTypeTXT2 = "Digi-Pro";
                            relativeSecond.setVisibility(View.VISIBLE);
                            PlanTypeTXT.setText(strPlanTypeTXT);
                            PlanTypeTXT2.setText(strPlanTypeTXT2);
                            SumInsuredSelectPlan.setText(strSumInsured);
                            SumInsuredDiGiProTxt.setText(strSumInsured);

                        }
                        else if (strSumInsured.equals("600000") || strSumInsured.equals("700000") || strSumInsured.equals("800000") || strSumInsured.equals("900000") || strSumInsured.equals("1000000")) {
                            strPlanTypeTXT = "Privilege";
                            strPlanTypeTXT2 = "Digi-Pro";
                            relativeSecond.setVisibility(View.VISIBLE);
                            PlanTypeTXT.setText(strPlanTypeTXT);
                            PlanTypeTXT2.setText(strPlanTypeTXT2);
                            SumInsuredSelectPlan.setText(strSumInsured);
                            SumInsuredDiGiProTxt.setText(strSumInsured);
                        }
                        else if (strSumInsured.equals("1500000") || strSumInsured.equals("2000000")) {
                            strPlanTypeTXT = "Plus";
                            strPlanTypeTXT2 = "";
                            relativeSecond.setVisibility(View.GONE);
                            PlanTypeTXT.setText(strPlanTypeTXT);
                            SumInsuredSelectPlan.setText(strSumInsured);
                        }
                        else if (strSumInsured.equals("2500000") || strSumInsured.equals("3000000")) {
                            strPlanTypeTXT = "Premier";
                            strPlanTypeTXT2 = "";
                            relativeSecond.setVisibility(View.GONE);
                            PlanTypeTXT.setText(strPlanTypeTXT);
                            SumInsuredSelectPlan.setText(strSumInsured);
                        }
                        else if (strSumInsured.equals("4000000") || strSumInsured.equals("5000000")) {
                            strPlanTypeTXT = "Executive";
                            strPlanTypeTXT2 = "";
                            relativeSecond.setVisibility(View.GONE);
                            PlanTypeTXT.setText(strPlanTypeTXT);
                            SumInsuredSelectPlan.setText(strSumInsured);
                        }

                        if (OneYear.isChecked()) {
                            OneYear.setChecked(true);
                            TwoYearRadio.setChecked(false);
                            ThreeYearRadio.setChecked(false);
                            if (str_policyType_spinner.equals("Individual")) {
                                GetCalculatedData(selectYearAdult + ".0", strSumInsured);
                                Log.e("totalAmountXL", "" + amount);
                                TotalPremiumSelectPlan.setText(amount);
                                TotalPremium.setText(amount);
                            }
                            else {
                                if (strCheckBoxSelf.equals("Checked") && strCheckBoxSpouse.equals("Checked")) {
                                    if (mCounter == 0) {
                                        if (selectYearAdult > selectYearSecondAdult) {
                                            AmountStr = TwoAdult(selectYearAdult, strSumInsured);
                                            TotalAmountStr = AmountStr;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        } else if (selectYearAdult < selectYearSecondAdult) {
                                            AmountStr = TwoAdult(selectYearSecondAdult, strSumInsured);
                                            TotalAmountStr = AmountStr;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }
                                    } else if (mCounter == 1) {
                                        if (selectYearAdult > selectYearSecondAdult) {
                                            AmountStr = TwoAdultOneChild(selectYearAdult, strSumInsured);
                                            TotalAmountStr = AmountStr;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        } else if (selectYearAdult < selectYearSecondAdult) {
                                            AmountStr = TwoAdultOneChild(selectYearSecondAdult, strSumInsured);
                                            TotalAmountStr = AmountStr;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }
                                    } else if (mCounter == 2) {
                                        if (selectYearAdult > selectYearSecondAdult) {
                                            AmountStr = TwoAdultTwoChild(selectYearAdult, strSumInsured);
                                            TotalAmountStr = AmountStr;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        } else if (selectYearAdult < selectYearSecondAdult) {
                                            AmountStr = TwoAdultTwoChild(selectYearSecondAdult, strSumInsured);
                                            TotalAmountStr = AmountStr;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }

                                    } else if (mCounter == 3) {
                                        if (selectYearAdult > selectYearSecondAdult) {
                                            AmountStr = TwoAdultThreeChild(selectYearAdult, strSumInsured);
                                            TotalAmountStr = AmountStr;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        } else if (selectYearAdult < selectYearSecondAdult) {
                                            AmountStr = TwoAdultThreeChild(selectYearSecondAdult, strSumInsured);
                                            TotalAmountStr = AmountStr;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }

                                    } else if (mCounter == 4) {
                                        if (selectYearAdult > selectYearSecondAdult) {
                                            AmountStr = TwoAdultFourChild(selectYearAdult, strSumInsured);
                                            TotalAmountStr = AmountStr;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        } else if (selectYearAdult < selectYearSecondAdult) {
                                            AmountStr = TwoAdultFourChild(selectYearSecondAdult, strSumInsured);
                                            TotalAmountStr = AmountStr;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }

                                    }
                                    if (strCheckBoxMother.equals("Checked")) {
                                        ParentsMotherAmount = ParentsMother(selectYearMotherAdult, strSumInsured);
                                        double addParentAmount = Double.parseDouble(ParentsMotherAmount) + Double.parseDouble(AmountStr);
                                        AmountStr = valueOf(addParentAmount);
                                        TotalAmountStr = AmountStr;
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(AmountStr);
                                    }
                                    if (strCheckBoxFather.equals("Checked")) {
                                        ParentsFatherAmount = ParentsFather(selectYearFatherAdult, strSumInsured);
                                        double addParentAmount = Double.parseDouble(ParentsFatherAmount) + Double.parseDouble(TotalAmountStr);
                                        AmountStr = valueOf(addParentAmount);
                                        Log.e("FatherAmount", AmountStr);
                                        TotalAmountStr = AmountStr;
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(AmountStr);
                                    }
                                    if (strCheckBoxMotherLaw.equals("Checked")) {
                                        ParentsMotherLawAmount = ParentsMotherInLaw(selectMotherLawAdult, strSumInsured);
                                        double addParentAmount = Double.parseDouble(ParentsMotherLawAmount) + Double.parseDouble(TotalAmountStr);
                                        AmountStr = valueOf(addParentAmount);
                                        TotalAmountStr = AmountStr;
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(AmountStr);
                                    }
                                    if (strCheckBoxFatherLaw.equals("Checked")) {
                                        ParentsFatherLawAmount = ParentsFatherInLaw(selectFatherLawAdult, strSumInsured);
                                        double addParentAmount = Double.parseDouble(ParentsFatherLawAmount) + Double.parseDouble(TotalAmountStr);
                                        AmountStr = valueOf(addParentAmount);
                                        TotalAmountStr = AmountStr;
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(AmountStr);
                                    }
                                }
                                else{
                                    if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                        if (mCounter==0){
                                            if (selectYearAdult>selectYearSecondAdult){
                                                CardAmount=TwoAdult(selectYearAdult,strSumInsured);
                                                TotalAmountStr=CardAmount;
                                                AmountStr=CardAmount;
                                                TotalPremiumSelectPlan.setText(CardAmount);
                                                TotalPremium.setText(AmountStr);
                                            }else if (selectYearAdult<selectYearSecondAdult){
                                                CardAmount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                                TotalAmountStr=CardAmount;
                                                AmountStr=CardAmount;
                                                TotalPremiumSelectPlan.setText(CardAmount);
                                                TotalPremium.setText(AmountStr);
                                            }
                                        }else if (mCounter==1){
                                            if (selectYearAdult>selectYearSecondAdult){
                                                CardAmount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                                TotalAmountStr=CardAmount;
                                                AmountStr=CardAmount;
                                                TotalPremiumSelectPlan.setText(CardAmount);
                                                TotalPremium.setText(AmountStr);
                                            }else if (selectYearAdult<selectYearSecondAdult){
                                                CardAmount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                                TotalAmountStr=CardAmount;
                                                AmountStr=CardAmount;
                                                TotalPremiumSelectPlan.setText(CardAmount);
                                                TotalPremium.setText(AmountStr);
                                            }
                                        }else if (mCounter==2){
                                            if (selectYearAdult>selectYearSecondAdult){
                                                CardAmount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                                TotalAmountStr=CardAmount;
                                                AmountStr=CardAmount;
                                                TotalPremiumSelectPlan.setText(CardAmount);
                                                TotalPremium.setText(AmountStr);
                                            }else if (selectYearAdult<selectYearSecondAdult){
                                                CardAmount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                                TotalAmountStr=CardAmount;
                                                AmountStr=CardAmount;
                                                TotalPremiumSelectPlan.setText(CardAmount);
                                                TotalPremium.setText(AmountStr);
                                            }

                                        }else if (mCounter==3){
                                            if (selectYearAdult>selectYearSecondAdult){
                                                CardAmount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                                TotalAmountStr=CardAmount;
                                                AmountStr=CardAmount;
                                                TotalPremiumSelectPlan.setText(CardAmount);
                                                TotalPremium.setText(AmountStr);
                                            }else if (selectYearAdult<selectYearSecondAdult){
                                                CardAmount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                                TotalAmountStr=CardAmount;
                                                AmountStr=CardAmount;
                                                TotalPremiumSelectPlan.setText(CardAmount);
                                                TotalPremium.setText(AmountStr);
                                            }
                                        }else if (mCounter==4) {
                                            if (selectYearAdult>selectYearSecondAdult){
                                                CardAmount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                                TotalAmountStr=CardAmount;
                                                AmountStr=CardAmount;
                                                TotalPremiumSelectPlan.setText(CardAmount);
                                                TotalPremium.setText(AmountStr);
                                            }else if (selectYearAdult<selectYearSecondAdult){
                                                CardAmount = TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                                TotalAmountStr=CardAmount;
                                                AmountStr=CardAmount;
                                                TotalPremiumSelectPlan.setText(CardAmount);
                                                TotalPremium.setText(AmountStr);
                                            }

                                        }
                                        if (strCheckBoxMother.equals("Checked")){
                                            ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                            double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                            CardAmount= valueOf(addParentAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }
                                        if (strCheckBoxFather.equals("Checked")){
                                            ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                            double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                            CardAmount= valueOf(addParentAmount);
                                            Log.e("FatherAmount",AmountStr);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }
                                        if (strCheckBoxMotherLaw.equals("Checked")){
                                            ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                            double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                            CardAmount= valueOf(addParentAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }
                                        if (strCheckBoxFatherLaw.equals("Checked")){
                                            ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                            double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                            CardAmount= valueOf(addParentAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }
                                    }
                                    else{
                                        if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                            CardAmount=AdultOneChild(selectYearAdult,strSumInsured);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                            CardAmount=AdultTwoChild(selectYearAdult,strSumInsured);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                            CardAmount=AdultThreeChild(selectYearAdult,strSumInsured);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                            CardAmount=AdultFourChild(selectYearAdult,strSumInsured);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }
                                        if (strCheckBoxMother.equals("Checked")){
                                            ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                            double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                            CardAmount= valueOf(addParentAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }
                                        if (strCheckBoxFather.equals("Checked")){
                                            ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                            double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                            CardAmount= valueOf(addParentAmount);
                                            Log.e("FatherAmount",AmountStr);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }
                                        if (strCheckBoxMotherLaw.equals("Checked")){
                                            ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                            double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                            CardAmount= valueOf(addParentAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }
                                        if (strCheckBoxFatherLaw.equals("Checked")){
                                            ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                            double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                            CardAmount= valueOf(addParentAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(AmountStr);
                                        }
                                    }

                                }


                            }
                        }else if (TwoYearRadio.isChecked()){
                            OneYear.setChecked(false);
                            TwoYearRadio.setChecked(true);
                            ThreeYearRadio.setChecked(false);
                            if (str_policyType_spinner.equals("Individual")){
                                GetCalculatedData(selectYearAdult+".0",strSumInsured);
                                double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                CardAmount= valueOf(twoYearAmount);
                                TotalAmountStr=CardAmount;
                                AmountStr=CardAmount;
                                Log.e("twoYearAmount",""+twoYearAmount);
                                TotalPremiumSelectPlan.setText(CardAmount);
                                TotalPremium.setText(valueOf(AmountStr));
                            }
                            else{
                                if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                    if (mCounter==0){
                                        if (selectYearAdult>selectYearSecondAdult){
                                            amount=TwoAdult(selectYearAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }else if (selectYearAdult<selectYearSecondAdult){
                                            amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }
                                    }else if (mCounter==1){
                                        if (selectYearAdult>selectYearSecondAdult){
                                            amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }else if (selectYearAdult<selectYearSecondAdult){
                                            amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }
                                    }else if (mCounter==2){
                                        if (selectYearAdult>selectYearSecondAdult){
                                            amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }else if (selectYearAdult<selectYearSecondAdult){
                                            amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }

                                    }else if (mCounter==3){
                                        if (selectYearAdult>selectYearSecondAdult){
                                            amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }else if (selectYearAdult<selectYearSecondAdult){
                                            amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }

                                    }else if (mCounter==4) {
                                        if (selectYearAdult>selectYearSecondAdult){
                                            amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }else if (selectYearAdult<selectYearSecondAdult){
                                            amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }
                                    }
                                    if (strCheckBoxMother.equals("Checked")){
                                        ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                        double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                        double twoYearAmountCalculation= addParentAmount*2;
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));

                                    }
                                    if (strCheckBoxFather.equals("Checked")){
                                        ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                        double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                        double twoYearAmountCalculation= addParentAmount*2;
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                    if (strCheckBoxMotherLaw.equals("Checked")){
                                        ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                        double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                        double twoYearAmountCalculation= addParentAmount*2;
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                    if (strCheckBoxFatherLaw.equals("Checked")){
                                        ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                        double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                        double twoYearAmountCalculation= addParentAmount*2;
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else{
                                    if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                        amount=AdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                        amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                        amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                        amount=AdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                    if (strCheckBoxMother.equals("Checked")){
                                        ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                        double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                        double twoYearAmountCalculation= addParentAmount*2;
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));

                                    }
                                    if (strCheckBoxFather.equals("Checked")){
                                        ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                        double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                        double twoYearAmountCalculation= addParentAmount*2;
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                    if (strCheckBoxMotherLaw.equals("Checked")){
                                        ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                        double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                        double twoYearAmountCalculation= addParentAmount*2;
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                    if (strCheckBoxFatherLaw.equals("Checked")){
                                        ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                        double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                        double twoYearAmountCalculation= addParentAmount*2;
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }
                            }
                        }
                        else if(ThreeYearRadio.isChecked()){
                            OneYear.setChecked(false);
                            TwoYearRadio.setChecked(false);
                            ThreeYearRadio.setChecked(true);
                            if (str_policyType_spinner.equals("Individual")){
                                GetCalculatedData(selectYearAdult+".0",strSumInsured);
                                double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                CardAmount= valueOf(twoYearAmount);
                                TotalAmountStr=CardAmount;
                                AmountStr=CardAmount;
                                Log.e("twoYearAmount",""+twoYearAmount);
                                TotalPremiumSelectPlan.setText(CardAmount);
                                TotalPremium.setText(valueOf(AmountStr));
                            }
                            else{
                                if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                    if (mCounter==0){
                                        if (selectYearAdult>selectYearSecondAdult){
                                            amount=TwoAdult(selectYearAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }else if (selectYearAdult<selectYearSecondAdult){
                                            amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }
                                    }else if (mCounter==1){
                                        if (selectYearAdult>selectYearSecondAdult){
                                            amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }else if (selectYearAdult<selectYearSecondAdult){
                                            amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }
                                    }else if (mCounter==2){
                                        if (selectYearAdult>selectYearSecondAdult){
                                            amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }else if (selectYearAdult<selectYearSecondAdult){
                                            amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }

                                    }else if (mCounter==3){
                                        if (selectYearAdult>selectYearSecondAdult){
                                            amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }else if (selectYearAdult<selectYearSecondAdult){
                                            amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }

                                    }else if (mCounter==4) {
                                        if (selectYearAdult>selectYearSecondAdult){
                                            amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }else if (selectYearAdult<selectYearSecondAdult){
                                            amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                            CardAmount= valueOf(twoYearAmount);
                                            TotalAmountStr=CardAmount;
                                            AmountStr=CardAmount;
                                            Log.e("twoYearAmount",""+twoYearAmount);
                                            TotalPremiumSelectPlan.setText(CardAmount);
                                            TotalPremium.setText(valueOf(AmountStr));
                                        }
                                    }
                                    if (strCheckBoxMother.equals("Checked")){
                                        ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                        double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((addParentAmount*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));

                                    }
                                    if (strCheckBoxFather.equals("Checked")){
                                        ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                        double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((addParentAmount*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                    if (strCheckBoxMotherLaw.equals("Checked")){
                                        ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                        double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((addParentAmount*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                    if (strCheckBoxFatherLaw.equals("Checked")){
                                        ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                        double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((addParentAmount*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else{
                                    if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                        amount=AdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                        amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                        amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                        amount=AdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                    if (strCheckBoxMother.equals("Checked")){
                                        ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                        double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((addParentAmount*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));

                                    }
                                    if (strCheckBoxFather.equals("Checked")){
                                        ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                        double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((addParentAmount*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                    if (strCheckBoxMotherLaw.equals("Checked")){
                                        ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                        double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((addParentAmount*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                    if (strCheckBoxFatherLaw.equals("Checked")){
                                        ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                        double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                        double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((addParentAmount*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }
                            }

                        }
                    }
                });
                singlePicker.show();
            }

        });
        OneYear.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (OneYear.isChecked()){
                    strPolicyTenure="1";
                    OneYear.setChecked(true);
                    TwoYearRadio.setChecked(false);
                    ThreeYearRadio.setChecked(false);
                    oneYearSecondRadio.setChecked(false);
                    TwoYearSecondRadio.setChecked(false);
                    ThreeYearSecondRadio.setChecked(false);
//                    LinerPackage.setVisibility(View.VISIBLE);
                     if (PackageOne.isChecked()){
                             PackageOne.setChecked(false); }
                          if (PackageTwo.isChecked()){
                              PackageTwo.setChecked(false); }
                           if (PackageThree.isChecked()){
                               PackageThree.setChecked(false); }
                            if (PackageFour.isChecked()){
                                PackageFour.setChecked(false); }
                             if (PackageFive.isChecked()){
                                 PackageFive.setChecked(false); }
                             if (CoPaymentCheckBox.isChecked()){
                                  CoPaymentCheckBox.setChecked(false); }
                              if (TenCheckBox.isChecked()){
                                  TenCheckBox.setChecked(false);
                         }
                              if (TwentyCheckBox.isChecked()){
                            TwentyCheckBox.setChecked(false);
                         }
                              if (ThirtyCheckBox.isChecked()){
                            ThirtyCheckBox.setChecked(false);
                         }
                              if (fortyCheckBox.isChecked()){
                            fortyCheckBox.setChecked(false);
                         } if (FiftyCheckBox.isChecked()){
                            FiftyCheckBox.setChecked(false);
                         }if (TieredDiscount.isChecked()){
                            TieredDiscount.setChecked(false);
                         }if (SubLimitDiscount.isChecked()){
                            SubLimitDiscount.setChecked(false);
                            LinerSubLimit.setVisibility(View.GONE);
                         }if (SubLimitADiscount.isChecked()){
                            SubLimitADiscount.setChecked(false);
                         }if (SubLimitBDiscount.isChecked()){
                            SubLimitBDiscount.setChecked(false);
                         }if (SubLimitCDiscount.isChecked()){
                            SubLimitCDiscount.setChecked(false);
                         }if (DirectPolicyDiscount.isChecked()){
                            DirectPolicyDiscount.setChecked(false);
                         }if (LoyaltyDiscount.isChecked()){
                            LoyaltyDiscount.setChecked(false);
                            LoyaltyTxt.setVisibility(View.GONE);
                         }
                    PackageValue();
                         if (strSumInsured.equals("100000") || strSumInsured.equals("200000")){
                        strPlanTypeTXT="Basic";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;

                    }else if (strSumInsured.equals("500000") || strSumInsured.equals("400000")|| strSumInsured.equals("300000")){
                        strPlanTypeTXT="Essential";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                             if (str_policyType_spinner.equals("Individual")){
                                 assetManager =getAssets();
                                 readExcelFileFromAssets();
                                 GetCalculatedData(selectYearAdult+".0",strSumInsured);
                                 Log.e("totalAmountXL",""+amount);
                                 AmountStr=amount;
                                 TotalAmountStr=amount;
                                 CardAmount=amount;
                                 TotalPremiumSelectPlan.setText(CardAmount);
                                 TotalPremium.setText(AmountStr);
                             }
                             else{
                                 if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                     if (mCounter==0){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdult(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==1){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==2){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }

                                     }else if (mCounter==3){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==4) {
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount = TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }

                                     }
                                     if (strCheckBoxMother.equals("Checked")){
                                         ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFather.equals("Checked")){
                                         ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         Log.e("FatherAmount",AmountStr);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMotherLaw.equals("Checked")){
                                         ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFatherLaw.equals("Checked")){
                                         ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                 }
                                 else{
                                     if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                         CardAmount=AdultOneChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                         CardAmount=AdultTwoChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                         CardAmount=AdultThreeChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                         CardAmount=AdultFourChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMother.equals("Checked")){
                                         ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFather.equals("Checked")){
                                         ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         Log.e("FatherAmount",AmountStr);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMotherLaw.equals("Checked")){
                                         ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFatherLaw.equals("Checked")){
                                         ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                 }

                             }
                         }
                    else if (strSumInsured.equals("600000") || strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                        strPlanTypeTXT="Privilege";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                             if (str_policyType_spinner.equals("Individual")){
                                 assetManager =getAssets();
                                 readExcelFileFromAssets();
                                 GetCalculatedData(selectYearAdult+".0",strSumInsured);
                                 Log.e("totalAmountXL",""+amount);
                                 AmountStr=amount;
                                 TotalAmountStr=amount;
                                 CardAmount=amount;
                                 TotalPremiumSelectPlan.setText(CardAmount);
                                 TotalPremium.setText(AmountStr);
                             }
                             else{
                                 if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                     if (mCounter==0){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdult(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==1){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==2){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }

                                     }else if (mCounter==3){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==4) {
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount = TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }

                                     }
                                     if (strCheckBoxMother.equals("Checked")){
                                         ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFather.equals("Checked")){
                                         ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         Log.e("FatherAmount",AmountStr);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMotherLaw.equals("Checked")){
                                         ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFatherLaw.equals("Checked")){
                                         ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                 }
                                 else{
                                     if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                         CardAmount=AdultOneChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                         CardAmount=AdultTwoChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                         CardAmount=AdultThreeChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                         CardAmount=AdultFourChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMother.equals("Checked")){
                                         ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFather.equals("Checked")){
                                         ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         Log.e("FatherAmount",AmountStr);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMotherLaw.equals("Checked")){
                                         ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFatherLaw.equals("Checked")){
                                         ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                 }

                             }
                         }
                    else if (strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                        strPlanTypeTXT="Plus";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                             if (str_policyType_spinner.equals("Individual")){
                                 assetManager =getAssets();
                                 readExcelFileFromAssets();
                                 GetCalculatedData(selectYearAdult+".0",strSumInsured);
                                 Log.e("totalAmountXL",""+amount);
                                 AmountStr=amount;
                                 TotalAmountStr=amount;
                                 CardAmount=amount;
                                 TotalPremiumSelectPlan.setText(CardAmount);
                                 TotalPremium.setText(AmountStr);
                             }
                             else{
                                 if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                     if (mCounter==0){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdult(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==1){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==2){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }

                                     }else if (mCounter==3){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==4) {
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount = TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }

                                     }
                                     if (strCheckBoxMother.equals("Checked")){
                                         ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFather.equals("Checked")){
                                         ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         Log.e("FatherAmount",AmountStr);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMotherLaw.equals("Checked")){
                                         ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFatherLaw.equals("Checked")){
                                         ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                 }
                                 else{
                                     if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                         CardAmount=AdultOneChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                         CardAmount=AdultTwoChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                         CardAmount=AdultThreeChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                         CardAmount=AdultFourChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMother.equals("Checked")){
                                         ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFather.equals("Checked")){
                                         ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         Log.e("FatherAmount",AmountStr);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMotherLaw.equals("Checked")){
                                         ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFatherLaw.equals("Checked")){
                                         ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                 }

                             }
                         }
                    else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                        strPlanTypeTXT="Premier";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                             if (str_policyType_spinner.equals("Individual")){
                                 assetManager =getAssets();
                                 readExcelFileFromAssets();
                                 GetCalculatedData(selectYearAdult+".0",strSumInsured);
                                 Log.e("totalAmountXL",""+amount);
                                 AmountStr=amount;
                                 TotalAmountStr=amount;
                                 CardAmount=amount;
                                 TotalPremiumSelectPlan.setText(CardAmount);
                                 TotalPremium.setText(AmountStr);
                             }
                             else{
                                 if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                     if (mCounter==0){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdult(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==1){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==2){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }

                                     }else if (mCounter==3){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==4) {
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount = TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }

                                     }
                                     if (strCheckBoxMother.equals("Checked")){
                                         ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFather.equals("Checked")){
                                         ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         Log.e("FatherAmount",AmountStr);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMotherLaw.equals("Checked")){
                                         ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFatherLaw.equals("Checked")){
                                         ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                 }
                                 else{
                                     if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                         CardAmount=AdultOneChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                         CardAmount=AdultTwoChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                         CardAmount=AdultThreeChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                         CardAmount=AdultFourChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMother.equals("Checked")){
                                         ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFather.equals("Checked")){
                                         ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         Log.e("FatherAmount",AmountStr);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMotherLaw.equals("Checked")){
                                         ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFatherLaw.equals("Checked")){
                                         ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                 }

                             }
                         }
                    else if (strSumInsured.equals("4000000")|| strSumInsured.equals("5000000")){
                        strPlanTypeTXT="Executive";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                             if (str_policyType_spinner.equals("Individual")){
                                 assetManager =getAssets();
                                 readExcelFileFromAssets();
                                 GetCalculatedData(selectYearAdult+".0",strSumInsured);
                                 Log.e("totalAmountXL",""+amount);
                                 AmountStr=amount;
                                 TotalAmountStr=amount;
                                 CardAmount=amount;
                                 TotalPremiumSelectPlan.setText(CardAmount);
                                 TotalPremium.setText(AmountStr);
                             }
                             else{
                                 if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                     if (mCounter==0){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdult(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==1){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==2){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }

                                     }else if (mCounter==3){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==4) {
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount = TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }

                                     }
                                     if (strCheckBoxMother.equals("Checked")){
                                         ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFather.equals("Checked")){
                                         ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         Log.e("FatherAmount",AmountStr);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMotherLaw.equals("Checked")){
                                         ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFatherLaw.equals("Checked")){
                                         ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                 }
                                 else{
                                     if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                         CardAmount=AdultOneChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                         CardAmount=AdultTwoChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                         CardAmount=AdultThreeChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                         CardAmount=AdultFourChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMother.equals("Checked")){
                                         ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFather.equals("Checked")){
                                         ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         Log.e("FatherAmount",AmountStr);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMotherLaw.equals("Checked")){
                                         ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFatherLaw.equals("Checked")){
                                         ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                 }

                             }
                         }else {
                        if (str_policyType_spinner.equals("Individual")){
                                 assetManager =getAssets();
                                 readExcelFileFromAssets();
                                 GetCalculatedData(selectYearAdult+".0",strSumInsured);
                                 Log.e("totalAmountXL",""+amount);
                                 AmountStr=amount;
                                 TotalAmountStr=amount;
                                 CardAmount=amount;
                                 TotalPremiumSelectPlan.setText(CardAmount);
                                 TotalPremium.setText(AmountStr);
                             }
                        else{
                                 if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                     if (mCounter==0){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdult(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==1){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==2){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }

                                     }else if (mCounter==3){
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }
                                     }else if (mCounter==4) {
                                         if (selectYearAdult>selectYearSecondAdult){
                                             CardAmount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }else if (selectYearAdult<selectYearSecondAdult){
                                             CardAmount = TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                             TotalAmountStr=CardAmount;
                                             AmountStr=CardAmount;
                                             TotalPremiumSelectPlan.setText(CardAmount);
                                             TotalPremium.setText(AmountStr);
                                         }

                                     }
                                     if (strCheckBoxMother.equals("Checked")){
                                         ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFather.equals("Checked")){
                                         ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         Log.e("FatherAmount",AmountStr);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMotherLaw.equals("Checked")){
                                         ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFatherLaw.equals("Checked")){
                                         ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                 }
                                 else{
                                     if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                         CardAmount=AdultOneChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                         CardAmount=AdultTwoChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                         CardAmount=AdultThreeChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                         CardAmount=AdultFourChild(selectYearAdult,strSumInsured);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMother.equals("Checked")){
                                         ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherAmount)+Double.parseDouble(AmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFather.equals("Checked")){
                                         ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         Log.e("FatherAmount",AmountStr);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxMotherLaw.equals("Checked")){
                                         ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                     if (strCheckBoxFatherLaw.equals("Checked")){
                                         ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                         double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                         CardAmount= valueOf(addParentAmount);
                                         TotalAmountStr=CardAmount;
                                         AmountStr=CardAmount;
                                         TotalPremiumSelectPlan.setText(CardAmount);
                                         TotalPremium.setText(AmountStr);
                                     }
                                 }

                             }
                    }

                }
            }
        });
        TwoYearRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (TwoYearRadio.isChecked()){
                    strPolicyTenure="2";
                    OneYear.setChecked(false);
                    TwoYearRadio.setChecked(true);
                    ThreeYearRadio.setChecked(false);
                    oneYearSecondRadio.setChecked(false);
                    TwoYearSecondRadio.setChecked(false);
                    ThreeYearSecondRadio.setChecked(false);
//                    LinerPackage.setVisibility(View.VISIBLE);
                     if (PackageOne.isChecked()){
                             PackageOne.setChecked(false); }
                          if (PackageTwo.isChecked()){
                              PackageTwo.setChecked(false); }
                           if (PackageThree.isChecked()){
                               PackageThree.setChecked(false); }
                            if (PackageFour.isChecked()){
                                PackageFour.setChecked(false); }
                             if (PackageFive.isChecked()){
                                 PackageFive.setChecked(false); }
                             if (CoPaymentCheckBox.isChecked()){
                                  CoPaymentCheckBox.setChecked(false); }
                              if (TenCheckBox.isChecked()){
                                  TenCheckBox.setChecked(false);
                         } if (TwentyCheckBox.isChecked()){
                            TwentyCheckBox.setChecked(false);
                         } if (ThirtyCheckBox.isChecked()){
                            ThirtyCheckBox.setChecked(false);
                         } if (fortyCheckBox.isChecked()){
                            fortyCheckBox.setChecked(false);
                         } if (FiftyCheckBox.isChecked()){
                            FiftyCheckBox.setChecked(false);
                         }if (TieredDiscount.isChecked()){
                            TieredDiscount.setChecked(false);
                         }if (SubLimitDiscount.isChecked()){
                            SubLimitDiscount.setChecked(false);
                            LinerSubLimit.setVisibility(View.GONE);
                         }if (SubLimitADiscount.isChecked()){
                            SubLimitADiscount.setChecked(false);
                         }if (SubLimitBDiscount.isChecked()){
                            SubLimitBDiscount.setChecked(false);
                         }if (SubLimitCDiscount.isChecked()){
                            SubLimitCDiscount.setChecked(false);
                         }if (DirectPolicyDiscount.isChecked()){
                            DirectPolicyDiscount.setChecked(false);
                         }if (LoyaltyDiscount.isChecked()){
                            LoyaltyDiscount.setChecked(false);
                            LoyaltyTxt.setVisibility(View.GONE);
                         }
                    PackageValue();

                    if (strSumInsured.equals("100000") || strSumInsured.equals("200000")){
                        strPlanTypeTXT="Basic";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                    }
                    else if (strSumInsured.equals("500000") || strSumInsured.equals("400000")|| strSumInsured.equals("300000")){
                        strPlanTypeTXT="Essential";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                        if (str_policyType_spinner.equals("Individual")){
                            GetCalculatedData(selectYearAdult+".0",strSumInsured);
                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                            CardAmount= valueOf(twoYearAmount);
                            TotalAmountStr=CardAmount;
                            AmountStr=CardAmount;
                            Log.e("twoYearAmount",""+twoYearAmount);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(valueOf(AmountStr));
                        }
                        else{
                            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                if (mCounter==0){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdult(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                else if (mCounter==1){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                else if (mCounter==2){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }
                                else if (mCounter==3){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }
                                else if (mCounter==4) {
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                            }else{
                                if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                    amount=AdultOneChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                    amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                    amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                    amount=AdultFourChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }

                            }
                        }
                    }
                    else if (strSumInsured.equals("600000") || strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                        strPlanTypeTXT="Privilege";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                        if (str_policyType_spinner.equals("Individual")){
                            GetCalculatedData(selectYearAdult+".0",strSumInsured);
                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                            CardAmount= valueOf(twoYearAmount);
                            TotalAmountStr=CardAmount;
                            AmountStr=CardAmount;
                            Log.e("twoYearAmount",""+twoYearAmount);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(valueOf(AmountStr));
                        }
                        else{
                            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                if (mCounter==0){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdult(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==1){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==2){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==3){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==4) {
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                            }else{
                                if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                    amount=AdultOneChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                    amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                    amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                    amount=AdultFourChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }

                            }
                        }
                    }
                    else if (strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                        strPlanTypeTXT="Plus";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                        if (str_policyType_spinner.equals("Individual")){
                            GetCalculatedData(selectYearAdult+".0",strSumInsured);
                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                            CardAmount= valueOf(twoYearAmount);
                            TotalAmountStr=CardAmount;
                            AmountStr=CardAmount;
                            Log.e("twoYearAmount",""+twoYearAmount);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(valueOf(AmountStr));
                        }
                        else{
                            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                if (mCounter==0){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdult(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==1){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==2){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==3){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==4) {
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                            }else{
                                if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                    amount=AdultOneChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                    amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                    amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                    amount=AdultFourChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }

                            }
                        }
                    }
                    else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                        strPlanTypeTXT="Premier";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                        if (str_policyType_spinner.equals("Individual")){
                            GetCalculatedData(selectYearAdult+".0",strSumInsured);
                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                            CardAmount= valueOf(twoYearAmount);
                            TotalAmountStr=CardAmount;
                            AmountStr=CardAmount;
                            Log.e("twoYearAmount",""+twoYearAmount);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(valueOf(AmountStr));
                        }
                        else{
                            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                if (mCounter==0){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdult(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==1){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==2){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==3){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==4) {
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                            }else{
                                if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                    amount=AdultOneChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                    amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                    amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                    amount=AdultFourChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }

                            }
                        }
                    }
                    else if (strSumInsured.equals("4000000")|| strSumInsured.equals("5000000")){
                        strPlanTypeTXT="Executive";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                        if (str_policyType_spinner.equals("Individual")){
                            GetCalculatedData(selectYearAdult+".0",strSumInsured);
                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                            CardAmount= valueOf(twoYearAmount);
                            TotalAmountStr=CardAmount;
                            AmountStr=CardAmount;
                            Log.e("twoYearAmount",""+twoYearAmount);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(valueOf(AmountStr));
                        }
                        else{
                            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                if (mCounter==0){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdult(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==1){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==2){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==3){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==4) {
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                            }else{
                                if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                    amount=AdultOneChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                    amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                    amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                    amount=AdultFourChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }

                            }
                        }
                      }
                    else {
                        if (str_policyType_spinner.equals("Individual")){
                            GetCalculatedData(selectYearAdult+".0",strSumInsured);
                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                            CardAmount= valueOf(twoYearAmount);
                            TotalAmountStr=CardAmount;
                            AmountStr=CardAmount;
                            Log.e("twoYearAmount",""+twoYearAmount);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(valueOf(AmountStr));
                        }
                        else{
                            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                if (mCounter==0){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdult(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==1){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==2){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==3){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==4) {
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                            }else{
                                if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                    amount=AdultOneChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                    amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                    amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                    amount=AdultFourChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*2))*5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*2));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=((addParentAmount*2)*5)/100;
                                    double twoYearAmountCalculation= addParentAmount*2;
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }

                            }
                        }
                    }

                }
            }
        });
        ThreeYearRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ThreeYearRadio.isChecked()){
                    strPolicyTenure="3";
                    OneYear.setChecked(false);
                    TwoYearRadio.setChecked(false);
                    ThreeYearRadio.setChecked(true);
                    oneYearSecondRadio.setChecked(false);
                    TwoYearSecondRadio.setChecked(false);
                    ThreeYearSecondRadio.setChecked(false);
//                    LinerPackage.setVisibility(View.VISIBLE);
                     if (PackageOne.isChecked()){
                             PackageOne.setChecked(false); }
                          if (PackageTwo.isChecked()){
                              PackageTwo.setChecked(false); }
                           if (PackageThree.isChecked()){
                               PackageThree.setChecked(false); }
                            if (PackageFour.isChecked()){
                                PackageFour.setChecked(false); }
                             if (PackageFive.isChecked()){
                                 PackageFive.setChecked(false); }
                             if (CoPaymentCheckBox.isChecked()){
                                  CoPaymentCheckBox.setChecked(false); }
                              if (TenCheckBox.isChecked()){
                                  TenCheckBox.setChecked(false);
                         } if (TwentyCheckBox.isChecked()){
                            TwentyCheckBox.setChecked(false);
                         } if (ThirtyCheckBox.isChecked()){
                            ThirtyCheckBox.setChecked(false);
                         } if (fortyCheckBox.isChecked()){
                            fortyCheckBox.setChecked(false);
                         } if (FiftyCheckBox.isChecked()){
                            FiftyCheckBox.setChecked(false);
                         }if (TieredDiscount.isChecked()){
                            TieredDiscount.setChecked(false);
                         }if (SubLimitDiscount.isChecked()){
                            SubLimitDiscount.setChecked(false);
                            LinerSubLimit.setVisibility(View.GONE);
                         }if (SubLimitADiscount.isChecked()){
                            SubLimitADiscount.setChecked(false);
                         }if (SubLimitBDiscount.isChecked()){
                            SubLimitBDiscount.setChecked(false);
                         }if (SubLimitCDiscount.isChecked()){
                            SubLimitCDiscount.setChecked(false);
                         }if (DirectPolicyDiscount.isChecked()){
                            DirectPolicyDiscount.setChecked(false);
                         }if (LoyaltyDiscount.isChecked()){
                            LoyaltyDiscount.setChecked(false);
                            LoyaltyTxt.setVisibility(View.GONE);
                         }

                    PackageValue();

                    if (strSumInsured.equals("100000") || strSumInsured.equals("200000")){
                        strPlanTypeTXT="Basic";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;

                    }
                    else if (strSumInsured.equals("500000") || strSumInsured.equals("400000")|| strSumInsured.equals("300000")){
                        strPlanTypeTXT="Essential";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                        if (str_policyType_spinner.equals("Individual")){
                            GetCalculatedData(selectYearAdult+".0",strSumInsured);
                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                            CardAmount= valueOf(twoYearAmount);
                            TotalAmountStr=CardAmount;
                            AmountStr=CardAmount;
                            Log.e("twoYearAmount",""+twoYearAmount);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(valueOf(AmountStr));
                        }
                        else{
                            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                if (mCounter==0){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdult(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==1){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==2){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==3){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==4) {
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                            }else{
                                if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                    amount=AdultOneChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                    amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                    amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                    amount=AdultFourChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }

                            }
                        }
                    }
                    else if (strSumInsured.equals("600000") || strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                        strPlanTypeTXT="Privilege";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                        if (str_policyType_spinner.equals("Individual")){
                            GetCalculatedData(selectYearAdult+".0",strSumInsured);
                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                            CardAmount= valueOf(twoYearAmount);
                            TotalAmountStr=CardAmount;
                            AmountStr=CardAmount;
                            Log.e("twoYearAmount",""+twoYearAmount);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(valueOf(AmountStr));
                        }
                        else{
                            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                if (mCounter==0){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdult(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==1){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==2){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==3){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==4) {
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                            }else{
                                if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                    amount=AdultOneChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                    amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                    amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                    amount=AdultFourChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }

                            }
                        }
                    }
                    else if (strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                        strPlanTypeTXT="Plus";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                        if (str_policyType_spinner.equals("Individual")){
                            GetCalculatedData(selectYearAdult+".0",strSumInsured);
                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                            CardAmount= valueOf(twoYearAmount);
                            TotalAmountStr=CardAmount;
                            AmountStr=CardAmount;
                            Log.e("twoYearAmount",""+twoYearAmount);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(valueOf(AmountStr));
                        }
                        else{
                            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                if (mCounter==0){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdult(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==1){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==2){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==3){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==4) {
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                            }else{
                                if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                    amount=AdultOneChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                    amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                    amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                    amount=AdultFourChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }

                            }
                        }
                    }
                    else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                        strPlanTypeTXT="Premier";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                        if (str_policyType_spinner.equals("Individual")){
                            GetCalculatedData(selectYearAdult+".0",strSumInsured);
                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                            CardAmount= valueOf(twoYearAmount);
                            TotalAmountStr=CardAmount;
                            AmountStr=CardAmount;
                            Log.e("twoYearAmount",""+twoYearAmount);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(valueOf(AmountStr));
                        }
                        else{
                            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                if (mCounter==0){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdult(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==1){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==2){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==3){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==4) {
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                            }else{
                                if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                    amount=AdultOneChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                    amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                    amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                    amount=AdultFourChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }

                            }
                        }
                    }
                    else if (strSumInsured.equals("4000000")|| strSumInsured.equals("5000000")){
                        strPlanTypeTXT="Executive";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT;
                        if (str_policyType_spinner.equals("Individual")){
                            GetCalculatedData(selectYearAdult+".0",strSumInsured);
                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                            CardAmount= valueOf(twoYearAmount);
                            TotalAmountStr=CardAmount;
                            AmountStr=CardAmount;
                            Log.e("twoYearAmount",""+twoYearAmount);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(valueOf(AmountStr));
                        }
                        else{
                            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                if (mCounter==0){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdult(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==1){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==2){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==3){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==4) {
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                            }else{
                                if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                    amount=AdultOneChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                    amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                    amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                    amount=AdultFourChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }

                            }
                        }
                    }
                    else {
                        if (str_policyType_spinner.equals("Individual")){
                            GetCalculatedData(selectYearAdult+".0",strSumInsured);
                            double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                            double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                            twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                            CardAmount= valueOf(twoYearAmount);
                            TotalAmountStr=CardAmount;
                            AmountStr=CardAmount;
                            Log.e("twoYearAmount",""+twoYearAmount);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(valueOf(AmountStr));
                        }
                        else{
                            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                                if (mCounter==0){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdult(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdult(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==1){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultOneChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }else if (mCounter==2){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultTwoChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==3){
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultThreeChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }

                                }else if (mCounter==4) {
                                    if (selectYearAdult>selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }else if (selectYearAdult<selectYearSecondAdult){
                                        amount=TwoAdultFourChild(selectYearSecondAdult,strSumInsured);
                                        double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                        double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                        twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                        CardAmount= valueOf(twoYearAmount);
                                        TotalAmountStr=CardAmount;
                                        AmountStr=CardAmount;
                                        Log.e("twoYearAmount",""+twoYearAmount);
                                        TotalPremiumSelectPlan.setText(CardAmount);
                                        TotalPremium.setText(valueOf(AmountStr));
                                    }
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                            }else{
                                if (strCheckBoxSelf.equals("Checked")&& mCounter==1){
                                    amount=AdultOneChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==2){
                                    amount=AdultTwoChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==3){
                                    amount=AdultThreeChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }else if (strCheckBoxSelf.equals("Checked")&& mCounter==4){
                                    amount=AdultFourChild(selectYearAdult,strSumInsured);
                                    double twoYearAmountDiscount=(((Double.parseDouble(amount)*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((Double.parseDouble(amount)*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMother.equals("Checked")){
                                    ParentsMotherAmount=ParentsMother(selectYearMotherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsAmount)+Double.parseDouble(AmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));

                                }
                                if (strCheckBoxFather.equals("Checked")){
                                    ParentsFatherAmount=ParentsFather(selectYearFatherAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxMotherLaw.equals("Checked")){
                                    ParentsMotherLawAmount=ParentsMotherInLaw(selectMotherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsMotherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }
                                if (strCheckBoxFatherLaw.equals("Checked")){
                                    ParentsFatherLawAmount=ParentsFatherInLaw(selectFatherLawAdult,strSumInsured);
                                    double addParentAmount= Double.parseDouble(ParentsFatherLawAmount)+Double.parseDouble(TotalAmountStr);
                                    double twoYearAmountDiscount=(((addParentAmount*3))*7.5)/100;
                                    double twoYearAmountCalculation= ((addParentAmount*3));
                                    twoYearAmount = twoYearAmountCalculation-twoYearAmountDiscount;
                                    CardAmount= valueOf(twoYearAmount);
                                    TotalAmountStr=CardAmount;
                                    AmountStr=CardAmount;
                                    Log.e("twoYearAmount",""+twoYearAmount);
                                    TotalPremiumSelectPlan.setText(CardAmount);
                                    TotalPremium.setText(valueOf(AmountStr));
                                }

                            }
                        }

                    }
                }
            }
        });
        oneYearSecondRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (oneYearSecondRadio.isChecked()){
                    strPolicyTenure="1";
                    oneYearSecondRadio.setChecked(true);
                    TwoYearSecondRadio.setChecked(false);
                    ThreeYearSecondRadio.setChecked(false);
                    OneYear.setChecked(false);
                    TwoYearRadio.setChecked(false);
                    ThreeYearRadio.setChecked(false);
                    LinerPackage.setVisibility(View.GONE);
                     if (PackageOne.isChecked()){
                             PackageOne.setChecked(false); }
                          if (PackageTwo.isChecked()){
                              PackageTwo.setChecked(false); }
                           if (PackageThree.isChecked()){
                               PackageThree.setChecked(false); }
                            if (PackageFour.isChecked()){
                                PackageFour.setChecked(false); }
                             if (PackageFive.isChecked()){
                                 PackageFive.setChecked(false); }
                             if (CoPaymentCheckBox.isChecked()){
                                  CoPaymentCheckBox.setChecked(false); }
                              if (TenCheckBox.isChecked()){
                                  TenCheckBox.setChecked(false);
                         } if (TwentyCheckBox.isChecked()){
                            TwentyCheckBox.setChecked(false);
                         } if (ThirtyCheckBox.isChecked()){
                            ThirtyCheckBox.setChecked(false);
                         } if (fortyCheckBox.isChecked()){
                            fortyCheckBox.setChecked(false);
                         } if (FiftyCheckBox.isChecked()){
                            FiftyCheckBox.setChecked(false);
                         }if (TieredDiscount.isChecked()){
                            TieredDiscount.setChecked(false);
                         }if (SubLimitDiscount.isChecked()){
                            SubLimitDiscount.setChecked(false);
                            LinerSubLimit.setVisibility(View.GONE);
                         }if (SubLimitADiscount.isChecked()){
                            SubLimitADiscount.setChecked(false);
                         }if (SubLimitBDiscount.isChecked()){
                            SubLimitBDiscount.setChecked(false);
                         }if (SubLimitCDiscount.isChecked()){
                            SubLimitCDiscount.setChecked(false);
                         }if (DirectPolicyDiscount.isChecked()){
                            DirectPolicyDiscount.setChecked(false);
                         }if (LoyaltyDiscount.isChecked()){
                            LoyaltyDiscount.setChecked(false);
                            LoyaltyTxt.setVisibility(View.GONE);
                         }
                    if (strSumInsured.equals("100000") || strSumInsured.equals("200000")){
                        strPlanTypeTXT="Basic";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else if (strSumInsured.equals("500000") || strSumInsured.equals("400000")|| strSumInsured.equals("300000")){
                        strPlanTypeTXT="Essential";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else if (strSumInsured.equals("600000") || strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                        strPlanTypeTXT="Privilege";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else if (strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                        strPlanTypeTXT="Plus";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                        strPlanTypeTXT="Premier";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else if (strSumInsured.equals("4000000")|| strSumInsured.equals("5000000")){
                        strPlanTypeTXT="Executive";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }else {


                    }
                }
            }
        });
        TwoYearSecondRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (TwoYearSecondRadio.isChecked()){
                    strPolicyTenure="2";
                    oneYearSecondRadio.setChecked(false);
                    TwoYearSecondRadio.setChecked(true);
                    ThreeYearSecondRadio.setChecked(false);
                    OneYear.setChecked(false);
                    TwoYearRadio.setChecked(false);
                    ThreeYearRadio.setChecked(false);
                    LinerPackage.setVisibility(View.GONE);
                     if (PackageOne.isChecked()){
                             PackageOne.setChecked(false); }
                          if (PackageTwo.isChecked()){
                              PackageTwo.setChecked(false); }
                           if (PackageThree.isChecked()){
                               PackageThree.setChecked(false); }
                            if (PackageFour.isChecked()){
                                PackageFour.setChecked(false); }
                             if (PackageFive.isChecked()){
                                 PackageFive.setChecked(false); }
                             if (CoPaymentCheckBox.isChecked()){
                                  CoPaymentCheckBox.setChecked(false); }
                              if (TenCheckBox.isChecked()){
                                  TenCheckBox.setChecked(false);
                         } if (TwentyCheckBox.isChecked()){
                            TwentyCheckBox.setChecked(false);
                         } if (ThirtyCheckBox.isChecked()){
                            ThirtyCheckBox.setChecked(false);
                         } if (fortyCheckBox.isChecked()){
                            fortyCheckBox.setChecked(false);
                         } if (FiftyCheckBox.isChecked()){
                            FiftyCheckBox.setChecked(false);
                         }if (TieredDiscount.isChecked()){
                            TieredDiscount.setChecked(false);
                         }if (SubLimitDiscount.isChecked()){
                            SubLimitDiscount.setChecked(false);
                            LinerSubLimit.setVisibility(View.GONE);
                         }if (SubLimitADiscount.isChecked()){
                            SubLimitADiscount.setChecked(false);
                         }if (SubLimitBDiscount.isChecked()){
                            SubLimitBDiscount.setChecked(false);
                         }if (SubLimitCDiscount.isChecked()){
                            SubLimitCDiscount.setChecked(false);
                         }if (DirectPolicyDiscount.isChecked()){
                            DirectPolicyDiscount.setChecked(false);
                         }if (LoyaltyDiscount.isChecked()){
                            LoyaltyDiscount.setChecked(false);
                            LoyaltyTxt.setVisibility(View.GONE);
                         }
                    if (strSumInsured.equals("100000") || strSumInsured.equals("200000")){
                        strPlanTypeTXT="Basic";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else if (strSumInsured.equals("500000") || strSumInsured.equals("400000")|| strSumInsured.equals("300000")){
                        strPlanTypeTXT="Essential";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else if (strSumInsured.equals("600000") || strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                        strPlanTypeTXT="Privilege";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else if (strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                        strPlanTypeTXT="Plus";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                        strPlanTypeTXT="Premier";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else if (strSumInsured.equals("4000000")|| strSumInsured.equals("5000000")){
                        strPlanTypeTXT="Executive";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }else {
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }

                }
            }
        });
        ThreeYearSecondRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ThreeYearSecondRadio.isChecked()){
                    strPolicyTenure="3";
                    oneYearSecondRadio.setChecked(false);
                    TwoYearSecondRadio.setChecked(false);
                    ThreeYearSecondRadio.setChecked(true);
                    OneYear.setChecked(false);
                    TwoYearRadio.setChecked(false);
                    ThreeYearRadio.setChecked(false);
                    LinerPackage.setVisibility(View.GONE);
                     if (PackageOne.isChecked()){
                             PackageOne.setChecked(false); }
                          if (PackageTwo.isChecked()){
                              PackageTwo.setChecked(false); }
                           if (PackageThree.isChecked()){
                               PackageThree.setChecked(false); }
                            if (PackageFour.isChecked()){
                                PackageFour.setChecked(false); }
                             if (PackageFive.isChecked()){
                                 PackageFive.setChecked(false); }
                             if (CoPaymentCheckBox.isChecked()){
                                  CoPaymentCheckBox.setChecked(false); }
                              if (TenCheckBox.isChecked()){
                                  TenCheckBox.setChecked(false);
                         } if (TwentyCheckBox.isChecked()){
                            TwentyCheckBox.setChecked(false);
                         } if (ThirtyCheckBox.isChecked()){
                            ThirtyCheckBox.setChecked(false);
                         } if (fortyCheckBox.isChecked()){
                            fortyCheckBox.setChecked(false);
                         } if (FiftyCheckBox.isChecked()){
                            FiftyCheckBox.setChecked(false);
                         }if (TieredDiscount.isChecked()){
                            TieredDiscount.setChecked(false);
                         }if (SubLimitDiscount.isChecked()){
                            SubLimitDiscount.setChecked(false);
                            LinerSubLimit.setVisibility(View.GONE);
                         }if (SubLimitADiscount.isChecked()){
                            SubLimitADiscount.setChecked(false);
                         }if (SubLimitBDiscount.isChecked()){
                            SubLimitBDiscount.setChecked(false);
                         }if (SubLimitCDiscount.isChecked()){
                            SubLimitCDiscount.setChecked(false);
                         }if (DirectPolicyDiscount.isChecked()){
                            DirectPolicyDiscount.setChecked(false);
                         }if (LoyaltyDiscount.isChecked()){
                            LoyaltyDiscount.setChecked(false);
                            LoyaltyTxt.setVisibility(View.GONE);
                         }
                    if (strSumInsured.equals("100000") || strSumInsured.equals("200000")){
                        strPlanTypeTXT="Basic";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else if (strSumInsured.equals("500000") || strSumInsured.equals("400000")|| strSumInsured.equals("300000")){
                        strPlanTypeTXT="Essential";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else if (strSumInsured.equals("600000") || strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                        strPlanTypeTXT="Privilege";
                        strPlanTypeTXT2="Digi-Pro";
                        relativeSecond.setVisibility(View.VISIBLE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        PlanTypeTXT2.setText(strPlanTypeTXT2);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        SumInsuredDiGiProTxt.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else if (strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                        strPlanTypeTXT="Plus";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);


                    }
                    else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                        strPlanTypeTXT="Premier";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);


                    }
                    else if (strSumInsured.equals("4000000")|| strSumInsured.equals("5000000")){
                        strPlanTypeTXT="Executive";
                        strPlanTypeTXT2="";
                        relativeSecond.setVisibility(View.GONE);
                        PlanTypeTXT.setText(strPlanTypeTXT);
                        SumInsuredSelectPlan.setText(strSumInsured);
                        PlanType=strPlanTypeTXT2;
                        GetCalculatedData(valueOf(selectYearAdult),strSumInsured);

                    }
                    else {


                    }
                }
            }
        });
        checkBoxLoyaltyDiscount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBoxLoyaltyDiscount.isChecked()){
                    LoyaltyDiscountStatus="True";
                    Toast.makeText(OfflineCHIAddOns.this, "Please Enter Policy Number", Toast.LENGTH_SHORT).show();
                }else{
                    LoyaltyDiscountStatus="False";
                }
            }
        });
        CoPaymentCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CoPaymentCheckBox.isChecked()){
                    CoPaymentCheckBox.setChecked(true);
                    CoPaymentStatus="True";
                    CoPaymentLiner.setVisibility(View.VISIBLE);
                    None.setChecked(false);
                }else{
                    CoPaymentCheckBox.setChecked(true);
                    CoPaymentStatus="False";
                    CoPaymentLiner.setVisibility(View.VISIBLE);
                    TenCheckBox.setChecked(false);
                    TwentyCheckBox.setChecked(false);
                    ThirtyCheckBox.setChecked(false);
                    fortyCheckBox.setChecked(false);
                    FiftyCheckBox.setChecked(false);
                }
            }
        });
        TenCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (TenCheckBox.isChecked()){
                    CoPaymentLoading="10";
                    double Copay= (coPaymentValueAdd);
                    Log.e("Copay", valueOf(Copay));
                    double str= Double.parseDouble(TotalAmountStr);
                    Log.e("str", valueOf(str));
                    double FinalAmount = (str-Copay);
                    CoPaymentDiscount=FinalAmount*.1;
                    newAmountStr= Double.parseDouble(TotalAmountStr)-CoPaymentDiscount;
                    AmountStr= valueOf(Math.round(newAmountStr * 100.0) / 100.0);
                    TotalPremiumSelectPlan.setText(CardAmount);
                    TotalPremium.setText(AmountStr);
                     FiftyCheckBox.setChecked(false);
                    fortyCheckBox.setChecked(false);
                    ThirtyCheckBox.setChecked(false);
                    TwentyCheckBox.setChecked(false);
                    TenCheckBox.setChecked(true);
                    None.setChecked(false);
                   DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt+SubLimitDiscountAmt1;
                }
            }
        });
        TwentyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (TwentyCheckBox.isChecked()){
                    CoPaymentLoading="20";
                    double Copay= (coPaymentValueAdd);
                    Log.e("Copay", valueOf(Copay));
                    double str= Double.parseDouble(TotalAmountStr);
                    Log.e("str", valueOf(str));
                    double FinalAmount = (str-Copay);
                    CoPaymentDiscount=FinalAmount*.2;
                     newAmountStr= Double.parseDouble(TotalAmountStr)-CoPaymentDiscount;
                    AmountStr= valueOf(Math.round(newAmountStr * 100.0) / 100.0);
                    TotalPremiumSelectPlan.setText(CardAmount);
                    TotalPremium.setText(AmountStr);
                    FiftyCheckBox.setChecked(false);
                    fortyCheckBox.setChecked(false);
                    ThirtyCheckBox.setChecked(false);
                    TwentyCheckBox.setChecked(true);
                    TenCheckBox.setChecked(false);
                    None.setChecked(false);
                    DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt+SubLimitDiscountAmt1;
                }
            }
        });
        ThirtyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ThirtyCheckBox.isChecked()){
                    CoPaymentLoading="30";
                    double Copay= (coPaymentValueAdd);
                    Log.e("Copay", valueOf(Copay));
                    double str= Double.parseDouble(TotalAmountStr);
                    Log.e("str", valueOf(str));
                    double FinalAmount = (str-Copay);
                    CoPaymentDiscount=FinalAmount*.3;
                     newAmountStr= Double.parseDouble(TotalAmountStr)-CoPaymentDiscount;
                    AmountStr= valueOf(Math.round(newAmountStr * 100.0) / 100.0);
                    TotalPremiumSelectPlan.setText(CardAmount);
                    TotalPremium.setText(AmountStr);
                    FiftyCheckBox.setChecked(false);
                    fortyCheckBox.setChecked(false);
                    ThirtyCheckBox.setChecked(true);
                    TwentyCheckBox.setChecked(false);
                    TenCheckBox.setChecked(false);
                    None.setChecked(false);
                    DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt+SubLimitDiscountAmt1;
                }
            }
        });
        fortyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (fortyCheckBox.isChecked()){
                    CoPaymentLoading="40";
                    double Copay= (coPaymentValueAdd);
                    Log.e("Copay", valueOf(Copay));
                    double str= Double.parseDouble(TotalAmountStr);
                    Log.e("str", valueOf(str));
                    double FinalAmount = (str-Copay);
                    CoPaymentDiscount=FinalAmount*.4;
                     newAmountStr= Double.parseDouble(TotalAmountStr)-CoPaymentDiscount;
                    AmountStr= valueOf(Math.round(newAmountStr * 100.0) / 100.0);
                    TotalPremiumSelectPlan.setText(CardAmount);
                    TotalPremium.setText(AmountStr);
                    FiftyCheckBox.setChecked(false);
                    fortyCheckBox.setChecked(true);
                    ThirtyCheckBox.setChecked(false);
                    TwentyCheckBox.setChecked(false);
                    TenCheckBox.setChecked(false);
                    None.setChecked(false);
                    DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt+SubLimitDiscountAmt1;
                }
            }
        });
        FiftyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (FiftyCheckBox.isChecked()){
                    CoPaymentLoading="50";
                    double Copay= (coPaymentValueAdd);
                    Log.e("Copay", valueOf(Copay));
                    double str= Double.parseDouble(TotalAmountStr);
                    Log.e("str", valueOf(str));
                    double FinalAmount = (str-Copay);
                    CoPaymentDiscount=FinalAmount*.5;
                     newAmountStr= Double.parseDouble(TotalAmountStr)-CoPaymentDiscount;
                    AmountStr= valueOf(Math.round(newAmountStr * 100.0) / 100.0);
                    TotalPremiumSelectPlan.setText(CardAmount);
                    TotalPremium.setText(AmountStr);
                    FiftyCheckBox.setChecked(true);
                    fortyCheckBox.setChecked(false);
                    ThirtyCheckBox.setChecked(false);
                    TwentyCheckBox.setChecked(false);
                    TenCheckBox.setChecked(false);
                    None.setChecked(false);
                    DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt+SubLimitDiscountAmt1;
                }
            }
        });
        TieredDiscount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (TieredDiscount.isChecked()){
                    TieredDiscount.setChecked(true);
                    TieredDiscountAmt=(Double.parseDouble(AmountStr))*.05;
                     TieredDiscountAmt1=(Double.parseDouble(AmountStr))-TieredDiscountAmt;
                    AmountStr= valueOf(Math.round(TieredDiscountAmt1 * 100.0) / 100.0);
//                    TotalAmountStr=AmountStr;
                    TotalPremiumSelectPlan.setText(CardAmount);
                    TotalPremium.setText(AmountStr);
                    DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt1+SubLimitDiscountAmt1;
                    None.setChecked(false);
                }else{
//                    TieredDiscountAmt=(Double.parseDouble(AmountStr))*.05;
//                    TieredDiscountAmt1=(Double.parseDouble(AmountStr))+TieredDiscountAmt;
//                    AmountStr=String.valueOf(Math.round(TieredDiscountAmt1 * 100.0) / 100.0);
////                    AmountStr=TotalAmountStr;
//                    TotalPremiumSelectPlan.setText(CardAmount);
//                    TotalPremium.setText(AmountStr);
//                    DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt1+SubLimitDiscountAmt1;
                }
            }
        });
        DirectPolicyDiscount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (DirectPolicyDiscount.isChecked()){
                      DirectPolicyDiscount.setChecked(true);
                      DirectDiscountAmt=(Double.parseDouble(AmountStr))*.15;
                       DirectDiscountAmt1=(Double.parseDouble(AmountStr))-DirectDiscountAmt;
                      AmountStr= valueOf(Math.round(DirectDiscountAmt1 * 100.0) / 100.0);
//                      TotalAmountStr=AmountStr;
                      TotalPremiumSelectPlan.setText(CardAmount);
                      TotalPremium.setText(AmountStr);
                      DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt1+SubLimitDiscountAmt1;
                      None.setChecked(false);
                  }
              }
          });
        LoyaltyDiscount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (LoyaltyDiscount.isChecked()){
                      LoyaltyDiscount.setChecked(true);
                      LoyaltyTxt.setVisibility(View.VISIBLE);
                      LoyaltyDiscountAmt= (Double.parseDouble(AmountStr))*.05;
                      LoyaltyDiscountAmt1=(Double.parseDouble(AmountStr))-LoyaltyDiscountAmt;
                      AmountStr= valueOf(Math.round(LoyaltyDiscountAmt1 * 100.0) / 100.0);
//                      TotalAmountStr=AmountStr;
                      TotalPremiumSelectPlan.setText(CardAmount);
                      TotalPremium.setText(AmountStr);
                      None.setChecked(false);
                      DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt1+SubLimitDiscountAmt1;
                  }
              }
          });
        SubLimitDiscount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (SubLimitDiscount.isChecked()){
                      LinerSubLimit.setVisibility(View.VISIBLE);
                      SubLimitDiscount.setChecked(true);
                      None.setChecked(false);
                  }
              }
          });
        SubLimitADiscount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (SubLimitADiscount.isChecked()){
                      SubLimitADiscount.setChecked(true);
                      SubLimitBDiscount.setChecked(false);
                      SubLimitCDiscount.setChecked(false);
                      if (strSumInsured.equals("100000") || strSumInsured.equals("200000")){
                          SubLimitDiscountAmt=(Double.parseDouble(AmountStr))*.075;
                           SubLimitDiscountAmt1=(Double.parseDouble(AmountStr))-SubLimitDiscountAmt;
                          AmountStr= valueOf(Math.round(SubLimitDiscountAmt1 * 100.0) / 100.0);
//                          TotalAmountStr=AmountStr;
                          TotalPremiumSelectPlan.setText(CardAmount);
                          TotalPremium.setText(AmountStr);
                          DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt1+SubLimitDiscountAmt1;
                      }else if (strSumInsured.equals("300000")|| strSumInsured.equals("400000")|| strSumInsured.equals("500000")||strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")||strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")||strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                          SubLimitDiscountAmt=(Double.parseDouble(AmountStr))*.1;
                           SubLimitDiscountAmt1=(Double.parseDouble(AmountStr))-SubLimitDiscountAmt;
                          AmountStr= valueOf(Math.round(SubLimitDiscountAmt1 * 100.0) / 100.0);
//                          TotalAmountStr=AmountStr;
                          TotalPremiumSelectPlan.setText(CardAmount);
                          TotalPremium.setText(AmountStr);
                          DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt1+SubLimitDiscountAmt1;
                      }
                  }
              }
          });
        SubLimitBDiscount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (SubLimitBDiscount.isChecked()){
                      SubLimitADiscount.setChecked(false);
                      SubLimitBDiscount.setChecked(true);
                      SubLimitCDiscount.setChecked(false);
                      if (strSumInsured.equals("100000") || strSumInsured.equals("200000")){
                          SubLimitDiscountAmt=(Double.parseDouble(AmountStr))*.05;
                           SubLimitDiscountAmt1=(Double.parseDouble(AmountStr))-SubLimitDiscountAmt;
                          AmountStr= valueOf(Math.round(SubLimitDiscountAmt1 * 100.0) / 100.0);
//                          TotalAmountStr=AmountStr;
                          TotalPremiumSelectPlan.setText(CardAmount);
                          TotalPremium.setText(AmountStr);
                          DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt1+SubLimitDiscountAmt1;
                      }else if (strSumInsured.equals("300000")|| strSumInsured.equals("400000")|| strSumInsured.equals("500000")||strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")||strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")||strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                          SubLimitDiscountAmt=(Double.parseDouble(AmountStr))*.075;
                          double SubLimitDiscountAmt1=(Double.parseDouble(AmountStr))-SubLimitDiscountAmt;
                          AmountStr= valueOf(Math.round(SubLimitDiscountAmt1 * 100.0) / 100.0);
//                          TotalAmountStr=AmountStr;
                          TotalPremiumSelectPlan.setText(CardAmount);
                          TotalPremium.setText(AmountStr);
                          DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt1+SubLimitDiscountAmt1;
                      }
                  }
              }
          });
        SubLimitCDiscount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (SubLimitBDiscount.isChecked()){
                      SubLimitADiscount.setChecked(false);
                      SubLimitBDiscount.setChecked(false);
                      SubLimitCDiscount.setChecked(true);
                      if (strSumInsured.equals("100000") || strSumInsured.equals("200000")){
                          Toast.makeText(OfflineCHIAddOns.this, "Not Applicable", Toast.LENGTH_SHORT).show();
                      }else if (strSumInsured.equals("300000")|| strSumInsured.equals("400000")|| strSumInsured.equals("500000")||strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")||strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")||strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                          SubLimitDiscountAmt=(Double.parseDouble(AmountStr))*.05;
                           SubLimitDiscountAmt1=(Double.parseDouble(AmountStr))-SubLimitDiscountAmt;
                          AmountStr= valueOf(Math.round(SubLimitDiscountAmt1 * 100.0) / 100.0);
//                          TotalAmountStr=AmountStr;
                          TotalPremiumSelectPlan.setText(CardAmount);
                          TotalPremium.setText(AmountStr);
                          DiscountTotal= newAmountStr+TieredDiscountAmt1+DirectDiscountAmt1+LoyaltyDiscountAmt1+SubLimitDiscountAmt1;
                      }
                  }
              }
          });
        None.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (None.isChecked()){
                      CoPaymentCheckBox.setChecked(false);
                      CoPaymentLiner.setVisibility(View.VISIBLE);
                      TenCheckBox.setChecked(false);
                      TwentyCheckBox.setChecked(false);
                      ThirtyCheckBox.setChecked(false);
                      fortyCheckBox.setChecked(false);
                      FiftyCheckBox.setChecked(false);
                      TieredDiscount.setChecked(false);
                      DirectPolicyDiscount.setChecked(false);
                      LoyaltyDiscount.setChecked(false);
                      LinerSubLimit.setVisibility(View.GONE);
                      SubLimitDiscount.setChecked(false);
                      LinerSubLimit.setVisibility(View.GONE);
                      SubLimitADiscount.setChecked(false);
                      SubLimitBDiscount.setChecked(false);
                      SubLimitCDiscount.setChecked(false);
                      AmountStr=TotalAmountStr;
                      TotalPremiumSelectPlan.setText(CardAmount);
                      TotalPremium.setText(AmountStr);
                      DiscountTotal=0.00;
                  }

              }
          });
        PolicyNumber.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_refer(PolicyNumber); // pass your EditText Obj here.
            }

            public void Is_Valid_refer(EditText edt_refer) {
                if (edt_refer.length()== 20) {
                    strPolicyNumber = edt_refer.getText().toString();
                    if (!edt_refer.getText().toString().contains("/")){
                        Toast.makeText(OfflineCHIAddOns.this, "Please Enter Existing Policy Number", Toast.LENGTH_SHORT).show();
                    }else{


                    }
                } else  if (edt_refer.getText().toString().equals("")) {
                    Toast.makeText(OfflineCHIAddOns.this, "Please Enter Existing Policy Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OfflineCHIAddOns.this, OfflineCalculatorSummery.class);
                intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                intent.putExtra("strSelfAgeEditText",strSelfAgeEditText);
                intent.putExtra("strGenderSpinner",strGenderSpinner);
                intent.putExtra("strCheckBoxSpouse",strCheckBoxSpouse);
                intent.putExtra("strSpouseAgeEditText",strSpouseAgeEditText);
                intent.putExtra("strCheckBoxMother",strCheckBoxMother);
                intent.putExtra("strMotherAgeEditText",strMotherAgeEditText);
                intent.putExtra("strFatherAgeEditText",strFatherAgeEditText);
                intent.putExtra("strCheckBoxFather",strCheckBoxFather);
                intent.putExtra("strCheckBoxMotherLaw",strCheckBoxMotherLaw);
                intent.putExtra("strMotherLawAgeEditText",strMotherLawAgeEditText);
                intent.putExtra("strCheckBoxFatherLaw",strCheckBoxFatherLaw);
                intent.putExtra("strFatherLawAgeEditText",strFatherLawAgeEditText);
                intent.putExtra("strFirstSonAgeEditText",strFirstSonAgeEditText);
                intent.putExtra("strSecondSonAgeEditText",strSecondSonAgeEditText);
                intent.putExtra("strThirdSonAgeEditText",strThirdSonAgeEditText);
                intent.putExtra("strFourSonAgeEditText",strFourSonAgeEditText);
                intent.putExtra("strCheckBoxSon",strCheckBoxSon);
                intent.putExtra("mCounter",mCounter);
                intent.putExtra("strTotalPremium",strTotalPremium);
                intent.putExtra("PosPolicyNo",PosPolicyNo);
                intent.putExtra("strSumInsured",strSumInsured);
                intent.putExtra("strPlanTypeTXT",strPlanTypeTXT);
                intent.putExtra("NetPremium",NetPremium);
                intent.putExtra("strPolicyTenure",strPolicyTenure);
                intent.putExtra("PlanType",PlanType);
                intent.putExtra("BasicStatus",BasicStatus);
                intent.putExtra("PersonalStatus",PersonalStatus);
                intent.putExtra("CriticalStatus",CriticalStatus);
                intent.putExtra("DailyHospitalSatus",DailyHospitalSatus);
                intent.putExtra("ModernTreatmentsStatus",ModernTreatmentsStatus);
                intent.putExtra("ExtensionPreHospitalization",ExtensionPreHospitalization);
                intent.putExtra("ExtensionPr0Hospitalization",ExtensionPr0Hospitalization);
                intent.putExtra("MaternityAndChildcare",MaternityAndChildcare);
                intent.putExtra("CoverageNonMedical",CoverageNonMedical);
                intent.putExtra("ConditionWaiverStatus",ConditionWaiverStatus);
                intent.putExtra("PersonalAccidentACoverStatus",PersonalAccidentACoverStatus);
                intent.putExtra("PersonalAccidentBCoverStatus",PersonalAccidentBCoverStatus);
                intent.putExtra("PreExistingDiseaseStatus",PreExistingDiseaseStatus);
                intent.putExtra("OutpatientDentalStatus",OutpatientDentalStatus);
                intent.putExtra("SecondOpinionStatus",SecondOpinionStatus);
                intent.putExtra("RestCureStatus",RestCureStatus);
                intent.putExtra("ObesityWeightStatus",ObesityWeightStatus);
                intent.putExtra("SterilityInfertilityStatus",SterilityInfertilityStatus);
                intent.putExtra("EnhancedOrganStatus",EnhancedOrganStatus);
                intent.putExtra("GlobalCoverStatus",GlobalCoverStatus);
                intent.putExtra("MedicallyAdvisedStatus",MedicallyAdvisedStatus);
                intent.putExtra("EmergencyAssistanceStatus",EmergencyAssistanceStatus);
                intent.putExtra("HomeCareStatus",HomeCareStatus);
                intent.putExtra("WellnessBenefitStatus",WellnessBenefitStatus);
                intent.putExtra("DiseaseManagementStatus",DiseaseManagementStatus);
                intent.putExtra("LoyaltyDiscountStatus",LoyaltyDiscountStatus);
                intent.putExtra("CoPaymentStatus",CoPaymentStatus);
                intent.putExtra("strPolicyNumber",strPolicyNumber);
                intent.putExtra("CoPaymentLoading",CoPaymentLoading);
                intent.putExtra("EmergencyTravellingStatus",EmergencyTravellingStatus);
                intent.putExtra("PremiumWaiverStatus",PremiumWaiverStatus);
                intent.putExtra("addons",addons);
                intent.putExtra("DiscountTotal",DiscountTotal);
                intent.putExtra("AmountStr",AmountStr);
                intent.putExtra("strGenderEditSpinner",strGenderEditSpinner);
                intent.putExtra("selectYearAdult", selectYearAdult);
                intent.putExtra("dailyCheckBoxClick", dailyCheckBoxClick);
                intent.putExtra("GlobalCoverCoverPremium", GlobalCoverCoverPremium);
                intent.putExtra("MaternityChildcareCoverPremium", MaternityChildcareCoverPremium);
                intent.putExtra("ExtensionPreHospitalizationCoverPremium", ExtensionPreHospitalizationCoverPremium);
                intent.putExtra("ExtensionProHospitalizationCoverPremium", ExtensionProHospitalizationCoverPremium);
                intent.putExtra("ModernTreatmentCoverPremium", ModernTreatmentCoverPremium);
                intent.putExtra("PremiumWaiverCoverPremium", PremiumWaiverCoverPremium);
                intent.putExtra("PreExistingDiseaseCoverPremium", PreExistingDiseaseCoverPremium);
                intent.putExtra("ConditionWaiverCoverPremium", ConditionWaiverCoverPremium);
                intent.putExtra("OutpatientDentalCoverPremium", OutpatientDentalCoverPremium);
                intent.putExtra("RestCureCoverPremium", RestCureCoverPremium);
                intent.putExtra("HomeCareCoverPremium", HomeCareCoverPremium);
                intent.putExtra("WellnessBenefitCoverPremium", WellnessBenefitCoverPremium);
                intent.putExtra("SterilityInfertilityCoverPremium", SterilityInfertilityCoverPremium);
                intent.putExtra("ObesityWeightCoverPremium", ObesityWeightCoverPremium);
                intent.putExtra("SecondOpinionCoverPremium", SecondOpinionCoverPremium);
                intent.putExtra("EmergencyTravellingCoverPremium", EmergencyTravellingCoverPremium);
                intent.putExtra("DailyHospitalCoverPremium", DailyHospitalCoverPremium);
                intent.putExtra("CriticalIllnessCoverPremium", CriticalIllnessCoverPremium);
                intent.putExtra("MedicallyAdvisedCoverPremium", MedicallyAdvisedCoverPremium);
                intent.putExtra("EnhancedCoverPremium", EnhancedCoverPremium);
                intent.putExtra("strPersonalPremiumA", strPersonalPremiumA);
                intent.putExtra("strPersonalBPremiumTxt", strPersonalBPremiumTxt);
                intent.putExtra("EmergencyAssistanceCoverPremium", EmergencyAssistanceCoverPremium);
                intent.putExtra("DiseaseManagementCoverPremium", DiseaseManagementCoverPremium);
                intent.putExtra("CoverageNonMedicalCoverPremium", CoverageNonMedicalCoverPremium);
                intent.putExtra("MaternityChildcareCoverPremium", MaternityChildcareCoverPremium);
                intent.putExtra("CheckBoxPersonalCoverAStatus", CheckBoxPersonalCoverAStatus);
                intent.putExtra("strFor","0");
                startActivity(intent);
                finish();
            }
        });

        PackageValue();


         SelectAddOnsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(OfflineCHIAddOns.this,R.style.BottomSheetTheme);
                View viewBottomSheet= LayoutInflater.from(OfflineCHIAddOns.this).inflate(R.layout.chi_bottom_addons,null);
                bottomSheetDialog.setContentView(viewBottomSheet);
                bottomSheetDialog.setCanceledOnTouchOutside(false);

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
                if (GlobalCoverCoverPremium.equals("0.00")||GlobalCoverCoverPremium.equals("")){
                    GlobalLiner.setVisibility(View.GONE);
                    GlobalCoverCoverPremium="0.0";
                }else {
                    GlobalLiner.setVisibility(View.VISIBLE);

                }

                if (SterilityInfertilityCoverPremium.equals("0.0")||SterilityInfertilityCoverPremium.equals("")){
                    SterilityLiner.setVisibility(View.GONE);
                }else{
                    SterilityLiner.setVisibility(View.VISIBLE);
                }


                if (dailyCheckBoxClick.equals("True")){
                    CheckBoxDailyCash.setChecked(true);
                }else{
                    CheckBoxDailyCash.setChecked(false);
                }
                if (CriticalStatus.equals("True")){
                    CheckBoxCriticalIllnes.setChecked(true);
                }else{
                    CheckBoxCriticalIllnes.setChecked(false);
                }
                if (ExtensionPreHospitalization.equals("True")){
                    CheckBoxPreHospitalization.setChecked(true);
                }else{
                    CheckBoxPreHospitalization.setChecked(false);
                }
                if (ExtensionPr0Hospitalization.equals("True")){
                    CheckBoxProHospitalization.setChecked(true);
                }else{
                    CheckBoxProHospitalization.setChecked(false);
                }

                if (MaternityAndChildcare.equals("True")){
                    CheckBoxMaternityChildcare.setChecked(true);
                }else{
                    CheckBoxMaternityChildcare.setChecked(false);
                }

                if (CoverageNonMedical.equals("True")){
                    CheckBoxCoverageNonMedical.setChecked(true);
                }else{
                    CheckBoxCoverageNonMedical.setChecked(false);
                }
                if (ConditionWaiverStatus.equals("True")){
                    CheckBoxConditionWaiver.setChecked(true);
                }else{
                    CheckBoxConditionWaiver.setChecked(false);
                }
                if (PreExistingDiseaseStatus.equals("True")){
                    CheckBoxPreExistingDisease.setChecked(true);
                }else{
                    CheckBoxPreExistingDisease.setChecked(false);
                }
                if (OutpatientDentalStatus.equals("True")){
                    CheckBoxOutpatientDental.setChecked(true);
                }else{
                    CheckBoxOutpatientDental.setChecked(false);
                }

                if (EmergencyTravellingStatus.equals("True")){
                    CheckBoxEmergencyTravelling.setChecked(true);
                }else{
                    CheckBoxEmergencyTravelling.setChecked(false);
                }

                if (SecondOpinionStatus.equals("True")){
                    CheckBoxSecondOpinion.setChecked(true);
                }else{
                    CheckBoxSecondOpinion.setChecked(false);
                }

                if (RestCureStatus.equals("True")){
                    CheckBoxRestCure.setChecked(true);
                }else{
                    CheckBoxRestCure.setChecked(false);
                }

                if (ObesityWeightStatus.equals("True")){
                    CheckBoxObesityWeight.setChecked(true);
                }else{
                    CheckBoxObesityWeight.setChecked(false);
                }

                if (SterilityInfertilityStatus.equals("True")){
                    CheckBoxSterilityInfertility.setChecked(true);
                }else{
                    CheckBoxSterilityInfertility.setChecked(false);
                }

                if (EnhancedOrganStatus.equals("True")){
                    CheckBoxEnhancedOrgan.setChecked(true);
                }else{
                    CheckBoxEnhancedOrgan.setChecked(false);
                }
                if (MedicallyAdvisedStatus.equals("True")){
                    CheckBoxMedicallyAdvised.setChecked(true);
                }else{
                    CheckBoxMedicallyAdvised.setChecked(false);
                }
                if (EmergencyAssistanceStatus.equals("True")){
                    CheckBoxEmergencyAssistance.setChecked(true);
                }else{
                    CheckBoxEmergencyAssistance.setChecked(false);
                }

                if (HomeCareStatus.equals("True")){
                    CheckBoxHomeCare.setChecked(true);
                }else{
                    CheckBoxHomeCare.setChecked(false);
                }
                if (WellnessBenefitStatus.equals("True")){
                    CheckBoxWellnessBenefit.setChecked(true);
                }else{
                    CheckBoxWellnessBenefit.setChecked(false);
                }

                if (DiseaseManagementStatus.equals("True")){
                    CheckBoxDiseaseManagement.setChecked(true);
                }else{
                    CheckBoxDiseaseManagement.setChecked(false);
                }
                if (GlobalCoverStatus.equals("True")){
                    CheckBoxGlobalCover.setChecked(true);
                }else{
                    CheckBoxGlobalCover.setChecked(false);
                }
                if (ModernTreatmentsStatus.equals("True")){
                    CheckBoxModernTreatments.setChecked(true);
                }else{
                    CheckBoxModernTreatments.setChecked(false);
                }

                if (PremiumWaiverStatus.equals("True")){
                    CheckBoxPremiumWaiver.setChecked(true);
                }else{
                    CheckBoxPremiumWaiver.setChecked(false);
                }
                if (CheckBoxPersonalCoverAStatus.equals("True")){
                    CheckBoxPersonalCoverA.setChecked(true);
                }else{
                    CheckBoxPersonalCoverA.setChecked(false);
                }
                if (CheckBoxPersonalCoverAStatus.equals("True")){
                    CheckBoxPersonalCoverB.setChecked(true);
                }else{
                    CheckBoxPersonalCoverB.setChecked(false);
                }

                PreHospitalizationPremiumTxt.setText(ExtensionPreHospitalizationCoverPremium);
                ProHospitalizationPremiumTxt.setText(ExtensionProHospitalizationCoverPremium);
                ModernTreatmentsPremiumTxt.setText(ModernTreatmentCoverPremium);
                PremiumWaiverPremiumTxt.setText(PremiumWaiverCoverPremium);
                PreexistingDiseasePremiumTxt.setText(PreExistingDiseaseCoverPremium);
                ConditionPremiumTxt.setText(ConditionWaiverCoverPremium);
                PersonalAPremiumTxt.setText(strPersonalPremiumA);
                PersonalBPremiumTxt.setText(strPersonalBPremiumTxt);
                EmergencyAssistancePremiumTxt.setText(EmergencyAssistanceCoverPremium);
                DiseaseManagementPremiumTxt.setText(DiseaseManagementCoverPremium);
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
                NoMedicalPremiumTxt.setText(CoverageNonMedicalCoverPremium);
                GlobalCoverPremiumTxt.setText(GlobalCoverCoverPremium);
                if (strGenderEditSpinner.equals("Female")){
                    if (selectYearAdult >= 18 && (selectYearAdult <= 45)) {
                        if (strSumInsured.equals("100000") || strSumInsured.equals("200000")){
                            MaternityChildcareCoverPremium="0.0";
                            MaternityChildcarePremiumTxt.setText(MaternityChildcareCoverPremium);
                        }else{
                            if (strSumInsured.equals("300000")|| strSumInsured.equals("400000")|| strSumInsured.equals("500000")){
                                MaternityChildcareCoverPremium="400";
                                MaternityChildcarePremiumTxt.setText(MaternityChildcareCoverPremium);
                            }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                                MaternityChildcareCoverPremium="720";
                                MaternityChildcarePremiumTxt.setText(MaternityChildcareCoverPremium);
                            }else if (strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                                MaternityChildcareCoverPremium="1100";
                                MaternityChildcarePremiumTxt.setText(MaternityChildcareCoverPremium);
                            }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                                MaternityChildcareCoverPremium="1550";
                                MaternityChildcarePremiumTxt.setText(MaternityChildcareCoverPremium);
                            }else if (strSumInsured.equals("4000000")){
                                MaternityChildcareCoverPremium="2000";
                                MaternityChildcarePremiumTxt.setText(MaternityChildcareCoverPremium);
                            }else if (strSumInsured.equals("5000000")){
                                MaternityChildcareCoverPremium="3800";
                                MaternityChildcarePremiumTxt.setText(MaternityChildcareCoverPremium);
                            }else{
                                MaternityChildcareCoverPremium="0.0";
                                MaternityChildcarePremiumTxt.setText(MaternityChildcareCoverPremium);
                            }
                        }
                    }
                    else{
                        LinerMaternity.setVisibility(View.GONE);
                        MaternityChildcareCoverPremium="0.0";
                        MaternityChildcarePremiumTxt.setText(MaternityChildcareCoverPremium);
                    }
                }else{
                    LinerMaternity.setVisibility(View.GONE);
                }
                       if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                            PersonalCoverBLiner.setVisibility(View.GONE);
                        }else{
                            double strDoublePersonalPremiumB=(0.63/1000*(Double.parseDouble(AmountStr)))*6;
                            double roundDbl1 = Math.round(strDoublePersonalPremiumB*100.0)/100.0;
                            strPersonalBPremiumTxt= valueOf(roundDbl1);
                        }
                CheckBoxDailyCash.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxDailyCash.isChecked()){
                            CountScroll++;
                            dailyCheckBoxClick="True";
                             doubleDailyHospitalCoverPremium=Double.parseDouble(DailyHospitalCoverPremium);
                            double DoubleCheck= doubleDailyHospitalCoverPremium+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            DailyHospitalLiner.setVisibility(View.VISIBLE);
                            coPaymentValueAdd=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doublePremiumWaiverCoverPremium+doubleWellnessBenefitCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleDiseaseManagementCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB;
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            dailyCheckBoxClick="False";
                            doubleDailyHospitalCoverPremium=Double.parseDouble(DailyHospitalCoverPremium);
                            double DoubleCheck= Double.parseDouble(AmountStr)-doubleDailyHospitalCoverPremium;
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            DailyHospitalLiner.setVisibility(View.GONE);
                        }
                    }
                });
                CheckBoxCriticalIllnes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxCriticalIllnes.isChecked()){
                            CountScroll++;
                            CriticalStatus="True";
                            doubleCriticalIllnessCoverPremium=Double.parseDouble(CriticalIllnessCoverPremium);

                            double DoubleCheck= Double.parseDouble(CriticalIllnessCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            CriticalIllnessLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                            coPaymentValueAdd=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doublePremiumWaiverCoverPremium+doubleWellnessBenefitCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleDiseaseManagementCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB;

                        }else {
                            CriticalStatus="False";
                            CountScroll--;
                            doubleCriticalIllnessCoverPremium=Double.parseDouble(CriticalIllnessCoverPremium);
                            double DoubleCheck= Double.parseDouble(AmountStr)-Double.parseDouble(CriticalIllnessCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            CriticalIllnessLiner.setVisibility(View.GONE);
                        }
                    }
                });
                CheckBoxPreHospitalization.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxPreHospitalization.isChecked()){
                            CountScroll++;
                            ExtensionPreHospitalization="True";
                            doubleExtensionPreHospitalizationCoverPremium=Double.parseDouble(ExtensionPreHospitalizationCoverPremium);
                            double DoubleCheck= Double.parseDouble(ExtensionPreHospitalizationCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            ExtensionPreLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            ExtensionPreHospitalization="False";
                            double DoubleCheck= Double.parseDouble(AmountStr)-Double.parseDouble(ExtensionPreHospitalizationCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            ExtensionPreLiner.setVisibility(View.GONE);
                        }
                    }
                });
                CheckBoxProHospitalization.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxProHospitalization.isChecked()){
                            CountScroll++;
                            ExtensionPr0Hospitalization="True";
                            doubleExtensionProHospitalizationCoverPremium=Double.parseDouble(ExtensionProHospitalizationCoverPremium);
                            double DoubleCheck= Double.parseDouble(ExtensionProHospitalizationCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            ExtensionPostLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            ExtensionPr0Hospitalization="False";
                            double DoubleCheck= Double.parseDouble(AmountStr)-Double.parseDouble(ExtensionProHospitalizationCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            ExtensionPostLiner.setVisibility(View.GONE);
                        }


                    }
                });
                CheckBoxPersonalCoverA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxPersonalCoverA.isChecked()){
                            CheckBoxPersonalCoverAStatus="True";
                            CountScroll++;
                            doublePersonalPremiumA=Double.parseDouble(strPersonalPremiumA);
                            double DoubleCheck= Double.parseDouble(strPersonalPremiumA)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                            coPaymentValueAdd=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doublePremiumWaiverCoverPremium+doubleWellnessBenefitCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleDiseaseManagementCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB;

                        }else {
                            CountScroll--;
                            CheckBoxPersonalCoverAStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(strPersonalPremiumA);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                        }


                    }
                });
                CheckBoxPersonalCoverB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxPersonalCoverB.isChecked()){
                            CheckBoxPersonalCoverBStatus="True";
                            CountScroll++;
                            doublePersonalPremiumB=Double.parseDouble(strPersonalBPremiumTxt);
                            double DoubleCheck= Double.parseDouble(strPersonalBPremiumTxt)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                            coPaymentValueAdd=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doublePremiumWaiverCoverPremium+doubleWellnessBenefitCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleDiseaseManagementCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB;

                        }else {
                            CountScroll--;
                            CheckBoxPersonalCoverBStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(strPersonalBPremiumTxt);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                        }


                    }
                });
                CheckBoxMaternityChildcare.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxMaternityChildcare.isChecked()){
                            MaternityAndChildcare="True";
                            CountScroll++;
                            doubleMaternityChildcareCoverPremium=Double.parseDouble(MaternityChildcareCoverPremium);
                            double DoubleCheck= Double.parseDouble(MaternityChildcareCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            MaternityLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            MaternityAndChildcare="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(MaternityChildcareCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            MaternityLiner.setVisibility(View.GONE);
                        }


                    }
                });
                CheckBoxCoverageNonMedical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxCoverageNonMedical.isChecked()){
                            CountScroll++;
                            CoverageNonMedical="True";
                            doubleCoverageNonMedicalCoverPremium=Double.parseDouble(CoverageNonMedicalCoverPremium);
                            double DoubleCheck= Double.parseDouble(CoverageNonMedicalCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            CoverageLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            CoverageNonMedical="False";
                            double DoubleCheck= Double.parseDouble(AmountStr)-Double.parseDouble(CoverageNonMedicalCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            CoverageLiner.setVisibility(View.GONE);
                        }


                    }
                });
                CheckBoxConditionWaiver.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxConditionWaiver.isChecked()){
                            CountScroll++;
                            ConditionWaiverStatus="True";
                           doubleConditionWaiverCoverPremium=Double.parseDouble(ConditionWaiverCoverPremium);
                            double DoubleCheck= Double.parseDouble(ConditionWaiverCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            ConditionWaiverLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            ConditionWaiverStatus="False";
                            double DoubleCheck= Double.parseDouble(AmountStr)-Double.parseDouble(ConditionWaiverCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            ConditionWaiverLiner.setVisibility(View.GONE);
                        }


                    }
                });
                CheckBoxPreExistingDisease.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxPreExistingDisease.isChecked()){
                            CountScroll++;
                            PreExistingDiseaseStatus="True";
                            doublePreExistingDiseaseCoverPremium=Double.parseDouble(PreExistingDiseaseCoverPremium);
                            double DoubleCheck= Double.parseDouble(PreExistingDiseaseCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            PreExistingDiseaseLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            PreExistingDiseaseStatus="False";
                            double DoubleCheck= Double.parseDouble(AmountStr)-Double.parseDouble(PreExistingDiseaseCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            PreExistingDiseaseLiner.setVisibility(View.GONE);
                        }


                    }
                });
                CheckBoxOutpatientDental.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxOutpatientDental.isChecked()){
                            CountScroll++;
                            OutpatientDentalStatus="True";
                            doubleOutpatientDentalCoverPremium=Double.parseDouble(OutpatientDentalCoverPremium);
                            double DoubleCheck= Double.parseDouble(OutpatientDentalCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            OutpatientDentalLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            OutpatientDentalStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(OutpatientDentalCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            OutpatientDentalLiner.setVisibility(View.GONE);
                        }


                    }
                });
                CheckBoxEmergencyTravelling.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxEmergencyTravelling.isChecked()){
                            CountScroll++;
                            EmergencyTravellingStatus="True";
                            doubleEmergencyTravellingCoverPremium=Double.parseDouble(EmergencyTravellingCoverPremium);
                            double DoubleCheck= Double.parseDouble(EmergencyTravellingCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            EmergencyTravellingLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            EmergencyTravellingStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(EmergencyTravellingCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            EmergencyTravellingLiner.setVisibility(View.GONE);
                        }


                    }
                });
                CheckBoxSecondOpinion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxSecondOpinion.isChecked()){
                            CountScroll++;
                            SecondOpinionStatus="True";
                             doubleSecondOpinionCoverPremium=Double.parseDouble(SecondOpinionCoverPremium);
                            double DoubleCheck= Double.parseDouble(SecondOpinionCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            SecondOpinionLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            SecondOpinionStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(SecondOpinionCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            SecondOpinionLiner.setVisibility(View.GONE);
                        }


                    }
                });
                CheckBoxRestCure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxRestCure.isChecked()){
                            CountScroll++;
                            RestCureStatus="True";
                            doubleRestCureCoverPremium=Double.parseDouble(RestCureCoverPremium);
                            double DoubleCheck= Double.parseDouble(RestCureCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            RestCureLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            RestCureStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(RestCureCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            RestCureLiner.setVisibility(View.GONE);
                        }
                    }
                });
                CheckBoxObesityWeight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxObesityWeight.isChecked()){
                            CountScroll++;
                            ObesityWeightStatus="True";
                            doubleObesityWeightCoverPremium=Double.parseDouble(ObesityWeightCoverPremium);
                            double DoubleCheck= Double.parseDouble(ObesityWeightCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            ObesityWeightLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            ObesityWeightStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(ObesityWeightCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            ObesityWeightLiner.setVisibility(View.GONE);
                        }
                    }
                });
                CheckBoxSterilityInfertility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxSterilityInfertility.isChecked()){
                            CountScroll++;
                            SterilityInfertilityStatus="True";
                            doubleSterilityInfertilityCoverPremium=Double.parseDouble(SterilityInfertilityCoverPremium);
                            double DoubleCheck= Double.parseDouble(SterilityInfertilityCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            SterilityInfertilityLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            SterilityInfertilityStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(SterilityInfertilityCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            SterilityInfertilityLiner.setVisibility(View.GONE);
                        } }
                });
                CheckBoxEnhancedOrgan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxEnhancedOrgan.isChecked()){
                            CountScroll++;
                            EnhancedOrganStatus="True";
                            doubleEnhancedCoverPremium=Double.parseDouble(EnhancedCoverPremium);
                            double DoubleCheck= Double.parseDouble(EnhancedCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            EnhancedOrganLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            EnhancedOrganStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(EnhancedCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            EnhancedOrganLiner.setVisibility(View.GONE);
                        }
                    }
                });
                CheckBoxMedicallyAdvised.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxMedicallyAdvised.isChecked()){
                            CountScroll++;
                            MedicallyAdvisedStatus="True";
                            doubleMedicallyAdvisedCoverPremium=Double.parseDouble(MedicallyAdvisedCoverPremium);
                            double DoubleCheck= Double.parseDouble(MedicallyAdvisedCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            MedicallyAdvisedLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            MedicallyAdvisedStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(MedicallyAdvisedCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            MedicallyAdvisedLiner.setVisibility(View.GONE);
                        } }
                });
                CheckBoxEmergencyAssistance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxEmergencyAssistance.isChecked()){
                            CountScroll++;
                            EmergencyAssistanceStatus="True";
                            doubleEmergencyAssistanceCoverPremium= Double.parseDouble(EmergencyAssistanceCoverPremium);
                            double DoubleCheck= Double.parseDouble(EmergencyAssistanceCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            EmergencyAssistanceLine.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                            coPaymentValueAdd=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doublePremiumWaiverCoverPremium+doubleWellnessBenefitCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleDiseaseManagementCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB;

                        }else {
                            CountScroll--;
                            EmergencyAssistanceStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(EmergencyAssistanceCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            EmergencyAssistanceLine.setVisibility(View.GONE);
                        }
                    }
                });
                CheckBoxHomeCare.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxHomeCare.isChecked()){
                            CountScroll++;
                            HomeCareStatus="True";
                            doubleHomeCareCoverPremium=Double.parseDouble(HomeCareCoverPremium);
                            double DoubleCheck= Double.parseDouble(HomeCareCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            HomeCareLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            HomeCareStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(HomeCareCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            HomeCareLiner.setVisibility(View.GONE);
                        }
                    }
                });
                CheckBoxWellnessBenefit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxWellnessBenefit.isChecked()){
                            CountScroll++;
                            WellnessBenefitStatus="True";
                            doubleWellnessBenefitCoverPremium=Double.parseDouble(WellnessBenefitCoverPremium);
                            double DoubleCheck= Double.parseDouble(WellnessBenefitCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            WellnessBenefitLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            WellnessBenefitStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(WellnessBenefitCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            WellnessBenefitLiner.setVisibility(View.GONE);
                        }
                    }
                });
                CheckBoxDiseaseManagement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxDiseaseManagement.isChecked()){
                            CountScroll++;
                            DiseaseManagementStatus="True";
                            doubleDiseaseManagementCoverPremium=Double.parseDouble(DiseaseManagementCoverPremium);
                            double DoubleCheck= Double.parseDouble(DiseaseManagementCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            DiseaseManagementLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                            coPaymentValueAdd=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doublePremiumWaiverCoverPremium+doubleWellnessBenefitCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleDiseaseManagementCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB;

                        }else {
                            CountScroll--;
                            DiseaseManagementStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(DiseaseManagementCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            DiseaseManagementLiner.setVisibility(View.GONE);
                        }
                    }
                });
                CheckBoxGlobalCover.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxGlobalCover.isChecked()){
                            CountScroll++;
                            GlobalCoverStatus="True";
                            doubleGlobalCoverCoverPremium=Double.parseDouble(GlobalCoverCoverPremium);
                            double DoubleCheck= Double.parseDouble(GlobalCoverCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            GlobalCoverLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            GlobalCoverStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(GlobalCoverCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            GlobalCoverLiner.setVisibility(View.GONE);
                        }


                    }
                });
                CheckBoxModernTreatments.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxModernTreatments.isChecked()){
                            CountScroll++;
                            ModernTreatmentsStatus="True";
                            doubleModernTreatmentCoverPremium=Double.parseDouble(ModernTreatmentCoverPremium);
                            double DoubleCheck= Double.parseDouble(ModernTreatmentCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            ModernTreatmentsLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                        }else {
                            CountScroll--;
                            ModernTreatmentsStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(ModernTreatmentCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            ModernTreatmentsLiner.setVisibility(View.GONE);
                        }
                    }
                });
                CheckBoxPremiumWaiver.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (CheckBoxPremiumWaiver.isChecked()){
                            CountScroll++;
                            PremiumWaiverStatus="True";
                            doublePremiumWaiverCoverPremium=Double.parseDouble(PremiumWaiverCoverPremium);
                            double DoubleCheck= Double.parseDouble(PremiumWaiverCoverPremium)+Double.parseDouble(AmountStr);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            PremiumWaiverLiner.setVisibility(View.VISIBLE);
                            addons=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doubleExtensionPreHospitalizationCoverPremium+doubleExtensionProHospitalizationCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB+doubleMaternityChildcareCoverPremium+doubleCoverageNonMedicalCoverPremium+doubleConditionWaiverCoverPremium+doublePreExistingDiseaseCoverPremium+doubleObesityWeightCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleSecondOpinionCoverPremium+doubleRestCureCoverPremium+doubleOutpatientDentalCoverPremium+doubleSterilityInfertilityCoverPremium+doubleEnhancedCoverPremium+doubleMedicallyAdvisedCoverPremium+doubleEmergencyTravellingCoverPremium+doubleHomeCareCoverPremium+doubleWellnessBenefitCoverPremium+doubleDiseaseManagementCoverPremium+doubleGlobalCoverCoverPremium+doubleModernTreatmentCoverPremium+doublePremiumWaiverCoverPremium;
                            Log.e("addons", valueOf(addons));
                            coPaymentValueAdd=doubleDailyHospitalCoverPremium+doubleCriticalIllnessCoverPremium+doublePremiumWaiverCoverPremium+doubleWellnessBenefitCoverPremium+doubleEmergencyAssistanceCoverPremium+doubleDiseaseManagementCoverPremium+doublePersonalPremiumA+doublePersonalPremiumB;

                        }else {
                            CountScroll--;
                            PremiumWaiverStatus="False";
                            double DoubleCheck=Double.parseDouble(AmountStr)-Double.parseDouble(PremiumWaiverCoverPremium);
                            AmountStr= valueOf(DoubleCheck);
                            TotalPremiumSelectPlan.setText(CardAmount);
                            TotalPremium.setText(AmountStr);
                            PremiumWaiverLiner.setVisibility(View.GONE);
                        }
                    }
                });

                if (CountScroll==0){
                    horizontalScroll.setVisibility(View.GONE);
                }else {
                    horizontalScroll.setVisibility(View.VISIBLE);
                }

                bottomCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomSheetDialog.show();
            }
        });
         DailyHospitalAddImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  DailyHospitalSatus="False";
                  DailyHospitalLiner.setVisibility(View.GONE);


              }
          });
         CriticalIllnessImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  CriticalStatus="False";
                  CriticalIllnessLiner.setVisibility(View.GONE);


              }
          });
         ExtensionPreImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  ExtensionPreHospitalization="False";
                  ExtensionPreLiner.setVisibility(View.GONE);


              }
          });
          ExtensionPostImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  ExtensionPr0Hospitalization="False";
                  ExtensionPostLiner.setVisibility(View.GONE);


              }
          });
          MaternityImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  MaternityAndChildcare="False";
                  MaternityLiner.setVisibility(View.GONE);


              }
          });
          CoverageImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  CoverageNonMedical="False";
                  CoverageLiner.setVisibility(View.GONE);


              }
          });
          ConditionWaiverImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  ConditionWaiverStatus="False";
                  ConditionWaiverLiner.setVisibility(View.GONE);


              }
          });
          PreExistingDiseaseImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  PreExistingDiseaseStatus="False";
                  PreExistingDiseaseLiner.setVisibility(View.GONE);


              }
          });
          OutpatientDentalImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  OutpatientDentalStatus="False";
                  OutpatientDentalLiner.setVisibility(View.GONE);


              }
          });
          EmergencyTravellingImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  EmergencyTravellingStatus="False";
                  EmergencyTravellingLiner.setVisibility(View.GONE);


              }
          });
          SecondOpinionImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  SecondOpinionStatus="False";
                  SecondOpinionLiner.setVisibility(View.GONE);


              }
          });
          RestCureImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  RestCureStatus="False";
                  RestCureLiner.setVisibility(View.GONE);


              }
          });
          ObesityWeightImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  ObesityWeightStatus="False";
                  ObesityWeightLiner.setVisibility(View.GONE);


              }
          });
          SterilityInfertilityImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  SterilityInfertilityStatus="False";
                  SterilityInfertilityLiner.setVisibility(View.GONE);


              }
          });
          EnhancedOrganImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  EnhancedOrganStatus="False";
                  EnhancedOrganLiner.setVisibility(View.GONE);


              }
          });
          MedicallyAdvisedImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  MedicallyAdvisedStatus="False";
                  MedicallyAdvisedLiner.setVisibility(View.GONE);


              }
          });
          EmergencyAssistanceImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  EmergencyAssistanceStatus="False";
                  EmergencyAssistanceLine.setVisibility(View.GONE);


              }
          });
          HomeCareImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  HomeCareStatus="False";
                  HomeCareLiner.setVisibility(View.GONE);


              }
          });
          WellnessBenefitImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  WellnessBenefitStatus="False";
                  WellnessBenefitLiner.setVisibility(View.GONE);


              }
          });
          DiseaseManagementImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  DiseaseManagementStatus="False";
                  DiseaseManagementLiner.setVisibility(View.GONE);


              }
          });
          GlobalCoverImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  GlobalCoverStatus="False";
                  GlobalCoverLiner.setVisibility(View.GONE);


              }
          });
          ModernTreatmentsImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  ModernTreatmentsStatus="False";
                  ModernTreatmentsLiner.setVisibility(View.GONE);


              }
          });
          PremiumWaiverImg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  PremiumWaiverStatus="False";
                  PremiumWaiverLiner.setVisibility(View.GONE);


              }
          });




          PersonalAccidentCoverPremium=strPersonalPremiumA;
           ConditionWaiverPackageOne.setText(ConditionWaiverCoverPremium);
          ExtensionPreHospitalizationPackageOne.setText(ExtensionPreHospitalizationCoverPremium);
          ExtensionProHospitalizationPackageOne.setText(ExtensionProHospitalizationCoverPremium);
          EmergencyAssistancePackageOe.setText(EmergencyAssistanceCoverPremium);
          PersonalAccidentPackageOne.setText(PersonalAccidentCoverPremium);
          WellnessBenefitPackageOne.setText(WellnessBenefitCoverPremium);
          float doubleTotalPremium= Float.parseFloat(ConditionWaiverCoverPremium)+Float.parseFloat(ExtensionPreHospitalizationCoverPremium)+Float.parseFloat(ExtensionProHospitalizationCoverPremium)+Float.parseFloat(EmergencyAssistanceCoverPremium)+Float.parseFloat(PersonalAccidentCoverPremium)+Float.parseFloat(WellnessBenefitCoverPremium);
          sumPremiumPackageOne= String.format("%.2f", doubleTotalPremium);
          TotalPremiumPackageOne.setText(sumPremiumPackageOne);


          //PackageTwo
          ConditionWaiverPackageTwo.setText(ConditionWaiverCoverPremium);
          PremiumWaiverPackageTwo.setText(PremiumWaiverCoverPremium);
          SecondOpinionPackageTwo.setText(SecondOpinionCoverPremium);
          PersonalAccidentPackageTwo.setText(PersonalAccidentCoverPremium);
          EmergencyAssistancePackageTwo.setText(EmergencyAssistanceCoverPremium);
          ModernTreatments.setText(ModernTreatmentCoverPremium);
          float doubleTotalPremiumTwo= Float.parseFloat(ConditionWaiverCoverPremium)+Float.parseFloat(PremiumWaiverCoverPremium)+Float.parseFloat(SecondOpinionCoverPremium)+Float.parseFloat(PersonalAccidentCoverPremium)+Float.parseFloat(EmergencyAssistanceCoverPremium)+Float.parseFloat(ModernTreatmentCoverPremium);
          sumPremiumPackageTwo=  String.format("%.2f", doubleTotalPremiumTwo);
          SumPremiumPackageTwo.setText(sumPremiumPackageTwo);


          //PackageThree
          ConditionWaiverPackageThree.setText(ConditionWaiverCoverPremium);
          NonMedicalPackageThree.setText(CoverageNonMedicalCoverPremium);
          MedicallyAdvisedPackageThree.setText(MedicallyAdvisedCoverPremium);
          EnhancedOrganPackageThree.setText(EnhancedCoverPremium);
          PersonalAccidentPackageThree.setText(PersonalAccidentCoverPremium);
          HomeCarePackageThree.setText(HomeCareCoverPremium);

          double doubleTotalPremiumThree= Float.parseFloat(ConditionWaiverCoverPremium)+Float.parseFloat(CoverageNonMedicalCoverPremium)+Float.parseFloat(MedicallyAdvisedCoverPremium)+Float.parseFloat(EnhancedCoverPremium)+Float.parseFloat(PersonalAccidentCoverPremium)+Float.parseFloat(HomeCareCoverPremium);
          sumPremiumPackageThree=  String.format("%.2f", doubleTotalPremiumThree);
          SumPremiumPackageThree.setText(sumPremiumPackageThree);

          //PackageFour
          ConditionWaiverPackageFour.setText(ConditionWaiverCoverPremium);
          PersonalAccidentPackageFour.setText(PersonalAccidentCoverPremium);
          CriticalIllnessPackageFour.setText(CriticalIllnessCoverPremium);
          ModernTreatmentPackageFour.setText(ModernTreatmentCoverPremium);
          HospitalDailyCashPackageFour.setText(DailyHospitalCoverPremium);
          double doubleTotalPremiumFour=Float.parseFloat(ConditionWaiverCoverPremium)+Float.parseFloat(PersonalAccidentCoverPremium)+Float.parseFloat(CriticalIllnessCoverPremium)+Float.parseFloat(ModernTreatmentCoverPremium)+Float.parseFloat(DailyHospitalCoverPremium);
          sumPremiumPackageFour=  String.format("%.2f", doubleTotalPremiumFour);
          SumPremiumPackageFour.setText(sumPremiumPackageFour);

          //PackageFive
          TreatmentTiredNetworkPackageFive.setText("");
          WellnessBenefitPackageFive.setText(WellnessBenefitCoverPremium);
          SumPremiumPackageFive.setText(WellnessBenefitCoverPremium);
          PackageOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (PackageOne.isChecked()){
                      strPackageOne="Check";
                      CountScroll++;
                      PackageOne.setChecked(true);
                      PackageTwo.setChecked(false);
                      PackageThree.setChecked(false);
                      PackageFour.setChecked(false);
                      PackageFive.setChecked(false);
                      ConditionWaiverStatus="True";
                      ExtensionPreHospitalization="True";
                      ExtensionPr0Hospitalization="True";
                      EmergencyAssistanceStatus="True";
                      PersonalStatus="True";
                      WellnessBenefitStatus="True";
                      addons= Double.parseDouble(sumPremiumPackageOne);
                      double AmountStrAmt= Double.parseDouble(AmountStr)+doubleTotalPremium;
                      AmountStr= valueOf(Math.round(AmountStrAmt * 100.0) / 100.0);
                      TotalAmountStr=AmountStr ;
                      TotalPremiumSelectPlan.setText(CardAmount);
                      TotalPremium.setText(AmountStr);

                  }else {
                      strPackageOne="UnCheck";
                      CountScroll--;
                      ConditionWaiverStatus="False";
                      ExtensionPreHospitalization="False";
                      ExtensionPr0Hospitalization="False";
                      EmergencyAssistanceStatus="False";
                      PersonalStatus="False";
                      WellnessBenefitStatus="False";
                      addons= Double.parseDouble(sumPremiumPackageOne);
                      double AmountStrAmt= Double.parseDouble(AmountStr)-doubleTotalPremium;
                      AmountStr= valueOf(Math.round(AmountStrAmt * 100.0) / 100.0);
                      TotalAmountStr=AmountStr ;
                      TotalPremiumSelectPlan.setText(TotalAmountStr);
                      TotalPremium.setText(TotalAmountStr);
                  }

              }
          });
          PackageTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (PackageTwo.isChecked()){
                      CountScroll++;
                      strPackageOne="Check";
                      PackageOne.setChecked(false);
                      PackageTwo.setChecked(true);
                      PackageThree.setChecked(false);
                      PackageFour.setChecked(false);
                      PackageFive.setChecked(false);
                      ConditionWaiverStatus="True";
                      PremiumWaiverStatus="True";
                      SecondOpinionStatus="True";
                      ModernTreatmentsStatus="True";
                      PersonalStatus="True";
                      EmergencyAssistanceStatus="True";
                      addons= Double.parseDouble(sumPremiumPackageTwo);
                      double AmountStrAmt= Double.parseDouble(AmountStr)+doubleTotalPremiumTwo;
                      AmountStr= valueOf(Math.round(AmountStrAmt * 100.0) / 100.0);
                      TotalAmountStr=AmountStr ;
                      TotalPremiumSelectPlan.setText(CardAmount);
                      TotalPremium.setText(AmountStr);

                  }else {
                      strPackageOne="UnCheck";
                      CountScroll--;
                      ConditionWaiverStatus="False";
                      PremiumWaiverStatus="False";
                      SecondOpinionStatus="False";
                      ModernTreatmentsStatus="False";
                      PersonalStatus="False";
                      EmergencyAssistanceStatus="False";
                      addons= Double.parseDouble(sumPremiumPackageTwo);
                      double AmountStrAmt= Double.parseDouble(AmountStr)-doubleTotalPremiumTwo;
                      AmountStr= valueOf(Math.round(AmountStrAmt * 100.0) / 100.0);
                      TotalAmountStr=AmountStr ;
                      TotalPremiumSelectPlan.setText(CardAmount);
                      TotalPremium.setText(AmountStr);
                  }

              }
          });
          PackageThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (PackageThree.isChecked()){
                      strPackageOne="Check";
                      CountScroll++;
                      PackageOne.setChecked(false);
                      PackageTwo.setChecked(false);
                      PackageThree.setChecked(true);
                      PackageFour.setChecked(false);
                      PackageFive.setChecked(false);
                      ConditionWaiverStatus="True";
                      CoverageNonMedical="True";
                      MedicallyAdvisedStatus="True";
                      EnhancedOrganStatus="True";
                      PersonalStatus="True";
                      HomeCareStatus="True";
                      addons= Double.parseDouble(sumPremiumPackageThree);
                      double AmountStrAmt= Double.parseDouble(AmountStr)+doubleTotalPremiumThree;
                      AmountStr= valueOf(Math.round(AmountStrAmt * 100.0) / 100.0);
                      TotalAmountStr=AmountStr ;
                      TotalPremiumSelectPlan.setText(CardAmount);
                      TotalPremium.setText(AmountStr);
                  }else {
                      strPackageOne="UnCheck";
                      CountScroll--;
                      ConditionWaiverStatus="False";
                      CoverageNonMedical="False";
                      MedicallyAdvisedStatus="False";
                      EnhancedOrganStatus="False";
                      PersonalStatus="False";
                      HomeCareStatus="False";
                      addons= Double.parseDouble(sumPremiumPackageOne);
                      double AmountStrAmt= Double.parseDouble(AmountStr)-doubleTotalPremiumThree;
                      AmountStr= valueOf(Math.round(AmountStrAmt * 100.0) / 100.0);
                      TotalAmountStr=AmountStr ;
                      TotalPremiumSelectPlan.setText(CardAmount);
                      TotalPremium.setText(AmountStr);
                  }

              }
          });
          PackageFour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (PackageFour.isChecked()){
                      strPackageOne="Check";
                      CountScroll++;
                      PackageOne.setChecked(false);
                      PackageTwo.setChecked(false);
                      PackageThree.setChecked(false);
                      PackageFour.setChecked(true);
                      PackageFive.setChecked(false);
                      ConditionWaiverStatus="True";
                      CriticalStatus="True";
                      ModernTreatmentsStatus="True";
                      PersonalStatus="True";
                      DailyHospitalSatus="True";
                      addons= Double.parseDouble(sumPremiumPackageFour);
                      double AmountStrAmt= Double.parseDouble(AmountStr)+doubleTotalPremiumFour;
                      AmountStr= valueOf(Math.round(AmountStrAmt * 100.0) / 100.0);
                      TotalAmountStr=AmountStr ;
                      TotalPremiumSelectPlan.setText(CardAmount);
                      TotalPremium.setText(AmountStr);
                  }else {
                      strPackageOne="UnCheck";
                      CountScroll--;
                      ConditionWaiverStatus="False";
                      CriticalStatus="False";
                      ModernTreatmentsStatus="False";
                      PersonalStatus="False";
                      DailyHospitalSatus="False";
                      addons= Double.parseDouble(sumPremiumPackageFour);
                      double AmountStrAmt= Double.parseDouble(AmountStr)-doubleTotalPremiumFour;
                      AmountStr= valueOf(Math.round(AmountStrAmt * 100.0) / 100.0);
                      TotalAmountStr=AmountStr ;
                      TotalPremiumSelectPlan.setText(CardAmount);
                      TotalPremium.setText(AmountStr);
                  }

              }
          });
          PackageFive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (PackageFive.isChecked()){
                      strPackageOne="Check";
                      CountScroll++;
                      PackageOne.setChecked(false);
                      PackageTwo.setChecked(false);
                      PackageThree.setChecked(false);
                      PackageFour.setChecked(false);
                      PackageFive.setChecked(true);
                      WellnessBenefitStatus="True";
                      addons= Double.parseDouble(WellnessBenefitCoverPremium);
                      double AmountStrAmt= Double.parseDouble(AmountStr)+Double.parseDouble(WellnessBenefitCoverPremium);
                      AmountStr= valueOf(Math.round(AmountStrAmt * 100.0) / 100.0);
                      TotalAmountStr=AmountStr ;
                      TotalPremiumSelectPlan.setText(CardAmount);
                      TotalPremium.setText(AmountStr);
                  }else {
                      strPackageOne="UnCheck";
                      CountScroll--;
                      WellnessBenefitStatus="False";
                      double AmountStrAmt= Double.parseDouble(AmountStr)-Double.parseDouble(WellnessBenefitCoverPremium);
                      AmountStr= valueOf(Math.round(AmountStrAmt * 100.0) / 100.0);
                      TotalAmountStr=AmountStr ;
                      TotalPremiumSelectPlan.setText(CardAmount);
                      TotalPremium.setText(AmountStr);
                  }

              }
          });

      }

    private void PackageValue() {
        if (str_policyType_spinner.equals("Individual")){
            ExtensionPreHospitalizationCoverPremium= valueOf((Double.parseDouble(AmountStr)*5)/100);
            ExtensionProHospitalizationCoverPremium= valueOf((Double.parseDouble(AmountStr)*5)/100);
            ModernTreatmentCoverPremium= valueOf((Double.parseDouble(AmountStr)*5)/100);
            PremiumWaiverCoverPremium= valueOf((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)))*15)/100);
            PreExistingDiseaseCoverPremium= valueOf((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)+(Double.parseDouble(PremiumWaiverCoverPremium))))*25)/100);
            double roundDConditionWaiverCoverPremium= ((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)+(Double.parseDouble(PremiumWaiverCoverPremium))+(Double.parseDouble(PreExistingDiseaseCoverPremium))))*0.10));
            double roundDConditionWaiverCoverPremium1= Math.round(roundDConditionWaiverCoverPremium*100.0)/100.0;
            ConditionWaiverCoverPremium= valueOf(roundDConditionWaiverCoverPremium1);
            PremiumBeforeDiscounts=(Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium))+(Double.parseDouble(PremiumWaiverCoverPremium))+(Double.parseDouble(PreExistingDiseaseCoverPremium))+(Double.parseDouble(ConditionWaiverCoverPremium));
            double strDoublePersonalPremiumA=0.51/1000*(Double.parseDouble(strSumInsured));
            double roundDbl = Math.round(strDoublePersonalPremiumA*100.0)/100.0;
            strPersonalPremiumA= valueOf(roundDbl);
            EmergencyAssistanceCoverPremium="130";
            DiseaseManagementCoverPremium="385";
            if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
            }else{
                double strDoublePersonalPremiumB=0.63/1000*(Double.parseDouble(strSumInsured));
                double roundDbl1 = Math.round(strDoublePersonalPremiumB*100.0)/100.0;
                strPersonalBPremiumTxt= valueOf(roundDbl1);
            }
            OutpatientDentalCoverPremium= OutPatientPremium(strSumInsured);
            RestCureCoverPremium= RestCureCoverPremium(strSumInsured);
            HomeCareCoverPremium= HomeCareCoverPremium(strSumInsured);
            WellnessBenefitCoverPremium= WellnessBenefitCoverPremium(strSumInsured);
            SterilityInfertilityCoverPremium= SterilityInfertilityCoverPremium(strSumInsured);
            ObesityWeightCoverPremium= ObesityWeightCoverPremium(strSumInsured);
            SecondOpinionCoverPremium= SecondOpinionCoverPremium(strSumInsured);
            EmergencyTravellingCoverPremium= EmergencyTravellingCoverPremium(strSumInsured);
            DailyHospitalCoverPremium= DailyHospitalCoverPremium(selectYearAdult,strSumInsured);
            CriticalIllnessCoverPremium= CriticalIllnessCoverPremium(selectYearAdult,strSumInsured);
            MedicallyAdvisedCoverPremium= MedicallyAdvisedCoverPremium(selectYearAdult,strSumInsured);
            EnhancedCoverPremium= EnhancedCoverPremium(selectYearAdult,strSumInsured);
            CoverageNonMedicalCoverPremium= NoMedicalPremiumTxt(selectYearAdult,strSumInsured);
        }
        else{
            if (FamilyTypeCounter+mCounter==2){
                ExtensionPreHospitalizationCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*2);
                ExtensionProHospitalizationCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*2);
                ModernTreatmentCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*2);
                PremiumWaiverCoverPremium= valueOf((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)))*0.15)*2);
                PreExistingDiseaseCoverPremium= valueOf((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)+(Double.parseDouble(PremiumWaiverCoverPremium))))*0.25)*2);
                double roundDConditionWaiverCoverPremium= ((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)+(Double.parseDouble(PremiumWaiverCoverPremium))+(Double.parseDouble(PreExistingDiseaseCoverPremium))))*0.10)*2);
                double roundDConditionWaiverCoverPremium1= Math.round(roundDConditionWaiverCoverPremium*100.0)/100.0;
                ConditionWaiverCoverPremium= valueOf(roundDConditionWaiverCoverPremium1);
                PremiumBeforeDiscounts=(Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium))+(Double.parseDouble(PremiumWaiverCoverPremium))+(Double.parseDouble(PreExistingDiseaseCoverPremium))+(Double.parseDouble(ConditionWaiverCoverPremium));
                double strDoublePersonalPremiumA=(0.51/1000*(Double.parseDouble(strSumInsured)))*2;
                double roundDbl = Math.round(strDoublePersonalPremiumA*100.0)/100.0;
                strPersonalPremiumA= valueOf(roundDbl);

                EmergencyAssistanceCoverPremium= valueOf(130.00*2);
                DiseaseManagementCoverPremium= valueOf(385*2);
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                }else{
                    double strDoublePersonalPremiumB=(0.63/1000*(Double.parseDouble(strSumInsured)))*2;
                    double roundDbl1 = Math.round(strDoublePersonalPremiumB*100.0)/100.0;
                    strPersonalBPremiumTxt= valueOf(roundDbl1);
                }
                OutpatientDentalCoverPremium1= OutPatientPremium(strSumInsured);
                OutpatientDentalCoverPremium= valueOf((Double.parseDouble(OutpatientDentalCoverPremium1))*2);
                RestCureCoverPremium1= RestCureCoverPremium(strSumInsured);
                RestCureCoverPremium= valueOf((Double.parseDouble(RestCureCoverPremium1))*2);
                HomeCareCoverPremium1= HomeCareCoverPremium(strSumInsured);
                HomeCareCoverPremium= valueOf((Double.parseDouble(HomeCareCoverPremium1))*2);
                WellnessBenefitCoverPremium1= WellnessBenefitCoverPremium(strSumInsured);
                WellnessBenefitCoverPremium= valueOf((Double.parseDouble(WellnessBenefitCoverPremium1))*2);
                SterilityInfertilityCoverPremium1= SterilityInfertilityCoverPremium(strSumInsured);
                SterilityInfertilityCoverPremium= valueOf((Double.parseDouble(SterilityInfertilityCoverPremium1))*2);
                ObesityWeightCoverPremium1= ObesityWeightCoverPremium(strSumInsured);
                ObesityWeightCoverPremium= valueOf((Double.parseDouble(ObesityWeightCoverPremium1))*2);
                SecondOpinionCoverPremium1= SecondOpinionCoverPremium(strSumInsured);
                SecondOpinionCoverPremium= valueOf((Double.parseDouble(SecondOpinionCoverPremium1))*2);
                EmergencyTravellingCoverPremium1= EmergencyTravellingCoverPremium(strSumInsured);
                EmergencyTravellingCoverPremium= valueOf((Double.parseDouble(EmergencyTravellingCoverPremium1))*2);
                DailyHospitalCoverPremium1= DailyHospitalCoverPremium(selectYearAdult,strSumInsured);
                DailyHospitalCoverPremium= valueOf((Double.parseDouble(DailyHospitalCoverPremium1))*2);
                CriticalIllnessCoverPremium1= CriticalIllnessCoverPremium(selectYearAdult,strSumInsured);
                CriticalIllnessCoverPremium= valueOf((Double.parseDouble(CriticalIllnessCoverPremium1))*2);
                MedicallyAdvisedCoverPremium1= MedicallyAdvisedCoverPremium(selectYearAdult,strSumInsured);
                MedicallyAdvisedCoverPremium= valueOf((Double.parseDouble(MedicallyAdvisedCoverPremium1))*2);
                EnhancedCoverPremium1= EnhancedCoverPremium(selectYearAdult,strSumInsured);
                EnhancedCoverPremium= valueOf((Double.parseDouble(EnhancedCoverPremium1))*2);
                CoverageNonMedicalCoverPremium1= NoMedicalPremiumTxt(selectYearAdult,strSumInsured);
                CoverageNonMedicalCoverPremium= valueOf((Double.parseDouble(CoverageNonMedicalCoverPremium1))*2);
            }
            else if(FamilyTypeCounter+mCounter==3){
                ExtensionPreHospitalizationCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*3);
                ExtensionProHospitalizationCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*3);
                ModernTreatmentCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*3);
                PremiumWaiverCoverPremium= valueOf((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)))*0.15)*3);
                PreExistingDiseaseCoverPremium= valueOf((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)+(Double.parseDouble(PremiumWaiverCoverPremium))))*0.25)*3);
                double roundDConditionWaiverCoverPremium= ((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)+(Double.parseDouble(PremiumWaiverCoverPremium))+(Double.parseDouble(PreExistingDiseaseCoverPremium))))*0.10)*3);
                double roundDConditionWaiverCoverPremium1= Math.round(roundDConditionWaiverCoverPremium*100.0)/100.0;
                ConditionWaiverCoverPremium= valueOf(roundDConditionWaiverCoverPremium1);
                PremiumBeforeDiscounts=(Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium))+(Double.parseDouble(PremiumWaiverCoverPremium))+(Double.parseDouble(PreExistingDiseaseCoverPremium))+(Double.parseDouble(ConditionWaiverCoverPremium));
                double strDoublePersonalPremiumA=(0.51/1000*(Double.parseDouble(strSumInsured)))*3;
                double roundDbl = Math.round(strDoublePersonalPremiumA*100.0)/100.0;
                strPersonalPremiumA= valueOf(roundDbl);

                EmergencyAssistanceCoverPremium= valueOf(130.00*3);
                DiseaseManagementCoverPremium= valueOf(385*3);
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                }else{
                    double strDoublePersonalPremiumB=(0.63/1000*(Double.parseDouble(strSumInsured)))*3;
                    double roundDbl1 = Math.round(strDoublePersonalPremiumB*100.0)/100.0;
                    strPersonalBPremiumTxt= valueOf(roundDbl1);
                }
                OutpatientDentalCoverPremium1= OutPatientPremium(strSumInsured);
                OutpatientDentalCoverPremium= valueOf((Double.parseDouble(OutpatientDentalCoverPremium1))*3);
                RestCureCoverPremium1= RestCureCoverPremium(strSumInsured);
                RestCureCoverPremium= valueOf((Double.parseDouble(RestCureCoverPremium1))*3);
                HomeCareCoverPremium1= HomeCareCoverPremium(strSumInsured);
                HomeCareCoverPremium= valueOf((Double.parseDouble(HomeCareCoverPremium1))*3);
                WellnessBenefitCoverPremium1= WellnessBenefitCoverPremium(strSumInsured);
                WellnessBenefitCoverPremium= valueOf((Double.parseDouble(WellnessBenefitCoverPremium1))*3);
                SterilityInfertilityCoverPremium1= SterilityInfertilityCoverPremium(strSumInsured);
                SterilityInfertilityCoverPremium= valueOf((Double.parseDouble(SterilityInfertilityCoverPremium1))*3);
                ObesityWeightCoverPremium1= ObesityWeightCoverPremium(strSumInsured);
                ObesityWeightCoverPremium= valueOf((Double.parseDouble(ObesityWeightCoverPremium1))*3);
                SecondOpinionCoverPremium1= SecondOpinionCoverPremium(strSumInsured);
                SecondOpinionCoverPremium= valueOf((Double.parseDouble(SecondOpinionCoverPremium1))*3);
                EmergencyTravellingCoverPremium1= EmergencyTravellingCoverPremium(strSumInsured);
                EmergencyTravellingCoverPremium= valueOf((Double.parseDouble(EmergencyTravellingCoverPremium1))*3);
                DailyHospitalCoverPremium1= DailyHospitalCoverPremium(selectYearAdult,strSumInsured);
                DailyHospitalCoverPremium= valueOf((Double.parseDouble(DailyHospitalCoverPremium1))*3);
                CriticalIllnessCoverPremium1= CriticalIllnessCoverPremium(selectYearAdult,strSumInsured);
                CriticalIllnessCoverPremium= valueOf((Double.parseDouble(CriticalIllnessCoverPremium1))*3);
                MedicallyAdvisedCoverPremium1= MedicallyAdvisedCoverPremium(selectYearAdult,strSumInsured);
                MedicallyAdvisedCoverPremium= valueOf((Double.parseDouble(MedicallyAdvisedCoverPremium1))*3);
                EnhancedCoverPremium1= EnhancedCoverPremium(selectYearAdult,strSumInsured);
                EnhancedCoverPremium= valueOf((Double.parseDouble(EnhancedCoverPremium1))*3);
                CoverageNonMedicalCoverPremium1= NoMedicalPremiumTxt(selectYearAdult,strSumInsured);
                CoverageNonMedicalCoverPremium= valueOf((Double.parseDouble(CoverageNonMedicalCoverPremium1))*3);
            }
            else if(FamilyTypeCounter+mCounter==4){
                ExtensionPreHospitalizationCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*4);
                ExtensionProHospitalizationCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*4);
                ModernTreatmentCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*4);
                PremiumWaiverCoverPremium= valueOf((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)))*0.15)*4);
                PreExistingDiseaseCoverPremium= valueOf((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)+(Double.parseDouble(PremiumWaiverCoverPremium))))*0.25)*4);
                double roundDConditionWaiverCoverPremium= ((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)+(Double.parseDouble(PremiumWaiverCoverPremium))+(Double.parseDouble(PreExistingDiseaseCoverPremium))))*0.10)*4);
                double roundDConditionWaiverCoverPremium1= Math.round(roundDConditionWaiverCoverPremium*100.0)/100.0;
                ConditionWaiverCoverPremium= valueOf(roundDConditionWaiverCoverPremium1);
                PremiumBeforeDiscounts=(Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium))+(Double.parseDouble(PremiumWaiverCoverPremium))+(Double.parseDouble(PreExistingDiseaseCoverPremium))+(Double.parseDouble(ConditionWaiverCoverPremium));
                double strDoublePersonalPremiumA=(0.51/1000*(Double.parseDouble(strSumInsured)))*4;
                double roundDbl = Math.round(strDoublePersonalPremiumA*100.0)/100.0;
                strPersonalPremiumA= valueOf(roundDbl);

                EmergencyAssistanceCoverPremium= valueOf(130.00*4);
                DiseaseManagementCoverPremium= valueOf(385*4);
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                }else{
                    double strDoublePersonalPremiumB=(0.63/1000*(Double.parseDouble(strSumInsured)))*4;
                    double roundDbl1 = Math.round(strDoublePersonalPremiumB*100.0)/100.0;
                    strPersonalBPremiumTxt= valueOf(roundDbl1);
                }
                OutpatientDentalCoverPremium1= OutPatientPremium(strSumInsured);
                OutpatientDentalCoverPremium= valueOf((Double.parseDouble(OutpatientDentalCoverPremium1))*4);
                RestCureCoverPremium1= RestCureCoverPremium(strSumInsured);
                RestCureCoverPremium= valueOf((Double.parseDouble(RestCureCoverPremium1))*4);
                HomeCareCoverPremium1= HomeCareCoverPremium(strSumInsured);
                HomeCareCoverPremium= valueOf((Double.parseDouble(HomeCareCoverPremium1))*4);
                WellnessBenefitCoverPremium1= WellnessBenefitCoverPremium(strSumInsured);
                WellnessBenefitCoverPremium= valueOf((Double.parseDouble(WellnessBenefitCoverPremium1))*4);
                SterilityInfertilityCoverPremium1= SterilityInfertilityCoverPremium(strSumInsured);
                SterilityInfertilityCoverPremium= valueOf((Double.parseDouble(SterilityInfertilityCoverPremium1))*4);
                ObesityWeightCoverPremium1= ObesityWeightCoverPremium(strSumInsured);
                ObesityWeightCoverPremium= valueOf((Double.parseDouble(ObesityWeightCoverPremium1))*4);
                SecondOpinionCoverPremium1= SecondOpinionCoverPremium(strSumInsured);
                SecondOpinionCoverPremium= valueOf((Double.parseDouble(SecondOpinionCoverPremium1))*4);
                EmergencyTravellingCoverPremium1= EmergencyTravellingCoverPremium(strSumInsured);
                EmergencyTravellingCoverPremium= valueOf((Double.parseDouble(EmergencyTravellingCoverPremium1))*4);
                DailyHospitalCoverPremium1= DailyHospitalCoverPremium(selectYearAdult,strSumInsured);
                DailyHospitalCoverPremium= valueOf((Double.parseDouble(DailyHospitalCoverPremium1))*4);
                CriticalIllnessCoverPremium1= CriticalIllnessCoverPremium(selectYearAdult,strSumInsured);
                CriticalIllnessCoverPremium= valueOf((Double.parseDouble(CriticalIllnessCoverPremium1))*4);
                MedicallyAdvisedCoverPremium1= MedicallyAdvisedCoverPremium(selectYearAdult,strSumInsured);
                MedicallyAdvisedCoverPremium= valueOf((Double.parseDouble(MedicallyAdvisedCoverPremium1))*4);
                EnhancedCoverPremium1= EnhancedCoverPremium(selectYearAdult,strSumInsured);
                EnhancedCoverPremium= valueOf((Double.parseDouble(EnhancedCoverPremium1))*4);
                CoverageNonMedicalCoverPremium1= NoMedicalPremiumTxt(selectYearAdult,strSumInsured);
                CoverageNonMedicalCoverPremium= valueOf((Double.parseDouble(CoverageNonMedicalCoverPremium1))*4);
            }
            else if(FamilyTypeCounter+mCounter==5){
                ExtensionPreHospitalizationCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*5);
                ExtensionProHospitalizationCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*5);
                ModernTreatmentCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*5);
                PremiumWaiverCoverPremium= valueOf((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)))*0.15)*5);
                PreExistingDiseaseCoverPremium= valueOf((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)+(Double.parseDouble(PremiumWaiverCoverPremium))))*0.25)*5);
                double roundDConditionWaiverCoverPremium= ((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)+(Double.parseDouble(PremiumWaiverCoverPremium))+(Double.parseDouble(PreExistingDiseaseCoverPremium))))*0.10)*5);
                double roundDConditionWaiverCoverPremium1= Math.round(roundDConditionWaiverCoverPremium*100.0)/100.0;
                ConditionWaiverCoverPremium= valueOf(roundDConditionWaiverCoverPremium1);
                PremiumBeforeDiscounts=(Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium))+(Double.parseDouble(PremiumWaiverCoverPremium))+(Double.parseDouble(PreExistingDiseaseCoverPremium))+(Double.parseDouble(ConditionWaiverCoverPremium));
                double strDoublePersonalPremiumA=(0.51/1000*(Double.parseDouble(strSumInsured)))*5;
                double roundDbl = Math.round(strDoublePersonalPremiumA*100.0)/100.0;
                strPersonalPremiumA= valueOf(roundDbl);

                EmergencyAssistanceCoverPremium= valueOf(130.00*5);
                DiseaseManagementCoverPremium= valueOf(385*5);
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                }else{
                    double strDoublePersonalPremiumB=(0.63/1000*(Double.parseDouble(strSumInsured)))*5;
                    double roundDbl1 = Math.round(strDoublePersonalPremiumB*100.0)/100.0;
                    strPersonalBPremiumTxt= valueOf(roundDbl1);
                }
                OutpatientDentalCoverPremium1= OutPatientPremium(strSumInsured);
                OutpatientDentalCoverPremium= valueOf((Double.parseDouble(OutpatientDentalCoverPremium1))*5);
                RestCureCoverPremium1= RestCureCoverPremium(strSumInsured);
                RestCureCoverPremium= valueOf((Double.parseDouble(RestCureCoverPremium1))*5);
                HomeCareCoverPremium1= HomeCareCoverPremium(strSumInsured);
                HomeCareCoverPremium= valueOf((Double.parseDouble(HomeCareCoverPremium1))*5);
                WellnessBenefitCoverPremium1= WellnessBenefitCoverPremium(strSumInsured);
                WellnessBenefitCoverPremium= valueOf((Double.parseDouble(WellnessBenefitCoverPremium1))*5);
                SterilityInfertilityCoverPremium1= SterilityInfertilityCoverPremium(strSumInsured);
                SterilityInfertilityCoverPremium= valueOf((Double.parseDouble(SterilityInfertilityCoverPremium1))*5);
                ObesityWeightCoverPremium1= ObesityWeightCoverPremium(strSumInsured);
                ObesityWeightCoverPremium= valueOf((Double.parseDouble(ObesityWeightCoverPremium1))*5);
                SecondOpinionCoverPremium1= SecondOpinionCoverPremium(strSumInsured);
                SecondOpinionCoverPremium= valueOf((Double.parseDouble(SecondOpinionCoverPremium1))*5);
                EmergencyTravellingCoverPremium1= EmergencyTravellingCoverPremium(strSumInsured);
                EmergencyTravellingCoverPremium= valueOf((Double.parseDouble(EmergencyTravellingCoverPremium1))*5);
                DailyHospitalCoverPremium1= DailyHospitalCoverPremium(selectYearAdult,strSumInsured);
                DailyHospitalCoverPremium= valueOf((Double.parseDouble(DailyHospitalCoverPremium1))*5);
                CriticalIllnessCoverPremium1= CriticalIllnessCoverPremium(selectYearAdult,strSumInsured);
                CriticalIllnessCoverPremium= valueOf((Double.parseDouble(CriticalIllnessCoverPremium1))*5);
                MedicallyAdvisedCoverPremium1= MedicallyAdvisedCoverPremium(selectYearAdult,strSumInsured);
                MedicallyAdvisedCoverPremium= valueOf((Double.parseDouble(MedicallyAdvisedCoverPremium1))*5);
                EnhancedCoverPremium1= EnhancedCoverPremium(selectYearAdult,strSumInsured);
                EnhancedCoverPremium= valueOf((Double.parseDouble(EnhancedCoverPremium1))*5);
                CoverageNonMedicalCoverPremium1= NoMedicalPremiumTxt(selectYearAdult,strSumInsured);
                CoverageNonMedicalCoverPremium= valueOf((Double.parseDouble(CoverageNonMedicalCoverPremium1))*5);
            }
            else if(FamilyTypeCounter+mCounter==6){
                ExtensionPreHospitalizationCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*6);
                ExtensionProHospitalizationCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*6);
                ModernTreatmentCoverPremium= valueOf((Double.parseDouble(AmountStr)*0.05)*6);
                PremiumWaiverCoverPremium= valueOf((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)))*0.15)*6);
                PreExistingDiseaseCoverPremium= valueOf((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)+(Double.parseDouble(PremiumWaiverCoverPremium))))*0.25)*6);
                double roundDConditionWaiverCoverPremium= ((((Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium)+(Double.parseDouble(PremiumWaiverCoverPremium))+(Double.parseDouble(PreExistingDiseaseCoverPremium))))*0.10)*6);
                double roundDConditionWaiverCoverPremium1= Math.round(roundDConditionWaiverCoverPremium*100.0)/100.0;
                ConditionWaiverCoverPremium= valueOf(roundDConditionWaiverCoverPremium1);
                PremiumBeforeDiscounts=(Double.parseDouble(AmountStr))+(Double.parseDouble(ModernTreatmentCoverPremium))+(Double.parseDouble(PremiumWaiverCoverPremium))+(Double.parseDouble(PreExistingDiseaseCoverPremium))+(Double.parseDouble(ConditionWaiverCoverPremium));
                double strDoublePersonalPremiumA=(0.51/1000*(Double.parseDouble(strSumInsured)))*6;
                double roundDbl = Math.round(strDoublePersonalPremiumA*100.0)/100.0;
                strPersonalPremiumA= valueOf(roundDbl);

                EmergencyAssistanceCoverPremium= valueOf(130.00*6);
                DiseaseManagementCoverPremium= valueOf(385*6);
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                }else{
                    double strDoublePersonalPremiumB=(0.63/1000*(Double.parseDouble(strSumInsured)))*6;
                    double roundDbl1 = Math.round(strDoublePersonalPremiumB*100.0)/100.0;
                    strPersonalBPremiumTxt= valueOf(roundDbl1);
                }
                OutpatientDentalCoverPremium1= OutPatientPremium(strSumInsured);
                OutpatientDentalCoverPremium= valueOf((Double.parseDouble(OutpatientDentalCoverPremium1))*6);
                RestCureCoverPremium1= RestCureCoverPremium(strSumInsured);
                RestCureCoverPremium= valueOf((Double.parseDouble(RestCureCoverPremium1))*6);
                HomeCareCoverPremium1= HomeCareCoverPremium(strSumInsured);
                HomeCareCoverPremium= valueOf((Double.parseDouble(HomeCareCoverPremium1))*6);
                WellnessBenefitCoverPremium1= WellnessBenefitCoverPremium(strSumInsured);
                WellnessBenefitCoverPremium= valueOf((Double.parseDouble(WellnessBenefitCoverPremium1))*6);
                SterilityInfertilityCoverPremium1= SterilityInfertilityCoverPremium(strSumInsured);
                SterilityInfertilityCoverPremium= valueOf((Double.parseDouble(SterilityInfertilityCoverPremium1))*6);
                ObesityWeightCoverPremium1= ObesityWeightCoverPremium(strSumInsured);
                ObesityWeightCoverPremium= valueOf((Double.parseDouble(ObesityWeightCoverPremium1))*6);
                SecondOpinionCoverPremium1= SecondOpinionCoverPremium(strSumInsured);
                SecondOpinionCoverPremium= valueOf((Double.parseDouble(SecondOpinionCoverPremium1))*6);
                EmergencyTravellingCoverPremium1= EmergencyTravellingCoverPremium(strSumInsured);
                EmergencyTravellingCoverPremium= valueOf((Double.parseDouble(EmergencyTravellingCoverPremium1))*6);
                DailyHospitalCoverPremium1= DailyHospitalCoverPremium(selectYearAdult,strSumInsured);
                DailyHospitalCoverPremium= valueOf((Double.parseDouble(DailyHospitalCoverPremium1))*6);
                CriticalIllnessCoverPremium1= CriticalIllnessCoverPremium(selectYearAdult,strSumInsured);
                CriticalIllnessCoverPremium= valueOf((Double.parseDouble(CriticalIllnessCoverPremium1))*6);
                MedicallyAdvisedCoverPremium1= MedicallyAdvisedCoverPremium(selectYearAdult,strSumInsured);
                MedicallyAdvisedCoverPremium= valueOf((Double.parseDouble(MedicallyAdvisedCoverPremium1))*6);
                EnhancedCoverPremium1= EnhancedCoverPremium(selectYearAdult,strSumInsured);
                EnhancedCoverPremium= valueOf((Double.parseDouble(EnhancedCoverPremium1))*6);
                CoverageNonMedicalCoverPremium1= NoMedicalPremiumTxt(selectYearAdult,strSumInsured);
                CoverageNonMedicalCoverPremium= valueOf((Double.parseDouble(CoverageNonMedicalCoverPremium1))*6);
            }
        }
    }

    private void GetCalculatedData(String age,String packageAmt) {

        for(int i=0;i<priceRateModels.size();i++)
        {
            if(priceRateModels.get(i).getAge().equalsIgnoreCase(age))
            {
                if(packageAmt.equalsIgnoreCase("100000"))
                    amount=priceRateModels.get(i).getA100000();
                else if(packageAmt.equalsIgnoreCase("200000"))
                    amount=priceRateModels.get(i).getA200000();
                else if(packageAmt.equalsIgnoreCase("300000"))
                    amount=priceRateModels.get(i).getA300000();
                else if(packageAmt.equalsIgnoreCase("400000"))
                    amount=priceRateModels.get(i).getA400000();
                else if(packageAmt.equalsIgnoreCase("500000"))
                    amount=priceRateModels.get(i).getA500000();
                else if(packageAmt.equalsIgnoreCase("600000"))
                    amount=priceRateModels.get(i).getA600000();
                else if(packageAmt.equalsIgnoreCase("700000"))
                    amount=priceRateModels.get(i).getA700000();
                else if(packageAmt.equalsIgnoreCase("800000"))
                    amount=priceRateModels.get(i).getA800000();
                else if(packageAmt.equalsIgnoreCase("900000"))
                    amount=priceRateModels.get(i).getA900000();
                else if(packageAmt.equalsIgnoreCase("1000000"))
                    amount=priceRateModels.get(i).getA1000000();
                else if(packageAmt.equalsIgnoreCase("1500000"))
                    amount=priceRateModels.get(i).getA1500000();
                else if(packageAmt.equalsIgnoreCase("2000000"))
                    amount=priceRateModels.get(i).getA2000000();
                else if(packageAmt.equalsIgnoreCase("2500000"))
                    amount=priceRateModels.get(i).getA2500000();
                else if(packageAmt.equalsIgnoreCase("3000000"))
                    amount=priceRateModels.get(i).getA3000000();
                else if(packageAmt.equalsIgnoreCase("4000000"))
                    amount=priceRateModels.get(i).getA4000000();
                else if(packageAmt.equalsIgnoreCase("5000000"))
                    amount=priceRateModels.get(i).getA5000000();
            }
        }

    }


    public void readExcelFileFromAssets() {

        try {
            InputStream myInput;
            //  Don't forget to Change to your assets folder excel sheet
            myInput = assetManager.open("abc_calculator.xls");

            // Create a POIFSFileSystem object
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

            // Create a workbook using the File System
            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

            // Get the first sheet from workbook
            HSSFSheet mySheet = myWorkBook.getSheetAt(0);

            /* We now need something to iterate through the cells. */
            Iterator<Row> rowIter = mySheet.rowIterator();
            while (rowIter.hasNext()) {
                HSSFRow myRow = (HSSFRow) rowIter.next();
                Iterator<Cell> cellIter = myRow.cellIterator();
                priceRateModels.add(new PriceRateModel(""+myRow.getCell(0),""+myRow.getCell(1),""+myRow.getCell(2),""+myRow.getCell(3),""+myRow.getCell(4),""+myRow.getCell(5),""+myRow.getCell(6),""+myRow.getCell(7),""+myRow.getCell(8),""+myRow.getCell(9),""+myRow.getCell(10),""+myRow.getCell(11),""+myRow.getCell(12),""+myRow.getCell(13),""+myRow.getCell(14),""+myRow.getCell(15),""+myRow.getCell(16)));
                while (cellIter.hasNext()) {
                    HSSFCell myCell = (HSSFCell) cellIter.next();
                    Log.e("FileUtils", "Cell Value: " + myCell.toString()+ " Index :" +myCell.getColumnIndex());


                }
            }





            Log.v("asjdafs",""+amount);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return;
    }


    @Override
    public void onBackPressed() {
        Intent intent=new Intent(OfflineCHIAddOns.this, CalculatorPlanType.class);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("strGenderSpinner",strGenderSpinner);
        intent.putExtra("strFor","1");
        startActivity(intent);
        finish();
    }
    public void calculate() {
        strage = age.getText().toString();
        strinsurance = insurance.getText().toString();
        GetCalculatedData(strage,strinsurance);
        txtamount.setText(amount);
        Log.e("ihkjughtdrse",""+amount);
    }
}