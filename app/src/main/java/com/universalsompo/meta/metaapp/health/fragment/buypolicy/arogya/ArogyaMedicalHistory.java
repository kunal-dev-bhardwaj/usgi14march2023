package com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.MemberMedicalInfoCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PolicyTypeCHI;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class ArogyaMedicalHistory extends AppCompatActivity {
    String strLoyaltyDiscount,str_policyTenure,str_Payment_spinner,new_str_age,str_oneGenderSpinner,strExisting_policy_number,str_existing_spinner,TotalPremium,strParentEditText,strNominee_dob,strOneChild,str_oneWeightEdit,strtwoDob,strthreeDob,strfourDob,strtwoWeightEdit,str_thirdWeightEdit,strFourWeightEdit,GST,strAnyDisease="",strAnyhabitual,strSubLimit,strnoDiabetes,strnoSpouseDiabetes,strNoHypertension,strNoSpouseHypertension,strNoCholesterol,strNoSpouseCholesterol,strforSelf,strforSpouse,strSubLimitAmount,strAnyTreatment,strDiscount,strcriticalEdit, strCriticalIllness,strCriticalUnderSpinner,strCriticalUnderSpinner2,strperonalAccidentEdit,strPersonalAccidentSpinner,strpersonalUnder_spinner,strpersonal_under_spinner2,strhospitalEdit,strhospitalCashSpinner,strhospital_under_spinner,strhospital_under_spinner2, strOneChildCriticalIllnessTxt,stroneChildTxt,str_twoChildEditName,stroneChildPersonal_under_spinner2,strtwoChildPersonal_under_spinner2,strthirdChildPersonal_under_spinner2,strfourChildPersonal_under_spinner2;
    String NetPremium,QuoteId,str_edit_dob3String,NetPremiumValue,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_gender="",str_occupation="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob,str_spouse_edit_dob_dob,str_policyType_spinner,str_SumInsured, streditPASpinner,str_amountPersonalSumInsured,str_IndividualTypeEdit,str_OneEditName,str_thirdNameEdit,str_fourNameEdit,str_TotalValue,strFirstTString,PosPolicyNo,strChildOne,strChildTwo,strChildThree,strChildFour,today,strThirdDString,str_for,
    TotalInstallPremium,strbloodPressure,strbloodSugar,strbloodPressureDiastolic,stredtcholesterol,strProposerSpinner,strContactNominee,strNomineeName,str_RelationEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit,strAddressLine1,strAddressLine2,strAddressLine3,strpincode,strCityName,strstateName,strbloodSugarAdultTwo,strbloodPressureAdultTwo,strbloodPressureDiastolicAdultTwo,strcholesterolAdultTwo,strbloodSugarChildOne,strbloodPressureChildOne,strbloodPressureDiastolicChildOne,strcholesterolChildOne,strbloodSugarChildTwo,strbloodPressureChildTwo,strbloodPressureDiastolicChildTwo,strcholesterolChildTwo,strbloodSugarThirdChild,strbloodPressureThirdChild,strbloodPressureDiastolicThirdChild,strcholesterolThirdChild,strbloodSugarFourChild,strbloodPressureFourChild,strbloodPressureDiastolicFourChild,strcholesterolFourChild;
    Date date;
    String  BMI,Individual_BMI,twoAdult_BMI,OneChildBMI,TwoChildBMI,ThreeChildBMI,FourChildBMI,str_life_style_spinner;
    Format formatter;
    EditText policyTypeEdit,familyTypeEdit,sumInsuredEdit,policyTenureEdit,totalPremiumAmount,QuotationID,hospitalCashSpinner,bloodSugar,bloodPressure,bloodPressureDiastolic,cholesterol,bloodSugarAdultTwo,bloodPressureAdultTwo,bloodPressureDiastolicAdultTwo,cholesterolAdultTwo,bloodSugarChildOne,bloodPressureChildOne,bloodPressureDiastolicChildOne,cholesterolChildOne,bloodSugarChildTwo,bloodPressureChildTwo,bloodPressureDiastolicChildTwo,cholesterolChildTwo,bloodSugarThirdChild,bloodPressureThirdChild,bloodPressureDiastolicThirdChild,cholesterolThirdChild,bloodSugarFourChild,bloodPressureFourChild,bloodPressureDiastolicFourChild,cholesterolFourChild;
    TextView show_Breakup;
    Button btn_continue;
    CheckBox checkbox;
    LinearLayout linerAdult,adultTwoLiner,ChildOneLiner,ChildTwoLiner,thirdChildLiner,FourChildTwoLiner,PreExistingDiseaseLiner;
    RadioButton YesPreExistingRadio,NoPreExistingRadio,YesMedicalHistoryRadio, NoMedicalHistoryRadio,YesMedicineRadio, NoMedicineRadio, YesHospitalizationHistoryRadio, NoHospitalizationHistoryRadio,NoPreExistingChildOneRadio,YesPersonRadio,NoPersonRadio,YesAlcoholRadio, NoAlcoholRadio,YesSmokerRadio,NoSmokerRadio, YesTobaccoRadio, NoTobaccoRadio, YesNarcoticRadio,NoNarcoticRadio;
    EditText IllnessEditSelf,MedicalProfessionalEditSelf,MedicalTreatmentEditSelf,MedicalHistoryEditSelf,PersonEditSelf,TypeEditSpinner,OccasionallyEditSpinner,AlcoholEditSpinner,AlcoholDurationEditSpinner,TypeSmokeEditSpinner,SmokeOccasionallyEditSpinner,SmokeDurationEditSpinner,SmokeAlcoholEditSpinner,TobaccoTypeEditSelf,TobaccoEditSelf,TobaccoOccasinallyEditSelf,TobaccoDurationEditSelf;
    String strYesPreExistingRadio,strMedicalHistoryRadio,strMedicineRadio,strHospitalizationHistory,strPersonRadio,strSelfAlcoholRadio,strTypeEditSpinner,strOccasionallyEditSpinner,strAlcoholEditSpinner,strAlcoholDurationEditSpinner,strSmokerRadio,strTypeSmokeEditSpinner,strSmokeOccasionallyEditSpinner,strSmokeDurationEditSpinner,strSmokeAlcoholEditSpinner,strSelfTobaccoRadio,strTobaccoTypeEditSelf,strTobaccoEditSelf,strTobaccoOccasinallyEditSelf,strTobaccoDurationEditSelf,strNarcoticRadio;
    LinearLayout SelfConsumeAlcoholLiner,TypeSpinnerLiner,OccasionallySelfDropDownLiner,AlcoholSpinnerLiner,AlcoholDurationSpinnerLiner,SelfSmokerLiner,TypeSmokeSpinnerLiner,SmokeOccasionallySpinnerLiner,SmokeDurationSpinnerLiner,SmokeAlcoholSpinnerLiner,SelfConsumeTobaccoLiner,TobaccoTypeLinerSelf,TobaccoLinerSelf,TobaccoOccasinallyLinerSelf,TobaccoDurationLinerSelf,SelfNarcoticLiner;

    LinearLayout SmokeLinerMother,SpouseDurationSpinnerLiner,LinerSmokeTwoChild,SmokeChildFourLiner,FatherNarcoticDurationLiner,FatherNarcoticFrequencyLiner,FatherNarcoticLiner,DurationFatherTobaccoLiner,TypeFatherTobaccoLiner,SmokeFatherLiner,SmokeDurationFatherLiner,SmokeFrequencyFatherLiner,SmokeFatherQuantityLiner,SmokeTypeFatherLiner,DurationFatherLiner,TypeFatherLiner,MotherNarcoticLiner,ChildFourNarcoticLiner,ChildThirdNarcoticLiner,SmokeLinerThird,ChildTwoNarcoticDurationLiner,ChildTwoNarcoticFrequencyLinerSelf,ChildTwoFourNarcoticLiner,DurationSmokeTwoChild,SmokeLinerTwoChild,SmokeOccasinallyTwoChild,TypeSmokeTwoChild,DurationTobaccoTwoChild,TypeTobaccoTwoChild,DurationTwoChildLiner,TypeTwoChildLiner,ChildNarcoticLiner,ChildNarcoticFrequencyLiner,ChildNarcoticDurationLiner,TobaccoDurationLinerChildOne,TobaccoTypeLinerChildOne,SmokeChildOneDurationLiner,SmokeChildOneOccasionallyLiner,SmokeChildOneAlcoholLiner,TypeChildOneSmokeLiner,ChildOneSmokerLiner,TypeChildOneSpinnerLiner,ChildOneDurationSpinnerLiner,SpouseNarcoticLiner,TypeSpouseSpinnerLiner,SmokeSpouseAlcoholSpinnerLiner,TobaccoTypeLinerSpouse,TobaccoDurationLinerSpouse,SpouseNarcoticFrequencyLinerSelf,NarcoticDurationLinerSpouse,SmokeSpouseDurationSpinnerLiner,SpouseSmokerLiner,TypeSpouseSmokeSpinnerLiner,SmokeSpouseOccasionallySpinnerLiner,NarcoticFrequencyLinerSelf,NarcoticDurationLinerSelf,FatherLiner, OccasionallyFatherTobaccoLiner, TobaccoFatherLiner, OccasionallyFatherSpinnerLiner, AlcoholSpinnerFatherLiner, MotherLiner, MotherOccasionallyTobaccoLiner, MotherTobaccoLiner, MotherAlcoholSpinnerLiner, MotherOccasionallySpinnerLiner, ConsumeAlcoholLinerMother, LinerFourChild, OccasionallyTobaccoLiner, ChildThreeLiner, TobaccoOccasinallyTwoChild, TobaccoLinerTwoChild, AlcoholTwoChildSpinnerLiner, OccasionallyTwoChildSpinnerLiner, LinerChildOneLiner, OccasionallySpinnerChildOneLiner, AlcoholSpinnerLinerChildOne, ConsumeTabaccoOccasinallyLinerChildOne, ConsumeTabaccoChildOneLiner, TobaccoLinerSpouse, SposeFreQuencyLiner, OccasionallySpinnerSpouseLiner, TobaccoOccasinallyLinerSpouse, SpouseLiner, DiseaseSelfLiner, AlcoholSelfDropDownLiner, TobaccoSelfSpinnerLiner,SpouseMainDiseaseLiner, LinerConsumeAlcohol, LinerConsumeTobacco,ConsumeSpinnerLiner, ChildOneConsumeAlcoholLiner, ConsumeTabaccoLinerChildOne, DiseaseLinerChildOne, ChildTwoLinerMedical, ChildTwoDiseaseLiner, AlcoholLinerChildTwo, LinerTobaccoTwoChild, DiseaseLinerChildThird, ConsumeAlcoholThirdChildLiner, ConsumeTobaccoLiner, DiseaseLinerChildFour, ConsumeAlcoholChildFourLiner, ConsumeTobaccoChildFourLiner, MotherMainLiner, MotherDiseaseLiner,
            MotherAlcoholLiner, ConsumeTobaccoLinerMother, FatherMainLiner, FatherDiseaseLiner, ConsumeAlcoholFatherLiner, ConsumeTobaccoFatherLiner, MatherLawMainLiner, MotherLawDiseaseLiner, ConsumeAlcoholMotherLaw, ConsumeTobaccoMotherLawLiner, FatherLawTwoLiner, DiseaseLinerFatherLaw, ConsumeAlcoholFatherLawLiner, ConsumeTobaccoFatherLawLiner;
    RadioButton YesFatherNarcoticRadio,NoFatherNarcoticRadio,YesMotherNarcoticRadio,NoMotherNarcoticRadio,YesChildFourNarcoticRadio,NoChildFourNarcoticRadio,YesChildThirdNarcoticRadio,NoChildThirdNarcoticRadio,YesChildTwoNarcoticRadio,NoChildTwoNarcoticRadio,YesChildNarcoticRadio,NoChildNarcoticRadio,YesSpouseNarcoticRadio,NoSpouseNarcoticRadio,YesSmokerFatherRadio,YesPersonFatherRadio,NoPersonFatherRadio,NoSmokerFatherRadio,YesPersonMotherRadio,YesSmokerMotherRadio,NoSmokerMotherRadio,NoPersonMotherRadio,YesSmokerChildFourRadio,NoPersonChildFourRadio,YesPersonChildFourRadio,NoSmokerChildFourRadio,YesSmokerChildThirdRadio,NoSmokerChildThirdRadio,YesPersonThirdChildRadio,NoPersonThirdChildRadio,YesPersonChildTwoRadio,NoPersonChildTwoRadio,YesSmokerChildTwoRadio,NoSmokerChildTwoRadio,YesSmokerChildRadio,NoSmokerChildRadio,YesPersonChildRadio,NoPersonChildRadio,YesPersonSpouseRadio,NoPersonSpouseRadio,YesSmokerSpouseRadio,NoSmokerSpouseRadio,YesPreExistingMotherRadio, NoPreExistingMotherRadio, YesMedicineThirdChildRadio, NoMedicineThirdChildRadio, YesPreExistingThirdChildRadio, NoPreExistingThirdChildRadio, YesChildTwoHistoryRadio, NoChildTwoHistoryRadio, YesChildTwoPreExistingRadio, NoChildTwoPreExistingRadio, NoMedicineChildOneRadio, YesMedicineChildOneRadio, YesPreExistingChildOneRadio,  YesPhysicalMentalRadio, NoPhysicalMentalRadio, SpouseYesPhysicalRadio, SpouseNoPhysicalRadio, YesDiseaseSpouseRadio, NoDiseaseSpouseRadio, YesConsumeAlcoholRadio, NoConsumeAlcoholRadio, YesSpouseTobaccoRadio, NoSpouseTobaccoRadio,
            YesChildOnePhysicalRadio, NoChildOnePhysicalRadio, YesChildOnePreExistingRadio, NoChildOnePreExistingRadio, YesChildOneConsumeAlcoholRadio, NoChildOneConsumeAlcoholRadio, YesConsumeTobaccoChildOneRadio, NoConsumeTobaccoChildOneRadio, YesChildTwoPhysicalRadio, NoChildTwoPhysicalRadio, YesChildTwoPreDisease, NoChildTwoPreDisease, YesChildTwoAlcoholRadio, NoChildTwoAlcoholRadio, YesTobaccoChildTwoRadio, NoTobaccoChildTwoRadio,
            YesPhysicalChildThirdRadio, NoPhysicalChildThirdRadio, YesDiseaseChildThird, NoDiseaseChildThird, YesAlcoholRadioThirdChild, NoAlcoholRadioThirdChild, YesTobaccoThirdChild, NoTobaccoThirdChild, YesPhysicalChildFourRadio, NoPhysicalChildFourRadio, YesDiseaseChildFourRadio, NoDiseaseChildFourRadio, YesConsumeAlcoholFourChild, NoConsumeAlcoholFourChild, YesConsumeTobaccoChildFour, NoConsumeTobaccoChildFour, YesMotherPhysical, NoMotherPhysical, YesDiseaseMother, NoDiseaseMother, YesConsumeAlcoholMother, NoConsumeAlcoholMother, YesConsumeTobaccoMother, NoConsumeTobaccoMother, YesFatherPhysical, NoFatherPhysical, YesDiseaseFather, NoDiseaseFather, YesConsumeAlcoholFather, NoConsumeAlcoholFather, YesConsumeTobaccoFather, NoConsumeTobaccoFather, YesMotherLawPhysical, NoMotherLawPhysical, YesDiseaseMotherLaw, NoDiseaseMotherLaw, YesConsumeAlcoholMotherLaw, NoConsumeAlcoholMotherLaw, YesConsumeTobaccoMotherLaw, NoConsumeTobaccoMotherLaw, YesPhysicalFatherLaw, NoPhysicalFatherLaw, YesDiseaseFatherLaw, NoDiseaseFatherLaw, YesConsumeAlcoholFatherLaw, NoConsumeAlcoholFatherLaw, YesConsumeTobaccoFatherLaw, NoConsumeTobaccoFatherLaw;
    EditText PersonEditFather,TreatmentHistoryEditFather,MedicalTreatmentEditFather,MedicalEditFather,IllnessEditFather,FatherNarcoticDurationEdit,FatherNarcoticEdit,DurationFatherTobaccoEdit,TypeFatherTobaccoEdit,SmokeDurationFatherEdit,SmokeFrequencyFatherEdit,SmokeQuantityFatherEdit,SmokeTypeFatherEdit,DurationFatherEdit,TypeFatherEdit,PersonEditMother,MedicalTreatmentEditMother,MedicalEditMother,MedicalHealthEditMother,IllnessEditMother,MotherNarcoticDurationEdit,MotherNarcoticEdit,MotherDurationSmokeEdit,MotherSmokeEditFrequency,MotherOccasionallySmokeEdit,MotherTypeSmokeEdit,MotherDurationTobaccoEdit,MotherTypeTobaccoEdit,MotherDurationEdit,MotherTypeEdit,PersonEditChild4,HospitalizedEditChild4,MedicalTreatmentEditChild4,MedicalEditChild4,IllnessEditChild4,ChildFourNarcoticDurationEdit,ChildFourNarcoticEdit,DurationSmokeEditChild4,SmokeEditFrequencyChild4,SmokeQuantityEdit,SmokeTypeEditChild4,DurationTobaccoEditChild4,TypeTobaccoEditChild4,DurationAlcoholEditChild4,TypeAlcoholEditChild4,PersonEditChild3,HospitizationTreatmentEditChild3,MedicalTreatmentEditChild3,MedicalEditChild3,IllnessEditChild3,ChildThirdNarcoticDurationEdit,ChildThirdNarcoticEdit,DurationTobaccoEditThirdChild,TypeTobaccoEditThirdChild,DurationSmokeEditThirdChild,FrequencySmokeEditThirdChild,QuantitySmokeEditThirdChild,TypeSmokeEditThirdChild,DurationEditThirdChild,TypeEditThirdChild,PersonEditChildTwo,HospitalizedEditChildTwo,TreatmentEditChildTwo,MedicineEditChildTwo,IllnessEditChildTwo,ChildTwoNarcoticDurationEdit,ChildTwoNarcoticEditSelf,DurationSmokeEditTwoChild,SmokeEditTwoChild,SmokeOccasinallyEditTwoChild,TypeSmokeEditTwoChild,DurationTobaccoEditTwoChild,TypeTobaccoEditTwoChild,DurationTwoChildEdit,TypeTwoChildEdit,ChildNarcoticDurationEdit,ChildNarcoticEdit,TobaccoDurationEditChild1,TobaccoTypeEditChildOne,SmokeChildOneDurationEdit,SmokeChildOneAlcoholEdit,SmokeChildOneOccasionallyEdit,TypeChildOneSmokeEdit,TypeChildOneEditSpinner,ChildOneDurationEditSpinner,PersonEditChildOne,PreExistingEditChildOne,DiseaseEditChildOne,PhysicalEditChildOne,IllnessEditChildOne,PersonEditSpouse,HospitalizationEditSpouse,DiseaseEditSpouse,PhysicalEditSpouse,IllnessEditSpouse,NarcoticDurationEditSpouse,NarcoticEditSpouse,TobaccoDurationEditSpouse,TobaccoTypeEditSpouse,SpouseDurationEditSpinner,TypeSpouseEditSpinner,SmokeSpouseDurationEditSpinner,SmokeSpouseAlcoholEditSpinner,TypeSpouseSmokeEditSpinner,SmokeSpouseOccasionallyEditSpinner,NarcoticEditSelf,NarcoticDurationEditSelf,OccasionallyFatherTobaccoSpinner, TobaccoFatherSpinner, OccasionallyFatherEditSpinner, AlcoholEditFatherSpinner, MotherOccasionallyTobaccoSpinner, MotherTobaccoEditSpinner, MotherOccasionallyEditSpinner, MotherAlcoholEditSpinner, OccasionallyLiterSpinner, AlcoholEditFrequency, OccasionallyTobaccoSpinner, TobaccoEditFrequency, OccasionallyEditThirdChild, AlcoholEditThirdChild, OccasionallyEditSpinnerThirdChild, AlcoholEditSpinnerThirdChild, TobaccoOccasinallyEditTwoChild, TobaccoEditTwoChild, AlcoholTwoChildEditSpinner, OccasionallyTwoChildEditSpinner, ConsumeTabaccoChildOneSpinner, ConsumeTabaccoChildOne, OccasionallyEditChildOneSpinner, AlcoholEditSpinnerChildOne, TobaccoOccasinallyEditSpouse, TobaccoEditSpouse, OccasionallySpouseEditSpinner, SpouseEditFrequency, PreExistingDiseaseEdit, bloodSugarMother, bloodPressureMother, bloodPressureDiastolicMother, cholesterolMother, bloodSugarFather, bloodPressureFather, bloodPressureDiastolicFather, cholesterolFather, bloodSugarMatherLaw, bloodPressureMatherLaw, bloodPressureDiastolicMatherLaw, cholesterolMatherLaw, bloodSugarFatherLaw, bloodPressureFatherLaw, bloodPressureDiastolicFatherLaw, cholesterolFatherLaw;
    String firstName, middleName,lastName,address1,address2,address3,corresAddress1,corresAddress2,corresAddress3,SterilityInfertilityMale,MaternityAndChildcareMale,strNomineeGenderEdit,strPersonEditFather,strTreatmentHistoryEditFather,strMedicalTreatmentEditFather,strMedicalEditFather,strIllnessEditFather,strFatherNarcoticDurationEdit,strFatherNarcoticEdit,strFatherNarcotic,strDurationFatherTobaccoEdit,strTypeFatherTobaccoEdit,strSmokeDurationFatherEdit,strSmokeFrequencyFatherEdit,strSmokeQuantityFatherEdit,strSmokeTypeFatherEdit,strDurationFatherEdit,strTypeFatherEdit,strPersonEditMother,strMedicalTreatmentEditMother,strMedicalEditMother,strMedicalHealthEditMother,strIllnessEditMother,strMotherNarcoticDurationEdit,strMotherNarcoticEdit,strMotherNarcotic,strMotherDurationSmokeEdit,strMotherSmokeEditFrequency,strMotherOccasionallySmokeEdit,strMotherTypeSmokeEdit,strMotherDurationTobaccoEdit,strMotherTypeTobaccoEdit,strMotherDurationEdit,strMotherTypeEdit,strPersonEditChild4,strHospitalizedEditChild4,strMedicalTreatmentEditChild4,strMedicalEditChild4,strIllnessEditChild4,strChildFourNarcoticDurationEdit,strChildFourNarcoticEdit,strDurationSmokeEditChild4,strSmokeEditFrequencyChild4,strSmokeQuantityEdit,strSmokeTypeEditChild4,strDurationTobaccoEditChild4,strTypeTobaccoEditChild4,strDurationAlcoholEditChild4,strTypeAlcoholEditChild4,strPersonEditChild3,strHospitizationTreatmentEditChild3,strMedicalTreatmentEditChild3,strMedicalEditChild3,strIllnessEditChild3,strChildThirdNarcoticDurationEdit,strChildThirdNarcoticEdit,strChildThirdNarcotic,strDurationTobaccoEditThirdChild,strTypeTobaccoEditThirdChild,strDurationSmokeEditThirdChild,strFrequencySmokeEditThirdChild,strQuantitySmokeEditThirdChild,strTypeSmokeEditThirdChild,strDurationEditThirdChild,strTypeEditThirdChild,strPersonEditChildTwo,strHospitalizedEditChildTwo,strTreatmentEditChildTwo,strMedicineEditChildTwo,strIllnessEditChildTwo,strChildTwoNarcoticDurationEdit,strChildTwoNarcoticEditSelf,strChildTwoNarcotic,strDurationSmokeEditTwoChild,strSmokeEditTwoChild,strSmokeOccasinallyEditTwoChild,strTypeSmokeEditTwoChild,strDurationTobaccoEditTwoChild,strTypeTobaccoEditTwoChild,strDurationTwoChildEdit,strTypeTwoChildEdit,strChildNarcoticDurationEdit,strChildNarcoticEdit,strChildNarcotic,strTobaccoDurationEditChild1,strTobaccoTypeEditChildOne,strSmokeChildOneDurationEdit,strSmokeChildOneAlcoholEdit,strSmokeChildOneOccasionallyEdit,strTypeChildOneSmokeEdit,strTypeChildOneEditSpinner,strChildOneDurationEditSpinner,strPersonEditChildOne,strPreExistingEditChildOne,strDiseaseEditChildOne,strPhysicalEditChildOne,strIllnessEditChildOne,strPersonEditSpouse,strIllnessEditSpouse,strPhysicalEditSpouse,strDiseaseEditSpouse,strHospitalizationEditSpouse,strNarcoticDurationEditSpouse,strNarcoticEditSpouse,strTobaccoDurationEditSpouse,strTobaccoTypeEditSpouse,strSpouseDurationEditSpinner,strTypeSpouseEditSpinner,strSmokeSpouseDurationEditSpinner,strSmokeSpouseAlcoholEditSpinner,strTypeSpouseSmokeEditSpinner,strSmokeSpouseOccasionallyEditSpinner,strMedicalProfessionalEditSelf,strMedicalTreatmentEditSelf,strMedicalHistoryEditSelf,strPersonEditSelf,strIllnessEditSelf,strNarcoticEditSelf,strNarcoticDurationEditSelf,strPersonFather,strSmokerFather,strPersonMotherRadio,strSmokerMotherRadio,TreatmentCheckBoxCheck,strBasicPremium,GSt,strDiseaseMother, strPreExistingMother, strTobaccoEditFrequency, strPreExistingThirdChild, strChildTwoPreExisting, strCoPaymentEditText, strSubLimitEditText, SubCategoryDiscountStatusCheck = "", CoPaymentCheckBoxCheck = "", checkPackage, strAppointeeNomineeName, strAppointeeNomineeDobEdit, strAppointeeGenderEdit, OrganDiscountStatus, PersonalStatusChildOne, PersonalStatusChildTwo, PersonalStatusChildThird, PersonalStatusChildFour, PersonalAccidentCategory, strPackage1 = "", strPackageTwo = "", strPackageThree = "", strPackageFour = "", strPackageFive = "", strPackageSix = "", DirectPolicyDiscountPremium, LongTermDiscountStatus, SubCategoryDiscountStatus, SubCategory,strGenderChildOneEdit, strChildOneNameEdit, strRelationEditSpouse, strSpouseOccupationEdit, strSpouseNameEditText = "", strSpouseGenderEdit, strFtSpouseEdit, strInchesSpouseEdit, strWeightEditSpouse, strSpouseBMIEdit,
            strBMIChildEdit, strSecondChildNameEdit, str_twoGenderSpinner, str_twoFtSpinner, str_twoInchesSpinner, str_oneFtSpinner, str_oneInchesSpinner, strOccupationEditChildOne, str_twoOccupationSpinner, str_thirdOccupationSpinner, str_fourOccupationSpinner, strMotherFeetEditText, strInchesMotherEdit, strMotherRelationShipEdit = "", strMotherWeightEdit = "", strMotherOccupationEdit = "", strMotherEditTextName = "", strMotherGenderEdit = "", strFatherOccupationEdit = "", strOccupationEditMotherLaw = "", strBMIMotherEdit = "", strFatherEditTextName = "", strFatherGenderEditTet = "", strRelationFatherEdit = "", strFatherWeightEdit = "", strFeetFatherEdit = "", strInchesFatherEdit = "", strBMIFatherEdit = "", strMotherLawEditText = "", strRelationMotherLawEdit = "", strWeightMotherLawEdit = "", strFeetEditTextMotherLaw = "", strInchesEditTextMotherLaw = "", strBMIMotherLawEdit = "", strFatherLawNameEdit = "", strFatherLawGenderEditText = "", strOccupationFatherLawEdit = "", strRelationEditTextFatherLaw = "", strFatherLawWeightEdit = "", strEditFeetFatherLaw = "", strEditInchesFatherLaw = "", strFatherLawBMIEdit = "", FamilyComposition = "", ParentComposition = "",
            strBMIChildTwoEdit, strThirdChildNameEdit, str_thirdGenderSpinner, str_thirdFtSpinner, str_thirdInchesSpinner, strBMIEChildThreeEdit,
            strFourChildNameEdit, str_fourGenderSpinner, str_fourFtSpinner, str_fourInchesSpinner, strBMIFourChildEdit, strCheckBoxSelf, strSelfAgeEditText = "", strTotalPremium = "", strYesPhysicalMentalRadio = "", strSpousePhysicalRadio = "", strDiseaseSpouseRadio = "", strConsumeSpouseAlcohol = "", strSpouseTobaccoRadio = "", strChildOnePhysicalRadio = "", strChildOnePreExisting = "", strChildOneConsumeAlcoholRadio = "", strConsumeTobaccoChildOneRadio = "", strChildTwoPhysicalRadio = "", strChildTwoPreDisease = "", strChildTwoAlcoholRadio = "", strTobaccoChildTwoRadio = "", strPhysicalChildThirdRadio = "", strDiseaseChildThird = "", strAlcoholRadioThirdChild = "", strTobaccoThirdChild = "", strPhysicalChildFourRadio = "", strDiseaseChildFourRadio = "", strMotherPhysical = "",
            strConsumeAlcoholMother = "", strConsumeTobaccoMother = "", strFatherPhysical = "", strDiseaseFather = "", strConsumeAlcoholFather = "", strConsumeTobaccoFather = "", strMotherLawPhysical = "", strDiseaseMotherLaw = "", strConsumeAlcoholMotherLaw = "", strConsumeTobaccoMotherLaw = "", strPhysicalFatherLaw = "", strDiseaseFatherLaw = "", strConsumeAlcoholFatherLaw = "", strConsumeTobaccoFatherLaw = "";
    LinearLayout MotherNarcoticDurationLiner,MotherNarcoticFrequencyLiner,MotherDurationSmokeLiner,MotherSmokeLinerFrequency,MotherOccasionallySmokeLiner,MotherTypeSmokeLiner,MotherDurationTobaccoLiner,MotherTypeTobaccoLiner,MotherTypeLiner,MotherDurationLiner,ChildFourNarcoticDurationLiner,ChildFourNarcoticFrequencyLiner,DurationSmokeLinerChild4,SmokeFrequencyLinerChild4,SmokeQuantityLiterLiner,SmokeTypeLinerChild4,DurationTobaccoLinerChild4,TypeTobaccoLinerChild4,TypeAlcoholLinerChild4,DurationAlcoholLinerChild4,ChildThirdNarcoticDurationLiner,ChildThirdNarcoticFrequencyLiner,DurationTobaccoThirdChild,TypeTobaccoThirdChild,DurationSmokeThirdChildLiner,FrequencySmokeThirdChildLiner,QuantitySmokeThirdChildLiner,TypeSmokeThirdChildLiner,TypeLinerThirdChild,DurationLinerThirdChild,OccasionallyLiterLiner, AlcoholFrequencyLiner, TobaccoFrequencyLiner, OccasionallyThirdChild, AlcoholThirdChildSpinnerLiner, OccasionallySpinnerLinerThirdChild, AlcoholSpinnerLinerThirdChild, continueButton, PreExistingDiseaseDropDownLiner;
    TextView TotalPremiumTxt, ViewDetails,MotherTxt,FatherTxt,InsuredTxt;
    String PersonalAccidentCoverPremium, CriticalIllnessCoverPremium = "", DailyHospitalCoverPremium = "", ModernTreatmentCoverPremium = "", ExtensionPreHospitalizationCoverPremium = "", ExtensionProHospitalizationCoverPremium = "", MaternityChildcareCoverPremium = "", CoverageNonMedicalCoverPremium = "", ConditionWaiverCoverPremium = "", PreExistingDiseaseCoverPremium = "", OutpatientDentalCoverPremium = "", EmergencyTravellingCoverPremium = "", SecondOpinionCoverPremium = "", RestCureCoverPremium = "", ObesityWeightCoverPremium = "", SterilityInfertilityCoverPremium = "", EnhancedCoverPremium = "", PremiumWaiverCoverPremium = "", GlobalCoverCoverPremium = "", MedicallyAdvisedCoverPremium = "", EmergencyAssistanceCoverPremium = "", HomeCareCoverPremium = "", WellnessBenefitCoverPremium = "", DiseaseManagementCoverPremium = "";
    String strProposerBMIEdit, strWeightEditProposer, strProposerEdtName, strProposerEditDob, strProposerEditFt, strProposerEditInches, strEditGenderProposer, strEditOccupationProposer, strProposerRelationEdit, yearRadio, strPreExistingDiseaseEdit = "", MaternityAndChildcareAddOn, strPolicyTenure = "", PlanType = "", strSumInsured = "", strPlanTypeTXT = "", strEdtNameSelf = "", strEmailIDEditSelf = "", strEditGenderSelf = "", strEditOccupationSelf = "", strPinCodeEdit = "", strPermanentAddressEdit2 = "", strPermanentAddressEdit = "", strStateEdit = "", strCityEdit = "", strEditInchesSelf = "", strEditFtSelf = "", strWeightEditSelf = "", strBMIEdit = "", strNomineeRelationEdit = "", strNomineeDobEdit = "", strBloodSugar = "", strBloodPressure = "", strBloodPressureDiastolic = "", strcholesterol = "";
    String strswitch = "", strCorrespondenceAddressEdit = "", strCorrespondenceAddressEdit2 = "", EmergencyTravellingStatus = "", strPolicyNumber = "", CoPaymentLoading = "", BasicStatus = "", PersonalStatus = "", CriticalStatus = "", DailyHospitalSatus = "", ModernTreatmentsStatus = "", ExtensionPreHospitalization = "", ExtensionPr0Hospitalization = "", MaternityAndChildcare = "", CoverageNonMedical = "", ConditionWaiverStatus = "", PersonalAccidentACoverStatus = "", PersonalAccidentBCoverStatus = "", PreExistingDiseaseStatus = "", OutpatientDentalStatus = "", SecondOpinionStatus = "", RestCureStatus = "", ObesityWeightStatus = "", SterilityInfertilityStatus = "", EnhancedOrganStatus = "", GlobalCoverStatus = "", MedicallyAdvisedStatus = "", EmergencyAssistanceStatus = "", HomeCareStatus = "", WellnessBenefitStatus = "", DiseaseManagementStatus = "", LoyaltyDiscountStatus = "", CoPaymentStatus = "", PremiumWaiverStatus = "", strGenderSpinner = "", strCheckBoxSpouse = "", strSpouseAgeEditText = "", strCheckBoxMother = "", strMotherAgeEditText = "", strFatherAgeEditText = "", strCheckBoxFather = "", strCheckBoxMotherLaw = "", strMotherLawAgeEditText = "", strCheckBoxFatherLaw = "", strFatherLawAgeEditText = "", strFirstSonAgeEditText = "", strSecondSonAgeEditText = "", strThirdSonAgeEditText = "", strFourSonAgeEditText = "", strCheckBoxSon = "", strFor = "", strSpouseDobEdit = "";
    RadioButton YesFatherHistoryRadio, NoFatherHistoryRadio, YesPreExistingFatherRadio, NoPreExistingFatherRadio, YesMotherHistoryRadio, NoMotherHistoryRadio, YesHistoryFourChildRadio, NoHistoryFourChildRadio, NoPreExistingFourChildRadio, YesPreExistingFourChildRadio, YesRadioSufferingDiseaseSecondAdult, NoRadioSufferingDiseaseSecondAdult, YesHospitalizationHistoryAdultSecondRadio, NoHospitalizationHistoryAdultSecondRadio;
    String strChildFourNarcotic,strSpouseNarcoticRadio,strSmokerChildFourChild,strPersonChildFourChild,strPersonChildTwo,strPersonChildThird,strSmokerChildThird,strSmokerChildTwo,strPersonChildRadio,strSmokerChildRadio,strSmokerSpouseRadio,strPersonSpouseRadio,strConsumeTobacco, strMotherHistoryRadio, strAlcoholEditFrequency, strOccasionallyTobaccoSpinner, strConsumeAlcoholFourChild, strHistoryFourChild, strSufferingDiseaseSecondAdult, strHospitalizationHistoryAdultSecond, strSpouseEditFrequency, strOccasionallySpouseEditSpinner, strTobaccoEditSpouse, strTobaccoOccasinallyEditSpouse, strPreExistingChildOneRadio, strMedicineChildOneRadio, strAlcoholEditSpinnerChildOne, strOccasionallyEditChildOneSpinner, strConsumeTabaccoChildOne, strConsumeTabaccoChildOneSpinner, strChildTwoHistory, strAlcoholTwoChildEditSpinner, strOccasionallyTwoChildEditSpinner, strTobaccoEditTwoChild, strTobaccoOccasinallyEditTwoChild, strMedicineThirdChildRadio, strAlcoholEditSpinnerThirdChild, strOccasionallyEditSpinnerThirdChild, strAlcoholEditThirdChild, strOccasionallyEditThirdChild, strPreExistingFourChild, strOccasionallyLiterSpinner,
            strMotherAlcoholEditSpinner, strMotherOccasionallyEditSpinner, strMotherTobaccoEditSpinner, strMotherOccasionallyTobaccoSpinner, strPreExistingFather, strFatherHistory, strAlcoholEditFatherSpinner, strOccasionallyFatherEditSpinner, strTobaccoFatherSpinner, strOccasionallyFatherTobaccoSpinner;

    int FamilyTypeCounter,ParentCounter,selectAppointee,selectNomineeYear,selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour;
    String strMotherFtEdit,strFatherLawInchesEdit,strMotherInchesEdit,strFatherFtEdit,strFatherInchesEdit,strMotherLawFtEdit,strMotherLawInchesEdit,strFatherLawFtEdit,strMotherName,strMotherDob,strFatherName,strFatherDob,strMotherLawName,strMotherLawDob,strMotherLawOccupationEdit,strMotherLawWeightEdit,strFatherLawName, strFatherLawDob,strFatherLawOccupationEdit,selectYearMother,selectYearFather,selectYearMotherLaw,selectYearFatherLaw, MotherBMI,FatherBMI,MotherLawBMI,FatherLawBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arogya_medical_history);

        getWindow().setStatusBarColor(ContextCompat.getColor(ArogyaMedicalHistory.this, R.color.colorPrimaryDark));
        str_edt_name = getIntent().getStringExtra("str_edt_name");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        str_email = getIntent().getStringExtra("str_email");
        str_age = getIntent().getStringExtra("str_age");
        str_edit_dob3String = getIntent().getStringExtra("str_edit_dob3String");
        str_reference_no = getIntent().getStringExtra("str_reference_no");
        str_edit_dob = getIntent().getStringExtra("str_edit_dob");
        str_gender = getIntent().getStringExtra("str_gender");
        str_occupation = getIntent().getStringExtra("str_occupation");
        str_ft = getIntent().getStringExtra("str_ft");
        str_inches = getIntent().getStringExtra("str_inches");
        str_weight_edit = getIntent().getStringExtra("str_weight_edit");
        str_edt_Spouse_name = getIntent().getStringExtra("str_edt_Spouse_name");
        str_spouse_edit_dob_dob = getIntent().getStringExtra("str_spouse_edit_dob_dob");
        str_spouse_gender = getIntent().getStringExtra("str_spouse_gender");
        str_spouse_occupation_spinner = getIntent().getStringExtra("str_spouse_occupation_spinner");
        str_spouse_ft_spinner = getIntent().getStringExtra("str_spouse_ft_spinner");
        str_spouse_inches_spinner = getIntent().getStringExtra("str_spouse_inches_spinner");
        str_spouse_weight_edit = getIntent().getStringExtra("str_spouse_weight_edit");
        str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
        str_SumInsured = getIntent().getStringExtra("str_SumInsured");
        str_IndividualTypeEdit = getIntent().getStringExtra("str_IndividualTypeEdit");
        str_OneEditName = getIntent().getStringExtra("str_OneEditName");
        str_twoChildEditName = getIntent().getStringExtra("str_twoChildEditName");
        str_thirdNameEdit = getIntent().getStringExtra("str_thirdNameEdit");
        str_fourNameEdit = getIntent().getStringExtra("str_fourNameEdit");
        str_TotalValue = getIntent().getStringExtra("TotalValue");
        strFirstTString = getIntent().getStringExtra("strFirstTString");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        strChildOne = getIntent().getStringExtra("strChildOne");
        strChildTwo = getIntent().getStringExtra("strChildTwo");
        strChildThree = getIntent().getStringExtra("strChildThree");
        strChildFour = getIntent().getStringExtra("strChildFour");
        NetPremiumValue = getIntent().getStringExtra("NetPremiumValue");
        GST = getIntent().getStringExtra("GST");
        strOneChild = getIntent().getStringExtra("strOneChild");
        str_oneWeightEdit = getIntent().getStringExtra("str_oneWeightEdit");
        strtwoDob = getIntent().getStringExtra("strtwoDob");
        strthreeDob = getIntent().getStringExtra("strthreeDob");
        strfourDob = getIntent().getStringExtra("strfourDob");
        strtwoWeightEdit = getIntent().getStringExtra("strtwoWeightEdit");
        str_thirdWeightEdit = getIntent().getStringExtra("str_thirdWeightEdit");
        strFourWeightEdit = getIntent().getStringExtra("strFourWeightEdit");
        str_for = getIntent().getStringExtra("for");
        str_amountPersonalSumInsured = getIntent().getStringExtra("str_amountPersonalSumInsured");
        strhospitalEdit = getIntent().getStringExtra("strhospitalEdit");
        strcriticalEdit = getIntent().getStringExtra("strcriticalEdit");
        strSubLimitAmount = getIntent().getStringExtra("strSubLimitAmount");
        strDiscount = getIntent().getStringExtra("strDiscount");
        NetPremiumValue = getIntent().getStringExtra("NetPremiumValue");
        strbloodSugar = getIntent().getStringExtra("strbloodSugar");
        strbloodPressure = getIntent().getStringExtra("strbloodPressure");
        strbloodPressureDiastolic = getIntent().getStringExtra("strbloodPressureDiastolic");
        stredtcholesterol = getIntent().getStringExtra("stredtcholesterol");
        strProposerSpinner = getIntent().getStringExtra("strProposerSpinner");
        strContactNominee = getIntent().getStringExtra("strContactNominee");
        strNomineeName = getIntent().getStringExtra("strNomineeName");
        str_RelationEdit = getIntent().getStringExtra("str_RelationEdit");
        strRelationAdultOneEdit = getIntent().getStringExtra("strRelationAdultOneEdit");
        strRelationChildEdit = getIntent().getStringExtra("strRelationChildEdit");
        strRelationChildTwoEdit = getIntent().getStringExtra("strRelationChildTwoEdit");
        strRelationChildThreeEdit = getIntent().getStringExtra("strRelationChildThreeEdit");
        strRelationFourChildEdit = getIntent().getStringExtra("strRelationFourChildEdit");
        strAddressLine1 = getIntent().getStringExtra("strAddressLine1");
        strAddressLine2 = getIntent().getStringExtra("strAddressLine2");
        strAddressLine3 = getIntent().getStringExtra("strAddressLine3");
        strpincode = getIntent().getStringExtra("strpincode");
        strCityName = getIntent().getStringExtra("strCityName");
        strstateName = getIntent().getStringExtra("strstateName");
        NetPremium = getIntent().getStringExtra("NetPremium");
        QuoteId = getIntent().getStringExtra("QuoteId");
        strNominee_dob = getIntent().getStringExtra("strNominee_dob");
        TotalInstallPremium = getIntent().getStringExtra("TotalInstallPremium");
        str_existing_spinner = getIntent().getStringExtra("str_existing_spinner");
        strExisting_policy_number = getIntent().getStringExtra("strExisting_policy_number");
        str_oneGenderSpinner = getIntent().getStringExtra("str_oneGenderSpinner");
        str_oneFtSpinner = getIntent().getStringExtra("str_oneFtSpinner");
        str_oneInchesSpinner = getIntent().getStringExtra("str_oneInchesSpinner");
        str_twoGenderSpinner = getIntent().getStringExtra("str_twoGenderSpinner");
        str_twoFtSpinner = getIntent().getStringExtra("str_twoFtSpinner");
        str_twoInchesSpinner = getIntent().getStringExtra("str_twoInchesSpinner");
        str_thirdGenderSpinner = getIntent().getStringExtra("str_thirdGenderSpinner");
        str_thirdFtSpinner = getIntent().getStringExtra("str_thirdFtSpinner");
        str_thirdInchesSpinner = getIntent().getStringExtra("str_thirdInchesSpinner");
        str_fourGenderSpinner = getIntent().getStringExtra("str_fourGenderSpinner");
        str_fourFtSpinner = getIntent().getStringExtra("str_fourFtSpinner");
        str_fourInchesSpinner = getIntent().getStringExtra("str_fourInchesSpinner");
        new_str_age = getIntent().getStringExtra("new_str_age");
        str_Payment_spinner = getIntent().getStringExtra("str_Payment_spinner");
        str_policyTenure = getIntent().getStringExtra("str_policyTenure");
        strLoyaltyDiscount = getIntent().getStringExtra("strLoyaltyDiscount");
        strParentEditText = getIntent().getStringExtra("strParentEditText");
        BMI = getIntent().getStringExtra("BMI");
        Individual_BMI = getIntent().getStringExtra("Individual_BMI");
        twoAdult_BMI = getIntent().getStringExtra("twoAdult_BMI");
        OneChildBMI = getIntent().getStringExtra("OneChildBMI");
        TwoChildBMI = getIntent().getStringExtra("TwoChildBMI");
        ThreeChildBMI = getIntent().getStringExtra("ThreeChildBMI");
        FourChildBMI = getIntent().getStringExtra("FourChildBMI");
        str_life_style_spinner = getIntent().getStringExtra("str_life_style_spinner");
        selectYearAdult = getIntent().getIntExtra("selectYearAdult", 0);
        selectYearSecondAdult = getIntent().getIntExtra("selectYearSecondAdult", 0);
        selectYearChild = getIntent().getIntExtra("selectYearChild", 0);
        selectYearChildTwo = getIntent().getIntExtra("selectYearChildTwo", 0);
        selectYearChildThird = getIntent().getIntExtra("selectYearChildThird", 0);
        selectYearChildFour = getIntent().getIntExtra("selectYearChildFour", 0);
        selectNomineeYear = getIntent().getIntExtra("selectNomineeYear", 0);
        strAppointeeNomineeName = getIntent().getStringExtra("strAppointeeNomineeName");
        strAppointeeNomineeDobEdit = getIntent().getStringExtra("strAppointeeNomineeDobEdit");
        strAppointeeGenderEdit = getIntent().getStringExtra("strAppointeeGenderEdit");
        FamilyTypeCounter = getIntent().getIntExtra("FamilyTypeCounter", 0);
        ParentCounter = getIntent().getIntExtra("ParentCounter", 0);
        strMotherName = getIntent().getStringExtra("strMotherName");
        strMotherDob = getIntent().getStringExtra("strMotherDob");
        strMotherOccupationEdit = getIntent().getStringExtra("strMotherOccupationEdit");
        strMotherWeightEdit = getIntent().getStringExtra("strMotherWeightEdit");
        strFatherName = getIntent().getStringExtra("strFatherName");
        strFatherDob = getIntent().getStringExtra("strFatherDob");
        strFatherWeightEdit = getIntent().getStringExtra("strFatherWeightEdit");
        strFatherOccupationEdit = getIntent().getStringExtra("strFatherOccupationEdit");
        strMotherLawName = getIntent().getStringExtra("strMotherLawName");
        strMotherLawDob = getIntent().getStringExtra("strMotherLawDob");
        strMotherLawOccupationEdit = getIntent().getStringExtra("strMotherLawOccupationEdit");
        strMotherLawWeightEdit = getIntent().getStringExtra("strMotherLawWeightEdit");
        strFatherLawName = getIntent().getStringExtra("strFatherLawName");
        strFatherLawDob = getIntent().getStringExtra("strFatherLawDob");
        strFatherLawOccupationEdit = getIntent().getStringExtra("strFatherLawOccupationEdit");
        strFatherLawWeightEdit = getIntent().getStringExtra("strFatherLawWeightEdit");
        selectYearMother = getIntent().getStringExtra("selectYearMother");
        selectYearFather = getIntent().getStringExtra("selectYearFather");
        selectYearMotherLaw = getIntent().getStringExtra("selectYearMotherLaw");
        selectYearFatherLaw = getIntent().getStringExtra("selectYearFatherLaw");
        MotherBMI = getIntent().getStringExtra("MotherBMI");
        FatherBMI = getIntent().getStringExtra("FatherBMI");
        MotherLawBMI = getIntent().getStringExtra("MotherLawBMI");
        FatherLawBMI = getIntent().getStringExtra("FatherLawBMI");
        strMotherFtEdit = getIntent().getStringExtra("strMotherFtEdit");
        strMotherInchesEdit = getIntent().getStringExtra("strMotherInchesEdit");
        strFatherFtEdit = getIntent().getStringExtra("strFatherFtEdit");
        strFatherInchesEdit = getIntent().getStringExtra("strFatherInchesEdit");
        strMotherLawFtEdit = getIntent().getStringExtra("strMotherLawFtEdit");
        strMotherLawInchesEdit = getIntent().getStringExtra("strMotherLawInchesEdit");
        strFatherLawFtEdit = getIntent().getStringExtra("strFatherLawFtEdit");
        strFatherLawInchesEdit = getIntent().getStringExtra("strFatherLawInchesEdit");

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

        initView();
    }

    private void initView() {
        policyTypeEdit=findViewById(R.id.policyTypeEdit);
        familyTypeEdit=findViewById(R.id.familyTypeEdit);
        sumInsuredEdit=findViewById(R.id.sumInsuredEdit);
        policyTenureEdit=findViewById(R.id.policyTenureEdit);
        totalPremiumAmount=findViewById(R.id.totalPremiumAmount);
        show_Breakup=findViewById(R.id.show_Breakup);
        QuotationID=findViewById(R.id.QuotationID);
        bloodSugar=findViewById(R.id.bloodSugar);
        bloodPressure=findViewById(R.id.bloodPressure);
        bloodPressureDiastolic=findViewById(R.id.bloodPressureDiastolic);
        cholesterol=findViewById(R.id.cholesterol);
        hospitalCashSpinner=findViewById(R.id.hospitalCashSpinner);
        checkbox=findViewById(R.id.checkbox);
        linerAdult=findViewById(R.id.linerAdult);
        adultTwoLiner=findViewById(R.id.adultTwoLiner);
        ChildOneLiner=findViewById(R.id.ChildOneLiner);
        ChildTwoLiner=findViewById(R.id.ChildTwoLiner);
        thirdChildLiner=findViewById(R.id.thirdChildLiner);
        FourChildTwoLiner=findViewById(R.id.FourChildTwoLiner);
        bloodSugarAdultTwo=findViewById(R.id.bloodSugarAdultTwo);
        bloodPressureAdultTwo=findViewById(R.id.bloodPressureAdultTwo);
        bloodPressureDiastolicAdultTwo=findViewById(R.id.bloodPressureDiastolicAdultTwo);
        cholesterolAdultTwo=findViewById(R.id.cholesterolAdultTwo);
        bloodSugarChildOne=findViewById(R.id.bloodSugarChildOne);
        bloodPressureChildOne=findViewById(R.id.bloodPressureChildOne);
        bloodPressureDiastolicChildOne=findViewById(R.id.bloodPressureDiastolicChildOne);
        cholesterolChildOne=findViewById(R.id.cholesterolChildOne);
        bloodSugarChildTwo=findViewById(R.id.bloodSugarChildTwo);
        bloodPressureChildTwo=findViewById(R.id.bloodPressureChildTwo);
        bloodPressureDiastolicChildTwo=findViewById(R.id.bloodPressureDiastolicChildTwo);
        cholesterolChildTwo=findViewById(R.id.cholesterolChildTwo);
        bloodSugarThirdChild=findViewById(R.id.bloodSugarThirdChild);
        bloodPressureThirdChild=findViewById(R.id.bloodPressureThirdChild);
        bloodPressureDiastolicThirdChild=findViewById(R.id.bloodPressureDiastolicThirdChild);
        cholesterolThirdChild=findViewById(R.id.cholesterolThirdChild);
        bloodSugarFourChild=findViewById(R.id.bloodSugarFourChild);
        bloodPressureFourChild=findViewById(R.id.bloodPressureFourChild);
        bloodPressureDiastolicFourChild=findViewById(R.id.bloodPressureDiastolicFourChild);
        cholesterolFourChild=findViewById(R.id.cholesterolFourChild);
        btn_continue=findViewById(R.id.btn_continue);
        AlcoholDurationEditSpinner = findViewById(R.id.AlcoholDurationEditSpinner);
        NarcoticEditSelf = findViewById(R.id.NarcoticEditSelf);
        NarcoticDurationEditSelf = findViewById(R.id.NarcoticDurationEditSelf);
        MotherTxt = findViewById(R.id.MotherTxt);
        FatherTxt = findViewById(R.id.FatherTxt);

        YesPreExistingRadio = findViewById(R.id.YesPreExistingRadio);
        NoPreExistingRadio = findViewById(R.id.NoPreExistingRadio);
        IllnessEditSelf = findViewById(R.id.IllnessEditSelf);
        YesMedicalHistoryRadio = findViewById(R.id.YesMedicalHistoryRadio);
        NoMedicalHistoryRadio = findViewById(R.id.NoMedicalHistoryRadio);
        MedicalProfessionalEditSelf = findViewById(R.id.MedicalProfessionalEditSelf);
        YesMedicineRadio = findViewById(R.id.YesMedicineRadio);
        NoMedicineRadio = findViewById(R.id.NoMedicineRadio);
        MedicalTreatmentEditSelf = findViewById(R.id.MedicalTreatmentEditSelf);
        YesHospitalizationHistoryRadio = findViewById(R.id.YesHospitalizationHistoryRadio);
        NoHospitalizationHistoryRadio = findViewById(R.id.NoHospitalizationHistoryRadio);
        NoPreExistingChildOneRadio = findViewById(R.id.NoPreExistingChildOneRadio);
        MedicalHistoryEditSelf = findViewById(R.id.MedicalHistoryEditSelf);
        YesPersonRadio = findViewById(R.id.YesPersonRadio);
        NoPersonRadio = findViewById(R.id.NoPersonRadio);
        PersonEditSelf = findViewById(R.id.PersonEditSelf);
        YesAlcoholRadio = findViewById(R.id.YesAlcoholRadio);
        NoAlcoholRadio = findViewById(R.id.NoAlcoholRadio);
        SelfConsumeAlcoholLiner = findViewById(R.id.SelfConsumeAlcoholLiner);
        TypeSpinnerLiner = findViewById(R.id.TypeSpinnerLiner);
        TypeEditSpinner = findViewById(R.id.TypeEditSpinner);
        OccasionallySelfDropDownLiner = findViewById(R.id.OccasionallySelfDropDownLiner);
        OccasionallyEditSpinner = findViewById(R.id.OccasionallyEditSpinner);
        AlcoholSpinnerLiner = findViewById(R.id.AlcoholSpinnerLiner);
        AlcoholEditSpinner = findViewById(R.id.AlcoholEditSpinner);
        AlcoholDurationSpinnerLiner = findViewById(R.id.AlcoholDurationSpinnerLiner);
        YesSmokerRadio = findViewById(R.id.YesSmokerRadio);
        NoSmokerRadio = findViewById(R.id.NoSmokerRadio);
        SelfSmokerLiner = findViewById(R.id.SelfSmokerLiner);
        TypeSmokeSpinnerLiner = findViewById(R.id.TypeSmokeSpinnerLiner);
        TypeSmokeEditSpinner = findViewById(R.id.TypeSmokeEditSpinner);
        SmokeOccasionallySpinnerLiner = findViewById(R.id.SmokeOccasionallySpinnerLiner);
        SmokeOccasionallyEditSpinner = findViewById(R.id.SmokeOccasionallyEditSpinner);
        SmokeAlcoholSpinnerLiner = findViewById(R.id.SmokeAlcoholSpinnerLiner);
        SmokeAlcoholEditSpinner = findViewById(R.id.SmokeAlcoholEditSpinner);
        SmokeDurationSpinnerLiner = findViewById(R.id.SmokeDurationSpinnerLiner);
        SmokeDurationEditSpinner = findViewById(R.id.SmokeDurationEditSpinner);
        TobaccoTypeEditSelf = findViewById(R.id.TobaccoTypeEditSelf);
        YesTobaccoRadio = findViewById(R.id.YesTobaccoRadio);
        NoTobaccoRadio = findViewById(R.id.NoTobaccoRadio);
        SelfConsumeTobaccoLiner = findViewById(R.id.SelfConsumeTobaccoLiner);
        TobaccoTypeLinerSelf = findViewById(R.id.TobaccoTypeLinerSelf);
        TobaccoLinerSelf = findViewById(R.id.TobaccoLinerSelf);
        TobaccoEditSelf = findViewById(R.id.TobaccoEditSelf);
        TobaccoOccasinallyLinerSelf = findViewById(R.id.TobaccoOccasinallyLinerSelf);
        TobaccoOccasinallyEditSelf = findViewById(R.id.TobaccoOccasinallyEditSelf);
        TobaccoDurationLinerSelf = findViewById(R.id.TobaccoDurationLinerSelf);
        TobaccoDurationEditSelf = findViewById(R.id.TobaccoDurationEditSelf);
        YesNarcoticRadio = findViewById(R.id.YesNarcoticRadio);
        NoNarcoticRadio = findViewById(R.id.NoNarcoticRadio);
        SelfNarcoticLiner = findViewById(R.id.SelfNarcoticLiner);
        YesPhysicalMentalRadio = findViewById(R.id.YesPhysicalMentalRadio);
        NoPhysicalMentalRadio = findViewById(R.id.NoPhysicalMentalRadio);
        NarcoticFrequencyLinerSelf = findViewById(R.id.NarcoticFrequencyLinerSelf);
        NarcoticDurationLinerSelf = findViewById(R.id.NarcoticDurationLinerSelf);
        //Spouse
        SpouseLiner = findViewById(R.id.SpouseLiner);
        SposeFreQuencyLiner = findViewById(R.id.SposeFreQuencyLiner);
        TobaccoLinerSpouse = findViewById(R.id.TobaccoLinerSpouse);
        TobaccoEditSpouse = findViewById(R.id.TobaccoEditSpouse);
        TobaccoOccasinallyEditSpouse = findViewById(R.id.TobaccoOccasinallyEditSpouse);
        OccasionallySpinnerSpouseLiner = findViewById(R.id.OccasionallySpinnerSpouseLiner);
        TobaccoOccasinallyLinerSpouse = findViewById(R.id.TobaccoOccasinallyLinerSpouse);
        OccasionallySpouseEditSpinner = findViewById(R.id.OccasionallySpouseEditSpinner);
        SpouseEditFrequency = findViewById(R.id.SpouseEditFrequency);
        SpouseYesPhysicalRadio = findViewById(R.id.SpouseYesPhysicalRadio);
        SpouseNoPhysicalRadio = findViewById(R.id.SpouseNoPhysicalRadio);
        YesDiseaseSpouseRadio = findViewById(R.id.YesDiseaseSpouseRadio);
        NoDiseaseSpouseRadio = findViewById(R.id.NoDiseaseSpouseRadio);
        YesConsumeAlcoholRadio = findViewById(R.id.YesConsumeAlcoholRadio);
        NoConsumeAlcoholRadio = findViewById(R.id.NoConsumeAlcoholRadio);
        LinerConsumeAlcohol = findViewById(R.id.LinerConsumeAlcohol);
        YesSpouseTobaccoRadio = findViewById(R.id.YesSpouseTobaccoRadio);
        NoSpouseTobaccoRadio = findViewById(R.id.NoSpouseTobaccoRadio);
        LinerConsumeTobacco = findViewById(R.id.LinerConsumeTobacco);
        bloodSugarAdultTwo = findViewById(R.id.bloodSugarAdultTwo);
        bloodPressureAdultTwo = findViewById(R.id.bloodPressureAdultTwo);
        bloodPressureDiastolicAdultTwo = findViewById(R.id.bloodPressureDiastolicAdultTwo);
        cholesterolAdultTwo = findViewById(R.id.cholesterolAdultTwo);
        YesRadioSufferingDiseaseSecondAdult = findViewById(R.id.YesRadioSufferingDiseaseSecondAdult);
        NoRadioSufferingDiseaseSecondAdult = findViewById(R.id.NoRadioSufferingDiseaseSecondAdult);
        YesHospitalizationHistoryAdultSecondRadio = findViewById(R.id.YesHospitalizationHistoryAdultSecondRadio);
        NoHospitalizationHistoryAdultSecondRadio = findViewById(R.id.NoHospitalizationHistoryAdultSecondRadio);
        YesSmokerSpouseRadio = findViewById(R.id.YesSmokerSpouseRadio);
        NoSmokerSpouseRadio = findViewById(R.id.NoSmokerSpouseRadio);
        YesPersonSpouseRadio = findViewById(R.id.YesPersonSpouseRadio);
        NoPersonSpouseRadio = findViewById(R.id.NoPersonSpouseRadio);
        SpouseSmokerLiner = findViewById(R.id.SpouseSmokerLiner);
        TypeSpouseSmokeSpinnerLiner = findViewById(R.id.TypeSpouseSmokeSpinnerLiner);
        TypeSpouseSmokeEditSpinner = findViewById(R.id.TypeSpouseSmokeEditSpinner);
        SmokeSpouseOccasionallySpinnerLiner = findViewById(R.id.SmokeSpouseOccasionallySpinnerLiner);
        SmokeSpouseOccasionallyEditSpinner = findViewById(R.id.SmokeSpouseOccasionallyEditSpinner);
        SmokeSpouseAlcoholSpinnerLiner = findViewById(R.id.SmokeSpouseAlcoholSpinnerLiner);
        SmokeSpouseAlcoholEditSpinner = findViewById(R.id.SmokeSpouseAlcoholEditSpinner);
        SmokeSpouseDurationSpinnerLiner = findViewById(R.id.SmokeSpouseDurationSpinnerLiner);
        SmokeSpouseDurationEditSpinner = findViewById(R.id.SmokeSpouseDurationEditSpinner);
        TypeSpouseEditSpinner = findViewById(R.id.TypeSpouseEditSpinner);
        TypeSpouseSpinnerLiner = findViewById(R.id.TypeSpouseSpinnerLiner);
        SpouseDurationEditSpinner = findViewById(R.id.SpouseDurationEditSpinner);
        TobaccoTypeLinerSpouse = findViewById(R.id.TobaccoTypeLinerSpouse);
        TobaccoTypeEditSpouse = findViewById(R.id.TobaccoTypeEditSpouse);
        TobaccoDurationLinerSpouse = findViewById(R.id.TobaccoDurationLinerSpouse);
        TobaccoDurationEditSpouse = findViewById(R.id.TobaccoDurationEditSpouse);
        YesSpouseNarcoticRadio = findViewById(R.id.YesSpouseNarcoticRadio);
        NoSpouseNarcoticRadio = findViewById(R.id.NoSpouseNarcoticRadio);
        SpouseNarcoticLiner = findViewById(R.id.SpouseNarcoticLiner);
        SpouseNarcoticFrequencyLinerSelf = findViewById(R.id.SpouseNarcoticFrequencyLinerSelf);
        NarcoticEditSpouse = findViewById(R.id.NarcoticEditSpouse);
        NarcoticDurationLinerSpouse = findViewById(R.id.NarcoticDurationLinerSpouse);
        NarcoticDurationEditSpouse = findViewById(R.id.NarcoticDurationEditSpouse);
        IllnessEditSpouse = findViewById(R.id.IllnessEditSpouse);
        PhysicalEditSpouse = findViewById(R.id.PhysicalEditSpouse);
        DiseaseEditSpouse = findViewById(R.id.DiseaseEditSpouse);
        HospitalizationEditSpouse = findViewById(R.id.HospitalizationEditSpouse);
        PersonEditSpouse = findViewById(R.id.PersonEditSpouse);
        SpouseDurationSpinnerLiner = findViewById(R.id.SpouseDurationSpinnerLiner);


        //Child 1
        ChildOneLiner = findViewById(R.id.ChildOneLiner);
        YesChildOnePhysicalRadio = findViewById(R.id.YesChildOnePhysicalRadio);
        NoChildOnePhysicalRadio = findViewById(R.id.NoChildOnePhysicalRadio);
        YesChildOnePreExistingRadio = findViewById(R.id.YesChildOnePreExistingRadio);
        NoChildOnePreExistingRadio = findViewById(R.id.NoChildOnePreExistingRadio);
        bloodSugarChildOne = findViewById(R.id.bloodSugarChildOne);
        bloodPressureChildOne = findViewById(R.id.bloodPressureChildOne);
        bloodPressureDiastolicChildOne = findViewById(R.id.bloodPressureDiastolicChildOne);
        cholesterolChildOne = findViewById(R.id.cholesterolChildOne);
        YesChildOneConsumeAlcoholRadio = findViewById(R.id.YesChildOneConsumeAlcoholRadio);
        NoChildOneConsumeAlcoholRadio = findViewById(R.id.NoChildOneConsumeAlcoholRadio);
        ChildOneConsumeAlcoholLiner = findViewById(R.id.ChildOneConsumeAlcoholLiner);
        YesConsumeTobaccoChildOneRadio = findViewById(R.id.YesConsumeTobaccoChildOneRadio);
        NoConsumeTobaccoChildOneRadio = findViewById(R.id.NoConsumeTobaccoChildOneRadio);
        ConsumeTabaccoLinerChildOne = findViewById(R.id.ConsumeTabaccoLinerChildOne);
        DiseaseLinerChildOne = findViewById(R.id.DiseaseLinerChildOne);
        YesPreExistingChildOneRadio = findViewById(R.id.YesPreExistingChildOneRadio);
        YesMedicineChildOneRadio = findViewById(R.id.YesMedicineChildOneRadio);
        AlcoholSpinnerLinerChildOne = findViewById(R.id.AlcoholSpinnerLinerChildOne);
        AlcoholEditSpinnerChildOne = findViewById(R.id.AlcoholEditSpinnerChildOne);
        OccasionallyEditChildOneSpinner = findViewById(R.id.OccasionallyEditChildOneSpinner);
        OccasionallySpinnerChildOneLiner = findViewById(R.id.OccasionallySpinnerChildOneLiner);
        ConsumeTabaccoOccasinallyLinerChildOne = findViewById(R.id.ConsumeTabaccoOccasinallyLinerChildOne);
        ConsumeTabaccoChildOne = findViewById(R.id.ConsumeTabaccoChildOne);
        ConsumeTabaccoChildOneSpinner = findViewById(R.id.ConsumeTabaccoChildOneSpinner);
        ConsumeTabaccoChildOneLiner = findViewById(R.id.ConsumeTabaccoChildOneLiner);
        LinerChildOneLiner = findViewById(R.id.LinerChildOneLiner);
        AlcoholTwoChildEditSpinner = findViewById(R.id.AlcoholTwoChildEditSpinner);
        OccasionallyTwoChildEditSpinner = findViewById(R.id.OccasionallyTwoChildEditSpinner);
        TobaccoEditTwoChild = findViewById(R.id.TobaccoEditTwoChild);
        TobaccoOccasinallyEditTwoChild = findViewById(R.id.TobaccoOccasinallyEditTwoChild);
        NoMedicineChildOneRadio = findViewById(R.id.NoMedicineChildOneRadio);
        YesPersonChildRadio = findViewById(R.id.YesPersonChildRadio);
        NoPersonChildRadio = findViewById(R.id.NoPersonChildRadio);
        YesSmokerChildRadio = findViewById(R.id.YesSmokerChildRadio);
        NoSmokerChildRadio = findViewById(R.id.NoSmokerChildRadio);
        IllnessEditChildOne = findViewById(R.id.IllnessEditChildOne);
        PhysicalEditChildOne = findViewById(R.id.PhysicalEditChildOne);
        DiseaseEditChildOne = findViewById(R.id.DiseaseEditChildOne);
        PreExistingEditChildOne = findViewById(R.id.PreExistingEditChildOne);
        PersonEditChildOne = findViewById(R.id.PersonEditChildOne);
        TypeChildOneSpinnerLiner = findViewById(R.id.TypeChildOneSpinnerLiner);
        TypeChildOneEditSpinner = findViewById(R.id.TypeChildOneEditSpinner);
        ChildOneDurationSpinnerLiner = findViewById(R.id.ChildOneDurationSpinnerLiner);
        ChildOneDurationEditSpinner = findViewById(R.id.ChildOneDurationEditSpinner);
        ChildOneSmokerLiner = findViewById(R.id.ChildOneSmokerLiner);
        TypeChildOneSmokeLiner = findViewById(R.id.TypeChildOneSmokeLiner);
        TypeChildOneSmokeEdit = findViewById(R.id.TypeChildOneSmokeEdit);
        SmokeChildOneOccasionallyLiner = findViewById(R.id.SmokeChildOneOccasionallyLiner);
        SmokeChildOneOccasionallyEdit = findViewById(R.id.SmokeChildOneOccasionallyEdit);
        SmokeChildOneAlcoholLiner = findViewById(R.id.SmokeChildOneAlcoholLiner);
        SmokeChildOneAlcoholEdit = findViewById(R.id.SmokeChildOneAlcoholEdit);
        SmokeChildOneDurationLiner = findViewById(R.id.SmokeChildOneDurationLiner);
        SmokeChildOneDurationEdit = findViewById(R.id.SmokeChildOneDurationEdit);
        TobaccoTypeLinerChildOne = findViewById(R.id.TobaccoTypeLinerChildOne);
        TobaccoTypeEditChildOne = findViewById(R.id.TobaccoTypeEditChildOne);
        TobaccoDurationLinerChildOne = findViewById(R.id.TobaccoDurationLinerChildOne);
        TobaccoDurationEditChild1 = findViewById(R.id.TobaccoDurationEditChild1);
        YesChildNarcoticRadio = findViewById(R.id.YesChildNarcoticRadio);
        NoChildNarcoticRadio = findViewById(R.id.NoChildNarcoticRadio);
        ChildNarcoticLiner = findViewById(R.id.ChildNarcoticLiner);
        ChildNarcoticFrequencyLiner = findViewById(R.id.ChildNarcoticFrequencyLiner);
        ChildNarcoticEdit = findViewById(R.id.ChildNarcoticEdit);
        ChildNarcoticDurationLiner = findViewById(R.id.ChildNarcoticDurationLiner);
        ChildNarcoticDurationEdit = findViewById(R.id.ChildNarcoticDurationEdit);


        //child2

        ChildTwoLinerMedical = findViewById(R.id.ChildTwoLinerMedical);
        YesChildTwoPhysicalRadio = findViewById(R.id.YesChildTwoPhysicalRadio);
        NoChildTwoPhysicalRadio = findViewById(R.id.NoChildTwoPhysicalRadio);
        YesChildTwoPreDisease = findViewById(R.id.YesChildTwoPreDisease);
        NoChildTwoPreDisease = findViewById(R.id.NoChildTwoPreDisease);
        ChildTwoDiseaseLiner = findViewById(R.id.ChildTwoDiseaseLiner);
        bloodSugarChildTwo = findViewById(R.id.bloodSugarChildTwo);
        bloodPressureChildTwo = findViewById(R.id.bloodPressureChildTwo);
        bloodPressureDiastolicChildTwo = findViewById(R.id.bloodPressureDiastolicChildTwo);
        cholesterolChildTwo = findViewById(R.id.cholesterolChildTwo);
        YesChildTwoAlcoholRadio = findViewById(R.id.YesChildTwoAlcoholRadio);
        NoChildTwoAlcoholRadio = findViewById(R.id.NoChildTwoAlcoholRadio);
        AlcoholLinerChildTwo = findViewById(R.id.AlcoholLinerChildTwo);
        YesTobaccoChildTwoRadio = findViewById(R.id.YesTobaccoChildTwoRadio);
        NoTobaccoChildTwoRadio = findViewById(R.id.NoTobaccoChildTwoRadio);
        LinerTobaccoTwoChild = findViewById(R.id.LinerTobaccoTwoChild);
        YesChildTwoPreExistingRadio = findViewById(R.id.YesChildTwoPreExistingRadio);
        NoChildTwoPreExistingRadio = findViewById(R.id.NoChildTwoPreExistingRadio);
        YesChildTwoHistoryRadio = findViewById(R.id.YesChildTwoHistoryRadio);
        NoChildTwoHistoryRadio = findViewById(R.id.NoChildTwoHistoryRadio);
        AlcoholTwoChildSpinnerLiner = findViewById(R.id.AlcoholTwoChildSpinnerLiner);
        OccasionallyTwoChildSpinnerLiner = findViewById(R.id.OccasionallyTwoChildSpinnerLiner);
        TobaccoLinerTwoChild = findViewById(R.id.TobaccoLinerTwoChild);
        TobaccoOccasinallyTwoChild = findViewById(R.id.TobaccoOccasinallyTwoChild);
        ChildTwoLiner = findViewById(R.id.ChildTwoLiner);
        ChildThreeLiner = findViewById(R.id.ChildThreeLiner);
        YesPersonChildTwoRadio = findViewById(R.id.YesPersonChildTwoRadio);
        NoPersonChildTwoRadio = findViewById(R.id.NoPersonChildTwoRadio);
        YesSmokerChildTwoRadio = findViewById(R.id.YesSmokerChildTwoRadio);
        NoSmokerChildTwoRadio = findViewById(R.id.NoSmokerChildTwoRadio);
        TypeTwoChildLiner = findViewById(R.id.TypeTwoChildLiner);
        TypeTwoChildEdit = findViewById(R.id.TypeTwoChildEdit);
        DurationTwoChildLiner = findViewById(R.id.DurationTwoChildLiner);
        DurationTwoChildEdit = findViewById(R.id.DurationTwoChildEdit);
        TypeTobaccoTwoChild = findViewById(R.id.TypeTobaccoTwoChild);
        TypeTobaccoEditTwoChild = findViewById(R.id.TypeTobaccoEditTwoChild);
        DurationTobaccoTwoChild = findViewById(R.id.DurationTobaccoTwoChild);
        DurationTobaccoEditTwoChild = findViewById(R.id.DurationTobaccoEditTwoChild);
        TypeSmokeTwoChild = findViewById(R.id.TypeSmokeTwoChild);
        TypeSmokeEditTwoChild = findViewById(R.id.TypeSmokeEditTwoChild);
        SmokeOccasinallyTwoChild = findViewById(R.id.SmokeOccasinallyTwoChild);
        SmokeOccasinallyEditTwoChild = findViewById(R.id.SmokeOccasinallyEditTwoChild);
        SmokeLinerTwoChild = findViewById(R.id.SmokeLinerTwoChild);
        SmokeEditTwoChild = findViewById(R.id.SmokeEditTwoChild);
        DurationSmokeTwoChild = findViewById(R.id.DurationSmokeTwoChild);
        DurationSmokeEditTwoChild = findViewById(R.id.DurationSmokeEditTwoChild);
        YesChildTwoNarcoticRadio = findViewById(R.id.YesChildTwoNarcoticRadio);
        NoChildTwoNarcoticRadio = findViewById(R.id.NoChildTwoNarcoticRadio);
        ChildTwoFourNarcoticLiner = findViewById(R.id.ChildTwoFourNarcoticLiner);
        ChildTwoNarcoticFrequencyLinerSelf = findViewById(R.id.ChildTwoNarcoticFrequencyLinerSelf);
        ChildTwoNarcoticEditSelf = findViewById(R.id.ChildTwoNarcoticEditSelf);
        ChildTwoNarcoticDurationLiner = findViewById(R.id.ChildTwoNarcoticDurationLiner);
        ChildTwoNarcoticDurationEdit = findViewById(R.id.ChildTwoNarcoticDurationEdit);
        IllnessEditChildTwo = findViewById(R.id.IllnessEditChildTwo);
        MedicineEditChildTwo = findViewById(R.id.MedicineEditChildTwo);
        TreatmentEditChildTwo = findViewById(R.id.TreatmentEditChildTwo);
        HospitalizedEditChildTwo = findViewById(R.id.HospitalizedEditChildTwo);
        PersonEditChildTwo = findViewById(R.id.PersonEditChildTwo);
        LinerSmokeTwoChild = findViewById(R.id.LinerSmokeTwoChild);


        //child3
        thirdChildLiner = findViewById(R.id.thirdChildLiner);
        YesPhysicalChildThirdRadio = findViewById(R.id.YesPhysicalChildThirdRadio);
        NoPhysicalChildThirdRadio = findViewById(R.id.NoPhysicalChildThirdRadio);
        YesDiseaseChildThird = findViewById(R.id.YesDiseaseChildThird);
        NoDiseaseChildThird = findViewById(R.id.NoDiseaseChildThird);
        DiseaseLinerChildThird = findViewById(R.id.DiseaseLinerChildThird);
        bloodSugarThirdChild = findViewById(R.id.bloodSugarThirdChild);
        bloodPressureThirdChild = findViewById(R.id.bloodPressureThirdChild);
        bloodPressureDiastolicThirdChild = findViewById(R.id.bloodPressureDiastolicThirdChild);
        cholesterolThirdChild = findViewById(R.id.cholesterolThirdChild);
        YesAlcoholRadioThirdChild = findViewById(R.id.YesAlcoholRadioThirdChild);
        NoAlcoholRadioThirdChild = findViewById(R.id.NoAlcoholRadioThirdChild);
        ConsumeAlcoholThirdChildLiner = findViewById(R.id.ConsumeAlcoholThirdChildLiner);
        YesTobaccoThirdChild = findViewById(R.id.YesTobaccoThirdChild);
        NoTobaccoThirdChild = findViewById(R.id.NoTobaccoThirdChild);
        ConsumeTobaccoLiner = findViewById(R.id.ConsumeTobaccoLiner);
        YesPreExistingThirdChildRadio = findViewById(R.id.YesPreExistingThirdChildRadio);
        NoPreExistingThirdChildRadio = findViewById(R.id.NoPreExistingThirdChildRadio);
        NoMedicineThirdChildRadio = findViewById(R.id.NoMedicineThirdChildRadio);
        YesMedicineThirdChildRadio = findViewById(R.id.YesMedicineThirdChildRadio);
        AlcoholSpinnerLinerThirdChild = findViewById(R.id.AlcoholSpinnerLinerThirdChild);
        AlcoholEditSpinnerThirdChild = findViewById(R.id.AlcoholEditSpinnerThirdChild);
        OccasionallySpinnerLinerThirdChild = findViewById(R.id.OccasionallySpinnerLinerThirdChild);
        AlcoholThirdChildSpinnerLiner = findViewById(R.id.AlcoholThirdChildSpinnerLiner);
        AlcoholEditThirdChild = findViewById(R.id.AlcoholEditThirdChild);
        OccasionallyThirdChild = findViewById(R.id.OccasionallyThirdChild);
        OccasionallyEditThirdChild = findViewById(R.id.OccasionallyEditThirdChild);
        OccasionallyEditSpinnerThirdChild = findViewById(R.id.OccasionallyEditSpinnerThirdChild);
        YesPersonThirdChildRadio = findViewById(R.id.YesPersonThirdChildRadio);
        NoPersonThirdChildRadio = findViewById(R.id.NoPersonThirdChildRadio);
        YesSmokerChildThirdRadio = findViewById(R.id.YesSmokerChildThirdRadio);
        NoSmokerChildThirdRadio = findViewById(R.id.NoSmokerChildThirdRadio);
        TypeLinerThirdChild = findViewById(R.id.TypeLinerThirdChild);
        TypeEditThirdChild = findViewById(R.id.TypeEditThirdChild);
        DurationLinerThirdChild = findViewById(R.id.DurationLinerThirdChild);
        DurationEditThirdChild = findViewById(R.id.DurationEditThirdChild);
        SmokeLinerThird = findViewById(R.id.SmokeLinerThird);
        TypeSmokeThirdChildLiner = findViewById(R.id.TypeSmokeThirdChildLiner);
        TypeSmokeEditThirdChild = findViewById(R.id.TypeSmokeEditThirdChild);
        QuantitySmokeThirdChildLiner = findViewById(R.id.QuantitySmokeThirdChildLiner);
        QuantitySmokeEditThirdChild = findViewById(R.id.QuantitySmokeEditThirdChild);
        FrequencySmokeThirdChildLiner = findViewById(R.id.FrequencySmokeThirdChildLiner);
        FrequencySmokeEditThirdChild = findViewById(R.id.FrequencySmokeEditThirdChild);
        DurationSmokeThirdChildLiner = findViewById(R.id.DurationSmokeThirdChildLiner);
        DurationSmokeEditThirdChild = findViewById(R.id.DurationSmokeEditThirdChild);
        TypeTobaccoThirdChild = findViewById(R.id.TypeTobaccoThirdChild);
        TypeTobaccoEditThirdChild = findViewById(R.id.TypeTobaccoEditThirdChild);
        DurationTobaccoThirdChild = findViewById(R.id.DurationTobaccoThirdChild);
        DurationTobaccoEditThirdChild = findViewById(R.id.DurationTobaccoEditThirdChild);
        YesChildThirdNarcoticRadio = findViewById(R.id.YesChildThirdNarcoticRadio);
        NoChildThirdNarcoticRadio = findViewById(R.id.NoChildThirdNarcoticRadio);
        ChildThirdNarcoticLiner = findViewById(R.id.ChildThirdNarcoticLiner);
        ChildThirdNarcoticFrequencyLiner = findViewById(R.id.ChildThirdNarcoticFrequencyLiner);
        ChildThirdNarcoticEdit = findViewById(R.id.ChildThirdNarcoticEdit);
        ChildThirdNarcoticDurationLiner = findViewById(R.id.ChildThirdNarcoticDurationLiner);
        ChildThirdNarcoticDurationEdit = findViewById(R.id.ChildThirdNarcoticDurationEdit);
        IllnessEditChild3 = findViewById(R.id.IllnessEditChild3);
        MedicalEditChild3 = findViewById(R.id.MedicalEditChild3);
        MedicalTreatmentEditChild3 = findViewById(R.id.MedicalTreatmentEditChild3);
        HospitizationTreatmentEditChild3 = findViewById(R.id.HospitizationTreatmentEditChild3);
        PersonEditChild3 = findViewById(R.id.PersonEditChild3);

        //Child Four
        FourChildTwoLiner = findViewById(R.id.FourChildTwoLiner);
        YesPhysicalChildFourRadio = findViewById(R.id.YesPhysicalChildFourRadio);
        NoPhysicalChildFourRadio = findViewById(R.id.NoPhysicalChildFourRadio);
        YesDiseaseChildFourRadio = findViewById(R.id.YesDiseaseChildFourRadio);
        NoDiseaseChildFourRadio = findViewById(R.id.NoDiseaseChildFourRadio);
        DiseaseLinerChildFour = findViewById(R.id.DiseaseLinerChildFour);
        bloodSugarFourChild = findViewById(R.id.bloodSugarFourChild);
        bloodPressureFourChild = findViewById(R.id.bloodPressureFourChild);
        bloodPressureDiastolicFourChild = findViewById(R.id.bloodPressureDiastolicFourChild);
        cholesterolFourChild = findViewById(R.id.cholesterolFourChild);
        YesConsumeAlcoholFourChild = findViewById(R.id.YesConsumeAlcoholFourChild);
        NoConsumeAlcoholFourChild = findViewById(R.id.NoConsumeAlcoholFourChild);
        ConsumeAlcoholChildFourLiner = findViewById(R.id.ConsumeAlcoholChildFourLiner);
        YesConsumeTobaccoChildFour = findViewById(R.id.YesConsumeTobaccoChildFour);
        NoConsumeTobaccoChildFour = findViewById(R.id.NoConsumeTobaccoChildFour);
        ConsumeTobaccoChildFourLiner = findViewById(R.id.ConsumeTobaccoChildFourLiner);
        YesPreExistingFourChildRadio = findViewById(R.id.YesPreExistingFourChildRadio);
        NoPreExistingFourChildRadio = findViewById(R.id.NoPreExistingFourChildRadio);
        YesHistoryFourChildRadio = findViewById(R.id.YesHistoryFourChildRadio);
        NoHistoryFourChildRadio = findViewById(R.id.NoHistoryFourChildRadio);
        TobaccoFrequencyLiner = findViewById(R.id.TobaccoFrequencyLiner);
        TobaccoEditFrequency = findViewById(R.id.TobaccoEditFrequency);
        OccasionallyTobaccoLiner = findViewById(R.id.OccasionallyTobaccoLiner);
        OccasionallyTobaccoSpinner = findViewById(R.id.OccasionallyTobaccoSpinner);
        AlcoholFrequencyLiner = findViewById(R.id.AlcoholFrequencyLiner);
        AlcoholEditFrequency = findViewById(R.id.AlcoholEditFrequency);
        OccasionallyLiterLiner = findViewById(R.id.OccasionallyLiterLiner);
        OccasionallyLiterSpinner = findViewById(R.id.OccasionallyLiterSpinner);
        LinerFourChild = findViewById(R.id.LinerFourChild);
        YesSmokerChildFourRadio = findViewById(R.id.YesSmokerChildFourRadio);
        NoSmokerChildFourRadio = findViewById(R.id.NoSmokerChildFourRadio);
        YesPersonChildFourRadio = findViewById(R.id.YesPersonChildFourRadio);
        NoPersonChildFourRadio = findViewById(R.id.NoPersonChildFourRadio);
        TypeAlcoholLinerChild4 = findViewById(R.id.TypeAlcoholLinerChild4);
        TypeAlcoholEditChild4 = findViewById(R.id.TypeAlcoholEditChild4);
        DurationAlcoholLinerChild4 = findViewById(R.id.DurationAlcoholLinerChild4);
        DurationAlcoholEditChild4 = findViewById(R.id.DurationAlcoholEditChild4);
        TypeTobaccoLinerChild4 = findViewById(R.id.TypeTobaccoLinerChild4);
        TypeTobaccoEditChild4 = findViewById(R.id.TypeTobaccoEditChild4);
        DurationTobaccoLinerChild4 = findViewById(R.id.DurationTobaccoLinerChild4);
        DurationTobaccoEditChild4 = findViewById(R.id.DurationTobaccoEditChild4);
        SmokeTypeLinerChild4 = findViewById(R.id.SmokeTypeLinerChild4);
        SmokeTypeEditChild4 = findViewById(R.id.SmokeTypeEditChild4);
        SmokeQuantityLiterLiner = findViewById(R.id.SmokeQuantityLiterLiner);
        SmokeQuantityEdit = findViewById(R.id.SmokeQuantityEdit);
        SmokeFrequencyLinerChild4 = findViewById(R.id.SmokeFrequencyLinerChild4);
        SmokeEditFrequencyChild4 = findViewById(R.id.SmokeEditFrequencyChild4);
        DurationSmokeLinerChild4 = findViewById(R.id.DurationSmokeLinerChild4);
        DurationSmokeEditChild4 = findViewById(R.id.DurationSmokeEditChild4);
        YesChildFourNarcoticRadio = findViewById(R.id.YesChildFourNarcoticRadio);
        NoChildFourNarcoticRadio = findViewById(R.id.NoChildFourNarcoticRadio);
        ChildFourNarcoticLiner = findViewById(R.id.ChildFourNarcoticLiner);
        ChildFourNarcoticFrequencyLiner = findViewById(R.id.ChildFourNarcoticFrequencyLiner);
        ChildFourNarcoticDurationLiner = findViewById(R.id.ChildFourNarcoticDurationLiner);
        ChildFourNarcoticEdit = findViewById(R.id.ChildFourNarcoticEdit);
        ChildFourNarcoticDurationEdit = findViewById(R.id.ChildFourNarcoticDurationEdit);
        IllnessEditChild4 = findViewById(R.id.IllnessEditChild4);
        MedicalEditChild4 = findViewById(R.id.MedicalEditChild4);
        MedicalTreatmentEditChild4 = findViewById(R.id.MedicalTreatmentEditChild4);
        HospitalizedEditChild4 = findViewById(R.id.HospitalizedEditChild4);
        PersonEditChild4 = findViewById(R.id.PersonEditChild4);
        SmokeChildFourLiner = findViewById(R.id.SmokeChildFourLiner);

        //Mother

        MotherMainLiner = findViewById(R.id.MotherMainLiner);
        YesMotherPhysical = findViewById(R.id.YesMotherPhysical);
        NoMotherPhysical = findViewById(R.id.NoMotherPhysical);
        YesDiseaseMother = findViewById(R.id.YesDiseaseMother);
        NoDiseaseMother = findViewById(R.id.NoDiseaseMother);
        MotherDiseaseLiner = findViewById(R.id.MotherDiseaseLiner);
        bloodSugarMother = findViewById(R.id.bloodSugarMother);
        bloodPressureMother = findViewById(R.id.bloodPressureMother);
        bloodPressureDiastolicMother = findViewById(R.id.bloodPressureDiastolicMother);
        cholesterolMother = findViewById(R.id.cholesterolMother);
        YesConsumeAlcoholMother = findViewById(R.id.YesConsumeAlcoholMother);
        NoConsumeAlcoholMother = findViewById(R.id.NoConsumeAlcoholMother);
        ConsumeAlcoholLinerMother = findViewById(R.id.ConsumeAlcoholLinerMother);
        YesConsumeTobaccoMother = findViewById(R.id.YesConsumeTobaccoMother);
        NoConsumeTobaccoMother = findViewById(R.id.NoConsumeTobaccoMother);
        ConsumeTobaccoLinerMother = findViewById(R.id.ConsumeTobaccoLinerMother);
        YesPreExistingMotherRadio = findViewById(R.id.YesPreExistingMotherRadio);
        NoPreExistingMotherRadio = findViewById(R.id.NoPreExistingMotherRadio);
        YesMotherHistoryRadio = findViewById(R.id.YesMotherHistoryRadio);
        NoMotherHistoryRadio = findViewById(R.id.NoMotherHistoryRadio);
        MotherAlcoholEditSpinner = findViewById(R.id.MotherAlcoholEditSpinner);
        MotherAlcoholSpinnerLiner = findViewById(R.id.MotherAlcoholSpinnerLiner);
        MotherOccasionallySpinnerLiner = findViewById(R.id.MotherOccasionallySpinnerLiner);
        MotherOccasionallyEditSpinner = findViewById(R.id.MotherOccasionallyEditSpinner);
        MotherTobaccoLiner = findViewById(R.id.MotherTobaccoLiner);
        MotherTobaccoEditSpinner = findViewById(R.id.MotherTobaccoEditSpinner);
        MotherOccasionallyTobaccoLiner = findViewById(R.id.MotherOccasionallyTobaccoLiner);
        MotherOccasionallyTobaccoSpinner = findViewById(R.id.MotherOccasionallyTobaccoSpinner);
        MotherLiner = findViewById(R.id.MotherLiner);
        FatherLiner = findViewById(R.id.FatherLiner);
        YesPersonMotherRadio = findViewById(R.id.YesPersonMotherRadio);
        NoPersonMotherRadio = findViewById(R.id.NoPersonMotherRadio);
        YesSmokerMotherRadio = findViewById(R.id.YesSmokerMotherRadio);
        NoSmokerMotherRadio = findViewById(R.id.NoSmokerMotherRadio);
        MotherTypeLiner = findViewById(R.id.MotherTypeLiner);
        MotherTypeEdit = findViewById(R.id.MotherTypeEdit);
        MotherDurationLiner = findViewById(R.id.MotherDurationLiner);
        MotherDurationEdit = findViewById(R.id.MotherDurationEdit);
        MotherTypeTobaccoLiner = findViewById(R.id.MotherTypeTobaccoLiner);
        MotherDurationTobaccoLiner = findViewById(R.id.MotherDurationTobaccoLiner);
        MotherDurationTobaccoEdit = findViewById(R.id.MotherDurationTobaccoEdit);
        MotherTypeSmokeLiner = findViewById(R.id.MotherTypeSmokeLiner);
        MotherTypeSmokeEdit = findViewById(R.id.MotherTypeSmokeEdit);
        MotherOccasionallySmokeLiner = findViewById(R.id.MotherOccasionallySmokeLiner);
        MotherOccasionallySmokeEdit = findViewById(R.id.MotherOccasionallySmokeEdit);
        MotherSmokeLinerFrequency = findViewById(R.id.MotherSmokeLinerFrequency);
        MotherSmokeEditFrequency = findViewById(R.id.MotherSmokeEditFrequency);
        MotherDurationSmokeLiner = findViewById(R.id.MotherDurationSmokeLiner);
        MotherDurationSmokeEdit = findViewById(R.id.MotherDurationSmokeEdit);
        YesMotherNarcoticRadio = findViewById(R.id.YesMotherNarcoticRadio);
        NoMotherNarcoticRadio = findViewById(R.id.NoMotherNarcoticRadio);
        MotherNarcoticLiner = findViewById(R.id.MotherNarcoticLiner);
        MotherNarcoticFrequencyLiner = findViewById(R.id.MotherNarcoticFrequencyLiner);
        MotherNarcoticEdit = findViewById(R.id.MotherNarcoticEdit);
        MotherNarcoticDurationLiner = findViewById(R.id.MotherNarcoticDurationLiner);
        MotherNarcoticDurationEdit = findViewById(R.id.MotherNarcoticDurationEdit);
        IllnessEditMother = findViewById(R.id.IllnessEditMother);
        MedicalHealthEditMother = findViewById(R.id.MedicalHealthEditMother);
        MedicalEditMother = findViewById(R.id.MedicalEditMother);
        MedicalTreatmentEditMother = findViewById(R.id.MedicalTreatmentEditMother);
        PersonEditMother = findViewById(R.id.PersonEditMother);
        MotherTypeTobaccoEdit = findViewById(R.id.MotherTypeTobaccoEdit);
        SmokeLinerMother = findViewById(R.id.SmokeLinerMother);

        //father

        FatherMainLiner = findViewById(R.id.FatherMainLiner);
        YesFatherPhysical = findViewById(R.id.YesFatherPhysical);
        NoFatherPhysical = findViewById(R.id.NoFatherPhysical);
        YesDiseaseFather = findViewById(R.id.YesDiseaseFather);
        YesSmokerFatherRadio = findViewById(R.id.YesSmokerFatherRadio);
        NoSmokerFatherRadio = findViewById(R.id.NoSmokerFatherRadio);
        YesPersonFatherRadio = findViewById(R.id.YesPersonFatherRadio);
        NoPersonFatherRadio = findViewById(R.id.NoPersonFatherRadio);
        NoDiseaseFather = findViewById(R.id.NoDiseaseFather);
        FatherDiseaseLiner = findViewById(R.id.FatherDiseaseLiner);
        bloodSugarFather = findViewById(R.id.bloodSugarFather);
        bloodPressureFather = findViewById(R.id.bloodPressureFather);
        bloodPressureDiastolicFather = findViewById(R.id.bloodPressureDiastolicFather);
        cholesterolFather = findViewById(R.id.cholesterolFather);
        YesConsumeAlcoholFather = findViewById(R.id.YesConsumeAlcoholFather);
        NoConsumeAlcoholFather = findViewById(R.id.NoConsumeAlcoholFather);
        ConsumeAlcoholFatherLiner = findViewById(R.id.ConsumeAlcoholFatherLiner);
        YesConsumeTobaccoFather = findViewById(R.id.YesConsumeTobaccoFather);
        NoConsumeTobaccoFather = findViewById(R.id.NoConsumeTobaccoFather);
        ConsumeTobaccoFatherLiner = findViewById(R.id.ConsumeTobaccoFatherLiner);
        YesPreExistingFatherRadio = findViewById(R.id.YesPreExistingFatherRadio);
        NoPreExistingFatherRadio = findViewById(R.id.NoPreExistingFatherRadio);
        NoFatherHistoryRadio = findViewById(R.id.NoFatherHistoryRadio);
        YesFatherHistoryRadio = findViewById(R.id.YesFatherHistoryRadio);
        AlcoholSpinnerFatherLiner = findViewById(R.id.AlcoholSpinnerFatherLiner);
        AlcoholEditFatherSpinner = findViewById(R.id.AlcoholEditFatherSpinner);
        OccasionallyFatherSpinnerLiner = findViewById(R.id.OccasionallyFatherSpinnerLiner);
        OccasionallyFatherEditSpinner = findViewById(R.id.OccasionallyFatherEditSpinner);
        TobaccoFatherLiner = findViewById(R.id.TobaccoFatherLiner);
        OccasionallyFatherTobaccoLiner = findViewById(R.id.OccasionallyFatherTobaccoLiner);
        TobaccoFatherSpinner = findViewById(R.id.TobaccoFatherSpinner);
        OccasionallyFatherTobaccoSpinner = findViewById(R.id.OccasionallyFatherTobaccoSpinner);
        TypeFatherLiner = findViewById(R.id.TypeFatherLiner);
        TypeFatherEdit = findViewById(R.id.TypeFatherEdit);
        DurationFatherLiner = findViewById(R.id.DurationFatherLiner);
        DurationFatherEdit = findViewById(R.id.DurationFatherEdit);
        SmokeTypeFatherLiner = findViewById(R.id.SmokeTypeFatherLiner);
        SmokeTypeFatherEdit = findViewById(R.id.SmokeTypeFatherEdit);
        SmokeFatherQuantityLiner = findViewById(R.id.SmokeFatherQuantityLiner);
        SmokeQuantityFatherEdit = findViewById(R.id.SmokeQuantityFatherEdit);
        SmokeFrequencyFatherLiner = findViewById(R.id.SmokeFrequencyFatherLiner);
        SmokeFrequencyFatherEdit = findViewById(R.id.SmokeFrequencyFatherEdit);
        SmokeDurationFatherLiner = findViewById(R.id.SmokeDurationFatherLiner);
        SmokeDurationFatherEdit = findViewById(R.id.SmokeDurationFatherEdit);
        SmokeFatherLiner = findViewById(R.id.SmokeFatherLiner);
        TypeFatherTobaccoLiner = findViewById(R.id.TypeFatherTobaccoLiner);
        TypeFatherTobaccoEdit = findViewById(R.id.TypeFatherTobaccoEdit);
        DurationFatherTobaccoLiner = findViewById(R.id.DurationFatherTobaccoLiner);
        DurationFatherTobaccoEdit = findViewById(R.id.DurationFatherTobaccoEdit);
        YesFatherNarcoticRadio = findViewById(R.id.YesFatherNarcoticRadio);
        NoFatherNarcoticRadio = findViewById(R.id.NoFatherNarcoticRadio);
        FatherNarcoticLiner = findViewById(R.id.FatherNarcoticLiner);
        FatherNarcoticFrequencyLiner = findViewById(R.id.FatherNarcoticFrequencyLiner);
        FatherNarcoticEdit = findViewById(R.id.FatherNarcoticEdit);
        FatherNarcoticDurationLiner = findViewById(R.id.FatherNarcoticDurationLiner);
        FatherNarcoticDurationEdit = findViewById(R.id.FatherNarcoticDurationEdit);
        IllnessEditFather = findViewById(R.id.IllnessEditFather);
        MedicalEditFather = findViewById(R.id.MedicalEditFather);
        MedicalTreatmentEditFather = findViewById(R.id.MedicalTreatmentEditFather);
        TreatmentHistoryEditFather = findViewById(R.id.TreatmentHistoryEditFather);
        PersonEditFather = findViewById(R.id.PersonEditFather);

        //MotherInLaw
        MatherLawMainLiner = findViewById(R.id.MatherLawMainLiner);
        YesMotherLawPhysical = findViewById(R.id.YesMotherLawPhysical);
        NoMotherLawPhysical = findViewById(R.id.NoMotherLawPhysical);
        YesDiseaseMotherLaw = findViewById(R.id.YesDiseaseMotherLaw);
        NoDiseaseMotherLaw = findViewById(R.id.NoDiseaseMotherLaw);
        MotherLawDiseaseLiner = findViewById(R.id.MotherLawDiseaseLiner);
        bloodSugarMatherLaw = findViewById(R.id.bloodSugarMatherLaw);
        bloodPressureMatherLaw = findViewById(R.id.bloodPressureMatherLaw);
        bloodPressureDiastolicMatherLaw = findViewById(R.id.bloodPressureDiastolicMatherLaw);
        cholesterolMatherLaw = findViewById(R.id.cholesterolMatherLaw);
        YesConsumeAlcoholMotherLaw = findViewById(R.id.YesConsumeAlcoholMotherLaw);
        NoConsumeAlcoholMotherLaw = findViewById(R.id.NoConsumeAlcoholMotherLaw);
        ConsumeAlcoholMotherLaw = findViewById(R.id.ConsumeAlcoholMotherLaw);
        YesConsumeTobaccoMotherLaw = findViewById(R.id.YesConsumeTobaccoMotherLaw);
        NoConsumeTobaccoMotherLaw = findViewById(R.id.NoConsumeTobaccoMotherLaw);
        ConsumeTobaccoMotherLawLiner = findViewById(R.id.ConsumeTobaccoMotherLawLiner);

        //fatherLaw
       
        FatherLawTwoLiner = findViewById(R.id.FatherLawTwoLiner);
        YesPhysicalFatherLaw = findViewById(R.id.YesPhysicalFatherLaw);
        NoPhysicalFatherLaw = findViewById(R.id.NoPhysicalFatherLaw);
        YesDiseaseFatherLaw = findViewById(R.id.YesDiseaseFatherLaw);
        NoDiseaseFatherLaw = findViewById(R.id.NoDiseaseFatherLaw);
        DiseaseLinerFatherLaw = findViewById(R.id.DiseaseLinerFatherLaw);
        bloodSugarFatherLaw = findViewById(R.id.bloodSugarFatherLaw);
        bloodPressureFatherLaw = findViewById(R.id.bloodPressureFatherLaw);
        bloodPressureDiastolicFatherLaw = findViewById(R.id.bloodPressureDiastolicFatherLaw);
        cholesterolFatherLaw = findViewById(R.id.cholesterolFatherLaw);
        YesConsumeAlcoholFatherLaw = findViewById(R.id.YesConsumeAlcoholFatherLaw);
        NoConsumeAlcoholFatherLaw = findViewById(R.id.NoConsumeAlcoholFatherLaw);
        ConsumeAlcoholFatherLawLiner = findViewById(R.id.ConsumeAlcoholFatherLawLiner);
        YesConsumeTobaccoFatherLaw = findViewById(R.id.YesConsumeTobaccoFatherLaw);
        NoConsumeTobaccoFatherLaw = findViewById(R.id.NoConsumeTobaccoFatherLaw);
        ConsumeTobaccoFatherLawLiner = findViewById(R.id.ConsumeTobaccoFatherLawLiner);
        
        policyTypeEdit.setText(str_policyType_spinner);
        familyTypeEdit.setText(str_IndividualTypeEdit);
        sumInsuredEdit.setText(str_SumInsured);
        policyTenureEdit.setText(strFirstTString+" Year");
        totalPremiumAmount.setText(str_TotalValue);
//        hospitalCashSpinner.setText(str_SumInsured);
        QuotationID.setText(QuoteId);
//        hospitalCashSpinner.setAlpha(0.5f);
        policyTypeEdit.setAlpha(0.5f);
        familyTypeEdit.setAlpha(0.5f);
        sumInsuredEdit.setAlpha(0.5f);
        policyTenureEdit.setAlpha(0.5f);
        totalPremiumAmount.setAlpha(0.5f);
        QuotationID.setAlpha(0.5f);

        if (str_policyType_spinner.equals("Individual")) {
            linerAdult.setVisibility(View.VISIBLE);
            SpouseLiner.setVisibility(View.GONE);
            LinerChildOneLiner.setVisibility(View.GONE);
            ChildTwoLiner.setVisibility(View.GONE);
            ChildThreeLiner.setVisibility(View.GONE);
            LinerFourChild.setVisibility(View.GONE);

        }
        else {
            if(str_IndividualTypeEdit.equals("2 Adult")){
                linerAdult.setVisibility(View.VISIBLE);
                SpouseLiner.setVisibility(View.VISIBLE);
                LinerChildOneLiner.setVisibility(View.GONE);
                ChildTwoLiner.setVisibility(View.GONE);
                ChildThreeLiner.setVisibility(View.GONE);
                LinerFourChild.setVisibility(View.GONE);

            } else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                linerAdult.setVisibility(View.VISIBLE);
                SpouseLiner.setVisibility(View.GONE);
                LinerChildOneLiner.setVisibility(View.VISIBLE);
                ChildTwoLiner.setVisibility(View.GONE);
                ChildThreeLiner.setVisibility(View.GONE);
                LinerFourChild.setVisibility(View.GONE);

            }else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                linerAdult.setVisibility(View.VISIBLE);
                SpouseLiner.setVisibility(View.GONE);
                LinerChildOneLiner.setVisibility(View.VISIBLE);
                ChildTwoLiner.setVisibility(View.VISIBLE);
                ChildThreeLiner.setVisibility(View.GONE);
                LinerFourChild.setVisibility(View.GONE);

            }else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                linerAdult.setVisibility(View.VISIBLE);
                SpouseLiner.setVisibility(View.GONE);
                LinerChildOneLiner.setVisibility(View.VISIBLE);
                ChildTwoLiner.setVisibility(View.VISIBLE);
                ChildThreeLiner.setVisibility(View.VISIBLE);
                LinerFourChild.setVisibility(View.GONE);
            } else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                linerAdult.setVisibility(View.VISIBLE);
                SpouseLiner.setVisibility(View.VISIBLE);
                LinerChildOneLiner.setVisibility(View.VISIBLE);
                ChildTwoLiner.setVisibility(View.GONE);
                ChildThreeLiner.setVisibility(View.GONE);
                LinerFourChild.setVisibility(View.GONE);

            } else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                linerAdult.setVisibility(View.VISIBLE);
                SpouseLiner.setVisibility(View.VISIBLE);
                LinerChildOneLiner.setVisibility(View.VISIBLE);
                ChildTwoLiner.setVisibility(View.VISIBLE);
                ChildThreeLiner.setVisibility(View.GONE);
                LinerFourChild.setVisibility(View.GONE);
            } else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                linerAdult.setVisibility(View.VISIBLE);
                SpouseLiner.setVisibility(View.VISIBLE);
                LinerChildOneLiner.setVisibility(View.VISIBLE);
                ChildTwoLiner.setVisibility(View.VISIBLE);
                ChildThreeLiner.setVisibility(View.VISIBLE);
                LinerFourChild.setVisibility(View.GONE);
            }
            else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                linerAdult.setVisibility(View.VISIBLE);
                SpouseLiner.setVisibility(View.VISIBLE);
                LinerChildOneLiner.setVisibility(View.VISIBLE);
                ChildTwoLiner.setVisibility(View.VISIBLE);
                ChildThreeLiner.setVisibility(View.VISIBLE);
                LinerFourChild.setVisibility(View.VISIBLE);
                MotherLiner.setVisibility(View.GONE);
                FatherLiner.setVisibility(View.GONE);

            }
            else{
                linerAdult.setVisibility(View.VISIBLE);
                SpouseLiner.setVisibility(View.GONE);
                LinerChildOneLiner.setVisibility(View.GONE);
                ChildTwoLiner.setVisibility(View.GONE);
                ChildThreeLiner.setVisibility(View.GONE);
                LinerFourChild.setVisibility(View.GONE);
            }


            if (strParentEditText.equals("Mother")){
                MotherLiner.setVisibility(View.VISIBLE);
                FatherLiner.setVisibility(View.GONE);
                MotherTxt.setText("Mother");
            }else if (strParentEditText.equals("Father")){
                MotherLiner.setVisibility(View.GONE);
                FatherLiner.setVisibility(View.VISIBLE);
                FatherTxt.setText("Father");
            }else if (strParentEditText.equals("Mother & Father")){
                MotherLiner.setVisibility(View.VISIBLE);
                FatherLiner.setVisibility(View.VISIBLE);
                MotherTxt.setText("Mother");
                FatherTxt.setText("Father");
            }else if (strParentEditText.equals("Mother-In-Law")){
                MotherLiner.setVisibility(View.VISIBLE);
                FatherLiner.setVisibility(View.GONE);
                MotherTxt.setText("Mother-In-Law");
            }else if (strParentEditText.equals("Father-In-Law")){
                MotherLiner.setVisibility(View.GONE);
                FatherLiner.setVisibility(View.VISIBLE);
                FatherTxt.setText("Father-In-Law");
            }else if (strParentEditText.equals("Mother-In-Law & Father-In-Law")){
                MotherLiner.setVisibility(View.VISIBLE);
                FatherLiner.setVisibility(View.VISIBLE);
                MotherTxt.setText("Mother-In-Law");
                FatherTxt.setText("Father-In-Law");
            }else{
                MotherLiner.setVisibility(View.GONE);
                FatherLiner.setVisibility(View.GONE);
            }


        }






        strSelfTobaccoRadio = "No";
        strNarcoticRadio = "No";



        strAlcoholEditSpinner = "Weekly";
        strTobaccoEditSelf = "Weekly";
        strSpouseEditFrequency = "Weekly";
        strTobaccoEditSpouse = "Weekly";
        strAlcoholEditSpinnerChildOne = "Weekly";
        strConsumeTabaccoChildOne = "Weekly";
        strAlcoholTwoChildEditSpinner = "Weekly";
        strTobaccoEditTwoChild = "Weekly";
        strAlcoholEditSpinnerThirdChild = "Weekly";
        strAlcoholEditThirdChild = "Weekly";
        strTobaccoEditFrequency = "Weekly";
        strAlcoholEditFrequency = "Weekly";
        strMotherAlcoholEditSpinner = "Weekly";
        strAlcoholEditFatherSpinner = "Weekly";
        strTobaccoFatherSpinner = "Weekly";
        strMotherTobaccoEditSpinner = "Weekly";
        strAlcoholTwoChildEditSpinner = "Weekly";
        strOccasionallyEditSpinner = "30ml";
        strTobaccoOccasinallyEditSelf = "1 to 5gm";
        strOccasionallySpouseEditSpinner = "30ml";
        strTobaccoOccasinallyEditSpouse = "1 to 5gm";
        strOccasionallyEditChildOneSpinner = "30ml";
        strConsumeTabaccoChildOneSpinner = "1 to 5gm";
        strOccasionallyTwoChildEditSpinner = "30ml";
        strTobaccoOccasinallyEditTwoChild = "1 to 5gm";
        strOccasionallyEditSpinnerThirdChild = "30ml";
        strOccasionallyEditThirdChild = "1 to 5gm";
        strOccasionallyTobaccoSpinner = "1 to 5gm";
        strOccasionallyLiterSpinner = "30ml";
        strMotherOccasionallyTobaccoSpinner = "1 to 5gm";
        strOccasionallyFatherEditSpinner = "30ml";
        strOccasionallyFatherTobaccoSpinner = "1 to 5gm";
        strMotherOccasionallyEditSpinner = "30ml";
        strYesPhysicalMentalRadio = "No";
        strYesPreExistingRadio = "No";
        strSufferingDiseaseSecondAdult = "No";
        strSpousePhysicalRadio = "No";
        strSelfTobaccoRadio = "No";
        strSelfAlcoholRadio = "No";
        strMedicalHistoryRadio = "No";
        strPersonRadio = "No";
        strSmokerRadio = "No";
        strSmokerSpouseRadio = "No";
        strPersonSpouseRadio = "No";
        strMedicineRadio = "No";
        strDiseaseSpouseRadio = "No";
        strHospitalizationHistory = "No";
        strHospitalizationHistoryAdultSecond = "No";
        strChildTwoPreExisting = "No";
        strChildTwoPhysicalRadio = "No";
        strChildTwoPreDisease = "No";
        strSpouseTobaccoRadio = "No";
        strConsumeSpouseAlcohol = "No";
        strSpouseNarcoticRadio = "No";
        strPreExistingChildOneRadio = "No";
        strChildOnePhysicalRadio = "No";
        strMedicineChildOneRadio = "No";
        strPersonChildRadio = "No";
        strSmokerChildRadio = "No";
        strChildOnePreExisting = "No";
        strChildOneConsumeAlcoholRadio = "No";
        strChildTwoHistory = "No";
        strPersonChildThird = "No";
        strSmokerChildThird = "No";
        strPersonChildTwo = "No";
        strSmokerChildTwo = "No";
        strPreExistingThirdChild = "No";
        strPhysicalChildThirdRadio = "No";
        strMedicineThirdChildRadio = "No";
        strDiseaseChildThird = "No";
        strPreExistingFourChild = "No";
        strPhysicalChildFourRadio = "No";
        strDiseaseChildFourRadio = "No";
        strHistoryFourChild = "No";
        strSmokerChildFourChild = "No";
        strPersonChildFourChild = "No";
        strConsumeAlcoholFourChild = "No";
        strMotherPhysical = "No";
        strDiseaseMother = "No";
        strDiseaseChildFourRadio = "No";
        strAlcoholRadioThirdChild = "No";
        strTobaccoThirdChild = "No";
        strChildThirdNarcotic = "No";
        strPhysicalChildThirdRadio = "No";
        strChildTwoAlcoholRadio = "No";
        strChildTwoNarcotic = "No";
        strTobaccoChildTwoRadio = "No";
        strConsumeTobaccoChildOneRadio = "No";
        strChildNarcotic = "No";
        strMotherHistoryRadio = "No";
        strConsumeAlcoholMother = "No";
        strConsumeTobaccoMother = "No";
        strMotherNarcotic = "No";
        strPreExistingFather = "No";
        strFatherPhysical = "No";
        strDiseaseFather = "No";
        strPersonFather = "No";
        strSmokerFather = "No";
        strFatherHistory = "No";
        strConsumeAlcoholFather = "No";
        strConsumeTobacco = "No";
        strChildFourNarcotic = "No";
        strPreExistingMother = "No";
        strPersonMotherRadio = "No";
        strSmokerMotherRadio = "No";
        strConsumeTobaccoFather = "No";
        strFatherNarcotic = "No";
        strNarcoticRadio = "No";

        strTypeEditSpinner="Beer";
        strTypeSpouseEditSpinner="Beer";
        strTypeChildOneEditSpinner="Beer";
        strTypeTwoChildEdit="Beer";
        strTypeEditThirdChild="Beer";
        strTypeAlcoholEditChild4="Beer";
        strTypeFatherEdit="Beer";
        strMotherTypeEdit="Beer";

        strAlcoholDurationEditSpinner="<5 years";
        strSpouseDurationEditSpinner="<5 years";
        strTobaccoDurationEditSelf="<5 years";
        strTobaccoDurationEditSpouse="<5 years";
        strTobaccoDurationEditChild1="<5 years";
        strDurationTobaccoEditTwoChild="<5 years";
        strDurationTobaccoEditThirdChild="<5 years";
        strDurationTobaccoEditChild4="<5 years";
        strMotherDurationTobaccoEdit="<5 years";
        strNarcoticDurationEditSelf="<5 years";
        strNarcoticDurationEditSpouse="<5 years";
        strChildNarcoticDurationEdit="<5 years";
        strChildTwoNarcoticDurationEdit="<5 years";
        strChildThirdNarcoticDurationEdit="<5 years";
        strChildFourNarcoticDurationEdit="<5 years";
        strMotherNarcoticDurationEdit="<5 years";
        strDurationFatherTobaccoEdit="<5 years";
        strFatherNarcoticDurationEdit="<5 years";


        strTobaccoTypeEditSelf="Tobacco";
        strTobaccoTypeEditSpouse="Tobacco";
        strTobaccoTypeEditChildOne="Tobacco";
        strTypeTobaccoEditTwoChild="Tobacco";
        strTypeTobaccoEditThirdChild="Tobacco";
        strTypeTobaccoEditChild4="Tobacco";
        strTypeFatherTobaccoEdit="Tobacco";
        strMotherTypeTobaccoEdit="Tobacco";
        strNarcoticEditSelf="Daily";
        strNarcoticEditSpouse="Daily";
        strChildNarcoticEdit="Daily";
        strChildTwoNarcoticEditSelf="Daily";
        strChildThirdNarcoticEdit="Daily";
        strChildFourNarcoticEdit="Daily";
        strMotherNarcoticEdit="Daily";
        strFatherNarcoticEdit="Daily";

        //smoke
        strTypeSmokeEditSpinner="Cigarette";
        strTypeSpouseSmokeEditSpinner="Cigarette";
        strTypeChildOneSmokeEdit="Cigarette";
        strTypeSmokeEditTwoChild="Cigarette";
        strTypeSmokeEditThirdChild="Cigarette";
        strSmokeTypeEditChild4="Cigarette";
        strMotherTypeSmokeEdit="Cigarette";
        strSmokeTypeFatherEdit="Cigarette";
        strSmokeOccasionallyEditSpinner="1 to 5";
        strSmokeSpouseOccasionallyEditSpinner="1 to 5";
        strSmokeChildOneOccasionallyEdit="1 to 5";
        strSmokeOccasinallyEditTwoChild="1 to 5";
        strQuantitySmokeEditThirdChild="1 to 5";
        strSmokeQuantityEdit="1 to 5";
        strSmokeQuantityFatherEdit="1 to 5";
        strMotherOccasionallySmokeEdit="1 to 5";
        strSmokeAlcoholEditSpinner="Daily";
        strSmokeSpouseAlcoholEditSpinner="Daily";
        strSmokeChildOneDurationEdit="<5 years";
        strDurationSmokeEditTwoChild="<5 years";
        strDurationSmokeEditThirdChild="<5 years";
        strDurationSmokeEditChild4="<5 years";
        strSmokeDurationFatherEdit="<5 years";
        strMotherDurationSmokeEdit="<5 years";
        strSmokeDurationEditSpinner="<5 years";
        strSmokeSpouseDurationEditSpinner="<5 years";
        strSmokeChildOneAlcoholEdit="Daily";
        strSmokeEditTwoChild="Daily";
        strFrequencySmokeEditThirdChild="Daily";
        strSmokeEditFrequencyChild4="Daily";
        strSmokeFrequencyFatherEdit="Daily";
        strMotherSmokeEditFrequency="Daily";
        strChildOneDurationEditSpinner="<5 years";
        strDurationTwoChildEdit="<5 years";
        strDurationEditThirdChild="<5 years";
        strDurationAlcoholEditChild4="<5 years";
        strMotherDurationEdit="<5 years";
        strDurationFatherEdit="<5 years";

        //Smoke
        TypeSmokeEditSpinner.setText(strTypeSmokeEditSpinner);
        TypeSpouseSmokeEditSpinner.setText(strTypeSpouseSmokeEditSpinner);
        TypeChildOneSmokeEdit.setText(strTypeChildOneSmokeEdit);
        SmokeOccasionallyEditSpinner.setText(strSmokeOccasionallyEditSpinner);
        SmokeSpouseOccasionallyEditSpinner.setText(strSmokeSpouseOccasionallyEditSpinner);
        SmokeChildOneOccasionallyEdit.setText(strSmokeChildOneOccasionallyEdit);
        SmokeAlcoholEditSpinner.setText(strSmokeAlcoholEditSpinner);
        SmokeSpouseAlcoholEditSpinner.setText(strSmokeSpouseAlcoholEditSpinner);
        SmokeDurationEditSpinner.setText(strSmokeDurationEditSpinner);
        SmokeSpouseDurationEditSpinner.setText(strSmokeSpouseDurationEditSpinner);
        SmokeChildOneAlcoholEdit.setText(strSmokeChildOneAlcoholEdit);
        SmokeChildOneDurationEdit.setText(strSmokeChildOneDurationEdit);
        TypeSmokeEditTwoChild.setText(strTypeSmokeEditTwoChild);
        TypeSmokeEditThirdChild.setText(strTypeSmokeEditThirdChild);
        SmokeOccasinallyEditTwoChild.setText(strSmokeOccasinallyEditTwoChild);
        SmokeEditTwoChild.setText(strSmokeEditTwoChild);
        DurationSmokeEditTwoChild.setText(strDurationSmokeEditTwoChild);
        QuantitySmokeEditThirdChild.setText(strQuantitySmokeEditThirdChild);
        FrequencySmokeEditThirdChild.setText(strFrequencySmokeEditThirdChild);
        DurationSmokeEditThirdChild.setText(strDurationSmokeEditThirdChild);
        SmokeTypeEditChild4.setText(strSmokeTypeEditChild4);
        SmokeQuantityEdit.setText(strSmokeQuantityEdit);
        SmokeEditFrequencyChild4.setText(strSmokeEditFrequencyChild4);
        DurationSmokeEditChild4.setText(strDurationSmokeEditChild4);
        MotherTypeSmokeEdit.setText(strMotherTypeSmokeEdit);
        MotherOccasionallySmokeEdit.setText(strMotherOccasionallySmokeEdit);
        MotherSmokeEditFrequency.setText(strMotherSmokeEditFrequency);
        MotherDurationSmokeEdit.setText(strMotherDurationSmokeEdit);
        SmokeTypeFatherEdit.setText(strSmokeTypeFatherEdit);
        SmokeQuantityFatherEdit.setText(strSmokeQuantityFatherEdit);
        SmokeFrequencyFatherEdit.setText(strSmokeFrequencyFatherEdit);
        SmokeDurationFatherEdit.setText(strSmokeDurationFatherEdit);

        //typeAlchol
        TypeEditSpinner.setText(strTypeEditSpinner);
        TypeEditSpinner.setText(strTypeSpouseEditSpinner);
        TypeChildOneEditSpinner.setText(strTypeChildOneEditSpinner);
        TypeTwoChildEdit.setText(strTypeTwoChildEdit);
        TypeEditThirdChild.setText(strTypeEditThirdChild);
        AlcoholDurationEditSpinner.setText(strAlcoholDurationEditSpinner);
        SpouseDurationEditSpinner.setText(strSpouseDurationEditSpinner);
        ChildOneDurationEditSpinner.setText(strChildOneDurationEditSpinner);
        DurationTwoChildEdit.setText(strDurationTwoChildEdit);
        DurationEditThirdChild.setText(strDurationEditThirdChild);
        DurationAlcoholEditChild4.setText(strDurationAlcoholEditChild4);
        TypeAlcoholEditChild4.setText(strTypeAlcoholEditChild4);
        MotherTypeEdit.setText(strMotherTypeEdit);
        MotherDurationEdit.setText(strMotherDurationEdit);
        TypeFatherEdit.setText(strTypeFatherEdit);
        DurationFatherEdit.setText(strDurationFatherEdit);

        OccasionallyFatherTobaccoSpinner.setText(strOccasionallyFatherTobaccoSpinner);
        OccasionallyFatherEditSpinner.setText(strOccasionallyFatherEditSpinner);
        AlcoholEditSpinner.setText(strAlcoholEditSpinner);
        TobaccoEditSelf.setText(strTobaccoEditSelf);
        OccasionallyEditSpinner.setText(strOccasionallyEditSpinner);
        TobaccoOccasinallyEditSelf.setText(strTobaccoOccasinallyEditSelf);
        SpouseEditFrequency.setText(strSpouseEditFrequency);
        OccasionallySpouseEditSpinner.setText(strOccasionallySpouseEditSpinner);
        TobaccoEditSpouse.setText(strTobaccoEditSpouse);
        TobaccoOccasinallyEditSpouse.setText(strTobaccoOccasinallyEditSpouse);
        AlcoholEditSpinnerChildOne.setText(strAlcoholEditSpinnerChildOne);
        OccasionallyEditChildOneSpinner.setText(strOccasionallyEditChildOneSpinner);
        ConsumeTabaccoChildOne.setText(strConsumeTabaccoChildOne);
        ConsumeTabaccoChildOneSpinner.setText(strConsumeTabaccoChildOneSpinner);
        AlcoholTwoChildEditSpinner.setText(strAlcoholTwoChildEditSpinner);
        OccasionallyTwoChildEditSpinner.setText(strOccasionallyTwoChildEditSpinner);
        TobaccoEditTwoChild.setText(strTobaccoEditTwoChild);
        TobaccoOccasinallyEditTwoChild.setText(strTobaccoOccasinallyEditTwoChild);
        AlcoholEditThirdChild.setText(strAlcoholEditThirdChild);
        OccasionallyTobaccoSpinner.setText(strOccasionallyTobaccoSpinner);
        AlcoholEditFrequency.setText(strAlcoholEditFrequency);
        OccasionallyLiterSpinner.setText(strOccasionallyLiterSpinner);
        MotherAlcoholEditSpinner.setText(strMotherAlcoholEditSpinner);
        MotherOccasionallyTobaccoSpinner.setText(strMotherOccasionallyTobaccoSpinner);
        AlcoholEditSpinnerThirdChild.setText(strAlcoholEditSpinnerThirdChild);
        OccasionallyEditSpinnerThirdChild.setText(strOccasionallyEditSpinnerThirdChild);
        OccasionallyEditThirdChild.setText(strOccasionallyEditThirdChild);
        TobaccoEditFrequency.setText(strTobaccoEditFrequency);
        AlcoholEditFatherSpinner.setText(strAlcoholEditFatherSpinner);
        TobaccoFatherSpinner.setText(strTobaccoFatherSpinner);
        MotherOccasionallyEditSpinner.setText(strMotherOccasionallyEditSpinner);
        MotherTobaccoEditSpinner.setText(strMotherTobaccoEditSpinner);
        TobaccoDurationEditSelf.setText(strTobaccoDurationEditSelf);
        TobaccoTypeEditSelf.setText(strTobaccoTypeEditSelf);
        TobaccoTypeEditSpouse.setText(strTobaccoTypeEditSpouse);
        NarcoticEditSelf.setText(strNarcoticEditSelf);
        NarcoticEditSpouse.setText(strNarcoticEditSpouse);
        ChildNarcoticEdit.setText(strChildNarcoticEdit);
        NarcoticDurationEditSelf.setText(strNarcoticDurationEditSelf);
        NarcoticDurationEditSpouse.setText(strNarcoticDurationEditSpouse);
        ChildNarcoticDurationEdit.setText(strChildNarcoticDurationEdit);
        TobaccoDurationEditSpouse.setText(strTobaccoDurationEditSpouse);
        TobaccoTypeEditChildOne.setText(strTobaccoTypeEditChildOne);
        TobaccoDurationEditChild1.setText(strTobaccoDurationEditChild1);
        TypeTobaccoEditTwoChild.setText(strTypeTobaccoEditTwoChild);
        DurationTobaccoEditTwoChild.setText(strDurationTobaccoEditTwoChild);
        ChildTwoNarcoticEditSelf.setText(strChildTwoNarcoticEditSelf);
        ChildTwoNarcoticDurationEdit.setText(strChildTwoNarcoticDurationEdit);
        TypeTobaccoEditThirdChild.setText(strTypeTobaccoEditThirdChild);
        DurationTobaccoEditThirdChild.setText(strDurationTobaccoEditThirdChild);
        ChildThirdNarcoticEdit.setText(strChildThirdNarcoticEdit);
        ChildThirdNarcoticDurationEdit.setText(strChildThirdNarcoticDurationEdit);
        TypeTobaccoEditChild4.setText(strTypeTobaccoEditChild4);
        DurationTobaccoEditChild4.setText(strDurationTobaccoEditChild4);
        ChildFourNarcoticEdit.setText(strChildFourNarcoticEdit);
        ChildFourNarcoticDurationEdit.setText(strChildFourNarcoticDurationEdit);
        MotherTypeTobaccoEdit.setText(strMotherTypeTobaccoEdit);
        MotherDurationTobaccoEdit.setText(strMotherDurationTobaccoEdit);
        MotherNarcoticEdit.setText(strMotherNarcoticEdit);
        MotherNarcoticDurationEdit.setText(strMotherNarcoticDurationEdit);
        TypeFatherTobaccoEdit.setText(strTypeFatherTobaccoEdit);
        DurationFatherTobaccoEdit.setText(strDurationFatherTobaccoEdit);
        FatherNarcoticEdit.setText(strFatherNarcoticEdit);
        FatherNarcoticDurationEdit.setText(strFatherNarcoticDurationEdit);
        YesChildThirdNarcoticRadio.setChecked(false);
        YesMotherNarcoticRadio.setChecked(false);
        YesChildFourNarcoticRadio.setChecked(false);
        NoChildThirdNarcoticRadio.setChecked(true);
        NoMotherNarcoticRadio.setChecked(true);
        NoChildFourNarcoticRadio.setChecked(true);
        YesChildTwoNarcoticRadio.setChecked(false);
        YesChildNarcoticRadio.setChecked(false);
        YesSpouseNarcoticRadio.setChecked(false);
        NoChildTwoNarcoticRadio.setChecked(true);
        NoChildNarcoticRadio.setChecked(true);
        NoSpouseNarcoticRadio.setChecked(true);
        NoConsumeTobaccoFather.setChecked(true);
        NoFatherNarcoticRadio.setChecked(true);
        YesFatherNarcoticRadio.setChecked(false);
        YesConsumeTobaccoFather.setChecked(false);
        NoConsumeAlcoholFather.setChecked(true);
        YesConsumeAlcoholFather.setChecked(false);
        NoFatherHistoryRadio.setChecked(true);
        YesFatherHistoryRadio.setChecked(false);
        NoDiseaseFather.setChecked(true);
        YesDiseaseFather.setChecked(false);
        YesSmokerFatherRadio.setChecked(false);
        YesPersonFatherRadio.setChecked(false);
        NoFatherPhysical.setChecked(true);
        YesFatherPhysical.setChecked(false);
        NoPreExistingFatherRadio.setChecked(true);
        YesPreExistingFatherRadio.setChecked(false);
        NoConsumeAlcoholMother.setChecked(true);
        YesConsumeAlcoholMother.setChecked(false);
        NoConsumeTobaccoMother.setChecked(true);
        YesConsumeTobaccoMother.setChecked(false);
        NoMotherHistoryRadio.setChecked(true);
        YesMotherHistoryRadio.setChecked(false);
        NoConsumeTobaccoChildOneRadio.setChecked(true);
        YesConsumeTobaccoChildOneRadio.setChecked(false);
        NoTobaccoChildTwoRadio.setChecked(true);
        YesTobaccoChildTwoRadio.setChecked(false);
        YesChildTwoAlcoholRadio.setChecked(false);
        NoChildTwoAlcoholRadio.setChecked(true);
        NoPhysicalChildThirdRadio.setChecked(true);
        YesPhysicalChildThirdRadio.setChecked(false);
        NoAlcoholRadioThirdChild.setChecked(true);
        YesAlcoholRadioThirdChild.setChecked(false);
        NoConsumeTobaccoChildFour.setChecked(true);
        YesConsumeTobaccoChildFour.setChecked(false);
        NoTobaccoThirdChild.setChecked(true);
        YesTobaccoThirdChild.setChecked(false);
        NoMotherPhysical.setChecked(true);
        YesMotherPhysical.setChecked(false);
        NoDiseaseMother.setChecked(true);
        YesDiseaseMother.setChecked(false);
        NoDiseaseChildFourRadio.setChecked(true);
        YesDiseaseChildFourRadio.setChecked(false);
        YesPhysicalMentalRadio.setChecked(false);
        NoPhysicalMentalRadio.setChecked(true);
        NoPreExistingRadio.setChecked(true);
        YesPreExistingRadio.setChecked(false);
        YesTobaccoRadio.setChecked(false);
        YesNarcoticRadio.setChecked(false);
        NoTobaccoRadio.setChecked(true);
        NoNarcoticRadio.setChecked(true);
        YesAlcoholRadio.setChecked(false);
        NoAlcoholRadio.setChecked(true);
        NoMedicalHistoryRadio.setChecked(true);
        NoMedicineRadio.setChecked(true);
        NoHospitalizationHistoryRadio.setChecked(true);
        NoRadioSufferingDiseaseSecondAdult.setChecked(true);
        YesRadioSufferingDiseaseSecondAdult.setChecked(false);
        SpouseYesPhysicalRadio.setChecked(false);
        SpouseNoPhysicalRadio.setChecked(true);
        NoDiseaseSpouseRadio.setChecked(true);
        YesDiseaseSpouseRadio.setChecked(false);
        YesHospitalizationHistoryAdultSecondRadio.setChecked(false);
        NoHospitalizationHistoryAdultSecondRadio.setChecked(true);
        YesConsumeAlcoholRadio.setChecked(false);
        NoConsumeAlcoholRadio.setChecked(true);
        YesSpouseTobaccoRadio.setChecked(false);
        NoSpouseTobaccoRadio.setChecked(true);
        NoPreExistingChildOneRadio.setChecked(true);
        YesPreExistingChildOneRadio.setChecked(false);
        YesChildOnePhysicalRadio.setChecked(false);
        NoChildOnePhysicalRadio.setChecked(true);
        YesMedicineChildOneRadio.setChecked(false);
        NoMedicineChildOneRadio.setChecked(true);
        YesChildOnePreExistingRadio.setChecked(false);
        NoChildOnePreExistingRadio.setChecked(true);
        YesChildOneConsumeAlcoholRadio.setChecked(false);
        NoChildOneConsumeAlcoholRadio.setChecked(true);
        YesChildTwoPreExistingRadio.setChecked(false);
        NoChildTwoPreExistingRadio.setChecked(true);
        NoChildTwoPhysicalRadio.setChecked(true);
        YesChildTwoPhysicalRadio.setChecked(false);
        NoChildTwoPreDisease.setChecked(true);
        YesChildTwoPreDisease.setChecked(false);
        NoChildTwoHistoryRadio.setChecked(true);
        YesChildTwoHistoryRadio.setChecked(false);
        YesPreExistingThirdChildRadio.setChecked(false);
        NoPreExistingThirdChildRadio.setChecked(true);
        NoPreExistingThirdChildRadio.setChecked(true);
        YesMedicineThirdChildRadio.setChecked(false);
        NoMedicineThirdChildRadio.setChecked(true);
        NoDiseaseChildThird.setChecked(true);
        YesDiseaseChildThird.setChecked(false);
        NoPreExistingFourChildRadio.setChecked(true);
        YesPreExistingFourChildRadio.setChecked(false);
        NoPhysicalChildFourRadio.setChecked(true);
        YesPhysicalChildFourRadio.setChecked(false);
        YesHistoryFourChildRadio.setChecked(false);
        NoHistoryFourChildRadio.setChecked(true);
        NoConsumeAlcoholFourChild.setChecked(true);
        YesConsumeAlcoholFourChild.setChecked(false);
        YesPreExistingMotherRadio.setChecked(false);
        NoPreExistingMotherRadio.setChecked(true);
        NoPersonRadio.setChecked(true);
        NoSmokerRadio.setChecked(true);
        YesPersonRadio.setChecked(false);
        YesSmokerRadio.setChecked(false);
        YesSmokerSpouseRadio.setChecked(false);
        YesPersonSpouseRadio.setChecked(false);
        YesPersonChildRadio.setChecked(false);
        YesSmokerChildRadio.setChecked(false);
        YesPersonThirdChildRadio.setChecked(false);
        YesSmokerChildThirdRadio.setChecked(false);
        YesSmokerChildFourRadio.setChecked(false);
        YesPersonChildFourRadio.setChecked(false);
        YesPersonChildTwoRadio.setChecked(false);
        YesSmokerChildTwoRadio.setChecked(false);
        YesPersonMotherRadio.setChecked(false);
        YesSmokerMotherRadio.setChecked(false);
        NoPersonThirdChildRadio.setChecked(true);
        NoSmokerSpouseRadio.setChecked(true);
        NoPersonChildTwoRadio.setChecked(true);
        NoPersonSpouseRadio.setChecked(true);
        NoPersonChildRadio.setChecked(true);
        NoSmokerChildRadio.setChecked(true);
        NoSmokerChildTwoRadio.setChecked(true);
        NoSmokerChildThirdRadio.setChecked(true);
        NoSmokerChildFourRadio.setChecked(true);
        NoPersonChildFourRadio.setChecked(true);
        NoPersonMotherRadio.setChecked(true);
        NoSmokerMotherRadio.setChecked(true);
        NoSmokerFatherRadio.setChecked(true);
        NoPersonFatherRadio.setChecked(true);

//        if (str_for.equals("1")){
//            if (str_policyType_spinner.equals("Individual")) {
//                bloodSugar.setText(strbloodSugar);
//                bloodPressure.setText(strbloodPressure);
//                bloodPressureDiastolic.setText(strbloodPressureDiastolic);
//                cholesterol.setText(stredtcholesterol);
//            }else {
//                if (str_IndividualTypeEdit.equals("2 Adult")) {
//                    bloodSugar.setText(strbloodSugar);
//                    bloodPressure.setText(strbloodPressure);
//                    bloodPressureDiastolic.setText(strbloodPressureDiastolic);
//                    cholesterol.setText(stredtcholesterol);
//                    bloodSugarAdultTwo.setText(strbloodSugarAdultTwo);
//                    bloodPressureAdultTwo.setText(strbloodPressureAdultTwo);
//                    bloodPressureDiastolicAdultTwo.setText(strbloodPressureDiastolicAdultTwo);
//                    cholesterolAdultTwo.setText(strcholesterolAdultTwo);
//                }else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
//                    bloodSugar.setText(strbloodSugar);
//                    bloodPressure.setText(strbloodPressure);
//                    bloodPressureDiastolic.setText(strbloodPressureDiastolic);
//                    cholesterol.setText(stredtcholesterol);
//                    bloodSugarChildOne.setText(strbloodSugarChildOne);
//                    bloodPressureChildOne.setText(strbloodPressureChildOne);
//                    bloodPressureDiastolicChildOne.setText(strbloodPressureDiastolicChildOne);
//                    cholesterolChildOne.setText(strcholesterolChildOne);
//                }
//                else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
//                    bloodSugar.setText(strbloodSugar);
//                    bloodPressure.setText(strbloodPressure);
//                    bloodPressureDiastolic.setText(strbloodPressureDiastolic);
//                    cholesterol.setText(stredtcholesterol);
//                    bloodSugarChildOne.setText(strbloodSugarChildOne);
//                    bloodPressureChildOne.setText(strbloodPressureChildOne);
//                    bloodPressureDiastolicChildOne.setText(strbloodPressureDiastolicChildOne);
//                    cholesterolChildOne.setText(strcholesterolChildOne);
//                    bloodSugarChildTwo.setText(strbloodSugarChildTwo);
//                    bloodPressureChildTwo.setText(strbloodPressureChildTwo);
//                    bloodPressureDiastolicChildTwo.setText(strbloodPressureDiastolicChildTwo);
//                    cholesterolChildTwo.setText(strcholesterolChildTwo);
//                }
//                else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
//                    bloodSugar.setText(strbloodSugar);
//                    bloodPressure.setText(strbloodPressure);
//                    bloodPressureDiastolic.setText(strbloodPressureDiastolic);
//                    cholesterol.setText(stredtcholesterol);
//                    bloodSugarChildOne.setText(strbloodSugarChildOne);
//                    bloodPressureChildOne.setText(strbloodPressureChildOne);
//                    bloodPressureDiastolicChildOne.setText(strbloodPressureDiastolicChildOne);
//                    cholesterolChildOne.setText(strcholesterolChildOne);
//                    bloodSugarChildTwo.setText(strbloodSugarChildTwo);
//                    bloodPressureChildTwo.setText(strbloodPressureChildTwo);
//                    bloodPressureDiastolicChildTwo.setText(strbloodPressureDiastolicChildTwo);
//                    cholesterolChildTwo.setText(strcholesterolChildTwo);
//                    bloodSugarThirdChild.setText(strbloodSugarThirdChild);
//                    bloodPressureThirdChild.setText(strbloodPressureThirdChild);
//                    bloodPressureDiastolicThirdChild.setText(strbloodPressureDiastolicThirdChild);
//                    cholesterolThirdChild.setText(strcholesterolThirdChild);
//                }
//                else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
//                    bloodSugar.setText(strbloodSugar);
//                    bloodPressure.setText(strbloodPressure);
//                    bloodPressureDiastolic.setText(strbloodPressureDiastolic);
//                    cholesterol.setText(stredtcholesterol);
//                    bloodSugarAdultTwo.setText(strbloodSugarAdultTwo);
//                    bloodPressureAdultTwo.setText(strbloodPressureAdultTwo);
//                    bloodPressureDiastolicAdultTwo.setText(strbloodPressureDiastolicAdultTwo);
//                    cholesterolAdultTwo.setText(strcholesterolAdultTwo);
//                    bloodSugarChildOne.setText(strbloodSugarChildOne);
//                    bloodPressureChildOne.setText(strbloodPressureChildOne);
//                    bloodPressureDiastolicChildOne.setText(strbloodPressureDiastolicChildOne);
//                    cholesterolChildOne.setText(strcholesterolChildOne);
//                }
//                else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
//                    bloodSugar.setText(strbloodSugar);
//                    bloodPressure.setText(strbloodPressure);
//                    bloodPressureDiastolic.setText(strbloodPressureDiastolic);
//                    cholesterol.setText(stredtcholesterol);
//                    bloodSugarAdultTwo.setText(strbloodSugarAdultTwo);
//                    bloodPressureAdultTwo.setText(strbloodPressureAdultTwo);
//                    bloodPressureDiastolicAdultTwo.setText(strbloodPressureDiastolicAdultTwo);
//                    cholesterolAdultTwo.setText(strcholesterolAdultTwo);
//                    bloodSugarChildOne.setText(strbloodSugarChildOne);
//                    bloodPressureChildOne.setText(strbloodPressureChildOne);
//                    bloodPressureDiastolicChildOne.setText(strbloodPressureDiastolicChildOne);
//                    cholesterolChildOne.setText(strcholesterolChildOne);
//                    bloodSugarChildTwo.setText(strbloodSugarChildTwo);
//                    bloodPressureChildTwo.setText(strbloodPressureChildTwo);
//                    bloodPressureDiastolicChildTwo.setText(strbloodPressureDiastolicChildTwo);
//                    cholesterolChildTwo.setText(strcholesterolChildTwo);
//                }
//                else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
//                    bloodSugar.setText(strbloodSugar);
//                    bloodPressure.setText(strbloodPressure);
//                    bloodPressureDiastolic.setText(strbloodPressureDiastolic);
//                    cholesterol.setText(stredtcholesterol);
//                    bloodSugarAdultTwo.setText(strbloodSugarAdultTwo);
//                    bloodPressureAdultTwo.setText(strbloodPressureAdultTwo);
//                    bloodPressureDiastolicAdultTwo.setText(strbloodPressureDiastolicAdultTwo);
//                    cholesterolAdultTwo.setText(strcholesterolAdultTwo);
//                    bloodSugarChildOne.setText(strbloodSugarChildOne);
//                    bloodPressureChildOne.setText(strbloodPressureChildOne);
//                    bloodPressureDiastolicChildOne.setText(strbloodPressureDiastolicChildOne);
//                    cholesterolChildOne.setText(strcholesterolChildOne);
//                    bloodSugarChildTwo.setText(strbloodSugarChildTwo);
//                    bloodPressureChildTwo.setText(strbloodPressureChildTwo);
//                    bloodPressureDiastolicChildTwo.setText(strbloodPressureDiastolicChildTwo);
//                    cholesterolChildTwo.setText(strcholesterolChildTwo);
//                    bloodSugarThirdChild.setText(strbloodSugarThirdChild);
//                    bloodPressureThirdChild.setText(strbloodPressureThirdChild);
//                    bloodPressureDiastolicThirdChild.setText(strbloodPressureDiastolicThirdChild);
//                    cholesterolThirdChild.setText(strcholesterolThirdChild);
//                }
//                else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
//                    bloodSugar.setText(strbloodSugar);
//                    bloodPressure.setText(strbloodPressure);
//                    bloodPressureDiastolic.setText(strbloodPressureDiastolic);
//                    cholesterol.setText(stredtcholesterol);
//                    bloodSugarAdultTwo.setText(strbloodSugarAdultTwo);
//                    bloodPressureAdultTwo.setText(strbloodPressureAdultTwo);
//                    bloodPressureDiastolicAdultTwo.setText(strbloodPressureDiastolicAdultTwo);
//                    cholesterolAdultTwo.setText(strcholesterolAdultTwo);
//                    bloodSugarChildOne.setText(strbloodSugarChildOne);
//                    bloodPressureChildOne.setText(strbloodPressureChildOne);
//                    bloodPressureDiastolicChildOne.setText(strbloodPressureDiastolicChildOne);
//                    cholesterolChildOne.setText(strcholesterolChildOne);
//                    bloodSugarChildTwo.setText(strbloodSugarChildTwo);
//                    bloodPressureChildTwo.setText(strbloodPressureChildTwo);
//                    bloodPressureDiastolicChildTwo.setText(strbloodPressureDiastolicChildTwo);
//                    cholesterolChildTwo.setText(strcholesterolChildTwo);
//                    bloodSugarThirdChild.setText(strbloodSugarThirdChild);
//                    bloodPressureThirdChild.setText(strbloodPressureThirdChild);
//                    bloodPressureDiastolicThirdChild.setText(strbloodPressureDiastolicThirdChild);
//                    cholesterolThirdChild.setText(strcholesterolThirdChild);
//                    bloodSugarFourChild.setText(strbloodSugarFourChild);
//                    bloodPressureFourChild.setText(strbloodPressureFourChild);
//                    bloodPressureDiastolicFourChild.setText(strbloodPressureDiastolicFourChild);
//                    cholesterolFourChild.setText(strcholesterolFourChild);
//                }
//            }
//        }




        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(ArogyaMedicalHistory.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.chi_show_breakup);
                EditText basicPremium,criticalEdit,premiumEdit,hospitalEdit,subLimitAmount,gstEdit,totalAmount,tiedHospital;
                Button buttonClose;
                criticalEdit = alert_dialog.findViewById(R.id.criticalEdit);
                premiumEdit = alert_dialog.findViewById(R.id.premiumEdit);
                hospitalEdit = alert_dialog.findViewById(R.id.hospitalEdit);
                basicPremium = alert_dialog.findViewById(R.id.basicPremium);
                subLimitAmount = alert_dialog.findViewById(R.id.subLimitAmount);
                totalAmount = alert_dialog.findViewById(R.id.totalAmount);
                gstEdit = alert_dialog.findViewById(R.id.gstEdit);
                tiedHospital = alert_dialog.findViewById(R.id.tiedHospital);
                buttonClose = alert_dialog.findViewById(R.id.buttonClose);

                basicPremium.setText(NetPremium);
                criticalEdit.setText(strcriticalEdit);
                premiumEdit.setText(str_amountPersonalSumInsured);
                hospitalEdit.setText(strhospitalEdit);
                subLimitAmount.setText(strSubLimitAmount);
                totalAmount.setText(str_TotalValue);
                tiedHospital.setText(strDiscount);
                gstEdit.setText(GST);

                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert_dialog.dismiss();
                    }
                });
                alert_dialog.show();
            }
        });


        YesPreExistingRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPreExistingRadio.isChecked()) {
                    YesPreExistingRadio.setChecked(true);
                    NoPreExistingRadio.setChecked(false);
                    strYesPreExistingRadio = "Yes";
                    IllnessEditSelf.setVisibility(View.VISIBLE);
                }
            }
        });
        NoPreExistingRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPreExistingRadio.isChecked()) {
                    NoPreExistingRadio.setChecked(true);
                    YesPreExistingRadio.setChecked(false);
                    strYesPreExistingRadio = "No";
                    IllnessEditSelf.setVisibility(View.GONE);
                }
            }
        });

        YesMedicalHistoryRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesMedicalHistoryRadio.isChecked()) {
                    YesMedicalHistoryRadio.setChecked(true);
                    NoMedicalHistoryRadio.setChecked(false);
                    strMedicalHistoryRadio = "Yes";
                    MedicalProfessionalEditSelf.setVisibility(View.VISIBLE);
                }
            }
        });
        NoMedicalHistoryRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoMedicalHistoryRadio.isChecked()) {
                    NoMedicalHistoryRadio.setChecked(true);
                    YesMedicalHistoryRadio.setChecked(false);
                    strMedicalHistoryRadio = "No";
                    MedicalProfessionalEditSelf.setVisibility(View.GONE);
                }
            }
        });

        YesMedicineRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesMedicineRadio.isChecked()) {
                    YesMedicineRadio.setChecked(true);
                    NoMedicineRadio.setChecked(false);
                    strMedicineRadio = "Yes";
                    MedicalTreatmentEditSelf.setVisibility(View.VISIBLE);
                }
            }
        });
        NoMedicineRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoMedicineRadio.isChecked()) {
                    NoMedicineRadio.setChecked(true);
                    YesMedicineRadio.setChecked(false);
                    strMedicineRadio = "No";
                    MedicalTreatmentEditSelf.setVisibility(View.GONE);
                }
            }
        });

        YesHospitalizationHistoryRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesHospitalizationHistoryRadio.isChecked()) {
                    YesHospitalizationHistoryRadio.setChecked(true);
                    NoHospitalizationHistoryRadio.setChecked(false);
                    strHospitalizationHistory = "Yes";
                    MedicalHistoryEditSelf.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoHospitalizationHistoryRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoHospitalizationHistoryRadio.isChecked()) {
                    NoHospitalizationHistoryRadio.setChecked(true);
                    YesHospitalizationHistoryRadio.setChecked(false);
                    strHospitalizationHistory = "No";
                    MedicalHistoryEditSelf.setVisibility(View.GONE);
                }
            }
        });

        YesPersonRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPersonRadio.isChecked()) {
                    YesPersonRadio.setChecked(true);
                    NoPersonRadio.setChecked(false);
                    strPersonRadio = "Yes";
                    PersonEditSelf.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoPersonRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPersonRadio.isChecked()) {
                    NoPersonRadio.setChecked(true);
                    YesPersonRadio.setChecked(false);
                    strPersonRadio = "No";
                    PersonEditSelf.setVisibility(View.GONE);
                }
            }
        });

        YesAlcoholRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesAlcoholRadio.isChecked()) {
                    YesAlcoholRadio.setChecked(true);
                    NoAlcoholRadio.setChecked(false);
                    strSelfAlcoholRadio = "Yes";
                    SelfConsumeAlcoholLiner.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoAlcoholRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoAlcoholRadio.isChecked()) {
                    NoAlcoholRadio.setChecked(true);
                    YesAlcoholRadio.setChecked(false);
                    strSelfAlcoholRadio = "No";
                    SelfConsumeAlcoholLiner.setVisibility(View.GONE);
                }
            }
        });

        TypeSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Beer");
                items1.add("Wine");
                items1.add("Whisky");
                items1.add("Rum");
                items1.add("Vodka");
                items1.add("Hard Liquor");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeEditSpinner = items1.get(options1);
                        TypeEditSpinner.setText(strTypeEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        OccasionallySelfDropDownLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("30ml");
                items1.add("60ml");
                items1.add("90ml");
                items1.add("120ml");
                items1.add("500ml");
                items1.add("1L");
                items1.add(">1L");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strOccasionallyEditSpinner = items1.get(options1);
                        OccasionallyEditSpinner.setText(strOccasionallyEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        AlcoholSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strAlcoholEditSpinner = items1.get(options1);
                        AlcoholEditSpinner.setText(strAlcoholEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        AlcoholDurationSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strAlcoholDurationEditSpinner = items1.get(options1);
                        AlcoholDurationEditSpinner.setText(strAlcoholDurationEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });

        YesSmokerRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesSmokerRadio.isChecked()) {
                    YesSmokerRadio.setChecked(true);
                    NoSmokerRadio.setChecked(false);
                    strSmokerRadio = "Yes";
                    SelfSmokerLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoSmokerRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoSmokerRadio.isChecked()) {
                    NoSmokerRadio.setChecked(true);
                    YesSmokerRadio.setChecked(false);
                    strSmokerRadio = "No";
                    SelfSmokerLiner.setVisibility(View.GONE);
                }
            }
        });
        TypeSmokeSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Bidi");
                items1.add("Cigarette");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeSmokeEditSpinner = items1.get(options1);
                        TypeSmokeEditSpinner.setText(strTypeSmokeEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeOccasionallySpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5");
                items1.add("6 to 10");
                items1.add("11 to 20");
                items1.add(">20");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeOccasionallyEditSpinner = items1.get(options1);
                        SmokeOccasionallyEditSpinner.setText(strSmokeOccasionallyEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeDurationSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeDurationEditSpinner = items1.get(options1);
                        SmokeDurationEditSpinner.setText(strSmokeDurationEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeAlcoholSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Monthly");
                items1.add("Weekly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeAlcoholEditSpinner = items1.get(options1);
                        SmokeAlcoholEditSpinner.setText(strSmokeAlcoholEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        
        YesTobaccoRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesTobaccoRadio.isChecked()) {
                    YesTobaccoRadio.setChecked(true);
                    NoTobaccoRadio.setChecked(false);
                    strSelfTobaccoRadio = "Yes";
                    SelfConsumeTobaccoLiner.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoTobaccoRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoTobaccoRadio.isChecked()) {
                    NoTobaccoRadio.setChecked(true);
                    YesTobaccoRadio.setChecked(false);
                    strSelfTobaccoRadio = "No";
                    SelfConsumeTobaccoLiner.setVisibility(View.GONE);
                }
            }
        });
        TobaccoTypeLinerSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Tobacco");
                items1.add("Gutkha");
                items1.add("Pan Masal");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoTypeEditSelf = items1.get(options1);
                        TobaccoTypeEditSelf.setText(strTobaccoTypeEditSelf);
                    }
                });
                singlePicker.show();
            }
        });
        TobaccoLinerSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoEditSelf = items1.get(options1);
                        TobaccoEditSelf.setText(strTobaccoEditSelf);
                    }
                });
                singlePicker.show();
            }
        });
        TobaccoOccasinallyLinerSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5gm");
                items1.add("6 to 10gm");
                items1.add(">10gm");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoOccasinallyEditSelf = items1.get(options1);
                        TobaccoOccasinallyEditSelf.setText(strTobaccoOccasinallyEditSelf);
                    }
                });
                singlePicker.show();
            }
        });
        TobaccoDurationLinerSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoDurationEditSelf = items1.get(options1);
                        TobaccoDurationEditSelf.setText(strTobaccoDurationEditSelf);
                    }
                });
                singlePicker.show();
            }
        });


        YesNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesNarcoticRadio.isChecked()) {
                    YesNarcoticRadio.setChecked(true);
                    NoNarcoticRadio.setChecked(false);
                    strNarcoticRadio = "Yes";
                    SelfNarcoticLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoNarcoticRadio.isChecked()) {
                    NoNarcoticRadio.setChecked(true);
                    YesNarcoticRadio.setChecked(false);
                    strNarcoticRadio = "No";
                    SelfNarcoticLiner.setVisibility(View.GONE);
                }
            }
        });

        //Narcotic
        NarcoticFrequencyLinerSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strNarcoticEditSelf = items1.get(options1);
                        NarcoticEditSelf.setText(strNarcoticEditSelf);
                    }
                });
                singlePicker.show();
            }
        });
        NarcoticDurationLinerSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strNarcoticDurationEditSelf = items1.get(options1);
                        NarcoticDurationEditSelf.setText(strNarcoticDurationEditSelf);
                    }
                });
                singlePicker.show();
            }
        });

        //spouse

        YesRadioSufferingDiseaseSecondAdult.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesRadioSufferingDiseaseSecondAdult.isChecked()) {
                    YesRadioSufferingDiseaseSecondAdult.setChecked(true);
                    NoRadioSufferingDiseaseSecondAdult.setChecked(false);
                    strSufferingDiseaseSecondAdult = "Yes";
                    IllnessEditSpouse.setVisibility(View.VISIBLE);
//                    alertPopup();

                }
            }
        });
        NoRadioSufferingDiseaseSecondAdult.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoRadioSufferingDiseaseSecondAdult.isChecked()) {
                    NoRadioSufferingDiseaseSecondAdult.setChecked(true);
                    YesRadioSufferingDiseaseSecondAdult.setChecked(false);
                    strSufferingDiseaseSecondAdult = "No";
                    IllnessEditSpouse.setVisibility(View.GONE);
                }
            }
        });
        SpouseYesPhysicalRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SpouseYesPhysicalRadio.isChecked()) {
                    SpouseYesPhysicalRadio.setChecked(true);
                    SpouseNoPhysicalRadio.setChecked(false);
                    strSpousePhysicalRadio = "Yes";
                    PhysicalEditSpouse.setVisibility(View.VISIBLE);
//                    alertPopup();

                }
            }
        });
        SpouseNoPhysicalRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SpouseNoPhysicalRadio.isChecked()) {
                    SpouseNoPhysicalRadio.setChecked(true);
                    SpouseYesPhysicalRadio.setChecked(false);
                    strSpousePhysicalRadio = "No";
                    PhysicalEditSpouse.setVisibility(View.GONE);

                }
            }
        });

        YesDiseaseSpouseRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesDiseaseSpouseRadio.isChecked()) {
                    YesDiseaseSpouseRadio.setChecked(true);
                    NoDiseaseSpouseRadio.setChecked(false);
                    strDiseaseSpouseRadio = "Yes";
                    DiseaseEditSpouse.setVisibility(View.VISIBLE);
//                    alertPopup();
//                    SpouseMainDiseaseLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoDiseaseSpouseRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoDiseaseSpouseRadio.isChecked()) {
                    NoDiseaseSpouseRadio.setChecked(true);
                    YesDiseaseSpouseRadio.setChecked(false);
                    strDiseaseSpouseRadio = "No";
                    DiseaseEditSpouse.setVisibility(View.GONE);
//                    SpouseMainDiseaseLiner.setVisibility(View.GONE);

                }
            }
        });

        YesHospitalizationHistoryAdultSecondRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesHospitalizationHistoryAdultSecondRadio.isChecked()) {
                    YesHospitalizationHistoryAdultSecondRadio.setChecked(true);
                    NoHospitalizationHistoryAdultSecondRadio.setChecked(false);
                    strHospitalizationHistoryAdultSecond = "Yes";
                    HospitalizationEditSpouse.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoHospitalizationHistoryAdultSecondRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoHospitalizationHistoryAdultSecondRadio.isChecked()) {
                    NoHospitalizationHistoryAdultSecondRadio.setChecked(true);
                    YesHospitalizationHistoryAdultSecondRadio.setChecked(false);
                    strHospitalizationHistoryAdultSecond = "No";
                    HospitalizationEditSpouse.setVisibility(View.GONE);
                }
            }
        });
        YesPersonSpouseRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPersonSpouseRadio.isChecked()) {
                    YesPersonSpouseRadio.setChecked(true);
                    NoPersonSpouseRadio.setChecked(false);
                    strPersonSpouseRadio = "Yes";
                    PersonEditSpouse.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoPersonSpouseRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPersonSpouseRadio.isChecked()) {
                    NoPersonSpouseRadio.setChecked(true);
                    YesPersonSpouseRadio.setChecked(false);
                    strPersonSpouseRadio = "No";
                    PersonEditSpouse.setVisibility(View.GONE);
                }
            }
        });

        YesSmokerSpouseRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesSmokerSpouseRadio.isChecked()) {
                    YesSmokerSpouseRadio.setChecked(true);
                    NoSmokerSpouseRadio.setChecked(false);
                    strSmokerSpouseRadio = "Yes";
                    SpouseSmokerLiner.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoSmokerSpouseRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoSmokerSpouseRadio.isChecked()) {
                    NoSmokerSpouseRadio.setChecked(true);
                    YesSmokerSpouseRadio.setChecked(false);
                    strSmokerSpouseRadio = "No";
                    SpouseSmokerLiner.setVisibility(View.GONE);
                }
            }
        });

        YesConsumeAlcoholRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesConsumeAlcoholRadio.isChecked()) {
                    YesConsumeAlcoholRadio.setChecked(true);
                    NoConsumeAlcoholRadio.setChecked(false);
                    strConsumeSpouseAlcohol = "Yes";
                    LinerConsumeAlcohol.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoConsumeAlcoholRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoConsumeAlcoholRadio.isChecked()) {
                    NoConsumeAlcoholRadio.setChecked(true);
                    YesConsumeAlcoholRadio.setChecked(false);
                    strConsumeSpouseAlcohol = "No";
                    LinerConsumeAlcohol.setVisibility(View.GONE);

                }
            }
        });

        YesSpouseNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesSpouseNarcoticRadio.isChecked()) {
                    YesSpouseNarcoticRadio.setChecked(true);
                    NoSpouseNarcoticRadio.setChecked(false);
                    strSpouseNarcoticRadio = "Yes";
                    SpouseNarcoticLiner.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoSpouseNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoSpouseNarcoticRadio.isChecked()) {
                    NoSpouseNarcoticRadio.setChecked(true);
                    YesSpouseNarcoticRadio.setChecked(false);
                    strSpouseNarcoticRadio= "No";
                    SpouseNarcoticLiner.setVisibility(View.GONE);

                }
            }
        });

        //AlcoholSpouse
        TypeSpouseSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Beer");
                items1.add("Wine");
                items1.add("Whisky");
                items1.add("Rum");
                items1.add("Vodka");
                items1.add("Hard Liquor");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeSpouseEditSpinner = items1.get(options1);
                        TypeSpouseEditSpinner.setText(strTypeSpouseEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        SpouseDurationSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSpouseDurationEditSpinner = items1.get(options1);
                        SpouseDurationEditSpinner.setText(strSpouseDurationEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        OccasionallySpinnerSpouseLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("30ml");
                items1.add("60ml");
                items1.add("90ml");
                items1.add("120ml");
                items1.add("500ml");
                items1.add("1L");
                items1.add(">1L");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strOccasionallySpouseEditSpinner = items1.get(options1);
                        OccasionallySpouseEditSpinner.setText(strOccasionallySpouseEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        SposeFreQuencyLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSpouseEditFrequency = items1.get(options1);
                        SpouseEditFrequency.setText(strSpouseEditFrequency);
                    }
                });
                singlePicker.show();
            }
        });
        //smokeSpouse
        TypeSpouseSmokeSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Bidi");
                items1.add("Cigarette");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeSpouseSmokeEditSpinner = items1.get(options1);
                        TypeSpouseSmokeEditSpinner.setText(strTypeSpouseSmokeEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeSpouseOccasionallySpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5");
                items1.add("6 to 10");
                items1.add("11 to 20");
                items1.add(">20");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeSpouseOccasionallyEditSpinner = items1.get(options1);
                        SmokeSpouseOccasionallyEditSpinner.setText(strSmokeSpouseOccasionallyEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeSpouseDurationSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeSpouseDurationEditSpinner = items1.get(options1);
                        SmokeSpouseDurationEditSpinner.setText(strSmokeSpouseDurationEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeSpouseAlcoholSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Monthly");
                items1.add("Weekly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeSpouseAlcoholEditSpinner = items1.get(options1);
                        SmokeSpouseAlcoholEditSpinner.setText(strSmokeSpouseAlcoholEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        //TobaccoSpouse
        TobaccoTypeLinerSpouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Tobacco");
                items1.add("Gutkha");
                items1.add("Pan Masal");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoTypeEditSpouse = items1.get(options1);
                        TobaccoTypeEditSpouse.setText(strTobaccoTypeEditSpouse);
                    }
                });
                singlePicker.show();
            }
        });
        TobaccoLinerSpouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoEditSpouse = items1.get(options1);
                        TobaccoEditSpouse.setText(strTobaccoEditSpouse);
                    }
                });
                singlePicker.show();
            }
        });
        TobaccoOccasinallyLinerSpouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5gm");
                items1.add("6 to 10gm");
                items1.add(">10gm");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoOccasinallyEditSpouse = items1.get(options1);
                        TobaccoOccasinallyEditSpouse.setText(strTobaccoOccasinallyEditSpouse);
                    }
                });
                singlePicker.show();
            }
        });
        TobaccoDurationLinerSpouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoDurationEditSpouse = items1.get(options1);
                        TobaccoDurationEditSpouse.setText(strTobaccoDurationEditSpouse);
                    }
                });
                singlePicker.show();
            }
        });
        //NarcoticSpouse
        SpouseNarcoticFrequencyLinerSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strNarcoticEditSpouse = items1.get(options1);
                        NarcoticEditSpouse.setText(strNarcoticEditSpouse);
                    }
                });
                singlePicker.show();
            }
        });
        NarcoticDurationLinerSpouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strNarcoticDurationEditSpouse = items1.get(options1);
                        NarcoticDurationEditSpouse.setText(strNarcoticDurationEditSpouse);
                    }
                });
                singlePicker.show();
            }
        });

        YesSpouseTobaccoRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesSpouseTobaccoRadio.isChecked()) {
                    YesSpouseTobaccoRadio.setChecked(true);
                    NoSpouseTobaccoRadio.setChecked(false);
                    strSpouseTobaccoRadio = "Yes";
                    LinerConsumeTobacco.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoSpouseTobaccoRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoSpouseTobaccoRadio.isChecked()) {
                    NoSpouseTobaccoRadio.setChecked(true);
                    YesSpouseTobaccoRadio.setChecked(false);
                    strSpouseTobaccoRadio = "No";
                    LinerConsumeTobacco.setVisibility(View.GONE);
                }
            }
        });

             //childone

        YesPreExistingChildOneRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPreExistingChildOneRadio.isChecked()) {
                    YesPreExistingChildOneRadio.setChecked(true);
                    NoPreExistingChildOneRadio.setChecked(false);
                    strPreExistingChildOneRadio = "Yes";
                    IllnessEditChildOne.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoPreExistingChildOneRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPreExistingChildOneRadio.isChecked()) {
                    NoPreExistingChildOneRadio.setChecked(true);
                    YesPreExistingChildOneRadio.setChecked(false);
                    strPreExistingChildOneRadio = "No";
                    IllnessEditChildOne.setVisibility(View.GONE);
                }
            }
        });

        YesChildOnePhysicalRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesChildOnePhysicalRadio.isChecked()) {
                    YesChildOnePhysicalRadio.setChecked(true);
                    NoChildOnePhysicalRadio.setChecked(false);
                    strChildOnePhysicalRadio = "Yes";
                    PhysicalEditChildOne.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoChildOnePhysicalRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoChildOnePhysicalRadio.isChecked()) {
                    NoChildOnePhysicalRadio.setChecked(true);
                    YesChildOnePhysicalRadio.setChecked(false);
                    strChildOnePhysicalRadio = "No";
                    PhysicalEditChildOne.setVisibility(View.GONE);
                }
            }
        });

        YesMedicineChildOneRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesMedicineChildOneRadio.isChecked()) {
                    YesMedicineChildOneRadio.setChecked(true);
                    NoMedicineChildOneRadio.setChecked(false);
                    strMedicineChildOneRadio = "Yes";
                    DiseaseEditChildOne.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoMedicineChildOneRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoMedicineChildOneRadio.isChecked()) {
                    NoMedicineChildOneRadio.setChecked(true);
                    YesMedicineChildOneRadio.setChecked(false);
                    strMedicineChildOneRadio = "No";
                    DiseaseEditChildOne.setVisibility(View.GONE);
                }
            }
        });
        YesPersonChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPersonChildRadio.isChecked()) {
                    YesPersonChildRadio.setChecked(true);
                    NoPersonChildRadio.setChecked(false);
                    strPersonChildRadio = "Yes";
                    PersonEditChildOne.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoPersonChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPersonChildRadio.isChecked()) {
                    NoPersonChildRadio.setChecked(true);
                    YesPersonChildRadio.setChecked(false);
                    strPersonChildRadio = "No";
                    PersonEditChildOne.setVisibility(View.GONE);
                }
            }
        });

        YesSmokerChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesSmokerChildRadio.isChecked()) {
                    YesSmokerChildRadio.setChecked(true);
                    NoSmokerChildRadio.setChecked(false);
                    strSmokerChildRadio = "Yes";
                    ChildOneSmokerLiner.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoSmokerChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoSmokerChildRadio.isChecked()) {
                    NoSmokerChildRadio.setChecked(true);
                    YesSmokerChildRadio.setChecked(false);
                    strSmokerChildRadio = "No";
                    ChildOneSmokerLiner.setVisibility(View.GONE);
                }
            }
        });
        YesChildOnePreExistingRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesChildOnePreExistingRadio.isChecked()) {
                    YesChildOnePreExistingRadio.setChecked(true);
                    NoChildOnePreExistingRadio.setChecked(false);
                    strChildOnePreExisting = "Yes";
                    PreExistingEditChildOne.setVisibility(View.VISIBLE);
//                    DiseaseLinerChildOne.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoChildOnePreExistingRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoChildOnePreExistingRadio.isChecked()) {
                    NoChildOnePreExistingRadio.setChecked(true);
                    YesChildOnePreExistingRadio.setChecked(false);
                    strChildOnePreExisting = "No";
                    PreExistingEditChildOne.setVisibility(View.GONE);
//                    DiseaseLinerChildOne.setVisibility(View.GONE);
                }
            }
        });
        YesChildOneConsumeAlcoholRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesChildOneConsumeAlcoholRadio.isChecked()) {
                    YesChildOneConsumeAlcoholRadio.setChecked(true);
                    NoChildOneConsumeAlcoholRadio.setChecked(false);
                    strChildOneConsumeAlcoholRadio = "Yes";
                    ChildOneConsumeAlcoholLiner.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoChildOneConsumeAlcoholRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoChildOneConsumeAlcoholRadio.isChecked()) {
                    NoChildOneConsumeAlcoholRadio.setChecked(true);
                    YesChildOneConsumeAlcoholRadio.setChecked(false);
                    strChildOneConsumeAlcoholRadio = "No";
                    ChildOneConsumeAlcoholLiner.setVisibility(View.GONE);
                }
            }
        });

        YesConsumeTobaccoChildOneRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesConsumeTobaccoChildOneRadio.isChecked()) {
                    YesConsumeTobaccoChildOneRadio.setChecked(true);
                    NoConsumeTobaccoChildOneRadio.setChecked(false);
                    strConsumeTobaccoChildOneRadio = "Yes";
                    ConsumeTabaccoLinerChildOne.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoConsumeTobaccoChildOneRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoConsumeTobaccoChildOneRadio.isChecked()) {
                    NoConsumeTobaccoChildOneRadio.setChecked(true);
                    YesConsumeTobaccoChildOneRadio.setChecked(false);
                    strConsumeTobaccoChildOneRadio = "No";
                    ConsumeTabaccoLinerChildOne.setVisibility(View.GONE);
                }
            }
        });

        YesChildNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesChildNarcoticRadio.isChecked()) {
                    YesChildNarcoticRadio.setChecked(true);
                    NoChildNarcoticRadio.setChecked(false);
                    strChildNarcotic = "Yes";
                    ChildNarcoticLiner.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoChildNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoChildNarcoticRadio.isChecked()) {
                    NoChildNarcoticRadio.setChecked(true);
                    YesChildNarcoticRadio.setChecked(false);
                    strChildNarcotic = "No";
                    ChildNarcoticLiner.setVisibility(View.GONE);
                }
            }
        });

        //AlcoholChild1
        TypeChildOneSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Beer");
                items1.add("Wine");
                items1.add("Whisky");
                items1.add("Rum");
                items1.add("Vodka");
                items1.add("Hard Liquor");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeChildOneEditSpinner = items1.get(options1);
                        TypeChildOneEditSpinner.setText(strTypeChildOneEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        ChildOneDurationSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strChildOneDurationEditSpinner = items1.get(options1);
                        ChildOneDurationEditSpinner.setText(strChildOneDurationEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        OccasionallySpinnerChildOneLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("30ml");
                items1.add("60ml");
                items1.add("90ml");
                items1.add("120ml");
                items1.add("500ml");
                items1.add("1L");
                items1.add(">1L");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strOccasionallyEditChildOneSpinner = items1.get(options1);
                        OccasionallyEditChildOneSpinner.setText(strOccasionallyEditChildOneSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        AlcoholSpinnerLinerChildOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strAlcoholEditSpinnerChildOne = items1.get(options1);
                        AlcoholEditSpinnerChildOne.setText(strAlcoholEditSpinnerChildOne);
                    }
                });
                singlePicker.show();
            }
        });
        //smokeChild1
        TypeChildOneSmokeLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Bidi");
                items1.add("Cigarette");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeChildOneSmokeEdit = items1.get(options1);
                        TypeChildOneSmokeEdit.setText(strTypeChildOneSmokeEdit);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeChildOneOccasionallyLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5");
                items1.add("6 to 10");
                items1.add("11 to 20");
                items1.add(">20");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeChildOneOccasionallyEdit = items1.get(options1);
                        SmokeChildOneOccasionallyEdit.setText(strSmokeChildOneOccasionallyEdit);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeChildOneAlcoholLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Monthly");
                items1.add("Weekly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeChildOneAlcoholEdit = items1.get(options1);
                        SmokeChildOneAlcoholEdit.setText(strSmokeChildOneAlcoholEdit);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeChildOneDurationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeChildOneDurationEdit = items1.get(options1);
                        SmokeChildOneDurationEdit.setText(strSmokeChildOneDurationEdit);
                    }
                });
                singlePicker.show();
            }
        });
        //TobaccoChild1
        TobaccoTypeLinerChildOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Tobacco");
                items1.add("Gutkha");
                items1.add("Pan Masal");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoTypeEditChildOne = items1.get(options1);
                        TobaccoTypeEditChildOne.setText(strTobaccoTypeEditChildOne);
                    }
                });
                singlePicker.show();
            }
        });
        ConsumeTabaccoOccasinallyLinerChildOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strConsumeTabaccoChildOne = items1.get(options1);
                        ConsumeTabaccoChildOne.setText(strConsumeTabaccoChildOne);

                    }
                });
                singlePicker.show();
            }
        });
        ConsumeTabaccoChildOneLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5gm");
                items1.add("6 to 10gm");
                items1.add(">10gm");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strConsumeTabaccoChildOneSpinner = items1.get(options1);
                        ConsumeTabaccoChildOneSpinner.setText(strConsumeTabaccoChildOneSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        TobaccoDurationLinerChildOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoDurationEditChild1 = items1.get(options1);
                        TobaccoDurationEditChild1.setText(strTobaccoDurationEditChild1);
                    }
                });
                singlePicker.show();
            }
        });
        //NarcoticChild1
        ChildNarcoticFrequencyLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strChildNarcoticEdit = items1.get(options1);
                        ChildNarcoticEdit.setText(strChildNarcoticEdit);
                    }
                });
                singlePicker.show();
            }
        });
        ChildNarcoticDurationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strChildNarcoticDurationEdit = items1.get(options1);
                        ChildNarcoticDurationEdit.setText(strChildNarcoticDurationEdit);
                    }
                });
                singlePicker.show();
            }
        });

       //childtwo
        YesChildTwoPreExistingRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesChildTwoPreExistingRadio.isChecked()) {
                    YesChildTwoPreExistingRadio.setChecked(true);
                    NoChildTwoPreExistingRadio.setChecked(false);
                    strChildTwoPreExisting = "Yes";
                    IllnessEditChildTwo.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoChildTwoPreExistingRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoChildTwoPreExistingRadio.isChecked()) {
                    NoChildTwoPreExistingRadio.setChecked(true);
                    YesChildTwoPreExistingRadio.setChecked(false);
                    strChildTwoPreExisting = "No";
                    IllnessEditChildTwo.setVisibility(View.GONE);
                }
            }
        });
        YesChildTwoPhysicalRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesChildTwoPhysicalRadio.isChecked()) {
                    YesChildTwoPhysicalRadio.setChecked(true);
                    NoChildTwoPhysicalRadio.setChecked(false);
                    strChildTwoPhysicalRadio = "Yes";
                    MedicineEditChildTwo.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoChildTwoPhysicalRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoChildTwoPhysicalRadio.isChecked()) {
                    NoChildTwoPhysicalRadio.setChecked(true);
                    YesChildTwoPhysicalRadio.setChecked(false);
                    strChildTwoPhysicalRadio = "No";
                    MedicineEditChildTwo.setVisibility(View.GONE);
                }
            }
        });
        YesChildTwoPreDisease.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesChildTwoPreDisease.isChecked()) {
                    YesChildTwoPreDisease.setChecked(true);
                    NoChildTwoPreDisease.setChecked(false);
                    strChildTwoPreDisease = "Yes";
                    TreatmentEditChildTwo.setVisibility(View.VISIBLE);
//                    alertPopup();
//                    ChildTwoDiseaseLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoChildTwoPreDisease.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoChildTwoPreDisease.isChecked()) {
                    NoChildTwoPreDisease.setChecked(true);
                    YesChildTwoPreDisease.setChecked(false);
                    strChildTwoPreDisease = "No";
//                    ChildTwoDiseaseLiner.setVisibility(View.GONE);
                    TreatmentEditChildTwo.setVisibility(View.GONE);
                }
            }
        });
        YesChildTwoHistoryRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesChildTwoHistoryRadio.isChecked()) {
                    YesChildTwoHistoryRadio.setChecked(true);
                    NoChildTwoHistoryRadio.setChecked(false);
                    strChildTwoHistory = "Yes";
                    HospitalizedEditChildTwo.setVisibility(View.VISIBLE);
//                    alertPopup();
//                    ChildTwoDiseaseLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoChildTwoHistoryRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoChildTwoHistoryRadio.isChecked()) {
                    NoChildTwoHistoryRadio.setChecked(true);
                    YesChildTwoHistoryRadio.setChecked(false);
                    strChildTwoHistory = "No";
                    HospitalizedEditChildTwo.setVisibility(View.GONE);
//                    ChildTwoDiseaseLiner.setVisibility(View.GONE);
                }
            }
        });
        YesPersonChildTwoRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPersonChildTwoRadio.isChecked()) {
                    YesPersonChildTwoRadio.setChecked(true);
                    NoPersonChildTwoRadio.setChecked(false);
                    strPersonChildTwo = "Yes";
                    PersonEditChildTwo.setVisibility(View.VISIBLE);
//                    alertPopup();
//                    ChildTwoDiseaseLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoPersonChildTwoRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPersonChildTwoRadio.isChecked()) {
                    NoPersonChildTwoRadio.setChecked(true);
                    YesPersonChildTwoRadio.setChecked(false);
                    strPersonChildTwo = "No";
                    PersonEditChildTwo.setVisibility(View.GONE);
//                    ChildTwoDiseaseLiner.setVisibility(View.GONE);
                }
            }
        });



        YesSmokerChildTwoRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesSmokerChildTwoRadio.isChecked()) {
                    YesSmokerChildTwoRadio.setChecked(true);
                    NoSmokerChildTwoRadio.setChecked(false);
                    strSmokerChildTwo = "Yes";
//                    alertPopup();
                    LinerSmokeTwoChild.setVisibility(View.VISIBLE);
                }
            }
        });
        NoSmokerChildTwoRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoSmokerChildTwoRadio.isChecked()) {
                    NoSmokerChildTwoRadio.setChecked(true);
                    YesSmokerChildTwoRadio.setChecked(false);
                    strSmokerChildTwo = "No";
                    LinerSmokeTwoChild.setVisibility(View.GONE);
                }
            }
        });

        YesChildTwoAlcoholRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesChildTwoAlcoholRadio.isChecked()) {
                    YesChildTwoAlcoholRadio.setChecked(true);
                    NoChildTwoAlcoholRadio.setChecked(false);
                    strChildTwoAlcoholRadio = "Yes";
//                    alertPopup();
                    AlcoholLinerChildTwo.setVisibility(View.VISIBLE);
                }
            }
        });
        NoChildTwoAlcoholRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoChildTwoAlcoholRadio.isChecked()) {
                    NoChildTwoAlcoholRadio.setChecked(true);
                    YesChildTwoAlcoholRadio.setChecked(false);
                    strChildTwoAlcoholRadio = "No";
                    AlcoholLinerChildTwo.setVisibility(View.GONE);
                }
            }
        });
        YesTobaccoChildTwoRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesTobaccoChildTwoRadio.isChecked()) {
                    YesTobaccoChildTwoRadio.setChecked(true);
                    NoTobaccoChildTwoRadio.setChecked(false);
                    strTobaccoChildTwoRadio = "Yes";
                    LinerTobaccoTwoChild.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoTobaccoChildTwoRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoTobaccoChildTwoRadio.isChecked()) {
                    NoTobaccoChildTwoRadio.setChecked(true);
                    YesTobaccoChildTwoRadio.setChecked(false);
                    strTobaccoChildTwoRadio = "No";
                    LinerTobaccoTwoChild.setVisibility(View.GONE);
                }
            }
        });

        YesChildTwoNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesChildTwoNarcoticRadio.isChecked()) {
                    YesChildTwoNarcoticRadio.setChecked(true);
                    NoChildTwoNarcoticRadio.setChecked(false);
                    strChildTwoNarcotic = "Yes";
                    ChildTwoFourNarcoticLiner.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoChildTwoNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoChildTwoNarcoticRadio.isChecked()) {
                    NoChildTwoNarcoticRadio.setChecked(true);
                    YesChildTwoNarcoticRadio.setChecked(false);
                    strChildTwoNarcotic= "No";
                    ChildTwoFourNarcoticLiner.setVisibility(View.GONE);
                }
            }
        });

        //AlcoholChild2
        TypeTwoChildLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Beer");
                items1.add("Wine");
                items1.add("Whisky");
                items1.add("Rum");
                items1.add("Vodka");
                items1.add("Hard Liquor");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeTwoChildEdit= items1.get(options1);
                        TypeTwoChildEdit.setText(strTypeTwoChildEdit);
                    }
                });
                singlePicker.show();
            }
        });
        DurationTwoChildLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDurationTwoChildEdit= items1.get(options1);
                        DurationTwoChildEdit.setText(strDurationTwoChildEdit);
                    }
                });
                singlePicker.show();
            }
        });
        OccasionallyTwoChildSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("30ml");
                items1.add("60ml");
                items1.add("90ml");
                items1.add("120ml");
                items1.add("500ml");
                items1.add("1L");
                items1.add(">1L");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strOccasionallyTwoChildEditSpinner = items1.get(options1);
                        OccasionallyTwoChildEditSpinner.setText(strOccasionallyTwoChildEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        AlcoholTwoChildSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strAlcoholTwoChildEditSpinner = items1.get(options1);
                        AlcoholTwoChildEditSpinner.setText(strAlcoholTwoChildEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        //smokeChild2
        TypeSmokeTwoChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Bidi");
                items1.add("Cigarette");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeSmokeEditTwoChild = items1.get(options1);
                        TypeSmokeEditTwoChild.setText(strTypeSmokeEditTwoChild);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeOccasinallyTwoChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5");
                items1.add("6 to 10");
                items1.add("11 to 20");
                items1.add(">20");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeOccasinallyEditTwoChild = items1.get(options1);
                        SmokeOccasinallyEditTwoChild.setText(strSmokeOccasinallyEditTwoChild);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeLinerTwoChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Monthly");
                items1.add("Weekly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeEditTwoChild = items1.get(options1);
                        SmokeEditTwoChild.setText(strSmokeEditTwoChild);
                    }
                });
                singlePicker.show();
            }
        });
        DurationSmokeTwoChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDurationSmokeEditTwoChild = items1.get(options1);
                        DurationSmokeEditTwoChild.setText(strDurationSmokeEditTwoChild);
                    }
                });
                singlePicker.show();
            }
        });
        //TobaccoChild2
        TypeTobaccoTwoChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Tobacco");
                items1.add("Gutkha");
                items1.add("Pan Masal");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeTobaccoEditTwoChild= items1.get(options1);
                        TypeTobaccoEditTwoChild.setText(strTypeTobaccoEditTwoChild);
                    }
                });
                singlePicker.show();
            }
        });
        TobaccoLinerTwoChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoEditTwoChild = items1.get(options1);
                        TobaccoEditTwoChild.setText(strTobaccoEditTwoChild);
                    }
                });
                singlePicker.show();
            }
        });
        TobaccoOccasinallyTwoChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5gm");
                items1.add("6 to 10gm");
                items1.add(">10gm");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoOccasinallyEditTwoChild = items1.get(options1);
                        TobaccoOccasinallyEditTwoChild.setText(strTobaccoOccasinallyEditTwoChild);
                    }
                });
                singlePicker.show();
            }
        });
        DurationTobaccoTwoChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDurationTobaccoEditTwoChild= items1.get(options1);
                        DurationTobaccoEditTwoChild.setText(strDurationTobaccoEditTwoChild);
                    }
                });
                singlePicker.show();
            }
        });
        //NarcoticChild2
        ChildTwoNarcoticFrequencyLinerSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strChildTwoNarcoticEditSelf = items1.get(options1);
                        ChildTwoNarcoticEditSelf.setText(strChildTwoNarcoticEditSelf);
                    }
                });
                singlePicker.show();
            }
        });
        ChildTwoNarcoticDurationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strChildTwoNarcoticDurationEdit = items1.get(options1);
                        ChildTwoNarcoticDurationEdit.setText(strChildTwoNarcoticDurationEdit);
                    }
                });
                singlePicker.show();
            }
        });

        YesPreExistingFourChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPreExistingFourChildRadio.isChecked()) {
                    YesPreExistingFourChildRadio.setChecked(true);
                    NoPreExistingFourChildRadio.setChecked(false);
                    strPreExistingFourChild = "Yes";
                    IllnessEditChild4.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoPreExistingFourChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPreExistingFourChildRadio.isChecked()) {
                    NoPreExistingFourChildRadio.setChecked(true);
                    YesPreExistingFourChildRadio.setChecked(false);
                    strPreExistingFourChild = "No";
                    IllnessEditChild4.setVisibility(View.GONE);
                }
            }
        });

        YesPreExistingThirdChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPreExistingThirdChildRadio.isChecked()) {
                    YesPreExistingThirdChildRadio.setChecked(true);
                    NoPreExistingThirdChildRadio.setChecked(false);
                    strPreExistingThirdChild = "Yes";
                    IllnessEditChild3.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoPreExistingThirdChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPreExistingThirdChildRadio.isChecked()) {
                    NoPreExistingThirdChildRadio.setChecked(true);
                    YesPreExistingThirdChildRadio.setChecked(false);
                    strPreExistingThirdChild = "No";
                    IllnessEditChild3.setVisibility(View.GONE);
                }
            }
        });


        YesPhysicalChildThirdRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPhysicalChildThirdRadio.isChecked()) {
                    YesPhysicalChildThirdRadio.setChecked(true);
                    NoPhysicalChildThirdRadio.setChecked(false);
                    strPhysicalChildThirdRadio = "Yes";
                    MedicalEditChild3.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoPhysicalChildThirdRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPhysicalChildThirdRadio.isChecked()) {
                    NoPhysicalChildThirdRadio.setChecked(true);
                    YesPhysicalChildThirdRadio.setChecked(false);
                    strPhysicalChildThirdRadio = "No";
                    MedicalEditChild3.setVisibility(View.GONE);
                }
            }
        });

        YesPersonThirdChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPersonThirdChildRadio.isChecked()) {
                    YesPersonThirdChildRadio.setChecked(true);
                    NoPersonThirdChildRadio.setChecked(false);
                    strPersonChildThird = "Yes";
                    PersonEditChild3.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoPersonThirdChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPersonThirdChildRadio.isChecked()) {
                    NoPersonThirdChildRadio.setChecked(true);
                    YesPersonThirdChildRadio.setChecked(false);
                    strPersonChildThird = "No";
                    PersonEditChild3.setVisibility(View.GONE);
//                    ChildTwoDiseaseLiner.setVisibility(View.GONE);
                }
            }
        });

        NoSmokerChildThirdRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoSmokerChildThirdRadio.isChecked()) {
                    NoSmokerChildThirdRadio.setChecked(true);
                    YesSmokerChildThirdRadio.setChecked(false);
                    strSmokerChildThird = "No";
                    SmokeLinerThird.setVisibility(View.GONE);
                }
            }
        });

        YesSmokerChildThirdRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesSmokerChildThirdRadio.isChecked()) {
                    YesSmokerChildThirdRadio.setChecked(true);
                    NoSmokerChildThirdRadio.setChecked(false);
                    strSmokerChildThird = "Yes";
                    SmokeLinerThird.setVisibility(View.VISIBLE);


//                    alertPopup();
//                    ChildTwoDiseaseLiner.setVisibility(View.VISIBLE);
                }
            }
        });


        YesMedicineThirdChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesMedicineThirdChildRadio.isChecked()) {
                    YesMedicineThirdChildRadio.setChecked(true);
                    NoMedicineThirdChildRadio.setChecked(false);
                    strMedicineThirdChildRadio = "Yes";
                    MedicalTreatmentEditChild3.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoMedicineThirdChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoMedicineThirdChildRadio.isChecked()) {
                    NoMedicineThirdChildRadio.setChecked(true);
                    YesMedicineThirdChildRadio.setChecked(false);
                    strMedicineThirdChildRadio = "No";
                    MedicalTreatmentEditChild3.setVisibility(View.GONE);
                }
            }
        });

        YesDiseaseChildThird.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesDiseaseChildThird.isChecked()) {
                    YesDiseaseChildThird.setChecked(true);
                    NoDiseaseChildThird.setChecked(false);
                    strDiseaseChildThird = "Yes";
                    HospitizationTreatmentEditChild3.setVisibility(View.VISIBLE);
//                    alertPopup();
//                    DiseaseLinerChildThird.setVisibility(View.VISIBLE);
                }
            }
        });

        NoDiseaseChildThird.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoDiseaseChildThird.isChecked()) {
                    NoDiseaseChildThird.setChecked(true);
                    YesDiseaseChildThird.setChecked(false);
                    strDiseaseChildThird = "No";
                    HospitizationTreatmentEditChild3.setVisibility(View.GONE);
//                    DiseaseLinerChildThird.setVisibility(View.GONE);
                }
            }
        });
        YesAlcoholRadioThirdChild.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesAlcoholRadioThirdChild.isChecked()) {
                    YesAlcoholRadioThirdChild.setChecked(true);
                    NoAlcoholRadioThirdChild.setChecked(false);
                    strAlcoholRadioThirdChild = "Yes";
//                    alertPopup();
                    ConsumeAlcoholThirdChildLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoAlcoholRadioThirdChild.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoAlcoholRadioThirdChild.isChecked()) {
                    NoAlcoholRadioThirdChild.setChecked(true);
                    YesAlcoholRadioThirdChild.setChecked(false);
                    strAlcoholRadioThirdChild = "No";
                    ConsumeAlcoholThirdChildLiner.setVisibility(View.GONE);
                }
            }
        });
        YesTobaccoThirdChild.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesTobaccoThirdChild.isChecked()) {
                    YesTobaccoThirdChild.setChecked(true);
                    NoTobaccoThirdChild.setChecked(false);
                    strTobaccoThirdChild = "Yes";
                    ConsumeTobaccoLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoTobaccoThirdChild.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoTobaccoThirdChild.isChecked()) {
                    NoTobaccoThirdChild.setChecked(true);
                    YesTobaccoThirdChild.setChecked(false);
                    strTobaccoThirdChild = "No";
                    ConsumeTobaccoLiner.setVisibility(View.GONE);
                }
            }
        });

        YesChildThirdNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesChildThirdNarcoticRadio.isChecked()) {
                    YesChildThirdNarcoticRadio.setChecked(true);
                    NoChildThirdNarcoticRadio.setChecked(false);
                    strChildThirdNarcotic = "Yes";
                    ChildThirdNarcoticLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoChildThirdNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoChildThirdNarcoticRadio.isChecked()) {
                    NoChildThirdNarcoticRadio.setChecked(true);
                    YesChildThirdNarcoticRadio.setChecked(false);
                    strChildThirdNarcotic = "No";
                    ChildThirdNarcoticLiner.setVisibility(View.GONE);
                }
            }
        });


        //AlcoholChild3
        TypeLinerThirdChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Beer");
                items1.add("Wine");
                items1.add("Whisky");
                items1.add("Rum");
                items1.add("Vodka");
                items1.add("Hard Liquor");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeEditThirdChild= items1.get(options1);
                        TypeEditThirdChild.setText(strTypeEditThirdChild);
                    }
                });
                singlePicker.show();
            }
        });
        DurationLinerThirdChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDurationEditThirdChild= items1.get(options1);
                        DurationEditThirdChild.setText(strDurationEditThirdChild);
                    }
                });
                singlePicker.show();
            }
        });
        OccasionallySpinnerLinerThirdChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("30ml");
                items1.add("60ml");
                items1.add("90ml");
                items1.add("120ml");
                items1.add("500ml");
                items1.add("1L");
                items1.add(">1L");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strOccasionallyEditSpinnerThirdChild = items1.get(options1);
                        OccasionallyEditSpinnerThirdChild.setText(strOccasionallyEditSpinnerThirdChild);
                    }
                });
                singlePicker.show();
            }
        });
        AlcoholSpinnerLinerThirdChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strAlcoholEditSpinnerThirdChild = items1.get(options1);
                        AlcoholEditSpinnerThirdChild.setText(strAlcoholEditSpinnerThirdChild);
                    }
                });
                singlePicker.show();
            }
        });
        //smokeChild3
        TypeSmokeThirdChildLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Bidi");
                items1.add("Cigarette");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeSmokeEditThirdChild = items1.get(options1);
                        TypeSmokeEditThirdChild.setText(strTypeSmokeEditThirdChild);
                    }
                });
                singlePicker.show();
            }
        });
        QuantitySmokeThirdChildLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5");
                items1.add("6 to 10");
                items1.add("11 to 20");
                items1.add(">20");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strQuantitySmokeEditThirdChild = items1.get(options1);
                        QuantitySmokeEditThirdChild.setText(strQuantitySmokeEditThirdChild);
                    }
                });
                singlePicker.show();
            }
        });
        FrequencySmokeThirdChildLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Monthly");
                items1.add("Weekly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strFrequencySmokeEditThirdChild = items1.get(options1);
                        FrequencySmokeEditThirdChild.setText(strFrequencySmokeEditThirdChild);
                    }
                });
                singlePicker.show();
            }
        });
        DurationSmokeThirdChildLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDurationSmokeEditThirdChild= items1.get(options1);
                        DurationSmokeEditThirdChild.setText(strDurationSmokeEditThirdChild);
                    }
                });
                singlePicker.show();
            }
        });
        //TobaccoChild3
        TypeTobaccoThirdChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Tobacco");
                items1.add("Gutkha");
                items1.add("Pan Masal");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeTobaccoEditThirdChild= items1.get(options1);
                        TypeTobaccoEditThirdChild.setText(strTypeTobaccoEditThirdChild);
                    }
                });
                singlePicker.show();
            }
        });
        AlcoholThirdChildSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strAlcoholEditThirdChild = items1.get(options1);
                        AlcoholEditThirdChild.setText(strAlcoholEditThirdChild);
                    }
                });
                singlePicker.show();
            }
        });
        OccasionallyThirdChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5gm");
                items1.add("6 to 10gm");
                items1.add(">10gm");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strOccasionallyEditThirdChild = items1.get(options1);
                        OccasionallyEditThirdChild.setText(strOccasionallyEditThirdChild);
                    }
                });
                singlePicker.show();
            }
        });
        DurationTobaccoThirdChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDurationTobaccoEditThirdChild= items1.get(options1);
                        DurationTobaccoEditThirdChild.setText(strDurationTobaccoEditThirdChild);
                    }
                });
                singlePicker.show();
            }
        });
        //NarcoticChild3
        ChildThirdNarcoticFrequencyLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strChildThirdNarcoticEdit = items1.get(options1);
                        ChildThirdNarcoticEdit.setText(strChildThirdNarcoticEdit);
                    }
                });
                singlePicker.show();
            }
        });
        ChildThirdNarcoticDurationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strChildThirdNarcoticDurationEdit = items1.get(options1);
                        ChildThirdNarcoticDurationEdit.setText(strChildThirdNarcoticDurationEdit);
                    }
                });
                singlePicker.show();
            }
        });


        //child4
      
        YesPhysicalChildFourRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPhysicalChildFourRadio.isChecked()) {
                    YesPhysicalChildFourRadio.setChecked(true);
                    NoPhysicalChildFourRadio.setChecked(false);
                    strPhysicalChildFourRadio = "Yes";
                    MedicalEditChild4.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoPhysicalChildFourRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPhysicalChildFourRadio.isChecked()) {
                    NoPhysicalChildFourRadio.setChecked(true);
                    YesPhysicalChildFourRadio.setChecked(false);
                    strPhysicalChildFourRadio = "No";
                    MedicalEditChild4.setVisibility(View.GONE);
                }
            }
        });
        YesDiseaseChildFourRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesDiseaseChildFourRadio.isChecked()) {
                    YesDiseaseChildFourRadio.setChecked(true);
                    NoDiseaseChildFourRadio.setChecked(false);
                    strDiseaseChildFourRadio = "Yes";
                    MedicalTreatmentEditChild4.setVisibility(View.VISIBLE);
//                    alertPopup();
//                    DiseaseLinerChildFour.setVisibility(View.VISIBLE);
                }
            }
        });
        NoDiseaseChildFourRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoDiseaseChildFourRadio.isChecked()) {
                    NoDiseaseChildFourRadio.setChecked(true);
                    YesDiseaseChildFourRadio.setChecked(false);
                    strDiseaseChildFourRadio = "No";
                    MedicalTreatmentEditChild4.setVisibility(View.GONE);
//                    DiseaseLinerChildFour.setVisibility(View.GONE);
                }
            }
        });


        YesHistoryFourChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesHistoryFourChildRadio.isChecked()) {
                    YesHistoryFourChildRadio.setChecked(true);
                    NoHistoryFourChildRadio.setChecked(false);
                    strHistoryFourChild = "Yes";
                    HospitalizedEditChild4.setVisibility(View.VISIBLE);
//                    alertPopup();
//                    DiseaseLinerChildFour.setVisibility(View.VISIBLE);
                }
            }
        });
        NoHistoryFourChildRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoHistoryFourChildRadio.isChecked()) {
                    NoHistoryFourChildRadio.setChecked(true);
                    YesHistoryFourChildRadio.setChecked(false);
                    strHistoryFourChild = "No";
                    HospitalizedEditChild4.setVisibility(View.GONE);
//                    DiseaseLinerChildFour.setVisibility(View.GONE);
                }
            }
        });

        YesPersonChildFourRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPersonChildFourRadio.isChecked()) {
                    YesPersonChildFourRadio.setChecked(true);
                    NoPersonChildFourRadio.setChecked(false);
                    strPersonChildFourChild = "Yes";
                    PersonEditChild4.setVisibility(View.VISIBLE);
//                    alertPopup();
//                    DiseaseLinerChildFour.setVisibility(View.VISIBLE);
                }
            }
        });
        NoPersonChildFourRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPersonChildFourRadio.isChecked()) {
                    NoPersonChildFourRadio.setChecked(true);
                    YesPersonChildFourRadio.setChecked(false);
                    strPersonChildFourChild = "No";
                    PersonEditChild4.setVisibility(View.GONE);
//                    DiseaseLinerChildFour.setVisibility(View.GONE);
                }
            }
        });
        YesSmokerChildFourRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesSmokerChildFourRadio.isChecked()) {
                    YesSmokerChildFourRadio.setChecked(true);
                    NoSmokerChildFourRadio.setChecked(false);
                    strSmokerChildFourChild = "Yes";
//                    alertPopup();
                    SmokeChildFourLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoSmokerChildFourRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoSmokerChildFourRadio.isChecked()) {
                    NoSmokerChildFourRadio.setChecked(true);
                    YesSmokerChildFourRadio.setChecked(false);
                    strSmokerChildFourChild = "No";
                    SmokeChildFourLiner.setVisibility(View.GONE);
                }
            }
        });

        YesConsumeAlcoholFourChild.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesConsumeAlcoholFourChild.isChecked()) {
                    YesConsumeAlcoholFourChild.setChecked(true);
                    NoConsumeAlcoholFourChild.setChecked(false);
                    strConsumeAlcoholFourChild = "Yes";
//                    alertPopup();
                    ConsumeAlcoholChildFourLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoConsumeAlcoholFourChild.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoConsumeAlcoholFourChild.isChecked()) {
                    NoConsumeAlcoholFourChild.setChecked(true);
                    YesConsumeAlcoholFourChild.setChecked(false);
                    strConsumeAlcoholFourChild = "No";
                    ConsumeAlcoholChildFourLiner.setVisibility(View.GONE);
                }
            }
        });
        YesConsumeTobaccoChildFour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesConsumeTobaccoChildFour.isChecked()) {
                    YesConsumeTobaccoChildFour.setChecked(true);
                    NoConsumeTobaccoChildFour.setChecked(false);
                    strConsumeTobacco = "Yes";
//                    alertPopup();
                    ConsumeTobaccoChildFourLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoConsumeTobaccoChildFour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoConsumeTobaccoChildFour.isChecked()) {
                    NoConsumeTobaccoChildFour.setChecked(true);
                    YesConsumeTobaccoChildFour.setChecked(false);
                    strConsumeTobacco = "No";
                    ConsumeTobaccoChildFourLiner.setVisibility(View.GONE);
                }
            }
        });

        YesChildFourNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesChildFourNarcoticRadio.isChecked()) {
                    YesChildFourNarcoticRadio.setChecked(true);
                    NoChildFourNarcoticRadio.setChecked(false);
                    strChildFourNarcotic= "Yes";
//                    alertPopup();
                    ChildFourNarcoticLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoChildFourNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoChildFourNarcoticRadio.isChecked()) {
                    NoChildFourNarcoticRadio.setChecked(true);
                    YesChildFourNarcoticRadio.setChecked(false);
                    strChildFourNarcotic= "No";
                    ChildFourNarcoticLiner.setVisibility(View.GONE);
                }
            }
        });


        //AlcoholChild4
        TypeAlcoholLinerChild4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Beer");
                items1.add("Wine");
                items1.add("Whisky");
                items1.add("Rum");
                items1.add("Vodka");
                items1.add("Hard Liquor");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeAlcoholEditChild4= items1.get(options1);
                        TypeAlcoholEditChild4.setText(strTypeAlcoholEditChild4);
                    }
                });
                singlePicker.show();
            }
        });
        DurationAlcoholLinerChild4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDurationAlcoholEditChild4= items1.get(options1);
                        DurationAlcoholEditChild4.setText(strDurationAlcoholEditChild4);
                    }
                });
                singlePicker.show();
            }
        });
        OccasionallyLiterLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("30ml");
                items1.add("60ml");
                items1.add("90ml");
                items1.add("120ml");
                items1.add("500ml");
                items1.add("1L");
                items1.add(">1L");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strOccasionallyLiterSpinner = items1.get(options1);
                        OccasionallyLiterSpinner.setText(strOccasionallyLiterSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        AlcoholFrequencyLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoEditFrequency = items1.get(options1);
                        AlcoholEditFrequency.setText(strAlcoholEditFrequency);
                    }
                });
                singlePicker.show();
            }
        });
        //smokeChild4
        SmokeTypeLinerChild4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Bidi");
                items1.add("Cigarette");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeTypeEditChild4 = items1.get(options1);
                        SmokeTypeEditChild4.setText(strSmokeTypeEditChild4);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeQuantityLiterLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5");
                items1.add("6 to 10");
                items1.add("11 to 20");
                items1.add(">20");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeQuantityEdit= items1.get(options1);
                        SmokeQuantityEdit.setText(strSmokeQuantityEdit);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeFrequencyLinerChild4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Monthly");
                items1.add("Weekly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeEditFrequencyChild4 = items1.get(options1);
                        SmokeEditFrequencyChild4.setText(strSmokeEditFrequencyChild4);
                    }
                });
                singlePicker.show();
            }
        });
        DurationSmokeLinerChild4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDurationSmokeEditChild4= items1.get(options1);
                        DurationSmokeEditChild4.setText(strDurationSmokeEditChild4);
                    }
                });
                singlePicker.show();
            }
        });
        //TobaccoChild4
        TypeTobaccoLinerChild4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Tobacco");
                items1.add("Gutkha");
                items1.add("Pan Masal");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeTobaccoEditChild4= items1.get(options1);
                        TypeTobaccoEditChild4.setText(strTypeTobaccoEditChild4);
                    }
                });
                singlePicker.show();
            }
        });
        TobaccoFrequencyLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoEditFrequency = items1.get(options1);
                        TobaccoEditFrequency.setText(strTobaccoEditFrequency);
                    }
                });
                singlePicker.show();
            }
        });
        OccasionallyTobaccoLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5gm");
                items1.add("6 to 10gm");
                items1.add(">10gm");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strOccasionallyTobaccoSpinner = items1.get(options1);
                        OccasionallyTobaccoSpinner.setText(strOccasionallyTobaccoSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        DurationTobaccoLinerChild4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDurationTobaccoEditChild4= items1.get(options1);
                        DurationTobaccoEditChild4.setText(strDurationTobaccoEditChild4);
                    }
                });
                singlePicker.show();
            }
        });
        //NarcoticChild4
        ChildFourNarcoticFrequencyLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strChildFourNarcoticEdit = items1.get(options1);
                        ChildFourNarcoticEdit.setText(strChildFourNarcoticEdit);
                    }
                });
                singlePicker.show();
            }
        });
        ChildFourNarcoticDurationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strChildFourNarcoticDurationEdit = items1.get(options1);
                        ChildFourNarcoticDurationEdit.setText(strChildFourNarcoticDurationEdit);
                    }
                });
                singlePicker.show();
            }
        });

        //mother
       
        YesPreExistingMotherRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPreExistingMotherRadio.isChecked()) {
                    YesPreExistingMotherRadio.setChecked(true);
                    NoPreExistingMotherRadio.setChecked(false);
                    IllnessEditMother.setVisibility(View.VISIBLE);
//                    alertPopup();
                    strPreExistingMother = "Yes";
                }
            }
        });

        NoPreExistingMotherRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPreExistingMotherRadio.isChecked()) {
                    NoPreExistingMotherRadio.setChecked(true);
                    YesPreExistingMotherRadio.setChecked(false);
                    strPreExistingMother = "No";
                    IllnessEditMother.setVisibility(View.GONE);
                }
            }
        });

        YesPersonMotherRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPersonMotherRadio.isChecked()) {
                    YesPersonMotherRadio.setChecked(true);
                    NoPersonMotherRadio.setChecked(false);
                    PersonEditMother.setVisibility(View.VISIBLE);
//                    alertPopup();
                    strPersonMotherRadio = "Yes";
                }
            }
        });

        NoPersonMotherRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPersonMotherRadio.isChecked()) {
                    NoPersonMotherRadio.setChecked(true);
                    YesPersonMotherRadio.setChecked(false);
                    strPersonMotherRadio = "No";
                    PersonEditMother.setVisibility(View.GONE);
                }
            }
        });

        YesSmokerMotherRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesSmokerMotherRadio.isChecked()) {
                    YesSmokerMotherRadio.setChecked(true);
                    NoSmokerMotherRadio.setChecked(false);
//                    alertPopup();
                    strSmokerMotherRadio = "Yes";
                    SmokeLinerMother.setVisibility(View.VISIBLE);
                }
            }
        });

        NoSmokerMotherRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoSmokerMotherRadio.isChecked()) {
                    NoSmokerMotherRadio.setChecked(true);
                    YesSmokerMotherRadio.setChecked(false);
                    strSmokerMotherRadio = "No";
                    SmokeLinerMother.setVisibility(View.GONE);
                }
            }
        });

        YesMotherPhysical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesMotherPhysical.isChecked()) {
                    YesMotherPhysical.setChecked(true);
                    NoMotherPhysical.setChecked(false);
                    strMotherPhysical = "Yes";
                    MedicalHealthEditMother.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoMotherPhysical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoMotherPhysical.isChecked()) {
                    NoMotherPhysical.setChecked(true);
                    YesMotherPhysical.setChecked(false);
                    strMotherPhysical = "No";
                    MedicalHealthEditMother.setVisibility(View.GONE);
                }
            }
        });
        YesDiseaseMother.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesDiseaseMother.isChecked()) {
                    YesDiseaseMother.setChecked(true);
                    NoDiseaseMother.setChecked(false);
                    strDiseaseMother = "Yes";
                    MedicalEditMother.setVisibility(View.VISIBLE);
//                    alertPopup();
//                    MotherDiseaseLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoDiseaseMother.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoDiseaseMother.isChecked()) {
                    NoDiseaseMother.setChecked(true);
                    YesDiseaseMother.setChecked(false);
                    strDiseaseMother = "No";
                    MedicalEditMother.setVisibility(View.GONE);
//                    MotherDiseaseLiner.setVisibility(View.GONE);

                }
            }
        });

        YesMotherHistoryRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesMotherHistoryRadio.isChecked()) {
                    YesMotherHistoryRadio.setChecked(true);
                    NoMotherHistoryRadio.setChecked(false);
                    strMotherHistoryRadio = "Yes";
                    MedicalTreatmentEditMother.setVisibility(View.VISIBLE);
//                    alertPopup();
//                    MotherDiseaseLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoMotherHistoryRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoMotherHistoryRadio.isChecked()) {
                    NoMotherHistoryRadio.setChecked(true);
                    YesMotherHistoryRadio.setChecked(false);
                    strMotherHistoryRadio = "No";
                    MedicalTreatmentEditMother.setVisibility(View.GONE);
//                    MotherDiseaseLiner.setVisibility(View.GONE);

                }
            }
        });

        YesConsumeAlcoholMother.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesConsumeAlcoholMother.isChecked()) {
                    YesConsumeAlcoholMother.setChecked(true);
                    NoConsumeAlcoholMother.setChecked(false);
                    strConsumeAlcoholMother = "Yes";
//                    alertPopup();
                    ConsumeAlcoholLinerMother.setVisibility(View.VISIBLE);

                }
            }
        });
        NoConsumeAlcoholMother.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoConsumeAlcoholMother.isChecked()) {
                    NoConsumeAlcoholMother.setChecked(true);
                    YesConsumeAlcoholMother.setChecked(false);
                    strConsumeAlcoholMother = "No";
                    ConsumeAlcoholLinerMother.setVisibility(View.GONE);

                }
            }
        });



        YesConsumeTobaccoMother.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesConsumeTobaccoMother.isChecked()) {
                    YesConsumeTobaccoMother.setChecked(true);
                    NoConsumeTobaccoMother.setChecked(false);
                    strConsumeTobaccoMother = "Yes";
//                    alertPopup();
                    ConsumeTobaccoLinerMother.setVisibility(View.VISIBLE);
                }
            }
        });
        NoConsumeTobaccoMother.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoConsumeTobaccoMother.isChecked()) {
                    NoConsumeTobaccoMother.setChecked(true);
                    YesConsumeTobaccoMother.setChecked(false);
                    strConsumeTobaccoMother = "No";
                    ConsumeTobaccoLinerMother.setVisibility(View.GONE);
                }
            }
        });

        YesMotherNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesMotherNarcoticRadio.isChecked()) {
                    YesMotherNarcoticRadio.setChecked(true);
                    NoMotherNarcoticRadio.setChecked(false);
                    strMotherNarcotic = "Yes";
//                    alertPopup();
                    MotherNarcoticLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoMotherNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoMotherNarcoticRadio.isChecked()) {
                    NoMotherNarcoticRadio.setChecked(true);
                    YesMotherNarcoticRadio.setChecked(false);
                    strMotherNarcotic = "No";
                    MotherNarcoticLiner.setVisibility(View.GONE);
                }
            }
        });

        //AlcoholMother
        MotherTypeLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Beer");
                items1.add("Wine");
                items1.add("Whisky");
                items1.add("Rum");
                items1.add("Vodka");
                items1.add("Hard Liquor");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherTypeEdit= items1.get(options1);
                        MotherTypeEdit.setText(strMotherTypeEdit);
                    }
                });
                singlePicker.show();
            }
        });
        MotherDurationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherDurationEdit= items1.get(options1);
                        MotherDurationEdit.setText(strMotherDurationEdit);
                    }
                });
                singlePicker.show();
            }
        });
        MotherAlcoholSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherAlcoholEditSpinner = items1.get(options1);
                        MotherAlcoholEditSpinner.setText(strMotherAlcoholEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        MotherOccasionallySpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("30ml");
                items1.add("60ml");
                items1.add("90ml");
                items1.add("120ml");
                items1.add("500ml");
                items1.add("1L");
                items1.add(">1L");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherOccasionallyEditSpinner = items1.get(options1);
                        MotherOccasionallyEditSpinner.setText(strMotherOccasionallyEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        //smokeMother
        MotherTypeSmokeLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Bidi");
                items1.add("Cigarette");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherTypeSmokeEdit = items1.get(options1);
                        MotherTypeSmokeEdit.setText(strMotherTypeSmokeEdit);
                    }
                });
                singlePicker.show();
            }
        });
        MotherOccasionallySmokeLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5");
                items1.add("6 to 10");
                items1.add("11 to 20");
                items1.add(">20");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherOccasionallySmokeEdit= items1.get(options1);
                        MotherOccasionallySmokeEdit.setText(strMotherOccasionallySmokeEdit);
                    }
                });
                singlePicker.show();
            }
        });
        MotherSmokeLinerFrequency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Monthly");
                items1.add("Weekly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherSmokeEditFrequency = items1.get(options1);
                        MotherSmokeEditFrequency.setText(strMotherSmokeEditFrequency);
                    }
                });
                singlePicker.show();
            }
        });
        MotherDurationSmokeLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherDurationSmokeEdit= items1.get(options1);
                        MotherDurationSmokeEdit.setText(strMotherDurationSmokeEdit);
                    }
                });
                singlePicker.show();
            }
        });
        //TobaccoMother
        MotherTypeTobaccoLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Tobacco");
                items1.add("Gutkha");
                items1.add("Pan Masal");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherTypeTobaccoEdit= items1.get(options1);
                        MotherTypeTobaccoEdit.setText(strMotherTypeTobaccoEdit);
                    }
                });
                singlePicker.show();
            }
        });
        MotherTobaccoLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherTobaccoEditSpinner = items1.get(options1);
                        MotherTobaccoEditSpinner.setText(strMotherTobaccoEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        MotherOccasionallyTobaccoLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5gm");
                items1.add("6 to 10gm");
                items1.add(">10gm");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherOccasionallyTobaccoSpinner = items1.get(options1);
                        MotherOccasionallyTobaccoSpinner.setText(strMotherOccasionallyTobaccoSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        MotherDurationTobaccoLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherDurationTobaccoEdit= items1.get(options1);
                        MotherDurationTobaccoEdit.setText(strMotherDurationTobaccoEdit);
                    }
                });
                singlePicker.show();
            }
        });
        //NarcoticMother
        MotherNarcoticFrequencyLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherNarcoticEdit = items1.get(options1);
                        MotherNarcoticEdit.setText(strMotherNarcoticEdit);
                    }
                });
                singlePicker.show();
            }
        });
        MotherNarcoticDurationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherNarcoticDurationEdit = items1.get(options1);
                        MotherNarcoticDurationEdit.setText(strMotherNarcoticDurationEdit);
                    }
                });
                singlePicker.show();
            }
        });


        //father
        YesPreExistingFatherRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPreExistingFatherRadio.isChecked()) {
                    YesPreExistingFatherRadio.setChecked(true);
                    NoPreExistingFatherRadio.setChecked(false);
                    strPreExistingFather = "Yes";
                    IllnessEditFather.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoPreExistingFatherRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPreExistingFatherRadio.isChecked()) {
                    NoPreExistingFatherRadio.setChecked(true);
                    YesPreExistingFatherRadio.setChecked(false);
                    strPreExistingFather = "No";
                    IllnessEditFather.setVisibility(View.GONE);
                }
            }
        });

        YesFatherPhysical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesFatherPhysical.isChecked()) {
                    YesFatherPhysical.setChecked(true);
                    NoFatherPhysical.setChecked(false);
                    strFatherPhysical = "Yes";
                    MedicalEditFather.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoFatherPhysical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoFatherPhysical.isChecked()) {
                    NoFatherPhysical.setChecked(true);
                    YesFatherPhysical.setChecked(false);
                    strFatherPhysical = "No";
                    MedicalEditFather.setVisibility(View.GONE);
                }
            }
        });

        YesFatherHistoryRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesFatherHistoryRadio.isChecked()) {
                    YesFatherHistoryRadio.setChecked(true);
                    NoFatherHistoryRadio.setChecked(false);
                    strFatherHistory = "Yes";
                    TreatmentHistoryEditFather.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoFatherHistoryRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoFatherHistoryRadio.isChecked()) {
                    NoFatherHistoryRadio.setChecked(true);
                    YesFatherHistoryRadio.setChecked(false);
                    strFatherHistory = "No";
                    TreatmentHistoryEditFather.setVisibility(View.GONE);
                }
            }
        });

        YesDiseaseFather.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesDiseaseFather.isChecked()) {
                    YesDiseaseFather.setChecked(true);
                    NoDiseaseFather.setChecked(false);
                    strDiseaseFather = "Yes";
//                    alertPopup();
                    MedicalTreatmentEditFather.setVisibility(View.VISIBLE);
                }
            }
        });
        NoDiseaseFather.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoDiseaseFather.isChecked()) {
                    NoDiseaseFather.setChecked(true);
                    YesDiseaseFather.setChecked(false);
                    strDiseaseFather = "No";
                    MedicalTreatmentEditFather.setVisibility(View.GONE);
                }
            }
        });

        YesPersonFatherRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPersonFatherRadio.isChecked()) {
                    YesPersonFatherRadio.setChecked(true);
                    NoPersonFatherRadio.setChecked(false);
                    strPersonFather = "Yes";
                    PersonEditFather.setVisibility(View.VISIBLE);
//                    alertPopup();
                }
            }
        });
        NoPersonFatherRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPersonFatherRadio.isChecked()) {
                    NoPersonFatherRadio.setChecked(true);
                    YesPersonFatherRadio.setChecked(false);
                    strPersonFather = "No";
                    PersonEditFather.setVisibility(View.GONE);
                }
            }
        });


        YesSmokerFatherRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesSmokerFatherRadio.isChecked()) {
                    YesSmokerFatherRadio.setChecked(true);
                    NoSmokerFatherRadio.setChecked(false);
                    strSmokerFather = "Yes";
                    SmokeFatherLiner.setVisibility(View.VISIBLE);

//                    alertPopup();
                }
            }
        });
        NoSmokerFatherRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoSmokerFatherRadio.isChecked()) {
                    NoSmokerFatherRadio.setChecked(true);
                    YesSmokerFatherRadio.setChecked(false);
                    strSmokerFather = "No";
                    SmokeFatherLiner.setVisibility(View.GONE);
                }
            }
        });


        YesConsumeAlcoholFather.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesConsumeAlcoholFather.isChecked()) {
                    YesConsumeAlcoholFather.setChecked(true);
                    NoConsumeAlcoholFather.setChecked(false);
                    strConsumeAlcoholFather = "Yes";
//                    alertPopup();
                    ConsumeAlcoholFatherLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoConsumeAlcoholFather.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoConsumeAlcoholFather.isChecked()) {
                    NoConsumeAlcoholFather.setChecked(true);
                    YesConsumeAlcoholFather.setChecked(false);
                    strConsumeAlcoholFather = "No";
                    ConsumeAlcoholFatherLiner.setVisibility(View.GONE);
                }
            }
        });

        YesConsumeTobaccoFather.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesConsumeTobaccoFather.isChecked()) {
                    YesConsumeTobaccoFather.setChecked(true);
                    NoConsumeTobaccoFather.setChecked(false);
                    strConsumeTobaccoFather = "Yes";
//                    alertPopup();
                    ConsumeTobaccoFatherLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoConsumeTobaccoFather.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoConsumeTobaccoFather.isChecked()) {
                    NoConsumeTobaccoFather.setChecked(true);
                    YesConsumeTobaccoFather.setChecked(false);
                    strConsumeTobaccoFather = "No";
                    ConsumeTobaccoFatherLiner.setVisibility(View.GONE);
                }
            }
        });


        YesFatherNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesFatherNarcoticRadio.isChecked()) {
                    YesFatherNarcoticRadio.setChecked(true);
                    NoFatherNarcoticRadio.setChecked(false);
                    strFatherNarcotic = "Yes";
//                    alertPopup();
                    FatherNarcoticLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoFatherNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoFatherNarcoticRadio.isChecked()) {
                    NoFatherNarcoticRadio.setChecked(true);
                    YesFatherNarcoticRadio.setChecked(false);
                    strFatherNarcotic = "No";
                    FatherNarcoticLiner.setVisibility(View.GONE);
                }
            }
        });

        //AlcoholFather
        TypeFatherLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Beer");
                items1.add("Wine");
                items1.add("Whisky");
                items1.add("Rum");
                items1.add("Vodka");
                items1.add("Hard Liquor");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeFatherEdit= items1.get(options1);
                        TypeFatherEdit.setText(strTypeFatherEdit);
                    }
                });
                singlePicker.show();
            }
        });
        DurationFatherLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDurationFatherEdit= items1.get(options1);
                        DurationFatherEdit.setText(strDurationFatherEdit);
                    }
                });
                singlePicker.show();
            }
        });
        OccasionallyFatherSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("30ml");
                items1.add("60ml");
                items1.add("90ml");
                items1.add("120ml");
                items1.add("500ml");
                items1.add("1L");
                items1.add(">1L");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strOccasionallyFatherEditSpinner = items1.get(options1);
                        OccasionallyFatherEditSpinner.setText(strOccasionallyFatherEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        AlcoholSpinnerFatherLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strAlcoholEditFatherSpinner = items1.get(options1);
                        AlcoholEditFatherSpinner.setText(strAlcoholEditFatherSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        //smokeFather
        SmokeTypeFatherLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Bidi");
                items1.add("Cigarette");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeTypeFatherEdit = items1.get(options1);
                        SmokeTypeFatherEdit.setText(strSmokeTypeFatherEdit);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeFatherQuantityLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5");
                items1.add("6 to 10");
                items1.add("11 to 20");
                items1.add(">20");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeQuantityFatherEdit= items1.get(options1);
                        SmokeQuantityFatherEdit.setText(strSmokeQuantityFatherEdit);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeFrequencyFatherLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Monthly");
                items1.add("Weekly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeFrequencyFatherEdit= items1.get(options1);
                        SmokeFrequencyFatherEdit.setText(strSmokeFrequencyFatherEdit);
                    }
                });
                singlePicker.show();
            }
        });
        SmokeDurationFatherLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSmokeDurationFatherEdit= items1.get(options1);
                        SmokeDurationFatherEdit.setText(strSmokeDurationFatherEdit);
                    }
                });
                singlePicker.show();
            }
        });
        //TobaccoFather
        TypeFatherTobaccoLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Tobacco");
                items1.add("Gutkha");
                items1.add("Pan Masal");
                items1.add("other");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTypeFatherTobaccoEdit= items1.get(options1);
                        TypeFatherTobaccoEdit.setText(strTypeFatherTobaccoEdit);
                    }
                });
                singlePicker.show();
            }
        });
        TobaccoFatherLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strTobaccoFatherSpinner = items1.get(options1);
                        TobaccoFatherSpinner.setText(strTobaccoFatherSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        OccasionallyFatherTobaccoLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 to 5gm");
                items1.add("6 to 10gm");
                items1.add(">10gm");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strOccasionallyFatherTobaccoSpinner = items1.get(options1);
                        OccasionallyFatherTobaccoSpinner.setText(strOccasionallyFatherTobaccoSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        DurationFatherTobaccoLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDurationFatherTobaccoEdit= items1.get(options1);
                        DurationFatherTobaccoEdit.setText(strDurationFatherTobaccoEdit);
                    }
                });
                singlePicker.show();
            }
        });
        //NarcoticFather
        FatherNarcoticFrequencyLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Weekly");
                items1.add("Monthly");
                items1.add("Daily");
                items1.add("Occasionally");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strFatherNarcoticEdit = items1.get(options1);
                        FatherNarcoticEdit.setText(strFatherNarcoticEdit);
                    }
                });
                singlePicker.show();
            }
        });
        FatherNarcoticDurationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaMedicalHistory.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("<5 years");
                items1.add(">5 years");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strFatherNarcoticDurationEdit = items1.get(options1);
                        FatherNarcoticDurationEdit.setText(strFatherNarcoticDurationEdit);
                    }
                });
                singlePicker.show();
            }
        });


        //MatherLaw
        
        YesMotherLawPhysical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesMotherLawPhysical.isChecked()) {
                    YesMotherLawPhysical.setChecked(true);
                    NoMotherLawPhysical.setChecked(false);
                    strMotherLawPhysical = "Yes";
                }
            }
        });
        NoMotherLawPhysical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoMotherLawPhysical.isChecked()) {
                    NoMotherLawPhysical.setChecked(true);
                    YesMotherLawPhysical.setChecked(false);
                    strMotherLawPhysical = "No";
                }
            }
        });
        YesDiseaseMotherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesDiseaseMotherLaw.isChecked()) {
                    YesDiseaseMotherLaw.setChecked(true);
                    NoDiseaseMotherLaw.setChecked(false);
                    strDiseaseMotherLaw = "Yes";
                    MotherLawDiseaseLiner.setVisibility(View.VISIBLE);

                }
            }
        });
        NoDiseaseMotherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoDiseaseMotherLaw.isChecked()) {
                    NoDiseaseMotherLaw.setChecked(true);
                    YesDiseaseMotherLaw.setChecked(false);
                    strDiseaseMotherLaw = "No";
                    MotherLawDiseaseLiner.setVisibility(View.GONE);
                }
            }
        });
        YesConsumeAlcoholMotherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesConsumeAlcoholMotherLaw.isChecked()) {
                    YesConsumeAlcoholMotherLaw.setChecked(true);
                    NoConsumeAlcoholMotherLaw.setChecked(false);
                    strConsumeAlcoholMotherLaw = "Yes";
                    ConsumeAlcoholMotherLaw.setVisibility(View.VISIBLE);
                }
            }
        });
        NoConsumeAlcoholMotherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoConsumeAlcoholMotherLaw.isChecked()) {
                    NoConsumeAlcoholMotherLaw.setChecked(true);
                    YesConsumeAlcoholMotherLaw.setChecked(false);
                    strConsumeAlcoholMotherLaw = "No";
                    ConsumeAlcoholMotherLaw.setVisibility(View.GONE);
                }
            }
        });
        YesConsumeTobaccoMotherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesConsumeTobaccoMotherLaw.isChecked()) {
                    YesConsumeTobaccoMotherLaw.setChecked(true);
                    NoConsumeTobaccoMotherLaw.setChecked(false);
                    strConsumeTobaccoMotherLaw = "Yes";
                    ConsumeTobaccoMotherLawLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoConsumeTobaccoMotherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoConsumeTobaccoMotherLaw.isChecked()) {
                    NoConsumeTobaccoMotherLaw.setChecked(true);
                    YesConsumeTobaccoMotherLaw.setChecked(false);
                    strConsumeTobaccoMotherLaw = "No";
                    ConsumeTobaccoMotherLawLiner.setVisibility(View.GONE);
                }
            }
        });

        //FatherLaw
      
        YesPhysicalFatherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPhysicalFatherLaw.isChecked()) {
                    YesPhysicalFatherLaw.setChecked(true);
                    NoPhysicalFatherLaw.setChecked(false);
                    strPhysicalFatherLaw = "Yes";
                }
            }
        });
        NoPhysicalFatherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPhysicalFatherLaw.isChecked()) {
                    NoPhysicalFatherLaw.setChecked(true);
                    YesPhysicalFatherLaw.setChecked(false);
                    strPhysicalFatherLaw = "No";
                }
            }
        });
        YesDiseaseFatherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesDiseaseFatherLaw.isChecked()) {
                    YesDiseaseFatherLaw.setChecked(true);
                    NoDiseaseFatherLaw.setChecked(false);
                    strDiseaseFatherLaw = "Yes";
                    DiseaseLinerFatherLaw.setVisibility(View.VISIBLE);
                }
            }
        });
        NoDiseaseFatherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoDiseaseFatherLaw.isChecked()) {
                    NoDiseaseFatherLaw.setChecked(true);
                    YesDiseaseFatherLaw.setChecked(false);
                    strDiseaseFatherLaw = "No";
                    DiseaseLinerFatherLaw.setVisibility(View.GONE);
                }
            }
        });
        YesConsumeAlcoholFatherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesConsumeAlcoholFatherLaw.isChecked()) {
                    YesConsumeAlcoholFatherLaw.setChecked(true);
                    NoConsumeAlcoholFatherLaw.setChecked(false);
                    strConsumeAlcoholFatherLaw = "Yes";
                    ConsumeAlcoholFatherLawLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoConsumeAlcoholFatherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoConsumeAlcoholFatherLaw.isChecked()) {
                    NoConsumeAlcoholFatherLaw.setChecked(true);
                    YesConsumeAlcoholFatherLaw.setChecked(false);
                    strConsumeAlcoholFatherLaw = "No";
                    ConsumeAlcoholFatherLawLiner.setVisibility(View.GONE);
                }
            }
        });
        YesConsumeTobaccoFatherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesConsumeTobaccoFatherLaw.isChecked()) {
                    YesConsumeTobaccoFatherLaw.setChecked(true);
                    NoConsumeTobaccoFatherLaw.setChecked(false);
                    strConsumeTobaccoFatherLaw = "Yes";
                    ConsumeTobaccoFatherLawLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        NoConsumeTobaccoFatherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoConsumeTobaccoFatherLaw.isChecked()) {
                    NoConsumeTobaccoFatherLaw.setChecked(true);
                    YesConsumeTobaccoFatherLaw.setChecked(false);
                    strConsumeTobaccoFatherLaw = "No";
                    ConsumeTobaccoFatherLawLiner.setVisibility(View.GONE);
                }
            }
        });

//        bloodSugar.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // TODO Auto-generated method stub
//            }
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                // TODO Auto-generated method stub
//            }
//            @Override
//            public void afterTextChanged(Editable edt_nm) {
//                strbloodSugar=bloodSugar.getText().toString();
//                if (Integer.parseInt(strbloodSugar) < 70 || Integer.parseInt(strbloodSugar) >99) {
//                    Toast.makeText(ArogyaMedicalHistory.this, "Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                    bloodSugar.setText("");
//                }else {
//                    bloodSugar.setText(strbloodSugar);
//                }
//
//            }
//        });

//        bloodSugar.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void afterTextChanged(Editable s) {}
//            @Override
//            public void beforeTextChanged(CharSequence s, int start,int count, int after) {
//            }
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if(s.length() == 0){
//                    bloodSugar.setText("");
//                }else{
//                  strbloodSugar=bloodSugar.getText().toString();
//                if (Integer.parseInt(strbloodSugar) < 70 || Integer.parseInt(strbloodSugar) >99) {
//                    Toast.makeText(ArogyaMedicalHistory.this, "Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                    bloodSugar.setText("");
//                }else {
//                    bloodSugar.setText(strbloodSugar);
//                }
//                }
//            }
//        });



        bloodPressure.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                // TODO Auto-generated method stub
//                Is_Valid_bloodPressure(bloodPressure); // pass your EditText Obj here.
            }
            public void Is_Valid_bloodPressure(EditText edtbloodPressure) {
                strbloodPressure=edtbloodPressure.getText().toString();
                final int value = Integer.parseInt(strbloodPressure);
                if (Integer.parseInt(strbloodPressure) < 90 || Integer.parseInt(strbloodPressure) >129) {
                    Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
                }else{
                    bloodPressure.setText(strbloodPressure);
                }
            }
        });
        bloodPressureDiastolic.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                // TODO Auto-generated method stub
//                Is_Valid_bloodPressureDiastolic(bloodPressureDiastolic); // pass your EditText Obj here.
            }
            public void Is_Valid_bloodPressureDiastolic(EditText edtbloodPressureDiastolic) {
                strbloodPressureDiastolic=edtbloodPressureDiastolic.getText().toString();
                if (Integer.parseInt(strbloodPressureDiastolic) < 60 || Integer.parseInt(strbloodPressureDiastolic) >79) {
                    Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();

                }else{
                    bloodPressureDiastolic.setText(strbloodPressureDiastolic);
                }
            }
        });
        cholesterol.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                // TODO Auto-generated method stub
//                Is_Valid_cholesterol(cholesterol); // pass your EditText Obj here.
            }
            public void Is_Valid_cholesterol(EditText edtcholesterol) {
                stredtcholesterol=edtcholesterol.getText().toString();
                if (Integer.parseInt(stredtcholesterol) < 150 || Integer.parseInt(stredtcholesterol) >199) {
                    Toast.makeText(ArogyaMedicalHistory.this, "Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();

                }else{
                    cholesterol.setText(stredtcholesterol);
                }
            }
        });


          btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str_policyType_spinner.equals("Individual")) {
                    if (strYesPreExistingRadio.equals("Yes") || strSelfAlcoholRadio.equals("Yes") || strSelfTobaccoRadio.equals("Yes")|| strNarcoticRadio.equals("Yes") || strMedicalHistoryRadio.equals("Yes") || strPersonRadio.equals("Yes")|| strSmokerRadio.equals("Yes")|| strMedicineRadio.equals("Yes") || strHospitalizationHistory.equals("Yes")) {
                        alertPopup();
                    }else {
                        intentNext();
                    }
                }else {
                    if(str_IndividualTypeEdit.equals("2 Adult")){
                        if (strYesPreExistingRadio.equals("Yes") || strSelfAlcoholRadio.equals("Yes") || strSelfTobaccoRadio.equals("Yes") || strNarcoticRadio.equals("Yes")|| strMedicalHistoryRadio.equals("Yes") || strPersonRadio.equals("Yes")|| strSmokerRadio.equals("Yes")|| strMedicineRadio.equals("Yes") || strHospitalizationHistory.equals("Yes")) {
                            alertPopup();
                        }else if (strSufferingDiseaseSecondAdult.equals("Yes") || strSpousePhysicalRadio.equals("Yes") || strDiseaseSpouseRadio.equals("Yes") || strHospitalizationHistoryAdultSecond.equals("Yes")|| strPersonSpouseRadio.equals("Yes") || strSmokerSpouseRadio.equals("Yes")  || strConsumeSpouseAlcohol.equals("Yes")|| strSpouseNarcoticRadio.equals("Yes") || strSpouseTobaccoRadio.equals("Yes")) {
                            alertPopup();
                        }else {
                            parentcheck();
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                        if (strYesPreExistingRadio.equals("Yes") || strSelfAlcoholRadio.equals("Yes") || strSelfTobaccoRadio.equals("Yes") || strNarcoticRadio.equals("Yes")|| strMedicalHistoryRadio.equals("Yes") || strPersonRadio.equals("Yes")|| strSmokerRadio.equals("Yes")|| strMedicineRadio.equals("Yes") || strHospitalizationHistory.equals("Yes")) {
                            alertPopup();
                        }else if (strPreExistingChildOneRadio.equals("Yes") || strChildOnePhysicalRadio.equals("Yes") || strMedicineChildOneRadio.equals("Yes")|| strPersonChildRadio.equals("Yes")|| strSmokerChildRadio.equals("Yes") || strChildOnePreExisting.equals("Yes") || strChildOneConsumeAlcoholRadio.equals("Yes")|| strChildNarcotic.equals("Yes")  || strConsumeTobaccoFather.equals("Yes")|| strFatherNarcotic.equals("Yes")) {
                            alertPopup();
                        }else {
                            parentcheck();
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                        if (strYesPreExistingRadio.equals("Yes") || strSelfAlcoholRadio.equals("Yes") || strSelfTobaccoRadio.equals("Yes") || strNarcoticRadio.equals("Yes")|| strMedicalHistoryRadio.equals("Yes") || strPersonRadio.equals("Yes")|| strSmokerRadio.equals("Yes")|| strMedicineRadio.equals("Yes") || strHospitalizationHistory.equals("Yes")) {
                            alertPopup();
                        }else if (strPreExistingChildOneRadio.equals("Yes") || strChildOnePhysicalRadio.equals("Yes") || strMedicineChildOneRadio.equals("Yes")|| strPersonChildRadio.equals("Yes")|| strSmokerChildRadio.equals("Yes") || strChildOnePreExisting.equals("Yes") || strChildOneConsumeAlcoholRadio.equals("Yes")|| strChildNarcotic.equals("Yes")  || strConsumeTobaccoFather.equals("Yes")|| strFatherNarcotic.equals("Yes")) {
                            alertPopup();
                        }else if (strChildTwoPreExisting.equals("Yes") || strChildTwoPhysicalRadio.equals("Yes") || strChildTwoPreDisease.equals("Yes") || strChildTwoHistory.equals("Yes") || strPersonChildTwo.equals("Yes")|| strSmokerChildTwo.equals("Yes")|| strChildTwoAlcoholRadio.equals("Yes") || strChildTwoNarcotic.equals("Yes")|| strTobaccoChildTwoRadio.equals("Yes")) {
                            alertPopup();
                        }else {
                            parentcheck();
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                        if (strYesPreExistingRadio.equals("Yes") || strSelfAlcoholRadio.equals("Yes") || strSelfTobaccoRadio.equals("Yes") || strNarcoticRadio.equals("Yes")|| strMedicalHistoryRadio.equals("Yes") || strPersonRadio.equals("Yes")|| strSmokerRadio.equals("Yes")|| strMedicineRadio.equals("Yes") || strHospitalizationHistory.equals("Yes")) {
                            alertPopup();
                        }else if (strPreExistingChildOneRadio.equals("Yes") || strChildOnePhysicalRadio.equals("Yes") || strMedicineChildOneRadio.equals("Yes")|| strPersonChildRadio.equals("Yes")|| strSmokerChildRadio.equals("Yes") || strChildOnePreExisting.equals("Yes") || strChildOneConsumeAlcoholRadio.equals("Yes")|| strChildNarcotic.equals("Yes")  || strConsumeTobaccoFather.equals("Yes")|| strFatherNarcotic.equals("Yes")) {
                            alertPopup();
                        }else if (strChildTwoPreExisting.equals("Yes") || strChildTwoPhysicalRadio.equals("Yes") || strChildTwoPreDisease.equals("Yes") || strChildTwoHistory.equals("Yes") || strPersonChildTwo.equals("Yes")|| strSmokerChildTwo.equals("Yes")|| strChildTwoAlcoholRadio.equals("Yes") || strChildTwoNarcotic.equals("Yes")|| strTobaccoChildTwoRadio.equals("Yes")) {
                            alertPopup();
                        }else if (strPreExistingThirdChild.equals("Yes") || strPhysicalChildThirdRadio.equals("Yes")|| strPersonChildThird.equals("Yes")|| strSmokerChildThird.equals("Yes") || strMedicineThirdChildRadio.equals("Yes") || strDiseaseChildThird.equals("Yes") || strAlcoholRadioThirdChild.equals("Yes") || strTobaccoThirdChild.equals("Yes")|| strChildThirdNarcotic.equals("Yes")) {
                            alertPopup();
                        } else {
                            parentcheck();
                        }

                    }
                    else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                        if (strYesPreExistingRadio.equals("Yes") || strSelfAlcoholRadio.equals("Yes") || strSelfTobaccoRadio.equals("Yes") || strNarcoticRadio.equals("Yes")|| strMedicalHistoryRadio.equals("Yes") || strPersonRadio.equals("Yes")|| strSmokerRadio.equals("Yes")|| strMedicineRadio.equals("Yes") || strHospitalizationHistory.equals("Yes")) {
                            alertPopup();
                        }else if (strSufferingDiseaseSecondAdult.equals("Yes") || strSpousePhysicalRadio.equals("Yes") || strDiseaseSpouseRadio.equals("Yes") || strHospitalizationHistoryAdultSecond.equals("Yes")|| strPersonSpouseRadio.equals("Yes") || strSmokerSpouseRadio.equals("Yes")  || strConsumeSpouseAlcohol.equals("Yes")|| strSpouseNarcoticRadio.equals("Yes") || strSpouseTobaccoRadio.equals("Yes")) {
                            alertPopup();
                        }else if (strPreExistingChildOneRadio.equals("Yes") || strChildOnePhysicalRadio.equals("Yes") || strMedicineChildOneRadio.equals("Yes")|| strPersonChildRadio.equals("Yes")|| strSmokerChildRadio.equals("Yes") || strChildOnePreExisting.equals("Yes") || strChildOneConsumeAlcoholRadio.equals("Yes")|| strChildNarcotic.equals("Yes")  || strConsumeTobaccoFather.equals("Yes")|| strFatherNarcotic.equals("Yes")) {
                            alertPopup();
                        } else {
                            parentcheck();
                        }

                    }
                    else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                        if (strYesPreExistingRadio.equals("Yes") || strSelfAlcoholRadio.equals("Yes") || strSelfTobaccoRadio.equals("Yes") || strNarcoticRadio.equals("Yes")|| strMedicalHistoryRadio.equals("Yes") || strPersonRadio.equals("Yes")|| strSmokerRadio.equals("Yes")|| strMedicineRadio.equals("Yes") || strHospitalizationHistory.equals("Yes")) {
                            alertPopup();
                        }else if (strSufferingDiseaseSecondAdult.equals("Yes") || strSpousePhysicalRadio.equals("Yes") || strDiseaseSpouseRadio.equals("Yes") || strHospitalizationHistoryAdultSecond.equals("Yes")|| strPersonSpouseRadio.equals("Yes") || strSmokerSpouseRadio.equals("Yes")  || strConsumeSpouseAlcohol.equals("Yes")|| strSpouseNarcoticRadio.equals("Yes") || strSpouseTobaccoRadio.equals("Yes")) {
                            alertPopup();
                        }else if (strPreExistingChildOneRadio.equals("Yes") || strChildOnePhysicalRadio.equals("Yes") || strMedicineChildOneRadio.equals("Yes")|| strPersonChildRadio.equals("Yes")|| strSmokerChildRadio.equals("Yes") || strChildOnePreExisting.equals("Yes") || strChildOneConsumeAlcoholRadio.equals("Yes")|| strChildNarcotic.equals("Yes")  || strConsumeTobaccoFather.equals("Yes")|| strFatherNarcotic.equals("Yes")) {
                            alertPopup();
                        }else if (strChildTwoPreExisting.equals("Yes") || strChildTwoPhysicalRadio.equals("Yes") || strChildTwoPreDisease.equals("Yes") || strChildTwoHistory.equals("Yes") || strPersonChildTwo.equals("Yes")|| strSmokerChildTwo.equals("Yes")|| strChildTwoAlcoholRadio.equals("Yes") || strChildTwoNarcotic.equals("Yes")|| strTobaccoChildTwoRadio.equals("Yes")) {
                            alertPopup();
                        }else {
                            parentcheck();
                        }

                    }
                    else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                        if (strYesPreExistingRadio.equals("Yes") || strSelfAlcoholRadio.equals("Yes") || strSelfTobaccoRadio.equals("Yes") || strNarcoticRadio.equals("Yes")|| strMedicalHistoryRadio.equals("Yes") || strPersonRadio.equals("Yes")|| strSmokerRadio.equals("Yes")|| strMedicineRadio.equals("Yes") || strHospitalizationHistory.equals("Yes")) {
                            alertPopup();
                        }else if (strSufferingDiseaseSecondAdult.equals("Yes") || strSpousePhysicalRadio.equals("Yes") || strDiseaseSpouseRadio.equals("Yes") || strHospitalizationHistoryAdultSecond.equals("Yes")|| strPersonSpouseRadio.equals("Yes") || strSmokerSpouseRadio.equals("Yes")  || strConsumeSpouseAlcohol.equals("Yes")|| strSpouseNarcoticRadio.equals("Yes") || strSpouseTobaccoRadio.equals("Yes")) {
                            alertPopup();
                        }else if (strPreExistingChildOneRadio.equals("Yes") || strChildOnePhysicalRadio.equals("Yes") || strMedicineChildOneRadio.equals("Yes")|| strPersonChildRadio.equals("Yes")|| strSmokerChildRadio.equals("Yes") || strChildOnePreExisting.equals("Yes") || strChildOneConsumeAlcoholRadio.equals("Yes")|| strChildNarcotic.equals("Yes")  || strConsumeTobaccoFather.equals("Yes")|| strFatherNarcotic.equals("Yes")) {
                            alertPopup();
                        }else if (strChildTwoPreExisting.equals("Yes") || strChildTwoPhysicalRadio.equals("Yes") || strChildTwoPreDisease.equals("Yes") || strChildTwoHistory.equals("Yes") || strPersonChildTwo.equals("Yes")|| strSmokerChildTwo.equals("Yes")|| strChildTwoAlcoholRadio.equals("Yes") || strChildTwoNarcotic.equals("Yes")|| strTobaccoChildTwoRadio.equals("Yes")) {
                            alertPopup();
                        }else if (strPreExistingThirdChild.equals("Yes") || strPhysicalChildThirdRadio.equals("Yes")|| strPersonChildThird.equals("Yes")|| strSmokerChildThird.equals("Yes") || strMedicineThirdChildRadio.equals("Yes") || strDiseaseChildThird.equals("Yes") || strAlcoholRadioThirdChild.equals("Yes") || strTobaccoThirdChild.equals("Yes")|| strChildThirdNarcotic.equals("Yes")) {
                            alertPopup();
                        } else {
                            parentcheck();
                        }

                    }
                    else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                        if (strYesPreExistingRadio.equals("Yes") || strSelfAlcoholRadio.equals("Yes") || strSelfTobaccoRadio.equals("Yes") || strNarcoticRadio.equals("Yes")|| strMedicalHistoryRadio.equals("Yes") || strPersonRadio.equals("Yes")|| strSmokerRadio.equals("Yes")|| strMedicineRadio.equals("Yes") || strHospitalizationHistory.equals("Yes")) {
                            alertPopup();
                        }else if (strSufferingDiseaseSecondAdult.equals("Yes") || strSpousePhysicalRadio.equals("Yes") || strDiseaseSpouseRadio.equals("Yes") || strHospitalizationHistoryAdultSecond.equals("Yes")|| strPersonSpouseRadio.equals("Yes") || strSmokerSpouseRadio.equals("Yes")  || strConsumeSpouseAlcohol.equals("Yes")|| strSpouseNarcoticRadio.equals("Yes") || strSpouseTobaccoRadio.equals("Yes")) {
                            alertPopup();
                        }else if (strPreExistingChildOneRadio.equals("Yes") || strChildOnePhysicalRadio.equals("Yes") || strMedicineChildOneRadio.equals("Yes")|| strPersonChildRadio.equals("Yes")|| strSmokerChildRadio.equals("Yes") || strChildOnePreExisting.equals("Yes") || strChildOneConsumeAlcoholRadio.equals("Yes")|| strChildNarcotic.equals("Yes")  || strConsumeTobaccoFather.equals("Yes")|| strFatherNarcotic.equals("Yes")) {
                            alertPopup();
                        }else if (strChildTwoPreExisting.equals("Yes") || strChildTwoPhysicalRadio.equals("Yes") || strChildTwoPreDisease.equals("Yes") || strChildTwoHistory.equals("Yes") || strPersonChildTwo.equals("Yes")|| strSmokerChildTwo.equals("Yes")|| strChildTwoAlcoholRadio.equals("Yes") || strChildTwoNarcotic.equals("Yes")|| strTobaccoChildTwoRadio.equals("Yes")) {
                            alertPopup();
                        }else if (strPreExistingThirdChild.equals("Yes") || strPhysicalChildThirdRadio.equals("Yes")|| strPersonChildThird.equals("Yes")|| strSmokerChildThird.equals("Yes") || strMedicineThirdChildRadio.equals("Yes") || strDiseaseChildThird.equals("Yes") || strAlcoholRadioThirdChild.equals("Yes") || strTobaccoThirdChild.equals("Yes")|| strChildThirdNarcotic.equals("Yes")) {
                            alertPopup();
                        } else if (strPreExistingFourChild.equals("Yes") || strPhysicalChildFourRadio.equals("Yes") || strDiseaseChildFourRadio.equals("Yes") || strHistoryFourChild.equals("Yes")|| strSmokerChildFourChild.equals("Yes")|| strPersonChildFourChild.equals("Yes") || strConsumeAlcoholFourChild.equals("Yes") || strConsumeTobacco.equals("Yes")|| strChildFourNarcotic.equals("Yes")) {
                            alertPopup();
                        }  else {
                            intentNext();
                        }

                    }

                }

            }
        });


//        btn_continue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (str_policyType_spinner.equals("Individual")) {
//                    strbloodSugar=bloodSugar.getText().toString();
//                    strbloodPressure=bloodPressure.getText().toString();
//                    strbloodPressureDiastolic=bloodPressureDiastolic.getText().toString();
//                    stredtcholesterol=cholesterol.getText().toString();
//                    if (strYesPreExistingRadio.equals("Yes") || strSelfAlcoholRadio.equals("Yes") || strSelfTobaccoRadio.equals("Yes")|| strNarcoticRadio.equals("Yes") || strMedicalHistoryRadio.equals("Yes") || strPersonRadio.equals("Yes")|| strSmokerRadio.equals("Yes")|| strMedicineRadio.equals("Yes") || strHospitalizationHistory.equals("Yes")) {
//                        alertPopup();
//                    }else {
//                        intentNext();
//                    }
//                }else {
//                    if(str_IndividualTypeEdit.equals("2 Adult")){
//                        strbloodSugar=bloodSugar.getText().toString();
//                        strbloodPressure=bloodPressure.getText().toString();
//                        strbloodPressureDiastolic=bloodPressureDiastolic.getText().toString();
//                        stredtcholesterol=cholesterol.getText().toString();
//                        strbloodSugarAdultTwo=bloodSugarAdultTwo.getText().toString();
//                        strbloodPressureAdultTwo=bloodPressureAdultTwo.getText().toString();
//                        strbloodPressureDiastolicAdultTwo=bloodPressureDiastolicAdultTwo.getText().toString();
//                        strcholesterolAdultTwo=cholesterolAdultTwo.getText().toString();
//                        if (strbloodSugar.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugar) < 70 || Integer.parseInt(strbloodSugar) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugar.setText("");
//                        }else if (strbloodPressure.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressure) < 90 || Integer.parseInt(strbloodPressure) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressure.setText("");
//                        }else if (strbloodPressureDiastolic.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolic) < 60 || Integer.parseInt(strbloodPressureDiastolic) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolic.setText("");
//                        }else if (stredtcholesterol.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(stredtcholesterol) < 150 || Integer.parseInt(stredtcholesterol) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterol.setText("");
//                        }else if (strbloodSugarAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarAdultTwo) < 70 || Integer.parseInt(strbloodSugarAdultTwo) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarAdultTwo.setText("");
//                        }else if (strbloodPressureAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureAdultTwo) < 90 || Integer.parseInt(strbloodPressureAdultTwo) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureAdultTwo.setText("");
//                        }else if (strbloodPressureDiastolicAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicAdultTwo) < 60 || Integer.parseInt(strbloodPressureDiastolicAdultTwo) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicAdultTwo.setText("");
//                        }else if (strcholesterolAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolAdultTwo) < 150 || Integer.parseInt(strcholesterolAdultTwo) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolAdultTwo.setText("");
//                        } else if (!checkbox.isChecked()){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Do you have any Pre Existing diseases?", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Intent intent=new Intent(ArogyaMedicalHistory.this, ArogyaPersonalHabbit.class);
//                            intent.putExtra("str_edt_name",str_edt_name);
//                            intent.putExtra("str_edt_phone",str_edt_phone);
//                            intent.putExtra("str_email",str_email);
//                            intent.putExtra("str_age",str_age);
//                            intent.putExtra("str_edit_dob3String",str_edit_dob3String);
//                            intent.putExtra("str_reference_no",str_reference_no);
//                            intent.putExtra("str_edit_dob",str_edit_dob);
//                            intent.putExtra("str_gender",str_gender);
//                            intent.putExtra("str_occupation",str_occupation);
//                            intent.putExtra("str_ft",str_ft);
//                            intent.putExtra("str_inches",str_inches);
//                            intent.putExtra("str_weight_edit",str_weight_edit);
//                            intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                            intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                            intent.putExtra("str_spouse_gender",str_spouse_gender);
//                            intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                            intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                            intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                            intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_OneEditName",str_OneEditName);
//                            intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                            intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                            intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                            intent.putExtra("TotalValue",str_TotalValue);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("strFirstTString",strFirstTString);
//                            intent.putExtra("PosPolicyNo",PosPolicyNo);
//                            intent.putExtra("strChildOne",strChildOne);
//                            intent.putExtra("strChildTwo",strChildTwo);
//                            intent.putExtra("strChildThree",strChildThree);
//                            intent.putExtra("strChildFour",strChildFour);
//                            intent.putExtra("NetPremiumValue",NetPremiumValue);
//                            intent.putExtra("strOneChild",strOneChild);
//                            intent.putExtra("strtwoDob",strtwoDob);
//                            intent.putExtra("strthreeDob",strthreeDob);
//                            intent.putExtra("strfourDob",strfourDob);
//                            intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
//                            intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
//                            intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
//                            intent.putExtra("strFourWeightEdit",strFourWeightEdit);
//                            intent.putExtra("strbloodSugar",strbloodSugar);
//                            intent.putExtra("strbloodPressure",strbloodPressure);
//                            intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
//                            intent.putExtra("stredtcholesterol",stredtcholesterol);
//                            intent.putExtra("strbloodSugarAdultTwo",strbloodSugarAdultTwo);
//                            intent.putExtra("strbloodPressureAdultTwo",strbloodPressureAdultTwo);
//                            intent.putExtra("strbloodPressureDiastolicAdultTwo",strbloodPressureDiastolicAdultTwo);
//                            intent.putExtra("strcholesterolAdultTwo",strcholesterolAdultTwo);
//                            intent.putExtra("GST",GST);
//                            intent.putExtra("str_RelationEdit",str_RelationEdit);
//                            intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
//                            intent.putExtra("strRelationChildEdit",strRelationChildEdit);
//                            intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
//                            intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
//                            intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
//                            intent.putExtra("strAddressLine1",strAddressLine1);
//                            intent.putExtra("strAddressLine2",strAddressLine2);
//                            intent.putExtra("strAddressLine3",strAddressLine3);
//                            intent.putExtra("strpincode",strpincode);
//                            intent.putExtra("strCityName",strCityName);
//                            intent.putExtra("strstateName",strstateName);
//                            intent.putExtra("QuoteId",QuoteId);
//                            intent.putExtra("NetPremium",NetPremium);
//                            intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                            intent.putExtra("strNominee_dob",strNominee_dob);
//                            intent.putExtra("for","0");
//                            startActivity(intent);
//                            finish();
//                        }
//                    }
//                    else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
//                        strbloodSugar=bloodSugar.getText().toString();
//                        strbloodPressure=bloodPressure.getText().toString();
//                        strbloodPressureDiastolic=bloodPressureDiastolic.getText().toString();
//                        stredtcholesterol=cholesterol.getText().toString();
//                        strbloodSugarChildOne=bloodSugarChildOne.getText().toString();
//                        strbloodPressureChildOne=bloodPressureChildOne.getText().toString();
//                        strbloodPressureDiastolicChildOne=bloodPressureDiastolicChildOne.getText().toString();
//                        strcholesterolChildOne=cholesterolChildOne.getText().toString();
//                        if (strbloodSugar.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugar) < 70 || Integer.parseInt(strbloodSugar) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugar.setText("");
//                        }else if (strbloodPressure.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressure) < 90 || Integer.parseInt(strbloodPressure) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressure.setText("");
//                        }else if (strbloodPressureDiastolic.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolic) < 60 || Integer.parseInt(strbloodPressureDiastolic) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolic.setText("");
//                        }else if (stredtcholesterol.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(stredtcholesterol) < 150 || Integer.parseInt(stredtcholesterol) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterol.setText("");
//                        }else if (strbloodSugarChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarChildOne) < 70 || Integer.parseInt(strbloodSugarChildOne) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarChildOne.setText("");
//                        }else if (strbloodPressureChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureChildOne) < 90 || Integer.parseInt(strbloodPressureChildOne) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureChildOne.setText("");
//                        }else if (strbloodPressureDiastolicChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicChildOne) < 60 || Integer.parseInt(strbloodPressureDiastolicChildOne) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicChildOne.setText("");
//                        }else if (strcholesterolChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolChildOne) < 150 || Integer.parseInt(strcholesterolChildOne) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolChildOne.setText("");
//                        } else if (!checkbox.isChecked()){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Do you have any Pre Existing diseases?", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Intent intent=new Intent(ArogyaMedicalHistory.this, ArogyaPersonalHabbit.class);
//                            intent.putExtra("str_edt_name",str_edt_name);
//                            intent.putExtra("str_edt_phone",str_edt_phone);
//                            intent.putExtra("str_email",str_email);
//                            intent.putExtra("str_age",str_age);
//                            intent.putExtra("str_edit_dob3String",str_edit_dob3String);
//                            intent.putExtra("str_reference_no",str_reference_no);
//                            intent.putExtra("str_edit_dob",str_edit_dob);
//                            intent.putExtra("str_gender",str_gender);
//                            intent.putExtra("str_occupation",str_occupation);
//                            intent.putExtra("str_ft",str_ft);
//                            intent.putExtra("str_inches",str_inches);
//                            intent.putExtra("str_weight_edit",str_weight_edit);
//                            intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                            intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                            intent.putExtra("str_spouse_gender",str_spouse_gender);
//                            intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                            intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                            intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                            intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_OneEditName",str_OneEditName);
//                            intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                            intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                            intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                            intent.putExtra("TotalValue",str_TotalValue);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("strFirstTString",strFirstTString);
//                            intent.putExtra("PosPolicyNo",PosPolicyNo);
//                            intent.putExtra("strChildOne",strChildOne);
//                            intent.putExtra("strChildTwo",strChildTwo);
//                            intent.putExtra("strChildThree",strChildThree);
//                            intent.putExtra("strChildFour",strChildFour);
//                            intent.putExtra("NetPremiumValue",NetPremiumValue);
//                            intent.putExtra("strOneChild",strOneChild);
//                            intent.putExtra("strtwoDob",strtwoDob);
//                            intent.putExtra("strthreeDob",strthreeDob);
//                            intent.putExtra("strfourDob",strfourDob);
//                            intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
//                            intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
//                            intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
//                            intent.putExtra("strFourWeightEdit",strFourWeightEdit);
//                            intent.putExtra("strbloodSugar",strbloodSugar);
//                            intent.putExtra("strbloodPressure",strbloodPressure);
//                            intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
//                            intent.putExtra("stredtcholesterol",stredtcholesterol);
//                            intent.putExtra("strbloodSugarChildOne",strbloodSugarChildOne);
//                            intent.putExtra("strbloodPressureChildOne",strbloodPressureChildOne);
//                            intent.putExtra("strbloodPressureDiastolicChildOne",strbloodPressureDiastolicChildOne);
//                            intent.putExtra("strcholesterolChildOne",strcholesterolChildOne);
//                            intent.putExtra("GST",GST);
//                            intent.putExtra("str_RelationEdit",str_RelationEdit);
//                            intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
//                            intent.putExtra("strRelationChildEdit",strRelationChildEdit);
//                            intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
//                            intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
//                            intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
//                            intent.putExtra("strAddressLine1",strAddressLine1);
//                            intent.putExtra("strAddressLine2",strAddressLine2);
//                            intent.putExtra("strAddressLine3",strAddressLine3);
//                            intent.putExtra("strpincode",strpincode);
//                            intent.putExtra("strCityName",strCityName);
//                            intent.putExtra("strstateName",strstateName);
//                            intent.putExtra("QuoteId",QuoteId);
//                            intent.putExtra("NetPremium",NetPremium);
//                            intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                            intent.putExtra("strNominee_dob",strNominee_dob);
//                            intent.putExtra("for","0");
//                            startActivity(intent);
//                            finish();
//                        }
//                    }
//                    else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
//                        strbloodSugar=bloodSugar.getText().toString();
//                        strbloodPressure=bloodPressure.getText().toString();
//                        strbloodPressureDiastolic=bloodPressureDiastolic.getText().toString();
//                        stredtcholesterol=cholesterol.getText().toString();
//                        strbloodSugarChildOne=bloodSugarChildOne.getText().toString();
//                        strbloodPressureChildOne=bloodPressureChildOne.getText().toString();
//                        strbloodPressureDiastolicChildOne=bloodPressureDiastolicChildOne.getText().toString();
//                        strcholesterolChildOne=cholesterolChildOne.getText().toString();
//                        strbloodSugarChildTwo=bloodSugarChildTwo.getText().toString();
//                        strbloodPressureChildTwo=bloodPressureChildTwo.getText().toString();
//                        strbloodPressureDiastolicChildTwo=bloodPressureDiastolicChildTwo.getText().toString();
//                        strcholesterolChildTwo=cholesterolChildTwo.getText().toString();
//
//                        if (strbloodSugar.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugar) < 70 || Integer.parseInt(strbloodSugar) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugar.setText("");
//                        }else if (strbloodPressure.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressure) < 90 || Integer.parseInt(strbloodPressure) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressure.setText("");
//                        }else if (strbloodPressureDiastolic.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolic) < 60 || Integer.parseInt(strbloodPressureDiastolic) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolic.setText("");
//                        }else if (stredtcholesterol.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(stredtcholesterol) < 150 || Integer.parseInt(stredtcholesterol) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterol.setText("");
//                        }else if (strbloodSugarChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarChildOne) < 70 || Integer.parseInt(strbloodSugarChildOne) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarChildOne.setText("");
//                        }else if (strbloodPressureChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureChildOne) < 90 || Integer.parseInt(strbloodPressureChildOne) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureChildOne.setText("");
//                        }else if (strbloodPressureDiastolicChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicChildOne) < 60 || Integer.parseInt(strbloodPressureDiastolicChildOne) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicChildOne.setText("");
//                        }else if (strcholesterolChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolChildOne) < 150 || Integer.parseInt(strcholesterolChildOne) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolChildOne.setText("");
//                        }else if (strbloodSugarChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarChildTwo) < 70 || Integer.parseInt(strbloodSugarChildTwo) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarChildTwo.setText("");
//                        }else if (strbloodPressureChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureChildTwo) < 90 || Integer.parseInt(strbloodPressureChildTwo) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureChildTwo.setText("");
//                        }else if (strbloodPressureDiastolicChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicChildTwo) < 60 || Integer.parseInt(strbloodPressureDiastolicChildTwo) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicChildTwo.setText("");
//                        }else if (strcholesterolChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolChildTwo) < 150 || Integer.parseInt(strcholesterolChildTwo) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolChildTwo.setText("");
//                        } else if (!checkbox.isChecked()){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Do you have any Pre Existing diseases?", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Intent intent=new Intent(ArogyaMedicalHistory.this, ArogyaPersonalHabbit.class);
//                            intent.putExtra("str_edt_name",str_edt_name);
//                            intent.putExtra("str_edt_phone",str_edt_phone);
//                            intent.putExtra("str_email",str_email);
//                            intent.putExtra("str_age",str_age);
//                            intent.putExtra("str_edit_dob3String",str_edit_dob3String);
//                            intent.putExtra("str_reference_no",str_reference_no);
//                            intent.putExtra("str_edit_dob",str_edit_dob);
//                            intent.putExtra("str_gender",str_gender);
//                            intent.putExtra("str_occupation",str_occupation);
//                            intent.putExtra("str_ft",str_ft);
//                            intent.putExtra("str_inches",str_inches);
//                            intent.putExtra("str_weight_edit",str_weight_edit);
//                            intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                            intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                            intent.putExtra("str_spouse_gender",str_spouse_gender);
//                            intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                            intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                            intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                            intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_OneEditName",str_OneEditName);
//                            intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                            intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                            intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                            intent.putExtra("TotalValue",str_TotalValue);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("strFirstTString",strFirstTString);
//                            intent.putExtra("PosPolicyNo",PosPolicyNo);
//                            intent.putExtra("strChildOne",strChildOne);
//                            intent.putExtra("strChildTwo",strChildTwo);
//                            intent.putExtra("strChildThree",strChildThree);
//                            intent.putExtra("strChildFour",strChildFour);
//                            intent.putExtra("NetPremiumValue",NetPremiumValue);
//                            intent.putExtra("strOneChild",strOneChild);
//                            intent.putExtra("strtwoDob",strtwoDob);
//                            intent.putExtra("strthreeDob",strthreeDob);
//                            intent.putExtra("strfourDob",strfourDob);
//                            intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
//                            intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
//                            intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
//                            intent.putExtra("strFourWeightEdit",strFourWeightEdit);
//                            intent.putExtra("strbloodSugar",strbloodSugar);
//                            intent.putExtra("strbloodPressure",strbloodPressure);
//                            intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
//                            intent.putExtra("stredtcholesterol",stredtcholesterol);
//                            intent.putExtra("strbloodSugarChildOne",strbloodSugarChildOne);
//                            intent.putExtra("strbloodPressureChildOne",strbloodPressureChildOne);
//                            intent.putExtra("strbloodPressureDiastolicChildOne",strbloodPressureDiastolicChildOne);
//                            intent.putExtra("strcholesterolChildOne",strcholesterolChildOne);
//                            intent.putExtra("strbloodSugarChildTwo",strbloodSugarChildTwo);
//                            intent.putExtra("strbloodPressureChildTwo",strbloodPressureChildTwo);
//                            intent.putExtra("strbloodPressureDiastolicChildTwo",strbloodPressureDiastolicChildTwo);
//                            intent.putExtra("strcholesterolChildTwo",strcholesterolChildTwo);
//                            intent.putExtra("GST",GST);
//                            intent.putExtra("str_RelationEdit",str_RelationEdit);
//                            intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
//                            intent.putExtra("strRelationChildEdit",strRelationChildEdit);
//                            intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
//                            intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
//                            intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
//                            intent.putExtra("strAddressLine1",strAddressLine1);
//                            intent.putExtra("strAddressLine2",strAddressLine2);
//                            intent.putExtra("strAddressLine3",strAddressLine3);
//                            intent.putExtra("strpincode",strpincode);
//                            intent.putExtra("strCityName",strCityName);
//                            intent.putExtra("strstateName",strstateName);
//                            intent.putExtra("QuoteId",QuoteId);
//                            intent.putExtra("NetPremium",NetPremium);
//                            intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                            intent.putExtra("strNominee_dob",strNominee_dob);
//                            intent.putExtra("for","0");
//                            startActivity(intent);
//                            finish();
//                        }
//                    }
//                    else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
//                        strbloodSugar=bloodSugar.getText().toString();
//                        strbloodPressure=bloodPressure.getText().toString();
//                        strbloodPressureDiastolic=bloodPressureDiastolic.getText().toString();
//                        stredtcholesterol=cholesterol.getText().toString();
//                        strbloodSugarChildOne=bloodSugarChildOne.getText().toString();
//                        strbloodPressureChildOne=bloodPressureChildOne.getText().toString();
//                        strbloodPressureDiastolicChildOne=bloodPressureDiastolicChildOne.getText().toString();
//                        strcholesterolChildOne=cholesterolChildOne.getText().toString();
//                        strbloodSugarChildTwo=bloodSugarChildTwo.getText().toString();
//                        strbloodPressureChildTwo=bloodPressureChildTwo.getText().toString();
//                        strbloodPressureDiastolicChildTwo=bloodPressureDiastolicChildTwo.getText().toString();
//                        strcholesterolChildTwo=cholesterolChildTwo.getText().toString();
//                        strbloodSugarThirdChild=bloodSugarThirdChild.getText().toString();
//                        strbloodPressureThirdChild=bloodPressureThirdChild.getText().toString();
//                        strbloodPressureDiastolicThirdChild=bloodPressureDiastolicThirdChild.getText().toString();
//                        strcholesterolThirdChild=cholesterolThirdChild.getText().toString();
//                        if (strbloodSugar.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugar) < 70 || Integer.parseInt(strbloodSugar) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugar.setText("");
//                        }else if (strbloodPressure.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressure) < 90 || Integer.parseInt(strbloodPressure) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressure.setText("");
//                        }else if (strbloodPressureDiastolic.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolic) < 60 || Integer.parseInt(strbloodPressureDiastolic) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolic.setText("");
//                        }else if (stredtcholesterol.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(stredtcholesterol) < 150 || Integer.parseInt(stredtcholesterol) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterol.setText("");
//                        }else if (strbloodSugarChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarChildOne) < 70 || Integer.parseInt(strbloodSugarChildOne) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarChildOne.setText("");
//                        }else if (strbloodPressureChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureChildOne) < 90 || Integer.parseInt(strbloodPressureChildOne) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureChildOne.setText("");
//                        }else if (strbloodPressureDiastolicChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicChildOne) < 60 || Integer.parseInt(strbloodPressureDiastolicChildOne) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicChildOne.setText("");
//                        }else if (strcholesterolChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolChildOne) < 150 || Integer.parseInt(strcholesterolChildOne) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolChildOne.setText("");
//                        }else if (strbloodSugarChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarChildTwo) < 70 || Integer.parseInt(strbloodSugarChildTwo) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarChildTwo.setText("");
//                        }else if (strbloodPressureChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureChildTwo) < 90 || Integer.parseInt(strbloodPressureChildTwo) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureChildTwo.setText("");
//                        }else if (strbloodPressureDiastolicChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicChildTwo) < 60 || Integer.parseInt(strbloodPressureDiastolicChildTwo) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicChildTwo.setText("");
//                        }else if (strcholesterolChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolChildTwo) < 150 || Integer.parseInt(strcholesterolChildTwo) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolChildTwo.setText("");
//                        } else if (strbloodSugarThirdChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 3rd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarThirdChild) < 70 || Integer.parseInt(strbloodSugarThirdChild) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "3rd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarThirdChild.setText("");
//                        }else if (strbloodPressureThirdChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 3rd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureThirdChild) < 90 || Integer.parseInt(strbloodPressureThirdChild) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "3rd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureThirdChild.setText("");
//                        }else if (strbloodPressureDiastolicThirdChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 3rd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicThirdChild) < 60 || Integer.parseInt(strbloodPressureDiastolicThirdChild) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "3rd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicThirdChild.setText("");
//                        }else if (strcholesterolThirdChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 3rd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolThirdChild) < 150 || Integer.parseInt(strcholesterolThirdChild) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "3rd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolThirdChild.setText("");
//                        }else if (!checkbox.isChecked()){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Do you have any Pre Existing diseases?", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Intent intent=new Intent(ArogyaMedicalHistory.this, ArogyaPersonalHabbit.class);
//                            intent.putExtra("str_edt_name",str_edt_name);
//                            intent.putExtra("str_edt_phone",str_edt_phone);
//                            intent.putExtra("str_email",str_email);
//                            intent.putExtra("str_age",str_age);
//                            intent.putExtra("str_edit_dob3String",str_edit_dob3String);
//                            intent.putExtra("str_reference_no",str_reference_no);
//                            intent.putExtra("str_edit_dob",str_edit_dob);
//                            intent.putExtra("str_gender",str_gender);
//                            intent.putExtra("str_occupation",str_occupation);
//                            intent.putExtra("str_ft",str_ft);
//                            intent.putExtra("str_inches",str_inches);
//                            intent.putExtra("str_weight_edit",str_weight_edit);
//                            intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                            intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                            intent.putExtra("str_spouse_gender",str_spouse_gender);
//                            intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                            intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                            intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                            intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_OneEditName",str_OneEditName);
//                            intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                            intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                            intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                            intent.putExtra("TotalValue",str_TotalValue);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("strFirstTString",strFirstTString);
//                            intent.putExtra("PosPolicyNo",PosPolicyNo);
//                            intent.putExtra("strChildOne",strChildOne);
//                            intent.putExtra("strChildTwo",strChildTwo);
//                            intent.putExtra("strChildThree",strChildThree);
//                            intent.putExtra("strChildFour",strChildFour);
//                            intent.putExtra("NetPremiumValue",NetPremiumValue);
//                            intent.putExtra("strOneChild",strOneChild);
//                            intent.putExtra("strtwoDob",strtwoDob);
//                            intent.putExtra("strthreeDob",strthreeDob);
//                            intent.putExtra("strfourDob",strfourDob);
//                            intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
//                            intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
//                            intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
//                            intent.putExtra("strFourWeightEdit",strFourWeightEdit);
//                            intent.putExtra("strbloodSugar",strbloodSugar);
//                            intent.putExtra("strbloodPressure",strbloodPressure);
//                            intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
//                            intent.putExtra("stredtcholesterol",stredtcholesterol);
//                            intent.putExtra("strbloodSugarChildOne",strbloodSugarChildOne);
//                            intent.putExtra("strbloodPressureChildOne",strbloodPressureChildOne);
//                            intent.putExtra("strbloodPressureDiastolicChildOne",strbloodPressureDiastolicChildOne);
//                            intent.putExtra("strcholesterolChildOne",strcholesterolChildOne);
//                            intent.putExtra("strbloodSugarChildTwo",strbloodSugarChildTwo);
//                            intent.putExtra("strbloodPressureChildTwo",strbloodPressureChildTwo);
//                            intent.putExtra("strbloodPressureDiastolicChildTwo",strbloodPressureDiastolicChildTwo);
//                            intent.putExtra("strcholesterolChildTwo",strcholesterolChildTwo);
//                            intent.putExtra("strbloodSugarThirdChild",strbloodSugarThirdChild);
//                            intent.putExtra("strbloodPressureThirdChild",strbloodPressureThirdChild);
//                            intent.putExtra("strbloodPressureDiastolicThirdChild",strbloodPressureDiastolicThirdChild);
//                            intent.putExtra("strcholesterolThirdChild",strcholesterolThirdChild);
//                            intent.putExtra("GST",GST);
//                            intent.putExtra("str_RelationEdit",str_RelationEdit);
//                            intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
//                            intent.putExtra("strRelationChildEdit",strRelationChildEdit);
//                            intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
//                            intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
//                            intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
//                            intent.putExtra("strAddressLine1",strAddressLine1);
//                            intent.putExtra("strAddressLine2",strAddressLine2);
//                            intent.putExtra("strAddressLine3",strAddressLine3);
//                            intent.putExtra("strpincode",strpincode);
//                            intent.putExtra("strCityName",strCityName);
//                            intent.putExtra("strstateName",strstateName);
//                            intent.putExtra("QuoteId",QuoteId);
//                            intent.putExtra("NetPremium",NetPremium);
//                            intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                            intent.putExtra("strNominee_dob",strNominee_dob);
//                            intent.putExtra("for","0");
//                            startActivity(intent);
//                            finish();
//                        }
//
//                    }
//                    else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
//                        strbloodSugar=bloodSugar.getText().toString();
//                        strbloodPressure=bloodPressure.getText().toString();
//                        strbloodPressureDiastolic=bloodPressureDiastolic.getText().toString();
//                        stredtcholesterol=cholesterol.getText().toString();
//                        strbloodSugarAdultTwo=bloodSugarAdultTwo.getText().toString();
//                        strbloodPressureAdultTwo=bloodPressureAdultTwo.getText().toString();
//                        strbloodPressureDiastolicAdultTwo=bloodPressureDiastolicAdultTwo.getText().toString();
//                        strcholesterolAdultTwo=cholesterolAdultTwo.getText().toString();
//                        strbloodSugarChildOne=bloodSugarChildOne.getText().toString();
//                        strbloodPressureChildOne=bloodPressureChildOne.getText().toString();
//                        strbloodPressureDiastolicChildOne=bloodPressureDiastolicChildOne.getText().toString();
//                        strcholesterolChildOne=cholesterolChildOne.getText().toString();
//                        if (strbloodSugar.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugar) < 70 || Integer.parseInt(strbloodSugar) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugar.setText("");
//                        }else if (strbloodPressure.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressure) < 90 || Integer.parseInt(strbloodPressure) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressure.setText("");
//                        }else if (strbloodPressureDiastolic.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolic) < 60 || Integer.parseInt(strbloodPressureDiastolic) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolic.setText("");
//                        }else if (stredtcholesterol.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(stredtcholesterol) < 150 || Integer.parseInt(stredtcholesterol) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterol.setText("");
//                        }else if (strbloodSugarAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarAdultTwo) < 70 || Integer.parseInt(strbloodSugarAdultTwo) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarAdultTwo.setText("");
//                        }else if (strbloodPressureAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureAdultTwo) < 90 || Integer.parseInt(strbloodPressureAdultTwo) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureAdultTwo.setText("");
//                        }else if (strbloodPressureDiastolicAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicAdultTwo) < 60 || Integer.parseInt(strbloodPressureDiastolicAdultTwo) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicAdultTwo.setText("");
//                        }else if (strcholesterolAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolAdultTwo) < 150 || Integer.parseInt(strcholesterolAdultTwo) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolAdultTwo.setText("");
//                        }else if (strbloodSugarChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarChildOne) < 70 || Integer.parseInt(strbloodSugarChildOne) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarChildOne.setText("");
//                        }else if (strbloodPressureChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureChildOne) < 90 || Integer.parseInt(strbloodPressureChildOne) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureChildOne.setText("");
//                        }else if (strbloodPressureDiastolicChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicChildOne) < 60 || Integer.parseInt(strbloodPressureDiastolicChildOne) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicChildOne.setText("");
//                        }else if (strcholesterolChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolChildOne) < 150 || Integer.parseInt(strcholesterolChildOne) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolChildOne.setText("");
//                        }else if (!checkbox.isChecked()){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Do you have any Pre Existing diseases?", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Intent intent=new Intent(ArogyaMedicalHistory.this, ArogyaPersonalHabbit.class);
//                            intent.putExtra("str_edt_name",str_edt_name);
//                            intent.putExtra("str_edt_phone",str_edt_phone);
//                            intent.putExtra("str_email",str_email);
//                            intent.putExtra("str_age",str_age);
//                            intent.putExtra("str_edit_dob3String",str_edit_dob3String);
//                            intent.putExtra("str_reference_no",str_reference_no);
//                            intent.putExtra("str_edit_dob",str_edit_dob);
//                            intent.putExtra("str_gender",str_gender);
//                            intent.putExtra("str_occupation",str_occupation);
//                            intent.putExtra("str_ft",str_ft);
//                            intent.putExtra("str_inches",str_inches);
//                            intent.putExtra("str_weight_edit",str_weight_edit);
//                            intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                            intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                            intent.putExtra("str_spouse_gender",str_spouse_gender);
//                            intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                            intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                            intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                            intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_OneEditName",str_OneEditName);
//                            intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                            intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                            intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                            intent.putExtra("TotalValue",str_TotalValue);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("strFirstTString",strFirstTString);
//                            intent.putExtra("PosPolicyNo",PosPolicyNo);
//                            intent.putExtra("strChildOne",strChildOne);
//                            intent.putExtra("strChildTwo",strChildTwo);
//                            intent.putExtra("strChildThree",strChildThree);
//                            intent.putExtra("strChildFour",strChildFour);
//                            intent.putExtra("NetPremiumValue",NetPremiumValue);
//                            intent.putExtra("strOneChild",strOneChild);
//                            intent.putExtra("strtwoDob",strtwoDob);
//                            intent.putExtra("strthreeDob",strthreeDob);
//                            intent.putExtra("strfourDob",strfourDob);
//                            intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
//                            intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
//                            intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
//                            intent.putExtra("strFourWeightEdit",strFourWeightEdit);
//                            intent.putExtra("strbloodSugar",strbloodSugar);
//                            intent.putExtra("strbloodPressure",strbloodPressure);
//                            intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
//                            intent.putExtra("stredtcholesterol",stredtcholesterol);
//                            intent.putExtra("strbloodSugarAdultTwo",strbloodSugarAdultTwo);
//                            intent.putExtra("strbloodPressureAdultTwo",strbloodPressureAdultTwo);
//                            intent.putExtra("strbloodPressureDiastolicAdultTwo",strbloodPressureDiastolicAdultTwo);
//                            intent.putExtra("strcholesterolAdultTwo",strcholesterolAdultTwo);
//                            intent.putExtra("strbloodSugarChildOne",strbloodSugarChildOne);
//                            intent.putExtra("strbloodPressureChildOne",strbloodPressureChildOne);
//                            intent.putExtra("strbloodPressureDiastolicChildOne",strbloodPressureDiastolicChildOne);
//                            intent.putExtra("strcholesterolChildOne",strcholesterolChildOne);
//                            intent.putExtra("strbloodSugarAdultTwo",strbloodSugarAdultTwo);
//                            intent.putExtra("strbloodPressureAdultTwo",strbloodPressureAdultTwo);
//                            intent.putExtra("strbloodPressureDiastolicAdultTwo",strbloodPressureDiastolicAdultTwo);
//                            intent.putExtra("strcholesterolAdultTwo",strcholesterolAdultTwo);
//                            intent.putExtra("strbloodSugarChildTwo",strbloodSugarChildTwo);
//                            intent.putExtra("strbloodPressureChildTwo",strbloodPressureChildTwo);
//                            intent.putExtra("strbloodPressureDiastolicChildTwo",strbloodPressureDiastolicChildTwo);
//                            intent.putExtra("strcholesterolChildTwo",strcholesterolChildTwo);
//                            intent.putExtra("strbloodSugarThirdChild",strbloodSugarThirdChild);
//                            intent.putExtra("strbloodPressureThirdChild",strbloodPressureThirdChild);
//                            intent.putExtra("strbloodPressureDiastolicThirdChild",strbloodPressureDiastolicThirdChild);
//                            intent.putExtra("strcholesterolThirdChild",strcholesterolThirdChild);
//                            intent.putExtra("GST",GST);
//                            intent.putExtra("str_RelationEdit",str_RelationEdit);
//                            intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
//                            intent.putExtra("strRelationChildEdit",strRelationChildEdit);
//                            intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
//                            intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
//                            intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
//                            intent.putExtra("strAddressLine1",strAddressLine1);
//                            intent.putExtra("strAddressLine2",strAddressLine2);
//                            intent.putExtra("strAddressLine3",strAddressLine3);
//                            intent.putExtra("strpincode",strpincode);
//                            intent.putExtra("strCityName",strCityName);
//                            intent.putExtra("strstateName",strstateName);
//                            intent.putExtra("QuoteId",QuoteId);
//                            intent.putExtra("NetPremium",NetPremium);
//                            intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                            intent.putExtra("strNominee_dob",strNominee_dob);
//                            intent.putExtra("for","0");
//                            startActivity(intent);
//                            finish();
//                        }
//
//                    }
//                    else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
//                        strbloodSugar=bloodSugar.getText().toString();
//                        strbloodPressure=bloodPressure.getText().toString();
//                        strbloodPressureDiastolic=bloodPressureDiastolic.getText().toString();
//                        stredtcholesterol=cholesterol.getText().toString();
//                        strbloodSugarAdultTwo=bloodSugarAdultTwo.getText().toString();
//                        strbloodPressureAdultTwo=bloodPressureAdultTwo.getText().toString();
//                        strbloodPressureDiastolicAdultTwo=bloodPressureDiastolicAdultTwo.getText().toString();
//                        strcholesterolAdultTwo=cholesterolAdultTwo.getText().toString();
//                        strbloodSugarChildOne=bloodSugarChildOne.getText().toString();
//                        strbloodPressureChildOne=bloodPressureChildOne.getText().toString();
//                        strbloodPressureDiastolicChildOne=bloodPressureDiastolicChildOne.getText().toString();
//                        strcholesterolChildOne=cholesterolChildOne.getText().toString();
//                        strbloodSugarChildTwo=bloodSugarChildTwo.getText().toString();
//                        strbloodPressureChildTwo=bloodPressureChildTwo.getText().toString();
//                        strbloodPressureDiastolicChildTwo=bloodPressureDiastolicChildTwo.getText().toString();
//                        strcholesterolChildTwo=cholesterolChildTwo.getText().toString();
//                        if (strbloodSugar.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugar) < 70 || Integer.parseInt(strbloodSugar) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugar.setText("");
//                        }else if (strbloodPressure.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressure) < 90 || Integer.parseInt(strbloodPressure) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressure.setText("");
//                        }else if (strbloodPressureDiastolic.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolic) < 60 || Integer.parseInt(strbloodPressureDiastolic) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolic.setText("");
//                        }else if (stredtcholesterol.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(stredtcholesterol) < 150 || Integer.parseInt(stredtcholesterol) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterol.setText("");
//                        }else if (strbloodSugarAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarAdultTwo) < 70 || Integer.parseInt(strbloodSugarAdultTwo) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarAdultTwo.setText("");
//                        }else if (strbloodPressureAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureAdultTwo) < 90 || Integer.parseInt(strbloodPressureAdultTwo) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureAdultTwo.setText("");
//                        }else if (strbloodPressureDiastolicAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicAdultTwo) < 60 || Integer.parseInt(strbloodPressureDiastolicAdultTwo) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicAdultTwo.setText("");
//                        }else if (strcholesterolAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolAdultTwo) < 150 || Integer.parseInt(strcholesterolAdultTwo) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolAdultTwo.setText("");
//                        }else if (strbloodSugarChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarChildOne) < 70 || Integer.parseInt(strbloodSugarChildOne) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarChildOne.setText("");
//                        }else if (strbloodPressureChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureChildOne) < 90 || Integer.parseInt(strbloodPressureChildOne) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureChildOne.setText("");
//                        }else if (strbloodPressureDiastolicChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicChildOne) < 60 || Integer.parseInt(strbloodPressureDiastolicChildOne) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicChildOne.setText("");
//                        }else if (strcholesterolChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolChildOne) < 150 || Integer.parseInt(strcholesterolChildOne) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolChildOne.setText("");
//                        }else if (strbloodSugarChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarChildTwo) < 70 || Integer.parseInt(strbloodSugarChildTwo) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarChildTwo.setText("");
//                        }else if (strbloodPressureChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureChildTwo) < 90 || Integer.parseInt(strbloodPressureChildTwo) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureChildTwo.setText("");
//                        }else if (strbloodPressureDiastolicChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicChildTwo) < 60 || Integer.parseInt(strbloodPressureDiastolicChildTwo) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicChildTwo.setText("");
//                        }else if (strcholesterolChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolChildTwo) < 150 || Integer.parseInt(strcholesterolChildTwo) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolChildTwo.setText("");
//                        }else if (!checkbox.isChecked()){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Do you have any Pre Existing diseases?", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Intent intent=new Intent(ArogyaMedicalHistory.this, ArogyaPersonalHabbit.class);
//                            intent.putExtra("str_edt_name",str_edt_name);
//                            intent.putExtra("str_edt_phone",str_edt_phone);
//                            intent.putExtra("str_email",str_email);
//                            intent.putExtra("str_age",str_age);
//                            intent.putExtra("str_edit_dob3String",str_edit_dob3String);
//                            intent.putExtra("str_reference_no",str_reference_no);
//                            intent.putExtra("str_edit_dob",str_edit_dob);
//                            intent.putExtra("str_gender",str_gender);
//                            intent.putExtra("str_occupation",str_occupation);
//                            intent.putExtra("str_ft",str_ft);
//                            intent.putExtra("str_inches",str_inches);
//                            intent.putExtra("str_weight_edit",str_weight_edit);
//                            intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                            intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                            intent.putExtra("str_spouse_gender",str_spouse_gender);
//                            intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                            intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                            intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                            intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_OneEditName",str_OneEditName);
//                            intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                            intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                            intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                            intent.putExtra("TotalValue",str_TotalValue);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("strFirstTString",strFirstTString);
//                            intent.putExtra("PosPolicyNo",PosPolicyNo);
//                            intent.putExtra("strChildOne",strChildOne);
//                            intent.putExtra("strChildTwo",strChildTwo);
//                            intent.putExtra("strChildThree",strChildThree);
//                            intent.putExtra("strChildFour",strChildFour);
//                            intent.putExtra("NetPremiumValue",NetPremiumValue);
//                            intent.putExtra("strOneChild",strOneChild);
//                            intent.putExtra("strtwoDob",strtwoDob);
//                            intent.putExtra("strthreeDob",strthreeDob);
//                            intent.putExtra("strfourDob",strfourDob);
//                            intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
//                            intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
//                            intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
//                            intent.putExtra("strFourWeightEdit",strFourWeightEdit);
//                            intent.putExtra("strbloodSugar",strbloodSugar);
//                            intent.putExtra("strbloodPressure",strbloodPressure);
//                            intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
//                            intent.putExtra("stredtcholesterol",stredtcholesterol);
//                            intent.putExtra("strbloodSugarAdultTwo",strbloodSugarAdultTwo);
//                            intent.putExtra("strbloodPressureAdultTwo",strbloodPressureAdultTwo);
//                            intent.putExtra("strbloodPressureDiastolicAdultTwo",strbloodPressureDiastolicAdultTwo);
//                            intent.putExtra("strcholesterolAdultTwo",strcholesterolAdultTwo);
//                            intent.putExtra("strbloodSugarChildOne",strbloodSugarChildOne);
//                            intent.putExtra("strbloodPressureChildOne",strbloodPressureChildOne);
//                            intent.putExtra("strbloodPressureDiastolicChildOne",strbloodPressureDiastolicChildOne);
//                            intent.putExtra("strcholesterolChildOne",strcholesterolChildOne);
//                            intent.putExtra("strbloodSugarAdultTwo",strbloodSugarAdultTwo);
//                            intent.putExtra("strbloodPressureAdultTwo",strbloodPressureAdultTwo);
//                            intent.putExtra("strbloodPressureDiastolicAdultTwo",strbloodPressureDiastolicAdultTwo);
//                            intent.putExtra("strcholesterolAdultTwo",strcholesterolAdultTwo);
//                            intent.putExtra("strbloodSugarChildTwo",strbloodSugarChildTwo);
//                            intent.putExtra("strbloodPressureChildTwo",strbloodPressureChildTwo);
//                            intent.putExtra("strbloodPressureDiastolicChildTwo",strbloodPressureDiastolicChildTwo);
//                            intent.putExtra("strcholesterolChildTwo",strcholesterolChildTwo);
//                            intent.putExtra("strbloodSugarThirdChild",strbloodSugarThirdChild);
//                            intent.putExtra("strbloodPressureThirdChild",strbloodPressureThirdChild);
//                            intent.putExtra("strbloodPressureDiastolicThirdChild",strbloodPressureDiastolicThirdChild);
//                            intent.putExtra("strcholesterolThirdChild",strcholesterolThirdChild);
//                            intent.putExtra("GST",GST);
//                            intent.putExtra("str_RelationEdit",str_RelationEdit);
//                            intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
//                            intent.putExtra("strRelationChildEdit",strRelationChildEdit);
//                            intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
//                            intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
//                            intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
//                            intent.putExtra("strAddressLine1",strAddressLine1);
//                            intent.putExtra("strAddressLine2",strAddressLine2);
//                            intent.putExtra("strAddressLine3",strAddressLine3);
//                            intent.putExtra("strpincode",strpincode);
//                            intent.putExtra("strCityName",strCityName);
//                            intent.putExtra("strstateName",strstateName);
//                            intent.putExtra("QuoteId",QuoteId);
//                            intent.putExtra("NetPremium",NetPremium);
//                            intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                            intent.putExtra("strNominee_dob",strNominee_dob);
//                            intent.putExtra("for","0");
//                            startActivity(intent);
//                            finish();
//                        }
//
//                    }
//                    else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
//                        strbloodSugar=bloodSugar.getText().toString();
//                        strbloodPressure=bloodPressure.getText().toString();
//                        strbloodPressureDiastolic=bloodPressureDiastolic.getText().toString();
//                        stredtcholesterol=cholesterol.getText().toString();
//                        strbloodSugarAdultTwo=bloodSugarAdultTwo.getText().toString();
//                        strbloodPressureAdultTwo=bloodPressureAdultTwo.getText().toString();
//                        strbloodPressureDiastolicAdultTwo=bloodPressureDiastolicAdultTwo.getText().toString();
//                        strcholesterolAdultTwo=cholesterolAdultTwo.getText().toString();
//                        strbloodSugarChildOne=bloodSugarChildOne.getText().toString();
//                        strbloodPressureChildOne=bloodPressureChildOne.getText().toString();
//                        strbloodPressureDiastolicChildOne=bloodPressureDiastolicChildOne.getText().toString();
//                        strcholesterolChildOne=cholesterolChildOne.getText().toString();
//                        strbloodSugarChildTwo=bloodSugarChildTwo.getText().toString();
//                        strbloodPressureChildTwo=bloodPressureChildTwo.getText().toString();
//                        strbloodPressureDiastolicChildTwo=bloodPressureDiastolicChildTwo.getText().toString();
//                        strcholesterolChildTwo=cholesterolChildTwo.getText().toString();
//                        strbloodSugarThirdChild=bloodSugarThirdChild.getText().toString();
//                        strbloodPressureThirdChild=bloodPressureThirdChild.getText().toString();
//                        strbloodPressureDiastolicThirdChild=bloodPressureDiastolicThirdChild.getText().toString();
//                        strcholesterolThirdChild=cholesterolThirdChild.getText().toString();
//                        if (strbloodSugar.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugar) < 70 || Integer.parseInt(strbloodSugar) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugar.setText("");
//                        }else if (strbloodPressure.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressure) < 90 || Integer.parseInt(strbloodPressure) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressure.setText("");
//                        }else if (strbloodPressureDiastolic.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolic) < 60 || Integer.parseInt(strbloodPressureDiastolic) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolic.setText("");
//                        }else if (stredtcholesterol.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(stredtcholesterol) < 150 || Integer.parseInt(stredtcholesterol) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterol.setText("");
//                        }else if (strbloodSugarAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarAdultTwo) < 70 || Integer.parseInt(strbloodSugarAdultTwo) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarAdultTwo.setText("");
//                        }else if (strbloodPressureAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureAdultTwo) < 90 || Integer.parseInt(strbloodPressureAdultTwo) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureAdultTwo.setText("");
//                        }else if (strbloodPressureDiastolicAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicAdultTwo) < 60 || Integer.parseInt(strbloodPressureDiastolicAdultTwo) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicAdultTwo.setText("");
//                        }else if (strcholesterolAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolAdultTwo) < 150 || Integer.parseInt(strcholesterolAdultTwo) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolAdultTwo.setText("");
//                        }else if (strbloodSugarChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarChildOne) < 70 || Integer.parseInt(strbloodSugarChildOne) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarChildOne.setText("");
//                        }else if (strbloodPressureChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureChildOne) < 90 || Integer.parseInt(strbloodPressureChildOne) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureChildOne.setText("");
//                        }else if (strbloodPressureDiastolicChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicChildOne) < 60 || Integer.parseInt(strbloodPressureDiastolicChildOne) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicChildOne.setText("");
//                        }else if (strcholesterolChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolChildOne) < 150 || Integer.parseInt(strcholesterolChildOne) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolChildOne.setText("");
//                        }else if (strbloodSugarChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarChildTwo) < 70 || Integer.parseInt(strbloodSugarChildTwo) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarChildTwo.setText("");
//                        }else if (strbloodPressureChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureChildTwo) < 90 || Integer.parseInt(strbloodPressureChildTwo) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureChildTwo.setText("");
//                        }else if (strbloodPressureDiastolicChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicChildTwo) < 60 || Integer.parseInt(strbloodPressureDiastolicChildTwo) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicChildTwo.setText("");
//                        }else if (strcholesterolChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolChildTwo) < 150 || Integer.parseInt(strcholesterolChildTwo) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolChildTwo.setText("");
//                        } else if (strbloodSugarThirdChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 3rd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarThirdChild) < 70 || Integer.parseInt(strbloodSugarThirdChild) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "3rd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarThirdChild.setText("");
//                        }else if (strbloodPressureThirdChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 3rd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureThirdChild) < 90 || Integer.parseInt(strbloodPressureThirdChild) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "3rd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureThirdChild.setText("");
//                        }else if (strbloodPressureDiastolicThirdChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 3rd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicThirdChild) < 60 || Integer.parseInt(strbloodPressureDiastolicThirdChild) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "3rd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicThirdChild.setText("");
//                        }else if (strcholesterolThirdChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 3rd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolThirdChild) < 150 || Integer.parseInt(strcholesterolThirdChild) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "3rd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolThirdChild.setText("");
//                        }else if (!checkbox.isChecked()){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Do you have any Pre Existing diseases?", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Intent intent=new Intent(ArogyaMedicalHistory.this, ArogyaPersonalHabbit.class);
//                            intent.putExtra("str_edt_name",str_edt_name);
//                            intent.putExtra("str_edt_phone",str_edt_phone);
//                            intent.putExtra("str_email",str_email);
//                            intent.putExtra("str_age",str_age);
//                            intent.putExtra("str_edit_dob3String",str_edit_dob3String);
//                            intent.putExtra("str_reference_no",str_reference_no);
//                            intent.putExtra("str_edit_dob",str_edit_dob);
//                            intent.putExtra("str_gender",str_gender);
//                            intent.putExtra("str_occupation",str_occupation);
//                            intent.putExtra("str_ft",str_ft);
//                            intent.putExtra("str_inches",str_inches);
//                            intent.putExtra("str_weight_edit",str_weight_edit);
//                            intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                            intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                            intent.putExtra("str_spouse_gender",str_spouse_gender);
//                            intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                            intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                            intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                            intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_OneEditName",str_OneEditName);
//                            intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                            intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                            intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                            intent.putExtra("TotalValue",str_TotalValue);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("strFirstTString",strFirstTString);
//                            intent.putExtra("PosPolicyNo",PosPolicyNo);
//                            intent.putExtra("strChildOne",strChildOne);
//                            intent.putExtra("strChildTwo",strChildTwo);
//                            intent.putExtra("strChildThree",strChildThree);
//                            intent.putExtra("strChildFour",strChildFour);
//                            intent.putExtra("NetPremiumValue",NetPremiumValue);
//                            intent.putExtra("strOneChild",strOneChild);
//                            intent.putExtra("strtwoDob",strtwoDob);
//                            intent.putExtra("strthreeDob",strthreeDob);
//                            intent.putExtra("strfourDob",strfourDob);
//                            intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
//                            intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
//                            intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
//                            intent.putExtra("strFourWeightEdit",strFourWeightEdit);
//                            intent.putExtra("strbloodSugar",strbloodSugar);
//                            intent.putExtra("strbloodPressure",strbloodPressure);
//                            intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
//                            intent.putExtra("stredtcholesterol",stredtcholesterol);
//                            intent.putExtra("strbloodSugarAdultTwo",strbloodSugarAdultTwo);
//                            intent.putExtra("strbloodPressureAdultTwo",strbloodPressureAdultTwo);
//                            intent.putExtra("strbloodPressureDiastolicAdultTwo",strbloodPressureDiastolicAdultTwo);
//                            intent.putExtra("strcholesterolAdultTwo",strcholesterolAdultTwo);
//                            intent.putExtra("strbloodSugarChildOne",strbloodSugarChildOne);
//                            intent.putExtra("strbloodPressureChildOne",strbloodPressureChildOne);
//                            intent.putExtra("strbloodPressureDiastolicChildOne",strbloodPressureDiastolicChildOne);
//                            intent.putExtra("strcholesterolChildOne",strcholesterolChildOne);
//                            intent.putExtra("strbloodSugarChildTwo",strbloodSugarChildTwo);
//                            intent.putExtra("strbloodPressureChildTwo",strbloodPressureChildTwo);
//                            intent.putExtra("strbloodPressureDiastolicChildTwo",strbloodPressureDiastolicChildTwo);
//                            intent.putExtra("strcholesterolChildTwo",strcholesterolChildTwo);
//                            intent.putExtra("strbloodSugarThirdChild",strbloodSugarThirdChild);
//                            intent.putExtra("strbloodPressureThirdChild",strbloodPressureThirdChild);
//                            intent.putExtra("strbloodPressureDiastolicThirdChild",strbloodPressureDiastolicThirdChild);
//                            intent.putExtra("strcholesterolThirdChild",strcholesterolThirdChild);
//                            intent.putExtra("GST",GST);
//                            intent.putExtra("str_RelationEdit",str_RelationEdit);
//                            intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
//                            intent.putExtra("strRelationChildEdit",strRelationChildEdit);
//                            intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
//                            intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
//                            intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
//                            intent.putExtra("strAddressLine1",strAddressLine1);
//                            intent.putExtra("strAddressLine2",strAddressLine2);
//                            intent.putExtra("strAddressLine3",strAddressLine3);
//                            intent.putExtra("strpincode",strpincode);
//                            intent.putExtra("strCityName",strCityName);
//                            intent.putExtra("QuoteId",QuoteId);
//                            intent.putExtra("NetPremium",NetPremium);
//                            intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                            intent.putExtra("strstateName",strstateName);
//                            intent.putExtra("strNominee_dob",strNominee_dob);
//                            intent.putExtra("for","0");
//                            startActivity(intent);
//                            finish();
//                        }
//
//                    }
//                    else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
//                        strbloodSugar=bloodSugar.getText().toString();
//                        strbloodPressure=bloodPressure.getText().toString();
//                        strbloodPressureDiastolic=bloodPressureDiastolic.getText().toString();
//                        stredtcholesterol=cholesterol.getText().toString();
//                        strbloodSugarAdultTwo=bloodSugarAdultTwo.getText().toString();
//                        strbloodPressureAdultTwo=bloodPressureAdultTwo.getText().toString();
//                        strbloodPressureDiastolicAdultTwo=bloodPressureDiastolicAdultTwo.getText().toString();
//                        strcholesterolAdultTwo=cholesterolAdultTwo.getText().toString();
//                        strbloodSugarChildOne=bloodSugarChildOne.getText().toString();
//                        strbloodPressureChildOne=bloodPressureChildOne.getText().toString();
//                        strbloodPressureDiastolicChildOne=bloodPressureDiastolicChildOne.getText().toString();
//                        strcholesterolChildOne=cholesterolChildOne.getText().toString();
//                        strbloodSugarChildTwo=bloodSugarChildTwo.getText().toString();
//                        strbloodPressureChildTwo=bloodPressureChildTwo.getText().toString();
//                        strbloodPressureDiastolicChildTwo=bloodPressureDiastolicChildTwo.getText().toString();
//                        strcholesterolChildTwo=cholesterolChildTwo.getText().toString();
//                        strbloodSugarThirdChild=bloodSugarThirdChild.getText().toString();
//                        strbloodPressureThirdChild=bloodPressureThirdChild.getText().toString();
//                        strbloodPressureDiastolicThirdChild=bloodPressureDiastolicThirdChild.getText().toString();
//                        strcholesterolThirdChild=cholesterolThirdChild.getText().toString();
//                        strbloodSugarFourChild=bloodSugarFourChild.getText().toString();
//                        strbloodPressureFourChild=bloodPressureFourChild.getText().toString();
//                        strbloodPressureDiastolicFourChild=bloodPressureDiastolicFourChild.getText().toString();
//                        strcholesterolFourChild=cholesterolFourChild.getText().toString();
//                        if (strbloodSugar.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugar) < 70 || Integer.parseInt(strbloodSugar) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugar.setText("");
//                        }else if (strbloodPressure.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressure) < 90 || Integer.parseInt(strbloodPressure) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressure.setText("");
//                        }else if (strbloodPressureDiastolic.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolic) < 60 || Integer.parseInt(strbloodPressureDiastolic) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolic.setText("");
//                        }else if (stredtcholesterol.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(stredtcholesterol) < 150 || Integer.parseInt(stredtcholesterol) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterol.setText("");
//                        }else if (strbloodSugarAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarAdultTwo) < 70 || Integer.parseInt(strbloodSugarAdultTwo) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarAdultTwo.setText("");
//                        }else if (strbloodPressureAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureAdultTwo) < 90 || Integer.parseInt(strbloodPressureAdultTwo) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureAdultTwo.setText("");
//                        }else if (strbloodPressureDiastolicAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicAdultTwo) < 60 || Integer.parseInt(strbloodPressureDiastolicAdultTwo) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicAdultTwo.setText("");
//                        }else if (strcholesterolAdultTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd Adult Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolAdultTwo) < 150 || Integer.parseInt(strcholesterolAdultTwo) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd Adult Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolAdultTwo.setText("");
//                        }else if (strbloodSugarChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarChildOne) < 70 || Integer.parseInt(strbloodSugarChildOne) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarChildOne.setText("");
//                        }else if (strbloodPressureChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureChildOne) < 90 || Integer.parseInt(strbloodPressureChildOne) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureChildOne.setText("");
//                        }else if (strbloodPressureDiastolicChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicChildOne) < 60 || Integer.parseInt(strbloodPressureDiastolicChildOne) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicChildOne.setText("");
//                        }else if (strcholesterolChildOne.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolChildOne) < 150 || Integer.parseInt(strcholesterolChildOne) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "1st child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolChildOne.setText("");
//                        }else if (strbloodSugarChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarChildTwo) < 70 || Integer.parseInt(strbloodSugarChildTwo) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarChildTwo.setText("");
//                        }else if (strbloodPressureChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureChildTwo) < 90 || Integer.parseInt(strbloodPressureChildTwo) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureChildTwo.setText("");
//                        }else if (strbloodPressureDiastolicChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicChildTwo) < 60 || Integer.parseInt(strbloodPressureDiastolicChildTwo) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicChildTwo.setText("");
//                        }else if (strcholesterolChildTwo.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 2nd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolChildTwo) < 150 || Integer.parseInt(strcholesterolChildTwo) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "2nd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolChildTwo.setText("");
//                        } else if (strbloodSugarThirdChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 3rd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarThirdChild) < 70 || Integer.parseInt(strbloodSugarThirdChild) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "3rd child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarThirdChild.setText("");
//                        }else if (strbloodPressureThirdChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 3rd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureThirdChild) < 90 || Integer.parseInt(strbloodPressureThirdChild) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "3rd child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureThirdChild.setText("");
//                        }else if (strbloodPressureDiastolicThirdChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 3rd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicThirdChild) < 60 || Integer.parseInt(strbloodPressureDiastolicThirdChild) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "3rd child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicThirdChild.setText("");
//                        }else if (strcholesterolThirdChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 3rd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolThirdChild) < 150 || Integer.parseInt(strcholesterolThirdChild) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "3rd child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolThirdChild.setText("");
//                        }else if (strbloodSugarFourChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 4th child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodSugarFourChild) < 70 || Integer.parseInt(strbloodSugarFourChild) >99) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "4th child Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                            bloodSugarFourChild.setText("");
//                        }else if (strbloodPressureFourChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 4th child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureFourChild) < 90 || Integer.parseInt(strbloodPressureFourChild) >129) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "4th child Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                            bloodPressureFourChild.setText("");
//                        }else if (strbloodPressureDiastolicFourChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 4th child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strbloodPressureDiastolicFourChild) < 60 || Integer.parseInt(strbloodPressureDiastolicFourChild) >79) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "4th child Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                            bloodPressureDiastolicFourChild.setText("");
//                        }else if (strcholesterolFourChild.equals("")){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Please enter 4th child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        }else if (Integer.parseInt(strcholesterolFourChild) < 150 || Integer.parseInt(strcholesterolFourChild) >199) {
//                            Toast.makeText(ArogyaMedicalHistory.this, "4th child Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                            cholesterolFourChild.setText("");
//                        }else if (!checkbox.isChecked()){
//                            Toast.makeText(ArogyaMedicalHistory.this, "Do you have any Pre Existing diseases?", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Intent intent=new Intent(ArogyaMedicalHistory.this, ArogyaPersonalHabbit.class);
//                            intent.putExtra("str_edt_name",str_edt_name);
//                            intent.putExtra("str_edt_phone",str_edt_phone);
//                            intent.putExtra("str_email",str_email);
//                            intent.putExtra("str_age",str_age);
//                            intent.putExtra("str_edit_dob3String",str_edit_dob3String);
//                            intent.putExtra("str_reference_no",str_reference_no);
//                            intent.putExtra("str_edit_dob",str_edit_dob);
//                            intent.putExtra("str_gender",str_gender);
//                            intent.putExtra("str_occupation",str_occupation);
//                            intent.putExtra("str_ft",str_ft);
//                            intent.putExtra("str_inches",str_inches);
//                            intent.putExtra("str_weight_edit",str_weight_edit);
//                            intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                            intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                            intent.putExtra("str_spouse_gender",str_spouse_gender);
//                            intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                            intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                            intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                            intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_OneEditName",str_OneEditName);
//                            intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                            intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                            intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                            intent.putExtra("TotalValue",str_TotalValue);
//                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                            intent.putExtra("str_SumInsured",str_SumInsured);
//                            intent.putExtra("strFirstTString",strFirstTString);
//                            intent.putExtra("PosPolicyNo",PosPolicyNo);
//                            intent.putExtra("strChildOne",strChildOne);
//                            intent.putExtra("strChildTwo",strChildTwo);
//                            intent.putExtra("strChildThree",strChildThree);
//                            intent.putExtra("strChildFour",strChildFour);
//                            intent.putExtra("NetPremiumValue",NetPremiumValue);
//                            intent.putExtra("strOneChild",strOneChild);
//                            intent.putExtra("strtwoDob",strtwoDob);
//                            intent.putExtra("strthreeDob",strthreeDob);
//                            intent.putExtra("strfourDob",strfourDob);
//                            intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
//                            intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
//                            intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
//                            intent.putExtra("strFourWeightEdit",strFourWeightEdit);
//                            intent.putExtra("strbloodSugar",strbloodSugar);
//                            intent.putExtra("strbloodPressure",strbloodPressure);
//                            intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
//                            intent.putExtra("stredtcholesterol",stredtcholesterol);
//                            intent.putExtra("strbloodSugarAdultTwo",strbloodSugarAdultTwo);
//                            intent.putExtra("strbloodPressureAdultTwo",strbloodPressureAdultTwo);
//                            intent.putExtra("strbloodPressureDiastolicAdultTwo",strbloodPressureDiastolicAdultTwo);
//                            intent.putExtra("strcholesterolAdultTwo",strcholesterolAdultTwo);
//                            intent.putExtra("strbloodSugarChildOne",strbloodSugarChildOne);
//                            intent.putExtra("strbloodPressureChildOne",strbloodPressureChildOne);
//                            intent.putExtra("strbloodPressureDiastolicChildOne",strbloodPressureDiastolicChildOne);
//                            intent.putExtra("strcholesterolChildOne",strcholesterolChildOne);
//                            intent.putExtra("strbloodSugarChildTwo",strbloodSugarChildTwo);
//                            intent.putExtra("strbloodPressureChildTwo",strbloodPressureChildTwo);
//                            intent.putExtra("strbloodPressureDiastolicChildTwo",strbloodPressureDiastolicChildTwo);
//                            intent.putExtra("strcholesterolChildTwo",strcholesterolChildTwo);
//                            intent.putExtra("strbloodSugarThirdChild",strbloodSugarThirdChild);
//                            intent.putExtra("strbloodPressureThirdChild",strbloodPressureThirdChild);
//                            intent.putExtra("strbloodPressureDiastolicThirdChild",strbloodPressureDiastolicThirdChild);
//                            intent.putExtra("strcholesterolThirdChild",strcholesterolThirdChild);
//                            intent.putExtra("strbloodSugarFourChild",strbloodSugarFourChild);
//                            intent.putExtra("strbloodPressureFourChild",strbloodPressureFourChild);
//                            intent.putExtra("strbloodPressureDiastolicFourChild",strbloodPressureDiastolicFourChild);
//                            intent.putExtra("strcholesterolFourChild",strcholesterolFourChild);
//                            intent.putExtra("GST",GST);
//                            intent.putExtra("str_RelationEdit",str_RelationEdit);
//                            intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
//                            intent.putExtra("strRelationChildEdit",strRelationChildEdit);
//                            intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
//                            intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
//                            intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
//                            intent.putExtra("strAddressLine1",strAddressLine1);
//                            intent.putExtra("strAddressLine2",strAddressLine2);
//                            intent.putExtra("strAddressLine3",strAddressLine3);
//                            intent.putExtra("strpincode",strpincode);
//                            intent.putExtra("strCityName",strCityName);
//                            intent.putExtra("strstateName",strstateName);
//                            intent.putExtra("QuoteId",QuoteId);
//                            intent.putExtra("NetPremium",NetPremium);
//                            intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                            intent.putExtra("strNominee_dob",strNominee_dob);
//                            intent.putExtra("for","0");
//                            startActivity(intent);
//                            finish();
//                        }
//
//                    }
//
//                }
//
//
//
//
//            }
//        });
    }

    private void parentcheck() {
        if (strParentEditText.equals("Mother")||strParentEditText.equals("Mother-In-Law")){
            if (strPreExistingMother.equals("Yes") || strPersonMotherRadio.equals("Yes")|| strSmokerMotherRadio.equals("Yes") ||strMotherPhysical.equals("Yes") || strDiseaseMother.equals("Yes") || strMotherHistoryRadio.equals("Yes") || strConsumeAlcoholMother.equals("Yes") || strConsumeTobaccoMother.equals("Yes")|| strMotherNarcotic.equals("Yes")) {
                alertPopup();
            }else{
                intentNext();
            }
        }else if (strParentEditText.equals("Father")||strParentEditText.equals("Father-In-Law")){
            if (strPreExistingFather.equals("Yes") || strFatherPhysical.equals("Yes") || strDiseaseFather.equals("Yes")|| strPersonFather.equals("Yes") || strFatherHistory.equals("Yes") || strConsumeAlcoholFather.equals("Yes") || strConsumeTobaccoFather.equals("Yes")) {
                alertPopup();
            } else {
                intentNext();
            }
        }else if (strParentEditText.equals("Mother & Father")||strParentEditText.equals("Mother-In-Law & Father-In-Law")){
            if (strPreExistingMother.equals("Yes") || strPersonMotherRadio.equals("Yes")|| strSmokerMotherRadio.equals("Yes") ||strMotherPhysical.equals("Yes") || strDiseaseMother.equals("Yes") || strMotherHistoryRadio.equals("Yes") || strConsumeAlcoholMother.equals("Yes") || strConsumeTobaccoMother.equals("Yes")|| strMotherNarcotic.equals("Yes")) {
                alertPopup();
            }else if (strPreExistingFather.equals("Yes") || strFatherPhysical.equals("Yes") || strDiseaseFather.equals("Yes")|| strPersonFather.equals("Yes") || strFatherHistory.equals("Yes") || strConsumeAlcoholFather.equals("Yes") || strConsumeTobaccoFather.equals("Yes")) {
                alertPopup();
            }else {
                intentNext();
            }
        }else{
            intentNext();
        }
    }

    private void alertPopup() {
        Dialog alert_dialogNSTP;
        alert_dialogNSTP = new Dialog(ArogyaMedicalHistory.this);
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
                Intent intent = new Intent(ArogyaMedicalHistory.this, BuyPolicySuminsuredArogya.class);
                intent.putExtra("str_edt_name",str_edt_name);
                intent.putExtra("str_edt_phone",str_edt_phone);
                intent.putExtra("str_email",str_email);
                intent.putExtra("str_age",str_age);
                intent.putExtra("str_reference_no",str_reference_no);
                intent.putExtra("str_edit_dob",str_edit_dob);
                intent.putExtra("str_gender",str_gender);
                intent.putExtra("str_occupation",str_occupation);
                intent.putExtra("str_ft",str_ft);
                intent.putExtra("str_inches",str_inches);
                intent.putExtra("str_weight_edit",str_weight_edit);
                intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
                intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
                intent.putExtra("str_spouse_gender",str_spouse_gender);
                intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
                intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
                intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
                intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
                intent.putExtra("strAnyDisease",strAnyDisease);
                intent.putExtra("strnoDiabetes",strnoDiabetes);
                intent.putExtra("strNoHypertension",strNoHypertension);
                intent.putExtra("strNoCholesterol",strNoCholesterol);
                intent.putExtra("strnoSpouseDiabetes",strnoSpouseDiabetes);
                intent.putExtra("strNoSpouseHypertension",strNoSpouseHypertension);
                intent.putExtra("strNoSpouseCholesterol",strNoSpouseCholesterol);
                intent.putExtra("strAnyhabitual",strAnyhabitual);
                intent.putExtra("strforSelf",strforSelf);
                intent.putExtra("strforSpouse",strforSpouse);
                intent.putExtra("strSubLimit",strSubLimit);
                intent.putExtra("strSubLimitAmount",strSubLimitAmount);
                intent.putExtra("strAnyTreatment",strAnyTreatment);
                intent.putExtra("strDiscount",strDiscount);
                intent.putExtra("strcriticalEdit",strcriticalEdit);
                intent.putExtra("strCriticalIllness",strCriticalIllness);
                intent.putExtra("strCriticalUnderSpinner",strCriticalUnderSpinner);
                intent.putExtra("strCriticalUnderSpinner2",strCriticalUnderSpinner2);
                intent.putExtra("strperonalAccidentEdit",strperonalAccidentEdit);
                intent.putExtra("strPersonalAccidentSpinner",strPersonalAccidentSpinner);
                intent.putExtra("strpersonalUnder_spinner",strpersonalUnder_spinner);
                intent.putExtra("strpersonal_under_spinner2",strpersonal_under_spinner2);
                intent.putExtra("strhospitalEdit",strhospitalEdit);
                intent.putExtra("strhospitalCashSpinner",strhospitalCashSpinner);
                intent.putExtra("strhospital_under_spinner",strhospital_under_spinner);
                intent.putExtra("strhospital_under_spinner2",strhospital_under_spinner2);
                intent.putExtra("TotalValue",str_TotalValue);
                intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                intent.putExtra("str_SumInsured",str_SumInsured);
                intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                intent.putExtra("str_OneEditName",str_OneEditName);
                intent.putExtra("str_twoChildEditName",str_twoChildEditName);
                intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
                intent.putExtra("str_fourNameEdit",str_fourNameEdit);
                intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                intent.putExtra("strFirstTString",strFirstTString);
                intent.putExtra("PosPolicyNo",PosPolicyNo);
                intent.putExtra("str_amountPersonalSumInsured",str_amountPersonalSumInsured);
                intent.putExtra("strhospitalEdit",strhospitalEdit);
                intent.putExtra("strcriticalEdit",strcriticalEdit);
                intent.putExtra("strSubLimitAmount",strSubLimitAmount);
                intent.putExtra("strDiscount",strDiscount);
                intent.putExtra("NetPremiumValue",NetPremiumValue);
                intent.putExtra("GST",GST);
                intent.putExtra("strProposerSpinner",strProposerSpinner);
                intent.putExtra("strContactNominee",strContactNominee);
                intent.putExtra("strNomineeName",strNomineeName);
                intent.putExtra("strbloodSugar",strbloodSugar);
                intent.putExtra("strbloodPressure",strbloodPressure);
                intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
                intent.putExtra("stredtcholesterol",stredtcholesterol);
                intent.putExtra("strbloodSugarAdultTwo",strbloodSugarAdultTwo);
                intent.putExtra("strbloodPressureAdultTwo",strbloodPressureAdultTwo);
                intent.putExtra("strbloodPressureDiastolicAdultTwo",strbloodPressureDiastolicAdultTwo);
                intent.putExtra("strcholesterolAdultTwo",strcholesterolAdultTwo);
                intent.putExtra("strbloodSugarChildOne",strbloodSugarChildOne);
                intent.putExtra("strbloodPressureChildOne",strbloodPressureChildOne);
                intent.putExtra("strbloodPressureDiastolicChildOne",strbloodPressureDiastolicChildOne);
                intent.putExtra("strcholesterolChildOne",strcholesterolChildOne);
                intent.putExtra("strbloodSugarChildTwo",strbloodSugarChildTwo);
                intent.putExtra("strbloodPressureChildTwo",strbloodPressureChildTwo);
                intent.putExtra("strbloodPressureDiastolicChildTwo",strbloodPressureDiastolicChildTwo);
                intent.putExtra("strcholesterolChildTwo",strcholesterolChildTwo);
                intent.putExtra("strbloodSugarThirdChild",strbloodSugarThirdChild);
                intent.putExtra("strbloodPressureThirdChild",strbloodPressureThirdChild);
                intent.putExtra("strbloodPressureDiastolicThirdChild",strbloodPressureDiastolicThirdChild);
                intent.putExtra("strcholesterolThirdChild",strcholesterolThirdChild);
                intent.putExtra("strbloodSugarFourChild",strbloodSugarFourChild);
                intent.putExtra("strbloodPressureFourChild",strbloodPressureFourChild);
                intent.putExtra("strbloodPressureDiastolicFourChild",strbloodPressureDiastolicFourChild);
                intent.putExtra("strcholesterolFourChild",strcholesterolFourChild);
                intent.putExtra("str_edit_dob3String",str_edit_dob3String);
                intent.putExtra("str_RelationEdit",str_RelationEdit);
                intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
                intent.putExtra("strRelationChildEdit",strRelationChildEdit);
                intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
                intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
                intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
                intent.putExtra("strAddressLine1",strAddressLine1);
                intent.putExtra("strAddressLine2",strAddressLine2);
                intent.putExtra("strAddressLine3",strAddressLine3);
                intent.putExtra("strpincode",strpincode);
                intent.putExtra("strCityName",strCityName);
                intent.putExtra("strstateName",strstateName);
                intent.putExtra("QuoteId",QuoteId);
                intent.putExtra("NetPremium",NetPremium);
                intent.putExtra("TotalInstallPremium",TotalInstallPremium);
                intent.putExtra("strNominee_dob",strNominee_dob);
                intent.putExtra("for","1");
                startActivity(intent);
                finish();
                alert_dialogNSTP.dismiss();

            }
        });
    }

    private void intentNext() {
        Intent intent=new Intent(ArogyaMedicalHistory.this, ArogyaNomineeOtherDetails.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_email",str_email);
        intent.putExtra("str_age",str_age);
        intent.putExtra("str_reference_no",str_reference_no);
        intent.putExtra("str_edit_dob",str_edit_dob);
        intent.putExtra("str_gender",str_gender);
        intent.putExtra("str_occupation",str_occupation);
        intent.putExtra("str_ft",str_ft);
        intent.putExtra("str_inches",str_inches);
        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
        intent.putExtra("str_weight_edit",str_weight_edit);
        intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
        intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
        intent.putExtra("str_spouse_gender",str_spouse_gender);
        intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
        intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
        intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
        intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
        intent.putExtra("strAnyDisease",strAnyDisease);
        intent.putExtra("strnoDiabetes",strnoDiabetes);
        intent.putExtra("strNoHypertension",strNoHypertension);
        intent.putExtra("strNoCholesterol",strNoCholesterol);
        intent.putExtra("strnoSpouseDiabetes",strnoSpouseDiabetes);
        intent.putExtra("strNoSpouseHypertension",strNoSpouseHypertension);
        intent.putExtra("strNoSpouseCholesterol",strNoSpouseCholesterol);
        intent.putExtra("strAnyhabitual",strAnyhabitual);
        intent.putExtra("strforSelf",strforSelf);
        intent.putExtra("strforSpouse",strforSpouse);
        intent.putExtra("strSubLimit",strSubLimit);
        intent.putExtra("strSubLimitAmount",strSubLimitAmount);
        intent.putExtra("strAnyTreatment",strAnyTreatment);
        intent.putExtra("strDiscount",strDiscount);
        intent.putExtra("strcriticalEdit",strcriticalEdit);
        intent.putExtra("strCriticalIllness",strCriticalIllness);
        intent.putExtra("strCriticalUnderSpinner",strCriticalUnderSpinner);
        intent.putExtra("strCriticalUnderSpinner2",strCriticalUnderSpinner2);
        intent.putExtra("strperonalAccidentEdit",strperonalAccidentEdit);
        intent.putExtra("strPersonalAccidentSpinner",strPersonalAccidentSpinner);
        intent.putExtra("strpersonalUnder_spinner",strpersonalUnder_spinner);
        intent.putExtra("strpersonal_under_spinner2",strpersonal_under_spinner2);
        intent.putExtra("strhospitalEdit",strhospitalEdit);
        intent.putExtra("strhospitalCashSpinner",strhospitalCashSpinner);
        intent.putExtra("strhospital_under_spinner",strhospital_under_spinner);
        intent.putExtra("strhospital_under_spinner2",strhospital_under_spinner2);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_OneEditName",str_OneEditName);
        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("strFirstTString",strFirstTString);
        intent.putExtra("TotalValue",str_TotalValue);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("str_amountPersonalSumInsured",str_amountPersonalSumInsured);
        intent.putExtra("strhospitalEdit",strhospitalEdit);
        intent.putExtra("strcriticalEdit",strcriticalEdit);
        intent.putExtra("strSubLimitAmount",strSubLimitAmount);
        intent.putExtra("strDiscount",strDiscount);
        intent.putExtra("GST",GST);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("str_RelationEdit",str_RelationEdit);
        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
        intent.putExtra("strAddressLine1",strAddressLine1);
        intent.putExtra("strAddressLine2",strAddressLine2);
        intent.putExtra("strAddressLine3",strAddressLine3);
        intent.putExtra("strpincode",strpincode);
        intent.putExtra("strCityName",strCityName);
        intent.putExtra("strstateName",strstateName);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("TotalPremium",TotalPremium);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("strNominee_dob",strNominee_dob);
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("str_oneGenderSpinner",str_oneGenderSpinner);
        intent.putExtra("str_oneFtSpinner",str_oneFtSpinner);
        intent.putExtra("str_oneInchesSpinner",str_oneInchesSpinner);
        intent.putExtra("str_twoGenderSpinner",str_twoGenderSpinner);
        intent.putExtra("str_twoFtSpinner",str_twoFtSpinner);
        intent.putExtra("str_twoInchesSpinner",str_twoInchesSpinner);
        intent.putExtra("str_thirdGenderSpinner",str_thirdGenderSpinner);
        intent.putExtra("str_thirdFtSpinner",str_thirdFtSpinner);
        intent.putExtra("str_thirdInchesSpinner",str_thirdInchesSpinner);
        intent.putExtra("str_fourGenderSpinner",str_fourGenderSpinner);
        intent.putExtra("str_fourFtSpinner",str_fourFtSpinner);
        intent.putExtra("str_fourInchesSpinner",str_fourInchesSpinner);
        intent.putExtra("strOneChild",strOneChild);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
        intent.putExtra("str_policyTenure",str_policyTenure);
        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
        intent.putExtra("BMI",BMI);
        intent.putExtra("Individual_BMI",Individual_BMI);
        intent.putExtra("twoAdult_BMI",twoAdult_BMI);
        intent.putExtra("OneChildBMI",OneChildBMI);
        intent.putExtra("TwoChildBMI",TwoChildBMI);
        intent.putExtra("ThreeChildBMI",ThreeChildBMI);
        intent.putExtra("FourChildBMI",FourChildBMI);
        intent.putExtra("str_life_style_spinner",str_life_style_spinner);
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("selectYearAdult",selectYearAdult);
        intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
        intent.putExtra("selectYearChild",selectYearChild);
        intent.putExtra("selectYearChildTwo",selectYearChildTwo);
        intent.putExtra("selectYearChildThird",selectYearChildThird);
        intent.putExtra("selectYearChildFour",selectYearChildFour);
        intent.putExtra("strParentEditText",strParentEditText);
        intent.putExtra("FamilyTypeCounter",FamilyTypeCounter);
        intent.putExtra("ParentCounter",ParentCounter);
        intent.putExtra("strMotherName",strMotherName);
        intent.putExtra("strMotherDob",strMotherDob);
        intent.putExtra("strMotherOccupationEdit",strMotherOccupationEdit);
        intent.putExtra("strMotherWeightEdit",strMotherWeightEdit);
        intent.putExtra("strFatherName",strFatherName);
        intent.putExtra("strFatherDob",strFatherDob);
        intent.putExtra("strFatherWeightEdit",strFatherWeightEdit);
        intent.putExtra("strFatherOccupationEdit",strFatherOccupationEdit);
        intent.putExtra("strMotherLawName",strMotherLawName);
        intent.putExtra("strMotherLawDob",strMotherLawDob);
        intent.putExtra("strMotherLawOccupationEdit",strMotherLawOccupationEdit);
        intent.putExtra("strMotherLawWeightEdit",strMotherLawWeightEdit);
        intent.putExtra("strFatherLawName",strFatherLawName);
        intent.putExtra("strFatherLawDob",strFatherLawDob);
        intent.putExtra("strFatherLawOccupationEdit",strFatherLawOccupationEdit);
        intent.putExtra("strFatherLawWeightEdit",strFatherLawWeightEdit);
        intent.putExtra("selectYearMother",selectYearMother);
        intent.putExtra("selectYearFather",selectYearFather);
        intent.putExtra("selectYearMotherLaw",selectYearMotherLaw);
        intent.putExtra("selectYearFatherLaw",selectYearFatherLaw);
        intent.putExtra("MotherBMI",MotherBMI);
        intent.putExtra("FatherBMI",FatherBMI);
        intent.putExtra("MotherLawBMI",MotherLawBMI);
        intent.putExtra("FatherLawBMI",FatherLawBMI);
        intent.putExtra("strMotherFtEdit",strMotherFtEdit);
        intent.putExtra("strMotherInchesEdit",strMotherInchesEdit);
        intent.putExtra("strFatherFtEdit",strFatherFtEdit);
        intent.putExtra("strFatherInchesEdit",strFatherInchesEdit);
        intent.putExtra("strMotherLawFtEdit",strMotherLawFtEdit);
        intent.putExtra("strMotherLawInchesEdit",strMotherLawInchesEdit);
        intent.putExtra("strFatherLawFtEdit",strFatherLawFtEdit);
        intent.putExtra("strFatherLawInchesEdit",strFatherLawInchesEdit);
        intent.putExtra("for","0");
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(ArogyaMedicalHistory.this, Arogya_Medical_Discount.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_email",str_email);
        intent.putExtra("str_age",str_age);
        intent.putExtra("str_reference_no",str_reference_no);
        intent.putExtra("str_edit_dob",str_edit_dob);
        intent.putExtra("str_gender",str_gender);
        intent.putExtra("str_occupation",str_occupation);
        intent.putExtra("str_ft",str_ft);
        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
        intent.putExtra("str_inches",str_inches);
        intent.putExtra("str_weight_edit",str_weight_edit);
        intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
        intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
        intent.putExtra("str_spouse_gender",str_spouse_gender);
        intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
        intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
        intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
        intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
        intent.putExtra("strAnyDisease",strAnyDisease);
        intent.putExtra("strnoDiabetes",strnoDiabetes);
        intent.putExtra("strNoHypertension",strNoHypertension);
        intent.putExtra("strNoCholesterol",strNoCholesterol);
        intent.putExtra("strnoSpouseDiabetes",strnoSpouseDiabetes);
        intent.putExtra("strNoSpouseHypertension",strNoSpouseHypertension);
        intent.putExtra("strNoSpouseCholesterol",strNoSpouseCholesterol);
        intent.putExtra("strAnyhabitual",strAnyhabitual);
        intent.putExtra("strforSelf",strforSelf);
        intent.putExtra("strforSpouse",strforSpouse);
        intent.putExtra("strSubLimit",strSubLimit);
        intent.putExtra("strSubLimitAmount",strSubLimitAmount);
        intent.putExtra("strAnyTreatment",strAnyTreatment);
        intent.putExtra("strDiscount",strDiscount);
        intent.putExtra("strcriticalEdit",strcriticalEdit);
        intent.putExtra("strCriticalIllness",strCriticalIllness);
        intent.putExtra("strCriticalUnderSpinner",strCriticalUnderSpinner);
        intent.putExtra("strCriticalUnderSpinner2",strCriticalUnderSpinner2);
        intent.putExtra("strperonalAccidentEdit",strperonalAccidentEdit);
        intent.putExtra("strPersonalAccidentSpinner",strPersonalAccidentSpinner);
        intent.putExtra("strpersonalUnder_spinner",strpersonalUnder_spinner);
        intent.putExtra("strpersonal_under_spinner2",strpersonal_under_spinner2);
        intent.putExtra("strhospitalEdit",strhospitalEdit);
        intent.putExtra("strhospitalCashSpinner",strhospitalCashSpinner);
        intent.putExtra("strhospital_under_spinner",strhospital_under_spinner);
        intent.putExtra("strhospital_under_spinner2",strhospital_under_spinner2);
        intent.putExtra("TotalValue",str_TotalValue);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_OneEditName",str_OneEditName);
        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("strFirstTString",strFirstTString);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("str_amountPersonalSumInsured",str_amountPersonalSumInsured);
        intent.putExtra("strhospitalEdit",strhospitalEdit);
        intent.putExtra("strcriticalEdit",strcriticalEdit);
        intent.putExtra("strSubLimitAmount",strSubLimitAmount);
        intent.putExtra("strDiscount",strDiscount);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("GST",GST);
        intent.putExtra("strProposerSpinner",strProposerSpinner);
        intent.putExtra("strContactNominee",strContactNominee);
        intent.putExtra("strNomineeName",strNomineeName);
        intent.putExtra("strbloodSugar",strbloodSugar);
        intent.putExtra("strbloodPressure",strbloodPressure);
        intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
        intent.putExtra("stredtcholesterol",stredtcholesterol);
        intent.putExtra("str_RelationEdit",str_RelationEdit);
        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
        intent.putExtra("strAddressLine1",strAddressLine1);
        intent.putExtra("strAddressLine2",strAddressLine2);
        intent.putExtra("strAddressLine3",strAddressLine3);
        intent.putExtra("strpincode",strpincode);
        intent.putExtra("strCityName",strCityName);
        intent.putExtra("strstateName",strstateName);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("strNominee_dob",strNominee_dob);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("str_life_style_spinner",str_life_style_spinner);
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("str_oneGenderSpinner",str_oneGenderSpinner);
        intent.putExtra("str_oneFtSpinner",str_oneFtSpinner);
        intent.putExtra("str_oneInchesSpinner",str_oneInchesSpinner);
        intent.putExtra("str_twoGenderSpinner",str_twoGenderSpinner);
        intent.putExtra("str_twoFtSpinner",str_twoFtSpinner);
        intent.putExtra("str_twoInchesSpinner",str_twoInchesSpinner);
        intent.putExtra("str_thirdGenderSpinner",str_thirdGenderSpinner);
        intent.putExtra("str_thirdFtSpinner",str_thirdFtSpinner);
        intent.putExtra("str_thirdInchesSpinner",str_thirdInchesSpinner);
        intent.putExtra("str_fourGenderSpinner",str_fourGenderSpinner);
        intent.putExtra("str_fourFtSpinner",str_fourFtSpinner);
        intent.putExtra("str_fourInchesSpinner",str_fourInchesSpinner);
        intent.putExtra("strOneChild",strOneChild);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
        intent.putExtra("str_policyTenure",str_policyTenure);
        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
        intent.putExtra("BMI",BMI);
        intent.putExtra("Individual_BMI",Individual_BMI);
        intent.putExtra("twoAdult_BMI",twoAdult_BMI);
        intent.putExtra("OneChildBMI",OneChildBMI);
        intent.putExtra("TwoChildBMI",TwoChildBMI);
        intent.putExtra("ThreeChildBMI",ThreeChildBMI);
        intent.putExtra("FourChildBMI",FourChildBMI);
        intent.putExtra("selectYearAdult",selectYearAdult);
        intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
        intent.putExtra("selectYearChild",selectYearChild);
        intent.putExtra("selectYearChildTwo",selectYearChildTwo);
        intent.putExtra("selectYearChildThird",selectYearChildThird);
        intent.putExtra("selectYearChildFour",selectYearChildFour);
        intent.putExtra("strParentEditText",strParentEditText);
        intent.putExtra("strMotherName",strMotherName);
        intent.putExtra("strMotherDob",strMotherDob);
        intent.putExtra("strMotherOccupationEdit",strMotherOccupationEdit);
        intent.putExtra("strMotherWeightEdit",strMotherWeightEdit);
        intent.putExtra("strFatherName",strFatherName);
        intent.putExtra("strFatherDob",strFatherDob);
        intent.putExtra("strFatherWeightEdit",strFatherWeightEdit);
        intent.putExtra("strFatherOccupationEdit",strFatherOccupationEdit);
        intent.putExtra("strMotherLawName",strMotherLawName);
        intent.putExtra("strMotherLawDob",strMotherLawDob);
        intent.putExtra("strMotherLawOccupationEdit",strMotherLawOccupationEdit);
        intent.putExtra("strMotherLawWeightEdit",strMotherLawWeightEdit);
        intent.putExtra("strFatherLawName",strFatherLawName);
        intent.putExtra("strFatherLawDob",strFatherLawDob);
        intent.putExtra("strFatherLawOccupationEdit",strFatherLawOccupationEdit);
        intent.putExtra("strFatherLawWeightEdit",strFatherLawWeightEdit);
        intent.putExtra("selectYearMother",selectYearMother);
        intent.putExtra("selectYearFather",selectYearFather);
        intent.putExtra("selectYearMotherLaw",selectYearMotherLaw);
        intent.putExtra("selectYearFatherLaw",selectYearFatherLaw);
        intent.putExtra("MotherBMI",MotherBMI);
        intent.putExtra("FatherBMI",FatherBMI);
        intent.putExtra("MotherLawBMI",MotherLawBMI);
        intent.putExtra("FatherLawBMI",FatherLawBMI);
        intent.putExtra("strMotherFtEdit",strMotherFtEdit);
        intent.putExtra("strMotherInchesEdit",strMotherInchesEdit);
        intent.putExtra("strFatherFtEdit",strFatherFtEdit);
        intent.putExtra("strFatherInchesEdit",strFatherInchesEdit);
        intent.putExtra("strMotherLawFtEdit",strMotherLawFtEdit);
        intent.putExtra("strMotherLawInchesEdit",strMotherLawInchesEdit);
        intent.putExtra("strFatherLawFtEdit",strFatherLawFtEdit);
        intent.putExtra("strFatherLawInchesEdit",strFatherLawInchesEdit);
        intent.putExtra("for","1");
        startActivity(intent);
        finish();
    }
}