package com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Payment_Complete_healthCare;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.paymentweb.PaymentWebUrl;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Motor_summery;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ChiSummery extends AppCompatActivity {
    String  strIDTypeName,strDob,firstName, middleName,lastName,ckycNo,uniqueTransactionNumber,address1,address2,address3,corresAddress1,corresAddress2,corresAddress3,SterilityInfertilityMale,MaternityAndChildcareMale,strNomineeGenderEdit,TreatmentCheckBoxCheck,strBasicPremium,GSt,strSpouseEditFrequency,strOccasionallySpouseEditSpinner,strTobaccoEditSpouse,strTobaccoOccasinallyEditSpouse,strCoPaymentEditText,strSubLimitEditText,SubCategoryDiscountStatusCheck="",CoPaymentCheckBoxCheck="",str_policyType_spinner1,checkPackage,strHospitalizationHistory,strMedicineRadio,strMedicalHistoryRadio,strAppointeeNomineeName,strAppointeeNomineeDobEdit,strAppointeeGenderEdit,PersonalAccidentCategory,DirectPolicyDiscountPremium,strGenderChildOneEdit,strChildOneNameEdit,strRelationEditSpouse,strCheckBoxSelf="",strPackageOne="",AmountStr="",PosPolicyNo="",str_policyType_spinner="",strSelfAgeEditText="",str_IndividualTypeEdit="",strTotalPremium="";
    TextView BasicPremiumTxt,DiscountsTxt,DirectPolicyDiscountTxt,addonsTxt,SelfName,selfEmailId,selfMobileNumber,SelfDOB,NomineeName,NomineeRelation,SumInsuredTxt,PolicyStartDateTxt,PolicyTenureTxt,NetPremiumTxt,GSTTxt,TotalPremiumTxt,TotalValue,PolicyPlanTxt;
    MySharedPreference pref;
    CustomProgressDialog customProgress;
    String OrganDiscountStatus,PersonalAccidentCoverPremium,CriticalIllnessCoverPremium="",DailyHospitalCoverPremium="",ModernTreatmentCoverPremium="",ExtensionPreHospitalizationCoverPremium="",ExtensionProHospitalizationCoverPremium="",MaternityChildcareCoverPremium="",CoverageNonMedicalCoverPremium="",ConditionWaiverCoverPremium="",PreExistingDiseaseCoverPremium="",OutpatientDentalCoverPremium="",EmergencyTravellingCoverPremium="",SecondOpinionCoverPremium="",RestCureCoverPremium="",ObesityWeightCoverPremium="",SterilityInfertilityCoverPremium="",EnhancedCoverPremium="",PremiumWaiverCoverPremium="", GlobalCoverCoverPremium="",MedicallyAdvisedCoverPremium="",EmergencyAssistanceCoverPremium="",HomeCareCoverPremium="",WellnessBenefitCoverPremium="",DiseaseManagementCoverPremium="";
    String TreatmentStatus,permAndCorresAddSame,strswitch="",strCorrespondenceAddressEdit="",strCorrespondenceAddressEdit2="",PersonalStatusChildOne,strSpouseDobEdit,str_age,yearRadio,PersonalAccidentACoverChildOneStatus,PersonalAccidentBCoverChildOneStatus,PersonalStatusChildTwo,PersonalAccidentAChildTwoCoverStatus,PersonalAccidentBChildTwoCoverStatus,PersonalStatusChildThird,PersonalAccidentACoverChildThirdStatus,PersonalAccidentBCoverChildThirdStatus,PersonalStatusChildFour,PersonalAccidentACoverChildFourStatus,PersonalAccidentBCoverChildFourStatus,LongTermDiscountStatus,SubCategoryDiscountStatus,SubCategory,strRelationFourChildEdit,strRelationChildThreeEdit,strRelationChildTwoEdit,strRelationChildEdit,strSpouseNameEditText="",strSpouseGenderEdit,strSpouseOccupationEdit,strFtSpouseEdit,strInchesSpouseEdit,strWeightEditSpouse,strSpouseBMIEdit,
            strBMIChildEdit, strSecondChildNameEdit, str_twoGenderSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strOccupationEditChildOne,str_twoOccupationSpinner,str_thirdOccupationSpinner,str_fourOccupationSpinner,strMotherFeetEditText,strInchesMotherEdit,strMotherRelationShipEdit="",strMotherWeightEdit="",strMotherOccupationEdit="",strMotherEditTextName="",strMotherGenderEdit="",strFatherOccupationEdit="",strOccupationEditMotherLaw="",strBMIMotherEdit="",strFatherEditTextName="",strFatherGenderEditTet="",strRelationFatherEdit="",strFatherWeightEdit="",strFeetFatherEdit="",strInchesFatherEdit="",strBMIFatherEdit="",strMotherLawEditText="",strRelationMotherLawEdit="",strWeightMotherLawEdit="",strFeetEditTextMotherLaw="",strInchesEditTextMotherLaw="",strBMIMotherLawEdit="",strFatherLawNameEdit="",strFatherLawGenderEditText="",strOccupationFatherLawEdit="",strRelationEditTextFatherLaw="",strFatherLawWeightEdit="",strEditFeetFatherLaw="",strEditInchesFatherLaw="",strFatherLawBMIEdit="",FamilyComposition="",ParentComposition="",
            strBMIChildTwoEdit, strThirdChildNameEdit,str_thirdGenderSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strBMIEChildThreeEdit,
            strPackage1="",strPackageTwo="",strPackageThree="",strPackageFour="",strPackageFive="",strPackageSix="", strYesPhysicalMentalRadio="",strYesPreExistingRadio="",strSelfTobaccoRadio="", strAlcoholEditSpinner="",strOccasionallyEditSpinner="",strTobaccoEditSelf="",strTobaccoOccasinallyEditSelf="",strSelfAlcoholRadio="",strFourChildNameEdit ,str_fourGenderSpinner, str_fourFtSpinner,str_fourInchesSpinner,strFourWeightEdit, strBMIFourChildEdit,str_edt_name="",str_edt_phone="",str_email="",today="",tomorrowDate="",nextYear="",strSumInsured="",strPlanTypeTXT="",NetPremium="",strPolicyTenure="",PlanType="",strEdtNameSelf="",strEmailIDEditSelf="",strEditGenderSelf="",strEditOccupationSelf="",strPinCodeEdit="",strPermanentAddressEdit2="",strPermanentAddressEdit="",strStateEdit="",strCityEdit="",strRelationAdultOneEdit="",strEditInchesSelf="",strEditFtSelf="",strWeightEditSelf="",strBMIEdit="",strNomineeRelationEdit="",strNomineeName="",strContactNominee="",strNomineeDobEdit="",strBloodSugar="",strBloodPressure="",strBloodPressureDiastolic="",strcholesterol="";
    Date date;
    int selectYearProposer,addons,selectFirstYearChild,selectSecSonChild,selectThirdSonChild,selectYearChildFour,mCounter=0,FamilyTypeCounter,selectNomineeYear,selectYearAdult,selectYearSecondAdult,selectYearMotherAdult,selectMotherLawAdult,selectYearFatherAdult,selectFatherLawAdult;
    double LongTerm,Discounts,LongTermDiscountDiscountPremium,SubCategoryDiscountPremium,doubleCoPaymentDiscountPremium,OrganDonorDiscountPremium;
    CheckBox checkBox;
    Format formatter;
    String strSpousePhysicalRadio,strDiseaseSpouseRadio,strSufferingDiseaseSecondAdult,strHospitalizationHistoryAdultSecond,strConsumeSpouseAlcohol,strSpouseTobaccoRadio,strProposerBMIEdit,strWeightEditProposer,strProposerEdtName="",strProposerEditDob="",strProposerEditFt="",strProposerEditInches,strEditGenderProposer,strEditOccupationProposer,strProposerRelationEdit,strPolicyNumber="",CoPaymentLoading="",BasicStatus="",PersonalStatus="",CriticalStatus="",DailyHospitalSatus="",ModernTreatmentsStatus="",ExtensionPreHospitalization="",ExtensionPr0Hospitalization="",MaternityAndChildcare="",CoverageNonMedical="",ConditionWaiverStatus="",PersonalAccidentACoverStatus="", PersonalAccidentBCoverStatus="",PreExistingDiseaseStatus="",OutpatientDentalStatus="",SecondOpinionStatus="",RestCureStatus="",ObesityWeightStatus="", SterilityInfertilityStatus="",EnhancedOrganStatus="",GlobalCoverStatus="",MedicallyAdvisedStatus="",EmergencyAssistanceStatus="",HomeCareStatus="", WellnessBenefitStatus="",DiseaseManagementStatus="",LoyaltyDiscountStatus="",CoPaymentStatus="",EmergencyTravellingStatus="",PremiumWaiverStatus="",strGenderSpinner="",strCheckBoxSpouse="",strSpouseAgeEditText="",strCheckBoxMother="",strMotherAgeEditText="",strFatherAgeEditText="",strCheckBoxFather="",strCheckBoxMotherLaw="",strMotherLawAgeEditText="",strCheckBoxFatherLaw="",strFatherLawAgeEditText="",strFirstSonAgeEditText="",strSecondSonAgeEditText="",strThirdSonAgeEditText="",strFourSonAgeEditText="",strCheckBoxSon="",strFor="";
    LinearLayout continueButton;
    ImageView SummeryBack;
    int  DirectPolicy, loyalityDiscount, TiresDiscount, copayemntMax;
    double OrganDonar, sublimt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_summery);
        getWindow().setStatusBarColor(ContextCompat.getColor(ChiSummery.this, R.color.colorPrimaryDark));

        pref = MySharedPreference.getInstance(ChiSummery.this);
        customProgress = new CustomProgressDialog(ChiSummery.this);
        str_edt_name = getIntent().getStringExtra("str_edt_name");
        strNomineeGenderEdit = getIntent().getStringExtra("strNomineeGenderEdit");
        TreatmentCheckBoxCheck = getIntent().getStringExtra("TreatmentCheckBoxCheck");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        str_email = getIntent().getStringExtra("str_email");
         Discounts = getIntent().getDoubleExtra("Discounts", 0.0);
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
        MaternityAndChildcareMale = getIntent().getStringExtra("MaternityAndChildcareMale");
        SterilityInfertilityMale = getIntent().getStringExtra("SterilityInfertilityMale");
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
        addons = getIntent().getIntExtra("addons", 0);
        mCounter = getIntent().getIntExtra("mCounter", 0);
        FamilyTypeCounter = getIntent().getIntExtra("FamilyTypeCounter", 0);
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
        strFor = getIntent().getStringExtra("strFor");
        strPackageOne = getIntent().getStringExtra("strPackageOne");
        strCheckBoxSelf = getIntent().getStringExtra("strCheckBoxSelf");
        strSpouseNameEditText = getIntent().getStringExtra("strSpouseNameEditText");
        strSpouseGenderEdit = getIntent().getStringExtra("strSpouseGenderEdit");
        strSpouseOccupationEdit = getIntent().getStringExtra("strSpouseOccupationEdit");
        strFtSpouseEdit = getIntent().getStringExtra("strFtSpouseEdit");
        strInchesSpouseEdit = getIntent().getStringExtra("strInchesSpouseEdit");
        strWeightEditSpouse = getIntent().getStringExtra("strWeightEditSpouse");
        strSpouseBMIEdit = getIntent().getStringExtra("strSpouseBMIEdit");
        strBMIChildEdit = getIntent().getStringExtra("strBMIChildEdit");
        strSecondChildNameEdit = getIntent().getStringExtra("strSecondChildNameEdit");
        str_twoGenderSpinner = getIntent().getStringExtra("str_twoGenderSpinner");
        str_twoFtSpinner = getIntent().getStringExtra("str_twoFtSpinner");
        str_twoInchesSpinner = getIntent().getStringExtra("str_twoInchesSpinner");
        strtwoWeightEdit = getIntent().getStringExtra("strtwoWeightEdit");
        strBMIChildTwoEdit = getIntent().getStringExtra("strBMIChildTwoEdit");
        strThirdChildNameEdit = getIntent().getStringExtra("strThirdChildNameEdit");
        str_thirdGenderSpinner = getIntent().getStringExtra("str_thirdGenderSpinner");
        str_thirdFtSpinner = getIntent().getStringExtra("str_thirdFtSpinner");
        str_thirdInchesSpinner = getIntent().getStringExtra("str_thirdInchesSpinner");
        str_thirdWeightEdit = getIntent().getStringExtra("str_thirdWeightEdit");
        strBMIEChildThreeEdit = getIntent().getStringExtra("strBMIEChildThreeEdit");
        strFourChildNameEdit = getIntent().getStringExtra("strFourChildNameEdit");
        str_fourGenderSpinner = getIntent().getStringExtra("str_fourGenderSpinner");
        str_fourFtSpinner = getIntent().getStringExtra("str_fourFtSpinner");
        str_fourInchesSpinner = getIntent().getStringExtra("str_fourInchesSpinner");
        strFourWeightEdit = getIntent().getStringExtra("strFourWeightEdit");
        strBMIFourChildEdit = getIntent().getStringExtra("strBMIFourChildEdit");
        strRelationEditSpouse = getIntent().getStringExtra("strRelationEditSpouse");
        strChildOneNameEdit = getIntent().getStringExtra("strChildOneNameEdit");
        strGenderChildOneEdit = getIntent().getStringExtra("strGenderChildOneEdit");
        strRelationChildEdit = getIntent().getStringExtra("strRelationChildEdit");
        strRelationChildTwoEdit = getIntent().getStringExtra("strRelationChildTwoEdit");
        strRelationChildThreeEdit = getIntent().getStringExtra("strRelationChildThreeEdit");
        strRelationFourChildEdit = getIntent().getStringExtra("strRelationFourChildEdit");
        LongTermDiscountStatus = getIntent().getStringExtra("LongTermDiscountStatus");
        SubCategoryDiscountStatus = getIntent().getStringExtra("SubCategoryDiscountStatus");
        SubCategory = getIntent().getStringExtra("SubCategory");
        DirectPolicyDiscountPremium = getIntent().getStringExtra("DirectPolicyDiscountPremium");
        selectYearProposer = getIntent().getIntExtra("selectYearProposer", 0);
        selectYearAdult = getIntent().getIntExtra("selectYearAdult", 0);
        selectYearSecondAdult = getIntent().getIntExtra("selectYearSecondAdult", 0);
        selectYearMotherAdult = getIntent().getIntExtra("selectYearMotherAdult", 0);
        selectMotherLawAdult = getIntent().getIntExtra("selectMotherLawAdult", 0);
        selectFirstYearChild = getIntent().getIntExtra("selectFirstYearChild", 0);
        selectSecSonChild = getIntent().getIntExtra("selectSecSonChild", 0);
        selectThirdSonChild = getIntent().getIntExtra("selectThirdSonChild", 0);
        selectYearChildFour = getIntent().getIntExtra("selectYearChildFour", 0);
        LongTermDiscountDiscountPremium = getIntent().getDoubleExtra("LongTermDiscountDiscountPremium", 0.0);
        SubCategoryDiscountPremium = getIntent().getDoubleExtra("SubCategoryDiscountPremium", 0.0);
        doubleCoPaymentDiscountPremium = getIntent().getDoubleExtra("doubleCoPaymentDiscountPremium", 0.0);
        FamilyComposition = getIntent().getStringExtra("FamilyComposition");
        ParentComposition = getIntent().getStringExtra("ParentComposition");
        PersonalAccidentACoverChildFourStatus = getIntent().getStringExtra("PersonalAccidentACoverChildFourStatus");
        PersonalAccidentBCoverChildFourStatus = getIntent().getStringExtra("PersonalAccidentBCoverChildFourStatus");
        PersonalStatusChildFour = getIntent().getStringExtra("PersonalStatusChildFour");
        PersonalStatusChildThird = getIntent().getStringExtra("PersonalStatusChildThird");
        PersonalAccidentACoverChildThirdStatus = getIntent().getStringExtra("PersonalAccidentACoverChildThirdStatus");
        PersonalAccidentBCoverChildThirdStatus = getIntent().getStringExtra("PersonalAccidentBCoverChildThirdStatus");
        PersonalAccidentBChildTwoCoverStatus = getIntent().getStringExtra("PersonalAccidentBChildTwoCoverStatus");
        PersonalAccidentAChildTwoCoverStatus = getIntent().getStringExtra("PersonalAccidentAChildTwoCoverStatus");
        PersonalStatusChildTwo = getIntent().getStringExtra("PersonalStatusChildTwo");
        PersonalAccidentACoverChildOneStatus = getIntent().getStringExtra("PersonalAccidentACoverChildOneStatus");
        PersonalAccidentBCoverChildOneStatus = getIntent().getStringExtra("PersonalAccidentBCoverChildOneStatus");
        strSpouseGenderEdit = getIntent().getStringExtra("strSpouseGenderEdit");
        strSpouseNameEditText = getIntent().getStringExtra("strSpouseNameEditText");
        strSpouseOccupationEdit = getIntent().getStringExtra("strSpouseOccupationEdit");
        strSpouseDobEdit = getIntent().getStringExtra("strSpouseDobEdit");
        strFtSpouseEdit = getIntent().getStringExtra("strFtSpouseEdit");
        strInchesSpouseEdit = getIntent().getStringExtra("strInchesSpouseEdit");
        strSpouseNameEditText = getIntent().getStringExtra("strSpouseNameEditText");
        strWeightEditSpouse = getIntent().getStringExtra("strWeightEditSpouse");
        strRelationEditSpouse = getIntent().getStringExtra("strRelationEditSpouse");
        strSpouseBMIEdit = getIntent().getStringExtra("strSpouseBMIEdit");
        strGenderChildOneEdit = getIntent().getStringExtra("strGenderChildOneEdit");
        str_oneFtSpinner = getIntent().getStringExtra("str_oneFtSpinner");
        str_oneInchesSpinner = getIntent().getStringExtra("str_oneInchesSpinner");
        str_oneWeightEdit = getIntent().getStringExtra("str_oneWeightEdit");
        strOccupationEditChildOne = getIntent().getStringExtra("strOccupationEditChildOne");
        str_twoOccupationSpinner = getIntent().getStringExtra("str_twoOccupationSpinner");
        str_thirdOccupationSpinner = getIntent().getStringExtra("str_thirdOccupationSpinner");
        str_fourOccupationSpinner = getIntent().getStringExtra("str_fourOccupationSpinner");
        strMotherFeetEditText = getIntent().getStringExtra("strMotherFeetEditText");
        strInchesMotherEdit = getIntent().getStringExtra("strInchesMotherEdit");
        strMotherOccupationEdit = getIntent().getStringExtra("strMotherOccupationEdit");
        strMotherEditTextName = getIntent().getStringExtra("strMotherEditTextName");
        strMotherWeightEdit = getIntent().getStringExtra("strMotherWeightEdit");
        strMotherGenderEdit = getIntent().getStringExtra("strMotherGenderEdit");
        strMotherRelationShipEdit = getIntent().getStringExtra("strMotherRelationShipEdit");
        strBMIMotherEdit = getIntent().getStringExtra("strBMIMotherEdit");
        strInchesFatherEdit = getIntent().getStringExtra("strInchesFatherEdit");
        strFeetFatherEdit = getIntent().getStringExtra("strFeetFatherEdit");
        strFatherOccupationEdit = getIntent().getStringExtra("strFatherOccupationEdit");
        strFatherEditTextName = getIntent().getStringExtra("strFatherEditTextName");
        strFatherWeightEdit = getIntent().getStringExtra("strFatherWeightEdit");
        strFatherGenderEditTet = getIntent().getStringExtra("strFatherGenderEditTet");
        strRelationFatherEdit = getIntent().getStringExtra("strRelationFatherEdit");
        strBMIFatherEdit = getIntent().getStringExtra("strBMIFatherEdit");
        strOccupationEditMotherLaw = getIntent().getStringExtra("strOccupationEditMotherLaw");
        strFeetEditTextMotherLaw = getIntent().getStringExtra("strFeetEditTextMotherLaw");
        strInchesEditTextMotherLaw = getIntent().getStringExtra("strInchesEditTextMotherLaw");
        strMotherLawEditText = getIntent().getStringExtra("strMotherLawEditText");
        strWeightMotherLawEdit = getIntent().getStringExtra("strWeightMotherLawEdit");
        strMotherGenderEdit = getIntent().getStringExtra("strMotherGenderEdit");
        strRelationMotherLawEdit = getIntent().getStringExtra("strRelationMotherLawEdit");
        strBMIMotherLawEdit = getIntent().getStringExtra("strBMIMotherLawEdit");
        strOccupationFatherLawEdit = getIntent().getStringExtra("strOccupationFatherLawEdit");
        strEditFeetFatherLaw = getIntent().getStringExtra("strEditFeetFatherLaw");
        strEditInchesFatherLaw = getIntent().getStringExtra("strEditInchesFatherLaw");
        strFatherLawNameEdit = getIntent().getStringExtra("strFatherLawNameEdit");
        strFatherLawWeightEdit = getIntent().getStringExtra("strFatherLawWeightEdit");
        strFatherLawGenderEditText = getIntent().getStringExtra("strFatherLawGenderEditText");
        strRelationEditTextFatherLaw = getIntent().getStringExtra("strRelationEditTextFatherLaw");
        strFatherLawBMIEdit = getIntent().getStringExtra("strFatherLawBMIEdit");
        str_age = getIntent().getStringExtra("str_age");
        strBasicPremium = getIntent().getStringExtra("strBasicPremium");
        yearRadio = getIntent().getStringExtra("yearRadio");
        strPackage1 = getIntent().getStringExtra("strPackage1");
        strPackageTwo = getIntent().getStringExtra("strPackageTwo");
        strPackageThree = getIntent().getStringExtra("strPackageThree");
        strPackageFour = getIntent().getStringExtra("strPackageFour");
        strPackageFive = getIntent().getStringExtra("strPackageFive");
        strPackageSix = getIntent().getStringExtra("strPackageSix");
        strYesPhysicalMentalRadio = getIntent().getStringExtra("strYesPhysicalMentalRadio");
        strYesPreExistingRadio = getIntent().getStringExtra("strYesPreExistingRadio");
        strSelfTobaccoRadio = getIntent().getStringExtra("strSelfTobaccoRadio");
        strAlcoholEditSpinner = getIntent().getStringExtra("strAlcoholEditSpinner");
        strOccasionallyEditSpinner = getIntent().getStringExtra("strOccasionallyEditSpinner");
        strTobaccoEditSelf = getIntent().getStringExtra("strTobaccoEditSelf");
        strTobaccoOccasinallyEditSelf = getIntent().getStringExtra("strTobaccoOccasinallyEditSelf");
        strSelfAlcoholRadio = getIntent().getStringExtra("strSelfAlcoholRadio");
        PersonalAccidentCategory = getIntent().getStringExtra("PersonalAccidentCategory");
        PersonalStatusChildOne = getIntent().getStringExtra("PersonalStatusChildOne");
        strswitch = getIntent().getStringExtra("strswitch");
        strCorrespondenceAddressEdit = getIntent().getStringExtra("strCorrespondenceAddressEdit");
        strCorrespondenceAddressEdit2 = getIntent().getStringExtra("strCorrespondenceAddressEdit2");
        strProposerEdtName = getIntent().getStringExtra("strProposerEdtName");
        strProposerEditDob = getIntent().getStringExtra("strProposerEditDob");
        strProposerEditFt = getIntent().getStringExtra("strProposerEditFt");
        strProposerEditInches = getIntent().getStringExtra("strProposerEditInches");
        strEditGenderProposer = getIntent().getStringExtra("strEditGenderProposer");
        strEditOccupationProposer = getIntent().getStringExtra("strEditOccupationProposer");
        strProposerRelationEdit = getIntent().getStringExtra("strProposerRelationEdit");
        strWeightEditProposer = getIntent().getStringExtra("strWeightEditProposer");
        strProposerBMIEdit = getIntent().getStringExtra("strProposerBMIEdit");
        DailyHospitalCoverPremium = getIntent().getStringExtra("DailyHospitalCoverPremium");
        CriticalIllnessCoverPremium = getIntent().getStringExtra("CriticalIllnessCoverPremium");
        ExtensionPreHospitalizationCoverPremium = getIntent().getStringExtra("ExtensionPreHospitalizationCoverPremium");
        ExtensionProHospitalizationCoverPremium = getIntent().getStringExtra("ExtensionProHospitalizationCoverPremium");
        MaternityChildcareCoverPremium = getIntent().getStringExtra("MaternityChildcareCoverPremium");
        CoverageNonMedicalCoverPremium = getIntent().getStringExtra("CoverageNonMedicalCoverPremium");
        ConditionWaiverCoverPremium = getIntent().getStringExtra("ConditionWaiverCoverPremium");
        PersonalAccidentCoverPremium = getIntent().getStringExtra("PersonalAccidentCoverPremium");
        PreExistingDiseaseCoverPremium = getIntent().getStringExtra("PreExistingDiseaseCoverPremium");
        OutpatientDentalCoverPremium = getIntent().getStringExtra("OutpatientDentalCoverPremium");
        EmergencyTravellingCoverPremium = getIntent().getStringExtra("EmergencyTravellingCoverPremium");
        SecondOpinionCoverPremium = getIntent().getStringExtra("SecondOpinionCoverPremium");
        RestCureCoverPremium = getIntent().getStringExtra("RestCureCoverPremium");
        ObesityWeightCoverPremium = getIntent().getStringExtra("ObesityWeightCoverPremium");
        SterilityInfertilityCoverPremium = getIntent().getStringExtra("SterilityInfertilityCoverPremium");
        EnhancedCoverPremium = getIntent().getStringExtra("EnhancedCoverPremium");
        MedicallyAdvisedCoverPremium = getIntent().getStringExtra("MedicallyAdvisedCoverPremium");
        EmergencyAssistanceCoverPremium = getIntent().getStringExtra("EmergencyAssistanceCoverPremium");
        HomeCareCoverPremium = getIntent().getStringExtra("HomeCareCoverPremium");
        WellnessBenefitCoverPremium = getIntent().getStringExtra("WellnessBenefitCoverPremium");
        DiseaseManagementCoverPremium = getIntent().getStringExtra("DiseaseManagementCoverPremium");
        GlobalCoverCoverPremium = getIntent().getStringExtra("GlobalCoverCoverPremium");
        ModernTreatmentCoverPremium = getIntent().getStringExtra("ModernTreatmentCoverPremium");
        PremiumWaiverCoverPremium = getIntent().getStringExtra("PremiumWaiverCoverPremium");
        OrganDiscountStatus = getIntent().getStringExtra("OrganDiscountStatus");
        OrganDonorDiscountPremium = getIntent().getDoubleExtra("OrganDonorDiscountPremium", 0.0);
        strAppointeeNomineeName = getIntent().getStringExtra("strAppointeeNomineeName");
        strAppointeeNomineeDobEdit = getIntent().getStringExtra("strAppointeeNomineeDobEdit");
        strAppointeeGenderEdit = getIntent().getStringExtra("strAppointeeGenderEdit");
        selectNomineeYear = getIntent().getIntExtra("selectNomineeYear", 0);
        strMedicalHistoryRadio = getIntent().getStringExtra("strMedicalHistoryRadio");
        strMedicineRadio = getIntent().getStringExtra("strMedicineRadio");
        strHospitalizationHistory = getIntent().getStringExtra("strHospitalizationHistory");
        checkPackage = getIntent().getStringExtra("checkPackage");
        CoPaymentCheckBoxCheck = getIntent().getStringExtra("CoPaymentCheckBoxCheck");
        SubCategoryDiscountStatusCheck = getIntent().getStringExtra("SubCategoryDiscountStatusCheck");
        strCoPaymentEditText = getIntent().getStringExtra("strCoPaymentEditText");
        strSubLimitEditText = getIntent().getStringExtra("strSubLimitEditText");
        selectFirstYearChild = getIntent().getIntExtra("selectFirstYearChild", 0);
        selectSecSonChild = getIntent().getIntExtra("selectSecSonChild", 0);
        selectThirdSonChild = getIntent().getIntExtra("selectThirdSonChild", 0);
        selectYearChildFour = getIntent().getIntExtra("selectYearChildFour", 0);
        selectYearAdult = getIntent().getIntExtra("selectYearAdult", 0);
        selectYearSecondAdult = getIntent().getIntExtra("selectYearSecondAdult", 0);
        selectYearMotherAdult = getIntent().getIntExtra("selectYearMotherAdult", 0);
        selectMotherLawAdult = getIntent().getIntExtra("selectMotherLawAdult", 0);
        selectFatherLawAdult = getIntent().getIntExtra("selectFatherLawAdult", 0);
        selectYearFatherAdult = getIntent().getIntExtra("selectYearFatherAdult", 0);
        strSufferingDiseaseSecondAdult = getIntent().getStringExtra("strSufferingDiseaseSecondAdult");
        strSpousePhysicalRadio = getIntent().getStringExtra("strSpousePhysicalRadio");
        strDiseaseSpouseRadio = getIntent().getStringExtra("strDiseaseSpouseRadio");
        strHospitalizationHistoryAdultSecond = getIntent().getStringExtra("strHospitalizationHistoryAdultSecond");
        strConsumeSpouseAlcohol = getIntent().getStringExtra("strConsumeSpouseAlcohol");
        strSpouseTobaccoRadio = getIntent().getStringExtra("strSpouseTobaccoRadio");
        strSpouseEditFrequency = getIntent().getStringExtra("strSpouseEditFrequency");
        strOccasionallySpouseEditSpinner = getIntent().getStringExtra("strOccasionallySpouseEditSpinner");
        strTobaccoEditSpouse = getIntent().getStringExtra("strTobaccoEditSpouse");
        strTobaccoOccasinallyEditSpouse = getIntent().getStringExtra("strTobaccoOccasinallyEditSpouse");
        GSt = getIntent().getStringExtra("GSt");
        OrganDonar = getIntent().getDoubleExtra("OrganDonar",0.00);
        LongTerm = getIntent().getDoubleExtra("LongTerm",0.00);
        sublimt = getIntent().getDoubleExtra("sublimt",0.00);
        copayemntMax = getIntent().getIntExtra("copayemntMax", 0);
        TiresDiscount = getIntent().getIntExtra("TiresDiscount", 0);
        DirectPolicy = getIntent().getIntExtra("DirectPolicy", 0);
        loyalityDiscount = getIntent().getIntExtra("loyalityDiscount", 0);
        strEmailIDEditSelf = getIntent().getStringExtra("strEmailIDEditSelf");
        strPinCodeEdit = getIntent().getStringExtra("strPinCodeEdit");
        strCityEdit = getIntent().getStringExtra("strCityEdit");
        strStateEdit = getIntent().getStringExtra("strStateEdit");
        address1 = getIntent().getStringExtra("address1");
        address2 = getIntent().getStringExtra("address2");
        address3 = getIntent().getStringExtra("address3");
        corresAddress1 = getIntent().getStringExtra("corresAddress1");
        corresAddress2 = getIntent().getStringExtra("corresAddress2");
        corresAddress3 = getIntent().getStringExtra("corresAddress3");
        firstName = getIntent().getStringExtra("firstName");
        middleName = getIntent().getStringExtra("middleName");
        lastName = getIntent().getStringExtra("lastName");
        ckycNo = getIntent().getStringExtra("ckycNo");
        uniqueTransactionNumber = getIntent().getStringExtra("uniqueTransactionNumber");
        permAndCorresAddSame = getIntent().getStringExtra("permAndCorresAddSame");
        strDob = getIntent().getStringExtra("strDob");
        strIDTypeName = getIntent().getStringExtra("strIDTypeName");
        TreatmentStatus = getIntent().getStringExtra("TreatmentStatus");

        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);

        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        tomorrowDate = formatter.format(date);
        Log.e("tomorrowDate",tomorrowDate);

        if (strPolicyTenure.equals("2")){
            calendar.add(Calendar.DATE, 364 * 2);
            date = calendar.getTime();
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            nextYear = formatter.format(date);
        }else if(strPolicyTenure.equals("3")){
            calendar.add(Calendar.DATE, 364*3);
            date = calendar.getTime();
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            nextYear = formatter.format(date);
        }else{
            calendar.add(Calendar.DATE, 364);
            date = calendar.getTime();
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            nextYear = formatter.format(date);
        }
        if (strIDTypeName.equals("Reference Number")){
            ckycNo="EM000001";
        }


        SummeryBack=findViewById(R.id.SummeryBack);
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
        DiscountsTxt=findViewById(R.id.DiscountsTxt);
        GSTTxt=findViewById(R.id.GSTTxt);
        TotalPremiumTxt=findViewById(R.id.TotalPremiumTxt);
        TotalValue=findViewById(R.id.TotalValue);
        PolicyPlanTxt=findViewById(R.id.PolicyPlanTxt);
        continueButton=findViewById(R.id.continueButton);
        checkBox=findViewById(R.id.checkBox);
        BasicPremiumTxt=findViewById(R.id.BasicPremiumTxt);
        DirectPolicyDiscountTxt=findViewById(R.id.DirectPolicyDiscountTxt);


        SelfName.setText(strEdtNameSelf);
        SelfDOB.setText(strSelfAgeEditText);
        selfMobileNumber.setText(str_edt_phone);
        selfEmailId.setText(strEmailIDEditSelf);
        NomineeName.setText(strNomineeName);
        NomineeRelation.setText(strNomineeRelationEdit);
        SumInsuredTxt.setText(strSumInsured);
        PolicyPlanTxt.setText(PlanType);
        PolicyStartDateTxt.setText(tomorrowDate);
        NetPremiumTxt.setText(NetPremium);
        TotalPremiumTxt.setText(strTotalPremium);
        TotalValue.setText(strTotalPremium);
        BasicPremiumTxt.setText(strBasicPremium);
        DirectPolicyDiscountTxt.setText(DirectPolicyDiscountPremium);
        PolicyTenureTxt.setText(strPolicyTenure+" Year");
        addonsTxt.setText(String.valueOf(addons));
        DiscountsTxt.setText(String.valueOf(Math.round(Discounts * 100.0) / 100.0));

        if (selectFirstYearChild < 5) {
            PersonalStatusChildOne = "False";
            PersonalAccidentACoverChildOneStatus = "False";
            PersonalAccidentBCoverChildOneStatus = "False";

        }
        if (selectSecSonChild <5) {
            PersonalStatusChildTwo = "False";
            PersonalAccidentAChildTwoCoverStatus = "False";
            PersonalAccidentBChildTwoCoverStatus = "False";
        }
        if (selectThirdSonChild <5) {
            PersonalStatusChildThird = "False";
            PersonalAccidentACoverChildThirdStatus = "False";
            PersonalAccidentBCoverChildThirdStatus = "False";
        }
        if (selectYearChildFour <5) {
            PersonalStatusChildFour = "False";
            PersonalAccidentACoverChildFourStatus = "False";
            PersonalAccidentBCoverChildFourStatus = "False";
        }
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strBloodSugar="75";
                strBloodPressure="95";
                strBloodPressureDiastolic="65";
                strcholesterol="155";
                if (!checkBox.isChecked()){
                    Toast.makeText(ChiSummery.this, "Accept Terms & Condition", Toast.LENGTH_SHORT).show();
                }else{
                    health_quote();
                }

            }
        });

        SummeryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backMethod();
            }
        });
        if (strEditGenderProposer.equals("Male")){
            strEditGenderProposer="M";
        }else if (strEditGenderProposer.equals("Female")){
            strEditGenderProposer="F";
        }else{
            strEditGenderProposer="";
        }
        if (strEditGenderSelf.equals("Male")){
            strEditGenderSelf="M";
        }else if (strEditGenderSelf.equals("Female")){
            strEditGenderSelf="F";
        }

        if (strCheckBoxSpouse.equals("Checked")) {
            if (strSpouseGenderEdit.equals("Male")){
                strSpouseGenderEdit="M";
            }else if (strSpouseGenderEdit.equals("Female")){
                strSpouseGenderEdit="F";
            }
        }

        if (strGenderChildOneEdit.equals("Male")){
            strGenderChildOneEdit="M";
        }else if (strGenderChildOneEdit.equals("Female")){
            strGenderChildOneEdit="F";
        }
        if (str_twoGenderSpinner.equals("Male")){
            str_twoGenderSpinner="M";
        }else if (str_twoGenderSpinner.equals("Female")){
            str_twoGenderSpinner="F";
        }
        if (str_thirdGenderSpinner.equals("Male")){
            str_thirdGenderSpinner="M";
        }else if (str_thirdGenderSpinner.equals("Female")){
            str_thirdGenderSpinner="F";
        }
        if (str_fourGenderSpinner.equals("Male")){
            str_fourGenderSpinner="M";
        }else if (str_fourGenderSpinner.equals("Female")){
            str_fourGenderSpinner="F";
        }

//        if (strProposerEditDob.equals("Select Dob")){
//            strProposerEditDob="";
//        }

        if (strCheckBoxSelf.equals("Checked")) {
            strProposerEdtName=strEdtNameSelf;
            strProposerEditDob=strSelfAgeEditText;
            strEditGenderProposer=strEditGenderSelf;
        }else{
//            strEmailIDEditSelf=str_email;
//            strPermanentAddressEdit=pref.getaddress();
//            strStateEdit=pref.getstate();
//            strCityEdit=pref.getcity();
//            strPinCodeEdit=pref.getpincode();
        }
    }
    private void health_quote() {
        strBloodSugar="NA";
        strBloodPressure="NA";
        strBloodPressureDiastolic="NA";
        strcholesterol="NA";
        if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
            str_policyType_spinner1=str_policyType_spinner;
        }else{
            if (strCheckBoxSelf.equals("Checked")||strCheckBoxSpouse.equals("Checked")){
                if (strCheckBoxMother.equals("Checked") && strCheckBoxFather.equals("Checked")) {
                    str_policyType_spinner1 = "Family Floater";
                }else if(strCheckBoxMotherLaw.equals("Checked") && strCheckBoxFatherLaw.equals("Checked")){
                    str_policyType_spinner1 = "Family Floater";
                }else if (strCheckBoxMother.equals("Checked")||strCheckBoxFather.equals("Checked")||strCheckBoxMotherLaw.equals("Checked")||strCheckBoxFatherLaw.equals("Checked")) {
                    str_policyType_spinner1="Individual";
                }else{
                    str_policyType_spinner1=str_policyType_spinner;
                }
            }else{
                str_policyType_spinner1=str_policyType_spinner;
            }
        }

        JSONObject object = new JSONObject();
        try {
            JSONObject RootObject = new JSONObject();
            //Authentication
            JSONObject AuthenticationObject = new JSONObject();
//            AuthenticationObject.put("WACode","20000001");
//            AuthenticationObject.put("WAAppCode","30000011");
            AuthenticationObject.put("WACode","20000149");
            AuthenticationObject.put("WAAppCode","30000149");
            AuthenticationObject.put("WAUserID","USER01");
            AuthenticationObject.put("WAUserPwd","pass@123");
            AuthenticationObject.put("WAType","0");
            RootObject.put("Authentication",AuthenticationObject);
            //Customer
            JSONObject CustomerObject = new JSONObject();
            CustomerObject.put("CustomerType","Individual");
            CustomerObject.put("CustomerName",strProposerEdtName);
            CustomerObject.put("DOB",strProposerEditDob);
            CustomerObject.put("Gender",strEditGenderProposer);
            CustomerObject.put("CanBeParent","");
            CustomerObject.put("ContactTelephoneSTD","");
            CustomerObject.put("MobileNo",str_edt_phone);
            CustomerObject.put("Emailid",strEmailIDEditSelf);
            CustomerObject.put("PresentAddressLine1",strPermanentAddressEdit);
            CustomerObject.put("PresentAddressLine2",strPermanentAddressEdit2);
            CustomerObject.put("PresentStateCode",strStateEdit);
            CustomerObject.put("PresentCityDistCode",strCityEdit);
            CustomerObject.put("PresentPinCode",strPinCodeEdit);
            CustomerObject.put("PermanentAddressLine1",strPermanentAddressEdit);
            CustomerObject.put("PermanentAddressLine2",strPermanentAddressEdit2);
            CustomerObject.put("PermanentStateCode",strStateEdit);
            CustomerObject.put("PermanentCityDistCode",strCityEdit);
            CustomerObject.put("PermanentPinCode",strPinCodeEdit);
            CustomerObject.put("CustGSTNo","NULL");
            CustomerObject.put("ProductName","Complete HealthCare Insurance");
            CustomerObject.put("InstrumentNo","NULL");
            CustomerObject.put("InstrumentDate","NULL");
            CustomerObject.put("BankID","NULL");
            CustomerObject.put("PosPolicyNo","");
            CustomerObject.put("ProductCode","2825");
            CustomerObject.put("WAURN","NULL");
            CustomerObject.put("NomineeName","");
            CustomerObject.put("NomineeRelation","");
            CustomerObject.put("PANNo","NULL");
            CustomerObject.put("AadhaarNo","");
            CustomerObject.put("EIA","NULL");
            CustomerObject.put("CKYCNo", ckycNo);
            CustomerObject.put("Ref_No_Unique_KYC", uniqueTransactionNumber);
            RootObject.put("Customer",CustomerObject);
            //POSAGENT
            JSONObject POSAGENTObject = new JSONObject();
            POSAGENTObject.put("Name","NULL");
            POSAGENTObject.put("PAN","NULL");
            POSAGENTObject.put("Aadhar","NULL");
            POSAGENTObject.put("Email","NULL");
            POSAGENTObject.put("MobileNo","NULL");
            POSAGENTObject.put("Location","MUMBAI CORPORATE OFFICE");
            POSAGENTObject.put("Information1","NULL");
            POSAGENTObject.put("Information2","NULL");
            RootObject.put("POSAGENT",POSAGENTObject);

            JSONObject ProductObject = new JSONObject();
            JSONObject GeneralProposalObject = new JSONObject();
            JSONObject GeneralProposalGroupObject = new JSONObject();
            JSONObject DistributionChannelObject = new JSONObject();
            //Branch
            JSONObject BranchDetailsObject = new JSONObject();

            BranchDetailsObject.put("IMDBranchName","NULL");
            BranchDetailsObject.put("IMDBranchCode","NULL");
            DistributionChannelObject.put("BranchDetails",BranchDetailsObject);
            //SpDetails
            JSONObject SPDetailsObject = new JSONObject();
            SPDetailsObject.put("SPName","NULL");
            SPDetailsObject.put("SPCode","NULL");
            DistributionChannelObject.put("SPDetails",SPDetailsObject);
            GeneralProposalGroupObject.put("DistributionChannel",DistributionChannelObject);

            //GeneralProposalInformation
            JSONObject GeneralProposalInformationObject = new JSONObject();
            GeneralProposalInformationObject.put("TypeOfBusiness","");
            GeneralProposalInformationObject.put("ServiceTaxExemptionCategory","");
            GeneralProposalInformationObject.put("BusinessType","New");
            GeneralProposalInformationObject.put("Sector","");
            GeneralProposalInformationObject.put("DealId","INTR-2312-0019722");
            GeneralProposalInformationObject.put("PolicyType",str_policyType_spinner1);
            GeneralProposalInformationObject.put("FamilyComposition",FamilyComposition);
            GeneralProposalInformationObject.put("ParentComposition",ParentComposition);
            GeneralProposalInformationObject.put("PlanType",PlanType);
            GeneralProposalInformationObject.put("ProposalDate",tomorrowDate);
            GeneralProposalInformationObject.put("PolicyDuration",strPolicyTenure);
            GeneralProposalInformationObject.put("PolicyNumberChar","NULL");
            //PolicyEffectiveDate
            JSONObject PolicyEffectiveDateObject = new JSONObject();
            PolicyEffectiveDateObject.put("Fromdate",tomorrowDate);
            PolicyEffectiveDateObject.put("Todate",nextYear);
            PolicyEffectiveDateObject.put("Fromhour","00:01");
            PolicyEffectiveDateObject.put("Tohour","23:59");
            GeneralProposalInformationObject.put("PolicyEffectiveDate",PolicyEffectiveDateObject);

            GeneralProposalInformationObject.put("SubCategory",SubCategory);
            GeneralProposalInformationObject.put("EmployeeCode","");
            GeneralProposalInformationObject.put("ExsistingPolicyNumber",strPolicyNumber);
            GeneralProposalInformationObject.put("PersonalAccidentCategory",PersonalAccidentCategory);
            GeneralProposalInformationObject.put("CoPaymentLoading",CoPaymentLoading);
            GeneralProposalInformationObject.put("RequestType", "Proposal");
            GeneralProposalGroupObject.put("GeneralProposalInformation",GeneralProposalInformationObject);
            GeneralProposalObject.put("GeneralProposalGroup",GeneralProposalGroupObject);

            //FinancierDetails
            JSONObject FinancierDetailsObject = new JSONObject();
            JSONObject FinancierDtlGrpObject = new JSONObject();
            JSONObject FinancierDtlGrpDataObject = new JSONObject();
            FinancierDtlGrpDataObject.put("FinancierCode","NULL");
            FinancierDtlGrpDataObject.put("AgreementType","NULL");
            FinancierDtlGrpDataObject.put("BranchName","NULL");
            FinancierDtlGrpDataObject.put("FinancierName","NULL");
            FinancierDtlGrpDataObject.put("SrNo","NULL");
            FinancierDtlGrpObject.put("FinancierDtlGrpData",FinancierDtlGrpDataObject);
            FinancierDetailsObject.put("FinancierDtlGrp",FinancierDtlGrpObject);
            GeneralProposalObject.put("FinancierDetails",FinancierDetailsObject);

            //PreviousPolicyDetails
            JSONObject PreviousPolicyDetailsObject = new JSONObject();
            JSONObject PreviousPolDtlGroupObject = new JSONObject();
            JSONObject PreviousPolDtlGroupDataObject = new JSONObject();
            PreviousPolDtlGroupDataObject.put("ProductCode","NULL");
            PreviousPolDtlGroupDataObject.put("ClaimSettled","NULL");
            PreviousPolDtlGroupDataObject.put("ClaimPremium","0");
            PreviousPolDtlGroupDataObject.put("ClaimAmount","0");
            PreviousPolDtlGroupDataObject.put("DateofLoss","NULL");
            PreviousPolDtlGroupDataObject.put("NatureofLoss","NULL");
            PreviousPolDtlGroupDataObject.put("ClaimNo","");
            PreviousPolDtlGroupDataObject.put("PolicyEffectiveTo","");
            PreviousPolDtlGroupDataObject.put("PolicyEffectiveFrom","");
            PreviousPolDtlGroupDataObject.put("PolicyPremium","0");
            PreviousPolDtlGroupDataObject.put("PolicyNo","NULL");
            PreviousPolDtlGroupDataObject.put("PolicyYear","NULL");
            PreviousPolDtlGroupDataObject.put("OfficeCode","NULL");
            PreviousPolDtlGroupDataObject.put("CorporateCustomerId","NULL");
            PreviousPolDtlGroupDataObject.put("InsurerName","NULL");
            PreviousPolDtlGroupDataObject.put("InsurerAddress","NULL");
            PreviousPolDtlGroupObject.put("PreviousPolDtlGroupData",PreviousPolDtlGroupDataObject);
            PreviousPolicyDetailsObject.put("PreviousPolDtlGroup",PreviousPolDtlGroupObject);
            PreviousPolicyDetailsObject.put("PreviousPolicyType","Package Policy");
            PreviousPolicyDetailsObject.put("OfficeAddress","NULL");
            GeneralProposalObject.put("PreviousPolicyDetails",PreviousPolicyDetailsObject);
            ProductObject.put("GeneralProposal",GeneralProposalObject);

            //PremiumCalculation
            JSONObject PremiumCalculationObject = new JSONObject();
            PremiumCalculationObject.put("NetPremium","0");
            PremiumCalculationObject.put("ServiceTax","0");
            PremiumCalculationObject.put("StampDuty2","0");
            PremiumCalculationObject.put("TotalPremium","0");
            PremiumCalculationObject.put("CGST","0");
            PremiumCalculationObject.put("SGST","");
            PremiumCalculationObject.put("UGST","0");
            PremiumCalculationObject.put("IGST","0");
            ProductObject.put("PremiumCalculation",PremiumCalculationObject);
//            ProductObject.put("PremiumCalculation",PremiumCalculationObject);
//            ProductObject.put("PremiumCalculation",GeneralProposalObject);

            //Risks
            JSONObject RisksObject = new JSONObject();
            JSONObject RiskObject = new JSONObject();
            JSONObject RisksDataObject = new JSONObject();
            JSONObject InsuredDetailsObject = new JSONObject();
            JSONArray InsuredDetailsGroupArray = new JSONArray();


                JSONObject InsuredDetailsObj=new JSONObject();
                InsuredDetailsObj.put("InsuredType","Adult");
                InsuredDetailsObj.put("FirstName",strEdtNameSelf);
                InsuredDetailsObj.put("LastName","");
                InsuredDetailsObj.put("DOB",strSelfAgeEditText);
                InsuredDetailsObj.put("Gender",strEditGenderSelf);
                InsuredDetailsObj.put("Relationship",strRelationAdultOneEdit);
                InsuredDetailsObj.put("Occupation",strEditOccupationSelf);
                InsuredDetailsObj.put("NomineeName",strNomineeName);
                InsuredDetailsObj.put("NomineeRelationship",strNomineeRelationEdit);

                JSONObject HealthIndicatorsObj=new JSONObject();
                HealthIndicatorsObj.put("PED","N");
                HealthIndicatorsObj.put("PEDDeclared","N");
                HealthIndicatorsObj.put("BloodSugarLevel",strBloodSugar);
                HealthIndicatorsObj.put("BloodPressureSystolic",strBloodPressure);
                HealthIndicatorsObj.put("BloodPressureDiastolic",strBloodPressureDiastolic);
                HealthIndicatorsObj.put("CholesterolLevel",strcholesterol);
                HealthIndicatorsObj.put("BodyMassIndex",strBMIEdit);
                HealthIndicatorsObj.put("TobaccoAndAlcohol","N");
                HealthIndicatorsObj.put("CoMorbidity","N");
                InsuredDetailsObj.put("HealthIndicators",HealthIndicatorsObj);

                JSONObject CoverDetailsObj=new JSONObject();
                JSONArray CoversArray = new JSONArray();
                JSONObject BasicInsuranceCoversObj=new JSONObject();
                BasicInsuranceCoversObj.put("Applicable","True");
                BasicInsuranceCoversObj.put("CoverSI",strSumInsured);
                BasicInsuranceCoversObj.put("CoverRate","0");
                BasicInsuranceCoversObj.put("CoverPremium","0");
                BasicInsuranceCoversObj.put("CoverGroups","Basic Insurance Cover");
                CoversArray.put(BasicInsuranceCoversObj);

                JSONObject PersonalAccidentCoversObj=new JSONObject();
                PersonalAccidentCoversObj.put("Applicable",PersonalStatus);
                PersonalAccidentCoversObj.put("CoverSI",strSumInsured);
                PersonalAccidentCoversObj.put("CoverRate","0");
                PersonalAccidentCoversObj.put("CoverPremium","0");
                PersonalAccidentCoversObj.put("CoverGroups","Personal Accident Cover");
                CoversArray.put(PersonalAccidentCoversObj);

                JSONObject CriticalIllnessCoversObj=new JSONObject();
                CriticalIllnessCoversObj.put("Applicable",CriticalStatus);
                CriticalIllnessCoversObj.put("CoverSI",strSumInsured);
                CriticalIllnessCoversObj.put("CoverRate","0");
                CriticalIllnessCoversObj.put("CoverPremium","0");
                CriticalIllnessCoversObj.put("CoverGroups","Critical Illness Cover");
                CoversArray.put(CriticalIllnessCoversObj);


                JSONObject DailyHospitalCoversObj=new JSONObject();
                DailyHospitalCoversObj.put("Applicable",DailyHospitalSatus);
                DailyHospitalCoversObj.put("CoverSI",strSumInsured);
                DailyHospitalCoversObj.put("CoverRate","0");
                DailyHospitalCoversObj.put("CoverPremium","0");
                DailyHospitalCoversObj.put("CoverGroups","Daily Hospital Cash Cover");
                CoversArray.put(DailyHospitalCoversObj);

                JSONObject ModernCoversObj=new JSONObject();
                ModernCoversObj.put("Applicable",ModernTreatmentsStatus);
                ModernCoversObj.put("CoverSI",strSumInsured);
                ModernCoversObj.put("CoverRate","0");
                ModernCoversObj.put("CoverPremium","0");
                ModernCoversObj.put("CoverGroups","Modern Treatments");
                CoversArray.put(ModernCoversObj);
                JSONObject ExtensionPreHospitalizationCoversObj=new JSONObject();
                ExtensionPreHospitalizationCoversObj.put("Applicable",ExtensionPreHospitalization);
                ExtensionPreHospitalizationCoversObj.put("CoverSI",strSumInsured);
                ExtensionPreHospitalizationCoversObj.put("CoverRate","0");
                ExtensionPreHospitalizationCoversObj.put("CoverPremium","0");
                ExtensionPreHospitalizationCoversObj.put("CoverGroups","Extension under Pre-Hospitalization");
                CoversArray.put(ExtensionPreHospitalizationCoversObj);

                JSONObject ExtensionPostHospitalizationCoversObj=new JSONObject();
                ExtensionPostHospitalizationCoversObj.put("Applicable",ExtensionPr0Hospitalization);
                ExtensionPostHospitalizationCoversObj.put("CoverSI",strSumInsured);
                ExtensionPostHospitalizationCoversObj.put("CoverRate","0");
                ExtensionPostHospitalizationCoversObj.put("CoverPremium","0");
                ExtensionPostHospitalizationCoversObj.put("CoverGroups","Extension under Post-Hospitalization");
                CoversArray.put(ExtensionPostHospitalizationCoversObj);


                JSONObject MaternityAndChildcareCoversObj=new JSONObject();
                MaternityAndChildcareCoversObj.put("Applicable",MaternityAndChildcareMale);
                MaternityAndChildcareCoversObj.put("CoverSI",strSumInsured);
                MaternityAndChildcareCoversObj.put("CoverRate","0");
                MaternityAndChildcareCoversObj.put("CoverPremium","0");
                MaternityAndChildcareCoversObj.put("CoverGroups","Maternity and Childcare Benefit Waiting Period Modification");
                CoversArray.put(MaternityAndChildcareCoversObj);

                JSONObject CoverageForNonMedicalCoversObj=new JSONObject();
                CoverageForNonMedicalCoversObj.put("Applicable",CoverageNonMedical);
                CoverageForNonMedicalCoversObj.put("CoverSI",strSumInsured);
                CoverageForNonMedicalCoversObj.put("CoverRate","0");
                CoverageForNonMedicalCoversObj.put("CoverPremium","0");
                CoverageForNonMedicalCoversObj.put("CoverGroups","Coverage for Non-Medical Items");
                CoversArray.put(CoverageForNonMedicalCoversObj);

                JSONObject ConditionWaiverCoversObj=new JSONObject();
                ConditionWaiverCoversObj.put("Applicable",ConditionWaiverStatus);
                ConditionWaiverCoversObj.put("CoverSI",strSumInsured);
                ConditionWaiverCoversObj.put("CoverRate","0");
                ConditionWaiverCoversObj.put("CoverPremium","0");
                ConditionWaiverCoversObj.put("CoverGroups","Condition waiver under Restore Benefit");
                CoversArray.put(ConditionWaiverCoversObj);

                JSONObject PreExistingDiseaseCoversObj=new JSONObject();
                PreExistingDiseaseCoversObj.put("Applicable",PreExistingDiseaseStatus);
                PreExistingDiseaseCoversObj.put("CoverSI",strSumInsured);
                PreExistingDiseaseCoversObj.put("CoverRate","0");
                PreExistingDiseaseCoversObj.put("CoverPremium","0");
                PreExistingDiseaseCoversObj.put("CoverGroups","Pre-Existing Disease waiting period");
                CoversArray.put(PreExistingDiseaseCoversObj);

                JSONObject OutpatientDentalWaitingCoversObj=new JSONObject();
                OutpatientDentalWaitingCoversObj.put("Applicable",OutpatientDentalStatus);
                OutpatientDentalWaitingCoversObj.put("CoverSI",strSumInsured);
                OutpatientDentalWaitingCoversObj.put("CoverRate","0");
                OutpatientDentalWaitingCoversObj.put("CoverPremium","0");
                OutpatientDentalWaitingCoversObj.put("CoverGroups","Outpatient Dental Waiting Period Modification");
                CoversArray.put(OutpatientDentalWaitingCoversObj);

                JSONObject EmergencyTravellingAllowanceCoversObj=new JSONObject();
                EmergencyTravellingAllowanceCoversObj.put("Applicable",EmergencyTravellingStatus);
                EmergencyTravellingAllowanceCoversObj.put("CoverSI",strSumInsured);
                EmergencyTravellingAllowanceCoversObj.put("CoverRate","0");
                EmergencyTravellingAllowanceCoversObj.put("CoverPremium","0");
                EmergencyTravellingAllowanceCoversObj.put("CoverGroups","Emergency Travelling Allowance");
                CoversArray.put(EmergencyTravellingAllowanceCoversObj);

                JSONObject SecondOpinionCoversObj=new JSONObject();
                SecondOpinionCoversObj.put("Applicable",SecondOpinionStatus);
                SecondOpinionCoversObj.put("CoverSI",strSumInsured);
                SecondOpinionCoversObj.put("CoverRate","0");
                SecondOpinionCoversObj.put("CoverPremium","0");
                SecondOpinionCoversObj.put("CoverGroups","Second Opinion");
                CoversArray.put(SecondOpinionCoversObj);

                JSONObject RestCureCoversObj=new JSONObject();
                RestCureCoversObj.put("Applicable",RestCureStatus);
                RestCureCoversObj.put("CoverSI",strSumInsured);
                RestCureCoversObj.put("CoverRate","0");
                RestCureCoversObj.put("CoverPremium","0");
                RestCureCoversObj.put("CoverGroups","Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
                CoversArray.put(RestCureCoversObj);

                JSONObject ObesityWeightCoversObj=new JSONObject();
                ObesityWeightCoversObj.put("Applicable",ObesityWeightStatus);
                ObesityWeightCoversObj.put("CoverSI",strSumInsured);
                ObesityWeightCoversObj.put("CoverRate","0");
                ObesityWeightCoversObj.put("CoverPremium","0");
                ObesityWeightCoversObj.put("CoverGroups","Obesity/ Weight Control Expenses Extension");
                CoversArray.put(ObesityWeightCoversObj);

                JSONObject SterilityInfertilityCoversObj=new JSONObject();
                SterilityInfertilityCoversObj.put("Applicable",SterilityInfertilityMale);
                SterilityInfertilityCoversObj.put("CoverSI",strSumInsured);
                SterilityInfertilityCoversObj.put("CoverRate","0");
                SterilityInfertilityCoversObj.put("CoverPremium","0");
                SterilityInfertilityCoversObj.put("CoverGroups","Sterility and Infertility Treatment Expenses Extension");
                CoversArray.put(SterilityInfertilityCoversObj);

                JSONObject EnhancedOrganDonorCoversObj=new JSONObject();
                EnhancedOrganDonorCoversObj.put("Applicable",EnhancedOrganStatus);
                EnhancedOrganDonorCoversObj.put("CoverSI",strSumInsured);
                EnhancedOrganDonorCoversObj.put("CoverRate","0");
                EnhancedOrganDonorCoversObj.put("CoverPremium","0");
                EnhancedOrganDonorCoversObj.put("CoverGroups","Enhanced Organ Donor Expenses");
                CoversArray.put(EnhancedOrganDonorCoversObj);

                JSONObject PremiumWaiverCoversObj=new JSONObject();
                PremiumWaiverCoversObj.put("Applicable",PremiumWaiverStatus);
                PremiumWaiverCoversObj.put("CoverSI",strSumInsured);
                PremiumWaiverCoversObj.put("CoverRate","0");
                PremiumWaiverCoversObj.put("CoverPremium","0");
                PremiumWaiverCoversObj.put("CoverGroups","Premium Waiver");
                CoversArray.put(PremiumWaiverCoversObj);

                JSONObject GlobalCoversObj=new JSONObject();
                GlobalCoversObj.put("Applicable",GlobalCoverStatus);
                GlobalCoversObj.put("CoverSI",strSumInsured);
                GlobalCoversObj.put("CoverRate","0");
                GlobalCoversObj.put("CoverPremium","0");
                GlobalCoversObj.put("CoverGroups","Global Cover");
                CoversArray.put(GlobalCoversObj);


                JSONObject MedicallyAdvisedCoversObj=new JSONObject();
                MedicallyAdvisedCoversObj.put("Applicable",MedicallyAdvisedStatus);
                MedicallyAdvisedCoversObj.put("CoverSI",strSumInsured);
                MedicallyAdvisedCoversObj.put("CoverRate","0");
                MedicallyAdvisedCoversObj.put("CoverPremium","0");
                MedicallyAdvisedCoversObj.put("CoverGroups","Medically Advised Support Devices");
                CoversArray.put(MedicallyAdvisedCoversObj);

                JSONObject EmergencyCoversObj=new JSONObject();
                EmergencyCoversObj.put("Applicable",EmergencyAssistanceStatus);
                EmergencyCoversObj.put("CoverSI",strSumInsured);
                EmergencyCoversObj.put("CoverRate","0");
                EmergencyCoversObj.put("CoverPremium","0");
                EmergencyCoversObj.put("CoverGroups","Emergency Assistance Service");
                CoversArray.put(EmergencyCoversObj);

                JSONObject HomeCareTreatmentCoversObj=new JSONObject();
                HomeCareTreatmentCoversObj.put("Applicable",HomeCareStatus);
                HomeCareTreatmentCoversObj.put("CoverSI",strSumInsured);
                HomeCareTreatmentCoversObj.put("CoverRate","0");
                HomeCareTreatmentCoversObj.put("CoverPremium","0");
                HomeCareTreatmentCoversObj.put("CoverGroups","Home Care Treatment");
                CoversArray.put(HomeCareTreatmentCoversObj);

                JSONObject WellnessBenefitCoversObj=new JSONObject();
                WellnessBenefitCoversObj.put("Applicable",WellnessBenefitStatus);
                WellnessBenefitCoversObj.put("CoverSI",strSumInsured);
                WellnessBenefitCoversObj.put("CoverRate","0");
                WellnessBenefitCoversObj.put("CoverPremium","0");
                WellnessBenefitCoversObj.put("CoverGroups","Wellness Benefit");
                CoversArray.put(WellnessBenefitCoversObj);

                JSONObject DiseaseManagementCoversObj=new JSONObject();
                DiseaseManagementCoversObj.put("Applicable",DiseaseManagementStatus);
                DiseaseManagementCoversObj.put("CoverSI",strSumInsured);
                DiseaseManagementCoversObj.put("CoverRate","0");
                DiseaseManagementCoversObj.put("CoverPremium","0");
                DiseaseManagementCoversObj.put("CoverGroups","Disease Management Program");
                CoversArray.put(DiseaseManagementCoversObj);
                CoverDetailsObj.put("Covers",CoversArray);
                InsuredDetailsObj.put("CoverDetails",CoverDetailsObj);

                //2nd Adult
                JSONObject SecondAdultObj=new JSONObject();
                SecondAdultObj.put("InsuredType","Adult");
                SecondAdultObj.put("FirstName",strSpouseNameEditText);
                SecondAdultObj.put("LastName","");
                SecondAdultObj.put("DOB",strSpouseAgeEditText);
                SecondAdultObj.put("Gender",strSpouseGenderEdit);
                SecondAdultObj.put("Relationship",strRelationEditSpouse);
                SecondAdultObj.put("Occupation",strSpouseOccupationEdit);
                SecondAdultObj.put("NomineeName",strNomineeName);
                SecondAdultObj.put("NomineeRelationship",strNomineeRelationEdit);

                JSONObject HealthIndicatorsSecondObj=new JSONObject();
                HealthIndicatorsSecondObj.put("PED","N");
                HealthIndicatorsSecondObj.put("PEDDeclared","N");
                HealthIndicatorsSecondObj.put("BloodSugarLevel",strBloodSugar);
                HealthIndicatorsSecondObj.put("BloodPressureSystolic",strBloodPressure);
                HealthIndicatorsSecondObj.put("BloodPressureDiastolic",strBloodPressureDiastolic);
                HealthIndicatorsSecondObj.put("CholesterolLevel",strcholesterol);
                HealthIndicatorsSecondObj.put("BodyMassIndex",strSpouseBMIEdit);
                HealthIndicatorsSecondObj.put("TobaccoAndAlcohol","N");
                HealthIndicatorsSecondObj.put("CoMorbidity","N");
                SecondAdultObj.put("HealthIndicators",HealthIndicatorsSecondObj);

                JSONObject CoverDetailsSecondObj=new JSONObject();
                JSONArray SecondAdultCoversArray = new JSONArray();
                JSONObject BasicInsuranceCoversAdultSecObj=new JSONObject();
                BasicInsuranceCoversAdultSecObj.put("Applicable","True");
                BasicInsuranceCoversAdultSecObj.put("CoverSI",strSumInsured);
                BasicInsuranceCoversAdultSecObj.put("CoverRate","0");
                BasicInsuranceCoversAdultSecObj.put("CoverPremium","0");
                BasicInsuranceCoversAdultSecObj.put("CoverGroups","Basic Insurance Cover");
                SecondAdultCoversArray.put(BasicInsuranceCoversAdultSecObj);

                JSONObject PersonalAccidentCoversSecondAdultObj=new JSONObject();
                PersonalAccidentCoversSecondAdultObj.put("Applicable",PersonalStatus);
                PersonalAccidentCoversSecondAdultObj.put("CoverSI",strSumInsured);
                PersonalAccidentCoversSecondAdultObj.put("CoverRate","0");
                PersonalAccidentCoversSecondAdultObj.put("CoverPremium","0");
                PersonalAccidentCoversSecondAdultObj.put("CoverGroups","Personal Accident Cover");
                SecondAdultCoversArray.put(PersonalAccidentCoversSecondAdultObj);

                JSONObject CriticalIllnessCoversSecondAdultObj=new JSONObject();
                CriticalIllnessCoversSecondAdultObj.put("Applicable",CriticalStatus);
                CriticalIllnessCoversSecondAdultObj.put("CoverSI",strSumInsured);
                CriticalIllnessCoversSecondAdultObj.put("CoverRate","0");
                CriticalIllnessCoversSecondAdultObj.put("CoverPremium","0");
                CriticalIllnessCoversSecondAdultObj.put("CoverGroups","Critical Illness Cover");
                SecondAdultCoversArray.put(CriticalIllnessCoversSecondAdultObj);


                JSONObject DailyHospitalCoversSecondAdultObj=new JSONObject();
                DailyHospitalCoversSecondAdultObj.put("Applicable",DailyHospitalSatus);
                DailyHospitalCoversSecondAdultObj.put("CoverSI",strSumInsured);
                DailyHospitalCoversSecondAdultObj.put("CoverRate","0");
                DailyHospitalCoversSecondAdultObj.put("CoverPremium","0");
                DailyHospitalCoversSecondAdultObj.put("CoverGroups","Daily Hospital Cash Cover");
                SecondAdultCoversArray.put(DailyHospitalCoversSecondAdultObj);

                JSONObject ModernCoversSecondAdultObj=new JSONObject();
                ModernCoversSecondAdultObj.put("Applicable",ModernTreatmentsStatus);
                ModernCoversSecondAdultObj.put("CoverSI",strSumInsured);
                ModernCoversSecondAdultObj.put("CoverRate","0");
                ModernCoversSecondAdultObj.put("CoverPremium","0");
                ModernCoversSecondAdultObj.put("CoverGroups","Modern Treatments");
                SecondAdultCoversArray.put(ModernCoversSecondAdultObj);
                JSONObject ExtensionPreHospitalizationCoversSecondAdultObj=new JSONObject();
                ExtensionPreHospitalizationCoversSecondAdultObj.put("Applicable",ExtensionPreHospitalization);
                ExtensionPreHospitalizationCoversSecondAdultObj.put("CoverSI",strSumInsured);
                ExtensionPreHospitalizationCoversSecondAdultObj.put("CoverRate","0");
                ExtensionPreHospitalizationCoversSecondAdultObj.put("CoverPremium","0");
                ExtensionPreHospitalizationCoversSecondAdultObj.put("CoverGroups","Extension under Pre-Hospitalization");
                SecondAdultCoversArray.put(ExtensionPreHospitalizationCoversSecondAdultObj);

                JSONObject ExtensionPostHospitalizationCoversSecondAdultObj=new JSONObject();
                ExtensionPostHospitalizationCoversSecondAdultObj.put("Applicable",ExtensionPr0Hospitalization);
                ExtensionPostHospitalizationCoversSecondAdultObj.put("CoverSI",strSumInsured);
                ExtensionPostHospitalizationCoversSecondAdultObj.put("CoverRate","0");
                ExtensionPostHospitalizationCoversSecondAdultObj.put("CoverPremium","0");
                ExtensionPostHospitalizationCoversSecondAdultObj.put("CoverGroups","Extension under Post-Hospitalization");
                SecondAdultCoversArray.put(ExtensionPostHospitalizationCoversSecondAdultObj);


                JSONObject MaternityAndChildcareCoversSecAdultObj=new JSONObject();
                MaternityAndChildcareCoversSecAdultObj.put("Applicable",MaternityAndChildcare);
                MaternityAndChildcareCoversSecAdultObj.put("CoverSI",strSumInsured);
                MaternityAndChildcareCoversSecAdultObj.put("CoverRate","0");
                MaternityAndChildcareCoversSecAdultObj.put("CoverPremium","0");
                MaternityAndChildcareCoversSecAdultObj.put("CoverGroups","Maternity and Childcare Benefit Waiting Period Modification");
                SecondAdultCoversArray.put(MaternityAndChildcareCoversSecAdultObj);

                JSONObject CoverageForNonMedicalCoversSecAdultObj=new JSONObject();
                CoverageForNonMedicalCoversSecAdultObj.put("Applicable",CoverageNonMedical);
                CoverageForNonMedicalCoversSecAdultObj.put("CoverSI",strSumInsured);
                CoverageForNonMedicalCoversSecAdultObj.put("CoverRate","0");
                CoverageForNonMedicalCoversSecAdultObj.put("CoverPremium","0");
                CoverageForNonMedicalCoversSecAdultObj.put("CoverGroups","Coverage for Non-Medical Items");
                SecondAdultCoversArray.put(CoverageForNonMedicalCoversSecAdultObj);

                JSONObject ConditionWaiverCoversSecAdultObj=new JSONObject();
                ConditionWaiverCoversSecAdultObj.put("Applicable",ConditionWaiverStatus);
                ConditionWaiverCoversSecAdultObj.put("CoverSI",strSumInsured);
                ConditionWaiverCoversSecAdultObj.put("CoverRate","0");
                ConditionWaiverCoversSecAdultObj.put("CoverPremium","0");
                ConditionWaiverCoversSecAdultObj.put("CoverGroups","Condition waiver under Restore Benefit");
                SecondAdultCoversArray.put(ConditionWaiverCoversSecAdultObj);

                JSONObject PreExistingDiseaseCoversSecAdultObj=new JSONObject();
                PreExistingDiseaseCoversSecAdultObj.put("Applicable",PreExistingDiseaseStatus);
                PreExistingDiseaseCoversSecAdultObj.put("CoverSI",strSumInsured);
                PreExistingDiseaseCoversSecAdultObj.put("CoverRate","0");
                PreExistingDiseaseCoversSecAdultObj.put("CoverPremium","0");
                PreExistingDiseaseCoversSecAdultObj.put("CoverGroups","Pre-Existing Disease waiting period");
                SecondAdultCoversArray.put(PreExistingDiseaseCoversSecAdultObj);

                JSONObject OutpatientDentalWaitingCoversSecAdultObj=new JSONObject();
                OutpatientDentalWaitingCoversSecAdultObj.put("Applicable",OutpatientDentalStatus);
                OutpatientDentalWaitingCoversSecAdultObj.put("CoverSI",strSumInsured);
                OutpatientDentalWaitingCoversSecAdultObj.put("CoverRate","0");
                OutpatientDentalWaitingCoversSecAdultObj.put("CoverPremium","0");
                OutpatientDentalWaitingCoversSecAdultObj.put("CoverGroups","Outpatient Dental Waiting Period Modification");
                SecondAdultCoversArray.put(OutpatientDentalWaitingCoversSecAdultObj);

                JSONObject EmergencyTravellingAllowanceCoversSecAdultObj=new JSONObject();
                EmergencyTravellingAllowanceCoversSecAdultObj.put("Applicable",EmergencyTravellingStatus);
                EmergencyTravellingAllowanceCoversSecAdultObj.put("CoverSI",strSumInsured);
                EmergencyTravellingAllowanceCoversSecAdultObj.put("CoverRate","0");
                EmergencyTravellingAllowanceCoversSecAdultObj.put("CoverPremium","0");
                EmergencyTravellingAllowanceCoversSecAdultObj.put("CoverGroups","Emergency Travelling Allowance");
                SecondAdultCoversArray.put(EmergencyTravellingAllowanceCoversSecAdultObj);

                JSONObject SecondOpinionCoversSecAdultObj=new JSONObject();
                SecondOpinionCoversSecAdultObj.put("Applicable",SecondOpinionStatus);
                SecondOpinionCoversSecAdultObj.put("CoverSI",strSumInsured);
                SecondOpinionCoversSecAdultObj.put("CoverRate","0");
                SecondOpinionCoversSecAdultObj.put("CoverPremium","0");
                SecondOpinionCoversSecAdultObj.put("CoverGroups","Second Opinion");
                SecondAdultCoversArray.put(SecondOpinionCoversSecAdultObj);

                JSONObject RestCureCoversSecAdultObj=new JSONObject();
                RestCureCoversSecAdultObj.put("Applicable",RestCureStatus);
                RestCureCoversSecAdultObj.put("CoverSI",strSumInsured);
                RestCureCoversSecAdultObj.put("CoverRate","0");
                RestCureCoversSecAdultObj.put("CoverPremium","0");
                RestCureCoversSecAdultObj.put("CoverGroups","Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
                SecondAdultCoversArray.put(RestCureCoversSecAdultObj);

                JSONObject ObesityWeightCoversSecAdultObj=new JSONObject();
                ObesityWeightCoversSecAdultObj.put("Applicable",ObesityWeightStatus);
                ObesityWeightCoversSecAdultObj.put("CoverSI",strSumInsured);
                ObesityWeightCoversSecAdultObj.put("CoverRate","0");
                ObesityWeightCoversSecAdultObj.put("CoverPremium","0");
                ObesityWeightCoversSecAdultObj.put("CoverGroups","Obesity/ Weight Control Expenses Extension");
                SecondAdultCoversArray.put(ObesityWeightCoversSecAdultObj);

                JSONObject SterilityInfertilityCoversSecAdultObj=new JSONObject();
                SterilityInfertilityCoversSecAdultObj.put("Applicable",SterilityInfertilityStatus);
                SterilityInfertilityCoversSecAdultObj.put("CoverSI",strSumInsured);
                SterilityInfertilityCoversSecAdultObj.put("CoverRate","0");
                SterilityInfertilityCoversSecAdultObj.put("CoverPremium","0");
                SterilityInfertilityCoversSecAdultObj.put("CoverGroups","Sterility and Infertility Treatment Expenses Extension");
                SecondAdultCoversArray.put(SterilityInfertilityCoversSecAdultObj);

                JSONObject EnhancedOrganDonorCoversSecAdultObj=new JSONObject();
                EnhancedOrganDonorCoversSecAdultObj.put("Applicable",EnhancedOrganStatus);
                EnhancedOrganDonorCoversSecAdultObj.put("CoverSI",strSumInsured);
                EnhancedOrganDonorCoversSecAdultObj.put("CoverRate","0");
                EnhancedOrganDonorCoversSecAdultObj.put("CoverPremium","0");
                EnhancedOrganDonorCoversSecAdultObj.put("CoverGroups","Enhanced Organ Donor Expenses");
                SecondAdultCoversArray.put(EnhancedOrganDonorCoversSecAdultObj);

                JSONObject PremiumWaiverCoversSecAdultObj=new JSONObject();
                PremiumWaiverCoversSecAdultObj.put("Applicable",PremiumWaiverStatus);
                PremiumWaiverCoversSecAdultObj.put("CoverSI",strSumInsured);
                PremiumWaiverCoversSecAdultObj.put("CoverRate","0");
                PremiumWaiverCoversSecAdultObj.put("CoverPremium","0");
                PremiumWaiverCoversSecAdultObj.put("CoverGroups","Premium Waiver");
                SecondAdultCoversArray.put(PremiumWaiverCoversSecAdultObj);

                JSONObject GlobalCoversSecAdultObj=new JSONObject();
                GlobalCoversSecAdultObj.put("Applicable",GlobalCoverStatus);
                GlobalCoversSecAdultObj.put("CoverSI",strSumInsured);
                GlobalCoversSecAdultObj.put("CoverRate","0");
                GlobalCoversSecAdultObj.put("CoverPremium","0");
                GlobalCoversSecAdultObj.put("CoverGroups","Global Cover");
                SecondAdultCoversArray.put(GlobalCoversSecAdultObj);


                JSONObject MedicallyAdvisedCoversSecAdultObj=new JSONObject();
                MedicallyAdvisedCoversSecAdultObj.put("Applicable",MedicallyAdvisedStatus);
                MedicallyAdvisedCoversSecAdultObj.put("CoverSI",strSumInsured);
                MedicallyAdvisedCoversSecAdultObj.put("CoverRate","0");
                MedicallyAdvisedCoversSecAdultObj.put("CoverPremium","0");
                MedicallyAdvisedCoversSecAdultObj.put("CoverGroups","Medically Advised Support Devices");
                SecondAdultCoversArray.put(MedicallyAdvisedCoversSecAdultObj);

                JSONObject EmergencyCoversSecAdultObj=new JSONObject();
                EmergencyCoversSecAdultObj.put("Applicable",EmergencyAssistanceStatus);
                EmergencyCoversSecAdultObj.put("CoverSI",strSumInsured);
                EmergencyCoversSecAdultObj.put("CoverRate","0");
                EmergencyCoversSecAdultObj.put("CoverPremium","0");
                EmergencyCoversSecAdultObj.put("CoverGroups","Emergency Assistance Service");
                SecondAdultCoversArray.put(EmergencyCoversSecAdultObj);

                JSONObject HomeCareTreatmentCoversSecAdultObj=new JSONObject();
                HomeCareTreatmentCoversSecAdultObj.put("Applicable",HomeCareStatus);
                HomeCareTreatmentCoversSecAdultObj.put("CoverSI",strSumInsured);
                HomeCareTreatmentCoversSecAdultObj.put("CoverRate","0");
                HomeCareTreatmentCoversSecAdultObj.put("CoverPremium","0");
                HomeCareTreatmentCoversSecAdultObj.put("CoverGroups","Home Care Treatment");
                SecondAdultCoversArray.put(HomeCareTreatmentCoversSecAdultObj);

                JSONObject WellnessBenefitCoversSecAdultObj=new JSONObject();
                WellnessBenefitCoversSecAdultObj.put("Applicable",WellnessBenefitStatus);
                WellnessBenefitCoversSecAdultObj.put("CoverSI",strSumInsured);
                WellnessBenefitCoversSecAdultObj.put("CoverRate","0");
                WellnessBenefitCoversSecAdultObj.put("CoverPremium","0");
                WellnessBenefitCoversSecAdultObj.put("CoverGroups","Wellness Benefit");
                SecondAdultCoversArray.put(WellnessBenefitCoversSecAdultObj);

                JSONObject DiseaseManagementCoversSecAdultObj=new JSONObject();
                DiseaseManagementCoversSecAdultObj.put("Applicable",DiseaseManagementStatus);
                DiseaseManagementCoversSecAdultObj.put("CoverSI",strSumInsured);
                DiseaseManagementCoversSecAdultObj.put("CoverRate","0");
                DiseaseManagementCoversSecAdultObj.put("CoverPremium","0");
                DiseaseManagementCoversSecAdultObj.put("CoverGroups","Disease Management Program");
                SecondAdultCoversArray.put(DiseaseManagementCoversSecAdultObj);
                CoverDetailsSecondObj.put("Covers",SecondAdultCoversArray);
                SecondAdultObj.put("CoverDetails",CoverDetailsSecondObj);
                //ChildFirst
                JSONObject FirstChildObj=new JSONObject();
                FirstChildObj.put("InsuredType","Child");
                FirstChildObj.put("FirstName",strChildOneNameEdit);
                FirstChildObj.put("LastName","");
                FirstChildObj.put("DOB",strFirstSonAgeEditText);
                FirstChildObj.put("Gender",strGenderChildOneEdit);
                FirstChildObj.put("Relationship",strRelationChildEdit);
                FirstChildObj.put("Occupation","Student");
                FirstChildObj.put("NomineeName",strNomineeName);
                FirstChildObj.put("NomineeRelationship",strNomineeRelationEdit);

                JSONObject HealthIndicatorsFirstChildObj=new JSONObject();
                HealthIndicatorsFirstChildObj.put("PED","N");
                HealthIndicatorsFirstChildObj.put("PEDDeclared","N");
                HealthIndicatorsFirstChildObj.put("BloodSugarLevel",strBloodSugar);
                HealthIndicatorsFirstChildObj.put("BloodPressureSystolic",strBloodPressure);
                HealthIndicatorsFirstChildObj.put("BloodPressureDiastolic",strBloodPressureDiastolic);
                HealthIndicatorsFirstChildObj.put("CholesterolLevel",strcholesterol);
                HealthIndicatorsFirstChildObj.put("BodyMassIndex",strBMIChildEdit);
                HealthIndicatorsFirstChildObj.put("TobaccoAndAlcohol","N");
                HealthIndicatorsFirstChildObj.put("CoMorbidity","N");
                FirstChildObj.put("HealthIndicators",HealthIndicatorsFirstChildObj);

                JSONObject CoverDetailsFirstChildObj=new JSONObject();
                JSONArray FirstChildCoversArray = new JSONArray();
                JSONObject BasicInsuranceCoversChildFirstObj=new JSONObject();
                BasicInsuranceCoversChildFirstObj.put("Applicable",BasicStatus);
                BasicInsuranceCoversChildFirstObj.put("CoverSI",strSumInsured);
                BasicInsuranceCoversChildFirstObj.put("CoverRate","0");
                BasicInsuranceCoversChildFirstObj.put("CoverPremium","0");
                BasicInsuranceCoversChildFirstObj.put("CoverGroups","Basic Insurance Cover");
                FirstChildCoversArray.put(BasicInsuranceCoversChildFirstObj);

                JSONObject PersonalAccidentCoversFirstObj=new JSONObject();
                PersonalAccidentCoversFirstObj.put("Applicable",PersonalStatusChildOne);
                PersonalAccidentCoversFirstObj.put("CoverSI",strSumInsured);
                PersonalAccidentCoversFirstObj.put("CoverRate","0");
                PersonalAccidentCoversFirstObj.put("CoverPremium","0");
                PersonalAccidentCoversFirstObj.put("CoverGroups","Personal Accident Cover");
                FirstChildCoversArray.put(PersonalAccidentCoversFirstObj);

                JSONObject CriticalIllnessCoversFirstObj=new JSONObject();
                CriticalIllnessCoversFirstObj.put("Applicable",CriticalStatus);
                CriticalIllnessCoversFirstObj.put("CoverSI",strSumInsured);
                CriticalIllnessCoversFirstObj.put("CoverRate","0");
                CriticalIllnessCoversFirstObj.put("CoverPremium","0");
                CriticalIllnessCoversFirstObj.put("CoverGroups","Critical Illness Cover");
                FirstChildCoversArray.put(CriticalIllnessCoversFirstObj);


                JSONObject DailyHospitalCoversFirstObj=new JSONObject();
                DailyHospitalCoversFirstObj.put("Applicable",DailyHospitalSatus);
                DailyHospitalCoversFirstObj.put("CoverSI",strSumInsured);
                DailyHospitalCoversFirstObj.put("CoverRate","0");
                DailyHospitalCoversFirstObj.put("CoverPremium","0");
                DailyHospitalCoversFirstObj.put("CoverGroups","Daily Hospital Cash Cover");
                FirstChildCoversArray.put(DailyHospitalCoversFirstObj);

                JSONObject ModernCoversFirstObj=new JSONObject();
                ModernCoversFirstObj.put("Applicable",ModernTreatmentsStatus);
                ModernCoversFirstObj.put("CoverSI",strSumInsured);
                ModernCoversFirstObj.put("CoverRate","0");
                ModernCoversFirstObj.put("CoverPremium","0");
                ModernCoversFirstObj.put("CoverGroups","Modern Treatments");
                FirstChildCoversArray.put(ModernCoversFirstObj);
                JSONObject ExtensionPreHospitalizationCoversFirstObj=new JSONObject();
                ExtensionPreHospitalizationCoversFirstObj.put("Applicable",ExtensionPreHospitalization);
                ExtensionPreHospitalizationCoversFirstObj.put("CoverSI",strSumInsured);
                ExtensionPreHospitalizationCoversFirstObj.put("CoverRate","0");
                ExtensionPreHospitalizationCoversFirstObj.put("CoverPremium","0");
                ExtensionPreHospitalizationCoversFirstObj.put("CoverGroups","Extension under Pre-Hospitalization");
                FirstChildCoversArray.put(ExtensionPreHospitalizationCoversFirstObj);

                JSONObject ExtensionPostHospitalizationCoversFirstObj=new JSONObject();
                ExtensionPostHospitalizationCoversFirstObj.put("Applicable",ExtensionPr0Hospitalization);
                ExtensionPostHospitalizationCoversFirstObj.put("CoverSI",strSumInsured);
                ExtensionPostHospitalizationCoversFirstObj.put("CoverRate","0");
                ExtensionPostHospitalizationCoversFirstObj.put("CoverPremium","0");
                ExtensionPostHospitalizationCoversFirstObj.put("CoverGroups","Extension under Post-Hospitalization");
                FirstChildCoversArray.put(ExtensionPostHospitalizationCoversFirstObj);


                JSONObject MaternityAndChildcareCoversFirstObj=new JSONObject();
                MaternityAndChildcareCoversFirstObj.put("Applicable","False");
                MaternityAndChildcareCoversFirstObj.put("CoverSI",strSumInsured);
                MaternityAndChildcareCoversFirstObj.put("CoverRate","0");
                MaternityAndChildcareCoversFirstObj.put("CoverPremium","0");
                MaternityAndChildcareCoversFirstObj.put("CoverGroups","Maternity and Childcare Benefit Waiting Period Modification");
                FirstChildCoversArray.put(MaternityAndChildcareCoversFirstObj);

                JSONObject CoverageForNonMedicalCoversFirstObj=new JSONObject();
                CoverageForNonMedicalCoversFirstObj.put("Applicable",CoverageNonMedical);
                CoverageForNonMedicalCoversFirstObj.put("CoverSI",strSumInsured);
                CoverageForNonMedicalCoversFirstObj.put("CoverRate","0");
                CoverageForNonMedicalCoversFirstObj.put("CoverPremium","0");
                CoverageForNonMedicalCoversFirstObj.put("CoverGroups","Coverage for Non-Medical Items");
                FirstChildCoversArray.put(CoverageForNonMedicalCoversFirstObj);

                JSONObject ConditionWaiverCoversFirstObj=new JSONObject();
                ConditionWaiverCoversFirstObj.put("Applicable",ConditionWaiverStatus);
                ConditionWaiverCoversFirstObj.put("CoverSI",strSumInsured);
                ConditionWaiverCoversFirstObj.put("CoverRate","0");
                ConditionWaiverCoversFirstObj.put("CoverPremium","0");
                ConditionWaiverCoversFirstObj.put("CoverGroups","Condition waiver under Restore Benefit");
                FirstChildCoversArray.put(ConditionWaiverCoversFirstObj);

                JSONObject PreExistingDiseaseCoversFirstObj=new JSONObject();
                PreExistingDiseaseCoversFirstObj.put("Applicable",PreExistingDiseaseStatus);
                PreExistingDiseaseCoversFirstObj.put("CoverSI",strSumInsured);
                PreExistingDiseaseCoversFirstObj.put("CoverRate","0");
                PreExistingDiseaseCoversFirstObj.put("CoverPremium","0");
                PreExistingDiseaseCoversFirstObj.put("CoverGroups","Pre-Existing Disease waiting period");
                FirstChildCoversArray.put(PreExistingDiseaseCoversFirstObj);

                JSONObject OutpatientDentalWaitingCoversFirstObj=new JSONObject();
                OutpatientDentalWaitingCoversFirstObj.put("Applicable",OutpatientDentalStatus);
                OutpatientDentalWaitingCoversFirstObj.put("CoverSI",strSumInsured);
                OutpatientDentalWaitingCoversFirstObj.put("CoverRate","0");
                OutpatientDentalWaitingCoversFirstObj.put("CoverPremium","0");
                OutpatientDentalWaitingCoversFirstObj.put("CoverGroups","Outpatient Dental Waiting Period Modification");
                FirstChildCoversArray.put(OutpatientDentalWaitingCoversFirstObj);

                JSONObject EmergencyTravellingAllowanceCoversFirstObj=new JSONObject();
                EmergencyTravellingAllowanceCoversFirstObj.put("Applicable",EmergencyTravellingStatus);
                EmergencyTravellingAllowanceCoversFirstObj.put("CoverSI",strSumInsured);
                EmergencyTravellingAllowanceCoversFirstObj.put("CoverRate","0");
                EmergencyTravellingAllowanceCoversFirstObj.put("CoverPremium","0");
                EmergencyTravellingAllowanceCoversFirstObj.put("CoverGroups","Emergency Travelling Allowance");
                FirstChildCoversArray.put(EmergencyTravellingAllowanceCoversFirstObj);

                JSONObject SecondOpinionCoversFirstObj=new JSONObject();
                SecondOpinionCoversFirstObj.put("Applicable",SecondOpinionStatus);
                SecondOpinionCoversFirstObj.put("CoverSI",strSumInsured);
                SecondOpinionCoversFirstObj.put("CoverRate","0");
                SecondOpinionCoversFirstObj.put("CoverPremium","0");
                SecondOpinionCoversFirstObj.put("CoverGroups","Second Opinion");
                FirstChildCoversArray.put(SecondOpinionCoversFirstObj);

                JSONObject RestCureCoversFirstObj=new JSONObject();
                RestCureCoversFirstObj.put("Applicable",RestCureStatus);
                RestCureCoversFirstObj.put("CoverSI",strSumInsured);
                RestCureCoversFirstObj.put("CoverRate","0");
                RestCureCoversFirstObj.put("CoverPremium","0");
                RestCureCoversFirstObj.put("CoverGroups","Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
                FirstChildCoversArray.put(RestCureCoversFirstObj);

                JSONObject ObesityWeightCoversFirstObj=new JSONObject();
                ObesityWeightCoversFirstObj.put("Applicable",ObesityWeightStatus);
                ObesityWeightCoversFirstObj.put("CoverSI",strSumInsured);
                ObesityWeightCoversFirstObj.put("CoverRate","0");
                ObesityWeightCoversFirstObj.put("CoverPremium","0");
                ObesityWeightCoversFirstObj.put("CoverGroups","Obesity/ Weight Control Expenses Extension");
                FirstChildCoversArray.put(ObesityWeightCoversFirstObj);

                JSONObject SterilityInfertilityCoversFirstObj=new JSONObject();
                SterilityInfertilityCoversFirstObj.put("Applicable","False");
                SterilityInfertilityCoversFirstObj.put("CoverSI",strSumInsured);
                SterilityInfertilityCoversFirstObj.put("CoverRate","0");
                SterilityInfertilityCoversFirstObj.put("CoverPremium","0");
                SterilityInfertilityCoversFirstObj.put("CoverGroups","Sterility and Infertility Treatment Expenses Extension");
                FirstChildCoversArray.put(SterilityInfertilityCoversFirstObj);

                JSONObject EnhancedOrganDonorCoversFirstObj=new JSONObject();
                EnhancedOrganDonorCoversFirstObj.put("Applicable",EnhancedOrganStatus);
                EnhancedOrganDonorCoversFirstObj.put("CoverSI",strSumInsured);
                EnhancedOrganDonorCoversFirstObj.put("CoverRate","0");
                EnhancedOrganDonorCoversFirstObj.put("CoverPremium","0");
                EnhancedOrganDonorCoversFirstObj.put("CoverGroups","Enhanced Organ Donor Expenses");
                FirstChildCoversArray.put(EnhancedOrganDonorCoversFirstObj);

                JSONObject PremiumWaiverCoversFirstObj=new JSONObject();
                PremiumWaiverCoversFirstObj.put("Applicable",PremiumWaiverStatus);
                PremiumWaiverCoversFirstObj.put("CoverSI",strSumInsured);
                PremiumWaiverCoversFirstObj.put("CoverRate","0");
                PremiumWaiverCoversFirstObj.put("CoverPremium","0");
                PremiumWaiverCoversFirstObj.put("CoverGroups","Premium Waiver");
                FirstChildCoversArray.put(PremiumWaiverCoversFirstObj);

                JSONObject GlobalCoversFirstObj=new JSONObject();
                GlobalCoversFirstObj.put("Applicable",GlobalCoverStatus);
                GlobalCoversFirstObj.put("CoverSI",strSumInsured);
                GlobalCoversFirstObj.put("CoverRate","0");
                GlobalCoversFirstObj.put("CoverPremium","0");
                GlobalCoversFirstObj.put("CoverGroups","Global Cover");
                FirstChildCoversArray.put(GlobalCoversFirstObj);


                JSONObject MedicallyAdvisedCoversFirstObj=new JSONObject();
                MedicallyAdvisedCoversFirstObj.put("Applicable",MedicallyAdvisedStatus);
                MedicallyAdvisedCoversFirstObj.put("CoverSI",strSumInsured);
                MedicallyAdvisedCoversFirstObj.put("CoverRate","0");
                MedicallyAdvisedCoversFirstObj.put("CoverPremium","0");
                MedicallyAdvisedCoversFirstObj.put("CoverGroups","Medically Advised Support Devices");
                FirstChildCoversArray.put(MedicallyAdvisedCoversFirstObj);

                JSONObject EmergencyCoversFirstObj=new JSONObject();
                EmergencyCoversFirstObj.put("Applicable",EmergencyAssistanceStatus);
                EmergencyCoversFirstObj.put("CoverSI",strSumInsured);
                EmergencyCoversFirstObj.put("CoverRate","0");
                EmergencyCoversFirstObj.put("CoverPremium","0");
                EmergencyCoversFirstObj.put("CoverGroups","Emergency Assistance Service");
                FirstChildCoversArray.put(EmergencyCoversFirstObj);

                JSONObject HomeCareTreatmentCoversFirstObj=new JSONObject();
                HomeCareTreatmentCoversFirstObj.put("Applicable",HomeCareStatus);
                HomeCareTreatmentCoversFirstObj.put("CoverSI",strSumInsured);
                HomeCareTreatmentCoversFirstObj.put("CoverRate","0");
                HomeCareTreatmentCoversFirstObj.put("CoverPremium","0");
                HomeCareTreatmentCoversFirstObj.put("CoverGroups","Home Care Treatment");
                FirstChildCoversArray.put(HomeCareTreatmentCoversFirstObj);

                JSONObject WellnessBenefitCoversFirstObj=new JSONObject();
                WellnessBenefitCoversFirstObj.put("Applicable",WellnessBenefitStatus);
                WellnessBenefitCoversFirstObj.put("CoverSI",strSumInsured);
                WellnessBenefitCoversFirstObj.put("CoverRate","0");
                WellnessBenefitCoversFirstObj.put("CoverPremium","0");
                WellnessBenefitCoversFirstObj.put("CoverGroups","Wellness Benefit");
                FirstChildCoversArray.put(WellnessBenefitCoversFirstObj);

                JSONObject DiseaseManagementCoversFirstObj=new JSONObject();
                DiseaseManagementCoversFirstObj.put("Applicable",DiseaseManagementStatus);
                DiseaseManagementCoversFirstObj.put("CoverSI",strSumInsured);
                DiseaseManagementCoversFirstObj.put("CoverRate","0");
                DiseaseManagementCoversFirstObj.put("CoverPremium","0");
                DiseaseManagementCoversFirstObj.put("CoverGroups","Disease Management Program");
                FirstChildCoversArray.put(DiseaseManagementCoversFirstObj);
                CoverDetailsFirstChildObj.put("Covers",FirstChildCoversArray);
                FirstChildObj.put("CoverDetails",CoverDetailsFirstChildObj);

                //childTwo
                JSONObject SecondChildObj=new JSONObject();
                SecondChildObj.put("InsuredType","Child");
                SecondChildObj.put("FirstName",strSecondChildNameEdit);
                SecondChildObj.put("LastName","");
                SecondChildObj.put("DOB",strSecondSonAgeEditText);
                SecondChildObj.put("Gender",str_twoGenderSpinner);
                SecondChildObj.put("Relationship",strRelationChildTwoEdit);
                SecondChildObj.put("Occupation","Student");
                SecondChildObj.put("NomineeName",strNomineeName);
                SecondChildObj.put("NomineeRelationship",strNomineeRelationEdit);

                JSONObject HealthIndicatorsSecondChildObj=new JSONObject();
                HealthIndicatorsSecondChildObj.put("PED","N");
                HealthIndicatorsSecondChildObj.put("PEDDeclared","N");
                HealthIndicatorsSecondChildObj.put("BloodSugarLevel",strBloodSugar);
                HealthIndicatorsSecondChildObj.put("BloodPressureSystolic",strBloodPressure);
                HealthIndicatorsSecondChildObj.put("BloodPressureDiastolic",strBloodPressureDiastolic);
                HealthIndicatorsSecondChildObj.put("CholesterolLevel",strcholesterol);
                HealthIndicatorsSecondChildObj.put("BodyMassIndex",strBMIChildTwoEdit);
                HealthIndicatorsSecondChildObj.put("TobaccoAndAlcohol","N");
                HealthIndicatorsSecondChildObj.put("CoMorbidity","N");
                SecondChildObj.put("HealthIndicators",HealthIndicatorsSecondChildObj);

                JSONObject CoverDetailsSecondChildObj=new JSONObject();
                JSONArray SecondChildCoversArray = new JSONArray();
                JSONObject BasicInsuranceCoversSecChildObj=new JSONObject();
                BasicInsuranceCoversSecChildObj.put("Applicable",BasicStatus);
                BasicInsuranceCoversSecChildObj.put("CoverSI",strSumInsured);
                BasicInsuranceCoversSecChildObj.put("CoverRate","0");
                BasicInsuranceCoversSecChildObj.put("CoverPremium","0");
                BasicInsuranceCoversSecChildObj.put("CoverGroups","Basic Insurance Cover");
                SecondChildCoversArray.put(BasicInsuranceCoversSecChildObj);

                JSONObject PersonalAccidentCoversSecondChildObj=new JSONObject();
                PersonalAccidentCoversSecondChildObj.put("Applicable",PersonalStatusChildTwo);
                PersonalAccidentCoversSecondChildObj.put("CoverSI",strSumInsured);
                PersonalAccidentCoversSecondChildObj.put("CoverRate","0");
                PersonalAccidentCoversSecondChildObj.put("CoverPremium","0");
                PersonalAccidentCoversSecondChildObj.put("CoverGroups","Personal Accident Cover");
                SecondChildCoversArray.put(PersonalAccidentCoversSecondChildObj);

                JSONObject CriticalIllnessCoversSecondChildObj=new JSONObject();
                CriticalIllnessCoversSecondChildObj.put("Applicable",CriticalStatus);
                CriticalIllnessCoversSecondChildObj.put("CoverSI",strSumInsured);
                CriticalIllnessCoversSecondChildObj.put("CoverRate","0");
                CriticalIllnessCoversSecondChildObj.put("CoverPremium","0");
                CriticalIllnessCoversSecondChildObj.put("CoverGroups","Critical Illness Cover");
                SecondChildCoversArray.put(CriticalIllnessCoversSecondChildObj);


                JSONObject DailyHospitalCoversSecondChildObj=new JSONObject();
                DailyHospitalCoversSecondChildObj.put("Applicable",DailyHospitalSatus);
                DailyHospitalCoversSecondChildObj.put("CoverSI",strSumInsured);
                DailyHospitalCoversSecondChildObj.put("CoverRate","0");
                DailyHospitalCoversSecondChildObj.put("CoverPremium","0");
                DailyHospitalCoversSecondChildObj.put("CoverGroups","Daily Hospital Cash Cover");
                SecondChildCoversArray.put(DailyHospitalCoversSecondChildObj);

                JSONObject ModernCoversSecondChildObj=new JSONObject();
                ModernCoversSecondChildObj.put("Applicable",ModernTreatmentsStatus);
                ModernCoversSecondChildObj.put("CoverSI",strSumInsured);
                ModernCoversSecondChildObj.put("CoverRate","0");
                ModernCoversSecondChildObj.put("CoverPremium","0");
                ModernCoversSecondChildObj.put("CoverGroups","Modern Treatments");
                SecondChildCoversArray.put(ModernCoversSecondChildObj);
                JSONObject ExtensionPreHospitalizationCoversSecondChildObj=new JSONObject();
                ExtensionPreHospitalizationCoversSecondChildObj.put("Applicable",ExtensionPreHospitalization);
                ExtensionPreHospitalizationCoversSecondChildObj.put("CoverSI",strSumInsured);
                ExtensionPreHospitalizationCoversSecondChildObj.put("CoverRate","0");
                ExtensionPreHospitalizationCoversSecondChildObj.put("CoverPremium","0");
                ExtensionPreHospitalizationCoversSecondChildObj.put("CoverGroups","Extension under Pre-Hospitalization");
                SecondChildCoversArray.put(ExtensionPreHospitalizationCoversSecondChildObj);

                JSONObject ExtensionPostHospitalizationCoversSecondChildObj=new JSONObject();
                ExtensionPostHospitalizationCoversSecondChildObj.put("Applicable",ExtensionPr0Hospitalization);
                ExtensionPostHospitalizationCoversSecondChildObj.put("CoverSI",strSumInsured);
                ExtensionPostHospitalizationCoversSecondChildObj.put("CoverRate","0");
                ExtensionPostHospitalizationCoversSecondChildObj.put("CoverPremium","0");
                ExtensionPostHospitalizationCoversSecondChildObj.put("CoverGroups","Extension under Post-Hospitalization");
                SecondChildCoversArray.put(ExtensionPostHospitalizationCoversSecondChildObj);


                JSONObject MaternityAndChildcareCoversSecChildObj=new JSONObject();
                MaternityAndChildcareCoversSecChildObj.put("Applicable","False");
                MaternityAndChildcareCoversSecChildObj.put("CoverSI",strSumInsured);
                MaternityAndChildcareCoversSecChildObj.put("CoverRate","0");
                MaternityAndChildcareCoversSecChildObj.put("CoverPremium","0");
                MaternityAndChildcareCoversSecChildObj.put("CoverGroups","Maternity and Childcare Benefit Waiting Period Modification");
                SecondChildCoversArray.put(MaternityAndChildcareCoversSecChildObj);

                JSONObject CoverageForNonMedicalCoversSecChildObj=new JSONObject();
                CoverageForNonMedicalCoversSecChildObj.put("Applicable",CoverageNonMedical);
                CoverageForNonMedicalCoversSecChildObj.put("CoverSI",strSumInsured);
                CoverageForNonMedicalCoversSecChildObj.put("CoverRate","0");
                CoverageForNonMedicalCoversSecChildObj.put("CoverPremium","0");
                CoverageForNonMedicalCoversSecChildObj.put("CoverGroups","Coverage for Non-Medical Items");
                SecondChildCoversArray.put(CoverageForNonMedicalCoversSecChildObj);

                JSONObject ConditionWaiverCoversSecChildObj=new JSONObject();
                ConditionWaiverCoversSecChildObj.put("Applicable",ConditionWaiverStatus);
                ConditionWaiverCoversSecChildObj.put("CoverSI",strSumInsured);
                ConditionWaiverCoversSecChildObj.put("CoverRate","0");
                ConditionWaiverCoversSecChildObj.put("CoverPremium","0");
                ConditionWaiverCoversSecChildObj.put("CoverGroups","Condition waiver under Restore Benefit");
                SecondChildCoversArray.put(ConditionWaiverCoversSecChildObj);

                JSONObject PreExistingDiseaseCoversSecChildObj=new JSONObject();
                PreExistingDiseaseCoversSecChildObj.put("Applicable",PreExistingDiseaseStatus);
                PreExistingDiseaseCoversSecChildObj.put("CoverSI",strSumInsured);
                PreExistingDiseaseCoversSecChildObj.put("CoverRate","0");
                PreExistingDiseaseCoversSecChildObj.put("CoverPremium","0");
                PreExistingDiseaseCoversSecChildObj.put("CoverGroups","Pre-Existing Disease waiting period");
                SecondChildCoversArray.put(PreExistingDiseaseCoversSecChildObj);

                JSONObject OutpatientDentalWaitingCoversSecChildObj=new JSONObject();
                OutpatientDentalWaitingCoversSecChildObj.put("Applicable",OutpatientDentalStatus);
                OutpatientDentalWaitingCoversSecChildObj.put("CoverSI",strSumInsured);
                OutpatientDentalWaitingCoversSecChildObj.put("CoverRate","0");
                OutpatientDentalWaitingCoversSecChildObj.put("CoverPremium","0");
                OutpatientDentalWaitingCoversSecChildObj.put("CoverGroups","Outpatient Dental Waiting Period Modification");
                SecondChildCoversArray.put(OutpatientDentalWaitingCoversSecChildObj);

                JSONObject EmergencyTravellingAllowanceCoversSecChildObj=new JSONObject();
                EmergencyTravellingAllowanceCoversSecChildObj.put("Applicable",EmergencyTravellingStatus);
                EmergencyTravellingAllowanceCoversSecChildObj.put("CoverSI",strSumInsured);
                EmergencyTravellingAllowanceCoversSecChildObj.put("CoverRate","0");
                EmergencyTravellingAllowanceCoversSecChildObj.put("CoverPremium","0");
                EmergencyTravellingAllowanceCoversSecChildObj.put("CoverGroups","Emergency Travelling Allowance");
                SecondChildCoversArray.put(EmergencyTravellingAllowanceCoversSecChildObj);

                JSONObject SecondOpinionCoversSecChildObj=new JSONObject();
                SecondOpinionCoversSecChildObj.put("Applicable",SecondOpinionStatus);
                SecondOpinionCoversSecChildObj.put("CoverSI",strSumInsured);
                SecondOpinionCoversSecChildObj.put("CoverRate","0");
                SecondOpinionCoversSecChildObj.put("CoverPremium","0");
                SecondOpinionCoversSecChildObj.put("CoverGroups","Second Opinion");
                SecondChildCoversArray.put(SecondOpinionCoversSecChildObj);

                JSONObject RestCureCoversSecChildObj=new JSONObject();
                RestCureCoversSecChildObj.put("Applicable",RestCureStatus);
                RestCureCoversSecChildObj.put("CoverSI",strSumInsured);
                RestCureCoversSecChildObj.put("CoverRate","0");
                RestCureCoversSecChildObj.put("CoverPremium","0");
                RestCureCoversSecChildObj.put("CoverGroups","Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
                SecondChildCoversArray.put(RestCureCoversSecChildObj);

                JSONObject ObesityWeightCoversSecChildObj=new JSONObject();
                ObesityWeightCoversSecChildObj.put("Applicable",ObesityWeightStatus);
                ObesityWeightCoversSecChildObj.put("CoverSI",strSumInsured);
                ObesityWeightCoversSecChildObj.put("CoverRate","0");
                ObesityWeightCoversSecChildObj.put("CoverPremium","0");
                ObesityWeightCoversSecChildObj.put("CoverGroups","Obesity/ Weight Control Expenses Extension");
                SecondChildCoversArray.put(ObesityWeightCoversSecChildObj);

                JSONObject SterilityInfertilityCoversSecChildObj=new JSONObject();
                SterilityInfertilityCoversSecChildObj.put("Applicable","False");
                SterilityInfertilityCoversSecChildObj.put("CoverSI",strSumInsured);
                SterilityInfertilityCoversSecChildObj.put("CoverRate","0");
                SterilityInfertilityCoversSecChildObj.put("CoverPremium","0");
                SterilityInfertilityCoversSecChildObj.put("CoverGroups","Sterility and Infertility Treatment Expenses Extension");
                SecondChildCoversArray.put(SterilityInfertilityCoversSecChildObj);

                JSONObject EnhancedOrganDonorCoversSecChildObj=new JSONObject();
                EnhancedOrganDonorCoversSecChildObj.put("Applicable",EnhancedOrganStatus);
                EnhancedOrganDonorCoversSecChildObj.put("CoverSI",strSumInsured);
                EnhancedOrganDonorCoversSecChildObj.put("CoverRate","0");
                EnhancedOrganDonorCoversSecChildObj.put("CoverPremium","0");
                EnhancedOrganDonorCoversSecChildObj.put("CoverGroups","Enhanced Organ Donor Expenses");
                SecondChildCoversArray.put(EnhancedOrganDonorCoversSecChildObj);

                JSONObject PremiumWaiverCoversSecChildObj=new JSONObject();
                PremiumWaiverCoversSecChildObj.put("Applicable",PremiumWaiverStatus);
                PremiumWaiverCoversSecChildObj.put("CoverSI",strSumInsured);
                PremiumWaiverCoversSecChildObj.put("CoverRate","0");
                PremiumWaiverCoversSecChildObj.put("CoverPremium","0");
                PremiumWaiverCoversSecChildObj.put("CoverGroups","Premium Waiver");
                SecondChildCoversArray.put(PremiumWaiverCoversSecChildObj);

                JSONObject GlobalCoversSecChildObj=new JSONObject();
                GlobalCoversSecChildObj.put("Applicable",GlobalCoverStatus);
                GlobalCoversSecChildObj.put("CoverSI",strSumInsured);
                GlobalCoversSecChildObj.put("CoverRate","0");
                GlobalCoversSecChildObj.put("CoverPremium","0");
                GlobalCoversSecChildObj.put("CoverGroups","Global Cover");
                SecondChildCoversArray.put(GlobalCoversSecChildObj);


                JSONObject MedicallyAdvisedCoversSecChildObj=new JSONObject();
                MedicallyAdvisedCoversSecChildObj.put("Applicable",MedicallyAdvisedStatus);
                MedicallyAdvisedCoversSecChildObj.put("CoverSI",strSumInsured);
                MedicallyAdvisedCoversSecChildObj.put("CoverRate","0");
                MedicallyAdvisedCoversSecChildObj.put("CoverPremium","0");
                MedicallyAdvisedCoversSecChildObj.put("CoverGroups","Medically Advised Support Devices");
                SecondChildCoversArray.put(MedicallyAdvisedCoversSecChildObj);

                JSONObject EmergencyCoversSecChildObj=new JSONObject();
                EmergencyCoversSecChildObj.put("Applicable",EmergencyAssistanceStatus);
                EmergencyCoversSecChildObj.put("CoverSI",strSumInsured);
                EmergencyCoversSecChildObj.put("CoverRate","0");
                EmergencyCoversSecChildObj.put("CoverPremium","0");
                EmergencyCoversSecChildObj.put("CoverGroups","Emergency Assistance Service");
                SecondChildCoversArray.put(EmergencyCoversSecChildObj);

                JSONObject HomeCareTreatmentCoversSecChildObj=new JSONObject();
                HomeCareTreatmentCoversSecChildObj.put("Applicable",HomeCareStatus);
                HomeCareTreatmentCoversSecChildObj.put("CoverSI",strSumInsured);
                HomeCareTreatmentCoversSecChildObj.put("CoverRate","0");
                HomeCareTreatmentCoversSecChildObj.put("CoverPremium","0");
                HomeCareTreatmentCoversSecChildObj.put("CoverGroups","Home Care Treatment");
                SecondChildCoversArray.put(HomeCareTreatmentCoversSecChildObj);

                JSONObject WellnessBenefitCoversSecChildObj=new JSONObject();
                WellnessBenefitCoversSecChildObj.put("Applicable",WellnessBenefitStatus);
                WellnessBenefitCoversSecChildObj.put("CoverSI",strSumInsured);
                WellnessBenefitCoversSecChildObj.put("CoverRate","0");
                WellnessBenefitCoversSecChildObj.put("CoverPremium","0");
                WellnessBenefitCoversSecChildObj.put("CoverGroups","Wellness Benefit");
                SecondChildCoversArray.put(WellnessBenefitCoversSecChildObj);

                JSONObject DiseaseManagementCoversSecChildObj=new JSONObject();
                DiseaseManagementCoversSecChildObj.put("Applicable",DiseaseManagementStatus);
                DiseaseManagementCoversSecChildObj.put("CoverSI",strSumInsured);
                DiseaseManagementCoversSecChildObj.put("CoverRate","0");
                DiseaseManagementCoversSecChildObj.put("CoverPremium","0");
                DiseaseManagementCoversSecChildObj.put("CoverGroups","Disease Management Program");
                SecondChildCoversArray.put(DiseaseManagementCoversSecChildObj);
                CoverDetailsSecondChildObj.put("Covers",SecondChildCoversArray);
                SecondChildObj.put("CoverDetails",CoverDetailsSecondChildObj);

               //Third child
                JSONObject ThirdChildObj=new JSONObject();
                ThirdChildObj.put("InsuredType","Child");
                ThirdChildObj.put("FirstName",strThirdChildNameEdit);
                ThirdChildObj.put("LastName","");
                ThirdChildObj.put("DOB",strThirdSonAgeEditText);
                ThirdChildObj.put("Gender",str_thirdGenderSpinner);
                ThirdChildObj.put("Relationship",strRelationChildThreeEdit);
                ThirdChildObj.put("Occupation","Student");
                ThirdChildObj.put("NomineeName",strNomineeName);
                ThirdChildObj.put("NomineeRelationship",strNomineeRelationEdit);

                JSONObject HealthIndicatorsThirdChildObj=new JSONObject();
                HealthIndicatorsThirdChildObj.put("PED","N");
                HealthIndicatorsThirdChildObj.put("PEDDeclared","N");
                HealthIndicatorsThirdChildObj.put("BloodSugarLevel",strBloodSugar);
                HealthIndicatorsThirdChildObj.put("BloodPressureSystolic",strBloodPressure);
                HealthIndicatorsThirdChildObj.put("BloodPressureDiastolic",strBloodPressureDiastolic);
                HealthIndicatorsThirdChildObj.put("CholesterolLevel",strcholesterol);
                HealthIndicatorsThirdChildObj.put("BodyMassIndex",strBMIEChildThreeEdit);
                HealthIndicatorsThirdChildObj.put("TobaccoAndAlcohol","N");
                HealthIndicatorsThirdChildObj.put("CoMorbidity","N");
                ThirdChildObj.put("HealthIndicators",HealthIndicatorsThirdChildObj);

                JSONObject CoverDetailsThirdChildObj=new JSONObject();
                JSONArray ThirdChildCoversArray = new JSONArray();
                JSONObject BasicInsuranceCoversThirdChildObj=new JSONObject();
                BasicInsuranceCoversThirdChildObj.put("Applicable",BasicStatus);
                BasicInsuranceCoversThirdChildObj.put("CoverSI",strSumInsured);
                BasicInsuranceCoversThirdChildObj.put("CoverRate","0");
                BasicInsuranceCoversThirdChildObj.put("CoverPremium","0");
                BasicInsuranceCoversThirdChildObj.put("CoverGroups","Basic Insurance Cover");
                ThirdChildCoversArray.put(BasicInsuranceCoversThirdChildObj);

                JSONObject PersonalAccidentCoversThirdChildObj=new JSONObject();
                PersonalAccidentCoversThirdChildObj.put("Applicable",PersonalStatusChildThird);
                PersonalAccidentCoversThirdChildObj.put("CoverSI",strSumInsured);
                PersonalAccidentCoversThirdChildObj.put("CoverRate","0");
                PersonalAccidentCoversThirdChildObj.put("CoverPremium","0");
                PersonalAccidentCoversThirdChildObj.put("CoverGroups","Personal Accident Cover");
                ThirdChildCoversArray.put(PersonalAccidentCoversThirdChildObj);

                JSONObject CriticalIllnessCoversThirdChildObj=new JSONObject();
                CriticalIllnessCoversThirdChildObj.put("Applicable",CriticalStatus);
                CriticalIllnessCoversThirdChildObj.put("CoverSI",strSumInsured);
                CriticalIllnessCoversThirdChildObj.put("CoverRate","0");
                CriticalIllnessCoversThirdChildObj.put("CoverPremium","0");
                CriticalIllnessCoversThirdChildObj.put("CoverGroups","Critical Illness Cover");
                ThirdChildCoversArray.put(CriticalIllnessCoversThirdChildObj);


                JSONObject DailyHospitalCoversThirdChildObj=new JSONObject();
                DailyHospitalCoversThirdChildObj.put("Applicable",DailyHospitalSatus);
                DailyHospitalCoversThirdChildObj.put("CoverSI",strSumInsured);
                DailyHospitalCoversThirdChildObj.put("CoverRate","0");
                DailyHospitalCoversThirdChildObj.put("CoverPremium","0");
                DailyHospitalCoversThirdChildObj.put("CoverGroups","Daily Hospital Cash Cover");
                ThirdChildCoversArray.put(DailyHospitalCoversThirdChildObj);

                JSONObject ModernCoversThirdChildObj=new JSONObject();
                ModernCoversThirdChildObj.put("Applicable",ModernTreatmentsStatus);
                ModernCoversThirdChildObj.put("CoverSI",strSumInsured);
                ModernCoversThirdChildObj.put("CoverRate","0");
                ModernCoversThirdChildObj.put("CoverPremium","0");
                ModernCoversThirdChildObj.put("CoverGroups","Modern Treatments");
                ThirdChildCoversArray.put(ModernCoversThirdChildObj);
                JSONObject ExtensionPreHospitalizationCoversThirdChildObj=new JSONObject();
                ExtensionPreHospitalizationCoversThirdChildObj.put("Applicable",ExtensionPreHospitalization);
                ExtensionPreHospitalizationCoversThirdChildObj.put("CoverSI",strSumInsured);
                ExtensionPreHospitalizationCoversThirdChildObj.put("CoverRate","0");
                ExtensionPreHospitalizationCoversThirdChildObj.put("CoverPremium","0");
                ExtensionPreHospitalizationCoversThirdChildObj.put("CoverGroups","Extension under Pre-Hospitalization");
                ThirdChildCoversArray.put(ExtensionPreHospitalizationCoversThirdChildObj);

                JSONObject ExtensionPostHospitalizationCoversThirdChildObj=new JSONObject();
                ExtensionPostHospitalizationCoversThirdChildObj.put("Applicable",ExtensionPr0Hospitalization);
                ExtensionPostHospitalizationCoversThirdChildObj.put("CoverSI",strSumInsured);
                ExtensionPostHospitalizationCoversThirdChildObj.put("CoverRate","0");
                ExtensionPostHospitalizationCoversThirdChildObj.put("CoverPremium","0");
                ExtensionPostHospitalizationCoversThirdChildObj.put("CoverGroups","Extension under Post-Hospitalization");
                ThirdChildCoversArray.put(ExtensionPostHospitalizationCoversThirdChildObj);


                JSONObject MaternityAndChildcareCoversThirdChildObj=new JSONObject();
                MaternityAndChildcareCoversThirdChildObj.put("Applicable","False");
                MaternityAndChildcareCoversThirdChildObj.put("CoverSI",strSumInsured);
                MaternityAndChildcareCoversThirdChildObj.put("CoverRate","0");
                MaternityAndChildcareCoversThirdChildObj.put("CoverPremium","0");
                MaternityAndChildcareCoversThirdChildObj.put("CoverGroups","Maternity and Childcare Benefit Waiting Period Modification");
                ThirdChildCoversArray.put(MaternityAndChildcareCoversThirdChildObj);

                JSONObject CoverageForNonMedicalCoversThirdChildObj=new JSONObject();
                CoverageForNonMedicalCoversThirdChildObj.put("Applicable",CoverageNonMedical);
                CoverageForNonMedicalCoversThirdChildObj.put("CoverSI",strSumInsured);
                CoverageForNonMedicalCoversThirdChildObj.put("CoverRate","0");
                CoverageForNonMedicalCoversThirdChildObj.put("CoverPremium","0");
                CoverageForNonMedicalCoversThirdChildObj.put("CoverGroups","Coverage for Non-Medical Items");
                ThirdChildCoversArray.put(CoverageForNonMedicalCoversThirdChildObj);

                JSONObject ConditionWaiverCoversThirdChildObj=new JSONObject();
                ConditionWaiverCoversThirdChildObj.put("Applicable",ConditionWaiverStatus);
                ConditionWaiverCoversThirdChildObj.put("CoverSI",strSumInsured);
                ConditionWaiverCoversThirdChildObj.put("CoverRate","0");
                ConditionWaiverCoversThirdChildObj.put("CoverPremium","0");
                ConditionWaiverCoversThirdChildObj.put("CoverGroups","Condition waiver under Restore Benefit");
                ThirdChildCoversArray.put(ConditionWaiverCoversThirdChildObj);

                JSONObject PreExistingDiseaseCoversThirdChildObj=new JSONObject();
                PreExistingDiseaseCoversThirdChildObj.put("Applicable",PreExistingDiseaseStatus);
                PreExistingDiseaseCoversThirdChildObj.put("CoverSI",strSumInsured);
                PreExistingDiseaseCoversThirdChildObj.put("CoverRate","0");
                PreExistingDiseaseCoversThirdChildObj.put("CoverPremium","0");
                PreExistingDiseaseCoversThirdChildObj.put("CoverGroups","Pre-Existing Disease waiting period");
                ThirdChildCoversArray.put(PreExistingDiseaseCoversThirdChildObj);

                JSONObject OutpatientDentalWaitingCoversThirdChildObj=new JSONObject();
                OutpatientDentalWaitingCoversThirdChildObj.put("Applicable",OutpatientDentalStatus);
                OutpatientDentalWaitingCoversThirdChildObj.put("CoverSI",strSumInsured);
                OutpatientDentalWaitingCoversThirdChildObj.put("CoverRate","0");
                OutpatientDentalWaitingCoversThirdChildObj.put("CoverPremium","0");
                OutpatientDentalWaitingCoversThirdChildObj.put("CoverGroups","Outpatient Dental Waiting Period Modification");
                ThirdChildCoversArray.put(OutpatientDentalWaitingCoversThirdChildObj);

                JSONObject EmergencyTravellingAllowanceCoversThirdChildObj=new JSONObject();
                EmergencyTravellingAllowanceCoversThirdChildObj.put("Applicable",EmergencyTravellingStatus);
                EmergencyTravellingAllowanceCoversThirdChildObj.put("CoverSI",strSumInsured);
                EmergencyTravellingAllowanceCoversThirdChildObj.put("CoverRate","0");
                EmergencyTravellingAllowanceCoversThirdChildObj.put("CoverPremium","0");
                EmergencyTravellingAllowanceCoversThirdChildObj.put("CoverGroups","Emergency Travelling Allowance");
                ThirdChildCoversArray.put(EmergencyTravellingAllowanceCoversThirdChildObj);

                JSONObject SecondOpinionCoversThirdChildObj=new JSONObject();
                SecondOpinionCoversThirdChildObj.put("Applicable",SecondOpinionStatus);
                SecondOpinionCoversThirdChildObj.put("CoverSI",strSumInsured);
                SecondOpinionCoversThirdChildObj.put("CoverRate","0");
                SecondOpinionCoversThirdChildObj.put("CoverPremium","0");
                SecondOpinionCoversThirdChildObj.put("CoverGroups","Second Opinion");
                ThirdChildCoversArray.put(SecondOpinionCoversThirdChildObj);

                JSONObject RestCureCoversThirdChildObj=new JSONObject();
                RestCureCoversThirdChildObj.put("Applicable",RestCureStatus);
                RestCureCoversThirdChildObj.put("CoverSI",strSumInsured);
                RestCureCoversThirdChildObj.put("CoverRate","0");
                RestCureCoversThirdChildObj.put("CoverPremium","0");
                RestCureCoversThirdChildObj.put("CoverGroups","Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
                ThirdChildCoversArray.put(RestCureCoversThirdChildObj);

                JSONObject ObesityWeightCoversThirdChildObj=new JSONObject();
                ObesityWeightCoversThirdChildObj.put("Applicable",ObesityWeightStatus);
                ObesityWeightCoversThirdChildObj.put("CoverSI",strSumInsured);
                ObesityWeightCoversThirdChildObj.put("CoverRate","0");
                ObesityWeightCoversThirdChildObj.put("CoverPremium","0");
                ObesityWeightCoversThirdChildObj.put("CoverGroups","Obesity/ Weight Control Expenses Extension");
                ThirdChildCoversArray.put(ObesityWeightCoversThirdChildObj);

                JSONObject SterilityInfertilityCoversThirdChildObj=new JSONObject();
                SterilityInfertilityCoversThirdChildObj.put("Applicable","False");
                SterilityInfertilityCoversThirdChildObj.put("CoverSI",strSumInsured);
                SterilityInfertilityCoversThirdChildObj.put("CoverRate","0");
                SterilityInfertilityCoversThirdChildObj.put("CoverPremium","0");
                SterilityInfertilityCoversThirdChildObj.put("CoverGroups","Sterility and Infertility Treatment Expenses Extension");
                ThirdChildCoversArray.put(SterilityInfertilityCoversThirdChildObj);

                JSONObject EnhancedOrganDonorCoversThirdChildObj=new JSONObject();
                EnhancedOrganDonorCoversThirdChildObj.put("Applicable",EnhancedOrganStatus);
                EnhancedOrganDonorCoversThirdChildObj.put("CoverSI",strSumInsured);
                EnhancedOrganDonorCoversThirdChildObj.put("CoverRate","0");
                EnhancedOrganDonorCoversThirdChildObj.put("CoverPremium","0");
                EnhancedOrganDonorCoversThirdChildObj.put("CoverGroups","Enhanced Organ Donor Expenses");
                ThirdChildCoversArray.put(EnhancedOrganDonorCoversThirdChildObj);

                JSONObject PremiumWaiverCoversThirdChildObj=new JSONObject();
                PremiumWaiverCoversThirdChildObj.put("Applicable",PremiumWaiverStatus);
                PremiumWaiverCoversThirdChildObj.put("CoverSI",strSumInsured);
                PremiumWaiverCoversThirdChildObj.put("CoverRate","0");
                PremiumWaiverCoversThirdChildObj.put("CoverPremium","0");
                PremiumWaiverCoversThirdChildObj.put("CoverGroups","Premium Waiver");
                ThirdChildCoversArray.put(PremiumWaiverCoversThirdChildObj);

                JSONObject GlobalCoversThirdChildObj=new JSONObject();
                GlobalCoversThirdChildObj.put("Applicable",GlobalCoverStatus);
                GlobalCoversThirdChildObj.put("CoverSI",strSumInsured);
                GlobalCoversThirdChildObj.put("CoverRate","0");
                GlobalCoversThirdChildObj.put("CoverPremium","0");
                GlobalCoversThirdChildObj.put("CoverGroups","Global Cover");
                ThirdChildCoversArray.put(GlobalCoversThirdChildObj);


                JSONObject MedicallyAdvisedCoversThirdChildObj=new JSONObject();
                MedicallyAdvisedCoversThirdChildObj.put("Applicable",MedicallyAdvisedStatus);
                MedicallyAdvisedCoversThirdChildObj.put("CoverSI",strSumInsured);
                MedicallyAdvisedCoversThirdChildObj.put("CoverRate","0");
                MedicallyAdvisedCoversThirdChildObj.put("CoverPremium","0");
                MedicallyAdvisedCoversThirdChildObj.put("CoverGroups","Medically Advised Support Devices");
                ThirdChildCoversArray.put(MedicallyAdvisedCoversThirdChildObj);

                JSONObject EmergencyCoversThirdChildObj=new JSONObject();
                EmergencyCoversThirdChildObj.put("Applicable",EmergencyAssistanceStatus);
                EmergencyCoversThirdChildObj.put("CoverSI",strSumInsured);
                EmergencyCoversThirdChildObj.put("CoverRate","0");
                EmergencyCoversThirdChildObj.put("CoverPremium","0");
                EmergencyCoversThirdChildObj.put("CoverGroups","Emergency Assistance Service");
                ThirdChildCoversArray.put(EmergencyCoversThirdChildObj);

                JSONObject HomeCareTreatmentCoversThirdChildObj=new JSONObject();
                HomeCareTreatmentCoversThirdChildObj.put("Applicable",HomeCareStatus);
                HomeCareTreatmentCoversThirdChildObj.put("CoverSI",strSumInsured);
                HomeCareTreatmentCoversThirdChildObj.put("CoverRate","0");
                HomeCareTreatmentCoversThirdChildObj.put("CoverPremium","0");
                HomeCareTreatmentCoversThirdChildObj.put("CoverGroups","Home Care Treatment");
                ThirdChildCoversArray.put(HomeCareTreatmentCoversThirdChildObj);

                JSONObject WellnessBenefitCoversThirdChildObj=new JSONObject();
                WellnessBenefitCoversThirdChildObj.put("Applicable",WellnessBenefitStatus);
                WellnessBenefitCoversThirdChildObj.put("CoverSI",strSumInsured);
                WellnessBenefitCoversThirdChildObj.put("CoverRate","0");
                WellnessBenefitCoversThirdChildObj.put("CoverPremium","0");
                WellnessBenefitCoversThirdChildObj.put("CoverGroups","Wellness Benefit");
                ThirdChildCoversArray.put(WellnessBenefitCoversThirdChildObj);

                JSONObject DiseaseManagementCoversThirdChildObj=new JSONObject();
                DiseaseManagementCoversThirdChildObj.put("Applicable",DiseaseManagementStatus);
                DiseaseManagementCoversThirdChildObj.put("CoverSI",strSumInsured);
                DiseaseManagementCoversThirdChildObj.put("CoverRate","0");
                DiseaseManagementCoversThirdChildObj.put("CoverPremium","0");
                DiseaseManagementCoversThirdChildObj.put("CoverGroups","Disease Management Program");
                ThirdChildCoversArray.put(DiseaseManagementCoversThirdChildObj);
                CoverDetailsThirdChildObj.put("Covers",ThirdChildCoversArray);
                ThirdChildObj.put("CoverDetails",CoverDetailsThirdChildObj);

                //fourChild
                JSONObject FourthChildObj=new JSONObject();
                FourthChildObj.put("InsuredType","Child");
                FourthChildObj.put("FirstName",strFourChildNameEdit);
                FourthChildObj.put("LastName","");
                FourthChildObj.put("DOB",strFourSonAgeEditText);
                FourthChildObj.put("Gender",str_fourGenderSpinner);
                FourthChildObj.put("Relationship",strRelationFourChildEdit);
                FourthChildObj.put("Occupation","Student");
                FourthChildObj.put("NomineeName",strNomineeName);
                FourthChildObj.put("NomineeRelationship",strNomineeRelationEdit);

                JSONObject HealthIndicatorsFourthChildObj=new JSONObject();
                HealthIndicatorsFourthChildObj.put("PED","N");
                HealthIndicatorsFourthChildObj.put("PEDDeclared","N");
                HealthIndicatorsFourthChildObj.put("BloodSugarLevel",strBloodSugar);
                HealthIndicatorsFourthChildObj.put("BloodPressureSystolic",strBloodPressure);
                HealthIndicatorsFourthChildObj.put("BloodPressureDiastolic",strBloodPressureDiastolic);
                HealthIndicatorsFourthChildObj.put("CholesterolLevel",strcholesterol);
                HealthIndicatorsFourthChildObj.put("BodyMassIndex",strBMIFourChildEdit);
                HealthIndicatorsFourthChildObj.put("TobaccoAndAlcohol","N");
                HealthIndicatorsFourthChildObj.put("CoMorbidity","N");
                FourthChildObj.put("HealthIndicators",HealthIndicatorsFourthChildObj);

                JSONObject CoverDetailsFourthChildObj=new JSONObject();
                JSONArray FourthChildCoversArray = new JSONArray();
                JSONObject BasicInsuranceCoversFourthChildObj=new JSONObject();
                BasicInsuranceCoversFourthChildObj.put("Applicable",BasicStatus);
                BasicInsuranceCoversFourthChildObj.put("CoverSI",strSumInsured);
                BasicInsuranceCoversFourthChildObj.put("CoverRate","0");
                BasicInsuranceCoversFourthChildObj.put("CoverPremium","0");
                BasicInsuranceCoversFourthChildObj.put("CoverGroups","Basic Insurance Cover");
                FourthChildCoversArray.put(BasicInsuranceCoversFourthChildObj);

                JSONObject PersonalAccidentCoversFourthChildObj=new JSONObject();
                PersonalAccidentCoversFourthChildObj.put("Applicable",PersonalStatusChildFour);
                PersonalAccidentCoversFourthChildObj.put("CoverSI",strSumInsured);
                PersonalAccidentCoversFourthChildObj.put("CoverRate","0");
                PersonalAccidentCoversFourthChildObj.put("CoverPremium","0");
                PersonalAccidentCoversFourthChildObj.put("CoverGroups","Personal Accident Cover");
                FourthChildCoversArray.put(PersonalAccidentCoversFourthChildObj);

                JSONObject CriticalIllnessCoversFourthChildObj=new JSONObject();
                CriticalIllnessCoversFourthChildObj.put("Applicable",CriticalStatus);
                CriticalIllnessCoversFourthChildObj.put("CoverSI",strSumInsured);
                CriticalIllnessCoversFourthChildObj.put("CoverRate","0");
                CriticalIllnessCoversFourthChildObj.put("CoverPremium","0");
                CriticalIllnessCoversFourthChildObj.put("CoverGroups","Critical Illness Cover");
                FourthChildCoversArray.put(CriticalIllnessCoversFourthChildObj);


                JSONObject DailyHospitalCoversFourthChildObj=new JSONObject();
                DailyHospitalCoversFourthChildObj.put("Applicable",DailyHospitalSatus);
                DailyHospitalCoversFourthChildObj.put("CoverSI",strSumInsured);
                DailyHospitalCoversFourthChildObj.put("CoverRate","0");
                DailyHospitalCoversFourthChildObj.put("CoverPremium","0");
                DailyHospitalCoversFourthChildObj.put("CoverGroups","Daily Hospital Cash Cover");
                FourthChildCoversArray.put(DailyHospitalCoversFourthChildObj);

                JSONObject ModernCoversFourthChildObj=new JSONObject();
                ModernCoversFourthChildObj.put("Applicable",ModernTreatmentsStatus);
                ModernCoversFourthChildObj.put("CoverSI",strSumInsured);
                ModernCoversFourthChildObj.put("CoverRate","0");
                ModernCoversFourthChildObj.put("CoverPremium","0");
                ModernCoversFourthChildObj.put("CoverGroups","Modern Treatments");
                FourthChildCoversArray.put(ModernCoversFourthChildObj);
                JSONObject ExtensionPreHospitalizationCoversFourthChildObj=new JSONObject();
                ExtensionPreHospitalizationCoversFourthChildObj.put("Applicable",ExtensionPreHospitalization);
                ExtensionPreHospitalizationCoversFourthChildObj.put("CoverSI",strSumInsured);
                ExtensionPreHospitalizationCoversFourthChildObj.put("CoverRate","0");
                ExtensionPreHospitalizationCoversFourthChildObj.put("CoverPremium","0");
                ExtensionPreHospitalizationCoversFourthChildObj.put("CoverGroups","Extension under Pre-Hospitalization");
                FourthChildCoversArray.put(ExtensionPreHospitalizationCoversFourthChildObj);

                JSONObject ExtensionPostHospitalizationCoversFourthChildObj=new JSONObject();
                ExtensionPostHospitalizationCoversFourthChildObj.put("Applicable",ExtensionPr0Hospitalization);
                ExtensionPostHospitalizationCoversFourthChildObj.put("CoverSI",strSumInsured);
                ExtensionPostHospitalizationCoversFourthChildObj.put("CoverRate","0");
                ExtensionPostHospitalizationCoversFourthChildObj.put("CoverPremium","0");
                ExtensionPostHospitalizationCoversFourthChildObj.put("CoverGroups","Extension under Post-Hospitalization");
                FourthChildCoversArray.put(ExtensionPostHospitalizationCoversFourthChildObj);


                JSONObject MaternityAndChildcareCoversFourthChildObj=new JSONObject();
                MaternityAndChildcareCoversFourthChildObj.put("Applicable","False");
                MaternityAndChildcareCoversFourthChildObj.put("CoverSI",strSumInsured);
                MaternityAndChildcareCoversFourthChildObj.put("CoverRate","0");
                MaternityAndChildcareCoversFourthChildObj.put("CoverPremium","0");
                MaternityAndChildcareCoversFourthChildObj.put("CoverGroups","Maternity and Childcare Benefit Waiting Period Modification");
                FourthChildCoversArray.put(MaternityAndChildcareCoversFourthChildObj);

                JSONObject CoverageForNonMedicalCoversFourthChildObj=new JSONObject();
                CoverageForNonMedicalCoversFourthChildObj.put("Applicable",CoverageNonMedical);
                CoverageForNonMedicalCoversFourthChildObj.put("CoverSI",strSumInsured);
                CoverageForNonMedicalCoversFourthChildObj.put("CoverRate","0");
                CoverageForNonMedicalCoversFourthChildObj.put("CoverPremium","0");
                CoverageForNonMedicalCoversFourthChildObj.put("CoverGroups","Coverage for Non-Medical Items");
                FourthChildCoversArray.put(CoverageForNonMedicalCoversFourthChildObj);

                JSONObject ConditionWaiverCoversFourthChildObj=new JSONObject();
                ConditionWaiverCoversFourthChildObj.put("Applicable",ConditionWaiverStatus);
                ConditionWaiverCoversFourthChildObj.put("CoverSI",strSumInsured);
                ConditionWaiverCoversFourthChildObj.put("CoverRate","0");
                ConditionWaiverCoversFourthChildObj.put("CoverPremium","0");
                ConditionWaiverCoversFourthChildObj.put("CoverGroups","Condition waiver under Restore Benefit");
                FourthChildCoversArray.put(ConditionWaiverCoversFourthChildObj);

                JSONObject PreExistingDiseaseCoversFourthChildObj=new JSONObject();
                PreExistingDiseaseCoversFourthChildObj.put("Applicable",PreExistingDiseaseStatus);
                PreExistingDiseaseCoversFourthChildObj.put("CoverSI",strSumInsured);
                PreExistingDiseaseCoversFourthChildObj.put("CoverRate","0");
                PreExistingDiseaseCoversFourthChildObj.put("CoverPremium","0");
                PreExistingDiseaseCoversFourthChildObj.put("CoverGroups","Pre-Existing Disease waiting period");
                FourthChildCoversArray.put(PreExistingDiseaseCoversFourthChildObj);

                JSONObject OutpatientDentalWaitingCoversFourthChildObj=new JSONObject();
                OutpatientDentalWaitingCoversFourthChildObj.put("Applicable",OutpatientDentalStatus);
                OutpatientDentalWaitingCoversFourthChildObj.put("CoverSI",strSumInsured);
                OutpatientDentalWaitingCoversFourthChildObj.put("CoverRate","0");
                OutpatientDentalWaitingCoversFourthChildObj.put("CoverPremium","0");
                OutpatientDentalWaitingCoversFourthChildObj.put("CoverGroups","Outpatient Dental Waiting Period Modification");
                FourthChildCoversArray.put(OutpatientDentalWaitingCoversFourthChildObj);

                JSONObject EmergencyTravellingAllowanceCoversFourthChildObj=new JSONObject();
                EmergencyTravellingAllowanceCoversFourthChildObj.put("Applicable",EmergencyTravellingStatus);
                EmergencyTravellingAllowanceCoversFourthChildObj.put("CoverSI",strSumInsured);
                EmergencyTravellingAllowanceCoversFourthChildObj.put("CoverRate","0");
                EmergencyTravellingAllowanceCoversFourthChildObj.put("CoverPremium","0");
                EmergencyTravellingAllowanceCoversFourthChildObj.put("CoverGroups","Emergency Travelling Allowance");
                FourthChildCoversArray.put(EmergencyTravellingAllowanceCoversFourthChildObj);

                JSONObject SecondOpinionCoversFourthChildObj=new JSONObject();
                SecondOpinionCoversFourthChildObj.put("Applicable",SecondOpinionStatus);
                SecondOpinionCoversFourthChildObj.put("CoverSI",strSumInsured);
                SecondOpinionCoversFourthChildObj.put("CoverRate","0");
                SecondOpinionCoversFourthChildObj.put("CoverPremium","0");
                SecondOpinionCoversFourthChildObj.put("CoverGroups","Second Opinion");
                FourthChildCoversArray.put(SecondOpinionCoversFourthChildObj);

                JSONObject RestCureCoversFourthChildObj=new JSONObject();
                RestCureCoversFourthChildObj.put("Applicable",RestCureStatus);
                RestCureCoversFourthChildObj.put("CoverSI",strSumInsured);
                RestCureCoversFourthChildObj.put("CoverRate","0");
                RestCureCoversFourthChildObj.put("CoverPremium","0");
                RestCureCoversFourthChildObj.put("CoverGroups","Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
                FourthChildCoversArray.put(RestCureCoversFourthChildObj);

                JSONObject ObesityWeightCoversFourthChildObj=new JSONObject();
                ObesityWeightCoversFourthChildObj.put("Applicable",ObesityWeightStatus);
                ObesityWeightCoversFourthChildObj.put("CoverSI",strSumInsured);
                ObesityWeightCoversFourthChildObj.put("CoverRate","0");
                ObesityWeightCoversFourthChildObj.put("CoverPremium","0");
                ObesityWeightCoversFourthChildObj.put("CoverGroups","Obesity/ Weight Control Expenses Extension");
                FourthChildCoversArray.put(ObesityWeightCoversFourthChildObj);

                JSONObject SterilityInfertilityCoversFourthChildObj=new JSONObject();
                SterilityInfertilityCoversFourthChildObj.put("Applicable","False");
                SterilityInfertilityCoversFourthChildObj.put("CoverSI",strSumInsured);
                SterilityInfertilityCoversFourthChildObj.put("CoverRate","0");
                SterilityInfertilityCoversFourthChildObj.put("CoverPremium","0");
                SterilityInfertilityCoversFourthChildObj.put("CoverGroups","Sterility and Infertility Treatment Expenses Extension");
                FourthChildCoversArray.put(SterilityInfertilityCoversFourthChildObj);

                JSONObject EnhancedOrganDonorCoversFourthChildObj=new JSONObject();
                EnhancedOrganDonorCoversFourthChildObj.put("Applicable",EnhancedOrganStatus);
                EnhancedOrganDonorCoversFourthChildObj.put("CoverSI",strSumInsured);
                EnhancedOrganDonorCoversFourthChildObj.put("CoverRate","0");
                EnhancedOrganDonorCoversFourthChildObj.put("CoverPremium","0");
                EnhancedOrganDonorCoversFourthChildObj.put("CoverGroups","Enhanced Organ Donor Expenses");
                FourthChildCoversArray.put(EnhancedOrganDonorCoversFourthChildObj);

                JSONObject PremiumWaiverCoversFourthChildObj=new JSONObject();
                PremiumWaiverCoversFourthChildObj.put("Applicable",PremiumWaiverStatus);
                PremiumWaiverCoversFourthChildObj.put("CoverSI",strSumInsured);
                PremiumWaiverCoversFourthChildObj.put("CoverRate","0");
                PremiumWaiverCoversFourthChildObj.put("CoverPremium","0");
                PremiumWaiverCoversFourthChildObj.put("CoverGroups","Premium Waiver");
                FourthChildCoversArray.put(PremiumWaiverCoversFourthChildObj);

                JSONObject GlobalCoversFourthChildObj=new JSONObject();
                GlobalCoversFourthChildObj.put("Applicable",GlobalCoverStatus);
                GlobalCoversFourthChildObj.put("CoverSI",strSumInsured);
                GlobalCoversFourthChildObj.put("CoverRate","0");
                GlobalCoversFourthChildObj.put("CoverPremium","0");
                GlobalCoversFourthChildObj.put("CoverGroups","Global Cover");
                FourthChildCoversArray.put(GlobalCoversFourthChildObj);


                JSONObject MedicallyAdvisedCoversFourthChildObj=new JSONObject();
                MedicallyAdvisedCoversFourthChildObj.put("Applicable",MedicallyAdvisedStatus);
                MedicallyAdvisedCoversFourthChildObj.put("CoverSI",strSumInsured);
                MedicallyAdvisedCoversFourthChildObj.put("CoverRate","0");
                MedicallyAdvisedCoversFourthChildObj.put("CoverPremium","0");
                MedicallyAdvisedCoversFourthChildObj.put("CoverGroups","Medically Advised Support Devices");
                FourthChildCoversArray.put(MedicallyAdvisedCoversFourthChildObj);

                JSONObject EmergencyCoversFourthChildObj=new JSONObject();
                EmergencyCoversFourthChildObj.put("Applicable",EmergencyAssistanceStatus);
                EmergencyCoversFourthChildObj.put("CoverSI",strSumInsured);
                EmergencyCoversFourthChildObj.put("CoverRate","0");
                EmergencyCoversFourthChildObj.put("CoverPremium","0");
                EmergencyCoversFourthChildObj.put("CoverGroups","Emergency Assistance Service");
                FourthChildCoversArray.put(EmergencyCoversFourthChildObj);

                JSONObject HomeCareTreatmentCoversFourthChildObj=new JSONObject();
                HomeCareTreatmentCoversFourthChildObj.put("Applicable",HomeCareStatus);
                HomeCareTreatmentCoversFourthChildObj.put("CoverSI",strSumInsured);
                HomeCareTreatmentCoversFourthChildObj.put("CoverRate","0");
                HomeCareTreatmentCoversFourthChildObj.put("CoverPremium","0");
                HomeCareTreatmentCoversFourthChildObj.put("CoverGroups","Home Care Treatment");
                FourthChildCoversArray.put(HomeCareTreatmentCoversFourthChildObj);

                JSONObject WellnessBenefitCoversFourthChildObj=new JSONObject();
                WellnessBenefitCoversFourthChildObj.put("Applicable",WellnessBenefitStatus);
                WellnessBenefitCoversFourthChildObj.put("CoverSI",strSumInsured);
                WellnessBenefitCoversFourthChildObj.put("CoverRate","0");
                WellnessBenefitCoversFourthChildObj.put("CoverPremium","0");
                WellnessBenefitCoversFourthChildObj.put("CoverGroups","Wellness Benefit");
                FourthChildCoversArray.put(WellnessBenefitCoversFourthChildObj);

                JSONObject DiseaseManagementCoversFourthChildObj=new JSONObject();
                DiseaseManagementCoversFourthChildObj.put("Applicable",DiseaseManagementStatus);
                DiseaseManagementCoversFourthChildObj.put("CoverSI",strSumInsured);
                DiseaseManagementCoversFourthChildObj.put("CoverRate","0");
                DiseaseManagementCoversFourthChildObj.put("CoverPremium","0");
                DiseaseManagementCoversFourthChildObj.put("CoverGroups","Disease Management Program");
                FourthChildCoversArray.put(DiseaseManagementCoversFourthChildObj);
                CoverDetailsFourthChildObj.put("Covers",FourthChildCoversArray);
                FourthChildObj.put("CoverDetails",CoverDetailsFourthChildObj);

                //Mother
                JSONObject MotherObj=new JSONObject();
                MotherObj.put("InsuredType","Parent");
                MotherObj.put("FirstName",strMotherEditTextName);
                MotherObj.put("LastName","");
                MotherObj.put("DOB",strMotherAgeEditText);
                MotherObj.put("Gender","F");
                MotherObj.put("Relationship","Mother");
                MotherObj.put("Occupation",strMotherOccupationEdit);
                MotherObj.put("NomineeName",strNomineeName);
                MotherObj.put("NomineeRelationship",strNomineeRelationEdit);

                JSONObject HealthIndicatorsMotherObj=new JSONObject();
                HealthIndicatorsMotherObj.put("PED","N");
                HealthIndicatorsMotherObj.put("PEDDeclared","N");
                HealthIndicatorsMotherObj.put("BloodSugarLevel",strBloodSugar);
                HealthIndicatorsMotherObj.put("BloodPressureSystolic",strBloodPressure);
                HealthIndicatorsMotherObj.put("BloodPressureDiastolic",strBloodPressureDiastolic);
                HealthIndicatorsMotherObj.put("CholesterolLevel",strcholesterol);
                HealthIndicatorsMotherObj.put("BodyMassIndex",strBMIMotherEdit);
                HealthIndicatorsMotherObj.put("TobaccoAndAlcohol","N");
                HealthIndicatorsMotherObj.put("CoMorbidity","N");
                MotherObj.put("HealthIndicators",HealthIndicatorsMotherObj);

                JSONObject CoverDetailsMotherObj=new JSONObject();
                JSONArray MotherCoversArray = new JSONArray();
                JSONObject BasicInsuranceCoversMotherObj=new JSONObject();
                BasicInsuranceCoversMotherObj.put("Applicable",BasicStatus);
                BasicInsuranceCoversMotherObj.put("CoverSI",strSumInsured);
                BasicInsuranceCoversMotherObj.put("CoverRate","0");
                BasicInsuranceCoversMotherObj.put("CoverPremium","0");
                BasicInsuranceCoversMotherObj.put("CoverGroups","Basic Insurance Cover");
                MotherCoversArray.put(BasicInsuranceCoversMotherObj);

                JSONObject PersonalAccidentCoversMotherObj=new JSONObject();
                PersonalAccidentCoversMotherObj.put("Applicable",PersonalStatus);
                PersonalAccidentCoversMotherObj.put("CoverSI",strSumInsured);
                PersonalAccidentCoversMotherObj.put("CoverRate","0");
                PersonalAccidentCoversMotherObj.put("CoverPremium","0");
                PersonalAccidentCoversMotherObj.put("CoverGroups","Personal Accident Cover");
                MotherCoversArray.put(PersonalAccidentCoversMotherObj);

                JSONObject CriticalIllnessCoversMotherObj=new JSONObject();
                CriticalIllnessCoversMotherObj.put("Applicable",CriticalStatus);
                CriticalIllnessCoversMotherObj.put("CoverSI",strSumInsured);
                CriticalIllnessCoversMotherObj.put("CoverRate","0");
                CriticalIllnessCoversMotherObj.put("CoverPremium","0");
                CriticalIllnessCoversMotherObj.put("CoverGroups","Critical Illness Cover");
                MotherCoversArray.put(CriticalIllnessCoversMotherObj);


                JSONObject DailyHospitalCoversMotherObj=new JSONObject();
                DailyHospitalCoversMotherObj.put("Applicable",DailyHospitalSatus);
                DailyHospitalCoversMotherObj.put("CoverSI",strSumInsured);
                DailyHospitalCoversMotherObj.put("CoverRate","0");
                DailyHospitalCoversMotherObj.put("CoverPremium","0");
                DailyHospitalCoversMotherObj.put("CoverGroups","Daily Hospital Cash Cover");
                MotherCoversArray.put(DailyHospitalCoversMotherObj);

                JSONObject ModernCoversMotherObj=new JSONObject();
                ModernCoversMotherObj.put("Applicable",ModernTreatmentsStatus);
                ModernCoversMotherObj.put("CoverSI",strSumInsured);
                ModernCoversMotherObj.put("CoverRate","0");
                ModernCoversMotherObj.put("CoverPremium","0");
                ModernCoversMotherObj.put("CoverGroups","Modern Treatments");
                MotherCoversArray.put(ModernCoversMotherObj);
                JSONObject ExtensionPreHospitalizationCoversMotherObj=new JSONObject();
                ExtensionPreHospitalizationCoversMotherObj.put("Applicable",ExtensionPreHospitalization);
                ExtensionPreHospitalizationCoversMotherObj.put("CoverSI",strSumInsured);
                ExtensionPreHospitalizationCoversMotherObj.put("CoverRate","0");
                ExtensionPreHospitalizationCoversMotherObj.put("CoverPremium","0");
                ExtensionPreHospitalizationCoversMotherObj.put("CoverGroups","Extension under Pre-Hospitalization");
                MotherCoversArray.put(ExtensionPreHospitalizationCoversMotherObj);

                JSONObject ExtensionPostHospitalizationCoversMotherObj=new JSONObject();
                ExtensionPostHospitalizationCoversMotherObj.put("Applicable",ExtensionPr0Hospitalization);
                ExtensionPostHospitalizationCoversMotherObj.put("CoverSI",strSumInsured);
                ExtensionPostHospitalizationCoversMotherObj.put("CoverRate","0");
                ExtensionPostHospitalizationCoversMotherObj.put("CoverPremium","0");
                ExtensionPostHospitalizationCoversMotherObj.put("CoverGroups","Extension under Post-Hospitalization");
                MotherCoversArray.put(ExtensionPostHospitalizationCoversMotherObj);


                JSONObject MaternityAndChildcareCoversMotherObj=new JSONObject();
                MaternityAndChildcareCoversMotherObj.put("Applicable","False");
                MaternityAndChildcareCoversMotherObj.put("CoverSI",strSumInsured);
                MaternityAndChildcareCoversMotherObj.put("CoverRate","0");
                MaternityAndChildcareCoversMotherObj.put("CoverPremium","0");
                MaternityAndChildcareCoversMotherObj.put("CoverGroups","Maternity and Childcare Benefit Waiting Period Modification");
                MotherCoversArray.put(MaternityAndChildcareCoversMotherObj);

                JSONObject CoverageForNonMedicalCoversMotherObj=new JSONObject();
                CoverageForNonMedicalCoversMotherObj.put("Applicable",CoverageNonMedical);
                CoverageForNonMedicalCoversMotherObj.put("CoverSI",strSumInsured);
                CoverageForNonMedicalCoversMotherObj.put("CoverRate","0");
                CoverageForNonMedicalCoversMotherObj.put("CoverPremium","0");
                CoverageForNonMedicalCoversMotherObj.put("CoverGroups","Coverage for Non-Medical Items");
                MotherCoversArray.put(CoverageForNonMedicalCoversMotherObj);

                JSONObject ConditionWaiverCoversMotherObj=new JSONObject();
                ConditionWaiverCoversMotherObj.put("Applicable",ConditionWaiverStatus);
                ConditionWaiverCoversMotherObj.put("CoverSI",strSumInsured);
                ConditionWaiverCoversMotherObj.put("CoverRate","0");
                ConditionWaiverCoversMotherObj.put("CoverPremium","0");
                ConditionWaiverCoversMotherObj.put("CoverGroups","Condition waiver under Restore Benefit");
                MotherCoversArray.put(ConditionWaiverCoversMotherObj);

                JSONObject PreExistingDiseaseCoversMotherObj=new JSONObject();
                PreExistingDiseaseCoversMotherObj.put("Applicable",PreExistingDiseaseStatus);
                PreExistingDiseaseCoversMotherObj.put("CoverSI",strSumInsured);
                PreExistingDiseaseCoversMotherObj.put("CoverRate","0");
                PreExistingDiseaseCoversMotherObj.put("CoverPremium","0");
                PreExistingDiseaseCoversMotherObj.put("CoverGroups","Pre-Existing Disease waiting period");
                MotherCoversArray.put(PreExistingDiseaseCoversMotherObj);

                JSONObject OutpatientDentalWaitingCoversMotherObj=new JSONObject();
                OutpatientDentalWaitingCoversMotherObj.put("Applicable",OutpatientDentalStatus);
                OutpatientDentalWaitingCoversMotherObj.put("CoverSI",strSumInsured);
                OutpatientDentalWaitingCoversMotherObj.put("CoverRate","0");
                OutpatientDentalWaitingCoversMotherObj.put("CoverPremium","0");
                OutpatientDentalWaitingCoversMotherObj.put("CoverGroups","Outpatient Dental Waiting Period Modification");
                MotherCoversArray.put(OutpatientDentalWaitingCoversMotherObj);

                JSONObject EmergencyTravellingAllowanceCoversMotherObj=new JSONObject();
                EmergencyTravellingAllowanceCoversMotherObj.put("Applicable",EmergencyTravellingStatus);
                EmergencyTravellingAllowanceCoversMotherObj.put("CoverSI",strSumInsured);
                EmergencyTravellingAllowanceCoversMotherObj.put("CoverRate","0");
                EmergencyTravellingAllowanceCoversMotherObj.put("CoverPremium","0");
                EmergencyTravellingAllowanceCoversMotherObj.put("CoverGroups","Emergency Travelling Allowance");
                MotherCoversArray.put(EmergencyTravellingAllowanceCoversMotherObj);

                JSONObject SecondOpinionCoversMotherObj=new JSONObject();
                SecondOpinionCoversMotherObj.put("Applicable",SecondOpinionStatus);
                SecondOpinionCoversMotherObj.put("CoverSI",strSumInsured);
                SecondOpinionCoversMotherObj.put("CoverRate","0");
                SecondOpinionCoversMotherObj.put("CoverPremium","0");
                SecondOpinionCoversMotherObj.put("CoverGroups","Second Opinion");
                MotherCoversArray.put(SecondOpinionCoversMotherObj);

                JSONObject RestCureCoversMotherObj=new JSONObject();
                RestCureCoversMotherObj.put("Applicable",RestCureStatus);
                RestCureCoversMotherObj.put("CoverSI",strSumInsured);
                RestCureCoversMotherObj.put("CoverRate","0");
                RestCureCoversMotherObj.put("CoverPremium","0");
                RestCureCoversMotherObj.put("CoverGroups","Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
                MotherCoversArray.put(RestCureCoversMotherObj);

                JSONObject ObesityWeightCoversMotherObj=new JSONObject();
                ObesityWeightCoversMotherObj.put("Applicable",ObesityWeightStatus);
                ObesityWeightCoversMotherObj.put("CoverSI",strSumInsured);
                ObesityWeightCoversMotherObj.put("CoverRate","0");
                ObesityWeightCoversMotherObj.put("CoverPremium","0");
                ObesityWeightCoversMotherObj.put("CoverGroups","Obesity/ Weight Control Expenses Extension");
                MotherCoversArray.put(ObesityWeightCoversMotherObj);

                JSONObject SterilityInfertilityCoversMotherObj=new JSONObject();
                SterilityInfertilityCoversMotherObj.put("Applicable","False");
                SterilityInfertilityCoversMotherObj.put("CoverSI",strSumInsured);
                SterilityInfertilityCoversMotherObj.put("CoverRate","0");
                SterilityInfertilityCoversMotherObj.put("CoverPremium","0");
                SterilityInfertilityCoversMotherObj.put("CoverGroups","Sterility and Infertility Treatment Expenses Extension");
                MotherCoversArray.put(SterilityInfertilityCoversMotherObj);

                JSONObject EnhancedOrganDonorCoversMotherObj=new JSONObject();
                EnhancedOrganDonorCoversMotherObj.put("Applicable",EnhancedOrganStatus);
                EnhancedOrganDonorCoversMotherObj.put("CoverSI",strSumInsured);
                EnhancedOrganDonorCoversMotherObj.put("CoverRate","0");
                EnhancedOrganDonorCoversMotherObj.put("CoverPremium","0");
                EnhancedOrganDonorCoversMotherObj.put("CoverGroups","Enhanced Organ Donor Expenses");
                MotherCoversArray.put(EnhancedOrganDonorCoversMotherObj);

                JSONObject PremiumWaiverCoversMotherObj=new JSONObject();
                PremiumWaiverCoversMotherObj.put("Applicable",PremiumWaiverStatus);
                PremiumWaiverCoversMotherObj.put("CoverSI",strSumInsured);
                PremiumWaiverCoversMotherObj.put("CoverRate","0");
                PremiumWaiverCoversMotherObj.put("CoverPremium","0");
                PremiumWaiverCoversMotherObj.put("CoverGroups","Premium Waiver");
                MotherCoversArray.put(PremiumWaiverCoversMotherObj);

                JSONObject GlobalCoversMotherObj=new JSONObject();
                GlobalCoversMotherObj.put("Applicable",GlobalCoverStatus);
                GlobalCoversMotherObj.put("CoverSI",strSumInsured);
                GlobalCoversMotherObj.put("CoverRate","0");
                GlobalCoversMotherObj.put("CoverPremium","0");
                GlobalCoversMotherObj.put("CoverGroups","Global Cover");
                MotherCoversArray.put(GlobalCoversMotherObj);


                JSONObject MedicallyAdvisedCoversMotherObj=new JSONObject();
                MedicallyAdvisedCoversMotherObj.put("Applicable",MedicallyAdvisedStatus);
                MedicallyAdvisedCoversMotherObj.put("CoverSI",strSumInsured);
                MedicallyAdvisedCoversMotherObj.put("CoverRate","0");
                MedicallyAdvisedCoversMotherObj.put("CoverPremium","0");
                MedicallyAdvisedCoversMotherObj.put("CoverGroups","Medically Advised Support Devices");
                MotherCoversArray.put(MedicallyAdvisedCoversMotherObj);

                JSONObject EmergencyCoversMotherObj=new JSONObject();
                EmergencyCoversMotherObj.put("Applicable",EmergencyAssistanceStatus);
                EmergencyCoversMotherObj.put("CoverSI",strSumInsured);
                EmergencyCoversMotherObj.put("CoverRate","0");
                EmergencyCoversMotherObj.put("CoverPremium","0");
                EmergencyCoversMotherObj.put("CoverGroups","Emergency Assistance Service");
                MotherCoversArray.put(EmergencyCoversMotherObj);

                JSONObject HomeCareTreatmentCoversMotherObj=new JSONObject();
                HomeCareTreatmentCoversMotherObj.put("Applicable",HomeCareStatus);
                HomeCareTreatmentCoversMotherObj.put("CoverSI",strSumInsured);
                HomeCareTreatmentCoversMotherObj.put("CoverRate","0");
                HomeCareTreatmentCoversMotherObj.put("CoverPremium","0");
                HomeCareTreatmentCoversMotherObj.put("CoverGroups","Home Care Treatment");
                MotherCoversArray.put(HomeCareTreatmentCoversMotherObj);

                JSONObject WellnessBenefitCoversMotherObj=new JSONObject();
                WellnessBenefitCoversMotherObj.put("Applicable",WellnessBenefitStatus);
                WellnessBenefitCoversMotherObj.put("CoverSI",strSumInsured);
                WellnessBenefitCoversMotherObj.put("CoverRate","0");
                WellnessBenefitCoversMotherObj.put("CoverPremium","0");
                WellnessBenefitCoversMotherObj.put("CoverGroups","Wellness Benefit");
                MotherCoversArray.put(WellnessBenefitCoversMotherObj);

                JSONObject DiseaseManagementCoversMotherObj=new JSONObject();
                DiseaseManagementCoversMotherObj.put("Applicable",DiseaseManagementStatus);
                DiseaseManagementCoversMotherObj.put("CoverSI",strSumInsured);
                DiseaseManagementCoversMotherObj.put("CoverRate","0");
                DiseaseManagementCoversMotherObj.put("CoverPremium","0");
                DiseaseManagementCoversMotherObj.put("CoverGroups","Disease Management Program");
                MotherCoversArray.put(DiseaseManagementCoversMotherObj);
                CoverDetailsMotherObj.put("Covers",MotherCoversArray);
                MotherObj.put("CoverDetails",CoverDetailsMotherObj);

                //father
                JSONObject FatherObj=new JSONObject();
                FatherObj.put("InsuredType","Parent");
                FatherObj.put("FirstName",strFatherEditTextName);
                FatherObj.put("LastName","");
                FatherObj.put("DOB",strFatherAgeEditText);
                FatherObj.put("Gender","M");
                FatherObj.put("Relationship","Father");
                FatherObj.put("Occupation",strFatherOccupationEdit);
                FatherObj.put("NomineeName",strNomineeName);
                FatherObj.put("NomineeRelationship",strNomineeRelationEdit);

                JSONObject HealthIndicatorsFatherObj=new JSONObject();
                HealthIndicatorsFatherObj.put("PED","N");
                HealthIndicatorsFatherObj.put("PEDDeclared","N");
                HealthIndicatorsFatherObj.put("BloodSugarLevel",strBloodSugar);
                HealthIndicatorsFatherObj.put("BloodPressureSystolic",strBloodPressure);
                HealthIndicatorsFatherObj.put("BloodPressureDiastolic",strBloodPressureDiastolic);
                HealthIndicatorsFatherObj.put("CholesterolLevel",strcholesterol);
                HealthIndicatorsFatherObj.put("BodyMassIndex",strBMIFatherEdit);
                HealthIndicatorsFatherObj.put("TobaccoAndAlcohol","N");
                HealthIndicatorsFatherObj.put("CoMorbidity","N");
                FatherObj.put("HealthIndicators",HealthIndicatorsFatherObj);

                JSONObject CoverDetailsFatherObj=new JSONObject();
                JSONArray FatherCoversArray = new JSONArray();
                JSONObject BasicInsuranceCoversFatherObj=new JSONObject();
                BasicInsuranceCoversFatherObj.put("Applicable",BasicStatus);
                BasicInsuranceCoversFatherObj.put("CoverSI",strSumInsured);
                BasicInsuranceCoversFatherObj.put("CoverRate","0");
                BasicInsuranceCoversFatherObj.put("CoverPremium","0");
                BasicInsuranceCoversFatherObj.put("CoverGroups","Basic Insurance Cover");
                FatherCoversArray.put(BasicInsuranceCoversFatherObj);

                JSONObject PersonalAccidentCoversFatherObj=new JSONObject();
                PersonalAccidentCoversFatherObj.put("Applicable",PersonalStatus);
                PersonalAccidentCoversFatherObj.put("CoverSI",strSumInsured);
                PersonalAccidentCoversFatherObj.put("CoverRate","0");
                PersonalAccidentCoversFatherObj.put("CoverPremium","0");
                PersonalAccidentCoversFatherObj.put("CoverGroups","Personal Accident Cover");
                FatherCoversArray.put(PersonalAccidentCoversFatherObj);

                JSONObject CriticalIllnessCoversFatherObj=new JSONObject();
                CriticalIllnessCoversFatherObj.put("Applicable",CriticalStatus);
                CriticalIllnessCoversFatherObj.put("CoverSI",strSumInsured);
                CriticalIllnessCoversFatherObj.put("CoverRate","0");
                CriticalIllnessCoversFatherObj.put("CoverPremium","0");
                CriticalIllnessCoversFatherObj.put("CoverGroups","Critical Illness Cover");
                FatherCoversArray.put(CriticalIllnessCoversFatherObj);


                JSONObject DailyHospitalCoversFatherObj=new JSONObject();
                DailyHospitalCoversFatherObj.put("Applicable",DailyHospitalSatus);
                DailyHospitalCoversFatherObj.put("CoverSI",strSumInsured);
                DailyHospitalCoversFatherObj.put("CoverRate","0");
                DailyHospitalCoversFatherObj.put("CoverPremium","0");
                DailyHospitalCoversFatherObj.put("CoverGroups","Daily Hospital Cash Cover");
                FatherCoversArray.put(DailyHospitalCoversFatherObj);

                JSONObject ModernCoversFatherObj=new JSONObject();
                ModernCoversFatherObj.put("Applicable",ModernTreatmentsStatus);
                ModernCoversFatherObj.put("CoverSI",strSumInsured);
                ModernCoversFatherObj.put("CoverRate","0");
                ModernCoversFatherObj.put("CoverPremium","0");
                ModernCoversFatherObj.put("CoverGroups","Modern Treatments");
                FatherCoversArray.put(ModernCoversFatherObj);
                JSONObject ExtensionPreHospitalizationCoversFatherObj=new JSONObject();
                ExtensionPreHospitalizationCoversFatherObj.put("Applicable",ExtensionPreHospitalization);
                ExtensionPreHospitalizationCoversFatherObj.put("CoverSI",strSumInsured);
                ExtensionPreHospitalizationCoversFatherObj.put("CoverRate","0");
                ExtensionPreHospitalizationCoversFatherObj.put("CoverPremium","0");
                ExtensionPreHospitalizationCoversFatherObj.put("CoverGroups","Extension under Pre-Hospitalization");
                FatherCoversArray.put(ExtensionPreHospitalizationCoversFatherObj);

                JSONObject ExtensionPostHospitalizationCoversFatherObj=new JSONObject();
                ExtensionPostHospitalizationCoversFatherObj.put("Applicable",ExtensionPr0Hospitalization);
                ExtensionPostHospitalizationCoversFatherObj.put("CoverSI",strSumInsured);
                ExtensionPostHospitalizationCoversFatherObj.put("CoverRate","0");
                ExtensionPostHospitalizationCoversFatherObj.put("CoverPremium","0");
                ExtensionPostHospitalizationCoversFatherObj.put("CoverGroups","Extension under Post-Hospitalization");
                FatherCoversArray.put(ExtensionPostHospitalizationCoversFatherObj);


                JSONObject MaternityAndChildcareCoversFatherObj=new JSONObject();
                MaternityAndChildcareCoversFatherObj.put("Applicable","False");
                MaternityAndChildcareCoversFatherObj.put("CoverSI",strSumInsured);
                MaternityAndChildcareCoversFatherObj.put("CoverRate","0");
                MaternityAndChildcareCoversFatherObj.put("CoverPremium","0");
                MaternityAndChildcareCoversFatherObj.put("CoverGroups","Maternity and Childcare Benefit Waiting Period Modification");
                FatherCoversArray.put(MaternityAndChildcareCoversFatherObj);

                JSONObject CoverageForNonMedicalCoversFatherObj=new JSONObject();
                CoverageForNonMedicalCoversFatherObj.put("Applicable",CoverageNonMedical);
                CoverageForNonMedicalCoversFatherObj.put("CoverSI",strSumInsured);
                CoverageForNonMedicalCoversFatherObj.put("CoverRate","0");
                CoverageForNonMedicalCoversFatherObj.put("CoverPremium","0");
                CoverageForNonMedicalCoversFatherObj.put("CoverGroups","Coverage for Non-Medical Items");
                FatherCoversArray.put(CoverageForNonMedicalCoversFatherObj);

                JSONObject ConditionWaiverCoversFatherObj=new JSONObject();
                ConditionWaiverCoversFatherObj.put("Applicable",ConditionWaiverStatus);
                ConditionWaiverCoversFatherObj.put("CoverSI",strSumInsured);
                ConditionWaiverCoversFatherObj.put("CoverRate","0");
                ConditionWaiverCoversFatherObj.put("CoverPremium","0");
                ConditionWaiverCoversFatherObj.put("CoverGroups","Condition waiver under Restore Benefit");
                FatherCoversArray.put(ConditionWaiverCoversFatherObj);

                JSONObject PreExistingDiseaseCoversFatherObj=new JSONObject();
                PreExistingDiseaseCoversFatherObj.put("Applicable",PreExistingDiseaseStatus);
                PreExistingDiseaseCoversFatherObj.put("CoverSI",strSumInsured);
                PreExistingDiseaseCoversFatherObj.put("CoverRate","0");
                PreExistingDiseaseCoversFatherObj.put("CoverPremium","0");
                PreExistingDiseaseCoversFatherObj.put("CoverGroups","Pre-Existing Disease waiting period");
                FatherCoversArray.put(PreExistingDiseaseCoversFatherObj);

                JSONObject OutpatientDentalWaitingCoversFatherObj=new JSONObject();
                OutpatientDentalWaitingCoversFatherObj.put("Applicable",OutpatientDentalStatus);
                OutpatientDentalWaitingCoversFatherObj.put("CoverSI",strSumInsured);
                OutpatientDentalWaitingCoversFatherObj.put("CoverRate","0");
                OutpatientDentalWaitingCoversFatherObj.put("CoverPremium","0");
                OutpatientDentalWaitingCoversFatherObj.put("CoverGroups","Outpatient Dental Waiting Period Modification");
                FatherCoversArray.put(OutpatientDentalWaitingCoversFatherObj);

                JSONObject EmergencyTravellingAllowanceCoversFatherObj=new JSONObject();
                EmergencyTravellingAllowanceCoversFatherObj.put("Applicable",EmergencyTravellingStatus);
                EmergencyTravellingAllowanceCoversFatherObj.put("CoverSI",strSumInsured);
                EmergencyTravellingAllowanceCoversFatherObj.put("CoverRate","0");
                EmergencyTravellingAllowanceCoversFatherObj.put("CoverPremium","0");
                EmergencyTravellingAllowanceCoversFatherObj.put("CoverGroups","Emergency Travelling Allowance");
                FatherCoversArray.put(EmergencyTravellingAllowanceCoversFatherObj);

                JSONObject SecondOpinionCoversFatherObj=new JSONObject();
                SecondOpinionCoversFatherObj.put("Applicable",SecondOpinionStatus);
                SecondOpinionCoversFatherObj.put("CoverSI",strSumInsured);
                SecondOpinionCoversFatherObj.put("CoverRate","0");
                SecondOpinionCoversFatherObj.put("CoverPremium","0");
                SecondOpinionCoversFatherObj.put("CoverGroups","Second Opinion");
                FatherCoversArray.put(SecondOpinionCoversFatherObj);

                JSONObject RestCureCoversFatherObj=new JSONObject();
                RestCureCoversFatherObj.put("Applicable",RestCureStatus);
                RestCureCoversFatherObj.put("CoverSI",strSumInsured);
                RestCureCoversFatherObj.put("CoverRate","0");
                RestCureCoversFatherObj.put("CoverPremium","0");
                RestCureCoversFatherObj.put("CoverGroups","Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
                FatherCoversArray.put(RestCureCoversFatherObj);

                JSONObject ObesityWeightCoversFatherObj=new JSONObject();
                ObesityWeightCoversFatherObj.put("Applicable",ObesityWeightStatus);
                ObesityWeightCoversFatherObj.put("CoverSI",strSumInsured);
                ObesityWeightCoversFatherObj.put("CoverRate","0");
                ObesityWeightCoversFatherObj.put("CoverPremium","0");
                ObesityWeightCoversFatherObj.put("CoverGroups","Obesity/ Weight Control Expenses Extension");
                FatherCoversArray.put(ObesityWeightCoversFatherObj);

                JSONObject SterilityInfertilityCoversFatherObj=new JSONObject();
                SterilityInfertilityCoversFatherObj.put("Applicable","False");
                SterilityInfertilityCoversFatherObj.put("CoverSI",strSumInsured);
                SterilityInfertilityCoversFatherObj.put("CoverRate","0");
                SterilityInfertilityCoversFatherObj.put("CoverPremium","0");
                SterilityInfertilityCoversFatherObj.put("CoverGroups","Sterility and Infertility Treatment Expenses Extension");
                FatherCoversArray.put(SterilityInfertilityCoversFatherObj);

                JSONObject EnhancedOrganDonorCoversFatherObj=new JSONObject();
                EnhancedOrganDonorCoversFatherObj.put("Applicable",EnhancedOrganStatus);
                EnhancedOrganDonorCoversFatherObj.put("CoverSI",strSumInsured);
                EnhancedOrganDonorCoversFatherObj.put("CoverRate","0");
                EnhancedOrganDonorCoversFatherObj.put("CoverPremium","0");
                EnhancedOrganDonorCoversFatherObj.put("CoverGroups","Enhanced Organ Donor Expenses");
                FatherCoversArray.put(EnhancedOrganDonorCoversFatherObj);

                JSONObject PremiumWaiverCoversFatherObj=new JSONObject();
                PremiumWaiverCoversFatherObj.put("Applicable",PremiumWaiverStatus);
                PremiumWaiverCoversFatherObj.put("CoverSI",strSumInsured);
                PremiumWaiverCoversFatherObj.put("CoverRate","0");
                PremiumWaiverCoversFatherObj.put("CoverPremium","0");
                PremiumWaiverCoversFatherObj.put("CoverGroups","Premium Waiver");
                FatherCoversArray.put(PremiumWaiverCoversFatherObj);

                JSONObject GlobalCoversFatherObj=new JSONObject();
                GlobalCoversFatherObj.put("Applicable",GlobalCoverStatus);
                GlobalCoversFatherObj.put("CoverSI",strSumInsured);
                GlobalCoversFatherObj.put("CoverRate","0");
                GlobalCoversFatherObj.put("CoverPremium","0");
                GlobalCoversFatherObj.put("CoverGroups","Global Cover");
                FatherCoversArray.put(GlobalCoversFatherObj);


                JSONObject MedicallyAdvisedCoversFatherObj=new JSONObject();
                MedicallyAdvisedCoversFatherObj.put("Applicable",MedicallyAdvisedStatus);
                MedicallyAdvisedCoversFatherObj.put("CoverSI",strSumInsured);
                MedicallyAdvisedCoversFatherObj.put("CoverRate","0");
                MedicallyAdvisedCoversFatherObj.put("CoverPremium","0");
                MedicallyAdvisedCoversFatherObj.put("CoverGroups","Medically Advised Support Devices");
                FatherCoversArray.put(MedicallyAdvisedCoversFatherObj);

                JSONObject EmergencyCoversFatherObj=new JSONObject();
                EmergencyCoversFatherObj.put("Applicable",EmergencyAssistanceStatus);
                EmergencyCoversFatherObj.put("CoverSI",strSumInsured);
                EmergencyCoversFatherObj.put("CoverRate","0");
                EmergencyCoversFatherObj.put("CoverPremium","0");
                EmergencyCoversFatherObj.put("CoverGroups","Emergency Assistance Service");
                FatherCoversArray.put(EmergencyCoversFatherObj);

                JSONObject HomeCareTreatmentCoversFatherObj=new JSONObject();
                HomeCareTreatmentCoversFatherObj.put("Applicable",HomeCareStatus);
                HomeCareTreatmentCoversFatherObj.put("CoverSI",strSumInsured);
                HomeCareTreatmentCoversFatherObj.put("CoverRate","0");
                HomeCareTreatmentCoversFatherObj.put("CoverPremium","0");
                HomeCareTreatmentCoversFatherObj.put("CoverGroups","Home Care Treatment");
                FatherCoversArray.put(HomeCareTreatmentCoversFatherObj);

                JSONObject WellnessBenefitCoversFatherObj=new JSONObject();
                WellnessBenefitCoversFatherObj.put("Applicable",WellnessBenefitStatus);
                WellnessBenefitCoversFatherObj.put("CoverSI",strSumInsured);
                WellnessBenefitCoversFatherObj.put("CoverRate","0");
                WellnessBenefitCoversFatherObj.put("CoverPremium","0");
                WellnessBenefitCoversFatherObj.put("CoverGroups","Wellness Benefit");
                FatherCoversArray.put(WellnessBenefitCoversFatherObj);

                JSONObject DiseaseManagementCoversFatherObj=new JSONObject();
                DiseaseManagementCoversFatherObj.put("Applicable",DiseaseManagementStatus);
                DiseaseManagementCoversFatherObj.put("CoverSI",strSumInsured);
                DiseaseManagementCoversFatherObj.put("CoverRate","0");
                DiseaseManagementCoversFatherObj.put("CoverPremium","0");
                DiseaseManagementCoversFatherObj.put("CoverGroups","Disease Management Program");
                FatherCoversArray.put(DiseaseManagementCoversFatherObj);
                CoverDetailsFatherObj.put("Covers",FatherCoversArray);
                FatherObj.put("CoverDetails",CoverDetailsFatherObj);

                //motherLaw
                JSONObject MotherLawObj=new JSONObject();
                MotherLawObj.put("InsuredType","Parent");
                MotherLawObj.put("FirstName",strMotherLawEditText);
                MotherLawObj.put("LastName","");
                MotherLawObj.put("DOB",strMotherLawAgeEditText);
                MotherLawObj.put("Gender","F");
                MotherLawObj.put("Relationship","Mother-In-Law");
                MotherLawObj.put("Occupation",strOccupationEditMotherLaw);
                MotherLawObj.put("NomineeName",strNomineeName);
                MotherLawObj.put("NomineeRelationship",strNomineeRelationEdit);

                JSONObject HealthIndicatorsMotherLawObj=new JSONObject();
                HealthIndicatorsMotherLawObj.put("PED","N");
                HealthIndicatorsMotherLawObj.put("PEDDeclared","N");
                HealthIndicatorsMotherLawObj.put("BloodSugarLevel",strBloodSugar);
                HealthIndicatorsMotherLawObj.put("BloodPressureSystolic",strBloodPressure);
                HealthIndicatorsMotherLawObj.put("BloodPressureDiastolic",strBloodPressureDiastolic);
                HealthIndicatorsMotherLawObj.put("CholesterolLevel",strcholesterol);
                HealthIndicatorsMotherLawObj.put("BodyMassIndex",strBMIMotherLawEdit);
                HealthIndicatorsMotherLawObj.put("TobaccoAndAlcohol","N");
                HealthIndicatorsMotherLawObj.put("CoMorbidity","N");
                MotherLawObj.put("HealthIndicators",HealthIndicatorsMotherLawObj);

                JSONObject CoverDetailsMotherLawObj=new JSONObject();
                JSONArray MotherLawCoversArray = new JSONArray();
                JSONObject BasicInsuranceCoversMotherLawObj=new JSONObject();
                BasicInsuranceCoversMotherLawObj.put("Applicable",BasicStatus);
                BasicInsuranceCoversMotherLawObj.put("CoverSI",strSumInsured);
                BasicInsuranceCoversMotherLawObj.put("CoverRate","0");
                BasicInsuranceCoversMotherLawObj.put("CoverPremium","0");
                BasicInsuranceCoversMotherLawObj.put("CoverGroups","Basic Insurance Cover");
                MotherLawCoversArray.put(BasicInsuranceCoversMotherLawObj);

                JSONObject PersonalAccidentCoversMotherLawObj=new JSONObject();
                PersonalAccidentCoversMotherLawObj.put("Applicable",PersonalStatus);
                PersonalAccidentCoversMotherLawObj.put("CoverSI",strSumInsured);
                PersonalAccidentCoversMotherLawObj.put("CoverRate","0");
                PersonalAccidentCoversMotherLawObj.put("CoverPremium","0");
                PersonalAccidentCoversMotherLawObj.put("CoverGroups","Personal Accident Cover");
                MotherLawCoversArray.put(PersonalAccidentCoversMotherLawObj);

                JSONObject CriticalIllnessCoversMotherLawObj=new JSONObject();
                CriticalIllnessCoversMotherLawObj.put("Applicable",CriticalStatus);
                CriticalIllnessCoversMotherLawObj.put("CoverSI",strSumInsured);
                CriticalIllnessCoversMotherLawObj.put("CoverRate","0");
                CriticalIllnessCoversMotherLawObj.put("CoverPremium","0");
                CriticalIllnessCoversMotherLawObj.put("CoverGroups","Critical Illness Cover");
                MotherLawCoversArray.put(CriticalIllnessCoversMotherLawObj);


                JSONObject DailyHospitalCoversMotherLawObj=new JSONObject();
                DailyHospitalCoversMotherLawObj.put("Applicable",DailyHospitalSatus);
                DailyHospitalCoversMotherLawObj.put("CoverSI",strSumInsured);
                DailyHospitalCoversMotherLawObj.put("CoverRate","0");
                DailyHospitalCoversMotherLawObj.put("CoverPremium","0");
                DailyHospitalCoversMotherLawObj.put("CoverGroups","Daily Hospital Cash Cover");
                MotherLawCoversArray.put(DailyHospitalCoversMotherLawObj);

                JSONObject ModernCoversMotherLawObj=new JSONObject();
                ModernCoversMotherLawObj.put("Applicable",ModernTreatmentsStatus);
                ModernCoversMotherLawObj.put("CoverSI",strSumInsured);
                ModernCoversMotherLawObj.put("CoverRate","0");
                ModernCoversMotherLawObj.put("CoverPremium","0");
                ModernCoversMotherLawObj.put("CoverGroups","Modern Treatments");
                MotherLawCoversArray.put(ModernCoversMotherLawObj);
                JSONObject ExtensionPreHospitalizationCoversMotherLawObj=new JSONObject();
                ExtensionPreHospitalizationCoversMotherLawObj.put("Applicable",ExtensionPreHospitalization);
                ExtensionPreHospitalizationCoversMotherLawObj.put("CoverSI",strSumInsured);
                ExtensionPreHospitalizationCoversMotherLawObj.put("CoverRate","0");
                ExtensionPreHospitalizationCoversMotherLawObj.put("CoverPremium","0");
                ExtensionPreHospitalizationCoversMotherLawObj.put("CoverGroups","Extension under Pre-Hospitalization");
                MotherLawCoversArray.put(ExtensionPreHospitalizationCoversMotherLawObj);

                JSONObject ExtensionPostHospitalizationCoversMotherLawObj=new JSONObject();
                ExtensionPostHospitalizationCoversMotherLawObj.put("Applicable",ExtensionPr0Hospitalization);
                ExtensionPostHospitalizationCoversMotherLawObj.put("CoverSI",strSumInsured);
                ExtensionPostHospitalizationCoversMotherLawObj.put("CoverRate","0");
                ExtensionPostHospitalizationCoversMotherLawObj.put("CoverPremium","0");
                ExtensionPostHospitalizationCoversMotherLawObj.put("CoverGroups","Extension under Post-Hospitalization");
                MotherLawCoversArray.put(ExtensionPostHospitalizationCoversMotherLawObj);


                JSONObject MaternityAndChildcareCoversMotherLawObj=new JSONObject();
                MaternityAndChildcareCoversMotherLawObj.put("Applicable","False");
                MaternityAndChildcareCoversMotherLawObj.put("CoverSI",strSumInsured);
                MaternityAndChildcareCoversMotherLawObj.put("CoverRate","0");
                MaternityAndChildcareCoversMotherLawObj.put("CoverPremium","0");
                MaternityAndChildcareCoversMotherLawObj.put("CoverGroups","Maternity and Childcare Benefit Waiting Period Modification");
                MotherLawCoversArray.put(MaternityAndChildcareCoversMotherLawObj);

                JSONObject CoverageForNonMedicalCoversMotherLawObj=new JSONObject();
                CoverageForNonMedicalCoversMotherLawObj.put("Applicable",CoverageNonMedical);
                CoverageForNonMedicalCoversMotherLawObj.put("CoverSI",strSumInsured);
                CoverageForNonMedicalCoversMotherLawObj.put("CoverRate","0");
                CoverageForNonMedicalCoversMotherLawObj.put("CoverPremium","0");
                CoverageForNonMedicalCoversMotherLawObj.put("CoverGroups","Coverage for Non-Medical Items");
                MotherLawCoversArray.put(CoverageForNonMedicalCoversMotherLawObj);

                JSONObject ConditionWaiverCoversMotherLawObj=new JSONObject();
                ConditionWaiverCoversMotherLawObj.put("Applicable",ConditionWaiverStatus);
                ConditionWaiverCoversMotherLawObj.put("CoverSI",strSumInsured);
                ConditionWaiverCoversMotherLawObj.put("CoverRate","0");
                ConditionWaiverCoversMotherLawObj.put("CoverPremium","0");
                ConditionWaiverCoversMotherLawObj.put("CoverGroups","Condition waiver under Restore Benefit");
                MotherLawCoversArray.put(ConditionWaiverCoversMotherLawObj);

                JSONObject PreExistingDiseaseCoversMotherLawObj=new JSONObject();
                PreExistingDiseaseCoversMotherLawObj.put("Applicable",PreExistingDiseaseStatus);
                PreExistingDiseaseCoversMotherLawObj.put("CoverSI",strSumInsured);
                PreExistingDiseaseCoversMotherLawObj.put("CoverRate","0");
                PreExistingDiseaseCoversMotherLawObj.put("CoverPremium","0");
                PreExistingDiseaseCoversMotherLawObj.put("CoverGroups","Pre-Existing Disease waiting period");
                MotherLawCoversArray.put(PreExistingDiseaseCoversMotherLawObj);

                JSONObject OutpatientDentalWaitingCoversMotherLawObj=new JSONObject();
                OutpatientDentalWaitingCoversMotherLawObj.put("Applicable",OutpatientDentalStatus);
                OutpatientDentalWaitingCoversMotherLawObj.put("CoverSI",strSumInsured);
                OutpatientDentalWaitingCoversMotherLawObj.put("CoverRate","0");
                OutpatientDentalWaitingCoversMotherLawObj.put("CoverPremium","0");
                OutpatientDentalWaitingCoversMotherLawObj.put("CoverGroups","Outpatient Dental Waiting Period Modification");
                MotherLawCoversArray.put(OutpatientDentalWaitingCoversMotherLawObj);

                JSONObject EmergencyTravellingAllowanceCoversMotherLawObj=new JSONObject();
                EmergencyTravellingAllowanceCoversMotherLawObj.put("Applicable",EmergencyTravellingStatus);
                EmergencyTravellingAllowanceCoversMotherLawObj.put("CoverSI",strSumInsured);
                EmergencyTravellingAllowanceCoversMotherLawObj.put("CoverRate","0");
                EmergencyTravellingAllowanceCoversMotherLawObj.put("CoverPremium","0");
                EmergencyTravellingAllowanceCoversMotherLawObj.put("CoverGroups","Emergency Travelling Allowance");
                MotherLawCoversArray.put(EmergencyTravellingAllowanceCoversMotherLawObj);

                JSONObject SecondOpinionCoversMotherLawObj=new JSONObject();
                SecondOpinionCoversMotherLawObj.put("Applicable",SecondOpinionStatus);
                SecondOpinionCoversMotherLawObj.put("CoverSI",strSumInsured);
                SecondOpinionCoversMotherLawObj.put("CoverRate","0");
                SecondOpinionCoversMotherLawObj.put("CoverPremium","0");
                SecondOpinionCoversMotherLawObj.put("CoverGroups","Second Opinion");
                MotherLawCoversArray.put(SecondOpinionCoversMotherLawObj);

                JSONObject RestCureCoversMotherLawObj=new JSONObject();
                RestCureCoversMotherLawObj.put("Applicable",RestCureStatus);
                RestCureCoversMotherLawObj.put("CoverSI",strSumInsured);
                RestCureCoversMotherLawObj.put("CoverRate","0");
                RestCureCoversMotherLawObj.put("CoverPremium","0");
                RestCureCoversMotherLawObj.put("CoverGroups","Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
                MotherLawCoversArray.put(RestCureCoversMotherLawObj);

                JSONObject ObesityWeightCoversMotherLawObj=new JSONObject();
                ObesityWeightCoversMotherLawObj.put("Applicable",ObesityWeightStatus);
                ObesityWeightCoversMotherLawObj.put("CoverSI",strSumInsured);
                ObesityWeightCoversMotherLawObj.put("CoverRate","0");
                ObesityWeightCoversMotherLawObj.put("CoverPremium","0");
                ObesityWeightCoversMotherLawObj.put("CoverGroups","Obesity/ Weight Control Expenses Extension");
                MotherLawCoversArray.put(ObesityWeightCoversMotherLawObj);

                JSONObject SterilityInfertilityCoversMotherLawObj=new JSONObject();
                SterilityInfertilityCoversMotherLawObj.put("Applicable","False");
                SterilityInfertilityCoversMotherLawObj.put("CoverSI",strSumInsured);
                SterilityInfertilityCoversMotherLawObj.put("CoverRate","0");
                SterilityInfertilityCoversMotherLawObj.put("CoverPremium","0");
                SterilityInfertilityCoversMotherLawObj.put("CoverGroups","Sterility and Infertility Treatment Expenses Extension");
                MotherLawCoversArray.put(SterilityInfertilityCoversMotherLawObj);

                JSONObject EnhancedOrganDonorCoversMotherLawObj=new JSONObject();
                EnhancedOrganDonorCoversMotherLawObj.put("Applicable",EnhancedOrganStatus);
                EnhancedOrganDonorCoversMotherLawObj.put("CoverSI",strSumInsured);
                EnhancedOrganDonorCoversMotherLawObj.put("CoverRate","0");
                EnhancedOrganDonorCoversMotherLawObj.put("CoverPremium","0");
                EnhancedOrganDonorCoversMotherLawObj.put("CoverGroups","Enhanced Organ Donor Expenses");
                MotherLawCoversArray.put(EnhancedOrganDonorCoversMotherLawObj);

                JSONObject PremiumWaiverCoversMotherLawObj=new JSONObject();
                PremiumWaiverCoversMotherLawObj.put("Applicable",PremiumWaiverStatus);
                PremiumWaiverCoversMotherLawObj.put("CoverSI",strSumInsured);
                PremiumWaiverCoversMotherLawObj.put("CoverRate","0");
                PremiumWaiverCoversMotherLawObj.put("CoverPremium","0");
                PremiumWaiverCoversMotherLawObj.put("CoverGroups","Premium Waiver");
                MotherLawCoversArray.put(PremiumWaiverCoversMotherLawObj);

                JSONObject GlobalCoversMotherLawObj=new JSONObject();
                GlobalCoversMotherLawObj.put("Applicable",GlobalCoverStatus);
                GlobalCoversMotherLawObj.put("CoverSI",strSumInsured);
                GlobalCoversMotherLawObj.put("CoverRate","0");
                GlobalCoversMotherLawObj.put("CoverPremium","0");
                GlobalCoversMotherLawObj.put("CoverGroups","Global Cover");
                MotherLawCoversArray.put(GlobalCoversMotherLawObj);


                JSONObject MedicallyAdvisedCoversMotherLawObj=new JSONObject();
                MedicallyAdvisedCoversMotherLawObj.put("Applicable",MedicallyAdvisedStatus);
                MedicallyAdvisedCoversMotherLawObj.put("CoverSI",strSumInsured);
                MedicallyAdvisedCoversMotherLawObj.put("CoverRate","0");
                MedicallyAdvisedCoversMotherLawObj.put("CoverPremium","0");
                MedicallyAdvisedCoversMotherLawObj.put("CoverGroups","Medically Advised Support Devices");
                MotherLawCoversArray.put(MedicallyAdvisedCoversMotherLawObj);

                JSONObject EmergencyCoversMotherLawObj=new JSONObject();
                EmergencyCoversMotherLawObj.put("Applicable",EmergencyAssistanceStatus);
                EmergencyCoversMotherLawObj.put("CoverSI",strSumInsured);
                EmergencyCoversMotherLawObj.put("CoverRate","0");
                EmergencyCoversMotherLawObj.put("CoverPremium","0");
                EmergencyCoversMotherLawObj.put("CoverGroups","Emergency Assistance Service");
                MotherLawCoversArray.put(EmergencyCoversMotherLawObj);

                JSONObject HomeCareTreatmentCoversMotherLawObj=new JSONObject();
                HomeCareTreatmentCoversMotherLawObj.put("Applicable",HomeCareStatus);
                HomeCareTreatmentCoversMotherLawObj.put("CoverSI",strSumInsured);
                HomeCareTreatmentCoversMotherLawObj.put("CoverRate","0");
                HomeCareTreatmentCoversMotherLawObj.put("CoverPremium","0");
                HomeCareTreatmentCoversMotherLawObj.put("CoverGroups","Home Care Treatment");
                MotherLawCoversArray.put(HomeCareTreatmentCoversMotherLawObj);

                JSONObject WellnessBenefitCoversMotherLawObj=new JSONObject();
                WellnessBenefitCoversMotherLawObj.put("Applicable",WellnessBenefitStatus);
                WellnessBenefitCoversMotherLawObj.put("CoverSI",strSumInsured);
                WellnessBenefitCoversMotherLawObj.put("CoverRate","0");
                WellnessBenefitCoversMotherLawObj.put("CoverPremium","0");
                WellnessBenefitCoversMotherLawObj.put("CoverGroups","Wellness Benefit");
                MotherLawCoversArray.put(WellnessBenefitCoversMotherLawObj);

                JSONObject DiseaseManagementCoversMotherLawObj=new JSONObject();
                DiseaseManagementCoversMotherLawObj.put("Applicable",DiseaseManagementStatus);
                DiseaseManagementCoversMotherLawObj.put("CoverSI",strSumInsured);
                DiseaseManagementCoversMotherLawObj.put("CoverRate","0");
                DiseaseManagementCoversMotherLawObj.put("CoverPremium","0");
                DiseaseManagementCoversMotherLawObj.put("CoverGroups","Disease Management Program");
                MotherLawCoversArray.put(DiseaseManagementCoversMotherLawObj);
                CoverDetailsMotherLawObj.put("Covers",MotherLawCoversArray);
                MotherLawObj.put("CoverDetails",CoverDetailsMotherLawObj);

                //FatherLaw
                JSONObject FatherLawObj=new JSONObject();
                FatherLawObj.put("InsuredType","Parent");
                FatherLawObj.put("FirstName",strFatherLawNameEdit);
                FatherLawObj.put("LastName","");
                FatherLawObj.put("DOB",strFatherLawAgeEditText);
                FatherLawObj.put("Gender","M");
                FatherLawObj.put("Relationship","Father-In-Law");
                FatherLawObj.put("Occupation",strOccupationFatherLawEdit);
                FatherLawObj.put("NomineeName",strNomineeName);
                FatherLawObj.put("NomineeRelationship",strNomineeRelationEdit);

                JSONObject HealthIndicatorsFatherLawObj=new JSONObject();
                HealthIndicatorsFatherLawObj.put("PED","N");
                HealthIndicatorsFatherLawObj.put("PEDDeclared","N");
                HealthIndicatorsFatherLawObj.put("BloodSugarLevel",strBloodSugar);
                HealthIndicatorsFatherLawObj.put("BloodPressureSystolic",strBloodPressure);
                HealthIndicatorsFatherLawObj.put("BloodPressureDiastolic",strBloodPressureDiastolic);
                HealthIndicatorsFatherLawObj.put("CholesterolLevel",strcholesterol);
                HealthIndicatorsFatherLawObj.put("BodyMassIndex",strFatherLawBMIEdit);
                HealthIndicatorsFatherLawObj.put("TobaccoAndAlcohol","N");
                HealthIndicatorsFatherLawObj.put("CoMorbidity","N");
                FatherLawObj.put("HealthIndicators",HealthIndicatorsFatherLawObj);

                JSONObject CoverDetailsFatherLawObj=new JSONObject();
                JSONArray FatherLawCoversArray = new JSONArray();
                JSONObject BasicInsuranceCoversFatherLawObj=new JSONObject();
                BasicInsuranceCoversFatherLawObj.put("Applicable",BasicStatus);
                BasicInsuranceCoversFatherLawObj.put("CoverSI",strSumInsured);
                BasicInsuranceCoversFatherLawObj.put("CoverRate","0");
                BasicInsuranceCoversFatherLawObj.put("CoverPremium","0");
                BasicInsuranceCoversFatherLawObj.put("CoverGroups","Basic Insurance Cover");
                FatherLawCoversArray.put(BasicInsuranceCoversFatherLawObj);

                JSONObject PersonalAccidentCoversFatherLawObj=new JSONObject();
                PersonalAccidentCoversFatherLawObj.put("Applicable",PersonalStatus);
                PersonalAccidentCoversFatherLawObj.put("CoverSI",strSumInsured);
                PersonalAccidentCoversFatherLawObj.put("CoverRate","0");
                PersonalAccidentCoversFatherLawObj.put("CoverPremium","0");
                PersonalAccidentCoversFatherLawObj.put("CoverGroups","Personal Accident Cover");
                FatherLawCoversArray.put(PersonalAccidentCoversFatherLawObj);

                JSONObject CriticalIllnessCoversFatherLawObj=new JSONObject();
                CriticalIllnessCoversFatherLawObj.put("Applicable",CriticalStatus);
                CriticalIllnessCoversFatherLawObj.put("CoverSI",strSumInsured);
                CriticalIllnessCoversFatherLawObj.put("CoverRate","0");
                CriticalIllnessCoversFatherLawObj.put("CoverPremium","0");
                CriticalIllnessCoversFatherLawObj.put("CoverGroups","Critical Illness Cover");
                FatherLawCoversArray.put(CriticalIllnessCoversFatherLawObj);


                JSONObject DailyHospitalCoversFatherLawObj=new JSONObject();
                DailyHospitalCoversFatherLawObj.put("Applicable",DailyHospitalSatus);
                DailyHospitalCoversFatherLawObj.put("CoverSI",strSumInsured);
                DailyHospitalCoversFatherLawObj.put("CoverRate","0");
                DailyHospitalCoversFatherLawObj.put("CoverPremium","0");
                DailyHospitalCoversFatherLawObj.put("CoverGroups","Daily Hospital Cash Cover");
                FatherLawCoversArray.put(DailyHospitalCoversFatherLawObj);

                JSONObject ModernCoversFatherLawObj=new JSONObject();
                ModernCoversFatherLawObj.put("Applicable",ModernTreatmentsStatus);
                ModernCoversFatherLawObj.put("CoverSI",strSumInsured);
                ModernCoversFatherLawObj.put("CoverRate","0");
                ModernCoversFatherLawObj.put("CoverPremium","0");
                ModernCoversFatherLawObj.put("CoverGroups","Modern Treatments");
                FatherLawCoversArray.put(ModernCoversFatherLawObj);
                JSONObject ExtensionPreHospitalizationCoversFatherLawObj=new JSONObject();
                ExtensionPreHospitalizationCoversFatherLawObj.put("Applicable",ExtensionPreHospitalization);
                ExtensionPreHospitalizationCoversFatherLawObj.put("CoverSI",strSumInsured);
                ExtensionPreHospitalizationCoversFatherLawObj.put("CoverRate","0");
                ExtensionPreHospitalizationCoversFatherLawObj.put("CoverPremium","0");
                ExtensionPreHospitalizationCoversFatherLawObj.put("CoverGroups","Extension under Pre-Hospitalization");
                FatherLawCoversArray.put(ExtensionPreHospitalizationCoversFatherLawObj);

                JSONObject ExtensionPostHospitalizationCoversFatherLawObj=new JSONObject();
                ExtensionPostHospitalizationCoversFatherLawObj.put("Applicable",ExtensionPr0Hospitalization);
                ExtensionPostHospitalizationCoversFatherLawObj.put("CoverSI",strSumInsured);
                ExtensionPostHospitalizationCoversFatherLawObj.put("CoverRate","0");
                ExtensionPostHospitalizationCoversFatherLawObj.put("CoverPremium","0");
                ExtensionPostHospitalizationCoversFatherLawObj.put("CoverGroups","Extension under Post-Hospitalization");
                FatherLawCoversArray.put(ExtensionPostHospitalizationCoversFatherLawObj);


                JSONObject MaternityAndChildcareCoversFatherLawObj=new JSONObject();
                MaternityAndChildcareCoversFatherLawObj.put("Applicable","False");
                MaternityAndChildcareCoversFatherLawObj.put("CoverSI",strSumInsured);
                MaternityAndChildcareCoversFatherLawObj.put("CoverRate","0");
                MaternityAndChildcareCoversFatherLawObj.put("CoverPremium","0");
                MaternityAndChildcareCoversFatherLawObj.put("CoverGroups","Maternity and Childcare Benefit Waiting Period Modification");
                FatherLawCoversArray.put(MaternityAndChildcareCoversFatherLawObj);

                JSONObject CoverageForNonMedicalCoversFatherLawObj=new JSONObject();
                CoverageForNonMedicalCoversFatherLawObj.put("Applicable",CoverageNonMedical);
                CoverageForNonMedicalCoversFatherLawObj.put("CoverSI",strSumInsured);
                CoverageForNonMedicalCoversFatherLawObj.put("CoverRate","0");
                CoverageForNonMedicalCoversFatherLawObj.put("CoverPremium","0");
                CoverageForNonMedicalCoversFatherLawObj.put("CoverGroups","Coverage for Non-Medical Items");
                FatherLawCoversArray.put(CoverageForNonMedicalCoversFatherLawObj);

                JSONObject ConditionWaiverCoversFatherLawObj=new JSONObject();
                ConditionWaiverCoversFatherLawObj.put("Applicable",ConditionWaiverStatus);
                ConditionWaiverCoversFatherLawObj.put("CoverSI",strSumInsured);
                ConditionWaiverCoversFatherLawObj.put("CoverRate","0");
                ConditionWaiverCoversFatherLawObj.put("CoverPremium","0");
                ConditionWaiverCoversFatherLawObj.put("CoverGroups","Condition waiver under Restore Benefit");
                FatherLawCoversArray.put(ConditionWaiverCoversFatherLawObj);

                JSONObject PreExistingDiseaseCoversFatherLawObj=new JSONObject();
                PreExistingDiseaseCoversFatherLawObj.put("Applicable",PreExistingDiseaseStatus);
                PreExistingDiseaseCoversFatherLawObj.put("CoverSI",strSumInsured);
                PreExistingDiseaseCoversFatherLawObj.put("CoverRate","0");
                PreExistingDiseaseCoversFatherLawObj.put("CoverPremium","0");
                PreExistingDiseaseCoversFatherLawObj.put("CoverGroups","Pre-Existing Disease waiting period");
                FatherLawCoversArray.put(PreExistingDiseaseCoversFatherLawObj);

                JSONObject OutpatientDentalWaitingCoversFatherLawObj=new JSONObject();
                OutpatientDentalWaitingCoversFatherLawObj.put("Applicable",OutpatientDentalStatus);
                OutpatientDentalWaitingCoversFatherLawObj.put("CoverSI",strSumInsured);
                OutpatientDentalWaitingCoversFatherLawObj.put("CoverRate","0");
                OutpatientDentalWaitingCoversFatherLawObj.put("CoverPremium","0");
                OutpatientDentalWaitingCoversFatherLawObj.put("CoverGroups","Outpatient Dental Waiting Period Modification");
                FatherLawCoversArray.put(OutpatientDentalWaitingCoversFatherLawObj);

                JSONObject EmergencyTravellingAllowanceCoversFatherLawObj=new JSONObject();
                EmergencyTravellingAllowanceCoversFatherLawObj.put("Applicable",EmergencyTravellingStatus);
                EmergencyTravellingAllowanceCoversFatherLawObj.put("CoverSI",strSumInsured);
                EmergencyTravellingAllowanceCoversFatherLawObj.put("CoverRate","0");
                EmergencyTravellingAllowanceCoversFatherLawObj.put("CoverPremium","0");
                EmergencyTravellingAllowanceCoversFatherLawObj.put("CoverGroups","Emergency Travelling Allowance");
                FatherLawCoversArray.put(EmergencyTravellingAllowanceCoversFatherLawObj);

                JSONObject SecondOpinionCoversFatherLawObj=new JSONObject();
                SecondOpinionCoversFatherLawObj.put("Applicable",SecondOpinionStatus);
                SecondOpinionCoversFatherLawObj.put("CoverSI",strSumInsured);
                SecondOpinionCoversFatherLawObj.put("CoverRate","0");
                SecondOpinionCoversFatherLawObj.put("CoverPremium","0");
                SecondOpinionCoversFatherLawObj.put("CoverGroups","Second Opinion");
                FatherLawCoversArray.put(SecondOpinionCoversFatherLawObj);

                JSONObject RestCureCoversFatherLawObj=new JSONObject();
                RestCureCoversFatherLawObj.put("Applicable",RestCureStatus);
                RestCureCoversFatherLawObj.put("CoverSI",strSumInsured);
                RestCureCoversFatherLawObj.put("CoverRate","0");
                RestCureCoversFatherLawObj.put("CoverPremium","0");
                RestCureCoversFatherLawObj.put("CoverGroups","Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
                FatherLawCoversArray.put(RestCureCoversFatherLawObj);

                JSONObject ObesityWeightCoversFatherLawObj=new JSONObject();
                ObesityWeightCoversFatherLawObj.put("Applicable",ObesityWeightStatus);
                ObesityWeightCoversFatherLawObj.put("CoverSI",strSumInsured);
                ObesityWeightCoversFatherLawObj.put("CoverRate","0");
                ObesityWeightCoversFatherLawObj.put("CoverPremium","0");
                ObesityWeightCoversFatherLawObj.put("CoverGroups","Obesity/ Weight Control Expenses Extension");
                FatherLawCoversArray.put(ObesityWeightCoversFatherLawObj);

                JSONObject SterilityInfertilityCoversFatherLawObj=new JSONObject();
                SterilityInfertilityCoversFatherLawObj.put("Applicable","False");
                SterilityInfertilityCoversFatherLawObj.put("CoverSI",strSumInsured);
                SterilityInfertilityCoversFatherLawObj.put("CoverRate","0");
                SterilityInfertilityCoversFatherLawObj.put("CoverPremium","0");
                SterilityInfertilityCoversFatherLawObj.put("CoverGroups","Sterility and Infertility Treatment Expenses Extension");
                FatherLawCoversArray.put(SterilityInfertilityCoversFatherLawObj);

                JSONObject EnhancedOrganDonorCoversFatherLawObj=new JSONObject();
                EnhancedOrganDonorCoversFatherLawObj.put("Applicable",EnhancedOrganStatus);
                EnhancedOrganDonorCoversFatherLawObj.put("CoverSI",strSumInsured);
                EnhancedOrganDonorCoversFatherLawObj.put("CoverRate","0");
                EnhancedOrganDonorCoversFatherLawObj.put("CoverPremium","0");
                EnhancedOrganDonorCoversFatherLawObj.put("CoverGroups","Enhanced Organ Donor Expenses");
                FatherLawCoversArray.put(EnhancedOrganDonorCoversFatherLawObj);

                JSONObject PremiumWaiverCoversFatherLawObj=new JSONObject();
                PremiumWaiverCoversFatherLawObj.put("Applicable",PremiumWaiverStatus);
                PremiumWaiverCoversFatherLawObj.put("CoverSI",strSumInsured);
                PremiumWaiverCoversFatherLawObj.put("CoverRate","0");
                PremiumWaiverCoversFatherLawObj.put("CoverPremium","0");
                PremiumWaiverCoversFatherLawObj.put("CoverGroups","Premium Waiver");
                FatherLawCoversArray.put(PremiumWaiverCoversFatherLawObj);

                JSONObject GlobalCoversFatherLawObj=new JSONObject();
                GlobalCoversFatherLawObj.put("Applicable",GlobalCoverStatus);
                GlobalCoversFatherLawObj.put("CoverSI",strSumInsured);
                GlobalCoversFatherLawObj.put("CoverRate","0");
                GlobalCoversFatherLawObj.put("CoverPremium","0");
                GlobalCoversFatherLawObj.put("CoverGroups","Global Cover");
                FatherLawCoversArray.put(GlobalCoversFatherLawObj);


                JSONObject MedicallyAdvisedCoversFatherLawObj=new JSONObject();
                MedicallyAdvisedCoversFatherLawObj.put("Applicable",MedicallyAdvisedStatus);
                MedicallyAdvisedCoversFatherLawObj.put("CoverSI",strSumInsured);
                MedicallyAdvisedCoversFatherLawObj.put("CoverRate","0");
                MedicallyAdvisedCoversFatherLawObj.put("CoverPremium","0");
                MedicallyAdvisedCoversFatherLawObj.put("CoverGroups","Medically Advised Support Devices");
                FatherLawCoversArray.put(MedicallyAdvisedCoversFatherLawObj);

                JSONObject EmergencyCoversFatherLawObj=new JSONObject();
                EmergencyCoversFatherLawObj.put("Applicable",EmergencyAssistanceStatus);
                EmergencyCoversFatherLawObj.put("CoverSI",strSumInsured);
                EmergencyCoversFatherLawObj.put("CoverRate","0");
                EmergencyCoversFatherLawObj.put("CoverPremium","0");
                EmergencyCoversFatherLawObj.put("CoverGroups","Emergency Assistance Service");
                FatherLawCoversArray.put(EmergencyCoversFatherLawObj);

                JSONObject HomeCareTreatmentCoversFatherLawObj=new JSONObject();
                HomeCareTreatmentCoversFatherLawObj.put("Applicable",HomeCareStatus);
                HomeCareTreatmentCoversFatherLawObj.put("CoverSI",strSumInsured);
                HomeCareTreatmentCoversFatherLawObj.put("CoverRate","0");
                HomeCareTreatmentCoversFatherLawObj.put("CoverPremium","0");
                HomeCareTreatmentCoversFatherLawObj.put("CoverGroups","Home Care Treatment");
                FatherLawCoversArray.put(HomeCareTreatmentCoversFatherLawObj);

                JSONObject WellnessBenefitCoversFatherLawObj=new JSONObject();
                WellnessBenefitCoversFatherLawObj.put("Applicable",WellnessBenefitStatus);
                WellnessBenefitCoversFatherLawObj.put("CoverSI",strSumInsured);
                WellnessBenefitCoversFatherLawObj.put("CoverRate","0");
                WellnessBenefitCoversFatherLawObj.put("CoverPremium","0");
                WellnessBenefitCoversFatherLawObj.put("CoverGroups","Wellness Benefit");
                FatherLawCoversArray.put(WellnessBenefitCoversFatherLawObj);

                JSONObject DiseaseManagementCoversFatherLawObj=new JSONObject();
                DiseaseManagementCoversFatherLawObj.put("Applicable",DiseaseManagementStatus);
                DiseaseManagementCoversFatherLawObj.put("CoverSI",strSumInsured);
                DiseaseManagementCoversFatherLawObj.put("CoverRate","0");
                DiseaseManagementCoversFatherLawObj.put("CoverPremium","0");
                DiseaseManagementCoversFatherLawObj.put("CoverGroups","Disease Management Program");
                FatherLawCoversArray.put(DiseaseManagementCoversFatherLawObj);
                CoverDetailsFatherLawObj.put("Covers",FatherLawCoversArray);
                FatherLawObj.put("CoverDetails",CoverDetailsFatherLawObj);

            if (str_policyType_spinner.equals("Individual")){
                if (strCheckBoxSelf.equals("Checked")||strCheckBoxSpouse.equals("Checked")||strCheckBoxMother.equals("Checked")||strCheckBoxFather.equals("Checked")||strCheckBoxMotherLaw.equals("Checked")||strCheckBoxFatherLaw.equals("Checked")){
                    InsuredDetailsGroupArray.put(InsuredDetailsObj);
                }
            }
            else{
                if (strCheckBoxSelf.equals("Checked")){
                    InsuredDetailsGroupArray.put(InsuredDetailsObj);
                }
                if (strCheckBoxSpouse.equals("Checked")){
                    InsuredDetailsGroupArray.put(SecondAdultObj);
                }
                if (mCounter==1){
                    InsuredDetailsGroupArray.put(FirstChildObj);
                }
                if (mCounter==2){
                    InsuredDetailsGroupArray.put(FirstChildObj);
                    InsuredDetailsGroupArray.put(SecondChildObj);
                }
                if (mCounter==3){
                    InsuredDetailsGroupArray.put(FirstChildObj);
                    InsuredDetailsGroupArray.put(SecondChildObj);
                    InsuredDetailsGroupArray.put(ThirdChildObj);
                }
                if (mCounter==4){
                    InsuredDetailsGroupArray.put(FirstChildObj);
                    InsuredDetailsGroupArray.put(SecondChildObj);
                    InsuredDetailsGroupArray.put(ThirdChildObj);
                    InsuredDetailsGroupArray.put(FourthChildObj);
                }
                if (strCheckBoxMother.equals("Checked")){
                    InsuredDetailsGroupArray.put(MotherObj);
                }
                if (strCheckBoxFather.equals("Checked")){
                    InsuredDetailsGroupArray.put(FatherObj);
                }
                if (strCheckBoxMotherLaw.equals("Checked")){
                    InsuredDetailsGroupArray.put(MotherLawObj);
                }
                if (strCheckBoxFatherLaw.equals("Checked")){
                    InsuredDetailsGroupArray.put(FatherLawObj);
                }

            }



           InsuredDetailsObject.put("InsuredDetailsGroup",InsuredDetailsGroupArray);
           RisksDataObject.put("InsuredDetails",InsuredDetailsObject);

            //otherLoading
            JSONObject OtherLoadingsObject = new JSONObject();
            JSONObject OtherLoadingGroupObject = new JSONObject();
            JSONObject OtherLoadingGroupDataObject = new JSONObject();
            OtherLoadingGroupDataObject.put("LoadingAmount","0");
            OtherLoadingGroupDataObject.put("LoadingRate","0");
            OtherLoadingGroupDataObject.put("SumInsured","0");
            OtherLoadingGroupDataObject.put("Rate","0");
            OtherLoadingGroupDataObject.put("Premium","0");
            OtherLoadingGroupDataObject.put("Applicable","False");
            OtherLoadingGroupDataObject.put("Description","NULL");
            OtherLoadingGroupObject.put("OtherLoadingGroupData",OtherLoadingGroupDataObject);
            OtherLoadingsObject.put("OtherLoadingGroup",OtherLoadingGroupObject);

            RisksDataObject.put("OtherLoadings",OtherLoadingsObject);
//            RiskObject.put("RisksData",RisksDataObject);
//            RisksObject.put("Risks",RiskObject);
            //OtherDiscounts
            JSONObject OtherDiscountsObject = new JSONObject();
            JSONArray OtherDiscountGroupArray = new JSONArray();
            JSONObject TreatmentObject = new JSONObject();
            TreatmentObject.put("DiscountAmount","0");
            TreatmentObject.put("DiscountRate","0");
            TreatmentObject.put("SumInsured",strSumInsured);
            TreatmentObject.put("Rate","0");
            TreatmentObject.put("Premium","0");
            TreatmentObject.put("Applicable",TreatmentStatus);
            TreatmentObject.put("Description","Treatment only in tiered network");
            OtherDiscountGroupArray.put(TreatmentObject);

            JSONObject CoPaymentObject = new JSONObject();
            CoPaymentObject.put("DiscountAmount","0");
            CoPaymentObject.put("DiscountRate","0");
            CoPaymentObject.put("SumInsured",strSumInsured);
            CoPaymentObject.put("Rate","0");
            CoPaymentObject.put("Premium","0");
            CoPaymentObject.put("Applicable",CoPaymentStatus);
            CoPaymentObject.put("Description","Co-payment");
            OtherDiscountGroupArray.put(CoPaymentObject);


            JSONObject LongObject = new JSONObject();
            LongObject.put("DiscountAmount","0");
            LongObject.put("DiscountRate","0");
            LongObject.put("SumInsured",strSumInsured);
            LongObject.put("Rate","0");
            LongObject.put("Premium","0");
            LongObject.put("Applicable",LongTermDiscountStatus);
            LongObject.put("Description","Long term discount");
            OtherDiscountGroupArray.put(LongObject);

            JSONObject FamilyDiscountObject = new JSONObject();
            FamilyDiscountObject.put("DiscountAmount","0");
            FamilyDiscountObject.put("DiscountRate","0");
            FamilyDiscountObject.put("SumInsured",strSumInsured);
            FamilyDiscountObject.put("Rate","0");
            FamilyDiscountObject.put("Premium","0");
            FamilyDiscountObject.put("Applicable","False");
            FamilyDiscountObject.put("Description","Family Discount");
            OtherDiscountGroupArray.put(FamilyDiscountObject);

            JSONObject SubCategoryObject = new JSONObject();
            SubCategoryObject.put("DiscountAmount","0");
            SubCategoryObject.put("DiscountRate","0");
            SubCategoryObject.put("SumInsured",strSumInsured);
            SubCategoryObject.put("Rate","0");
            SubCategoryObject.put("Premium","0");
            SubCategoryObject.put("Applicable",SubCategoryDiscountStatus);
            SubCategoryObject.put("Description","Sub Category Discount");
            OtherDiscountGroupArray.put(SubCategoryObject);


            JSONObject DirectPolicyObject = new JSONObject();
            DirectPolicyObject.put("DiscountAmount","0");
            DirectPolicyObject.put("DiscountRate","0");
            DirectPolicyObject.put("SumInsured",strSumInsured);
            DirectPolicyObject.put("Rate","0");
            DirectPolicyObject.put("Premium","0");
            DirectPolicyObject.put("Applicable","True");
            DirectPolicyObject.put("Description","Direct Policy Discount");
            OtherDiscountGroupArray.put(DirectPolicyObject);

            JSONObject LoyaltyDiscountObject = new JSONObject();
            LoyaltyDiscountObject.put("DiscountAmount","0");
            LoyaltyDiscountObject.put("DiscountRate","0");
            LoyaltyDiscountObject.put("SumInsured",strSumInsured);
            LoyaltyDiscountObject.put("Rate","0");
            LoyaltyDiscountObject.put("Premium","0");
            LoyaltyDiscountObject.put("Applicable",LoyaltyDiscountStatus);
            LoyaltyDiscountObject.put("Description","Loyalty Discount");
            OtherDiscountGroupArray.put(LoyaltyDiscountObject);

            JSONObject EmployeeDiscountObject = new JSONObject();
            EmployeeDiscountObject.put("DiscountAmount","0");
            EmployeeDiscountObject.put("DiscountRate","0");
            EmployeeDiscountObject.put("SumInsured",strSumInsured);
            EmployeeDiscountObject.put("Rate","0");
            EmployeeDiscountObject.put("Premium","0");
            EmployeeDiscountObject.put("Applicable","False");
            EmployeeDiscountObject.put("Description","Employee Discount");
            OtherDiscountGroupArray.put(EmployeeDiscountObject);

            JSONObject OrganDonorDiscountObject = new JSONObject();
            OrganDonorDiscountObject.put("DiscountAmount","0");
            OrganDonorDiscountObject.put("DiscountRate","0");
            OrganDonorDiscountObject.put("SumInsured",strSumInsured);
            OrganDonorDiscountObject.put("Rate","0");
            OrganDonorDiscountObject.put("Premium","0");
            OrganDonorDiscountObject.put("Applicable",OrganDiscountStatus);
            OrganDonorDiscountObject.put("Description","Organ Donor Discount");
            OtherDiscountGroupArray.put(OrganDonorDiscountObject);

            OtherDiscountsObject.put("OtherDiscountGroup",OtherDiscountGroupArray);
            RisksDataObject.put("OtherDiscounts",OtherDiscountsObject);
            RiskObject.put("RisksData",RisksDataObject);
            RisksObject.put("Risk",RiskObject);
            ProductObject.put("Risks",RisksObject);

            RootObject.put("Product",ProductObject);
            //PaymentDetails
            JSONObject PaymentDetailsObj=new JSONObject();
            JSONObject PaymentEntryObj=new JSONObject();
            PaymentEntryObj.put("PaymentId","NULL");
            PaymentEntryObj.put("MICRCheque","NULL");
            PaymentEntryObj.put("InstrumentDate","NULL");
            PaymentEntryObj.put("DraweeBankName","NULL");
            PaymentEntryObj.put("HOUSEBANKNAME","NULL");
            PaymentEntryObj.put("AmountPaid","NULL");
            PaymentEntryObj.put("PaymentType","NULL");
            PaymentEntryObj.put("PaymentMode","NULL");
            PaymentEntryObj.put("InstrumentNo","NULL");
            PaymentEntryObj.put("Status","NULL");
            PaymentEntryObj.put("DepositSlipNo","NULL");
            PaymentEntryObj.put("PayerType","NULL");
            PaymentDetailsObj.put("PaymentEntry",PaymentEntryObj);
            RootObject.put("PaymentDetails",PaymentDetailsObj);
            //Error
            JSONObject ErrorsObj=new JSONObject();
            ErrorsObj.put("ErrorCode","0");
            ErrorsObj.put("ErrDescription","NULL");
            RootObject.put("Errors",ErrorsObj);

            //mainObject
            object.put("Root",RootObject);
            Log.e("objectApi", String.valueOf(object));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(ChiSummery.this, object, UrlHealthConstants.revisedCHIURL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                try {
                    JSONObject   RootJsonObject = object.getJSONObject("Root");
                    JSONObject ErrorsJsonObject = RootJsonObject.getJSONObject("Errors");
                    String ErrDescription = ErrorsJsonObject.getString("ErrDescription");
                    if (ErrDescription.equals("")) {
                        if (Tag == RequestHealthConstants.RevisedCHIQuotation) {
                            try {
                                JSONObject AuthenticationJsonObject = RootJsonObject.getJSONObject("Authentication");
                                String WACode = AuthenticationJsonObject.getString("WACode");
                                JSONObject CustomerJsonObject = RootJsonObject.getJSONObject("Customer");
                                String PosPolicyNo = CustomerJsonObject.getString("PosPolicyNo");

                                JSONObject ProductJsonObject = RootJsonObject.getJSONObject("Product");
                                Log.e("ProductJsonObject",ProductJsonObject.toString());
                                JSONObject PremiumCalculationJsonObject = ProductJsonObject.getJSONObject("PremiumCalculation");
                                String TotalPremium = PremiumCalculationJsonObject.getString("TotalPremium");
                                Intent intent=new Intent(ChiSummery.this, PaymentWebUrl.class);
                                intent.putExtra("WACode",WACode);
                                intent.putExtra("PosPolicyNo",PosPolicyNo);
                                intent.putExtra("TotalValue",TotalPremium);
                                intent.putExtra("checkPage","Summery");
                                intent.putExtra("checkPayment","Health");
                                startActivity(intent);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }else {
                        Toast.makeText(getApplication(), ""+ErrDescription, Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        },
                RequestHealthConstants.RevisedCHIQuotation);
        req.execute();

    }
    private void backMethod() {
        Intent intent=new Intent(ChiSummery.this,MemberMedicalInfoCHI.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_email",str_email);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("strSelfAgeEditText",strSelfAgeEditText);
        intent.putExtra("strTotalPremium",strTotalPremium);
        intent.putExtra("strEdtNameSelf",strEdtNameSelf);
        intent.putExtra("strEmailIDEditSelf",strEmailIDEditSelf);
        intent.putExtra("strEditGenderSelf",strEditGenderSelf);
        intent.putExtra("strEditOccupationSelf",strEditOccupationSelf);
        intent.putExtra("strPinCodeEdit",strPinCodeEdit);
        intent.putExtra("strPermanentAddressEdit2",strPermanentAddressEdit2);
        intent.putExtra("strPermanentAddressEdit",strPermanentAddressEdit);
        intent.putExtra("strStateEdit",strStateEdit);
        intent.putExtra("strCityEdit",strCityEdit);
        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
        intent.putExtra("strEditInchesSelf",strEditInchesSelf);
        intent.putExtra("strEditFtSelf",strEditFtSelf);
        intent.putExtra("strWeightEditSelf",strWeightEditSelf);
        intent.putExtra("strBMIEdit",strBMIEdit);
        intent.putExtra("strNomineeRelationEdit",strNomineeRelationEdit);
        intent.putExtra("strNomineeName",strNomineeName);
        intent.putExtra("strContactNominee",strContactNominee);
        intent.putExtra("strNomineeDobEdit",strNomineeDobEdit);
        intent.putExtra("strYesPhysicalMentalRadio",strYesPhysicalMentalRadio);
        intent.putExtra("strYesPreExistingRadio",strYesPreExistingRadio);
        intent.putExtra("strBloodSugar",strBloodSugar);
        intent.putExtra("strBloodPressure",strBloodPressure);
        intent.putExtra("strBloodPressureDiastolic",strBloodPressureDiastolic);
        intent.putExtra("strcholesterol",strcholesterol);
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
        intent.putExtra("PosPolicyNo",PosPolicyNo);
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
        intent.putExtra("strFor","1");
        intent.putExtra("strSpouseDobEdit",strSpouseDobEdit);
        intent.putExtra("strPackageOne",strPackageOne);
        intent.putExtra("strCheckBoxSelf",strCheckBoxSelf);
        intent.putExtra("addons",addons);
        intent.putExtra("Discounts",Discounts);
        intent.putExtra("strSpouseNameEditText", strSpouseNameEditText);
        intent.putExtra("strSpouseGenderEdit", strSpouseGenderEdit);
        intent.putExtra("strSpouseOccupationEdit", strSpouseOccupationEdit);
        intent.putExtra("strFtSpouseEdit", strFtSpouseEdit);
        intent.putExtra("strInchesSpouseEdit", strInchesSpouseEdit);
        intent.putExtra("strWeightEditSpouse", strWeightEditSpouse);
        intent.putExtra("strSpouseBMIEdit", strSpouseBMIEdit);
        intent.putExtra("strBMIChildEdit", strBMIChildEdit);
        intent.putExtra("strSecondChildNameEdit", strSecondChildNameEdit);
        intent.putExtra("str_twoGenderSpinner", str_twoGenderSpinner);
        intent.putExtra("str_twoFtSpinner", str_twoFtSpinner);
        intent.putExtra("str_twoInchesSpinner", str_twoInchesSpinner);
        intent.putExtra("strtwoWeightEdit", strtwoWeightEdit);
        intent.putExtra("strBMIChildTwoEdit", strBMIChildTwoEdit);
        intent.putExtra("strThirdChildNameEdit", strThirdChildNameEdit);
        intent.putExtra("str_thirdGenderSpinner", str_thirdGenderSpinner);
        intent.putExtra("str_thirdFtSpinner", str_thirdFtSpinner);
        intent.putExtra("str_thirdInchesSpinner", str_thirdInchesSpinner);
        intent.putExtra("str_thirdWeightEdit", str_thirdWeightEdit);
        intent.putExtra("strBMIEChildThreeEdit", strBMIEChildThreeEdit);
        intent.putExtra("strFourChildNameEdit", strFourChildNameEdit);
        intent.putExtra("str_fourGenderSpinner", str_fourGenderSpinner);
        intent.putExtra("str_fourFtSpinner", str_fourFtSpinner);
        intent.putExtra("str_fourInchesSpinner", str_fourInchesSpinner);
        intent.putExtra("strFourWeightEdit", strFourWeightEdit);
        intent.putExtra("strBMIFourChildEdit", strBMIFourChildEdit);
        intent.putExtra("strSpouseOccupationEdit", strSpouseOccupationEdit);
        intent.putExtra("strRelationEditSpouse", strRelationEditSpouse);
        intent.putExtra("strChildOneNameEdit", strChildOneNameEdit);
        intent.putExtra("strGenderChildOneEdit", strGenderChildOneEdit);
        intent.putExtra("strRelationChildEdit", strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit", strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit", strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit", strRelationFourChildEdit);
        intent.putExtra("LongTermDiscountStatus",LongTermDiscountStatus);
        intent.putExtra("SubCategoryDiscountStatus",SubCategoryDiscountStatus);
        intent.putExtra("SubCategory",SubCategory);
        intent.putExtra("DirectPolicyDiscountPremium",DirectPolicyDiscountPremium);
        intent.putExtra("FamilyTypeCounter",FamilyTypeCounter);
        intent.putExtra("ParentComposition",ParentComposition);
        intent.putExtra("LongTermDiscountDiscountPremium",LongTermDiscountDiscountPremium);
        intent.putExtra("SubCategoryDiscountPremium",SubCategoryDiscountPremium);
        intent.putExtra("doubleCoPaymentDiscountPremium",doubleCoPaymentDiscountPremium);
        intent.putExtra("str_age",str_age);
        intent.putExtra("strMotherFeetEditText", strMotherFeetEditText);
        intent.putExtra("strInchesMotherEdit", strInchesMotherEdit);
        intent.putExtra("strMotherOccupationEdit", strMotherOccupationEdit);
        intent.putExtra("strMotherEditTextName", strMotherEditTextName);
        intent.putExtra("strMotherWeightEdit", strMotherWeightEdit);
        intent.putExtra("strMotherGenderEdit", strMotherGenderEdit);
        intent.putExtra("strMotherRelationShipEdit", strMotherRelationShipEdit);
        intent.putExtra("strBMIMotherEdit", strBMIMotherEdit);
        intent.putExtra("strInchesFatherEdit", strInchesFatherEdit);
        intent.putExtra("strFeetFatherEdit", strFeetFatherEdit);
        intent.putExtra("strFatherOccupationEdit", strFatherOccupationEdit);
        intent.putExtra("strFatherEditTextName", strFatherEditTextName);
        intent.putExtra("strFatherWeightEdit", strFatherWeightEdit);
        intent.putExtra("strFatherGenderEditTet", strFatherGenderEditTet);
        intent.putExtra("strRelationFatherEdit", strRelationFatherEdit);
        intent.putExtra("strBMIFatherEdit", strBMIFatherEdit);
        intent.putExtra("strOccupationEditMotherLaw", strOccupationEditMotherLaw);
        intent.putExtra("strFeetEditTextMotherLaw", strFeetEditTextMotherLaw);
        intent.putExtra("strInchesEditTextMotherLaw", strInchesEditTextMotherLaw);
        intent.putExtra("strMotherLawEditText", strMotherLawEditText);
        intent.putExtra("strWeightMotherLawEdit", strWeightMotherLawEdit);
        intent.putExtra("strMotherGenderEdit", strMotherGenderEdit);
        intent.putExtra("strRelationMotherLawEdit", strRelationMotherLawEdit);
        intent.putExtra("strBMIMotherLawEdit", strBMIMotherLawEdit);
        intent.putExtra("strOccupationFatherLawEdit", strOccupationFatherLawEdit);
        intent.putExtra("strEditFeetFatherLaw", strEditFeetFatherLaw);
        intent.putExtra("strEditInchesFatherLaw", strEditInchesFatherLaw);
        intent.putExtra("strFatherLawNameEdit", strFatherLawNameEdit);
        intent.putExtra("strFatherLawWeightEdit", strFatherLawWeightEdit);
        intent.putExtra("strFatherLawGenderEditText", strFatherLawGenderEditText);
        intent.putExtra("strRelationEditTextFatherLaw", strRelationEditTextFatherLaw);
        intent.putExtra("str_oneFtSpinner", str_oneFtSpinner);
        intent.putExtra("str_oneInchesSpinner", str_oneInchesSpinner);
        intent.putExtra("str_oneWeightEdit", str_oneWeightEdit);
        intent.putExtra("strOccupationEditChildOne",strOccupationEditChildOne);
        intent.putExtra("str_twoOccupationSpinner",str_twoOccupationSpinner);
        intent.putExtra("str_thirdOccupationSpinner",str_thirdOccupationSpinner);
        intent.putExtra("str_fourOccupationSpinner",str_fourOccupationSpinner);
        intent.putExtra("str_thirdOccupationSpinner",str_thirdOccupationSpinner);
        intent.putExtra("yearRadio",yearRadio);
        intent.putExtra("strPackage1",strPackage1);
        intent.putExtra("strPackageTwo",strPackageTwo);
        intent.putExtra("strPackageThree",strPackageThree);
        intent.putExtra("strPackageFour",strPackageFour);
        intent.putExtra("strPackageFive",strPackageFive);
        intent.putExtra("strPackageSix",strPackageSix);
        intent.putExtra("strSelfTobaccoRadio",strSelfTobaccoRadio);
        intent.putExtra("strAlcoholEditSpinner",strAlcoholEditSpinner);
        intent.putExtra("strOccasionallyEditSpinner",strOccasionallyEditSpinner);
        intent.putExtra("strTobaccoEditSelf",strTobaccoEditSelf);
        intent.putExtra("strTobaccoOccasinallyEditSelf",strTobaccoOccasinallyEditSelf);
        intent.putExtra("strSelfAlcoholRadio",strSelfAlcoholRadio);
        intent.putExtra("PersonalAccidentCategory",PersonalAccidentCategory);
        intent.putExtra("PremiumWaiverStatus",PremiumWaiverStatus);
        intent.putExtra("FamilyComposition",FamilyComposition);
        intent.putExtra("PersonalStatusChildFour",PersonalStatusChildFour);
        intent.putExtra("PersonalStatusChildThird",PersonalStatusChildThird);
        intent.putExtra("PersonalStatusChildTwo",PersonalStatusChildTwo);
        intent.putExtra("PersonalStatusChildOne",PersonalStatusChildOne);
        intent.putExtra("strswitch",strswitch);
        intent.putExtra("strCorrespondenceAddressEdit",strCorrespondenceAddressEdit);
        intent.putExtra("strCorrespondenceAddressEdit2",strCorrespondenceAddressEdit2);
        intent.putExtra("strProposerEditDob",strProposerEditDob);
        intent.putExtra("strProposerEditFt",strProposerEditFt);
        intent.putExtra("strProposerEditInches",strProposerEditInches);
        intent.putExtra("strEditGenderProposer",strEditGenderProposer);
        intent.putExtra("strEditOccupationProposer",strEditOccupationProposer);
        intent.putExtra("strProposerRelationEdit",strProposerRelationEdit);
        intent.putExtra("strProposerEdtName",strProposerEdtName);
        intent.putExtra("strWeightEditProposer",strWeightEditProposer);
        intent.putExtra("strProposerBMIEdit",strProposerBMIEdit);
        intent.putExtra("DailyHospitalCoverPremium",DailyHospitalCoverPremium);
        intent.putExtra("CriticalIllnessCoverPremium",CriticalIllnessCoverPremium);
        intent.putExtra("ExtensionPreHospitalizationCoverPremium",ExtensionPreHospitalizationCoverPremium);
        intent.putExtra("ExtensionProHospitalizationCoverPremium",ExtensionProHospitalizationCoverPremium);
        intent.putExtra("MaternityChildcareCoverPremium",MaternityChildcareCoverPremium);
        intent.putExtra("CoverageNonMedicalCoverPremium",CoverageNonMedicalCoverPremium);
        intent.putExtra("ConditionWaiverCoverPremium",ConditionWaiverCoverPremium);
        intent.putExtra("PersonalAccidentCoverPremium",PersonalAccidentCoverPremium);
        intent.putExtra("PreExistingDiseaseCoverPremium",PreExistingDiseaseCoverPremium);
        intent.putExtra("OutpatientDentalCoverPremium",OutpatientDentalCoverPremium);
        intent.putExtra("EmergencyTravellingCoverPremium",EmergencyTravellingCoverPremium);
        intent.putExtra("SecondOpinionCoverPremium",SecondOpinionCoverPremium);
        intent.putExtra("RestCureCoverPremium",RestCureCoverPremium);
        intent.putExtra("ObesityWeightCoverPremium",ObesityWeightCoverPremium);
        intent.putExtra("SterilityInfertilityCoverPremium",SterilityInfertilityCoverPremium);
        intent.putExtra("EnhancedCoverPremium",EnhancedCoverPremium);
        intent.putExtra("MedicallyAdvisedCoverPremium",MedicallyAdvisedCoverPremium);
        intent.putExtra("EmergencyAssistanceCoverPremium",EmergencyAssistanceCoverPremium);
        intent.putExtra("HomeCareCoverPremium",HomeCareCoverPremium);
        intent.putExtra("WellnessBenefitCoverPremium",WellnessBenefitCoverPremium);
        intent.putExtra("DiseaseManagementCoverPremium",DiseaseManagementCoverPremium);
        intent.putExtra("GlobalCoverCoverPremium",GlobalCoverCoverPremium);
        intent.putExtra("ModernTreatmentCoverPremium",ModernTreatmentCoverPremium);
        intent.putExtra("PremiumWaiverCoverPremium",PremiumWaiverCoverPremium);
        intent.putExtra("OrganDiscountStatus",OrganDiscountStatus);
        intent.putExtra("OrganDonorDiscountPremium",OrganDonorDiscountPremium);
        intent.putExtra("strAppointeeNomineeName",strAppointeeNomineeName);
        intent.putExtra("strAppointeeNomineeDobEdit",strAppointeeNomineeDobEdit);
        intent.putExtra("strAppointeeGenderEdit",strAppointeeGenderEdit);
        intent.putExtra("selectNomineeYear",selectNomineeYear);
        intent.putExtra("strMedicalHistoryRadio",strMedicalHistoryRadio);
        intent.putExtra("strMedicineRadio",strMedicineRadio);
        intent.putExtra("strHospitalizationHistory",strHospitalizationHistory);
        intent.putExtra("checkPackage",checkPackage);
        intent.putExtra("CoPaymentCheckBoxCheck",CoPaymentCheckBoxCheck);
        intent.putExtra("SubCategoryDiscountStatusCheck",SubCategoryDiscountStatusCheck);
        intent.putExtra("strCoPaymentEditText",strCoPaymentEditText);
        intent.putExtra("strSubLimitEditText",strSubLimitEditText);
        intent.putExtra("selectFirstYearChild",selectFirstYearChild);
        intent.putExtra("selectSecSonChild",selectSecSonChild);
        intent.putExtra("selectThirdSonChild",selectThirdSonChild);
        intent.putExtra("selectYearChildFour",selectYearChildFour);
        intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
        intent.putExtra("selectYearAdult",selectYearAdult);
        intent.putExtra("selectYearMotherAdult",selectYearMotherAdult);
        intent.putExtra("selectMotherLawAdult",selectMotherLawAdult);
        intent.putExtra("selectFatherLawAdult",selectFatherLawAdult);
        intent.putExtra("selectYearFatherAdult",selectYearFatherAdult);
        intent.putExtra("strSufferingDiseaseSecondAdult",strSufferingDiseaseSecondAdult);
        intent.putExtra("strHospitalizationHistoryAdultSecond",strHospitalizationHistoryAdultSecond);
        intent.putExtra("strConsumeSpouseAlcohol",strConsumeSpouseAlcohol);
        intent.putExtra("strSpouseTobaccoRadio",strSpouseTobaccoRadio);
        intent.putExtra("strSpousePhysicalRadio",strSpousePhysicalRadio);
        intent.putExtra("strDiseaseSpouseRadio",strDiseaseSpouseRadio);
        intent.putExtra("strSpouseEditFrequency", strSpouseEditFrequency);
        intent.putExtra("strOccasionallySpouseEditSpinner", strOccasionallySpouseEditSpinner);
        intent.putExtra("strTobaccoOccasinallyEditSpouse", strTobaccoOccasinallyEditSpouse);
        intent.putExtra("strTobaccoEditSpouse", strTobaccoEditSpouse);
        intent.putExtra("strBasicPremium", strBasicPremium);
        intent.putExtra("copayemntMax", copayemntMax);
        intent.putExtra("TiresDiscount", TiresDiscount);
        intent.putExtra("DirectPolicy", DirectPolicy);
        intent.putExtra("OrganDonar", OrganDonar);
        intent.putExtra("LongTerm", LongTerm);
        intent.putExtra("loyalityDiscount", loyalityDiscount);
        intent.putExtra("sublimt", sublimt);
        intent.putExtra("GSt", GSt);
        intent.putExtra("TreatmentCheckBoxCheck", TreatmentCheckBoxCheck);
        intent.putExtra("strNomineeGenderEdit", strNomineeGenderEdit);
        intent.putExtra("strEmailIDEditSelf",strEmailIDEditSelf);
        intent.putExtra("strPinCodeEdit",strPinCodeEdit);
        intent.putExtra("strCityEdit",strCityEdit);
        intent.putExtra("strStateEdit",strStateEdit);
        intent.putExtra("address1",address1);
        intent.putExtra("address2",address2);
        intent.putExtra("address3",address3);
        intent.putExtra("corresAddress1",corresAddress1);
        intent.putExtra("corresAddress2",corresAddress2);
        intent.putExtra("corresAddress3",corresAddress3);
        intent.putExtra("firstName",firstName);
        intent.putExtra("middleName",middleName);
        intent.putExtra("lastName",lastName);
        intent.putExtra("ckycNo",ckycNo);
        intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
        intent.putExtra("selectYearProposer",selectYearProposer);
        intent.putExtra("permAndCorresAddSame",permAndCorresAddSame);
        intent.putExtra("MaternityAndChildcare", MaternityAndChildcare);
        intent.putExtra("MaternityAndChildcareMale", MaternityAndChildcareMale);
        intent.putExtra("SterilityInfertilityMale", SterilityInfertilityMale);
        intent.putExtra("strDob",strDob);
        intent.putExtra("strIDTypeName",strIDTypeName);
        intent.putExtra("TreatmentStatus",TreatmentStatus);
        intent.putExtra("strFatherLawBMIEdit",strFatherLawBMIEdit);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        backMethod();
    }
}