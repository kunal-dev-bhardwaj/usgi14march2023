package com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
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
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.ArogyaBmiCalculation.ArogyaCalculation;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.ArogyaBmiCalculation.ArogyaCalculationAdult;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.ArogyaBmiCalculation.ArogyaCalculationFather;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.ArogyaBmiCalculation.ArogyaCalculationFatherLaw;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.ArogyaBmiCalculation.ArogyaCalculationMother;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.ArogyaBmiCalculation.ArogyaCalculationMotherLaw;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.ArogyaBmiCalculation.ArogyacalculationOne;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.ArogyaBmiCalculation.ArogyacalculationThree;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.ArogyaBmiCalculation.ArogyacalculationTwo;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.ArogyaBmiCalculation.Arogyacalculationfour;

import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculation;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationAdult;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationOne;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationThree;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationTwo;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationfour;


public class Arogya_Member_info extends AppCompatActivity {
      Button btn_continue,btn_recalculate;
      String str_life_style_spinner,strFirstString,strFourString,strLoyaltyDiscount,str_Payment_spinner,new_str_age,str_existing_spinner,strExisting_policy_number,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_family_individual="",str_edit_adult="",str_no_child="",str_no_parent="",str_deductible="",str_sum_insured="",str_premium_amount="",TotalInstallPremium,QuoteId,TotalPremium,
    NetPremium, GST, str_RelationEdit, strRelationAdultOneEdit, strRelationChildEdit, strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit,str_for,str_proposer_self_spinner="",str_edit_dob="",str_gender="",str_self="",str_occupation="",str_weight_edit="",str_spouse_edit_dob_dob,str_spouse_weight_edit,str_edt_Spouse_name,str_spouse_gender,str_ft,str_inches,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_edit,NetPremiumValue,strMotherRelationEdit,strMotherEdit,strMotherName,strMotherDob,strMotherDobString,strMotherOccupationEdit,strMotherFtEdit,strMotherInchesEdit,strMotherWeightEdit,strFatherLawDobString;
      LinearLayout two_adult_details_liner,proposer_liner,MotherFt,MotherInches,MotherOccupation,FatherOccupation,FatherFt,FatherInches,MotherLawOccupation,MotherLawFt,MotherLawInches,FatherLawFt,FatherLawInches;
    String[] yesNo,relation_with_insure,familyFloater,familyChildFloater,CompleteSumInsured,policyTenure;
    String[] gender;
    String[] occupation;
    String[] ft;
    String[] inches;
    String[] relation_with_insure_adult;
    EditText FatherName,FatherDob,FatherEdit,FatherOccupationEdit,FatherFtEdit,FatherInchesEdit,FatherWeightEdit,FatherRelationEdit,MotherLawName,MotherLawDob,MotherLawEdit,MotherLawOccupationEdit,MotherLawFtEdit,MotherLawInchesEdit,MotherLawWeightEdit,MotherLawRelationEdit,FatherLawName,FatherLawDob,FatherLawEdit,FatherLawOccupationEdit,FatherLawFtEdit,FatherLawInchesEdit,FatherLawWeightEdit,FatherLawRelationEdit;
    String strFatherName,strFatherDob,strFatherDobString,strFatherEdit,strFatherOccupationEdit,strFatherFtEdit,strFatherInchesEdit,strFatherWeightEdit,strFatherRelationEdit,strMotherLawName,strMotherLawDob,strMotherLawDobString,strMotherLawEdit,strMotherLawFtEdit,strMotherLawOccupationEdit,strMotherLawInchesEdit,strMotherLawWeightEdit,strMotherLawRelationEdit,strFatherLawName,strFatherLawDob,strFatherLawEdit,strFatherLawOccupationEdit,strFatherLawFtEdit,strFatherLawInchesEdit,strFatherLawWeightEdit,strFatherLawRelationEdit;
    EditText spouse_gender_spinner,edit_ft,edit_inches,edit_occupation,edit_gender,oneFtSpinner,oneInchesSpinner,twoGenderSpinner,twoFtSpinner,twoInchesSpinner,thirdGenderSpinner,thirdFtSpinner,thirdInchesSpinner,fourGenderSpinner,fourFtSpinner,fourInchesSpinner,spouse_occupation_spinner,spouse_ft_spinner,spouse_inches_spinner,oneGenderSpinner,IndividualTypeEdit,policyType_spinner,proposer_edt_name,edt_name,edit_dob,weight_edit,edt_Spouse_name,spouse_edit_dob,spouse_weight_edit,totalPremiumAmount;
    Spinner proposer_spinner,proposer_self_spinner,familyType_spinner,gender_spinner,occupation_spinner,ft_spinner,inches_spinner;
    LinearLayout MotherLiner,FatherLiner,MotherLawLiner,FatherLawLiner,adultLiner,spouseLiner,oneChildLiner,twoChildLiner,threeChildLiner,fourChildLiner,gender_liner,linerOccupation,ftLiner,LinerInches,spouseGender,spouseOccupation,spouseFt,spouseInches,spouseRelationLiner,ChildOneGender,ChildOneLinerRelation,LinerFtChildOne,LinerInchesChildOne,childTwoGenderLiner,LinerChildTwoFt,LinerChildTwoInches,ChildTwoRelationLiner,thirdLinerGender,LinerFtThird,thirdInchesLiner,RelationThirdLiner,LinerGenderFour,LinerFtFour,LinerInchesFour,LinerRelationFour,FatherLawOccupation;
    private SimpleDateFormat dateFormatter;
    String str_new_dob,today,tomorrowDate,nextYear,strThirdDString ;
    Date date,CurrentDate,SelectDate;
    TextView show_Breakup;
     MySharedPreference pref;
    ImageView sumInsuredDropDown;
    Format formatter;
    EditText MotherDob,MotherName,MotherRelationEdit,MotherFtEdit,MotherInchesEdit,MotherWeightEdit,MotherOccupationEdit,MotherEdit,RelationEdit,BMIAdultOneEdit,RelationChildThreeEdit,RelationFourChildEdit,RelationChildTwoEdit,RelationChildEdit,RelationAdultOneEdit,familyTypeEdit,sumInsuredEdit,Payment_spinner,policyTenureEdit,
            QuotationID,SumInsured_spinner,BMIEdit,policyTenure_edit,policyTenure_spinner,OneEditName,OneDob,oneOccupationSpinner,oneWeightEdit,twoChildEditName,twoOccupationSpinner,twoDob,twoWeightEdit,thirdNameEdit,thirdDob,thirdOccupationSpinner,thirdWeightEdit,fourNameEdit,fourDob,fourOccupationSpinner,FourWeightEdit;
    String strParentEditText,TotalValue,PosPolicyNo,str_policyType_spinner,str_IndividualTypeEdit,str_SumInsured,str_policyTenure,strFirstTString,str_twoChildEditName,str_thirdNameEdit,str_fourNameEdit,str_oneWeightEdit,str_thirdWeightEdit,strFourWeightEdit,str_spouse_edit_dob="",str_edit_dob3String,str_OneEditName,str_edit_dob3StringSpouse,strOneChild,strChildOne,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,strtwoDob,strChildTwo,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,str_SumInsured_spinner,
            strthreeDob,strChildThree,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,strfourDob,strChildFour,str_fourGenderSpinner,str_fourOccupationSpinner,str_fourFtSpinner,str_fourInchesSpinner;
    double kg = 0.0;
    double BMI=0.0;
    double cm=0.0;
    double Individual_BMI=0.0,twoAdult_BMI=0.0,OneChildBMI,TwoChildBMI,ThreeChildBMI,FourChildBMI,MotherBMI=0.0,FatherBMI,MotherLawBMI,FatherLawBMI;
    public Period period;
    int selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour,selectIntMonth,selectInt1,selectInt2,daysLeft,daysLeftChild2,daysLeftChild3,daysLeftChild4,selectYearMother,SelectMonthMother,SelectDaysMother,selectYearFatherLaw,SelectMonthFatherLaw,SelectDaysFatherLaw,selectYearFather,SelectMonthFather,SelectDaysFather,selectYearMotherLaw,SelectMonthMotherLaw,SelectDaysMotherLaw,FamilyTypeCounter,ParentCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arogya__member_info);
        getWindow().setStatusBarColor(ContextCompat.getColor(Arogya_Member_info.this, R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(Arogya_Member_info.this);
        str_edt_name = getIntent().getStringExtra("str_edt_name");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        str_email = getIntent().getStringExtra("str_email");
        str_age = getIntent().getStringExtra("str_age");
        str_reference_no = getIntent().getStringExtra("str_reference_no");
        str_edit_dob = getIntent().getStringExtra("str_edit_dob");
        str_gender = getIntent().getStringExtra("str_gender");
        str_occupation = getIntent().getStringExtra("str_occupation");
        str_ft = getIntent().getStringExtra("str_ft");
        str_edit_dob3String = getIntent().getStringExtra("str_edit_dob3String");
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
        TotalValue = getIntent().getStringExtra("TotalValue");
        strFirstTString = getIntent().getStringExtra("strFirstTString");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        strChildOne = getIntent().getStringExtra("strChildOne");
        strChildTwo = getIntent().getStringExtra("strChildTwo");
        strChildThree = getIntent().getStringExtra("strChildThree");
        strChildFour = getIntent().getStringExtra("strChildFour");
        NetPremiumValue = getIntent().getStringExtra("NetPremiumValue");
        strOneChild = getIntent().getStringExtra("strOneChild");
        str_oneWeightEdit = getIntent().getStringExtra("str_oneWeightEdit");
        strtwoDob = getIntent().getStringExtra("strtwoDob");
        strthreeDob = getIntent().getStringExtra("strthreeDob");
        strfourDob = getIntent().getStringExtra("strfourDob");
        strtwoWeightEdit = getIntent().getStringExtra("strtwoWeightEdit");
        str_thirdWeightEdit = getIntent().getStringExtra("str_thirdWeightEdit");
        strFourWeightEdit = getIntent().getStringExtra("strFourWeightEdit");
        GST = getIntent().getStringExtra("GST");
        str_RelationEdit = getIntent().getStringExtra("str_RelationEdit");
        strRelationAdultOneEdit = getIntent().getStringExtra("strRelationAdultOneEdit");
        strRelationChildEdit = getIntent().getStringExtra("strRelationChildEdit");
        strRelationChildTwoEdit = getIntent().getStringExtra("strRelationChildTwoEdit");
        strRelationChildThreeEdit = getIntent().getStringExtra("strRelationChildThreeEdit");
        strRelationFourChildEdit = getIntent().getStringExtra("strRelationFourChildEdit");
        NetPremium = getIntent().getStringExtra("NetPremium");
        QuoteId = getIntent().getStringExtra("QuoteId");
        TotalInstallPremium = getIntent().getStringExtra("TotalInstallPremium");
        str_for = getIntent().getStringExtra("for");
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
        str_life_style_spinner = getIntent().getStringExtra("str_life_style_spinner");
        strParentEditText = getIntent().getStringExtra("strParentEditText");
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
        strMotherFtEdit = getIntent().getStringExtra("strMotherFtEdit");
        strMotherInchesEdit = getIntent().getStringExtra("strMotherInchesEdit");
        strFatherFtEdit = getIntent().getStringExtra("strFatherFtEdit");
        strFatherInchesEdit = getIntent().getStringExtra("strFatherInchesEdit");
        strMotherLawFtEdit = getIntent().getStringExtra("strMotherLawFtEdit");
        strMotherLawInchesEdit = getIntent().getStringExtra("strMotherLawInchesEdit");
        strFatherLawFtEdit = getIntent().getStringExtra("strFatherLawFtEdit");
        strFatherLawInchesEdit = getIntent().getStringExtra("strFatherLawInchesEdit");

        if (str_for.equals("1")){
            BMI = getIntent().getDoubleExtra("BMI", BMI);
            Individual_BMI = getIntent().getDoubleExtra("Individual_BMI", Individual_BMI);
            twoAdult_BMI = getIntent().getDoubleExtra("twoAdult_BMI", twoAdult_BMI);
            OneChildBMI = getIntent().getDoubleExtra("OneChildBMI", OneChildBMI);
            TwoChildBMI = getIntent().getDoubleExtra("TwoChildBMI", TwoChildBMI);
            ThreeChildBMI = getIntent().getDoubleExtra("ThreeChildBMI", ThreeChildBMI);
            FourChildBMI = getIntent().getDoubleExtra("ThreeChildBMI", FourChildBMI);
            MotherBMI = getIntent().getDoubleExtra("MotherBMI", MotherBMI);
            FatherBMI = getIntent().getDoubleExtra("FatherBMI", FatherBMI);
            MotherLawBMI = getIntent().getDoubleExtra("MotherLawBMI", MotherLawBMI);
            FatherLawBMI = getIntent().getDoubleExtra("FatherLawBMI", FatherLawBMI);
            selectYearAdult = getIntent().getIntExtra("selectYearAdult", 0);
            selectYearSecondAdult = getIntent().getIntExtra("selectYearSecondAdult", 0);
            selectYearChild = getIntent().getIntExtra("selectYearChild", 0);
            selectYearChildTwo = getIntent().getIntExtra("selectYearChildTwo", 0);
            selectYearChildThird = getIntent().getIntExtra("selectYearChildThird", 0);
            selectYearChildFour = getIntent().getIntExtra("selectYearChildFour", 0);
            selectYearMother = getIntent().getIntExtra("selectYearMother", 0);
            selectYearFather = getIntent().getIntExtra("selectYearFather", 0);
            selectYearMotherLaw = getIntent().getIntExtra("selectYearMotherLaw", 0);
            selectYearFatherLaw = getIntent().getIntExtra("selectYearFatherLaw", 0);
        }
        String[] strParts =  str_age.split("yrs");
         strFirstString = strParts[0];


        String[] strParts1 = str_age.split("-");
        String strFirstString1 = strParts1[0]; // 004
        String strSecondString1 = strParts1[1];

        String[] strParts2 =  strSecondString1.split("yrs");
        strFourString = strParts2[0];



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
        int new_dob= Integer.parseInt(strThirdDString)- Integer.parseInt(strFirstString);
        Log.e("new_dob", String.valueOf(new_dob));
        str_new_dob=strFirstDString+"/"+ strSecondDString + "/"+String.valueOf(new_dob);
        Log.e("str_new_dob", str_new_dob);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        tomorrowDate = formatter.format(date);
        Log.e("tomorrowDate",tomorrowDate);
        calendar.add(Calendar.DATE, 364);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        nextYear = formatter.format(date);
        Log.e("nextYear",nextYear);

        init();
    }
    private void init() {
        familyTypeEdit=findViewById(R.id.familyTypeEdit);
        sumInsuredEdit=findViewById(R.id.sumInsuredEdit);
        policyTenureEdit=findViewById(R.id.policyTenureEdit);
        proposer_spinner=findViewById(R.id.proposer_spinner);
        proposer_liner=findViewById(R.id.proposer_liner);
        btn_continue=findViewById(R.id.btn_continue);
        edt_name=findViewById(R.id.edt_name);
        edit_dob=findViewById(R.id.edit_dob);
        IndividualTypeEdit=findViewById(R.id.IndividualTypeEdit);
        policyType_spinner=findViewById(R.id.policyType_spinner);
        Payment_spinner=findViewById(R.id.Payment_spinner);
//        familyType_spinner=findViewById(R.id.familyType_spinner);
        SumInsured_spinner=findViewById(R.id.SumInsured_spinner);
        sumInsuredDropDown=findViewById(R.id.sumInsuredDropDown);
        RelationEdit=findViewById(R.id.RelationEdit);
        gender_spinner=findViewById(R.id.gender_spinner);
        BMIAdultOneEdit=findViewById(R.id.BMIAdultOneEdit);
        RelationChildThreeEdit=findViewById(R.id.RelationChildThreeEdit);
        RelationFourChildEdit=findViewById(R.id.RelationFourChildEdit);
        RelationChildTwoEdit=findViewById(R.id.RelationChildTwoEdit);
        RelationChildEdit=findViewById(R.id.RelationChildEdit);
        RelationAdultOneEdit=findViewById(R.id.RelationAdultOneEdit);
        spouse_gender_spinner=findViewById(R.id.spouse_gender_spinner);
//        occupation_spinner=findViewById(R.id.occupation_spinner);
        spouse_occupation_spinner=findViewById(R.id.spouse_occupation_spinner);
        ft_spinner=findViewById(R.id.ft_spinner);
        spouse_ft_spinner=findViewById(R.id.spouse_ft_spinner);
        inches_spinner=findViewById(R.id.inches_spinner);
        spouse_inches_spinner=findViewById(R.id.spouse_inches_spinner);
        weight_edit=findViewById(R.id.weight_edit);
        edt_Spouse_name=findViewById(R.id.edt_Spouse_name);
        spouse_edit_dob=findViewById(R.id.spouse_edit_dob);
        spouse_weight_edit=findViewById(R.id.spouse_weight_edit);
        totalPremiumAmount=findViewById(R.id.totalPremiumAmount);
        QuotationID=findViewById(R.id.QuotationID);
        oneChildLiner=findViewById(R.id.oneChildLiner);
        twoChildLiner=findViewById(R.id.twoChildLiner);
        threeChildLiner=findViewById(R.id.threeChildLiner);
        fourChildLiner=findViewById(R.id.fourChildLiner);
        spouseLiner=findViewById(R.id.spouseLiner);
        adultLiner=findViewById(R.id.adultLiner);
        policyTenure_edit=findViewById(R.id.policyTenure_edit);
        edit_gender=findViewById(R.id.edit_gender);
        edit_occupation=findViewById(R.id.edit_occupation);
        edit_ft=findViewById(R.id.edit_ft);
        edit_inches=findViewById(R.id.edit_inches);
        show_Breakup=findViewById(R.id.show_Breakup);
        BMIEdit=findViewById(R.id.BMIEdit);
        OneEditName=findViewById(R.id.OneEditName);
        OneDob=findViewById(R.id.OneChildDob);
        oneGenderSpinner=findViewById(R.id.oneGenderSpinner);
        oneOccupationSpinner=findViewById(R.id.oneOccupationSpinner);
        oneFtSpinner=findViewById(R.id.oneFtSpinner);
        oneInchesSpinner=findViewById(R.id.oneInchesSpinner);
        oneWeightEdit=findViewById(R.id.oneWeightEdit);

        gender_liner=findViewById(R.id.gender_liner);
        linerOccupation=findViewById(R.id.linerOccupation);
        ftLiner=findViewById(R.id.ftLiner);
        LinerInches=findViewById(R.id.LinerInches);

        spouseGender=findViewById(R.id.spouseGender);
        spouseOccupation=findViewById(R.id.spouseOccupation);
        spouseFt=findViewById(R.id.spouseFt);
        spouseInches=findViewById(R.id.spouseInches);

        ChildOneGender=findViewById(R.id.ChildOneGender);
        LinerFtChildOne=findViewById(R.id.LinerFtChildOne);
        LinerInchesChildOne=findViewById(R.id.LinerInchesChildOne);

        childTwoGenderLiner=findViewById(R.id.childTwoGenderLiner);
        LinerChildTwoFt=findViewById(R.id.LinerChildTwoFt);
        LinerChildTwoInches=findViewById(R.id.LinerChildTwoInches);

        thirdLinerGender=findViewById(R.id.thirdLinerGender);
        LinerFtThird=findViewById(R.id.LinerFtThird);
        thirdInchesLiner=findViewById(R.id.thirdInchesLiner);

        LinerGenderFour=findViewById(R.id.LinerGenderFour);
        LinerFtFour=findViewById(R.id.LinerFtFour);
        LinerInchesFour=findViewById(R.id.LinerInchesFour);

        spouseRelationLiner=findViewById(R.id.spouseRelationLiner);
        ChildOneLinerRelation=findViewById(R.id.ChildOneLinerRelation);
        ChildTwoRelationLiner=findViewById(R.id.ChildTwoRelationLiner);
        RelationThirdLiner=findViewById(R.id.RelationThirdLiner);
        LinerRelationFour=findViewById(R.id.LinerRelationFour);

        twoChildEditName=findViewById(R.id.twoChildEditName);
        twoDob=findViewById(R.id.twoDob);
        twoGenderSpinner=findViewById(R.id.twoGenderSpinner);
        twoOccupationSpinner=findViewById(R.id.twoOccupationSpinner);
        twoFtSpinner=findViewById(R.id.twoFtSpinner);
        twoInchesSpinner=findViewById(R.id.twoInchesSpinner);
        twoWeightEdit=findViewById(R.id.twoWeightEdit);

        thirdNameEdit=findViewById(R.id.thirdNameEdit);
        thirdDob=findViewById(R.id.thirdDob);
        thirdGenderSpinner=findViewById(R.id.thirdGenderSpinner);
        thirdInchesSpinner=findViewById(R.id.thirdInchesSpinner);
        thirdFtSpinner=findViewById(R.id.thirdFtSpinner);
        thirdOccupationSpinner=findViewById(R.id.thirdOccupationSpinner);
        thirdWeightEdit=findViewById(R.id.thirdWeightEdit);

        fourNameEdit=findViewById(R.id.fourNameEdit);
        fourDob=findViewById(R.id.fourDob);
        fourGenderSpinner=findViewById(R.id.fourGenderSpinner);
        fourOccupationSpinner=findViewById(R.id.fourOccupationSpinner);
        fourFtSpinner=findViewById(R.id.fourFtSpinner);
        fourInchesSpinner=findViewById(R.id.fourInchesSpinner);
        FourWeightEdit=findViewById(R.id.FourWeightEdit);
       //mother
        MotherLiner=findViewById(R.id.MotherLiner);
        MotherName=findViewById(R.id.MotherName);
        MotherDob=findViewById(R.id.MotherDob);
        MotherOccupationEdit=findViewById(R.id.MotherOccupationEdit);
        MotherEdit=findViewById(R.id.MotherEdit);
        MotherFt=findViewById(R.id.MotherFt);
        MotherInchesEdit=findViewById(R.id.MotherInchesEdit);
        MotherWeightEdit=findViewById(R.id.MotherWeightEdit);
        MotherRelationEdit=findViewById(R.id.MotherRelationEdit);
        MotherFtEdit=findViewById(R.id.MotherFtEdit);
        MotherInches=findViewById(R.id.MotherInches);
        MotherOccupation=findViewById(R.id.MotherOccupation);
        //father
        FatherLiner=findViewById(R.id.FatherLiner);
        FatherName=findViewById(R.id.FatherName);
        FatherDob=findViewById(R.id.FatherDob);
        FatherEdit=findViewById(R.id.FatherEdit);
        FatherOccupation=findViewById(R.id.FatherOccupation);
        FatherOccupationEdit=findViewById(R.id.FatherOccupationEdit);
        FatherFt=findViewById(R.id.FatherFt);
        FatherFtEdit=findViewById(R.id.FatherFtEdit);
        FatherInches=findViewById(R.id.FatherInches);
        FatherInchesEdit=findViewById(R.id.FatherInchesEdit);
        FatherWeightEdit=findViewById(R.id.FatherWeightEdit);
        FatherRelationEdit=findViewById(R.id.FatherRelationEdit);
        //mother-in-law
        MotherLawLiner=findViewById(R.id.MotherLawLiner);
        MotherLawName=findViewById(R.id.MotherLawName);
        MotherLawDob=findViewById(R.id.MotherLawDob);
        MotherLawEdit=findViewById(R.id.MotherLawEdit);
        MotherLawOccupation=findViewById(R.id.MotherLawOccupation);
        MotherLawOccupationEdit=findViewById(R.id.MotherLawOccupationEdit);
        MotherLawFt=findViewById(R.id.MotherLawFt);
        MotherLawFtEdit=findViewById(R.id.MotherLawFtEdit);
        MotherLawInches=findViewById(R.id.MotherLawInches);
        MotherLawInchesEdit=findViewById(R.id.MotherLawInchesEdit);
        MotherLawWeightEdit=findViewById(R.id.MotherLawWeightEdit);
        MotherLawRelationEdit=findViewById(R.id.MotherLawRelationEdit);
        //father-in-law
        FatherLawLiner=findViewById(R.id.FatherLawLiner);
        FatherLawName=findViewById(R.id.FatherLawName);
        FatherLawDob=findViewById(R.id.FatherLawDob);
        FatherLawEdit=findViewById(R.id.FatherLawEdit);
        FatherLawOccupation=findViewById(R.id.FatherLawOccupation);
        FatherLawOccupationEdit=findViewById(R.id.FatherLawOccupationEdit);
        FatherLawFt=findViewById(R.id.FatherLawFt);
        FatherLawFtEdit=findViewById(R.id.FatherLawFtEdit);
        FatherLawInches=findViewById(R.id.FatherLawInches);
        FatherLawInchesEdit=findViewById(R.id.FatherLawInchesEdit);
        FatherLawWeightEdit=findViewById(R.id.FatherLawWeightEdit);
        FatherLawRelationEdit=findViewById(R.id.FatherLawRelationEdit);

        yesNo=getResources().getStringArray(R.array.yesNo);
        relation_with_insure=getResources().getStringArray(R.array.relation_with_insure);

        policyType_spinner.setText(str_policyType_spinner);
        policyType_spinner.setAlpha(0.5f);
        familyTypeEdit.setText(str_IndividualTypeEdit);
        familyTypeEdit.setAlpha(0.5f);
        sumInsuredEdit.setText(str_SumInsured);
        sumInsuredEdit.setAlpha(0.5f);
        Payment_spinner.setText(str_Payment_spinner);
        Payment_spinner.setAlpha(0.5f);
        policyTenureEdit.setText(strFirstTString+" Year");
        policyTenureEdit.setAlpha(0.5f);
        totalPremiumAmount.setText(TotalValue);
        totalPremiumAmount.setAlpha(0.5f);
        QuotationID.setText(QuoteId);
        QuotationID.setAlpha(0.5f);
        adultLiner.setVisibility(View.VISIBLE);
        spouseLiner.setVisibility(View.VISIBLE);
        oneChildLiner.setVisibility(View.GONE);
        twoChildLiner.setVisibility(View.GONE);
        threeChildLiner.setVisibility(View.GONE);
        fourChildLiner.setVisibility(View.GONE);

        str_RelationEdit="Self";
        RelationEdit.setText(str_RelationEdit);


        if (str_policyType_spinner.equals("Individual")){
            adultLiner.setVisibility(View.VISIBLE);
            spouseLiner.setVisibility(View.GONE);
            oneChildLiner.setVisibility(View.GONE);
            twoChildLiner.setVisibility(View.GONE);
            threeChildLiner.setVisibility(View.GONE);
            fourChildLiner.setVisibility(View.GONE);
            MotherLiner.setVisibility(View.GONE);
            FatherLiner.setVisibility(View.GONE);
            MotherLawLiner.setVisibility(View.GONE);
            FatherLawLiner.setVisibility(View.GONE);
//            str_for="1";
        }
        else {
            if(str_IndividualTypeEdit.equals("2 Adult")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.VISIBLE);
                oneChildLiner.setVisibility(View.GONE);
                twoChildLiner.setVisibility(View.GONE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
//                str_for="1";
            }
            else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.GONE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.GONE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
//                str_for="1";
            }
            else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.GONE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.VISIBLE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
                str_twoOccupationSpinner="Student";
                twoOccupationSpinner.setText(str_twoOccupationSpinner);
//                str_for="1";
            }
            else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.GONE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.VISIBLE);
                threeChildLiner.setVisibility(View.VISIBLE);
                fourChildLiner.setVisibility(View.GONE);
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
                str_twoOccupationSpinner="Student";
                twoOccupationSpinner.setText(str_twoOccupationSpinner);
                str_thirdOccupationSpinner="Student";
                thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
//                str_for="1";
            }
            else if(str_IndividualTypeEdit.equals("1 Adult + 4 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.GONE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.VISIBLE);
                threeChildLiner.setVisibility(View.VISIBLE);
                fourChildLiner.setVisibility(View.VISIBLE);
//                str_for="1";
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
                str_twoOccupationSpinner="Student";
                twoOccupationSpinner.setText(str_twoOccupationSpinner);
                str_thirdOccupationSpinner="Student";
                thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
                str_fourOccupationSpinner="Student";
                fourOccupationSpinner.setText(str_fourOccupationSpinner);
            }
            else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.VISIBLE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.GONE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
//                str_for="1";
            }
            else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.VISIBLE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.VISIBLE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
//                str_for="1";
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
                str_twoOccupationSpinner="Student";
                twoOccupationSpinner.setText(str_twoOccupationSpinner);
            }
            else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.VISIBLE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.VISIBLE);
                threeChildLiner.setVisibility(View.VISIBLE);
                fourChildLiner.setVisibility(View.GONE);
//                str_for="1";
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
                str_twoOccupationSpinner="Student";
                twoOccupationSpinner.setText(str_twoOccupationSpinner);
                str_thirdOccupationSpinner="Student";
                thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
            }
            else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.VISIBLE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.VISIBLE);
                threeChildLiner.setVisibility(View.VISIBLE);
                fourChildLiner.setVisibility(View.VISIBLE);
//                str_for="1";
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
                str_twoOccupationSpinner="Student";
                twoOccupationSpinner.setText(str_twoOccupationSpinner);
                str_thirdOccupationSpinner="Student";
                thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
                str_fourOccupationSpinner="Student";
                fourOccupationSpinner.setText(str_fourOccupationSpinner);
            }
            else{
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.GONE);
                oneChildLiner.setVisibility(View.GONE);
                twoChildLiner.setVisibility(View.GONE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
            }

            if (strParentEditText.equals("Mother")){
                MotherLiner.setVisibility(View.VISIBLE);
                FatherLiner.setVisibility(View.GONE);
                MotherLawLiner.setVisibility(View.GONE);
                FatherLawLiner.setVisibility(View.GONE);
            }else if (strParentEditText.equals("Father")){
                MotherLiner.setVisibility(View.GONE);
                FatherLiner.setVisibility(View.VISIBLE);
                MotherLawLiner.setVisibility(View.GONE);
                FatherLawLiner.setVisibility(View.GONE);
            }else if (strParentEditText.equals("Mother & Father")){
                MotherLiner.setVisibility(View.VISIBLE);
                FatherLiner.setVisibility(View.VISIBLE);
                MotherLawLiner.setVisibility(View.GONE);
                FatherLawLiner.setVisibility(View.GONE);
            }else if (strParentEditText.equals("Mother-In-Law")){
                MotherLiner.setVisibility(View.GONE);
                FatherLiner.setVisibility(View.GONE);
                MotherLawLiner.setVisibility(View.VISIBLE);
                FatherLawLiner.setVisibility(View.GONE);
            }else if (strParentEditText.equals("Father-In-Law")){
                MotherLiner.setVisibility(View.GONE);
                FatherLiner.setVisibility(View.GONE);
                MotherLawLiner.setVisibility(View.GONE);
                FatherLawLiner.setVisibility(View.VISIBLE);
            }else if (strParentEditText.equals("Mother-In-Law & Father-In-Law")){
                MotherLiner.setVisibility(View.GONE);
                FatherLiner.setVisibility(View.GONE);
                MotherLawLiner.setVisibility(View.VISIBLE);
                FatherLawLiner.setVisibility(View.VISIBLE);
            }else{
                MotherLiner.setVisibility(View.GONE);
                FatherLiner.setVisibility(View.GONE);
                MotherLawLiner.setVisibility(View.GONE);
                FatherLawLiner.setVisibility(View.GONE);
            }


        }
        edt_name.setText(str_edt_name);
        str_oneOccupationSpinner="Student";
        str_twoOccupationSpinner="Student";
        str_thirdOccupationSpinner="Student";
        str_fourOccupationSpinner="Student";
        oneOccupationSpinner.setText(str_oneOccupationSpinner);
        twoOccupationSpinner.setText(str_twoOccupationSpinner);
        thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
        fourOccupationSpinner.setText(str_fourOccupationSpinner);

        if (str_for.equals("1")){
            if (str_policyType_spinner.equals("Individual")){
                edit_dob.setText(str_edit_dob);
                gender_spinner.setVisibility(View.GONE);
                edit_gender.setVisibility(View.VISIBLE);
                edit_occupation.setVisibility(View.VISIBLE);
                edit_ft.setVisibility(View.VISIBLE);
                edit_inches.setVisibility(View.VISIBLE);
                inches_spinner.setVisibility(View.GONE);
                ft_spinner.setVisibility(View.GONE);
                edit_gender.setText(str_gender);
                edit_occupation.setText(str_occupation);
                edit_ft.setText(str_ft);
                edit_inches.setText(str_inches);
                weight_edit.setText(str_weight_edit);
                str_for="1";
            }
            else if (str_policyType_spinner.equals("Family Floater")){
                str_oneOccupationSpinner="Student";
                str_twoOccupationSpinner="Student";
                str_thirdOccupationSpinner="Student";
                str_fourOccupationSpinner="Student";
                familyTypeEdit.setText(str_IndividualTypeEdit);
                switch (str_IndividualTypeEdit) {
                    case "2 Adult":
                        adultLiner.setVisibility(View.VISIBLE);
                        spouseLiner.setVisibility(View.VISIBLE);
                        oneChildLiner.setVisibility(View.GONE);
                        twoChildLiner.setVisibility(View.GONE);
                        threeChildLiner.setVisibility(View.GONE);
                        fourChildLiner.setVisibility(View.GONE);
                        edit_dob.setText(str_edit_dob);
                        gender_spinner.setVisibility(View.GONE);
                        edit_gender.setVisibility(View.VISIBLE);
                        edit_occupation.setVisibility(View.VISIBLE);
                        edit_ft.setVisibility(View.VISIBLE);
                        edit_inches.setVisibility(View.VISIBLE);
                        inches_spinner.setVisibility(View.GONE);
                        ft_spinner.setVisibility(View.GONE);
                        edit_gender.setText(str_gender);
                        spouse_gender_spinner.setText(str_spouse_gender);
                        edit_occupation.setText(str_occupation);
                        spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                        edit_ft.setText(str_ft);
                        spouse_ft_spinner.setText(str_spouse_ft_spinner);
                        edit_inches.setText(str_inches);
                        spouse_inches_spinner.setText(str_spouse_inches_spinner);
                        weight_edit.setText(str_weight_edit);
                        edt_Spouse_name.setText(str_edt_Spouse_name);
                        spouse_edit_dob.setText(str_spouse_edit_dob_dob);
                        spouse_weight_edit.setText(str_spouse_weight_edit);
                        RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                        break;
                    case "1 Adult + 1 Child":
                        adultLiner.setVisibility(View.VISIBLE);
                        spouseLiner.setVisibility(View.GONE);
                        oneChildLiner.setVisibility(View.VISIBLE);
                        twoChildLiner.setVisibility(View.GONE);
                        threeChildLiner.setVisibility(View.GONE);
                        fourChildLiner.setVisibility(View.GONE);
                        edit_dob.setText(str_edit_dob);
                        gender_spinner.setVisibility(View.GONE);
                        edit_gender.setVisibility(View.VISIBLE);
                        edit_occupation.setVisibility(View.VISIBLE);
                        edit_ft.setVisibility(View.VISIBLE);
                        edit_inches.setVisibility(View.VISIBLE);
                        inches_spinner.setVisibility(View.GONE);
                        ft_spinner.setVisibility(View.GONE);
                        edit_gender.setText(str_gender);
                        edit_occupation.setText(str_occupation);
                        edit_ft.setText(str_ft);
                        edit_inches.setText(str_inches);
                        weight_edit.setText(str_weight_edit);
                        oneGenderSpinner.setText(str_oneGenderSpinner);
                        OneEditName.setText(str_OneEditName);
                        OneDob.setText(strOneChild);
                        oneOccupationSpinner.setText(str_oneOccupationSpinner);
                        oneWeightEdit.setText(str_oneWeightEdit);
                        oneFtSpinner.setText(str_oneFtSpinner);
                        oneInchesSpinner.setText(str_oneInchesSpinner);
                        RelationChildEdit.setText(strRelationChildEdit);
                        str_for = "1";
                        break;
                    case "1 Adult + 2 Child":
                        adultLiner.setVisibility(View.VISIBLE);
                        spouseLiner.setVisibility(View.GONE);
                        oneChildLiner.setVisibility(View.VISIBLE);
                        twoChildLiner.setVisibility(View.VISIBLE);
                        threeChildLiner.setVisibility(View.GONE);
                        fourChildLiner.setVisibility(View.GONE);
                        edit_dob.setText(str_edit_dob);
                        gender_spinner.setVisibility(View.GONE);
                        edit_gender.setVisibility(View.VISIBLE);
                        edit_occupation.setVisibility(View.VISIBLE);
                        edit_ft.setVisibility(View.VISIBLE);
                        edit_inches.setVisibility(View.VISIBLE);
                        inches_spinner.setVisibility(View.GONE);
                        ft_spinner.setVisibility(View.GONE);
                        edit_gender.setText(str_gender);
                        edit_occupation.setText(str_occupation);
                        edit_ft.setText(str_ft);
                        edit_inches.setText(str_inches);
                        weight_edit.setText(str_weight_edit);
                        OneEditName.setText(str_OneEditName);
                        OneDob.setText(strOneChild);
                        oneGenderSpinner.setText(str_oneGenderSpinner);
                        oneWeightEdit.setText(str_oneWeightEdit);
                        twoChildEditName.setText(str_twoChildEditName);
                        twoDob.setText(strtwoDob);
                        twoWeightEdit.setText(strtwoWeightEdit);
                        twoOccupationSpinner.setText(str_twoOccupationSpinner);
                        oneOccupationSpinner.setText(str_oneOccupationSpinner);
                        oneFtSpinner.setText(str_oneFtSpinner);
                        oneInchesSpinner.setText(str_oneInchesSpinner);
                        twoGenderSpinner.setText(str_twoGenderSpinner);
                        twoFtSpinner.setText(str_twoFtSpinner);
                        twoInchesSpinner.setText(str_twoInchesSpinner);
                        RelationChildEdit.setText(strRelationChildEdit);
                        RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                        str_for = "1";
                        break;
                    case "1 Adult + 3 Child":
                        adultLiner.setVisibility(View.VISIBLE);
                        spouseLiner.setVisibility(View.GONE);
                        oneChildLiner.setVisibility(View.VISIBLE);
                        twoChildLiner.setVisibility(View.VISIBLE);
                        threeChildLiner.setVisibility(View.VISIBLE);
                        fourChildLiner.setVisibility(View.GONE);
                        edit_occupation.setVisibility(View.VISIBLE);
                        edit_ft.setVisibility(View.VISIBLE);
                        edit_inches.setVisibility(View.VISIBLE);
                        inches_spinner.setVisibility(View.GONE);
                        ft_spinner.setVisibility(View.GONE);
                        edit_gender.setText(str_gender);
                        edit_dob.setText(str_edit_dob);
                        edit_occupation.setText(str_occupation);
                        edit_ft.setText(str_ft);
                        edit_inches.setText(str_inches);
                        weight_edit.setText(str_weight_edit);
                        edt_Spouse_name.setText(str_edt_Spouse_name);
                        spouse_gender_spinner.setText(str_spouse_gender);
                        spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                        spouse_ft_spinner.setText(str_spouse_ft_spinner);
                        spouse_inches_spinner.setText(str_spouse_inches_spinner);
                        spouse_edit_dob.setText(str_spouse_edit_dob_dob);
                        spouse_weight_edit.setText(str_spouse_weight_edit);
                        OneEditName.setText(str_OneEditName);
                        OneDob.setText(strOneChild);
                        oneWeightEdit.setText(str_oneWeightEdit);
                        oneGenderSpinner.setText(str_oneGenderSpinner);
                        oneFtSpinner.setText(str_oneFtSpinner);
                        oneInchesSpinner.setText(str_oneInchesSpinner);
                        twoChildEditName.setText(str_twoChildEditName);
                        twoDob.setText(strtwoDob);
                        twoWeightEdit.setText(strtwoWeightEdit);
                        thirdNameEdit.setText(str_thirdNameEdit);
                        thirdDob.setText(strthreeDob);
                        thirdWeightEdit.setText(str_thirdWeightEdit);
                        oneOccupationSpinner.setText(str_oneOccupationSpinner);
                        twoOccupationSpinner.setText(str_twoOccupationSpinner);
                        thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
                        twoGenderSpinner.setText(str_twoGenderSpinner);
                        twoFtSpinner.setText(str_twoFtSpinner);
                        twoInchesSpinner.setText(str_twoInchesSpinner);
                        thirdGenderSpinner.setText(str_thirdGenderSpinner);
                        thirdFtSpinner.setText(str_thirdFtSpinner);
                        thirdInchesSpinner.setText(str_thirdInchesSpinner);
                        RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                        RelationChildEdit.setText(strRelationChildEdit);
                        RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                        RelationChildThreeEdit.setText(strRelationChildThreeEdit);
                        str_for = "1";
                        break;
                    case "1 Adult + 4 Child":
                        adultLiner.setVisibility(View.VISIBLE);
                        spouseLiner.setVisibility(View.GONE);
                        oneChildLiner.setVisibility(View.VISIBLE);
                        twoChildLiner.setVisibility(View.VISIBLE);
                        threeChildLiner.setVisibility(View.VISIBLE);
                        fourChildLiner.setVisibility(View.VISIBLE);
                        edit_occupation.setVisibility(View.VISIBLE);
                        edit_ft.setVisibility(View.VISIBLE);
                        edit_inches.setVisibility(View.VISIBLE);
                        inches_spinner.setVisibility(View.GONE);
                        ft_spinner.setVisibility(View.GONE);
                        edit_gender.setText(str_gender);
                        edit_dob.setText(str_edit_dob);
                        edit_occupation.setText(str_occupation);
                        edit_ft.setText(str_ft);
                        edit_inches.setText(str_inches);
                        weight_edit.setText(str_weight_edit);
                        edt_Spouse_name.setText(str_edt_Spouse_name);
                        spouse_gender_spinner.setText(str_spouse_gender);
                        spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                        spouse_ft_spinner.setText(str_spouse_ft_spinner);
                        spouse_inches_spinner.setText(str_spouse_inches_spinner);
                        spouse_edit_dob.setText(str_spouse_edit_dob_dob);
                        spouse_weight_edit.setText(str_spouse_weight_edit);
                        OneEditName.setText(str_OneEditName);
                        OneDob.setText(strOneChild);
                        oneWeightEdit.setText(str_oneWeightEdit);
                        oneGenderSpinner.setText(str_oneGenderSpinner);
                        oneFtSpinner.setText(str_oneFtSpinner);
                        oneInchesSpinner.setText(str_oneInchesSpinner);
                        twoChildEditName.setText(str_twoChildEditName);
                        twoDob.setText(strtwoDob);
                        twoWeightEdit.setText(strtwoWeightEdit);
                        thirdNameEdit.setText(str_thirdNameEdit);
                        thirdDob.setText(strthreeDob);
                        thirdWeightEdit.setText(str_thirdWeightEdit);
                        fourNameEdit.setText(str_fourNameEdit);
                        fourDob.setText(strfourDob);
                        FourWeightEdit.setText(strFourWeightEdit);
                        oneOccupationSpinner.setText(str_oneOccupationSpinner);
                        twoOccupationSpinner.setText(str_twoOccupationSpinner);
                        thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
                        fourOccupationSpinner.setText(str_fourOccupationSpinner);
                        twoGenderSpinner.setText(str_twoGenderSpinner);
                        twoFtSpinner.setText(str_twoFtSpinner);
                        twoInchesSpinner.setText(str_twoInchesSpinner);
                        thirdGenderSpinner.setText(str_thirdGenderSpinner);
                        thirdFtSpinner.setText(str_thirdFtSpinner);
                        thirdInchesSpinner.setText(str_thirdInchesSpinner);
                        fourGenderSpinner.setText(str_fourGenderSpinner);
                        fourFtSpinner.setText(str_fourFtSpinner);
                        fourInchesSpinner.setText(str_fourInchesSpinner);
                        RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                        RelationChildEdit.setText(strRelationChildEdit);
                        RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                        RelationChildThreeEdit.setText(strRelationChildThreeEdit);
                        RelationFourChildEdit.setText(strRelationFourChildEdit);
                        str_for = "1";
                        break;
                        case "2 Adult + 1 Child":
                        adultLiner.setVisibility(View.VISIBLE);
                        spouseLiner.setVisibility(View.VISIBLE);
                        oneChildLiner.setVisibility(View.VISIBLE);
                        twoChildLiner.setVisibility(View.GONE);
                        threeChildLiner.setVisibility(View.GONE);
                        fourChildLiner.setVisibility(View.GONE);
                        edit_dob.setText(str_edit_dob);
                        gender_spinner.setVisibility(View.GONE);
                        edit_gender.setVisibility(View.VISIBLE);
                        edit_occupation.setVisibility(View.VISIBLE);
                        edit_ft.setVisibility(View.VISIBLE);
                        edit_inches.setVisibility(View.VISIBLE);
                        inches_spinner.setVisibility(View.GONE);
                        ft_spinner.setVisibility(View.GONE);
                        edit_gender.setText(str_gender);
                        spouse_gender_spinner.setText(str_spouse_gender);
                        edit_occupation.setText(str_occupation);
                        spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                        edit_ft.setText(str_ft);
                        spouse_ft_spinner.setText(str_spouse_ft_spinner);
                        edit_inches.setText(str_inches);
                        spouse_inches_spinner.setText(str_spouse_inches_spinner);
                        weight_edit.setText(str_weight_edit);
                        edt_Spouse_name.setText(str_edt_Spouse_name);
                        spouse_edit_dob.setText(str_spouse_edit_dob_dob);
                        spouse_weight_edit.setText(str_spouse_weight_edit);
                        OneEditName.setText(str_OneEditName);
                        OneDob.setText(strOneChild);
                        oneGenderSpinner.setText(str_oneGenderSpinner);
                        oneWeightEdit.setText(str_oneWeightEdit);
                        oneOccupationSpinner.setText(str_oneOccupationSpinner);
                        oneFtSpinner.setText(str_oneFtSpinner);
                        oneInchesSpinner.setText(str_oneInchesSpinner);
                        RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                        RelationChildEdit.setText(strRelationChildEdit);
                        str_for = "1";
                        break;
                    case "2 Adult + 2 Child":
                        adultLiner.setVisibility(View.VISIBLE);
                        spouseLiner.setVisibility(View.VISIBLE);
                        oneChildLiner.setVisibility(View.VISIBLE);
                        twoChildLiner.setVisibility(View.VISIBLE);
                        threeChildLiner.setVisibility(View.GONE);
                        fourChildLiner.setVisibility(View.GONE);
                        edit_dob.setText(str_edit_dob);
                        gender_spinner.setVisibility(View.GONE);
                        edit_gender.setVisibility(View.VISIBLE);
                        edit_occupation.setVisibility(View.VISIBLE);
                        edit_ft.setVisibility(View.VISIBLE);
                        edit_inches.setVisibility(View.VISIBLE);

                        inches_spinner.setVisibility(View.GONE);
                        ft_spinner.setVisibility(View.GONE);
                        edit_gender.setText(str_gender);
                        spouse_gender_spinner.setText(str_spouse_gender);
                        edit_occupation.setText(str_occupation);
                        spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                        edit_ft.setText(str_ft);
                        spouse_ft_spinner.setText(str_spouse_ft_spinner);
                        edit_inches.setText(str_inches);
                        spouse_inches_spinner.setText(str_spouse_inches_spinner);
                        weight_edit.setText(str_weight_edit);
                        edt_Spouse_name.setText(str_edt_Spouse_name);
                        spouse_edit_dob.setText(str_spouse_edit_dob_dob);
                        spouse_weight_edit.setText(str_spouse_weight_edit);
                        OneEditName.setText(str_OneEditName);
                        OneDob.setText(strOneChild);
                        oneGenderSpinner.setText(str_oneGenderSpinner);
                        oneWeightEdit.setText(str_oneWeightEdit);
                        twoChildEditName.setText(str_twoChildEditName);
                        twoDob.setText(strtwoDob);
                        twoWeightEdit.setText(strtwoWeightEdit);
                        twoOccupationSpinner.setText(str_twoOccupationSpinner);
                        oneOccupationSpinner.setText(str_oneOccupationSpinner);
                        oneFtSpinner.setText(str_oneFtSpinner);
                        oneInchesSpinner.setText(str_oneInchesSpinner);
                        twoGenderSpinner.setText(str_twoGenderSpinner);
                        twoFtSpinner.setText(str_twoFtSpinner);
                        twoInchesSpinner.setText(str_twoInchesSpinner);
                        RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                        RelationChildEdit.setText(strRelationChildEdit);
                        RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                        str_for = "1";
                        break;
                    case "2 Adult + 3 Child":
                        adultLiner.setVisibility(View.VISIBLE);
                        spouseLiner.setVisibility(View.VISIBLE);
                        oneChildLiner.setVisibility(View.VISIBLE);
                        twoChildLiner.setVisibility(View.VISIBLE);
                        threeChildLiner.setVisibility(View.VISIBLE);
                        fourChildLiner.setVisibility(View.GONE);
                        edit_dob.setText(str_edit_dob);
                        gender_spinner.setVisibility(View.GONE);
                        edit_gender.setVisibility(View.VISIBLE);
                        edit_occupation.setVisibility(View.VISIBLE);
                        edit_ft.setVisibility(View.VISIBLE);
                        edit_inches.setVisibility(View.VISIBLE);
                        inches_spinner.setVisibility(View.GONE);
                        ft_spinner.setVisibility(View.GONE);
                        edit_gender.setText(str_gender);
                        spouse_gender_spinner.setText(str_spouse_gender);
                        spouse_gender_spinner.setText(str_spouse_gender);
                        edit_occupation.setText(str_occupation);
                        spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                        edit_ft.setText(str_ft);
                        spouse_ft_spinner.setText(str_spouse_ft_spinner);
                        edit_inches.setText(str_inches);
                        spouse_inches_spinner.setText(str_spouse_inches_spinner);
                        weight_edit.setText(str_weight_edit);
                        edt_Spouse_name.setText(str_edt_Spouse_name);
                        spouse_edit_dob.setText(str_spouse_edit_dob_dob);
                        spouse_weight_edit.setText(str_spouse_weight_edit);
                        OneEditName.setText(str_OneEditName);
                        OneDob.setText(strOneChild);
                        oneWeightEdit.setText(str_oneWeightEdit);
                        oneGenderSpinner.setText(str_oneGenderSpinner);
                        twoChildEditName.setText(str_twoChildEditName);
                        twoDob.setText(strtwoDob);
                        twoWeightEdit.setText(strtwoWeightEdit);
                        thirdNameEdit.setText(str_thirdNameEdit);
                        thirdDob.setText(strthreeDob);
                        thirdWeightEdit.setText(str_thirdWeightEdit);
                        twoOccupationSpinner.setText(str_twoOccupationSpinner);
                        thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
                        oneOccupationSpinner.setText(str_oneOccupationSpinner);
                        oneFtSpinner.setText(str_oneFtSpinner);
                        oneInchesSpinner.setText(str_oneInchesSpinner);
                        twoGenderSpinner.setText(str_twoGenderSpinner);
                        twoFtSpinner.setText(str_twoFtSpinner);
                        twoInchesSpinner.setText(str_twoInchesSpinner);
                        thirdGenderSpinner.setText(str_thirdGenderSpinner);
                        thirdFtSpinner.setText(str_thirdFtSpinner);
                        thirdInchesSpinner.setText(str_thirdInchesSpinner);
                        RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                        RelationChildEdit.setText(strRelationChildEdit);
                        RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                        RelationChildThreeEdit.setText(strRelationChildThreeEdit);
                        str_for = "1";
                        break;
                    case "2 Adult + 4 Child":
                        adultLiner.setVisibility(View.VISIBLE);
                        spouseLiner.setVisibility(View.VISIBLE);
                        oneChildLiner.setVisibility(View.VISIBLE);
                        twoChildLiner.setVisibility(View.VISIBLE);
                        threeChildLiner.setVisibility(View.VISIBLE);
                        fourChildLiner.setVisibility(View.VISIBLE);
                        edit_occupation.setVisibility(View.VISIBLE);
                        edit_ft.setVisibility(View.VISIBLE);
                        edit_inches.setVisibility(View.VISIBLE);
                        inches_spinner.setVisibility(View.GONE);
                        ft_spinner.setVisibility(View.GONE);
                        edit_gender.setText(str_gender);
                        edit_dob.setText(str_edit_dob);
                        edit_occupation.setText(str_occupation);
                        edit_ft.setText(str_ft);
                        edit_inches.setText(str_inches);
                        weight_edit.setText(str_weight_edit);
                        edt_Spouse_name.setText(str_edt_Spouse_name);
                        spouse_gender_spinner.setText(str_spouse_gender);
                        spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                        spouse_ft_spinner.setText(str_spouse_ft_spinner);
                        spouse_inches_spinner.setText(str_spouse_inches_spinner);
                        spouse_edit_dob.setText(str_spouse_edit_dob_dob);
                        spouse_weight_edit.setText(str_spouse_weight_edit);
                        OneEditName.setText(str_OneEditName);
                        OneDob.setText(strOneChild);
                        oneWeightEdit.setText(str_oneWeightEdit);
                        oneGenderSpinner.setText(str_oneGenderSpinner);
                        oneFtSpinner.setText(str_oneFtSpinner);
                        oneInchesSpinner.setText(str_oneInchesSpinner);
                        twoChildEditName.setText(str_twoChildEditName);
                        twoDob.setText(strtwoDob);
                        twoWeightEdit.setText(strtwoWeightEdit);
                        thirdNameEdit.setText(str_thirdNameEdit);
                        thirdDob.setText(strthreeDob);
                        thirdWeightEdit.setText(str_thirdWeightEdit);
                        fourNameEdit.setText(str_fourNameEdit);
                        fourDob.setText(strfourDob);
                        FourWeightEdit.setText(strFourWeightEdit);
                        oneOccupationSpinner.setText(str_oneOccupationSpinner);
                        twoOccupationSpinner.setText(str_twoOccupationSpinner);
                        thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
                        fourOccupationSpinner.setText(str_fourOccupationSpinner);
                        twoGenderSpinner.setText(str_twoGenderSpinner);
                        twoFtSpinner.setText(str_twoFtSpinner);
                        twoInchesSpinner.setText(str_twoInchesSpinner);
                        thirdGenderSpinner.setText(str_thirdGenderSpinner);
                        thirdFtSpinner.setText(str_thirdFtSpinner);
                        thirdInchesSpinner.setText(str_thirdInchesSpinner);
                        fourGenderSpinner.setText(str_fourGenderSpinner);
                        fourFtSpinner.setText(str_fourFtSpinner);
                        fourInchesSpinner.setText(str_fourInchesSpinner);
                        RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                        RelationChildEdit.setText(strRelationChildEdit);
                        RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                        RelationChildThreeEdit.setText(strRelationChildThreeEdit);
                        RelationFourChildEdit.setText(strRelationFourChildEdit);
                        str_for = "1";
                        break;
                }

                if (strParentEditText.equals("Mother")){
                    MotherName.setText(strMotherName);
                    MotherDob.setText(strMotherDob);
                    MotherOccupationEdit.setText(strMotherOccupationEdit);
                    MotherWeightEdit.setText(strMotherWeightEdit);
                    MotherFtEdit.setText(strMotherFtEdit);
                    MotherInchesEdit.setText(strMotherInchesEdit);
                }else if (strParentEditText.equals("Father")){
                    FatherName.setText(strFatherName);
                    FatherDob.setText(strFatherDob);
                    FatherWeightEdit.setText(strFatherWeightEdit);
                    FatherOccupationEdit.setText(strFatherOccupationEdit);
                    FatherFtEdit.setText(strFatherFtEdit);
                    FatherInchesEdit.setText(strFatherInchesEdit);
                }else if (strParentEditText.equals("Mother & Father")){
                    MotherName.setText(strMotherName);
                    MotherDob.setText(strMotherDob);
                    MotherOccupationEdit.setText(strMotherOccupationEdit);
                    MotherWeightEdit.setText(strMotherWeightEdit);
                    MotherFtEdit.setText(strMotherFtEdit);
                    MotherInchesEdit.setText(strMotherInchesEdit);
                    FatherName.setText(strFatherName);
                    FatherDob.setText(strFatherDob);
                    FatherWeightEdit.setText(strFatherWeightEdit);
                    FatherOccupationEdit.setText(strFatherOccupationEdit);
                    FatherFtEdit.setText(strFatherFtEdit);
                    FatherInchesEdit.setText(strFatherInchesEdit);
                }else if (strParentEditText.equals("Mother-In-Law")){
                    MotherLawName.setText(strMotherLawName);
                    MotherLawDob.setText(strMotherLawDob);
                    MotherLawWeightEdit.setText(strMotherLawWeightEdit);
                    MotherLawOccupationEdit.setText(strMotherLawOccupationEdit);
                    MotherLawFtEdit.setText(strMotherLawFtEdit);
                    MotherLawInchesEdit.setText(strMotherLawInchesEdit);
                }else if (strParentEditText.equals("Father-In-Law")){
                    FatherLawName.setText(strFatherLawName);
                    FatherLawDob.setText(strFatherLawDob);
                    FatherLawWeightEdit.setText(strFatherLawWeightEdit);
                    FatherLawOccupationEdit.setText(strFatherLawOccupationEdit);
                    FatherLawFtEdit.setText(strFatherLawFtEdit);
                    FatherLawInchesEdit.setText(strFatherLawInchesEdit);
                }else if (strParentEditText.equals("Mother-In-Law & Father-In-Law")){
                    MotherLawName.setText(strMotherLawName);
                    MotherLawDob.setText(strMotherLawDob);
                    MotherLawWeightEdit.setText(strMotherLawWeightEdit);
                    MotherLawOccupationEdit.setText(strMotherLawOccupationEdit);
                    MotherLawFtEdit.setText(strMotherLawFtEdit);
                    MotherLawInchesEdit.setText(strMotherLawInchesEdit);
                    FatherLawName.setText(strFatherLawName);
                    FatherLawDob.setText(strFatherLawDob);
                    FatherLawWeightEdit.setText(strFatherLawWeightEdit);
                    FatherLawOccupationEdit.setText(strFatherLawOccupationEdit);
                    FatherLawFtEdit.setText(strFatherLawFtEdit);
                    FatherLawInchesEdit.setText(strFatherLawInchesEdit);
                }


            }
        }
        else{

            str_gender="Select Gender";
            str_spouse_gender="Select Gender";
            str_oneGenderSpinner="Select Gender";
            str_twoGenderSpinner="Select Gender";
            str_thirdGenderSpinner="Select Gender";
            str_fourGenderSpinner="Select Gender";
            str_occupation="Occupation";
            str_spouse_occupation_spinner="Occupation";
            strMotherOccupationEdit="Occupation";
            strFatherOccupationEdit="Occupation";
            strMotherLawOccupationEdit="Occupation";
            strFatherLawOccupationEdit="Occupation";
            str_ft="Ft";
            str_spouse_ft_spinner="Ft";
            str_oneFtSpinner="Ft";
            str_twoFtSpinner="Ft";
            str_thirdFtSpinner="Ft";
            str_fourFtSpinner="Ft";
            strMotherFtEdit="Ft";
            strFatherFtEdit="Ft";
            strMotherLawFtEdit="Ft";
            strFatherLawFtEdit="Ft";
            str_inches="Inches";
            str_spouse_inches_spinner="Inches";
            str_oneInchesSpinner="Inches";
            str_twoInchesSpinner="Inches";
            str_thirdInchesSpinner="Inches";
            str_fourInchesSpinner="Inches";
            strMotherInchesEdit="Inches";
            strFatherInchesEdit="Inches";
            strMotherLawInchesEdit="Inches";
            strFatherLawInchesEdit="Inches";
            edit_gender.setText(str_gender);
            edit_occupation.setText(str_occupation);
            edit_ft.setText(str_ft);
            edit_inches.setText(str_inches);
            spouse_gender_spinner.setText(str_spouse_gender);
            spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
            spouse_ft_spinner.setText(str_spouse_ft_spinner);
            spouse_inches_spinner.setText(str_spouse_inches_spinner);
            oneGenderSpinner.setText(str_oneGenderSpinner);
            oneFtSpinner.setText(str_oneFtSpinner);
            oneInchesSpinner.setText(str_oneInchesSpinner);
            twoGenderSpinner.setText(str_twoGenderSpinner);
            twoFtSpinner.setText(str_twoFtSpinner);
            twoInchesSpinner.setText(str_twoInchesSpinner);
            thirdGenderSpinner.setText(str_thirdGenderSpinner);
            thirdFtSpinner.setText(str_thirdFtSpinner);
            thirdInchesSpinner.setText(str_thirdInchesSpinner);
            fourGenderSpinner.setText(str_fourGenderSpinner);
            fourFtSpinner.setText(str_fourFtSpinner);
            fourInchesSpinner.setText(str_fourInchesSpinner);

            MotherOccupationEdit.setText(strMotherOccupationEdit);
            MotherFtEdit.setText(strMotherFtEdit);
            MotherInchesEdit.setText(strMotherInchesEdit);
            FatherOccupationEdit.setText(strFatherOccupationEdit);
            FatherFtEdit.setText(strFatherFtEdit);
            FatherInchesEdit.setText(strFatherInchesEdit);

            MotherLawOccupationEdit.setText(strMotherLawOccupationEdit);
            MotherLawFtEdit.setText(strMotherLawFtEdit);
            MotherLawInchesEdit.setText(strMotherLawInchesEdit);
            FatherLawOccupationEdit.setText(strFatherLawOccupationEdit);
            FatherLawFtEdit.setText(strFatherLawFtEdit);
            FatherLawInchesEdit.setText(strFatherLawInchesEdit);

            edit_dob.setText(str_edit_dob);
            weight_edit.setText(str_weight_edit);
            edt_Spouse_name.setText(str_edt_Spouse_name);
            spouse_edit_dob.setText(str_spouse_edit_dob_dob);
            spouse_weight_edit.setText(str_spouse_weight_edit);

        }
        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(Arogya_Member_info.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.arogya_show_breakup);
                EditText installmentAmount,policyNoExisting, LifeStyleDiscount,basicPremium,criticalEdit,premiumEdit,hospitalEdit,subLimitAmount,gstEdit,totalAmount,tiedHospital;
                Button buttonClose;
                LinearLayout linerExisting,installmentLiner;
                criticalEdit = alert_dialog.findViewById(R.id.criticalEdit);
                premiumEdit = alert_dialog.findViewById(R.id.premiumEdit);
                hospitalEdit = alert_dialog.findViewById(R.id.hospitalEdit);
                basicPremium = alert_dialog.findViewById(R.id.basicPremium);
                LifeStyleDiscount = alert_dialog.findViewById(R.id.LifeStyleDiscount);
                subLimitAmount = alert_dialog.findViewById(R.id.subLimitAmount);
                totalAmount = alert_dialog.findViewById(R.id.totalAmount);
                gstEdit = alert_dialog.findViewById(R.id.gstEdit);
                tiedHospital = alert_dialog.findViewById(R.id.tiedHospital);
                buttonClose = alert_dialog.findViewById(R.id.buttonClose);
                policyNoExisting = alert_dialog.findViewById(R.id.policyNoExisting);
                linerExisting = alert_dialog.findViewById(R.id.linerExisting);
                installmentLiner = alert_dialog.findViewById(R.id.installmentLiner);
                installmentAmount = alert_dialog.findViewById(R.id.installmentAmount);


                if (str_for.equals("1")) {
                    if (str_existing_spinner.equals("Yes")){
                        LifeStyleDiscount.setText("Yes");
                        linerExisting.setVisibility(View.VISIBLE);
                        policyNoExisting.setText(strExisting_policy_number);
                    }else{
                        linerExisting.setVisibility(View.GONE);
                    }
                }else {
                    linerExisting.setVisibility(View.GONE);
                }
                installmentAmount.setText(TotalInstallPremium);
                basicPremium.setText(NetPremium);
//                criticalEdit.setText("0");
//                premiumEdit.setText("0");
//                hospitalEdit.setText("0");
//                subLimitAmount.setText("0");
                totalAmount.setText(TotalValue);
//                tiedHospital.setText("0");
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
        strRelationAdultOneEdit="Spouse";
        RelationAdultOneEdit.setText(strRelationAdultOneEdit);
        strRelationChildEdit="Daughter";
        strRelationChildTwoEdit="Daughter";
        strRelationChildThreeEdit="Daughter";
        strRelationFourChildEdit="Daughter";
        strMotherEdit="Female";
        strMotherLawEdit="Female";
        strFatherEdit="Male";
        strFatherLawEdit="Male";
        strMotherRelationEdit="Mother";
        strMotherLawRelationEdit="Mother-In-Law";
        strFatherRelationEdit="Father";
        strFatherLawRelationEdit="Father-In-Law";
        RelationChildEdit.setText(strRelationChildEdit);
        RelationChildTwoEdit.setText(strRelationChildTwoEdit);
        RelationChildThreeEdit.setText(strRelationChildThreeEdit);
        RelationFourChildEdit.setText(strRelationFourChildEdit);
        MotherRelationEdit.setText(strMotherRelationEdit);
        FatherRelationEdit.setText(strFatherRelationEdit);
        FatherEdit.setText(strFatherEdit);
        FatherLawEdit.setText(strFatherLawEdit);
        MotherEdit.setText(strMotherEdit);
        MotherLawEdit.setText(strMotherLawEdit);
        MotherLawRelationEdit.setText(strMotherLawRelationEdit);
        FatherLawRelationEdit.setText(strFatherLawRelationEdit);

        spouseRelationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Spouse");
                items1.add("Mother");
                items1.add("Father");
                items1.add("Father in law");
                items1.add("Mother in law");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationAdultOneEdit=items1.get(options1);
                        RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                    }
                });
                singlePicker.show(); }
        });
        ChildOneLinerRelation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationChildEdit=items1.get(options1);
                        RelationChildEdit.setText(strRelationChildEdit);
                    }
                });
                singlePicker.show(); }
        });
        ChildTwoRelationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationChildTwoEdit=items1.get(options1);
                        RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                    }
                });
                singlePicker.show(); }
        });
        RelationThirdLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationChildThreeEdit=items1.get(options1);
                        RelationChildThreeEdit.setText(strRelationChildThreeEdit);
                    }
                });
                singlePicker.show(); }
        });
        LinerRelationFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationFourChildEdit=items1.get(options1);
                        RelationFourChildEdit.setText(strRelationFourChildEdit);
                    }
                });
                singlePicker.show(); }
        });

//        if (str_for.equals("0")){
//
//
//        }

        gender_liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
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
                        str_gender=items1.get(options1);
                        edit_gender.setText(str_gender);
                        if (!str_gender.equals("Select Gender")){
                            if (str_edit_dob3String != null) {
                                try {
                                    SelectDate = dateFormatter.parse(str_edit_dob);
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
                                    Toast.makeText(Arogya_Member_info.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                                    edit_dob.setText("");
                                }
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });
        linerOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
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
                        str_occupation=items1.get(options1);
                        edit_occupation.setText(str_occupation);
                        if (!str_occupation.equals("Occupation")){
                            if (str_edit_dob3String != null) {
                                 try {
                                    SelectDate = dateFormatter.parse(str_edit_dob);
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
                                    Toast.makeText(Arogya_Member_info.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                                    edit_dob.setText("");
                                }
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });
        ftLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_ft=ft.get(options1);
                        edit_ft.setText(str_ft);
                    }
                });
                singlePicker.show(); }
        });
        LinerInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_inches=inches.get(options1);
                        edit_inches.setText(str_inches);
                    }
                });
                singlePicker.show(); }
        });

        //2nd adult
        spouseGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
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
                        str_spouse_gender=items1.get(options1);
                        spouse_gender_spinner.setText(str_spouse_gender);
                        if (!str_spouse_gender.equals("Select Gender")){
                            if (str_edit_dob3StringSpouse != null) {
                                 try {
                                    SelectDate = dateFormatter.parse(str_spouse_edit_dob_dob);
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
                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                                    spouse_edit_dob.setText("");
                                }
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });
        spouseOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
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
                        str_spouse_occupation_spinner=items1.get(options1);
                        spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                        if (!str_spouse_occupation_spinner.equals("Occupation")){
                            if (str_edit_dob3StringSpouse != null) {
                                try {
                                    SelectDate = dateFormatter.parse(str_spouse_edit_dob_dob);
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
                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                                    spouse_edit_dob.setText("");
                                }
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });
        spouseFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_spouse_ft_spinner=ft.get(options1);
                        spouse_ft_spinner.setText(str_spouse_ft_spinner);
                    }
                });
                singlePicker.show(); }
        });
        spouseInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_spouse_inches_spinner=inches.get(options1);
                        spouse_inches_spinner.setText(str_spouse_inches_spinner);
                    }
                });
                singlePicker.show(); }
        });

        //1st child
        ChildOneGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
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
                        str_oneGenderSpinner=items1.get(options1);
                        oneGenderSpinner.setText(str_oneGenderSpinner);
                        if (!str_oneGenderSpinner.equals("Select Gender")){
                            if (strChildOne != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strOneChild);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearChild = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearChild < 1 || (selectYearChild > 25)) {
                                    Toast.makeText(Arogya_Member_info.this, "1st Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
                                    OneDob.setText("");
                                }
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerFtChildOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_oneFtSpinner=ft.get(options1);
                        oneFtSpinner.setText(str_oneFtSpinner);
                    }
                });
                singlePicker.show(); }
        });
        LinerInchesChildOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_oneInchesSpinner=inches.get(options1);
                        oneInchesSpinner.setText(str_oneInchesSpinner);
                    }
                });
                singlePicker.show(); }
        });

        //2nd child
        childTwoGenderLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
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
                        str_twoGenderSpinner=items1.get(options1);
                        twoGenderSpinner.setText(str_twoGenderSpinner);
                        if (!str_twoGenderSpinner.equals("Select Gender")){
                            if (strChildTwo != null){
                                try {
                                    SelectDate = dateFormatter.parse(strtwoDob);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearChildTwo = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                }
                                catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearChildTwo < 1 || (selectYearChildTwo > 25)) {
                                    Toast.makeText(Arogya_Member_info.this, "2nd Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
                                    twoDob.setText("");
                                }
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerChildTwoFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_twoFtSpinner=ft.get(options1);
                        twoFtSpinner.setText(str_twoFtSpinner);
                    }
                });
                singlePicker.show(); }
        });
        LinerChildTwoInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_twoInchesSpinner=inches.get(options1);
                        twoInchesSpinner.setText(str_twoInchesSpinner);
                    }
                });
                singlePicker.show(); }
        });

        //3rd child
        thirdLinerGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
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
                        str_thirdGenderSpinner=items1.get(options1);
                        thirdGenderSpinner.setText(str_thirdGenderSpinner);
                        if (!str_thirdGenderSpinner.equals("Select Gender")){
                            if (strChildThree != null){
                                try {
                                    SelectDate = dateFormatter.parse(strthreeDob);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearChildThird = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                }
                                catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearChildThird < 1 || (selectYearChildThird > 25)) {
                                    Toast.makeText(Arogya_Member_info.this, "3rd Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
                                    thirdDob.setText("");
                                }
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerFtThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_thirdFtSpinner=ft.get(options1);
                        thirdFtSpinner.setText(str_thirdFtSpinner);
                    }
                });
                singlePicker.show(); }
        });
        thirdInchesLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_thirdInchesSpinner=inches.get(options1);
                        thirdInchesSpinner.setText(str_thirdInchesSpinner);
                    }
                });
                singlePicker.show(); }
        });
        //4th child

        LinerGenderFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
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
                        str_fourGenderSpinner=items1.get(options1);
                        fourGenderSpinner.setText(str_fourGenderSpinner);
                        if (!str_fourGenderSpinner.equals("Select Gender")){
                            try {
                                SelectDate = dateFormatter.parse(strfourDob);
                                CurrentDate = dateFormatter.parse(today);
                                long selectNewDate = SelectDate.getTime();
                                long TodayendDate = CurrentDate.getTime();
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                    selectYearChildFour = period.getYears();
                                    SelectMonth = period.getMonths();
                                    SelectDays = period.getDays();
                                }
                            }
                            catch (ParseException e) {
                                e.printStackTrace();
                            }
                            if (selectYearChildFour < 1 || (selectYearChildFour > 25)) {
                                Toast.makeText(Arogya_Member_info.this, "4th Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
                                fourDob.setText("");
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerFtFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_fourFtSpinner=ft.get(options1);
                        fourFtSpinner.setText( str_fourFtSpinner);
                    }
                });
                singlePicker.show(); }
        });
        LinerInchesFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_fourInchesSpinner=inches.get(options1);
                        fourInchesSpinner.setText(str_fourInchesSpinner);
                    }
                });
                singlePicker.show(); }
        });

        //Mother
        MotherOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
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
                        strMotherOccupationEdit=items1.get(options1);
                        MotherOccupationEdit.setText(strMotherOccupationEdit);
                        if (!strMotherOccupationEdit.equals("Occupation")){
                            if (strMotherDobString != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strMotherDob);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearMother = period.getYears();
                                        SelectMonthMother = period.getMonths();
                                        SelectDaysMother = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearMother < 36 || (selectYearMother > 55)) {
                                    Toast.makeText(Arogya_Member_info.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                                    MotherDob.setText("");
                                }
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });
        MotherFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherFtEdit=ft.get(options1);
                        MotherFtEdit.setText(strMotherFtEdit);
                    }
                });
                singlePicker.show(); }
        });
        MotherInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherInchesEdit=inches.get(options1);
                        MotherInchesEdit.setText(strMotherInchesEdit);
                    }
                });
                singlePicker.show(); }
        });

        //father
        FatherOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
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
                        strFatherOccupationEdit=items1.get(options1);
                        FatherOccupationEdit.setText(strFatherOccupationEdit);
                        if (!strFatherOccupationEdit.equals("Occupation")){
                            if (strFatherDobString != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strFatherDob);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearFather = period.getYears();
                                        SelectMonthFather = period.getMonths();
                                        SelectDaysFather = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearFather < 36 || (selectYearFather > 55)) {
                                    Toast.makeText(Arogya_Member_info.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                                    FatherDob.setText("");
                                }
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });
        FatherFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strFatherFtEdit=ft.get(options1);
                        FatherFtEdit.setText(strFatherFtEdit);
                    }
                });
                singlePicker.show(); }
        });
        FatherInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strFatherInchesEdit=inches.get(options1);
                        FatherInchesEdit.setText(strFatherInchesEdit);
                    }
                });
                singlePicker.show(); }
        });

        //Mother-In-Law
        MotherLawOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
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
                        strMotherLawOccupationEdit=items1.get(options1);
                        MotherLawOccupationEdit.setText(strMotherLawOccupationEdit);
                        if (!strMotherLawOccupationEdit.equals("Occupation")){
                            if (strMotherLawDobString != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strMotherLawDob);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearMotherLaw = period.getYears();
                                        SelectMonthMotherLaw = period.getMonths();
                                        SelectDaysMotherLaw = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearMotherLaw < 36 || (selectYearMotherLaw > 55)) {
                                    Toast.makeText(Arogya_Member_info.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                                    MotherLawDob.setText("");
                                }
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });
        MotherLawFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherLawFtEdit=ft.get(options1);
                        MotherLawFtEdit.setText(strMotherLawFtEdit);
                    }
                });
                singlePicker.show(); }
        });
        MotherLawInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strMotherLawInchesEdit=inches.get(options1);
                        MotherLawInchesEdit.setText(strMotherLawInchesEdit);
                    }
                });
                singlePicker.show(); }
        });

        //Father-In-Law
        FatherLawOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
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
                        strFatherLawOccupationEdit=items1.get(options1);
                        FatherLawOccupationEdit.setText(strFatherLawOccupationEdit);
                        if (!strFatherLawOccupationEdit.equals("Occupation")){
                            if (strFatherLawDobString != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strFatherLawDob);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearFatherLaw = period.getYears();
                                        SelectMonthFatherLaw = period.getMonths();
                                        SelectDaysFatherLaw = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearFatherLaw < 18 || (selectYearFatherLaw > 55)) {
                                    Toast.makeText(Arogya_Member_info.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                                    FatherLawDob.setText("");
                                }
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });
        FatherLawFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strFatherLawFtEdit=ft.get(options1);
                        FatherLawFtEdit.setText(strFatherLawFtEdit);
                    }
                });
                singlePicker.show(); }
        });
        FatherLawInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strFatherLawInchesEdit=inches.get(options1);
                        FatherLawInchesEdit.setText(strFatherLawInchesEdit);
                    }
                });
                singlePicker.show(); }
        });

        edit_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalender();
            }
        });

        spouse_edit_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderspouse();
            }
        });
        OneDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderchild();
            }
        });

        twoDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalendertwochild();
            }
        });

        thirdDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderthreechild();
            }
        });
        fourDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderfourchild();
            }
        });

        MotherDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderMother();
            }
        });
        FatherDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderFather();
            }
        });
        MotherLawDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderMotherLaw();
            }
        });
        FatherLawDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderFatherLaw();
            }
        });

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Individual_BMI=0.0;
                twoAdult_BMI=0.0;
                str_edt_name=edt_name.getText().toString();
                str_edit_dob=edit_dob.getText().toString();
                str_weight_edit=weight_edit.getText().toString();
                str_spouse_edit_dob_dob=spouse_edit_dob.getText().toString();
                str_edt_Spouse_name=edt_Spouse_name.getText().toString();
                str_spouse_weight_edit=spouse_weight_edit.getText().toString();
                str_OneEditName=OneEditName.getText().toString();
                str_twoChildEditName=twoChildEditName.getText().toString();
                str_thirdNameEdit=thirdNameEdit.getText().toString();
                str_fourNameEdit=fourNameEdit.getText().toString();
                str_oneWeightEdit=oneWeightEdit.getText().toString();
                strOneChild=OneDob.getText().toString();
                strtwoDob=twoDob.getText().toString();
                strtwoWeightEdit=twoWeightEdit.getText().toString();
                str_thirdWeightEdit=thirdWeightEdit.getText().toString();
                strthreeDob=thirdDob.getText().toString();
                strFourWeightEdit=FourWeightEdit.getText().toString();
                strfourDob=fourDob.getText().toString();
                strMotherName=MotherName.getText().toString();
                strMotherDob=MotherDob.getText().toString();
                strMotherOccupationEdit=MotherOccupationEdit.getText().toString();
                strMotherWeightEdit=MotherWeightEdit.getText().toString();
                strFatherName=FatherName.getText().toString();
                strFatherDob=FatherDob.getText().toString();
                strFatherWeightEdit=FatherWeightEdit.getText().toString();
                strFatherOccupationEdit=FatherOccupationEdit.getText().toString();
                strMotherLawName=MotherLawName.getText().toString();
                strMotherLawDob=MotherLawDob.getText().toString();
                strMotherLawOccupationEdit=MotherLawOccupationEdit.getText().toString();
                strMotherLawWeightEdit=MotherLawWeightEdit.getText().toString();
                strFatherLawName=FatherLawName.getText().toString();
                strFatherLawDob=FatherLawDob.getText().toString();
                strFatherLawOccupationEdit=FatherLawOccupationEdit.getText().toString();
                strFatherLawWeightEdit=FatherLawWeightEdit.getText().toString();
                if (str_policyType_spinner.equals("Individual")){
                    if (str_edt_name.equals("")){
                        Toast.makeText(Arogya_Member_info.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                    }else if(str_edit_dob.equals("")){
                        Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                    } else if (str_gender.equals("Select Gender")){
                        Toast.makeText(Arogya_Member_info.this, "Select Gender", Toast.LENGTH_SHORT).show();
                    }else if (str_occupation.equals("Occupation")){
                        Toast.makeText(Arogya_Member_info.this, "Select Occupation", Toast.LENGTH_SHORT).show();
                    } else if(str_ft.equals("Ft") && str_inches.equals("Inches")){
                        Toast.makeText(Arogya_Member_info.this, "Enter Ft & Inches", Toast.LENGTH_SHORT).show();
                    }else if (str_weight_edit.equals("")){
                        Toast.makeText(Arogya_Member_info.this, "Enter Weight in Kg", Toast.LENGTH_SHORT).show();
                    } else {
                        if (str_edit_dob3String != null){
                            try {
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
                                SelectDate = dateFormat.parse(str_edit_dob);
                                CurrentDate = dateFormat.parse(today);
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
                                Toast.makeText(Arogya_Member_info.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                            }else if(!str_ft.equals("Ft") && !str_inches.equals("Inches")) {
                                cm=convertFeetandInchesToCentimeter(str_ft, str_inches);
                                kg= Double.parseDouble(str_weight_edit);
                                BMI=calculateBMI(kg,cm);
                                if (BMI!=0.0){
                                    if (BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "BMI is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                    else if (BMI >= 16.0 && BMI <= 33.0) {
                                        Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
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
                                        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
                                        intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
                                        intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
                                        intent.putExtra("str_spouse_gender",str_spouse_gender);
                                        intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
                                        intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
                                        intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
                                        intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
                                        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                                        intent.putExtra("str_SumInsured",str_SumInsured);
                                        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                                        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
                                        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
                                        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
                                        intent.putExtra("TotalValue",TotalValue);
                                        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                                        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                                        intent.putExtra("str_SumInsured",str_SumInsured);
                                        intent.putExtra("strFirstTString",strFirstTString);
                                        intent.putExtra("PosPolicyNo",PosPolicyNo);
                                        intent.putExtra("strChildOne",strChildOne);
                                        intent.putExtra("strChildTwo",strChildTwo);
                                        intent.putExtra("strChildThree",strChildThree);
                                        intent.putExtra("strChildFour",strChildFour);
                                        intent.putExtra("NetPremiumValue",NetPremiumValue);
                                        intent.putExtra("GST",GST);
                                        intent.putExtra("PosPolicyNo",PosPolicyNo);
                                        intent.putExtra("QuoteId",QuoteId);
                                        intent.putExtra("TotalPremium",TotalPremium);
                                        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
                                        intent.putExtra("strOneChild",strOneChild);
                                        intent.putExtra("strtwoDob",strtwoDob);
                                        intent.putExtra("strthreeDob",strthreeDob);
                                        intent.putExtra("NetPremium",NetPremium);
                                        intent.putExtra("strfourDob",strfourDob);
                                        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
                                        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
                                        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
                                        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
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
                                        intent.putExtra("str_RelationEdit",str_RelationEdit);
                                        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
                                        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
                                        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
                                        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
                                        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
                                        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
                                        intent.putExtra("for","0");
                                        intent.putExtra("str_existing_spinner",str_existing_spinner);
                                        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
                                        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
                                        intent.putExtra("new_str_age",new_str_age);
                                        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
                                        intent.putExtra("str_policyTenure",str_policyTenure);
                                        intent.putExtra("BMI",BMI);
                                        intent.putExtra("Individual_BMI",Individual_BMI);
                                        intent.putExtra("twoAdult_BMI",twoAdult_BMI);
                                        intent.putExtra("OneChildBMI",OneChildBMI);
                                        intent.putExtra("TwoChildBMI",TwoChildBMI);
                                        intent.putExtra("ThreeChildBMI",ThreeChildBMI);
                                        intent.putExtra("FourChildBMI",FourChildBMI);
                                        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
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
                                        startActivity(intent);
                                        finish();
                                    }
                                    else if (BMI >33) {
                                        Toast.makeText(Arogya_Member_info.this, "BMI is not normal", Toast.LENGTH_SHORT).show();
                                    } 
                                }
                            }
                        }
                    }
                }
                else {
                    if(str_IndividualTypeEdit.equals("2 Adult")){
                        if(!str_edit_dob.equals("")) {
                            str_spouse_edit_dob_dob = spouse_edit_dob.getText().toString();
                            str_edt_Spouse_name = edt_Spouse_name.getText().toString();
                            str_spouse_weight_edit = spouse_weight_edit.getText().toString();
                            str_OneEditName = OneEditName.getText().toString();
                            str_twoChildEditName = twoChildEditName.getText().toString();
                            str_thirdNameEdit = thirdNameEdit.getText().toString();
                            str_fourNameEdit = fourNameEdit.getText().toString();
                            if (str_edt_name.equals("")) {
                                Toast.makeText(Arogya_Member_info.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                            } else if (str_edit_dob.equals("")) {
                                Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                            } else if (str_gender.equals("Select Gender")) {
                                Toast.makeText(Arogya_Member_info.this, "Select Gender", Toast.LENGTH_SHORT).show();
                            } else if (str_occupation.equals("Occupation")) {
                                Toast.makeText(Arogya_Member_info.this, "Select Occupation", Toast.LENGTH_SHORT).show();
                            } else if (str_ft.equals("Ft") && str_inches.equals("Inches")) {
                                Toast.makeText(Arogya_Member_info.this, "Enter Ft & Inches", Toast.LENGTH_SHORT).show();
                            } else if (str_weight_edit.equals("")) {
                                Toast.makeText(Arogya_Member_info.this, "Enter Weight in Kg", Toast.LENGTH_SHORT).show();
                            } else if (str_edt_Spouse_name.equals("")) {
                                Toast.makeText(Arogya_Member_info.this, "Enter 2nd Adult Name", Toast.LENGTH_SHORT).show();
                            } else if (str_spouse_edit_dob_dob.equals("")) {
                                Toast.makeText(Arogya_Member_info.this, "Enter 2nd Adult Date of Birth", Toast.LENGTH_SHORT).show();
                            } else if (str_spouse_gender.equals("Select Gender")) {
                                Toast.makeText(Arogya_Member_info.this, "Select 2nd Adult Gender", Toast.LENGTH_SHORT).show();

                            } else if (str_spouse_occupation_spinner.equals("Occupation")) {
                                Toast.makeText(Arogya_Member_info.this, "Select 2nd Adult Occupation", Toast.LENGTH_SHORT).show();

                            } else if (str_spouse_ft_spinner.equals("Ft")) {
                                Toast.makeText(Arogya_Member_info.this, "Select 2nd Adult Ft", Toast.LENGTH_SHORT).show();

                            } else if (str_spouse_inches_spinner.equals("Inches")) {
                                Toast.makeText(Arogya_Member_info.this, "Select 2nd Adult Inches", Toast.LENGTH_SHORT).show();

                            } else if (str_spouse_weight_edit.equals("")) {
                                Toast.makeText(Arogya_Member_info.this, "Enter 2nd Adult Weight in Kg", Toast.LENGTH_SHORT).show();
                            } else {
                                Individual_BMI = ArogyaCalculation(str_edt_name, str_gender, str_occupation, str_edit_dob, str_ft, str_inches, str_weight_edit, str_edit_dob3String, strThirdDString, selectYearAdult, getApplicationContext());
                                twoAdult_BMI = ArogyaCalculationAdult(str_edt_Spouse_name, str_spouse_edit_dob_dob, str_spouse_gender, str_spouse_occupation_spinner, str_spouse_ft_spinner, str_spouse_inches_spinner, str_spouse_weight_edit, str_edit_dob3StringSpouse, strThirdDString, selectYearSecondAdult, getApplicationContext());
                                if (Individual_BMI != 0.0 && twoAdult_BMI != 0.0) {
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    } else if (twoAdult_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult  weight is not normal", Toast.LENGTH_SHORT).show();
                                    } else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0) {
                                        twoAdult();
                                    } else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    } else if (twoAdult_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                        else{
                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                        if (strParentEditText.equals("Mother")){
                            MotherIntent();
                        }else if (strParentEditText.equals("Father")){
                            FatherIntent();
                        }else if (strParentEditText.equals("Mother & Father")){
                            MotherFatherIntent();
                        }else if (strParentEditText.equals("Mother-In-Law")){
                            MotherLawIntent();
                        }else if (strParentEditText.equals("Father-In-Law")){
                            FatherLawIntent();
                        }else if (strParentEditText.equals("Mother-In-Law & Father-In-Law")){
                            MotherFatherLawIntent();
                        }

                        if(!str_edit_dob.equals("")){
                            Individual_BMI= ArogyaCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            OneChildBMI= ArogyacalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            if (selectYearChild > 19){
                                if (Individual_BMI!=0.0 && OneChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (OneChildBMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "1st Child weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0) {
                                        twoAdult();
                                    }
                                    else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (OneChildBMI >33) {
                                        Toast.makeText(Arogya_Member_info.this, "1st Child weight is not normal", Toast.LENGTH_SHORT).show();
                                    } }
                            }else{
                                if (Individual_BMI!=0.0 && OneChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0) {
                                        twoAdult();
                                    }
                                    else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }else{
                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= ArogyaCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            OneChildBMI= ArogyacalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            TwoChildBMI= ArogyacalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                            if (selectYearChild > 19){
                                if (selectYearChildTwo > 19){
                                    if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
                                        if (Individual_BMI < 16.0) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (OneChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (TwoChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0) {
                                            twoAdult();
                                        }
                                        else if (Individual_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (OneChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (TwoChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        } }
                                }else{
                                    if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
                                        if (Individual_BMI < 16.0) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (OneChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 ) {
                                            twoAdult();
                                        }
                                        else if (Individual_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (OneChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                }
                            }else if (selectYearChildTwo > 19){
                                if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (TwoChildBMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0) {
                                        twoAdult();
                                    }
                                    else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (TwoChildBMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            else{
                                if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0) {
                                        twoAdult();
                                    }else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }else{
                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= ArogyaCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            OneChildBMI= ArogyacalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            TwoChildBMI= ArogyacalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                            ThreeChildBMI= ArogyacalculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,selectYearChildThird,getApplicationContext());
                            if (selectYearChild > 19){
                                if (selectYearChildTwo > 19){
                                    if (selectYearChildThird > 19){
                                        if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            } else  if (OneChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (TwoChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (ThreeChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                                twoAdult();
                                            }
                                            else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (OneChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (TwoChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (ThreeChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }
                                        }}
                                    else{
                                        if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            } else  if (OneChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (TwoChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0) {
                                                twoAdult();
                                            }
                                            else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (OneChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (TwoChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }}
                                    }
                                } else{
                                    if (selectYearChildThird > 19){
                                        if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            } else  if (OneChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (ThreeChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                                twoAdult();
                                            }
                                            else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (OneChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (ThreeChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }else{
                                        if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            } else  if (OneChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0) {
                                                twoAdult();
                                            }
                                            else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (OneChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                }
                            }
                            else if (selectYearChildTwo > 19){
                                if (selectYearChildThird > 19){
                                    if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                        if (Individual_BMI < 16.0) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (TwoChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (ThreeChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                            twoAdult();
                                        } else if (Individual_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (TwoChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (ThreeChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }else{
                                    if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                        if (Individual_BMI < 16.0) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (TwoChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0) {
                                            twoAdult();
                                        }
                                        else if (Individual_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (TwoChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                            else if (selectYearChildThird > 19){
                                if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (ThreeChildBMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                        twoAdult();
                                    }
                                    else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (ThreeChildBMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            else{
                                if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    } else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0) {
                                        twoAdult();
                                    }
                                    else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("1 Adult + 4 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= ArogyaCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            OneChildBMI= ArogyacalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            TwoChildBMI= ArogyacalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                            ThreeChildBMI= ArogyacalculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,selectYearChildThird,getApplicationContext());
                            FourChildBMI= Arogyacalculationfour(str_fourNameEdit,strfourDob,str_fourGenderSpinner,str_fourOccupationSpinner,str_fourFtSpinner,str_fourInchesSpinner,strFourWeightEdit,strChildFour,strThirdDString,selectYearChildFour,getApplicationContext());
                            if (selectYearChild > 19){
                                if (selectYearChildTwo > 19){
                                    if (selectYearChildThird > 19){
                                          if(selectYearChildFour>19){
                                              if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                                  if (Individual_BMI < 16.0) {
                                                      Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else  if (OneChildBMI < 16.0){
                                                      Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else  if (TwoChildBMI < 16.0){
                                                      Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else  if (ThreeChildBMI < 16.0){
                                                      Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else  if (FourChildBMI < 16.0){
                                                      Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                                      twoAdult();
                                                  }
                                                  else if (Individual_BMI > 33) {
                                                      Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else if (OneChildBMI > 33) {
                                                      Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else if (TwoChildBMI > 33) {
                                                      Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else if (ThreeChildBMI > 33) {
                                                      Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else if (FourChildBMI > 33) {
                                                      Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }
                                              }
                                        }
                                          else{
                                              if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                                  if (Individual_BMI < 16.0) {
                                                      Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else  if (OneChildBMI < 16.0){
                                                      Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else  if (TwoChildBMI < 16.0){
                                                      Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else  if (ThreeChildBMI < 16.0){
                                                      Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                                      twoAdult();
                                                  }
                                                  else if (Individual_BMI > 33) {
                                                      Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else if (OneChildBMI > 33) {
                                                      Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else if (TwoChildBMI > 33) {
                                                      Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }else if (ThreeChildBMI > 33) {
                                                      Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                                  }
                                              }

                                          }
                                    }
                                    else{
                                        if(selectYearChildFour>19){
                                            if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                                if (Individual_BMI < 16.0) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (OneChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (TwoChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (FourChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                                    twoAdult();
                                                }
                                                else if (Individual_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (OneChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (TwoChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (FourChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                        else{
                                            if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                                if (Individual_BMI < 16.0) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                } else  if (OneChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (TwoChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0) {
                                                    twoAdult();
                                                }
                                                else if (Individual_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (OneChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (TwoChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }}
                                        }
                                    }
                                 }
                                else if (selectYearChildThird > 19){
                                    if(selectYearChildFour>19){
                                        if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (OneChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (ThreeChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (FourChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                                twoAdult();
                                            }
                                            else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (OneChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (ThreeChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (FourChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                    else{
                                        if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (OneChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (ThreeChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                                twoAdult();
                                            }
                                            else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (OneChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (ThreeChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }
                                        }

                                    }
                                }
                                else if(selectYearChildFour>19){
                                    if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                        if (Individual_BMI < 16.0) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (FourChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                            twoAdult();
                                        }
                                        else if (Individual_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (FourChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    if (Individual_BMI!=0.0 && OneChildBMI!=0.0){
                                        if (Individual_BMI < 16.0) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0) {
                                            twoAdult();
                                        }
                                        else if (Individual_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                            else if (selectYearChildTwo > 19){
                                if (selectYearChildThird > 19){
                                     if(selectYearChildFour>19){
                                        if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (TwoChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (ThreeChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (FourChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                                twoAdult();
                                            }
                                            else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (TwoChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (ThreeChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (FourChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                     else {
                                         if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                             if (Individual_BMI < 16.0) {
                                                 Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                             }else  if (OneChildBMI < 16.0){
                                                 Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                             }else  if (TwoChildBMI < 16.0){
                                                 Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                             }else  if (ThreeChildBMI < 16.0){
                                                 Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                             }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                                 twoAdult();
                                             }
                                             else if (Individual_BMI > 33) {
                                                 Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                             }else if (TwoChildBMI > 33) {
                                                 Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                             }else if (ThreeChildBMI > 33) {
                                                 Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                             }
                                         }
                                     }
                                }
                                else if(selectYearChildFour>19){
                                    if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                        if (Individual_BMI < 16.0) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (OneChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (TwoChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (FourChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                            twoAdult();
                                        }
                                        else if (Individual_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (TwoChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (FourChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                        if (Individual_BMI < 16.0) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                            twoAdult();
                                        }else if (Individual_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                            else if (selectYearChildThird > 19){
                                 if(selectYearChildFour>19){
                                     if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                         if (Individual_BMI < 16.0) {
                                             Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                         }else  if (ThreeChildBMI < 16.0){
                                             Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                         }else  if (FourChildBMI < 16.0){
                                             Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                         }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                             twoAdult();
                                         }
                                         else if (Individual_BMI > 33) {
                                             Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                         }else if (ThreeChildBMI > 33) {
                                             Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                         }else if (FourChildBMI > 33) {
                                             Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                         }
                                     }
                                }
                                 else{
                                     if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                         if (Individual_BMI < 16.0) {
                                             Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                         }else  if (ThreeChildBMI < 16.0){
                                             Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                         }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0  && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                             twoAdult();
                                         }
                                         else if (Individual_BMI > 33) {
                                             Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                         }else if (ThreeChildBMI > 33) {
                                             Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                         }
                                     }
                                }
                            }
                            else if(selectYearChildFour>19){
                                if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (FourChildBMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                        twoAdult();
                                    }
                                    else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (FourChildBMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            else{
                                if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    } else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0) {
                                        twoAdult();
                                    }
                                    else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }else{
                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= ArogyaCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            twoAdult_BMI= ArogyaCalculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,selectYearSecondAdult,getApplicationContext());
                            OneChildBMI= ArogyacalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            if (selectYearChild > 19){
                                if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (twoAdult_BMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (OneChildBMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0) {
                                        twoAdult();
                                    }
                                    else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (twoAdult_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (OneChildBMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    } }
                            }
                            else{
                                if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (twoAdult_BMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0) {
                                        twoAdult();
                                    }
                                    else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (twoAdult_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            }


                        }else{
                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= ArogyaCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            twoAdult_BMI= ArogyaCalculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,selectYearSecondAdult,getApplicationContext());
                            OneChildBMI= ArogyacalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            TwoChildBMI= ArogyacalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                            if (selectYearChild > 19){
                                if (selectYearChildTwo > 19){
                                    if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
                                        if (Individual_BMI < 16.0) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (twoAdult_BMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (OneChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (TwoChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0) {
                                            twoAdult();
                                        }
                                        else if (Individual_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (twoAdult_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (OneChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (TwoChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        } }
                                }
                                else{
                                    if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0){
                                        if (Individual_BMI < 16.0) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (twoAdult_BMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (OneChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0) {
                                            twoAdult();
                                        }
                                        else if (Individual_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (twoAdult_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (OneChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        } }
                                }
                            }else if (selectYearChildTwo > 19){
                                if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (twoAdult_BMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (TwoChildBMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0) {
                                        twoAdult();
                                    }
                                    else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (twoAdult_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (TwoChildBMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            else{
                                if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (twoAdult_BMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 ) {
                                        twoAdult();
                                    }else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (twoAdult_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }else{
                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= ArogyaCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            twoAdult_BMI= ArogyaCalculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,selectYearSecondAdult,getApplicationContext());
                            OneChildBMI= ArogyacalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            TwoChildBMI= ArogyacalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                            ThreeChildBMI= ArogyacalculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,selectYearChildThird,getApplicationContext());
                            if (selectYearChild > 19){
                                if (selectYearChildTwo > 19){
                                    if (selectYearChildThird > 19){
                                        if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (twoAdult_BMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (OneChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (TwoChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (ThreeChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                                twoAdult();
                                            }
                                            else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (twoAdult_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (OneChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (TwoChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (ThreeChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            } }
                                    }
                                    else{
                                        if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (twoAdult_BMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (OneChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (TwoChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0) {
                                                twoAdult();
                                            }
                                            else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (twoAdult_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (OneChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (TwoChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                }
                                else{
                                    if (selectYearChildThird > 19){
                                        if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (twoAdult_BMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (OneChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (ThreeChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                                twoAdult();
                                            }
                                            else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (twoAdult_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (OneChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (ThreeChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }else{
                                        if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (twoAdult_BMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (OneChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0) {
                                                twoAdult();
                                            }
                                            else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (twoAdult_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (OneChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                }
                            }
                            else if (selectYearChildTwo > 19){
                                if (selectYearChildThird > 19){
                                    if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                        if (Individual_BMI < 16.0) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (twoAdult_BMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (TwoChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (ThreeChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                            twoAdult();
                                        }
                                        else if (Individual_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (twoAdult_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (TwoChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (ThreeChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && TwoChildBMI!=0.0){
                                        if (Individual_BMI < 16.0) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (twoAdult_BMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else  if (TwoChildBMI < 16.0){
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0) {
                                            twoAdult();
                                        }
                                        else if (Individual_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (twoAdult_BMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                        }else if (TwoChildBMI > 33) {
                                            Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                            else if (selectYearChildThird > 19){
                                if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && ThreeChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (twoAdult_BMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (ThreeChildBMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                        twoAdult();
                                    }
                                    else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (twoAdult_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (ThreeChildBMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            else{
                                if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (twoAdult_BMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0) {
                                        twoAdult();
                                    }
                                    else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (twoAdult_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }else{
                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= ArogyaCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            twoAdult_BMI= ArogyaCalculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,selectYearSecondAdult,getApplicationContext());
                            OneChildBMI= ArogyacalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            TwoChildBMI= ArogyacalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                            ThreeChildBMI= ArogyacalculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,selectYearChildThird,getApplicationContext());
                            FourChildBMI= Arogyacalculationfour(str_fourNameEdit,strfourDob,str_fourGenderSpinner,str_fourOccupationSpinner,str_fourFtSpinner,str_fourInchesSpinner,strFourWeightEdit,strChildFour,strThirdDString,selectYearChildFour,getApplicationContext());
                            if (selectYearChild > 19){
                                if (selectYearChildTwo > 19){
                                    if (selectYearChildThird > 19){
                                        if (selectYearChildFour > 19){
                                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                                if (Individual_BMI < 16.0) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (twoAdult_BMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (OneChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (TwoChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (ThreeChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (FourChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                                    nextIntent();
                                                }else if (Individual_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (twoAdult_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (OneChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (TwoChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (ThreeChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (FourChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                        else{
                                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 ){
                                                if (Individual_BMI < 16.0) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (twoAdult_BMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (OneChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (TwoChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (ThreeChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                                    nextIntent();
                                                }else if (Individual_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (twoAdult_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (OneChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (TwoChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (ThreeChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                    }
                                    else{
                                        if (selectYearChildFour > 19){
                                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && FourChildBMI!=0.0){
                                                if (Individual_BMI < 16.0) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (twoAdult_BMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (OneChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (TwoChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (FourChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                                    nextIntent();
                                                }else if (Individual_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (twoAdult_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (OneChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (TwoChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (FourChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }else{
                                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
                                                if (Individual_BMI < 16.0) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (twoAdult_BMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (OneChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (TwoChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 ) {
                                                    nextIntent();
                                                }else if (Individual_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (twoAdult_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (OneChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (TwoChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }
                                            }

                                        }
                                    }
                                }
                                else{
                                    if (selectYearChildThird > 19){
                                        if (selectYearChildFour > 19){
                                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                                if (Individual_BMI < 16.0) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (twoAdult_BMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (OneChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (ThreeChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (FourChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                                    nextIntent();
                                                }else if (Individual_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (twoAdult_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (OneChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (ThreeChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (FourChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                        else{
                                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && ThreeChildBMI!=0.0 ){
                                                if (Individual_BMI < 16.0) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (twoAdult_BMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (OneChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (ThreeChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                                    nextIntent();
                                                }else if (Individual_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (twoAdult_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (OneChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (ThreeChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                    }
                                    else{
                                        if (selectYearChildFour > 19){
                                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && FourChildBMI!=0.0){
                                                if (Individual_BMI < 16.0) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (twoAdult_BMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (OneChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (TwoChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (FourChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                                    nextIntent();
                                                }else if (Individual_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (twoAdult_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (OneChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (FourChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                        else{
                                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0){
                                                if (Individual_BMI < 16.0) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (twoAdult_BMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else  if (OneChildBMI < 16.0){
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0) {
                                                    nextIntent();
                                                }else if (Individual_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (twoAdult_BMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                                }else if (OneChildBMI > 33) {
                                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                                }
                                            }

                                        }
                                    }
                                }
                            }
                            else if (selectYearChildTwo > 19){
                                if (selectYearChildThird > 19){
                                    if (selectYearChildFour > 19){
                                        if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (twoAdult_BMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (TwoChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (ThreeChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (FourChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                                nextIntent();
                                            }else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (twoAdult_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (TwoChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (ThreeChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (FourChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                    else{
                                        if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (twoAdult_BMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (OneChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (TwoChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (ThreeChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                                nextIntent();
                                            }else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (twoAdult_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (OneChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (TwoChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (ThreeChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }

                                }
                                else{
                                    if (selectYearChildFour > 19){
                                        if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && TwoChildBMI!=0.0 && FourChildBMI!=0.0){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (twoAdult_BMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (TwoChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (FourChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                                nextIntent();
                                            }else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (twoAdult_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (TwoChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (FourChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                    else{
                                        if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && TwoChildBMI!=0.0 ){
                                            if (Individual_BMI < 16.0) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (twoAdult_BMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else  if (TwoChildBMI < 16.0){
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0) {
                                                nextIntent();
                                            }else if (Individual_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (twoAdult_BMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                            }else if (TwoChildBMI > 33) {
                                                Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                }
                            }
                            else if (selectYearChildThird > 19){
                                  if (selectYearChildFour > 19){
                                      if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                          if (Individual_BMI < 16.0) {
                                              Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                          }else  if (twoAdult_BMI < 16.0){
                                              Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                          }else  if (ThreeChildBMI < 16.0){
                                              Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                          }else  if (FourChildBMI < 16.0){
                                              Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                          }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                              nextIntent();
                                          }else if (Individual_BMI > 33) {
                                              Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                          }else if (twoAdult_BMI > 33) {
                                              Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                          }else if (ThreeChildBMI > 33) {
                                              Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                          }else if (FourChildBMI > 33) {
                                              Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                          }
                                      }
                                  }
                                  else{
                                      if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && ThreeChildBMI!=0.0){
                                          if (Individual_BMI < 16.0) {
                                              Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                          }else  if (twoAdult_BMI < 16.0){
                                              Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                          }else  if (ThreeChildBMI < 16.0){
                                              Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                          }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                              nextIntent();
                                          }
                                          else if (Individual_BMI > 33) {
                                              Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                          }else if (twoAdult_BMI > 33) {
                                              Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                          }else if (ThreeChildBMI > 33) {
                                              Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                          }
                                      }
                                  }
                            }
                            else if (selectYearChildFour > 19){
                                if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && FourChildBMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (twoAdult_BMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (FourChildBMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                        nextIntent();
                                    }else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (twoAdult_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (FourChildBMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            }
                            else{
                                if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0){
                                    if (Individual_BMI < 16.0) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else  if (twoAdult_BMI < 16.0){
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0) {
                                        nextIntent();
                                    }
                                    else if (Individual_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                    }else if (twoAdult_BMI > 33) {
                                        Toast.makeText(Arogya_Member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }else{
                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

//        btn_continue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Individual_BMI=0.0;
//                twoAdult_BMI=0.0;
//                str_edit_dob=edit_dob.getText().toString();
//                str_weight_edit=weight_edit.getText().toString();
//                str_spouse_edit_dob_dob=spouse_edit_dob.getText().toString();
//                str_edt_Spouse_name=edt_Spouse_name.getText().toString();
//                str_spouse_weight_edit=spouse_weight_edit.getText().toString();
//                str_OneEditName=OneEditName.getText().toString();
//                str_twoChildEditName=twoChildEditName.getText().toString();
//                str_thirdNameEdit=thirdNameEdit.getText().toString();
//                str_fourNameEdit=fourNameEdit.getText().toString();
//                str_oneWeightEdit=oneWeightEdit.getText().toString();
//                strOneChild=OneDob.getText().toString();
//                strtwoDob=twoDob.getText().toString();
//                strtwoWeightEdit=twoWeightEdit.getText().toString();
//                str_thirdWeightEdit=thirdWeightEdit.getText().toString();
//                strthreeDob=thirdDob.getText().toString();
//                strFourWeightEdit=FourWeightEdit.getText().toString();
//                strfourDob=fourDob.getText().toString();
//
//                if (str_policyType_spinner.equals("Individual")){
//                    if (str_edt_name.equals("")){
//                        Toast.makeText(Arogya_Member_info.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
//                    }else if(str_edit_dob.equals("")){
//                        Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
//                    } else if (str_gender.equals("Select Gender")){
//                        Toast.makeText(Arogya_Member_info.this, "Select Gender", Toast.LENGTH_SHORT).show();
//                    }else if (str_occupation.equals("Occupation")){
//                        Toast.makeText(Arogya_Member_info.this, "Select Occupation", Toast.LENGTH_SHORT).show();
//                    } else if(str_ft.equals("Ft") && str_inches.equals("Inches")){
//                        Toast.makeText(Arogya_Member_info.this, "Enter Ft & Inches", Toast.LENGTH_SHORT).show();
//                    }else if (str_weight_edit.equals("")){
//                        Toast.makeText(Arogya_Member_info.this, "Enter Weight in Kg", Toast.LENGTH_SHORT).show();
//                    } else {
//                        if (str_edit_dob3String != null){
//                            int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
//                            if (dateValidation < 18 || (dateValidation >55)) {
//                                Toast.makeText(Arogya_Member_info.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
//                            }else if(!str_ft.equals("Ft") && !str_inches.equals("Inches")) {
//                                cm=convertFeetandInchesToCentimeter(str_ft, str_inches);
//                                kg= Double.parseDouble(str_weight_edit);
//                                BMI=calculateBMI(kg,cm);
//                                if (BMI!=0.0){
//                                    if (BMI < 16.0) {
//                                        Toast.makeText(Arogya_Member_info.this, "Weight is not normal", Toast.LENGTH_SHORT).show();
//                                    }
//                                    else if (BMI >= 16.0 && BMI <= 33.0) {
//                                        Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
//                                        intent.putExtra("str_edt_name",str_edt_name);
//                                        intent.putExtra("str_edt_phone",str_edt_phone);
//                                        intent.putExtra("str_email",str_email);
//                                        intent.putExtra("str_age",str_age);
//                                        intent.putExtra("str_reference_no",str_reference_no);
//                                        intent.putExtra("str_edit_dob",str_edit_dob);
//                                        intent.putExtra("str_gender",str_gender);
//                                        intent.putExtra("str_occupation",str_occupation);
//                                        intent.putExtra("str_ft",str_ft);
//                                        intent.putExtra("str_inches",str_inches);
//                                        intent.putExtra("str_weight_edit",str_weight_edit);
//                                        intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                                        intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                                        intent.putExtra("str_spouse_gender",str_spouse_gender);
//                                        intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                                        intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                                        intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                                        intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                                        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                        intent.putExtra("str_SumInsured",str_SumInsured);
//                                        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                                        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                                        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                                        intent.putExtra("TotalValue",TotalValue);
//                                        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                        intent.putExtra("strFirstTString",strFirstTString);
//                                        intent.putExtra("PosPolicyNo",PosPolicyNo);
//                                        intent.putExtra("QuoteId",QuoteId);
//                                        intent.putExtra("TotalPremium",TotalPremium);
//                                        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                                        startActivity(intent);
//                                        finish();
//                                    }
//                                    else if (BMI >= 24.9 && BMI < 30) {
//                                        Toast.makeText(Arogya_Member_info.this, "Weight is not normal", Toast.LENGTH_SHORT).show();
//                                    } else if (BMI >33) {
//                                        Toast.makeText(Arogya_Member_info.this, "Weight is not normal", Toast.LENGTH_SHORT).show();
//                                    } }
//                            }
//                        }
//                    }
//
//
////                    Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,getApplicationContext());
//
//                }else {
//                    if(str_IndividualTypeEdit.equals("2 Adult")){
//                        if(!str_edit_dob.equals("")){
//                            str_spouse_edit_dob_dob=spouse_edit_dob.getText().toString();
//                            str_edt_Spouse_name=edt_Spouse_name.getText().toString();
//                            str_spouse_weight_edit=spouse_weight_edit.getText().toString();
//                            str_OneEditName=OneEditName.getText().toString();
//                            str_twoChildEditName=twoChildEditName.getText().toString();
//                            str_thirdNameEdit=thirdNameEdit.getText().toString();
//                            str_fourNameEdit=fourNameEdit.getText().toString();
//                            Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,getApplicationContext());
//                            twoAdult_BMI= calculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,getApplicationContext());
//                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0){
//                                if (Individual_BMI < 16.0) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (twoAdult_BMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >= 18.5 && Individual_BMI < 24.9 && twoAdult_BMI >= 18.5 && twoAdult_BMI < 24.9) {
//                                    Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
//                                    intent.putExtra("str_edt_name",str_edt_name);
//                                    intent.putExtra("str_edt_phone",str_edt_phone);
//                                    intent.putExtra("str_email",str_email);
//                                    intent.putExtra("str_age",str_age);
//                                    intent.putExtra("str_reference_no",str_reference_no);
//                                    intent.putExtra("str_edit_dob",str_edit_dob);
//                                    intent.putExtra("str_gender",str_gender);
//                                    intent.putExtra("str_occupation",str_occupation);
//                                    intent.putExtra("str_ft",str_ft);
//                                    intent.putExtra("str_inches",str_inches);
//                                    intent.putExtra("str_weight_edit",str_weight_edit);
//                                    intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                                    intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                                    intent.putExtra("str_spouse_gender",str_spouse_gender);
//                                    intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                                    intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                                    intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                                    intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_SumInsured",str_SumInsured);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                                    intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                                    intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                                    intent.putExtra("TotalValue",TotalValue);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("strFirstTString",strFirstTString);
//                                    intent.putExtra("PosPolicyNo",PosPolicyNo);
//                                    intent.putExtra("QuoteId",QuoteId);
//                                    intent.putExtra("TotalPremium",TotalPremium);
//                                    intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                                else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (twoAdult_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } }
//                        }else{
//                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
//                        if(!str_edit_dob.equals("")){
//                            Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,getApplicationContext());
//                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,getApplicationContext());
//                            if (Individual_BMI!=0.0 && OneChildBMI!=0.0){
//                                if (Individual_BMI < 16.0) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (OneChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >= 18.5 && Individual_BMI < 24.9 && OneChildBMI >= 18.5 && OneChildBMI < 24.9) {
//                                    Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
//                                    intent.putExtra("str_edt_name",str_edt_name);
//                                    intent.putExtra("str_edt_phone",str_edt_phone);
//                                    intent.putExtra("str_email",str_email);
//                                    intent.putExtra("str_age",str_age);
//                                    intent.putExtra("str_reference_no",str_reference_no);
//                                    intent.putExtra("str_edit_dob",str_edit_dob);
//                                    intent.putExtra("str_gender",str_gender);
//                                    intent.putExtra("str_occupation",str_occupation);
//                                    intent.putExtra("str_ft",str_ft);
//                                    intent.putExtra("str_inches",str_inches);
//                                    intent.putExtra("str_weight_edit",str_weight_edit);
//                                    intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                                    intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                                    intent.putExtra("str_spouse_gender",str_spouse_gender);
//                                    intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                                    intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                                    intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                                    intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_SumInsured",str_SumInsured);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("str_OneEditName",str_OneEditName);
//                                    intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                                    intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                                    intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                                    intent.putExtra("TotalValue",TotalValue);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("strFirstTString",strFirstTString);
//                                    intent.putExtra("PosPolicyNo",PosPolicyNo);
//                                    intent.putExtra("QuoteId",QuoteId);
//                                    intent.putExtra("TotalPremium",TotalPremium);
//                                    intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                                else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                                } else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (OneChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child weight is not normal", Toast.LENGTH_SHORT).show();
//                                } }
//                        }else{
//                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
//                        if(!str_edit_dob.equals("")){
//                            Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,getApplicationContext());
//                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,getApplicationContext());
//                            TwoChildBMI=SuperCalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,getApplicationContext());
//                            if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
//                                if (Individual_BMI < 16.0) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } else  if (OneChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (TwoChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >= 18.5 && Individual_BMI < 24.9 && OneChildBMI >= 18.5 && OneChildBMI < 24.9 && TwoChildBMI >= 18.5 && TwoChildBMI < 24.9) {
//                                    Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
//                                    intent.putExtra("str_edt_name",str_edt_name);
//                                    intent.putExtra("str_edt_phone",str_edt_phone);
//                                    intent.putExtra("str_email",str_email);
//                                    intent.putExtra("str_age",str_age);
//                                    intent.putExtra("str_reference_no",str_reference_no);
//                                    intent.putExtra("str_edit_dob",str_edit_dob);
//                                    intent.putExtra("str_gender",str_gender);
//                                    intent.putExtra("str_occupation",str_occupation);
//                                    intent.putExtra("str_ft",str_ft);
//                                    intent.putExtra("str_inches",str_inches);
//                                    intent.putExtra("str_weight_edit",str_weight_edit);
//                                    intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                                    intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                                    intent.putExtra("str_spouse_gender",str_spouse_gender);
//                                    intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                                    intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                                    intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                                    intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_SumInsured",str_SumInsured);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("str_OneEditName",str_OneEditName);
//                                    intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                                    intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                                    intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                                    intent.putExtra("TotalValue",TotalValue);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("strFirstTString",strFirstTString);
//                                    intent.putExtra("PosPolicyNo",PosPolicyNo);
//                                    intent.putExtra("QuoteId",QuoteId);
//                                    intent.putExtra("TotalPremium",TotalPremium);
//                                    intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                                else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (OneChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (TwoChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } }
//                        }else{
//                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
//                        if(!str_edit_dob.equals("")){
//                            Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,getApplicationContext());
//                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,getApplicationContext());
//                            TwoChildBMI=SuperCalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,getApplicationContext());
//                            ThreeChildBMI= SuperCalculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,getApplicationContext());
//                            if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
//                                if (Individual_BMI < 16.0) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } else  if (OneChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (TwoChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (ThreeChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >= 18.5 && Individual_BMI < 24.9 && OneChildBMI >= 18.5 && OneChildBMI < 24.9 && TwoChildBMI >= 18.5 && TwoChildBMI < 24.9 && ThreeChildBMI >= 18.5 && ThreeChildBMI < 24.9) {
//                                    Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
//                                    intent.putExtra("str_edt_name",str_edt_name);
//                                    intent.putExtra("str_edt_phone",str_edt_phone);
//                                    intent.putExtra("str_email",str_email);
//                                    intent.putExtra("str_age",str_age);
//                                    intent.putExtra("str_reference_no",str_reference_no);
//                                    intent.putExtra("str_edit_dob",str_edit_dob);
//                                    intent.putExtra("str_gender",str_gender);
//                                    intent.putExtra("str_occupation",str_occupation);
//                                    intent.putExtra("str_ft",str_ft);
//                                    intent.putExtra("str_inches",str_inches);
//                                    intent.putExtra("str_weight_edit",str_weight_edit);
//                                    intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                                    intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                                    intent.putExtra("str_spouse_gender",str_spouse_gender);
//                                    intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                                    intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                                    intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                                    intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_SumInsured",str_SumInsured);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("str_OneEditName",str_OneEditName);
//                                    intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                                    intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                                    intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                                    intent.putExtra("TotalValue",TotalValue);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("strFirstTString",strFirstTString);
//                                    intent.putExtra("PosPolicyNo",PosPolicyNo);
//                                    intent.putExtra("QuoteId",QuoteId);
//                                    intent.putExtra("TotalPremium",TotalPremium);
//                                    intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                                else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (ThreeChildBMI >= 24.9 && ThreeChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (OneChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (TwoChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }}else if (ThreeChildBMI >33) {
//                                Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                            } }
//                    }
//                    else if(str_IndividualTypeEdit.equals("1 Adult + 4 Child")){
//                        if(!str_edit_dob.equals("")){
//                            Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,getApplicationContext());
//                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,getApplicationContext());
//                            TwoChildBMI=SuperCalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,getApplicationContext());
//                            ThreeChildBMI= SuperCalculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,getApplicationContext());
//                            FourChildBMI= SuperCalculationFour(str_fourNameEdit,strfourDob,str_fourGenderSpinner,str_fourOccupationSpinner,str_fourFtSpinner,str_fourInchesSpinner,strFourWeightEdit,strChildFour,strThirdDString,getApplicationContext());
//
//                            if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
//                                if (Individual_BMI < 16.0) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (OneChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (TwoChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (ThreeChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (FourChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >= 18.5 && Individual_BMI < 24.9 && OneChildBMI >= 18.5 && OneChildBMI < 24.9 && TwoChildBMI >= 18.5 && TwoChildBMI < 24.9 && ThreeChildBMI >= 18.5 && ThreeChildBMI < 24.9 && FourChildBMI >= 18.5 && FourChildBMI < 24.9) {
//                                    Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
//                                    intent.putExtra("str_edt_name",str_edt_name);
//                                    intent.putExtra("str_edt_phone",str_edt_phone);
//                                    intent.putExtra("str_email",str_email);
//                                    intent.putExtra("str_age",str_age);
//                                    intent.putExtra("str_reference_no",str_reference_no);
//                                    intent.putExtra("str_edit_dob",str_edit_dob);
//                                    intent.putExtra("str_gender",str_gender);
//                                    intent.putExtra("str_occupation",str_occupation);
//                                    intent.putExtra("str_ft",str_ft);
//                                    intent.putExtra("str_inches",str_inches);
//                                    intent.putExtra("str_weight_edit",str_weight_edit);
//                                    intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                                    intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                                    intent.putExtra("str_spouse_gender",str_spouse_gender);
//                                    intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                                    intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                                    intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                                    intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_SumInsured",str_SumInsured);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("str_OneEditName",str_OneEditName);
//                                    intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                                    intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                                    intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                                    intent.putExtra("TotalValue",TotalValue);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("strFirstTString",strFirstTString);
//                                    intent.putExtra("PosPolicyNo",PosPolicyNo);
//                                    intent.putExtra("QuoteId",QuoteId);
//                                    intent.putExtra("TotalPremium",TotalPremium);
//                                    intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                                else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1  weight is not normal", Toast.LENGTH_SHORT).show();
//                                } else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (ThreeChildBMI >= 24.9 && ThreeChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (FourChildBMI >= 24.9 && FourChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (OneChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (TwoChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (ThreeChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (FourChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } }
//                        }else{
//                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
//                        } }
//                    else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
//                        if(!str_edit_dob.equals("")){
//                            Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,getApplicationContext());
//                            twoAdult_BMI= calculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,getApplicationContext());
//                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,getApplicationContext());
//                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0){
//                                if (Individual_BMI < 16.0) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (twoAdult_BMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (OneChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >= 18.5 && Individual_BMI < 24.9 && twoAdult_BMI >= 18.5 && twoAdult_BMI < 24.9 && OneChildBMI >= 18.5 && OneChildBMI < 24.9) {
//                                    Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
//                                    intent.putExtra("str_edt_name",str_edt_name);
//                                    intent.putExtra("str_edt_phone",str_edt_phone);
//                                    intent.putExtra("str_email",str_email);
//                                    intent.putExtra("str_age",str_age);
//                                    intent.putExtra("str_reference_no",str_reference_no);
//                                    intent.putExtra("str_edit_dob",str_edit_dob);
//                                    intent.putExtra("str_gender",str_gender);
//                                    intent.putExtra("str_occupation",str_occupation);
//                                    intent.putExtra("str_ft",str_ft);
//                                    intent.putExtra("str_inches",str_inches);
//                                    intent.putExtra("str_weight_edit",str_weight_edit);
//                                    intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                                    intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                                    intent.putExtra("str_spouse_gender",str_spouse_gender);
//                                    intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                                    intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                                    intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                                    intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_SumInsured",str_SumInsured);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("str_OneEditName",str_OneEditName);
//                                    intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                                    intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                                    intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                                    intent.putExtra("TotalValue",TotalValue);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("strFirstTString",strFirstTString);
//                                    intent.putExtra("PosPolicyNo",PosPolicyNo);
//                                    intent.putExtra("QuoteId",QuoteId);
//                                    intent.putExtra("TotalPremium",TotalPremium);
//                                    intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                                    startActivity(intent);
//
//                                }
//                                else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (twoAdult_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (OneChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } }
//                        }else{
//                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
//                        if(!str_edit_dob.equals("")){
//                            Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,getApplicationContext());
//                            twoAdult_BMI= calculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,getApplicationContext());
//                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,getApplicationContext());
//                            TwoChildBMI=SuperCalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,getApplicationContext());
//                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
//                                if (Individual_BMI < 16.0) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (twoAdult_BMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (OneChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (TwoChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >= 18.5 && Individual_BMI < 24.9 && twoAdult_BMI >= 18.5 && twoAdult_BMI < 24.9 && OneChildBMI >= 18.5 && OneChildBMI < 24.9 && TwoChildBMI >= 18.5 && TwoChildBMI < 24.9) {
//                                    Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
//                                    intent.putExtra("str_edt_name",str_edt_name);
//                                    intent.putExtra("str_edt_phone",str_edt_phone);
//                                    intent.putExtra("str_email",str_email);
//                                    intent.putExtra("str_age",str_age);
//                                    intent.putExtra("str_reference_no",str_reference_no);
//                                    intent.putExtra("str_edit_dob",str_edit_dob);
//                                    intent.putExtra("str_gender",str_gender);
//                                    intent.putExtra("str_occupation",str_occupation);
//                                    intent.putExtra("str_ft",str_ft);
//                                    intent.putExtra("str_inches",str_inches);
//                                    intent.putExtra("str_weight_edit",str_weight_edit);
//                                    intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                                    intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                                    intent.putExtra("str_spouse_gender",str_spouse_gender);
//                                    intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                                    intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                                    intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                                    intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_SumInsured",str_SumInsured);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("str_OneEditName",str_OneEditName);
//                                    intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                                    intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                                    intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                                    intent.putExtra("TotalValue",TotalValue);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("str_SumInsured",str_SumInsured);
//                                    intent.putExtra("strFirstTString",strFirstTString);
//                                    intent.putExtra("PosPolicyNo",PosPolicyNo);
//                                    intent.putExtra("QuoteId",QuoteId);
//                                    intent.putExtra("TotalPremium",TotalPremium);
//                                    intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                                else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (twoAdult_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (OneChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (TwoChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } }
//                        }else{
//                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
//                        }
//
//
//
//
//                    }
//                    else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
//                        if(!str_edit_dob.equals("")){
//                            Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,getApplicationContext());
//                            twoAdult_BMI= calculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,getApplicationContext());
//                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,getApplicationContext());
//                            TwoChildBMI=SuperCalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,getApplicationContext());
//                            ThreeChildBMI= SuperCalculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,getApplicationContext());
//                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
//                                if (Individual_BMI < 16.0) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (twoAdult_BMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (OneChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (TwoChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (ThreeChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >= 18.5 && Individual_BMI < 24.9 && twoAdult_BMI >= 18.5 && twoAdult_BMI < 24.9 && OneChildBMI >= 18.5 && OneChildBMI < 24.9 && TwoChildBMI >= 18.5 && TwoChildBMI < 24.9 && ThreeChildBMI >= 18.5 && ThreeChildBMI < 24.9) {
//                                    Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
//                                    intent.putExtra("str_edt_name",str_edt_name);
//                                    intent.putExtra("str_edt_phone",str_edt_phone);
//                                    intent.putExtra("str_email",str_email);
//                                    intent.putExtra("str_age",str_age);
//                                    intent.putExtra("str_reference_no",str_reference_no);
//                                    intent.putExtra("str_edit_dob",str_edit_dob);
//                                    intent.putExtra("str_gender",str_gender);
//                                    intent.putExtra("str_occupation",str_occupation);
//                                    intent.putExtra("str_ft",str_ft);
//                                    intent.putExtra("str_inches",str_inches);
//                                    intent.putExtra("str_weight_edit",str_weight_edit);
//                                    intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                                    intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                                    intent.putExtra("str_spouse_gender",str_spouse_gender);
//                                    intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                                    intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                                    intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                                    intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_SumInsured",str_SumInsured);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("str_OneEditName",str_OneEditName);
//                                    intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                                    intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                                    intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                                    intent.putExtra("TotalValue",TotalValue);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("str_SumInsured",str_SumInsured);
//                                    intent.putExtra("strFirstTString",strFirstTString);
//                                    intent.putExtra("PosPolicyNo",PosPolicyNo);
//                                    intent.putExtra("QuoteId",QuoteId);
//                                    intent.putExtra("TotalPremium",TotalPremium);
//                                    intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                                else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1  weight is not normal", Toast.LENGTH_SHORT).show();
//                                } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (ThreeChildBMI >= 24.9 && ThreeChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (twoAdult_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (OneChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (TwoChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (ThreeChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } }
//                        }else{
//                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
//                        if(!str_edit_dob.equals("")){
//                            Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,getApplicationContext());
//                            twoAdult_BMI= calculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,getApplicationContext());
//                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,getApplicationContext());
//                            TwoChildBMI=SuperCalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,getApplicationContext());
//                            ThreeChildBMI= SuperCalculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,getApplicationContext());
//                            FourChildBMI= SuperCalculationFour(str_fourNameEdit,strfourDob,str_fourGenderSpinner,str_fourOccupationSpinner,str_fourFtSpinner,str_fourInchesSpinner,strFourWeightEdit,strChildFour,strThirdDString,getApplicationContext());
//                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
//                                if (Individual_BMI < 16.0) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (twoAdult_BMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (OneChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (TwoChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (ThreeChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else  if (FourChildBMI < 16.0){
//                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >= 18.5 && Individual_BMI < 24.9 && twoAdult_BMI >= 18.5 && twoAdult_BMI < 24.9 && OneChildBMI >= 18.5 && OneChildBMI < 24.9 && TwoChildBMI >= 18.5 && TwoChildBMI < 24.9 && ThreeChildBMI >= 18.5 && ThreeChildBMI < 24.9 && FourChildBMI >= 18.5 && FourChildBMI < 24.9) {
//                                    Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
//                                    intent.putExtra("str_edt_name",str_edt_name);
//                                    intent.putExtra("str_edt_phone",str_edt_phone);
//                                    intent.putExtra("str_email",str_email);
//                                    intent.putExtra("str_age",str_age);
//                                    intent.putExtra("str_reference_no",str_reference_no);
//                                    intent.putExtra("str_edit_dob",str_edit_dob);
//                                    intent.putExtra("str_gender",str_gender);
//                                    intent.putExtra("str_occupation",str_occupation);
//                                    intent.putExtra("str_ft",str_ft);
//                                    intent.putExtra("str_inches",str_inches);
//                                    intent.putExtra("str_weight_edit",str_weight_edit);
//                                    intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                                    intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                                    intent.putExtra("str_spouse_gender",str_spouse_gender);
//                                    intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                                    intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                                    intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                                    intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_SumInsured",str_SumInsured);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("str_OneEditName",str_OneEditName);
//                                    intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                                    intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                                    intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                                    intent.putExtra("TotalValue",TotalValue);
//                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                                    intent.putExtra("str_SumInsured",str_SumInsured);
//                                    intent.putExtra("strFirstTString",strFirstTString);
//                                    intent.putExtra("PosPolicyNo",PosPolicyNo);
//                                    intent.putExtra("QuoteId",QuoteId);
//                                    intent.putExtra("TotalPremium",TotalPremium);
//                                    intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                                else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1  weight is not normal", Toast.LENGTH_SHORT).show();
//                                } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (ThreeChildBMI >= 24.9 && ThreeChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (FourChildBMI >= 24.9 && FourChildBMI < 30) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (Individual_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (twoAdult_BMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Adult 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (OneChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (TwoChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (ThreeChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                                }else if (FourChildBMI >33) {
//                                    Toast.makeText(Arogya_Member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
//                                } }
//                        }else{
//                            Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
//                        }
//
//
//
//
//                    }
//                    else{
//                        Toast.makeText(Arogya_Member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//            }
//        });
    }

    private void MotherFatherLawIntent() {
        if (strMotherLawName.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother-In-Law Name", Toast.LENGTH_SHORT).show();
        } else if (strMotherLawDob.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother-In-Law Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (strMotherLawOccupationEdit.equals("Occupation")) {
            Toast.makeText(Arogya_Member_info.this, "Select Mother-In-Law Occupation", Toast.LENGTH_SHORT).show();
        } else if (strMotherLawFtEdit.equals("Ft") && strMotherLawInchesEdit.equals("Inches")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother-In-Law Ft & Inches", Toast.LENGTH_SHORT).show();
        } else if (strMotherLawWeightEdit.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother-In-Law Weight in Kg", Toast.LENGTH_SHORT).show();
        }else if (strFatherLawName.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father-In-Law Name", Toast.LENGTH_SHORT).show();
        } else if (strFatherLawDob.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father-In-Law Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (strFatherLawOccupationEdit.equals("Occupation")) {
            Toast.makeText(Arogya_Member_info.this, "Select Father-In-Law Occupation", Toast.LENGTH_SHORT).show();
        } else if (strFatherLawFtEdit.equals("Ft") && strFatherLawInchesEdit.equals("Inches")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father-In-Law Ft & Inches", Toast.LENGTH_SHORT).show();
        } else if (strFatherLawWeightEdit.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father-In-Law Weight in Kg", Toast.LENGTH_SHORT).show();
        }
        else{
            MotherLawBMI = ArogyaCalculationMotherLaw(strMotherLawName, strMotherLawDob, strMotherLawEdit, strMotherLawOccupationEdit, strMotherLawFtEdit, strMotherLawInchesEdit, strMotherLawWeightEdit, strMotherLawDobString, strThirdDString, selectYearMotherLaw, getApplicationContext());
            FatherLawBMI = ArogyaCalculationFatherLaw(strFatherLawName, strFatherLawDob, strFatherLawEdit, strFatherLawOccupationEdit, strFatherLawFtEdit, strFatherLawInchesEdit, strFatherLawWeightEdit, strFatherLawDobString, strThirdDString, selectYearFatherLaw, getApplicationContext());
            if (MotherLawBMI != 0.0 && FatherLawBMI != 0.0 ){
                if (MotherLawBMI < 16.0) {
                    Toast.makeText(Arogya_Member_info.this, "Mother-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
                }else if (FatherLawBMI < 16.0) {
                    Toast.makeText(Arogya_Member_info.this, "Father-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
                } else if (MotherLawBMI >= 16.0 && MotherLawBMI <= 33.0 && FatherLawBMI >= 16.0 && FatherLawBMI <= 33.0) {
                    nextIntent();
                }else if (MotherLawBMI > 33) {
                    Toast.makeText(Arogya_Member_info.this, "Mother-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
                }else if (FatherLawBMI > 33) {
                    Toast.makeText(Arogya_Member_info.this, "Father-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void FatherLawIntent() {
         if (strFatherLawName.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father-In-Law Name", Toast.LENGTH_SHORT).show();
        } else if (strFatherLawDob.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father-In-Law Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (strFatherLawOccupationEdit.equals("Occupation")) {
            Toast.makeText(Arogya_Member_info.this, "Select Father-In-Law Occupation", Toast.LENGTH_SHORT).show();
        } else if (strFatherLawFtEdit.equals("Ft") && strFatherLawInchesEdit.equals("Inches")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father-In-Law Ft & Inches", Toast.LENGTH_SHORT).show();
        } else if (strFatherLawWeightEdit.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father-In-Law Weight in Kg", Toast.LENGTH_SHORT).show();
        }
        else{
            FatherLawBMI = ArogyaCalculationFatherLaw(strFatherLawName, strFatherLawDob, strFatherLawEdit, strFatherLawOccupationEdit, strFatherLawFtEdit, strFatherLawInchesEdit, strFatherLawWeightEdit, strFatherLawDobString, strThirdDString, selectYearFatherLaw, getApplicationContext());
            if (FatherLawBMI != 0.0 ){
                 if (FatherLawBMI < 16.0) {
                    Toast.makeText(Arogya_Member_info.this, "Father-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
                } else if (FatherLawBMI >= 16.0 && FatherLawBMI <= 33.0) {
                     nextIntent();
                }else if (FatherLawBMI > 33) {
                    Toast.makeText(Arogya_Member_info.this, "Father-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void MotherLawIntent() {
        if (strMotherLawName.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother-In-Law Name", Toast.LENGTH_SHORT).show();
        } else if (strMotherLawDob.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother-In-Law Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (strMotherLawOccupationEdit.equals("Occupation")) {
            Toast.makeText(Arogya_Member_info.this, "Select Mother-In-Law Occupation", Toast.LENGTH_SHORT).show();
        } else if (strMotherLawFtEdit.equals("Ft") && strMotherLawInchesEdit.equals("Inches")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother-In-Law Ft & Inches", Toast.LENGTH_SHORT).show();
        } else if (strMotherLawWeightEdit.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother-In-Law Weight in Kg", Toast.LENGTH_SHORT).show();
        }
        else{
            MotherLawBMI = ArogyaCalculationMotherLaw(strMotherLawName, strMotherLawDob, strMotherLawEdit, strMotherLawOccupationEdit, strMotherLawFtEdit, strMotherLawInchesEdit, strMotherLawWeightEdit, strMotherLawDobString, strThirdDString, selectYearMotherLaw, getApplicationContext());
            if (MotherLawBMI != 0.0 ){
                 if (MotherLawBMI < 16.0) {
                    Toast.makeText(Arogya_Member_info.this, "Mother-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
                } else if (MotherLawBMI >= 16.0 && MotherLawBMI <= 33.0) {
                    nextIntent();
                } else if (MotherLawBMI > 33) {
                    Toast.makeText(Arogya_Member_info.this, "Mother-In-Law BMI is not normal", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void MotherFatherIntent() {
        if (strMotherName.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother Name", Toast.LENGTH_SHORT).show();
        } else if (strMotherDob.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (strMotherOccupationEdit.equals("Occupation")) {
            Toast.makeText(Arogya_Member_info.this, "Select Mother Occupation", Toast.LENGTH_SHORT).show();
        } else if (strMotherFtEdit.equals("Ft") && strMotherInchesEdit.equals("Inches")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother Ft & Inches", Toast.LENGTH_SHORT).show();
        } else if (strMotherWeightEdit.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother Weight in Kg", Toast.LENGTH_SHORT).show();
        }else if (strFatherName.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father Name", Toast.LENGTH_SHORT).show();
        } else if (strFatherDob.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (strFatherOccupationEdit.equals("Occupation")) {
            Toast.makeText(Arogya_Member_info.this, "Select Father Occupation", Toast.LENGTH_SHORT).show();
        } else if (strFatherFtEdit.equals("Ft") && strFatherInchesEdit.equals("Inches")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father Ft & Inches", Toast.LENGTH_SHORT).show();
        } else if (strFatherWeightEdit.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father Weight in Kg", Toast.LENGTH_SHORT).show();
        }else{
            MotherBMI = ArogyaCalculationMother(strMotherName, strMotherDob, strMotherEdit, strMotherOccupationEdit, strMotherFtEdit, strMotherInchesEdit, strMotherWeightEdit, strMotherDobString, strThirdDString, selectYearMother, getApplicationContext());
            FatherBMI = ArogyaCalculationFather(strFatherName, strFatherDob, strFatherEdit, strFatherOccupationEdit, strFatherFtEdit, strFatherInchesEdit, strFatherWeightEdit, strFatherDobString, strThirdDString, selectYearFather, getApplicationContext());
            if (MotherBMI!= 0.0 && FatherBMI != 0.0 ){
                 if (MotherBMI < 16.0) {
                    Toast.makeText(Arogya_Member_info.this, "Mother BMI is not normal", Toast.LENGTH_SHORT).show();
                }else if (FatherBMI < 16.0) {
                    Toast.makeText(Arogya_Member_info.this, "Father BMI is not normal", Toast.LENGTH_SHORT).show();
                } else if (MotherBMI >= 16.0 && MotherBMI <= 33.0 && FatherBMI >= 16.0 && FatherBMI <= 33.0) {
                     nextIntent();
                }else if (MotherBMI > 33) {
                    Toast.makeText(Arogya_Member_info.this, "Mother BMI is not normal", Toast.LENGTH_SHORT).show();
                }else if (FatherBMI > 33) {
                    Toast.makeText(Arogya_Member_info.this, "Father BMI is not normal", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    private void FatherIntent() {
        if (strFatherName.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father Name", Toast.LENGTH_SHORT).show();
        } else if (strFatherDob.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (strFatherOccupationEdit.equals("Occupation")) {
            Toast.makeText(Arogya_Member_info.this, "Select Father Occupation", Toast.LENGTH_SHORT).show();
        } else if (strFatherFtEdit.equals("Ft") && strFatherInchesEdit.equals("Inches")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father Ft & Inches", Toast.LENGTH_SHORT).show();
        } else if (strFatherWeightEdit.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Father Weight in Kg", Toast.LENGTH_SHORT).show();
        }
        else{
            FatherBMI = ArogyaCalculationFather(strFatherName, strFatherDob, strFatherEdit, strFatherOccupationEdit, strFatherFtEdit, strFatherInchesEdit, strFatherWeightEdit, strFatherDobString, strThirdDString, selectYearFather, getApplicationContext());
            if (FatherBMI != 0.0 ){
                 if (FatherBMI < 16.0) {
                    Toast.makeText(Arogya_Member_info.this, "Father BMI is not normal", Toast.LENGTH_SHORT).show();
                } else if (FatherBMI >= 16.0 && FatherBMI <= 33.0) {
                     nextIntent();
                }else if (FatherBMI > 33) {
                    Toast.makeText(Arogya_Member_info.this, "Father BMI is not normal", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void MotherIntent() {
        if (strMotherName.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother Name", Toast.LENGTH_SHORT).show();
        } else if (strMotherDob.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (strMotherOccupationEdit.equals("Occupation")) {
            Toast.makeText(Arogya_Member_info.this, "Select Mother Occupation", Toast.LENGTH_SHORT).show();
        } else if (strMotherFtEdit.equals("Ft") && strMotherInchesEdit.equals("Inches")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother Ft & Inches", Toast.LENGTH_SHORT).show();
        } else if (strMotherWeightEdit.equals("")) {
            Toast.makeText(Arogya_Member_info.this, "Enter Mother Weight in Kg", Toast.LENGTH_SHORT).show();
        }
        else{
            MotherBMI = ArogyaCalculationMother(strMotherName, strMotherDob, strMotherEdit, strMotherOccupationEdit, strMotherFtEdit, strMotherInchesEdit, strMotherWeightEdit, strMotherDobString, strThirdDString, selectYearMother, getApplicationContext());
            if (MotherBMI != 0.0 ){
                 if (MotherBMI < 16.0) {
                    Toast.makeText(Arogya_Member_info.this, "Mother BMI is not normal", Toast.LENGTH_SHORT).show();
                } else if ( MotherBMI >= 16.0 && MotherBMI <= 33.0) {
                     nextIntent();
                }else if (MotherBMI > 33) {
                    Toast.makeText(Arogya_Member_info.this, "Mother BMI is not normal", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    private void showCalenderFatherLaw() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Arogya_Member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strFatherLawDob=dateFormatter.format(newDate.getTime());
            Log.e("strFatherLawDob", strFatherLawDob);

            String[] strdDate=  strFatherLawDob.split("/");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            strFatherLawDobString = strdDate[2];
            Log.e("strFatherLawDobString", strFatherLawDobString);
            FatherLawDob.setText(strFatherLawDob);

            try {
                SelectDate = dateFormatter.parse(strFatherLawDob);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearFatherLaw = period.getYears();
                    SelectMonthFatherLaw = period.getMonths();
                    SelectDaysFatherLaw = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearFatherLaw < 18 || (selectYearFatherLaw > 55)) {
                Toast.makeText(Arogya_Member_info.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                FatherLawDob.setText("");
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    private void showCalenderMotherLaw() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Arogya_Member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strMotherLawDob=dateFormatter.format(newDate.getTime());
            Log.e("strMotherLawDob", strMotherLawDob);
            String[] strdDate=  strMotherLawDob.split("/");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            strMotherLawDobString = strdDate[2];
            Log.e("strMotherLawDobString", strMotherLawDobString);
            MotherLawDob.setText(strMotherLawDob);
            try {
                SelectDate = dateFormatter.parse(strMotherLawDob);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearMotherLaw = period.getYears();
                    SelectMonthMotherLaw = period.getMonths();
                    SelectDaysMotherLaw = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearMotherLaw < 36 || (selectYearMotherLaw > 55)) {
                Toast.makeText(Arogya_Member_info.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                MotherLawDob.setText("");
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    private void showCalenderFather() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Arogya_Member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strFatherDob=dateFormatter.format(newDate.getTime());
            Log.e("strFatherDob", strFatherDob);

            String[] strdDate=  strFatherDob.split("/");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            strFatherDobString = strdDate[2];
            Log.e("strFatherDobString", strFatherDobString);
            FatherDob.setText(strFatherDob);

            try {
                SelectDate = dateFormatter.parse(strFatherDob);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearFather = period.getYears();
                    SelectMonthFather = period.getMonths();
                    SelectDaysFather = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearFather < 36 || (selectYearFather > 55)) {
                Toast.makeText(Arogya_Member_info.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                FatherDob.setText("");
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    private void showCalenderMother() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Arogya_Member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strMotherDob=dateFormatter.format(newDate.getTime());
            Log.e("strMotherDob", strMotherDob);

            String[] strdDate=  strMotherDob.split("/");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            strMotherDobString = strdDate[2];
            Log.e("strMotherDobString", strMotherDobString);
            MotherDob.setText(strMotherDob);

            try {
                SelectDate = dateFormatter.parse(strMotherDob);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearMother = period.getYears();
                    SelectMonthMother = period.getMonths();
                    SelectDaysMother = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (selectYearMother < 36 || (selectYearMother > 55)) {
                Toast.makeText(Arogya_Member_info.this, "Age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                MotherDob.setText("");
            }
          }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    private void twoAdultFourChild() {
        Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("BMI",BMI);
        intent.putExtra("Individual_BMI",Individual_BMI);
        intent.putExtra("twoAdult_BMI",twoAdult_BMI);
        intent.putExtra("OneChildBMI",OneChildBMI);
        intent.putExtra("TwoChildBMI",TwoChildBMI);
        intent.putExtra("ThreeChildBMI",ThreeChildBMI);
        intent.putExtra("FourChildBMI",FourChildBMI);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_email",str_email);
        intent.putExtra("str_age",str_age);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("str_reference_no",str_reference_no);
        intent.putExtra("str_edit_dob",str_edit_dob);
        intent.putExtra("str_gender",str_gender);
        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
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
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_OneEditName",str_OneEditName);
        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
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
        intent.putExtra("TotalValue",TotalValue);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("strFirstTString",strFirstTString);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("strChildOne",strChildOne);
        intent.putExtra("strChildTwo",strChildTwo);
        intent.putExtra("strChildThree",strChildThree);
        intent.putExtra("strChildFour",strChildFour);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("strOneChild",strOneChild);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
        intent.putExtra("GST",GST);
        intent.putExtra("str_RelationEdit",str_RelationEdit);
        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("TotalPremium",TotalPremium);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("for","0");
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
        intent.putExtra("str_policyTenure",str_policyTenure);
        intent.putExtra("str_life_style_spinner",str_life_style_spinner);
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("selectYearAdult",selectYearAdult);
        intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
        intent.putExtra("selectYearChild",selectYearChild);
        intent.putExtra("selectYearChildTwo",selectYearChildTwo);
        intent.putExtra("selectYearChildThird",selectYearChildThird);
        intent.putExtra("selectYearChildFour",selectYearChildFour);
        intent.putExtra("strParentEditText",strParentEditText);
        startActivity(intent);
        finish();
    }

    private void twoAdultThreeChild() {
        Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_email",str_email);
        intent.putExtra("str_age",str_age);
        intent.putExtra("str_reference_no",str_reference_no);
        intent.putExtra("str_edit_dob",str_edit_dob);
        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
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
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_OneEditName",str_OneEditName);
        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
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
        intent.putExtra("TotalValue",TotalValue);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("strFirstTString",strFirstTString);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("strChildOne",strChildOne);
        intent.putExtra("strChildTwo",strChildTwo);
        intent.putExtra("strChildThree",strChildThree);
        intent.putExtra("strChildFour",strChildFour);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("strOneChild",strOneChild);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
        intent.putExtra("GST",GST);
        intent.putExtra("str_RelationEdit",str_RelationEdit);
        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("TotalPremium",TotalPremium);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("for","0");
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
        intent.putExtra("str_policyTenure",str_policyTenure);
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
        startActivity(intent);
        finish();
    }

    private void TwoAdultTwoChildInent() {
        Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_email",str_email);
        intent.putExtra("str_age",str_age);
        intent.putExtra("str_reference_no",str_reference_no);
        intent.putExtra("str_edit_dob",str_edit_dob);
        intent.putExtra("str_gender",str_gender);
        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
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
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_OneEditName",str_OneEditName);
        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
        intent.putExtra("TotalValue",TotalValue);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("strFirstTString",strFirstTString);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("strChildOne",strChildOne);
        intent.putExtra("strChildTwo",strChildTwo);
        intent.putExtra("strChildThree",strChildThree);
        intent.putExtra("strChildFour",strChildFour);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("strOneChild",strOneChild);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
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
        intent.putExtra("GST",GST);
        intent.putExtra("str_RelationEdit",str_RelationEdit);
        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("TotalPremium",TotalPremium);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("for","0");
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
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
        startActivity(intent);
        finish();
    }

    private void twoAdultOneChild() {
        Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_email",str_email);
        intent.putExtra("str_age",str_age);
        intent.putExtra("str_reference_no",str_reference_no);
        intent.putExtra("str_edit_dob",str_edit_dob);
        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
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
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_OneEditName",str_OneEditName);
        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
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
        intent.putExtra("TotalValue",TotalValue);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("strFirstTString",strFirstTString);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("strChildOne",strChildOne);
        intent.putExtra("strChildTwo",strChildTwo);
        intent.putExtra("strChildThree",strChildThree);
        intent.putExtra("strChildFour",strChildFour);
        intent.putExtra("strOneChild",strOneChild);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("GST",GST);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("TotalPremium",TotalPremium);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("str_RelationEdit",str_RelationEdit);
        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("for","0");
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
        intent.putExtra("str_policyTenure",str_policyTenure);
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
        intent.putExtra("selectYearAdult",selectYearAdult);
        intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
        intent.putExtra("selectYearChild",selectYearChild);
        intent.putExtra("selectYearChildTwo",selectYearChildTwo);
        intent.putExtra("selectYearChildThird",selectYearChildThird);
        intent.putExtra("selectYearChildFour",selectYearChildFour);
        intent.putExtra("strParentEditText",strParentEditText);
        startActivity(intent);
        finish();
    }

    private void forChildOneChild() {
        Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_email",str_email);
        intent.putExtra("str_age",str_age);
        intent.putExtra("str_reference_no",str_reference_no);
        intent.putExtra("str_edit_dob",str_edit_dob);
        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
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
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_OneEditName",str_OneEditName);
        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
        intent.putExtra("TotalValue",TotalValue);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("strFirstTString",strFirstTString);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("strChildOne",strChildOne);
        intent.putExtra("strChildTwo",strChildTwo);
        intent.putExtra("strChildThree",strChildThree);
        intent.putExtra("strChildFour",strChildFour);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("strOneChild",strOneChild);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
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
        intent.putExtra("GST",GST);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("TotalPremium",TotalPremium);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("str_RelationEdit",str_RelationEdit);
        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("for","0");
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
        intent.putExtra("str_policyTenure",str_policyTenure);
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
        startActivity(intent);
        finish();
    }

    private void oneAdultThreeChild() {
        Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_email",str_email);
        intent.putExtra("str_age",str_age);
        intent.putExtra("str_reference_no",str_reference_no);
        intent.putExtra("str_edit_dob",str_edit_dob);
        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
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
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_OneEditName",str_OneEditName);
        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
        intent.putExtra("TotalValue",TotalValue);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("strFirstTString",strFirstTString);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("strChildOne",strChildOne);
        intent.putExtra("strChildTwo",strChildTwo);
        intent.putExtra("strChildThree",strChildThree);
        intent.putExtra("strChildFour",strChildFour);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("strOneChild",strOneChild);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
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
        intent.putExtra("GST",GST);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("TotalPremium",TotalPremium);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("str_RelationEdit",str_RelationEdit);
        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("for","0");
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
        intent.putExtra("str_policyTenure",str_policyTenure);
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
        startActivity(intent);
        finish();
    }

    private void oneAdultTwoChild() {
        Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_email",str_email);
        intent.putExtra("str_age",str_age);
        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
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
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_OneEditName",str_OneEditName);
        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
        intent.putExtra("TotalValue",TotalValue);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("strFirstTString",strFirstTString);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("strChildOne",strChildOne);
        intent.putExtra("strChildTwo",strChildTwo);
        intent.putExtra("strChildThree",strChildThree);
        intent.putExtra("strChildFour",strChildFour);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strOneChild",strOneChild);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
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
        intent.putExtra("str_RelationEdit",str_RelationEdit);
        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
        intent.putExtra("GST",GST);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("TotalPremium",TotalPremium);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("for","0");
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
        intent.putExtra("str_policyTenure",str_policyTenure);
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
        startActivity(intent);
        finish();
    }

    private void oneAdultOneChild() {
        Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_email",str_email);
        intent.putExtra("str_age",str_age);
        intent.putExtra("str_reference_no",str_reference_no);
        intent.putExtra("str_edit_dob",str_edit_dob);
        intent.putExtra("str_gender",str_gender);
        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
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
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_OneEditName",str_OneEditName);
        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
        intent.putExtra("TotalValue",TotalValue);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("strFirstTString",strFirstTString);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("strChildOne",strChildOne);
        intent.putExtra("strChildTwo",strChildTwo);
        intent.putExtra("strChildThree",strChildThree);
        intent.putExtra("strChildFour",strChildFour);
        intent.putExtra("strOneChild",strOneChild);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
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
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("GST",GST);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("TotalPremium",TotalPremium);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("str_RelationEdit",str_RelationEdit);
        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("for","0");
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
        intent.putExtra("str_policyTenure",str_policyTenure);
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
        startActivity(intent);
        finish();
    }

    private void twoAdult() {
        if (strParentEditText.equals("Mother")){
            MotherIntent();
        }else if (strParentEditText.equals("Father")){
            FatherIntent();
        }else if (strParentEditText.equals("Mother & Father")){
            MotherFatherIntent();
        }else if (strParentEditText.equals("Mother-In-Law")){
            MotherLawIntent();
        }else if (strParentEditText.equals("Father-In-Law")){
            FatherLawIntent();
        }else if (strParentEditText.equals("Mother-In-Law & Father-In-Law")){
            MotherFatherLawIntent();
        }else{
            nextIntent();
        }
    }

    private void nextIntent() {
        Intent intent=new Intent(Arogya_Member_info.this, Arogya_Medical_Discount.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("BMI",BMI);
        intent.putExtra("Individual_BMI",Individual_BMI);
        intent.putExtra("twoAdult_BMI",twoAdult_BMI);
        intent.putExtra("OneChildBMI",OneChildBMI);
        intent.putExtra("TwoChildBMI",TwoChildBMI);
        intent.putExtra("ThreeChildBMI",ThreeChildBMI);
        intent.putExtra("FourChildBMI",FourChildBMI);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_email",str_email);
        intent.putExtra("str_age",str_age);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("str_reference_no",str_reference_no);
        intent.putExtra("str_edit_dob",str_edit_dob);
        intent.putExtra("str_gender",str_gender);
        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
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
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_OneEditName",str_OneEditName);
        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
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
        intent.putExtra("TotalValue",TotalValue);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("strFirstTString",strFirstTString);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("strChildOne",strChildOne);
        intent.putExtra("strChildTwo",strChildTwo);
        intent.putExtra("strChildThree",strChildThree);
        intent.putExtra("strChildFour",strChildFour);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("strOneChild",strOneChild);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
        intent.putExtra("GST",GST);
        intent.putExtra("str_RelationEdit",str_RelationEdit);
        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("TotalPremium",TotalPremium);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("for","0");
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
        intent.putExtra("str_policyTenure",str_policyTenure);
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

    private double calculateBMI(double kg, double cm) {
        double heightMeter= cm/ 100;
        BMI = kg/ (heightMeter * heightMeter);
        Log.e("bmi", String.valueOf(BMI));
        return BMI;
    }



    public double convertFeetandInchesToCentimeter(String feet, String inches) {
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
        cm=(heightInFeet * 30.48) + (heightInInches * 2.54);
        Log.e("heightInCm", String.valueOf(cm));
        return cm;

    }
//    shi & asi
    private void showCalenderchild() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Arogya_Member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strOneChild=dateFormatter.format(newDate.getTime());
            String[] strdDate2=  strOneChild.split("/");
            String strone = strdDate2[0];
            String strtwo = strdDate2[1];
            strChildOne = strdDate2[2];
            OneDob.setText(strOneChild);
            try {
                SelectDate = dateFormatter.parse(strOneChild);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearChild= period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strOneChild,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeft= Integer.parseInt(days);
                Log.e("daysleft", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strChildOne != null) {
                if (daysLeft < 91) {
                    Toast.makeText(Arogya_Member_info.this, "1st Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();
                    OneDob.setText("");
                }else{
                    OneDob.setText(strOneChild);
                }
            }

//            if (strChildOne != null) {
//                if (selectYearChild < 1 || (selectYearChild > 25)) {
//                    Toast.makeText(Arogya_Member_info.this, "1st Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
//                    OneDob.setText("");
//                }else{
//                    OneDob.setText(strOneChild);
//                }
//            }


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalendertwochild() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Arogya_Member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strtwoDob=dateFormatter.format(newDate.getTime());
            String[] strDateOB2=  strtwoDob.split("/");
            String strone = strDateOB2[0];
            String strtwo = strDateOB2[1];
            strChildTwo = strDateOB2[2];
            twoDob.setText(strtwoDob);

            try {
                SelectDate = dateFormatter.parse(strtwoDob);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearChildTwo = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strtwoDob,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild2= Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strChildTwo != null) {
                if (daysLeftChild2 < 91) {
                    Toast.makeText(Arogya_Member_info.this, "2nd Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();
                    twoDob.setText("");
                }else{
                    twoDob.setText(strtwoDob);
                }
            }


//            if (strChildTwo != null) {
//                if (selectYearChildTwo < 1 || (selectYearChildTwo > 25)) {
//                    Toast.makeText(Arogya_Member_info.this, "2nd Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
//                    twoDob.setText("");
//                }else{
//                    twoDob.setText(strtwoDob);
//                }
//            }


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalenderthreechild() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Arogya_Member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strthreeDob=dateFormatter.format(newDate.getTime());
            String[] strDateOB2=  strthreeDob.split("/");
            String strone = strDateOB2[0];
            String strtwo = strDateOB2[1];
            strChildThree = strDateOB2[2];
            thirdDob.setText(strthreeDob);
            try {
                SelectDate = dateFormatter.parse(strthreeDob);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearChildThird = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strthreeDob,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild3= Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strChildThree != null) {
                if (daysLeftChild3 < 91) {
                    Toast.makeText(Arogya_Member_info.this, "3rd Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();
                    thirdDob.setText("");
                }else{
                    thirdDob.setText(strthreeDob);
                }
            }
//            if (strChildThree != null) {
//                if (selectYearChildThird < 1 || (selectYearChildThird > 25)) {
//                    Toast.makeText(Arogya_Member_info.this, "3rd Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
//                    thirdDob.setText("");
//                }else{
//                    thirdDob.setText(strthreeDob);
//                }
//            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalenderfourchild() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Arogya_Member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strfourDob=dateFormatter.format(newDate.getTime());
            String[] strDateOB2=  strfourDob.split("/");
            String strone = strDateOB2[0];
            String strtwo = strDateOB2[1];
            strChildFour = strDateOB2[2];
            fourDob.setText(strfourDob);
            try {
                SelectDate = dateFormatter.parse(strfourDob);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearChildFour = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strfourDob,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild4= Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strChildFour != null) {
                if (daysLeftChild4 < 91) {
                    Toast.makeText(Arogya_Member_info.this, "4th Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();
                    fourDob.setText("");
                }else{
                    fourDob.setText(strfourDob);
                }
            }

//            if (strChildFour != null) {
//                if (selectYearChildFour < 1 || (selectYearChildFour > 25)) {
//                    Toast.makeText(Arogya_Member_info.this, "4th Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
//                    fourDob.setText("");
//                }else{
//                    fourDob.setText(strfourDob);
//                }
//            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalenderspouse() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Arogya_Member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            str_spouse_edit_dob_dob=dateFormatter.format(newDate.getTime());
            String[] strdDate1=  str_spouse_edit_dob_dob.split("/");
            String str_edit_dobDString = strdDate1[0];
            String str_edit_dob2String = strdDate1[1];
            str_edit_dob3StringSpouse = strdDate1[2];
            spouse_edit_dob.setText(str_spouse_edit_dob_dob);
            try {
                SelectDate = dateFormatter.parse(str_spouse_edit_dob_dob);
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

            if (str_for.equals("0")){
                if (str_edit_dob3StringSpouse != null) {
                    Log.e("str_edit_dob3String",str_edit_dob3StringSpouse);
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3StringSpouse);
                    if (selectYearSecondAdult < Integer.parseInt(strFirstString) || (selectYearSecondAdult > Integer.parseInt(strFourString))) {
                        str_edit_dob=str_spouse_edit_dob_dob;
                        strOneChild="27/01/2005";
                        strtwoDob="27/01/2005";
                        strthreeDob="27/01/2005";
                        strfourDob="27/01/2005";
                        strRelationChildEdit="Child1";
                        strRelationChildTwoEdit="Child2";
                        strRelationChildThreeEdit="Child3";
                        strRelationFourChildEdit="Child4";
                        SaveQuotationWA();
                        Toast.makeText(Arogya_Member_info.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
                    }else{
                        strOneChild="27/01/2005";
                        strtwoDob="27/01/2005";
                        strthreeDob="27/01/2005";
                        strfourDob="27/01/2005";
                        strRelationChildEdit="Child1";
                        strRelationChildTwoEdit="Child2";
                        strRelationChildThreeEdit="Child3";
                        strRelationFourChildEdit="Child4";
                        SaveQuotationWA();
                    }
                }
            }
            else if (str_for.equals("1")){
                if (str_edit_dob3StringSpouse != null) {
                    Log.e("str_edit_dob3String",str_edit_dob3StringSpouse);
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3StringSpouse);
                    if (selectYearSecondAdult < Integer.parseInt(strFirstString) || (selectYearSecondAdult > Integer.parseInt(strFourString))) {
                        str_edit_dob=str_spouse_edit_dob_dob;
                        SaveQuotationWA();
                        Toast.makeText(Arogya_Member_info.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
                    }else{
                        SaveQuotationWA();
                    }
                }
            }

//            if (str_for.equals("0")){
//                if (str_edit_dob3StringSpouse != null) {
//                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
//                    int dateValidationAdult2 = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3StringSpouse);
//                    if (dateValidationAdult2 < dateValidation ){
//                    }else if(dateValidationAdult2 >dateValidation) {
//                        SaveQuotationWAAdult();
//                        Toast.makeText(Arogya_Member_info.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
//                    }else{
//                        SaveQuotationWAAdult();
//                    }
//
//                }
//            }
//            else if (str_for.equals("1")){
//                if (str_edit_dob3StringSpouse != null) {
//                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
//                    int dateValidationAdult2 = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3StringSpouse);
//                    if (dateValidationAdult2 < dateValidation ){
//                    }else if(dateValidationAdult2 >dateValidation) {
//                        SaveQuotationWAAdult();
//                        Toast.makeText(Arogya_Member_info.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
//                    }else{
//                        SaveQuotationWAAdult();
//                    }
//
//                }
//            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Arogya_Member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            str_edit_dob=dateFormatter.format(newDate.getTime());
            Log.e("str_edit_dob", str_edit_dob);

            String[] strdDate=  str_edit_dob.split("/");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            str_edit_dob3String = strdDate[2];
            Log.e("str_edit_dob3String", str_edit_dob3String);
            edit_dob.setText(str_edit_dob);

            try {
                SelectDate = dateFormatter.parse(str_edit_dob);
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


            if (str_for.equals("0")){
                if (str_edit_dob3String != null) {
                    Log.e("str_edit_dob3String",str_edit_dob3String);
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
                    if (selectYearAdult < Integer.parseInt(strFirstString) || (selectYearAdult > Integer.parseInt(strFourString))) {
                        str_spouse_edit_dob_dob=str_edit_dob;
                        strOneChild="27/01/2005";
                        strtwoDob="27/01/2005";
                        strthreeDob="27/01/2005";
                        strfourDob="27/01/2005";
                        strRelationChildEdit="Child1";
                        strRelationChildTwoEdit="Child2";
                        strRelationChildThreeEdit="Child3";
                        strRelationFourChildEdit="Child4";
                        SaveQuotationWA();
                        Toast.makeText(Arogya_Member_info.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
                    }else{
                        str_spouse_edit_dob_dob=str_edit_dob;
                        strOneChild="27/01/2005";
                        strtwoDob="27/01/2005";
                        strthreeDob="27/01/2005";
                        strfourDob="27/01/2005";
                        strRelationChildEdit="Child1";
                        strRelationChildTwoEdit="Child2";
                        strRelationChildThreeEdit="Child3";
                        strRelationFourChildEdit="Child4";
                        SaveQuotationWA();
                    }
                }
            }
            else if (str_for.equals("1")){
                if (str_edit_dob3String != null) {
                    Log.e("str_edit_dob3String",str_edit_dob3String);
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
                    if (selectYearAdult < Integer.parseInt(strFirstString) || (selectYearAdult > Integer.parseInt(strFourString))) {
                        SaveQuotationWA();
                        Toast.makeText(Arogya_Member_info.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
                    }else{
                        SaveQuotationWA();
                    }
                }
            }


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void SaveQuotationWA() {
        JSONObject object = new JSONObject();
        try {
            object.put("QuoteId","");
            object.put("ProductCode","2851");
            object.put("PolicyType",str_policyType_spinner);
            object.put("FamilyCombo","");
            object.put("PlanType",str_IndividualTypeEdit);
            object.put("PolicyDuration",str_policyTenure);
            object.put("IsPED","No");
            object.put("BasicPremium","");
            object.put("NetPremium","");
            object.put("GST","");
            object.put("TotalPremium","");
            object.put("UpdateFlag","");
            object.put("PageName","");
            object.put("RedirectUrl","");
            object.put("ProposalNo","");
            object.put("PolicyNo","");
            object.put("IsSameProposer","Yes");
            object.put("ProposerName","Prafulla");
            object.put("ProposerRelation","Brother");
            object.put("InstallmentFrequency",str_Payment_spinner);
            object.put("IsLoyatyDicsount",str_existing_spinner);
            object.put("ExistingPolicyNo",strExisting_policy_number);
            JSONArray array=new JSONArray();
            if(str_IndividualTypeEdit.equals("1 Adult")){
                JSONObject obj=new JSONObject();
                obj.put("Name",str_edt_name);
                obj.put("DOB",str_edit_dob);
                obj.put("Gender",str_gender);
                obj.put("HeightInFeet",str_ft);
                obj.put("HeightInInches",str_inches);
                obj.put("Weight",str_weight_edit);
                obj.put("BMI",BMI);
                obj.put("Occupation",str_occupation);
                obj.put("Relation",str_RelationEdit);
                obj.put("SumInsured",str_SumInsured);
                array.put(obj);
            }
            else if (str_policyType_spinner.equals("Family Floater")){
                if(str_IndividualTypeEdit.equals("2 Adult")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_name);
                    objAdult2.put("DOB",str_edit_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_thirdNameEdit);
                    objChild3.put("DOB",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("HeightInFeet",str_thirdFtSpinner);
                    objChild3.put("HeightInInches",str_thirdInchesSpinner);
                    objChild3.put("Weight",str_thirdWeightEdit);
                    objChild3.put("BMI",ThreeChildBMI);
                    objChild3.put("Occupation",str_thirdOccupationSpinner);
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 4 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_thirdNameEdit);
                    objChild3.put("DOB",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("HeightInFeet",str_thirdFtSpinner);
                    objChild3.put("HeightInInches",str_thirdInchesSpinner);
                    objChild3.put("Weight",str_thirdWeightEdit);
                    objChild3.put("BMI",ThreeChildBMI);
                    objChild3.put("Occupation",str_thirdOccupationSpinner);
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                    JSONObject objChild4=new JSONObject();
                    objChild4.put("Name",str_fourNameEdit);
                    objChild4.put("DOB",strfourDob);
                    objChild4.put("Gender",str_fourGenderSpinner);
                    objChild4.put("HeightInFeet",str_fourFtSpinner);
                    objChild4.put("HeightInInches",str_fourInchesSpinner);
                    objChild4.put("Weight",strFourWeightEdit);
                    objChild4.put("BMI",FourChildBMI);
                    objChild4.put("Occupation",str_fourOccupationSpinner);
                    objChild4.put("Relation",strRelationFourChildEdit);
                    objChild4.put("SumInsured",str_SumInsured);
                    array.put(objChild4);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_thirdNameEdit);
                    objChild3.put("DOB",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("HeightInFeet",str_thirdFtSpinner);
                    objChild3.put("HeightInInches",str_thirdInchesSpinner);
                    objChild3.put("Weight",str_thirdWeightEdit);
                    objChild3.put("BMI",ThreeChildBMI);
                    objChild3.put("Occupation",str_thirdOccupationSpinner);
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_thirdNameEdit);
                    objChild3.put("DOB",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("HeightInFeet",str_thirdFtSpinner);
                    objChild3.put("HeightInInches",str_thirdInchesSpinner);
                    objChild3.put("Weight",str_thirdWeightEdit);
                    objChild3.put("BMI",ThreeChildBMI);
                    objChild3.put("Occupation",str_thirdOccupationSpinner);
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                    JSONObject objChild4=new JSONObject();
                    objChild4.put("Name",str_fourNameEdit);
                    objChild4.put("DOB",strfourDob);
                    objChild4.put("Gender",str_fourGenderSpinner);
                    objChild4.put("HeightInFeet",str_fourFtSpinner);
                    objChild4.put("HeightInInches",str_fourInchesSpinner);
                    objChild4.put("Weight",strFourWeightEdit);
                    objChild4.put("BMI",FourChildBMI);
                    objChild4.put("Occupation",str_fourOccupationSpinner);
                    objChild4.put("Relation",strRelationFourChildEdit);
                    objChild4.put("SumInsured",str_SumInsured);
                    array.put(objChild4);
                }
            }
            object.put("asiQouteInsuredInfo",array);
            JSONObject Customer_Details_obj=new JSONObject();
            Customer_Details_obj.put("CustomerId","");
            Customer_Details_obj.put("CustomerName","");
            object.put("CustomerDetails",Customer_Details_obj);
            JSONObject authenticate_obj=new JSONObject();
            authenticate_obj.put("WebAggregatorCode","20000001");
            authenticate_obj.put("WAApplicationCode","30000011");
            authenticate_obj.put("WAUserID","USER01");
            authenticate_obj.put("WAUserPassword","pass@123");
            authenticate_obj.put("WAType","0");
            object.put("authenticate",authenticate_obj);
            object.put("ErrorMessage","");

        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Arogya_Member_info.this, object, UrlHealthConstants.SaveQuotationWA_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("ErrorMessage").equals("null")) {
                    if (Tag == RequestHealthConstants.Arogya_QUATATION) {
                        try {
                            QuoteId  = object.optString("QuoteId");
                            TotalValue = object.optString("TotalPremium");
                            NetPremium = object.optString("NetPremium");
                            GST = object.optString("GST");
                            strLoyaltyDiscount = object.optString("LoyaltyDiscount");
                            JSONArray installmentFreq = object.getJSONArray("installmentFreq");
                            for (int i = 0; i < installmentFreq.length(); i++) {
                                JSONObject obj = installmentFreq.getJSONObject(0);
                                TotalInstallPremium = obj.optString("TotalInstallPremium");

                            }
//                            existing_policy_amount.setText(strLoyaltyDiscount);
                            totalPremiumAmount.setText(TotalValue);
//                            txtNetPremiumValue.setText(NetPremium);
                            QuotationID.setText(QuoteId);
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                }else {
                    Toast.makeText(getApplication(), object.optString("ErrorMessage"), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestHealthConstants.Arogya_QUATATION);
        req.execute();

    }
    private void SaveQuotationWAAdult() {
        JSONObject object = new JSONObject();
        try {
            object.put("QuoteId","");
            object.put("ProductCode","2851");
            object.put("PolicyType",str_policyType_spinner);
            object.put("FamilyCombo","");
            object.put("PlanType",str_IndividualTypeEdit);
            object.put("PolicyDuration",str_policyTenure);
            object.put("IsPED","No");
            object.put("BasicPremium","");
            object.put("NetPremium","");
            object.put("GST","");
            object.put("TotalPremium","");
            object.put("UpdateFlag","");
            object.put("PageName","");
            object.put("RedirectUrl","");
            object.put("ProposalNo","");
            object.put("PolicyNo","");
            object.put("IsSameProposer","Yes");
            object.put("ProposerName","Prafulla");
            object.put("ProposerRelation","Brother");
            object.put("InstallmentFrequency",str_Payment_spinner);
            object.put("IsLoyatyDicsount",str_existing_spinner);
            object.put("ExistingPolicyNo",strExisting_policy_number);
            JSONArray array=new JSONArray();
            if(str_IndividualTypeEdit.equals("1 Adult")){
                JSONObject obj=new JSONObject();
                obj.put("Name",str_edt_name);
                obj.put("DOB",str_edit_dob);
                obj.put("Gender",str_gender);
                obj.put("HeightInFeet",str_ft);
                obj.put("HeightInInches",str_inches);
                obj.put("Weight",str_weight_edit);
                obj.put("BMI",BMI);
                obj.put("Occupation",str_occupation);
                obj.put("Relation",str_RelationEdit);
                obj.put("SumInsured",str_SumInsured);
                array.put(obj);
            }
            else if (str_policyType_spinner.equals("Family Floater")){
                if(str_IndividualTypeEdit.equals("2 Adult")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_spouse_edit_dob_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_thirdNameEdit);
                    objChild3.put("DOB",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("HeightInFeet",str_thirdFtSpinner);
                    objChild3.put("HeightInInches",str_thirdInchesSpinner);
                    objChild3.put("Weight",str_thirdWeightEdit);
                    objChild3.put("BMI",ThreeChildBMI);
                    objChild3.put("Occupation",str_thirdOccupationSpinner);
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 4 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_thirdNameEdit);
                    objChild3.put("DOB",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("HeightInFeet",str_thirdFtSpinner);
                    objChild3.put("HeightInInches",str_thirdInchesSpinner);
                    objChild3.put("Weight",str_thirdWeightEdit);
                    objChild3.put("BMI",ThreeChildBMI);
                    objChild3.put("Occupation",str_thirdOccupationSpinner);
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                    JSONObject objChild4=new JSONObject();
                    objChild4.put("Name",str_fourNameEdit);
                    objChild4.put("DOB",strfourDob);
                    objChild4.put("Gender",str_fourGenderSpinner);
                    objChild4.put("HeightInFeet",str_fourFtSpinner);
                    objChild4.put("HeightInInches",str_fourInchesSpinner);
                    objChild4.put("Weight",strFourWeightEdit);
                    objChild4.put("BMI",FourChildBMI);
                    objChild4.put("Occupation",str_fourOccupationSpinner);
                    objChild4.put("Relation",strRelationFourChildEdit);
                    objChild4.put("SumInsured",str_SumInsured);
                    array.put(objChild4);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_thirdNameEdit);
                    objChild3.put("DOB",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("HeightInFeet",str_thirdFtSpinner);
                    objChild3.put("HeightInInches",str_thirdInchesSpinner);
                    objChild3.put("Weight",str_thirdWeightEdit);
                    objChild3.put("BMI",ThreeChildBMI);
                    objChild3.put("Occupation",str_thirdOccupationSpinner);
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_thirdNameEdit);
                    objChild3.put("DOB",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("HeightInFeet",str_thirdFtSpinner);
                    objChild3.put("HeightInInches",str_thirdInchesSpinner);
                    objChild3.put("Weight",str_thirdWeightEdit);
                    objChild3.put("BMI",ThreeChildBMI);
                    objChild3.put("Occupation",str_thirdOccupationSpinner);
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                    JSONObject objChild4=new JSONObject();
                    objChild4.put("Name",str_fourNameEdit);
                    objChild4.put("DOB",strfourDob);
                    objChild4.put("Gender",str_fourGenderSpinner);
                    objChild4.put("HeightInFeet",str_fourFtSpinner);
                    objChild4.put("HeightInInches",str_fourInchesSpinner);
                    objChild4.put("Weight",strFourWeightEdit);
                    objChild4.put("BMI",FourChildBMI);
                    objChild4.put("Occupation",str_fourOccupationSpinner);
                    objChild4.put("Relation",strRelationFourChildEdit);
                    objChild4.put("SumInsured",str_SumInsured);
                    array.put(objChild4);
                }
            }
            object.put("asiQouteInsuredInfo",array);
            JSONObject Customer_Details_obj=new JSONObject();
            Customer_Details_obj.put("CustomerId","");
            Customer_Details_obj.put("CustomerName","");
            object.put("CustomerDetails",Customer_Details_obj);
            JSONObject authenticate_obj=new JSONObject();
            authenticate_obj.put("WebAggregatorCode","20000001");
            authenticate_obj.put("WAApplicationCode","30000011");
            authenticate_obj.put("WAUserID","USER01");
            authenticate_obj.put("WAUserPassword","pass@123");
            authenticate_obj.put("WAType","0");
            object.put("authenticate",authenticate_obj);
            object.put("ErrorMessage","");

        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Arogya_Member_info.this, object, UrlHealthConstants.SaveQuotationWA_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("ErrorMessage").equals("null")) {
                    if (Tag == RequestHealthConstants.Arogya_QUATATION) {
                        try {
                            QuoteId  = object.optString("QuoteId");
                            TotalValue = object.optString("TotalPremium");
                            NetPremium = object.optString("NetPremium");
                            GST = object.optString("GST");
                            strLoyaltyDiscount = object.optString("LoyaltyDiscount");
                            JSONArray installmentFreq = object.getJSONArray("installmentFreq");
                            for (int i = 0; i < installmentFreq.length(); i++) {
                                JSONObject obj = installmentFreq.getJSONObject(0);
                                TotalInstallPremium = obj.optString("TotalInstallPremium");

                            }
//                            existing_policy_amount.setText(strLoyaltyDiscount);
                            totalPremiumAmount.setText(TotalValue);
//                            txtNetPremiumValue.setText(NetPremium);
                            QuotationID.setText(QuoteId);
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                }else {
                    Toast.makeText(getApplication(), object.optString("ErrorMessage"), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestHealthConstants.Arogya_QUATATION);
        req.execute();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Arogya_Member_info.this, BuyPolicySuminsuredArogya.class);
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
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_OneEditName",str_OneEditName);
        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
        intent.putExtra("TotalValue",TotalValue);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("str_SumInsured",str_SumInsured);
        intent.putExtra("strFirstTString",strFirstTString);
        intent.putExtra("PosPolicyNo",PosPolicyNo);
        intent.putExtra("strChildOne",strChildOne);
        intent.putExtra("strChildTwo",strChildTwo);
        intent.putExtra("strChildThree",strChildThree);
        intent.putExtra("strChildFour",strChildFour);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("strOneChild",strOneChild);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
        intent.putExtra("TotalValue",TotalValue);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("GST",GST);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
        intent.putExtra("str_policyTenure",str_policyTenure);
        intent.putExtra("str_life_style_spinner",str_life_style_spinner);
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strParentEditText",strParentEditText);
        intent.putExtra("for","1");
        startActivity(intent);
        finish();

    }
}