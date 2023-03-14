package com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.AddressCompleteHealth;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PersonalInformationCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PersonalInformationCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PersonalInformationCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PersonalInformationCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PersonalInformationCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PersonalInformationCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.NomineeOtherDetailsCompleteHealth;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.paymentweb.PaymentWebUrl;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
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
import java.util.Locale;
import java.util.Objects;

public class PersonalInformationCHI extends AppCompatActivity {
    ImageView calendarAppointeeIconDob, proposerDownArrowImg, proposerUpArrowImg, calendarIconProposer, BackImg, selfDownArrowImg, selfUpArrowImg, SpouseDownArrowImg, SpouseUpArrowImg, ChildOneDownArrow, ChildOneUpArrow, ChildTwoDownArrow, ChildTwoUpArrow, ChildThreeDownArrowImg, ChildThreeUpArrowImg, ChildFourDownImg, ChildFourUpImg, MotherDownImg, MotherUpImg, FatherDownArrowImg, FatherUpArrowImg, MotherLawDownImg, MotherLawUpImg, FatherLawDownImg, FatherLawUpImg, nomineeDownImg, nomineeUpImg, calendarIconSelf, calendarIconDob, SpouseDobImg, FirstSonAgeIcon, SecondSonAgeIcon;
    LinearLayout InformationLiner,InformationLinerProposer,NomineeSpinner,InsuredMemberLiner,linerAppointeeSpinner, appointeeNominee, PersonalInformationLiner, ProposerInfoLiner, proposerLiner, continueButton, selfInformationLiner, selfLiner, SpouseMainLiner, ChildOneLinerMain, MainChildOneLiner, ChildTwoLinerMain, MainChildTwoLiner, MainChildThirdLiner, ChildThreeLinerMain, ChildFourLinerMain, MainChildFourLiner, MotherLinerMain, MainMotherLiner, FatherLinerMain, MainFatherLiner, MainMotherLawLiner, MotherLawMainLiner, FatherLawMainLiner, MainFatherLawLiner, MainNomineeLiner, proposerGenderLiner, proposerLinerOccupation, ProposerFtLiner, ProposerLinerInches, GenderLiner, LinerOccupation, ftLiner, LinerInches, linerRelationShip, SpouseGenderLiner, spouseOccupationLiner, FtSpouse, InchesSpouseLiner, ChildOneGenderLiner, OccupationChildOneLiner, ChildOneLinerRelation, LinerFtChildOne, LinerInchesChildOne, SecondSonAgeLiner, SecSonChildGenderLiner, LinerChildTwoFt, LinerChildTwoInches, thirdLinerGender, ThirdSonLinerAge, LinerFtThird, thirdInchesLiner, RelationThirdLiner, ChildTwoRelationLiner, FourChildCalenderLiner, LinerGenderFour, LinerFtFour, LinerInchesFour, LinerRelationFour, LinerMotherDob, MotherOccupationLiner, MotherFeetLiner, InchesLinerMother, FatherDobLiner, LinerFatherOccupation, FeetLinerFather, LinerFatherInches, MotherLawDobLiner, OccupationMatherLawLiner, InchesLinerMotherInLaw, FeetMotherLawLiner, LinerDobFatherLaw, OccupationFatherLawLiner, LinerFeetFatherLaw, LinerInchesFatherLaw;
    String strIDTypeName,TreatmentStatus,permAndCorresAddSame,firstName, middleName,lastName,ckycNo,uniqueTransactionNumber,address1,address2,address3,corresAddress1,corresAddress2,corresAddress3,SterilityInfertilityMale,MaternityAndChildcareMale,strNomineeGenderEdit,TreatmentCheckBoxCheck,strBasicPremium, strCoPaymentEditText, strSubLimitEditText, strGender, SubCategoryDiscountStatusCheck = "", CoPaymentCheckBoxCheck = "", nextYear, tomorrowDate, strBloodSugar, strBloodPressure, strBloodPressureDiastolic, strcholesterol, str_policyType_spinner1, checkPackage, strSelfChangeAgeEditText, strProposerEditDob, strProposerEdtName, strEditGenderProposer, strEditOccupationProposer, strProposerRelationEdit, strProposerEditInches, strWeightEditProposer, strswitch, PersonalStatusChildOne, PersonalStatusChildTwo, PersonalStatusChildThird, PersonalStatusChildFour, PersonalAccidentCategory, strFirstString, strFourString, str_age, DirectPolicyDiscountPremium, LongTermDiscountStatus, SubCategoryDiscountStatus, SubCategory, yearRadio, strSpouseNameEditText, strCheckBoxSelf, MaternityAndChildcareAddOn, str_edt_name = "", str_edt_phone = "", str_email = "", strPackageOne = "", PosPolicyNo = "", strPolicyTenure = "", PlanType = "", today, str_policyType_spinner = "", strSelfAgeEditText = "", str_IndividualTypeEdit = "", strTotalPremium = "", strSumInsured = "", strPlanTypeTXT = "", NetPremium = "", strEdtNameSelf, str_edit_dob3String, strProposerEditFt, strProposerBMIEdit, strEditGenderSelf, strEditOccupationSelf, strRelationAdultOneEdit, strEmailIDEditSelf, strPermanentAddressEdit, strPermanentAddressEdit2, strCorrespondenceAddressEdit = "", strCorrespondenceAddressEdit2 = "", strLandMarkEdit, strPinCodeEdit = "", strCityEdit = "", strStateEdit = "", strWeightEditSelf = "", strEditInchesSelf = "", strEditFtSelf = "", strBMIEdit = "", strNomineeRelationEdit = "", strNomineeName = "", strContactNominee = "", strNomineeDobEdit = "", strSpouseAgeEditText = "", strSpouseAgeEditText1 = "", strSpouseGenderEdit = "", strSpouseOccupationEdit = "", strFtSpouseEdit = "", strInchesSpouseEdit = "", strWeightEditSpouse = "", strSpouseBMIEdit = "", strChildOneNameEdit = "", strGenderChildOneEdit = "", strOccupationEditChildOne = "", strRelationChildEdit = "", str_oneFtSpinner = "", str_oneWeightEdit = "", str_oneInchesSpinner = "", strBMIChildEdit = "", strSecondChildNameEdit = "", str_twoGenderSpinner = "", str_twoOccupationSpinner = "", str_thirdOccupationSpinner = "", str_fourOccupationSpinner = "", strRelationChildTwoEdit = "", strRelationChildThreeEdit = "", strRelationFourChildEdit = "", str_twoFtSpinner = "", str_twoInchesSpinner = "", strtwoWeightEdit = "", strBMIChildTwoEdit = "", str_thirdGenderSpinner = "", str_thirdFtSpinner = "", str_thirdInchesSpinner = "", str_thirdWeightEdit = "", strBMIEChildThreeEdit = "", strThirdChildNameEdit = "", strFourChildNameEdit = "", str_fourGenderSpinner = "", str_fourFtSpinner = "", str_fourInchesSpinner = "", strFourWeightEdit = "", strBMIFourChildEdit = "", strMotherEditTextName = "", strMotherGenderEdit = "", strMotherOccupationEdit = "", strMotherRelationShipEdit = "", strMotherWeightEdit = "", strMotherFeetEditText = "", strInchesMotherEdit = "", strBMIMotherEdit = "", strFatherEditTextName = "", strFatherGenderEditTet = "", strRelationFatherEdit = "", strFatherWeightEdit = "", strFeetFatherEdit = "", strInchesFatherEdit = "", strBMIFatherEdit = "", strMotherLawEditText = "", strRelationMotherLawEdit = "", strWeightMotherLawEdit = "", strFeetEditTextMotherLaw = "", strInchesEditTextMotherLaw = "", strBMIMotherLawEdit = "", strFatherLawNameEdit = "", strFatherLawGenderEditText = "", strOccupationFatherLawEdit = "", strRelationEditTextFatherLaw = "", strFatherLawWeightEdit = "", strEditFeetFatherLaw = "", strEditInchesFatherLaw = "", strFatherLawBMIEdit = "", strRelationEditSpouse = "";
    EditText LandMarkEditProposer,PinCodeEditProposer,StateEditProposer,CityEditProposer,CorrespondenceAddressEditProposer,CorrespondenceAddressEdit2Proposer,PermanentAddressEditProposer,PermanentAddressEdit2Proposer,EmailIDEditSelfProposer,PhoneNumberEditProposer,PhoneNumberEdit,NomineeGenderEdit,appointeeNomineeName, appointeeNomineeDobEdit, AppointeeGenderEdit, NomineeDobEdit, proposerEditDob, proposerEdtName, EditGenderProposer, EditOccupationProposer, proposerEditFt, proposerEditInches, WeightEditProposer, ProposerRelationEdit, ProposerBMIEdit, CorrespondenceAddressEdit, CorrespondenceAddressEdit2, SpouseNameEditText, RelationEditSpouse, FirstSonAgeEditText, EdtNameSelf, EditDobSelf, EditGenderSelf, EditOccupationSelf, EmailIDEditSelf, PermanentAddressEdit, PermanentAddressEdit2, LandMarkEdit, RelationAdultOneEdit, PinCodeEdit, CityEdit, StateEdit, WeightEditSelf, EditInchesSelf, EditFtSelf, BMIEdit, NomineeRelationEdit, NomineeName, ContactNominee, SpouseDobEdit, SpouseGenderEdit, SpouseOccupationEdit, FtSpouseEdit, InchesSpouseEdit, WeightEditSpouse, SpouseBMIEdit, GenderChildOneEdit, OccupationEditChildOne, RelationChildEdit, oneWeightEdit, oneFtSpinner, BMIChildEdit, ChildOneNameEdit, oneInchesSpinner, SecondChildNameEdit, SecondSonAgeEditText, twoGenderSpinner, twoOccupationSpinner, thirdOccupationSpinner, fourOccupationSpinner, RelationChildTwoEdit, RelationChildThreeEdit, RelationFourChildEdit, twoFtSpinner, twoWeightEdit, BMIChildTwoEdit, twoInchesSpinner, thirdGenderSpinner, ThirdSonAgeEditText, thirdFtSpinner, thirdInchesSpinner, thirdWeightEdit, BMIEChildThreeEdit, ThirdChildNameEdit, FourChildNameEdit, FourSonAgeEditText, fourGenderSpinner, fourFtSpinner, fourInchesSpinner, FourWeightEdit, BMIFourChildEdit, MotherEditTextName, MotherAgeEditText, MotherGenderEdit, MotherOccupationEdit, MotherRelationShipEdit, MotherWeightEdit, MotherFeetEditText, InchesMotherEdit, BMIMotherEdit, FatherEditTextName, FatherAgeEditText, FatherGenderEditTet, FatherOccupationEdit, RelationFatherEdit, FatherWeightEdit, FeetFatherEdit, InchesFatherEdit, BMIFatherEdit, MotherLawEditText, MotherLawAgeEditText, GenderMotherLawEdit, OccupationEditMotherLaw, RelationMotherLawEdit, WeightMotherLawEdit, FeetEditTextMotherLaw, InchesEditTextMotherLaw, BMIMotherLawEdit, FatherLawNameEdit, FatherLawAgeEditText, FatherLawGenderEditText, OccupationFatherLawEdit, RelationEditTextFatherLaw, FatherLawWeightEdit, EditFeetFatherLaw, EditInchesFatherLaw, FatherLawBMIEdit;
    SimpleDateFormat dateFormatter;
    String strDob,GSt, strAppointeeNomineeName, strAppointeeNomineeDobEdit, strAppointeeGenderEdit, OrganDiscountStatus, PersonalAccidentCoverPremium, CriticalIllnessCoverPremium = "", DailyHospitalCoverPremium = "", ModernTreatmentCoverPremium = "", ExtensionPreHospitalizationCoverPremium = "", ExtensionProHospitalizationCoverPremium = "", MaternityChildcareCoverPremium = "", CoverageNonMedicalCoverPremium = "", ConditionWaiverCoverPremium = "", PreExistingDiseaseCoverPremium = "", OutpatientDentalCoverPremium = "", EmergencyTravellingCoverPremium = "", SecondOpinionCoverPremium = "", RestCureCoverPremium = "", ObesityWeightCoverPremium = "", SterilityInfertilityCoverPremium = "", EnhancedCoverPremium = "", PremiumWaiverCoverPremium = "", GlobalCoverCoverPremium = "", MedicallyAdvisedCoverPremium = "", EmergencyAssistanceCoverPremium = "", HomeCareCoverPremium = "", WellnessBenefitCoverPremium = "", DiseaseManagementCoverPremium = "";
    Date date, CurrentDate, SelectDate;
    public Period period;
    Format formatter;
    int FamilyTypeCounter, selectYearProposer, mCounter, selectYearAdult, selectAppointee, selectYearSecondAdult, SelectMonth, SelectDays, selectFirstYearChild, daysLeftChild1, selectSecSonChild, daysLeftChild2, daysLeftChild3, selectThirdSonChild, daysLeftChild4, selectYearChildFour, selectNomineeYear, daysLeftDaughter1, SecondDaughterYearChild, daysLeftDaughter2, ThirdDaughterYearChild, daysLeftDaughter3, FourDaughterYearChild, daysLeftDaughter4, selectYearMotherAdult, selectYearFatherAdult, selectMotherLawAdult, selectFatherLawAdult;
    MySharedPreference pref;
    double kg = 0.0;
    double BMI = 0.0;
    double cm = 0.0;
    CheckBox SwitchButton,SwitchButtonProposer;
    double Discounts, LongTermDiscountDiscountPremium, SubCategoryDiscountPremium, doubleCoPaymentDiscountPremium, OrganDonorDiscountPremium;
    TextView PersonalInfomationTxt,ProposerInfoTxt,TotalPremiumTxt, ViewDetails;
    String FamilyComposition, ParentComposition, strFor = "", EmergencyTravellingStatus = "", strPolicyNumber = "", CoPaymentLoading = "", BasicStatus = "", PersonalStatus = "", CriticalStatus = "", DailyHospitalSatus = "", ModernTreatmentsStatus = "", ExtensionPreHospitalization = "", ExtensionPr0Hospitalization = "", MaternityAndChildcare = "", CoverageNonMedical = "", ConditionWaiverStatus = "", PersonalAccidentACoverStatus = "", PersonalAccidentBCoverStatus = "", PreExistingDiseaseStatus = "", OutpatientDentalStatus = "", SecondOpinionStatus = "", RestCureStatus = "", ObesityWeightStatus = "", SterilityInfertilityStatus = "", EnhancedOrganStatus = "", GlobalCoverStatus = "", MedicallyAdvisedStatus = "", EmergencyAssistanceStatus = "", HomeCareStatus = "", WellnessBenefitStatus = "", DiseaseManagementStatus = "", LoyaltyDiscountStatus = "", CoPaymentStatus = "", PremiumWaiverStatus = "", strGenderSpinner = "", strCheckBoxSpouse = "", strCheckBoxMother = "", strMotherAgeEditText = "", strFatherAgeEditText = "", strCheckBoxFather = "", strCheckBoxMotherLaw = "", strMotherLawAgeEditText = "", strCheckBoxFatherLaw = "", strFatherLawAgeEditText = "", strFirstSonAgeEditText = "", strSecondSonAgeEditText = "", strThirdSonAgeEditText = "", strFourSonAgeEditText = "", strCheckBoxSon = "", strFatherOccupationEdit = "", strOccupationEditMotherLaw = "", strPackage1 = "", strPackageTwo = "", strPackageThree = "", strPackageFour = "", strPackageFive = "", strPackageSix = "";
    int addons,DirectPolicy, loyalityDiscount, TiresDiscount, copayemntMax;
    double OrganDonar, sublimt,LongTerm;
    CustomProgressDialog customprogress;
    JSONArray InsuredDetailsGroupArray1;
    JSONObject CoverDetailsJsonObject1, JsonObjectCover1, JsonObjectCoverCh2, JsonObjectCoverCh3, JsonObjectCoverCh4;

    double BasicInsuranceCoverPremiumAd1, PersonalAccidentCoverPremiumAd1, CriticalIllnessCoverPremiumAd1, DailyHospitalCoverPremiumAd1, ModernTreatmentCoverPremiumAd1, ExtensionPreHospitalizationCoverPremiumAd1, ExtensionProHospitalizationCoverPremiumAd1, MaternityChildcareCoverPremiumAd1, CoverageNonMedicalCoverPremiumAd1, ConditionWaiverCoverPremiumAd1, PreExistingDiseaseCoverPremiumAd1, OutpatientDentalCoverPremiumAd1, EmergencyTravellingCoverPremiumAd1, SecondOpinionCoverPremiumAd1, RestCureCoverPremiumAd1, ObesityWeightCoverPremiumAd1, SterilityInfertilityCoverPremiumAd1, EnhancedCoverPremiumAd1, PremiumWaiverCoverPremiumAd1, GlobalCoverCoverPremiumAd1, MedicallyAdvisedCoverPremiumAd1, EmergencyAssistanceCoverPremiumAd1, HomeCareCoverPremiumAd1, WellnessBenefitCoverPremiumAd1, DiseaseManagementCoverPremiumAd1;
    double BasicInsuranceCoverPremiumAd2, PersonalAccidentCoverPremiumAd2, CriticalIllnessCoverPremiumAd2, DailyHospitalCoverPremiumAd2, ModernTreatmentCoverPremiumAd2, ExtensionPreHospitalizationCoverPremiumAd2, ExtensionProHospitalizationCoverPremiumAd2, MaternityChildcareCoverPremiumAd2, CoverageNonMedicalCoverPremiumAd2, ConditionWaiverCoverPremiumAd2, PreExistingDiseaseCoverPremiumAd2, OutpatientDentalCoverPremiumAd2, EmergencyTravellingCoverPremiumAd2, SecondOpinionCoverPremiumAd2, RestCureCoverPremiumAd2, ObesityWeightCoverPremiumAd2, SterilityInfertilityCoverPremiumAd2, EnhancedCoverPremiumAd2, PremiumWaiverCoverPremiumAd2, GlobalCoverCoverPremiumAd2, MedicallyAdvisedCoverPremiumAd2, EmergencyAssistanceCoverPremiumAd2, HomeCareCoverPremiumAd2, WellnessBenefitCoverPremiumAd2, DiseaseManagementCoverPremiumAd2;
    double BasicInsuranceCoverPremiumChild1, PersonalAccidentCoverPremiumCh1, CriticalIllnessCoverPremiumCh1, DailyHospitalCoverPremiumCh1, ModernTreatmentCoverPremiumCh1, ExtensionPreHospitalizationCoverPremiumCh1, ExtensionProHospitalizationCoverPremiumCh1, MaternityChildcareCoverPremiumCh1, CoverageNonMedicalCoverPremiumCh1, ConditionWaiverCoverPremiumCh1, PreExistingDiseaseCoverPremiumCh1, OutpatientDentalCoverPremiumCh1, EmergencyTravellingCoverPremiumCh1, SecondOpinionCoverPremiumCh1, RestCureCoverPremiumCh1, ObesityWeightCoverPremiumCh1, SterilityInfertilityCoverPremiumCh1, EnhancedCoverPremiumCh1, PremiumWaiverCoverPremiumCh1, GlobalCoverCoverPremiumCh1, MedicallyAdvisedCoverPremiumCh1, EmergencyAssistanceCoverPremiumCh1, HomeCareCoverPremiumCh1, WellnessBenefitCoverPremiumCh1, DiseaseManagementCoverPremiumCh1;
    double BasicInsuranceCoverPremiumChild2, PersonalAccidentCoverPremiumCh2, CriticalIllnessCoverPremiumCh2, DailyHospitalCoverPremiumCh2, ModernTreatmentCoverPremiumCh2, ExtensionPreHospitalizationCoverPremiumCh2, ExtensionProHospitalizationCoverPremiumCh2, MaternityChildcareCoverPremiumCh2, CoverageNonMedicalCoverPremiumCh2, ConditionWaiverCoverPremiumCh2, PreExistingDiseaseCoverPremiumCh2, OutpatientDentalCoverPremiumCh2, EmergencyTravellingCoverPremiumCh2, SecondOpinionCoverPremiumCh2, RestCureCoverPremiumCh2, ObesityWeightCoverPremiumCh2, SterilityInfertilityCoverPremiumCh2, EnhancedCoverPremiumCh2, PremiumWaiverCoverPremiumCh2, GlobalCoverCoverPremiumCh2, MedicallyAdvisedCoverPremiumCh2, EmergencyAssistanceCoverPremiumCh2, HomeCareCoverPremiumCh2, WellnessBenefitCoverPremiumCh2, DiseaseManagementCoverPremiumCh2;
    double BasicInsuranceCoverPremiumChild3, PersonalAccidentCoverPremiumCh3, CriticalIllnessCoverPremiumCh3, DailyHospitalCoverPremiumCh3, ModernTreatmentCoverPremiumCh3, ExtensionPreHospitalizationCoverPremiumCh3, ExtensionProHospitalizationCoverPremiumCh3, MaternityChildcareCoverPremiumCh3, CoverageNonMedicalCoverPremiumCh3, ConditionWaiverCoverPremiumCh3, PreExistingDiseaseCoverPremiumCh3, OutpatientDentalCoverPremiumCh3, EmergencyTravellingCoverPremiumCh3, SecondOpinionCoverPremiumCh3, RestCureCoverPremiumCh3, ObesityWeightCoverPremiumCh3, SterilityInfertilityCoverPremiumCh3, EnhancedCoverPremiumCh3, PremiumWaiverCoverPremiumCh3, GlobalCoverCoverPremiumCh3, MedicallyAdvisedCoverPremiumCh3, EmergencyAssistanceCoverPremiumCh3, HomeCareCoverPremiumCh3, WellnessBenefitCoverPremiumCh3, DiseaseManagementCoverPremiumCh3;
    double BasicInsuranceCoverPremiumChild4, PersonalAccidentCoverPremiumCh4, CriticalIllnessCoverPremiumCh4, DailyHospitalCoverPremiumCh4, ModernTreatmentCoverPremiumCh4, ExtensionPreHospitalizationCoverPremiumCh4, ExtensionProHospitalizationCoverPremiumCh4, MaternityChildcareCoverPremiumCh4, CoverageNonMedicalCoverPremiumCh4, ConditionWaiverCoverPremiumCh4, PreExistingDiseaseCoverPremiumCh4, OutpatientDentalCoverPremiumCh4, EmergencyTravellingCoverPremiumCh4, SecondOpinionCoverPremiumCh4, RestCureCoverPremiumCh4, ObesityWeightCoverPremiumCh4, SterilityInfertilityCoverPremiumCh4, EnhancedCoverPremiumCh4, PremiumWaiverCoverPremiumCh4, GlobalCoverCoverPremiumCh4, MedicallyAdvisedCoverPremiumCh4, EmergencyAssistanceCoverPremiumCh4, HomeCareCoverPremiumCh4, WellnessBenefitCoverPremiumCh4, DiseaseManagementCoverPremiumCh4;
    double BasicInsuranceCoverPremiumM, PersonalAccidentCoverPremiumM, CriticalIllnessCoverPremiumM, DailyHospitalCoverPremiumM, ModernTreatmentCoverPremiumM, ExtensionPreHospitalizationCoverPremiumM, ExtensionProHospitalizationCoverPremiumM, MaternityChildcareCoverPremiumM, CoverageNonMedicalCoverPremiumM, ConditionWaiverCoverPremiumM, PreExistingDiseaseCoverPremiumM, OutpatientDentalCoverPremiumM, EmergencyTravellingCoverPremiumM, SecondOpinionCoverPremiumM, RestCureCoverPremiumM, ObesityWeightCoverPremiumM, SterilityInfertilityCoverPremiumM, EnhancedCoverPremiumM, PremiumWaiverCoverPremiumM, GlobalCoverCoverPremiumM, MedicallyAdvisedCoverPremiumM, EmergencyAssistanceCoverPremiumM, HomeCareCoverPremiumM, WellnessBenefitCoverPremiumM, DiseaseManagementCoverPremiumM;
    double BasicInsuranceCoverPremium1, PersonalAccidentCoverPremium1,CriticalIllnessCoverPremium1, DailyHospitalCoverPremium1, ModernTreatmentCoverPremium1, ExtensionPreHospitalizationCoverPremium1, ExtensionProHospitalizationCoverPremium1, MaternityChildcareCoverPremium1, CoverageNonMedicalCoverPremium1, ConditionWaiverCoverPremium1, PreExistingDiseaseCoverPremium1, OutpatientDentalCoverPremium1, EmergencyTravellingCoverPremium1, SecondOpinionCoverPremium1, RestCureCoverPremium1, ObesityWeightCoverPremium1, SterilityInfertilityCoverPremium1, EnhancedCoverPremium1, PremiumWaiverCoverPremium1, GlobalCoverCoverPremium1, MedicallyAdvisedCoverPremium1, EmergencyAssistanceCoverPremium1, HomeCareCoverPremium1, WellnessBenefitCoverPremium1, DiseaseManagementCoverPremium1;
    double BasicInsuranceCoverPremiumF, PersonalAccidentCoverPremiumF, CriticalIllnessCoverPremiumF, DailyHospitalCoverPremiumF, ModernTreatmentCoverPremiumF, ExtensionPreHospitalizationCoverPremiumF, ExtensionProHospitalizationCoverPremiumF, MaternityChildcareCoverPremiumF, CoverageNonMedicalCoverPremiumF, ConditionWaiverCoverPremiumF, PreExistingDiseaseCoverPremiumF, OutpatientDentalCoverPremiumF, EmergencyTravellingCoverPremiumF, SecondOpinionCoverPremiumF, RestCureCoverPremiumF, ObesityWeightCoverPremiumF, SterilityInfertilityCoverPremiumF, EnhancedCoverPremiumF, PremiumWaiverCoverPremiumF, GlobalCoverCoverPremiumF, MedicallyAdvisedCoverPremiumF, EmergencyAssistanceCoverPremiumF, HomeCareCoverPremiumF, WellnessBenefitCoverPremiumF, DiseaseManagementCoverPremiumF;
    double BasicPremiumAdd, conditionAdd, ExtensionPreAdd, ExtensionProAdd, EmergencyAdd, PersonalAccidentAdd, WellnessAdd, PewmiumWaiverAdd, SecondOpinionAdd, ModernTreatAdd, CoverageNonAdd, MedicallyAdvisedAdd, EnhancedAdd, HomeCareAdd, CriticalAdd, DailyCashAdd, OutpatientDentalAdd, EmergencyTravellingAdd, PreExistingAdd, MaternityAdd, DiseaseManagementAdd, RestCureAdd, SterilityAdd, GlobalAdd, ObesityWeightAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information_chi);
        pref = MySharedPreference.getInstance(PersonalInformationCHI.this);
        customprogress = new CustomProgressDialog(PersonalInformationCHI.this);
        getWindow().setStatusBarColor(ContextCompat.getColor(PersonalInformationCHI.this, R.color.colorPrimaryDark));
        TreatmentCheckBoxCheck = getIntent().getStringExtra("TreatmentCheckBoxCheck");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        str_email = getIntent().getStringExtra("str_email");
        str_age = getIntent().getStringExtra("str_age");
        str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
        str_IndividualTypeEdit = getIntent().getStringExtra("str_IndividualTypeEdit");
        strSelfAgeEditText = getIntent().getStringExtra("strSelfAgeEditText");
        strTotalPremium = getIntent().getStringExtra("strTotalPremium");
        str_edt_name = getIntent().getStringExtra("str_edt_name");
        strTotalPremium = getIntent().getStringExtra("strTotalPremium");
        strSumInsured = getIntent().getStringExtra("strSumInsured");
        strPlanTypeTXT = getIntent().getStringExtra("strPlanTypeTXT");
        strCheckBoxSon = getIntent().getStringExtra("strCheckBoxSon");
        strGenderSpinner = getIntent().getStringExtra("strGenderSpinner");
        strGender = getIntent().getStringExtra("strGender");
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
        strFor = getIntent().getStringExtra("strFor");
        NetPremium = getIntent().getStringExtra("NetPremium");
        strBasicPremium = getIntent().getStringExtra("strBasicPremium");
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
        strNomineeName = getIntent().getStringExtra("strNomineeName");
        strNomineeGenderEdit = getIntent().getStringExtra("strNomineeGenderEdit");
        strContactNominee = getIntent().getStringExtra("strContactNominee");
        strNomineeDobEdit = getIntent().getStringExtra("strNomineeDobEdit");
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
        TreatmentStatus = getIntent().getStringExtra("TreatmentStatus");
        strIDTypeName = getIntent().getStringExtra("strIDTypeName");
        EmergencyTravellingStatus = getIntent().getStringExtra("EmergencyTravellingStatus");
        strPolicyNumber = getIntent().getStringExtra("strPolicyNumber");
        CoPaymentLoading = getIntent().getStringExtra("CoPaymentLoading");
        PremiumWaiverStatus = getIntent().getStringExtra("PremiumWaiverStatus");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        strPackageOne = getIntent().getStringExtra("strPackageOne");
        MaternityAndChildcareAddOn = getIntent().getStringExtra("MaternityAndChildcareAddOn");
        strCheckBoxSelf = getIntent().getStringExtra("strCheckBoxSelf");
        yearRadio = getIntent().getStringExtra("yearRadio");
        strPackage1 = getIntent().getStringExtra("strPackage1");
        strPackageTwo = getIntent().getStringExtra("strPackageTwo");
        strPackageThree = getIntent().getStringExtra("strPackageThree");
        strPackageFour = getIntent().getStringExtra("strPackageFour");
        strPackageFive = getIntent().getStringExtra("strPackageFive");
        strPackageSix = getIntent().getStringExtra("strPackageSix");
        strPackageOne = getIntent().getStringExtra("strPackageOne");
        LongTermDiscountStatus = getIntent().getStringExtra("LongTermDiscountStatus");
        SubCategoryDiscountStatus = getIntent().getStringExtra("SubCategoryDiscountStatus");
        SubCategory = getIntent().getStringExtra("SubCategory");
        DirectPolicyDiscountPremium = getIntent().getStringExtra("DirectPolicyDiscountPremium");
        strSpouseGenderEdit = getIntent().getStringExtra("strSpouseGenderEdit");
        strSpouseNameEditText = getIntent().getStringExtra("strSpouseNameEditText");
        strSpouseOccupationEdit = getIntent().getStringExtra("strSpouseOccupationEdit");
        strFtSpouseEdit = getIntent().getStringExtra("strFtSpouseEdit");
        strInchesSpouseEdit = getIntent().getStringExtra("strInchesSpouseEdit");
        strSpouseNameEditText = getIntent().getStringExtra("strSpouseNameEditText");
        strWeightEditSpouse = getIntent().getStringExtra("strWeightEditSpouse");
        strRelationEditSpouse = getIntent().getStringExtra("strRelationEditSpouse");
        strSpouseBMIEdit = getIntent().getStringExtra("strSpouseBMIEdit");
        strGenderChildOneEdit = getIntent().getStringExtra("strGenderChildOneEdit");
        str_oneFtSpinner = getIntent().getStringExtra("str_oneFtSpinner");
        str_oneInchesSpinner = getIntent().getStringExtra("str_oneInchesSpinner");
        strChildOneNameEdit = getIntent().getStringExtra("strChildOneNameEdit");
        str_oneWeightEdit = getIntent().getStringExtra("str_oneWeightEdit");
        strOccupationEditChildOne = getIntent().getStringExtra("strOccupationEditChildOne");
        strRelationChildEdit = getIntent().getStringExtra("strRelationChildEdit");
        strBMIChildEdit = getIntent().getStringExtra("strBMIChildEdit");
        str_twoGenderSpinner = getIntent().getStringExtra("str_twoGenderSpinner");
        str_twoFtSpinner = getIntent().getStringExtra("str_twoFtSpinner");
        str_twoInchesSpinner = getIntent().getStringExtra("str_twoInchesSpinner");
        strSecondChildNameEdit = getIntent().getStringExtra("strSecondChildNameEdit");
        strtwoWeightEdit = getIntent().getStringExtra("strtwoWeightEdit");
        str_twoOccupationSpinner = getIntent().getStringExtra("str_twoOccupationSpinner");
        strRelationChildTwoEdit = getIntent().getStringExtra("strRelationChildTwoEdit");
        strBMIChildTwoEdit = getIntent().getStringExtra("strBMIChildTwoEdit");
        strThirdChildNameEdit = getIntent().getStringExtra("strThirdChildNameEdit");
        str_thirdGenderSpinner = getIntent().getStringExtra("str_thirdGenderSpinner");
        str_thirdFtSpinner = getIntent().getStringExtra("str_thirdFtSpinner");
        str_thirdInchesSpinner = getIntent().getStringExtra("str_thirdInchesSpinner");
        str_thirdWeightEdit = getIntent().getStringExtra("str_thirdWeightEdit");
        str_thirdOccupationSpinner = getIntent().getStringExtra("str_thirdOccupationSpinner");
        strRelationChildThreeEdit = getIntent().getStringExtra("strRelationChildThreeEdit");
        strBMIEChildThreeEdit = getIntent().getStringExtra("strBMIEChildThreeEdit");
        str_fourGenderSpinner = getIntent().getStringExtra("str_fourGenderSpinner");
        str_fourFtSpinner = getIntent().getStringExtra("str_fourFtSpinner");
        str_fourInchesSpinner = getIntent().getStringExtra("str_fourInchesSpinner");
        strFourChildNameEdit = getIntent().getStringExtra("strFourChildNameEdit");
        strFourWeightEdit = getIntent().getStringExtra("strFourWeightEdit");
        str_fourOccupationSpinner = getIntent().getStringExtra("str_fourOccupationSpinner");
        strRelationFourChildEdit = getIntent().getStringExtra("strRelationFourChildEdit");
        strBMIFourChildEdit = getIntent().getStringExtra("strBMIFourChildEdit");
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
        selectYearProposer = getIntent().getIntExtra("selectYearProposer", 0);
        mCounter = getIntent().getIntExtra("mCounter", 0);
        addons = getIntent().getIntExtra("addons", 0);
        FamilyTypeCounter = getIntent().getIntExtra("FamilyTypeCounter", 0);
        Discounts = getIntent().getDoubleExtra("Discounts", 0.0);
        doubleCoPaymentDiscountPremium = getIntent().getDoubleExtra("doubleCoPaymentDiscountPremium", 0.0);
        LongTermDiscountDiscountPremium = getIntent().getDoubleExtra("LongTermDiscountDiscountPremium", 0.0);
        SubCategoryDiscountPremium = getIntent().getDoubleExtra("SubCategoryDiscountPremium", 0.0);
        FamilyComposition = getIntent().getStringExtra("FamilyComposition");
        ParentComposition = getIntent().getStringExtra("ParentComposition");
        strNomineeRelationEdit = getIntent().getStringExtra("strNomineeRelationEdit");
        PersonalAccidentCategory = getIntent().getStringExtra("PersonalAccidentCategory");
        PersonalStatusChildOne = getIntent().getStringExtra("PersonalStatusChildOne");
        PersonalStatusChildTwo = getIntent().getStringExtra("PersonalStatusChildTwo");
        PersonalStatusChildFour = getIntent().getStringExtra("PersonalStatusChildFour");
        PersonalStatusChildThird = getIntent().getStringExtra("PersonalStatusChildThird");
        strswitch = getIntent().getStringExtra("strswitch");
        GSt = getIntent().getStringExtra("GSt");
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
        checkPackage = getIntent().getStringExtra("checkPackage");
        selectNomineeYear = getIntent().getIntExtra("selectNomineeYear", 0);
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
        OrganDonar = getIntent().getDoubleExtra("OrganDonar", 0.00);
        LongTerm = getIntent().getDoubleExtra("LongTerm", 0.00);
        sublimt = getIntent().getDoubleExtra("sublimt", 0.00);
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


        Log.e("selectYearAdult", String.valueOf(selectYearAdult));
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);

        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        tomorrowDate = formatter.format(date);
        Log.e("tomorrowDate", tomorrowDate);


        calendar.add(Calendar.DATE, 364);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        nextYear = formatter.format(date);

        String[] strParts = str_age.split("yrs");
        strFirstString = strParts[0];

        String[] strParts1 = str_age.split("-");
        String strFirstString1 = strParts1[0]; // 004
        String strSecondString1 = strParts1[1];

        String[] strParts2 = strSecondString1.split("yrs");
        strFourString = strParts2[0];

        initView();
    }
    private void initView() {
        //TextView
        ProposerInfoTxt = findViewById(R.id.ProposerInfoTxt);
        PersonalInfomationTxt = findViewById(R.id.PersonalInfomationTxt);
        TotalPremiumTxt = findViewById(R.id.TotalPremiumTxt);
        ViewDetails = findViewById(R.id.ViewDetails);
        CorrespondenceAddressEdit = findViewById(R.id.CorrespondenceAddressEdit);
        CorrespondenceAddressEdit2 = findViewById(R.id.CorrespondenceAddressEdit2);
        SwitchButton = findViewById(R.id.SwitchButton);
        SwitchButtonProposer = findViewById(R.id.SwitchButtonProposer);
        InformationLinerProposer = findViewById(R.id.InformationLinerProposer);
        InformationLiner = findViewById(R.id.InformationLiner);
        //Proposer
        InsuredMemberLiner = findViewById(R.id.InsuredMemberLiner);
        linerAppointeeSpinner = findViewById(R.id.linerAppointeeSpinner);
        appointeeNominee = findViewById(R.id.appointeeNominee);
        appointeeNomineeName = findViewById(R.id.appointeeNomineeName);
        appointeeNomineeDobEdit = findViewById(R.id.appointeeNomineeDobEdit);
        AppointeeGenderEdit = findViewById(R.id.AppointeeGenderEdit);
        NomineeDobEdit = findViewById(R.id.NomineeDobEdit);
        ProposerInfoLiner = findViewById(R.id.ProposerInfoLiner);
        proposerEdtName = findViewById(R.id.proposerEdtName);
        proposerEditDob = findViewById(R.id.proposerEditDob);
        EditGenderProposer = findViewById(R.id.EditGenderProposer);
        EditOccupationProposer = findViewById(R.id.EditOccupationProposer);
        calendarIconProposer = findViewById(R.id.calendarIconProposer);
        proposerEditFt = findViewById(R.id.proposerEditFt);
        proposerEditInches = findViewById(R.id.proposerEditInches);
        WeightEditProposer = findViewById(R.id.WeightEditProposer);
        ProposerBMIEdit = findViewById(R.id.ProposerBMIEdit);
        ProposerRelationEdit = findViewById(R.id.ProposerRelationEdit);
        proposerDownArrowImg = findViewById(R.id.proposerDownArrowImg);
        proposerUpArrowImg = findViewById(R.id.proposerUpArrowImg);
        PhoneNumberEdit = findViewById(R.id.PhoneNumberEdit);
        PhoneNumberEditProposer = findViewById(R.id.PhoneNumberEditProposer);
        EmailIDEditSelfProposer = findViewById(R.id.EmailIDEditSelfProposer);

        //ImageView
        calendarAppointeeIconDob = findViewById(R.id.calendarAppointeeIconDob);
        BackImg = findViewById(R.id.BackImg);
        selfDownArrowImg = findViewById(R.id.selfDownArrowImg);
        selfUpArrowImg = findViewById(R.id.selfUpArrowImg);
        SpouseDownArrowImg = findViewById(R.id.SpouseDownArrowImg);
        SpouseUpArrowImg = findViewById(R.id.SpouseUpArrowImg);
        ChildOneDownArrow = findViewById(R.id.ChildOneDownArrow);
        ChildOneUpArrow = findViewById(R.id.ChildOneUpArrow);
        ChildTwoDownArrow = findViewById(R.id.ChildTwoDownArrow);
        ChildTwoUpArrow = findViewById(R.id.ChildTwoUpArrow);
        ChildThreeDownArrowImg = findViewById(R.id.ChildThreeDownArrowImg);
        ChildThreeUpArrowImg = findViewById(R.id.ChildThreeUpArrowImg);
        ChildFourDownImg = findViewById(R.id.ChildFourDownImg);
        ChildFourUpImg = findViewById(R.id.ChildFourUpImg);
        MotherDownImg = findViewById(R.id.MotherDownImg);
        MotherUpImg = findViewById(R.id.MotherUpImg);
        FatherDownArrowImg = findViewById(R.id.FatherDownArrowImg);
        FatherUpArrowImg = findViewById(R.id.FatherUpArrowImg);
        MotherLawDownImg = findViewById(R.id.MotherLawDownImg);
        MotherLawUpImg = findViewById(R.id.MotherLawUpImg);
        FatherLawDownImg = findViewById(R.id.FatherLawDownImg);
        FatherLawUpImg = findViewById(R.id.FatherLawUpImg);
        nomineeDownImg = findViewById(R.id.nomineeDownImg);
        nomineeUpImg = findViewById(R.id.nomineeUpImg);
        calendarIconSelf = findViewById(R.id.calendarIconSelf);
        calendarIconDob = findViewById(R.id.calendarIconDob);
        SpouseDobImg = findViewById(R.id.SpouseDobImg);
        FirstSonAgeIcon = findViewById(R.id.FirstSonAgeIcon);
        SecondSonAgeIcon = findViewById(R.id.SecondSonAgeIcon);
        //Liner
        continueButton = findViewById(R.id.continueButton);
        NomineeSpinner = findViewById(R.id.NomineeSpinner);
        NomineeGenderEdit = findViewById(R.id.NomineeGenderEdit);
        PersonalInformationLiner = findViewById(R.id.PersonalInformationLiner);
        proposerLiner = findViewById(R.id.proposerLiner);
        selfInformationLiner = findViewById(R.id.selfInformationLiner);
        selfLiner = findViewById(R.id.selfLiner);
        SpouseMainLiner = findViewById(R.id.SpouseMainLiner);
        ChildOneLinerMain = findViewById(R.id.ChildOneLinerMain);
        MainChildOneLiner = findViewById(R.id.MainChildOneLiner);
        ChildTwoLinerMain = findViewById(R.id.ChildTwoLinerMain);
        MainChildTwoLiner = findViewById(R.id.MainChildTwoLiner);
        ChildThreeLinerMain = findViewById(R.id.ChildThreeLinerMain);
        ChildFourLinerMain = findViewById(R.id.ChildFourLinerMain);
        MainChildThirdLiner = findViewById(R.id.MainChildThirdLiner);
        MainChildFourLiner = findViewById(R.id.MainChildFourLiner);
        MotherLinerMain = findViewById(R.id.MotherLinerMain);
        MainMotherLiner = findViewById(R.id.MainMotherLiner);
        FatherLinerMain = findViewById(R.id.FatherLinerMain);
        MainFatherLiner = findViewById(R.id.MainFatherLiner);
        MotherLawMainLiner = findViewById(R.id.MotherLawMainLiner);
        MainMotherLawLiner = findViewById(R.id.MainMotherLawLiner);
        FatherLawMainLiner = findViewById(R.id.FatherLawMainLiner);
        MainFatherLawLiner = findViewById(R.id.MainFatherLawLiner);
        MainNomineeLiner = findViewById(R.id.MainNomineeLiner);
        proposerGenderLiner = findViewById(R.id.proposerGenderLiner);
        proposerLinerOccupation = findViewById(R.id.proposerLinerOccupation);
        ProposerFtLiner = findViewById(R.id.ProposerFtLiner);
        ProposerLinerInches = findViewById(R.id.ProposerLinerInches);
        GenderLiner = findViewById(R.id.GenderLiner);
        LinerOccupation = findViewById(R.id.LinerOccupation);
        ftLiner = findViewById(R.id.ftLiner);
        LinerInches = findViewById(R.id.LinerInches);
        linerRelationShip = findViewById(R.id.linerRelationShip);
        SpouseGenderLiner = findViewById(R.id.SpouseGenderLiner);
        spouseOccupationLiner = findViewById(R.id.spouseOccupationLiner);
        FtSpouse = findViewById(R.id.FtSpouse);
        InchesSpouseLiner = findViewById(R.id.InchesSpouseLiner);
        ChildOneGenderLiner = findViewById(R.id.ChildOneGenderLiner);
        OccupationChildOneLiner = findViewById(R.id.OccupationChildOneLiner);
        ChildOneLinerRelation = findViewById(R.id.ChildOneLinerRelation);
        LinerFtChildOne = findViewById(R.id.LinerFtChildOne);
        LinerInchesChildOne = findViewById(R.id.LinerInchesChildOne);
        SecondSonAgeLiner = findViewById(R.id.SecondSonAgeLiner);
        SecSonChildGenderLiner = findViewById(R.id.SecSonChildGenderLiner);
        LinerChildTwoFt = findViewById(R.id.LinerChildTwoFt);
        LinerChildTwoInches = findViewById(R.id.LinerChildTwoInches);
        thirdLinerGender = findViewById(R.id.thirdLinerGender);
        ThirdSonLinerAge = findViewById(R.id.ThirdSonLinerAge);
        LinerFtThird = findViewById(R.id.LinerFtThird);
        thirdInchesLiner = findViewById(R.id.thirdInchesLiner);
        RelationThirdLiner = findViewById(R.id.RelationThirdLiner);
        MotherOccupationLiner = findViewById(R.id.MotherOccupationLiner);
        MotherFeetLiner = findViewById(R.id.MotherFeetLiner);
        InchesLinerMother = findViewById(R.id.InchesLinerMother);
        FatherDobLiner = findViewById(R.id.FatherDobLiner);
        LinerFatherOccupation = findViewById(R.id.LinerFatherOccupation);
        FeetLinerFather = findViewById(R.id.FeetLinerFather);
        LinerFatherInches = findViewById(R.id.LinerFatherInches);
        MotherLawDobLiner = findViewById(R.id.MotherLawDobLiner);
        OccupationMatherLawLiner = findViewById(R.id.OccupationMatherLawLiner);
        InchesLinerMotherInLaw = findViewById(R.id.InchesLinerMotherInLaw);
        FeetMotherLawLiner = findViewById(R.id.FeetMotherLawLiner);
        LinerDobFatherLaw = findViewById(R.id.LinerDobFatherLaw);
        OccupationFatherLawLiner = findViewById(R.id.OccupationFatherLawLiner);
        LinerFeetFatherLaw = findViewById(R.id.LinerFeetFatherLaw);
        LinerInchesFatherLaw = findViewById(R.id.LinerInchesFatherLaw);

        //EditText
        LandMarkEditProposer = findViewById(R.id.LandMarkEditProposer);
        StateEditProposer = findViewById(R.id.StateEditProposer);
        CityEditProposer = findViewById(R.id.CityEditProposer);
        CorrespondenceAddressEditProposer = findViewById(R.id.CorrespondenceAddressEditProposer);
        CorrespondenceAddressEdit2Proposer = findViewById(R.id.CorrespondenceAddressEdit2Proposer);
        PinCodeEditProposer = findViewById(R.id.PinCodeEditProposer);
        PermanentAddressEditProposer = findViewById(R.id.PermanentAddressEditProposer);
        PermanentAddressEdit2Proposer = findViewById(R.id.PermanentAddressEdit2Proposer);
        EdtNameSelf = findViewById(R.id.EdtNameSelf);
        EditDobSelf = findViewById(R.id.EditDobSelf);
        EditGenderSelf = findViewById(R.id.EditGenderSelf);
        EditOccupationSelf = findViewById(R.id.EditOccupationSelf);
        EmailIDEditSelf = findViewById(R.id.EmailIDEditSelf);
        PermanentAddressEdit = findViewById(R.id.PermanentAddressEdit);
        PermanentAddressEdit2 = findViewById(R.id.PermanentAddressEdit2);
        LandMarkEdit = findViewById(R.id.LandMarkEdit);
        RelationAdultOneEdit = findViewById(R.id.RelationAdultOneEdit);
        PinCodeEdit = findViewById(R.id.PinCodeEdit);
        CityEdit = findViewById(R.id.CityEdit);
        StateEdit = findViewById(R.id.StateEdit);
        WeightEditSelf = findViewById(R.id.WeightEditSelf);
        RelationEditSpouse = findViewById(R.id.RelationEditSpouse);
        SpouseNameEditText = findViewById(R.id.SpouseNameEditText);
        EditInchesSelf = findViewById(R.id.EditInchesSelf);
        EditFtSelf = findViewById(R.id.EditFtSelf);
        BMIEdit = findViewById(R.id.BMIEdit);
        NomineeRelationEdit = findViewById(R.id.NomineeRelationEdit);
        NomineeName = findViewById(R.id.NomineeName);
        ContactNominee = findViewById(R.id.ContactNominee);
        NomineeDobEdit = findViewById(R.id.NomineeDobEdit);
        SpouseDobEdit = findViewById(R.id.SpouseDobEdit);
        SpouseOccupationEdit = findViewById(R.id.SpouseOccupationEdit);
        FtSpouseEdit = findViewById(R.id.FtSpouseEdit);
        InchesSpouseEdit = findViewById(R.id.InchesSpouseEdit);
        WeightEditSpouse = findViewById(R.id.WeightEditSpouse);
        SpouseBMIEdit = findViewById(R.id.SpouseBMIEdit);
        SpouseGenderEdit = findViewById(R.id.SpouseGenderEdit);
        FirstSonAgeEditText = findViewById(R.id.FirstSonAgeEditText);
        GenderChildOneEdit = findViewById(R.id.GenderChildOneEdit);
        OccupationEditChildOne = findViewById(R.id.OccupationEditChildOne);
        RelationChildEdit = findViewById(R.id.RelationChildEdit);
        oneWeightEdit = findViewById(R.id.oneWeightEdit);
        oneFtSpinner = findViewById(R.id.oneFtSpinner);
        ChildOneNameEdit = findViewById(R.id.ChildOneNameEdit);
        BMIChildEdit = findViewById(R.id.BMIChildEdit);
        oneInchesSpinner = findViewById(R.id.oneInchesSpinner);
        SecondChildNameEdit = findViewById(R.id.SecondChildNameEdit);
        SecondSonAgeEditText = findViewById(R.id.SecondSonAgeEditText);
        twoGenderSpinner = findViewById(R.id.twoGenderSpinner);
        twoOccupationSpinner = findViewById(R.id.twoOccupationSpinner);
        thirdOccupationSpinner = findViewById(R.id.thirdOccupationSpinner);
        fourOccupationSpinner = findViewById(R.id.fourOccupationSpinner);
        RelationChildTwoEdit = findViewById(R.id.RelationChildTwoEdit);
        RelationChildThreeEdit = findViewById(R.id.RelationChildThreeEdit);
        RelationFourChildEdit = findViewById(R.id.RelationFourChildEdit);
        twoFtSpinner = findViewById(R.id.twoFtSpinner);
        twoWeightEdit = findViewById(R.id.twoWeightEdit);
        BMIChildTwoEdit = findViewById(R.id.BMIChildTwoEdit);
        twoInchesSpinner = findViewById(R.id.twoInchesSpinner);
        thirdGenderSpinner = findViewById(R.id.thirdGenderSpinner);
        ThirdSonAgeEditText = findViewById(R.id.ThirdSonAgeEditText);
        thirdFtSpinner = findViewById(R.id.thirdFtSpinner);
        thirdInchesSpinner = findViewById(R.id.thirdInchesSpinner);
        thirdWeightEdit = findViewById(R.id.thirdWeightEdit);
        BMIEChildThreeEdit = findViewById(R.id.BMIEChildThreeEdit);
        ChildTwoRelationLiner = findViewById(R.id.ChildTwoRelationLiner);
        ThirdChildNameEdit = findViewById(R.id.ThirdChildNameEdit);
        FourChildNameEdit = findViewById(R.id.FourChildNameEdit);
        FourChildCalenderLiner = findViewById(R.id.FourChildCalenderLiner);
        FourSonAgeEditText = findViewById(R.id.FourSonAgeEditText);
        LinerGenderFour = findViewById(R.id.LinerGenderFour);
        fourGenderSpinner = findViewById(R.id.fourGenderSpinner);
        LinerFtFour = findViewById(R.id.LinerFtFour);
        fourFtSpinner = findViewById(R.id.fourFtSpinner);
        fourInchesSpinner = findViewById(R.id.fourInchesSpinner);
        LinerInchesFour = findViewById(R.id.LinerInchesFour);
        FourWeightEdit = findViewById(R.id.FourWeightEdit);
        BMIFourChildEdit = findViewById(R.id.BMIFourChildEdit);
        LinerRelationFour = findViewById(R.id.LinerRelationFour);
        MotherEditTextName = findViewById(R.id.MotherEditTextName);
        LinerMotherDob = findViewById(R.id.LinerMotherDob);
        MotherAgeEditText = findViewById(R.id.MotherAgeEditText);
        MotherGenderEdit = findViewById(R.id.MotherGenderEdit);
        MotherOccupationEdit = findViewById(R.id.MotherOccupationEdit);
        MotherRelationShipEdit = findViewById(R.id.MotherRelationShipEdit);
        MotherWeightEdit = findViewById(R.id.MotherWeightEdit);
        MotherFeetEditText = findViewById(R.id.MotherFeetEditText);
        InchesMotherEdit = findViewById(R.id.InchesMotherEdit);
        BMIMotherEdit = findViewById(R.id.BMIMotherEdit);
        FatherEditTextName = findViewById(R.id.FatherEditTextName);
        FatherAgeEditText = findViewById(R.id.FatherAgeEditText);
        FatherGenderEditTet = findViewById(R.id.FatherGenderEditTet);
        FatherOccupationEdit = findViewById(R.id.FatherOccupationEdit);
        RelationFatherEdit = findViewById(R.id.RelationFatherEdit);
        FatherWeightEdit = findViewById(R.id.FatherWeightEdit);
        FeetFatherEdit = findViewById(R.id.FeetFatherEdit);
        InchesFatherEdit = findViewById(R.id.InchesFatherEdit);
        BMIFatherEdit = findViewById(R.id.BMIFatherEdit);
        MotherLawEditText = findViewById(R.id.MotherLawEditText);
        MotherLawAgeEditText = findViewById(R.id.MotherLawAgeEditText);
        GenderMotherLawEdit = findViewById(R.id.GenderMotherLawEdit);
        OccupationEditMotherLaw = findViewById(R.id.OccupationEditMotherLaw);
        RelationMotherLawEdit = findViewById(R.id.RelationMotherLawEdit);
        WeightMotherLawEdit = findViewById(R.id.WeightMotherLawEdit);
        FeetEditTextMotherLaw = findViewById(R.id.FeetEditTextMotherLaw);
        InchesEditTextMotherLaw = findViewById(R.id.InchesEditTextMotherLaw);
        BMIMotherLawEdit = findViewById(R.id.BMIMotherLawEdit);
        FatherLawNameEdit = findViewById(R.id.FatherLawNameEdit);
        FatherLawAgeEditText = findViewById(R.id.FatherLawAgeEditText);
        FatherLawGenderEditText = findViewById(R.id.FatherLawGenderEditText);
        OccupationFatherLawEdit = findViewById(R.id.OccupationFatherLawEdit);
        RelationEditTextFatherLaw = findViewById(R.id.RelationEditTextFatherLaw);
        FatherLawWeightEdit = findViewById(R.id.FatherLawWeightEdit);
        EditFeetFatherLaw = findViewById(R.id.EditFeetFatherLaw);
        EditInchesFatherLaw = findViewById(R.id.EditInchesFatherLaw);
        FatherLawBMIEdit = findViewById(R.id.FatherLawBMIEdit);

        TotalPremiumTxt.setText(strTotalPremium);
        EditDobSelf.setText(strSelfAgeEditText);
        PinCodeEdit.setText(strPinCodeEdit);
        StateEdit.setText(strStateEdit);
        CityEdit.setText(strCityEdit);
        strPermanentAddressEdit=address1;
        strPermanentAddressEdit2=address2+" "+address3;
//        strCorrespondenceAddressEdit=corresAddress1;
//        strCorrespondenceAddressEdit2=corresAddress2+" "+corresAddress3;
        PermanentAddressEdit.setText(strPermanentAddressEdit);
        PermanentAddressEdit2.setText(strPermanentAddressEdit2);
//        CorrespondenceAddressEdit.setText(strCorrespondenceAddressEdit);
//        CorrespondenceAddressEdit2.setText(strCorrespondenceAddressEdit2);
        PhoneNumberEdit.setText(str_edt_phone);
        PhoneNumberEditProposer.setText(str_edt_phone);
        EmailIDEditSelf.setText(strEmailIDEditSelf);
        EmailIDEditSelfProposer.setText(strEmailIDEditSelf);

        PermanentAddressEditProposer.setText(strPermanentAddressEdit);
        PermanentAddressEdit2Proposer.setText(strPermanentAddressEdit2);
        PinCodeEditProposer.setText(strPinCodeEdit);
        StateEditProposer.setText(strStateEdit);
        CityEditProposer.setText(strCityEdit);
//        CorrespondenceAddressEditProposer.setText(strCorrespondenceAddressEdit);
//        CorrespondenceAddressEdit2Proposer.setText(strCorrespondenceAddressEdit);

//        CorrespondenceAddressEditProposer.setEnabled(false);
//        CorrespondenceAddressEdit2Proposer.setEnabled(false);
        StateEditProposer.setEnabled(false);
        PinCodeEditProposer.setEnabled(false);
        CityEditProposer.setEnabled(false);
        PinCodeEdit.setEnabled(false);
        CityEdit.setEnabled(false);
        proposerEdtName.setEnabled(false);
        EmailIDEditSelf.setEnabled(false);
        EmailIDEditSelfProposer.setEnabled(false);
        PhoneNumberEditProposer.setEnabled(false);
        PhoneNumberEdit.setEnabled(false);
        PermanentAddressEdit.setEnabled(false);
        PermanentAddressEdit2.setEnabled(false);
//        CorrespondenceAddressEdit.setEnabled(false);
//        CorrespondenceAddressEdit2.setEnabled(false);
        PermanentAddressEdit.setClickable(false);
        PermanentAddressEdit.setFocusable(false);
//        PermanentAddressEditProposer.setEnabled(false);
//        PermanentAddressEdit2Proposer.setEnabled(false);

        if (strIDTypeName.equals("Reference Number")){
            EmailIDEditSelf.setEnabled(true);
            EmailIDEditSelfProposer.setEnabled(true);
            PhoneNumberEditProposer.setEnabled(true);
            PhoneNumberEdit.setEnabled(true);
            PinCodeEditProposer.setEnabled(true);
            PinCodeEdit.setEnabled(true);
            strPermanentAddressEdit=address1;
            strPermanentAddressEdit2=address1;
            PermanentAddressEdit.setText(strPermanentAddressEdit);
            PermanentAddressEdit2.setText(strPermanentAddressEdit2);
            PermanentAddressEditProposer.setText(strPermanentAddressEdit);
            PermanentAddressEdit2Proposer.setText(strPermanentAddressEdit2);
        }



        if (!strCheckBoxSelf.equals("Checked")){
            strProposerEditDob=strDob;
            strProposerEdtName=firstName+" "+middleName+" "+lastName;
            proposerEdtName.setText(strProposerEdtName);
            GenderLiner.setClickable(true);
            if (strIDTypeName.equals("Reference Number")){
                strProposerEdtName=firstName;
                proposerEdtName.setText(strProposerEdtName);
            }
            if(!strCheckBoxSpouse.equals("Checked")){
                strSpouseGenderEdit = "Select Gender";
            }
        }
        else{
            strProposerEditDob=strDob;
            strEdtNameSelf=firstName+" "+middleName+" "+lastName;
            EdtNameSelf.setText(strEdtNameSelf);
            GenderLiner.setClickable(false);
            if(!strCheckBoxSpouse.equals("Checked")){
                strSpouseGenderEdit = "Select Gender";
            }
            if (strIDTypeName.equals("Reference Number")){
                strEdtNameSelf=firstName;
                EdtNameSelf.setText(strEdtNameSelf);
            }
        }

        if (strCheckBoxSelf.equals("Checked")) {
            strSelfAgeEditText=strDob;
            EditDobSelf.setText(strSelfAgeEditText);
            ProposerInfoLiner.setVisibility(View.GONE);
        }
        else {
            ProposerInfoTxt.setText("Personal Information");
            ProposerInfoLiner.setVisibility(View.VISIBLE);
        }
        proposerGenderLiner.setClickable(true);
        proposerGenderLiner.setFocusable(false);

        if (!str_policyType_spinner.equals("Individual")) {
            FirstSonAgeEditText.setText(strFirstSonAgeEditText);
            InsuredMemberLiner.setVisibility(View.VISIBLE);

            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
              if (strCheckBoxSelf.equals("Checked")) {
                EdtNameSelf.setText(strEdtNameSelf);
                ProposerInfoLiner.setVisibility(View.GONE);
                PersonalInformationLiner.setVisibility(View.VISIBLE);
                  InformationLiner.setVisibility(View.VISIBLE);
                  strSelfAgeEditText=strDob;
                EditDobSelf.setText(strSelfAgeEditText);
                  EdtNameSelf.setClickable(false);
                  EdtNameSelf.setFocusable(false);
            } else {
                  ProposerInfoLiner.setVisibility(View.VISIBLE);
                PersonalInformationLiner.setVisibility(View.GONE);
            }

            if (strCheckBoxSpouse.equals("Checked")) {
                selfInformationLiner.setVisibility(View.VISIBLE);
                SpouseDobEdit.setText(strSpouseAgeEditText);
            } else {
                selfInformationLiner.setVisibility(View.GONE);
            }
            }else{
                if (strCheckBoxSelf.equals("Checked")||strCheckBoxSpouse.equals("Checked")){
                    if (strCheckBoxSpouse.equals("Checked")){
                        PersonalInfomationTxt.setText("Spouse");
                        ProposerInfoLiner.setVisibility(View.VISIBLE);
                        EdtNameSelf.setEnabled(true);
                        EditDobSelf.setEnabled(true);
                        InformationLiner.setVisibility(View.GONE);
                    }else{
                        EdtNameSelf.setText(strEdtNameSelf);
                        ProposerInfoLiner.setVisibility(View.GONE);
                        EdtNameSelf.setClickable(false);
                        EdtNameSelf.setFocusable(false);
                        InformationLiner.setVisibility(View.VISIBLE);
                    }
                    PersonalInformationLiner.setVisibility(View.VISIBLE);
                }
            }



            if (strCheckBoxSon.equals("Checked")) {
                if (mCounter == 1) {
                    ChildOneLinerMain.setVisibility(View.VISIBLE);
                    ChildTwoLinerMain.setVisibility(View.GONE);
                    ChildThreeLinerMain.setVisibility(View.GONE);
                    ChildFourLinerMain.setVisibility(View.GONE);
                    FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                } else if (mCounter == 2) {
                    ChildOneLinerMain.setVisibility(View.VISIBLE);
                    ChildTwoLinerMain.setVisibility(View.VISIBLE);
                    ChildThreeLinerMain.setVisibility(View.GONE);
                    ChildFourLinerMain.setVisibility(View.GONE);
                    FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                    SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                } else if (mCounter == 3) {
                    ChildOneLinerMain.setVisibility(View.VISIBLE);
                    ChildTwoLinerMain.setVisibility(View.VISIBLE);
                    ChildThreeLinerMain.setVisibility(View.VISIBLE);
                    ChildFourLinerMain.setVisibility(View.GONE);
                    FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                    SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                    ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                } else if (mCounter == 4) {
                    ChildOneLinerMain.setVisibility(View.VISIBLE);
                    ChildTwoLinerMain.setVisibility(View.VISIBLE);
                    ChildThreeLinerMain.setVisibility(View.VISIBLE);
                    ChildFourLinerMain.setVisibility(View.VISIBLE);
                    FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                    SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                    ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                    FourSonAgeEditText.setText(strFourSonAgeEditText);
                }
            }
            else {
                ChildOneLinerMain.setVisibility(View.GONE);
                ChildTwoLinerMain.setVisibility(View.GONE);
                ChildThreeLinerMain.setVisibility(View.GONE);
                ChildFourLinerMain.setVisibility(View.GONE);
            }

            if (strCheckBoxMother.equals("Checked")) {
                MotherLinerMain.setVisibility(View.VISIBLE);
                MotherAgeEditText.setText(strMotherAgeEditText);
            } else {
                MotherLinerMain.setVisibility(View.GONE);
            }
            if (strCheckBoxFather.equals("Checked")) {
                FatherLinerMain.setVisibility(View.VISIBLE);
                FatherAgeEditText.setText(strFatherAgeEditText);
            } else {
                FatherLinerMain.setVisibility(View.GONE);
            }
            if (strCheckBoxMotherLaw.equals("Checked")) {
                MotherLawMainLiner.setVisibility(View.VISIBLE);
                MotherLawAgeEditText.setText(strMotherLawAgeEditText);
            } else {
                MotherLawMainLiner.setVisibility(View.GONE);
            }

            if (strCheckBoxFatherLaw.equals("Checked")) {
                FatherLawMainLiner.setVisibility(View.VISIBLE);
                FatherLawAgeEditText.setText(strFatherLawAgeEditText);
            } else {
                FatherLawMainLiner.setVisibility(View.GONE);
            }
        }
        else {
            if (strCheckBoxSelf.equals("Checked")) {
                InsuredMemberLiner.setVisibility(View.GONE);
                PersonalInfomationTxt.setText("Personal Information");
                EdtNameSelf.setText(strEdtNameSelf);
                EdtNameSelf.setClickable(false);
                EdtNameSelf.setFocusable(false);
                InformationLiner.setVisibility(View.VISIBLE);
            }else{
                InsuredMemberLiner.setVisibility(View.VISIBLE);
            }
            if (strCheckBoxSpouse.equals("Checked")) {
                PersonalInfomationTxt.setText("Spouse");
                EdtNameSelf.setEnabled(true);
                EditDobSelf.setEnabled(true);
                InformationLiner.setVisibility(View.GONE);
                GenderLiner.setClickable(false);
            }
            if (strCheckBoxMother.equals("Checked")) {
                PersonalInfomationTxt.setText("Mother");
            }
            if (strCheckBoxFather.equals("Checked")) {
                PersonalInfomationTxt.setText("Father");
            }
            if (strCheckBoxMotherLaw.equals("Checked")) {
                PersonalInfomationTxt.setText("Mother-In-Law");
            }
            if (strCheckBoxFatherLaw.equals("Checked")) {
                PersonalInfomationTxt.setText("Father-In-Law");
            }
            selfInformationLiner.setVisibility(View.GONE);
            ChildOneLinerMain.setVisibility(View.GONE);
            ChildTwoLinerMain.setVisibility(View.GONE);
            ChildThreeLinerMain.setVisibility(View.GONE);
            ChildFourLinerMain.setVisibility(View.GONE);
            MotherLinerMain.setVisibility(View.GONE);
            FatherLinerMain.setVisibility(View.GONE);
            MotherLawMainLiner.setVisibility(View.GONE);
            FatherLawMainLiner.setVisibility(View.GONE);
            PersonalInformationLiner.setVisibility(View.VISIBLE);
            FirstSonAgeEditText.setText(strFirstSonAgeEditText);
        }

        if (strFor.equals("0")) {
            //Proposer
            strProposerEditFt = "Ft";
            strProposerEditInches = "Inches";
            strEditGenderProposer = strGenderSpinner;
            strEditOccupationProposer = "Select Occupation";
            strProposerRelationEdit = "Self";
//            strProposerEditDob = "Select Dob";
            strAppointeeNomineeDobEdit = "Select Dob";
            strswitch = "False";
            //self
//            strEditGenderProposer = "Select Gender";
            strNomineeGenderEdit = "Select Gender";
            strAppointeeGenderEdit = "Select Gender";
//            strEditGenderSelf = "Select Gender";
//            strSpouseGenderEdit = "Select Gender";
            strEditOccupationSelf = "Select Occupation";
            strSpouseOccupationEdit = "Select Occupation";
            strRelationEditSpouse = "Spouse";

            strEditFtSelf = "Ft";
            strFtSpouseEdit = "Ft";
            strEditInchesSelf = "Inches";
            strInchesSpouseEdit = "Inches";
            strNomineeRelationEdit = "Spouse";
            strNomineeDobEdit = "Nominee Dob";


            strOccupationEditChildOne = "Student";
            str_twoOccupationSpinner = "Student";
            str_thirdOccupationSpinner = "Student";
            str_fourOccupationSpinner = "Student";
            OccupationEditChildOne.setText(strOccupationEditChildOne);
            twoOccupationSpinner.setText(str_twoOccupationSpinner);
            thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
            fourOccupationSpinner.setText(str_fourOccupationSpinner);
            RelationEditSpouse.setText(strRelationEditSpouse);
            AppointeeGenderEdit.setText(strAppointeeGenderEdit);

            if (strGenderSpinner.equals("Female")){
                strRelationChildEdit = "Daughter";
                strRelationChildTwoEdit = "Daughter";
                strRelationChildThreeEdit = "Daughter";
                strRelationFourChildEdit = "Daughter";
            }else{
                strRelationChildEdit = "Son";
                strRelationChildTwoEdit = "Son";
                strRelationChildThreeEdit = "Son";
                strRelationFourChildEdit = "Son";
            }
            RelationChildEdit.setText(strRelationChildEdit);
            RelationChildTwoEdit.setText(strRelationChildTwoEdit);
            RelationChildThreeEdit.setText(strRelationChildThreeEdit);
            RelationFourChildEdit.setText(strRelationFourChildEdit);

            strMotherGenderEdit = "Female";
            strMotherRelationShipEdit = "Mother";
            strRelationFatherEdit = "Father";
            strFatherGenderEditTet = "Male";
            strRelationMotherLawEdit = "Mother-In-Law";
            strFatherLawGenderEditText = "Male";
            strRelationEditTextFatherLaw = "Father-In-Law";
            MotherGenderEdit.setText(strMotherGenderEdit);
            GenderMotherLawEdit.setText(strMotherGenderEdit);
            MotherRelationShipEdit.setText(strMotherRelationShipEdit);
            FatherGenderEditTet.setText(strFatherGenderEditTet);
            RelationFatherEdit.setText(strRelationFatherEdit);
            RelationMotherLawEdit.setText(strRelationMotherLawEdit);
            FatherLawGenderEditText.setText(strFatherLawGenderEditText);
            RelationEditTextFatherLaw.setText(strRelationEditTextFatherLaw);

            //Mother
            strMotherOccupationEdit = "Select Occupation";
            strMotherFeetEditText = "Ft";
            strInchesMotherEdit = "Inches";
            MotherFeetEditText.setText(strMotherFeetEditText);
            InchesMotherEdit.setText(strInchesMotherEdit);
            MotherOccupationEdit.setText(strMotherOccupationEdit);

            //Father
            strFatherOccupationEdit = "Select Occupation";
            strFeetFatherEdit = "Ft";
            strInchesFatherEdit = "Inches";
            InchesFatherEdit.setText(strInchesFatherEdit);
            FeetFatherEdit.setText(strFeetFatherEdit);
            FatherOccupationEdit.setText(strFatherOccupationEdit);

            //MotherLaw
            strOccupationEditMotherLaw = "Select Occupation";
            strFeetEditTextMotherLaw = "Ft";
            strInchesEditTextMotherLaw = "Inches";
            OccupationEditMotherLaw.setText(strOccupationEditMotherLaw);
            FeetEditTextMotherLaw.setText(strFeetEditTextMotherLaw);
            InchesEditTextMotherLaw.setText(strInchesEditTextMotherLaw);

            //FatherLaw
            strOccupationFatherLawEdit = "Select Occupation";
            strEditFeetFatherLaw = "Ft";
            strEditInchesFatherLaw = "Inches";
            OccupationFatherLawEdit.setText(strOccupationFatherLawEdit);
            EditFeetFatherLaw.setText(strEditFeetFatherLaw);
            EditInchesFatherLaw.setText(strEditInchesFatherLaw);


//            strEmailIDEditSelf=str_email;


            if (str_policyType_spinner.equals("Individual")) {
                if (strCheckBoxSelf.equals("Checked")) {
                    strRelationAdultOneEdit = "Self";
                    EditDobSelf.setText(strSelfAgeEditText);
                    EdtNameSelf.setEnabled(false);
                    EditDobSelf.setEnabled(false);
                    if (strGenderSpinner.equals("Female")) {
                        strGender = "F";
                        strEditGenderSelf = "Female";
                    } else {
                        strGender = "M";
                        strEditGenderSelf = "Male";
                    }
                    GenderLiner.setClickable(false);
                    EditGenderSelf.setText(strEditGenderSelf);
                }
                if (strCheckBoxSpouse.equals("Checked")) {
                    if (strGenderSpinner.equals("Female")) {
                        strGender = "M";
                        strSpouseGenderEdit = "Male";
                    } else {
                        strGender = "F";
                        strSpouseGenderEdit = "Female";
                    }
                    strEdtNameSelf="";
                    strBMIEdit = strSpouseBMIEdit;
                    strEditOccupationSelf = strSpouseOccupationEdit;
                    strEditGenderSelf = strSpouseGenderEdit;
                    strRelationAdultOneEdit = strRelationEditSpouse;
                    strSelfAgeEditText = strSpouseAgeEditText;
                    selectYearAdult=selectYearSecondAdult;
                    EditDobSelf.setText(strSelfAgeEditText);
                    EditGenderSelf.setText(strEditGenderSelf);
                    RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                    EditOccupationSelf.setText(strEditOccupationSelf);
                    BMIEdit.setText(strBMIEdit);
                    EdtNameSelf.setEnabled(true);
                    EditDobSelf.setEnabled(true);
                    GenderLiner.setClickable(false);

                }
                if (strCheckBoxMother.equals("Checked")) {
                    strEdtNameSelf="";
                    strBMIEdit = strBMIMotherEdit;
                    strEditOccupationSelf = strMotherOccupationEdit;
                    strEditGenderSelf = strMotherGenderEdit;
                    strRelationAdultOneEdit = strMotherRelationShipEdit;
                    strSelfAgeEditText = strMotherAgeEditText;
                    selectYearAdult=selectYearMotherAdult;
                    EditDobSelf.setText(strSelfAgeEditText);
                    EditGenderSelf.setText(strEditGenderSelf);
                    RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                    EditOccupationSelf.setText(strEditOccupationSelf);
                    BMIEdit.setText(strBMIEdit);
                    EdtNameSelf.setEnabled(true);
                }
                if (strCheckBoxFather.equals("Checked")) {
                    strEdtNameSelf="";
                    strBMIEdit = strBMIFatherEdit;
                    strEditOccupationSelf = strFatherOccupationEdit;
                    strEditGenderSelf = strFatherGenderEditTet;
                    strRelationAdultOneEdit = strRelationFatherEdit;
                    strSelfAgeEditText = strFatherAgeEditText;
                    selectYearAdult=selectYearFatherAdult;
                    EditDobSelf.setText(strSelfAgeEditText);
                    EditGenderSelf.setText(strEditGenderSelf);
                    RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                    EditOccupationSelf.setText(strEditOccupationSelf);
                    BMIEdit.setText(strBMIEdit);
                    EdtNameSelf.setEnabled(true);
                }
                if (strCheckBoxMotherLaw.equals("Checked")) {
                    strEdtNameSelf="";
                    strBMIEdit = strBMIMotherLawEdit;
                    strEditOccupationSelf = strOccupationEditMotherLaw;
                    strEditGenderSelf = strMotherGenderEdit;
                    strRelationAdultOneEdit = strRelationMotherLawEdit;
                    strSelfAgeEditText = strMotherLawAgeEditText;
                    selectYearAdult=selectMotherLawAdult;
                    EditDobSelf.setText(strSelfAgeEditText);
                    EditGenderSelf.setText(strEditGenderSelf);
                    RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                    EditOccupationSelf.setText(strEditOccupationSelf);
                    BMIEdit.setText(strBMIEdit);
                    EdtNameSelf.setEnabled(true);
                }
                if (strCheckBoxFatherLaw.equals("Checked")) {
                    strEdtNameSelf="";
                    strBMIEdit = strFatherLawBMIEdit;
                    strEditOccupationSelf = strOccupationFatherLawEdit;
                    strEditGenderSelf = strFatherLawGenderEditText;
                    strRelationAdultOneEdit = strRelationEditTextFatherLaw;
                    strSelfAgeEditText = strFatherLawAgeEditText;
                    selectYearAdult=selectFatherLawAdult;
                    EditDobSelf.setText(strSelfAgeEditText);
                    EditGenderSelf.setText(strEditGenderSelf);
                    RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                    EditOccupationSelf.setText(strEditOccupationSelf);
                    BMIEdit.setText(strBMIEdit);
                    EdtNameSelf.setEnabled(true);
                }

            }
            else {
                if (strCheckBoxSelf.equals("Checked") && strCheckBoxSpouse.equals("Checked")) {
                    strRelationAdultOneEdit = "Self";
                    RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                    EdtNameSelf.setEnabled(false);
                    EditDobSelf.setEnabled(false);
                    if (strGenderSpinner.equals("Female")) {
                        strGender = "F";
                        strEditGenderSelf = "Female";
                        strSpouseGenderEdit = "Male";
                    } else {
                        strGender = "M";
                        strEditGenderSelf = "Male";
                        strSpouseGenderEdit = "Female";
                    }
                    GenderLiner.setClickable(false);
                    EditGenderSelf.setText(strEditGenderSelf);
                    SpouseGenderEdit.setText(strSpouseGenderEdit);
                    SpouseGenderLiner.setClickable(false);
                } else {
                    if (strCheckBoxSelf.equals("Checked") || strCheckBoxSpouse.equals("Checked")) {
                        if (strCheckBoxSpouse.equals("Checked")) {
                            if (strGenderSpinner.equals("Female")) {
                                strGender = "M";
                                strSpouseGenderEdit = "Male";
                            } else {
                                strGender = "F";
                                strSpouseGenderEdit = "Female";
                            }
                            strEditGenderSelf=strSpouseGenderEdit;
                            strSelfAgeEditText = strSpouseAgeEditText;
                            selectYearAdult = selectYearSecondAdult;
                            strRelationAdultOneEdit = "Spouse";
                            strRelationEditSpouse = "Spouse";
                            strRelationAdultOneEdit = strRelationEditSpouse;
                            EditDobSelf.setText(strSelfAgeEditText);
                            EditGenderSelf.setText(strEditGenderSelf);
                            RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                            EditOccupationSelf.setText(strEditOccupationSelf);
                            BMIEdit.setText(strBMIEdit);
                            EdtNameSelf.setEnabled(true);
                            EditDobSelf.setEnabled(true);
                            GenderLiner.setClickable(false);
                        } else {
                            strRelationAdultOneEdit = "Self";
                            RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                            EdtNameSelf.setEnabled(false);
                            EditDobSelf.setEnabled(false);
                            if (strGenderSpinner.equals("Female")) {
                                strEditGenderSelf = "Female";
                            } else {
                                strEditGenderSelf = "Male";
                            }
                            GenderLiner.setClickable(false);
                            EditGenderSelf.setText(strEditGenderSelf);
                        }
                    }
                }
            }
            //Proposer
            proposerEdtName.setText(strProposerEdtName);
            proposerEditDob.setText(strProposerEditDob);
            proposerEditFt.setText(strProposerEditFt);
            proposerEditInches.setText(strProposerEditInches);
            EditGenderProposer.setText(strEditGenderProposer);
            EditOccupationProposer.setText(strEditOccupationProposer);
            ProposerRelationEdit.setText(strProposerRelationEdit);


            NomineeGenderEdit.setText(strNomineeGenderEdit);
            EditGenderSelf.setText(strEditGenderSelf);
            EditOccupationSelf.setText(strEditOccupationSelf);
            RelationAdultOneEdit.setText(strRelationAdultOneEdit);
            EditFtSelf.setText(strEditFtSelf);
            EditInchesSelf.setText(strEditInchesSelf);
            NomineeRelationEdit.setText(strNomineeRelationEdit);
            NomineeDobEdit.setText(strNomineeDobEdit);

            //2nd adult
            SpouseGenderEdit.setText(strSpouseGenderEdit);
            SpouseOccupationEdit.setText(strSpouseOccupationEdit);
            FtSpouseEdit.setText(strFtSpouseEdit);
            InchesSpouseEdit.setText(strInchesSpouseEdit);

            //1st child
            strGenderChildOneEdit = "Select Gender";
            GenderChildOneEdit.setText(strGenderChildOneEdit);
            str_oneFtSpinner = "Ft";
            str_oneInchesSpinner = "Inches";
            oneFtSpinner.setText(str_oneFtSpinner);
            oneInchesSpinner.setText(str_oneInchesSpinner);

            //2ndchild
            str_twoGenderSpinner = "Select Gender";
            twoGenderSpinner.setText(str_twoGenderSpinner);
            str_twoFtSpinner = "Ft";
            str_twoInchesSpinner = "Inches";
            twoFtSpinner.setText(str_twoFtSpinner);
            twoInchesSpinner.setText(str_twoInchesSpinner);

            //3rdchild
            str_thirdGenderSpinner = "Select Gender";
            thirdGenderSpinner.setText(str_thirdGenderSpinner);
            str_thirdFtSpinner = "Ft";
            str_thirdInchesSpinner = "Inches";
            thirdFtSpinner.setText(str_thirdFtSpinner);
            thirdInchesSpinner.setText(str_thirdInchesSpinner);

            //4th child
            str_fourGenderSpinner = "Select Gender";
            fourGenderSpinner.setText(str_fourGenderSpinner);
            str_fourFtSpinner = "Ft";
            str_fourInchesSpinner = "Inches";
            fourFtSpinner.setText(str_fourFtSpinner);
            fourInchesSpinner.setText(str_fourInchesSpinner);


        }
        else {
            if (strProposerEditDob.equals("") || strProposerEditDob.equals("strProposerEditDob")) {
                strProposerEditDob = "Select Dob";
            }
            if (strEditGenderProposer.equals("M")) {
                strEditGenderProposer = "Male";
            } else if (strEditGenderProposer.equals("F")) {
                strEditGenderProposer = "Female";
            } else {
                if (strEditGenderProposer.equals("Male")) {
                    strEditGenderProposer = "Male";
                } else if (strEditGenderProposer.equals("Female")) {
                    strEditGenderProposer = "Female";
                } else {
                    strEditGenderProposer = "Select Gender";
                }

            }

            if (strEditGenderSelf.equals("M")) {
                strEditGenderSelf = "Male";
            } else if (strEditGenderSelf.equals("F")) {
                strEditGenderSelf = "Female";
            } else {
                if (strEditGenderSelf.equals("Male")) {
                    strEditGenderSelf = "Male";
                } else if (strEditGenderSelf.equals("Female")) {
                    strEditGenderSelf = "Female";
                } else {
                    strEditGenderSelf = "Select Gender";
                }
            }
            if (strSpouseGenderEdit.equals("M")) {
                strSpouseGenderEdit = "Male";
            } else if (strSpouseGenderEdit.equals("F")) {
                strSpouseGenderEdit = "Female";
            } else {
                if (strSpouseGenderEdit.equals("Male")) {
                    strSpouseGenderEdit = "Male";
                } else if (strSpouseGenderEdit.equals("Female")) {
                    strSpouseGenderEdit = "Female";
                } else {
                    strSpouseGenderEdit = "Select Gender";
                }
            }
            if (strGenderChildOneEdit.equals("M")) {
                strGenderChildOneEdit = "Male";
            } else if (strGenderChildOneEdit.equals("F")) {
                strGenderChildOneEdit = "Female";
            } else {
                if (strGenderChildOneEdit.equals("Male")) {
                    strGenderChildOneEdit = "Male";
                } else if (strGenderChildOneEdit.equals("Female")) {
                    strGenderChildOneEdit = "Female";
                } else {
                    strGenderChildOneEdit = "Select Gender";
                }
            }
            if (str_twoGenderSpinner.equals("M")) {
                str_twoGenderSpinner = "Male";
            } else if (str_twoGenderSpinner.equals("F")) {
                str_twoGenderSpinner = "Female";
            } else {
                if (str_twoGenderSpinner.equals("Male")) {
                    str_twoGenderSpinner = "Male";
                } else if (str_twoGenderSpinner.equals("Female")) {
                    str_twoGenderSpinner = "Female";
                } else {
                    str_twoGenderSpinner = "Select Gender";
                }
            }
            if (str_thirdGenderSpinner.equals("M")) {
                str_thirdGenderSpinner = "Male";
            } else if (str_thirdGenderSpinner.equals("F")) {
                str_thirdGenderSpinner = "Female";
            } else {
                if (str_thirdGenderSpinner.equals("Male")) {
                    str_thirdGenderSpinner = "Male";
                } else if (str_thirdGenderSpinner.equals("Female")) {
                    str_thirdGenderSpinner = "Female";
                } else {
                    str_thirdGenderSpinner = "Select Gender";
                }
            }
            if (str_fourGenderSpinner.equals("M")) {
                str_fourGenderSpinner = "Male";
            } else if (str_fourGenderSpinner.equals("F")) {
                str_fourGenderSpinner = "Female";
            } else {
                if (str_fourGenderSpinner.equals("Male")) {
                    str_fourGenderSpinner = "Male";
                } else if (str_fourGenderSpinner.equals("Female")) {
                    str_fourGenderSpinner = "Female";
                } else {
                    str_fourGenderSpinner = "Select Gender";
                }
            }



            proposerEdtName.setText(strProposerEdtName);
            proposerEditDob.setText(strProposerEditDob);
            proposerEditFt.setText(strProposerEditFt);
            proposerEditInches.setText(strProposerEditInches);
            EditGenderProposer.setText(strEditGenderProposer);
            EditOccupationProposer.setText(strEditOccupationProposer);
            ProposerRelationEdit.setText(strProposerRelationEdit);
            ProposerBMIEdit.setText(strProposerBMIEdit);
            WeightEditProposer.setText(strWeightEditProposer);

            EdtNameSelf.setText(strEdtNameSelf);
            EmailIDEditSelf.setText(strEmailIDEditSelf);
            PermanentAddressEdit.setText(strPermanentAddressEdit);
            PermanentAddressEdit2.setText(strPermanentAddressEdit2);

            if (strswitch.equals("False")) {
                SwitchButton.setChecked(false);
                SwitchButton.setClickable(true);
                SwitchButtonProposer.setChecked(false);
                SwitchButtonProposer.setClickable(true);
            } else {
                SwitchButton.setChecked(true);
                SwitchButtonProposer.setChecked(true);
                SwitchButtonProposer.setClickable(false);
            }

//            if (permAndCorresAddSame.equals("Y")){
//                strswitch = "True";
//                SwitchButton.setChecked(true);
//                SwitchButton.setClickable(false);
//                SwitchButtonProposer.setChecked(true);
//                SwitchButtonProposer.setClickable(false);
//            }else{
//                strswitch = "False";
//                SwitchButton.setChecked(false);
//                SwitchButton.setClickable(true);
//                SwitchButtonProposer.setChecked(false);
//                SwitchButtonProposer.setClickable(true);
//            }
            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")) {
                strRelationAdultOneEdit = "Self";
                RelationAdultOneEdit.setText(strRelationAdultOneEdit);
            }else{
                if (strCheckBoxSelf.equals("Checked")||strCheckBoxSpouse.equals("Checked")){
                 if (strCheckBoxSpouse.equals("Checked")) {
                    strRelationAdultOneEdit = "Spouse";
                    strRelationEditSpouse = "Spouse";
                    strRelationAdultOneEdit = strRelationEditSpouse;
                    EditDobSelf.setText(strSelfAgeEditText);
                    EditGenderSelf.setText(strEditGenderSelf);
                    RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                    EditOccupationSelf.setText(strEditOccupationSelf);
                    BMIEdit.setText(strBMIEdit);
                } else{
                     strRelationAdultOneEdit = "Self";
                     RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                 }
                }

            }

            CorrespondenceAddressEdit.setText(strCorrespondenceAddressEdit);
            CorrespondenceAddressEdit2.setText(strCorrespondenceAddressEdit2);
            PinCodeEdit.setText(strPinCodeEdit);
            LandMarkEditProposer.setText(strLandMarkEdit);
            LandMarkEdit.setText(strLandMarkEdit);
            WeightEditSelf.setText(strWeightEditSelf);
            BMIEdit.setText(strBMIEdit);
            NomineeName.setText(strNomineeName);
            EditGenderSelf.setText(strEditGenderSelf);
            EditOccupationSelf.setText(strEditOccupationSelf);
            RelationAdultOneEdit.setText(strRelationAdultOneEdit);
            EditFtSelf.setText(strEditFtSelf);
            EditInchesSelf.setText(strEditInchesSelf);
            NomineeRelationEdit.setText(strNomineeRelationEdit);
            NomineeDobEdit.setText(strNomineeDobEdit);
            NomineeGenderEdit.setText(strNomineeGenderEdit);
            StateEdit.setText(strStateEdit);
            CityEdit.setText(strCityEdit);
            //2nd adult
            SpouseGenderEdit.setText(strSpouseGenderEdit);
            SpouseOccupationEdit.setText(strSpouseOccupationEdit);
            FtSpouseEdit.setText(strFtSpouseEdit);
            InchesSpouseEdit.setText(strInchesSpouseEdit);
            SpouseNameEditText.setText(strSpouseNameEditText);
            WeightEditSpouse.setText(strWeightEditSpouse);
            RelationEditSpouse.setText(strRelationEditSpouse);
            SpouseBMIEdit.setText(strSpouseBMIEdit);
            //1st child
            GenderChildOneEdit.setText(strGenderChildOneEdit);
            oneFtSpinner.setText(str_oneFtSpinner);
            oneInchesSpinner.setText(str_oneInchesSpinner);
            ChildOneNameEdit.setText(strChildOneNameEdit);
            oneWeightEdit.setText(str_oneWeightEdit);
            OccupationEditChildOne.setText(strOccupationEditChildOne);
            RelationChildEdit.setText(strRelationChildEdit);
            BMIChildEdit.setText(strBMIChildEdit);
            //2ndchild
            twoGenderSpinner.setText(str_twoGenderSpinner);
            twoFtSpinner.setText(str_twoFtSpinner);
            twoInchesSpinner.setText(str_twoInchesSpinner);
            SecondChildNameEdit.setText(strSecondChildNameEdit);
            twoWeightEdit.setText(strtwoWeightEdit);
            twoOccupationSpinner.setText(str_twoOccupationSpinner);
            RelationChildTwoEdit.setText(strRelationChildTwoEdit);
            BMIChildTwoEdit.setText(strBMIChildTwoEdit);
            //3rdchild
            thirdGenderSpinner.setText(str_thirdGenderSpinner);
            thirdFtSpinner.setText(str_thirdFtSpinner);
            thirdInchesSpinner.setText(str_thirdInchesSpinner);
            ThirdChildNameEdit.setText(strThirdChildNameEdit);
            thirdWeightEdit.setText(str_thirdWeightEdit);
            thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
            RelationChildThreeEdit.setText(strRelationChildThreeEdit);
            BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
            //4th child
            fourGenderSpinner.setText(str_fourGenderSpinner);
            fourFtSpinner.setText(str_fourFtSpinner);
            fourInchesSpinner.setText(str_fourInchesSpinner);
            FourChildNameEdit.setText(strFourChildNameEdit);
            FourWeightEdit.setText(strFourWeightEdit);
            fourOccupationSpinner.setText(str_fourOccupationSpinner);
            RelationFourChildEdit.setText(strRelationFourChildEdit);
            BMIFourChildEdit.setText(strBMIFourChildEdit);
            //Mother
            MotherFeetEditText.setText(strMotherFeetEditText);
            InchesMotherEdit.setText(strInchesMotherEdit);
            MotherOccupationEdit.setText(strMotherOccupationEdit);
            MotherEditTextName.setText(strMotherEditTextName);
            MotherWeightEdit.setText(strMotherWeightEdit);
            MotherGenderEdit.setText(strMotherGenderEdit);
            MotherRelationShipEdit.setText(strMotherRelationShipEdit);
            BMIMotherEdit.setText(strBMIMotherEdit);
            //Father
            InchesFatherEdit.setText(strInchesFatherEdit);
            FeetFatherEdit.setText(strFeetFatherEdit);
            FatherOccupationEdit.setText(strFatherOccupationEdit);
            FatherEditTextName.setText(strFatherEditTextName);
            FatherWeightEdit.setText(strFatherWeightEdit);
            FatherGenderEditTet.setText(strFatherGenderEditTet);
            RelationFatherEdit.setText(strRelationFatherEdit);
            BMIFatherEdit.setText(strBMIFatherEdit);
            //MotherLaw
            OccupationEditMotherLaw.setText(strOccupationEditMotherLaw);
            FeetEditTextMotherLaw.setText(strFeetEditTextMotherLaw);
            InchesEditTextMotherLaw.setText(strInchesEditTextMotherLaw);
            MotherLawEditText.setText(strMotherLawEditText);
            WeightMotherLawEdit.setText(strWeightMotherLawEdit);
            GenderMotherLawEdit.setText(strMotherGenderEdit);
            RelationMotherLawEdit.setText(strRelationMotherLawEdit);
            BMIMotherLawEdit.setText(strBMIMotherLawEdit);
            //FatherLaw
            OccupationFatherLawEdit.setText(strOccupationFatherLawEdit);
            EditFeetFatherLaw.setText(strEditFeetFatherLaw);
            EditInchesFatherLaw.setText(strEditInchesFatherLaw);
            FatherLawNameEdit.setText(strFatherLawNameEdit);
            FatherLawWeightEdit.setText(strFatherLawWeightEdit);
            FatherLawGenderEditText.setText(strFatherLawGenderEditText);
            RelationEditTextFatherLaw.setText(strRelationEditTextFatherLaw);
            FatherLawBMIEdit.setText(strFatherLawBMIEdit);

            if (selectNomineeYear <= 5) {
                appointeeNominee.setVisibility(View.VISIBLE);
                appointeeNomineeDobEdit.setText(strAppointeeNomineeDobEdit);
                appointeeNomineeName.setText(strAppointeeNomineeName);
                AppointeeGenderEdit.setText(strAppointeeGenderEdit);
            } else {
                appointeeNominee.setVisibility(View.GONE);
            }
        }


        proposerDownArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proposerLiner.setVisibility(View.VISIBLE);
                proposerUpArrowImg.setVisibility(View.VISIBLE);
                proposerDownArrowImg.setVisibility(View.GONE);
            }
        });
        proposerUpArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proposerLiner.setVisibility(View.GONE);
                proposerUpArrowImg.setVisibility(View.GONE);
                proposerDownArrowImg.setVisibility(View.VISIBLE);
            }
        });

        selfDownArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selfLiner.setVisibility(View.VISIBLE);
                selfUpArrowImg.setVisibility(View.VISIBLE);
                selfDownArrowImg.setVisibility(View.GONE);
            }
        });
        selfUpArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selfLiner.setVisibility(View.GONE);
                selfUpArrowImg.setVisibility(View.GONE);
                selfDownArrowImg.setVisibility(View.VISIBLE);
            }
        });
        calendarIconProposer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showProposertCalender();
            }
        });
        SwitchButtonProposer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchButtonProposer.isChecked()) {
                    strPermanentAddressEdit = PermanentAddressEditProposer.getText().toString();
                    strPermanentAddressEdit2 = PermanentAddressEdit2Proposer.getText().toString();
                    if (strPermanentAddressEdit.equals("") && strPermanentAddressEdit2.equals("")) {
                        SwitchButtonProposer.setChecked(false);
                        strswitch = "False";
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter Permanent Address Line 1 & 2", Toast.LENGTH_SHORT).show();
                    } else if (strPermanentAddressEdit.equals("") || strPermanentAddressEdit2.equals("")) {
                        SwitchButtonProposer.setChecked(false);
                        strswitch = "False";
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter Permanent Address Line 1 & 2", Toast.LENGTH_SHORT).show();
                    } else {
                        SwitchButtonProposer.setChecked(true);
                        strswitch = "True";
                        CorrespondenceAddressEditProposer.setClickable(false);
                        CorrespondenceAddressEdit2Proposer.setClickable(false);
                        CorrespondenceAddressEditProposer.setEnabled(false);
                        CorrespondenceAddressEdit2Proposer.setEnabled(false);
                        strCorrespondenceAddressEdit = strPermanentAddressEdit;
                        strCorrespondenceAddressEdit2 = strPermanentAddressEdit2;
                        CorrespondenceAddressEditProposer.setText(strCorrespondenceAddressEdit);
                        CorrespondenceAddressEdit2Proposer.setText(strCorrespondenceAddressEdit2);
                    }
                } else {
                    strswitch = "False";
                    SwitchButtonProposer.setChecked(false);
                    strCorrespondenceAddressEdit = "";
                    strCorrespondenceAddressEdit2 = "";
                    CorrespondenceAddressEditProposer.setText(strCorrespondenceAddressEdit);
                    CorrespondenceAddressEdit2Proposer.setText(strCorrespondenceAddressEdit2);
                    CorrespondenceAddressEditProposer.setClickable(true);
                    CorrespondenceAddressEdit2Proposer.setClickable(true);
                    CorrespondenceAddressEditProposer.setEnabled(true);
                    CorrespondenceAddressEdit2Proposer.setEnabled(true);
                }
            }
        });
//        proposerGenderLiner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
//                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("Select Gender");
//                items1.add("Male");
//                items1.add("Female");
//                singlePicker.setPicker(items1);
//                singlePicker.setCyclic(false);
//                singlePicker.setSelectOptions(0);
//                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                    @Override
//                    public void onOptionsSelect(int options1, int option2, int options3) {
//                        strEditGenderProposer = items1.get(options1);
//                        EditGenderProposer.setText(strEditGenderProposer);
////                        if (!strEditGenderProposer.equals("Select Gender")) {
////                            if (str_edit_dob3String != null) {
////                                try {
////                                    SelectDate = dateFormatter.parse(strProposerEditDob);
////                                    CurrentDate = dateFormatter.parse(today);
////                                    long selectNewDate = SelectDate.getTime();
////                                    long TodayendDate = CurrentDate.getTime();
////                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
////                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
////                                        selectYearProposer = period.getYears();
////                                        SelectMonth = period.getMonths();
////                                        SelectDays = period.getDays();
////                                    }
////                                } catch (ParseException e) {
////                                    e.printStackTrace();
////                                }
////                                if (selectYearProposer < 18 || (selectYearProposer > 55)) {
//////                                    Toast.makeText(PersonalInformationCHI.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
////                                    strProposerEditDob = "Select Dob";
////                                    proposerEditDob.setText(strProposerEditDob);
////                                } else {
////                                    proposerEditDob.setText(strProposerEditDob);
////                                }
////                            }
////                        }
//
//                    }
//                });
//                singlePicker.show();
//            }
//        });
        proposerLinerOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Occupation");
                items1.add("Doctors");
                items1.add("Lawyers");
                items1.add("Accounts");
                items1.add("Architects");
                items1.add("Consulting engineers");
                items1.add("Teachers");
                items1.add("Administrative Function and persons primarily engaged in occupation of similar Hazard");
                items1.add("Bankers Persons engaged in clerical function");
                items1.add("Bureaucrats");
                items1.add("Housewife");
                items1.add("Student");
                items1.add("Shopkeeper");
                items1.add("Writer");
                items1.add("Fashion Designer");
                items1.add("Desk job");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strEditOccupationProposer = items1.get(options1);
                        EditOccupationProposer.setText(strEditOccupationProposer);
                        if (!strEditOccupationProposer.equals("Occupation")) {
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strProposerEditDob);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearProposer = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearProposer < 18 || (selectYearProposer > 55)) {
//                                    Toast.makeText(PersonalInformationCHI.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                                    strProposerEditDob = "Select Dob";
                                    proposerEditDob.setText(strProposerEditDob);
                                } else {
                                    proposerEditDob.setText(strProposerEditDob);
                                }
                            }
                        }

                    }
                });
                singlePicker.show();
            }
        });
        ProposerFtLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");
                ft.add("0");
                ft.add("1");
                ft.add("2");
                ft.add("3");
                ft.add("4");
                ft.add("5");
                ft.add("6");
                ft.add("7");
                ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strProposerEditFt = ft.get(options1);
                        proposerEditFt.setText(strProposerEditFt);
                        strWeightEditProposer = WeightEditProposer.getText().toString();
                        if (!strProposerEditFt.equals("Ft") && !strProposerEditInches.equals("Inches") && !strWeightEditProposer.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strProposerEditFt, strProposerEditInches);
                            kg = Double.parseDouble(strWeightEditProposer);
                            BMI = calculateBMI(kg, cm);
                            strProposerBMIEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strProposerBMIEdit) >= 16.0 && Double.parseDouble(strProposerBMIEdit) <= 33.0) {
                                ProposerBMIEdit.setText(strProposerBMIEdit);
                            } else {
                                ProposerBMIEdit.setText(strProposerBMIEdit);
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        ProposerLinerInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");
                inches.add("0");
                inches.add("1");
                inches.add("2");
                inches.add("3");
                inches.add("4");
                inches.add("5");
                inches.add("6");
                inches.add("7");
                inches.add("8");
                inches.add("9");
                inches.add("10");
                inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strProposerEditInches = inches.get(options1);
                        proposerEditInches.setText(strProposerEditInches);
                        strWeightEditProposer = WeightEditProposer.getText().toString();
                        if (!strProposerEditFt.equals("Ft") && !strProposerEditInches.equals("Inches") && !strWeightEditProposer.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strProposerEditFt, strProposerEditInches);
                            kg = Double.parseDouble(strWeightEditProposer);
                            BMI = calculateBMI(kg, cm);
                            strProposerBMIEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strProposerBMIEdit) >= 16.0 && Double.parseDouble(strProposerBMIEdit) <= 33.0) {
                                ProposerBMIEdit.setText(strProposerBMIEdit);
                            } else {
                                ProposerBMIEdit.setText(strProposerBMIEdit);
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        WeightEditProposer.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 2) {
                    strWeightEditProposer = WeightEditProposer.getText().toString();
                    if (!strProposerEditFt.equals("Ft") && !strProposerEditInches.equals("Inches") && !strWeightEditProposer.equals("")) {
                        cm = convertFeetandInchesToCentimeter(strProposerEditFt, strProposerEditInches);
                        kg = Double.parseDouble(strWeightEditProposer);
                        BMI = calculateBMI(kg, cm);
                        strProposerBMIEdit = String.format("%.2f", BMI);
                        if (Double.parseDouble(strProposerBMIEdit) >= 16.0 && Double.parseDouble(strProposerBMIEdit) <= 33.0) {
                            ProposerBMIEdit.setText(strProposerBMIEdit);
                        } else {
                            ProposerBMIEdit.setText(strProposerBMIEdit);
                            showAgePopupNSTP();
//                            alertPopup();
//                            Toast.makeText(PersonalInformationCHI.this, "BMI is not normal", Toast.LENGTH_SHORT).show();
                        }
                    } else if (strProposerEditFt.equals("Ft") && strProposerEditInches.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Select Ft & Inches", Toast.LENGTH_SHORT).show();
                        ProposerBMIEdit.setText(strProposerBMIEdit);
                    } else if (strWeightEditProposer.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter 1st Adult Weight", Toast.LENGTH_SHORT).show();
                        ProposerBMIEdit.setText(strProposerBMIEdit);
                    } else {
                        strProposerBMIEdit = String.format("%.2f", BMI);
                        ProposerBMIEdit.setText(strProposerBMIEdit);
                    }
                }
            }
        });
        calendarIconSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showFirstCalender();
                if (!strCheckBoxSelf.equals("Checked")){
                    showFirstCalender();
                }
//                showFirstCalender();
            }
        });
//        GenderLiner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
//                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("Select Gender");
//                items1.add("Male");
//                items1.add("Female");
//                singlePicker.setPicker(items1);
//                singlePicker.setCyclic(false);
//                singlePicker.setSelectOptions(0);
//                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                    @Override
//                    public void onOptionsSelect(int options1, int option2, int options3) {
//                        strEditGenderSelf = items1.get(options1);
//                        EditGenderSelf.setText(strEditGenderSelf);
//                        if (!strEditGenderSelf.equals("Select Gender")) {
//                            if (str_edit_dob3String != null) {
//                                try {
//                                    SelectDate = dateFormatter.parse(strEditGenderSelf);
//                                    CurrentDate = dateFormatter.parse(today);
//                                    long selectNewDate = SelectDate.getTime();
//                                    long TodayendDate = CurrentDate.getTime();
//                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
//                                        selectYearAdult = period.getYears();
//                                        SelectMonth = period.getMonths();
//                                        SelectDays = period.getDays();
//                                    }
//                                } catch (ParseException e) {
//                                    e.printStackTrace();
//                                }
//                                if (selectYearAdult < 18 || (selectYearAdult > 55)) {
////                                    Toast.makeText(PersonalInformationCHI.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
//                                    EditGenderSelf.setText("");
//                                    showAgePopupNSTP();
//                                }
//                            }
//                        }
//
//                    }
//                });
//                singlePicker.show();
//            }
//        });
        LinerOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Occupation");
                items1.add("Doctors");
                items1.add("Lawyers");
                items1.add("Accounts");
                items1.add("Architects");
                items1.add("Consulting engineers");
                items1.add("Teachers");
                items1.add("Administrative Function and persons primarily engaged in occupation of similar Hazard");
                items1.add("Bankers Persons engaged in clerical function");
                items1.add("Bureaucrats");
                items1.add("Housewife");
                items1.add("Student");
                items1.add("Shopkeeper");
                items1.add("Writer");
                items1.add("Fashion Designer");
                items1.add("Desk job");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strEditOccupationSelf = items1.get(options1);
                        EditOccupationSelf.setText(strEditOccupationSelf);
                        if (!strEditOccupationSelf.equals("Occupation")) {
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strSelfAgeEditText);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearAdult = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearAdult < 18 || (selectYearAdult > 55)) {
//                                    Toast.makeText(PersonalInformationCHI.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                                    EditDobSelf.setText("");
                                    showAgePopupNSTP();
                                }
                            }
                        }

                    }
                });
                singlePicker.show();
            }
        });

        PinCodeEditProposer.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                Is_Valid_refer(PinCodeEditProposer);
            }

            public void Is_Valid_refer(EditText edt_refer) {
                if (edt_refer.length() == 6) {
                    strPinCodeEdit = edt_refer.getText().toString();
                    pincodeURL();
                } else if (edt_refer.getText().toString().equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Please Enter 6 Digit PinCode/ZipCode", Toast.LENGTH_SHORT).show();
                }
            }
        });


        PinCodeEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                Is_Valid_refer(PinCodeEdit);
            }

            public void Is_Valid_refer(EditText edt_refer) {
                if (edt_refer.length() == 6) {
                    strPinCodeEdit = edt_refer.getText().toString();
                    pincodeURL();
                } else if (edt_refer.getText().toString().equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Please Enter 6 Digit PinCode/ZipCode", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ftLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");
                ft.add("0");
                ft.add("1");
                ft.add("2");
                ft.add("3");
                ft.add("4");
                ft.add("5");
                ft.add("6");
                ft.add("7");
                ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strEditFtSelf = ft.get(options1);
                        EditFtSelf.setText(strEditFtSelf);
                        strWeightEditSelf = WeightEditSelf.getText().toString();
                        if (!strEditFtSelf.equals("Ft") && !strEditInchesSelf.equals("Inches") && !strWeightEditSelf.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strEditFtSelf, strEditInchesSelf);
                            kg = Double.parseDouble(strWeightEditSelf);
                            BMI = calculateBMI(kg, cm);
                            strBMIEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIEdit) >= 16.0 && Double.parseDouble(strBMIEdit) <= 33.0) {
                                BMIEdit.setText(strBMIEdit);
                            } else {
                                BMIEdit.setText(strBMIEdit);
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        LinerInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");
                inches.add("0");
                inches.add("1");
                inches.add("2");
                inches.add("3");
                inches.add("4");
                inches.add("5");
                inches.add("6");
                inches.add("7");
                inches.add("8");
                inches.add("9");
                inches.add("10");
                inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strEditInchesSelf = inches.get(options1);
                        EditInchesSelf.setText(strEditInchesSelf);
                        strWeightEditSelf = WeightEditSelf.getText().toString();
                        if (!strEditFtSelf.equals("Ft") && !strEditInchesSelf.equals("Inches") && !strWeightEditSelf.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strEditFtSelf, strEditInchesSelf);
                            kg = Double.parseDouble(strWeightEditSelf);
                            BMI = calculateBMI(kg, cm);
                            strBMIEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIEdit) >= 16.0 && Double.parseDouble(strBMIEdit) <= 33.0) {
                                BMIEdit.setText(strBMIEdit);
                            } else {
                                BMIEdit.setText(strBMIEdit);
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        WeightEditSelf.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 2) {
                    strWeightEditSelf = WeightEditSelf.getText().toString();
                    if (!strEditFtSelf.equals("Ft") && !strEditInchesSelf.equals("Inches") && !strWeightEditSelf.equals("")) {
                        cm = convertFeetandInchesToCentimeter(strEditFtSelf, strEditInchesSelf);
                        kg = Double.parseDouble(strWeightEditSelf);
                        BMI = calculateBMI(kg, cm);
                        strBMIEdit = String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIEdit) >= 16.0 && Double.parseDouble(strBMIEdit) <= 33.0) {
                            BMIEdit.setText(strBMIEdit);
                        } else {
                            BMIEdit.setText(strBMIEdit);
                            showAgePopupNSTP();
//                            alertPopup();
//                            Toast.makeText(PersonalInformationCHI.this, "BMI is not normal", Toast.LENGTH_SHORT).show();
                        }
                    } else if (strEditFtSelf.equals("Ft") && strEditInchesSelf.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Select Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIEdit.setText(strBMIEdit);
                    } else if (strWeightEditSelf.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter 1st Adult Weight", Toast.LENGTH_SHORT).show();
                        BMIEdit.setText(strBMIEdit);
                    } else {
                        strBMIEdit = String.format("%.2f", BMI);
                        BMIEdit.setText(strBMIEdit);
                    }
                }
            }
        });
        SwitchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchButton.isChecked()) {
                    strPermanentAddressEdit = PermanentAddressEdit.getText().toString();
                    strPermanentAddressEdit2 = PermanentAddressEdit2.getText().toString();
                    if (strPermanentAddressEdit.equals("") && strPermanentAddressEdit2.equals("")) {
                        SwitchButton.setChecked(false);
                        strswitch = "False";
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter Permanent Address Line 1 & 2", Toast.LENGTH_SHORT).show();
                    } else if (strPermanentAddressEdit.equals("") || strPermanentAddressEdit2.equals("")) {
                        SwitchButton.setChecked(false);
                        strswitch = "False";
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter Permanent Address Line 1 & 2", Toast.LENGTH_SHORT).show();
                    } else {
                        SwitchButton.setChecked(true);
                        strswitch = "True";
                        CorrespondenceAddressEdit.setClickable(false);
                        CorrespondenceAddressEdit2.setClickable(false);
                        CorrespondenceAddressEdit.setEnabled(false);
                        CorrespondenceAddressEdit2.setEnabled(false);
                        strCorrespondenceAddressEdit = strPermanentAddressEdit;
                        strCorrespondenceAddressEdit2 = strPermanentAddressEdit2;
                        CorrespondenceAddressEdit.setText(strCorrespondenceAddressEdit);
                        CorrespondenceAddressEdit2.setText(strCorrespondenceAddressEdit2);
                    }
                } else {
                    strswitch = "False";
                    SwitchButton.setChecked(false);
                    strCorrespondenceAddressEdit = "";
                    strCorrespondenceAddressEdit2 = "";
                    CorrespondenceAddressEdit.setText(strCorrespondenceAddressEdit);
                    CorrespondenceAddressEdit2.setText(strCorrespondenceAddressEdit2);
                    CorrespondenceAddressEdit.setClickable(true);
                    CorrespondenceAddressEdit2.setClickable(true);
                    CorrespondenceAddressEdit.setEnabled(true);
                    CorrespondenceAddressEdit2.setEnabled(true);
                }
            }
        });

        SpouseDownArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpouseMainLiner.setVisibility(View.VISIBLE);
                SpouseDownArrowImg.setVisibility(View.GONE);
                SpouseUpArrowImg.setVisibility(View.VISIBLE);
            }
        });
        SpouseUpArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpouseMainLiner.setVisibility(View.GONE);
                SpouseDownArrowImg.setVisibility(View.VISIBLE);
                SpouseUpArrowImg.setVisibility(View.GONE);
            }
        });
//        SpouseGenderLiner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
//                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("Select Gender");
//                items1.add("Male");
//                items1.add("Female");
//                singlePicker.setPicker(items1);
//                singlePicker.setCyclic(false);
//                singlePicker.setSelectOptions(0);
//                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                    @Override
//                    public void onOptionsSelect(int options1, int option2, int options3) {
//                        strSpouseGenderEdit = items1.get(options1);
//                        SpouseGenderEdit.setText(strSpouseGenderEdit);
//                        if (!strSpouseGenderEdit.equals("Select Gender")) {
//                            if (str_edit_dob3String != null) {
//                                try {
//                                    SelectDate = dateFormatter.parse(strSpouseAgeEditText);
//                                    CurrentDate = dateFormatter.parse(today);
//                                    long selectNewDate = SelectDate.getTime();
//                                    long TodayendDate = CurrentDate.getTime();
//                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
//                                        selectYearSecondAdult = period.getYears();
//                                        SelectMonth = period.getMonths();
//                                        SelectDays = period.getDays();
//                                    }
//                                } catch (ParseException e) {
//                                    e.printStackTrace();
//                                }
//                                if (selectYearSecondAdult < 18 || (selectYearSecondAdult > 55)) {
////                                    Toast.makeText(PersonalInformationCHI.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
//                                    strSpouseAgeEditText = "Select Dob";
//                                    SpouseDobEdit.setText(strSpouseAgeEditText);
//                                    showAgePopupNSTP();
//                                }
//                            }
//                        }
//
//                    }
//                });
//                singlePicker.show();
//            }
//        });
        spouseOccupationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Occupation");
                items1.add("Doctors");
                items1.add("Lawyers");
                items1.add("Accounts");
                items1.add("Architects");
                items1.add("Consulting engineers");
                items1.add("Teachers");
                items1.add("Administrative Function and persons primarily engaged in occupation of similar Hazard");
                items1.add("Bankers Persons engaged in clerical function");
                items1.add("Bureaucrats");
                items1.add("Housewife");
                items1.add("Student");
                items1.add("Shopkeeper");
                items1.add("Writer");
                items1.add("Fashion Designer");
                items1.add("Desk job");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSpouseOccupationEdit = items1.get(options1);
                        SpouseOccupationEdit.setText(strSpouseOccupationEdit);
                        if (!strSpouseOccupationEdit.equals("Occupation")) {
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strSpouseAgeEditText);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearSecondAdult = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearSecondAdult < 18 || (selectYearSecondAdult > 55)) {
//                                    Toast.makeText(PersonalInformationCHI.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                                    strSpouseAgeEditText = "Select Dob";
                                    SpouseDobEdit.setText(strSpouseAgeEditText);
                                    showAgePopupNSTP();
                                }
                            }
                        }

                    }
                });
                singlePicker.show();
            }
        });
        FtSpouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");
                ft.add("0");
                ft.add("1");
                ft.add("2");
                ft.add("3");
                ft.add("4");
                ft.add("5");
                ft.add("6");
                ft.add("7");
                ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strFtSpouseEdit = ft.get(options1);
                        FtSpouseEdit.setText(strFtSpouseEdit);
                        strWeightEditSpouse = WeightEditSpouse.getText().toString();
                        if (!strFtSpouseEdit.equals("Ft") && !strInchesSpouseEdit.equals("Inches") && !strWeightEditSpouse.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strFtSpouseEdit, strInchesSpouseEdit);
                            kg = Double.parseDouble(strWeightEditSpouse);
                            BMI = calculateBMI(kg, cm);
                            strSpouseBMIEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strSpouseBMIEdit) >= 16.0 && Double.parseDouble(strSpouseBMIEdit) <= 33.0) {
                                SpouseBMIEdit.setText(strSpouseBMIEdit);
                            } else {
                                SpouseBMIEdit.setText(strSpouseBMIEdit);
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        InchesSpouseLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");
                inches.add("0");
                inches.add("1");
                inches.add("2");
                inches.add("3");
                inches.add("4");
                inches.add("5");
                inches.add("6");
                inches.add("7");
                inches.add("8");
                inches.add("9");
                inches.add("10");
                inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strInchesSpouseEdit = inches.get(options1);
                        InchesSpouseEdit.setText(strInchesSpouseEdit);
                        strWeightEditSpouse = WeightEditSpouse.getText().toString();
                        if (!strFtSpouseEdit.equals("Ft") && !strInchesSpouseEdit.equals("Inches") && !strWeightEditSpouse.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strFtSpouseEdit, strInchesSpouseEdit);
                            kg = Double.parseDouble(strWeightEditSpouse);
                            BMI = calculateBMI(kg, cm);
                            strSpouseBMIEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strSpouseBMIEdit) >= 16.0 && Double.parseDouble(strSpouseBMIEdit) <= 33.0) {
                                SpouseBMIEdit.setText(strSpouseBMIEdit);
                            } else {
                                SpouseBMIEdit.setText(strSpouseBMIEdit);
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        WeightEditSpouse.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 2) {
                    strWeightEditSpouse = WeightEditSpouse.getText().toString();
                    if (!strFtSpouseEdit.equals("Ft") && !strInchesSpouseEdit.equals("Inches") && !strWeightEditSpouse.equals("")) {
                        cm = convertFeetandInchesToCentimeter(strFtSpouseEdit, strInchesSpouseEdit);
                        kg = Double.parseDouble(strWeightEditSpouse);
                        BMI = calculateBMI(kg, cm);
                        strSpouseBMIEdit = String.format("%.2f", BMI);
                        if (Double.parseDouble(strSpouseBMIEdit) >= 16.0 && Double.parseDouble(strSpouseBMIEdit) <= 33.0) {
                            SpouseBMIEdit.setText(strSpouseBMIEdit);
                        } else {
                            SpouseBMIEdit.setText(strSpouseBMIEdit);
                            showAgePopupNSTP();
//                            alertPopup();
//                            Toast.makeText(PersonalInformationCHI.this, "2nd Adult BMI is not normal", Toast.LENGTH_SHORT).show();
                        }
                    } else if (strFtSpouseEdit.equals("Ft") && strInchesSpouseEdit.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Select 2nd Adult Ft & Inches", Toast.LENGTH_SHORT).show();
                        SpouseBMIEdit.setText(strSpouseBMIEdit);
                    } else if (strWeightEditSpouse.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter 2nd Adult Weight", Toast.LENGTH_SHORT).show();
                        SpouseBMIEdit.setText(strSpouseBMIEdit);
                    } else {
                        strSpouseBMIEdit = String.format("%.2f", BMI);
                        SpouseBMIEdit.setText(strSpouseBMIEdit);
                    }
                }
            }
        });

        //FirstChild
        ChildOneDownArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainChildOneLiner.setVisibility(View.VISIBLE);
                ChildOneDownArrow.setVisibility(View.GONE);
                ChildOneUpArrow.setVisibility(View.VISIBLE);
            }
        });
        ChildOneUpArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainChildOneLiner.setVisibility(View.GONE);
                ChildOneDownArrow.setVisibility(View.VISIBLE);
                ChildOneUpArrow.setVisibility(View.GONE);
            }
        });
        FirstSonAgeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFirstSonCalender();
            }
        });
        ChildOneGenderLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
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
                        strGenderChildOneEdit = items1.get(options1);
                        GenderChildOneEdit.setText(strGenderChildOneEdit);
                        if (strGenderChildOneEdit.equals("Male")){
                            strRelationChildEdit="Son";
                            RelationChildEdit.setText(strRelationChildEdit);
                        }else if(strGenderChildOneEdit.equals("Female")){
                            strRelationChildEdit="Daughter";
                            RelationChildEdit.setText(strRelationChildEdit);
                        }
                        if (!strGenderChildOneEdit.equals("Select Gender")) {
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strFirstSonAgeEditText);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectFirstYearChild = period.getYears();
                                        Log.e("selectFirstYearChild", String.valueOf(selectFirstYearChild));
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    LocalDate start = LocalDate.parse(strFirstSonAgeEditText, formatter);
                                    LocalDate end = LocalDate.parse(today, formatter);
                                    String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                                    daysLeftChild1 = Integer.parseInt(days);
                                    Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
                                }
                                if (strFirstSonAgeEditText != null) {
                                    if (daysLeftChild1 < 91 || (selectFirstYearChild > 25)) {
                                        Toast.makeText(PersonalInformationCHI.this, "Son Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                                        strFirstSonAgeEditText = "Select Dob";
                                        FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                                    } else {
                                        FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                                    }
                                }
                            }
                        }

                    }
                });
                singlePicker.show();
            }
        });
        ChildOneLinerRelation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationChildEdit = items1.get(options1);
                        RelationChildEdit.setText(strRelationChildEdit);
                    }
                });
                singlePicker.show();
            }
        });
        LinerFtChildOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");
                ft.add("0");
                ft.add("1");
                ft.add("2");
                ft.add("3");
                ft.add("4");
                ft.add("5");
                ft.add("6");
                ft.add("7");
                ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_oneFtSpinner = ft.get(options1);
                        oneFtSpinner.setText(str_oneFtSpinner);
                        str_oneWeightEdit = oneWeightEdit.getText().toString();
                        if (!str_oneFtSpinner.equals("Ft") && !str_oneInchesSpinner.equals("Inches") && !str_oneWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_oneFtSpinner, str_oneInchesSpinner);
                            kg = Double.parseDouble(str_oneWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIChildEdit = String.format("%.2f", BMI);
                            if (selectFirstYearChild > 19) {
                                if (Double.parseDouble(strBMIChildEdit) >= 16.0 && Double.parseDouble(strBMIChildEdit) <= 33.0) {
                                } else {
                                    showAgePopupNSTP();
//                                    alertPopup();
//                                    Toast.makeText(PersonalInformationCHI.this, "1st child BMI is not normal", Toast.LENGTH_SHORT).show();
                                }
                            }
                            BMIChildEdit.setText(strBMIChildEdit);
//                            if (Double.parseDouble(strBMIChildEdit) >= 16.0 && Double.parseDouble(strBMIChildEdit) <= 33.0) {
//                                BMIChildEdit.setText(strBMIChildEdit);
//                            } else {
//                                BMIChildEdit.setText(strBMIChildEdit);
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "1st child BMI is not normal", Toast.LENGTH_SHORT).show();
//                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        LinerInchesChildOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");
                inches.add("0");
                inches.add("1");
                inches.add("2");
                inches.add("3");
                inches.add("4");
                inches.add("5");
                inches.add("6");
                inches.add("7");
                inches.add("8");
                inches.add("9");
                inches.add("10");
                inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_oneInchesSpinner = inches.get(options1);
                        oneInchesSpinner.setText(str_oneInchesSpinner);
                        str_oneWeightEdit = oneWeightEdit.getText().toString();
                        if (!str_oneFtSpinner.equals("Ft") && !str_oneInchesSpinner.equals("Inches") && !str_oneWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_oneFtSpinner, str_oneInchesSpinner);
                            kg = Double.parseDouble(str_oneWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIChildEdit = String.format("%.2f", BMI);
                            if (selectFirstYearChild > 19) {
                                if (Double.parseDouble(strBMIChildEdit) >= 16.0 && Double.parseDouble(strBMIChildEdit) <= 33.0) {
                                } else {
                                    showAgePopupNSTP();
//                                    alertPopup();
//                                    Toast.makeText(PersonalInformationCHI.this, "1st child BMI is not normal", Toast.LENGTH_SHORT).show();
                                }
                            }
                            BMIChildEdit.setText(strBMIChildEdit);
                        }
                    }
                });
                singlePicker.show();
            }
        });
        oneWeightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 2) {
                    str_oneWeightEdit = oneWeightEdit.getText().toString();
                    if (!str_oneFtSpinner.equals("Ft") && !str_oneInchesSpinner.equals("Inches") && !str_oneWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_oneFtSpinner, str_oneInchesSpinner);
                        kg = Double.parseDouble(str_oneWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIChildEdit = String.format("%.2f", BMI);
                        if (selectFirstYearChild > 19) {
                            if (Double.parseDouble(strBMIChildEdit) >= 16.0 && Double.parseDouble(strBMIChildEdit) <= 33.0) {
                            } else {
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "1st child BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                        BMIChildEdit.setText(strBMIChildEdit);
                    } else if (str_oneFtSpinner.equals("Ft") && str_oneInchesSpinner.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Select 1st Child Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIChildEdit.setText(strBMIChildEdit);
                    } else if (str_oneWeightEdit.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter 1st Child Weight", Toast.LENGTH_SHORT).show();
                        BMIChildEdit.setText(strBMIChildEdit);
                    } else {
                        strBMIChildEdit = String.format("%.2f", BMI);
                        BMIChildEdit.setText(strBMIChildEdit);
                    }
                }
            }
        });

        //SecondChild
        ChildTwoDownArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainChildTwoLiner.setVisibility(View.VISIBLE);
                ChildTwoDownArrow.setVisibility(View.GONE);
                ChildTwoUpArrow.setVisibility(View.VISIBLE);
            }
        });
        ChildTwoUpArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainChildTwoLiner.setVisibility(View.GONE);
                ChildTwoUpArrow.setVisibility(View.GONE);
                ChildTwoDownArrow.setVisibility(View.VISIBLE);
            }
        });
        SecondSonAgeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSecondSonCalender();
            }
        });
        SecSonChildGenderLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
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
                        str_twoGenderSpinner = items1.get(options1);
                        twoGenderSpinner.setText(str_twoGenderSpinner);
                        if (str_twoGenderSpinner.equals("Male")){
                             strRelationChildTwoEdit="Son";
                             RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                        }else if(str_twoGenderSpinner.equals("Female")){
                             strRelationChildTwoEdit="Daughter";
                             RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                        }
                        if (!str_twoGenderSpinner.equals("Select Gender")) {
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strSecondSonAgeEditText);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectSecSonChild = period.getYears();
                                        Log.e("selectSecSonChild", String.valueOf(selectSecSonChild));
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    LocalDate start = LocalDate.parse(strSecondSonAgeEditText, formatter);
                                    LocalDate end = LocalDate.parse(today, formatter);
                                    String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                                    daysLeftChild2 = Integer.parseInt(days);
                                    Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
                                }
                                if (strSecondSonAgeEditText != null) {
                                    if (daysLeftChild2 < 91 || (selectSecSonChild > 25)) {
                                        Toast.makeText(PersonalInformationCHI.this, "Second Child Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                                        strSecondSonAgeEditText = "Select Dob";
                                        SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                                    } else {
                                        SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                                    }
                                }
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        LinerChildTwoFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");
                ft.add("0");
                ft.add("1");
                ft.add("2");
                ft.add("3");
                ft.add("4");
                ft.add("5");
                ft.add("6");
                ft.add("7");
                ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_twoFtSpinner = ft.get(options1);
                        twoFtSpinner.setText(str_twoFtSpinner);
                        strtwoWeightEdit = twoWeightEdit.getText().toString();
                        if (!str_twoFtSpinner.equals("Ft") && !str_twoInchesSpinner.equals("Inches") && !strtwoWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_twoFtSpinner, str_twoInchesSpinner);
                            kg = Double.parseDouble(strtwoWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIChildTwoEdit = String.format("%.2f", BMI);
                            if (selectSecSonChild > 19) {
                                if (Double.parseDouble(strBMIChildTwoEdit) >= 16.0 && Double.parseDouble(strBMIChildTwoEdit) <= 33.0) {
                                } else {
                                    showAgePopupNSTP();
//                                    alertPopup();
//                                    Toast.makeText(PersonalInformationCHI.this, "2nd child BMI is not normal", Toast.LENGTH_SHORT).show();
                                }
                            }
                            BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                        }
                    }
                });
                singlePicker.show();
            }
        });
        LinerChildTwoInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");
                inches.add("0");
                inches.add("1");
                inches.add("2");
                inches.add("3");
                inches.add("4");
                inches.add("5");
                inches.add("6");
                inches.add("7");
                inches.add("8");
                inches.add("9");
                inches.add("10");
                inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_twoInchesSpinner = inches.get(options1);
                        twoInchesSpinner.setText(str_twoInchesSpinner);
                        strtwoWeightEdit = twoWeightEdit.getText().toString();
                        if (!str_twoFtSpinner.equals("Ft") && !str_twoInchesSpinner.equals("Inches") && !strtwoWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_twoFtSpinner, str_twoInchesSpinner);
                            kg = Double.parseDouble(strtwoWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIChildTwoEdit = String.format("%.2f", BMI);
                            if (selectSecSonChild > 19) {
                                if (Double.parseDouble(strBMIChildTwoEdit) >= 16.0 && Double.parseDouble(strBMIChildTwoEdit) <= 33.0) {
                                } else {
                                    showAgePopupNSTP();
//                                    alertPopup();
//                                    Toast.makeText(PersonalInformationCHI.this, "2nd child BMI is not normal", Toast.LENGTH_SHORT).show();
                                }
                            }
                            BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                        }
                    }
                });
                singlePicker.show();
            }
        });
        twoWeightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 2) {
                    strtwoWeightEdit = twoWeightEdit.getText().toString();
                    if (!str_twoFtSpinner.equals("Ft") && !str_twoInchesSpinner.equals("Inches") && !strtwoWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_twoFtSpinner, str_twoInchesSpinner);
                        kg = Double.parseDouble(strtwoWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIChildTwoEdit = String.format("%.2f", BMI);
                        if (selectSecSonChild > 19) {
                            if (Double.parseDouble(strBMIChildTwoEdit) >= 16.0 && Double.parseDouble(strBMIChildTwoEdit) <= 33.0) {
                            } else {
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "2nd child BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                    } else if (str_twoFtSpinner.equals("Ft") && str_twoInchesSpinner.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Select 2nd Child Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                    } else if (strtwoWeightEdit.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter 2nd Child Weight", Toast.LENGTH_SHORT).show();
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                    } else {
                        strBMIChildTwoEdit = String.format("%.2f", BMI);
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                    }
                }
            }
        });
        ChildTwoRelationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationChildTwoEdit = items1.get(options1);
                        RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                    }
                });
                singlePicker.show();
            }
        });
        //ThirdChild
        ChildThreeDownArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainChildThirdLiner.setVisibility(View.VISIBLE);
                ChildThreeDownArrowImg.setVisibility(View.GONE);
                ChildThreeUpArrowImg.setVisibility(View.VISIBLE);
            }
        });
        ChildThreeUpArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainChildThirdLiner.setVisibility(View.GONE);
                ChildThreeUpArrowImg.setVisibility(View.GONE);
                ChildThreeDownArrowImg.setVisibility(View.VISIBLE);
            }
        });
        ThirdSonLinerAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showThirdSonCalender();
            }
        });
        thirdLinerGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
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
                        str_thirdGenderSpinner = items1.get(options1);
                        thirdGenderSpinner.setText(str_thirdGenderSpinner);
                        if (str_thirdGenderSpinner.equals("Male")){
                            strRelationChildThreeEdit="Son";
                            RelationChildThreeEdit.setText(strRelationChildThreeEdit);
                        }else if(str_thirdGenderSpinner.equals("Female")){
                            strRelationChildThreeEdit="Daughter";
                            RelationChildThreeEdit.setText(strRelationChildThreeEdit);
                        }
                        if (!str_thirdGenderSpinner.equals("Select Gender")) {
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strThirdSonAgeEditText);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectThirdSonChild = period.getYears();
                                        Log.e("selectThirdSonChild", String.valueOf(selectThirdSonChild));
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    LocalDate start = LocalDate.parse(strThirdSonAgeEditText, formatter);
                                    LocalDate end = LocalDate.parse(today, formatter);
                                    String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                                    daysLeftChild3 = Integer.parseInt(days);
                                    Log.e("daysLeftChild3", String.valueOf(ChronoUnit.DAYS.between(start, end)));
                                }
                                if (strThirdSonAgeEditText != null) {
                                    if (daysLeftChild3 < 91 || (selectThirdSonChild > 25)) {
                                        Toast.makeText(PersonalInformationCHI.this, "Third Child Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                                        strThirdSonAgeEditText = "Select Dob";
                                        ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                                    } else {
                                        ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                                    }
                                }
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        LinerFtThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");
                ft.add("0");
                ft.add("1");
                ft.add("2");
                ft.add("3");
                ft.add("4");
                ft.add("5");
                ft.add("6");
                ft.add("7");
                ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_thirdFtSpinner = ft.get(options1);
                        thirdFtSpinner.setText(str_thirdFtSpinner);
                        str_thirdWeightEdit = thirdWeightEdit.getText().toString();
                        if (!str_thirdFtSpinner.equals("Ft") && !str_thirdInchesSpinner.equals("Inches") && !str_thirdWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_thirdFtSpinner, str_thirdInchesSpinner);
                            kg = Double.parseDouble(str_thirdWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIEChildThreeEdit = String.format("%.2f", BMI);
                            if (selectThirdSonChild > 19) {
                                if (Double.parseDouble(strBMIEChildThreeEdit) >= 16.0 && Double.parseDouble(strBMIEChildThreeEdit) <= 33.0) {
                                } else {
                                    showAgePopupNSTP();
//                                    alertPopup();
//                                    Toast.makeText(PersonalInformationCHI.this, "3rd child BMI is not normal", Toast.LENGTH_SHORT).show();
                                }
                            }
                            BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                        }
                    }
                });
                singlePicker.show();
            }
        });
        thirdInchesLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");
                inches.add("0");
                inches.add("1");
                inches.add("2");
                inches.add("3");
                inches.add("4");
                inches.add("5");
                inches.add("6");
                inches.add("7");
                inches.add("8");
                inches.add("9");
                inches.add("10");
                inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_thirdInchesSpinner = inches.get(options1);
                        thirdInchesSpinner.setText(str_thirdInchesSpinner);
                        str_thirdWeightEdit = thirdWeightEdit.getText().toString();
                        if (!str_thirdFtSpinner.equals("Ft") && !str_thirdInchesSpinner.equals("Inches") && !str_thirdWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_thirdFtSpinner, str_thirdInchesSpinner);
                            kg = Double.parseDouble(str_thirdWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIEChildThreeEdit = String.format("%.2f", BMI);
                            if (selectThirdSonChild > 19) {
                                if (Double.parseDouble(strBMIEChildThreeEdit) >= 16.0 && Double.parseDouble(strBMIEChildThreeEdit) <= 33.0) {
                                } else {
                                    showAgePopupNSTP();
//                                    alertPopup();
//                                    Toast.makeText(PersonalInformationCHI.this, "3rd child BMI is not normal", Toast.LENGTH_SHORT).show();
                                }
                            }
                            BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                        }
                    }
                });
                singlePicker.show();
            }
        });
        thirdWeightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 2) {
                    str_thirdWeightEdit = thirdWeightEdit.getText().toString();
                    if (!str_thirdFtSpinner.equals("Ft") && !str_thirdInchesSpinner.equals("Inches") && !str_thirdWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_thirdFtSpinner, str_thirdInchesSpinner);
                        kg = Double.parseDouble(str_thirdWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIEChildThreeEdit = String.format("%.2f", BMI);
                        if (selectThirdSonChild > 19) {
                            if (Double.parseDouble(strBMIEChildThreeEdit) >= 16.0 && Double.parseDouble(strBMIEChildThreeEdit) <= 33.0) {
                            } else {
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "3rd child BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                    } else if (str_thirdFtSpinner.equals("Ft") && str_thirdInchesSpinner.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Select 3rd Child Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                    } else if (str_thirdWeightEdit.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter 3rd Child Weight", Toast.LENGTH_SHORT).show();
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                    } else {
                        strBMIEChildThreeEdit = String.format("%.2f", BMI);
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                    }
                }
            }
        });
        RelationThirdLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationChildThreeEdit = items1.get(options1);
                        RelationChildThreeEdit.setText(strRelationChildThreeEdit);
                    }
                });
                singlePicker.show();
            }
        });


        //FourChild
        ChildFourDownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainChildFourLiner.setVisibility(View.VISIBLE);
                ChildFourDownImg.setVisibility(View.GONE);
                ChildFourUpImg.setVisibility(View.VISIBLE);
            }
        });
        ChildFourUpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainChildFourLiner.setVisibility(View.GONE);
                ChildFourUpImg.setVisibility(View.GONE);
                ChildFourDownImg.setVisibility(View.VISIBLE);
            }
        });
        FourChildCalenderLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFourSonCalender();
            }
        });
        LinerGenderFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
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
                        str_fourGenderSpinner = items1.get(options1);
                        fourGenderSpinner.setText(str_fourGenderSpinner);
                        if (str_fourGenderSpinner.equals("Male")){
                            strRelationFourChildEdit="Son";
                            RelationFourChildEdit.setText(strRelationFourChildEdit);
                        }else if(str_fourGenderSpinner.equals("Female")){
                            strRelationFourChildEdit="Daughter";
                            RelationFourChildEdit.setText(strRelationFourChildEdit);
                        }
                        if (!str_fourGenderSpinner.equals("Select Gender")) {
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strFourSonAgeEditText);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearChildFour = period.getYears();
                                        Log.e("selectYearChildFour", String.valueOf(selectYearChildFour));
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    LocalDate start = LocalDate.parse(strFourSonAgeEditText, formatter);
                                    LocalDate end = LocalDate.parse(today, formatter);
                                    String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                                    daysLeftChild4 = Integer.parseInt(days);
                                    Log.e("daysLeftChild4", String.valueOf(ChronoUnit.DAYS.between(start, end)));
                                }
                                if (strFourSonAgeEditText != null) {
                                    if (daysLeftChild4 < 91 || (selectYearChildFour > 25)) {
                                        Toast.makeText(PersonalInformationCHI.this, "Fourth Child Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                                        strFourSonAgeEditText = "Select Dob";
                                        FourSonAgeEditText.setText(strFourSonAgeEditText);
                                    } else {
                                        FourSonAgeEditText.setText(strFourSonAgeEditText);
                                    }
                                }
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        LinerFtFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");
                ft.add("0");
                ft.add("1");
                ft.add("2");
                ft.add("3");
                ft.add("4");
                ft.add("5");
                ft.add("6");
                ft.add("7");
                ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_fourFtSpinner = ft.get(options1);
                        fourFtSpinner.setText(str_fourFtSpinner);
                        strFourWeightEdit = FourWeightEdit.getText().toString();
                        if (!str_fourFtSpinner.equals("Ft") && !str_fourInchesSpinner.equals("Inches") && !strFourWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_fourFtSpinner, str_fourInchesSpinner);
                            kg = Double.parseDouble(strFourWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIFourChildEdit = String.format("%.2f", BMI);

                            if (selectYearChildFour > 19) {
                                if (Double.parseDouble(strBMIFourChildEdit) >= 16.0 && Double.parseDouble(strBMIFourChildEdit) <= 33.0) {
                                } else {
                                    showAgePopupNSTP();
//                                    alertPopup();
//                                    Toast.makeText(PersonalInformationCHI.this, "4th child BMI is not normal", Toast.LENGTH_SHORT).show();
                                }
                            }
                            BMIFourChildEdit.setText(strBMIFourChildEdit);
                        }
                    }
                });
                singlePicker.show();
            }
        });
        LinerInchesFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");
                inches.add("0");
                inches.add("1");
                inches.add("2");
                inches.add("3");
                inches.add("4");
                inches.add("5");
                inches.add("6");
                inches.add("7");
                inches.add("8");
                inches.add("9");
                inches.add("10");
                inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_fourInchesSpinner = inches.get(options1);
                        fourInchesSpinner.setText(str_fourInchesSpinner);
                        strFourWeightEdit = FourWeightEdit.getText().toString();
                        if (!str_fourFtSpinner.equals("Ft") && !str_fourInchesSpinner.equals("Inches") && !strFourWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_fourFtSpinner, str_fourInchesSpinner);
                            kg = Double.parseDouble(strFourWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIFourChildEdit = String.format("%.2f", BMI);
                            if (selectYearChildFour > 19) {
                                if (Double.parseDouble(strBMIFourChildEdit) >= 16.0 && Double.parseDouble(strBMIFourChildEdit) <= 33.0) {
                                } else {
                                    showAgePopupNSTP();
//                                    alertPopup();
//                                    Toast.makeText(PersonalInformationCHI.this, "4th child BMI is not normal", Toast.LENGTH_SHORT).show();
                                }
                            }
                            BMIFourChildEdit.setText(strBMIFourChildEdit);
                        }
                    }
                });
                singlePicker.show();
            }
        });
        FourWeightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 2) {
                    strFourWeightEdit = FourWeightEdit.getText().toString();
                    if (!str_fourFtSpinner.equals("Ft") && !str_fourInchesSpinner.equals("Inches") && !strFourWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_fourFtSpinner, str_fourInchesSpinner);
                        kg = Double.parseDouble(strFourWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIFourChildEdit = String.format("%.2f", BMI);
                        if (selectYearChildFour > 19) {
                            if (Double.parseDouble(strBMIFourChildEdit) >= 16.0 && Double.parseDouble(strBMIFourChildEdit) <= 33.0) {
                            } else {
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "4th child BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                        BMIFourChildEdit.setText(strBMIFourChildEdit);
                    } else if (str_fourFtSpinner.equals("Ft") && str_fourInchesSpinner.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Select 4th Child Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIFourChildEdit.setText(strBMIFourChildEdit);
                    } else if (strFourWeightEdit.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter 4th Child Weight", Toast.LENGTH_SHORT).show();
                        BMIFourChildEdit.setText(strBMIFourChildEdit);
                    } else {
                        strBMIFourChildEdit = String.format("%.2f", BMI);
                        BMIFourChildEdit.setText(strBMIFourChildEdit);
                    }
                }
            }
        });
        LinerRelationFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationFourChildEdit = items1.get(options1);
                        RelationFourChildEdit.setText(strRelationFourChildEdit);
                    }
                });
                singlePicker.show();
            }
        });

        //Mother
        MotherDownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MotherDownImg.setVisibility(View.GONE);
                MotherUpImg.setVisibility(View.VISIBLE);
                MainMotherLiner.setVisibility(View.VISIBLE);
            }
        });
        MotherUpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MotherDownImg.setVisibility(View.VISIBLE);
                MotherUpImg.setVisibility(View.GONE);
                MainMotherLiner.setVisibility(View.GONE);
            }
        });
        LinerMotherDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMotherCalender();
            }
        });
        MotherOccupationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Occupation");
                items1.add("Doctors");
                items1.add("Lawyers");
                items1.add("Accounts");
                items1.add("Architects");
                items1.add("Consulting engineers");
                items1.add("Teachers");
                items1.add("Administrative Function and persons primarily engaged in occupation of similar Hazard");
                items1.add("Bankers Persons engaged in clerical function");
                items1.add("Bureaucrats");
                items1.add("Housewife");
                items1.add("Student");
                items1.add("Shopkeeper");
                items1.add("Writer");
                items1.add("Fashion Designer");
                items1.add("Desk job");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherOccupationEdit = items1.get(options1);
                        MotherOccupationEdit.setText(strMotherOccupationEdit);
                        if (!strMotherOccupationEdit.equals("Occupation")) {
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strMotherAgeEditText);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearMotherAdult = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearMotherAdult < 36 || (selectYearMotherAdult > 55)) {
                                    Toast.makeText(PersonalInformationCHI.this, "Mother Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                                    strMotherAgeEditText = "Select Dob";
                                    MotherAgeEditText.setText(strMotherAgeEditText);
                                    showAgePopupNSTP();
                                }
                            }
                        }

                    }
                });
                singlePicker.show();
            }
        });
        MotherFeetLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");
                ft.add("0");
                ft.add("1");
                ft.add("2");
                ft.add("3");
                ft.add("4");
                ft.add("5");
                ft.add("6");
                ft.add("7");
                ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherFeetEditText = ft.get(options1);
                        MotherFeetEditText.setText(strMotherFeetEditText);
                        strMotherWeightEdit = MotherWeightEdit.getText().toString();
                        if (!strMotherFeetEditText.equals("Ft") && !strInchesMotherEdit.equals("Inches") && !strMotherWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strMotherFeetEditText, strInchesMotherEdit);
                            kg = Double.parseDouble(strMotherWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIMotherEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIMotherEdit) >= 16.0 && Double.parseDouble(strBMIMotherEdit) <= 33.0) {
                                BMIMotherEdit.setText(strBMIMotherEdit);
                            } else {
                                BMIMotherEdit.setText(strBMIMotherEdit);
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "Mother's BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        InchesLinerMother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");
                inches.add("0");
                inches.add("1");
                inches.add("2");
                inches.add("3");
                inches.add("4");
                inches.add("5");
                inches.add("6");
                inches.add("7");
                inches.add("8");
                inches.add("9");
                inches.add("10");
                inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strInchesMotherEdit = inches.get(options1);
                        InchesMotherEdit.setText(strInchesMotherEdit);
                        strMotherWeightEdit = MotherWeightEdit.getText().toString();
                        if (!strMotherFeetEditText.equals("Ft") && !strInchesMotherEdit.equals("Inches") && !strMotherWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strMotherFeetEditText, strInchesMotherEdit);
                            kg = Double.parseDouble(strMotherWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIMotherEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIMotherEdit) >= 16.0 && Double.parseDouble(strBMIMotherEdit) <= 33.0) {
                                BMIMotherEdit.setText(strBMIMotherEdit);
                            } else {
                                BMIMotherEdit.setText(strBMIMotherEdit);
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "Mother's BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        MotherWeightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 2) {
                    strMotherWeightEdit = MotherWeightEdit.getText().toString();
                    if (!strMotherFeetEditText.equals("Ft") && !strInchesMotherEdit.equals("Inches") && !strMotherWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(strMotherFeetEditText, strInchesMotherEdit);
                        kg = Double.parseDouble(strMotherWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIMotherEdit = String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIMotherEdit) >= 16.0 && Double.parseDouble(strBMIMotherEdit) <= 33.0) {
                            BMIMotherEdit.setText(strBMIMotherEdit);
                        } else {
                            BMIMotherEdit.setText(strBMIMotherEdit);
                            showAgePopupNSTP();
//                            Toast.makeText(PersonalInformationCHI.this, "Mother's BMI is not normal", Toast.LENGTH_SHORT).show();
//                            alertPopup();
                        }
                    } else if (strMotherFeetEditText.equals("Ft") && strInchesMotherEdit.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Select Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIMotherEdit.setText(strBMIMotherEdit);
                    } else if (strMotherWeightEdit.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter Mother Weight", Toast.LENGTH_SHORT).show();
                        BMIMotherEdit.setText(strBMIMotherEdit);
                    } else {
                        strBMIMotherEdit = String.format("%.2f", BMI);
                        BMIMotherEdit.setText(strBMIMotherEdit);
                    }
                }
            }
        });


        //Father
        FatherDownArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FatherUpArrowImg.setVisibility(View.VISIBLE);
                MainFatherLiner.setVisibility(View.VISIBLE);
                FatherDownArrowImg.setVisibility(View.GONE);
            }
        });
        FatherUpArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FatherUpArrowImg.setVisibility(View.GONE);
                MainFatherLiner.setVisibility(View.GONE);
                FatherDownArrowImg.setVisibility(View.VISIBLE);
            }
        });
        FatherDobLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFatherCalender();
            }
        });
        LinerFatherOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Occupation");
                items1.add("Doctors");
                items1.add("Lawyers");
                items1.add("Accounts");
                items1.add("Architects");
                items1.add("Consulting engineers");
                items1.add("Teachers");
                items1.add("Administrative Function and persons primarily engaged in occupation of similar Hazard");
                items1.add("Bankers Persons engaged in clerical function");
                items1.add("Bureaucrats");
                items1.add("Housewife");
                items1.add("Student");
                items1.add("Shopkeeper");
                items1.add("Writer");
                items1.add("Fashion Designer");
                items1.add("Desk job");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strFatherOccupationEdit = items1.get(options1);
                        FatherOccupationEdit.setText(strFatherOccupationEdit);
                        if (!strFatherOccupationEdit.equals("Occupation")) {
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strFatherAgeEditText);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearFatherAdult = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearFatherAdult < 36 || (selectYearFatherAdult > 55)) {
                                    Toast.makeText(PersonalInformationCHI.this, "Father Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                                    strFatherAgeEditText = "Select Dob";
                                    FatherAgeEditText.setText(strFatherAgeEditText);
                                    showAgePopupNSTP();
                                }
                            }
                        }

                    }
                });
                singlePicker.show();
            }
        });
        FeetLinerFather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");
                ft.add("0");
                ft.add("1");
                ft.add("2");
                ft.add("3");
                ft.add("4");
                ft.add("5");
                ft.add("6");
                ft.add("7");
                ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strFeetFatherEdit = ft.get(options1);
                        FeetFatherEdit.setText(strFeetFatherEdit);
                        strFatherWeightEdit = FatherWeightEdit.getText().toString();
                        if (!strFeetFatherEdit.equals("Ft") && !strInchesFatherEdit.equals("Inches") && !strFatherWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strFeetFatherEdit, strInchesFatherEdit);
                            kg = Double.parseDouble(strFatherWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIFatherEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIFatherEdit) >= 16.0 && Double.parseDouble(strBMIFatherEdit) <= 33.0) {
                                BMIFatherEdit.setText(strBMIFatherEdit);
                            } else {
                                BMIFatherEdit.setText(strBMIFatherEdit);
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "Father BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        LinerFatherInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");
                inches.add("0");
                inches.add("1");
                inches.add("2");
                inches.add("3");
                inches.add("4");
                inches.add("5");
                inches.add("6");
                inches.add("7");
                inches.add("8");
                inches.add("9");
                inches.add("10");
                inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strInchesFatherEdit = inches.get(options1);
                        InchesFatherEdit.setText(strInchesFatherEdit);
                        strFatherWeightEdit = FatherWeightEdit.getText().toString();
                        if (!strFeetFatherEdit.equals("Ft") && !strInchesFatherEdit.equals("Inches") && !strFatherWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strFeetFatherEdit, strInchesFatherEdit);
                            kg = Double.parseDouble(strFatherWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIFatherEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIFatherEdit) >= 16.0 && Double.parseDouble(strBMIFatherEdit) <= 33.0) {
                                BMIFatherEdit.setText(strBMIFatherEdit);
                            } else {
                                BMIFatherEdit.setText(strBMIFatherEdit);
                                showAgePopupNSTP();
//                                alertPopup();
//                                Toast.makeText(PersonalInformationCHI.this, "Father BMI is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        FatherWeightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 2) {
                    strFatherWeightEdit = FatherWeightEdit.getText().toString();
                    if (!strFeetFatherEdit.equals("Ft") && !strInchesFatherEdit.equals("Inches") && !strFatherWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(strFeetFatherEdit, strInchesFatherEdit);
                        kg = Double.parseDouble(strFatherWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIFatherEdit = String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIFatherEdit) >= 16.0 && Double.parseDouble(strBMIFatherEdit) <= 33.0) {
                            BMIFatherEdit.setText(strBMIFatherEdit);
                        } else {
                            BMIFatherEdit.setText(strBMIFatherEdit);
                            showAgePopupNSTP();
//                            alertPopup();
//                            Toast.makeText(PersonalInformationCHI.this, "Father BMI is not normal", Toast.LENGTH_SHORT).show();
                        }
                    } else if (strFeetFatherEdit.equals("Ft") && strInchesFatherEdit.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Select Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIFatherEdit.setText(strBMIFatherEdit);
                    } else if (strFatherWeightEdit.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter Father Weight", Toast.LENGTH_SHORT).show();
                        BMIFatherEdit.setText(strBMIFatherEdit);
                    } else {
                        strBMIFatherEdit = String.format("%.2f", BMI);
                        BMIFatherEdit.setText(strBMIFatherEdit);
                    }
                }
            }
        });

        //Mother-In-Law
        MotherLawDownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MotherLawDownImg.setVisibility(View.GONE);
                MotherLawUpImg.setVisibility(View.VISIBLE);
                MainMotherLawLiner.setVisibility(View.VISIBLE);
            }
        });
        MotherLawUpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MotherLawDownImg.setVisibility(View.VISIBLE);
                MotherLawUpImg.setVisibility(View.GONE);
                MainMotherLawLiner.setVisibility(View.GONE);
            }
        });
        MotherLawDobLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMotherInLawCalender();
            }
        });
        OccupationMatherLawLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Occupation");
                items1.add("Doctors");
                items1.add("Lawyers");
                items1.add("Accounts");
                items1.add("Architects");
                items1.add("Consulting engineers");
                items1.add("Teachers");
                items1.add("Administrative Function and persons primarily engaged in occupation of similar Hazard");
                items1.add("Bankers Persons engaged in clerical function");
                items1.add("Bureaucrats");
                items1.add("Housewife");
                items1.add("Student");
                items1.add("Shopkeeper");
                items1.add("Writer");
                items1.add("Fashion Designer");
                items1.add("Desk job");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strOccupationEditMotherLaw = items1.get(options1);
                        OccupationEditMotherLaw.setText(strOccupationEditMotherLaw);
                        if (!strOccupationEditMotherLaw.equals("Occupation")) {
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strMotherLawAgeEditText);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectMotherLawAdult = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectMotherLawAdult < 36 || (selectMotherLawAdult > 55)) {
                                    Toast.makeText(PersonalInformationCHI.this, "Mother-In-Law Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                                    strMotherLawAgeEditText = "Select Dob";
                                    MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                                    showAgePopupNSTP();
                                }
                            }
                        }

                    }
                });
                singlePicker.show();
            }
        });
        FeetMotherLawLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");
                ft.add("0");
                ft.add("1");
                ft.add("2");
                ft.add("3");
                ft.add("4");
                ft.add("5");
                ft.add("6");
                ft.add("7");
                ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strFeetEditTextMotherLaw = ft.get(options1);
                        FeetEditTextMotherLaw.setText(strFeetEditTextMotherLaw);
                        strWeightMotherLawEdit = WeightMotherLawEdit.getText().toString();
                        if (!strFeetEditTextMotherLaw.equals("Ft") && !strInchesEditTextMotherLaw.equals("Inches") && !strWeightMotherLawEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strFeetEditTextMotherLaw, strInchesEditTextMotherLaw);
                            kg = Double.parseDouble(strWeightMotherLawEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIMotherLawEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIMotherLawEdit) >= 16.0 && Double.parseDouble(strBMIMotherLawEdit) <= 33.0) {
                                BMIMotherLawEdit.setText(strBMIMotherLawEdit);
                            } else {
                                BMIMotherLawEdit.setText(strBMIMotherLawEdit);
//                                Toast.makeText(PersonalInformationCHI.this, "Mother-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
//                                alertPopup();
                                showAgePopupNSTP();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        InchesLinerMotherInLaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");
                inches.add("0");
                inches.add("1");
                inches.add("2");
                inches.add("3");
                inches.add("4");
                inches.add("5");
                inches.add("6");
                inches.add("7");
                inches.add("8");
                inches.add("9");
                inches.add("10");
                inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strInchesEditTextMotherLaw = inches.get(options1);
                        InchesEditTextMotherLaw.setText(strInchesEditTextMotherLaw);
                        strWeightMotherLawEdit = WeightMotherLawEdit.getText().toString();
                        if (!strFeetEditTextMotherLaw.equals("Ft") && !strInchesEditTextMotherLaw.equals("Inches") && !strWeightMotherLawEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strFeetEditTextMotherLaw, strInchesEditTextMotherLaw);
                            kg = Double.parseDouble(strWeightMotherLawEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIMotherLawEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIMotherLawEdit) >= 16.0 && Double.parseDouble(strBMIMotherLawEdit) <= 33.0) {
                                BMIMotherLawEdit.setText(strBMIMotherLawEdit);
                            } else {
                                BMIMotherLawEdit.setText(strBMIMotherLawEdit);
//                                Toast.makeText(PersonalInformationCHI.this, "Mother-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
//                                alertPopup();
                                showAgePopupNSTP();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        WeightMotherLawEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 2) {
                    strWeightMotherLawEdit = WeightMotherLawEdit.getText().toString();
                    if (!strFeetEditTextMotherLaw.equals("Ft") && !strInchesEditTextMotherLaw.equals("Inches") && !strWeightMotherLawEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(strFeetEditTextMotherLaw, strInchesEditTextMotherLaw);
                        kg = Double.parseDouble(strWeightMotherLawEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIMotherLawEdit = String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIMotherLawEdit) >= 16.0 && Double.parseDouble(strBMIMotherLawEdit) <= 33.0) {
                            BMIMotherLawEdit.setText(strBMIMotherLawEdit);
                        } else {
                            BMIMotherLawEdit.setText(strBMIMotherLawEdit);
                            showAgePopupNSTP();
//                            alertPopup();
//                            Toast.makeText(PersonalInformationCHI.this, "Mother-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
                        }
                    } else if (strFeetEditTextMotherLaw.equals("Ft") && strInchesEditTextMotherLaw.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Select Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIMotherLawEdit.setText(strBMIMotherLawEdit);
                    } else if (strWeightMotherLawEdit.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter Mother-In-Law Weight", Toast.LENGTH_SHORT).show();
                        BMIMotherLawEdit.setText(strBMIMotherLawEdit);
                    } else {
                        strBMIMotherLawEdit = String.format("%.2f", BMI);
                        BMIMotherLawEdit.setText(strBMIMotherLawEdit);
                    }
                }
            }
        });

        FatherLawDownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FatherLawDownImg.setVisibility(View.GONE);
                FatherLawUpImg.setVisibility(View.VISIBLE);
                MainFatherLawLiner.setVisibility(View.VISIBLE);

            }
        });
        FatherLawUpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FatherLawDownImg.setVisibility(View.VISIBLE);
                FatherLawUpImg.setVisibility(View.GONE);
                MainFatherLawLiner.setVisibility(View.GONE);

            }
        });
        LinerDobFatherLaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFatherInLawCalender();
            }
        });
        OccupationFatherLawLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Occupation");
                items1.add("Doctors");
                items1.add("Lawyers");
                items1.add("Accounts");
                items1.add("Architects");
                items1.add("Consulting engineers");
                items1.add("Teachers");
                items1.add("Administrative Function and persons primarily engaged in occupation of similar Hazard");
                items1.add("Bankers Persons engaged in clerical function");
                items1.add("Bureaucrats");
                items1.add("Housewife");
                items1.add("Student");
                items1.add("Shopkeeper");
                items1.add("Writer");
                items1.add("Fashion Designer");
                items1.add("Desk job");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strOccupationFatherLawEdit = items1.get(options1);
                        OccupationFatherLawEdit.setText(strOccupationFatherLawEdit);
                        if (!strOccupationFatherLawEdit.equals("Occupation")) {
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strFatherLawAgeEditText);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectFatherLawAdult = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectFatherLawAdult < 36 || (selectFatherLawAdult > 55)) {
                                    Toast.makeText(PersonalInformationCHI.this, "Father-In-Law Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                                    strFatherLawAgeEditText = "Select Dob";
                                    FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                                    showAgePopupNSTP();
                                }
                            }
                        }

                    }
                });
                singlePicker.show();
            }
        });
        LinerFeetFatherLaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");
                ft.add("0");
                ft.add("1");
                ft.add("2");
                ft.add("3");
                ft.add("4");
                ft.add("5");
                ft.add("6");
                ft.add("7");
                ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strEditFeetFatherLaw = ft.get(options1);
                        EditFeetFatherLaw.setText(strEditFeetFatherLaw);
                        strFatherLawWeightEdit = FatherLawWeightEdit.getText().toString();
                        if (!strEditFeetFatherLaw.equals("Ft") && !strEditInchesFatherLaw.equals("Inches") && !strFatherLawWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strEditFeetFatherLaw, strEditInchesFatherLaw);
                            kg = Double.parseDouble(strFatherLawWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strFatherLawBMIEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strFatherLawBMIEdit) >= 16.0 && Double.parseDouble(strFatherLawBMIEdit) <= 33.0) {
                                FatherLawBMIEdit.setText(strFatherLawBMIEdit);
                            } else {
                                FatherLawBMIEdit.setText(strFatherLawBMIEdit);
//                                Toast.makeText(PersonalInformationCHI.this, "Father-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
//                                alertPopup();
                                showAgePopupNSTP();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        LinerInchesFatherLaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");
                inches.add("0");
                inches.add("1");
                inches.add("2");
                inches.add("3");
                inches.add("4");
                inches.add("5");
                inches.add("6");
                inches.add("7");
                inches.add("8");
                inches.add("9");
                inches.add("10");
                inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strEditInchesFatherLaw = inches.get(options1);
                        EditInchesFatherLaw.setText(strEditInchesFatherLaw);
                        strFatherLawWeightEdit = FatherLawWeightEdit.getText().toString();
                        if (!strEditFeetFatherLaw.equals("Ft") && !strEditInchesFatherLaw.equals("Inches") && !strFatherLawWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(strEditFeetFatherLaw, strEditInchesFatherLaw);
                            kg = Double.parseDouble(strFatherLawWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strFatherLawBMIEdit = String.format("%.2f", BMI);
                            if (Double.parseDouble(strFatherLawBMIEdit) >= 16.0 && Double.parseDouble(strFatherLawBMIEdit) <= 33.0) {
                                FatherLawBMIEdit.setText(strFatherLawBMIEdit);
                            } else {
                                FatherLawBMIEdit.setText(strFatherLawBMIEdit);
//                                Toast.makeText(PersonalInformationCHI.this, "Father-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
//                                alertPopup();
                                showAgePopupNSTP();
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        FatherLawWeightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 2) {
                    strFatherLawWeightEdit = FatherLawWeightEdit.getText().toString();
                    if (!strEditFeetFatherLaw.equals("Ft") && !strEditInchesFatherLaw.equals("Inches") && !strFatherLawWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(strEditFeetFatherLaw, strEditInchesFatherLaw);
                        kg = Double.parseDouble(strFatherLawWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strFatherLawBMIEdit = String.format("%.2f", BMI);
                        if (Double.parseDouble(strFatherLawBMIEdit) >= 16.0 && Double.parseDouble(strFatherLawBMIEdit) <= 33.0) {
                            FatherLawBMIEdit.setText(strFatherLawBMIEdit);
                        } else {
                            FatherLawBMIEdit.setText(strFatherLawBMIEdit);
//                            Toast.makeText(PersonalInformationCHI.this, "Father-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
//                            alertPopup();
                            showAgePopupNSTP();
                        }
                    } else if (strEditFeetFatherLaw.equals("Ft") && strEditInchesFatherLaw.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Select Ft & Inches", Toast.LENGTH_SHORT).show();
                        FatherLawBMIEdit.setText(strFatherLawBMIEdit);
                    } else if (strFatherLawWeightEdit.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Please Enter Father-In-Law  Weight", Toast.LENGTH_SHORT).show();
                        FatherLawBMIEdit.setText(strFatherLawBMIEdit);
                    } else {
                        strFatherLawBMIEdit = String.format("%.2f", BMI);
                        FatherLawBMIEdit.setText(strFatherLawBMIEdit);
                    }
                }
            }
        });

        //nominee
        nomineeDownImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomineeDownImg.setVisibility(View.GONE);
                nomineeUpImg.setVisibility(View.VISIBLE);
                MainNomineeLiner.setVisibility(View.VISIBLE);

            }
        });
        nomineeUpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomineeUpImg.setVisibility(View.GONE);
                nomineeDownImg.setVisibility(View.VISIBLE);
                MainNomineeLiner.setVisibility(View.GONE);

            }
        });
        NomineeSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
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
                        strNomineeGenderEdit = items1.get(options1);
                        NomineeGenderEdit.setText(strNomineeGenderEdit);
                        if (!strNomineeGenderEdit.equals("Select Gender")) {
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strNomineeDobEdit);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectNomineeYear = period.getYears();
                                        Log.e("selectNomineeYear", String.valueOf(selectNomineeYear));
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                            }
                        }

                    }
                });
                singlePicker.show();
            }
        });
        linerRelationShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("Self");
                items1.add("Spouse");
                items1.add("Other");
                items1.add("Son");
                items1.add("Daughter in law");
                items1.add("Son in law");
                items1.add("Mother");
                items1.add("Father");
                items1.add("Father in law");
                items1.add("Mother in law");
                items1.add("Brother");
                items1.add("Sister");
                items1.add("Daughter");
                items1.add("Grand Father");
                items1.add("Grand Mother");
                items1.add("Grand Son");
                items1.add("Grand Daughter");
                items1.add("Legal Heir");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strNomineeRelationEdit = items1.get(options1);
                        NomineeRelationEdit.setText(strNomineeRelationEdit);
                        if (strNomineeRelationEdit.equals("Self")) {
                            if (strCheckBoxSelf.equals("Checked")){
                                strNomineeName = strEdtNameSelf;
                                strNomineeGenderEdit = strEditGenderSelf;
                                strNomineeDobEdit = strSelfAgeEditText;
                                selectNomineeYear = selectYearAdult;
                                NomineeName.setText(strNomineeName);
                                NomineeDobEdit.setText(strNomineeDobEdit);
                                NomineeGenderEdit.setText(strNomineeGenderEdit);
                            }else{
                                if (strCheckBoxSpouse.equals("Checked")||strCheckBoxMother.equals("Checked")||strCheckBoxFather.equals("Checked")||strCheckBoxMotherLaw.equals("Checked")||strCheckBoxFatherLaw.equals("Checked")){
                                    strProposerEdtName = proposerEdtName.getText().toString();
                                    strNomineeName = strProposerEdtName;
                                    strNomineeDobEdit = strProposerEditDob;
                                    selectNomineeYear = selectYearProposer;
                                    strNomineeGenderEdit = strEditGenderProposer;
                                    NomineeName.setText(strNomineeName);
                                    NomineeDobEdit.setText(strNomineeDobEdit);
                                    NomineeGenderEdit.setText(strNomineeGenderEdit);
                                }
                            }
                            NomineeName.setClickable(false);
                            NomineeName.setEnabled(false);
                            NomineeName.setCursorVisible(false);
                            NomineeSpinner.setClickable(false);
                            NomineeDobEdit.setClickable(false);
                            NomineeDobEdit.setEnabled(false);
                            NomineeDobEdit.setCursorVisible(false);
                        } else {
                            strNomineeName = "";
                            strNomineeDobEdit = "";
                            strNomineeGenderEdit = "Select Gender";
                            NomineeName.setText(strNomineeName);
                            NomineeDobEdit.setText(strNomineeDobEdit);
                            NomineeGenderEdit.setText(strNomineeGenderEdit);
                            NomineeName.setClickable(true);
                            NomineeName.setEnabled(true);
                            NomineeName.setCursorVisible(true);
                            NomineeDobEdit.setClickable(true);
                            NomineeDobEdit.setEnabled(true);
                            NomineeDobEdit.setCursorVisible(true);
                            NomineeSpinner.setClickable(true);
                        }
                    }
                });
                singlePicker.show();
            }
        });

        calendarIconDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNomineeCalender();
            }
        });
        calendarAppointeeIconDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNomineeAppointCalender();
            }
        });
        linerAppointeeSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PersonalInformationCHI.this);
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
                        strAppointeeGenderEdit = items1.get(options1);
                        AppointeeGenderEdit.setText(strAppointeeGenderEdit);
                        if (!strAppointeeGenderEdit.equals("Select Gender")) {
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strAppointeeNomineeDobEdit);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectAppointee = period.getYears();
                                        Log.e("selectSecSonChild", String.valueOf(selectSecSonChild));
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                if (selectAppointee < 18 || (selectAppointee > 75)) {
                                    Toast.makeText(PersonalInformationCHI.this, "Appointee Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
                                    strAppointeeNomineeDobEdit = "Select Dob";
                                    appointeeNomineeDobEdit.setText(strAppointeeNomineeDobEdit);

                                }
                            }
                        }

                    }
                });
                singlePicker.show();
            }
        });

        SpouseDobImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSpouseCalender();
            }
        });
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strProposerEdtName = proposerEdtName.getText().toString();
                strWeightEditProposer = WeightEditProposer.getText().toString();
                strProposerEditDob = proposerEditDob.getText().toString();
                strEdtNameSelf = EdtNameSelf.getText().toString();
                str_edt_phone = PhoneNumberEdit.getText().toString();
                strEmailIDEditSelf = EmailIDEditSelf.getText().toString();
                strPermanentAddressEdit = PermanentAddressEdit.getText().toString();
                strPermanentAddressEdit2 = PermanentAddressEdit2.getText().toString();
                strCorrespondenceAddressEdit = CorrespondenceAddressEdit.getText().toString();
                strCorrespondenceAddressEdit2 = CorrespondenceAddressEdit2.getText().toString();
                strNomineeRelationEdit = NomineeRelationEdit.getText().toString();
                strPinCodeEdit = PinCodeEdit.getText().toString();
                strCityEdit = CityEdit.getText().toString();
                strStateEdit = StateEdit.getText().toString();
                strLandMarkEdit = LandMarkEditProposer.getText().toString();
                strLandMarkEdit = LandMarkEdit.getText().toString();
                strWeightEditSelf = WeightEditSelf.getText().toString();
                strBMIEdit = BMIEdit.getText().toString();
                strNomineeName = NomineeName.getText().toString();
                strNomineeGenderEdit = NomineeGenderEdit.getText().toString();
                strContactNominee = ContactNominee.getText().toString();
                strNomineeDobEdit = NomineeDobEdit.getText().toString();
                strSpouseNameEditText = SpouseNameEditText.getText().toString();
                strWeightEditSpouse = WeightEditSpouse.getText().toString();
                strChildOneNameEdit = ChildOneNameEdit.getText().toString();
                str_oneWeightEdit = oneWeightEdit.getText().toString();
                strSecondChildNameEdit = SecondChildNameEdit.getText().toString();
                strtwoWeightEdit = twoWeightEdit.getText().toString();
                strThirdChildNameEdit = ThirdChildNameEdit.getText().toString();
                str_thirdWeightEdit = thirdWeightEdit.getText().toString();
                strFourChildNameEdit = FourChildNameEdit.getText().toString();
                strFourWeightEdit = FourWeightEdit.getText().toString();
                strMotherEditTextName = MotherEditTextName.getText().toString();
                strMotherWeightEdit = MotherWeightEdit.getText().toString();
                strFatherEditTextName = FatherEditTextName.getText().toString();
                strFatherWeightEdit = FatherWeightEdit.getText().toString();
                strMotherLawEditText = MotherLawEditText.getText().toString();
                strWeightMotherLawEdit = WeightMotherLawEdit.getText().toString();
                strFatherLawNameEdit = FatherLawNameEdit.getText().toString();
                strFatherLawWeightEdit = FatherLawWeightEdit.getText().toString();
                strAppointeeNomineeName = appointeeNomineeName.getText().toString();
                strAppointeeNomineeDobEdit = appointeeNomineeDobEdit.getText().toString();
                strAppointeeGenderEdit = AppointeeGenderEdit.getText().toString();
//                else if (strContactNominee.equals("")){
//                    Toast.makeText(PersonalInformationCHI.this, "Enter Nominee Contact Number", Toast.LENGTH_SHORT).show();
//                }else if (strNomineeDobEdit.equals("Nominee Dob")||strNomineeDobEdit.equals("")){
//                    Toast.makeText(PersonalInformationCHI.this, "Enter Nominee Dob Number", Toast.LENGTH_SHORT).show();
//                }

                if (str_policyType_spinner.equals("Individual")) {
                    if (strCheckBoxSelf.equals("Checked")) {
                        if (strEdtNameSelf.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Self Name", Toast.LENGTH_SHORT).show();
                        } else if (strSelfAgeEditText.equals("Select Dob") || strSelfAgeEditText.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Self DOB", Toast.LENGTH_SHORT).show();
                        } else if (selectYearAdult < 18 || selectYearAdult > 55) {
//                            Toast.makeText(PersonalInformationCHI.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                            showAgePopupNSTP();
                        }else if (strEditGenderSelf.equals("Select Gender")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select Self Gender", Toast.LENGTH_SHORT).show();
                        } else if (strEditOccupationSelf.equals("Select Occupation")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select Self Occupation", Toast.LENGTH_SHORT).show();
                        }else if (str_edt_phone.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                        } else if (strEmailIDEditSelf.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Self Email", Toast.LENGTH_SHORT).show();
                        } else if (!Patterns.EMAIL_ADDRESS.matcher(strEmailIDEditSelf).matches()) {
                            Toast.makeText(PersonalInformationCHI.this, "Email address is not valid", Toast.LENGTH_SHORT).show();
                        } else if (strPermanentAddressEdit.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Permanent Address Line 1", Toast.LENGTH_SHORT).show();
                        } else if (strPermanentAddressEdit2.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Permanent Address Line 2", Toast.LENGTH_SHORT).show();
                        } else if (strPinCodeEdit.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter PinCode", Toast.LENGTH_SHORT).show();
                        } else if (strEditFtSelf.equals("Ft")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select Self Ft", Toast.LENGTH_SHORT).show();
                        } else if (strEditInchesSelf.equals("Inches")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select Self Inches", Toast.LENGTH_SHORT).show();
                        }else if (strWeightEditSelf.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter  Weight", Toast.LENGTH_SHORT).show();
                        } else if (!(Double.parseDouble(strBMIEdit) >= 16.0 && Double.parseDouble(strBMIEdit) <= 33.0)) {
//                            alertPopup();
                            showAgePopupNSTP();
                        } else if (strNomineeName.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Nominee Name", Toast.LENGTH_SHORT).show();
                        }else if (strNomineeGenderEdit.equals("Select Gender")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select Nominee Gender", Toast.LENGTH_SHORT).show();
                        } else if (selectNomineeYear <= 5) {
                            if (strAppointeeNomineeName.equals("")) {
                                Toast.makeText(PersonalInformationCHI.this, "Enter Appointee Name", Toast.LENGTH_SHORT).show();
                            } else if (strAppointeeNomineeDobEdit.equals("Select Dob") || strAppointeeNomineeDobEdit.equals("")) {
                                Toast.makeText(PersonalInformationCHI.this, "Enter Appointee DOB", Toast.LENGTH_SHORT).show();
                            } else if (strAppointeeGenderEdit.equals("Select Gender")) {
                                Toast.makeText(PersonalInformationCHI.this, "Select Appointee Gender", Toast.LENGTH_SHORT).show();
                            } else {
                                if (strCheckBoxSpouse.equals("Checked")) {
                                    SpouseMethod();
                                } else if (mCounter == 1) {
                                    ChildOneMethod();
                                } else if (mCounter == 2) {
                                    ChildTwoMethod();
                                } else if (mCounter == 3) {
                                    ChildThirdMethod();
                                } else if (mCounter == 4) {
                                    ChildFourthMethod();
                                } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                    CheckMotherFatherCondition();
                                } else {
                                    methoElse();
                                }
                            }
                        } else {
                            methoElse();
                        }
                    }
                    else {
                        str_edt_phone = PhoneNumberEditProposer.getText().toString();
                        strEmailIDEditSelf = EmailIDEditSelfProposer.getText().toString();
                        strPinCodeEdit = PinCodeEditProposer.getText().toString();
                        if (strProposerEdtName.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Proposer Name", Toast.LENGTH_SHORT).show();
                        } else if (strProposerEditDob.equals("Select Dob") || strProposerEditDob.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Proposer DOB", Toast.LENGTH_SHORT).show();
                        }else if (selectYearProposer < 18 || (selectYearProposer > 55)) {
                            Toast.makeText(PersonalInformationCHI.this, "Proposer age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                            showAgePopupNSTP();
                        } else if (strEditGenderProposer.equals("Select Gender")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select Proposer Gender", Toast.LENGTH_SHORT).show();
                        }else if (str_edt_phone.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                        } else if (strEditOccupationProposer.equals("Select Occupation")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select Proposer Occupation", Toast.LENGTH_SHORT).show();
                        }
//                        else if (strProposerEditFt.equals("Ft")) {
//                            Toast.makeText(PersonalInformationCHI.this, "Select Proposer Ft", Toast.LENGTH_SHORT).show();
//                        } else if (strProposerEditInches.equals("Inches")) {
//                            Toast.makeText(PersonalInformationCHI.this, "Select Proposer Inches", Toast.LENGTH_SHORT).show();
//                        } else if (strWeightEditProposer.equals("")) {
//                            Toast.makeText(PersonalInformationCHI.this, "Select Proposer Weight", Toast.LENGTH_SHORT).show();
//                        } else if (!(Double.parseDouble(strProposerBMIEdit) >= 16.0 && Double.parseDouble(strProposerBMIEdit) <= 33.0)) {
//                            alertPopup();
//                        }

                        else if (strEdtNameSelf.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter  Name", Toast.LENGTH_SHORT).show();
                        } else if (strSelfAgeEditText.equals("Select Dob") || strSelfAgeEditText.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter  DOB", Toast.LENGTH_SHORT).show();
                        } else if (selectYearAdult < 18 || selectYearAdult > 55) {
//                            Toast.makeText(PersonalInformationCHI.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                            showAgePopupNSTP();
                        }else if (strEditGenderSelf.equals("Select Gender")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select  Gender", Toast.LENGTH_SHORT).show();
                        } else if (strEditOccupationSelf.equals("Select Occupation")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select  Occupation", Toast.LENGTH_SHORT).show();
                        } else if (str_edt_phone.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                        }else if (strEmailIDEditSelf.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter  Email", Toast.LENGTH_SHORT).show();
                        } else if (!Patterns.EMAIL_ADDRESS.matcher(strEmailIDEditSelf).matches()) {
                            Toast.makeText(PersonalInformationCHI.this, "Email address is not valid", Toast.LENGTH_SHORT).show();
                        }
                        else if (strPermanentAddressEdit.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Permanent Address Line 1", Toast.LENGTH_SHORT).show();
                        } else if (strPermanentAddressEdit2.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Permanent Address Line 2", Toast.LENGTH_SHORT).show();
                        } else if (strPinCodeEdit.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter PinCode", Toast.LENGTH_SHORT).show();
                        } else if (strEditFtSelf.equals("Ft")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select  Ft", Toast.LENGTH_SHORT).show();
                        } else if (strEditInchesSelf.equals("Inches")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select  Inches", Toast.LENGTH_SHORT).show();
                        } else if (strWeightEditSelf.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter  Weight", Toast.LENGTH_SHORT).show();
                        }else if (!(Double.parseDouble(strBMIEdit) >= 16.0 && Double.parseDouble(strBMIEdit) <= 33.0)) {
//                            alertPopup();
                            showAgePopupNSTP();
                        } else if (strNomineeName.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Nominee Name", Toast.LENGTH_SHORT).show();
                        }else if (strNomineeGenderEdit.equals("Select Gender")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select Nominee Gender", Toast.LENGTH_SHORT).show();
                        } else if (selectNomineeYear <= 5) {
                            if (strAppointeeNomineeName.equals("")) {
                                Toast.makeText(PersonalInformationCHI.this, "Enter Appointee Name", Toast.LENGTH_SHORT).show();
                            } else if (strAppointeeNomineeDobEdit.equals("Select Dob") || strAppointeeNomineeDobEdit.equals("")) {
                                Toast.makeText(PersonalInformationCHI.this, "Enter Appointee DOB", Toast.LENGTH_SHORT).show();
                            } else if (strAppointeeGenderEdit.equals("Select Gender")) {
                                Toast.makeText(PersonalInformationCHI.this, "Select Appointee Gender", Toast.LENGTH_SHORT).show();
                            } else {
                                if (strCheckBoxSpouse.equals("Checked")) {
                                    SpouseMethod();
                                } else if (mCounter == 1) {
                                    ChildOneMethod();
                                } else if (mCounter == 2) {
                                    ChildTwoMethod();
                                } else if (mCounter == 3) {
                                    ChildThirdMethod();
                                } else if (mCounter == 4) {
                                    ChildFourthMethod();
                                } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                    CheckMotherFatherCondition();
                                } else {
                                    methoElse();
                                }
                            }
                        } else {
                            methoElse();
                        }
                    }
                }
                else {
                    if (strCheckBoxSelf.equals("Checked")) {
                        selfMethod();
                    }
                    else {
                        str_edt_phone = PhoneNumberEditProposer.getText().toString();
                        strEmailIDEditSelf = EmailIDEditSelfProposer.getText().toString();
                        strPinCodeEdit = PinCodeEditProposer.getText().toString();
                        if (strProposerEdtName.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Proposer Name", Toast.LENGTH_SHORT).show();
                        } else if (strProposerEditDob.equals("Select Dob") || strProposerEditDob.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Proposer DOB", Toast.LENGTH_SHORT).show();
                        }else if (selectYearProposer < 18 || (selectYearProposer > 55)) {
                            Toast.makeText(PersonalInformationCHI.this, "Proposer age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                            showAgePopupNSTP();
                        } else if (str_edt_phone.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                        }else if (strEditGenderProposer.equals("Select Gender")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select Proposer Gender", Toast.LENGTH_SHORT).show();
                        } else if (strEditOccupationProposer.equals("Select Occupation")) {
                            Toast.makeText(PersonalInformationCHI.this, "Select Proposer Occupation", Toast.LENGTH_SHORT).show();
                        }else if (strEmailIDEditSelf.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter  Email", Toast.LENGTH_SHORT).show();
                        } else if (!Patterns.EMAIL_ADDRESS.matcher(strEmailIDEditSelf).matches()) {
                            Toast.makeText(PersonalInformationCHI.this, "Email address is not valid", Toast.LENGTH_SHORT).show();
                        }
                        else if (strPermanentAddressEdit.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Permanent Address Line 1", Toast.LENGTH_SHORT).show();
                        } else if (strPermanentAddressEdit2.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter Permanent Address Line 2", Toast.LENGTH_SHORT).show();
                        } else if (strPinCodeEdit.equals("")) {
                            Toast.makeText(PersonalInformationCHI.this, "Enter PinCode", Toast.LENGTH_SHORT).show();
                        }
//                        else if (strProposerEditFt.equals("Ft")) {
//                            Toast.makeText(PersonalInformationCHI.this, "Select Proposer Ft", Toast.LENGTH_SHORT).show();
//                        } else if (strProposerEditInches.equals("Inches")) {
//                            Toast.makeText(PersonalInformationCHI.this, "Select Proposer Inches", Toast.LENGTH_SHORT).show();
//                        } else if (strWeightEditProposer.equals("")) {
//                            Toast.makeText(PersonalInformationCHI.this, "Select Proposer Weight", Toast.LENGTH_SHORT).show();
//                        } else if (!(Double.parseDouble(strProposerBMIEdit) >= 16.0 && Double.parseDouble(strProposerBMIEdit) <= 33.0)) {
//                            alertPopup();
//                        }
                        else {
                            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){

                             if (strCheckBoxSelf.equals("Checked")) {
                                selfMethod();
                            } else if (strCheckBoxSpouse.equals("Checked")) {
                                SpouseMethod();
                            } else if (mCounter == 1) {
                                ChildOneMethod();
                            } else if (mCounter == 2) {
                                ChildTwoMethod();
                            } else if (mCounter == 3) {
                                ChildThirdMethod();
                            } else if (mCounter == 4) {
                                ChildFourthMethod();
                            } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                CheckMotherFatherCondition();
                            } else {
                                methoElse();
                            }
                          }
                            else {
                                if (strCheckBoxSelf.equals("Checked")||strCheckBoxSpouse.equals("Checked")) {
                                    strSpouseNameEditText = strEdtNameSelf;
                                    strSpouseBMIEdit = strBMIEdit;
                                    strSpouseOccupationEdit = strEditOccupationSelf;
                                    strSpouseGenderEdit = strEditGenderSelf;
                                    strSpouseAgeEditText = strSelfAgeEditText;
                                    selectYearSecondAdult = selectYearAdult;
                                    selfMethod1();
                                }
                           else if (mCounter == 1) {
                                ChildOneMethod();
                            } else if (mCounter == 2) {
                                ChildTwoMethod();
                            } else if (mCounter == 3) {
                                ChildThirdMethod();
                            } else if (mCounter == 4) {
                                ChildFourthMethod();
                            } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                CheckMotherFatherCondition();
                            } else {
                                methoElse();
                            }

                            }



                        }
                    }
                }
            }
        });
        BackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backMethod();
            }
        });
        ViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog alert_dialog;
                alert_dialog = new Dialog(PersonalInformationCHI.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.viewdetailsnewchi);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(alert_dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.gravity = Gravity.CENTER;
                Button buttonClose;
                buttonClose = alert_dialog.findViewById(R.id.buttonClose);
                TextView SumInsuredTxt = alert_dialog.findViewById(R.id.SumInsuredTxt);
                TextView TotalMember = alert_dialog.findViewById(R.id.TotalMember);
                TextView TotalDiscount = alert_dialog.findViewById(R.id.TotalDiscount);
                TextView longTermDiscountTxt = alert_dialog.findViewById(R.id.longTermDiscountTxt);
                TextView DirectDiscountTxt = alert_dialog.findViewById(R.id.DirectDiscountTxt);
                TextView SubCategoryDiscount = alert_dialog.findViewById(R.id.SubCategoryDiscount);
                TextView CoPaymentDiscountTxt = alert_dialog.findViewById(R.id.CoPaymentDiscountTxt);
                TextView TreatmentDiscount = alert_dialog.findViewById(R.id.TreatmentDiscount);
                TextView OrganDiscountAmount = alert_dialog.findViewById(R.id.OrganDiscountAmount);
                TextView TotalAddOn = alert_dialog.findViewById(R.id.TotalAddOn);
                LinearLayout DailyCashViewTxt = alert_dialog.findViewById(R.id.DailyCashViewTxt);
                TextView DailyCashViewTxtAmount = alert_dialog.findViewById(R.id.DailyCashViewTxtAmount);
                LinearLayout CriticalTxt = alert_dialog.findViewById(R.id.CriticalTxt);
                TextView CriticalTxtPremium = alert_dialog.findViewById(R.id.CriticalTxtPremium);
                LinearLayout ExtensionPreTxt = alert_dialog.findViewById(R.id.ExtensionPreTxt);
                TextView ExtensionPreTxtPremium = alert_dialog.findViewById(R.id.ExtensionPreTxtPremium);
                LinearLayout ExtensionPostTxt = alert_dialog.findViewById(R.id.ExtensionPostTxt);
                TextView ExtensionPostTxtPremium = alert_dialog.findViewById(R.id.ExtensionPostTxtPremium);
                LinearLayout MaternityTxt = alert_dialog.findViewById(R.id.MaternityTxt);
                TextView MaternityTxtPremium = alert_dialog.findViewById(R.id.MaternityTxtPremium);
                LinearLayout CoverageTxt = alert_dialog.findViewById(R.id.CoverageTxt);
                TextView CoverageTxtPremium = alert_dialog.findViewById(R.id.CoverageTxtPremium);
                LinearLayout ConditionTxt = alert_dialog.findViewById(R.id.ConditionTxt);
                TextView ConditionTxtPremium = alert_dialog.findViewById(R.id.ConditionTxtPremium);
                LinearLayout PersonalCoverTxt = alert_dialog.findViewById(R.id.PersonalCoverTxt);
                TextView PersonalCoverTxtPremium = alert_dialog.findViewById(R.id.PersonalCoverTxtPremium);
                TextView PersonalBTxt = alert_dialog.findViewById(R.id.PersonalBTxt);
                TextView PersonalATxt = alert_dialog.findViewById(R.id.PersonalATxt);
                LinearLayout PreExitingTxt = alert_dialog.findViewById(R.id.PreExitingTxt);
                TextView PreExitingTxtPremium = alert_dialog.findViewById(R.id.PreExitingTxtPremium);
                LinearLayout OutpatientDentalTxt = alert_dialog.findViewById(R.id.OutpatientDentalTxt);
                TextView OutpatientDentalTxtPremium = alert_dialog.findViewById(R.id.OutpatientDentalTxtPremium);
                LinearLayout EmergencyTravellingTxt = alert_dialog.findViewById(R.id.EmergencyTravellingTxt);
                TextView EmergencyTravellingTxtPremium = alert_dialog.findViewById(R.id.EmergencyTravellingTxtPremium);
                LinearLayout SecondTxt = alert_dialog.findViewById(R.id.SecondTxt);
                TextView SecondTxtPremium = alert_dialog.findViewById(R.id.SecondTxtPremium);
                LinearLayout RestCureTxt = alert_dialog.findViewById(R.id.RestCureTxt);
                TextView RestCureTxtPremium = alert_dialog.findViewById(R.id.RestCureTxtPremium);
                LinearLayout ObesityTxt = alert_dialog.findViewById(R.id.ObesityTxt);
                TextView ObesityTxtPremium = alert_dialog.findViewById(R.id.ObesityTxtPremium);
                LinearLayout SterilityInfertilityTxt = alert_dialog.findViewById(R.id.SterilityInfertilityTxt);
                TextView SterilityInfertilityTxtPremium = alert_dialog.findViewById(R.id.SterilityInfertilityTxtPremium);
                LinearLayout EnhancedTxt = alert_dialog.findViewById(R.id.EnhancedTxt);
                TextView EnhancedTxtPremium = alert_dialog.findViewById(R.id.EnhancedTxtPremium);
                LinearLayout MedicallyTxt = alert_dialog.findViewById(R.id.MedicallyTxt);
                TextView MedicallyTxtPremium = alert_dialog.findViewById(R.id.MedicallyTxtPremium);
                LinearLayout EmergencyAssistanceTxt = alert_dialog.findViewById(R.id.EmergencyAssistanceTxt);
                TextView EmergencyAssistanceTxtPremium = alert_dialog.findViewById(R.id.EmergencyAssistanceTxtPremium);
                LinearLayout HomeCareTxt = alert_dialog.findViewById(R.id.HomeCareTxt);
                TextView HomeCareTxtPremium = alert_dialog.findViewById(R.id.HomeCareTxtPremium);
                LinearLayout WellnessBenefitTxt = alert_dialog.findViewById(R.id.WellnessBenefitTxt);
                TextView WellnessBenefitTxtPremium = alert_dialog.findViewById(R.id.WellnessBenefitTxtPremium);
                LinearLayout DiseaseManagementTxt = alert_dialog.findViewById(R.id.DiseaseManagementTxt);
                TextView DiseaseManagementTxtPremium = alert_dialog.findViewById(R.id.DiseaseManagementTxtPremium);
                LinearLayout GlobalCoverTxt = alert_dialog.findViewById(R.id.GlobalCoverTxt);
                TextView GlobalCoverTxtPremium = alert_dialog.findViewById(R.id.GlobalCoverTxtPremium);
                LinearLayout ModernTreatmentTxt = alert_dialog.findViewById(R.id.ModernTreatmentTxt);
                TextView ModernTreatmentTxtPremium = alert_dialog.findViewById(R.id.ModernTreatmentTxtPremium);
                LinearLayout PremiumWaiverTxt = alert_dialog.findViewById(R.id.PremiumWaiverTxt);
                TextView PremiumWaiverTxtPremium = alert_dialog.findViewById(R.id.PremiumWaiverTxtPremium);
                TextView TotalPremiumTxtView = alert_dialog.findViewById(R.id.TotalPremiumTxtView);
                TextView GSTTxtView = alert_dialog.findViewById(R.id.GSTTxtView);
                TextView BasicPremiumTxtView = alert_dialog.findViewById(R.id.BasicPremiumTxtView);
                GSTTxtView.setText(GSt);
                SumInsuredTxt.setText(strSumInsured);
                BasicPremiumTxtView.setText(strBasicPremium);
                TextView LongTermTxt = alert_dialog.findViewById(R.id.LongTermTxt);
                TextView subLimitTxt = alert_dialog.findViewById(R.id.subLimitTxt);
                TextView CoPaymentTxt = alert_dialog.findViewById(R.id.CoPaymentTxt);
                String strTotalMember = String.valueOf(FamilyTypeCounter + mCounter);
                TotalMember.setText(strTotalMember);
                double strTotalDiscount = Discounts + Double.parseDouble(DirectPolicyDiscountPremium);
                String newTotalDiscount = valueOf(Math.round(strTotalDiscount * 100.0) / 100.0);
                TotalDiscount.setText(newTotalDiscount);
                longTermDiscountTxt.setText(String.valueOf(LongTermDiscountDiscountPremium));
                SubCategoryDiscount.setText(String.valueOf(SubCategoryDiscountPremium));
                CoPaymentDiscountTxt.setText(String.valueOf(doubleCoPaymentDiscountPremium));
                OrganDiscountAmount.setText(String.valueOf(OrganDonorDiscountPremium));
                TreatmentDiscount.setText("0.0");
                DirectDiscountTxt.setText(DirectPolicyDiscountPremium);
                TotalAddOn.setText(String.valueOf(addons));
                TotalPremiumTxtView.setText(strTotalPremium);
                if (yearRadio.equals("TwoYearFirstCard") || yearRadio.equals("TwoYearSecondCard")) {
                    LongTermTxt.setText("(5%)");
                } else if (yearRadio.equals("ThreeYearFirstCard") || yearRadio.equals("ThreeYearSecondCard")) {
                    LongTermTxt.setText("(7.5%)");
                } else {
                    LongTermTxt.setText("");
                }
                if (CoPaymentStatus.equals("True")) {
                    if (CoPaymentLoading.equals("10")) {
                        CoPaymentTxt.setText("(10%)");
                    } else if (CoPaymentLoading.equals("20")) {
                        CoPaymentTxt.setText("(20%)");
                    } else if (CoPaymentLoading.equals("30")) {
                        CoPaymentTxt.setText("(30%)");
                    } else if (CoPaymentLoading.equals("40")) {
                        CoPaymentTxt.setText("(40%)");
                    } else if (CoPaymentLoading.equals("50")) {
                        CoPaymentTxt.setText("(50%)");
                    }
                } else {
                    CoPaymentTxt.setText("");
                }
                if (SubCategoryDiscountStatus.equals("True")) {
                    if (SubCategory.equals("A")) {
                        subLimitTxt.setText("(10%)");
                    } else if (SubCategory.equals("B")) {
                        subLimitTxt.setText("(7.50%)");
                    } else if (SubCategory.equals("C")) {
                        subLimitTxt.setText("(5%)");
                    }
                } else {
                    subLimitTxt.setText("");
                }

                if (DailyHospitalSatus.equals("True")) {
                    DailyCashViewTxt.setVisibility(View.VISIBLE);
                    DailyCashViewTxtAmount.setText(DailyHospitalCoverPremium);
                } else {
                    DailyCashViewTxt.setVisibility(View.GONE);
                }
                if (CriticalStatus.equals("True")) {
                    CriticalTxt.setVisibility(View.VISIBLE);
                    CriticalTxtPremium.setText(CriticalIllnessCoverPremium);
                } else {
                    CriticalTxt.setVisibility(View.GONE);
                }

                if (ExtensionPreHospitalization.equals("True")) {
                    ExtensionPreTxt.setVisibility(View.VISIBLE);
                    ExtensionPreTxtPremium.setText(ExtensionPreHospitalizationCoverPremium);
                } else {
                    ExtensionPreTxt.setVisibility(View.GONE);
                }

                if (ExtensionPr0Hospitalization.equals("True")) {
                    ExtensionPostTxt.setVisibility(View.VISIBLE);
                    ExtensionPostTxtPremium.setText(ExtensionProHospitalizationCoverPremium);
                } else {
                    ExtensionPostTxt.setVisibility(View.GONE);
                }

                if (MaternityAndChildcare.equals("True")) {
                    MaternityTxt.setVisibility(View.VISIBLE);
                    MaternityTxtPremium.setText(MaternityChildcareCoverPremium);
                } else {
                    MaternityTxt.setVisibility(View.GONE);
                }
                if (CoverageNonMedical.equals("True")) {
                    CoverageTxt.setVisibility(View.VISIBLE);
                    CoverageTxtPremium.setText(CoverageNonMedicalCoverPremium);
                } else {
                    CoverageTxt.setVisibility(View.GONE);
                }
                if (ConditionWaiverStatus.equals("True")) {
                    ConditionTxt.setVisibility(View.VISIBLE);
                    ConditionTxtPremium.setText(ConditionWaiverCoverPremium);
                } else {
                    ConditionTxt.setVisibility(View.GONE);
                }
                if (PersonalStatus.equals("True")) {
                    PersonalCoverTxt.setVisibility(View.VISIBLE);
                    PersonalCoverTxtPremium.setText(PersonalAccidentCoverPremium);
                } else {
                    PersonalCoverTxt.setVisibility(View.GONE);
                }

                if (PersonalAccidentBCoverStatus.equals("True")) {
                    PersonalBTxt.setVisibility(View.VISIBLE);
                } else {
                    PersonalBTxt.setVisibility(View.GONE);
                }
                if (PersonalAccidentACoverStatus.equals("True")) {
                    PersonalATxt.setVisibility(View.VISIBLE);
                } else {
                    PersonalATxt.setVisibility(View.GONE);
                }
                if (PreExistingDiseaseStatus.equals("True")) {
                    PreExitingTxt.setVisibility(View.VISIBLE);
                    PreExitingTxtPremium.setText(PreExistingDiseaseCoverPremium);
                } else {
                    PreExitingTxt.setVisibility(View.GONE);
                }
                if (OutpatientDentalStatus.equals("True")) {
                    OutpatientDentalTxt.setVisibility(View.VISIBLE);
                    OutpatientDentalTxtPremium.setText(OutpatientDentalCoverPremium);
                } else {
                    OutpatientDentalTxt.setVisibility(View.GONE);
                }
                if (EmergencyTravellingStatus.equals("True")) {
                    EmergencyTravellingTxt.setVisibility(View.VISIBLE);
                    EmergencyTravellingTxtPremium.setText(EmergencyTravellingCoverPremium);
                } else {
                    EmergencyTravellingTxt.setVisibility(View.GONE);
                }
                if (SecondOpinionStatus.equals("True")) {
                    SecondTxt.setVisibility(View.VISIBLE);
                    SecondTxtPremium.setText(SecondOpinionCoverPremium);
                } else {
                    SecondTxt.setVisibility(View.GONE);
                }
                if (RestCureStatus.equals("True")) {
                    RestCureTxt.setVisibility(View.VISIBLE);
                    RestCureTxtPremium.setText(RestCureCoverPremium);
                } else {
                    RestCureTxt.setVisibility(View.GONE);
                }
                if (ObesityWeightStatus.equals("True")) {
                    ObesityTxt.setVisibility(View.VISIBLE);
                    ObesityTxtPremium.setText(ObesityWeightCoverPremium);
                } else {
                    ObesityTxt.setVisibility(View.GONE);
                }
                if (SterilityInfertilityStatus.equals("True")) {
                    SterilityInfertilityTxt.setVisibility(View.VISIBLE);
                    SterilityInfertilityTxtPremium.setText(SterilityInfertilityCoverPremium);
                } else {
                    SterilityInfertilityTxt.setVisibility(View.GONE);
                }
                if (EnhancedOrganStatus.equals("True")) {
                    EnhancedTxt.setVisibility(View.VISIBLE);
                    EnhancedTxtPremium.setText(EnhancedCoverPremium);
                } else {
                    EnhancedTxt.setVisibility(View.GONE);
                }
                if (MedicallyAdvisedStatus.equals("True")) {
                    MedicallyTxt.setVisibility(View.VISIBLE);
                    MedicallyTxtPremium.setText(MedicallyAdvisedCoverPremium);
                } else {
                    MedicallyTxt.setVisibility(View.GONE);
                }
                if (EmergencyAssistanceStatus.equals("True")) {
                    EmergencyAssistanceTxt.setVisibility(View.VISIBLE);
                    EmergencyAssistanceTxtPremium.setText(EmergencyAssistanceCoverPremium);
                } else {
                    EmergencyAssistanceTxt.setVisibility(View.GONE);
                }
                if (HomeCareStatus.equals("True")) {
                    HomeCareTxt.setVisibility(View.VISIBLE);
                    HomeCareTxtPremium.setText(HomeCareCoverPremium);
                } else {
                    HomeCareTxt.setVisibility(View.GONE);
                }
                if (WellnessBenefitStatus.equals("True")) {
                    WellnessBenefitTxt.setVisibility(View.VISIBLE);
                    WellnessBenefitTxtPremium.setText(WellnessBenefitCoverPremium);
                } else {
                    WellnessBenefitTxt.setVisibility(View.GONE);
                }
                if (DiseaseManagementStatus.equals("True")) {
                    DiseaseManagementTxt.setVisibility(View.VISIBLE);
                    DiseaseManagementTxtPremium.setText(DiseaseManagementCoverPremium);
                } else {
                    DiseaseManagementTxt.setVisibility(View.GONE);
                }
                if (GlobalCoverStatus.equals("True")) {
                    GlobalCoverTxt.setVisibility(View.VISIBLE);
                    GlobalCoverTxtPremium.setText(GlobalCoverCoverPremium);
                } else {
                    GlobalCoverTxt.setVisibility(View.GONE);
                }
                if (ModernTreatmentsStatus.equals("True")) {
                    ModernTreatmentTxt.setVisibility(View.VISIBLE);
                    ModernTreatmentTxtPremium.setText(ModernTreatmentCoverPremium);
                } else {
                    ModernTreatmentTxt.setVisibility(View.GONE);
                }
                if (PremiumWaiverStatus.equals("True")) {
                    PremiumWaiverTxt.setVisibility(View.VISIBLE);
                    PremiumWaiverTxtPremium.setText(PremiumWaiverCoverPremium);
                } else {
                    PremiumWaiverTxt.setVisibility(View.GONE);
                }
                alert_dialog.show();
                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert_dialog.dismiss();
                    }
                });
            }
        });
    }
    private void selfMethod1() {
        if (strEdtNameSelf.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  Name", Toast.LENGTH_SHORT).show();
        } else if (strSelfAgeEditText.equals("Select Dob") || strSelfAgeEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  DOB", Toast.LENGTH_SHORT).show();
        }else if (selectYearAdult < 18 || selectYearAdult > 55) {
//            Toast.makeText(PersonalInformationCHI.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
            showAgePopupNSTP();
        }else if (strEditGenderSelf.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select  Gender", Toast.LENGTH_SHORT).show();
        } else if (strEditOccupationSelf.equals("Select Occupation")) {
            Toast.makeText(PersonalInformationCHI.this, "Select  Occupation", Toast.LENGTH_SHORT).show();
        } else if (strEmailIDEditSelf.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  Name", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(strEmailIDEditSelf).matches()) {
            Toast.makeText(PersonalInformationCHI.this, "Email address is not valid", Toast.LENGTH_SHORT).show();
        } else if (strPermanentAddressEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Permanent Address Line 1", Toast.LENGTH_SHORT).show();
        } else if (strPermanentAddressEdit2.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Permanent Address Line 2", Toast.LENGTH_SHORT).show();
        } else if (strPinCodeEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter PinCode", Toast.LENGTH_SHORT).show();
        } else if (strEditFtSelf.equals("Ft")) {
            Toast.makeText(PersonalInformationCHI.this, "Select  Ft", Toast.LENGTH_SHORT).show();
        } else if (strEditInchesSelf.equals("Inches")) {
            Toast.makeText(PersonalInformationCHI.this, "Select  Inches", Toast.LENGTH_SHORT).show();
        }else if (strWeightEditSelf.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  Weight", Toast.LENGTH_SHORT).show();
        } else if (!(Double.parseDouble(strBMIEdit) >= 16.0 && Double.parseDouble(strBMIEdit) <= 33.0)) {
//            alertPopup();
            showAgePopupNSTP();
        } else if (strNomineeName.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Nominee Name", Toast.LENGTH_SHORT).show();
        } else if (strNomineeGenderEdit.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select Nominee Gender", Toast.LENGTH_SHORT).show();
        }else if (strNomineeDobEdit.equals("Nominee Dob") || strNomineeDobEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Nominee Dob Number", Toast.LENGTH_SHORT).show();
        } else if (selectNomineeYear <= 5) {
            if (strAppointeeNomineeName.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Appointee Name", Toast.LENGTH_SHORT).show();
            } else if (strAppointeeNomineeDobEdit.equals("Select Dob") || strAppointeeNomineeDobEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Appointee DOB", Toast.LENGTH_SHORT).show();
            } else if (strAppointeeGenderEdit.equals("Select Gender")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Appointee Gender", Toast.LENGTH_SHORT).show();
            } else {
                if (mCounter == 1) {
                    ChildOneMethod();
                } else if (mCounter == 2) {
                    ChildTwoMethod();
                } else if (mCounter == 3) {
                    ChildThirdMethod();
                } else if (mCounter == 4) {
                    ChildFourthMethod();
                } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    CheckMotherFatherCondition();
                } else {
                    methoElse();
                }
            }
        } else {
            if (mCounter == 1) {
                ChildOneMethod();
            } else if (mCounter == 2) {
                ChildTwoMethod();
            } else if (mCounter == 3) {
                ChildThirdMethod();
            } else if (mCounter == 4) {
                ChildFourthMethod();
            } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                CheckMotherFatherCondition();
            } else {
                methoElse();
            }

        }
    }
    private void selfMethod() {
        str_edt_phone = PhoneNumberEdit.getText().toString();
        if (strEdtNameSelf.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  Name", Toast.LENGTH_SHORT).show();
        } else if (strSelfAgeEditText.equals("Select Dob") || strSelfAgeEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  DOB", Toast.LENGTH_SHORT).show();
        }else if (selectYearAdult < 18 || selectYearAdult > 55) {
//            Toast.makeText(PersonalInformationCHI.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
            showAgePopupNSTP();
        }else if (strEditGenderSelf.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select  Gender", Toast.LENGTH_SHORT).show();
        } else if (strEditOccupationSelf.equals("Select Occupation")) {
            Toast.makeText(PersonalInformationCHI.this, "Select  Occupation", Toast.LENGTH_SHORT).show();
        }else if (str_edt_phone.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        } else if (strEmailIDEditSelf.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  Email", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(strEmailIDEditSelf).matches()) {
            Toast.makeText(PersonalInformationCHI.this, "Email address is not valid", Toast.LENGTH_SHORT).show();
        } else if (strPermanentAddressEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Permanent Address Line 1", Toast.LENGTH_SHORT).show();
        } else if (strPermanentAddressEdit2.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Permanent Address Line 2", Toast.LENGTH_SHORT).show();
        } else if (strPinCodeEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter PinCode", Toast.LENGTH_SHORT).show();
        } else if (strEditFtSelf.equals("Ft")) {
            Toast.makeText(PersonalInformationCHI.this, "Select  Ft", Toast.LENGTH_SHORT).show();
        } else if (strEditInchesSelf.equals("Inches")) {
            Toast.makeText(PersonalInformationCHI.this, "Select  Inches", Toast.LENGTH_SHORT).show();
        } else if (strWeightEditSelf.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  Weight", Toast.LENGTH_SHORT).show();
        }else if (!(Double.parseDouble(strBMIEdit) >= 16.0 && Double.parseDouble(strBMIEdit) <= 33.0)) {
//            alertPopup();
            showAgePopupNSTP();
        } else if (strNomineeName.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Nominee Name", Toast.LENGTH_SHORT).show();
        } else if (strNomineeGenderEdit.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select Nominee Gender", Toast.LENGTH_SHORT).show();
        }else if (strNomineeDobEdit.equals("Nominee Dob") || strNomineeDobEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Nominee Dob Number", Toast.LENGTH_SHORT).show();
        } else if (selectNomineeYear <= 5) {
            if (strAppointeeNomineeName.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Appointee Name", Toast.LENGTH_SHORT).show();
            } else if (strAppointeeNomineeDobEdit.equals("Select Dob") || strAppointeeNomineeDobEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Appointee DOB", Toast.LENGTH_SHORT).show();
            } else if (strAppointeeGenderEdit.equals("Select Gender")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Appointee Gender", Toast.LENGTH_SHORT).show();
            } else {
                if (strCheckBoxSpouse.equals("Checked")) {
                    SpouseMethod();
                } else if (mCounter == 1) {
                    ChildOneMethod();
                } else if (mCounter == 2) {
                    ChildTwoMethod();
                } else if (mCounter == 3) {
                    ChildThirdMethod();
                } else if (mCounter == 4) {
                    ChildFourthMethod();
                } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    CheckMotherFatherCondition();
                } else {
                    methoElse();
                }
            }
        } else {
            if (strCheckBoxSpouse.equals("Checked")) {
                SpouseMethod();
            } else if (mCounter == 1) {
                ChildOneMethod();
            } else if (mCounter == 2) {
                ChildTwoMethod();
            } else if (mCounter == 3) {
                ChildThirdMethod();
            } else if (mCounter == 4) {
                ChildFourthMethod();
            } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                CheckMotherFatherCondition();
            } else {
                methoElse();
            }

        }
    }
    private void SpouseMethod() {
        if (strSpouseNameEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Spouse Name", Toast.LENGTH_SHORT).show();
        } else if (strSpouseAgeEditText.equals("Select Dob") || strSpouseAgeEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Spouse DOB", Toast.LENGTH_SHORT).show();
        }else if (selectYearSecondAdult < 18 || (selectYearSecondAdult > 55)) {
//            Toast.makeText(PersonalInformationCHI.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
            showAgePopupNSTP();
        } else if (strSpouseGenderEdit.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select Spouse Gender", Toast.LENGTH_SHORT).show();
        } else if (strSpouseOccupationEdit.equals("Select Occupation")) {
            Toast.makeText(PersonalInformationCHI.this, "Select Spouse Occupation", Toast.LENGTH_SHORT).show();
        } else if (strFtSpouseEdit.equals("Ft")) {
            Toast.makeText(PersonalInformationCHI.this, "Select Spouse Ft", Toast.LENGTH_SHORT).show();
        } else if (strInchesSpouseEdit.equals("Inches")) {
            Toast.makeText(PersonalInformationCHI.this, "Select Inches Ft", Toast.LENGTH_SHORT).show();
        } else if (strWeightEditSpouse.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Spouse Weight", Toast.LENGTH_SHORT).show();
        } else if (!(Double.parseDouble(strSpouseBMIEdit) >= 16.0 && Double.parseDouble(strSpouseBMIEdit) <= 33.0)) {
//            alertPopup();
            showAgePopupNSTP();
//            Toast.makeText(PersonalInformationCHI.this, "Spouse BMI is not normal", Toast.LENGTH_SHORT).show();
        } else if (strNomineeName.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Nominee Name", Toast.LENGTH_SHORT).show();
        } else if (strNomineeGenderEdit.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select Nominee Gender", Toast.LENGTH_SHORT).show();
        }else if (strNomineeDobEdit.equals("Nominee Dob") || strNomineeDobEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter Nominee Dob Number", Toast.LENGTH_SHORT).show();
        } else if (selectNomineeYear <= 5) {
            if (strAppointeeNomineeName.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Appointee Name", Toast.LENGTH_SHORT).show();
            } else if (strAppointeeNomineeDobEdit.equals("Select Dob") || strAppointeeNomineeDobEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Appointee DOB", Toast.LENGTH_SHORT).show();
            } else if (strAppointeeGenderEdit.equals("Select Gender")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Appointee Gender", Toast.LENGTH_SHORT).show();
            } else {
                if (mCounter == 1) {
                    ChildOneMethod();
                } else if (mCounter == 2) {
                    ChildTwoMethod();
                } else if (mCounter == 3) {
                    ChildThirdMethod();
                } else if (mCounter == 4) {
                    ChildFourthMethod();
                } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    CheckMotherFatherCondition();
                } else {
                    methoElse();
                }
            }
        } else {
            if (mCounter == 1) {
                ChildOneMethod();
            } else if (mCounter == 2) {
                ChildTwoMethod();
            } else if (mCounter == 3) {
                ChildThirdMethod();
            } else if (mCounter == 4) {
                ChildFourthMethod();
            } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                CheckMotherFatherCondition();
            } else {
                methoElse();
            }

        }
    }
    private void ChildOneMethod() {
        if (strChildOneNameEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 1'st Child Name", Toast.LENGTH_SHORT).show();
        } else if (strFirstSonAgeEditText.equals("Select Dob") || strFirstSonAgeEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  1'st Child DOB", Toast.LENGTH_SHORT).show();
        } else if (strGenderChildOneEdit.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Gender", Toast.LENGTH_SHORT).show();
        } else if (str_oneFtSpinner.equals("Ft")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_oneInchesSpinner.equals("Inches")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_oneWeightEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 1'st Child Weight", Toast.LENGTH_SHORT).show();
        } else if (selectFirstYearChild > 19) {
            if (!(Double.parseDouble(strBMIChildEdit) >= 16.0 && Double.parseDouble(strBMIChildEdit) <= 33.0)) {
//                Toast.makeText(PersonalInformationCHI.this, "1'st Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                alertPopup();
                showAgePopupNSTP();
            } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                CheckMotherFatherCondition();
            } else {
                methoElse();
            }
        } else {
            if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                CheckMotherFatherCondition();
            } else {
                methoElse();
            }
        }
    }
    private void ChildTwoMethod() {
        if (strChildOneNameEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 1'st Child Name", Toast.LENGTH_SHORT).show();
        } else if (strFirstSonAgeEditText.equals("Select Dob") || strFirstSonAgeEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  1'st Child DOB", Toast.LENGTH_SHORT).show();
        } else if (strGenderChildOneEdit.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Gender", Toast.LENGTH_SHORT).show();
        } else if (str_oneFtSpinner.equals("Ft")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_oneInchesSpinner.equals("Inches")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_oneWeightEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 1'st Child Weight", Toast.LENGTH_SHORT).show();
        } else if (selectFirstYearChild > 19) {
            if (!(Double.parseDouble(strBMIChildEdit) >= 16.0 && Double.parseDouble(strBMIChildEdit) <= 33.0)) {
//                Toast.makeText(PersonalInformationCHI.this, "1'st Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                alertPopup();
                showAgePopupNSTP();
            } else if (strSecondChildNameEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Name", Toast.LENGTH_SHORT).show();
            } else if (strSecondSonAgeEditText.equals("Select Dob") || strSecondSonAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter  2nd Child DOB", Toast.LENGTH_SHORT).show();
            } else if (str_twoGenderSpinner.equals("Select Gender")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Gender", Toast.LENGTH_SHORT).show();
            } else if (str_twoFtSpinner.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_twoInchesSpinner.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (strtwoWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Weight", Toast.LENGTH_SHORT).show();
            } else if (selectSecSonChild > 19) {
                if (!(Double.parseDouble(strBMIChildTwoEdit) >= 16.0 && Double.parseDouble(strBMIChildTwoEdit) <= 33.0)) {
//                    Toast.makeText(PersonalInformationCHI.this, "2nd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                    alertPopup();
                    showAgePopupNSTP();
                } else {
                    if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                        CheckMotherFatherCondition1();
                    } else {
                        methoElse();
                    }
                }
            } else {
                if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    CheckMotherFatherCondition1();
                } else {
                    methoElse();
                }
            }
        } else if (strSecondChildNameEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Name", Toast.LENGTH_SHORT).show();
        } else if (strSecondSonAgeEditText.equals("Select Dob") || strSecondSonAgeEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  2nd Child DOB", Toast.LENGTH_SHORT).show();
        } else if (str_twoGenderSpinner.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Gender", Toast.LENGTH_SHORT).show();
        } else if (str_twoFtSpinner.equals("Ft")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_twoInchesSpinner.equals("Inches")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
        } else if (strtwoWeightEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Weight", Toast.LENGTH_SHORT).show();
        } else if (selectSecSonChild > 19) {
            if (!(Double.parseDouble(strBMIChildTwoEdit) >= 16.0 && Double.parseDouble(strBMIChildTwoEdit) <= 33.0)) {
//                Toast.makeText(PersonalInformationCHI.this, "2nd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                alertPopup();
                showAgePopupNSTP();
            } else {
                if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    CheckMotherFatherCondition1();
                } else {
                    methoElse();
                }
            }
        } else {
            if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                CheckMotherFatherCondition1();
            } else {
                methoElse();
            }
        }
    }
    private void ChildThirdMethod() {
        if (strChildOneNameEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 1'st Child Name", Toast.LENGTH_SHORT).show();
        } else if (strFirstSonAgeEditText.equals("Select Dob") || strFirstSonAgeEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  1'st Child DOB", Toast.LENGTH_SHORT).show();
        } else if (strGenderChildOneEdit.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Gender", Toast.LENGTH_SHORT).show();
        } else if (str_oneFtSpinner.equals("Ft")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_oneInchesSpinner.equals("Inches")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_oneWeightEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 1'st Child Weight", Toast.LENGTH_SHORT).show();
        } else if (selectFirstYearChild > 19) {
            if (!(Double.parseDouble(strBMIChildEdit) >= 16.0 && Double.parseDouble(strBMIChildEdit) <= 33.0)) {
//                Toast.makeText(PersonalInformationCHI.this, "1'st Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                alertPopup();
                showAgePopupNSTP();
            } else if (strSecondChildNameEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Name", Toast.LENGTH_SHORT).show();
            } else if (strSecondSonAgeEditText.equals("Select Dob") || strSecondSonAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter  2nd Child DOB", Toast.LENGTH_SHORT).show();
            } else if (str_twoGenderSpinner.equals("Select Gender")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Gender", Toast.LENGTH_SHORT).show();
            } else if (str_twoFtSpinner.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_twoInchesSpinner.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (strtwoWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Weight", Toast.LENGTH_SHORT).show();
            } else if (selectSecSonChild > 19) {
                if (!(Double.parseDouble(strBMIChildTwoEdit) >= 16.0 && Double.parseDouble(strBMIChildTwoEdit) <= 33.0)) {
//                    Toast.makeText(PersonalInformationCHI.this, "2nd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                    alertPopup();
                    showAgePopupNSTP();
                } else if (strThirdChildNameEdit.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Name", Toast.LENGTH_SHORT).show();
                } else if (strThirdSonAgeEditText.equals("Select Dob") || strThirdSonAgeEditText.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter  3rd Child DOB", Toast.LENGTH_SHORT).show();
                } else if (str_thirdGenderSpinner.equals("Select Gender")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Gender", Toast.LENGTH_SHORT).show();
                } else if (str_thirdFtSpinner.equals("Ft")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
                } else if (str_thirdInchesSpinner.equals("Inches")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
                } else if (str_thirdWeightEdit.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Weight", Toast.LENGTH_SHORT).show();
                } else if (selectThirdSonChild > 19) {
                    if (!(Double.parseDouble(strBMIEChildThreeEdit) >= 16.0 && Double.parseDouble(strBMIEChildThreeEdit) <= 33.0)) {
//                        Toast.makeText(PersonalInformationCHI.this, "3rd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                        alertPopup();
                        showAgePopupNSTP();
                    } else {
                        if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                            CheckMotherFatherCondition1();
                        } else {
                            methoElse();
                        }
                    }
                } else {
                    if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                        CheckMotherFatherCondition1();
                    } else {
                        methoElse();
                    }
                }
            } else if (strThirdChildNameEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Name", Toast.LENGTH_SHORT).show();
            } else if (strThirdSonAgeEditText.equals("Select Dob") || strThirdSonAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter  3rd Child DOB", Toast.LENGTH_SHORT).show();
            } else if (str_thirdGenderSpinner.equals("Select Gender")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Gender", Toast.LENGTH_SHORT).show();
            } else if (str_thirdFtSpinner.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_thirdInchesSpinner.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_thirdWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Weight", Toast.LENGTH_SHORT).show();
            } else if (selectThirdSonChild > 19) {
                if (!(Double.parseDouble(strBMIEChildThreeEdit) >= 16.0 && Double.parseDouble(strBMIEChildThreeEdit) <= 33.0)) {
//                    Toast.makeText(PersonalInformationCHI.this, "3rd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                    alertPopup();
                    showAgePopupNSTP();
                } else {
                    if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                        CheckMotherFatherCondition1();
                    } else {
                        methoElse();
                    }
                }
            } else {
                if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    CheckMotherFatherCondition1();
                } else {
                    methoElse();
                }
            }
        } else if (strSecondChildNameEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Name", Toast.LENGTH_SHORT).show();
        } else if (strSecondSonAgeEditText.equals("Select Dob") || strSecondSonAgeEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  2nd Child DOB", Toast.LENGTH_SHORT).show();
        } else if (str_twoGenderSpinner.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Gender", Toast.LENGTH_SHORT).show();
        } else if (str_twoFtSpinner.equals("Ft")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_twoInchesSpinner.equals("Inches")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
        } else if (strtwoWeightEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Weight", Toast.LENGTH_SHORT).show();
        } else if (selectSecSonChild > 19) {
            if (!(Double.parseDouble(strBMIChildTwoEdit) >= 16.0 && Double.parseDouble(strBMIChildTwoEdit) <= 33.0)) {
//                Toast.makeText(PersonalInformationCHI.this, "2nd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                alertPopup();
                showAgePopupNSTP();
            } else if (strThirdChildNameEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Name", Toast.LENGTH_SHORT).show();
            } else if (strThirdSonAgeEditText.equals("Select Dob") || strThirdSonAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter  3rd Child DOB", Toast.LENGTH_SHORT).show();
            } else if (str_thirdGenderSpinner.equals("Select Gender")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Gender", Toast.LENGTH_SHORT).show();
            } else if (str_thirdFtSpinner.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_thirdInchesSpinner.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_thirdWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Weight", Toast.LENGTH_SHORT).show();
            } else if (selectThirdSonChild > 19) {
                if (!(Double.parseDouble(strBMIEChildThreeEdit) >= 16.0 && Double.parseDouble(strBMIEChildThreeEdit) <= 33.0)) {
//                    Toast.makeText(PersonalInformationCHI.this, "3rd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                    alertPopup();
                    showAgePopupNSTP();
                } else {
                    if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                        CheckMotherFatherCondition1();
                    } else {
                        methoElse();
                    }
                }

            } else {
                if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    CheckMotherFatherCondition1();
                } else {
                    methoElse();
                }
            }
        } else if (strThirdChildNameEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Name", Toast.LENGTH_SHORT).show();
        } else if (strThirdSonAgeEditText.equals("Select Dob") || strThirdSonAgeEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  3rd Child DOB", Toast.LENGTH_SHORT).show();
        } else if (str_thirdGenderSpinner.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Gender", Toast.LENGTH_SHORT).show();
        } else if (str_thirdFtSpinner.equals("Ft")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_thirdInchesSpinner.equals("Inches")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_thirdWeightEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Weight", Toast.LENGTH_SHORT).show();
        } else if (selectThirdSonChild > 19) {
            if (!(Double.parseDouble(strBMIEChildThreeEdit) >= 16.0 && Double.parseDouble(strBMIEChildThreeEdit) <= 33.0)) {
//                Toast.makeText(PersonalInformationCHI.this, "3rd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                alertPopup();
                showAgePopupNSTP();
            } else {
                if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    CheckMotherFatherCondition1();
                } else {
                    methoElse();
                }
            }
        } else {
            if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                CheckMotherFatherCondition1();
            } else {
                methoElse();
            }
        }
    }
    private void ChildFourthMethod() {
        if (strChildOneNameEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 1'st Child Name", Toast.LENGTH_SHORT).show();
        } else if (strFirstSonAgeEditText.equals("Select Dob") || strFirstSonAgeEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  1'st Child DOB", Toast.LENGTH_SHORT).show();
        } else if (strGenderChildOneEdit.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Gender", Toast.LENGTH_SHORT).show();
        } else if (str_oneFtSpinner.equals("Ft")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_oneInchesSpinner.equals("Inches")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_oneWeightEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 1'st Child Weight", Toast.LENGTH_SHORT).show();
        } else if (selectFirstYearChild > 19) {
            if (!(Double.parseDouble(strBMIChildEdit) >= 16.0 && Double.parseDouble(strBMIChildEdit) <= 33.0)) {
//                Toast.makeText(PersonalInformationCHI.this, "1'st Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                alertPopup();
                showAgePopupNSTP();
            } else if (strSecondChildNameEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Name", Toast.LENGTH_SHORT).show();
            } else if (strSecondSonAgeEditText.equals("Select Dob") || strSecondSonAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter  2nd Child DOB", Toast.LENGTH_SHORT).show();
            } else if (str_twoGenderSpinner.equals("Select Gender")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Gender", Toast.LENGTH_SHORT).show();
            } else if (str_twoFtSpinner.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_twoInchesSpinner.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (strtwoWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Weight", Toast.LENGTH_SHORT).show();
            } else if (selectSecSonChild > 19) {
                if (!(Double.parseDouble(strBMIChildTwoEdit) >= 16.0 && Double.parseDouble(strBMIChildTwoEdit) <= 33.0)) {
//                    Toast.makeText(PersonalInformationCHI.this, "2nd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                    alertPopup();
                    showAgePopupNSTP();
                } else if (strThirdChildNameEdit.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Name", Toast.LENGTH_SHORT).show();
                } else if (strThirdSonAgeEditText.equals("Select Dob") || strThirdSonAgeEditText.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter  3rd Child DOB", Toast.LENGTH_SHORT).show();
                } else if (str_thirdGenderSpinner.equals("Select Gender")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Gender", Toast.LENGTH_SHORT).show();
                } else if (str_thirdFtSpinner.equals("Ft")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
                } else if (str_thirdInchesSpinner.equals("Inches")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
                } else if (str_thirdWeightEdit.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Weight", Toast.LENGTH_SHORT).show();
                } else if (selectThirdSonChild > 19) {
                    if (!(Double.parseDouble(strBMIEChildThreeEdit) >= 16.0 && Double.parseDouble(strBMIEChildThreeEdit) <= 33.0)) {
//                        Toast.makeText(PersonalInformationCHI.this, "3rd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                        alertPopup();
                        showAgePopupNSTP();
                    } else if (strFourChildNameEdit.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Name", Toast.LENGTH_SHORT).show();
                    } else if (strFourSonAgeEditText.equals("Select Dob") || strFourSonAgeEditText.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Enter  4th Child DOB", Toast.LENGTH_SHORT).show();
                    } else if (str_fourGenderSpinner.equals("Select Gender")) {
                        Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Gender", Toast.LENGTH_SHORT).show();
                    } else if (str_fourFtSpinner.equals("Ft")) {
                        Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
                    } else if (str_fourInchesSpinner.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
                    } else if (strFourWeightEdit.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Weight", Toast.LENGTH_SHORT).show();
                    } else if (selectYearChildFour > 19) {
                        if (!(Double.parseDouble(strBMIFourChildEdit) >= 16.0 && Double.parseDouble(strBMIFourChildEdit) <= 33.0)) {
//                            Toast.makeText(PersonalInformationCHI.this, "4th Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                            alertPopup();
                            showAgePopupNSTP();
                        } else {
                            if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                CheckMotherFatherCondition1();
                            } else {
                                methoElse();
                            }
                        }
                    } else {
                        if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                            CheckMotherFatherCondition1();
                        } else {
                            methoElse();
                        }
                    }
                } else if (strFourChildNameEdit.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Name", Toast.LENGTH_SHORT).show();
                } else if (strFourSonAgeEditText.equals("Select Dob") || strFourSonAgeEditText.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter  4th Child DOB", Toast.LENGTH_SHORT).show();
                } else if (str_fourGenderSpinner.equals("Select Gender")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Gender", Toast.LENGTH_SHORT).show();
                } else if (str_fourFtSpinner.equals("Ft")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
                } else if (str_fourInchesSpinner.equals("Inches")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
                } else if (strFourWeightEdit.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Weight", Toast.LENGTH_SHORT).show();
                } else if (selectYearChildFour > 19) {
                    if (!(Double.parseDouble(strBMIFourChildEdit) >= 16.0 && Double.parseDouble(strBMIFourChildEdit) <= 33.0)) {
//                        Toast.makeText(PersonalInformationCHI.this, "4th Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                        alertPopup();
                        showAgePopupNSTP();
                    } else {
                        if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                            CheckMotherFatherCondition1();
                        } else {
                            methoElse();
                        }
                    }
                } else {
                    if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                        CheckMotherFatherCondition1();
                    } else {
                        methoElse();
                    }
                }
            } else if (strThirdChildNameEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Name", Toast.LENGTH_SHORT).show();
            } else if (strThirdSonAgeEditText.equals("Select Dob") || strThirdSonAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter  3rd Child DOB", Toast.LENGTH_SHORT).show();
            } else if (str_thirdGenderSpinner.equals("Select Gender")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Gender", Toast.LENGTH_SHORT).show();
            } else if (str_thirdFtSpinner.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_thirdInchesSpinner.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_thirdWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Weight", Toast.LENGTH_SHORT).show();
            } else if (selectThirdSonChild > 19) {
                if (!(Double.parseDouble(strBMIEChildThreeEdit) >= 16.0 && Double.parseDouble(strBMIEChildThreeEdit) <= 33.0)) {
//                    Toast.makeText(PersonalInformationCHI.this, "3rd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                    alertPopup();
                    showAgePopupNSTP();
                } else if (strFourChildNameEdit.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Name", Toast.LENGTH_SHORT).show();
                } else if (strFourSonAgeEditText.equals("Select Dob") || strFourSonAgeEditText.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter  4th Child DOB", Toast.LENGTH_SHORT).show();
                } else if (str_fourGenderSpinner.equals("Select Gender")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Gender", Toast.LENGTH_SHORT).show();
                } else if (str_fourFtSpinner.equals("Ft")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
                } else if (str_fourInchesSpinner.equals("Inches")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
                } else if (strFourWeightEdit.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Weight", Toast.LENGTH_SHORT).show();
                } else if (selectYearChildFour > 19) {
                    if (!(Double.parseDouble(strBMIFourChildEdit) >= 16.0 && Double.parseDouble(strBMIFourChildEdit) <= 33.0)) {
//                        Toast.makeText(PersonalInformationCHI.this, "4th Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                        alertPopup();
                        showAgePopupNSTP();
                    } else {
                        if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                            CheckMotherFatherCondition1();
                        } else {
                            methoElse();
                        }
                    }
                } else {
                    if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                        CheckMotherFatherCondition1();
                    } else {
                        methoElse();
                    }
                }
            } else if (strFourChildNameEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Name", Toast.LENGTH_SHORT).show();
            } else if (strFourSonAgeEditText.equals("Select Dob") || strFourSonAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter  4th Child DOB", Toast.LENGTH_SHORT).show();
            } else if (str_fourGenderSpinner.equals("Select Gender")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Gender", Toast.LENGTH_SHORT).show();
            } else if (str_fourFtSpinner.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_fourInchesSpinner.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
            } else if (strFourWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Weight", Toast.LENGTH_SHORT).show();
            } else if (selectYearChildFour > 19) {
                if (!(Double.parseDouble(strBMIFourChildEdit) >= 16.0 && Double.parseDouble(strBMIFourChildEdit) <= 33.0)) {
//                    Toast.makeText(PersonalInformationCHI.this, "4th Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                    alertPopup();
                    showAgePopupNSTP();
                } else {
                    if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                        CheckMotherFatherCondition1();
                    } else {
                        methoElse();
                    }
                }
            } else {
                if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    CheckMotherFatherCondition1();
                } else {
                    methoElse();
                }
            }
        } else if (strSecondChildNameEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Name", Toast.LENGTH_SHORT).show();
        } else if (strSecondSonAgeEditText.equals("Select Dob") || strSecondSonAgeEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  2nd Child DOB", Toast.LENGTH_SHORT).show();
        } else if (str_twoGenderSpinner.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Gender", Toast.LENGTH_SHORT).show();
        } else if (str_twoFtSpinner.equals("Ft")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_twoInchesSpinner.equals("Inches")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
        } else if (strtwoWeightEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Weight", Toast.LENGTH_SHORT).show();
        } else if (selectSecSonChild > 19) {
            if (!(Double.parseDouble(strBMIChildTwoEdit) >= 16.0 && Double.parseDouble(strBMIChildTwoEdit) <= 33.0)) {
//                Toast.makeText(PersonalInformationCHI.this, "2nd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                alertPopup();
                showAgePopupNSTP();
            } else if (strThirdChildNameEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Name", Toast.LENGTH_SHORT).show();
            } else if (strThirdSonAgeEditText.equals("Select Dob") || strThirdSonAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter  3rd Child DOB", Toast.LENGTH_SHORT).show();
            } else if (str_thirdGenderSpinner.equals("Select Gender")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Gender", Toast.LENGTH_SHORT).show();
            } else if (str_thirdFtSpinner.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_thirdInchesSpinner.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_thirdWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Weight", Toast.LENGTH_SHORT).show();
            } else if (selectThirdSonChild > 19) {
                if (!(Double.parseDouble(strBMIEChildThreeEdit) >= 16.0 && Double.parseDouble(strBMIEChildThreeEdit) <= 33.0)) {
//                    Toast.makeText(PersonalInformationCHI.this, "3rd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                    alertPopup();
                    showAgePopupNSTP();
                } else if (strFourChildNameEdit.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Name", Toast.LENGTH_SHORT).show();
                } else if (strFourSonAgeEditText.equals("Select Dob") || strFourSonAgeEditText.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter  4th Child DOB", Toast.LENGTH_SHORT).show();
                } else if (str_fourGenderSpinner.equals("Select Gender")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Gender", Toast.LENGTH_SHORT).show();
                } else if (str_fourFtSpinner.equals("Ft")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
                } else if (str_fourInchesSpinner.equals("Inches")) {
                    Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
                } else if (strFourWeightEdit.equals("")) {
                    Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Weight", Toast.LENGTH_SHORT).show();
                } else if (selectYearChildFour > 19) {
                    if (!(Double.parseDouble(strBMIFourChildEdit) >= 16.0 && Double.parseDouble(strBMIFourChildEdit) <= 33.0)) {
//                        Toast.makeText(PersonalInformationCHI.this, "4th Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                        alertPopup();
                        showAgePopupNSTP();
                    } else {
                        if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                            CheckMotherFatherCondition1();
                        } else {
                            methoElse();
                        }
                    }
                } else {
                    if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                        CheckMotherFatherCondition1();
                    } else {
                        methoElse();
                    }
                }
            } else if (strFourChildNameEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Name", Toast.LENGTH_SHORT).show();
            } else if (strFourSonAgeEditText.equals("Select Dob") || strFourSonAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter  4th Child DOB", Toast.LENGTH_SHORT).show();
            } else if (str_fourGenderSpinner.equals("Select Gender")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Gender", Toast.LENGTH_SHORT).show();
            } else if (str_fourFtSpinner.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_fourInchesSpinner.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
            } else if (strFourWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Weight", Toast.LENGTH_SHORT).show();
            } else if (selectYearChildFour > 19) {
                if (!(Double.parseDouble(strBMIFourChildEdit) >= 16.0 && Double.parseDouble(strBMIFourChildEdit) <= 33.0)) {
//                    Toast.makeText(PersonalInformationCHI.this, "4th Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                    alertPopup();
                    showAgePopupNSTP();
                } else {
                    if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                        CheckMotherFatherCondition1();
                    } else {
                        methoElse();
                    }
                }
            } else {
                if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    CheckMotherFatherCondition1();
                } else {
                    methoElse();
                }
            }
        } else if (strThirdChildNameEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Name", Toast.LENGTH_SHORT).show();
        } else if (strThirdSonAgeEditText.equals("Select Dob") || strThirdSonAgeEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  3rd Child DOB", Toast.LENGTH_SHORT).show();
        } else if (str_thirdGenderSpinner.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Gender", Toast.LENGTH_SHORT).show();
        } else if (str_thirdFtSpinner.equals("Ft")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_thirdInchesSpinner.equals("Inches")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_thirdWeightEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Weight", Toast.LENGTH_SHORT).show();
        } else if (selectThirdSonChild > 19) {
            if (!(Double.parseDouble(strBMIEChildThreeEdit) >= 16.0 && Double.parseDouble(strBMIEChildThreeEdit) <= 33.0)) {
//                Toast.makeText(PersonalInformationCHI.this, "3rd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                alertPopup();
                showAgePopupNSTP();
            } else if (strFourChildNameEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Name", Toast.LENGTH_SHORT).show();
            } else if (strFourSonAgeEditText.equals("Select Dob") || strFourSonAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter  4th Child DOB", Toast.LENGTH_SHORT).show();
            } else if (str_fourGenderSpinner.equals("Select Gender")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Gender", Toast.LENGTH_SHORT).show();
            } else if (str_fourFtSpinner.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
            } else if (str_fourInchesSpinner.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
            } else if (strFourWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Weight", Toast.LENGTH_SHORT).show();
            } else if (selectYearChildFour > 19) {
                if (!(Double.parseDouble(strBMIFourChildEdit) >= 16.0 && Double.parseDouble(strBMIFourChildEdit) <= 33.0)) {
//                    Toast.makeText(PersonalInformationCHI.this, "4th Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                    alertPopup();
                    showAgePopupNSTP();
                } else {
                    if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                        CheckMotherFatherCondition1();
                    } else {
                        methoElse();
                    }
                }
            } else {
                if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    CheckMotherFatherCondition1();
                } else {
                    methoElse();
                }
            }
        } else if (strFourChildNameEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Name", Toast.LENGTH_SHORT).show();
        } else if (strFourSonAgeEditText.equals("Select Dob") || strFourSonAgeEditText.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter  4th Child DOB", Toast.LENGTH_SHORT).show();
        } else if (str_fourGenderSpinner.equals("Select Gender")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Gender", Toast.LENGTH_SHORT).show();
        } else if (str_fourFtSpinner.equals("Ft")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
        } else if (str_fourInchesSpinner.equals("Inches")) {
            Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
        } else if (strFourWeightEdit.equals("")) {
            Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Weight", Toast.LENGTH_SHORT).show();
        } else if (selectYearChildFour > 19) {
            if (!(Double.parseDouble(strBMIFourChildEdit) >= 16.0 && Double.parseDouble(strBMIFourChildEdit) <= 33.0)) {
//                Toast.makeText(PersonalInformationCHI.this, "4th Child BMI is not normal", Toast.LENGTH_SHORT).show();
//                alertPopup();
                showAgePopupNSTP();
            } else {
                if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    CheckMotherFatherCondition1();
                } else {
                    methoElse();
                }
            }
        } else {
            if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                CheckMotherFatherCondition1();
            } else {
                methoElse();
            }
        }


//        if (strChildOneNameEdit.equals("")) {
//            Toast.makeText(PersonalInformationCHI.this, "Enter 1'st Child Name", Toast.LENGTH_SHORT).show();
//        } else if (strFirstSonAgeEditText.equals("Select Dob") || strFirstSonAgeEditText.equals("")) {
//            Toast.makeText(PersonalInformationCHI.this, "Enter  1'st Child DOB", Toast.LENGTH_SHORT).show();
//        } else if (strGenderChildOneEdit.equals("Select Gender")) {
//            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Gender", Toast.LENGTH_SHORT).show();
//        } else if (str_oneFtSpinner.equals("Ft")) {
//            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Ft", Toast.LENGTH_SHORT).show();
//        } else if (str_oneInchesSpinner.equals("Inches")) {
//            Toast.makeText(PersonalInformationCHI.this, "Select 1'st Child Ft", Toast.LENGTH_SHORT).show();
//        } else if (str_oneWeightEdit.equals("")) {
//            Toast.makeText(PersonalInformationCHI.this, "Enter 1'st Child Weight", Toast.LENGTH_SHORT).show();
//       }else if (selectFirstYearChild >19){
//            if (!(Double.parseDouble(strBMIChildEdit) >= 16.0 && Double.parseDouble(strBMIChildEdit) <= 33.0)) {
//            Toast.makeText(PersonalInformationCHI.this, "1'st Child BMI is not normal", Toast.LENGTH_SHORT).show();
//            alertPopup();
//        }
//      } else if (strSecondChildNameEdit.equals("")) {
//            Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Name", Toast.LENGTH_SHORT).show();
//        } else if (strSecondSonAgeEditText.equals("Select Dob") || strSecondSonAgeEditText.equals("")) {
//            Toast.makeText(PersonalInformationCHI.this, "Enter  2nd Child DOB", Toast.LENGTH_SHORT).show();
//        } else if (str_twoGenderSpinner.equals("Select Gender")) {
//            Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Gender", Toast.LENGTH_SHORT).show();
//        } else if (str_twoFtSpinner.equals("Ft")) {
//            Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
//        } else if (str_twoInchesSpinner.equals("Inches")) {
//            Toast.makeText(PersonalInformationCHI.this, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();
//        } else if (strtwoWeightEdit.equals("")) {
//            Toast.makeText(PersonalInformationCHI.this, "Enter 2nd Child Weight", Toast.LENGTH_SHORT).show();
//        }else if (selectSecSonChild >19){
//            if (!(Double.parseDouble(strBMIChildTwoEdit) >= 16.0 && Double.parseDouble(strBMIChildTwoEdit) <= 33.0)) {
//            Toast.makeText(PersonalInformationCHI.this, "2nd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//            alertPopup();
//         }
//       }  else if (strThirdChildNameEdit.equals("")) {
//            Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Name", Toast.LENGTH_SHORT).show();
//        } else if (strThirdSonAgeEditText.equals("Select Dob") || strThirdSonAgeEditText.equals("")) {
//            Toast.makeText(PersonalInformationCHI.this, "Enter  3rd Child DOB", Toast.LENGTH_SHORT).show();
//        } else if (str_thirdGenderSpinner.equals("Select Gender")) {
//            Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Gender", Toast.LENGTH_SHORT).show();
//        } else if (str_thirdFtSpinner.equals("Ft")) {
//            Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
//        } else if (str_thirdInchesSpinner.equals("Inches")) {
//            Toast.makeText(PersonalInformationCHI.this, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();
//        } else if (str_thirdWeightEdit.equals("")) {
//            Toast.makeText(PersonalInformationCHI.this, "Enter 3rd Child Weight", Toast.LENGTH_SHORT).show();
//        }else if (selectThirdSonChild >19){
//            if (!(Double.parseDouble(strBMIEChildThreeEdit) >= 16.0 && Double.parseDouble(strBMIEChildThreeEdit) <= 33.0)) {
//                Toast.makeText(PersonalInformationCHI.this, "3rd Child BMI is not normal", Toast.LENGTH_SHORT).show();
//            alertPopup();
//         }
//       }
//        else if (strFourChildNameEdit.equals("")) {
//            Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Name", Toast.LENGTH_SHORT).show();
//        } else if (strFourSonAgeEditText.equals("Select Dob") || strFourSonAgeEditText.equals("")) {
//            Toast.makeText(PersonalInformationCHI.this, "Enter  4th Child DOB", Toast.LENGTH_SHORT).show();
//        } else if (str_fourGenderSpinner.equals("Select Gender")) {
//            Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Gender", Toast.LENGTH_SHORT).show();
//        } else if (str_fourFtSpinner.equals("Ft")) {
//            Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
//        } else if (str_fourInchesSpinner.equals("Inches")) {
//            Toast.makeText(PersonalInformationCHI.this, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();
//        } else if (strFourWeightEdit.equals("")) {
//            Toast.makeText(PersonalInformationCHI.this, "Enter 4th Child Weight", Toast.LENGTH_SHORT).show();
//        }else if (selectYearChildFour >19){
//            if (!(Double.parseDouble(strBMIFourChildEdit) >= 16.0 && Double.parseDouble(strBMIFourChildEdit) <= 33.0)) {
//                Toast.makeText(PersonalInformationCHI.this, "4th Child BMI is not normal", Toast.LENGTH_SHORT).show();
//            alertPopup();
//          } else{
//              if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
//                CheckMotherFatherCondition1();
//            }
//            else {
//                methoElse();
//            }
//            }
//       }else {
//            if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
//                CheckMotherFatherCondition1();
//            }
//            else {
//                methoElse();
//            }
//        }
    }
    private void showProposertCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PersonalInformationCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strProposerEditDob = dateFormatter.format(newDate.getTime());
            Log.e("strProposerEditDob", strProposerEditDob);
            proposerEditDob.setText(strProposerEditDob);
            try {
                SelectDate = dateFormatter.parse(strProposerEditDob);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearProposer = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearProposer < 18 || (selectYearProposer > 55)) {
//                Toast.makeText(PersonalInformationCHI.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                strProposerEditDob = "Select Dob";
                proposerEditDob.setText(strProposerEditDob);
                showAgePopupNSTP();
            } else {
                proposerEditDob.setText(strProposerEditDob);

//                if (selectYearProposer < Integer.parseInt(strFirstString) || (selectYearProposer > Integer.parseInt(strFourString))) {
//                    proposerEditDob.setText(strProposerEditDob);
////                    showAgePopup();
//                }
//                else {
//                    proposerEditDob.setText(strProposerEditDob);
//                }

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showMaternityPopup() {
        Dialog MaternityDialog;
        MaternityDialog = new Dialog(PersonalInformationCHI.this);
        MaternityDialog.setCanceledOnTouchOutside(false);
        MaternityDialog.setCancelable(false);
        MaternityDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(MaternityDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        MaternityDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        MaternityDialog.setContentView(R.layout.newmaternitypopup);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(MaternityDialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        MaternityDialog.show();
        LinearLayout continueButtonMaterntiy = MaternityDialog.findViewById(R.id.continueButtonMaterntiy);
        ImageView cutImg = MaternityDialog.findViewById(R.id.cutImg);
        continueButtonMaterntiy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaternityDialog.dismiss();
                strNomineeName = NomineeName.getText().toString();
                strEdtNameSelf = EdtNameSelf.getText().toString();
                strSpouseNameEditText = SpouseNameEditText.getText().toString();
                strChildOneNameEdit = ChildOneNameEdit.getText().toString();
                strSecondChildNameEdit = SecondChildNameEdit.getText().toString();
                strThirdChildNameEdit = ThirdChildNameEdit.getText().toString();
                strFourChildNameEdit = FourChildNameEdit.getText().toString();
                strMotherEditTextName = MotherEditTextName.getText().toString();
                strFatherEditTextName = FatherEditTextName.getText().toString();
                if (strNomineeName.equals("")){
                    strNomineeName = "";
                }
                if (strEdtNameSelf.equals("")){
                    strEdtNameSelf = "";
                }
                if (strSpouseNameEditText.equals("")){
                    strSpouseNameEditText = "";
                }
                if (strChildOneNameEdit.equals("")){
                    strChildOneNameEdit = "";
                }
                if (strSecondChildNameEdit.equals("")){
                    strSecondChildNameEdit = "";
                }
                if (strThirdChildNameEdit.equals("")){
                    strThirdChildNameEdit = "";
                }
                if (strFourChildNameEdit.equals("")){
                    strFourChildNameEdit = "";
                }
                if (strMotherEditTextName.equals("")){
                    strMotherEditTextName = "";
                }
                if (strFatherEditTextName.equals("")){
                    strFatherEditTextName = "";
                }

                health_quote();
            }
        });
        cutImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaternityDialog.dismiss();
                strNomineeName = "";
                health_quote();
            }
        });
    }
    private void PersonalAccidentPopUp() {
        Dialog ChildDialog;
        ChildDialog = new Dialog(PersonalInformationCHI.this);
        ChildDialog.setCanceledOnTouchOutside(false);
        ChildDialog.setCancelable(false);
        ChildDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(ChildDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ChildDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        ChildDialog.setContentView(R.layout.childagepopup);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(ChildDialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        ChildDialog.show();
        LinearLayout continueChildButtonPopup = ChildDialog.findViewById(R.id.continueChildButtonPopup);
        ImageView cutImg = ChildDialog.findViewById(R.id.cutImg);
        continueChildButtonPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChildDialog.dismiss();
                strNomineeName = "";
                health_quote();
            }
        });
        cutImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChildDialog.dismiss();
                strNomineeName = "";
                health_quote();
            }
        });
    }
    private void showAgePopup() {
        Dialog alert_dialog1;
        alert_dialog1 = new Dialog(PersonalInformationCHI.this);
        alert_dialog1.setCanceledOnTouchOutside(false);
        alert_dialog1.setCancelable(false);
        alert_dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog1.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert_dialog1.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog1.setContentView(R.layout.agematchpopup);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(alert_dialog1.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        alert_dialog1.show();
        LinearLayout continueButtonPopup = alert_dialog1.findViewById(R.id.continueButtonPopup);
        ImageView cutImg = alert_dialog1.findViewById(R.id.cutImg);
        continueButtonPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialog1.dismiss();
                strNomineeName = NomineeName.getText().toString();
                strEdtNameSelf = EdtNameSelf.getText().toString();
                strSpouseNameEditText = SpouseNameEditText.getText().toString();
                strChildOneNameEdit = ChildOneNameEdit.getText().toString();
                strSecondChildNameEdit = SecondChildNameEdit.getText().toString();
                strThirdChildNameEdit = ThirdChildNameEdit.getText().toString();
                strFourChildNameEdit = FourChildNameEdit.getText().toString();
                strMotherEditTextName = MotherEditTextName.getText().toString();
                strFatherEditTextName = FatherEditTextName.getText().toString();
                if (strNomineeName.equals("")){
                    strNomineeName = "";
                }
                if (strEdtNameSelf.equals("")){
                    strEdtNameSelf = "";
                }
                if (strSpouseNameEditText.equals("")){
                    strSpouseNameEditText = "";
                }
                if (strChildOneNameEdit.equals("")){
                    strChildOneNameEdit = "";
                }
                if (strSecondChildNameEdit.equals("")){
                    strSecondChildNameEdit = "";
                }
                if (strThirdChildNameEdit.equals("")){
                    strThirdChildNameEdit = "";
                }
                if (strFourChildNameEdit.equals("")){
                    strFourChildNameEdit = "";
                }
                if (strMotherEditTextName.equals("")){
                    strMotherEditTextName = "";
                }
                if (strFatherEditTextName.equals("")){
                    strFatherEditTextName = "";
                }
                health_quote();
            }
        });
        cutImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialog1.dismiss();
                strNomineeName = "";
                health_quote();
            }
        });
    }
    public void showFirstCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PersonalInformationCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSelfAgeEditText = dateFormatter.format(newDate.getTime());
            Log.e("strSelfAgeEditText", strSelfAgeEditText);
            String[] strdDate = strSelfAgeEditText.split("/");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            str_edit_dob3String = strdDate[2];
            Log.e("str_edit_dob3String", str_edit_dob3String);
            String ageCheck = "1";
            EditDobSelf.setText(strSelfAgeEditText);
//            EditDobSelf.setText(strSelfChangeAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strSelfAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearAdult = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (selectYearAdult < 18 || (selectYearAdult > 55)) {
//                Toast.makeText(PersonalInformationCHI.this, "Self age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                strSelfAgeEditText = "Select Dob";
                EditDobSelf.setText(strSelfAgeEditText);
                showAgePopupNSTP();
            }
            else {
                if (selectYearAdult < Integer.parseInt(strFirstString) || (selectYearAdult > Integer.parseInt(strFourString))) {
                    EditDobSelf.setText(strSelfAgeEditText);
                    if (str_policyType_spinner.equals("Individual")) {
                        if (strGenderSpinner.equals("Female")) {
                            if (strCheckBoxSelf.equals("Checked")) {
                                if (selectYearAdult > 45) {
                                    if (!(MaternityAndChildcare.equals("False")&&SterilityInfertilityStatus.equals("False"))){
                                        MaternityAndChildcare = "False";
                                        SterilityInfertilityStatus = "False";
                                        showMaternityPopup();
                                    }else{
                                        showAgePopup();
                                    }
                                } else{
                                   showAgePopup();
                               }
                            } else if  (strCheckBoxSpouse.equals("Checked")){
                                selectYearSecondAdult=selectYearAdult;
                                strSpouseAgeEditText=strSelfAgeEditText;
                               if (selectYearAdult > 45) {
                                   if (!(MaternityAndChildcare.equals("False")&&SterilityInfertilityStatus.equals("False"))){
                                       MaternityAndChildcare = "False";
                                       SterilityInfertilityStatus = "False";
                                       showMaternityPopup();
                                   }else{
                                       showAgePopup();
                                   }
                                } else{
                                   showAgePopup();
                               }
                            }else{
                                showAgePopup();
                            }
                          }
                        else {
                            if (strCheckBoxSelf.equals("Checked")) {
                                if (selectYearAdult > 45) {
                                    if (!(MaternityAndChildcare.equals("False")&&SterilityInfertilityStatus.equals("False"))){
                                        MaternityAndChildcare = "False";
                                        SterilityInfertilityStatus = "False";
                                        showMaternityPopup();
                                    }else{
                                        showAgePopup();
                                    }
                                } else{
                                    showAgePopup();
                                }
                            } else if  (strCheckBoxSpouse.equals("Checked")){
                                selectYearSecondAdult=selectYearAdult;
                                strSpouseAgeEditText=strSelfAgeEditText;
                                if (selectYearAdult > 45) {
                                    if (!(MaternityAndChildcare.equals("False")&&SterilityInfertilityStatus.equals("False"))){
                                        MaternityAndChildcare = "False";
                                        SterilityInfertilityStatus = "False";
                                        showMaternityPopup();
                                    }else{
                                        showAgePopup();
                                    }
                                } else{
                                    showAgePopup();
                                }
                            }else{
                                showAgePopup();
                            }
                        }
                     } else {
                        if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                            showAgePopup();
                        }
                        else{
                            if (strCheckBoxSelf.equals("Checked")||strCheckBoxSpouse.equals("Checked")){
                                if (strCheckBoxSpouse.equals("Checked")){
                                     selectYearSecondAdult=selectYearAdult;
                                  strSpouseAgeEditText=strSelfAgeEditText;
                               if (selectYearAdult > 45) {
                                   if (!(MaternityAndChildcare.equals("False")&&SterilityInfertilityStatus.equals("False"))){
                                       MaternityAndChildcare = "False";
                                       SterilityInfertilityStatus = "False";
                                       showMaternityPopup();
                                   }else{
                                       showAgePopup();
                                   }
                                } else{
                                   showAgePopup();
                               }
                                }else{
                                    showAgePopup();
                                }

                            }
                        }
                    }

                } else {
                    EditDobSelf.setText(strSelfAgeEditText);
                }

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    private void showAgePopupNSTP() {
        Dialog alert_dialogNSTP;
        alert_dialogNSTP = new Dialog(PersonalInformationCHI.this);
        alert_dialogNSTP.setCanceledOnTouchOutside(false);
        alert_dialogNSTP.setCancelable(false);
        alert_dialogNSTP.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialogNSTP.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert_dialogNSTP.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialogNSTP.setContentView(R.layout.alert_dialog_nstp_new);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(alert_dialogNSTP.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        alert_dialogNSTP.show();
        TextView ok_dialog = alert_dialogNSTP.findViewById(R.id.ok_dialog);
        TextView CancelDialog = alert_dialogNSTP.findViewById(R.id.CancelDialog);
        ImageView cutImgNSTP = alert_dialogNSTP.findViewById(R.id.cutImgNSTP);
        cutImgNSTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialogNSTP.dismiss();
            }
        });
        CancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialogNSTP.dismiss();
            }
        });

        ok_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalInformationCHI.this, PolicyTypeCHI.class);
                intent.putExtra("strEdtNameSelf", strEdtNameSelf);
                intent.putExtra("str_age", str_age);
                intent.putExtra("str_edt_phone", str_edt_phone);
                intent.putExtra("str_email", str_email);
                intent.putExtra("str_policyType_spinner", str_policyType_spinner);
                intent.putExtra("str_IndividualTypeEdit", str_IndividualTypeEdit);
                intent.putExtra("strSelfAgeEditText", strSelfAgeEditText);
                intent.putExtra("strGenderSpinner", strGenderSpinner);
                intent.putExtra("strCheckBoxSpouse", strCheckBoxSpouse);
                intent.putExtra("strSpouseAgeEditText", strSpouseAgeEditText);
                intent.putExtra("strCheckBoxMother", strCheckBoxMother);
                intent.putExtra("strMotherAgeEditText", strMotherAgeEditText);
                intent.putExtra("strFatherAgeEditText", strFatherAgeEditText);
                intent.putExtra("strCheckBoxFather", strCheckBoxFather);
                intent.putExtra("strCheckBoxMotherLaw", strCheckBoxMotherLaw);
                intent.putExtra("strMotherLawAgeEditText", strMotherLawAgeEditText);
                intent.putExtra("strCheckBoxFatherLaw", strCheckBoxFatherLaw);
                intent.putExtra("strFatherLawAgeEditText", strFatherLawAgeEditText);
                intent.putExtra("strFirstSonAgeEditText", strFirstSonAgeEditText);
                intent.putExtra("strSecondSonAgeEditText", strSecondSonAgeEditText);
                intent.putExtra("strThirdSonAgeEditText", strThirdSonAgeEditText);
                intent.putExtra("strFourSonAgeEditText", strFourSonAgeEditText);
                intent.putExtra("strCheckBoxSelf", strCheckBoxSelf);
                intent.putExtra("strCheckBoxSon", strCheckBoxSon);
                intent.putExtra("mCounter", mCounter);
                intent.putExtra("FamilyTypeCounter", FamilyTypeCounter);
                intent.putExtra("selectYearAdult", selectYearAdult);
                intent.putExtra("FamilyComposition", FamilyComposition);
                intent.putExtra("ParentComposition", ParentComposition);
                intent.putExtra("PersonalAccidentCategory", PersonalAccidentCategory);
                intent.putExtra("selectFirstYearChild", selectFirstYearChild);
                intent.putExtra("selectSecSonChild", selectSecSonChild);
                intent.putExtra("selectThirdSonChild", selectThirdSonChild);
                intent.putExtra("selectYearChildFour", selectYearChildFour);
                intent.putExtra("selectYearSecondAdult", selectYearSecondAdult);
                intent.putExtra("selectYearAdult", selectYearAdult);
                intent.putExtra("selectYearMotherAdult", selectYearMotherAdult);
                intent.putExtra("selectMotherLawAdult", selectMotherLawAdult);
                intent.putExtra("selectFatherLawAdult", selectFatherLawAdult);
                intent.putExtra("selectYearFatherAdult", selectYearFatherAdult);
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
                intent.putExtra("strFor", "1");
                startActivity(intent);
                finish();
                alert_dialogNSTP.dismiss();

            }
        });
    }
    public void showSpouseCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PersonalInformationCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSpouseAgeEditText = dateFormatter.format(newDate.getTime());
            Log.e("strSelfAgeEditText", strSpouseAgeEditText);
            SpouseDobEdit.setText(strSpouseAgeEditText);
            String[] strdDate = strSpouseAgeEditText.split("/");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            strSpouseAgeEditText1 = strdDate[2];
            Log.e("strSpouseAgeEditText1", strSpouseAgeEditText1);
            try {
                SelectDate = dateFormatter.parse(strSpouseAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearSecondAdult = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (str_policyType_spinner.equals("Individual")) {
                if (strCheckBoxSpouse.equals("Checked")) {
                    strSelfAgeEditText = strSpouseAgeEditText;
                    selectYearAdult=selectYearSecondAdult;
                    EditDobSelf.setText(strSelfAgeEditText);
                }
            }
            if (selectYearSecondAdult < 18 || (selectYearSecondAdult > 55)) {
//                Toast.makeText(PersonalInformationCHI.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                strSpouseAgeEditText = "Select Dob";
                SpouseDobEdit.setText(strSpouseAgeEditText);
                showAgePopupNSTP();
            } else {
                if (selectYearSecondAdult < Integer.parseInt(strFirstString) || (selectYearSecondAdult > Integer.parseInt(strFourString))) {
                    SpouseDobEdit.setText(strSpouseAgeEditText);
                    if (selectYearSecondAdult > 45) {
                        if (!(MaternityAndChildcare.equals("False")&&SterilityInfertilityStatus.equals("False"))){
                            MaternityAndChildcare = "False";
                            SterilityInfertilityStatus = "False";
                            showMaternityPopup();
                        }else{
                            showAgePopup();
                        }
                    }else{
                        showAgePopup();
                    }
                } else {
                    SpouseDobEdit.setText(strSpouseAgeEditText);
                }
            }


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    public void showFirstSonCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PersonalInformationCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strFirstSonAgeEditText = dateFormatter.format(newDate.getTime());
            FirstSonAgeEditText.setText(strFirstSonAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strFirstSonAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectFirstYearChild = period.getYears();
                    Log.e("selectFirstYearChild", String.valueOf(selectFirstYearChild));
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strFirstSonAgeEditText, formatter);
                LocalDate end = LocalDate.parse(today, formatter);
                String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild1 = Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strFirstSonAgeEditText != null) {
                if (daysLeftChild1 < 91 || (selectFirstYearChild > 25)) {
                    Toast.makeText(PersonalInformationCHI.this, "Child Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strFirstSonAgeEditText = "Select Dob";
                    FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                } else {
                    if (selectFirstYearChild < 5) {
                        PersonalStatusChildOne = "False";
                         PersonalAccidentPopUp();
                    }else{
                        if (PersonalStatus.equals("True")){
                            PersonalStatusChildOne = "True";
                        }else{
                            PersonalStatusChildOne = "False";
                        }
                        strNomineeName = "";
                        health_quote();
                    }
                    FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showSecondSonCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PersonalInformationCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSecondSonAgeEditText = dateFormatter.format(newDate.getTime());
            SecondSonAgeEditText.setText(strSecondSonAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strSecondSonAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectSecSonChild = period.getYears();
                    Log.e("selectSecSonChild", String.valueOf(selectSecSonChild));
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strSecondSonAgeEditText, formatter);
                LocalDate end = LocalDate.parse(today, formatter);
                String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild2 = Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strSecondSonAgeEditText != null) {
                if (daysLeftChild2 < 91 || (selectSecSonChild > 25)) {
                    Toast.makeText(PersonalInformationCHI.this, "Second Child Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strSecondSonAgeEditText = "Select Dob";
                    SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                } else {
                    if (selectSecSonChild < 5) {
                        PersonalStatusChildTwo = "False";
                        PersonalAccidentPopUp();
                    }else{
                        if (PersonalStatus.equals("True")){
                            PersonalStatusChildTwo = "True";
                        }else{
                            PersonalStatusChildTwo = "False";
                        }
                        strNomineeName = "";
                        health_quote();
                    }
                    SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showThirdSonCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PersonalInformationCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strThirdSonAgeEditText = dateFormatter.format(newDate.getTime());
            ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strThirdSonAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectThirdSonChild = period.getYears();
                    Log.e("selectThirdSonChild", String.valueOf(selectThirdSonChild));
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strThirdSonAgeEditText, formatter);
                LocalDate end = LocalDate.parse(today, formatter);
                String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild3 = Integer.parseInt(days);
                Log.e("daysLeftChild3", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strThirdSonAgeEditText != null) {
                if (daysLeftChild3 < 91 || (selectThirdSonChild > 25)) {
                    Toast.makeText(PersonalInformationCHI.this, "Third Child Age be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strThirdSonAgeEditText = "Select Dob";
                    ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                } else {
                    if (selectThirdSonChild < 5) {
                        PersonalStatusChildThird = "False";
                        PersonalAccidentPopUp();
                    }else{
                        if (PersonalStatus.equals("True")){
                            PersonalStatusChildThird = "True";
                        }else{
                            PersonalStatusChildThird = "False";
                        }
                        strNomineeName = "";
                        health_quote();
                    }
                    ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showFourSonCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PersonalInformationCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strFourSonAgeEditText = dateFormatter.format(newDate.getTime());
            FourSonAgeEditText.setText(strFourSonAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strFourSonAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearChildFour = period.getYears();
                    Log.e("selectYearChildFour", String.valueOf(selectYearChildFour));
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strFourSonAgeEditText, formatter);
                LocalDate end = LocalDate.parse(today, formatter);
                String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild4 = Integer.parseInt(days);
                Log.e("daysLeftChild4", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strFourSonAgeEditText != null) {
                if (daysLeftChild4 < 91 || selectYearChildFour > 25) {
                    Toast.makeText(PersonalInformationCHI.this, "Fourth Child Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strFourSonAgeEditText = "Select Dob";
                    FourSonAgeEditText.setText(strFourSonAgeEditText);
                } else {
                    if (selectYearChildFour < 5) {
                        PersonalStatusChildFour = "False";
                        PersonalAccidentPopUp();
                    }else{
                        if (PersonalStatus.equals("True")){
                            PersonalStatusChildFour = "True";
                        }else{
                            PersonalStatusChildFour = "False";
                        }
                        strNomineeName = "";
                        health_quote();
                    }
                    FourSonAgeEditText.setText(strFourSonAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showMotherCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PersonalInformationCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strMotherAgeEditText = dateFormatter.format(newDate.getTime());
            Log.e("strMotherAgeEditText", strMotherAgeEditText);
            MotherAgeEditText.setText(strMotherAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strMotherAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearMotherAdult = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (str_policyType_spinner.equals("Individual")) {
                if (strCheckBoxMother.equals("Checked")) {
                    strSelfAgeEditText = strMotherAgeEditText;
                    selectYearAdult=selectYearMotherAdult;
                    EditDobSelf.setText(strSelfAgeEditText);
                }
            }

            if (selectYearMotherAdult < 36 || (selectYearMotherAdult > 55)) {
                Toast.makeText(PersonalInformationCHI.this, "Mother Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                strMotherAgeEditText = "Select Dob";
                MotherAgeEditText.setText(strMotherAgeEditText);
                showAgePopupNSTP();
            } else {
                if (selectYearMotherAdult < Integer.parseInt(strFirstString) || (selectYearMotherAdult > Integer.parseInt(strFourString))) {
                    MotherAgeEditText.setText(strMotherAgeEditText);
                    showAgePopup();
                } else {
                    if (selectYearMotherAdult < 36 || (selectYearMotherAdult > 55)) {
                        Toast.makeText(PersonalInformationCHI.this, "Mother Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                        strMotherAgeEditText = "Select Dob";
                        MotherAgeEditText.setText(strMotherAgeEditText);
                        showAgePopupNSTP();
                    } else {
                        MotherAgeEditText.setText(strMotherAgeEditText);
                    }

                }
            }


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    public void showFatherCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PersonalInformationCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strFatherAgeEditText=dateFormatter.format(newDate.getTime());
            Log.e("strFatherAgeEditText", strFatherAgeEditText);
            FatherAgeEditText.setText(strFatherAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strFatherAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearFatherAdult = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (str_policyType_spinner.equals("Individual")) {
                if (strCheckBoxFather.equals("Checked")) {
                    strSelfAgeEditText = strFatherAgeEditText;
                    selectYearAdult=selectYearFatherAdult;
                    EditDobSelf.setText(strSelfAgeEditText);
                }
            }
            if (selectYearFatherAdult < 36 || (selectYearFatherAdult > 55)) {
                Toast.makeText(PersonalInformationCHI.this, "Father Age must be between 36 to 75 years ", Toast.LENGTH_SHORT).show();
                strFatherAgeEditText="Select Dob";
                FatherAgeEditText.setText(strFatherAgeEditText);
                showAgePopupNSTP();
            }else{
                if (selectYearFatherAdult < Integer.parseInt(strFirstString) || (selectYearFatherAdult > Integer.parseInt(strFourString))) {
                    FatherAgeEditText.setText(strFatherAgeEditText);
                    showAgePopup();
                }else{
                    if (selectYearMotherAdult < 36 || (selectYearMotherAdult > 55)) {
                        Toast.makeText(PersonalInformationCHI.this, "Father Age must be between 36 to 75 years ", Toast.LENGTH_SHORT).show();
                        strFatherAgeEditText="Select Dob";
                        FatherAgeEditText.setText(strFatherAgeEditText);
                        showAgePopupNSTP();
                    }else{
                        FatherAgeEditText.setText(strFatherAgeEditText);
                    }

                }
            }



        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    public void showMotherInLawCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PersonalInformationCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strMotherLawAgeEditText = dateFormatter.format(newDate.getTime());
            Log.e("strMotherLawAgeEditText", strMotherLawAgeEditText);
            MotherLawAgeEditText.setText(strMotherLawAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strMotherLawAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectMotherLawAdult = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (str_policyType_spinner.equals("Individual")) {
                if (strCheckBoxMotherLaw.equals("Checked")) {
                    strSelfAgeEditText = strMotherLawAgeEditText;
                    selectYearAdult=selectMotherLawAdult;
                    EditDobSelf.setText(strSelfAgeEditText);
                }
            }


            if (selectMotherLawAdult < 36 || (selectMotherLawAdult > 55)) {
                Toast.makeText(PersonalInformationCHI.this, "Mother-In-Law Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                strMotherLawAgeEditText = "Select Dob";
                MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                showAgePopupNSTP();
            } else {
                if (selectMotherLawAdult < Integer.parseInt(strFirstString) || (selectMotherLawAdult > Integer.parseInt(strFourString))) {
                    MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                    showAgePopup();
                } else {
                    if (selectMotherLawAdult < 36 || (selectMotherLawAdult > 55)) {
                        Toast.makeText(PersonalInformationCHI.this, "Mother-In-Law Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                        strMotherLawAgeEditText = "Select Dob";
                        MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                        showAgePopupNSTP();
                    } else {
                        MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                    }
                }


            }


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    public void showFatherInLawCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PersonalInformationCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strFatherLawAgeEditText = dateFormatter.format(newDate.getTime());
            Log.e("strFatherLawAgeEditText", strFatherLawAgeEditText);
            FatherLawAgeEditText.setText(strFatherLawAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strFatherLawAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectFatherLawAdult = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (str_policyType_spinner.equals("Individual")) {
                if (strCheckBoxFatherLaw.equals("Checked")) {
                    strSelfAgeEditText = strFatherLawAgeEditText;
                    selectYearAdult=selectFatherLawAdult;
                    EditDobSelf.setText(strSelfAgeEditText);
                }

            }
            if (selectFatherLawAdult < 36 || (selectFatherLawAdult > 55)) {
                Toast.makeText(PersonalInformationCHI.this, "Father-In-Law Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                strFatherLawAgeEditText = "Select Dob";
                FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                showAgePopupNSTP();
            } else {
                if (selectFatherLawAdult < Integer.parseInt(strFirstString) || (selectFatherLawAdult > Integer.parseInt(strFourString))) {
                    FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                    showAgePopup();
                } else {
                    if (selectFatherLawAdult < 36 || (selectFatherLawAdult > 55)) {
                        Toast.makeText(PersonalInformationCHI.this, "Father-In-Law Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                        strFatherLawAgeEditText = "Select Dob";
                        FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                        showAgePopupNSTP();
                    } else {
                        FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                    }
                }


            }


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    private void showNomineeCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PersonalInformationCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strNomineeDobEdit = dateFormatter.format(newDate.getTime());
            Log.e("strNomineeDobEdit", strNomineeDobEdit);
            NomineeDobEdit.setText(strNomineeDobEdit);

            try {
                SelectDate = dateFormatter.parse(strNomineeDobEdit);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectNomineeYear = period.getYears();
                    Log.e("selectNomineeYear", String.valueOf(selectNomineeYear));
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectNomineeYear <= 5) {
                appointeeNominee.setVisibility(View.VISIBLE);

            } else {
                appointeeNominee.setVisibility(View.GONE);
            }


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showNomineeAppointCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PersonalInformationCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strAppointeeNomineeDobEdit = dateFormatter.format(newDate.getTime());
            appointeeNomineeDobEdit.setText(strAppointeeNomineeDobEdit);
            try {
                SelectDate = dateFormatter.parse(strAppointeeNomineeDobEdit);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectAppointee = period.getYears();
                    Log.e("selectSecSonChild", String.valueOf(selectSecSonChild));
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (selectAppointee < 18 || (selectAppointee > 75)) {
                Toast.makeText(PersonalInformationCHI.this, "Appointee Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
                strAppointeeNomineeDobEdit = "Select Dob";
                appointeeNomineeDobEdit.setText(strAppointeeNomineeDobEdit);

            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void pincodeURL() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("pincode", strPinCodeEdit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(PersonalInformationCHI.this, object, UrlHealthConstants.GetStateCity_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    if (Tag == RequestHealthConstants.GetCity) {
                        try {
                            strCityEdit = object.getString("CityName");
                            strStateEdit = object.getString("StateName");
                            CityEdit.setText(strCityEdit);
                            StateEdit.setText(strStateEdit);
                            StateEditProposer.setText(strStateEdit);
                            CityEditProposer.setText(strCityEdit);
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
    double calculateBMI(double kg, double cm) {
        double heightMeter = cm / 100;
        BMI = kg / (heightMeter * heightMeter);
        Log.e("bmi", String.valueOf(BMI));
        return BMI;
    }
    double convertFeetandInchesToCentimeter(String feet, String inches) {
        double heightInFeet = 0;
        double heightInInches = 0;
        try {
            if (feet != null && feet.trim().length() != 0) {
                heightInFeet = Double.parseDouble(feet);
            }
            if (inches != null && inches.trim().length() != 0) {
                heightInInches = Double.parseDouble(inches);
            }

        } catch (NumberFormatException nfe) {

        }
        cm = (heightInFeet * 30.48) + (heightInInches * 2.54);
        Log.e("heightInCm", String.valueOf(cm));
        return cm;

    }
    private void alertPopup() {
        final Dialog alert_dialog = new Dialog(PersonalInformationCHI.this);
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.alert_dialog_nstp);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(alert_dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        TextView ok_dialog, KnowMoreText, alert_heading;
        KnowMoreText = alert_dialog.findViewById(R.id.KnowMoreText);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        ok_dialog = alert_dialog.findViewById(R.id.ok_dialog);
        KnowMoreText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_heading.setVisibility(View.VISIBLE);
                KnowMoreText.setVisibility(View.GONE);
            }
        });
        ok_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialog.dismiss();
            }
        });
        alert_dialog.show();
    }
    private void CheckMotherFatherCondition() {
        if (strCheckBoxMother.equals("Checked")) {
            if (strMotherEditTextName.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Mother Name", Toast.LENGTH_SHORT).show();
            } else if (strMotherAgeEditText.equals("Select Dob") || strMotherAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Mother DOB", Toast.LENGTH_SHORT).show();
            }else if (selectYearMotherAdult < 36 || (selectYearMotherAdult > 55)) {
                Toast.makeText(PersonalInformationCHI.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                showAgePopupNSTP();
            } else if (strMotherOccupationEdit.equals("Select Occupation")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Mother Occupation", Toast.LENGTH_SHORT).show();
            } else if (strMotherFeetEditText.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Mother Ft", Toast.LENGTH_SHORT).show();
            } else if (strInchesMotherEdit.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Mother Inches", Toast.LENGTH_SHORT).show();
            } else if (strMotherWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Mother Weight", Toast.LENGTH_SHORT).show();
            } else if (!(Double.parseDouble(strBMIMotherEdit) >= 16.0 && Double.parseDouble(strBMIMotherEdit) <= 33.0)) {
                Toast.makeText(PersonalInformationCHI.this, "Mother BMI is not normal", Toast.LENGTH_SHORT).show();
            } else {
                if (strCheckBoxFather.equals("Checked")) {
                    if (strFatherEditTextName.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Enter Father Name", Toast.LENGTH_SHORT).show();
                    } else if (strFatherAgeEditText.equals("Select Dob") || strFatherAgeEditText.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Enter Father DOB", Toast.LENGTH_SHORT).show();
                    }else if (selectYearFatherAdult < 36 || selectYearFatherAdult > 55) {
                        Toast.makeText(PersonalInformationCHI.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                        showAgePopupNSTP();
                    } else if (strFatherOccupationEdit.equals("Select Occupation")) {
                        Toast.makeText(PersonalInformationCHI.this, "Select Father Occupation", Toast.LENGTH_SHORT).show();
                    } else if (strFeetFatherEdit.equals("Ft")) {
                        Toast.makeText(PersonalInformationCHI.this, "Select Father Ft", Toast.LENGTH_SHORT).show();
                    } else if (strInchesFatherEdit.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Select Father Inches", Toast.LENGTH_SHORT).show();
                    } else if (strFatherWeightEdit.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Enter Father Weight", Toast.LENGTH_SHORT).show();
                    } else if (!(Double.parseDouble(strBMIFatherEdit) >= 16.0 && Double.parseDouble(strBMIFatherEdit) <= 33.0)) {
                        Toast.makeText(PersonalInformationCHI.this, "Father BMI is not normal", Toast.LENGTH_SHORT).show();
                    } else {
                        methoElse();
                    }
                } else {
                    methoElse();
                }
            }
        }
        else if (strCheckBoxFather.equals("Checked")) {
            if (strFatherEditTextName.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Father Name", Toast.LENGTH_SHORT).show();
            } else if (strFatherAgeEditText.equals("Select Dob") || strFatherAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Father DOB", Toast.LENGTH_SHORT).show();
            }else if (selectYearFatherAdult < 36 || selectYearFatherAdult > 55) {
                Toast.makeText(PersonalInformationCHI.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                showAgePopupNSTP();
            } else if (strFatherOccupationEdit.equals("Select Occupation")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Father Occupation", Toast.LENGTH_SHORT).show();
            } else if (strFeetFatherEdit.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Father Ft", Toast.LENGTH_SHORT).show();
            } else if (strInchesFatherEdit.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Father Inches", Toast.LENGTH_SHORT).show();
            } else if (strFatherWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Father Weight", Toast.LENGTH_SHORT).show();
            } else if (!(Double.parseDouble(strBMIFatherEdit) >= 16.0 && Double.parseDouble(strBMIFatherEdit) <= 33.0)) {
                Toast.makeText(PersonalInformationCHI.this, "Father BMI is not normal", Toast.LENGTH_SHORT).show();
            } else {
                methoElse();
            }
        } else if (strCheckBoxMotherLaw.equals("Checked")) {
            if (strMotherLawEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Mother-In-Law Name", Toast.LENGTH_SHORT).show();
            } else if (strMotherLawAgeEditText.equals("Select Dob") || strMotherLawAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Mother-In-Law DOB", Toast.LENGTH_SHORT).show();
            }else if (selectMotherLawAdult < 36 || selectMotherLawAdult > 55) {
                Toast.makeText(PersonalInformationCHI.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                showAgePopupNSTP();
            }else if (strOccupationEditMotherLaw.equals("Select Occupation")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Mother-In-Law Occupation", Toast.LENGTH_SHORT).show();
            } else if (strFeetEditTextMotherLaw.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Mother-In-Law Ft", Toast.LENGTH_SHORT).show();
            } else if (strInchesEditTextMotherLaw.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Mother-In-Law Inches", Toast.LENGTH_SHORT).show();
            } else if (strWeightMotherLawEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Mother-In-Law Weight", Toast.LENGTH_SHORT).show();
            } else if (!(Double.parseDouble(strBMIMotherLawEdit) >= 16.0 && Double.parseDouble(strBMIMotherLawEdit) <= 33.0)) {
                Toast.makeText(PersonalInformationCHI.this, "Mother-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
            } else {
                if (strCheckBoxFatherLaw.equals("Checked")) {
                    if (strFatherLawNameEdit.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Enter Father-In-Law Name", Toast.LENGTH_SHORT).show();
                    } else if (strFatherLawAgeEditText.equals("Select Dob") || strFatherLawAgeEditText.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Enter Father-In-Law DOB", Toast.LENGTH_SHORT).show();
                    }else if (selectFatherLawAdult < 36 || selectFatherLawAdult > 55) {
                        Toast.makeText(PersonalInformationCHI.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                        showAgePopupNSTP();
                    } else if (strOccupationFatherLawEdit.equals("Select Occupation")) {
                        Toast.makeText(PersonalInformationCHI.this, "Select Father-In-Law Occupation", Toast.LENGTH_SHORT).show();
                    } else if (strEditFeetFatherLaw.equals("Ft")) {
                        Toast.makeText(PersonalInformationCHI.this, "Select Father-In-Law Ft", Toast.LENGTH_SHORT).show();
                    } else if (strEditInchesFatherLaw.equals("Inches")) {
                        Toast.makeText(PersonalInformationCHI.this, "Select Father-In-Law Inches", Toast.LENGTH_SHORT).show();
                    } else if (strFatherLawWeightEdit.equals("")) {
                        Toast.makeText(PersonalInformationCHI.this, "Enter Father-In-Law Weight", Toast.LENGTH_SHORT).show();
                    } else if (!(Double.parseDouble(strFatherLawBMIEdit) >= 16.0 && Double.parseDouble(strFatherLawBMIEdit) <= 33.0)) {
                        Toast.makeText(PersonalInformationCHI.this, "Father-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
                    } else {
                        methoElse();
                    }
                } else {
                    methoElse();
                }
            }
        } else if (strCheckBoxFatherLaw.equals("Checked")) {
            if (strFatherLawNameEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Father-In-Law Name", Toast.LENGTH_SHORT).show();
            } else if (strFatherLawAgeEditText.equals("Select Dob") || strFatherLawAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Father-In-Law DOB", Toast.LENGTH_SHORT).show();
            } else if (selectFatherLawAdult < 36 || selectFatherLawAdult > 55) {
                Toast.makeText(PersonalInformationCHI.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                showAgePopupNSTP();
            }else if (strOccupationFatherLawEdit.equals("Select Occupation")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Father-In-Law Occupation", Toast.LENGTH_SHORT).show();
            } else if (strEditFeetFatherLaw.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Father-In-Law Ft", Toast.LENGTH_SHORT).show();
            } else if (strEditInchesFatherLaw.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Father-In-Law Inches", Toast.LENGTH_SHORT).show();
            } else if (strFatherLawWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Father-In-Law Weight", Toast.LENGTH_SHORT).show();
            } else if (!(Double.parseDouble(strFatherLawBMIEdit) >= 16.0 && Double.parseDouble(strFatherLawBMIEdit) <= 33.0)) {
                Toast.makeText(PersonalInformationCHI.this, "Father-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
            } else {
                methoElse();
            }
        } else {
            methoElse();
        }
    }
    private void CheckMotherFatherCondition1() {
        if (strCheckBoxMother.equals("Checked")) {
            if (strMotherEditTextName.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Mother Name", Toast.LENGTH_SHORT).show();
            } else if (strMotherAgeEditText.equals("Select Dob") || strMotherAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Mother DOB", Toast.LENGTH_SHORT).show();
            }else if (selectYearMotherAdult < 36 || (selectYearMotherAdult > 55)) {
                Toast.makeText(PersonalInformationCHI.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                showAgePopupNSTP();
            } else if (strMotherOccupationEdit.equals("Select Occupation")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Mother Occupation", Toast.LENGTH_SHORT).show();
            } else if (strMotherFeetEditText.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Mother Ft", Toast.LENGTH_SHORT).show();
            } else if (strInchesMotherEdit.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Mother Inches", Toast.LENGTH_SHORT).show();
            } else if (strMotherWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Mother Weight", Toast.LENGTH_SHORT).show();
            } else if (!(Double.parseDouble(strBMIMotherEdit) >= 16.0 && Double.parseDouble(strBMIMotherEdit) <= 33.0)) {
                Toast.makeText(PersonalInformationCHI.this, "Mother BMI is not normal", Toast.LENGTH_SHORT).show();
            } else {
                methoElse();

            }
        } else if (strCheckBoxFather.equals("Checked")) {
            if (strFatherEditTextName.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Father Name", Toast.LENGTH_SHORT).show();
            } else if (strFatherAgeEditText.equals("Select Dob") || strFatherAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Father DOB", Toast.LENGTH_SHORT).show();
            } else if (selectYearFatherAdult < 36 || selectYearFatherAdult > 55) {
                Toast.makeText(PersonalInformationCHI.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                showAgePopupNSTP();
            }else if (strFatherOccupationEdit.equals("Select Occupation")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Father Occupation", Toast.LENGTH_SHORT).show();
            } else if (strFeetFatherEdit.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Father Ft", Toast.LENGTH_SHORT).show();
            } else if (strInchesFatherEdit.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Father Inches", Toast.LENGTH_SHORT).show();
            } else if (strFatherWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Father Weight", Toast.LENGTH_SHORT).show();
            } else if (!(Double.parseDouble(strBMIFatherEdit) >= 16.0 && Double.parseDouble(strBMIFatherEdit) <= 33.0)) {
                Toast.makeText(PersonalInformationCHI.this, "Father BMI is not normal", Toast.LENGTH_SHORT).show();
            } else {
                methoElse();
            }
        } else if (strCheckBoxMotherLaw.equals("Checked")) {
            if (strMotherLawEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Mother-In-Law Name", Toast.LENGTH_SHORT).show();
            } else if (strMotherLawAgeEditText.equals("Select Dob") || strMotherLawAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Mother-In-Law DOB", Toast.LENGTH_SHORT).show();
            } else if (selectMotherLawAdult < 36 || selectMotherLawAdult > 55) {
                Toast.makeText(PersonalInformationCHI.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                showAgePopupNSTP();
            }else if (strOccupationEditMotherLaw.equals("Select Occupation")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Mother-In-Law Occupation", Toast.LENGTH_SHORT).show();
            } else if (strFeetEditTextMotherLaw.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Mother-In-Law Ft", Toast.LENGTH_SHORT).show();
            } else if (strInchesEditTextMotherLaw.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Mother-In-Law Inches", Toast.LENGTH_SHORT).show();
            } else if (strWeightMotherLawEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Mother-In-Law Weight", Toast.LENGTH_SHORT).show();
            } else if (!(Double.parseDouble(strBMIMotherLawEdit) >= 16.0 && Double.parseDouble(strBMIMotherLawEdit) <= 33.0)) {
                Toast.makeText(PersonalInformationCHI.this, "Mother-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
            } else {
                methoElse();
            }
        } else if (strCheckBoxFatherLaw.equals("Checked")) {
            if (strFatherLawNameEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Father-In-Law Name", Toast.LENGTH_SHORT).show();
            } else if (strFatherLawAgeEditText.equals("Select Dob") || strFatherLawAgeEditText.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Father-In-Law DOB", Toast.LENGTH_SHORT).show();
            }else if (selectFatherLawAdult < 36 || selectFatherLawAdult > 55) {
                Toast.makeText(PersonalInformationCHI.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                showAgePopupNSTP();
            } else if (strOccupationFatherLawEdit.equals("Select Occupation")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Father-In-Law Occupation", Toast.LENGTH_SHORT).show();
            } else if (strEditFeetFatherLaw.equals("Ft")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Father-In-Law Ft", Toast.LENGTH_SHORT).show();
            } else if (strEditInchesFatherLaw.equals("Inches")) {
                Toast.makeText(PersonalInformationCHI.this, "Select Father-In-Law Inches", Toast.LENGTH_SHORT).show();
            } else if (strFatherLawWeightEdit.equals("")) {
                Toast.makeText(PersonalInformationCHI.this, "Enter Father-In-Law Weight", Toast.LENGTH_SHORT).show();
            } else if (!(Double.parseDouble(strFatherLawBMIEdit) >= 16.0 && Double.parseDouble(strFatherLawBMIEdit) <= 33.0)) {
                Toast.makeText(PersonalInformationCHI.this, "Father-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
            } else {
                methoElse();
            }
        } else {
            methoElse();
        }
    }
    private void methoElse() {
        Intent intent = new Intent(PersonalInformationCHI.this, MemberMedicalInfoCHI.class);
        intent.putExtra("str_edt_name", str_edt_name);
        intent.putExtra("str_edt_phone", str_edt_phone);
        intent.putExtra("TreatmentCheckBoxCheck", TreatmentCheckBoxCheck);
        intent.putExtra("str_email", str_email);
        intent.putExtra("str_policyType_spinner", str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit", str_IndividualTypeEdit);
        intent.putExtra("strSelfAgeEditText", strSelfAgeEditText);
        intent.putExtra("strEdtNameSelf", strEdtNameSelf);
        intent.putExtra("strEmailIDEditSelf", strEmailIDEditSelf);
        intent.putExtra("strEditGenderSelf", strEditGenderSelf);
        intent.putExtra("strEditOccupationSelf", strEditOccupationSelf);
        intent.putExtra("strGenderSpinner", strGenderSpinner);
        intent.putExtra("strCheckBoxSpouse", strCheckBoxSpouse);
        intent.putExtra("strCheckBoxMother", strCheckBoxMother);
        intent.putExtra("strMotherAgeEditText", strMotherAgeEditText);
        intent.putExtra("strFatherAgeEditText", strFatherAgeEditText);
        intent.putExtra("strCheckBoxFather", strCheckBoxFather);
        intent.putExtra("strCheckBoxMotherLaw", strCheckBoxMotherLaw);
        intent.putExtra("strMotherLawAgeEditText", strMotherLawAgeEditText);
        intent.putExtra("strCheckBoxFatherLaw", strCheckBoxFatherLaw);
        intent.putExtra("strFatherLawAgeEditText", strFatherLawAgeEditText);
        intent.putExtra("strFirstSonAgeEditText", strFirstSonAgeEditText);
        intent.putExtra("strSecondSonAgeEditText", strSecondSonAgeEditText);
        intent.putExtra("strThirdSonAgeEditText", strThirdSonAgeEditText);
        intent.putExtra("strFourSonAgeEditText", strFourSonAgeEditText);
        intent.putExtra("strCheckBoxSon", strCheckBoxSon);
        intent.putExtra("mCounter", mCounter);
        intent.putExtra("strTotalPremium", strTotalPremium);
        intent.putExtra("strPinCodeEdit", strPinCodeEdit);
        intent.putExtra("strPermanentAddressEdit2", strPermanentAddressEdit2);
        intent.putExtra("strPermanentAddressEdit", strPermanentAddressEdit);
        intent.putExtra("strStateEdit", strStateEdit);
        intent.putExtra("strCityEdit", strCityEdit);
        intent.putExtra("strRelationAdultOneEdit", strRelationAdultOneEdit);
        intent.putExtra("strEditInchesSelf", strEditInchesSelf);
        intent.putExtra("strEditFtSelf", strEditFtSelf);
        intent.putExtra("strWeightEditSelf", strWeightEditSelf);
        intent.putExtra("strBMIEdit", strBMIEdit);
        intent.putExtra("strNomineeRelationEdit", strNomineeRelationEdit);
        intent.putExtra("strNomineeName", strNomineeName);
        intent.putExtra("strNomineeGenderEdit", strNomineeGenderEdit);
        intent.putExtra("strContactNominee", strContactNominee);
        intent.putExtra("strNomineeDobEdit", strNomineeDobEdit);
        intent.putExtra("strSumInsured", strSumInsured);
        intent.putExtra("strPlanTypeTXT", strPlanTypeTXT);
        intent.putExtra("NetPremium", NetPremium);
        intent.putExtra("strBasicPremium", strBasicPremium);
        intent.putExtra("strPolicyTenure", strPolicyTenure);
        intent.putExtra("PlanType", PlanType);
        intent.putExtra("BasicStatus", BasicStatus);
        intent.putExtra("PersonalStatus", PersonalStatus);
        intent.putExtra("CriticalStatus", CriticalStatus);
        intent.putExtra("DailyHospitalSatus", DailyHospitalSatus);
        intent.putExtra("ModernTreatmentsStatus", ModernTreatmentsStatus);
        intent.putExtra("ExtensionPreHospitalization", ExtensionPreHospitalization);
        intent.putExtra("ExtensionPr0Hospitalization", ExtensionPr0Hospitalization);
        intent.putExtra("MaternityAndChildcare", MaternityAndChildcare);
        intent.putExtra("MaternityAndChildcareMale", MaternityAndChildcareMale);
        intent.putExtra("SterilityInfertilityMale", SterilityInfertilityMale);
        intent.putExtra("CoverageNonMedical", CoverageNonMedical);
        intent.putExtra("ConditionWaiverStatus", ConditionWaiverStatus);
        intent.putExtra("PersonalAccidentACoverStatus", PersonalAccidentACoverStatus);
        intent.putExtra("PersonalAccidentBCoverStatus", PersonalAccidentBCoverStatus);
        intent.putExtra("PreExistingDiseaseStatus", PreExistingDiseaseStatus);
        intent.putExtra("OutpatientDentalStatus", OutpatientDentalStatus);
        intent.putExtra("SecondOpinionStatus", SecondOpinionStatus);
        intent.putExtra("RestCureStatus", RestCureStatus);
        intent.putExtra("ObesityWeightStatus", ObesityWeightStatus);
        intent.putExtra("SterilityInfertilityStatus", SterilityInfertilityStatus);
        intent.putExtra("EnhancedOrganStatus", EnhancedOrganStatus);
        intent.putExtra("GlobalCoverStatus", GlobalCoverStatus);
        intent.putExtra("MedicallyAdvisedStatus", MedicallyAdvisedStatus);
        intent.putExtra("EmergencyAssistanceStatus", EmergencyAssistanceStatus);
        intent.putExtra("HomeCareStatus", HomeCareStatus);
        intent.putExtra("WellnessBenefitStatus", WellnessBenefitStatus);
        intent.putExtra("DiseaseManagementStatus", DiseaseManagementStatus);
        intent.putExtra("LoyaltyDiscountStatus", LoyaltyDiscountStatus);
        intent.putExtra("CoPaymentStatus", CoPaymentStatus);
        intent.putExtra("TreatmentStatus", TreatmentStatus);
        intent.putExtra("strIDTypeName", strIDTypeName);
        intent.putExtra("EmergencyTravellingStatus", EmergencyTravellingStatus);
        intent.putExtra("strPolicyNumber", strPolicyNumber);
        intent.putExtra("CoPaymentLoading", CoPaymentLoading);
        intent.putExtra("PremiumWaiverStatus", PremiumWaiverStatus);
        intent.putExtra("PosPolicyNo", PosPolicyNo);
        intent.putExtra("strSpouseAgeEditText", strSpouseAgeEditText);
        intent.putExtra("strPackageOne", strPackageOne);
        intent.putExtra("MaternityAndChildcareAddOn", MaternityAndChildcareAddOn);
        intent.putExtra("strChildOneNameEdit", strChildOneNameEdit);
        intent.putExtra("strFirstSonAgeEditText", strFirstSonAgeEditText);
        intent.putExtra("strGenderChildOneEdit", strGenderChildOneEdit);
        intent.putExtra("str_oneFtSpinner", str_oneFtSpinner);
        intent.putExtra("str_oneInchesSpinner", str_oneInchesSpinner);
        intent.putExtra("str_oneWeightEdit", str_oneWeightEdit);
        intent.putExtra("addons", addons);
        intent.putExtra("Discounts", Discounts);
        intent.putExtra("strCheckBoxSelf", strCheckBoxSelf);
        intent.putExtra("strSpouseNameEditText", strSpouseNameEditText);
        intent.putExtra("strSpouseGenderEdit", strSpouseGenderEdit);
        intent.putExtra("strSpouseOccupationEdit", strSpouseOccupationEdit);
        intent.putExtra("strFtSpouseEdit", strFtSpouseEdit);
        intent.putExtra("strInchesSpouseEdit", strInchesSpouseEdit);
        intent.putExtra("strWeightEditSpouse", strWeightEditSpouse);
        intent.putExtra("strSpouseBMIEdit", strSpouseBMIEdit);
        intent.putExtra("strBMIChildEdit", strBMIChildEdit);
        intent.putExtra("strSecondChildNameEdit", strSecondChildNameEdit);
        intent.putExtra("strSecondSonAgeEditText", strSecondSonAgeEditText);
        intent.putExtra("str_twoGenderSpinner", str_twoGenderSpinner);
        intent.putExtra("str_twoFtSpinner", str_twoFtSpinner);
        intent.putExtra("str_twoInchesSpinner", str_twoInchesSpinner);
        intent.putExtra("strtwoWeightEdit", strtwoWeightEdit);
        intent.putExtra("strBMIChildTwoEdit", strBMIChildTwoEdit);
        intent.putExtra("strThirdChildNameEdit", strThirdChildNameEdit);
        intent.putExtra("strThirdSonAgeEditText", strThirdSonAgeEditText);
        intent.putExtra("str_thirdGenderSpinner", str_thirdGenderSpinner);
        intent.putExtra("str_thirdFtSpinner", str_thirdFtSpinner);
        intent.putExtra("str_thirdInchesSpinner", str_thirdInchesSpinner);
        intent.putExtra("str_thirdWeightEdit", str_thirdWeightEdit);
        intent.putExtra("strBMIEChildThreeEdit", strBMIEChildThreeEdit);
        intent.putExtra("strFourChildNameEdit", strFourChildNameEdit);
        intent.putExtra("strFourSonAgeEditText", strFourSonAgeEditText);
        intent.putExtra("str_fourGenderSpinner", str_fourGenderSpinner);
        intent.putExtra("str_fourFtSpinner", str_fourFtSpinner);
        intent.putExtra("str_fourInchesSpinner", str_fourInchesSpinner);
        intent.putExtra("strFourWeightEdit", strFourWeightEdit);
        intent.putExtra("strBMIFourChildEdit", strBMIFourChildEdit);
        intent.putExtra("strSpouseOccupationEdit", strSpouseOccupationEdit);
        intent.putExtra("strRelationEditSpouse", strRelationEditSpouse);
        intent.putExtra("strRelationChildEdit", strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit", strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit", strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit", strRelationFourChildEdit);
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
        intent.putExtra("strFatherLawBMIEdit", strFatherLawBMIEdit);
        intent.putExtra("LongTermDiscountStatus", LongTermDiscountStatus);
        intent.putExtra("SubCategoryDiscountStatus", SubCategoryDiscountStatus);
        intent.putExtra("SubCategory", SubCategory);
        intent.putExtra("DirectPolicyDiscountPremium", DirectPolicyDiscountPremium);
        intent.putExtra("FamilyTypeCounter", FamilyTypeCounter);
        intent.putExtra("LongTermDiscountDiscountPremium", LongTermDiscountDiscountPremium);
        intent.putExtra("SubCategoryDiscountPremium", SubCategoryDiscountPremium);
        intent.putExtra("doubleCoPaymentDiscountPremium", doubleCoPaymentDiscountPremium);
        intent.putExtra("strOccupationEditChildOne", strOccupationEditChildOne);
        intent.putExtra("str_twoOccupationSpinner", str_twoOccupationSpinner);
        intent.putExtra("str_thirdOccupationSpinner", str_thirdOccupationSpinner);
        intent.putExtra("str_fourOccupationSpinner", str_fourOccupationSpinner);
        intent.putExtra("str_thirdOccupationSpinner", str_thirdOccupationSpinner);
        intent.putExtra("str_age", str_age);
        intent.putExtra("yearRadio", yearRadio);
        intent.putExtra("strPackage1", strPackage1);
        intent.putExtra("strPackageTwo", strPackageTwo);
        intent.putExtra("strPackageThree", strPackageThree);
        intent.putExtra("strPackageFour", strPackageFour);
        intent.putExtra("strPackageFive", strPackageFive);
        intent.putExtra("strPackageSix", strPackageSix);
        intent.putExtra("FamilyComposition", FamilyComposition);
        intent.putExtra("ParentComposition", ParentComposition);
        intent.putExtra("PersonalAccidentCategory", PersonalAccidentCategory);
        intent.putExtra("PersonalStatusChildFour", PersonalStatusChildFour);
        intent.putExtra("PersonalStatusChildThird", PersonalStatusChildThird);
        intent.putExtra("PersonalStatusChildTwo", PersonalStatusChildTwo);
        intent.putExtra("PersonalStatusChildOne", PersonalStatusChildOne);
        intent.putExtra("strswitch", strswitch);
        intent.putExtra("strCorrespondenceAddressEdit", strCorrespondenceAddressEdit);
        intent.putExtra("strCorrespondenceAddressEdit2", strCorrespondenceAddressEdit2);
        intent.putExtra("strProposerEditDob", strProposerEditDob);
        intent.putExtra("strProposerEditFt", strProposerEditFt);
        intent.putExtra("strProposerEditInches", strProposerEditInches);
        intent.putExtra("strEditGenderProposer", strEditGenderProposer);
        intent.putExtra("strEditOccupationProposer", strEditOccupationProposer);
        intent.putExtra("strProposerRelationEdit", strProposerRelationEdit);
        intent.putExtra("strProposerEdtName", strProposerEdtName);
        intent.putExtra("strWeightEditProposer", strWeightEditProposer);
        intent.putExtra("strProposerBMIEdit", strProposerBMIEdit);
        intent.putExtra("DailyHospitalCoverPremium", DailyHospitalCoverPremium);
        intent.putExtra("CriticalIllnessCoverPremium", CriticalIllnessCoverPremium);
        intent.putExtra("ExtensionPreHospitalizationCoverPremium", ExtensionPreHospitalizationCoverPremium);
        intent.putExtra("ExtensionProHospitalizationCoverPremium", ExtensionProHospitalizationCoverPremium);
        intent.putExtra("MaternityChildcareCoverPremium", MaternityChildcareCoverPremium);
        intent.putExtra("CoverageNonMedicalCoverPremium", CoverageNonMedicalCoverPremium);
        intent.putExtra("ConditionWaiverCoverPremium", ConditionWaiverCoverPremium);
        intent.putExtra("PersonalAccidentCoverPremium", PersonalAccidentCoverPremium);
        intent.putExtra("PreExistingDiseaseCoverPremium", PreExistingDiseaseCoverPremium);
        intent.putExtra("OutpatientDentalCoverPremium", OutpatientDentalCoverPremium);
        intent.putExtra("EmergencyTravellingCoverPremium", EmergencyTravellingCoverPremium);
        intent.putExtra("SecondOpinionCoverPremium", SecondOpinionCoverPremium);
        intent.putExtra("RestCureCoverPremium", RestCureCoverPremium);
        intent.putExtra("ObesityWeightCoverPremium", ObesityWeightCoverPremium);
        intent.putExtra("SterilityInfertilityCoverPremium", SterilityInfertilityCoverPremium);
        intent.putExtra("EnhancedCoverPremium", EnhancedCoverPremium);
        intent.putExtra("MedicallyAdvisedCoverPremium", MedicallyAdvisedCoverPremium);
        intent.putExtra("EmergencyAssistanceCoverPremium", EmergencyAssistanceCoverPremium);
        intent.putExtra("HomeCareCoverPremium", HomeCareCoverPremium);
        intent.putExtra("WellnessBenefitCoverPremium", WellnessBenefitCoverPremium);
        intent.putExtra("DiseaseManagementCoverPremium", DiseaseManagementCoverPremium);
        intent.putExtra("GlobalCoverCoverPremium", GlobalCoverCoverPremium);
        intent.putExtra("ModernTreatmentCoverPremium", ModernTreatmentCoverPremium);
        intent.putExtra("PremiumWaiverCoverPremium", PremiumWaiverCoverPremium);
        intent.putExtra("OrganDiscountStatus", OrganDiscountStatus);
        intent.putExtra("OrganDonorDiscountPremium", OrganDonorDiscountPremium);
        intent.putExtra("strAppointeeNomineeName", strAppointeeNomineeName);
        intent.putExtra("strAppointeeNomineeDobEdit", strAppointeeNomineeDobEdit);
        intent.putExtra("strAppointeeGenderEdit", strAppointeeGenderEdit);
        intent.putExtra("selectNomineeYear", selectNomineeYear);
        intent.putExtra("checkPackage", checkPackage);
        intent.putExtra("CoPaymentCheckBoxCheck", CoPaymentCheckBoxCheck);
        intent.putExtra("SubCategoryDiscountStatusCheck", SubCategoryDiscountStatusCheck);
        intent.putExtra("strCoPaymentEditText", strCoPaymentEditText);
        intent.putExtra("strSubLimitEditText", strSubLimitEditText);
        intent.putExtra("selectFirstYearChild", selectFirstYearChild);
        intent.putExtra("selectSecSonChild", selectSecSonChild);
        intent.putExtra("selectThirdSonChild", selectThirdSonChild);
        intent.putExtra("selectYearChildFour", selectYearChildFour);
        intent.putExtra("selectYearSecondAdult", selectYearSecondAdult);
        intent.putExtra("selectYearSecondAdult", selectYearSecondAdult);
        intent.putExtra("selectYearAdult", selectYearAdult);
        intent.putExtra("selectYearMotherAdult", selectYearMotherAdult);
        intent.putExtra("selectMotherLawAdult", selectMotherLawAdult);
        intent.putExtra("selectFatherLawAdult", selectFatherLawAdult);
        intent.putExtra("selectYearFatherAdult", selectYearFatherAdult);
        intent.putExtra("copayemntMax", copayemntMax);
        intent.putExtra("TiresDiscount", TiresDiscount);
        intent.putExtra("DirectPolicy", DirectPolicy);
        intent.putExtra("OrganDonar", OrganDonar);
        intent.putExtra("LongTerm", LongTerm);
        intent.putExtra("loyalityDiscount", loyalityDiscount);
        intent.putExtra("sublimt", sublimt);
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
        intent.putExtra("permAndCorresAddSame",permAndCorresAddSame);
        intent.putExtra("strDob",strDob);
        intent.putExtra("selectYearProposer",selectYearProposer);
        intent.putExtra("GSt", GSt);
        intent.putExtra("strFor", "0");
        startActivity(intent);
        finish();
    }
    private void health_quote() {
        customprogress.showProgressBar();
        strBloodSugar = "NA";
        strBloodPressure = "NA";
        strBloodPressureDiastolic = "NA";
        strcholesterol = "NA";

        if (strEditGenderProposer.equals("Male")) {
            strEditGenderProposer = "M";
        }
        else if (strEditGenderProposer.equals("Female")) {
            strEditGenderProposer = "F";
        } else {
            strEditGenderProposer = "";
        }
        if (strEditGenderSelf.equals("Male")) {
            strEditGenderSelf = "M";
            strGender = "M";
        } else if (strEditGenderSelf.equals("Female")) {
            strEditGenderSelf = "F";
            strGender = "F";
        }
        if (strSpouseGenderEdit.equals("Male")) {
            strSpouseGenderEdit = "M";
            strGender = "M";
        } else if (strSpouseGenderEdit.equals("Female")) {
            strSpouseGenderEdit = "F";
            strGender = "F";
        }
        if (strGenderChildOneEdit.equals("Male")) {
            strGenderChildOneEdit = "M";
            strGender = "M";
        } else if (strGenderChildOneEdit.equals("Female")) {
            strGenderChildOneEdit = "F";
            strGender = "F";
        }
        if (str_twoGenderSpinner.equals("Male")) {
            str_twoGenderSpinner = "M";
            strGender = "M";
        } else if (str_twoGenderSpinner.equals("Female")) {
            str_twoGenderSpinner = "F";
            strGender = "F";
        }
        if (str_thirdGenderSpinner.equals("Male")) {
            str_thirdGenderSpinner = "M";
            strGender = "M";
        } else if (str_thirdGenderSpinner.equals("Female")) {
            str_thirdGenderSpinner = "F";
            strGender = "F";
        }
        if (str_fourGenderSpinner.equals("Male")) {
            str_fourGenderSpinner = "M";
            strGender = "M";
        } else if (str_fourGenderSpinner.equals("Female")) {
            str_fourGenderSpinner = "F";
            strGender = "F";
        }

//        if (strProposerEditDob.equals("Select Dob")) {
//            strProposerEditDob = "";
//        }

        if (strCheckBoxSelf.equals("Checked")) {
            strProposerEdtName = strEdtNameSelf;
            strProposerEditDob = strSelfAgeEditText;
            strEditGenderProposer = strEditGenderSelf;
        } else {
            strEmailIDEditSelf = str_email;
//            strPermanentAddressEdit=pref.getaddress();
//            strStateEdit=pref.getstate();
//            strCityEdit=pref.getcity();
//            strPinCodeEdit=pref.getpincode();
        }

        if (strCheckBoxSelf.equals("Checked") && strCheckBoxSpouse.equals("Checked")) {
            str_policyType_spinner1 = str_policyType_spinner;
            MaternityAndChildcareMale="False";
            SterilityInfertilityMale="False";
        } else {
            if (strCheckBoxSelf.equals("Checked") || strCheckBoxSpouse.equals("Checked")) {
                if (strCheckBoxMother.equals("Checked") && strCheckBoxFather.equals("Checked")) {
                    str_policyType_spinner1 = "Family Floater";
                }else if(strCheckBoxMotherLaw.equals("Checked") && strCheckBoxFatherLaw.equals("Checked")){
                    str_policyType_spinner1 = "Family Floater";
                }else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    str_policyType_spinner1 = "Individual";
                    MaternityAndChildcareMale=MaternityAndChildcare;
                    SterilityInfertilityMale=SterilityInfertilityStatus;

                } else {
                    MaternityAndChildcareMale=MaternityAndChildcare;
                    SterilityInfertilityMale=SterilityInfertilityStatus;
                    str_policyType_spinner1 = str_policyType_spinner;
                }
            } else {
                MaternityAndChildcareMale=MaternityAndChildcare;
                SterilityInfertilityMale=SterilityInfertilityStatus;
                str_policyType_spinner1 = str_policyType_spinner;
            }
        }

        JSONObject object = new JSONObject();
        try {
            JSONObject RootObject = new JSONObject();
            //Authentication
            JSONObject AuthenticationObject = new JSONObject();
//            AuthenticationObject.put("WACode", "20000001");
//            AuthenticationObject.put("WAAppCode", "30000011");
            AuthenticationObject.put("WACode","20000149");
            AuthenticationObject.put("WAAppCode","30000149");
            AuthenticationObject.put("WAUserID", "USER01");
            AuthenticationObject.put("WAUserPwd", "pass@123");
            AuthenticationObject.put("WAType", "0");
            RootObject.put("Authentication", AuthenticationObject);
            //Customer
            JSONObject CustomerObject = new JSONObject();
            CustomerObject.put("CustomerType", "Individual");
            CustomerObject.put("CustomerName", strProposerEdtName);
            CustomerObject.put("DOB", strProposerEditDob);
            CustomerObject.put("Gender", strEditGenderProposer);
            CustomerObject.put("CanBeParent", "");
            CustomerObject.put("ContactTelephoneSTD", "");
            CustomerObject.put("MobileNo", str_edt_phone);
            CustomerObject.put("Emailid", strEmailIDEditSelf);
            CustomerObject.put("PresentAddressLine1", strPermanentAddressEdit);
            CustomerObject.put("PresentAddressLine2", strPermanentAddressEdit2);
            CustomerObject.put("PresentStateCode", strStateEdit);
            CustomerObject.put("PresentCityDistCode", strCityEdit);
            CustomerObject.put("PresentPinCode", strPinCodeEdit);
            CustomerObject.put("PermanentAddressLine1", strPermanentAddressEdit);
            CustomerObject.put("PermanentAddressLine2", strPermanentAddressEdit2);
            CustomerObject.put("PermanentStateCode", strStateEdit);
            CustomerObject.put("PermanentCityDistCode", strCityEdit);
            CustomerObject.put("PermanentPinCode", strPinCodeEdit);
            CustomerObject.put("CustGSTNo", "NULL");
            CustomerObject.put("ProductName", "Complete HealthCare Insurance");
            CustomerObject.put("InstrumentNo", "NULL");
            CustomerObject.put("InstrumentDate", "NULL");
            CustomerObject.put("BankID", "NULL");
            CustomerObject.put("PosPolicyNo", "");
            CustomerObject.put("ProductCode", "2825");
            CustomerObject.put("WAURN", "NULL");
            CustomerObject.put("NomineeName", "");
            CustomerObject.put("NomineeRelation", "");
            CustomerObject.put("PANNo", "NULL");
            CustomerObject.put("AadhaarNo", "");
            CustomerObject.put("EIA", "NULL");
            CustomerObject.put("CKYCNo", "");
            CustomerObject.put("Ref_No_Unique_KYC", "");
            RootObject.put("Customer", CustomerObject);
            //POSAGENT
            JSONObject POSAGENTObject = new JSONObject();
            POSAGENTObject.put("Name", "NULL");
            POSAGENTObject.put("PAN", "NULL");
            POSAGENTObject.put("Aadhar", "NULL");
            POSAGENTObject.put("Email", "NULL");
            POSAGENTObject.put("MobileNo", "NULL");
//            POSAGENTObject.put("Location", "NULL");
            POSAGENTObject.put("Location", "MUMBAI CORPORATE OFFICE");
            POSAGENTObject.put("Information1", "NULL");
            POSAGENTObject.put("Information2", "NULL");
            RootObject.put("POSAGENT", POSAGENTObject);

            JSONObject ProductObject = new JSONObject();
            JSONObject GeneralProposalObject = new JSONObject();
            JSONObject GeneralProposalGroupObject = new JSONObject();
            JSONObject DistributionChannelObject = new JSONObject();
            //Branch
            JSONObject BranchDetailsObject = new JSONObject();

            BranchDetailsObject.put("IMDBranchName", "NULL");
            BranchDetailsObject.put("IMDBranchCode", "NULL");
            DistributionChannelObject.put("BranchDetails", BranchDetailsObject);
            //SpDetails
            JSONObject SPDetailsObject = new JSONObject();
            SPDetailsObject.put("SPName", "NULL");
            SPDetailsObject.put("SPCode", "NULL");
            DistributionChannelObject.put("SPDetails", SPDetailsObject);
            GeneralProposalGroupObject.put("DistributionChannel", DistributionChannelObject);

            //GeneralProposalInformation
            JSONObject GeneralProposalInformationObject = new JSONObject();
            GeneralProposalInformationObject.put("TypeOfBusiness", "");
            GeneralProposalInformationObject.put("ServiceTaxExemptionCategory", "");
            GeneralProposalInformationObject.put("BusinessType", "New");
            GeneralProposalInformationObject.put("Sector", "");
            GeneralProposalInformationObject.put("DealId", "INTR-2312-0019722");
            GeneralProposalInformationObject.put("PolicyType", str_policyType_spinner1);
            GeneralProposalInformationObject.put("FamilyComposition", FamilyComposition);
            GeneralProposalInformationObject.put("ParentComposition", ParentComposition);
            GeneralProposalInformationObject.put("PlanType", PlanType);
            GeneralProposalInformationObject.put("ProposalDate", tomorrowDate);
            GeneralProposalInformationObject.put("PolicyDuration", strPolicyTenure);
            GeneralProposalInformationObject.put("PolicyNumberChar", "NULL");
            //PolicyEffectiveDate
            JSONObject PolicyEffectiveDateObject = new JSONObject();
            PolicyEffectiveDateObject.put("Fromdate", tomorrowDate);
            PolicyEffectiveDateObject.put("Todate", nextYear);
            PolicyEffectiveDateObject.put("Fromhour", "00:01");
            PolicyEffectiveDateObject.put("Tohour", "23:59");
            GeneralProposalInformationObject.put("PolicyEffectiveDate", PolicyEffectiveDateObject);

            GeneralProposalInformationObject.put("SubCategory", SubCategory);
            GeneralProposalInformationObject.put("EmployeeCode", "");
            GeneralProposalInformationObject.put("ExsistingPolicyNumber", strPolicyNumber);
            GeneralProposalInformationObject.put("PersonalAccidentCategory", PersonalAccidentCategory);
            GeneralProposalInformationObject.put("CoPaymentLoading", CoPaymentLoading);
            GeneralProposalInformationObject.put("RequestType", "Quotation");
            GeneralProposalGroupObject.put("GeneralProposalInformation", GeneralProposalInformationObject);
            GeneralProposalObject.put("GeneralProposalGroup", GeneralProposalGroupObject);

            //FinancierDetails
            JSONObject FinancierDetailsObject = new JSONObject();
            JSONObject FinancierDtlGrpObject = new JSONObject();
            JSONObject FinancierDtlGrpDataObject = new JSONObject();
            FinancierDtlGrpDataObject.put("FinancierCode", "NULL");
            FinancierDtlGrpDataObject.put("AgreementType", "NULL");
            FinancierDtlGrpDataObject.put("BranchName", "NULL");
            FinancierDtlGrpDataObject.put("FinancierName", "NULL");
            FinancierDtlGrpDataObject.put("SrNo", "NULL");
            FinancierDtlGrpObject.put("FinancierDtlGrpData", FinancierDtlGrpDataObject);
            FinancierDetailsObject.put("FinancierDtlGrp", FinancierDtlGrpObject);
            GeneralProposalObject.put("FinancierDetails", FinancierDetailsObject);

            //PreviousPolicyDetails
            JSONObject PreviousPolicyDetailsObject = new JSONObject();
            JSONObject PreviousPolDtlGroupObject = new JSONObject();
            JSONObject PreviousPolDtlGroupDataObject = new JSONObject();
            PreviousPolDtlGroupDataObject.put("ProductCode", "NULL");
            PreviousPolDtlGroupDataObject.put("ClaimSettled", "NULL");
            PreviousPolDtlGroupDataObject.put("ClaimPremium", "0");
            PreviousPolDtlGroupDataObject.put("ClaimAmount", "0");
            PreviousPolDtlGroupDataObject.put("DateofLoss", "NULL");
            PreviousPolDtlGroupDataObject.put("NatureofLoss", "NULL");
            PreviousPolDtlGroupDataObject.put("ClaimNo", "");
            PreviousPolDtlGroupDataObject.put("PolicyEffectiveTo", "");
            PreviousPolDtlGroupDataObject.put("PolicyEffectiveFrom", "");
            PreviousPolDtlGroupDataObject.put("PolicyPremium", "0");
            PreviousPolDtlGroupDataObject.put("PolicyNo", "NULL");
            PreviousPolDtlGroupDataObject.put("PolicyYear", "NULL");
            PreviousPolDtlGroupDataObject.put("OfficeCode", "NULL");
            PreviousPolDtlGroupDataObject.put("CorporateCustomerId", "NULL");
            PreviousPolDtlGroupDataObject.put("InsurerName", "NULL");
            PreviousPolDtlGroupDataObject.put("InsurerAddress", "NULL");
            PreviousPolDtlGroupObject.put("PreviousPolDtlGroupData", PreviousPolDtlGroupDataObject);
            PreviousPolicyDetailsObject.put("PreviousPolDtlGroup", PreviousPolDtlGroupObject);
            PreviousPolicyDetailsObject.put("PreviousPolicyType", "Package Policy");
            PreviousPolicyDetailsObject.put("OfficeAddress", "NULL");
            GeneralProposalObject.put("PreviousPolicyDetails", PreviousPolicyDetailsObject);
            ProductObject.put("GeneralProposal", GeneralProposalObject);

            //PremiumCalculation
            JSONObject PremiumCalculationObject = new JSONObject();
            PremiumCalculationObject.put("NetPremium", "0");
            PremiumCalculationObject.put("ServiceTax", "0");
            PremiumCalculationObject.put("StampDuty2", "0");
            PremiumCalculationObject.put("TotalPremium", "0");
            PremiumCalculationObject.put("CGST", "0");
            PremiumCalculationObject.put("SGST", "");
            PremiumCalculationObject.put("UGST", "0");
            PremiumCalculationObject.put("IGST", "0");
            ProductObject.put("PremiumCalculation", PremiumCalculationObject);
//            ProductObject.put("PremiumCalculation",PremiumCalculationObject);
//            ProductObject.put("PremiumCalculation",GeneralProposalObject);

            //Risks
            JSONObject RisksObject = new JSONObject();
            JSONObject RiskObject = new JSONObject();
            JSONObject RisksDataObject = new JSONObject();
            JSONObject InsuredDetailsObject = new JSONObject();
            JSONArray InsuredDetailsGroupArray = new JSONArray();


            JSONObject InsuredDetailsObj = new JSONObject();
            InsuredDetailsObj.put("InsuredType", "Adult");
            InsuredDetailsObj.put("FirstName", strEdtNameSelf);
            InsuredDetailsObj.put("LastName", "");
            InsuredDetailsObj.put("DOB", strSelfAgeEditText);
            InsuredDetailsObj.put("Gender", strEditGenderSelf);
            InsuredDetailsObj.put("Relationship", strRelationAdultOneEdit);
            InsuredDetailsObj.put("Occupation", strEditOccupationSelf);
            InsuredDetailsObj.put("NomineeName", strNomineeName);
            InsuredDetailsObj.put("NomineeRelationship", strNomineeRelationEdit);

            JSONObject HealthIndicatorsObj = new JSONObject();
            HealthIndicatorsObj.put("PED", "N");
            HealthIndicatorsObj.put("PEDDeclared", "N");
            HealthIndicatorsObj.put("BloodSugarLevel", strBloodSugar);
            HealthIndicatorsObj.put("BloodPressureSystolic", strBloodPressure);
            HealthIndicatorsObj.put("BloodPressureDiastolic", strBloodPressureDiastolic);
            HealthIndicatorsObj.put("CholesterolLevel", strcholesterol);
            HealthIndicatorsObj.put("BodyMassIndex", "30");
            HealthIndicatorsObj.put("TobaccoAndAlcohol", "N");
            HealthIndicatorsObj.put("CoMorbidity", "N");
            InsuredDetailsObj.put("HealthIndicators", HealthIndicatorsObj);

            JSONObject CoverDetailsObj = new JSONObject();
            JSONArray CoversArray = new JSONArray();
            JSONObject BasicInsuranceCoversObj = new JSONObject();
            BasicInsuranceCoversObj.put("Applicable", "True");
            BasicInsuranceCoversObj.put("CoverSI", strSumInsured);
            BasicInsuranceCoversObj.put("CoverRate", "0");
            BasicInsuranceCoversObj.put("CoverPremium", "0");
            BasicInsuranceCoversObj.put("CoverGroups", "Basic Insurance Cover");
            CoversArray.put(BasicInsuranceCoversObj);

            JSONObject PersonalAccidentCoversObj = new JSONObject();
            PersonalAccidentCoversObj.put("Applicable", PersonalStatus);
            PersonalAccidentCoversObj.put("CoverSI", strSumInsured);
            PersonalAccidentCoversObj.put("CoverRate", "0");
            PersonalAccidentCoversObj.put("CoverPremium", "0");
            PersonalAccidentCoversObj.put("CoverGroups", "Personal Accident Cover");
            CoversArray.put(PersonalAccidentCoversObj);

            JSONObject CriticalIllnessCoversObj = new JSONObject();
            CriticalIllnessCoversObj.put("Applicable", CriticalStatus);
            CriticalIllnessCoversObj.put("CoverSI", strSumInsured);
            CriticalIllnessCoversObj.put("CoverRate", "0");
            CriticalIllnessCoversObj.put("CoverPremium", "0");
            CriticalIllnessCoversObj.put("CoverGroups", "Critical Illness Cover");
            CoversArray.put(CriticalIllnessCoversObj);


            JSONObject DailyHospitalCoversObj = new JSONObject();
            DailyHospitalCoversObj.put("Applicable", DailyHospitalSatus);
            DailyHospitalCoversObj.put("CoverSI", strSumInsured);
            DailyHospitalCoversObj.put("CoverRate", "0");
            DailyHospitalCoversObj.put("CoverPremium", "0");
            DailyHospitalCoversObj.put("CoverGroups", "Daily Hospital Cash Cover");
            CoversArray.put(DailyHospitalCoversObj);

            JSONObject ModernCoversObj = new JSONObject();
            ModernCoversObj.put("Applicable", ModernTreatmentsStatus);
            ModernCoversObj.put("CoverSI", strSumInsured);
            ModernCoversObj.put("CoverRate", "0");
            ModernCoversObj.put("CoverPremium", "0");
            ModernCoversObj.put("CoverGroups", "Modern Treatments");
            CoversArray.put(ModernCoversObj);
            JSONObject ExtensionPreHospitalizationCoversObj = new JSONObject();
            ExtensionPreHospitalizationCoversObj.put("Applicable", ExtensionPreHospitalization);
            ExtensionPreHospitalizationCoversObj.put("CoverSI", strSumInsured);
            ExtensionPreHospitalizationCoversObj.put("CoverRate", "0");
            ExtensionPreHospitalizationCoversObj.put("CoverPremium", "0");
            ExtensionPreHospitalizationCoversObj.put("CoverGroups", "Extension under Pre-Hospitalization");
            CoversArray.put(ExtensionPreHospitalizationCoversObj);

            JSONObject ExtensionPostHospitalizationCoversObj = new JSONObject();
            ExtensionPostHospitalizationCoversObj.put("Applicable", ExtensionPr0Hospitalization);
            ExtensionPostHospitalizationCoversObj.put("CoverSI", strSumInsured);
            ExtensionPostHospitalizationCoversObj.put("CoverRate", "0");
            ExtensionPostHospitalizationCoversObj.put("CoverPremium", "0");
            ExtensionPostHospitalizationCoversObj.put("CoverGroups", "Extension under Post-Hospitalization");
            CoversArray.put(ExtensionPostHospitalizationCoversObj);


            JSONObject MaternityAndChildcareCoversObj = new JSONObject();
            MaternityAndChildcareCoversObj.put("Applicable", MaternityAndChildcareMale);
            MaternityAndChildcareCoversObj.put("CoverSI", strSumInsured);
            MaternityAndChildcareCoversObj.put("CoverRate", "0");
            MaternityAndChildcareCoversObj.put("CoverPremium", "0");
            MaternityAndChildcareCoversObj.put("CoverGroups", "Maternity and Childcare Benefit Waiting Period Modification");
            CoversArray.put(MaternityAndChildcareCoversObj);

            JSONObject CoverageForNonMedicalCoversObj = new JSONObject();
            CoverageForNonMedicalCoversObj.put("Applicable", CoverageNonMedical);
            CoverageForNonMedicalCoversObj.put("CoverSI", strSumInsured);
            CoverageForNonMedicalCoversObj.put("CoverRate", "0");
            CoverageForNonMedicalCoversObj.put("CoverPremium", "0");
            CoverageForNonMedicalCoversObj.put("CoverGroups", "Coverage for Non-Medical Items");
            CoversArray.put(CoverageForNonMedicalCoversObj);

            JSONObject ConditionWaiverCoversObj = new JSONObject();
            ConditionWaiverCoversObj.put("Applicable", ConditionWaiverStatus);
            ConditionWaiverCoversObj.put("CoverSI", strSumInsured);
            ConditionWaiverCoversObj.put("CoverRate", "0");
            ConditionWaiverCoversObj.put("CoverPremium", "0");
            ConditionWaiverCoversObj.put("CoverGroups", "Condition waiver under Restore Benefit");
            CoversArray.put(ConditionWaiverCoversObj);

            JSONObject PreExistingDiseaseCoversObj = new JSONObject();
            PreExistingDiseaseCoversObj.put("Applicable", PreExistingDiseaseStatus);
            PreExistingDiseaseCoversObj.put("CoverSI", strSumInsured);
            PreExistingDiseaseCoversObj.put("CoverRate", "0");
            PreExistingDiseaseCoversObj.put("CoverPremium", "0");
            PreExistingDiseaseCoversObj.put("CoverGroups", "Pre-Existing Disease waiting period");
            CoversArray.put(PreExistingDiseaseCoversObj);

            JSONObject OutpatientDentalWaitingCoversObj = new JSONObject();
            OutpatientDentalWaitingCoversObj.put("Applicable", OutpatientDentalStatus);
            OutpatientDentalWaitingCoversObj.put("CoverSI", strSumInsured);
            OutpatientDentalWaitingCoversObj.put("CoverRate", "0");
            OutpatientDentalWaitingCoversObj.put("CoverPremium", "0");
            OutpatientDentalWaitingCoversObj.put("CoverGroups", "Outpatient Dental Waiting Period Modification");
            CoversArray.put(OutpatientDentalWaitingCoversObj);

            JSONObject EmergencyTravellingAllowanceCoversObj = new JSONObject();
            EmergencyTravellingAllowanceCoversObj.put("Applicable", EmergencyTravellingStatus);
            EmergencyTravellingAllowanceCoversObj.put("CoverSI", strSumInsured);
            EmergencyTravellingAllowanceCoversObj.put("CoverRate", "0");
            EmergencyTravellingAllowanceCoversObj.put("CoverPremium", "0");
            EmergencyTravellingAllowanceCoversObj.put("CoverGroups", "Emergency Travelling Allowance");
            CoversArray.put(EmergencyTravellingAllowanceCoversObj);

            JSONObject SecondOpinionCoversObj = new JSONObject();
            SecondOpinionCoversObj.put("Applicable", SecondOpinionStatus);
            SecondOpinionCoversObj.put("CoverSI", strSumInsured);
            SecondOpinionCoversObj.put("CoverRate", "0");
            SecondOpinionCoversObj.put("CoverPremium", "0");
            SecondOpinionCoversObj.put("CoverGroups", "Second Opinion");
            CoversArray.put(SecondOpinionCoversObj);

            JSONObject RestCureCoversObj = new JSONObject();
            RestCureCoversObj.put("Applicable", RestCureStatus);
            RestCureCoversObj.put("CoverSI", strSumInsured);
            RestCureCoversObj.put("CoverRate", "0");
            RestCureCoversObj.put("CoverPremium", "0");
            RestCureCoversObj.put("CoverGroups", "Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
            CoversArray.put(RestCureCoversObj);

            JSONObject ObesityWeightCoversObj = new JSONObject();
            ObesityWeightCoversObj.put("Applicable", ObesityWeightStatus);
            ObesityWeightCoversObj.put("CoverSI", strSumInsured);
            ObesityWeightCoversObj.put("CoverRate", "0");
            ObesityWeightCoversObj.put("CoverPremium", "0");
            ObesityWeightCoversObj.put("CoverGroups", "Obesity/ Weight Control Expenses Extension");
            CoversArray.put(ObesityWeightCoversObj);

            JSONObject SterilityInfertilityCoversObj = new JSONObject();
            SterilityInfertilityCoversObj.put("Applicable", SterilityInfertilityMale);
            SterilityInfertilityCoversObj.put("CoverSI", strSumInsured);
            SterilityInfertilityCoversObj.put("CoverRate", "0");
            SterilityInfertilityCoversObj.put("CoverPremium", "0");
            SterilityInfertilityCoversObj.put("CoverGroups", "Sterility and Infertility Treatment Expenses Extension");
            CoversArray.put(SterilityInfertilityCoversObj);

            JSONObject EnhancedOrganDonorCoversObj = new JSONObject();
            EnhancedOrganDonorCoversObj.put("Applicable", EnhancedOrganStatus);
            EnhancedOrganDonorCoversObj.put("CoverSI", strSumInsured);
            EnhancedOrganDonorCoversObj.put("CoverRate", "0");
            EnhancedOrganDonorCoversObj.put("CoverPremium", "0");
            EnhancedOrganDonorCoversObj.put("CoverGroups", "Enhanced Organ Donor Expenses");
            CoversArray.put(EnhancedOrganDonorCoversObj);

            JSONObject PremiumWaiverCoversObj = new JSONObject();
            PremiumWaiverCoversObj.put("Applicable", PremiumWaiverStatus);
            PremiumWaiverCoversObj.put("CoverSI", strSumInsured);
            PremiumWaiverCoversObj.put("CoverRate", "0");
            PremiumWaiverCoversObj.put("CoverPremium", "0");
            PremiumWaiverCoversObj.put("CoverGroups", "Premium Waiver");
            CoversArray.put(PremiumWaiverCoversObj);

            JSONObject GlobalCoversObj = new JSONObject();
            GlobalCoversObj.put("Applicable", GlobalCoverStatus);
            GlobalCoversObj.put("CoverSI", strSumInsured);
            GlobalCoversObj.put("CoverRate", "0");
            GlobalCoversObj.put("CoverPremium", "0");
            GlobalCoversObj.put("CoverGroups", "Global Cover");
            CoversArray.put(GlobalCoversObj);


            JSONObject MedicallyAdvisedCoversObj = new JSONObject();
            MedicallyAdvisedCoversObj.put("Applicable", MedicallyAdvisedStatus);
            MedicallyAdvisedCoversObj.put("CoverSI", strSumInsured);
            MedicallyAdvisedCoversObj.put("CoverRate", "0");
            MedicallyAdvisedCoversObj.put("CoverPremium", "0");
            MedicallyAdvisedCoversObj.put("CoverGroups", "Medically Advised Support Devices");
            CoversArray.put(MedicallyAdvisedCoversObj);

            JSONObject EmergencyCoversObj = new JSONObject();
            EmergencyCoversObj.put("Applicable", EmergencyAssistanceStatus);
            EmergencyCoversObj.put("CoverSI", strSumInsured);
            EmergencyCoversObj.put("CoverRate", "0");
            EmergencyCoversObj.put("CoverPremium", "0");
            EmergencyCoversObj.put("CoverGroups", "Emergency Assistance Service");
            CoversArray.put(EmergencyCoversObj);

            JSONObject HomeCareTreatmentCoversObj = new JSONObject();
            HomeCareTreatmentCoversObj.put("Applicable", HomeCareStatus);
            HomeCareTreatmentCoversObj.put("CoverSI", strSumInsured);
            HomeCareTreatmentCoversObj.put("CoverRate", "0");
            HomeCareTreatmentCoversObj.put("CoverPremium", "0");
            HomeCareTreatmentCoversObj.put("CoverGroups", "Home Care Treatment");
            CoversArray.put(HomeCareTreatmentCoversObj);

            JSONObject WellnessBenefitCoversObj = new JSONObject();
            WellnessBenefitCoversObj.put("Applicable", WellnessBenefitStatus);
            WellnessBenefitCoversObj.put("CoverSI", strSumInsured);
            WellnessBenefitCoversObj.put("CoverRate", "0");
            WellnessBenefitCoversObj.put("CoverPremium", "0");
            WellnessBenefitCoversObj.put("CoverGroups", "Wellness Benefit");
            CoversArray.put(WellnessBenefitCoversObj);

            JSONObject DiseaseManagementCoversObj = new JSONObject();
            DiseaseManagementCoversObj.put("Applicable", DiseaseManagementStatus);
            DiseaseManagementCoversObj.put("CoverSI", strSumInsured);
            DiseaseManagementCoversObj.put("CoverRate", "0");
            DiseaseManagementCoversObj.put("CoverPremium", "0");
            DiseaseManagementCoversObj.put("CoverGroups", "Disease Management Program");
            CoversArray.put(DiseaseManagementCoversObj);
            CoverDetailsObj.put("Covers", CoversArray);
            InsuredDetailsObj.put("CoverDetails", CoverDetailsObj);

            //2nd Adult
            JSONObject SecondAdultObj = new JSONObject();
            SecondAdultObj.put("InsuredType", "Adult");
            SecondAdultObj.put("FirstName", strSpouseNameEditText);
            SecondAdultObj.put("LastName", "");
            SecondAdultObj.put("DOB", strSpouseAgeEditText);
            SecondAdultObj.put("Gender", strSpouseGenderEdit);
            SecondAdultObj.put("Relationship", strRelationEditSpouse);
            SecondAdultObj.put("Occupation", strSpouseOccupationEdit);
            SecondAdultObj.put("NomineeName", strNomineeName);
            SecondAdultObj.put("NomineeRelationship", strNomineeRelationEdit);

            JSONObject HealthIndicatorsSecondObj = new JSONObject();
            HealthIndicatorsSecondObj.put("PED", "N");
            HealthIndicatorsSecondObj.put("PEDDeclared", "N");
            HealthIndicatorsSecondObj.put("BloodSugarLevel", strBloodSugar);
            HealthIndicatorsSecondObj.put("BloodPressureSystolic", strBloodPressure);
            HealthIndicatorsSecondObj.put("BloodPressureDiastolic", strBloodPressureDiastolic);
            HealthIndicatorsSecondObj.put("CholesterolLevel", strcholesterol);
            HealthIndicatorsSecondObj.put("BodyMassIndex", "30");
            HealthIndicatorsSecondObj.put("TobaccoAndAlcohol", "N");
            HealthIndicatorsSecondObj.put("CoMorbidity", "N");
            SecondAdultObj.put("HealthIndicators", HealthIndicatorsSecondObj);

            JSONObject CoverDetailsSecondObj = new JSONObject();
            JSONArray SecondAdultCoversArray = new JSONArray();
            JSONObject BasicInsuranceCoversAdultSecObj = new JSONObject();
            BasicInsuranceCoversAdultSecObj.put("Applicable", "True");
            BasicInsuranceCoversAdultSecObj.put("CoverSI", strSumInsured);
            BasicInsuranceCoversAdultSecObj.put("CoverRate", "0");
            BasicInsuranceCoversAdultSecObj.put("CoverPremium", "0");
            BasicInsuranceCoversAdultSecObj.put("CoverGroups", "Basic Insurance Cover");
            SecondAdultCoversArray.put(BasicInsuranceCoversAdultSecObj);

            JSONObject PersonalAccidentCoversSecondAdultObj = new JSONObject();
            PersonalAccidentCoversSecondAdultObj.put("Applicable", PersonalStatus);
            PersonalAccidentCoversSecondAdultObj.put("CoverSI", strSumInsured);
            PersonalAccidentCoversSecondAdultObj.put("CoverRate", "0");
            PersonalAccidentCoversSecondAdultObj.put("CoverPremium", "0");
            PersonalAccidentCoversSecondAdultObj.put("CoverGroups", "Personal Accident Cover");
            SecondAdultCoversArray.put(PersonalAccidentCoversSecondAdultObj);

            JSONObject CriticalIllnessCoversSecondAdultObj = new JSONObject();
            CriticalIllnessCoversSecondAdultObj.put("Applicable", CriticalStatus);
            CriticalIllnessCoversSecondAdultObj.put("CoverSI", strSumInsured);
            CriticalIllnessCoversSecondAdultObj.put("CoverRate", "0");
            CriticalIllnessCoversSecondAdultObj.put("CoverPremium", "0");
            CriticalIllnessCoversSecondAdultObj.put("CoverGroups", "Critical Illness Cover");
            SecondAdultCoversArray.put(CriticalIllnessCoversSecondAdultObj);


            JSONObject DailyHospitalCoversSecondAdultObj = new JSONObject();
            DailyHospitalCoversSecondAdultObj.put("Applicable", DailyHospitalSatus);
            DailyHospitalCoversSecondAdultObj.put("CoverSI", strSumInsured);
            DailyHospitalCoversSecondAdultObj.put("CoverRate", "0");
            DailyHospitalCoversSecondAdultObj.put("CoverPremium", "0");
            DailyHospitalCoversSecondAdultObj.put("CoverGroups", "Daily Hospital Cash Cover");
            SecondAdultCoversArray.put(DailyHospitalCoversSecondAdultObj);

            JSONObject ModernCoversSecondAdultObj = new JSONObject();
            ModernCoversSecondAdultObj.put("Applicable", ModernTreatmentsStatus);
            ModernCoversSecondAdultObj.put("CoverSI", strSumInsured);
            ModernCoversSecondAdultObj.put("CoverRate", "0");
            ModernCoversSecondAdultObj.put("CoverPremium", "0");
            ModernCoversSecondAdultObj.put("CoverGroups", "Modern Treatments");
            SecondAdultCoversArray.put(ModernCoversSecondAdultObj);
            JSONObject ExtensionPreHospitalizationCoversSecondAdultObj = new JSONObject();
            ExtensionPreHospitalizationCoversSecondAdultObj.put("Applicable", ExtensionPreHospitalization);
            ExtensionPreHospitalizationCoversSecondAdultObj.put("CoverSI", strSumInsured);
            ExtensionPreHospitalizationCoversSecondAdultObj.put("CoverRate", "0");
            ExtensionPreHospitalizationCoversSecondAdultObj.put("CoverPremium", "0");
            ExtensionPreHospitalizationCoversSecondAdultObj.put("CoverGroups", "Extension under Pre-Hospitalization");
            SecondAdultCoversArray.put(ExtensionPreHospitalizationCoversSecondAdultObj);

            JSONObject ExtensionPostHospitalizationCoversSecondAdultObj = new JSONObject();
            ExtensionPostHospitalizationCoversSecondAdultObj.put("Applicable", ExtensionPr0Hospitalization);
            ExtensionPostHospitalizationCoversSecondAdultObj.put("CoverSI", strSumInsured);
            ExtensionPostHospitalizationCoversSecondAdultObj.put("CoverRate", "0");
            ExtensionPostHospitalizationCoversSecondAdultObj.put("CoverPremium", "0");
            ExtensionPostHospitalizationCoversSecondAdultObj.put("CoverGroups", "Extension under Post-Hospitalization");
            SecondAdultCoversArray.put(ExtensionPostHospitalizationCoversSecondAdultObj);


            JSONObject MaternityAndChildcareCoversSecAdultObj = new JSONObject();
            MaternityAndChildcareCoversSecAdultObj.put("Applicable", MaternityAndChildcare);
            MaternityAndChildcareCoversSecAdultObj.put("CoverSI", strSumInsured);
            MaternityAndChildcareCoversSecAdultObj.put("CoverRate", "0");
            MaternityAndChildcareCoversSecAdultObj.put("CoverPremium", "0");
            MaternityAndChildcareCoversSecAdultObj.put("CoverGroups", "Maternity and Childcare Benefit Waiting Period Modification");
            SecondAdultCoversArray.put(MaternityAndChildcareCoversSecAdultObj);

            JSONObject CoverageForNonMedicalCoversSecAdultObj = new JSONObject();
            CoverageForNonMedicalCoversSecAdultObj.put("Applicable", CoverageNonMedical);
            CoverageForNonMedicalCoversSecAdultObj.put("CoverSI", strSumInsured);
            CoverageForNonMedicalCoversSecAdultObj.put("CoverRate", "0");
            CoverageForNonMedicalCoversSecAdultObj.put("CoverPremium", "0");
            CoverageForNonMedicalCoversSecAdultObj.put("CoverGroups", "Coverage for Non-Medical Items");
            SecondAdultCoversArray.put(CoverageForNonMedicalCoversSecAdultObj);

            JSONObject ConditionWaiverCoversSecAdultObj = new JSONObject();
            ConditionWaiverCoversSecAdultObj.put("Applicable", ConditionWaiverStatus);
            ConditionWaiverCoversSecAdultObj.put("CoverSI", strSumInsured);
            ConditionWaiverCoversSecAdultObj.put("CoverRate", "0");
            ConditionWaiverCoversSecAdultObj.put("CoverPremium", "0");
            ConditionWaiverCoversSecAdultObj.put("CoverGroups", "Condition waiver under Restore Benefit");
            SecondAdultCoversArray.put(ConditionWaiverCoversSecAdultObj);

            JSONObject PreExistingDiseaseCoversSecAdultObj = new JSONObject();
            PreExistingDiseaseCoversSecAdultObj.put("Applicable", PreExistingDiseaseStatus);
            PreExistingDiseaseCoversSecAdultObj.put("CoverSI", strSumInsured);
            PreExistingDiseaseCoversSecAdultObj.put("CoverRate", "0");
            PreExistingDiseaseCoversSecAdultObj.put("CoverPremium", "0");
            PreExistingDiseaseCoversSecAdultObj.put("CoverGroups", "Pre-Existing Disease waiting period");
            SecondAdultCoversArray.put(PreExistingDiseaseCoversSecAdultObj);

            JSONObject OutpatientDentalWaitingCoversSecAdultObj = new JSONObject();
            OutpatientDentalWaitingCoversSecAdultObj.put("Applicable", OutpatientDentalStatus);
            OutpatientDentalWaitingCoversSecAdultObj.put("CoverSI", strSumInsured);
            OutpatientDentalWaitingCoversSecAdultObj.put("CoverRate", "0");
            OutpatientDentalWaitingCoversSecAdultObj.put("CoverPremium", "0");
            OutpatientDentalWaitingCoversSecAdultObj.put("CoverGroups", "Outpatient Dental Waiting Period Modification");
            SecondAdultCoversArray.put(OutpatientDentalWaitingCoversSecAdultObj);

            JSONObject EmergencyTravellingAllowanceCoversSecAdultObj = new JSONObject();
            EmergencyTravellingAllowanceCoversSecAdultObj.put("Applicable", EmergencyTravellingStatus);
            EmergencyTravellingAllowanceCoversSecAdultObj.put("CoverSI", strSumInsured);
            EmergencyTravellingAllowanceCoversSecAdultObj.put("CoverRate", "0");
            EmergencyTravellingAllowanceCoversSecAdultObj.put("CoverPremium", "0");
            EmergencyTravellingAllowanceCoversSecAdultObj.put("CoverGroups", "Emergency Travelling Allowance");
            SecondAdultCoversArray.put(EmergencyTravellingAllowanceCoversSecAdultObj);

            JSONObject SecondOpinionCoversSecAdultObj = new JSONObject();
            SecondOpinionCoversSecAdultObj.put("Applicable", SecondOpinionStatus);
            SecondOpinionCoversSecAdultObj.put("CoverSI", strSumInsured);
            SecondOpinionCoversSecAdultObj.put("CoverRate", "0");
            SecondOpinionCoversSecAdultObj.put("CoverPremium", "0");
            SecondOpinionCoversSecAdultObj.put("CoverGroups", "Second Opinion");
            SecondAdultCoversArray.put(SecondOpinionCoversSecAdultObj);

            JSONObject RestCureCoversSecAdultObj = new JSONObject();
            RestCureCoversSecAdultObj.put("Applicable", RestCureStatus);
            RestCureCoversSecAdultObj.put("CoverSI", strSumInsured);
            RestCureCoversSecAdultObj.put("CoverRate", "0");
            RestCureCoversSecAdultObj.put("CoverPremium", "0");
            RestCureCoversSecAdultObj.put("CoverGroups", "Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
            SecondAdultCoversArray.put(RestCureCoversSecAdultObj);

            JSONObject ObesityWeightCoversSecAdultObj = new JSONObject();
            ObesityWeightCoversSecAdultObj.put("Applicable", ObesityWeightStatus);
            ObesityWeightCoversSecAdultObj.put("CoverSI", strSumInsured);
            ObesityWeightCoversSecAdultObj.put("CoverRate", "0");
            ObesityWeightCoversSecAdultObj.put("CoverPremium", "0");
            ObesityWeightCoversSecAdultObj.put("CoverGroups", "Obesity/ Weight Control Expenses Extension");
            SecondAdultCoversArray.put(ObesityWeightCoversSecAdultObj);

            JSONObject SterilityInfertilityCoversSecAdultObj = new JSONObject();
            SterilityInfertilityCoversSecAdultObj.put("Applicable", SterilityInfertilityStatus);
            SterilityInfertilityCoversSecAdultObj.put("CoverSI", strSumInsured);
            SterilityInfertilityCoversSecAdultObj.put("CoverRate", "0");
            SterilityInfertilityCoversSecAdultObj.put("CoverPremium", "0");
            SterilityInfertilityCoversSecAdultObj.put("CoverGroups", "Sterility and Infertility Treatment Expenses Extension");
            SecondAdultCoversArray.put(SterilityInfertilityCoversSecAdultObj);

            JSONObject EnhancedOrganDonorCoversSecAdultObj = new JSONObject();
            EnhancedOrganDonorCoversSecAdultObj.put("Applicable", EnhancedOrganStatus);
            EnhancedOrganDonorCoversSecAdultObj.put("CoverSI", strSumInsured);
            EnhancedOrganDonorCoversSecAdultObj.put("CoverRate", "0");
            EnhancedOrganDonorCoversSecAdultObj.put("CoverPremium", "0");
            EnhancedOrganDonorCoversSecAdultObj.put("CoverGroups", "Enhanced Organ Donor Expenses");
            SecondAdultCoversArray.put(EnhancedOrganDonorCoversSecAdultObj);

            JSONObject PremiumWaiverCoversSecAdultObj = new JSONObject();
            PremiumWaiverCoversSecAdultObj.put("Applicable", PremiumWaiverStatus);
            PremiumWaiverCoversSecAdultObj.put("CoverSI", strSumInsured);
            PremiumWaiverCoversSecAdultObj.put("CoverRate", "0");
            PremiumWaiverCoversSecAdultObj.put("CoverPremium", "0");
            PremiumWaiverCoversSecAdultObj.put("CoverGroups", "Premium Waiver");
            SecondAdultCoversArray.put(PremiumWaiverCoversSecAdultObj);

            JSONObject GlobalCoversSecAdultObj = new JSONObject();
            GlobalCoversSecAdultObj.put("Applicable", GlobalCoverStatus);
            GlobalCoversSecAdultObj.put("CoverSI", strSumInsured);
            GlobalCoversSecAdultObj.put("CoverRate", "0");
            GlobalCoversSecAdultObj.put("CoverPremium", "0");
            GlobalCoversSecAdultObj.put("CoverGroups", "Global Cover");
            SecondAdultCoversArray.put(GlobalCoversSecAdultObj);


            JSONObject MedicallyAdvisedCoversSecAdultObj = new JSONObject();
            MedicallyAdvisedCoversSecAdultObj.put("Applicable", MedicallyAdvisedStatus);
            MedicallyAdvisedCoversSecAdultObj.put("CoverSI", strSumInsured);
            MedicallyAdvisedCoversSecAdultObj.put("CoverRate", "0");
            MedicallyAdvisedCoversSecAdultObj.put("CoverPremium", "0");
            MedicallyAdvisedCoversSecAdultObj.put("CoverGroups", "Medically Advised Support Devices");
            SecondAdultCoversArray.put(MedicallyAdvisedCoversSecAdultObj);

            JSONObject EmergencyCoversSecAdultObj = new JSONObject();
            EmergencyCoversSecAdultObj.put("Applicable", EmergencyAssistanceStatus);
            EmergencyCoversSecAdultObj.put("CoverSI", strSumInsured);
            EmergencyCoversSecAdultObj.put("CoverRate", "0");
            EmergencyCoversSecAdultObj.put("CoverPremium", "0");
            EmergencyCoversSecAdultObj.put("CoverGroups", "Emergency Assistance Service");
            SecondAdultCoversArray.put(EmergencyCoversSecAdultObj);

            JSONObject HomeCareTreatmentCoversSecAdultObj = new JSONObject();
            HomeCareTreatmentCoversSecAdultObj.put("Applicable", HomeCareStatus);
            HomeCareTreatmentCoversSecAdultObj.put("CoverSI", strSumInsured);
            HomeCareTreatmentCoversSecAdultObj.put("CoverRate", "0");
            HomeCareTreatmentCoversSecAdultObj.put("CoverPremium", "0");
            HomeCareTreatmentCoversSecAdultObj.put("CoverGroups", "Home Care Treatment");
            SecondAdultCoversArray.put(HomeCareTreatmentCoversSecAdultObj);

            JSONObject WellnessBenefitCoversSecAdultObj = new JSONObject();
            WellnessBenefitCoversSecAdultObj.put("Applicable", WellnessBenefitStatus);
            WellnessBenefitCoversSecAdultObj.put("CoverSI", strSumInsured);
            WellnessBenefitCoversSecAdultObj.put("CoverRate", "0");
            WellnessBenefitCoversSecAdultObj.put("CoverPremium", "0");
            WellnessBenefitCoversSecAdultObj.put("CoverGroups", "Wellness Benefit");
            SecondAdultCoversArray.put(WellnessBenefitCoversSecAdultObj);

            JSONObject DiseaseManagementCoversSecAdultObj = new JSONObject();
            DiseaseManagementCoversSecAdultObj.put("Applicable", DiseaseManagementStatus);
            DiseaseManagementCoversSecAdultObj.put("CoverSI", strSumInsured);
            DiseaseManagementCoversSecAdultObj.put("CoverRate", "0");
            DiseaseManagementCoversSecAdultObj.put("CoverPremium", "0");
            DiseaseManagementCoversSecAdultObj.put("CoverGroups", "Disease Management Program");
            SecondAdultCoversArray.put(DiseaseManagementCoversSecAdultObj);
            CoverDetailsSecondObj.put("Covers", SecondAdultCoversArray);
            SecondAdultObj.put("CoverDetails", CoverDetailsSecondObj);
            //ChildFirst
            JSONObject FirstChildObj = new JSONObject();
            FirstChildObj.put("InsuredType", "Child");
            FirstChildObj.put("FirstName", "Child One");
            FirstChildObj.put("LastName", "");
            FirstChildObj.put("DOB", strFirstSonAgeEditText);
            FirstChildObj.put("Gender", strGenderChildOneEdit);
            FirstChildObj.put("Relationship", strRelationChildEdit);
            FirstChildObj.put("Occupation", "Student");
            FirstChildObj.put("NomineeName", strNomineeName);
            FirstChildObj.put("NomineeRelationship", strNomineeRelationEdit);

            JSONObject HealthIndicatorsFirstChildObj = new JSONObject();
            HealthIndicatorsFirstChildObj.put("PED", "N");
            HealthIndicatorsFirstChildObj.put("PEDDeclared", "N");
            HealthIndicatorsFirstChildObj.put("BloodSugarLevel", strBloodSugar);
            HealthIndicatorsFirstChildObj.put("BloodPressureSystolic", strBloodPressure);
            HealthIndicatorsFirstChildObj.put("BloodPressureDiastolic", strBloodPressureDiastolic);
            HealthIndicatorsFirstChildObj.put("CholesterolLevel", strcholesterol);
            HealthIndicatorsFirstChildObj.put("BodyMassIndex", "30");
            HealthIndicatorsFirstChildObj.put("TobaccoAndAlcohol", "N");
            HealthIndicatorsFirstChildObj.put("CoMorbidity", "N");
            FirstChildObj.put("HealthIndicators", HealthIndicatorsFirstChildObj);

            JSONObject CoverDetailsFirstChildObj = new JSONObject();
            JSONArray FirstChildCoversArray = new JSONArray();
            JSONObject BasicInsuranceCoversChildFirstObj = new JSONObject();
            BasicInsuranceCoversChildFirstObj.put("Applicable", BasicStatus);
            BasicInsuranceCoversChildFirstObj.put("CoverSI", strSumInsured);
            BasicInsuranceCoversChildFirstObj.put("CoverRate", "0");
            BasicInsuranceCoversChildFirstObj.put("CoverPremium", "0");
            BasicInsuranceCoversChildFirstObj.put("CoverGroups", "Basic Insurance Cover");
            FirstChildCoversArray.put(BasicInsuranceCoversChildFirstObj);

            JSONObject PersonalAccidentCoversFirstObj = new JSONObject();
            PersonalAccidentCoversFirstObj.put("Applicable", PersonalStatusChildOne);
            PersonalAccidentCoversFirstObj.put("CoverSI", strSumInsured);
            PersonalAccidentCoversFirstObj.put("CoverRate", "0");
            PersonalAccidentCoversFirstObj.put("CoverPremium", "0");
            PersonalAccidentCoversFirstObj.put("CoverGroups", "Personal Accident Cover");
            FirstChildCoversArray.put(PersonalAccidentCoversFirstObj);

            JSONObject CriticalIllnessCoversFirstObj = new JSONObject();
            CriticalIllnessCoversFirstObj.put("Applicable", CriticalStatus);
            CriticalIllnessCoversFirstObj.put("CoverSI", strSumInsured);
            CriticalIllnessCoversFirstObj.put("CoverRate", "0");
            CriticalIllnessCoversFirstObj.put("CoverPremium", "0");
            CriticalIllnessCoversFirstObj.put("CoverGroups", "Critical Illness Cover");
            FirstChildCoversArray.put(CriticalIllnessCoversFirstObj);


            JSONObject DailyHospitalCoversFirstObj = new JSONObject();
            DailyHospitalCoversFirstObj.put("Applicable", DailyHospitalSatus);
            DailyHospitalCoversFirstObj.put("CoverSI", strSumInsured);
            DailyHospitalCoversFirstObj.put("CoverRate", "0");
            DailyHospitalCoversFirstObj.put("CoverPremium", "0");
            DailyHospitalCoversFirstObj.put("CoverGroups", "Daily Hospital Cash Cover");
            FirstChildCoversArray.put(DailyHospitalCoversFirstObj);

            JSONObject ModernCoversFirstObj = new JSONObject();
            ModernCoversFirstObj.put("Applicable", ModernTreatmentsStatus);
            ModernCoversFirstObj.put("CoverSI", strSumInsured);
            ModernCoversFirstObj.put("CoverRate", "0");
            ModernCoversFirstObj.put("CoverPremium", "0");
            ModernCoversFirstObj.put("CoverGroups", "Modern Treatments");
            FirstChildCoversArray.put(ModernCoversFirstObj);
            JSONObject ExtensionPreHospitalizationCoversFirstObj = new JSONObject();
            ExtensionPreHospitalizationCoversFirstObj.put("Applicable", ExtensionPreHospitalization);
            ExtensionPreHospitalizationCoversFirstObj.put("CoverSI", strSumInsured);
            ExtensionPreHospitalizationCoversFirstObj.put("CoverRate", "0");
            ExtensionPreHospitalizationCoversFirstObj.put("CoverPremium", "0");
            ExtensionPreHospitalizationCoversFirstObj.put("CoverGroups", "Extension under Pre-Hospitalization");
            FirstChildCoversArray.put(ExtensionPreHospitalizationCoversFirstObj);

            JSONObject ExtensionPostHospitalizationCoversFirstObj = new JSONObject();
            ExtensionPostHospitalizationCoversFirstObj.put("Applicable", ExtensionPr0Hospitalization);
            ExtensionPostHospitalizationCoversFirstObj.put("CoverSI", strSumInsured);
            ExtensionPostHospitalizationCoversFirstObj.put("CoverRate", "0");
            ExtensionPostHospitalizationCoversFirstObj.put("CoverPremium", "0");
            ExtensionPostHospitalizationCoversFirstObj.put("CoverGroups", "Extension under Post-Hospitalization");
            FirstChildCoversArray.put(ExtensionPostHospitalizationCoversFirstObj);


            JSONObject MaternityAndChildcareCoversFirstObj = new JSONObject();
            MaternityAndChildcareCoversFirstObj.put("Applicable", "False");
            MaternityAndChildcareCoversFirstObj.put("CoverSI", strSumInsured);
            MaternityAndChildcareCoversFirstObj.put("CoverRate", "0");
            MaternityAndChildcareCoversFirstObj.put("CoverPremium", "0");
            MaternityAndChildcareCoversFirstObj.put("CoverGroups", "Maternity and Childcare Benefit Waiting Period Modification");
            FirstChildCoversArray.put(MaternityAndChildcareCoversFirstObj);

            JSONObject CoverageForNonMedicalCoversFirstObj = new JSONObject();
            CoverageForNonMedicalCoversFirstObj.put("Applicable", CoverageNonMedical);
            CoverageForNonMedicalCoversFirstObj.put("CoverSI", strSumInsured);
            CoverageForNonMedicalCoversFirstObj.put("CoverRate", "0");
            CoverageForNonMedicalCoversFirstObj.put("CoverPremium", "0");
            CoverageForNonMedicalCoversFirstObj.put("CoverGroups", "Coverage for Non-Medical Items");
            FirstChildCoversArray.put(CoverageForNonMedicalCoversFirstObj);

            JSONObject ConditionWaiverCoversFirstObj = new JSONObject();
            ConditionWaiverCoversFirstObj.put("Applicable", ConditionWaiverStatus);
            ConditionWaiverCoversFirstObj.put("CoverSI", strSumInsured);
            ConditionWaiverCoversFirstObj.put("CoverRate", "0");
            ConditionWaiverCoversFirstObj.put("CoverPremium", "0");
            ConditionWaiverCoversFirstObj.put("CoverGroups", "Condition waiver under Restore Benefit");
            FirstChildCoversArray.put(ConditionWaiverCoversFirstObj);

            JSONObject PreExistingDiseaseCoversFirstObj = new JSONObject();
            PreExistingDiseaseCoversFirstObj.put("Applicable", PreExistingDiseaseStatus);
            PreExistingDiseaseCoversFirstObj.put("CoverSI", strSumInsured);
            PreExistingDiseaseCoversFirstObj.put("CoverRate", "0");
            PreExistingDiseaseCoversFirstObj.put("CoverPremium", "0");
            PreExistingDiseaseCoversFirstObj.put("CoverGroups", "Pre-Existing Disease waiting period");
            FirstChildCoversArray.put(PreExistingDiseaseCoversFirstObj);

            JSONObject OutpatientDentalWaitingCoversFirstObj = new JSONObject();
            OutpatientDentalWaitingCoversFirstObj.put("Applicable", OutpatientDentalStatus);
            OutpatientDentalWaitingCoversFirstObj.put("CoverSI", strSumInsured);
            OutpatientDentalWaitingCoversFirstObj.put("CoverRate", "0");
            OutpatientDentalWaitingCoversFirstObj.put("CoverPremium", "0");
            OutpatientDentalWaitingCoversFirstObj.put("CoverGroups", "Outpatient Dental Waiting Period Modification");
            FirstChildCoversArray.put(OutpatientDentalWaitingCoversFirstObj);

            JSONObject EmergencyTravellingAllowanceCoversFirstObj = new JSONObject();
            EmergencyTravellingAllowanceCoversFirstObj.put("Applicable", EmergencyTravellingStatus);
            EmergencyTravellingAllowanceCoversFirstObj.put("CoverSI", strSumInsured);
            EmergencyTravellingAllowanceCoversFirstObj.put("CoverRate", "0");
            EmergencyTravellingAllowanceCoversFirstObj.put("CoverPremium", "0");
            EmergencyTravellingAllowanceCoversFirstObj.put("CoverGroups", "Emergency Travelling Allowance");
            FirstChildCoversArray.put(EmergencyTravellingAllowanceCoversFirstObj);

            JSONObject SecondOpinionCoversFirstObj = new JSONObject();
            SecondOpinionCoversFirstObj.put("Applicable", SecondOpinionStatus);
            SecondOpinionCoversFirstObj.put("CoverSI", strSumInsured);
            SecondOpinionCoversFirstObj.put("CoverRate", "0");
            SecondOpinionCoversFirstObj.put("CoverPremium", "0");
            SecondOpinionCoversFirstObj.put("CoverGroups", "Second Opinion");
            FirstChildCoversArray.put(SecondOpinionCoversFirstObj);

            JSONObject RestCureCoversFirstObj = new JSONObject();
            RestCureCoversFirstObj.put("Applicable", RestCureStatus);
            RestCureCoversFirstObj.put("CoverSI", strSumInsured);
            RestCureCoversFirstObj.put("CoverRate", "0");
            RestCureCoversFirstObj.put("CoverPremium", "0");
            RestCureCoversFirstObj.put("CoverGroups", "Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
            FirstChildCoversArray.put(RestCureCoversFirstObj);

            JSONObject ObesityWeightCoversFirstObj = new JSONObject();
            ObesityWeightCoversFirstObj.put("Applicable", ObesityWeightStatus);
            ObesityWeightCoversFirstObj.put("CoverSI", strSumInsured);
            ObesityWeightCoversFirstObj.put("CoverRate", "0");
            ObesityWeightCoversFirstObj.put("CoverPremium", "0");
            ObesityWeightCoversFirstObj.put("CoverGroups", "Obesity/ Weight Control Expenses Extension");
            FirstChildCoversArray.put(ObesityWeightCoversFirstObj);

            JSONObject SterilityInfertilityCoversFirstObj = new JSONObject();
            SterilityInfertilityCoversFirstObj.put("Applicable", "False");
            SterilityInfertilityCoversFirstObj.put("CoverSI", strSumInsured);
            SterilityInfertilityCoversFirstObj.put("CoverRate", "0");
            SterilityInfertilityCoversFirstObj.put("CoverPremium", "0");
            SterilityInfertilityCoversFirstObj.put("CoverGroups", "Sterility and Infertility Treatment Expenses Extension");
            FirstChildCoversArray.put(SterilityInfertilityCoversFirstObj);

            JSONObject EnhancedOrganDonorCoversFirstObj = new JSONObject();
            EnhancedOrganDonorCoversFirstObj.put("Applicable", EnhancedOrganStatus);
            EnhancedOrganDonorCoversFirstObj.put("CoverSI", strSumInsured);
            EnhancedOrganDonorCoversFirstObj.put("CoverRate", "0");
            EnhancedOrganDonorCoversFirstObj.put("CoverPremium", "0");
            EnhancedOrganDonorCoversFirstObj.put("CoverGroups", "Enhanced Organ Donor Expenses");
            FirstChildCoversArray.put(EnhancedOrganDonorCoversFirstObj);

            JSONObject PremiumWaiverCoversFirstObj = new JSONObject();
            PremiumWaiverCoversFirstObj.put("Applicable", PremiumWaiverStatus);
            PremiumWaiverCoversFirstObj.put("CoverSI", strSumInsured);
            PremiumWaiverCoversFirstObj.put("CoverRate", "0");
            PremiumWaiverCoversFirstObj.put("CoverPremium", "0");
            PremiumWaiverCoversFirstObj.put("CoverGroups", "Premium Waiver");
            FirstChildCoversArray.put(PremiumWaiverCoversFirstObj);

            JSONObject GlobalCoversFirstObj = new JSONObject();
            GlobalCoversFirstObj.put("Applicable", GlobalCoverStatus);
            GlobalCoversFirstObj.put("CoverSI", strSumInsured);
            GlobalCoversFirstObj.put("CoverRate", "0");
            GlobalCoversFirstObj.put("CoverPremium", "0");
            GlobalCoversFirstObj.put("CoverGroups", "Global Cover");
            FirstChildCoversArray.put(GlobalCoversFirstObj);


            JSONObject MedicallyAdvisedCoversFirstObj = new JSONObject();
            MedicallyAdvisedCoversFirstObj.put("Applicable", MedicallyAdvisedStatus);
            MedicallyAdvisedCoversFirstObj.put("CoverSI", strSumInsured);
            MedicallyAdvisedCoversFirstObj.put("CoverRate", "0");
            MedicallyAdvisedCoversFirstObj.put("CoverPremium", "0");
            MedicallyAdvisedCoversFirstObj.put("CoverGroups", "Medically Advised Support Devices");
            FirstChildCoversArray.put(MedicallyAdvisedCoversFirstObj);

            JSONObject EmergencyCoversFirstObj = new JSONObject();
            EmergencyCoversFirstObj.put("Applicable", EmergencyAssistanceStatus);
            EmergencyCoversFirstObj.put("CoverSI", strSumInsured);
            EmergencyCoversFirstObj.put("CoverRate", "0");
            EmergencyCoversFirstObj.put("CoverPremium", "0");
            EmergencyCoversFirstObj.put("CoverGroups", "Emergency Assistance Service");
            FirstChildCoversArray.put(EmergencyCoversFirstObj);

            JSONObject HomeCareTreatmentCoversFirstObj = new JSONObject();
            HomeCareTreatmentCoversFirstObj.put("Applicable", HomeCareStatus);
            HomeCareTreatmentCoversFirstObj.put("CoverSI", strSumInsured);
            HomeCareTreatmentCoversFirstObj.put("CoverRate", "0");
            HomeCareTreatmentCoversFirstObj.put("CoverPremium", "0");
            HomeCareTreatmentCoversFirstObj.put("CoverGroups", "Home Care Treatment");
            FirstChildCoversArray.put(HomeCareTreatmentCoversFirstObj);

            JSONObject WellnessBenefitCoversFirstObj = new JSONObject();
            WellnessBenefitCoversFirstObj.put("Applicable", WellnessBenefitStatus);
            WellnessBenefitCoversFirstObj.put("CoverSI", strSumInsured);
            WellnessBenefitCoversFirstObj.put("CoverRate", "0");
            WellnessBenefitCoversFirstObj.put("CoverPremium", "0");
            WellnessBenefitCoversFirstObj.put("CoverGroups", "Wellness Benefit");
            FirstChildCoversArray.put(WellnessBenefitCoversFirstObj);

            JSONObject DiseaseManagementCoversFirstObj = new JSONObject();
            DiseaseManagementCoversFirstObj.put("Applicable", DiseaseManagementStatus);
            DiseaseManagementCoversFirstObj.put("CoverSI", strSumInsured);
            DiseaseManagementCoversFirstObj.put("CoverRate", "0");
            DiseaseManagementCoversFirstObj.put("CoverPremium", "0");
            DiseaseManagementCoversFirstObj.put("CoverGroups", "Disease Management Program");
            FirstChildCoversArray.put(DiseaseManagementCoversFirstObj);
            CoverDetailsFirstChildObj.put("Covers", FirstChildCoversArray);
            FirstChildObj.put("CoverDetails", CoverDetailsFirstChildObj);

            //childTwo
            JSONObject SecondChildObj = new JSONObject();
            SecondChildObj.put("InsuredType", "Child");
            SecondChildObj.put("FirstName", "child two");
            SecondChildObj.put("LastName", "");
            SecondChildObj.put("DOB", strSecondSonAgeEditText);
            SecondChildObj.put("Gender", str_twoGenderSpinner);
            SecondChildObj.put("Relationship", strRelationChildTwoEdit);
            SecondChildObj.put("Occupation", "Student");
            SecondChildObj.put("NomineeName", strNomineeName);
            SecondChildObj.put("NomineeRelationship", strNomineeRelationEdit);

            JSONObject HealthIndicatorsSecondChildObj = new JSONObject();
            HealthIndicatorsSecondChildObj.put("PED", "N");
            HealthIndicatorsSecondChildObj.put("PEDDeclared", "N");
            HealthIndicatorsSecondChildObj.put("BloodSugarLevel", strBloodSugar);
            HealthIndicatorsSecondChildObj.put("BloodPressureSystolic", strBloodPressure);
            HealthIndicatorsSecondChildObj.put("BloodPressureDiastolic", strBloodPressureDiastolic);
            HealthIndicatorsSecondChildObj.put("CholesterolLevel", strcholesterol);
            HealthIndicatorsSecondChildObj.put("BodyMassIndex", "30");
            HealthIndicatorsSecondChildObj.put("TobaccoAndAlcohol", "N");
            HealthIndicatorsSecondChildObj.put("CoMorbidity", "N");
            SecondChildObj.put("HealthIndicators", HealthIndicatorsSecondChildObj);

            JSONObject CoverDetailsSecondChildObj = new JSONObject();
            JSONArray SecondChildCoversArray = new JSONArray();
            JSONObject BasicInsuranceCoversSecChildObj = new JSONObject();
            BasicInsuranceCoversSecChildObj.put("Applicable", BasicStatus);
            BasicInsuranceCoversSecChildObj.put("CoverSI", strSumInsured);
            BasicInsuranceCoversSecChildObj.put("CoverRate", "0");
            BasicInsuranceCoversSecChildObj.put("CoverPremium", "0");
            BasicInsuranceCoversSecChildObj.put("CoverGroups", "Basic Insurance Cover");
            SecondChildCoversArray.put(BasicInsuranceCoversSecChildObj);

            JSONObject PersonalAccidentCoversSecondChildObj = new JSONObject();
            PersonalAccidentCoversSecondChildObj.put("Applicable", PersonalStatusChildTwo);
            PersonalAccidentCoversSecondChildObj.put("CoverSI", strSumInsured);
            PersonalAccidentCoversSecondChildObj.put("CoverRate", "0");
            PersonalAccidentCoversSecondChildObj.put("CoverPremium", "0");
            PersonalAccidentCoversSecondChildObj.put("CoverGroups", "Personal Accident Cover");
            SecondChildCoversArray.put(PersonalAccidentCoversSecondChildObj);

            JSONObject CriticalIllnessCoversSecondChildObj = new JSONObject();
            CriticalIllnessCoversSecondChildObj.put("Applicable", CriticalStatus);
            CriticalIllnessCoversSecondChildObj.put("CoverSI", strSumInsured);
            CriticalIllnessCoversSecondChildObj.put("CoverRate", "0");
            CriticalIllnessCoversSecondChildObj.put("CoverPremium", "0");
            CriticalIllnessCoversSecondChildObj.put("CoverGroups", "Critical Illness Cover");
            SecondChildCoversArray.put(CriticalIllnessCoversSecondChildObj);


            JSONObject DailyHospitalCoversSecondChildObj = new JSONObject();
            DailyHospitalCoversSecondChildObj.put("Applicable", DailyHospitalSatus);
            DailyHospitalCoversSecondChildObj.put("CoverSI", strSumInsured);
            DailyHospitalCoversSecondChildObj.put("CoverRate", "0");
            DailyHospitalCoversSecondChildObj.put("CoverPremium", "0");
            DailyHospitalCoversSecondChildObj.put("CoverGroups", "Daily Hospital Cash Cover");
            SecondChildCoversArray.put(DailyHospitalCoversSecondChildObj);

            JSONObject ModernCoversSecondChildObj = new JSONObject();
            ModernCoversSecondChildObj.put("Applicable", ModernTreatmentsStatus);
            ModernCoversSecondChildObj.put("CoverSI", strSumInsured);
            ModernCoversSecondChildObj.put("CoverRate", "0");
            ModernCoversSecondChildObj.put("CoverPremium", "0");
            ModernCoversSecondChildObj.put("CoverGroups", "Modern Treatments");
            SecondChildCoversArray.put(ModernCoversSecondChildObj);
            JSONObject ExtensionPreHospitalizationCoversSecondChildObj = new JSONObject();
            ExtensionPreHospitalizationCoversSecondChildObj.put("Applicable", ExtensionPreHospitalization);
            ExtensionPreHospitalizationCoversSecondChildObj.put("CoverSI", strSumInsured);
            ExtensionPreHospitalizationCoversSecondChildObj.put("CoverRate", "0");
            ExtensionPreHospitalizationCoversSecondChildObj.put("CoverPremium", "0");
            ExtensionPreHospitalizationCoversSecondChildObj.put("CoverGroups", "Extension under Pre-Hospitalization");
            SecondChildCoversArray.put(ExtensionPreHospitalizationCoversSecondChildObj);

            JSONObject ExtensionPostHospitalizationCoversSecondChildObj = new JSONObject();
            ExtensionPostHospitalizationCoversSecondChildObj.put("Applicable", ExtensionPr0Hospitalization);
            ExtensionPostHospitalizationCoversSecondChildObj.put("CoverSI", strSumInsured);
            ExtensionPostHospitalizationCoversSecondChildObj.put("CoverRate", "0");
            ExtensionPostHospitalizationCoversSecondChildObj.put("CoverPremium", "0");
            ExtensionPostHospitalizationCoversSecondChildObj.put("CoverGroups", "Extension under Post-Hospitalization");
            SecondChildCoversArray.put(ExtensionPostHospitalizationCoversSecondChildObj);


            JSONObject MaternityAndChildcareCoversSecChildObj = new JSONObject();
            MaternityAndChildcareCoversSecChildObj.put("Applicable", "False");
            MaternityAndChildcareCoversSecChildObj.put("CoverSI", strSumInsured);
            MaternityAndChildcareCoversSecChildObj.put("CoverRate", "0");
            MaternityAndChildcareCoversSecChildObj.put("CoverPremium", "0");
            MaternityAndChildcareCoversSecChildObj.put("CoverGroups", "Maternity and Childcare Benefit Waiting Period Modification");
            SecondChildCoversArray.put(MaternityAndChildcareCoversSecChildObj);

            JSONObject CoverageForNonMedicalCoversSecChildObj = new JSONObject();
            CoverageForNonMedicalCoversSecChildObj.put("Applicable", CoverageNonMedical);
            CoverageForNonMedicalCoversSecChildObj.put("CoverSI", strSumInsured);
            CoverageForNonMedicalCoversSecChildObj.put("CoverRate", "0");
            CoverageForNonMedicalCoversSecChildObj.put("CoverPremium", "0");
            CoverageForNonMedicalCoversSecChildObj.put("CoverGroups", "Coverage for Non-Medical Items");
            SecondChildCoversArray.put(CoverageForNonMedicalCoversSecChildObj);

            JSONObject ConditionWaiverCoversSecChildObj = new JSONObject();
            ConditionWaiverCoversSecChildObj.put("Applicable", ConditionWaiverStatus);
            ConditionWaiverCoversSecChildObj.put("CoverSI", strSumInsured);
            ConditionWaiverCoversSecChildObj.put("CoverRate", "0");
            ConditionWaiverCoversSecChildObj.put("CoverPremium", "0");
            ConditionWaiverCoversSecChildObj.put("CoverGroups", "Condition waiver under Restore Benefit");
            SecondChildCoversArray.put(ConditionWaiverCoversSecChildObj);

            JSONObject PreExistingDiseaseCoversSecChildObj = new JSONObject();
            PreExistingDiseaseCoversSecChildObj.put("Applicable", PreExistingDiseaseStatus);
            PreExistingDiseaseCoversSecChildObj.put("CoverSI", strSumInsured);
            PreExistingDiseaseCoversSecChildObj.put("CoverRate", "0");
            PreExistingDiseaseCoversSecChildObj.put("CoverPremium", "0");
            PreExistingDiseaseCoversSecChildObj.put("CoverGroups", "Pre-Existing Disease waiting period");
            SecondChildCoversArray.put(PreExistingDiseaseCoversSecChildObj);

            JSONObject OutpatientDentalWaitingCoversSecChildObj = new JSONObject();
            OutpatientDentalWaitingCoversSecChildObj.put("Applicable", OutpatientDentalStatus);
            OutpatientDentalWaitingCoversSecChildObj.put("CoverSI", strSumInsured);
            OutpatientDentalWaitingCoversSecChildObj.put("CoverRate", "0");
            OutpatientDentalWaitingCoversSecChildObj.put("CoverPremium", "0");
            OutpatientDentalWaitingCoversSecChildObj.put("CoverGroups", "Outpatient Dental Waiting Period Modification");
            SecondChildCoversArray.put(OutpatientDentalWaitingCoversSecChildObj);

            JSONObject EmergencyTravellingAllowanceCoversSecChildObj = new JSONObject();
            EmergencyTravellingAllowanceCoversSecChildObj.put("Applicable", EmergencyTravellingStatus);
            EmergencyTravellingAllowanceCoversSecChildObj.put("CoverSI", strSumInsured);
            EmergencyTravellingAllowanceCoversSecChildObj.put("CoverRate", "0");
            EmergencyTravellingAllowanceCoversSecChildObj.put("CoverPremium", "0");
            EmergencyTravellingAllowanceCoversSecChildObj.put("CoverGroups", "Emergency Travelling Allowance");
            SecondChildCoversArray.put(EmergencyTravellingAllowanceCoversSecChildObj);

            JSONObject SecondOpinionCoversSecChildObj = new JSONObject();
            SecondOpinionCoversSecChildObj.put("Applicable", SecondOpinionStatus);
            SecondOpinionCoversSecChildObj.put("CoverSI", strSumInsured);
            SecondOpinionCoversSecChildObj.put("CoverRate", "0");
            SecondOpinionCoversSecChildObj.put("CoverPremium", "0");
            SecondOpinionCoversSecChildObj.put("CoverGroups", "Second Opinion");
            SecondChildCoversArray.put(SecondOpinionCoversSecChildObj);

            JSONObject RestCureCoversSecChildObj = new JSONObject();
            RestCureCoversSecChildObj.put("Applicable", RestCureStatus);
            RestCureCoversSecChildObj.put("CoverSI", strSumInsured);
            RestCureCoversSecChildObj.put("CoverRate", "0");
            RestCureCoversSecChildObj.put("CoverPremium", "0");
            RestCureCoversSecChildObj.put("CoverGroups", "Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
            SecondChildCoversArray.put(RestCureCoversSecChildObj);

            JSONObject ObesityWeightCoversSecChildObj = new JSONObject();
            ObesityWeightCoversSecChildObj.put("Applicable", ObesityWeightStatus);
            ObesityWeightCoversSecChildObj.put("CoverSI", strSumInsured);
            ObesityWeightCoversSecChildObj.put("CoverRate", "0");
            ObesityWeightCoversSecChildObj.put("CoverPremium", "0");
            ObesityWeightCoversSecChildObj.put("CoverGroups", "Obesity/ Weight Control Expenses Extension");
            SecondChildCoversArray.put(ObesityWeightCoversSecChildObj);

            JSONObject SterilityInfertilityCoversSecChildObj = new JSONObject();
            SterilityInfertilityCoversSecChildObj.put("Applicable", "False");
            SterilityInfertilityCoversSecChildObj.put("CoverSI", strSumInsured);
            SterilityInfertilityCoversSecChildObj.put("CoverRate", "0");
            SterilityInfertilityCoversSecChildObj.put("CoverPremium", "0");
            SterilityInfertilityCoversSecChildObj.put("CoverGroups", "Sterility and Infertility Treatment Expenses Extension");
            SecondChildCoversArray.put(SterilityInfertilityCoversSecChildObj);

            JSONObject EnhancedOrganDonorCoversSecChildObj = new JSONObject();
            EnhancedOrganDonorCoversSecChildObj.put("Applicable", EnhancedOrganStatus);
            EnhancedOrganDonorCoversSecChildObj.put("CoverSI", strSumInsured);
            EnhancedOrganDonorCoversSecChildObj.put("CoverRate", "0");
            EnhancedOrganDonorCoversSecChildObj.put("CoverPremium", "0");
            EnhancedOrganDonorCoversSecChildObj.put("CoverGroups", "Enhanced Organ Donor Expenses");
            SecondChildCoversArray.put(EnhancedOrganDonorCoversSecChildObj);

            JSONObject PremiumWaiverCoversSecChildObj = new JSONObject();
            PremiumWaiverCoversSecChildObj.put("Applicable", PremiumWaiverStatus);
            PremiumWaiverCoversSecChildObj.put("CoverSI", strSumInsured);
            PremiumWaiverCoversSecChildObj.put("CoverRate", "0");
            PremiumWaiverCoversSecChildObj.put("CoverPremium", "0");
            PremiumWaiverCoversSecChildObj.put("CoverGroups", "Premium Waiver");
            SecondChildCoversArray.put(PremiumWaiverCoversSecChildObj);

            JSONObject GlobalCoversSecChildObj = new JSONObject();
            GlobalCoversSecChildObj.put("Applicable", GlobalCoverStatus);
            GlobalCoversSecChildObj.put("CoverSI", strSumInsured);
            GlobalCoversSecChildObj.put("CoverRate", "0");
            GlobalCoversSecChildObj.put("CoverPremium", "0");
            GlobalCoversSecChildObj.put("CoverGroups", "Global Cover");
            SecondChildCoversArray.put(GlobalCoversSecChildObj);


            JSONObject MedicallyAdvisedCoversSecChildObj = new JSONObject();
            MedicallyAdvisedCoversSecChildObj.put("Applicable", MedicallyAdvisedStatus);
            MedicallyAdvisedCoversSecChildObj.put("CoverSI", strSumInsured);
            MedicallyAdvisedCoversSecChildObj.put("CoverRate", "0");
            MedicallyAdvisedCoversSecChildObj.put("CoverPremium", "0");
            MedicallyAdvisedCoversSecChildObj.put("CoverGroups", "Medically Advised Support Devices");
            SecondChildCoversArray.put(MedicallyAdvisedCoversSecChildObj);

            JSONObject EmergencyCoversSecChildObj = new JSONObject();
            EmergencyCoversSecChildObj.put("Applicable", EmergencyAssistanceStatus);
            EmergencyCoversSecChildObj.put("CoverSI", strSumInsured);
            EmergencyCoversSecChildObj.put("CoverRate", "0");
            EmergencyCoversSecChildObj.put("CoverPremium", "0");
            EmergencyCoversSecChildObj.put("CoverGroups", "Emergency Assistance Service");
            SecondChildCoversArray.put(EmergencyCoversSecChildObj);

            JSONObject HomeCareTreatmentCoversSecChildObj = new JSONObject();
            HomeCareTreatmentCoversSecChildObj.put("Applicable", HomeCareStatus);
            HomeCareTreatmentCoversSecChildObj.put("CoverSI", strSumInsured);
            HomeCareTreatmentCoversSecChildObj.put("CoverRate", "0");
            HomeCareTreatmentCoversSecChildObj.put("CoverPremium", "0");
            HomeCareTreatmentCoversSecChildObj.put("CoverGroups", "Home Care Treatment");
            SecondChildCoversArray.put(HomeCareTreatmentCoversSecChildObj);

            JSONObject WellnessBenefitCoversSecChildObj = new JSONObject();
            WellnessBenefitCoversSecChildObj.put("Applicable", WellnessBenefitStatus);
            WellnessBenefitCoversSecChildObj.put("CoverSI", strSumInsured);
            WellnessBenefitCoversSecChildObj.put("CoverRate", "0");
            WellnessBenefitCoversSecChildObj.put("CoverPremium", "0");
            WellnessBenefitCoversSecChildObj.put("CoverGroups", "Wellness Benefit");
            SecondChildCoversArray.put(WellnessBenefitCoversSecChildObj);

            JSONObject DiseaseManagementCoversSecChildObj = new JSONObject();
            DiseaseManagementCoversSecChildObj.put("Applicable", DiseaseManagementStatus);
            DiseaseManagementCoversSecChildObj.put("CoverSI", strSumInsured);
            DiseaseManagementCoversSecChildObj.put("CoverRate", "0");
            DiseaseManagementCoversSecChildObj.put("CoverPremium", "0");
            DiseaseManagementCoversSecChildObj.put("CoverGroups", "Disease Management Program");
            SecondChildCoversArray.put(DiseaseManagementCoversSecChildObj);
            CoverDetailsSecondChildObj.put("Covers", SecondChildCoversArray);
            SecondChildObj.put("CoverDetails", CoverDetailsSecondChildObj);

            //Third child
            JSONObject ThirdChildObj = new JSONObject();
            ThirdChildObj.put("InsuredType", "Child");
            ThirdChildObj.put("FirstName", "Child third");
            ThirdChildObj.put("LastName", "");
            ThirdChildObj.put("DOB", strThirdSonAgeEditText);
            ThirdChildObj.put("Gender", str_thirdGenderSpinner);
            ThirdChildObj.put("Relationship", strRelationChildThreeEdit);
            ThirdChildObj.put("Occupation", "Student");
            ThirdChildObj.put("NomineeName", strNomineeName);
            ThirdChildObj.put("NomineeRelationship", strNomineeRelationEdit);

            JSONObject HealthIndicatorsThirdChildObj = new JSONObject();
            HealthIndicatorsThirdChildObj.put("PED", "N");
            HealthIndicatorsThirdChildObj.put("PEDDeclared", "N");
            HealthIndicatorsThirdChildObj.put("BloodSugarLevel", strBloodSugar);
            HealthIndicatorsThirdChildObj.put("BloodPressureSystolic", strBloodPressure);
            HealthIndicatorsThirdChildObj.put("BloodPressureDiastolic", strBloodPressureDiastolic);
            HealthIndicatorsThirdChildObj.put("CholesterolLevel", strcholesterol);
            HealthIndicatorsThirdChildObj.put("BodyMassIndex", "30");
            HealthIndicatorsThirdChildObj.put("TobaccoAndAlcohol", "N");
            HealthIndicatorsThirdChildObj.put("CoMorbidity", "N");
            ThirdChildObj.put("HealthIndicators", HealthIndicatorsThirdChildObj);

            JSONObject CoverDetailsThirdChildObj = new JSONObject();
            JSONArray ThirdChildCoversArray = new JSONArray();
            JSONObject BasicInsuranceCoversThirdChildObj = new JSONObject();
            BasicInsuranceCoversThirdChildObj.put("Applicable", BasicStatus);
            BasicInsuranceCoversThirdChildObj.put("CoverSI", strSumInsured);
            BasicInsuranceCoversThirdChildObj.put("CoverRate", "0");
            BasicInsuranceCoversThirdChildObj.put("CoverPremium", "0");
            BasicInsuranceCoversThirdChildObj.put("CoverGroups", "Basic Insurance Cover");
            ThirdChildCoversArray.put(BasicInsuranceCoversThirdChildObj);

            JSONObject PersonalAccidentCoversThirdChildObj = new JSONObject();
            PersonalAccidentCoversThirdChildObj.put("Applicable", PersonalStatusChildThird);
            PersonalAccidentCoversThirdChildObj.put("CoverSI", strSumInsured);
            PersonalAccidentCoversThirdChildObj.put("CoverRate", "0");
            PersonalAccidentCoversThirdChildObj.put("CoverPremium", "0");
            PersonalAccidentCoversThirdChildObj.put("CoverGroups", "Personal Accident Cover");
            ThirdChildCoversArray.put(PersonalAccidentCoversThirdChildObj);

            JSONObject CriticalIllnessCoversThirdChildObj = new JSONObject();
            CriticalIllnessCoversThirdChildObj.put("Applicable", CriticalStatus);
            CriticalIllnessCoversThirdChildObj.put("CoverSI", strSumInsured);
            CriticalIllnessCoversThirdChildObj.put("CoverRate", "0");
            CriticalIllnessCoversThirdChildObj.put("CoverPremium", "0");
            CriticalIllnessCoversThirdChildObj.put("CoverGroups", "Critical Illness Cover");
            ThirdChildCoversArray.put(CriticalIllnessCoversThirdChildObj);


            JSONObject DailyHospitalCoversThirdChildObj = new JSONObject();
            DailyHospitalCoversThirdChildObj.put("Applicable", DailyHospitalSatus);
            DailyHospitalCoversThirdChildObj.put("CoverSI", strSumInsured);
            DailyHospitalCoversThirdChildObj.put("CoverRate", "0");
            DailyHospitalCoversThirdChildObj.put("CoverPremium", "0");
            DailyHospitalCoversThirdChildObj.put("CoverGroups", "Daily Hospital Cash Cover");
            ThirdChildCoversArray.put(DailyHospitalCoversThirdChildObj);

            JSONObject ModernCoversThirdChildObj = new JSONObject();
            ModernCoversThirdChildObj.put("Applicable", ModernTreatmentsStatus);
            ModernCoversThirdChildObj.put("CoverSI", strSumInsured);
            ModernCoversThirdChildObj.put("CoverRate", "0");
            ModernCoversThirdChildObj.put("CoverPremium", "0");
            ModernCoversThirdChildObj.put("CoverGroups", "Modern Treatments");
            ThirdChildCoversArray.put(ModernCoversThirdChildObj);
            JSONObject ExtensionPreHospitalizationCoversThirdChildObj = new JSONObject();
            ExtensionPreHospitalizationCoversThirdChildObj.put("Applicable", ExtensionPreHospitalization);
            ExtensionPreHospitalizationCoversThirdChildObj.put("CoverSI", strSumInsured);
            ExtensionPreHospitalizationCoversThirdChildObj.put("CoverRate", "0");
            ExtensionPreHospitalizationCoversThirdChildObj.put("CoverPremium", "0");
            ExtensionPreHospitalizationCoversThirdChildObj.put("CoverGroups", "Extension under Pre-Hospitalization");
            ThirdChildCoversArray.put(ExtensionPreHospitalizationCoversThirdChildObj);

            JSONObject ExtensionPostHospitalizationCoversThirdChildObj = new JSONObject();
            ExtensionPostHospitalizationCoversThirdChildObj.put("Applicable", ExtensionPr0Hospitalization);
            ExtensionPostHospitalizationCoversThirdChildObj.put("CoverSI", strSumInsured);
            ExtensionPostHospitalizationCoversThirdChildObj.put("CoverRate", "0");
            ExtensionPostHospitalizationCoversThirdChildObj.put("CoverPremium", "0");
            ExtensionPostHospitalizationCoversThirdChildObj.put("CoverGroups", "Extension under Post-Hospitalization");
            ThirdChildCoversArray.put(ExtensionPostHospitalizationCoversThirdChildObj);


            JSONObject MaternityAndChildcareCoversThirdChildObj = new JSONObject();
            MaternityAndChildcareCoversThirdChildObj.put("Applicable", "False");
            MaternityAndChildcareCoversThirdChildObj.put("CoverSI", strSumInsured);
            MaternityAndChildcareCoversThirdChildObj.put("CoverRate", "0");
            MaternityAndChildcareCoversThirdChildObj.put("CoverPremium", "0");
            MaternityAndChildcareCoversThirdChildObj.put("CoverGroups", "Maternity and Childcare Benefit Waiting Period Modification");
            ThirdChildCoversArray.put(MaternityAndChildcareCoversThirdChildObj);

            JSONObject CoverageForNonMedicalCoversThirdChildObj = new JSONObject();
            CoverageForNonMedicalCoversThirdChildObj.put("Applicable", CoverageNonMedical);
            CoverageForNonMedicalCoversThirdChildObj.put("CoverSI", strSumInsured);
            CoverageForNonMedicalCoversThirdChildObj.put("CoverRate", "0");
            CoverageForNonMedicalCoversThirdChildObj.put("CoverPremium", "0");
            CoverageForNonMedicalCoversThirdChildObj.put("CoverGroups", "Coverage for Non-Medical Items");
            ThirdChildCoversArray.put(CoverageForNonMedicalCoversThirdChildObj);

            JSONObject ConditionWaiverCoversThirdChildObj = new JSONObject();
            ConditionWaiverCoversThirdChildObj.put("Applicable", ConditionWaiverStatus);
            ConditionWaiverCoversThirdChildObj.put("CoverSI", strSumInsured);
            ConditionWaiverCoversThirdChildObj.put("CoverRate", "0");
            ConditionWaiverCoversThirdChildObj.put("CoverPremium", "0");
            ConditionWaiverCoversThirdChildObj.put("CoverGroups", "Condition waiver under Restore Benefit");
            ThirdChildCoversArray.put(ConditionWaiverCoversThirdChildObj);

            JSONObject PreExistingDiseaseCoversThirdChildObj = new JSONObject();
            PreExistingDiseaseCoversThirdChildObj.put("Applicable", PreExistingDiseaseStatus);
            PreExistingDiseaseCoversThirdChildObj.put("CoverSI", strSumInsured);
            PreExistingDiseaseCoversThirdChildObj.put("CoverRate", "0");
            PreExistingDiseaseCoversThirdChildObj.put("CoverPremium", "0");
            PreExistingDiseaseCoversThirdChildObj.put("CoverGroups", "Pre-Existing Disease waiting period");
            ThirdChildCoversArray.put(PreExistingDiseaseCoversThirdChildObj);

            JSONObject OutpatientDentalWaitingCoversThirdChildObj = new JSONObject();
            OutpatientDentalWaitingCoversThirdChildObj.put("Applicable", OutpatientDentalStatus);
            OutpatientDentalWaitingCoversThirdChildObj.put("CoverSI", strSumInsured);
            OutpatientDentalWaitingCoversThirdChildObj.put("CoverRate", "0");
            OutpatientDentalWaitingCoversThirdChildObj.put("CoverPremium", "0");
            OutpatientDentalWaitingCoversThirdChildObj.put("CoverGroups", "Outpatient Dental Waiting Period Modification");
            ThirdChildCoversArray.put(OutpatientDentalWaitingCoversThirdChildObj);

            JSONObject EmergencyTravellingAllowanceCoversThirdChildObj = new JSONObject();
            EmergencyTravellingAllowanceCoversThirdChildObj.put("Applicable", EmergencyTravellingStatus);
            EmergencyTravellingAllowanceCoversThirdChildObj.put("CoverSI", strSumInsured);
            EmergencyTravellingAllowanceCoversThirdChildObj.put("CoverRate", "0");
            EmergencyTravellingAllowanceCoversThirdChildObj.put("CoverPremium", "0");
            EmergencyTravellingAllowanceCoversThirdChildObj.put("CoverGroups", "Emergency Travelling Allowance");
            ThirdChildCoversArray.put(EmergencyTravellingAllowanceCoversThirdChildObj);

            JSONObject SecondOpinionCoversThirdChildObj = new JSONObject();
            SecondOpinionCoversThirdChildObj.put("Applicable", SecondOpinionStatus);
            SecondOpinionCoversThirdChildObj.put("CoverSI", strSumInsured);
            SecondOpinionCoversThirdChildObj.put("CoverRate", "0");
            SecondOpinionCoversThirdChildObj.put("CoverPremium", "0");
            SecondOpinionCoversThirdChildObj.put("CoverGroups", "Second Opinion");
            ThirdChildCoversArray.put(SecondOpinionCoversThirdChildObj);

            JSONObject RestCureCoversThirdChildObj = new JSONObject();
            RestCureCoversThirdChildObj.put("Applicable", RestCureStatus);
            RestCureCoversThirdChildObj.put("CoverSI", strSumInsured);
            RestCureCoversThirdChildObj.put("CoverRate", "0");
            RestCureCoversThirdChildObj.put("CoverPremium", "0");
            RestCureCoversThirdChildObj.put("CoverGroups", "Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
            ThirdChildCoversArray.put(RestCureCoversThirdChildObj);

            JSONObject ObesityWeightCoversThirdChildObj = new JSONObject();
            ObesityWeightCoversThirdChildObj.put("Applicable", ObesityWeightStatus);
            ObesityWeightCoversThirdChildObj.put("CoverSI", strSumInsured);
            ObesityWeightCoversThirdChildObj.put("CoverRate", "0");
            ObesityWeightCoversThirdChildObj.put("CoverPremium", "0");
            ObesityWeightCoversThirdChildObj.put("CoverGroups", "Obesity/ Weight Control Expenses Extension");
            ThirdChildCoversArray.put(ObesityWeightCoversThirdChildObj);

            JSONObject SterilityInfertilityCoversThirdChildObj = new JSONObject();
            SterilityInfertilityCoversThirdChildObj.put("Applicable", "False");
            SterilityInfertilityCoversThirdChildObj.put("CoverSI", strSumInsured);
            SterilityInfertilityCoversThirdChildObj.put("CoverRate", "0");
            SterilityInfertilityCoversThirdChildObj.put("CoverPremium", "0");
            SterilityInfertilityCoversThirdChildObj.put("CoverGroups", "Sterility and Infertility Treatment Expenses Extension");
            ThirdChildCoversArray.put(SterilityInfertilityCoversThirdChildObj);

            JSONObject EnhancedOrganDonorCoversThirdChildObj = new JSONObject();
            EnhancedOrganDonorCoversThirdChildObj.put("Applicable", EnhancedOrganStatus);
            EnhancedOrganDonorCoversThirdChildObj.put("CoverSI", strSumInsured);
            EnhancedOrganDonorCoversThirdChildObj.put("CoverRate", "0");
            EnhancedOrganDonorCoversThirdChildObj.put("CoverPremium", "0");
            EnhancedOrganDonorCoversThirdChildObj.put("CoverGroups", "Enhanced Organ Donor Expenses");
            ThirdChildCoversArray.put(EnhancedOrganDonorCoversThirdChildObj);

            JSONObject PremiumWaiverCoversThirdChildObj = new JSONObject();
            PremiumWaiverCoversThirdChildObj.put("Applicable", PremiumWaiverStatus);
            PremiumWaiverCoversThirdChildObj.put("CoverSI", strSumInsured);
            PremiumWaiverCoversThirdChildObj.put("CoverRate", "0");
            PremiumWaiverCoversThirdChildObj.put("CoverPremium", "0");
            PremiumWaiverCoversThirdChildObj.put("CoverGroups", "Premium Waiver");
            ThirdChildCoversArray.put(PremiumWaiverCoversThirdChildObj);

            JSONObject GlobalCoversThirdChildObj = new JSONObject();
            GlobalCoversThirdChildObj.put("Applicable", GlobalCoverStatus);
            GlobalCoversThirdChildObj.put("CoverSI", strSumInsured);
            GlobalCoversThirdChildObj.put("CoverRate", "0");
            GlobalCoversThirdChildObj.put("CoverPremium", "0");
            GlobalCoversThirdChildObj.put("CoverGroups", "Global Cover");
            ThirdChildCoversArray.put(GlobalCoversThirdChildObj);


            JSONObject MedicallyAdvisedCoversThirdChildObj = new JSONObject();
            MedicallyAdvisedCoversThirdChildObj.put("Applicable", MedicallyAdvisedStatus);
            MedicallyAdvisedCoversThirdChildObj.put("CoverSI", strSumInsured);
            MedicallyAdvisedCoversThirdChildObj.put("CoverRate", "0");
            MedicallyAdvisedCoversThirdChildObj.put("CoverPremium", "0");
            MedicallyAdvisedCoversThirdChildObj.put("CoverGroups", "Medically Advised Support Devices");
            ThirdChildCoversArray.put(MedicallyAdvisedCoversThirdChildObj);

            JSONObject EmergencyCoversThirdChildObj = new JSONObject();
            EmergencyCoversThirdChildObj.put("Applicable", EmergencyAssistanceStatus);
            EmergencyCoversThirdChildObj.put("CoverSI", strSumInsured);
            EmergencyCoversThirdChildObj.put("CoverRate", "0");
            EmergencyCoversThirdChildObj.put("CoverPremium", "0");
            EmergencyCoversThirdChildObj.put("CoverGroups", "Emergency Assistance Service");
            ThirdChildCoversArray.put(EmergencyCoversThirdChildObj);

            JSONObject HomeCareTreatmentCoversThirdChildObj = new JSONObject();
            HomeCareTreatmentCoversThirdChildObj.put("Applicable", HomeCareStatus);
            HomeCareTreatmentCoversThirdChildObj.put("CoverSI", strSumInsured);
            HomeCareTreatmentCoversThirdChildObj.put("CoverRate", "0");
            HomeCareTreatmentCoversThirdChildObj.put("CoverPremium", "0");
            HomeCareTreatmentCoversThirdChildObj.put("CoverGroups", "Home Care Treatment");
            ThirdChildCoversArray.put(HomeCareTreatmentCoversThirdChildObj);

            JSONObject WellnessBenefitCoversThirdChildObj = new JSONObject();
            WellnessBenefitCoversThirdChildObj.put("Applicable", WellnessBenefitStatus);
            WellnessBenefitCoversThirdChildObj.put("CoverSI", strSumInsured);
            WellnessBenefitCoversThirdChildObj.put("CoverRate", "0");
            WellnessBenefitCoversThirdChildObj.put("CoverPremium", "0");
            WellnessBenefitCoversThirdChildObj.put("CoverGroups", "Wellness Benefit");
            ThirdChildCoversArray.put(WellnessBenefitCoversThirdChildObj);

            JSONObject DiseaseManagementCoversThirdChildObj = new JSONObject();
            DiseaseManagementCoversThirdChildObj.put("Applicable", DiseaseManagementStatus);
            DiseaseManagementCoversThirdChildObj.put("CoverSI", strSumInsured);
            DiseaseManagementCoversThirdChildObj.put("CoverRate", "0");
            DiseaseManagementCoversThirdChildObj.put("CoverPremium", "0");
            DiseaseManagementCoversThirdChildObj.put("CoverGroups", "Disease Management Program");
            ThirdChildCoversArray.put(DiseaseManagementCoversThirdChildObj);
            CoverDetailsThirdChildObj.put("Covers", ThirdChildCoversArray);
            ThirdChildObj.put("CoverDetails", CoverDetailsThirdChildObj);

            //fourChild
            JSONObject FourthChildObj = new JSONObject();
            FourthChildObj.put("InsuredType", "Child");
            FourthChildObj.put("FirstName", strFourChildNameEdit);
            FourthChildObj.put("LastName", "");
            FourthChildObj.put("DOB", strFourSonAgeEditText);
            FourthChildObj.put("Gender", str_fourGenderSpinner);
            FourthChildObj.put("Relationship", strRelationFourChildEdit);
            FourthChildObj.put("Occupation", "Student");
            FourthChildObj.put("NomineeName", strNomineeName);
            FourthChildObj.put("NomineeRelationship", strNomineeRelationEdit);

            JSONObject HealthIndicatorsFourthChildObj = new JSONObject();
            HealthIndicatorsFourthChildObj.put("PED", "N");
            HealthIndicatorsFourthChildObj.put("PEDDeclared", "N");
            HealthIndicatorsFourthChildObj.put("BloodSugarLevel", strBloodSugar);
            HealthIndicatorsFourthChildObj.put("BloodPressureSystolic", strBloodPressure);
            HealthIndicatorsFourthChildObj.put("BloodPressureDiastolic", strBloodPressureDiastolic);
            HealthIndicatorsFourthChildObj.put("CholesterolLevel", strcholesterol);
            HealthIndicatorsFourthChildObj.put("BodyMassIndex", "30");
            HealthIndicatorsFourthChildObj.put("TobaccoAndAlcohol", "N");
            HealthIndicatorsFourthChildObj.put("CoMorbidity", "N");
            FourthChildObj.put("HealthIndicators", HealthIndicatorsFourthChildObj);

            JSONObject CoverDetailsFourthChildObj = new JSONObject();
            JSONArray FourthChildCoversArray = new JSONArray();
            JSONObject BasicInsuranceCoversFourthChildObj = new JSONObject();
            BasicInsuranceCoversFourthChildObj.put("Applicable", BasicStatus);
            BasicInsuranceCoversFourthChildObj.put("CoverSI", strSumInsured);
            BasicInsuranceCoversFourthChildObj.put("CoverRate", "0");
            BasicInsuranceCoversFourthChildObj.put("CoverPremium", "0");
            BasicInsuranceCoversFourthChildObj.put("CoverGroups", "Basic Insurance Cover");
            FourthChildCoversArray.put(BasicInsuranceCoversFourthChildObj);

            JSONObject PersonalAccidentCoversFourthChildObj = new JSONObject();
            PersonalAccidentCoversFourthChildObj.put("Applicable", PersonalStatusChildFour);
            PersonalAccidentCoversFourthChildObj.put("CoverSI", strSumInsured);
            PersonalAccidentCoversFourthChildObj.put("CoverRate", "0");
            PersonalAccidentCoversFourthChildObj.put("CoverPremium", "0");
            PersonalAccidentCoversFourthChildObj.put("CoverGroups", "Personal Accident Cover");
            FourthChildCoversArray.put(PersonalAccidentCoversFourthChildObj);

            JSONObject CriticalIllnessCoversFourthChildObj = new JSONObject();
            CriticalIllnessCoversFourthChildObj.put("Applicable", CriticalStatus);
            CriticalIllnessCoversFourthChildObj.put("CoverSI", strSumInsured);
            CriticalIllnessCoversFourthChildObj.put("CoverRate", "0");
            CriticalIllnessCoversFourthChildObj.put("CoverPremium", "0");
            CriticalIllnessCoversFourthChildObj.put("CoverGroups", "Critical Illness Cover");
            FourthChildCoversArray.put(CriticalIllnessCoversFourthChildObj);


            JSONObject DailyHospitalCoversFourthChildObj = new JSONObject();
            DailyHospitalCoversFourthChildObj.put("Applicable", DailyHospitalSatus);
            DailyHospitalCoversFourthChildObj.put("CoverSI", strSumInsured);
            DailyHospitalCoversFourthChildObj.put("CoverRate", "0");
            DailyHospitalCoversFourthChildObj.put("CoverPremium", "0");
            DailyHospitalCoversFourthChildObj.put("CoverGroups", "Daily Hospital Cash Cover");
            FourthChildCoversArray.put(DailyHospitalCoversFourthChildObj);

            JSONObject ModernCoversFourthChildObj = new JSONObject();
            ModernCoversFourthChildObj.put("Applicable", ModernTreatmentsStatus);
            ModernCoversFourthChildObj.put("CoverSI", strSumInsured);
            ModernCoversFourthChildObj.put("CoverRate", "0");
            ModernCoversFourthChildObj.put("CoverPremium", "0");
            ModernCoversFourthChildObj.put("CoverGroups", "Modern Treatments");
            FourthChildCoversArray.put(ModernCoversFourthChildObj);
            JSONObject ExtensionPreHospitalizationCoversFourthChildObj = new JSONObject();
            ExtensionPreHospitalizationCoversFourthChildObj.put("Applicable", ExtensionPreHospitalization);
            ExtensionPreHospitalizationCoversFourthChildObj.put("CoverSI", strSumInsured);
            ExtensionPreHospitalizationCoversFourthChildObj.put("CoverRate", "0");
            ExtensionPreHospitalizationCoversFourthChildObj.put("CoverPremium", "0");
            ExtensionPreHospitalizationCoversFourthChildObj.put("CoverGroups", "Extension under Pre-Hospitalization");
            FourthChildCoversArray.put(ExtensionPreHospitalizationCoversFourthChildObj);

            JSONObject ExtensionPostHospitalizationCoversFourthChildObj = new JSONObject();
            ExtensionPostHospitalizationCoversFourthChildObj.put("Applicable", ExtensionPr0Hospitalization);
            ExtensionPostHospitalizationCoversFourthChildObj.put("CoverSI", strSumInsured);
            ExtensionPostHospitalizationCoversFourthChildObj.put("CoverRate", "0");
            ExtensionPostHospitalizationCoversFourthChildObj.put("CoverPremium", "0");
            ExtensionPostHospitalizationCoversFourthChildObj.put("CoverGroups", "Extension under Post-Hospitalization");
            FourthChildCoversArray.put(ExtensionPostHospitalizationCoversFourthChildObj);


            JSONObject MaternityAndChildcareCoversFourthChildObj = new JSONObject();
            MaternityAndChildcareCoversFourthChildObj.put("Applicable", "False");
            MaternityAndChildcareCoversFourthChildObj.put("CoverSI", strSumInsured);
            MaternityAndChildcareCoversFourthChildObj.put("CoverRate", "0");
            MaternityAndChildcareCoversFourthChildObj.put("CoverPremium", "0");
            MaternityAndChildcareCoversFourthChildObj.put("CoverGroups", "Maternity and Childcare Benefit Waiting Period Modification");
            FourthChildCoversArray.put(MaternityAndChildcareCoversFourthChildObj);

            JSONObject CoverageForNonMedicalCoversFourthChildObj = new JSONObject();
            CoverageForNonMedicalCoversFourthChildObj.put("Applicable", CoverageNonMedical);
            CoverageForNonMedicalCoversFourthChildObj.put("CoverSI", strSumInsured);
            CoverageForNonMedicalCoversFourthChildObj.put("CoverRate", "0");
            CoverageForNonMedicalCoversFourthChildObj.put("CoverPremium", "0");
            CoverageForNonMedicalCoversFourthChildObj.put("CoverGroups", "Coverage for Non-Medical Items");
            FourthChildCoversArray.put(CoverageForNonMedicalCoversFourthChildObj);

            JSONObject ConditionWaiverCoversFourthChildObj = new JSONObject();
            ConditionWaiverCoversFourthChildObj.put("Applicable", ConditionWaiverStatus);
            ConditionWaiverCoversFourthChildObj.put("CoverSI", strSumInsured);
            ConditionWaiverCoversFourthChildObj.put("CoverRate", "0");
            ConditionWaiverCoversFourthChildObj.put("CoverPremium", "0");
            ConditionWaiverCoversFourthChildObj.put("CoverGroups", "Condition waiver under Restore Benefit");
            FourthChildCoversArray.put(ConditionWaiverCoversFourthChildObj);

            JSONObject PreExistingDiseaseCoversFourthChildObj = new JSONObject();
            PreExistingDiseaseCoversFourthChildObj.put("Applicable", PreExistingDiseaseStatus);
            PreExistingDiseaseCoversFourthChildObj.put("CoverSI", strSumInsured);
            PreExistingDiseaseCoversFourthChildObj.put("CoverRate", "0");
            PreExistingDiseaseCoversFourthChildObj.put("CoverPremium", "0");
            PreExistingDiseaseCoversFourthChildObj.put("CoverGroups", "Pre-Existing Disease waiting period");
            FourthChildCoversArray.put(PreExistingDiseaseCoversFourthChildObj);

            JSONObject OutpatientDentalWaitingCoversFourthChildObj = new JSONObject();
            OutpatientDentalWaitingCoversFourthChildObj.put("Applicable", OutpatientDentalStatus);
            OutpatientDentalWaitingCoversFourthChildObj.put("CoverSI", strSumInsured);
            OutpatientDentalWaitingCoversFourthChildObj.put("CoverRate", "0");
            OutpatientDentalWaitingCoversFourthChildObj.put("CoverPremium", "0");
            OutpatientDentalWaitingCoversFourthChildObj.put("CoverGroups", "Outpatient Dental Waiting Period Modification");
            FourthChildCoversArray.put(OutpatientDentalWaitingCoversFourthChildObj);

            JSONObject EmergencyTravellingAllowanceCoversFourthChildObj = new JSONObject();
            EmergencyTravellingAllowanceCoversFourthChildObj.put("Applicable", EmergencyTravellingStatus);
            EmergencyTravellingAllowanceCoversFourthChildObj.put("CoverSI", strSumInsured);
            EmergencyTravellingAllowanceCoversFourthChildObj.put("CoverRate", "0");
            EmergencyTravellingAllowanceCoversFourthChildObj.put("CoverPremium", "0");
            EmergencyTravellingAllowanceCoversFourthChildObj.put("CoverGroups", "Emergency Travelling Allowance");
            FourthChildCoversArray.put(EmergencyTravellingAllowanceCoversFourthChildObj);

            JSONObject SecondOpinionCoversFourthChildObj = new JSONObject();
            SecondOpinionCoversFourthChildObj.put("Applicable", SecondOpinionStatus);
            SecondOpinionCoversFourthChildObj.put("CoverSI", strSumInsured);
            SecondOpinionCoversFourthChildObj.put("CoverRate", "0");
            SecondOpinionCoversFourthChildObj.put("CoverPremium", "0");
            SecondOpinionCoversFourthChildObj.put("CoverGroups", "Second Opinion");
            FourthChildCoversArray.put(SecondOpinionCoversFourthChildObj);

            JSONObject RestCureCoversFourthChildObj = new JSONObject();
            RestCureCoversFourthChildObj.put("Applicable", RestCureStatus);
            RestCureCoversFourthChildObj.put("CoverSI", strSumInsured);
            RestCureCoversFourthChildObj.put("CoverRate", "0");
            RestCureCoversFourthChildObj.put("CoverPremium", "0");
            RestCureCoversFourthChildObj.put("CoverGroups", "Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
            FourthChildCoversArray.put(RestCureCoversFourthChildObj);

            JSONObject ObesityWeightCoversFourthChildObj = new JSONObject();
            ObesityWeightCoversFourthChildObj.put("Applicable", ObesityWeightStatus);
            ObesityWeightCoversFourthChildObj.put("CoverSI", strSumInsured);
            ObesityWeightCoversFourthChildObj.put("CoverRate", "0");
            ObesityWeightCoversFourthChildObj.put("CoverPremium", "0");
            ObesityWeightCoversFourthChildObj.put("CoverGroups", "Obesity/ Weight Control Expenses Extension");
            FourthChildCoversArray.put(ObesityWeightCoversFourthChildObj);

            JSONObject SterilityInfertilityCoversFourthChildObj = new JSONObject();
            SterilityInfertilityCoversFourthChildObj.put("Applicable", "False");
            SterilityInfertilityCoversFourthChildObj.put("CoverSI", strSumInsured);
            SterilityInfertilityCoversFourthChildObj.put("CoverRate", "0");
            SterilityInfertilityCoversFourthChildObj.put("CoverPremium", "0");
            SterilityInfertilityCoversFourthChildObj.put("CoverGroups", "Sterility and Infertility Treatment Expenses Extension");
            FourthChildCoversArray.put(SterilityInfertilityCoversFourthChildObj);

            JSONObject EnhancedOrganDonorCoversFourthChildObj = new JSONObject();
            EnhancedOrganDonorCoversFourthChildObj.put("Applicable", EnhancedOrganStatus);
            EnhancedOrganDonorCoversFourthChildObj.put("CoverSI", strSumInsured);
            EnhancedOrganDonorCoversFourthChildObj.put("CoverRate", "0");
            EnhancedOrganDonorCoversFourthChildObj.put("CoverPremium", "0");
            EnhancedOrganDonorCoversFourthChildObj.put("CoverGroups", "Enhanced Organ Donor Expenses");
            FourthChildCoversArray.put(EnhancedOrganDonorCoversFourthChildObj);

            JSONObject PremiumWaiverCoversFourthChildObj = new JSONObject();
            PremiumWaiverCoversFourthChildObj.put("Applicable", PremiumWaiverStatus);
            PremiumWaiverCoversFourthChildObj.put("CoverSI", strSumInsured);
            PremiumWaiverCoversFourthChildObj.put("CoverRate", "0");
            PremiumWaiverCoversFourthChildObj.put("CoverPremium", "0");
            PremiumWaiverCoversFourthChildObj.put("CoverGroups", "Premium Waiver");
            FourthChildCoversArray.put(PremiumWaiverCoversFourthChildObj);

            JSONObject GlobalCoversFourthChildObj = new JSONObject();
            GlobalCoversFourthChildObj.put("Applicable", GlobalCoverStatus);
            GlobalCoversFourthChildObj.put("CoverSI", strSumInsured);
            GlobalCoversFourthChildObj.put("CoverRate", "0");
            GlobalCoversFourthChildObj.put("CoverPremium", "0");
            GlobalCoversFourthChildObj.put("CoverGroups", "Global Cover");
            FourthChildCoversArray.put(GlobalCoversFourthChildObj);


            JSONObject MedicallyAdvisedCoversFourthChildObj = new JSONObject();
            MedicallyAdvisedCoversFourthChildObj.put("Applicable", MedicallyAdvisedStatus);
            MedicallyAdvisedCoversFourthChildObj.put("CoverSI", strSumInsured);
            MedicallyAdvisedCoversFourthChildObj.put("CoverRate", "0");
            MedicallyAdvisedCoversFourthChildObj.put("CoverPremium", "0");
            MedicallyAdvisedCoversFourthChildObj.put("CoverGroups", "Medically Advised Support Devices");
            FourthChildCoversArray.put(MedicallyAdvisedCoversFourthChildObj);

            JSONObject EmergencyCoversFourthChildObj = new JSONObject();
            EmergencyCoversFourthChildObj.put("Applicable", EmergencyAssistanceStatus);
            EmergencyCoversFourthChildObj.put("CoverSI", strSumInsured);
            EmergencyCoversFourthChildObj.put("CoverRate", "0");
            EmergencyCoversFourthChildObj.put("CoverPremium", "0");
            EmergencyCoversFourthChildObj.put("CoverGroups", "Emergency Assistance Service");
            FourthChildCoversArray.put(EmergencyCoversFourthChildObj);

            JSONObject HomeCareTreatmentCoversFourthChildObj = new JSONObject();
            HomeCareTreatmentCoversFourthChildObj.put("Applicable", HomeCareStatus);
            HomeCareTreatmentCoversFourthChildObj.put("CoverSI", strSumInsured);
            HomeCareTreatmentCoversFourthChildObj.put("CoverRate", "0");
            HomeCareTreatmentCoversFourthChildObj.put("CoverPremium", "0");
            HomeCareTreatmentCoversFourthChildObj.put("CoverGroups", "Home Care Treatment");
            FourthChildCoversArray.put(HomeCareTreatmentCoversFourthChildObj);

            JSONObject WellnessBenefitCoversFourthChildObj = new JSONObject();
            WellnessBenefitCoversFourthChildObj.put("Applicable", WellnessBenefitStatus);
            WellnessBenefitCoversFourthChildObj.put("CoverSI", strSumInsured);
            WellnessBenefitCoversFourthChildObj.put("CoverRate", "0");
            WellnessBenefitCoversFourthChildObj.put("CoverPremium", "0");
            WellnessBenefitCoversFourthChildObj.put("CoverGroups", "Wellness Benefit");
            FourthChildCoversArray.put(WellnessBenefitCoversFourthChildObj);

            JSONObject DiseaseManagementCoversFourthChildObj = new JSONObject();
            DiseaseManagementCoversFourthChildObj.put("Applicable", DiseaseManagementStatus);
            DiseaseManagementCoversFourthChildObj.put("CoverSI", strSumInsured);
            DiseaseManagementCoversFourthChildObj.put("CoverRate", "0");
            DiseaseManagementCoversFourthChildObj.put("CoverPremium", "0");
            DiseaseManagementCoversFourthChildObj.put("CoverGroups", "Disease Management Program");
            FourthChildCoversArray.put(DiseaseManagementCoversFourthChildObj);
            CoverDetailsFourthChildObj.put("Covers", FourthChildCoversArray);
            FourthChildObj.put("CoverDetails", CoverDetailsFourthChildObj);

            //Mother
            JSONObject MotherObj = new JSONObject();
            MotherObj.put("InsuredType", "Parent");
            MotherObj.put("FirstName", strMotherEditTextName);
            MotherObj.put("LastName", "");
            MotherObj.put("DOB", strMotherAgeEditText);
            MotherObj.put("Gender", "F");
            MotherObj.put("Relationship", "Mother");
            MotherObj.put("Occupation", strMotherOccupationEdit);
            MotherObj.put("NomineeName", strNomineeName);
            MotherObj.put("NomineeRelationship", strNomineeRelationEdit);

            JSONObject HealthIndicatorsMotherObj = new JSONObject();
            HealthIndicatorsMotherObj.put("PED", "N");
            HealthIndicatorsMotherObj.put("PEDDeclared", "N");
            HealthIndicatorsMotherObj.put("BloodSugarLevel", strBloodSugar);
            HealthIndicatorsMotherObj.put("BloodPressureSystolic", strBloodPressure);
            HealthIndicatorsMotherObj.put("BloodPressureDiastolic", strBloodPressureDiastolic);
            HealthIndicatorsMotherObj.put("CholesterolLevel", strcholesterol);
            HealthIndicatorsMotherObj.put("BodyMassIndex", "30");
            HealthIndicatorsMotherObj.put("TobaccoAndAlcohol", "N");
            HealthIndicatorsMotherObj.put("CoMorbidity", "N");
            MotherObj.put("HealthIndicators", HealthIndicatorsMotherObj);

            JSONObject CoverDetailsMotherObj = new JSONObject();
            JSONArray MotherCoversArray = new JSONArray();
            JSONObject BasicInsuranceCoversMotherObj = new JSONObject();
            BasicInsuranceCoversMotherObj.put("Applicable", BasicStatus);
            BasicInsuranceCoversMotherObj.put("CoverSI", strSumInsured);
            BasicInsuranceCoversMotherObj.put("CoverRate", "0");
            BasicInsuranceCoversMotherObj.put("CoverPremium", "0");
            BasicInsuranceCoversMotherObj.put("CoverGroups", "Basic Insurance Cover");
            MotherCoversArray.put(BasicInsuranceCoversMotherObj);

            JSONObject PersonalAccidentCoversMotherObj = new JSONObject();
            PersonalAccidentCoversMotherObj.put("Applicable", PersonalStatus);
            PersonalAccidentCoversMotherObj.put("CoverSI", strSumInsured);
            PersonalAccidentCoversMotherObj.put("CoverRate", "0");
            PersonalAccidentCoversMotherObj.put("CoverPremium", "0");
            PersonalAccidentCoversMotherObj.put("CoverGroups", "Personal Accident Cover");
            MotherCoversArray.put(PersonalAccidentCoversMotherObj);

            JSONObject CriticalIllnessCoversMotherObj = new JSONObject();
            CriticalIllnessCoversMotherObj.put("Applicable", CriticalStatus);
            CriticalIllnessCoversMotherObj.put("CoverSI", strSumInsured);
            CriticalIllnessCoversMotherObj.put("CoverRate", "0");
            CriticalIllnessCoversMotherObj.put("CoverPremium", "0");
            CriticalIllnessCoversMotherObj.put("CoverGroups", "Critical Illness Cover");
            MotherCoversArray.put(CriticalIllnessCoversMotherObj);


            JSONObject DailyHospitalCoversMotherObj = new JSONObject();
            DailyHospitalCoversMotherObj.put("Applicable", DailyHospitalSatus);
            DailyHospitalCoversMotherObj.put("CoverSI", strSumInsured);
            DailyHospitalCoversMotherObj.put("CoverRate", "0");
            DailyHospitalCoversMotherObj.put("CoverPremium", "0");
            DailyHospitalCoversMotherObj.put("CoverGroups", "Daily Hospital Cash Cover");
            MotherCoversArray.put(DailyHospitalCoversMotherObj);

            JSONObject ModernCoversMotherObj = new JSONObject();
            ModernCoversMotherObj.put("Applicable", ModernTreatmentsStatus);
            ModernCoversMotherObj.put("CoverSI", strSumInsured);
            ModernCoversMotherObj.put("CoverRate", "0");
            ModernCoversMotherObj.put("CoverPremium", "0");
            ModernCoversMotherObj.put("CoverGroups", "Modern Treatments");
            MotherCoversArray.put(ModernCoversMotherObj);
            JSONObject ExtensionPreHospitalizationCoversMotherObj = new JSONObject();
            ExtensionPreHospitalizationCoversMotherObj.put("Applicable", ExtensionPreHospitalization);
            ExtensionPreHospitalizationCoversMotherObj.put("CoverSI", strSumInsured);
            ExtensionPreHospitalizationCoversMotherObj.put("CoverRate", "0");
            ExtensionPreHospitalizationCoversMotherObj.put("CoverPremium", "0");
            ExtensionPreHospitalizationCoversMotherObj.put("CoverGroups", "Extension under Pre-Hospitalization");
            MotherCoversArray.put(ExtensionPreHospitalizationCoversMotherObj);

            JSONObject ExtensionPostHospitalizationCoversMotherObj = new JSONObject();
            ExtensionPostHospitalizationCoversMotherObj.put("Applicable", ExtensionPr0Hospitalization);
            ExtensionPostHospitalizationCoversMotherObj.put("CoverSI", strSumInsured);
            ExtensionPostHospitalizationCoversMotherObj.put("CoverRate", "0");
            ExtensionPostHospitalizationCoversMotherObj.put("CoverPremium", "0");
            ExtensionPostHospitalizationCoversMotherObj.put("CoverGroups", "Extension under Post-Hospitalization");
            MotherCoversArray.put(ExtensionPostHospitalizationCoversMotherObj);


            JSONObject MaternityAndChildcareCoversMotherObj = new JSONObject();
            MaternityAndChildcareCoversMotherObj.put("Applicable", "False");
            MaternityAndChildcareCoversMotherObj.put("CoverSI", strSumInsured);
            MaternityAndChildcareCoversMotherObj.put("CoverRate", "0");
            MaternityAndChildcareCoversMotherObj.put("CoverPremium", "0");
            MaternityAndChildcareCoversMotherObj.put("CoverGroups", "Maternity and Childcare Benefit Waiting Period Modification");
            MotherCoversArray.put(MaternityAndChildcareCoversMotherObj);

            JSONObject CoverageForNonMedicalCoversMotherObj = new JSONObject();
            CoverageForNonMedicalCoversMotherObj.put("Applicable", CoverageNonMedical);
            CoverageForNonMedicalCoversMotherObj.put("CoverSI", strSumInsured);
            CoverageForNonMedicalCoversMotherObj.put("CoverRate", "0");
            CoverageForNonMedicalCoversMotherObj.put("CoverPremium", "0");
            CoverageForNonMedicalCoversMotherObj.put("CoverGroups", "Coverage for Non-Medical Items");
            MotherCoversArray.put(CoverageForNonMedicalCoversMotherObj);

            JSONObject ConditionWaiverCoversMotherObj = new JSONObject();
            ConditionWaiverCoversMotherObj.put("Applicable", ConditionWaiverStatus);
            ConditionWaiverCoversMotherObj.put("CoverSI", strSumInsured);
            ConditionWaiverCoversMotherObj.put("CoverRate", "0");
            ConditionWaiverCoversMotherObj.put("CoverPremium", "0");
            ConditionWaiverCoversMotherObj.put("CoverGroups", "Condition waiver under Restore Benefit");
            MotherCoversArray.put(ConditionWaiverCoversMotherObj);

            JSONObject PreExistingDiseaseCoversMotherObj = new JSONObject();
            PreExistingDiseaseCoversMotherObj.put("Applicable", PreExistingDiseaseStatus);
            PreExistingDiseaseCoversMotherObj.put("CoverSI", strSumInsured);
            PreExistingDiseaseCoversMotherObj.put("CoverRate", "0");
            PreExistingDiseaseCoversMotherObj.put("CoverPremium", "0");
            PreExistingDiseaseCoversMotherObj.put("CoverGroups", "Pre-Existing Disease waiting period");
            MotherCoversArray.put(PreExistingDiseaseCoversMotherObj);

            JSONObject OutpatientDentalWaitingCoversMotherObj = new JSONObject();
            OutpatientDentalWaitingCoversMotherObj.put("Applicable", OutpatientDentalStatus);
            OutpatientDentalWaitingCoversMotherObj.put("CoverSI", strSumInsured);
            OutpatientDentalWaitingCoversMotherObj.put("CoverRate", "0");
            OutpatientDentalWaitingCoversMotherObj.put("CoverPremium", "0");
            OutpatientDentalWaitingCoversMotherObj.put("CoverGroups", "Outpatient Dental Waiting Period Modification");
            MotherCoversArray.put(OutpatientDentalWaitingCoversMotherObj);

            JSONObject EmergencyTravellingAllowanceCoversMotherObj = new JSONObject();
            EmergencyTravellingAllowanceCoversMotherObj.put("Applicable", EmergencyTravellingStatus);
            EmergencyTravellingAllowanceCoversMotherObj.put("CoverSI", strSumInsured);
            EmergencyTravellingAllowanceCoversMotherObj.put("CoverRate", "0");
            EmergencyTravellingAllowanceCoversMotherObj.put("CoverPremium", "0");
            EmergencyTravellingAllowanceCoversMotherObj.put("CoverGroups", "Emergency Travelling Allowance");
            MotherCoversArray.put(EmergencyTravellingAllowanceCoversMotherObj);

            JSONObject SecondOpinionCoversMotherObj = new JSONObject();
            SecondOpinionCoversMotherObj.put("Applicable", SecondOpinionStatus);
            SecondOpinionCoversMotherObj.put("CoverSI", strSumInsured);
            SecondOpinionCoversMotherObj.put("CoverRate", "0");
            SecondOpinionCoversMotherObj.put("CoverPremium", "0");
            SecondOpinionCoversMotherObj.put("CoverGroups", "Second Opinion");
            MotherCoversArray.put(SecondOpinionCoversMotherObj);

            JSONObject RestCureCoversMotherObj = new JSONObject();
            RestCureCoversMotherObj.put("Applicable", RestCureStatus);
            RestCureCoversMotherObj.put("CoverSI", strSumInsured);
            RestCureCoversMotherObj.put("CoverRate", "0");
            RestCureCoversMotherObj.put("CoverPremium", "0");
            RestCureCoversMotherObj.put("CoverGroups", "Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
            MotherCoversArray.put(RestCureCoversMotherObj);

            JSONObject ObesityWeightCoversMotherObj = new JSONObject();
            ObesityWeightCoversMotherObj.put("Applicable", ObesityWeightStatus);
            ObesityWeightCoversMotherObj.put("CoverSI", strSumInsured);
            ObesityWeightCoversMotherObj.put("CoverRate", "0");
            ObesityWeightCoversMotherObj.put("CoverPremium", "0");
            ObesityWeightCoversMotherObj.put("CoverGroups", "Obesity/ Weight Control Expenses Extension");
            MotherCoversArray.put(ObesityWeightCoversMotherObj);

            JSONObject SterilityInfertilityCoversMotherObj = new JSONObject();
            SterilityInfertilityCoversMotherObj.put("Applicable", "False");
            SterilityInfertilityCoversMotherObj.put("CoverSI", strSumInsured);
            SterilityInfertilityCoversMotherObj.put("CoverRate", "0");
            SterilityInfertilityCoversMotherObj.put("CoverPremium", "0");
            SterilityInfertilityCoversMotherObj.put("CoverGroups", "Sterility and Infertility Treatment Expenses Extension");
            MotherCoversArray.put(SterilityInfertilityCoversMotherObj);

            JSONObject EnhancedOrganDonorCoversMotherObj = new JSONObject();
            EnhancedOrganDonorCoversMotherObj.put("Applicable", EnhancedOrganStatus);
            EnhancedOrganDonorCoversMotherObj.put("CoverSI", strSumInsured);
            EnhancedOrganDonorCoversMotherObj.put("CoverRate", "0");
            EnhancedOrganDonorCoversMotherObj.put("CoverPremium", "0");
            EnhancedOrganDonorCoversMotherObj.put("CoverGroups", "Enhanced Organ Donor Expenses");
            MotherCoversArray.put(EnhancedOrganDonorCoversMotherObj);

            JSONObject PremiumWaiverCoversMotherObj = new JSONObject();
            PremiumWaiverCoversMotherObj.put("Applicable", PremiumWaiverStatus);
            PremiumWaiverCoversMotherObj.put("CoverSI", strSumInsured);
            PremiumWaiverCoversMotherObj.put("CoverRate", "0");
            PremiumWaiverCoversMotherObj.put("CoverPremium", "0");
            PremiumWaiverCoversMotherObj.put("CoverGroups", "Premium Waiver");
            MotherCoversArray.put(PremiumWaiverCoversMotherObj);

            JSONObject GlobalCoversMotherObj = new JSONObject();
            GlobalCoversMotherObj.put("Applicable", GlobalCoverStatus);
            GlobalCoversMotherObj.put("CoverSI", strSumInsured);
            GlobalCoversMotherObj.put("CoverRate", "0");
            GlobalCoversMotherObj.put("CoverPremium", "0");
            GlobalCoversMotherObj.put("CoverGroups", "Global Cover");
            MotherCoversArray.put(GlobalCoversMotherObj);


            JSONObject MedicallyAdvisedCoversMotherObj = new JSONObject();
            MedicallyAdvisedCoversMotherObj.put("Applicable", MedicallyAdvisedStatus);
            MedicallyAdvisedCoversMotherObj.put("CoverSI", strSumInsured);
            MedicallyAdvisedCoversMotherObj.put("CoverRate", "0");
            MedicallyAdvisedCoversMotherObj.put("CoverPremium", "0");
            MedicallyAdvisedCoversMotherObj.put("CoverGroups", "Medically Advised Support Devices");
            MotherCoversArray.put(MedicallyAdvisedCoversMotherObj);

            JSONObject EmergencyCoversMotherObj = new JSONObject();
            EmergencyCoversMotherObj.put("Applicable", EmergencyAssistanceStatus);
            EmergencyCoversMotherObj.put("CoverSI", strSumInsured);
            EmergencyCoversMotherObj.put("CoverRate", "0");
            EmergencyCoversMotherObj.put("CoverPremium", "0");
            EmergencyCoversMotherObj.put("CoverGroups", "Emergency Assistance Service");
            MotherCoversArray.put(EmergencyCoversMotherObj);

            JSONObject HomeCareTreatmentCoversMotherObj = new JSONObject();
            HomeCareTreatmentCoversMotherObj.put("Applicable", HomeCareStatus);
            HomeCareTreatmentCoversMotherObj.put("CoverSI", strSumInsured);
            HomeCareTreatmentCoversMotherObj.put("CoverRate", "0");
            HomeCareTreatmentCoversMotherObj.put("CoverPremium", "0");
            HomeCareTreatmentCoversMotherObj.put("CoverGroups", "Home Care Treatment");
            MotherCoversArray.put(HomeCareTreatmentCoversMotherObj);

            JSONObject WellnessBenefitCoversMotherObj = new JSONObject();
            WellnessBenefitCoversMotherObj.put("Applicable", WellnessBenefitStatus);
            WellnessBenefitCoversMotherObj.put("CoverSI", strSumInsured);
            WellnessBenefitCoversMotherObj.put("CoverRate", "0");
            WellnessBenefitCoversMotherObj.put("CoverPremium", "0");
            WellnessBenefitCoversMotherObj.put("CoverGroups", "Wellness Benefit");
            MotherCoversArray.put(WellnessBenefitCoversMotherObj);

            JSONObject DiseaseManagementCoversMotherObj = new JSONObject();
            DiseaseManagementCoversMotherObj.put("Applicable", DiseaseManagementStatus);
            DiseaseManagementCoversMotherObj.put("CoverSI", strSumInsured);
            DiseaseManagementCoversMotherObj.put("CoverRate", "0");
            DiseaseManagementCoversMotherObj.put("CoverPremium", "0");
            DiseaseManagementCoversMotherObj.put("CoverGroups", "Disease Management Program");
            MotherCoversArray.put(DiseaseManagementCoversMotherObj);
            CoverDetailsMotherObj.put("Covers", MotherCoversArray);
            MotherObj.put("CoverDetails", CoverDetailsMotherObj);

            //father
            JSONObject FatherObj = new JSONObject();
            FatherObj.put("InsuredType", "Parent");
            FatherObj.put("FirstName", strFatherEditTextName);
            FatherObj.put("LastName", "");
            FatherObj.put("DOB", strFatherAgeEditText);
            FatherObj.put("Gender", "M");
            FatherObj.put("Relationship", "Father");
            FatherObj.put("Occupation", strFatherOccupationEdit);
            FatherObj.put("NomineeName", strNomineeName);
            FatherObj.put("NomineeRelationship", strNomineeRelationEdit);

            JSONObject HealthIndicatorsFatherObj = new JSONObject();
            HealthIndicatorsFatherObj.put("PED", "N");
            HealthIndicatorsFatherObj.put("PEDDeclared", "N");
            HealthIndicatorsFatherObj.put("BloodSugarLevel", strBloodSugar);
            HealthIndicatorsFatherObj.put("BloodPressureSystolic", strBloodPressure);
            HealthIndicatorsFatherObj.put("BloodPressureDiastolic", strBloodPressureDiastolic);
            HealthIndicatorsFatherObj.put("CholesterolLevel", strcholesterol);
            HealthIndicatorsFatherObj.put("BodyMassIndex", "30");
            HealthIndicatorsFatherObj.put("TobaccoAndAlcohol", "N");
            HealthIndicatorsFatherObj.put("CoMorbidity", "N");
            FatherObj.put("HealthIndicators", HealthIndicatorsFatherObj);

            JSONObject CoverDetailsFatherObj = new JSONObject();
            JSONArray FatherCoversArray = new JSONArray();
            JSONObject BasicInsuranceCoversFatherObj = new JSONObject();
            BasicInsuranceCoversFatherObj.put("Applicable", BasicStatus);
            BasicInsuranceCoversFatherObj.put("CoverSI", strSumInsured);
            BasicInsuranceCoversFatherObj.put("CoverRate", "0");
            BasicInsuranceCoversFatherObj.put("CoverPremium", "0");
            BasicInsuranceCoversFatherObj.put("CoverGroups", "Basic Insurance Cover");
            FatherCoversArray.put(BasicInsuranceCoversFatherObj);

            JSONObject PersonalAccidentCoversFatherObj = new JSONObject();
            PersonalAccidentCoversFatherObj.put("Applicable", PersonalStatus);
            PersonalAccidentCoversFatherObj.put("CoverSI", strSumInsured);
            PersonalAccidentCoversFatherObj.put("CoverRate", "0");
            PersonalAccidentCoversFatherObj.put("CoverPremium", "0");
            PersonalAccidentCoversFatherObj.put("CoverGroups", "Personal Accident Cover");
            FatherCoversArray.put(PersonalAccidentCoversFatherObj);

            JSONObject CriticalIllnessCoversFatherObj = new JSONObject();
            CriticalIllnessCoversFatherObj.put("Applicable", CriticalStatus);
            CriticalIllnessCoversFatherObj.put("CoverSI", strSumInsured);
            CriticalIllnessCoversFatherObj.put("CoverRate", "0");
            CriticalIllnessCoversFatherObj.put("CoverPremium", "0");
            CriticalIllnessCoversFatherObj.put("CoverGroups", "Critical Illness Cover");
            FatherCoversArray.put(CriticalIllnessCoversFatherObj);


            JSONObject DailyHospitalCoversFatherObj = new JSONObject();
            DailyHospitalCoversFatherObj.put("Applicable", DailyHospitalSatus);
            DailyHospitalCoversFatherObj.put("CoverSI", strSumInsured);
            DailyHospitalCoversFatherObj.put("CoverRate", "0");
            DailyHospitalCoversFatherObj.put("CoverPremium", "0");
            DailyHospitalCoversFatherObj.put("CoverGroups", "Daily Hospital Cash Cover");
            FatherCoversArray.put(DailyHospitalCoversFatherObj);

            JSONObject ModernCoversFatherObj = new JSONObject();
            ModernCoversFatherObj.put("Applicable", ModernTreatmentsStatus);
            ModernCoversFatherObj.put("CoverSI", strSumInsured);
            ModernCoversFatherObj.put("CoverRate", "0");
            ModernCoversFatherObj.put("CoverPremium", "0");
            ModernCoversFatherObj.put("CoverGroups", "Modern Treatments");
            FatherCoversArray.put(ModernCoversFatherObj);
            JSONObject ExtensionPreHospitalizationCoversFatherObj = new JSONObject();
            ExtensionPreHospitalizationCoversFatherObj.put("Applicable", ExtensionPreHospitalization);
            ExtensionPreHospitalizationCoversFatherObj.put("CoverSI", strSumInsured);
            ExtensionPreHospitalizationCoversFatherObj.put("CoverRate", "0");
            ExtensionPreHospitalizationCoversFatherObj.put("CoverPremium", "0");
            ExtensionPreHospitalizationCoversFatherObj.put("CoverGroups", "Extension under Pre-Hospitalization");
            FatherCoversArray.put(ExtensionPreHospitalizationCoversFatherObj);

            JSONObject ExtensionPostHospitalizationCoversFatherObj = new JSONObject();
            ExtensionPostHospitalizationCoversFatherObj.put("Applicable", ExtensionPr0Hospitalization);
            ExtensionPostHospitalizationCoversFatherObj.put("CoverSI", strSumInsured);
            ExtensionPostHospitalizationCoversFatherObj.put("CoverRate", "0");
            ExtensionPostHospitalizationCoversFatherObj.put("CoverPremium", "0");
            ExtensionPostHospitalizationCoversFatherObj.put("CoverGroups", "Extension under Post-Hospitalization");
            FatherCoversArray.put(ExtensionPostHospitalizationCoversFatherObj);


            JSONObject MaternityAndChildcareCoversFatherObj = new JSONObject();
            MaternityAndChildcareCoversFatherObj.put("Applicable", "False");
            MaternityAndChildcareCoversFatherObj.put("CoverSI", strSumInsured);
            MaternityAndChildcareCoversFatherObj.put("CoverRate", "0");
            MaternityAndChildcareCoversFatherObj.put("CoverPremium", "0");
            MaternityAndChildcareCoversFatherObj.put("CoverGroups", "Maternity and Childcare Benefit Waiting Period Modification");
            FatherCoversArray.put(MaternityAndChildcareCoversFatherObj);

            JSONObject CoverageForNonMedicalCoversFatherObj = new JSONObject();
            CoverageForNonMedicalCoversFatherObj.put("Applicable", CoverageNonMedical);
            CoverageForNonMedicalCoversFatherObj.put("CoverSI", strSumInsured);
            CoverageForNonMedicalCoversFatherObj.put("CoverRate", "0");
            CoverageForNonMedicalCoversFatherObj.put("CoverPremium", "0");
            CoverageForNonMedicalCoversFatherObj.put("CoverGroups", "Coverage for Non-Medical Items");
            FatherCoversArray.put(CoverageForNonMedicalCoversFatherObj);

            JSONObject ConditionWaiverCoversFatherObj = new JSONObject();
            ConditionWaiverCoversFatherObj.put("Applicable", ConditionWaiverStatus);
            ConditionWaiverCoversFatherObj.put("CoverSI", strSumInsured);
            ConditionWaiverCoversFatherObj.put("CoverRate", "0");
            ConditionWaiverCoversFatherObj.put("CoverPremium", "0");
            ConditionWaiverCoversFatherObj.put("CoverGroups", "Condition waiver under Restore Benefit");
            FatherCoversArray.put(ConditionWaiverCoversFatherObj);

            JSONObject PreExistingDiseaseCoversFatherObj = new JSONObject();
            PreExistingDiseaseCoversFatherObj.put("Applicable", PreExistingDiseaseStatus);
            PreExistingDiseaseCoversFatherObj.put("CoverSI", strSumInsured);
            PreExistingDiseaseCoversFatherObj.put("CoverRate", "0");
            PreExistingDiseaseCoversFatherObj.put("CoverPremium", "0");
            PreExistingDiseaseCoversFatherObj.put("CoverGroups", "Pre-Existing Disease waiting period");
            FatherCoversArray.put(PreExistingDiseaseCoversFatherObj);

            JSONObject OutpatientDentalWaitingCoversFatherObj = new JSONObject();
            OutpatientDentalWaitingCoversFatherObj.put("Applicable", OutpatientDentalStatus);
            OutpatientDentalWaitingCoversFatherObj.put("CoverSI", strSumInsured);
            OutpatientDentalWaitingCoversFatherObj.put("CoverRate", "0");
            OutpatientDentalWaitingCoversFatherObj.put("CoverPremium", "0");
            OutpatientDentalWaitingCoversFatherObj.put("CoverGroups", "Outpatient Dental Waiting Period Modification");
            FatherCoversArray.put(OutpatientDentalWaitingCoversFatherObj);

            JSONObject EmergencyTravellingAllowanceCoversFatherObj = new JSONObject();
            EmergencyTravellingAllowanceCoversFatherObj.put("Applicable", EmergencyTravellingStatus);
            EmergencyTravellingAllowanceCoversFatherObj.put("CoverSI", strSumInsured);
            EmergencyTravellingAllowanceCoversFatherObj.put("CoverRate", "0");
            EmergencyTravellingAllowanceCoversFatherObj.put("CoverPremium", "0");
            EmergencyTravellingAllowanceCoversFatherObj.put("CoverGroups", "Emergency Travelling Allowance");
            FatherCoversArray.put(EmergencyTravellingAllowanceCoversFatherObj);

            JSONObject SecondOpinionCoversFatherObj = new JSONObject();
            SecondOpinionCoversFatherObj.put("Applicable", SecondOpinionStatus);
            SecondOpinionCoversFatherObj.put("CoverSI", strSumInsured);
            SecondOpinionCoversFatherObj.put("CoverRate", "0");
            SecondOpinionCoversFatherObj.put("CoverPremium", "0");
            SecondOpinionCoversFatherObj.put("CoverGroups", "Second Opinion");
            FatherCoversArray.put(SecondOpinionCoversFatherObj);

            JSONObject RestCureCoversFatherObj = new JSONObject();
            RestCureCoversFatherObj.put("Applicable", RestCureStatus);
            RestCureCoversFatherObj.put("CoverSI", strSumInsured);
            RestCureCoversFatherObj.put("CoverRate", "0");
            RestCureCoversFatherObj.put("CoverPremium", "0");
            RestCureCoversFatherObj.put("CoverGroups", "Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
            FatherCoversArray.put(RestCureCoversFatherObj);

            JSONObject ObesityWeightCoversFatherObj = new JSONObject();
            ObesityWeightCoversFatherObj.put("Applicable", ObesityWeightStatus);
            ObesityWeightCoversFatherObj.put("CoverSI", strSumInsured);
            ObesityWeightCoversFatherObj.put("CoverRate", "0");
            ObesityWeightCoversFatherObj.put("CoverPremium", "0");
            ObesityWeightCoversFatherObj.put("CoverGroups", "Obesity/ Weight Control Expenses Extension");
            FatherCoversArray.put(ObesityWeightCoversFatherObj);

            JSONObject SterilityInfertilityCoversFatherObj = new JSONObject();
            SterilityInfertilityCoversFatherObj.put("Applicable", "False");
            SterilityInfertilityCoversFatherObj.put("CoverSI", strSumInsured);
            SterilityInfertilityCoversFatherObj.put("CoverRate", "0");
            SterilityInfertilityCoversFatherObj.put("CoverPremium", "0");
            SterilityInfertilityCoversFatherObj.put("CoverGroups", "Sterility and Infertility Treatment Expenses Extension");
            FatherCoversArray.put(SterilityInfertilityCoversFatherObj);

            JSONObject EnhancedOrganDonorCoversFatherObj = new JSONObject();
            EnhancedOrganDonorCoversFatherObj.put("Applicable", EnhancedOrganStatus);
            EnhancedOrganDonorCoversFatherObj.put("CoverSI", strSumInsured);
            EnhancedOrganDonorCoversFatherObj.put("CoverRate", "0");
            EnhancedOrganDonorCoversFatherObj.put("CoverPremium", "0");
            EnhancedOrganDonorCoversFatherObj.put("CoverGroups", "Enhanced Organ Donor Expenses");
            FatherCoversArray.put(EnhancedOrganDonorCoversFatherObj);

            JSONObject PremiumWaiverCoversFatherObj = new JSONObject();
            PremiumWaiverCoversFatherObj.put("Applicable", PremiumWaiverStatus);
            PremiumWaiverCoversFatherObj.put("CoverSI", strSumInsured);
            PremiumWaiverCoversFatherObj.put("CoverRate", "0");
            PremiumWaiverCoversFatherObj.put("CoverPremium", "0");
            PremiumWaiverCoversFatherObj.put("CoverGroups", "Premium Waiver");
            FatherCoversArray.put(PremiumWaiverCoversFatherObj);

            JSONObject GlobalCoversFatherObj = new JSONObject();
            GlobalCoversFatherObj.put("Applicable", GlobalCoverStatus);
            GlobalCoversFatherObj.put("CoverSI", strSumInsured);
            GlobalCoversFatherObj.put("CoverRate", "0");
            GlobalCoversFatherObj.put("CoverPremium", "0");
            GlobalCoversFatherObj.put("CoverGroups", "Global Cover");
            FatherCoversArray.put(GlobalCoversFatherObj);


            JSONObject MedicallyAdvisedCoversFatherObj = new JSONObject();
            MedicallyAdvisedCoversFatherObj.put("Applicable", MedicallyAdvisedStatus);
            MedicallyAdvisedCoversFatherObj.put("CoverSI", strSumInsured);
            MedicallyAdvisedCoversFatherObj.put("CoverRate", "0");
            MedicallyAdvisedCoversFatherObj.put("CoverPremium", "0");
            MedicallyAdvisedCoversFatherObj.put("CoverGroups", "Medically Advised Support Devices");
            FatherCoversArray.put(MedicallyAdvisedCoversFatherObj);

            JSONObject EmergencyCoversFatherObj = new JSONObject();
            EmergencyCoversFatherObj.put("Applicable", EmergencyAssistanceStatus);
            EmergencyCoversFatherObj.put("CoverSI", strSumInsured);
            EmergencyCoversFatherObj.put("CoverRate", "0");
            EmergencyCoversFatherObj.put("CoverPremium", "0");
            EmergencyCoversFatherObj.put("CoverGroups", "Emergency Assistance Service");
            FatherCoversArray.put(EmergencyCoversFatherObj);

            JSONObject HomeCareTreatmentCoversFatherObj = new JSONObject();
            HomeCareTreatmentCoversFatherObj.put("Applicable", HomeCareStatus);
            HomeCareTreatmentCoversFatherObj.put("CoverSI", strSumInsured);
            HomeCareTreatmentCoversFatherObj.put("CoverRate", "0");
            HomeCareTreatmentCoversFatherObj.put("CoverPremium", "0");
            HomeCareTreatmentCoversFatherObj.put("CoverGroups", "Home Care Treatment");
            FatherCoversArray.put(HomeCareTreatmentCoversFatherObj);

            JSONObject WellnessBenefitCoversFatherObj = new JSONObject();
            WellnessBenefitCoversFatherObj.put("Applicable", WellnessBenefitStatus);
            WellnessBenefitCoversFatherObj.put("CoverSI", strSumInsured);
            WellnessBenefitCoversFatherObj.put("CoverRate", "0");
            WellnessBenefitCoversFatherObj.put("CoverPremium", "0");
            WellnessBenefitCoversFatherObj.put("CoverGroups", "Wellness Benefit");
            FatherCoversArray.put(WellnessBenefitCoversFatherObj);

            JSONObject DiseaseManagementCoversFatherObj = new JSONObject();
            DiseaseManagementCoversFatherObj.put("Applicable", DiseaseManagementStatus);
            DiseaseManagementCoversFatherObj.put("CoverSI", strSumInsured);
            DiseaseManagementCoversFatherObj.put("CoverRate", "0");
            DiseaseManagementCoversFatherObj.put("CoverPremium", "0");
            DiseaseManagementCoversFatherObj.put("CoverGroups", "Disease Management Program");
            FatherCoversArray.put(DiseaseManagementCoversFatherObj);
            CoverDetailsFatherObj.put("Covers", FatherCoversArray);
            FatherObj.put("CoverDetails", CoverDetailsFatherObj);

            //motherLaw
            JSONObject MotherLawObj = new JSONObject();
            MotherLawObj.put("InsuredType", "Parent");
            MotherLawObj.put("FirstName", strMotherEditTextName);
            MotherLawObj.put("LastName", "");
            MotherLawObj.put("DOB", strMotherLawEditText);
            MotherLawObj.put("Gender", "F");
            MotherLawObj.put("Relationship", "Mother-In-Law");
            MotherLawObj.put("Occupation", strOccupationEditMotherLaw);
            MotherLawObj.put("NomineeName", strNomineeName);
            MotherLawObj.put("NomineeRelationship", strNomineeRelationEdit);

            JSONObject HealthIndicatorsMotherLawObj = new JSONObject();
            HealthIndicatorsMotherLawObj.put("PED", "N");
            HealthIndicatorsMotherLawObj.put("PEDDeclared", "N");
            HealthIndicatorsMotherLawObj.put("BloodSugarLevel", strBloodSugar);
            HealthIndicatorsMotherLawObj.put("BloodPressureSystolic", strBloodPressure);
            HealthIndicatorsMotherLawObj.put("BloodPressureDiastolic", strBloodPressureDiastolic);
            HealthIndicatorsMotherLawObj.put("CholesterolLevel", strcholesterol);
            HealthIndicatorsMotherLawObj.put("BodyMassIndex", "30");
            HealthIndicatorsMotherLawObj.put("TobaccoAndAlcohol", "N");
            HealthIndicatorsMotherLawObj.put("CoMorbidity", "N");
            MotherLawObj.put("HealthIndicators", HealthIndicatorsMotherLawObj);

            JSONObject CoverDetailsMotherLawObj = new JSONObject();
            JSONArray MotherLawCoversArray = new JSONArray();
            JSONObject BasicInsuranceCoversMotherLawObj = new JSONObject();
            BasicInsuranceCoversMotherLawObj.put("Applicable", BasicStatus);
            BasicInsuranceCoversMotherLawObj.put("CoverSI", strSumInsured);
            BasicInsuranceCoversMotherLawObj.put("CoverRate", "0");
            BasicInsuranceCoversMotherLawObj.put("CoverPremium", "0");
            BasicInsuranceCoversMotherLawObj.put("CoverGroups", "Basic Insurance Cover");
            MotherLawCoversArray.put(BasicInsuranceCoversMotherLawObj);

            JSONObject PersonalAccidentCoversMotherLawObj = new JSONObject();
            PersonalAccidentCoversMotherLawObj.put("Applicable", PersonalStatus);
            PersonalAccidentCoversMotherLawObj.put("CoverSI", strSumInsured);
            PersonalAccidentCoversMotherLawObj.put("CoverRate", "0");
            PersonalAccidentCoversMotherLawObj.put("CoverPremium", "0");
            PersonalAccidentCoversMotherLawObj.put("CoverGroups", "Personal Accident Cover");
            MotherLawCoversArray.put(PersonalAccidentCoversMotherLawObj);

            JSONObject CriticalIllnessCoversMotherLawObj = new JSONObject();
            CriticalIllnessCoversMotherLawObj.put("Applicable", CriticalStatus);
            CriticalIllnessCoversMotherLawObj.put("CoverSI", strSumInsured);
            CriticalIllnessCoversMotherLawObj.put("CoverRate", "0");
            CriticalIllnessCoversMotherLawObj.put("CoverPremium", "0");
            CriticalIllnessCoversMotherLawObj.put("CoverGroups", "Critical Illness Cover");
            MotherLawCoversArray.put(CriticalIllnessCoversMotherLawObj);


            JSONObject DailyHospitalCoversMotherLawObj = new JSONObject();
            DailyHospitalCoversMotherLawObj.put("Applicable", DailyHospitalSatus);
            DailyHospitalCoversMotherLawObj.put("CoverSI", strSumInsured);
            DailyHospitalCoversMotherLawObj.put("CoverRate", "0");
            DailyHospitalCoversMotherLawObj.put("CoverPremium", "0");
            DailyHospitalCoversMotherLawObj.put("CoverGroups", "Daily Hospital Cash Cover");
            MotherLawCoversArray.put(DailyHospitalCoversMotherLawObj);

            JSONObject ModernCoversMotherLawObj = new JSONObject();
            ModernCoversMotherLawObj.put("Applicable", ModernTreatmentsStatus);
            ModernCoversMotherLawObj.put("CoverSI", strSumInsured);
            ModernCoversMotherLawObj.put("CoverRate", "0");
            ModernCoversMotherLawObj.put("CoverPremium", "0");
            ModernCoversMotherLawObj.put("CoverGroups", "Modern Treatments");
            MotherLawCoversArray.put(ModernCoversMotherLawObj);
            JSONObject ExtensionPreHospitalizationCoversMotherLawObj = new JSONObject();
            ExtensionPreHospitalizationCoversMotherLawObj.put("Applicable", ExtensionPreHospitalization);
            ExtensionPreHospitalizationCoversMotherLawObj.put("CoverSI", strSumInsured);
            ExtensionPreHospitalizationCoversMotherLawObj.put("CoverRate", "0");
            ExtensionPreHospitalizationCoversMotherLawObj.put("CoverPremium", "0");
            ExtensionPreHospitalizationCoversMotherLawObj.put("CoverGroups", "Extension under Pre-Hospitalization");
            MotherLawCoversArray.put(ExtensionPreHospitalizationCoversMotherLawObj);

            JSONObject ExtensionPostHospitalizationCoversMotherLawObj = new JSONObject();
            ExtensionPostHospitalizationCoversMotherLawObj.put("Applicable", ExtensionPr0Hospitalization);
            ExtensionPostHospitalizationCoversMotherLawObj.put("CoverSI", strSumInsured);
            ExtensionPostHospitalizationCoversMotherLawObj.put("CoverRate", "0");
            ExtensionPostHospitalizationCoversMotherLawObj.put("CoverPremium", "0");
            ExtensionPostHospitalizationCoversMotherLawObj.put("CoverGroups", "Extension under Post-Hospitalization");
            MotherLawCoversArray.put(ExtensionPostHospitalizationCoversMotherLawObj);


            JSONObject MaternityAndChildcareCoversMotherLawObj = new JSONObject();
            MaternityAndChildcareCoversMotherLawObj.put("Applicable", "False");
            MaternityAndChildcareCoversMotherLawObj.put("CoverSI", strSumInsured);
            MaternityAndChildcareCoversMotherLawObj.put("CoverRate", "0");
            MaternityAndChildcareCoversMotherLawObj.put("CoverPremium", "0");
            MaternityAndChildcareCoversMotherLawObj.put("CoverGroups", "Maternity and Childcare Benefit Waiting Period Modification");
            MotherLawCoversArray.put(MaternityAndChildcareCoversMotherLawObj);

            JSONObject CoverageForNonMedicalCoversMotherLawObj = new JSONObject();
            CoverageForNonMedicalCoversMotherLawObj.put("Applicable", CoverageNonMedical);
            CoverageForNonMedicalCoversMotherLawObj.put("CoverSI", strSumInsured);
            CoverageForNonMedicalCoversMotherLawObj.put("CoverRate", "0");
            CoverageForNonMedicalCoversMotherLawObj.put("CoverPremium", "0");
            CoverageForNonMedicalCoversMotherLawObj.put("CoverGroups", "Coverage for Non-Medical Items");
            MotherLawCoversArray.put(CoverageForNonMedicalCoversMotherLawObj);

            JSONObject ConditionWaiverCoversMotherLawObj = new JSONObject();
            ConditionWaiverCoversMotherLawObj.put("Applicable", ConditionWaiverStatus);
            ConditionWaiverCoversMotherLawObj.put("CoverSI", strSumInsured);
            ConditionWaiverCoversMotherLawObj.put("CoverRate", "0");
            ConditionWaiverCoversMotherLawObj.put("CoverPremium", "0");
            ConditionWaiverCoversMotherLawObj.put("CoverGroups", "Condition waiver under Restore Benefit");
            MotherLawCoversArray.put(ConditionWaiverCoversMotherLawObj);

            JSONObject PreExistingDiseaseCoversMotherLawObj = new JSONObject();
            PreExistingDiseaseCoversMotherLawObj.put("Applicable", PreExistingDiseaseStatus);
            PreExistingDiseaseCoversMotherLawObj.put("CoverSI", strSumInsured);
            PreExistingDiseaseCoversMotherLawObj.put("CoverRate", "0");
            PreExistingDiseaseCoversMotherLawObj.put("CoverPremium", "0");
            PreExistingDiseaseCoversMotherLawObj.put("CoverGroups", "Pre-Existing Disease waiting period");
            MotherLawCoversArray.put(PreExistingDiseaseCoversMotherLawObj);

            JSONObject OutpatientDentalWaitingCoversMotherLawObj = new JSONObject();
            OutpatientDentalWaitingCoversMotherLawObj.put("Applicable", OutpatientDentalStatus);
            OutpatientDentalWaitingCoversMotherLawObj.put("CoverSI", strSumInsured);
            OutpatientDentalWaitingCoversMotherLawObj.put("CoverRate", "0");
            OutpatientDentalWaitingCoversMotherLawObj.put("CoverPremium", "0");
            OutpatientDentalWaitingCoversMotherLawObj.put("CoverGroups", "Outpatient Dental Waiting Period Modification");
            MotherLawCoversArray.put(OutpatientDentalWaitingCoversMotherLawObj);

            JSONObject EmergencyTravellingAllowanceCoversMotherLawObj = new JSONObject();
            EmergencyTravellingAllowanceCoversMotherLawObj.put("Applicable", EmergencyTravellingStatus);
            EmergencyTravellingAllowanceCoversMotherLawObj.put("CoverSI", strSumInsured);
            EmergencyTravellingAllowanceCoversMotherLawObj.put("CoverRate", "0");
            EmergencyTravellingAllowanceCoversMotherLawObj.put("CoverPremium", "0");
            EmergencyTravellingAllowanceCoversMotherLawObj.put("CoverGroups", "Emergency Travelling Allowance");
            MotherLawCoversArray.put(EmergencyTravellingAllowanceCoversMotherLawObj);

            JSONObject SecondOpinionCoversMotherLawObj = new JSONObject();
            SecondOpinionCoversMotherLawObj.put("Applicable", SecondOpinionStatus);
            SecondOpinionCoversMotherLawObj.put("CoverSI", strSumInsured);
            SecondOpinionCoversMotherLawObj.put("CoverRate", "0");
            SecondOpinionCoversMotherLawObj.put("CoverPremium", "0");
            SecondOpinionCoversMotherLawObj.put("CoverGroups", "Second Opinion");
            MotherLawCoversArray.put(SecondOpinionCoversMotherLawObj);

            JSONObject RestCureCoversMotherLawObj = new JSONObject();
            RestCureCoversMotherLawObj.put("Applicable", RestCureStatus);
            RestCureCoversMotherLawObj.put("CoverSI", strSumInsured);
            RestCureCoversMotherLawObj.put("CoverRate", "0");
            RestCureCoversMotherLawObj.put("CoverPremium", "0");
            RestCureCoversMotherLawObj.put("CoverGroups", "Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
            MotherLawCoversArray.put(RestCureCoversMotherLawObj);

            JSONObject ObesityWeightCoversMotherLawObj = new JSONObject();
            ObesityWeightCoversMotherLawObj.put("Applicable", ObesityWeightStatus);
            ObesityWeightCoversMotherLawObj.put("CoverSI", strSumInsured);
            ObesityWeightCoversMotherLawObj.put("CoverRate", "0");
            ObesityWeightCoversMotherLawObj.put("CoverPremium", "0");
            ObesityWeightCoversMotherLawObj.put("CoverGroups", "Obesity/ Weight Control Expenses Extension");
            MotherLawCoversArray.put(ObesityWeightCoversMotherLawObj);

            JSONObject SterilityInfertilityCoversMotherLawObj = new JSONObject();
            SterilityInfertilityCoversMotherLawObj.put("Applicable", "False");
            SterilityInfertilityCoversMotherLawObj.put("CoverSI", strSumInsured);
            SterilityInfertilityCoversMotherLawObj.put("CoverRate", "0");
            SterilityInfertilityCoversMotherLawObj.put("CoverPremium", "0");
            SterilityInfertilityCoversMotherLawObj.put("CoverGroups", "Sterility and Infertility Treatment Expenses Extension");
            MotherLawCoversArray.put(SterilityInfertilityCoversMotherLawObj);

            JSONObject EnhancedOrganDonorCoversMotherLawObj = new JSONObject();
            EnhancedOrganDonorCoversMotherLawObj.put("Applicable", EnhancedOrganStatus);
            EnhancedOrganDonorCoversMotherLawObj.put("CoverSI", strSumInsured);
            EnhancedOrganDonorCoversMotherLawObj.put("CoverRate", "0");
            EnhancedOrganDonorCoversMotherLawObj.put("CoverPremium", "0");
            EnhancedOrganDonorCoversMotherLawObj.put("CoverGroups", "Enhanced Organ Donor Expenses");
            MotherLawCoversArray.put(EnhancedOrganDonorCoversMotherLawObj);

            JSONObject PremiumWaiverCoversMotherLawObj = new JSONObject();
            PremiumWaiverCoversMotherLawObj.put("Applicable", PremiumWaiverStatus);
            PremiumWaiverCoversMotherLawObj.put("CoverSI", strSumInsured);
            PremiumWaiverCoversMotherLawObj.put("CoverRate", "0");
            PremiumWaiverCoversMotherLawObj.put("CoverPremium", "0");
            PremiumWaiverCoversMotherLawObj.put("CoverGroups", "Premium Waiver");
            MotherLawCoversArray.put(PremiumWaiverCoversMotherLawObj);

            JSONObject GlobalCoversMotherLawObj = new JSONObject();
            GlobalCoversMotherLawObj.put("Applicable", GlobalCoverStatus);
            GlobalCoversMotherLawObj.put("CoverSI", strSumInsured);
            GlobalCoversMotherLawObj.put("CoverRate", "0");
            GlobalCoversMotherLawObj.put("CoverPremium", "0");
            GlobalCoversMotherLawObj.put("CoverGroups", "Global Cover");
            MotherLawCoversArray.put(GlobalCoversMotherLawObj);


            JSONObject MedicallyAdvisedCoversMotherLawObj = new JSONObject();
            MedicallyAdvisedCoversMotherLawObj.put("Applicable", MedicallyAdvisedStatus);
            MedicallyAdvisedCoversMotherLawObj.put("CoverSI", strSumInsured);
            MedicallyAdvisedCoversMotherLawObj.put("CoverRate", "0");
            MedicallyAdvisedCoversMotherLawObj.put("CoverPremium", "0");
            MedicallyAdvisedCoversMotherLawObj.put("CoverGroups", "Medically Advised Support Devices");
            MotherLawCoversArray.put(MedicallyAdvisedCoversMotherLawObj);

            JSONObject EmergencyCoversMotherLawObj = new JSONObject();
            EmergencyCoversMotherLawObj.put("Applicable", EmergencyAssistanceStatus);
            EmergencyCoversMotherLawObj.put("CoverSI", strSumInsured);
            EmergencyCoversMotherLawObj.put("CoverRate", "0");
            EmergencyCoversMotherLawObj.put("CoverPremium", "0");
            EmergencyCoversMotherLawObj.put("CoverGroups", "Emergency Assistance Service");
            MotherLawCoversArray.put(EmergencyCoversMotherLawObj);

            JSONObject HomeCareTreatmentCoversMotherLawObj = new JSONObject();
            HomeCareTreatmentCoversMotherLawObj.put("Applicable", HomeCareStatus);
            HomeCareTreatmentCoversMotherLawObj.put("CoverSI", strSumInsured);
            HomeCareTreatmentCoversMotherLawObj.put("CoverRate", "0");
            HomeCareTreatmentCoversMotherLawObj.put("CoverPremium", "0");
            HomeCareTreatmentCoversMotherLawObj.put("CoverGroups", "Home Care Treatment");
            MotherLawCoversArray.put(HomeCareTreatmentCoversMotherLawObj);

            JSONObject WellnessBenefitCoversMotherLawObj = new JSONObject();
            WellnessBenefitCoversMotherLawObj.put("Applicable", WellnessBenefitStatus);
            WellnessBenefitCoversMotherLawObj.put("CoverSI", strSumInsured);
            WellnessBenefitCoversMotherLawObj.put("CoverRate", "0");
            WellnessBenefitCoversMotherLawObj.put("CoverPremium", "0");
            WellnessBenefitCoversMotherLawObj.put("CoverGroups", "Wellness Benefit");
            MotherLawCoversArray.put(WellnessBenefitCoversMotherLawObj);

            JSONObject DiseaseManagementCoversMotherLawObj = new JSONObject();
            DiseaseManagementCoversMotherLawObj.put("Applicable", DiseaseManagementStatus);
            DiseaseManagementCoversMotherLawObj.put("CoverSI", strSumInsured);
            DiseaseManagementCoversMotherLawObj.put("CoverRate", "0");
            DiseaseManagementCoversMotherLawObj.put("CoverPremium", "0");
            DiseaseManagementCoversMotherLawObj.put("CoverGroups", "Disease Management Program");
            MotherLawCoversArray.put(DiseaseManagementCoversMotherLawObj);
            CoverDetailsMotherLawObj.put("Covers", MotherLawCoversArray);
            MotherLawObj.put("CoverDetails", CoverDetailsMotherLawObj);

            //FatherLaw
            JSONObject FatherLawObj = new JSONObject();
            FatherLawObj.put("InsuredType", "Parent");
            FatherLawObj.put("FirstName", strFatherEditTextName);
            FatherLawObj.put("LastName", "");
            FatherLawObj.put("DOB", strFatherLawAgeEditText);
            FatherLawObj.put("Gender", "M");
            FatherLawObj.put("Relationship", "Father-In-Law");
            FatherLawObj.put("Occupation", strOccupationFatherLawEdit);
            FatherLawObj.put("NomineeName", strNomineeName);
            FatherLawObj.put("NomineeRelationship", strNomineeRelationEdit);

            JSONObject HealthIndicatorsFatherLawObj = new JSONObject();
            HealthIndicatorsFatherLawObj.put("PED", "N");
            HealthIndicatorsFatherLawObj.put("PEDDeclared", "N");
            HealthIndicatorsFatherLawObj.put("BloodSugarLevel", strBloodSugar);
            HealthIndicatorsFatherLawObj.put("BloodPressureSystolic", strBloodPressure);
            HealthIndicatorsFatherLawObj.put("BloodPressureDiastolic", strBloodPressureDiastolic);
            HealthIndicatorsFatherLawObj.put("CholesterolLevel", strcholesterol);
            HealthIndicatorsFatherLawObj.put("BodyMassIndex", "30");
            HealthIndicatorsFatherLawObj.put("TobaccoAndAlcohol", "N");
            HealthIndicatorsFatherLawObj.put("CoMorbidity", "N");
            FatherLawObj.put("HealthIndicators", HealthIndicatorsFatherLawObj);

            JSONObject CoverDetailsFatherLawObj = new JSONObject();
            JSONArray FatherLawCoversArray = new JSONArray();
            JSONObject BasicInsuranceCoversFatherLawObj = new JSONObject();
            BasicInsuranceCoversFatherLawObj.put("Applicable", BasicStatus);
            BasicInsuranceCoversFatherLawObj.put("CoverSI", strSumInsured);
            BasicInsuranceCoversFatherLawObj.put("CoverRate", "0");
            BasicInsuranceCoversFatherLawObj.put("CoverPremium", "0");
            BasicInsuranceCoversFatherLawObj.put("CoverGroups", "Basic Insurance Cover");
            FatherLawCoversArray.put(BasicInsuranceCoversFatherLawObj);

            JSONObject PersonalAccidentCoversFatherLawObj = new JSONObject();
            PersonalAccidentCoversFatherLawObj.put("Applicable", PersonalStatus);
            PersonalAccidentCoversFatherLawObj.put("CoverSI", strSumInsured);
            PersonalAccidentCoversFatherLawObj.put("CoverRate", "0");
            PersonalAccidentCoversFatherLawObj.put("CoverPremium", "0");
            PersonalAccidentCoversFatherLawObj.put("CoverGroups", "Personal Accident Cover");
            FatherLawCoversArray.put(PersonalAccidentCoversFatherLawObj);

            JSONObject CriticalIllnessCoversFatherLawObj = new JSONObject();
            CriticalIllnessCoversFatherLawObj.put("Applicable", CriticalStatus);
            CriticalIllnessCoversFatherLawObj.put("CoverSI", strSumInsured);
            CriticalIllnessCoversFatherLawObj.put("CoverRate", "0");
            CriticalIllnessCoversFatherLawObj.put("CoverPremium", "0");
            CriticalIllnessCoversFatherLawObj.put("CoverGroups", "Critical Illness Cover");
            FatherLawCoversArray.put(CriticalIllnessCoversFatherLawObj);


            JSONObject DailyHospitalCoversFatherLawObj = new JSONObject();
            DailyHospitalCoversFatherLawObj.put("Applicable", DailyHospitalSatus);
            DailyHospitalCoversFatherLawObj.put("CoverSI", strSumInsured);
            DailyHospitalCoversFatherLawObj.put("CoverRate", "0");
            DailyHospitalCoversFatherLawObj.put("CoverPremium", "0");
            DailyHospitalCoversFatherLawObj.put("CoverGroups", "Daily Hospital Cash Cover");
            FatherLawCoversArray.put(DailyHospitalCoversFatherLawObj);

            JSONObject ModernCoversFatherLawObj = new JSONObject();
            ModernCoversFatherLawObj.put("Applicable", ModernTreatmentsStatus);
            ModernCoversFatherLawObj.put("CoverSI", strSumInsured);
            ModernCoversFatherLawObj.put("CoverRate", "0");
            ModernCoversFatherLawObj.put("CoverPremium", "0");
            ModernCoversFatherLawObj.put("CoverGroups", "Modern Treatments");
            FatherLawCoversArray.put(ModernCoversFatherLawObj);
            JSONObject ExtensionPreHospitalizationCoversFatherLawObj = new JSONObject();
            ExtensionPreHospitalizationCoversFatherLawObj.put("Applicable", ExtensionPreHospitalization);
            ExtensionPreHospitalizationCoversFatherLawObj.put("CoverSI", strSumInsured);
            ExtensionPreHospitalizationCoversFatherLawObj.put("CoverRate", "0");
            ExtensionPreHospitalizationCoversFatherLawObj.put("CoverPremium", "0");
            ExtensionPreHospitalizationCoversFatherLawObj.put("CoverGroups", "Extension under Pre-Hospitalization");
            FatherLawCoversArray.put(ExtensionPreHospitalizationCoversFatherLawObj);

            JSONObject ExtensionPostHospitalizationCoversFatherLawObj = new JSONObject();
            ExtensionPostHospitalizationCoversFatherLawObj.put("Applicable", ExtensionPr0Hospitalization);
            ExtensionPostHospitalizationCoversFatherLawObj.put("CoverSI", strSumInsured);
            ExtensionPostHospitalizationCoversFatherLawObj.put("CoverRate", "0");
            ExtensionPostHospitalizationCoversFatherLawObj.put("CoverPremium", "0");
            ExtensionPostHospitalizationCoversFatherLawObj.put("CoverGroups", "Extension under Post-Hospitalization");
            FatherLawCoversArray.put(ExtensionPostHospitalizationCoversFatherLawObj);


            JSONObject MaternityAndChildcareCoversFatherLawObj = new JSONObject();
            MaternityAndChildcareCoversFatherLawObj.put("Applicable", "False");
            MaternityAndChildcareCoversFatherLawObj.put("CoverSI", strSumInsured);
            MaternityAndChildcareCoversFatherLawObj.put("CoverRate", "0");
            MaternityAndChildcareCoversFatherLawObj.put("CoverPremium", "0");
            MaternityAndChildcareCoversFatherLawObj.put("CoverGroups", "Maternity and Childcare Benefit Waiting Period Modification");
            FatherLawCoversArray.put(MaternityAndChildcareCoversFatherLawObj);

            JSONObject CoverageForNonMedicalCoversFatherLawObj = new JSONObject();
            CoverageForNonMedicalCoversFatherLawObj.put("Applicable", CoverageNonMedical);
            CoverageForNonMedicalCoversFatherLawObj.put("CoverSI", strSumInsured);
            CoverageForNonMedicalCoversFatherLawObj.put("CoverRate", "0");
            CoverageForNonMedicalCoversFatherLawObj.put("CoverPremium", "0");
            CoverageForNonMedicalCoversFatherLawObj.put("CoverGroups", "Coverage for Non-Medical Items");
            FatherLawCoversArray.put(CoverageForNonMedicalCoversFatherLawObj);

            JSONObject ConditionWaiverCoversFatherLawObj = new JSONObject();
            ConditionWaiverCoversFatherLawObj.put("Applicable", ConditionWaiverStatus);
            ConditionWaiverCoversFatherLawObj.put("CoverSI", strSumInsured);
            ConditionWaiverCoversFatherLawObj.put("CoverRate", "0");
            ConditionWaiverCoversFatherLawObj.put("CoverPremium", "0");
            ConditionWaiverCoversFatherLawObj.put("CoverGroups", "Condition waiver under Restore Benefit");
            FatherLawCoversArray.put(ConditionWaiverCoversFatherLawObj);

            JSONObject PreExistingDiseaseCoversFatherLawObj = new JSONObject();
            PreExistingDiseaseCoversFatherLawObj.put("Applicable", PreExistingDiseaseStatus);
            PreExistingDiseaseCoversFatherLawObj.put("CoverSI", strSumInsured);
            PreExistingDiseaseCoversFatherLawObj.put("CoverRate", "0");
            PreExistingDiseaseCoversFatherLawObj.put("CoverPremium", "0");
            PreExistingDiseaseCoversFatherLawObj.put("CoverGroups", "Pre-Existing Disease waiting period");
            FatherLawCoversArray.put(PreExistingDiseaseCoversFatherLawObj);

            JSONObject OutpatientDentalWaitingCoversFatherLawObj = new JSONObject();
            OutpatientDentalWaitingCoversFatherLawObj.put("Applicable", OutpatientDentalStatus);
            OutpatientDentalWaitingCoversFatherLawObj.put("CoverSI", strSumInsured);
            OutpatientDentalWaitingCoversFatherLawObj.put("CoverRate", "0");
            OutpatientDentalWaitingCoversFatherLawObj.put("CoverPremium", "0");
            OutpatientDentalWaitingCoversFatherLawObj.put("CoverGroups", "Outpatient Dental Waiting Period Modification");
            FatherLawCoversArray.put(OutpatientDentalWaitingCoversFatherLawObj);

            JSONObject EmergencyTravellingAllowanceCoversFatherLawObj = new JSONObject();
            EmergencyTravellingAllowanceCoversFatherLawObj.put("Applicable", EmergencyTravellingStatus);
            EmergencyTravellingAllowanceCoversFatherLawObj.put("CoverSI", strSumInsured);
            EmergencyTravellingAllowanceCoversFatherLawObj.put("CoverRate", "0");
            EmergencyTravellingAllowanceCoversFatherLawObj.put("CoverPremium", "0");
            EmergencyTravellingAllowanceCoversFatherLawObj.put("CoverGroups", "Emergency Travelling Allowance");
            FatherLawCoversArray.put(EmergencyTravellingAllowanceCoversFatherLawObj);

            JSONObject SecondOpinionCoversFatherLawObj = new JSONObject();
            SecondOpinionCoversFatherLawObj.put("Applicable", SecondOpinionStatus);
            SecondOpinionCoversFatherLawObj.put("CoverSI", strSumInsured);
            SecondOpinionCoversFatherLawObj.put("CoverRate", "0");
            SecondOpinionCoversFatherLawObj.put("CoverPremium", "0");
            SecondOpinionCoversFatherLawObj.put("CoverGroups", "Second Opinion");
            FatherLawCoversArray.put(SecondOpinionCoversFatherLawObj);

            JSONObject RestCureCoversFatherLawObj = new JSONObject();
            RestCureCoversFatherLawObj.put("Applicable", RestCureStatus);
            RestCureCoversFatherLawObj.put("CoverSI", strSumInsured);
            RestCureCoversFatherLawObj.put("CoverRate", "0");
            RestCureCoversFatherLawObj.put("CoverPremium", "0");
            RestCureCoversFatherLawObj.put("CoverGroups", "Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension");
            FatherLawCoversArray.put(RestCureCoversFatherLawObj);

            JSONObject ObesityWeightCoversFatherLawObj = new JSONObject();
            ObesityWeightCoversFatherLawObj.put("Applicable", ObesityWeightStatus);
            ObesityWeightCoversFatherLawObj.put("CoverSI", strSumInsured);
            ObesityWeightCoversFatherLawObj.put("CoverRate", "0");
            ObesityWeightCoversFatherLawObj.put("CoverPremium", "0");
            ObesityWeightCoversFatherLawObj.put("CoverGroups", "Obesity/ Weight Control Expenses Extension");
            FatherLawCoversArray.put(ObesityWeightCoversFatherLawObj);

            JSONObject SterilityInfertilityCoversFatherLawObj = new JSONObject();
            SterilityInfertilityCoversFatherLawObj.put("Applicable", "False");
            SterilityInfertilityCoversFatherLawObj.put("CoverSI", strSumInsured);
            SterilityInfertilityCoversFatherLawObj.put("CoverRate", "0");
            SterilityInfertilityCoversFatherLawObj.put("CoverPremium", "0");
            SterilityInfertilityCoversFatherLawObj.put("CoverGroups", "Sterility and Infertility Treatment Expenses Extension");
            FatherLawCoversArray.put(SterilityInfertilityCoversFatherLawObj);

            JSONObject EnhancedOrganDonorCoversFatherLawObj = new JSONObject();
            EnhancedOrganDonorCoversFatherLawObj.put("Applicable", EnhancedOrganStatus);
            EnhancedOrganDonorCoversFatherLawObj.put("CoverSI", strSumInsured);
            EnhancedOrganDonorCoversFatherLawObj.put("CoverRate", "0");
            EnhancedOrganDonorCoversFatherLawObj.put("CoverPremium", "0");
            EnhancedOrganDonorCoversFatherLawObj.put("CoverGroups", "Enhanced Organ Donor Expenses");
            FatherLawCoversArray.put(EnhancedOrganDonorCoversFatherLawObj);

            JSONObject PremiumWaiverCoversFatherLawObj = new JSONObject();
            PremiumWaiverCoversFatherLawObj.put("Applicable", PremiumWaiverStatus);
            PremiumWaiverCoversFatherLawObj.put("CoverSI", strSumInsured);
            PremiumWaiverCoversFatherLawObj.put("CoverRate", "0");
            PremiumWaiverCoversFatherLawObj.put("CoverPremium", "0");
            PremiumWaiverCoversFatherLawObj.put("CoverGroups", "Premium Waiver");
            FatherLawCoversArray.put(PremiumWaiverCoversFatherLawObj);

            JSONObject GlobalCoversFatherLawObj = new JSONObject();
            GlobalCoversFatherLawObj.put("Applicable", GlobalCoverStatus);
            GlobalCoversFatherLawObj.put("CoverSI", strSumInsured);
            GlobalCoversFatherLawObj.put("CoverRate", "0");
            GlobalCoversFatherLawObj.put("CoverPremium", "0");
            GlobalCoversFatherLawObj.put("CoverGroups", "Global Cover");
            FatherLawCoversArray.put(GlobalCoversFatherLawObj);


            JSONObject MedicallyAdvisedCoversFatherLawObj = new JSONObject();
            MedicallyAdvisedCoversFatherLawObj.put("Applicable", MedicallyAdvisedStatus);
            MedicallyAdvisedCoversFatherLawObj.put("CoverSI", strSumInsured);
            MedicallyAdvisedCoversFatherLawObj.put("CoverRate", "0");
            MedicallyAdvisedCoversFatherLawObj.put("CoverPremium", "0");
            MedicallyAdvisedCoversFatherLawObj.put("CoverGroups", "Medically Advised Support Devices");
            FatherLawCoversArray.put(MedicallyAdvisedCoversFatherLawObj);

            JSONObject EmergencyCoversFatherLawObj = new JSONObject();
            EmergencyCoversFatherLawObj.put("Applicable", EmergencyAssistanceStatus);
            EmergencyCoversFatherLawObj.put("CoverSI", strSumInsured);
            EmergencyCoversFatherLawObj.put("CoverRate", "0");
            EmergencyCoversFatherLawObj.put("CoverPremium", "0");
            EmergencyCoversFatherLawObj.put("CoverGroups", "Emergency Assistance Service");
            FatherLawCoversArray.put(EmergencyCoversFatherLawObj);

            JSONObject HomeCareTreatmentCoversFatherLawObj = new JSONObject();
            HomeCareTreatmentCoversFatherLawObj.put("Applicable", HomeCareStatus);
            HomeCareTreatmentCoversFatherLawObj.put("CoverSI", strSumInsured);
            HomeCareTreatmentCoversFatherLawObj.put("CoverRate", "0");
            HomeCareTreatmentCoversFatherLawObj.put("CoverPremium", "0");
            HomeCareTreatmentCoversFatherLawObj.put("CoverGroups", "Home Care Treatment");
            FatherLawCoversArray.put(HomeCareTreatmentCoversFatherLawObj);

            JSONObject WellnessBenefitCoversFatherLawObj = new JSONObject();
            WellnessBenefitCoversFatherLawObj.put("Applicable", WellnessBenefitStatus);
            WellnessBenefitCoversFatherLawObj.put("CoverSI", strSumInsured);
            WellnessBenefitCoversFatherLawObj.put("CoverRate", "0");
            WellnessBenefitCoversFatherLawObj.put("CoverPremium", "0");
            WellnessBenefitCoversFatherLawObj.put("CoverGroups", "Wellness Benefit");
            FatherLawCoversArray.put(WellnessBenefitCoversFatherLawObj);

            JSONObject DiseaseManagementCoversFatherLawObj = new JSONObject();
            DiseaseManagementCoversFatherLawObj.put("Applicable", DiseaseManagementStatus);
            DiseaseManagementCoversFatherLawObj.put("CoverSI", strSumInsured);
            DiseaseManagementCoversFatherLawObj.put("CoverRate", "0");
            DiseaseManagementCoversFatherLawObj.put("CoverPremium", "0");
            DiseaseManagementCoversFatherLawObj.put("CoverGroups", "Disease Management Program");
            FatherLawCoversArray.put(DiseaseManagementCoversFatherLawObj);
            CoverDetailsFatherLawObj.put("Covers", FatherLawCoversArray);
            FatherLawObj.put("CoverDetails", CoverDetailsFatherLawObj);

            if (str_policyType_spinner.equals("Individual")) {
                if (strCheckBoxSelf.equals("Checked") || strCheckBoxSpouse.equals("Checked") || strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    InsuredDetailsGroupArray.put(InsuredDetailsObj);
                }
            } else {
                if (strCheckBoxSelf.equals("Checked")) {
                    InsuredDetailsGroupArray.put(InsuredDetailsObj);
                }
                if (strCheckBoxSpouse.equals("Checked")) {
                    InsuredDetailsGroupArray.put(SecondAdultObj);
                }
                if (mCounter == 1) {
                    InsuredDetailsGroupArray.put(FirstChildObj);
                }
                if (mCounter == 2) {
                    InsuredDetailsGroupArray.put(FirstChildObj);
                    InsuredDetailsGroupArray.put(SecondChildObj);
                }
                if (mCounter == 3) {
                    InsuredDetailsGroupArray.put(FirstChildObj);
                    InsuredDetailsGroupArray.put(SecondChildObj);
                    InsuredDetailsGroupArray.put(ThirdChildObj);
                }
                if (mCounter == 4) {
                    InsuredDetailsGroupArray.put(FirstChildObj);
                    InsuredDetailsGroupArray.put(SecondChildObj);
                    InsuredDetailsGroupArray.put(ThirdChildObj);
                    InsuredDetailsGroupArray.put(FourthChildObj);
                }
                if (strCheckBoxMother.equals("Checked")) {
                    InsuredDetailsGroupArray.put(MotherObj);
                }
                if (strCheckBoxFather.equals("Checked")) {
                    InsuredDetailsGroupArray.put(FatherObj);
                }
                if (strCheckBoxMotherLaw.equals("Checked")) {
                    InsuredDetailsGroupArray.put(MotherLawObj);
                }
                if (strCheckBoxFatherLaw.equals("Checked")) {
                    InsuredDetailsGroupArray.put(FatherLawObj);
                }

            }


            InsuredDetailsObject.put("InsuredDetailsGroup", InsuredDetailsGroupArray);
            RisksDataObject.put("InsuredDetails", InsuredDetailsObject);

            //otherLoading
            JSONObject OtherLoadingsObject = new JSONObject();
            JSONObject OtherLoadingGroupObject = new JSONObject();
            JSONObject OtherLoadingGroupDataObject = new JSONObject();
            OtherLoadingGroupDataObject.put("LoadingAmount", "0");
            OtherLoadingGroupDataObject.put("LoadingRate", "0");
            OtherLoadingGroupDataObject.put("SumInsured", "0");
            OtherLoadingGroupDataObject.put("Rate", "0");
            OtherLoadingGroupDataObject.put("Premium", "0");
            OtherLoadingGroupDataObject.put("Applicable", "False");
            OtherLoadingGroupDataObject.put("Description", "NULL");
            OtherLoadingGroupObject.put("OtherLoadingGroupData", OtherLoadingGroupDataObject);
            OtherLoadingsObject.put("OtherLoadingGroup", OtherLoadingGroupObject);

            RisksDataObject.put("OtherLoadings", OtherLoadingsObject);
//            RiskObject.put("RisksData",RisksDataObject);
//            RisksObject.put("Risks",RiskObject);
            //OtherDiscounts
            JSONObject OtherDiscountsObject = new JSONObject();
            JSONArray OtherDiscountGroupArray = new JSONArray();
            JSONObject TreatmentObject = new JSONObject();
            TreatmentObject.put("DiscountAmount", "0");
            TreatmentObject.put("DiscountRate", "0");
            TreatmentObject.put("SumInsured", strSumInsured);
            TreatmentObject.put("Rate", "0");
            TreatmentObject.put("Premium", "0");
            TreatmentObject.put("Applicable", "False");
            TreatmentObject.put("Description", "Treatment only in tiered network");
            OtherDiscountGroupArray.put(TreatmentObject);

            JSONObject CoPaymentObject = new JSONObject();
            CoPaymentObject.put("DiscountAmount", "0");
            CoPaymentObject.put("DiscountRate", "0");
            CoPaymentObject.put("SumInsured", strSumInsured);
            CoPaymentObject.put("Rate", "0");
            CoPaymentObject.put("Premium", "0");
            CoPaymentObject.put("Applicable", CoPaymentStatus);
            CoPaymentObject.put("Description", "Co-payment");
            OtherDiscountGroupArray.put(CoPaymentObject);


            JSONObject LongObject = new JSONObject();
            LongObject.put("DiscountAmount", "0");
            LongObject.put("DiscountRate", "0");
            LongObject.put("SumInsured", strSumInsured);
            LongObject.put("Rate", "0");
            LongObject.put("Premium", "0");
            LongObject.put("Applicable", LongTermDiscountStatus);
            LongObject.put("Description", "Long term discount");
            OtherDiscountGroupArray.put(LongObject);

            JSONObject FamilyDiscountObject = new JSONObject();
            FamilyDiscountObject.put("DiscountAmount", "0");
            FamilyDiscountObject.put("DiscountRate", "0");
            FamilyDiscountObject.put("SumInsured", strSumInsured);
            FamilyDiscountObject.put("Rate", "0");
            FamilyDiscountObject.put("Premium", "0");
            FamilyDiscountObject.put("Applicable", "False");
            FamilyDiscountObject.put("Description", "Family Discount");
            OtherDiscountGroupArray.put(FamilyDiscountObject);

            JSONObject SubCategoryObject = new JSONObject();
            SubCategoryObject.put("DiscountAmount", "0");
            SubCategoryObject.put("DiscountRate", "0");
            SubCategoryObject.put("SumInsured", strSumInsured);
            SubCategoryObject.put("Rate", "0");
            SubCategoryObject.put("Premium", "0");
            SubCategoryObject.put("Applicable", SubCategoryDiscountStatus);
            SubCategoryObject.put("Description", "Sub Category Discount");
            OtherDiscountGroupArray.put(SubCategoryObject);


            JSONObject DirectPolicyObject = new JSONObject();
            DirectPolicyObject.put("DiscountAmount", "0");
            DirectPolicyObject.put("DiscountRate", "0");
            DirectPolicyObject.put("SumInsured", strSumInsured);
            DirectPolicyObject.put("Rate", "0");
            DirectPolicyObject.put("Premium", "0");
            DirectPolicyObject.put("Applicable", "True");
            DirectPolicyObject.put("Description", "Direct Policy Discount");
            OtherDiscountGroupArray.put(DirectPolicyObject);

            JSONObject LoyaltyDiscountObject = new JSONObject();
            LoyaltyDiscountObject.put("DiscountAmount", "0");
            LoyaltyDiscountObject.put("DiscountRate", "0");
            LoyaltyDiscountObject.put("SumInsured", strSumInsured);
            LoyaltyDiscountObject.put("Rate", "0");
            LoyaltyDiscountObject.put("Premium", "0");
            LoyaltyDiscountObject.put("Applicable", LoyaltyDiscountStatus);
            LoyaltyDiscountObject.put("Description", "Loyalty Discount");
            OtherDiscountGroupArray.put(LoyaltyDiscountObject);

            JSONObject EmployeeDiscountObject = new JSONObject();
            EmployeeDiscountObject.put("DiscountAmount", "0");
            EmployeeDiscountObject.put("DiscountRate", "0");
            EmployeeDiscountObject.put("SumInsured", strSumInsured);
            EmployeeDiscountObject.put("Rate", "0");
            EmployeeDiscountObject.put("Premium", "0");
            EmployeeDiscountObject.put("Applicable", "False");
            EmployeeDiscountObject.put("Description", "Employee Discount");
            OtherDiscountGroupArray.put(EmployeeDiscountObject);

            JSONObject OrganDonorDiscountObject = new JSONObject();
            OrganDonorDiscountObject.put("DiscountAmount", "0");
            OrganDonorDiscountObject.put("DiscountRate", "0");
            OrganDonorDiscountObject.put("SumInsured", strSumInsured);
            OrganDonorDiscountObject.put("Rate", "0");
            OrganDonorDiscountObject.put("Premium", "0");
            OrganDonorDiscountObject.put("Applicable", OrganDiscountStatus);
            OrganDonorDiscountObject.put("Description", "Organ Donor Discount");
            OtherDiscountGroupArray.put(OrganDonorDiscountObject);

            OtherDiscountsObject.put("OtherDiscountGroup", OtherDiscountGroupArray);
            RisksDataObject.put("OtherDiscounts", OtherDiscountsObject);
            RiskObject.put("RisksData", RisksDataObject);
            RisksObject.put("Risk", RiskObject);
            ProductObject.put("Risks", RisksObject);

            RootObject.put("Product", ProductObject);
            //PaymentDetails
            JSONObject PaymentDetailsObj = new JSONObject();
            JSONObject PaymentEntryObj = new JSONObject();
            PaymentEntryObj.put("PaymentId", "NULL");
            PaymentEntryObj.put("MICRCheque", "NULL");
            PaymentEntryObj.put("InstrumentDate", "NULL");
            PaymentEntryObj.put("DraweeBankName", "NULL");
            PaymentEntryObj.put("HOUSEBANKNAME", "NULL");
            PaymentEntryObj.put("AmountPaid", "NULL");
            PaymentEntryObj.put("PaymentType", "NULL");
            PaymentEntryObj.put("PaymentMode", "NULL");
            PaymentEntryObj.put("InstrumentNo", "NULL");
            PaymentEntryObj.put("Status", "NULL");
            PaymentEntryObj.put("DepositSlipNo", "NULL");
            PaymentEntryObj.put("PayerType", "NULL");
            PaymentDetailsObj.put("PaymentEntry", PaymentEntryObj);
            RootObject.put("PaymentDetails", PaymentDetailsObj);
            //Error
            JSONObject ErrorsObj = new JSONObject();
            ErrorsObj.put("ErrorCode", "0");
            ErrorsObj.put("ErrDescription", "NULL");
            RootObject.put("Errors", ErrorsObj);

            //mainObject
            object.put("Root", RootObject);
            Log.e("objectApi", String.valueOf(object));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(PersonalInformationCHI.this, object, UrlHealthConstants.revisedCHIURL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        try {
                            customprogress.hideProgressBar();
                            JSONObject RootJsonObject = object.getJSONObject("Root");
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
                                        Log.e("ProductJsonObject", ProductJsonObject.toString());
                                        JSONObject PremiumCalculationJsonObject = ProductJsonObject.getJSONObject("PremiumCalculation");
                                        JSONObject RisksJsonObject = ProductJsonObject.getJSONObject("Risks");
                                        JSONObject newRisksJsonObject = RisksJsonObject.getJSONObject("Risk");
                                        JSONObject RisksDataJsonObject = newRisksJsonObject.getJSONObject("RisksData");
                                        JSONObject InsuredDetailsJsonObject = RisksDataJsonObject.getJSONObject("InsuredDetails");
                                        JSONObject OtherDiscountsJsonObject = RisksDataJsonObject.getJSONObject("OtherDiscounts");
                                        InsuredDetailsGroupArray1 = InsuredDetailsJsonObject.getJSONArray("InsuredDetailsGroup");
                                        String strTotalPremium1 = PremiumCalculationJsonObject.getString("TotalPremium");
                                        NetPremium = PremiumCalculationJsonObject.getString("NetPremium");

                                        for (int k = 0; k < InsuredDetailsGroupArray1.length(); k++) {
                                            if (str_policyType_spinner.equals("Individual")) {
                                                JSONObject CoverDetailsJsonObject = InsuredDetailsGroupArray1.getJSONObject(0).getJSONObject("CoverDetails");
                                                Log.e("CoverDetailsJsonObject", CoverDetailsJsonObject.toString());
                                                JSONArray CoversArray = CoverDetailsJsonObject.getJSONArray("Covers");
                                                Log.e("CoversArray", String.valueOf(CoversArray));
                                                for (int l = 0; l < CoversArray.length(); l++) {
                                                    JSONObject JsonObjectCover = CoversArray.getJSONObject(l);
                                                    String CoverName = JsonObjectCover.getString("CoverGroups");
                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                        BasicInsuranceCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                        PersonalAccidentCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageOne") || checkPackage.equals("PackageTwo") || checkPackage.equals("PackageThree") || checkPackage.equals("PackageFour")) {
                                                            PersonalAccidentCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                        CriticalIllnessCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageFour")) {
                                                            CriticalIllnessCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                        DailyHospitalCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageFour")) {
                                                            DailyHospitalCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                        ModernTreatmentCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageTwo") || checkPackage.equals("PackageFour")) {
                                                            ModernTreatmentCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                        ExtensionPreHospitalizationCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageOne")) {
                                                            ExtensionPreHospitalizationCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                        ExtensionProHospitalizationCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageOne")) {
                                                            ExtensionProHospitalizationCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                        MaternityChildcareCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                        CoverageNonMedicalCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageThree")) {
                                                            CoverageNonMedicalCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                        ConditionWaiverCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageOne") || checkPackage.equals("PackageTwo") || checkPackage.equals("PackageThree") || checkPackage.equals("PackageFour")) {
                                                            ConditionWaiverCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                        PreExistingDiseaseCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                        OutpatientDentalCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                        EmergencyTravellingCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                    } else if (CoverName.equals("Second Opinion")) {
                                                        SecondOpinionCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageTwo")) {
                                                            SecondOpinionCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                        RestCureCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                        ObesityWeightCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                        SterilityInfertilityCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                        EnhancedCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageThree")) {
                                                            EnhancedCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                        PremiumWaiverCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageTwo")) {
                                                            PremiumWaiverCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Global Cover")) {
                                                        GlobalCoverCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                        MedicallyAdvisedCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageThree")) {
                                                            MedicallyAdvisedCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                        EmergencyAssistanceCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageOne") || checkPackage.equals("PackageTwo")) {
                                                            EmergencyAssistanceCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                        HomeCareCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageThree")) {
                                                            HomeCareCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }
                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                        WellnessBenefitCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                        if (checkPackage.equals("PackageOne") || checkPackage.equals("PackageFive")) {
                                                            WellnessBenefitCoverPremium = JsonObjectCover.getString("CoverPremium");
                                                        }

                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                        DiseaseManagementCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                                    }
                                                    strBasicPremium = String.valueOf(BasicInsuranceCoverPremium1);
                                                    double addonsNew;
                                                    addonsNew = PersonalAccidentCoverPremium1 + CriticalIllnessCoverPremium1 + DailyHospitalCoverPremium1 + ModernTreatmentCoverPremium1 + ExtensionPreHospitalizationCoverPremium1 + ExtensionProHospitalizationCoverPremium1 + MaternityChildcareCoverPremium1 + CoverageNonMedicalCoverPremium1 + ConditionWaiverCoverPremium1 + PreExistingDiseaseCoverPremium1 + OutpatientDentalCoverPremium1 + EmergencyTravellingCoverPremium1 + SecondOpinionCoverPremium1 + RestCureCoverPremium1 + ObesityWeightCoverPremium1 + SterilityInfertilityCoverPremium1 + EnhancedCoverPremium1 + PremiumWaiverCoverPremium1 + GlobalCoverCoverPremium1 + MedicallyAdvisedCoverPremium1 + EmergencyAssistanceCoverPremium1 + HomeCareCoverPremium1 + WellnessBenefitCoverPremium1 + DiseaseManagementCoverPremium1;
                                                    addons= (int) addonsNew;
                                                    Log.e("addons", String.valueOf(addons));

                                                }
                                            }
                                            else {
                                                if (strCheckBoxSelf.equals("Checked") && strCheckBoxSpouse.equals("Checked")) {
                                                    FirstAdult();
                                                    SecondAdult();
                                                    if (mCounter == 1) {
                                                        ChildOneTwoAdult();
                                                        if (strCheckBoxMother.equals("Checked") || strCheckBoxMotherLaw.equals("Checked")) {
                                                            JSONObject CoverDetailsJsonObjectMother = InsuredDetailsGroupArray1.getJSONObject(3).getJSONObject("CoverDetails");
                                                            JSONArray CoversArrayM = CoverDetailsJsonObjectMother.getJSONArray("Covers");
                                                            for (int l = 0; l < CoversArrayM.length(); l++) {
                                                                JSONObject JsonObjectCoverM = CoversArrayM.getJSONObject(l);
                                                                String CoverName = JsonObjectCoverM.getString("CoverGroups");
                                                                if (CoverName.equals("Basic Insurance Cover")) {
                                                                    BasicInsuranceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Personal Accident Cover")) {
                                                                    PersonalAccidentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Critical Illness Cover")) {
                                                                    CriticalIllnessCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                    DailyHospitalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Modern Treatments")) {
                                                                    ModernTreatmentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                    ExtensionPreHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                    ExtensionProHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                    MaternityChildcareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                    CoverageNonMedicalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                    ConditionWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                    PreExistingDiseaseCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                    OutpatientDentalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                    EmergencyTravellingCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Second Opinion")) {
                                                                    SecondOpinionCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                    RestCureCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                    ObesityWeightCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                    SterilityInfertilityCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                    EnhancedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Premium Waiver")) {
                                                                    PremiumWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Global Cover")) {
                                                                    GlobalCoverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                    MedicallyAdvisedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                    EmergencyAssistanceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Home Care Treatment")) {
                                                                    HomeCareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Wellness Benefit")) {
                                                                    WellnessBenefitCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Disease Management Program")) {
                                                                    DiseaseManagementCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                }

                                                            }
                                                            if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                                JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(4).getJSONObject("CoverDetails");
                                                                JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                                for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                    JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                    String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                                        BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                                        PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                                        CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                        DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                                        ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                        ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                        ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                        MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                        CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                        ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                        PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                        OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                        EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Second Opinion")) {
                                                                        SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                        RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                        ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                        SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                        EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                                        PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Global Cover")) {
                                                                        GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                        MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                        EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                                        HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                                        WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                                        DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    }

                                                                }
                                                            }
                                                        }
                                                        else if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                            JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(3).getJSONObject("CoverDetails");
                                                            JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                            for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                if (CoverName.equals("Basic Insurance Cover")) {
                                                                    BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Personal Accident Cover")) {
                                                                    PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Critical Illness Cover")) {
                                                                    CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                    DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Modern Treatments")) {
                                                                    ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                    ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                    ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                    MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                    CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                    ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                    PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                    OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                    EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Second Opinion")) {
                                                                    SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                    RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                    ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                    SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                    EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Premium Waiver")) {
                                                                    PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Global Cover")) {
                                                                    GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                    MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                    EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Home Care Treatment")) {
                                                                    HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Wellness Benefit")) {
                                                                    WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Disease Management Program")) {
                                                                    DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                }

                                                            }

                                                        }
                                                    }
                                                    else if (mCounter == 2) {
                                                        ChildOneTwoAdult();
                                                        childTwoAdult();
                                                        if (strCheckBoxMother.equals("Checked") || strCheckBoxMotherLaw.equals("Checked")) {
                                                            JSONObject CoverDetailsJsonObjectMother = InsuredDetailsGroupArray1.getJSONObject(4).getJSONObject("CoverDetails");
                                                            JSONArray CoversArrayM = CoverDetailsJsonObjectMother.getJSONArray("Covers");
                                                            for (int l = 0; l < CoversArrayM.length(); l++) {
                                                                JSONObject JsonObjectCoverM = CoversArrayM.getJSONObject(l);
                                                                String CoverName = JsonObjectCoverM.getString("CoverGroups");
                                                                if (CoverName.equals("Basic Insurance Cover")) {
                                                                    BasicInsuranceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Personal Accident Cover")) {
                                                                    PersonalAccidentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Critical Illness Cover")) {
                                                                    CriticalIllnessCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                    DailyHospitalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Modern Treatments")) {
                                                                    ModernTreatmentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                    ExtensionPreHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                    ExtensionProHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                    MaternityChildcareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                    CoverageNonMedicalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                    ConditionWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                    PreExistingDiseaseCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                    OutpatientDentalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                    EmergencyTravellingCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Second Opinion")) {
                                                                    SecondOpinionCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                    RestCureCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                    ObesityWeightCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                    SterilityInfertilityCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                    EnhancedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Premium Waiver")) {
                                                                    PremiumWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Global Cover")) {
                                                                    GlobalCoverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                    MedicallyAdvisedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                    EmergencyAssistanceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Home Care Treatment")) {
                                                                    HomeCareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Wellness Benefit")) {
                                                                    WellnessBenefitCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Disease Management Program")) {
                                                                    DiseaseManagementCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                }

                                                            }
                                                            if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                                JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(5).getJSONObject("CoverDetails");
                                                                JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                                for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                    JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                    String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                                        BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                                        PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                                        CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                        DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                                        ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                        ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                        ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                        MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                        CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                        ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                        PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                        OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                        EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Second Opinion")) {
                                                                        SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                        RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                        ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                        SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                        EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                                        PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Global Cover")) {
                                                                        GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                        MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                        EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                                        HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                                        WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                                        DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    }

                                                                }
                                                            }
                                                        } else if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                            JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(4).getJSONObject("CoverDetails");
                                                            JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                            for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                if (CoverName.equals("Basic Insurance Cover")) {
                                                                    BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Personal Accident Cover")) {
                                                                    PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Critical Illness Cover")) {
                                                                    CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                    DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Modern Treatments")) {
                                                                    ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                    ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                    ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                    MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                    CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                    ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                    PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                    OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                    EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Second Opinion")) {
                                                                    SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                    RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                    ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                    SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                    EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Premium Waiver")) {
                                                                    PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Global Cover")) {
                                                                    GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                    MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                    EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Home Care Treatment")) {
                                                                    HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Wellness Benefit")) {
                                                                    WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Disease Management Program")) {
                                                                    DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                }

                                                            }

                                                        }
                                                    }
                                                    else if (mCounter == 3) {
                                                        ChildOneTwoAdult();
                                                        childTwoAdult();
                                                        childThreeAdult();
                                                        if (strCheckBoxMother.equals("Checked") || strCheckBoxMotherLaw.equals("Checked")) {
                                                            JSONObject CoverDetailsJsonObjectMother = InsuredDetailsGroupArray1.getJSONObject(5).getJSONObject("CoverDetails");
                                                            JSONArray CoversArrayM = CoverDetailsJsonObjectMother.getJSONArray("Covers");
                                                            for (int l = 0; l < CoversArrayM.length(); l++) {
                                                                JSONObject JsonObjectCoverM = CoversArrayM.getJSONObject(l);
                                                                String CoverName = JsonObjectCoverM.getString("CoverGroups");
                                                                if (CoverName.equals("Basic Insurance Cover")) {
                                                                    BasicInsuranceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Personal Accident Cover")) {
                                                                    PersonalAccidentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Critical Illness Cover")) {
                                                                    CriticalIllnessCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                    DailyHospitalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Modern Treatments")) {
                                                                    ModernTreatmentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                    ExtensionPreHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                    ExtensionProHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                    MaternityChildcareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                    CoverageNonMedicalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                    ConditionWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                    PreExistingDiseaseCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                    OutpatientDentalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                    EmergencyTravellingCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Second Opinion")) {
                                                                    SecondOpinionCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                    RestCureCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                    ObesityWeightCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                    SterilityInfertilityCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                    EnhancedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Premium Waiver")) {
                                                                    PremiumWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Global Cover")) {
                                                                    GlobalCoverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                    MedicallyAdvisedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                    EmergencyAssistanceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Home Care Treatment")) {
                                                                    HomeCareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Wellness Benefit")) {
                                                                    WellnessBenefitCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Disease Management Program")) {
                                                                    DiseaseManagementCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                }

                                                            }
                                                        } else if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                            JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(5).getJSONObject("CoverDetails");
                                                            JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                            for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                if (CoverName.equals("Basic Insurance Cover")) {
                                                                    BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Personal Accident Cover")) {
                                                                    PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Critical Illness Cover")) {
                                                                    CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                    DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Modern Treatments")) {
                                                                    ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                    ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                    ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                    MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                    CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                    ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                    PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                    OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                    EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Second Opinion")) {
                                                                    SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                    RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                    ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                    SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                    EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Premium Waiver")) {
                                                                    PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Global Cover")) {
                                                                    GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                    MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                    EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Home Care Treatment")) {
                                                                    HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Wellness Benefit")) {
                                                                    WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Disease Management Program")) {
                                                                    DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                }

                                                            }

                                                        }
                                                    }
                                                    else if (mCounter == 4) {
                                                        ChildOneTwoAdult();
                                                        childTwoAdult();
                                                        childThreeAdult();
                                                        childFourAdult();
                                                    }
                                                    else {
                                                        if (strCheckBoxMother.equals("Checked") || strCheckBoxMotherLaw.equals("Checked")) {
                                                            JSONObject CoverDetailsJsonObjectMother = InsuredDetailsGroupArray1.getJSONObject(2).getJSONObject("CoverDetails");
                                                            JSONArray CoversArrayM = CoverDetailsJsonObjectMother.getJSONArray("Covers");
                                                            for (int l = 0; l < CoversArrayM.length(); l++) {
                                                                JSONObject JsonObjectCoverM = CoversArrayM.getJSONObject(l);
                                                                String CoverName = JsonObjectCoverM.getString("CoverGroups");
                                                                if (CoverName.equals("Basic Insurance Cover")) {
                                                                    BasicInsuranceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Personal Accident Cover")) {
                                                                    PersonalAccidentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Critical Illness Cover")) {
                                                                    CriticalIllnessCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                    DailyHospitalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Modern Treatments")) {
                                                                    ModernTreatmentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                    ExtensionPreHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                    ExtensionProHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                    MaternityChildcareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                    CoverageNonMedicalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                    ConditionWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                    PreExistingDiseaseCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                    OutpatientDentalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                    EmergencyTravellingCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Second Opinion")) {
                                                                    SecondOpinionCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                    RestCureCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                    ObesityWeightCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                    SterilityInfertilityCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                    EnhancedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Premium Waiver")) {
                                                                    PremiumWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Global Cover")) {
                                                                    GlobalCoverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                    MedicallyAdvisedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                    EmergencyAssistanceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Home Care Treatment")) {
                                                                    HomeCareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Wellness Benefit")) {
                                                                    WellnessBenefitCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Disease Management Program")) {
                                                                    DiseaseManagementCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                }

                                                            }
                                                            if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                                JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(3).getJSONObject("CoverDetails");
                                                                JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                                for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                    JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                    String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                                        BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                                        PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                                        CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                        DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                                        ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                        ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                        ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                        MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                        CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                        ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                        PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                        OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                        EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Second Opinion")) {
                                                                        SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                        RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                        ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                        SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                        EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                                        PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Global Cover")) {
                                                                        GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                        MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                        EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                                        HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                                        WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                                        DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    }

                                                                }
                                                            }
                                                        } else if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                            JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(2).getJSONObject("CoverDetails");
                                                            JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                            for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                if (CoverName.equals("Basic Insurance Cover")) {
                                                                    BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Personal Accident Cover")) {
                                                                    PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Critical Illness Cover")) {
                                                                    CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                    DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Modern Treatments")) {
                                                                    ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                    ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                    ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                    MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                    CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                    ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                    PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                    OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                    EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Second Opinion")) {
                                                                    SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                    RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                    ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                    SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                    EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Premium Waiver")) {
                                                                    PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Global Cover")) {
                                                                    GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                    MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                    EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Home Care Treatment")) {
                                                                    HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Wellness Benefit")) {
                                                                    WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                } else if (CoverName.equals("Disease Management Program")) {
                                                                    DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                }

                                                            }

                                                        }
                                                    }
                                                    if (selectYearAdult > selectYearSecondAdult) {
                                                        BasicPremiumAdd = BasicInsuranceCoverPremiumAd1 + BasicInsuranceCoverPremiumM + BasicInsuranceCoverPremiumF;
                                                    } else if (selectYearAdult < selectYearSecondAdult) {
                                                        BasicPremiumAdd = BasicInsuranceCoverPremiumAd2 + BasicInsuranceCoverPremiumM + BasicInsuranceCoverPremiumF;
                                                    } else {
                                                        BasicPremiumAdd = BasicInsuranceCoverPremiumAd1 + BasicInsuranceCoverPremiumM + BasicInsuranceCoverPremiumF;
                                                    }
                                                } else {
                                                    if (strCheckBoxSelf.equals("Checked") || strCheckBoxSpouse.equals("Checked")) {
                                                        FirstAdult();
                                                        if (mCounter == 1) {
                                                            childOne();
                                                            if (strCheckBoxMother.equals("Checked") || strCheckBoxMotherLaw.equals("Checked")) {
                                                                JSONObject CoverDetailsJsonObjectMother = InsuredDetailsGroupArray1.getJSONObject(2).getJSONObject("CoverDetails");
                                                                JSONArray CoversArrayM = CoverDetailsJsonObjectMother.getJSONArray("Covers");
                                                                for (int l = 0; l < CoversArrayM.length(); l++) {
                                                                    JSONObject JsonObjectCoverM = CoversArrayM.getJSONObject(l);
                                                                    String CoverName = JsonObjectCoverM.getString("CoverGroups");
                                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                                        BasicInsuranceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                                        PersonalAccidentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                                        CriticalIllnessCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                        DailyHospitalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                                        ModernTreatmentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                        ExtensionPreHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                        ExtensionProHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                        MaternityChildcareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                        CoverageNonMedicalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                        ConditionWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                        PreExistingDiseaseCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                        OutpatientDentalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                        EmergencyTravellingCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Second Opinion")) {
                                                                        SecondOpinionCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                        RestCureCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                        ObesityWeightCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                        SterilityInfertilityCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                        EnhancedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                                        PremiumWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Global Cover")) {
                                                                        GlobalCoverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                        MedicallyAdvisedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                        EmergencyAssistanceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                                        HomeCareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                                        WellnessBenefitCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                                        DiseaseManagementCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    }

                                                                }
                                                                if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                                    JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(3).getJSONObject("CoverDetails");
                                                                    JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                                    for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                        JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                        String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                        if (CoverName.equals("Basic Insurance Cover")) {
                                                                            BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Personal Accident Cover")) {
                                                                            PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Critical Illness Cover")) {
                                                                            CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                            DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Modern Treatments")) {
                                                                            ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                            ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                            ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                            MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                            CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                            ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                            PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                            OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                            EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Second Opinion")) {
                                                                            SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                            RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                            ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                            SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                            EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Premium Waiver")) {
                                                                            PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Global Cover")) {
                                                                            GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                            MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                            EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Home Care Treatment")) {
                                                                            HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Wellness Benefit")) {
                                                                            WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Disease Management Program")) {
                                                                            DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        }

                                                                    }
                                                                }
                                                            }
                                                            else if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                                JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(2).getJSONObject("CoverDetails");
                                                                JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                                for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                    JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                    String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                                        BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                                        PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                                        CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                        DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                                        ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                        ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                        ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                        MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                        CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                        ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                        PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                        OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                        EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Second Opinion")) {
                                                                        SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                        RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                        ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                        SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                        EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                                        PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Global Cover")) {
                                                                        GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                        MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                        EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                                        HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                                        WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                                        DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    }

                                                                }

                                                            }
                                                        }
                                                        else if (mCounter == 2) {
                                                            childOne();
                                                            childTwo();

                                                            if (strCheckBoxMother.equals("Checked") || strCheckBoxMotherLaw.equals("Checked")) {
                                                                JSONObject CoverDetailsJsonObjectMother = InsuredDetailsGroupArray1.getJSONObject(3).getJSONObject("CoverDetails");
                                                                JSONArray CoversArrayM = CoverDetailsJsonObjectMother.getJSONArray("Covers");
                                                                for (int l = 0; l < CoversArrayM.length(); l++) {
                                                                    JSONObject JsonObjectCoverM = CoversArrayM.getJSONObject(l);
                                                                    String CoverName = JsonObjectCoverM.getString("CoverGroups");
                                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                                        BasicInsuranceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                                        PersonalAccidentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                                        CriticalIllnessCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                        DailyHospitalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                                        ModernTreatmentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                        ExtensionPreHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                        ExtensionProHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                        MaternityChildcareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                        CoverageNonMedicalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                        ConditionWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                        PreExistingDiseaseCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                        OutpatientDentalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                        EmergencyTravellingCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Second Opinion")) {
                                                                        SecondOpinionCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                        RestCureCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                        ObesityWeightCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                        SterilityInfertilityCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                        EnhancedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                                        PremiumWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Global Cover")) {
                                                                        GlobalCoverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                        MedicallyAdvisedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                        EmergencyAssistanceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                                        HomeCareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                                        WellnessBenefitCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                                        DiseaseManagementCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    }

                                                                }
                                                                if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                                    JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(4).getJSONObject("CoverDetails");
                                                                    JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                                    for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                        JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                        String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                        if (CoverName.equals("Basic Insurance Cover")) {
                                                                            BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Personal Accident Cover")) {
                                                                            PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Critical Illness Cover")) {
                                                                            CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                            DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Modern Treatments")) {
                                                                            ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                            ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                            ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                            MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                            CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                            ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                            PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                            OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                            EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Second Opinion")) {
                                                                            SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                            RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                            ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                            SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                            EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Premium Waiver")) {
                                                                            PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Global Cover")) {
                                                                            GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                            MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                            EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Home Care Treatment")) {
                                                                            HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Wellness Benefit")) {
                                                                            WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Disease Management Program")) {
                                                                            DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        }

                                                                    }
                                                                }
                                                            } else if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                                JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(3).getJSONObject("CoverDetails");
                                                                JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                                for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                    JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                    String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                                        BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                                        PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                                        CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                        DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                                        ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                        ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                        ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                        MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                        CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                        ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                        PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                        OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                        EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Second Opinion")) {
                                                                        SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                        RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                        ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                        SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                        EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                                        PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Global Cover")) {
                                                                        GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                        MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                        EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                                        HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                                        WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                                        DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    }

                                                                }

                                                            }
                                                        }
                                                        else if (mCounter == 3) {
                                                            childOne();
                                                            childTwo();
                                                            childThree();
                                                            if (strCheckBoxMother.equals("Checked") || strCheckBoxMotherLaw.equals("Checked")) {
                                                                JSONObject CoverDetailsJsonObjectMother = InsuredDetailsGroupArray1.getJSONObject(4).getJSONObject("CoverDetails");
                                                                JSONArray CoversArrayM = CoverDetailsJsonObjectMother.getJSONArray("Covers");
                                                                for (int l = 0; l < CoversArrayM.length(); l++) {
                                                                    JSONObject JsonObjectCoverM = CoversArrayM.getJSONObject(l);
                                                                    String CoverName = JsonObjectCoverM.getString("CoverGroups");
                                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                                        BasicInsuranceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                                        PersonalAccidentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                                        CriticalIllnessCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                        DailyHospitalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                                        ModernTreatmentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                        ExtensionPreHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                        ExtensionProHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                        MaternityChildcareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                        CoverageNonMedicalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                        ConditionWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                        PreExistingDiseaseCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                        OutpatientDentalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                        EmergencyTravellingCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Second Opinion")) {
                                                                        SecondOpinionCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                        RestCureCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                        ObesityWeightCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                        SterilityInfertilityCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                        EnhancedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                                        PremiumWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Global Cover")) {
                                                                        GlobalCoverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                        MedicallyAdvisedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                        EmergencyAssistanceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                                        HomeCareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                                        WellnessBenefitCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                                        DiseaseManagementCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    }

                                                                }
                                                                if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                                    JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(5).getJSONObject("CoverDetails");
                                                                    JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                                    for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                        JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                        String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                        if (CoverName.equals("Basic Insurance Cover")) {
                                                                            BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Personal Accident Cover")) {
                                                                            PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Critical Illness Cover")) {
                                                                            CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                            DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Modern Treatments")) {
                                                                            ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                            ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                            ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                            MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                            CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                            ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                            PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                            OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                            EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Second Opinion")) {
                                                                            SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                            RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                            ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                            SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                            EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Premium Waiver")) {
                                                                            PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Global Cover")) {
                                                                            GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                            MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                            EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Home Care Treatment")) {
                                                                            HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Wellness Benefit")) {
                                                                            WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Disease Management Program")) {
                                                                            DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        }

                                                                    }
                                                                }
                                                            } else if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                                JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(4).getJSONObject("CoverDetails");
                                                                JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                                for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                    JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                    String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                                        BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                                        PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                                        CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                        DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                                        ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                        ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                        ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                        MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                        CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                        ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                        PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                        OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                        EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Second Opinion")) {
                                                                        SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                        RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                        ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                        SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                        EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                                        PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Global Cover")) {
                                                                        GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                        MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                        EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                                        HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                                        WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                                        DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    }

                                                                }

                                                            }
                                                        }
                                                        else if (mCounter == 4) {
                                                            childOne();
                                                            childTwo();
                                                            childThree();
                                                            childFour();
                                                            if (strCheckBoxMother.equals("Checked") || strCheckBoxMotherLaw.equals("Checked")) {
                                                                JSONObject CoverDetailsJsonObjectMother = InsuredDetailsGroupArray1.getJSONObject(5).getJSONObject("CoverDetails");
                                                                JSONArray CoversArrayM = CoverDetailsJsonObjectMother.getJSONArray("Covers");
                                                                for (int l = 0; l < CoversArrayM.length(); l++) {
                                                                    JSONObject JsonObjectCoverM = CoversArrayM.getJSONObject(l);
                                                                    String CoverName = JsonObjectCoverM.getString("CoverGroups");
                                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                                        BasicInsuranceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                                        PersonalAccidentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                                        CriticalIllnessCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                        DailyHospitalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                                        ModernTreatmentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                        ExtensionPreHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                        ExtensionProHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                        MaternityChildcareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                        CoverageNonMedicalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                        ConditionWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                        PreExistingDiseaseCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                        OutpatientDentalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                        EmergencyTravellingCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Second Opinion")) {
                                                                        SecondOpinionCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                        RestCureCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                        ObesityWeightCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                        SterilityInfertilityCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                        EnhancedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                                        PremiumWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Global Cover")) {
                                                                        GlobalCoverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                        MedicallyAdvisedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                        EmergencyAssistanceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                                        HomeCareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                                        WellnessBenefitCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                                        DiseaseManagementCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    }

                                                                }
                                                            } else if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                                JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(5).getJSONObject("CoverDetails");
                                                                JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                                for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                    JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                    String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                                        BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                                        PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                                        CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                        DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                                        ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                        ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                        ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                        MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                        CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                        ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                        PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                        OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                        EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Second Opinion")) {
                                                                        SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                        RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                        ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                        SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                        EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                                        PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Global Cover")) {
                                                                        GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                        MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                        EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                                        HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                                        WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                                        DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    }

                                                                }

                                                            }
                                                        }
                                                        else {
                                                            if (strCheckBoxMother.equals("Checked") || strCheckBoxMotherLaw.equals("Checked")) {
                                                                JSONObject CoverDetailsJsonObjectMother = InsuredDetailsGroupArray1.getJSONObject(1).getJSONObject("CoverDetails");
                                                                JSONArray CoversArrayM = CoverDetailsJsonObjectMother.getJSONArray("Covers");
                                                                for (int l = 0; l < CoversArrayM.length(); l++) {
                                                                    JSONObject JsonObjectCoverM = CoversArrayM.getJSONObject(l);
                                                                    String CoverName = JsonObjectCoverM.getString("CoverGroups");
                                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                                        BasicInsuranceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                                        PersonalAccidentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                                        CriticalIllnessCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                        DailyHospitalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                                        ModernTreatmentCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                        ExtensionPreHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                        ExtensionProHospitalizationCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                        MaternityChildcareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                        CoverageNonMedicalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                        ConditionWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                        PreExistingDiseaseCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                        OutpatientDentalCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                        EmergencyTravellingCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Second Opinion")) {
                                                                        SecondOpinionCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                        RestCureCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                        ObesityWeightCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                        SterilityInfertilityCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                        EnhancedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                                        PremiumWaiverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Global Cover")) {
                                                                        GlobalCoverCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                        MedicallyAdvisedCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                        EmergencyAssistanceCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                                        HomeCareCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                                        WellnessBenefitCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                                        DiseaseManagementCoverPremiumM = Double.parseDouble(JsonObjectCoverM.getString("CoverPremium"));
                                                                    }

                                                                }
                                                                if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                                    JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(2).getJSONObject("CoverDetails");
                                                                    JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                                    for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                        JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                        String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                        if (CoverName.equals("Basic Insurance Cover")) {
                                                                            BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Personal Accident Cover")) {
                                                                            PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Critical Illness Cover")) {
                                                                            CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                            DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Modern Treatments")) {
                                                                            ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                            ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                            ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                            MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                            CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                            ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                            PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                            OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                            EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Second Opinion")) {
                                                                            SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                            RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                            ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                            SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                            EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Premium Waiver")) {
                                                                            PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Global Cover")) {
                                                                            GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                            MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                            EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Home Care Treatment")) {
                                                                            HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Wellness Benefit")) {
                                                                            WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        } else if (CoverName.equals("Disease Management Program")) {
                                                                            DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                        }

                                                                    }
                                                                }
                                                            } else if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                                                                JSONObject CoverDetailsJsonObjectF = InsuredDetailsGroupArray1.getJSONObject(1).getJSONObject("CoverDetails");
                                                                JSONArray CoversArrayF = CoverDetailsJsonObjectF.getJSONArray("Covers");
                                                                for (int l = 0; l < CoversArrayF.length(); l++) {
                                                                    JSONObject JsonObjectCoverF = CoversArrayF.getJSONObject(l);
                                                                    String CoverName = JsonObjectCoverF.getString("CoverGroups");
                                                                    if (CoverName.equals("Basic Insurance Cover")) {
                                                                        BasicInsuranceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Personal Accident Cover")) {
                                                                        PersonalAccidentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Critical Illness Cover")) {
                                                                        CriticalIllnessCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                                                                        DailyHospitalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Modern Treatments")) {
                                                                        ModernTreatmentCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                                                                        ExtensionPreHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                                                                        ExtensionProHospitalizationCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                                        MaternityChildcareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                                                                        CoverageNonMedicalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                                                                        ConditionWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                                                                        PreExistingDiseaseCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                                                                        OutpatientDentalCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Travelling Allowance")) {
                                                                        EmergencyTravellingCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Second Opinion")) {
                                                                        SecondOpinionCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                                                                        RestCureCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                                                                        ObesityWeightCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                                                                        SterilityInfertilityCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                                                                        EnhancedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Premium Waiver")) {
                                                                        PremiumWaiverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Global Cover")) {
                                                                        GlobalCoverCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Medically Advised Support Devices")) {
                                                                        MedicallyAdvisedCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Emergency Assistance Service")) {
                                                                        EmergencyAssistanceCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Home Care Treatment")) {
                                                                        HomeCareCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Wellness Benefit")) {
                                                                        WellnessBenefitCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    } else if (CoverName.equals("Disease Management Program")) {
                                                                        DiseaseManagementCoverPremiumF = Double.parseDouble(JsonObjectCoverF.getString("CoverPremium"));
                                                                    }

                                                                }

                                                            }
                                                        }
                                                        BasicPremiumAdd = BasicInsuranceCoverPremiumAd1 + BasicInsuranceCoverPremiumM + BasicInsuranceCoverPremiumF;
                                                    }
                                                }
                                                conditionAdd = ConditionWaiverCoverPremiumAd1 + ConditionWaiverCoverPremiumAd2 + ConditionWaiverCoverPremiumCh1 + ConditionWaiverCoverPremiumCh2 + ConditionWaiverCoverPremiumCh3 + ConditionWaiverCoverPremiumCh4 + ConditionWaiverCoverPremiumM + ConditionWaiverCoverPremiumF;
                                                ExtensionPreAdd = ExtensionPreHospitalizationCoverPremiumAd1 + ExtensionPreHospitalizationCoverPremiumAd2 + ExtensionPreHospitalizationCoverPremiumCh1 + ExtensionPreHospitalizationCoverPremiumCh2 + ExtensionPreHospitalizationCoverPremiumCh3 + ExtensionPreHospitalizationCoverPremiumCh4 + ExtensionPreHospitalizationCoverPremiumM + ExtensionPreHospitalizationCoverPremiumF;
                                                ExtensionProAdd = ExtensionProHospitalizationCoverPremiumAd1 + ExtensionProHospitalizationCoverPremiumAd2 + ExtensionProHospitalizationCoverPremiumCh1 + ExtensionProHospitalizationCoverPremiumCh2 + ExtensionProHospitalizationCoverPremiumCh3 + ExtensionProHospitalizationCoverPremiumCh4 + ExtensionProHospitalizationCoverPremiumM + ExtensionProHospitalizationCoverPremiumF;
                                                EmergencyAdd = EmergencyAssistanceCoverPremiumAd1 + EmergencyAssistanceCoverPremiumAd2 + EmergencyAssistanceCoverPremiumCh1 + EmergencyAssistanceCoverPremiumCh2 + EmergencyAssistanceCoverPremiumCh3 + EmergencyAssistanceCoverPremiumCh4 + EmergencyAssistanceCoverPremiumM + EmergencyAssistanceCoverPremiumF;
                                                PersonalAccidentAdd = PersonalAccidentCoverPremiumAd1 + PersonalAccidentCoverPremiumAd2 + PersonalAccidentCoverPremiumCh1 + PersonalAccidentCoverPremiumCh2 + PersonalAccidentCoverPremiumCh3 + PersonalAccidentCoverPremiumCh4 + PersonalAccidentCoverPremiumM + PersonalAccidentCoverPremiumF;
                                                WellnessAdd = WellnessBenefitCoverPremiumAd1 + WellnessBenefitCoverPremiumAd2 + WellnessBenefitCoverPremiumCh1 + WellnessBenefitCoverPremiumCh2 + WellnessBenefitCoverPremiumCh3 + WellnessBenefitCoverPremiumCh4 + WellnessBenefitCoverPremiumM + WellnessBenefitCoverPremiumF;
                                                PewmiumWaiverAdd = PremiumWaiverCoverPremiumAd1 + PremiumWaiverCoverPremiumAd2 + PremiumWaiverCoverPremiumCh1 + PremiumWaiverCoverPremiumCh2 + PremiumWaiverCoverPremiumCh3 + PremiumWaiverCoverPremiumCh4 + PremiumWaiverCoverPremiumM + PremiumWaiverCoverPremiumF;
                                                SecondOpinionAdd = SecondOpinionCoverPremiumAd1 + SecondOpinionCoverPremiumAd2 + SecondOpinionCoverPremiumCh1 + SecondOpinionCoverPremiumCh2 + SecondOpinionCoverPremiumCh3 + SecondOpinionCoverPremiumCh4 + SecondOpinionCoverPremiumM + SecondOpinionCoverPremiumF;
                                                ModernTreatAdd = ModernTreatmentCoverPremiumAd1 + ModernTreatmentCoverPremiumAd2 + ModernTreatmentCoverPremiumCh1 + ModernTreatmentCoverPremiumCh2 + ModernTreatmentCoverPremiumCh3 + ModernTreatmentCoverPremiumCh4 + ModernTreatmentCoverPremiumM + ModernTreatmentCoverPremiumF;
                                                CoverageNonAdd = CoverageNonMedicalCoverPremiumAd1 + CoverageNonMedicalCoverPremiumAd2 + CoverageNonMedicalCoverPremiumCh1 + CoverageNonMedicalCoverPremiumCh2 + CoverageNonMedicalCoverPremiumCh3 + CoverageNonMedicalCoverPremiumCh4 + CoverageNonMedicalCoverPremiumM + CoverageNonMedicalCoverPremiumF;
                                                MedicallyAdvisedAdd = MedicallyAdvisedCoverPremiumAd1 + MedicallyAdvisedCoverPremiumAd2 + MedicallyAdvisedCoverPremiumCh1 + MedicallyAdvisedCoverPremiumCh2 + MedicallyAdvisedCoverPremiumCh3 + MedicallyAdvisedCoverPremiumCh4 + MedicallyAdvisedCoverPremiumM + MedicallyAdvisedCoverPremiumF;
                                                EnhancedAdd = EnhancedCoverPremiumAd1 + EnhancedCoverPremiumAd2 + EnhancedCoverPremiumCh1 + EnhancedCoverPremiumCh2 + EnhancedCoverPremiumCh3 + EnhancedCoverPremiumCh4 + EnhancedCoverPremiumM + EnhancedCoverPremiumF;
                                                HomeCareAdd = HomeCareCoverPremiumAd1 + HomeCareCoverPremiumAd2 + HomeCareCoverPremiumCh1 + HomeCareCoverPremiumCh2 + HomeCareCoverPremiumCh3 + HomeCareCoverPremiumCh4 + HomeCareCoverPremiumM + HomeCareCoverPremiumF;
                                                CriticalAdd = CriticalIllnessCoverPremiumAd1 + CriticalIllnessCoverPremiumAd2 + CriticalIllnessCoverPremiumCh1 + CriticalIllnessCoverPremiumCh2 + CriticalIllnessCoverPremiumCh3 + CriticalIllnessCoverPremiumCh4 + CriticalIllnessCoverPremiumM + CriticalIllnessCoverPremiumF;
                                                DailyCashAdd = DailyHospitalCoverPremiumAd1 + DailyHospitalCoverPremiumAd2 + DailyHospitalCoverPremiumCh1 + DailyHospitalCoverPremiumCh2 + DailyHospitalCoverPremiumCh3 + DailyHospitalCoverPremiumCh4 + DailyHospitalCoverPremiumM + DailyHospitalCoverPremiumF;
                                                OutpatientDentalAdd = OutpatientDentalCoverPremiumAd1 + OutpatientDentalCoverPremiumAd2 + OutpatientDentalCoverPremiumCh1 + OutpatientDentalCoverPremiumCh2 + OutpatientDentalCoverPremiumCh3 + OutpatientDentalCoverPremiumCh4 + OutpatientDentalCoverPremiumM + OutpatientDentalCoverPremiumF;
                                                EmergencyTravellingAdd = EmergencyTravellingCoverPremiumAd1 + EmergencyTravellingCoverPremiumAd2 + EmergencyTravellingCoverPremiumCh1 + EmergencyTravellingCoverPremiumCh2 + EmergencyTravellingCoverPremiumCh3 + EmergencyTravellingCoverPremiumCh4 + EmergencyTravellingCoverPremiumM + EmergencyTravellingCoverPremiumF;
                                                PreExistingAdd = PreExistingDiseaseCoverPremiumAd1 + PreExistingDiseaseCoverPremiumAd2 + PreExistingDiseaseCoverPremiumCh1 + PreExistingDiseaseCoverPremiumCh2 + PreExistingDiseaseCoverPremiumCh3 + PreExistingDiseaseCoverPremiumCh4 + PreExistingDiseaseCoverPremiumM + PreExistingDiseaseCoverPremiumF;
                                                MaternityAdd = MaternityChildcareCoverPremiumAd1 + MaternityChildcareCoverPremiumAd2 + MaternityChildcareCoverPremiumCh1 + MaternityChildcareCoverPremiumCh2 + MaternityChildcareCoverPremiumCh3 + MaternityChildcareCoverPremiumCh4 + MaternityChildcareCoverPremiumM + MaternityChildcareCoverPremiumF;
                                                RestCureAdd = RestCureCoverPremiumAd1 + RestCureCoverPremiumAd2 + RestCureCoverPremiumCh1 + RestCureCoverPremiumCh2 + RestCureCoverPremiumCh3 + RestCureCoverPremiumCh4 + RestCureCoverPremiumM + RestCureCoverPremiumF;
                                                SterilityAdd = SterilityInfertilityCoverPremiumAd1 + SterilityInfertilityCoverPremiumAd2 + SterilityInfertilityCoverPremiumCh1 + SterilityInfertilityCoverPremiumCh2 + SterilityInfertilityCoverPremiumCh3 + SterilityInfertilityCoverPremiumCh4 + SterilityInfertilityCoverPremiumM + SterilityInfertilityCoverPremiumF;
                                                GlobalAdd = GlobalCoverCoverPremiumAd1 + GlobalCoverCoverPremiumAd2 + GlobalCoverCoverPremiumCh1 + GlobalCoverCoverPremiumCh2 + GlobalCoverCoverPremiumCh3 + GlobalCoverCoverPremiumCh4 + GlobalCoverCoverPremiumM + GlobalCoverCoverPremiumF;
                                                ObesityWeightAdd = ObesityWeightCoverPremiumAd1 + ObesityWeightCoverPremiumAd2 + ObesityWeightCoverPremiumCh1 + ObesityWeightCoverPremiumCh2 + ObesityWeightCoverPremiumCh3 + ObesityWeightCoverPremiumCh4 + ObesityWeightCoverPremiumM + ObesityWeightCoverPremiumF;
                                                DiseaseManagementAdd = DiseaseManagementCoverPremiumAd1 + DiseaseManagementCoverPremiumAd2 + DiseaseManagementCoverPremiumCh1 + DiseaseManagementCoverPremiumCh2 + DiseaseManagementCoverPremiumCh3 + DiseaseManagementCoverPremiumCh4 + DiseaseManagementCoverPremiumM + DiseaseManagementCoverPremiumF;
                                                strBasicPremium = String.valueOf(BasicPremiumAdd);
                                                double addonsNew;
                                                addonsNew = PersonalAccidentAdd + CriticalAdd + DailyCashAdd + ModernTreatAdd + ExtensionPreAdd + ExtensionProAdd + MaternityAdd + CoverageNonAdd + conditionAdd + PreExistingAdd + OutpatientDentalAdd + EmergencyTravellingAdd + SecondOpinionAdd + RestCureAdd + HomeCareAdd + SterilityAdd + EnhancedAdd + PewmiumWaiverAdd + GlobalAdd + MedicallyAdvisedAdd + EmergencyAdd + ObesityWeightAdd + WellnessAdd + DiseaseManagementAdd;
                                                addons= (int) addonsNew;

                                            }
                                        }
                                        ConditionWaiverCoverPremium = String.valueOf(conditionAdd);
                                        PremiumWaiverCoverPremium = String.valueOf(PewmiumWaiverAdd);
                                        SecondOpinionCoverPremium= String.valueOf(SecondOpinionAdd);
                                        EmergencyAssistanceCoverPremium = String.valueOf(EmergencyAdd);
                                        PersonalAccidentCoverPremium= String.valueOf(PersonalAccidentAdd);
                                        ModernTreatmentCoverPremium= String.valueOf(ModernTreatAdd);
                                        ExtensionPreHospitalizationCoverPremium = String.valueOf(ExtensionPreAdd);
                                        ExtensionProHospitalizationCoverPremium= String.valueOf(ExtensionProAdd);
                                        CoverageNonMedicalCoverPremium= String.valueOf(CoverageNonAdd);
                                        MedicallyAdvisedCoverPremium= String.valueOf(MedicallyAdvisedAdd);
                                        EnhancedCoverPremium= String.valueOf(EnhancedAdd);
                                        HomeCareCoverPremium= String.valueOf(HomeCareAdd);
                                        CriticalIllnessCoverPremium= String.valueOf(CriticalAdd);
                                        DailyHospitalCoverPremium= String.valueOf(DailyCashAdd);
                                        WellnessBenefitCoverPremium= String.valueOf(WellnessAdd);
                                        OutpatientDentalCoverPremium = String.valueOf(OutpatientDentalAdd);
                                        EmergencyTravellingCoverPremium = String.valueOf(EmergencyTravellingAdd);
                                        PreExistingDiseaseCoverPremium = String.valueOf(PreExistingAdd);
                                        MaternityChildcareCoverPremium = String.valueOf(MaternityAdd);
                                        RestCureCoverPremium = String.valueOf(RestCureAdd);
                                        SterilityInfertilityCoverPremium = String.valueOf(SterilityAdd);
                                        GlobalCoverCoverPremium = String.valueOf(GlobalAdd);
                                        ObesityWeightCoverPremium = String.valueOf(ObesityWeightAdd);
                                        DiseaseManagementCoverPremium = String.valueOf(DiseaseManagementAdd);

                                        double doubleTotalPremium1 = Double.parseDouble(strTotalPremium1);
                                        double mathMainPremiumTotal = Math.round(doubleTotalPremium1 * 100.0) / 100.0;
                                        strTotalPremium = String.valueOf(mathMainPremiumTotal);
                                        TotalPremiumTxt.setText(strTotalPremium);


                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                Toast.makeText(getApplication(), "" + ErrDescription, Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, 5000);

            }

            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestHealthConstants.RevisedCHIQuotation);
        req.execute();

    }
    private void FirstAdult() {
        try {
            JSONObject CoverDetailsJsonObject = InsuredDetailsGroupArray1.getJSONObject(0).getJSONObject("CoverDetails");
            JSONArray CoversArray = CoverDetailsJsonObject.getJSONArray("Covers");
            for (int l = 0; l < CoversArray.length(); l++) {
                JSONObject JsonObjectCover = CoversArray.getJSONObject(l);
                String CoverName = JsonObjectCover.getString("CoverGroups");
                if (CoverName.equals("Basic Insurance Cover")) {
                    BasicInsuranceCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Personal Accident Cover")) {
                    PersonalAccidentCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Critical Illness Cover")) {
                    CriticalIllnessCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                    DailyHospitalCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Modern Treatments")) {
                    ModernTreatmentCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                    ExtensionPreHospitalizationCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                    ExtensionProHospitalizationCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                    MaternityChildcareCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                    CoverageNonMedicalCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                    ConditionWaiverCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                    PreExistingDiseaseCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                    OutpatientDentalCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                    EmergencyTravellingCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Second Opinion")) {
                    SecondOpinionCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                    RestCureCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                    ObesityWeightCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                    SterilityInfertilityCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                    EnhancedCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Premium Waiver")) {
                    PremiumWaiverCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Global Cover")) {
                    GlobalCoverCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Medically Advised Support Devices")) {
                    MedicallyAdvisedCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Assistance Service")) {
                    EmergencyAssistanceCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Home Care Treatment")) {
                    HomeCareCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Wellness Benefit")) {
                    WellnessBenefitCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                } else if (CoverName.equals("Disease Management Program")) {
                    DiseaseManagementCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                }

            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }
    private void SecondAdult() {
        try {
            JSONObject CoverDetailsJsonObjectSecondAd = InsuredDetailsGroupArray1.getJSONObject(1).getJSONObject("CoverDetails");
            JSONArray CoversArrayAd2 = CoverDetailsJsonObjectSecondAd.getJSONArray("Covers");
            for (int l = 0; l < CoversArrayAd2.length(); l++) {
                JSONObject JsonObjectCoverAd = CoversArrayAd2.getJSONObject(l);
                String CoverName = JsonObjectCoverAd.getString("CoverGroups");
                if (CoverName.equals("Basic Insurance Cover")) {
                    BasicInsuranceCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Personal Accident Cover")) {
                    PersonalAccidentCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Critical Illness Cover")) {
                    CriticalIllnessCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                    DailyHospitalCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Modern Treatments")) {
                    ModernTreatmentCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                    ExtensionPreHospitalizationCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                    ExtensionProHospitalizationCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                    MaternityChildcareCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                    CoverageNonMedicalCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                    ConditionWaiverCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                    PreExistingDiseaseCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                    OutpatientDentalCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                    EmergencyTravellingCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Second Opinion")) {
                    SecondOpinionCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                    RestCureCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                    ObesityWeightCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                    SterilityInfertilityCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                    EnhancedCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Premium Waiver")) {
                    PremiumWaiverCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Global Cover")) {
                    GlobalCoverCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Medically Advised Support Devices")) {
                    MedicallyAdvisedCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Assistance Service")) {
                    EmergencyAssistanceCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Home Care Treatment")) {
                    HomeCareCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Wellness Benefit")) {
                    WellnessBenefitCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                } else if (CoverName.equals("Disease Management Program")) {
                    DiseaseManagementCoverPremiumAd2 = Double.parseDouble(JsonObjectCoverAd.getString("CoverPremium"));
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    private void ChildOneTwoAdult() {
        try {
            CoverDetailsJsonObject1 = InsuredDetailsGroupArray1.getJSONObject(2).getJSONObject("CoverDetails");
            JSONArray CoversArray1 = CoverDetailsJsonObject1.getJSONArray("Covers");
            for (int l = 0; l < CoversArray1.length(); l++) {
                JsonObjectCover1 = CoversArray1.getJSONObject(l);
                String CoverName = JsonObjectCover1.getString("CoverGroups");
                if (CoverName.equals("Basic Insurance Cover")) {
                    BasicInsuranceCoverPremiumChild1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Personal Accident Cover")) {
                    PersonalAccidentCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Critical Illness Cover")) {
                    CriticalIllnessCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                    DailyHospitalCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Modern Treatments")) {
                    ModernTreatmentCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                    ExtensionPreHospitalizationCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                    ExtensionProHospitalizationCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                    MaternityChildcareCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                    CoverageNonMedicalCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                    ConditionWaiverCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                    PreExistingDiseaseCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                    OutpatientDentalCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                    EmergencyTravellingCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Second Opinion")) {
                    SecondOpinionCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                    RestCureCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                    ObesityWeightCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                    SterilityInfertilityCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                    EnhancedCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Premium Waiver")) {
                    PremiumWaiverCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Global Cover")) {
                    GlobalCoverCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Medically Advised Support Devices")) {
                    MedicallyAdvisedCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Assistance Service")) {
                    EmergencyAssistanceCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Home Care Treatment")) {
                    HomeCareCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Wellness Benefit")) {
                    WellnessBenefitCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Disease Management Program")) {
                    DiseaseManagementCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void childTwoAdult() {
        try {
            JSONObject CoverDetailsJsonObjectCh2 = InsuredDetailsGroupArray1.getJSONObject(3).getJSONObject("CoverDetails");
            JSONArray CoversArrayCh2 = CoverDetailsJsonObjectCh2.getJSONArray("Covers");
            for (int l = 0; l < CoversArrayCh2.length(); l++) {
                JsonObjectCoverCh2 = CoversArrayCh2.getJSONObject(l);
                String CoverName = JsonObjectCoverCh2.getString("CoverGroups");
                if (CoverName.equals("Basic Insurance Cover")) {
                    BasicInsuranceCoverPremiumChild2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Personal Accident Cover")) {
                    PersonalAccidentCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Critical Illness Cover")) {
                    CriticalIllnessCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                    DailyHospitalCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Modern Treatments")) {
                    ModernTreatmentCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                    ExtensionPreHospitalizationCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                    ExtensionProHospitalizationCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                    MaternityChildcareCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                    CoverageNonMedicalCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                    ConditionWaiverCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                    PreExistingDiseaseCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                    OutpatientDentalCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                    EmergencyTravellingCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Second Opinion")) {
                    SecondOpinionCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                    RestCureCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                    ObesityWeightCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                    SterilityInfertilityCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                    EnhancedCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Premium Waiver")) {
                    PremiumWaiverCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Global Cover")) {
                    GlobalCoverCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Medically Advised Support Devices")) {
                    MedicallyAdvisedCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Assistance Service")) {
                    EmergencyAssistanceCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Home Care Treatment")) {
                    HomeCareCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Wellness Benefit")) {
                    WellnessBenefitCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Disease Management Program")) {
                    DiseaseManagementCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void childThreeAdult() {
        try {
            JSONObject CoverDetailsJsonObjectCh3 = InsuredDetailsGroupArray1.getJSONObject(4).getJSONObject("CoverDetails");
            JSONArray CoversArrayCh3 = CoverDetailsJsonObjectCh3.getJSONArray("Covers");
            for (int l = 0; l < CoversArrayCh3.length(); l++) {
                JsonObjectCoverCh3 = CoversArrayCh3.getJSONObject(l);
                String CoverName = JsonObjectCoverCh3.getString("CoverGroups");
                if (CoverName.equals("Basic Insurance Cover")) {
                    BasicInsuranceCoverPremiumChild3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Personal Accident Cover")) {
                    PersonalAccidentCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Critical Illness Cover")) {
                    CriticalIllnessCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                    DailyHospitalCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Modern Treatments")) {
                    ModernTreatmentCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                    ExtensionPreHospitalizationCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                    ExtensionProHospitalizationCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                    MaternityChildcareCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                    CoverageNonMedicalCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                    ConditionWaiverCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                    PreExistingDiseaseCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                    OutpatientDentalCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                    EmergencyTravellingCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Second Opinion")) {
                    SecondOpinionCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                    RestCureCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                    ObesityWeightCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                    SterilityInfertilityCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                    EnhancedCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Premium Waiver")) {
                    PremiumWaiverCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Global Cover")) {
                    GlobalCoverCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Medically Advised Support Devices")) {
                    MedicallyAdvisedCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Assistance Service")) {
                    EmergencyAssistanceCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Home Care Treatment")) {
                    HomeCareCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Wellness Benefit")) {
                    WellnessBenefitCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Disease Management Program")) {
                    DiseaseManagementCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void childFourAdult() {
        try {
            JSONObject CoverDetailsJsonObjectCh4 = InsuredDetailsGroupArray1.getJSONObject(5).getJSONObject("CoverDetails");
            JSONArray CoversArrayCh4 = CoverDetailsJsonObjectCh4.getJSONArray("Covers");
            for (int l = 0; l < CoversArrayCh4.length(); l++) {
                JsonObjectCoverCh4 = CoversArrayCh4.getJSONObject(l);
                String CoverName = JsonObjectCoverCh4.getString("CoverGroups");
                if (CoverName.equals("Basic Insurance Cover")) {
                    BasicInsuranceCoverPremiumChild4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Personal Accident Cover")) {
                    PersonalAccidentCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Critical Illness Cover")) {
                    CriticalIllnessCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                    DailyHospitalCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Modern Treatments")) {
                    ModernTreatmentCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                    ExtensionPreHospitalizationCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                    ExtensionProHospitalizationCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                    MaternityChildcareCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                    CoverageNonMedicalCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                    ConditionWaiverCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                    PreExistingDiseaseCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                    OutpatientDentalCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                    EmergencyTravellingCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Second Opinion")) {
                    SecondOpinionCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                    RestCureCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                    ObesityWeightCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                    SterilityInfertilityCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                    EnhancedCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Premium Waiver")) {
                    PremiumWaiverCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Global Cover")) {
                    GlobalCoverCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Medically Advised Support Devices")) {
                    MedicallyAdvisedCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Assistance Service")) {
                    EmergencyAssistanceCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Home Care Treatment")) {
                    HomeCareCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Wellness Benefit")) {
                    WellnessBenefitCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Disease Management Program")) {
                    DiseaseManagementCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void childOne() {
        try {
            CoverDetailsJsonObject1 = InsuredDetailsGroupArray1.getJSONObject(1).getJSONObject("CoverDetails");
            JSONArray CoversArray1 = CoverDetailsJsonObject1.getJSONArray("Covers");
            for (int l = 0; l < CoversArray1.length(); l++) {
                JsonObjectCover1 = CoversArray1.getJSONObject(l);
                String CoverName = JsonObjectCover1.getString("CoverGroups");
                if (CoverName.equals("Basic Insurance Cover")) {
                    BasicInsuranceCoverPremiumChild1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Personal Accident Cover")) {
                    PersonalAccidentCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Critical Illness Cover")) {
                    CriticalIllnessCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                    DailyHospitalCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Modern Treatments")) {
                    ModernTreatmentCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                    ExtensionPreHospitalizationCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                    ExtensionProHospitalizationCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                    MaternityChildcareCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                    CoverageNonMedicalCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                    ConditionWaiverCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                    PreExistingDiseaseCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                    OutpatientDentalCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                    EmergencyTravellingCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Second Opinion")) {
                    SecondOpinionCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                    RestCureCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                    ObesityWeightCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                    SterilityInfertilityCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                    EnhancedCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Premium Waiver")) {
                    PremiumWaiverCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Global Cover")) {
                    GlobalCoverCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Medically Advised Support Devices")) {
                    MedicallyAdvisedCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Assistance Service")) {
                    EmergencyAssistanceCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Home Care Treatment")) {
                    HomeCareCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Wellness Benefit")) {
                    WellnessBenefitCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                } else if (CoverName.equals("Disease Management Program")) {
                    DiseaseManagementCoverPremiumCh1 = Double.parseDouble(JsonObjectCover1.getString("CoverPremium"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    private void childTwo() {
        try {
            JSONObject CoverDetailsJsonObjectCh2 = InsuredDetailsGroupArray1.getJSONObject(2).getJSONObject("CoverDetails");
            JSONArray CoversArrayCh2 = CoverDetailsJsonObjectCh2.getJSONArray("Covers");
            for (int l = 0; l < CoversArrayCh2.length(); l++) {
                JsonObjectCoverCh2 = CoversArrayCh2.getJSONObject(l);
                String CoverName = JsonObjectCoverCh2.getString("CoverGroups");
                if (CoverName.equals("Basic Insurance Cover")) {
                    BasicInsuranceCoverPremiumChild2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Personal Accident Cover")) {
                    PersonalAccidentCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Critical Illness Cover")) {
                    CriticalIllnessCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                    DailyHospitalCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Modern Treatments")) {
                    ModernTreatmentCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                    ExtensionPreHospitalizationCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                    ExtensionProHospitalizationCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                    MaternityChildcareCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                    CoverageNonMedicalCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                    ConditionWaiverCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                    PreExistingDiseaseCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                    OutpatientDentalCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                    EmergencyTravellingCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Second Opinion")) {
                    SecondOpinionCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                    RestCureCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                    ObesityWeightCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                    SterilityInfertilityCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                    EnhancedCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Premium Waiver")) {
                    PremiumWaiverCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Global Cover")) {
                    GlobalCoverCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Medically Advised Support Devices")) {
                    MedicallyAdvisedCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Assistance Service")) {
                    EmergencyAssistanceCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Home Care Treatment")) {
                    HomeCareCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Wellness Benefit")) {
                    WellnessBenefitCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                } else if (CoverName.equals("Disease Management Program")) {
                    DiseaseManagementCoverPremiumCh2 = Double.parseDouble(JsonObjectCoverCh2.getString("CoverPremium"));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void childThree() {
        try {
            JSONObject CoverDetailsJsonObjectCh3 = InsuredDetailsGroupArray1.getJSONObject(3).getJSONObject("CoverDetails");
            JSONArray CoversArrayCh3 = CoverDetailsJsonObjectCh3.getJSONArray("Covers");
            for (int l = 0; l < CoversArrayCh3.length(); l++) {
                JsonObjectCoverCh3 = CoversArrayCh3.getJSONObject(l);
                String CoverName = JsonObjectCoverCh3.getString("CoverGroups");
                if (CoverName.equals("Basic Insurance Cover")) {
                    BasicInsuranceCoverPremiumChild3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Personal Accident Cover")) {
                    PersonalAccidentCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Critical Illness Cover")) {
                    CriticalIllnessCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                    DailyHospitalCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Modern Treatments")) {
                    ModernTreatmentCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                    ExtensionPreHospitalizationCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                    ExtensionProHospitalizationCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                    MaternityChildcareCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                    CoverageNonMedicalCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                    ConditionWaiverCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                    PreExistingDiseaseCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                    OutpatientDentalCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                    EmergencyTravellingCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Second Opinion")) {
                    SecondOpinionCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                    RestCureCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                    ObesityWeightCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                    SterilityInfertilityCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                    EnhancedCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Premium Waiver")) {
                    PremiumWaiverCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Global Cover")) {
                    GlobalCoverCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Medically Advised Support Devices")) {
                    MedicallyAdvisedCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Assistance Service")) {
                    EmergencyAssistanceCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Home Care Treatment")) {
                    HomeCareCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Wellness Benefit")) {
                    WellnessBenefitCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                } else if (CoverName.equals("Disease Management Program")) {
                    DiseaseManagementCoverPremiumCh3 = Double.parseDouble(JsonObjectCoverCh3.getString("CoverPremium"));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void childFour() {
        try {
            JSONObject CoverDetailsJsonObjectCh4 = InsuredDetailsGroupArray1.getJSONObject(4).getJSONObject("CoverDetails");
            JSONArray CoversArrayCh4 = CoverDetailsJsonObjectCh4.getJSONArray("Covers");
            for (int l = 0; l < CoversArrayCh4.length(); l++) {
                JsonObjectCoverCh4 = CoversArrayCh4.getJSONObject(l);
                String CoverName = JsonObjectCoverCh4.getString("CoverGroups");
                if (CoverName.equals("Basic Insurance Cover")) {
                    BasicInsuranceCoverPremiumChild4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Personal Accident Cover")) {
                    PersonalAccidentCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Critical Illness Cover")) {
                    CriticalIllnessCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Daily Hospital Cash Cover")) {
                    DailyHospitalCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Modern Treatments")) {
                    ModernTreatmentCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Pre-Hospitalization")) {
                    ExtensionPreHospitalizationCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Extension under Post-Hospitalization")) {
                    ExtensionProHospitalizationCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Maternity and Childcare Benefit Waiting Period Modification")) {
                    MaternityChildcareCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Coverage for Non-Medical Items")) {
                    CoverageNonMedicalCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Condition waiver under Restore Benefit")) {
                    ConditionWaiverCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Pre-Existing Disease waiting period")) {
                    PreExistingDiseaseCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Outpatient Dental Waiting Period Modification")) {
                    OutpatientDentalCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Travelling Allowance")) {
                    EmergencyTravellingCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Second Opinion")) {
                    SecondOpinionCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Rest Cure, Rehabilitation and Respite Care Nursing Care Expenses Extension")) {
                    RestCureCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Obesity/ Weight Control Expenses Extension")) {
                    ObesityWeightCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Sterility and Infertility Treatment Expenses Extension")) {
                    SterilityInfertilityCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Enhanced Organ Donor Expenses")) {
                    EnhancedCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Premium Waiver")) {
                    PremiumWaiverCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Global Cover")) {
                    GlobalCoverCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Medically Advised Support Devices")) {
                    MedicallyAdvisedCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Emergency Assistance Service")) {
                    EmergencyAssistanceCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Home Care Treatment")) {
                    HomeCareCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Wellness Benefit")) {
                    WellnessBenefitCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                } else if (CoverName.equals("Disease Management Program")) {
                    DiseaseManagementCoverPremiumCh4 = Double.parseDouble(JsonObjectCoverCh4.getString("CoverPremium"));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void backMethod() {
        if (!str_policyType_spinner.equals("Individual")) {
            if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                if (strCheckBoxSelf.equals("Checked")) {
                    strEdtNameSelf=EdtNameSelf.getText().toString();
                }
            }else{
                if (strCheckBoxSelf.equals("Checked")||strCheckBoxSpouse.equals("Checked")){
                    if (strCheckBoxSpouse.equals("Checked")){
                        strProposerEdtName=proposerEdtName.getText().toString();
                    }else{
                        strEdtNameSelf=EdtNameSelf.getText().toString();
                    }
                }
            }
        }else{
            if (strCheckBoxSelf.equals("Checked")) {
                strEdtNameSelf=EdtNameSelf.getText().toString();
            }
            if (strCheckBoxSpouse.equals("Checked")||strCheckBoxMother.equals("Checked")||strCheckBoxFather.equals("Checked")||strCheckBoxMotherLaw.equals("Checked")||strCheckBoxFatherLaw.equals("Checked")) {
                strProposerEdtName=proposerEdtName.getText().toString();
            }

        }


        Intent intent = new Intent(PersonalInformationCHI.this, NewCHIAddOns.class);
        intent.putExtra("TreatmentCheckBoxCheck", TreatmentCheckBoxCheck);
        intent.putExtra("strEdtNameSelf", strEdtNameSelf);
        intent.putExtra("str_edt_phone", str_edt_phone);
        intent.putExtra("str_email", str_email);
        intent.putExtra("str_edt_name", str_edt_name);
        intent.putExtra("str_policyType_spinner", str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit", str_IndividualTypeEdit);
        intent.putExtra("strSelfAgeEditText", strSelfAgeEditText);
        intent.putExtra("strGenderSpinner", strGenderSpinner);
        intent.putExtra("strGender", strGender);
        intent.putExtra("strCheckBoxSpouse", strCheckBoxSpouse);
        intent.putExtra("strSpouseAgeEditText", strSpouseAgeEditText);
        intent.putExtra("strCheckBoxMother", strCheckBoxMother);
        intent.putExtra("strMotherAgeEditText", strMotherAgeEditText);
        intent.putExtra("strFatherAgeEditText", strFatherAgeEditText);
        intent.putExtra("strCheckBoxFather", strCheckBoxFather);
        intent.putExtra("strCheckBoxMotherLaw", strCheckBoxMotherLaw);
        intent.putExtra("strMotherLawAgeEditText", strMotherLawAgeEditText);
        intent.putExtra("strCheckBoxFatherLaw", strCheckBoxFatherLaw);
        intent.putExtra("strFatherLawAgeEditText", strFatherLawAgeEditText);
        intent.putExtra("strFirstSonAgeEditText", strFirstSonAgeEditText);
        intent.putExtra("strSecondSonAgeEditText", strSecondSonAgeEditText);
        intent.putExtra("strThirdSonAgeEditText", strThirdSonAgeEditText);
        intent.putExtra("strFourSonAgeEditText", strFourSonAgeEditText);
        intent.putExtra("strCheckBoxSon", strCheckBoxSon);
        intent.putExtra("mCounter", mCounter);
        intent.putExtra("strTotalPremium", strTotalPremium);
        intent.putExtra("PosPolicyNo", PosPolicyNo);
        intent.putExtra("strSumInsured", strSumInsured);
        intent.putExtra("strPlanTypeTXT", strPlanTypeTXT);
        intent.putExtra("NetPremium", NetPremium);
        intent.putExtra("strBasicPremium", strBasicPremium);
        intent.putExtra("strPolicyTenure", strPolicyTenure);
        intent.putExtra("PlanType", PlanType);
        intent.putExtra("BasicStatus", BasicStatus);
        intent.putExtra("PersonalStatus", PersonalStatus);
        intent.putExtra("CriticalStatus", CriticalStatus);
        intent.putExtra("DailyHospitalSatus", DailyHospitalSatus);
        intent.putExtra("ModernTreatmentsStatus", ModernTreatmentsStatus);
        intent.putExtra("ExtensionPreHospitalization", ExtensionPreHospitalization);
        intent.putExtra("ExtensionPr0Hospitalization", ExtensionPr0Hospitalization);
        intent.putExtra("MaternityAndChildcare", MaternityAndChildcare);
        intent.putExtra("MaternityAndChildcareMale", MaternityAndChildcareMale);
        intent.putExtra("SterilityInfertilityMale", SterilityInfertilityMale);
        intent.putExtra("MaternityAndChildcareAddOn", MaternityAndChildcareAddOn);
        intent.putExtra("CoverageNonMedical", CoverageNonMedical);
        intent.putExtra("ConditionWaiverStatus", ConditionWaiverStatus);
        intent.putExtra("PersonalAccidentACoverStatus", PersonalAccidentACoverStatus);
        intent.putExtra("PersonalAccidentBCoverStatus", PersonalAccidentBCoverStatus);
        intent.putExtra("PreExistingDiseaseStatus", PreExistingDiseaseStatus);
        intent.putExtra("OutpatientDentalStatus", OutpatientDentalStatus);
        intent.putExtra("SecondOpinionStatus", SecondOpinionStatus);
        intent.putExtra("RestCureStatus", RestCureStatus);
        intent.putExtra("ObesityWeightStatus", ObesityWeightStatus);
        intent.putExtra("SterilityInfertilityStatus", SterilityInfertilityStatus);
        intent.putExtra("EnhancedOrganStatus", EnhancedOrganStatus);
        intent.putExtra("GlobalCoverStatus", GlobalCoverStatus);
        intent.putExtra("MedicallyAdvisedStatus", MedicallyAdvisedStatus);
        intent.putExtra("EmergencyAssistanceStatus", EmergencyAssistanceStatus);
        intent.putExtra("HomeCareStatus", HomeCareStatus);
        intent.putExtra("WellnessBenefitStatus", WellnessBenefitStatus);
        intent.putExtra("DiseaseManagementStatus", DiseaseManagementStatus);
        intent.putExtra("LoyaltyDiscountStatus", LoyaltyDiscountStatus);
        intent.putExtra("CoPaymentStatus", CoPaymentStatus);
        intent.putExtra("TreatmentStatus", TreatmentStatus);
        intent.putExtra("strIDTypeName", strIDTypeName);
        intent.putExtra("strPolicyNumber", strPolicyNumber);
        intent.putExtra("CoPaymentLoading", CoPaymentLoading);
        intent.putExtra("EmergencyTravellingStatus", EmergencyTravellingStatus);
        intent.putExtra("PremiumWaiverStatus", PremiumWaiverStatus);
        intent.putExtra("strPackageOne", strPackageOne);
        intent.putExtra("strCheckBoxSelf", strCheckBoxSelf);
        intent.putExtra("addons", addons);
        intent.putExtra("yearRadio", yearRadio);
        intent.putExtra("strPackage1", strPackage1);
        intent.putExtra("strPackageTwo", strPackageTwo);
        intent.putExtra("strPackageThree", strPackageThree);
        intent.putExtra("strPackageFour", strPackageFour);
        intent.putExtra("strPackageFive", strPackageFive);
        intent.putExtra("strPackageSix", strPackageSix);
        intent.putExtra("LongTermDiscountStatus", LongTermDiscountStatus);
        intent.putExtra("SubCategoryDiscountStatus", SubCategoryDiscountStatus);
        intent.putExtra("SubCategory", SubCategory);
        intent.putExtra("DirectPolicyDiscountPremium", DirectPolicyDiscountPremium);
        intent.putExtra("FamilyTypeCounter", FamilyTypeCounter);
        intent.putExtra("LongTermDiscountDiscountPremium", LongTermDiscountDiscountPremium);
        intent.putExtra("SubCategoryDiscountPremium", SubCategoryDiscountPremium);
        intent.putExtra("doubleCoPaymentDiscountPremium", doubleCoPaymentDiscountPremium);
        intent.putExtra("FamilyComposition", FamilyComposition);
        intent.putExtra("ParentComposition", ParentComposition);
        intent.putExtra("str_age", str_age);
        intent.putExtra("PersonalAccidentCategory", PersonalAccidentCategory);
        intent.putExtra("PersonalStatusChildFour", PersonalStatusChildFour);
        intent.putExtra("PersonalStatusChildThird", PersonalStatusChildThird);
        intent.putExtra("PersonalStatusChildTwo", PersonalStatusChildTwo);
        intent.putExtra("PersonalStatusChildOne", PersonalStatusChildOne);
        intent.putExtra("strswitch", strswitch);
        intent.putExtra("strCorrespondenceAddressEdit", strCorrespondenceAddressEdit);
        intent.putExtra("strCorrespondenceAddressEdit2", strCorrespondenceAddressEdit2);
        intent.putExtra("strProposerEditDob", strProposerEditDob);
        intent.putExtra("strProposerEditFt", strProposerEditFt);
        intent.putExtra("strProposerEditInches", strProposerEditInches);
        intent.putExtra("strEditGenderProposer", strEditGenderProposer);
        intent.putExtra("strEditOccupationProposer", strEditOccupationProposer);
        intent.putExtra("strProposerRelationEdit", strProposerRelationEdit);
        intent.putExtra("strProposerEdtName", strProposerEdtName);
        intent.putExtra("strWeightEditProposer", strWeightEditProposer);
        intent.putExtra("strProposerBMIEdit", strProposerBMIEdit);
        intent.putExtra("DailyHospitalCoverPremium", DailyHospitalCoverPremium);
        intent.putExtra("CriticalIllnessCoverPremium", CriticalIllnessCoverPremium);
        intent.putExtra("ExtensionPreHospitalizationCoverPremium", ExtensionPreHospitalizationCoverPremium);
        intent.putExtra("ExtensionProHospitalizationCoverPremium", ExtensionProHospitalizationCoverPremium);
        intent.putExtra("MaternityChildcareCoverPremium", MaternityChildcareCoverPremium);
        intent.putExtra("CoverageNonMedicalCoverPremium", CoverageNonMedicalCoverPremium);
        intent.putExtra("ConditionWaiverCoverPremium", ConditionWaiverCoverPremium);
        intent.putExtra("PersonalAccidentCoverPremium", PersonalAccidentCoverPremium);
        intent.putExtra("PreExistingDiseaseCoverPremium", PreExistingDiseaseCoverPremium);
        intent.putExtra("OutpatientDentalCoverPremium", OutpatientDentalCoverPremium);
        intent.putExtra("EmergencyTravellingCoverPremium", EmergencyTravellingCoverPremium);
        intent.putExtra("SecondOpinionCoverPremium", SecondOpinionCoverPremium);
        intent.putExtra("RestCureCoverPremium", RestCureCoverPremium);
        intent.putExtra("ObesityWeightCoverPremium", ObesityWeightCoverPremium);
        intent.putExtra("SterilityInfertilityCoverPremium", SterilityInfertilityCoverPremium);
        intent.putExtra("EnhancedCoverPremium", EnhancedCoverPremium);
        intent.putExtra("MedicallyAdvisedCoverPremium", MedicallyAdvisedCoverPremium);
        intent.putExtra("EmergencyAssistanceCoverPremium", EmergencyAssistanceCoverPremium);
        intent.putExtra("HomeCareCoverPremium", HomeCareCoverPremium);
        intent.putExtra("WellnessBenefitCoverPremium", WellnessBenefitCoverPremium);
        intent.putExtra("DiseaseManagementCoverPremium", DiseaseManagementCoverPremium);
        intent.putExtra("GlobalCoverCoverPremium", GlobalCoverCoverPremium);
        intent.putExtra("ModernTreatmentCoverPremium", ModernTreatmentCoverPremium);
        intent.putExtra("PremiumWaiverCoverPremium", PremiumWaiverCoverPremium);
        intent.putExtra("OrganDiscountStatus", OrganDiscountStatus);
        intent.putExtra("OrganDonorDiscountPremium", OrganDonorDiscountPremium);
        intent.putExtra("checkPackage", checkPackage);
        intent.putExtra("CoPaymentCheckBoxCheck", CoPaymentCheckBoxCheck);
        intent.putExtra("SubCategoryDiscountStatusCheck", SubCategoryDiscountStatusCheck);
        intent.putExtra("strCoPaymentEditText", strCoPaymentEditText);
        intent.putExtra("strSubLimitEditText", strSubLimitEditText);
        intent.putExtra("selectFirstYearChild", selectFirstYearChild);
        intent.putExtra("selectSecSonChild", selectSecSonChild);
        intent.putExtra("selectThirdSonChild", selectThirdSonChild);
        intent.putExtra("selectYearChildFour", selectYearChildFour);
        intent.putExtra("selectYearSecondAdult", selectYearSecondAdult);
        intent.putExtra("selectYearAdult", selectYearAdult);
        intent.putExtra("selectYearMotherAdult", selectYearMotherAdult);
        intent.putExtra("selectMotherLawAdult", selectMotherLawAdult);
        intent.putExtra("selectFatherLawAdult", selectFatherLawAdult);
        intent.putExtra("selectYearFatherAdult", selectYearFatherAdult);
        intent.putExtra("copayemntMax", copayemntMax);
        intent.putExtra("TiresDiscount", TiresDiscount);
        intent.putExtra("DirectPolicy", DirectPolicy);
        intent.putExtra("OrganDonar", OrganDonar);
        intent.putExtra("LongTerm", LongTerm);
        intent.putExtra("loyalityDiscount", loyalityDiscount);
        intent.putExtra("sublimt", sublimt);
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
        intent.putExtra("permAndCorresAddSame",permAndCorresAddSame);
        intent.putExtra("strDob",strDob);
        intent.putExtra("GSt", GSt);
        intent.putExtra("selectYearProposer", selectYearProposer);
        intent.putExtra("strFor", "1");
        startActivity(intent);
        finish();

    }
    @Override
    public void onBackPressed() {
        backMethod();
    }
}