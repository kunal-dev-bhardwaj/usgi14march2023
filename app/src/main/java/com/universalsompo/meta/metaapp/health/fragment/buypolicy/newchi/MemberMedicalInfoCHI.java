package com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.MedicalHistoryCompleteHealth;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Medical_Complete_health;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;

public class MemberMedicalInfoCHI extends AppCompatActivity {
    ImageView BackImg, SelfArrowImgMedical, SelfUpMedicalArrowImg, SpouseDownMemberArrowImg, SpouseUpMemberArrowImg, ChildOneDownArrow, ChildOneUpArrow, ChildTwoDownArrow, ChildTwoUpArrow, ChildThreeDownArrowImgMedical, ChildThreeUpArrowImgMedical, ChildFourDownImgMedical, ChildFourUpImgMedical, MotherDownImgMedical, MotherUpImgMedical, FatherDownArrowImgMedical, FatherUpArrowImgMedical, MotherLawDownImgMedical, MotherLawUpImgMedical, FatherLawDownImgMedical, FatherLawUpImgMedical;
    LinearLayout SmokeLinerMother,SpouseDurationSpinnerLiner,LinerSmokeTwoChild,SmokeChildFourLiner,FatherNarcoticDurationLiner,FatherNarcoticFrequencyLiner,FatherNarcoticLiner,DurationFatherTobaccoLiner,TypeFatherTobaccoLiner,SmokeFatherLiner,SmokeDurationFatherLiner,SmokeFrequencyFatherLiner,SmokeFatherQuantityLiner,SmokeTypeFatherLiner,DurationFatherLiner,TypeFatherLiner,MotherNarcoticLiner,ChildFourNarcoticLiner,ChildThirdNarcoticLiner,SmokeLinerThird,ChildTwoNarcoticDurationLiner,ChildTwoNarcoticFrequencyLinerSelf,ChildTwoFourNarcoticLiner,DurationSmokeTwoChild,SmokeLinerTwoChild,SmokeOccasinallyTwoChild,TypeSmokeTwoChild,DurationTobaccoTwoChild,TypeTobaccoTwoChild,DurationTwoChildLiner,TypeTwoChildLiner,ChildNarcoticLiner,ChildNarcoticFrequencyLiner,ChildNarcoticDurationLiner,TobaccoDurationLinerChildOne,TobaccoTypeLinerChildOne,SmokeChildOneDurationLiner,SmokeChildOneOccasionallyLiner,SmokeChildOneAlcoholLiner,TypeChildOneSmokeLiner,ChildOneSmokerLiner,TypeChildOneSpinnerLiner,ChildOneDurationSpinnerLiner,SpouseNarcoticLiner,TypeSpouseSpinnerLiner,SmokeSpouseAlcoholSpinnerLiner,TobaccoTypeLinerSpouse,TobaccoDurationLinerSpouse,SpouseNarcoticFrequencyLinerSelf,NarcoticDurationLinerSpouse,SmokeSpouseDurationSpinnerLiner,SpouseSmokerLiner,TypeSpouseSmokeSpinnerLiner,SmokeSpouseOccasionallySpinnerLiner,NarcoticFrequencyLinerSelf,NarcoticDurationLinerSelf,TobaccoTypeLinerSelf,TobaccoDurationLinerSelf,SelfSmokerLiner,TypeSmokeSpinnerLiner,SmokeOccasionallySpinnerLiner,SmokeAlcoholSpinnerLiner,SmokeDurationSpinnerLiner,FatherLiner, OccasionallyFatherTobaccoLiner, TobaccoFatherLiner, OccasionallyFatherSpinnerLiner, AlcoholSpinnerFatherLiner, MotherLiner, MotherOccasionallyTobaccoLiner, MotherTobaccoLiner, MotherAlcoholSpinnerLiner, MotherOccasionallySpinnerLiner, ConsumeAlcoholLinerMother, LinerFourChild, OccasionallyTobaccoLiner, ChildTwoLiner, ChildThreeLiner, TobaccoOccasinallyTwoChild, TobaccoLinerTwoChild, AlcoholTwoChildSpinnerLiner, OccasionallyTwoChildSpinnerLiner, LinerChildOneLiner, OccasionallySpinnerChildOneLiner, AlcoholSpinnerLinerChildOne, ConsumeTabaccoOccasinallyLinerChildOne, ConsumeTabaccoChildOneLiner, TobaccoLinerSpouse, SposeFreQuencyLiner, OccasionallySpinnerSpouseLiner, TobaccoOccasinallyLinerSpouse, SpouseLiner, TypeSpinnerLiner,AlcoholDurationSpinnerLiner,OccasionallySelfDropDownLiner, linerAdult, DiseaseSelfLiner, AlcoholSelfDropDownLiner, AlcoholSpinnerLiner, TobaccoSelfSpinnerLiner, TobaccoLinerSelf, TobaccoOccasinallyLinerSelf, SelfConsumeAlcoholLiner, SelfConsumeTobaccoLiner, SelfNarcoticLiner,adultTwoLiner, SpouseMainDiseaseLiner, LinerConsumeAlcohol, LinerConsumeTobacco, ChildOneLiner, ConsumeSpinnerLiner, ChildOneConsumeAlcoholLiner, ConsumeTabaccoLinerChildOne, DiseaseLinerChildOne, ChildTwoLinerMedical, ChildTwoDiseaseLiner, AlcoholLinerChildTwo, LinerTobaccoTwoChild, thirdChildLiner, DiseaseLinerChildThird, ConsumeAlcoholThirdChildLiner, ConsumeTobaccoLiner, FourChildTwoLiner, DiseaseLinerChildFour, ConsumeAlcoholChildFourLiner, ConsumeTobaccoChildFourLiner, MotherMainLiner, MotherDiseaseLiner,
            MotherAlcoholLiner, ConsumeTobaccoLinerMother, FatherMainLiner, FatherDiseaseLiner, ConsumeAlcoholFatherLiner, ConsumeTobaccoFatherLiner, MatherLawMainLiner, MotherLawDiseaseLiner, ConsumeAlcoholMotherLaw, ConsumeTobaccoMotherLawLiner, FatherLawTwoLiner, DiseaseLinerFatherLaw, ConsumeAlcoholFatherLawLiner, ConsumeTobaccoFatherLawLiner;
    RadioButton YesFatherNarcoticRadio,NoFatherNarcoticRadio,YesMotherNarcoticRadio,NoMotherNarcoticRadio,YesChildFourNarcoticRadio,NoChildFourNarcoticRadio,YesChildThirdNarcoticRadio,NoChildThirdNarcoticRadio,YesChildTwoNarcoticRadio,NoChildTwoNarcoticRadio,YesChildNarcoticRadio,NoChildNarcoticRadio,YesSpouseNarcoticRadio,NoSpouseNarcoticRadio,YesSmokerFatherRadio,YesPersonFatherRadio,NoPersonFatherRadio,NoSmokerFatherRadio,YesPersonMotherRadio,YesSmokerMotherRadio,NoSmokerMotherRadio,NoPersonMotherRadio,YesSmokerChildFourRadio,NoPersonChildFourRadio,YesPersonChildFourRadio,NoSmokerChildFourRadio,YesSmokerChildThirdRadio,NoSmokerChildThirdRadio,YesPersonThirdChildRadio,NoPersonThirdChildRadio,YesPersonChildTwoRadio,NoPersonChildTwoRadio,YesSmokerChildTwoRadio,NoSmokerChildTwoRadio,YesSmokerChildRadio,NoSmokerChildRadio,YesPersonChildRadio,NoPersonChildRadio,YesPersonSpouseRadio,NoPersonSpouseRadio,YesSmokerSpouseRadio,NoSmokerSpouseRadio,YesSmokerRadio,NoSmokerRadio,YesPersonRadio,NoPersonRadio,YesPreExistingMotherRadio, NoPreExistingMotherRadio, YesMedicineThirdChildRadio, NoMedicineThirdChildRadio, YesPreExistingThirdChildRadio, NoPreExistingThirdChildRadio, YesChildTwoHistoryRadio, NoChildTwoHistoryRadio, YesChildTwoPreExistingRadio, NoChildTwoPreExistingRadio, NoMedicineChildOneRadio, YesMedicineChildOneRadio, YesPreExistingChildOneRadio, YesHospitalizationHistoryRadio, NoPreExistingChildOneRadio, NoHospitalizationHistoryRadio, YesMedicineRadio, NoMedicineRadio, YesMedicalHistoryRadio, NoMedicalHistoryRadio, YesPhysicalMentalRadio, NoPhysicalMentalRadio, YesPreExistingRadio, NoPreExistingRadio, YesAlcoholRadio, NoAlcoholRadio, YesTobaccoRadio, NoTobaccoRadio, YesNarcoticRadio,NoNarcoticRadio,SpouseYesPhysicalRadio, SpouseNoPhysicalRadio, YesDiseaseSpouseRadio, NoDiseaseSpouseRadio, YesConsumeAlcoholRadio, NoConsumeAlcoholRadio, YesSpouseTobaccoRadio, NoSpouseTobaccoRadio,
            YesChildOnePhysicalRadio, NoChildOnePhysicalRadio, YesChildOnePreExistingRadio, NoChildOnePreExistingRadio, YesChildOneConsumeAlcoholRadio, NoChildOneConsumeAlcoholRadio, YesConsumeTobaccoChildOneRadio, NoConsumeTobaccoChildOneRadio, YesChildTwoPhysicalRadio, NoChildTwoPhysicalRadio, YesChildTwoPreDisease, NoChildTwoPreDisease, YesChildTwoAlcoholRadio, NoChildTwoAlcoholRadio, YesTobaccoChildTwoRadio, NoTobaccoChildTwoRadio,
            YesPhysicalChildThirdRadio, NoPhysicalChildThirdRadio, YesDiseaseChildThird, NoDiseaseChildThird, YesAlcoholRadioThirdChild, NoAlcoholRadioThirdChild, YesTobaccoThirdChild, NoTobaccoThirdChild, YesPhysicalChildFourRadio, NoPhysicalChildFourRadio, YesDiseaseChildFourRadio, NoDiseaseChildFourRadio, YesConsumeAlcoholFourChild, NoConsumeAlcoholFourChild, YesConsumeTobaccoChildFour, NoConsumeTobaccoChildFour, YesMotherPhysical, NoMotherPhysical, YesDiseaseMother, NoDiseaseMother, YesConsumeAlcoholMother, NoConsumeAlcoholMother, YesConsumeTobaccoMother, NoConsumeTobaccoMother, YesFatherPhysical, NoFatherPhysical, YesDiseaseFather, NoDiseaseFather, YesConsumeAlcoholFather, NoConsumeAlcoholFather, YesConsumeTobaccoFather, NoConsumeTobaccoFather, YesMotherLawPhysical, NoMotherLawPhysical, YesDiseaseMotherLaw, NoDiseaseMotherLaw, YesConsumeAlcoholMotherLaw, NoConsumeAlcoholMotherLaw, YesConsumeTobaccoMotherLaw, NoConsumeTobaccoMotherLaw, YesPhysicalFatherLaw, NoPhysicalFatherLaw, YesDiseaseFatherLaw, NoDiseaseFatherLaw, YesConsumeAlcoholFatherLaw, NoConsumeAlcoholFatherLaw, YesConsumeTobaccoFatherLaw, NoConsumeTobaccoFatherLaw;
    EditText PersonEditFather,TreatmentHistoryEditFather,MedicalTreatmentEditFather,MedicalEditFather,IllnessEditFather,FatherNarcoticDurationEdit,FatherNarcoticEdit,DurationFatherTobaccoEdit,TypeFatherTobaccoEdit,SmokeDurationFatherEdit,SmokeFrequencyFatherEdit,SmokeQuantityFatherEdit,SmokeTypeFatherEdit,DurationFatherEdit,TypeFatherEdit,PersonEditMother,MedicalTreatmentEditMother,MedicalEditMother,MedicalHealthEditMother,IllnessEditMother,MotherNarcoticDurationEdit,MotherNarcoticEdit,MotherDurationSmokeEdit,MotherSmokeEditFrequency,MotherOccasionallySmokeEdit,MotherTypeSmokeEdit,MotherDurationTobaccoEdit,MotherTypeTobaccoEdit,MotherDurationEdit,MotherTypeEdit,PersonEditChild4,HospitalizedEditChild4,MedicalTreatmentEditChild4,MedicalEditChild4,IllnessEditChild4,ChildFourNarcoticDurationEdit,ChildFourNarcoticEdit,DurationSmokeEditChild4,SmokeEditFrequencyChild4,SmokeQuantityEdit,SmokeTypeEditChild4,DurationTobaccoEditChild4,TypeTobaccoEditChild4,DurationAlcoholEditChild4,TypeAlcoholEditChild4,PersonEditChild3,HospitizationTreatmentEditChild3,MedicalTreatmentEditChild3,MedicalEditChild3,IllnessEditChild3,ChildThirdNarcoticDurationEdit,ChildThirdNarcoticEdit,DurationTobaccoEditThirdChild,TypeTobaccoEditThirdChild,DurationSmokeEditThirdChild,FrequencySmokeEditThirdChild,QuantitySmokeEditThirdChild,TypeSmokeEditThirdChild,DurationEditThirdChild,TypeEditThirdChild,PersonEditChildTwo,HospitalizedEditChildTwo,TreatmentEditChildTwo,MedicineEditChildTwo,IllnessEditChildTwo,ChildTwoNarcoticDurationEdit,ChildTwoNarcoticEditSelf,DurationSmokeEditTwoChild,SmokeEditTwoChild,SmokeOccasinallyEditTwoChild,TypeSmokeEditTwoChild,DurationTobaccoEditTwoChild,TypeTobaccoEditTwoChild,DurationTwoChildEdit,TypeTwoChildEdit,ChildNarcoticDurationEdit,ChildNarcoticEdit,TobaccoDurationEditChild1,TobaccoTypeEditChildOne,SmokeChildOneDurationEdit,SmokeChildOneAlcoholEdit,SmokeChildOneOccasionallyEdit,TypeChildOneSmokeEdit,TypeChildOneEditSpinner,ChildOneDurationEditSpinner,PersonEditChildOne,PreExistingEditChildOne,DiseaseEditChildOne,PhysicalEditChildOne,IllnessEditChildOne,PersonEditSpouse,HospitalizationEditSpouse,DiseaseEditSpouse,PhysicalEditSpouse,IllnessEditSpouse,NarcoticDurationEditSpouse,NarcoticEditSpouse,TobaccoDurationEditSpouse,TobaccoTypeEditSpouse,SpouseDurationEditSpinner,TypeSpouseEditSpinner,SmokeSpouseDurationEditSpinner,SmokeSpouseAlcoholEditSpinner,TypeSpouseSmokeEditSpinner,SmokeSpouseOccasionallyEditSpinner,MedicalProfessionalEditSelf,MedicalTreatmentEditSelf,MedicalHistoryEditSelf,PersonEditSelf,IllnessEditSelf,NarcoticEditSelf,NarcoticDurationEditSelf,TobaccoDurationEditSelf,TobaccoTypeEditSelf,SmokeAlcoholEditSpinner,SmokeDurationEditSpinner,SmokeOccasionallyEditSpinner,TypeSmokeEditSpinner,TypeEditSpinner,AlcoholDurationEditSpinner,OccasionallyFatherTobaccoSpinner, TobaccoFatherSpinner, OccasionallyFatherEditSpinner, AlcoholEditFatherSpinner, MotherOccasionallyTobaccoSpinner, MotherTobaccoEditSpinner, MotherOccasionallyEditSpinner, MotherAlcoholEditSpinner, OccasionallyLiterSpinner, AlcoholEditFrequency, OccasionallyTobaccoSpinner, TobaccoEditFrequency, OccasionallyEditThirdChild, AlcoholEditThirdChild, OccasionallyEditSpinnerThirdChild, AlcoholEditSpinnerThirdChild, TobaccoOccasinallyEditTwoChild, TobaccoEditTwoChild, AlcoholTwoChildEditSpinner, OccasionallyTwoChildEditSpinner, ConsumeTabaccoChildOneSpinner, ConsumeTabaccoChildOne, OccasionallyEditChildOneSpinner, AlcoholEditSpinnerChildOne, TobaccoOccasinallyEditSpouse, TobaccoEditSpouse, OccasionallySpouseEditSpinner, SpouseEditFrequency, PreExistingDiseaseEdit, TobaccoOccasinallyEditSelf, bloodSugar, bloodPressure, bloodPressureDiastolic, cholesterol, AlcoholEditSpinner, OccasionallyEditSpinner, TobaccoEditSelf, bloodSugarAdultTwo, bloodPressureAdultTwo, bloodPressureDiastolicAdultTwo, cholesterolAdultTwo, bloodSugarChildOne, bloodPressureChildOne, bloodPressureDiastolicChildOne, cholesterolChildOne, bloodSugarChildTwo, bloodPressureChildTwo, bloodPressureDiastolicChildTwo, cholesterolChildTwo, bloodSugarThirdChild, bloodPressureThirdChild, bloodPressureDiastolicThirdChild, cholesterolThirdChild, bloodSugarFourChild, bloodPressureFourChild, bloodPressureDiastolicFourChild, cholesterolFourChild, bloodSugarMother, bloodPressureMother, bloodPressureDiastolicMother, cholesterolMother, bloodSugarFather, bloodPressureFather, bloodPressureDiastolicFather, cholesterolFather, bloodSugarMatherLaw, bloodPressureMatherLaw, bloodPressureDiastolicMatherLaw, cholesterolMatherLaw, bloodSugarFatherLaw, bloodPressureFatherLaw, bloodPressureDiastolicFatherLaw, cholesterolFatherLaw;
    String strIDTypeName,strDob,permAndCorresAddSame,firstName, middleName,lastName,ckycNo,uniqueTransactionNumber,address1,address2,address3,corresAddress1,corresAddress2,corresAddress3,SterilityInfertilityMale,MaternityAndChildcareMale,strNomineeGenderEdit,strPersonEditFather,strTreatmentHistoryEditFather,strMedicalTreatmentEditFather,strMedicalEditFather,strIllnessEditFather,strFatherNarcoticDurationEdit,strFatherNarcoticEdit,strFatherNarcotic,strDurationFatherTobaccoEdit,strTypeFatherTobaccoEdit,strSmokeDurationFatherEdit,strSmokeFrequencyFatherEdit,strSmokeQuantityFatherEdit,strSmokeTypeFatherEdit,strDurationFatherEdit,strTypeFatherEdit,strPersonEditMother,strMedicalTreatmentEditMother,strMedicalEditMother,strMedicalHealthEditMother,strIllnessEditMother,strMotherNarcoticDurationEdit,strMotherNarcoticEdit,strMotherNarcotic,strMotherDurationSmokeEdit,strMotherSmokeEditFrequency,strMotherOccasionallySmokeEdit,strMotherTypeSmokeEdit,strMotherDurationTobaccoEdit,strMotherTypeTobaccoEdit,strMotherDurationEdit,strMotherTypeEdit,strPersonEditChild4,strHospitalizedEditChild4,strMedicalTreatmentEditChild4,strMedicalEditChild4,strIllnessEditChild4,strChildFourNarcoticDurationEdit,strChildFourNarcoticEdit,strDurationSmokeEditChild4,strSmokeEditFrequencyChild4,strSmokeQuantityEdit,strSmokeTypeEditChild4,strDurationTobaccoEditChild4,strTypeTobaccoEditChild4,strDurationAlcoholEditChild4,strTypeAlcoholEditChild4,strPersonEditChild3,strHospitizationTreatmentEditChild3,strMedicalTreatmentEditChild3,strMedicalEditChild3,strIllnessEditChild3,strChildThirdNarcoticDurationEdit,strChildThirdNarcoticEdit,strChildThirdNarcotic,strDurationTobaccoEditThirdChild,strTypeTobaccoEditThirdChild,strDurationSmokeEditThirdChild,strFrequencySmokeEditThirdChild,strQuantitySmokeEditThirdChild,strTypeSmokeEditThirdChild,strDurationEditThirdChild,strTypeEditThirdChild,strPersonEditChildTwo,strHospitalizedEditChildTwo,strTreatmentEditChildTwo,strMedicineEditChildTwo,strIllnessEditChildTwo,strChildTwoNarcoticDurationEdit,strChildTwoNarcoticEditSelf,strChildTwoNarcotic,strDurationSmokeEditTwoChild,strSmokeEditTwoChild,strSmokeOccasinallyEditTwoChild,strTypeSmokeEditTwoChild,strDurationTobaccoEditTwoChild,strTypeTobaccoEditTwoChild,strDurationTwoChildEdit,strTypeTwoChildEdit,strChildNarcoticDurationEdit,strChildNarcoticEdit,strChildNarcotic,strTobaccoDurationEditChild1,strTobaccoTypeEditChildOne,strSmokeChildOneDurationEdit,strSmokeChildOneAlcoholEdit,strSmokeChildOneOccasionallyEdit,strTypeChildOneSmokeEdit,strTypeChildOneEditSpinner,strChildOneDurationEditSpinner,strPersonEditChildOne,strPreExistingEditChildOne,strDiseaseEditChildOne,strPhysicalEditChildOne,strIllnessEditChildOne,strPersonEditSpouse,strIllnessEditSpouse,strPhysicalEditSpouse,strDiseaseEditSpouse,strHospitalizationEditSpouse,strNarcoticDurationEditSpouse,strNarcoticEditSpouse,strTobaccoDurationEditSpouse,strTobaccoTypeEditSpouse,strSpouseDurationEditSpinner,strTypeSpouseEditSpinner,strSmokeSpouseDurationEditSpinner,strSmokeSpouseAlcoholEditSpinner,strTypeSpouseSmokeEditSpinner,strSmokeSpouseOccasionallyEditSpinner,strMedicalProfessionalEditSelf,strMedicalTreatmentEditSelf,strMedicalHistoryEditSelf,strPersonEditSelf,strIllnessEditSelf,strNarcoticEditSelf,strNarcoticDurationEditSelf,strNarcoticRadio,strTobaccoDurationEditSelf,strTobaccoTypeEditSelf,strSmokeAlcoholEditSpinner,strTypeEditSpinner,strSmokeOccasionallyEditSpinner,strTypeSmokeEditSpinner,strSmokeDurationEditSpinner,strAlcoholDurationEditSpinner,strPersonFather,strSmokerFather,strPersonMotherRadio,strSmokerMotherRadio,TreatmentCheckBoxCheck,strBasicPremium,GSt,strDiseaseMother, strPreExistingMother, strTobaccoEditFrequency, strPreExistingThirdChild, strChildTwoPreExisting, strCoPaymentEditText, strSubLimitEditText, SubCategoryDiscountStatusCheck = "", CoPaymentCheckBoxCheck = "", checkPackage, strAppointeeNomineeName, strAppointeeNomineeDobEdit, strAppointeeGenderEdit, OrganDiscountStatus, PersonalStatusChildOne, PersonalStatusChildTwo, PersonalStatusChildThird, PersonalStatusChildFour, PersonalAccidentCategory, strPackage1 = "", strPackageTwo = "", strPackageThree = "", strPackageFour = "", strPackageFive = "", strPackageSix = "", str_age, DirectPolicyDiscountPremium, LongTermDiscountStatus, SubCategoryDiscountStatus, SubCategory, strRelationFourChildEdit, strRelationChildThreeEdit, strRelationChildTwoEdit, strRelationChildEdit, strGenderChildOneEdit, strChildOneNameEdit, strRelationEditSpouse, strSpouseOccupationEdit, strSpouseNameEditText = "", strSpouseGenderEdit, strFtSpouseEdit, strInchesSpouseEdit, strWeightEditSpouse, strSpouseBMIEdit,
            strBMIChildEdit, strSecondChildNameEdit, str_twoGenderSpinner, str_twoFtSpinner, str_twoInchesSpinner, strtwoWeightEdit, str_oneFtSpinner, str_oneInchesSpinner, str_oneWeightEdit, strOccupationEditChildOne, str_twoOccupationSpinner, str_thirdOccupationSpinner, str_fourOccupationSpinner, strMotherFeetEditText, strInchesMotherEdit, strMotherRelationShipEdit = "", strMotherWeightEdit = "", strMotherOccupationEdit = "", strMotherEditTextName = "", strMotherGenderEdit = "", strFatherOccupationEdit = "", strOccupationEditMotherLaw = "", strBMIMotherEdit = "", strFatherEditTextName = "", strFatherGenderEditTet = "", strRelationFatherEdit = "", strFatherWeightEdit = "", strFeetFatherEdit = "", strInchesFatherEdit = "", strBMIFatherEdit = "", strMotherLawEditText = "", strRelationMotherLawEdit = "", strWeightMotherLawEdit = "", strFeetEditTextMotherLaw = "", strInchesEditTextMotherLaw = "", strBMIMotherLawEdit = "", strFatherLawNameEdit = "", strFatherLawGenderEditText = "", strOccupationFatherLawEdit = "", strRelationEditTextFatherLaw = "", strFatherLawWeightEdit = "", strEditFeetFatherLaw = "", strEditInchesFatherLaw = "", strFatherLawBMIEdit = "", FamilyComposition = "", ParentComposition = "",
            strBMIChildTwoEdit, strThirdChildNameEdit, str_thirdGenderSpinner, str_thirdFtSpinner, str_thirdInchesSpinner, str_thirdWeightEdit, strBMIEChildThreeEdit,
            strFourChildNameEdit, str_fourGenderSpinner, str_fourFtSpinner, str_fourInchesSpinner, strFourWeightEdit, strBMIFourChildEdit, strCheckBoxSelf, strTobaccoOccasinallyEditSelf = "", str_edt_name = "", str_edt_phone = "", str_email = "", strPackageOne = "", PosPolicyNo = "", str_policyType_spinner = "", strSelfAgeEditText = "", str_IndividualTypeEdit = "", strTotalPremium = "", strYesPhysicalMentalRadio = "", strYesPreExistingRadio = "", strSelfAlcoholRadio = "", strSelfTobaccoRadio = "", strSpousePhysicalRadio = "", strDiseaseSpouseRadio = "", strConsumeSpouseAlcohol = "", strSpouseTobaccoRadio = "", strChildOnePhysicalRadio = "", strChildOnePreExisting = "", strChildOneConsumeAlcoholRadio = "", strConsumeTobaccoChildOneRadio = "", strChildTwoPhysicalRadio = "", strChildTwoPreDisease = "", strChildTwoAlcoholRadio = "", strTobaccoChildTwoRadio = "", strPhysicalChildThirdRadio = "", strDiseaseChildThird = "", strAlcoholRadioThirdChild = "", strTobaccoThirdChild = "", strPhysicalChildFourRadio = "", strDiseaseChildFourRadio = "", strMotherPhysical = "",
            strConsumeAlcoholMother = "", strConsumeTobaccoMother = "", strFatherPhysical = "", strDiseaseFather = "", strConsumeAlcoholFather = "", strConsumeTobaccoFather = "", strMotherLawPhysical = "", strDiseaseMotherLaw = "", strConsumeAlcoholMotherLaw = "", strConsumeTobaccoMotherLaw = "", strPhysicalFatherLaw = "", strDiseaseFatherLaw = "", strConsumeAlcoholFatherLaw = "", strConsumeTobaccoFatherLaw = "", strAlcoholEditSpinner = "", strOccasionallyEditSpinner = "", strTobaccoEditSelf = "";
    LinearLayout MotherNarcoticDurationLiner,MotherNarcoticFrequencyLiner,MotherDurationSmokeLiner,MotherSmokeLinerFrequency,MotherOccasionallySmokeLiner,MotherTypeSmokeLiner,MotherDurationTobaccoLiner,MotherTypeTobaccoLiner,MotherTypeLiner,MotherDurationLiner,ChildFourNarcoticDurationLiner,ChildFourNarcoticFrequencyLiner,DurationSmokeLinerChild4,SmokeFrequencyLinerChild4,SmokeQuantityLiterLiner,SmokeTypeLinerChild4,DurationTobaccoLinerChild4,TypeTobaccoLinerChild4,TypeAlcoholLinerChild4,DurationAlcoholLinerChild4,ChildThirdNarcoticDurationLiner,ChildThirdNarcoticFrequencyLiner,DurationTobaccoThirdChild,TypeTobaccoThirdChild,DurationSmokeThirdChildLiner,FrequencySmokeThirdChildLiner,QuantitySmokeThirdChildLiner,TypeSmokeThirdChildLiner,TypeLinerThirdChild,DurationLinerThirdChild,OccasionallyLiterLiner, AlcoholFrequencyLiner, TobaccoFrequencyLiner, OccasionallyThirdChild, AlcoholThirdChildSpinnerLiner, OccasionallySpinnerLinerThirdChild, AlcoholSpinnerLinerThirdChild, continueButton, PreExistingDiseaseLiner, PreExistingDiseaseDropDownLiner;
    TextView TotalPremiumTxt, ViewDetails,MotherTxt,FatherTxt,InsuredTxt;
    String PersonalAccidentCoverPremium, CriticalIllnessCoverPremium = "", DailyHospitalCoverPremium = "", ModernTreatmentCoverPremium = "", ExtensionPreHospitalizationCoverPremium = "", ExtensionProHospitalizationCoverPremium = "", MaternityChildcareCoverPremium = "", CoverageNonMedicalCoverPremium = "", ConditionWaiverCoverPremium = "", PreExistingDiseaseCoverPremium = "", OutpatientDentalCoverPremium = "", EmergencyTravellingCoverPremium = "", SecondOpinionCoverPremium = "", RestCureCoverPremium = "", ObesityWeightCoverPremium = "", SterilityInfertilityCoverPremium = "", EnhancedCoverPremium = "", PremiumWaiverCoverPremium = "", GlobalCoverCoverPremium = "", MedicallyAdvisedCoverPremium = "", EmergencyAssistanceCoverPremium = "", HomeCareCoverPremium = "", WellnessBenefitCoverPremium = "", DiseaseManagementCoverPremium = "";
    String strProposerBMIEdit, strWeightEditProposer, strProposerEdtName, strProposerEditDob, strProposerEditFt, strProposerEditInches, strEditGenderProposer, strEditOccupationProposer, strProposerRelationEdit, yearRadio, strPreExistingDiseaseEdit = "", MaternityAndChildcareAddOn, strPolicyTenure = "", PlanType = "", strSumInsured = "", strPlanTypeTXT = "", NetPremium = "", strEdtNameSelf = "", strEmailIDEditSelf = "", strEditGenderSelf = "", strEditOccupationSelf = "", strPinCodeEdit = "", strPermanentAddressEdit2 = "", strPermanentAddressEdit = "", strStateEdit = "", strCityEdit = "", strRelationAdultOneEdit = "", strEditInchesSelf = "", strEditFtSelf = "", strWeightEditSelf = "", strBMIEdit = "", strNomineeRelationEdit = "", strNomineeName = "", strContactNominee = "", strNomineeDobEdit = "", strBloodSugar = "", strBloodPressure = "", strBloodPressureDiastolic = "", strcholesterol = "";
    String strPersonRadio,strSmokerRadio,strHospitalizationHistory, strMedicineRadio, strMedicalHistoryRadio, strswitch = "", strCorrespondenceAddressEdit = "", strCorrespondenceAddressEdit2 = "", EmergencyTravellingStatus = "", strPolicyNumber = "", CoPaymentLoading = "", BasicStatus = "", PersonalStatus = "", CriticalStatus = "", DailyHospitalSatus = "", ModernTreatmentsStatus = "", ExtensionPreHospitalization = "", ExtensionPr0Hospitalization = "", MaternityAndChildcare = "", CoverageNonMedical = "", ConditionWaiverStatus = "", PersonalAccidentACoverStatus = "", PersonalAccidentBCoverStatus = "", PreExistingDiseaseStatus = "", OutpatientDentalStatus = "", SecondOpinionStatus = "", RestCureStatus = "", ObesityWeightStatus = "", SterilityInfertilityStatus = "", EnhancedOrganStatus = "", GlobalCoverStatus = "", MedicallyAdvisedStatus = "", EmergencyAssistanceStatus = "", HomeCareStatus = "", WellnessBenefitStatus = "", DiseaseManagementStatus = "", LoyaltyDiscountStatus = "", CoPaymentStatus = "", PremiumWaiverStatus = "", strGenderSpinner = "", strCheckBoxSpouse = "", strSpouseAgeEditText = "", strCheckBoxMother = "", strMotherAgeEditText = "", strFatherAgeEditText = "", strCheckBoxFather = "", strCheckBoxMotherLaw = "", strMotherLawAgeEditText = "", strCheckBoxFatherLaw = "", strFatherLawAgeEditText = "", strFirstSonAgeEditText = "", strSecondSonAgeEditText = "", strThirdSonAgeEditText = "", strFourSonAgeEditText = "", strCheckBoxSon = "", strFor = "", strSpouseDobEdit = "";
    int addons,selectYearAdult, selectYearMotherAdult, selectMotherLawAdult, selectFatherLawAdult, selectYearFatherAdult, selectYearSecondAdult, mCounter = 0, FamilyTypeCounter, selectNomineeYear, selectFirstYearChild, selectSecSonChild, selectThirdSonChild, selectYearChildFour;
    double Discounts, LongTermDiscountDiscountPremium, SubCategoryDiscountPremium, doubleCoPaymentDiscountPremium, OrganDonorDiscountPremium;
    RadioButton YesFatherHistoryRadio, NoFatherHistoryRadio, YesPreExistingFatherRadio, NoPreExistingFatherRadio, YesMotherHistoryRadio, NoMotherHistoryRadio, YesHistoryFourChildRadio, NoHistoryFourChildRadio, NoPreExistingFourChildRadio, YesPreExistingFourChildRadio, YesRadioSufferingDiseaseSecondAdult, NoRadioSufferingDiseaseSecondAdult, YesHospitalizationHistoryAdultSecondRadio, NoHospitalizationHistoryAdultSecondRadio;
    String TreatmentStatus,strChildFourNarcotic,strSpouseNarcoticRadio,strSmokerChildFourChild,strPersonChildFourChild,strPersonChildTwo,strPersonChildThird,strSmokerChildThird,strSmokerChildTwo,strPersonChildRadio,strSmokerChildRadio,strSmokerSpouseRadio,strPersonSpouseRadio,strConsumeTobacco, strMotherHistoryRadio, strAlcoholEditFrequency, strOccasionallyTobaccoSpinner, strConsumeAlcoholFourChild, strHistoryFourChild, strSufferingDiseaseSecondAdult, strHospitalizationHistoryAdultSecond, strSpouseEditFrequency, strOccasionallySpouseEditSpinner, strTobaccoEditSpouse, strTobaccoOccasinallyEditSpouse, strPreExistingChildOneRadio, strMedicineChildOneRadio, strAlcoholEditSpinnerChildOne, strOccasionallyEditChildOneSpinner, strConsumeTabaccoChildOne, strConsumeTabaccoChildOneSpinner, strChildTwoHistory, strAlcoholTwoChildEditSpinner, strOccasionallyTwoChildEditSpinner, strTobaccoEditTwoChild, strTobaccoOccasinallyEditTwoChild, strMedicineThirdChildRadio, strAlcoholEditSpinnerThirdChild, strOccasionallyEditSpinnerThirdChild, strAlcoholEditThirdChild, strOccasionallyEditThirdChild, strPreExistingFourChild, strOccasionallyLiterSpinner,
            strMotherAlcoholEditSpinner, strMotherOccasionallyEditSpinner, strMotherTobaccoEditSpinner, strMotherOccasionallyTobaccoSpinner, strPreExistingFather, strFatherHistory, strAlcoholEditFatherSpinner, strOccasionallyFatherEditSpinner, strTobaccoFatherSpinner, strOccasionallyFatherTobaccoSpinner;
    int  selectYearProposer,DirectPolicy, loyalityDiscount, TiresDiscount, copayemntMax;
    double OrganDonar, sublimt,LongTerm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_medical_info_chi);
        getWindow().setStatusBarColor(ContextCompat.getColor(MemberMedicalInfoCHI.this, R.color.colorPrimaryDark));
        str_edt_name = getIntent().getStringExtra("str_edt_name");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        TreatmentCheckBoxCheck = getIntent().getStringExtra("TreatmentCheckBoxCheck");
        str_email = getIntent().getStringExtra("str_email");
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
        strBasicPremium = getIntent().getStringExtra("strBasicPremium");
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
        TreatmentStatus = getIntent().getStringExtra("TreatmentStatus");
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
        MaternityAndChildcareAddOn = getIntent().getStringExtra("MaternityAndChildcareAddOn");
        strFor = getIntent().getStringExtra("strFor");
        strBasicPremium = getIntent().getStringExtra("strBasicPremium");
        strPackageOne = getIntent().getStringExtra("strPackageOne");
        Discounts = getIntent().getDoubleExtra("Discounts", 0.0);
        LongTermDiscountDiscountPremium = getIntent().getDoubleExtra("LongTermDiscountDiscountPremium", 0.0);
        SubCategoryDiscountPremium = getIntent().getDoubleExtra("SubCategoryDiscountPremium", 0.0);
        doubleCoPaymentDiscountPremium = getIntent().getDoubleExtra("doubleCoPaymentDiscountPremium", 0.0);
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
        strNomineeGenderEdit = getIntent().getStringExtra("strNomineeGenderEdit");
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
        DirectPolicyDiscountPremium = getIntent().getStringExtra("DirectPolicyDiscountPremium");
        SubCategory = getIntent().getStringExtra("SubCategory");
        mCounter = getIntent().getIntExtra("mCounter", 0);
        addons = getIntent().getIntExtra("addons", 0);
        FamilyTypeCounter = getIntent().getIntExtra("FamilyTypeCounter", 0);
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
        FamilyComposition = getIntent().getStringExtra("FamilyComposition");
        ParentComposition = getIntent().getStringExtra("ParentComposition");
        str_age = getIntent().getStringExtra("str_age");
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
        PersonalStatusChildTwo = getIntent().getStringExtra("PersonalStatusChildTwo");
        PersonalStatusChildFour = getIntent().getStringExtra("PersonalStatusChildFour");
        PersonalStatusChildThird = getIntent().getStringExtra("PersonalStatusChildThird");
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
        strMedicalHistoryRadio = getIntent().getStringExtra("strMedicalHistoryRadio");
        strPersonRadio = getIntent().getStringExtra("strPersonRadio");
        strSmokerRadio = getIntent().getStringExtra("strSmokerRadio");
        strMedicineRadio = getIntent().getStringExtra("strMedicineRadio");
        strHospitalizationHistory = getIntent().getStringExtra("strHospitalizationHistory");
        checkPackage = getIntent().getStringExtra("checkPackage");
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
        strPreExistingThirdChild = getIntent().getStringExtra("strPreExistingThirdChild");
        strMedicineThirdChildRadio = getIntent().getStringExtra("strMedicineThirdChildRadio");
        strPhysicalChildThirdRadio = getIntent().getStringExtra("strPhysicalChildThirdRadio");
        strDiseaseChildThird = getIntent().getStringExtra("strDiseaseChildThird");
        strAlcoholEditSpinnerThirdChild = getIntent().getStringExtra("strAlcoholEditSpinnerThirdChild");
        strOccasionallyEditThirdChild = getIntent().getStringExtra("strOccasionallyEditThirdChild");
        strPreExistingFourChild = getIntent().getStringExtra("strPreExistingFourChild");

        strPreExistingChildOneRadio = getIntent().getStringExtra("strPreExistingChildOneRadio");
        strChildOnePhysicalRadio = getIntent().getStringExtra("strChildOnePhysicalRadio");
        strMedicineChildOneRadio = getIntent().getStringExtra("strMedicineChildOneRadio");
        strChildOnePreExisting = getIntent().getStringExtra("strChildOnePreExisting");
        strChildOneConsumeAlcoholRadio = getIntent().getStringExtra("strChildOneConsumeAlcoholRadio");
        strAlcoholEditSpinnerChildOne = getIntent().getStringExtra("strAlcoholEditSpinnerChildOne");
        strOccasionallyEditChildOneSpinner = getIntent().getStringExtra("strOccasionallyEditChildOneSpinner");
        strConsumeTabaccoChildOne = getIntent().getStringExtra("strConsumeTabaccoChildOne");
        strConsumeTabaccoChildOneSpinner = getIntent().getStringExtra("strConsumeTabaccoChildOneSpinner");
        strChildTwoPreExisting = getIntent().getStringExtra("strChildTwoPreExisting");
        strChildTwoPhysicalRadio = getIntent().getStringExtra("strChildTwoPhysicalRadio");
        strChildTwoPreDisease = getIntent().getStringExtra("strChildTwoPreDisease");
        strChildTwoHistory = getIntent().getStringExtra("strChildTwoHistory");
        strAlcoholTwoChildEditSpinner = getIntent().getStringExtra("strAlcoholTwoChildEditSpinner");
        strOccasionallyTwoChildEditSpinner = getIntent().getStringExtra("strOccasionallyTwoChildEditSpinner");
        strTobaccoEditTwoChild = getIntent().getStringExtra("strTobaccoEditTwoChild");
        strTobaccoOccasinallyEditTwoChild = getIntent().getStringExtra("strTobaccoOccasinallyEditTwoChild");
        strOccasionallyEditSpinnerThirdChild = getIntent().getStringExtra("strOccasionallyEditSpinnerThirdChild");
        strAlcoholEditThirdChild = getIntent().getStringExtra("strAlcoholEditThirdChild");
        strPhysicalChildFourRadio = getIntent().getStringExtra("strPhysicalChildFourRadio");
        strDiseaseChildFourRadio = getIntent().getStringExtra("strDiseaseChildFourRadio");
        strHistoryFourChild = getIntent().getStringExtra("strHistoryFourChild");
        strConsumeAlcoholFourChild = getIntent().getStringExtra("strConsumeAlcoholFourChild");
        strTobaccoEditFrequency = getIntent().getStringExtra("strTobaccoEditFrequency");
        strAlcoholEditFrequency = getIntent().getStringExtra("strAlcoholEditFrequency");
        strOccasionallyLiterSpinner = getIntent().getStringExtra("strOccasionallyLiterSpinner");
        strPreExistingMother = getIntent().getStringExtra("strPreExistingMother");
        strMotherPhysical = getIntent().getStringExtra("strMotherPhysical");
        strDiseaseMother = getIntent().getStringExtra("strDiseaseMother");
        strMotherHistoryRadio = getIntent().getStringExtra("strMotherHistoryRadio");
        strMotherAlcoholEditSpinner = getIntent().getStringExtra("strMotherAlcoholEditSpinner");
        strMotherOccasionallyEditSpinner = getIntent().getStringExtra("strMotherOccasionallyEditSpinner");
        strMotherTobaccoEditSpinner = getIntent().getStringExtra("strMotherTobaccoEditSpinner");
        strMotherOccasionallyTobaccoSpinner = getIntent().getStringExtra("strMotherOccasionallyTobaccoSpinner");
        strPreExistingFather = getIntent().getStringExtra("strPreExistingFather");
        GSt = getIntent().getStringExtra("GSt");
        selectYearProposer = getIntent().getIntExtra("selectYearProposer", 0);
        selectNomineeYear = getIntent().getIntExtra("selectNomineeYear", 0);
        CoPaymentCheckBoxCheck = getIntent().getStringExtra("CoPaymentCheckBoxCheck");
        SubCategoryDiscountStatusCheck = getIntent().getStringExtra("SubCategoryDiscountStatusCheck");
        strCoPaymentEditText = getIntent().getStringExtra("strCoPaymentEditText");
        strSubLimitEditText = getIntent().getStringExtra("strSubLimitEditText");
        selectFirstYearChild = getIntent().getIntExtra("selectFirstYearChild", 0);
        selectSecSonChild = getIntent().getIntExtra("selectSecSonChild", 0);
        selectThirdSonChild = getIntent().getIntExtra("selectThirdSonChild", 0);
        selectYearChildFour = getIntent().getIntExtra("selectYearChildFour", 0);
        selectYearSecondAdult = getIntent().getIntExtra("selectYearSecondAdult", 0);
        selectYearAdult = getIntent().getIntExtra("selectYearAdult", 0);
        selectYearMotherAdult = getIntent().getIntExtra("selectYearMotherAdult", 0);
        selectMotherLawAdult = getIntent().getIntExtra("selectMotherLawAdult", 0);
        selectFatherLawAdult = getIntent().getIntExtra("selectFatherLawAdult", 0);
        selectYearFatherAdult = getIntent().getIntExtra("selectYearFatherAdult", 0);
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

        initView();
    }
    private void initView() {

        //Button
        BackImg = findViewById(R.id.BackImg);
        continueButton = findViewById(R.id.continueButton);
        //TextView
        TotalPremiumTxt = findViewById(R.id.TotalPremiumTxt);
        ViewDetails = findViewById(R.id.ViewDetails);
        MotherTxt = findViewById(R.id.MotherTxt);
        FatherTxt = findViewById(R.id.FatherTxt);
        InsuredTxt = findViewById(R.id.InsuredTxt);
        //Self
        PreExistingDiseaseEdit = findViewById(R.id.PreExistingDiseaseEdit);
        PreExistingDiseaseDropDownLiner = findViewById(R.id.PreExistingDiseaseDropDownLiner);
        PreExistingDiseaseLiner = findViewById(R.id.PreExistingDiseaseLiner);
        SelfArrowImgMedical = findViewById(R.id.SelfArrowImgMedical);
        SelfUpMedicalArrowImg = findViewById(R.id.SelfUpMedicalArrowImg);
        linerAdult = findViewById(R.id.linerAdult);
        YesHospitalizationHistoryRadio = findViewById(R.id.YesHospitalizationHistoryRadio);
        NoPreExistingChildOneRadio = findViewById(R.id.NoPreExistingChildOneRadio);
        NoHospitalizationHistoryRadio = findViewById(R.id.NoHospitalizationHistoryRadio);
        YesMedicineRadio = findViewById(R.id.YesMedicineRadio);
        NoMedicineRadio = findViewById(R.id.NoMedicineRadio);
        YesPhysicalMentalRadio = findViewById(R.id.YesPhysicalMentalRadio);
        YesMedicalHistoryRadio = findViewById(R.id.YesMedicalHistoryRadio);
        NoMedicalHistoryRadio = findViewById(R.id.NoMedicalHistoryRadio);
        MedicalProfessionalEditSelf = findViewById(R.id.MedicalProfessionalEditSelf);
        MedicalTreatmentEditSelf = findViewById(R.id.MedicalTreatmentEditSelf);
        MedicalHistoryEditSelf = findViewById(R.id.MedicalHistoryEditSelf);
        PersonEditSelf = findViewById(R.id.PersonEditSelf);
        NoPhysicalMentalRadio = findViewById(R.id.NoPhysicalMentalRadio);
        YesPreExistingRadio = findViewById(R.id.YesPreExistingRadio);
        NoPreExistingRadio = findViewById(R.id.NoPreExistingRadio);
        bloodSugar = findViewById(R.id.bloodSugar);
        bloodPressure = findViewById(R.id.bloodPressure);
        bloodPressureDiastolic = findViewById(R.id.bloodPressureDiastolic);
        cholesterol = findViewById(R.id.cholesterol);
        YesAlcoholRadio = findViewById(R.id.YesAlcoholRadio);
        NoAlcoholRadio = findViewById(R.id.NoAlcoholRadio);
        AlcoholEditSpinner = findViewById(R.id.AlcoholEditSpinner);
        OccasionallyEditSpinner = findViewById(R.id.OccasionallyEditSpinner);
        AlcoholSelfDropDownLiner = findViewById(R.id.AlcoholSelfDropDownLiner);
        YesTobaccoRadio = findViewById(R.id.YesTobaccoRadio);
        YesNarcoticRadio = findViewById(R.id.YesNarcoticRadio);
        NoNarcoticRadio = findViewById(R.id.NoNarcoticRadio);
        NoTobaccoRadio = findViewById(R.id.NoTobaccoRadio);
        TobaccoEditSelf = findViewById(R.id.TobaccoEditSelf);
        TobaccoSelfSpinnerLiner = findViewById(R.id.TobaccoSelfSpinnerLiner);
        SelfConsumeAlcoholLiner = findViewById(R.id.SelfConsumeAlcoholLiner);
        DiseaseSelfLiner = findViewById(R.id.DiseaseSelfLiner);
        SelfConsumeTobaccoLiner = findViewById(R.id.SelfConsumeTobaccoLiner);
        SelfNarcoticLiner = findViewById(R.id.SelfNarcoticLiner);
        adultTwoLiner = findViewById(R.id.adultTwoLiner);
        SpouseMainDiseaseLiner = findViewById(R.id.SpouseMainDiseaseLiner);
        AlcoholSpinnerLiner = findViewById(R.id.AlcoholSpinnerLiner);
        TobaccoLinerSelf = findViewById(R.id.TobaccoLinerSelf);
        TobaccoOccasinallyLinerSelf = findViewById(R.id.TobaccoOccasinallyLinerSelf);
        OccasionallySelfDropDownLiner = findViewById(R.id.OccasionallySelfDropDownLiner);
        TypeSpinnerLiner = findViewById(R.id.TypeSpinnerLiner);
        AlcoholDurationSpinnerLiner = findViewById(R.id.AlcoholDurationSpinnerLiner);
        TobaccoOccasinallyEditSelf = findViewById(R.id.TobaccoOccasinallyEditSelf);
        YesPersonRadio = findViewById(R.id.YesPersonRadio);
        YesSmokerRadio = findViewById(R.id.YesSmokerRadio);
        NoPersonRadio = findViewById(R.id.NoPersonRadio);
        NoSmokerRadio = findViewById(R.id.NoSmokerRadio);
        TypeEditSpinner = findViewById(R.id.TypeEditSpinner);
        AlcoholDurationEditSpinner = findViewById(R.id.AlcoholDurationEditSpinner);
        SelfSmokerLiner = findViewById(R.id.SelfSmokerLiner);
        TobaccoTypeLinerSelf = findViewById(R.id.TobaccoTypeLinerSelf);
        NarcoticFrequencyLinerSelf = findViewById(R.id.NarcoticFrequencyLinerSelf);
        NarcoticDurationLinerSelf = findViewById(R.id.NarcoticDurationLinerSelf);
        TobaccoDurationLinerSelf = findViewById(R.id.TobaccoDurationLinerSelf);
        TypeSmokeSpinnerLiner = findViewById(R.id.TypeSmokeSpinnerLiner);
        TypeSmokeEditSpinner = findViewById(R.id.TypeSmokeEditSpinner);
        SmokeOccasionallySpinnerLiner = findViewById(R.id.SmokeOccasionallySpinnerLiner);
        SmokeOccasionallyEditSpinner = findViewById(R.id.SmokeOccasionallyEditSpinner);
        SmokeAlcoholSpinnerLiner = findViewById(R.id.SmokeAlcoholSpinnerLiner);
        SmokeAlcoholEditSpinner = findViewById(R.id.SmokeAlcoholEditSpinner);
        SmokeDurationSpinnerLiner = findViewById(R.id.SmokeDurationSpinnerLiner);
        SmokeDurationEditSpinner = findViewById(R.id.SmokeDurationEditSpinner);
        TobaccoTypeEditSelf = findViewById(R.id.TobaccoTypeEditSelf);
        TobaccoDurationEditSelf = findViewById(R.id.TobaccoDurationEditSelf);
        NarcoticEditSelf = findViewById(R.id.NarcoticEditSelf);
        NarcoticDurationEditSelf = findViewById(R.id.NarcoticDurationEditSelf);
        IllnessEditSelf = findViewById(R.id.IllnessEditSelf);
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
        SpouseDownMemberArrowImg = findViewById(R.id.SpouseDownMemberArrowImg);
        SpouseUpMemberArrowImg = findViewById(R.id.SpouseUpMemberArrowImg);
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
        ChildOneDownArrow = findViewById(R.id.ChildOneDownArrow);
        ChildOneUpArrow = findViewById(R.id.ChildOneUpArrow);
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
        ChildTwoDownArrow = findViewById(R.id.ChildTwoDownArrow);
        ChildTwoUpArrow = findViewById(R.id.ChildTwoUpArrow);
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

        ChildThreeDownArrowImgMedical = findViewById(R.id.ChildThreeDownArrowImgMedical);
        ChildThreeUpArrowImgMedical = findViewById(R.id.ChildThreeUpArrowImgMedical);
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
        ChildFourDownImgMedical = findViewById(R.id.ChildFourDownImgMedical);
        ChildFourUpImgMedical = findViewById(R.id.ChildFourUpImgMedical);
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
        MotherDownImgMedical = findViewById(R.id.MotherDownImgMedical);
        MotherUpImgMedical = findViewById(R.id.MotherUpImgMedical);
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

        FatherDownArrowImgMedical = findViewById(R.id.FatherDownArrowImgMedical);
        FatherUpArrowImgMedical = findViewById(R.id.FatherUpArrowImgMedical);
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
        MotherLawDownImgMedical = findViewById(R.id.MotherLawDownImgMedical);
        MotherLawUpImgMedical = findViewById(R.id.MotherLawUpImgMedical);
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
        FatherLawDownImgMedical = findViewById(R.id.FatherLawDownImgMedical);
        FatherLawUpImgMedical = findViewById(R.id.FatherLawUpImgMedical);
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
        TotalPremiumTxt.setText(strTotalPremium);
        if (!str_policyType_spinner.equals("Individual")) {
            if (strCheckBoxSelf.equals("Checked")) {
                linerAdult.setVisibility(View.VISIBLE);
            } else {
                linerAdult.setVisibility(View.GONE);
            }

            if (strCheckBoxSpouse.equals("Checked")) {
                SpouseLiner.setVisibility(View.VISIBLE);
            } else {
                SpouseLiner.setVisibility(View.GONE);
            }
            if (strCheckBoxSon.equals("Checked")) {
                if (mCounter == 1) {
                    LinerChildOneLiner.setVisibility(View.VISIBLE);
                    ChildTwoLiner.setVisibility(View.GONE);
                    ChildThreeLiner.setVisibility(View.GONE);
                    LinerFourChild.setVisibility(View.GONE);
                } else if (mCounter == 2) {
                    LinerChildOneLiner.setVisibility(View.VISIBLE);
                    ChildTwoLiner.setVisibility(View.VISIBLE);
                    ChildThreeLiner.setVisibility(View.GONE);
                    LinerFourChild.setVisibility(View.GONE);

                } else if (mCounter == 3) {
                    LinerChildOneLiner.setVisibility(View.VISIBLE);
                    ChildTwoLiner.setVisibility(View.VISIBLE);
                    ChildThreeLiner.setVisibility(View.VISIBLE);
                    LinerFourChild.setVisibility(View.GONE);

                } else if (mCounter == 4) {
                    LinerChildOneLiner.setVisibility(View.VISIBLE);
                    ChildTwoLiner.setVisibility(View.VISIBLE);
                    ChildThreeLiner.setVisibility(View.VISIBLE);
                    LinerFourChild.setVisibility(View.VISIBLE);
                }
            } else {
                LinerChildOneLiner.setVisibility(View.GONE);
                ChildTwoLiner.setVisibility(View.GONE);
                ChildThreeLiner.setVisibility(View.GONE);
                LinerFourChild.setVisibility(View.GONE);
            }

            if (strCheckBoxMother.equals("Checked") || strCheckBoxMotherLaw.equals("Checked")) {
                MotherLiner.setVisibility(View.VISIBLE);
            } else {
                MotherLiner.setVisibility(View.GONE);
            }
            if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                FatherLiner.setVisibility(View.VISIBLE);
            } else {
                FatherLiner.setVisibility(View.GONE);
            }
            if (strCheckBoxMother.equals("Checked")) {
                MotherTxt.setText("Mother");
            } else if (strCheckBoxMotherLaw.equals("Checked")){
                MotherTxt.setText("Mother-in-law");
            }
            if (strCheckBoxFather.equals("Checked")) {
                FatherTxt.setText("Father");
            } else if (strCheckBoxFatherLaw.equals("Checked")){
                FatherTxt.setText("Father-in-law");
            }

        }
        else {
            if (strCheckBoxSelf.equals("Checked")) {
                InsuredTxt.setText("Self");
            }
            if (strCheckBoxSpouse.equals("Checked")) {
                InsuredTxt.setText("Spouse");
            }
            if (strCheckBoxMother.equals("Checked")) {
                InsuredTxt.setText("Mother");
            }
            if (strCheckBoxMotherLaw.equals("Checked")) {
                InsuredTxt.setText("Mother-in-law");
            }
            if (strCheckBoxFather.equals("Checked")) {
                InsuredTxt.setText("Father");
            }
            if (strCheckBoxFatherLaw.equals("Checked")){
                InsuredTxt.setText("Father-in-law");
            }

            linerAdult.setVisibility(View.VISIBLE);
            SpouseLiner.setVisibility(View.GONE);
            LinerChildOneLiner.setVisibility(View.GONE);
            ChildTwoLiner.setVisibility(View.GONE);
            ChildThreeLiner.setVisibility(View.GONE);
            LinerFourChild.setVisibility(View.GONE);
            ChildTwoLiner.setVisibility(View.GONE);
            FatherLiner.setVisibility(View.GONE);
            MotherLiner.setVisibility(View.GONE);
        }
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

        if (strFor.equals("0")) {
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
        }
        else {
            NoChildThirdNarcoticRadio.setChecked(true);
            NoFatherNarcoticRadio.setChecked(true);
            NoMotherNarcoticRadio.setChecked(true);
            NoChildTwoNarcoticRadio.setChecked(true);
            NoChildFourNarcoticRadio.setChecked(true);
            NoChildNarcoticRadio.setChecked(true);
            NoSpouseNarcoticRadio.setChecked(true);
            NoNarcoticRadio.setChecked(true);
            NoPersonFatherRadio.setChecked(true);
            NoSmokerFatherRadio.setChecked(true);
            NoSmokerMotherRadio.setChecked(true);
            NoPersonMotherRadio.setChecked(true);
            NoPersonChildFourRadio.setChecked(true);
            NoSmokerChildFourRadio.setChecked(true);
            NoSmokerChildThirdRadio.setChecked(true);
            NoPersonThirdChildRadio.setChecked(true);
            NoSmokerChildTwoRadio.setChecked(true);
            NoSmokerChildRadio.setChecked(true);
            NoPersonChildTwoRadio.setChecked(true);
            NoPersonSpouseRadio.setChecked(true);
            NoPersonChildRadio.setChecked(true);
            NoSmokerSpouseRadio.setChecked(true);
            NoFatherHistoryRadio.setChecked(true);
            NoSmokerRadio.setChecked(true);
            NoPersonRadio.setChecked(true);
            NoDiseaseFather.setChecked(true);
            NoPhysicalChildThirdRadio.setChecked(true);
            NoConsumeAlcoholFourChild.setChecked(true);
            NoPhysicalChildFourRadio.setChecked(true);
            NoHistoryFourChildRadio.setChecked(true);
            NoPreExistingMotherRadio.setChecked(true);
            NoDiseaseChildFourRadio.setChecked(true);
            NoConsumeTobaccoChildFour.setChecked(true);
            NoAlcoholRadioThirdChild.setChecked(true);
            NoTobaccoThirdChild.setChecked(true);
            NoChildTwoAlcoholRadio.setChecked(true);
            NoTobaccoChildTwoRadio.setChecked(true);
            NoMotherHistoryRadio.setChecked(true);
            NoConsumeAlcoholMother.setChecked(true);
            NoConsumeTobaccoMother.setChecked(true);
            NoPreExistingFatherRadio.setChecked(true);
            NoConsumeAlcoholFather.setChecked(true);
            NoConsumeTobaccoChildOneRadio.setChecked(true);
            NoPreExistingChildOneRadio.setChecked(true);
            NoPhysicalMentalRadio.setChecked(true);
            NoPreExistingRadio.setChecked(true);
            NoTobaccoRadio.setChecked(true);
            NoAlcoholRadio.setChecked(true);
            NoMedicalHistoryRadio.setChecked(true);
            NoMedicineRadio.setChecked(true);
            NoFatherPhysical.setChecked(true);
            NoHospitalizationHistoryRadio.setChecked(true);
            NoMotherPhysical.setChecked(true);
            NoDiseaseMother.setChecked(true);
            bloodSugar.setText(strBloodSugar);
            bloodPressure.setText(strBloodPressure);
            bloodPressureDiastolic.setText(strBloodPressureDiastolic);
            cholesterol.setText(strcholesterol);
            NoRadioSufferingDiseaseSecondAdult.setChecked(true);
            SpouseNoPhysicalRadio.setChecked(true);
            NoDiseaseSpouseRadio.setChecked(true);
            NoHospitalizationHistoryAdultSecondRadio.setChecked(true);
            NoSpouseTobaccoRadio.setChecked(true);
            NoConsumeAlcoholRadio.setChecked(true);
            NoMedicineChildOneRadio.setChecked(true);
            NoChildOnePhysicalRadio.setChecked(true);
            NoChildOnePreExistingRadio.setChecked(true);
            NoChildOneConsumeAlcoholRadio.setChecked(true);
            NoChildTwoPreExistingRadio.setChecked(true);
            NoChildTwoPhysicalRadio.setChecked(true);
            NoChildTwoPreDisease.setChecked(true);
            NoChildTwoHistoryRadio.setChecked(true);
            NoPreExistingThirdChildRadio.setChecked(true);
            NoMedicineThirdChildRadio.setChecked(true);
            NoDiseaseChildThird.setChecked(true);
            NoDiseaseChildFourRadio.setChecked(true);
            NoConsumeTobaccoFather.setChecked(true);

        }

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
        //Self
        SelfArrowImgMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerAdult.setVisibility(View.VISIBLE);
                SelfUpMedicalArrowImg.setVisibility(View.VISIBLE);
                SelfArrowImgMedical.setVisibility(View.GONE);
            }
        });
        SelfUpMedicalArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerAdult.setVisibility(View.GONE);
                SelfUpMedicalArrowImg.setVisibility(View.GONE);
                SelfArrowImgMedical.setVisibility(View.VISIBLE);
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
//                    alertPopup();
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
        YesMedicalHistoryRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesMedicalHistoryRadio.isChecked()) {
                    YesMedicalHistoryRadio.setChecked(true);
                    NoMedicalHistoryRadio.setChecked(false);
                    strMedicalHistoryRadio = "Yes";
                    MedicalProfessionalEditSelf.setVisibility(View.VISIBLE);
//                    alertPopup();
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
        YesSmokerRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesSmokerRadio.isChecked()) {
                    YesSmokerRadio.setChecked(true);
                    NoSmokerRadio.setChecked(false);
                    strSmokerRadio = "Yes";
//                    alertPopup();
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


        YesPhysicalMentalRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPhysicalMentalRadio.isChecked()) {
                    YesPhysicalMentalRadio.setChecked(true);
                    NoPhysicalMentalRadio.setChecked(false);
                    strYesPhysicalMentalRadio = "Yes";
//                    alertPopup();
                }
            }
        });
        NoPhysicalMentalRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NoPhysicalMentalRadio.isChecked()) {
                    NoPhysicalMentalRadio.setChecked(true);
                    YesPhysicalMentalRadio.setChecked(false);
                    strYesPhysicalMentalRadio = "No";

                }
            }
        });

        YesPreExistingRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesPreExistingRadio.isChecked()) {
                    YesPreExistingRadio.setChecked(true);
                    NoPreExistingRadio.setChecked(false);
                    strYesPreExistingRadio = "Yes";
                    PreExistingDiseaseLiner.setVisibility(View.GONE);
                    strPreExistingDiseaseEdit = "Alzheimer’s disease";
                    PreExistingDiseaseEdit.setText(strPreExistingDiseaseEdit);
                    IllnessEditSelf.setVisibility(View.VISIBLE);
//                    alertPopup();
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
                    PreExistingDiseaseLiner.setVisibility(View.GONE);
                    IllnessEditSelf.setVisibility(View.GONE);
                }
            }
        });

        PreExistingDiseaseDropDownLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Alzheimer’s disease");
                items1.add("Huntington’s Chorea");
                items1.add("Parkinson diseases");
                items1.add("Multiple Sclerosis");
                items1.add("Schizophrenia");
                items1.add("Lou Gehrig’s disease (ALS)");
                items1.add("Arthritis- Rheumatoid / Osteoarthritis");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strPreExistingDiseaseEdit = items1.get(options1);
                        PreExistingDiseaseEdit.setText(strPreExistingDiseaseEdit);

                    }
                });
                singlePicker.show();
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

        YesNarcoticRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (YesNarcoticRadio.isChecked()) {
                    YesNarcoticRadio.setChecked(true);
                    NoNarcoticRadio.setChecked(false);
                    strNarcoticRadio = "Yes";
                    SelfNarcoticLiner.setVisibility(View.VISIBLE);
//                    alertPopup();
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

        //Alcohol
        AlcoholSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
        TypeSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
        AlcoholDurationSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
        OccasionallySelfDropDownLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
        //smoke
        TypeSmokeSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
        //Tobacco
        TobaccoTypeLinerSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
        //Narcotic
        NarcoticFrequencyLinerSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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

        //Spouse
        SpouseDownMemberArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adultTwoLiner.setVisibility(View.VISIBLE);
                SpouseUpMemberArrowImg.setVisibility(View.VISIBLE);
                SpouseDownMemberArrowImg.setVisibility(View.GONE);
            }
        });
        SpouseUpMemberArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adultTwoLiner.setVisibility(View.GONE);
                SpouseUpMemberArrowImg.setVisibility(View.GONE);
                SpouseDownMemberArrowImg.setVisibility(View.VISIBLE);
            }
        });

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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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

        //childOne
        ChildOneDownArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChildOneLiner.setVisibility(View.VISIBLE);
                ChildOneUpArrow.setVisibility(View.VISIBLE);
                ChildOneDownArrow.setVisibility(View.GONE);
            }
        });
        ChildOneUpArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChildOneLiner.setVisibility(View.GONE);
                ChildOneUpArrow.setVisibility(View.GONE);
                ChildOneDownArrow.setVisibility(View.VISIBLE);
            }
        });
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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


        //childTwo

        ChildTwoDownArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChildTwoLinerMedical.setVisibility(View.VISIBLE);
                ChildTwoUpArrow.setVisibility(View.VISIBLE);
                ChildTwoDownArrow.setVisibility(View.GONE);
            }
        });
        ChildTwoUpArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChildTwoLinerMedical.setVisibility(View.GONE);
                ChildTwoDownArrow.setVisibility(View.VISIBLE);
                ChildTwoUpArrow.setVisibility(View.GONE);

            }
        });

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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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

        //child3
        ChildThreeDownArrowImgMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thirdChildLiner.setVisibility(View.VISIBLE);
                ChildThreeUpArrowImgMedical.setVisibility(View.VISIBLE);
                ChildThreeDownArrowImgMedical.setVisibility(View.GONE);
            }
        });
        ChildThreeUpArrowImgMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thirdChildLiner.setVisibility(View.generateViewId());
                ChildThreeUpArrowImgMedical.setVisibility(View.GONE);
                ChildThreeDownArrowImgMedical.setVisibility(View.VISIBLE);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
        ChildFourDownImgMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChildFourDownImgMedical.setVisibility(View.GONE);
                ChildFourUpImgMedical.setVisibility(View.VISIBLE);
                FourChildTwoLiner.setVisibility(View.VISIBLE);
            }
        });
        ChildFourUpImgMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChildFourDownImgMedical.setVisibility(View.VISIBLE);
                ChildFourUpImgMedical.setVisibility(View.GONE);
                FourChildTwoLiner.setVisibility(View.GONE);
            }
        });
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
        MotherDownImgMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MotherDownImgMedical.setVisibility(View.GONE);
                MotherUpImgMedical.setVisibility(View.VISIBLE);
                MotherMainLiner.setVisibility(View.VISIBLE);
            }
        });
        MotherUpImgMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MotherDownImgMedical.setVisibility(View.VISIBLE);
                MotherUpImgMedical.setVisibility(View.GONE);
                MotherMainLiner.setVisibility(View.GONE);
            }
        });
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
        FatherDownArrowImgMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FatherDownArrowImgMedical.setVisibility(View.GONE);
                FatherUpArrowImgMedical.setVisibility(View.VISIBLE);
                FatherMainLiner.setVisibility(View.VISIBLE);
            }
        });
        FatherUpArrowImgMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FatherUpArrowImgMedical.setVisibility(View.VISIBLE);
                FatherUpArrowImgMedical.setVisibility(View.GONE);
                FatherMainLiner.setVisibility(View.GONE);
            }
        });

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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(MemberMedicalInfoCHI.this);
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
        MotherLawDownImgMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MotherLawDownImgMedical.setVisibility(View.GONE);
                MotherLawUpImgMedical.setVisibility(View.VISIBLE);
                MatherLawMainLiner.setVisibility(View.VISIBLE);
            }
        });
        MotherLawUpImgMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MotherLawDownImgMedical.setVisibility(View.VISIBLE);
                MotherLawUpImgMedical.setVisibility(View.GONE);
                MatherLawMainLiner.setVisibility(View.GONE);
            }
        });
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
        FatherLawDownImgMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FatherLawUpImgMedical.setVisibility(View.VISIBLE);
                FatherLawTwoLiner.setVisibility(View.VISIBLE);
                FatherLawDownImgMedical.setVisibility(View.GONE);
            }
        });
        FatherLawUpImgMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FatherLawDownImgMedical.setVisibility(View.VISIBLE);
                FatherLawTwoLiner.setVisibility(View.GONE);
                FatherLawUpImgMedical.setVisibility(View.GONE);
            }
        });
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
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strBloodSugar = bloodSugar.getText().toString();
                strBloodPressure = bloodPressure.getText().toString();
                strBloodPressureDiastolic = bloodPressureDiastolic.getText().toString();
                strcholesterol = cholesterol.getText().toString();
                strIllnessEditSelf = IllnessEditSelf.getText().toString();
                strMedicalProfessionalEditSelf = MedicalProfessionalEditSelf.getText().toString();
                strMedicalTreatmentEditSelf = MedicalTreatmentEditSelf.getText().toString();
                strMedicalHistoryEditSelf = MedicalHistoryEditSelf.getText().toString();
                strPersonEditSelf = PersonEditSelf.getText().toString();
                strIllnessEditSpouse = IllnessEditSpouse.getText().toString();
                strPhysicalEditSpouse = PhysicalEditSpouse.getText().toString();
                strDiseaseEditSpouse = DiseaseEditSpouse.getText().toString();
                strHospitalizationEditSpouse = HospitalizationEditSpouse.getText().toString();
                strPersonEditSpouse = PersonEditSpouse.getText().toString();
                strIllnessEditChildOne = IllnessEditChildOne.getText().toString();
                strPhysicalEditChildOne = PhysicalEditChildOne.getText().toString();
                strDiseaseEditChildOne = DiseaseEditChildOne.getText().toString();
                strPreExistingEditChildOne = PreExistingEditChildOne.getText().toString();
                strPersonEditChildOne = PersonEditChildOne.getText().toString();
                strIllnessEditChildTwo = IllnessEditChildTwo.getText().toString();
                strMedicineEditChildTwo = MedicineEditChildTwo.getText().toString();
                strTreatmentEditChildTwo = TreatmentEditChildTwo.getText().toString();
                strHospitalizedEditChildTwo = HospitalizedEditChildTwo.getText().toString();
                strPersonEditChildTwo = PersonEditChildTwo.getText().toString();
                strIllnessEditChild3 = IllnessEditChild3.getText().toString();
                strMedicalEditChild3 = MedicalEditChild3.getText().toString();
                strMedicalTreatmentEditChild3 = MedicalTreatmentEditChild3.getText().toString();
                strHospitizationTreatmentEditChild3 = HospitizationTreatmentEditChild3.getText().toString();
                strPersonEditChild3 = PersonEditChild3.getText().toString();
                strIllnessEditChild4 = IllnessEditChild4.getText().toString();
                strMedicalEditChild4 = MedicalEditChild4.getText().toString();
                strMedicalTreatmentEditChild4 = MedicalTreatmentEditChild4.getText().toString();
                strHospitalizedEditChild4 = HospitalizedEditChild4.getText().toString();
                strPersonEditChild4= PersonEditChild4.getText().toString();
                strIllnessEditMother= IllnessEditMother.getText().toString();
                strMedicalEditMother= MedicalEditMother.getText().toString();
                strMedicalHealthEditMother= MedicalHealthEditMother.getText().toString();
                strMedicalTreatmentEditMother= MedicalTreatmentEditMother.getText().toString();
                strPersonEditMother= PersonEditMother.getText().toString();
                strIllnessEditFather= IllnessEditFather.getText().toString();
                strMedicalEditFather= MedicalEditFather.getText().toString();
                strMedicalTreatmentEditFather= MedicalTreatmentEditFather.getText().toString();
                strTreatmentHistoryEditFather= TreatmentHistoryEditFather.getText().toString();
                strPersonEditFather= PersonEditFather.getText().toString();
//                strYesPhysicalMentalRadio.equals("Yes")||
                if (str_policyType_spinner.equals("Individual")) {
                    if (strCheckBoxSelf.equals("Checked") || strCheckBoxSpouse.equals("Checked") || strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                        if (strYesPreExistingRadio.equals("Yes") || strSelfAlcoholRadio.equals("Yes") || strSelfTobaccoRadio.equals("Yes")|| strNarcoticRadio.equals("Yes") || strMedicalHistoryRadio.equals("Yes") || strPersonRadio.equals("Yes")|| strSmokerRadio.equals("Yes")|| strMedicineRadio.equals("Yes") || strHospitalizationHistory.equals("Yes")) {
                            alertPopup();
                        } else {
                            elseMethod();
                        }
                    }
                } else {
                    if (strCheckBoxSelf.equals("Checked")) {
                        if (strYesPreExistingRadio.equals("Yes") || strSelfAlcoholRadio.equals("Yes") || strSelfTobaccoRadio.equals("Yes") || strNarcoticRadio.equals("Yes")|| strMedicalHistoryRadio.equals("Yes") || strPersonRadio.equals("Yes")|| strSmokerRadio.equals("Yes")|| strMedicineRadio.equals("Yes") || strHospitalizationHistory.equals("Yes")) {
                            alertPopup();
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
                                elseMethod();
                            }

                        }
                    }else if (strCheckBoxSpouse.equals("Checked")) {
                        SpouseMethod();
                    }else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                        CheckMotherFatherCondition();
                    }else {
                        elseMethod();
                    }
                }


            }

        });
        ViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog alert_dialog;
                alert_dialog = new Dialog(MemberMedicalInfoCHI.this);
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
                TextView GSTTxtView=alert_dialog.findViewById(R.id.GSTTxtView);
                TextView BasicPremiumTxtView=alert_dialog.findViewById(R.id.BasicPremiumTxtView);
                TextView LongTermTxt=alert_dialog.findViewById(R.id.LongTermTxt);
                TextView subLimitTxt=alert_dialog.findViewById(R.id.subLimitTxt);
                TextView CoPaymentTxt=alert_dialog.findViewById(R.id.CoPaymentTxt);
                GSTTxtView.setText(GSt);
                SumInsuredTxt.setText(strSumInsured);
                BasicPremiumTxtView.setText(strBasicPremium);
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
        BackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                methodBack();
            }
        });

    }
    private void SpouseMethod() {
        if (strSufferingDiseaseSecondAdult.equals("Yes") || strSpousePhysicalRadio.equals("Yes") || strDiseaseSpouseRadio.equals("Yes") || strHospitalizationHistoryAdultSecond.equals("Yes")|| strPersonSpouseRadio.equals("Yes") || strSmokerSpouseRadio.equals("Yes")  || strConsumeSpouseAlcohol.equals("Yes")|| strSpouseNarcoticRadio.equals("Yes") || strSpouseTobaccoRadio.equals("Yes")) {
            alertPopup();
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
                elseMethod();
            }
        }

    }
    private void ChildOneMethod() {
        if (strPreExistingChildOneRadio.equals("Yes") || strChildOnePhysicalRadio.equals("Yes") || strMedicineChildOneRadio.equals("Yes")|| strPersonChildRadio.equals("Yes")|| strSmokerChildRadio.equals("Yes") || strChildOnePreExisting.equals("Yes") || strChildOneConsumeAlcoholRadio.equals("Yes")|| strChildNarcotic.equals("Yes")  || strConsumeTobaccoFather.equals("Yes")|| strFatherNarcotic.equals("Yes")) {
            alertPopup();
        } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
            CheckMotherFatherCondition();
        } else {
            elseMethod();
        }
    }
    private void ChildTwoMethod() {
        if (strPreExistingChildOneRadio.equals("Yes") || strChildOnePhysicalRadio.equals("Yes") || strMedicineChildOneRadio.equals("Yes")|| strPersonChildRadio.equals("Yes")|| strSmokerChildRadio.equals("Yes") || strChildOnePreExisting.equals("Yes") || strChildOneConsumeAlcoholRadio.equals("Yes")|| strChildNarcotic.equals("Yes")  || strConsumeTobaccoFather.equals("Yes")|| strFatherNarcotic.equals("Yes")) {
            alertPopup();
        }else if (strChildTwoPreExisting.equals("Yes") || strChildTwoPhysicalRadio.equals("Yes") || strChildTwoPreDisease.equals("Yes") || strChildTwoHistory.equals("Yes") || strPersonChildTwo.equals("Yes")|| strSmokerChildTwo.equals("Yes")|| strChildTwoAlcoholRadio.equals("Yes") || strChildTwoNarcotic.equals("Yes")|| strTobaccoChildTwoRadio.equals("Yes")) {
            alertPopup();
        } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
            CheckMotherFatherCondition();
        } else {
            elseMethod();
        }
    }
    private void ChildThirdMethod() {
        if (strPreExistingChildOneRadio.equals("Yes") || strChildOnePhysicalRadio.equals("Yes") || strMedicineChildOneRadio.equals("Yes")|| strPersonChildRadio.equals("Yes") || strSmokerChildRadio.equals("Yes")|| strChildOnePreExisting.equals("Yes") || strChildOneConsumeAlcoholRadio.equals("Yes")|| strChildNarcotic.equals("Yes")  || strConsumeTobaccoFather.equals("Yes")) {
            alertPopup();
        }else if (strChildTwoPreExisting.equals("Yes") || strChildTwoPhysicalRadio.equals("Yes") || strChildTwoPreDisease.equals("Yes") || strChildTwoHistory.equals("Yes")|| strPersonChildTwo.equals("Yes")|| strSmokerChildTwo.equals("Yes") || strChildTwoAlcoholRadio.equals("Yes") || strChildTwoNarcotic.equals("Yes")|| strTobaccoChildTwoRadio.equals("Yes")) {
            alertPopup();
        }else if (strPreExistingThirdChild.equals("Yes") || strPhysicalChildThirdRadio.equals("Yes")|| strPersonChildThird.equals("Yes")|| strSmokerChildThird.equals("Yes") || strMedicineThirdChildRadio.equals("Yes") || strDiseaseChildThird.equals("Yes") || strAlcoholRadioThirdChild.equals("Yes") || strTobaccoThirdChild.equals("Yes")|| strChildThirdNarcotic.equals("Yes")) {
            alertPopup();
        } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
            CheckMotherFatherCondition();
        } else {
            elseMethod();
        }
    }
    private void ChildFourthMethod() {
        if (strPreExistingChildOneRadio.equals("Yes") || strChildOnePhysicalRadio.equals("Yes") || strMedicineChildOneRadio.equals("Yes")|| strPersonChildRadio.equals("Yes") || strSmokerChildRadio.equals("Yes")|| strChildOnePreExisting.equals("Yes") || strChildOneConsumeAlcoholRadio.equals("Yes")|| strChildNarcotic.equals("Yes")  || strConsumeTobaccoFather.equals("Yes")) {
            alertPopup();
        }else if (strChildTwoPreExisting.equals("Yes") || strChildTwoPhysicalRadio.equals("Yes") || strChildTwoPreDisease.equals("Yes") || strChildTwoHistory.equals("Yes")|| strPersonChildTwo.equals("Yes")|| strSmokerChildTwo.equals("Yes") || strChildTwoAlcoholRadio.equals("Yes") || strChildTwoNarcotic.equals("Yes")|| strTobaccoChildTwoRadio.equals("Yes")) {
            alertPopup();
        }else if (strPreExistingThirdChild.equals("Yes") || strPhysicalChildThirdRadio.equals("Yes") || strMedicineThirdChildRadio.equals("Yes") || strDiseaseChildThird.equals("Yes")|| strPersonChildThird.equals("Yes")|| strSmokerChildThird.equals("Yes") || strAlcoholRadioThirdChild.equals("Yes") || strTobaccoThirdChild.equals("Yes")|| strChildThirdNarcotic.equals("Yes")) {
            alertPopup();
        } else if (strPreExistingFourChild.equals("Yes") || strPhysicalChildFourRadio.equals("Yes") || strDiseaseChildFourRadio.equals("Yes") || strHistoryFourChild.equals("Yes")|| strSmokerChildFourChild.equals("Yes")|| strPersonChildFourChild.equals("Yes") || strConsumeAlcoholFourChild.equals("Yes") || strConsumeTobacco.equals("Yes")|| strChildFourNarcotic.equals("Yes")) {
            alertPopup();
        } else if (strCheckBoxMother.equals("Checked") || strCheckBoxFather.equals("Checked") || strCheckBoxMotherLaw.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
            CheckMotherFatherCondition();
        } else {
            elseMethod();
        }
    }
    private void CheckMotherFatherCondition() {
        if (strCheckBoxMother.equals("Checked") || strCheckBoxMotherLaw.equals("Checked")) {
            if (strPreExistingMother.equals("Yes") || strPersonMotherRadio.equals("Yes")|| strSmokerMotherRadio.equals("Yes") ||strMotherPhysical.equals("Yes") || strDiseaseMother.equals("Yes") || strMotherHistoryRadio.equals("Yes") || strConsumeAlcoholMother.equals("Yes") || strConsumeTobaccoMother.equals("Yes")|| strMotherNarcotic.equals("Yes")) {
                alertPopup();
            } else {
                if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
                    if (strPreExistingFather.equals("Yes") || strFatherPhysical.equals("Yes") || strDiseaseFather.equals("Yes")|| strPersonFather.equals("Yes") || strFatherHistory.equals("Yes") || strConsumeAlcoholFather.equals("Yes") || strConsumeTobaccoFather.equals("Yes")) {
                        alertPopup();
                    } else {
                        elseMethod();
                    }
                } else {
                    elseMethod();
                }
            }

        } else if (strCheckBoxFather.equals("Checked") || strCheckBoxFatherLaw.equals("Checked")) {
            if (strPreExistingFather.equals("Yes") || strFatherPhysical.equals("Yes") || strDiseaseFather.equals("Yes")|| strPersonFather.equals("Yes")|| strSmokerFather.equals("Yes")  || strFatherHistory.equals("Yes") || strConsumeAlcoholFather.equals("Yes") || strConsumeTobaccoFather.equals("Yes")) {
                alertPopup();
            } else {
                elseMethod();
            }
        } else {
            elseMethod();
        }
    }
    private void elseMethod() {
        Intent intent = new Intent(MemberMedicalInfoCHI.this, ChiSummery.class);
        intent.putExtra("str_edt_name", str_edt_name);
        intent.putExtra("TreatmentCheckBoxCheck", TreatmentCheckBoxCheck);
        intent.putExtra("str_edt_phone", str_edt_phone);
        intent.putExtra("str_email", str_email);
        intent.putExtra("str_policyType_spinner", str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit", str_IndividualTypeEdit);
        intent.putExtra("strSelfAgeEditText", strSelfAgeEditText);
        intent.putExtra("strTotalPremium", strTotalPremium);
        intent.putExtra("strEdtNameSelf", strEdtNameSelf);
        intent.putExtra("strEmailIDEditSelf", strEmailIDEditSelf);
        intent.putExtra("strEditGenderSelf", strEditGenderSelf);
        intent.putExtra("strEditOccupationSelf", strEditOccupationSelf);
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
        intent.putExtra("strContactNominee", strContactNominee);
        intent.putExtra("strNomineeDobEdit", strNomineeDobEdit);
        intent.putExtra("strYesPhysicalMentalRadio", strYesPhysicalMentalRadio);
        intent.putExtra("strYesPreExistingRadio", strYesPreExistingRadio);
        intent.putExtra("strBloodSugar", strBloodSugar);
        intent.putExtra("strBloodPressure", strBloodPressure);
        intent.putExtra("strBloodPressureDiastolic", strBloodPressureDiastolic);
        intent.putExtra("strcholesterol", strcholesterol);
        intent.putExtra("strSumInsured", strSumInsured);
        intent.putExtra("strBasicPremium", strBasicPremium);
        intent.putExtra("strPlanTypeTXT", strPlanTypeTXT);
        intent.putExtra("NetPremium", NetPremium);
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
        intent.putExtra("strPolicyNumber", strPolicyNumber);
        intent.putExtra("CoPaymentLoading", CoPaymentLoading);
        intent.putExtra("EmergencyTravellingStatus", EmergencyTravellingStatus);
        intent.putExtra("PosPolicyNo", PosPolicyNo);
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
        intent.putExtra("strCheckBoxSon", strCheckBoxSon);
        intent.putExtra("mCounter", mCounter);
        intent.putExtra("strFor", "0");
        intent.putExtra("strSpouseDobEdit", strSpouseDobEdit);
        intent.putExtra("strPackageOne", strPackageOne);
        intent.putExtra("strCheckBoxSelf", strCheckBoxSelf);
        intent.putExtra("addons", addons);
        intent.putExtra("Discounts", Discounts);
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
        intent.putExtra("strNomineeGenderEdit", strNomineeGenderEdit);
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
        intent.putExtra("LongTermDiscountStatus", LongTermDiscountStatus);
        intent.putExtra("SubCategoryDiscountStatus", SubCategoryDiscountStatus);
        intent.putExtra("SubCategory", SubCategory);
        intent.putExtra("DirectPolicyDiscountPremium", DirectPolicyDiscountPremium);
        intent.putExtra("FamilyTypeCounter", FamilyTypeCounter);
        intent.putExtra("LongTermDiscountDiscountPremium", LongTermDiscountDiscountPremium);
        intent.putExtra("SubCategoryDiscountPremium", SubCategoryDiscountPremium);
        intent.putExtra("doubleCoPaymentDiscountPremium", doubleCoPaymentDiscountPremium);
        intent.putExtra("str_age", str_age);
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
        intent.putExtra("str_oneFtSpinner", str_oneFtSpinner);
        intent.putExtra("str_oneInchesSpinner", str_oneInchesSpinner);
        intent.putExtra("str_oneWeightEdit", str_oneWeightEdit);
        intent.putExtra("strOccupationEditChildOne", strOccupationEditChildOne);
        intent.putExtra("str_twoOccupationSpinner", str_twoOccupationSpinner);
        intent.putExtra("str_thirdOccupationSpinner", str_thirdOccupationSpinner);
        intent.putExtra("str_fourOccupationSpinner", str_fourOccupationSpinner);
        intent.putExtra("str_thirdOccupationSpinner", str_thirdOccupationSpinner);
        intent.putExtra("yearRadio", yearRadio);
        intent.putExtra("strPackage1", strPackage1);
        intent.putExtra("strPackageTwo", strPackageTwo);
        intent.putExtra("strPackageThree", strPackageThree);
        intent.putExtra("strPackageFour", strPackageFour);
        intent.putExtra("strPackageFive", strPackageFive);
        intent.putExtra("strPackageSix", strPackageSix);
        intent.putExtra("FamilyComposition", FamilyComposition);
        intent.putExtra("ParentComposition", ParentComposition);
        intent.putExtra("strSelfTobaccoRadio", strSelfTobaccoRadio);
        intent.putExtra("strAlcoholEditSpinner", strAlcoholEditSpinner);
        intent.putExtra("strOccasionallyEditSpinner", strOccasionallyEditSpinner);
        intent.putExtra("strTobaccoEditSelf", strTobaccoEditSelf);
        intent.putExtra("strTobaccoOccasinallyEditSelf", strTobaccoOccasinallyEditSelf);
        intent.putExtra("strSelfAlcoholRadio", strSelfAlcoholRadio);
        intent.putExtra("PersonalAccidentCategory", PersonalAccidentCategory);
        intent.putExtra("PremiumWaiverStatus", PremiumWaiverStatus);
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
        intent.putExtra("strMedicalHistoryRadio", strMedicalHistoryRadio);
        intent.putExtra("strPersonRadio", strPersonRadio);
        intent.putExtra("strSmokerRadio", strSmokerRadio);
        intent.putExtra("strMedicineRadio", strMedicineRadio);
        intent.putExtra("strHospitalizationHistory", strHospitalizationHistory);
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
        intent.putExtra("strSpousePhysicalRadio", strSpousePhysicalRadio);
        intent.putExtra("strDiseaseSpouseRadio", strDiseaseSpouseRadio);
        intent.putExtra("strSufferingDiseaseSecondAdult", strSufferingDiseaseSecondAdult);
        intent.putExtra("strHospitalizationHistoryAdultSecond", strHospitalizationHistoryAdultSecond);
        intent.putExtra("strConsumeSpouseAlcohol", strConsumeSpouseAlcohol);
        intent.putExtra("strSpouseTobaccoRadio", strSpouseTobaccoRadio);
        intent.putExtra("strSpouseEditFrequency", strSpouseEditFrequency);
        intent.putExtra("strOccasionallySpouseEditSpinner", strOccasionallySpouseEditSpinner);
        intent.putExtra("strTobaccoOccasinallyEditSpouse", strTobaccoOccasinallyEditSpouse);
        intent.putExtra("strTobaccoEditSpouse", strTobaccoEditSpouse);
        intent.putExtra("strPreExistingChildOneRadio", strPreExistingChildOneRadio);
        intent.putExtra("strChildOnePhysicalRadio", strChildOnePhysicalRadio);
        intent.putExtra("strMedicineChildOneRadio", strMedicineChildOneRadio);
        intent.putExtra("strChildOnePreExisting", strChildOnePreExisting);
        intent.putExtra("strChildOneConsumeAlcoholRadio", strChildOneConsumeAlcoholRadio);
        intent.putExtra("strAlcoholEditSpinnerChildOne", strAlcoholEditSpinnerChildOne);
        intent.putExtra("strOccasionallyEditChildOneSpinner", strOccasionallyEditChildOneSpinner);
        intent.putExtra("strConsumeTabaccoChildOne", strConsumeTabaccoChildOne);
        intent.putExtra("strChildTwoPreExisting", strChildTwoPreExisting);
        intent.putExtra("strChildTwoPhysicalRadio", strChildTwoPhysicalRadio);
        intent.putExtra("strChildTwoPreDisease", strChildTwoPreDisease);
        intent.putExtra("strChildTwoHistory", strChildTwoHistory);
        intent.putExtra("strOccasionallyTwoChildEditSpinner", strOccasionallyTwoChildEditSpinner);
        intent.putExtra("strTobaccoEditTwoChild", strTobaccoEditTwoChild);
        intent.putExtra("strTobaccoOccasinallyEditTwoChild", strTobaccoOccasinallyEditTwoChild);
        intent.putExtra("strPreExistingThirdChild", strPreExistingThirdChild);
        intent.putExtra("strPhysicalChildThirdRadio", strPhysicalChildThirdRadio);
        intent.putExtra("strMedicineThirdChildRadio", strMedicineThirdChildRadio);
        intent.putExtra("strDiseaseChildThird", strDiseaseChildThird);
        intent.putExtra("strAlcoholEditSpinnerThirdChild", strAlcoholEditSpinnerThirdChild);
        intent.putExtra("strOccasionallyEditSpinnerThirdChild", strOccasionallyEditSpinnerThirdChild);
        intent.putExtra("strAlcoholEditThirdChild", strAlcoholEditThirdChild);
        intent.putExtra("strOccasionallyEditThirdChild", strOccasionallyEditThirdChild);
        intent.putExtra("strPreExistingFourChild", strPreExistingFourChild);
        intent.putExtra("strPhysicalChildFourRadio", strPhysicalChildFourRadio);
        intent.putExtra("strDiseaseChildFourRadio", strDiseaseChildFourRadio);
        intent.putExtra("strHistoryFourChild", strHistoryFourChild);
        intent.putExtra("strConsumeAlcoholFourChild", strConsumeAlcoholFourChild);
        intent.putExtra("strPreExistingMother", strPreExistingMother);
        intent.putExtra("strMotherPhysical", strMotherPhysical);
        intent.putExtra("copayemntMax", copayemntMax);
        intent.putExtra("TiresDiscount", TiresDiscount);
        intent.putExtra("DirectPolicy", DirectPolicy);
        intent.putExtra("OrganDonar", OrganDonar);
        intent.putExtra("LongTerm", LongTerm);
        intent.putExtra("loyalityDiscount", loyalityDiscount);
        intent.putExtra("sublimt", sublimt);
        intent.putExtra("GSt", GSt);
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
        intent.putExtra("selectYearProposer",selectYearProposer);
        intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
        intent.putExtra("strDob",strDob);
        intent.putExtra("strIDTypeName",strIDTypeName);
        intent.putExtra("permAndCorresAddSame",permAndCorresAddSame);
        startActivity(intent);
        finish();
    }
    private void alertPopup() {
        Dialog alert_dialogNSTP;
        alert_dialogNSTP = new Dialog(MemberMedicalInfoCHI.this);
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
                Intent intent = new Intent(MemberMedicalInfoCHI.this, PolicyTypeCHI.class);
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
                intent.putExtra("strFor", "1");
                startActivity(intent);
                finish();
                alert_dialogNSTP.dismiss();

            }
        });
    }
    private void methodBack() {
        Intent intent = new Intent(MemberMedicalInfoCHI.this, PersonalInformationCHI.class);
        intent.putExtra("TreatmentCheckBoxCheck", TreatmentCheckBoxCheck);
        intent.putExtra("str_edt_name", str_edt_name);
        intent.putExtra("str_edt_phone", str_edt_phone);
        intent.putExtra("str_email", str_email);
        intent.putExtra("str_policyType_spinner", str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit", str_IndividualTypeEdit);
        intent.putExtra("strSelfAgeEditText", strSelfAgeEditText);
        intent.putExtra("strTotalPremium", strTotalPremium);
        intent.putExtra("strEdtNameSelf", strEdtNameSelf);
        intent.putExtra("strEmailIDEditSelf", strEmailIDEditSelf);
        intent.putExtra("strEditGenderSelf", strEditGenderSelf);
        intent.putExtra("strEditOccupationSelf", strEditOccupationSelf);
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
        intent.putExtra("strContactNominee", strContactNominee);
        intent.putExtra("strNomineeDobEdit", strNomineeDobEdit);
        intent.putExtra("strYesPhysicalMentalRadio", strYesPhysicalMentalRadio);
        intent.putExtra("strYesPreExistingRadio", strYesPreExistingRadio);
        intent.putExtra("strBloodSugar", strBloodSugar);
        intent.putExtra("strBloodPressure", strBloodPressure);
        intent.putExtra("strBloodPressureDiastolic", strBloodPressureDiastolic);
        intent.putExtra("strcholesterol", strcholesterol);
        intent.putExtra("strSumInsured", strSumInsured);
        intent.putExtra("strBasicPremium", strBasicPremium);
        intent.putExtra("strPlanTypeTXT", strPlanTypeTXT);
        intent.putExtra("NetPremium", NetPremium);
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
        intent.putExtra("strPolicyNumber", strPolicyNumber);
        intent.putExtra("CoPaymentLoading", CoPaymentLoading);
        intent.putExtra("EmergencyTravellingStatus", EmergencyTravellingStatus);
        intent.putExtra("PosPolicyNo", PosPolicyNo);
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
        intent.putExtra("strCheckBoxSon", strCheckBoxSon);
        intent.putExtra("mCounter", mCounter);
        intent.putExtra("strFor", "1");
        intent.putExtra("strSpouseDobEdit", strSpouseDobEdit);
        intent.putExtra("strPackageOne", strPackageOne);
        intent.putExtra("strCheckBoxSelf", strCheckBoxSelf);
        intent.putExtra("addons", addons);
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
        intent.putExtra("strNomineeGenderEdit", strNomineeGenderEdit);
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
        intent.putExtra("LongTermDiscountStatus", LongTermDiscountStatus);
        intent.putExtra("SubCategoryDiscountStatus", SubCategoryDiscountStatus);
        intent.putExtra("SubCategory", SubCategory);
        intent.putExtra("DirectPolicyDiscountPremium", DirectPolicyDiscountPremium);
        intent.putExtra("FamilyTypeCounter", FamilyTypeCounter);
        intent.putExtra("LongTermDiscountDiscountPremium", LongTermDiscountDiscountPremium);
        intent.putExtra("SubCategoryDiscountPremium", SubCategoryDiscountPremium);
        intent.putExtra("doubleCoPaymentDiscountPremium", doubleCoPaymentDiscountPremium);
        intent.putExtra("str_oneFtSpinner", str_oneFtSpinner);
        intent.putExtra("str_oneInchesSpinner", str_oneInchesSpinner);
        intent.putExtra("str_oneWeightEdit", str_oneWeightEdit);
        intent.putExtra("strOccupationEditChildOne", strOccupationEditChildOne);
        intent.putExtra("str_twoOccupationSpinner", str_twoOccupationSpinner);
        intent.putExtra("str_thirdOccupationSpinner", str_thirdOccupationSpinner);
        intent.putExtra("str_fourOccupationSpinner", str_fourOccupationSpinner);
        intent.putExtra("str_thirdOccupationSpinner", str_thirdOccupationSpinner);
        intent.putExtra("yearRadio", yearRadio);
        intent.putExtra("str_age", str_age);
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
        intent.putExtra("strPackage1", strPackage1);
        intent.putExtra("strPackageTwo", strPackageTwo);
        intent.putExtra("strPackageThree", strPackageThree);
        intent.putExtra("strPackageFour", strPackageFour);
        intent.putExtra("strPackageFive", strPackageFive);
        intent.putExtra("strPackageSix", strPackageSix);
        intent.putExtra("FamilyComposition", FamilyComposition);
        intent.putExtra("ParentComposition", ParentComposition);
        intent.putExtra("PersonalAccidentCategory", PersonalAccidentCategory);
        intent.putExtra("PremiumWaiverStatus", PremiumWaiverStatus);
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
        intent.putExtra("strMedicalHistoryRadio", strMedicalHistoryRadio);
        intent.putExtra("strPersonRadio", strPersonRadio);
        intent.putExtra("strSmokerRadio", strSmokerRadio);
        intent.putExtra("strMedicineRadio", strMedicineRadio);
        intent.putExtra("strHospitalizationHistory", strHospitalizationHistory);
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
        intent.putExtra("GSt", GSt);
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
        intent.putExtra("selectYearProposer",selectYearProposer);
        intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
        intent.putExtra("strDob",strDob);
        intent.putExtra("strIDTypeName",strIDTypeName);
        intent.putExtra("permAndCorresAddSame",permAndCorresAddSame);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        methodBack();
    }
//    else if (strBloodSugar.equals("")){
//                        Toast.makeText(MemberMedicalInfoCHI.this, "Please enter Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                    }else if (Integer.parseInt(strBloodSugar) <= 70 || Integer.parseInt(strBloodSugar) >=99) {
//                        Toast.makeText(MemberMedicalInfoCHI.this, "Blood Sugar Level (Normal range between 70mg to 99mg) ", Toast.LENGTH_SHORT).show();
//                        bloodSugar.setText("");
//                    }else if (strBloodPressure.equals("")){
//                        Toast.makeText(MemberMedicalInfoCHI.this, "Please enter Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                    }else if (Integer.parseInt(strBloodPressure) <= 90 || Integer.parseInt(strBloodPressure) >=129) {
//                        Toast.makeText(MemberMedicalInfoCHI.this, "Blood Pressure (Systolic - Normal range 90 to 129) ", Toast.LENGTH_SHORT).show();
//                        bloodPressure.setText("");
//                    }else if (strBloodPressureDiastolic.equals("")){
//                        Toast.makeText(MemberMedicalInfoCHI.this, "Please enter Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                    }else if (Integer.parseInt(strBloodPressureDiastolic) <= 60 || Integer.parseInt(strBloodPressureDiastolic) >=79) {
//                        Toast.makeText(MemberMedicalInfoCHI.this, "Blood Pressure (Diastolic - Normal range 60 to 79)", Toast.LENGTH_SHORT).show();
//                        bloodPressureDiastolic.setText("");
//                    }else if (strcholesterol.equals("")){
//                        Toast.makeText(MemberMedicalInfoCHI.this, "Please enter Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                    }else if (Integer.parseInt(strcholesterol) <= 150 || Integer.parseInt(strcholesterol) >=199) {
//                        Toast.makeText(MemberMedicalInfoCHI.this, "Cholesterol Level (mg/dL) (Normal range 150 to 199)", Toast.LENGTH_SHORT).show();
//                        cholesterol.setText("");
//                    }
}