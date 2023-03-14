package com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya.Arogya_Member_info;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Complete_health_member_info;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Member_Self;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Medicle_details;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Member_Self;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Medicle_details;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

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

import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculation;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationAdult;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationOne;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationThree;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationTwo;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationfour;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.sopercalculation.SuperBmiCalculation.SuperCalculation;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.sopercalculation.SuperBmiCalculation.SuperCalculationAdult;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.sopercalculation.SuperBmiCalculation.SuperCalculationFour;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.sopercalculation.SuperBmiCalculation.SuperCalculationOne;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.sopercalculation.SuperBmiCalculation.SuperCalculationThree;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.sopercalculation.SuperBmiCalculation.SuperCalculationTwo;

import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Super_Member_Self extends AppCompatActivity {
    Button btn_continue;
    String str_employeeCodeDiscountValue,str_LoyaltyDiscountEdit,str_loyalty_spinner,str_employeeDiscountEditSpinner,str_life_style_spinner,strSubLimitAmount,LifeStyleDiscountStr,str_Deductible,BI_Status,BI_Status1,BI_Status2,BI_Status3,BI_Status4,BI_Status5,strFourString,strFirstString,new_str_age,strselfProposerRelation,strSumInsuredTpeEDit,ESaleDiscount,LongTermDiscount,PD_Status,str_selfProposerGender,str_selfProposerOccupation,strBMIFourChildEdit,strBMIEChildThreeEdit,strBMIChildTwoEdit,strBMIChildEdit,strBMIAdultOneEdit,strBMIEdit,strPriceTotal,strNominee_dob,str_family_individual,str_selfProposerDob,str_edit_dob3String1,str_proposer_self_spinner,TotalValue,NetPremiumValue,GST,PosPolicyNo,str_policyType_spinner,str_IndividualTypeEdit,str_SumInsured,str_policyTenure,strFirstTString,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_gender="",str_occupation="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob,str_edit_dob3String,str_spouse_edit_dob_dob,str_OneEditName,str_edit_dob3StringSpouse,strOneChild,strChildOne,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,strtwoDob,strChildTwo,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,
            strthreeDob,strChildThree,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,strfourDob,strChildFour,str_fourGenderSpinner,str_fourOccupationSpinner,str_fourFtSpinner,str_fourInchesSpinner;
    EditText  Deductible_spinner,selfProposerRelation,selfProposerGender,selfProposerOccupation,spouse_occupation_spinner,spouse_ft_spinner,spouse_inches_spinner,oneGenderSpinner,BMIAdultOneEdit,BMIChildEdit,BMIChildTwoEdit,familyTypeEdit,sumInsuredEdit,deductibleEdit,policyTenureEdit,QuotationID,selfProposerDob,proposer_edt_name,IndividualTypeEdit,policyType_spinner,familyType_spinner,edt_name,edit_dob,weight_edit,edt_Spouse_name,spouse_edit_dob,spouse_weight_edit,totalPremiumAmount;
    private SimpleDateFormat dateFormatter;
    LinearLayout adultLiner,spouseLiner,oneChildLiner,twoChildLiner,threeChildLiner,fourChildLiner,proposer_liner,gender_liner,linerOccupation,ftLiner,LinerInches,spouseGender,spouseOccupation,spouseFt,spouseInches,spouseRelationLiner,ChildOneGender,ChildOneLinerRelation,LinerFtChildOne,LinerInchesChildOne,childTwoGenderLiner,LinerChildTwoFt,LinerChildTwoInches,ChildTwoRelationLiner,thirdLinerGender,LinerFtThird,thirdInchesLiner,RelationThirdLiner,LinerGenderFour,LinerFtFour,LinerInchesFour,LinerRelationFour;
    Spinner proposer_spinner,proposer_self_spinner,SelfProposerMarital,policyTenure_spinner,gender_spinner,occupation_spinner,ft_spinner,inches_spinner;
    String[] familyFloater,familyChildFloater,Salutation,policyTenure, gender,Marital;
    String[] occupation,yesNo,relation_with_insure;
    String[] ft;
    String[] inches;
    ImageView sumInsuredDropDown;
    final double change = 2.2046226218;
    double kg = 0.0;
    double BMI=0.0;
    double cm=0.0;
    String str_amountPersonalSumInsured,strcriticalEdit,strhospitalEdit,strOneChildCriticalIllnessTxt,stroneChildTxt;
    String str_new_dob,today,tomorrowDate,nextYear,strThirdDString ;
    Date date,CurrentDate,SelectDate;
    TextView show_Breakup;
    double  amountPersonalSumInsured,personalSumInsured;
    Format formatter;
    private MySharedPreference pref;
    CustomProgressDialog customprogress;
    double Individual_BMI=0.0,twoAdult_BMI=0.0,OneChildBMI,TwoChildBMI,ThreeChildBMI,FourChildBMI;
    EditText spouse_gender_spinner,edit_ft,edit_inches,edit_occupation,edit_gender,oneFtSpinner,oneInchesSpinner,twoGenderSpinner,twoFtSpinner,twoInchesSpinner,thirdGenderSpinner,thirdFtSpinner,thirdInchesSpinner,fourGenderSpinner,fourFtSpinner,fourInchesSpinner,BMIEdit,BMIEChildThreeEdit,BMIFourChildEdit,RelationEdit,RelationAdultOneEdit,RelationChildEdit,RelationChildTwoEdit,RelationChildThreeEdit,RelationFourChildEdit,policyTenure_edit,SumInsured_spinner,OneEditName,OneDob,oneOccupationSpinner,oneWeightEdit,twoChildEditName,twoOccupationSpinner,twoDob,twoWeightEdit,thirdNameEdit,thirdDob,thirdOccupationSpinner,thirdWeightEdit,fourNameEdit,fourDob,fourOccupationSpinner,FourWeightEdit;
    Spinner selfProposerSpinner;
    public Period period;
    int selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour,daysLeft,daysLeftChild2,daysLeftChild3,daysLeftChild4;
    String strGlobalDiscount,strDiseaseManagement,strGlobalAdultSpinner,strAdult1OneDiseaseSpinner,str_for,str_RelationEdit,str_twoChildEditName,str_thirdNameEdit,str_fourNameEdit,str_oneWeightEdit,str_thirdWeightEdit,strFourWeightEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super__member__self);
        getWindow().setStatusBarColor(ContextCompat.getColor(Super_Member_Self.this, R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(Super_Member_Self.this);
        customprogress = new CustomProgressDialog(Super_Member_Self.this);
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
        str_Deductible = getIntent().getStringExtra("str_Deductible");
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
        strNominee_dob = getIntent().getStringExtra("strNominee_dob");
        strPriceTotal = getIntent().getStringExtra("strPriceTotal");
        strBMIEdit = getIntent().getStringExtra("strBMIEdit");
        strBMIAdultOneEdit = getIntent().getStringExtra("strBMIAdultOneEdit");
        strBMIChildEdit = getIntent().getStringExtra("strBMIChildEdit");
        strBMIChildTwoEdit = getIntent().getStringExtra("strBMIChildTwoEdit");
        strBMIEChildThreeEdit = getIntent().getStringExtra("strBMIEChildThreeEdit");
        strBMIFourChildEdit = getIntent().getStringExtra("strBMIFourChildEdit");
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
        LongTermDiscount = getIntent().getStringExtra("LongTermDiscount");
        ESaleDiscount = getIntent().getStringExtra("ESaleDiscount");
        PD_Status = getIntent().getStringExtra("PD_Status");
        nextYear = getIntent().getStringExtra("nextYear");
        tomorrowDate = getIntent().getStringExtra("tomorrowDate");
        new_str_age = getIntent().getStringExtra("new_str_age");
        str_for = getIntent().getStringExtra("for");
        BI_Status = getIntent().getStringExtra("BI_Status");
        BI_Status1 = getIntent().getStringExtra("BI_Status1");
        BI_Status2 = getIntent().getStringExtra("BI_Status2");
        BI_Status3 = getIntent().getStringExtra("BI_Status3");
        BI_Status4 = getIntent().getStringExtra("BI_Status4");
        BI_Status5 = getIntent().getStringExtra("BI_Status5");
        str_employeeCodeDiscountValue = getIntent().getStringExtra("str_employeeCodeDiscountValue");
        str_LoyaltyDiscountEdit = getIntent().getStringExtra("str_LoyaltyDiscountEdit");
        str_loyalty_spinner = getIntent().getStringExtra("str_loyalty_spinner");
        str_employeeDiscountEditSpinner = getIntent().getStringExtra("str_employeeDiscountEditSpinner");
        str_life_style_spinner = getIntent().getStringExtra("str_life_style_spinner");
        strSumInsuredTpeEDit = getIntent().getStringExtra("strSumInsuredTpeEDit");
        strGlobalAdultSpinner = getIntent().getStringExtra("strGlobalAdultSpinner");
        strAdult1OneDiseaseSpinner = getIntent().getStringExtra("strAdult1OneDiseaseSpinner");
        if (str_for.equals("1")){
            selectYearAdult = getIntent().getIntExtra("selectYearAdult", 0);
            selectYearSecondAdult = getIntent().getIntExtra("selectYearSecondAdult", 0);
            selectYearChild = getIntent().getIntExtra("selectYearChild", 0);
            selectYearChildTwo = getIntent().getIntExtra("selectYearChildTwo", 0);
            selectYearChildThird = getIntent().getIntExtra("selectYearChildThird", 0);
            selectYearChildFour = getIntent().getIntExtra("selectYearChildFour", 0);
        }
        init();
        String[] strParts =  str_age.split("yrs");
        strFirstString = strParts[0];

        String[] strParts1 = str_age.split("-");
        String strFirstString1 = strParts1[0]; // 004
        String strSecondString1 = strParts1[1];

        String[] strParts2 =  strSecondString1.split("yrs");
        strFourString = strParts2[0];

//        Toast.makeText(Super_Member_Self.this, strFirstString, Toast.LENGTH_SHORT).show();
//        Toast.makeText(Super_Member_Self.this, strFourString, Toast.LENGTH_SHORT).show();


        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        today = formatter.format(date);
        String[] strTDate=  today.split("-");
        String strFirstDString = strTDate[0];
        String strSecondDString = strTDate[1];
        strThirdDString = strTDate[2];
        Log.e("strThirdDString", strThirdDString);
        Log.e("Today",today);
        int new_dob= Integer.parseInt(strThirdDString)- Integer.parseInt(strFirstString);
        Log.e("new_dob", String.valueOf(new_dob));
        str_new_dob=strFirstDString+"-"+ strSecondDString + "-"+String.valueOf(new_dob);
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
        Deductible_spinner=findViewById(R.id.Deductible_spinner);
        familyTypeEdit=findViewById(R.id.familyTypeEdit);
        sumInsuredEdit=findViewById(R.id.sumInsuredEdit);
        policyTenureEdit=findViewById(R.id.policyTenureEdit);
        proposer_spinner=findViewById(R.id.proposer_spinner);
        proposer_liner=findViewById(R.id.proposer_liner);
        btn_continue=findViewById(R.id.btn_continue);
        edt_name=findViewById(R.id.edt_name);
        edit_dob=findViewById(R.id.edit_dob);
        gender_liner=findViewById(R.id.gender_liner);
        linerOccupation=findViewById(R.id.linerOccupation);
        ftLiner=findViewById(R.id.ftLiner);
        LinerInches=findViewById(R.id.LinerInches);
        spouseGender=findViewById(R.id.spouseGender);
        spouseOccupation=findViewById(R.id.spouseOccupation);
        spouseFt=findViewById(R.id.spouseFt);
        spouseInches=findViewById(R.id.spouseInches);
        spouseRelationLiner=findViewById(R.id.spouseRelationLiner);
        ChildOneLinerRelation=findViewById(R.id.ChildOneLinerRelation);
        ChildOneGender=findViewById(R.id.ChildOneGender);
        LinerFtChildOne=findViewById(R.id.LinerFtChildOne);
        childTwoGenderLiner=findViewById(R.id.childTwoGenderLiner);
        LinerChildTwoFt=findViewById(R.id.LinerChildTwoFt);
        LinerChildTwoInches=findViewById(R.id.LinerChildTwoInches);
        ChildTwoRelationLiner=findViewById(R.id.ChildTwoRelationLiner);
        thirdLinerGender=findViewById(R.id.thirdLinerGender);
        LinerFtThird=findViewById(R.id.LinerFtThird);
        thirdInchesLiner=findViewById(R.id.thirdInchesLiner);
        RelationThirdLiner=findViewById(R.id.RelationThirdLiner);
        LinerInchesChildOne=findViewById(R.id.LinerInchesChildOne);
        LinerGenderFour=findViewById(R.id.LinerGenderFour);
        LinerFtFour=findViewById(R.id.LinerFtFour);
        LinerInchesFour=findViewById(R.id.LinerInchesFour);
        LinerRelationFour=findViewById(R.id.LinerRelationFour);
        IndividualTypeEdit=findViewById(R.id.IndividualTypeEdit);
        policyType_spinner=findViewById(R.id.policyType_spinner);
//        familyType_spinner=findViewById(R.id.familyType_spinner);
        SumInsured_spinner=findViewById(R.id.SumInsured_spinner);
        sumInsuredDropDown=findViewById(R.id.sumInsuredDropDown);
        selfProposerSpinner=findViewById(R.id.selfProposerSpinner);
        RelationEdit=findViewById(R.id.RelationEdit);
        gender_spinner=findViewById(R.id.gender_spinner);
        BMIAdultOneEdit=findViewById(R.id.BMIAdultOneEdit);
        BMIChildEdit=findViewById(R.id.BMIChildEdit);
        BMIChildTwoEdit=findViewById(R.id.BMIChildTwoEdit);
        RelationChildThreeEdit=findViewById(R.id.RelationChildThreeEdit);
        RelationFourChildEdit=findViewById(R.id.RelationFourChildEdit);
        RelationChildTwoEdit=findViewById(R.id.RelationChildTwoEdit);
        RelationChildEdit=findViewById(R.id.RelationChildEdit);
        RelationAdultOneEdit=findViewById(R.id.RelationAdultOneEdit);
        spouse_gender_spinner=findViewById(R.id.spouse_gender_spinner);

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
        selfProposerDob=findViewById(R.id.selfProposerDob);
        selfProposerGender=findViewById(R.id.selfProposerGender);
        selfProposerOccupation=findViewById(R.id.selfProposerOccupation);
        SelfProposerMarital=findViewById(R.id.SelfProposerMarital);
        selfProposerRelation=findViewById(R.id.selfProposerRelation);
        BMIEdit=findViewById(R.id.BMIEdit);
        BMIEChildThreeEdit=findViewById(R.id.BMIEChildThreeEdit);
        BMIFourChildEdit=findViewById(R.id.BMIFourChildEdit);


        OneEditName=findViewById(R.id.OneEditName);
        OneDob=findViewById(R.id.OneChildDob);
        oneGenderSpinner=findViewById(R.id.oneGenderSpinner);
        oneOccupationSpinner=findViewById(R.id.oneOccupationSpinner);
        oneFtSpinner=findViewById(R.id.oneFtSpinner);
        oneInchesSpinner=findViewById(R.id.oneInchesSpinner);
        oneWeightEdit=findViewById(R.id.oneWeightEdit);

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

        yesNo=getResources().getStringArray(R.array.yesNo);
        relation_with_insure=getResources().getStringArray(R.array.relation_with_insure);

        policyType_spinner.setText(str_policyType_spinner);
        policyType_spinner.setAlpha(0.5f);
        familyTypeEdit.setText(str_IndividualTypeEdit);
        familyTypeEdit.setAlpha(0.5f);
        sumInsuredEdit.setText(str_SumInsured);
        sumInsuredEdit.setAlpha(0.5f);
        policyTenureEdit.setText(strFirstTString+" Year");
        policyTenureEdit.setAlpha(0.5f);
        totalPremiumAmount.setText(TotalValue);
        totalPremiumAmount.setAlpha(0.5f);
        QuotationID.setText(PosPolicyNo);
        Deductible_spinner.setText(str_Deductible);
        QuotationID.setAlpha(0.5f);
        Deductible_spinner.setAlpha(0.5f);
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
        }else {
            if(str_IndividualTypeEdit.equals("2 Adult")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.VISIBLE);
                oneChildLiner.setVisibility(View.GONE);
                twoChildLiner.setVisibility(View.GONE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
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
            }
            else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.VISIBLE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.VISIBLE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
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
        }
        edt_name.setText(str_edt_name);

        final ArrayAdapter<String> adapterproposer_spinner=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,yesNo);
        proposer_spinner.setAdapter(adapterproposer_spinner);
//        final ArrayAdapter<String> relation_with_insure_adapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,relation_with_insure);
//        proposer_self_spinner.setAdapter(relation_with_insure_adapter);

//        familyChildFloater=getResources().getStringArray(R.array.floater_no_child);
//        final ArrayAdapter<String> policyFamilyAdapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,familyChildFloater);
//        familyType_spinner.setAdapter(policyFamilyAdapter);


//        CompleteSumInsured=getResources().getStringArray(R.array.CompleteSumInsured);
//        final ArrayAdapter<String> sumInsuredAdapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,CompleteSumInsured);
//        SumInsured_spinner.setAdapter(sumInsuredAdapter);

//        policyTenure=getResources().getStringArray(R.array.policyTenure);
//        final ArrayAdapter<String> policyTenureAdapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,policyTenure);
//        policyTenure_spinner.setAdapter(policyTenureAdapter);

        Salutation=getResources().getStringArray(R.array.Salutation);
        final ArrayAdapter<String> adapterSalutation=new ArrayAdapter<String>(this, R.layout.spinner_item_text,Salutation);
        selfProposerSpinner.setAdapter(adapterSalutation);

        Marital=getResources().getStringArray(R.array.Marital);
        final ArrayAdapter<String> adapterMarital=new ArrayAdapter<String>(this, R.layout.spinner_item_text,Marital);
        SelfProposerMarital.setAdapter(adapterMarital);

        str_oneOccupationSpinner="Student";
        str_twoOccupationSpinner="Student";
        str_thirdOccupationSpinner="Student";
        str_fourOccupationSpinner="Student";
        oneOccupationSpinner.setText(str_oneOccupationSpinner);
        twoOccupationSpinner.setText(str_twoOccupationSpinner);
        thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
        fourOccupationSpinner.setText(str_fourOccupationSpinner);

//        oneOccupationSpinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
//                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("Student");
//                singlePicker.setPicker(items1);
//                singlePicker.setCyclic(false);
//                singlePicker.setSelectOptions(0);
//                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                    @Override
//                    public void onOptionsSelect(int options1, int option2, int options3) {
//                        str_oneOccupationSpinner=items1.get(options1);
//                        oneOccupationSpinner.setText(str_oneOccupationSpinner);
//
//                    }
//                });
//                singlePicker.show(); }
//        });
//
//        twoOccupationSpinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
//                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("Student");
//                singlePicker.setPicker(items1);
//                singlePicker.setCyclic(false);
//                singlePicker.setSelectOptions(0);
//                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                    @Override
//                    public void onOptionsSelect(int options1, int option2, int options3) {
//                        str_twoOccupationSpinner=items1.get(options1);
//                        twoOccupationSpinner.setText(str_twoOccupationSpinner);
//
//                    }
//                });
//                singlePicker.show(); }
//        });
//
//        thirdOccupationSpinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
//                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("Student");
//                singlePicker.setPicker(items1);
//                singlePicker.setCyclic(false);
//                singlePicker.setSelectOptions(0);
//                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                    @Override
//                    public void onOptionsSelect(int options1, int option2, int options3) {
//                        str_thirdOccupationSpinner=items1.get(options1);
//                        thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
//
//                    }
//                });
//                singlePicker.show(); }
//        });
//        fourOccupationSpinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
//                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("Student");
//                singlePicker.setPicker(items1);
//                singlePicker.setCyclic(false);
//                singlePicker.setSelectOptions(0);
//                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                    @Override
//                    public void onOptionsSelect(int options1, int option2, int options3) {
//                        str_fourOccupationSpinner=items1.get(options1);
//                        fourOccupationSpinner.setText(str_fourOccupationSpinner);
//
//                    }
//                });
//                singlePicker.show(); }
//        });
//

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
                BMIEdit.setText(strBMIEdit);
                str_for="1";
            }else if (str_policyType_spinner.equals("Family Floater")){
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
                        BMIEdit.setText(strBMIEdit);
                        BMIAdultOneEdit.setText(strBMIAdultOneEdit);
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
                        BMIEdit.setText(strBMIEdit);
                        BMIChildEdit.setText(strBMIChildEdit);
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
                        BMIEdit.setText(strBMIEdit);
                        BMIChildEdit.setText(strBMIChildEdit);
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
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
                        BMIEdit.setText(strBMIEdit);
                        BMIChildEdit.setText(strBMIChildEdit);
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                        oneFtSpinner.setText(str_oneFtSpinner);
                        oneInchesSpinner.setText(str_oneInchesSpinner);
                        twoGenderSpinner.setText(str_twoGenderSpinner);
                        twoFtSpinner.setText(str_twoFtSpinner);
                        twoInchesSpinner.setText(str_twoInchesSpinner);
                        thirdGenderSpinner.setText(str_thirdGenderSpinner);
                        thirdFtSpinner.setText(str_thirdFtSpinner);
                        thirdInchesSpinner.setText(str_thirdInchesSpinner);
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
                        BMIEdit.setText(strBMIEdit);
                        BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                        BMIChildEdit.setText(strBMIChildEdit);
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
                        BMIEdit.setText(strBMIEdit);
                        BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                        BMIChildEdit.setText(strBMIChildEdit);
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
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
                        BMIEdit.setText(strBMIEdit);
                        BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                        BMIChildEdit.setText(strBMIChildEdit);
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
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
                        BMIEdit.setText(strBMIEdit);
                        edt_Spouse_name.setText(str_edt_Spouse_name);
                        spouse_gender_spinner.setText(str_spouse_gender);
                        spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                        spouse_ft_spinner.setText(str_spouse_ft_spinner);
                        spouse_inches_spinner.setText(str_spouse_inches_spinner);
                        spouse_edit_dob.setText(str_spouse_edit_dob_dob);
                        spouse_weight_edit.setText(str_spouse_weight_edit);
                        BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                        OneEditName.setText(str_OneEditName);
                        OneDob.setText(strOneChild);
                        oneWeightEdit.setText(str_oneWeightEdit);
                        oneGenderSpinner.setText(str_oneGenderSpinner);
                        oneFtSpinner.setText(str_oneFtSpinner);
                        oneInchesSpinner.setText(str_oneInchesSpinner);
                        BMIChildEdit.setText(strBMIChildEdit);
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
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                        BMIFourChildEdit.setText(strBMIFourChildEdit);
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
            }
        }
        else{
            edit_dob.setText(str_edit_dob);
            edit_gender.setText(str_gender);
            edit_occupation.setText(str_occupation);
            edit_ft.setText(str_ft);
            edit_inches.setText(str_inches);
            weight_edit.setText(str_weight_edit);
            edt_Spouse_name.setText(str_edt_Spouse_name);
            spouse_edit_dob.setText(str_spouse_edit_dob_dob);
            spouse_weight_edit.setText(str_spouse_weight_edit);
            BMIEdit.setText(strBMIEdit);
        }

        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(Super_Member_Self.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.super_show_breakup);
                EditText globalDiscount,DiseaseManagement,basicPremium,criticalEdit,premiumEdit,hospitalEdit,subLimitAmount,gstEdit,totalAmount,tiedHospital;
                Button buttonClose;

                buttonClose = alert_dialog.findViewById(R.id.buttonClose);
                basicPremium = alert_dialog.findViewById(R.id.basicPremium);
                sumInsuredEdit = alert_dialog.findViewById(R.id.sumInsuredEdit);
                deductibleEdit = alert_dialog.findViewById(R.id.deductibleEdit);
                gstEdit = alert_dialog.findViewById(R.id.gstEdit);
                totalAmount = alert_dialog.findViewById(R.id.totalAmount);
                globalDiscount = alert_dialog.findViewById(R.id.globalDiscount);
                DiseaseManagement = alert_dialog.findViewById(R.id.DiseaseManagement);

                basicPremium.setText(NetPremiumValue);
                sumInsuredEdit.setText(str_SumInsured);
                deductibleEdit.setText(str_Deductible);
                gstEdit.setText(GST);
                totalAmount.setText(TotalValue);


               if (str_for.equals("1")){
                  if(strGlobalAdultSpinner.equals("No")){
                    strGlobalDiscount="No";
                    globalDiscount.setText(strGlobalDiscount);
                }else{
                    strGlobalDiscount="Yes";
                    globalDiscount.setText(strGlobalDiscount);
                }
                if (strAdult1OneDiseaseSpinner.equals("No")){
                    strDiseaseManagement="No";
                    DiseaseManagement.setText(strDiseaseManagement);
                }else{
                    strDiseaseManagement="Yes";
                    DiseaseManagement.setText(strDiseaseManagement);
                }
                }

               buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert_dialog.dismiss();
                    }
                });
                alert_dialog.show();
            }
        });

//        SumInsured_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                str_SumInsured= String.valueOf(CompleteSumInsured[i]);
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });

        strRelationAdultOneEdit="Spouse";
        strselfProposerRelation="Spouse";
        RelationAdultOneEdit.setText(strRelationAdultOneEdit);
        selfProposerRelation.setText(strselfProposerRelation);
        strRelationChildEdit="Daughter";
        strRelationChildTwoEdit="Daughter";
        strRelationChildThreeEdit="Daughter";
        strRelationFourChildEdit="Daughter";
        RelationChildEdit.setText(strRelationChildEdit);
        RelationChildTwoEdit.setText(strRelationChildTwoEdit);
        RelationChildThreeEdit.setText(strRelationChildThreeEdit);
        RelationFourChildEdit.setText(strRelationFourChildEdit);


        selfProposerRelation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Spouse");
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
                        strselfProposerRelation=items1.get(options1);
                        selfProposerRelation.setText(strselfProposerRelation);
                    }
                });
                singlePicker.show(); }
        });


        spouseRelationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Spouse");
                items1.add("Daughter in law");
                items1.add("Son in law");
                items1.add("Grand Father");
                items1.add("Grand Mother");
                items1.add("Mother");
                items1.add("Father");
                items1.add("Father in law");
                items1.add("Mother in law");
                items1.add("Sister in law");
                items1.add("Brother in law");
                items1.add("Brother");
                items1.add("Sister");
                items1.add("Niece");
                items1.add("Nephew");
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                items1.add("Grand Son");
                items1.add("Grand Daughter");
                items1.add("Niece");
                items1.add("Nephew");
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                items1.add("Grand Son");
                items1.add("Grand Daughter");
                items1.add("Niece");
                items1.add("Nephew");
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                items1.add("Grand Son");
                items1.add("Grand Daughter");
                items1.add("Niece");
                items1.add("Nephew");
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                items1.add("Grand Son");
                items1.add("Grand Daughter");
                items1.add("Niece");
                items1.add("Nephew");
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

        if (str_for.equals("0")){
            str_selfProposerGender="Select Gender";
            str_gender="Select Gender";
            str_spouse_gender="Select Gender";
            str_oneGenderSpinner="Select Gender";
            str_twoGenderSpinner="Select Gender";
            str_thirdGenderSpinner="Select Gender";
            str_fourGenderSpinner="Select Gender";
            str_selfProposerOccupation="Occupation";
            str_occupation="Occupation";
            str_spouse_occupation_spinner="Occupation";
            str_ft="Ft";
            str_spouse_ft_spinner="Ft";
            str_oneFtSpinner="Ft";
            str_twoFtSpinner="Ft";
            str_thirdFtSpinner="Ft";
            str_fourFtSpinner="Ft";
            str_inches="Inches";
            str_spouse_inches_spinner="Inches";
            str_oneInchesSpinner="Inches";
            str_twoInchesSpinner="Inches";
            str_thirdInchesSpinner="Inches";
            str_fourInchesSpinner="Inches";
            selfProposerGender.setText(str_selfProposerGender);
            selfProposerOccupation.setText(str_selfProposerOccupation);
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
        }

        //selfProposer
        selfProposerGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                        str_selfProposerGender=items1.get(options1);
                        selfProposerGender.setText(str_selfProposerGender);
                    }
                });
                singlePicker.show(); }
        });
        selfProposerOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Occupation");
                items1.add("Doctors");
                items1.add("Lawyer");
                items1.add("Accounts");
                items1.add("Architects");
                items1.add("Consulting");
                items1.add("Teachers");
                items1.add("Bankers");
                items1.add("Housewife");
                items1.add("Student");
                items1.add("Self");
                items1.add("Salaried");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_selfProposerOccupation=items1.get(options1);
                        selfProposerOccupation.setText(str_selfProposerOccupation);
                    }
                });
                singlePicker.show(); }
        });

        gender_liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                                if (selectYearAdult < 18 || (selectYearAdult > 65)) {
                                    Toast.makeText(Super_Member_Self.this, "Age must be between 18 to 65 years ", Toast.LENGTH_SHORT).show();
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                                if (selectYearAdult < 18 || (selectYearAdult > 65)) {
                                    Toast.makeText(Super_Member_Self.this, "Age must be between 18 to 65 years ", Toast.LENGTH_SHORT).show();
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                        str_weight_edit=weight_edit.getText().toString();
                        if(!str_ft.equals("Ft") && !str_inches.equals("Inches") && !str_weight_edit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_ft, str_inches);
                            kg = Double.parseDouble(str_weight_edit);
                            BMI = calculateBMI(kg, cm);
                            strBMIEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIEdit) >= 17.5 && Double.parseDouble(strBMIEdit) <= 30.0) {
                                BMIEdit.setText(strBMIEdit);
                            }else{
                                BMIEdit.setText(strBMIEdit);
                                Toast.makeText(Super_Member_Self.this, "Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                        str_weight_edit=weight_edit.getText().toString();
                        if(!str_ft.equals("Ft") && !str_inches.equals("Inches") && !str_weight_edit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_ft, str_inches);
                            kg = Double.parseDouble(str_weight_edit);
                            BMI = calculateBMI(kg, cm);
                            strBMIEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIEdit) >= 17.5 && Double.parseDouble(strBMIEdit) <= 30.0) {
                                BMIEdit.setText(strBMIEdit);
                            }else{
                                BMIEdit.setText(strBMIEdit);
                                Toast.makeText(Super_Member_Self.this, "Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        weight_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()==2){
                    str_weight_edit=weight_edit.getText().toString();
                    if(!str_ft.equals("Ft") && !str_inches.equals("Inches") && !str_weight_edit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_ft, str_inches);
                        kg = Double.parseDouble(str_weight_edit);
                        BMI = calculateBMI(kg, cm);
                        strBMIEdit=String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIEdit) >= 17.5 && Double.parseDouble(strBMIEdit) <= 30.0) {
                            BMIEdit.setText(strBMIEdit);
                        }else{
                            BMIEdit.setText(strBMIEdit);
                            Toast.makeText(Super_Member_Self.this, "Weight is not normal", Toast.LENGTH_SHORT).show();
                        }
                    }else if(str_ft.equals("Ft") && str_inches.equals("Inches")){
                        Toast.makeText(Super_Member_Self.this, "Please Select Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIEdit.setText(strBMIEdit);
                    }else if (str_weight_edit.equals("")){
                        Toast.makeText(Super_Member_Self.this, "Please Enter 1st Adult Weight", Toast.LENGTH_SHORT).show();
                        BMIEdit.setText(strBMIEdit);
                    }else {
                        strBMIEdit=String.format("%.2f", BMI);
                        BMIEdit.setText(strBMIEdit);
                    }
                }
            }
        });


        //2nd adult
        spouseGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                                if (selectYearSecondAdult < 18 || (selectYearSecondAdult > 65)) {
                                    Toast.makeText(Super_Member_Self.this, "2nd Adult Age must be between 18 to 65 years ", Toast.LENGTH_SHORT).show();
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                                if (selectYearSecondAdult < 18 || (selectYearSecondAdult > 65)) {
                                    Toast.makeText(Super_Member_Self.this, "2nd Adult Age must be between 18 to 65 years ", Toast.LENGTH_SHORT).show();
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                        str_spouse_weight_edit=spouse_weight_edit.getText().toString();
                        if(!str_spouse_ft_spinner.equals("Ft") && !str_spouse_inches_spinner.equals("Inches") && !str_spouse_weight_edit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_spouse_ft_spinner, str_spouse_inches_spinner);
                            kg = Double.parseDouble(str_spouse_weight_edit);
                            BMI = calculateBMI(kg, cm);
                            strBMIAdultOneEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIAdultOneEdit) >= 17.5 && Double.parseDouble(strBMIAdultOneEdit) <= 30.0) {
                                BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                            }else{
                                BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                                Toast.makeText(Super_Member_Self.this, "2nd Adult Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        spouseInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                        str_spouse_weight_edit=spouse_weight_edit.getText().toString();
                        if(!str_spouse_ft_spinner.equals("Ft") && !str_spouse_inches_spinner.equals("Inches") && !str_spouse_weight_edit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_spouse_ft_spinner, str_spouse_inches_spinner);
                            kg = Double.parseDouble(str_spouse_weight_edit);
                            BMI = calculateBMI(kg, cm);
                            strBMIAdultOneEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIAdultOneEdit) >= 17.5 && Double.parseDouble(strBMIAdultOneEdit) <= 30.0) {
                                BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                            }else{
                                BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                                Toast.makeText(Super_Member_Self.this, "2nd Adult Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        spouse_weight_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()==2){
                    str_spouse_weight_edit=spouse_weight_edit.getText().toString();
                    if(!str_spouse_ft_spinner.equals("Ft") && !str_spouse_inches_spinner.equals("Inches") && !str_spouse_weight_edit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_spouse_ft_spinner, str_spouse_inches_spinner);
                        kg = Double.parseDouble(str_spouse_weight_edit);
                        BMI = calculateBMI(kg, cm);
                        strBMIAdultOneEdit=String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIAdultOneEdit) >= 17.5 && Double.parseDouble(strBMIAdultOneEdit) <= 30.0) {
                            BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                        }else{
                            BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                            Toast.makeText(Super_Member_Self.this, "2nd Adult Weight is not normal", Toast.LENGTH_SHORT).show();
                        }
                    }else if(str_spouse_ft_spinner.equals("Ft") && str_spouse_inches_spinner.equals("Inches")){
                        Toast.makeText(Super_Member_Self.this, "Please Select 2nd Adult Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                    }else if (str_spouse_weight_edit.equals("")){
                        Toast.makeText(Super_Member_Self.this, "Please Enter 2nd Adult Weight", Toast.LENGTH_SHORT).show();
                        BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                    }else {
                        strBMIAdultOneEdit=String.format("%.2f", BMI);
                        BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                    }
                }
            }
        });

        //1st child
        ChildOneGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                                if (selectYearChild < 1 || (selectYearChild > 30)) {
                                    Toast.makeText(Super_Member_Self.this, "1st Child Age must be between 1 to 30 years", Toast.LENGTH_SHORT).show();
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                        str_oneWeightEdit=oneWeightEdit.getText().toString();
                        if(!str_oneFtSpinner.equals("Ft") && !str_oneInchesSpinner.equals("Inches") && !str_oneWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_oneFtSpinner, str_oneInchesSpinner);
                            kg = Double.parseDouble(str_oneWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIChildEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIChildEdit) >= 17.5 && Double.parseDouble(strBMIChildEdit) <= 30.0) {
                                BMIChildEdit.setText(strBMIChildEdit);
                            }else{
                                BMIChildEdit.setText(strBMIChildEdit);
                                Toast.makeText(Super_Member_Self.this, "1st child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerInchesChildOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                        str_oneWeightEdit=oneWeightEdit.getText().toString();
                        if(!str_oneFtSpinner.equals("Ft") && !str_oneInchesSpinner.equals("Inches") && !str_oneWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_oneFtSpinner, str_oneInchesSpinner);
                            kg = Double.parseDouble(str_oneWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIChildEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIChildEdit) >= 17.5 && Double.parseDouble(strBMIChildEdit) <= 30.0) {
                                BMIChildEdit.setText(strBMIChildEdit);
                            }else{
                                BMIChildEdit.setText(strBMIChildEdit);
                                Toast.makeText(Super_Member_Self.this, "1st child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
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
                if (s.length()==2){
                    str_oneWeightEdit=oneWeightEdit.getText().toString();
                    if(!str_oneFtSpinner.equals("Ft") && !str_oneInchesSpinner.equals("Inches") && !str_oneWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_oneFtSpinner, str_oneInchesSpinner);
                        kg = Double.parseDouble(str_oneWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIChildEdit=String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIChildEdit) >= 17.5 && Double.parseDouble(strBMIChildEdit) <= 30.0) {
                            BMIChildEdit.setText(strBMIChildEdit);
                        }else{
                            BMIChildEdit.setText(strBMIChildEdit);
                            Toast.makeText(Super_Member_Self.this, "1st child Weight is not normal", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_oneFtSpinner.equals("Ft") && str_oneInchesSpinner.equals("Inches")){
                        Toast.makeText(Super_Member_Self.this, "Please Select 1st Child Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIChildEdit.setText(strBMIChildEdit);
                    }else if (str_oneWeightEdit.equals("")){
                        Toast.makeText(Super_Member_Self.this, "Please Enter 1st Child Weight", Toast.LENGTH_SHORT).show();
                        BMIChildEdit.setText(strBMIChildEdit);
                    }else {
                        strBMIChildEdit=String.format("%.2f", BMI);
                        BMIChildEdit.setText(strBMIChildEdit);
                    }
                }
            }
        });

        //2nd child
        childTwoGenderLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                            if (selectYearChildTwo < 1 || (selectYearChildTwo > 30)) {
                                Toast.makeText(Super_Member_Self.this, "2nd Child Age must be between 1 to 30 years", Toast.LENGTH_SHORT).show();
                                twoDob.setText("");
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerChildTwoFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                        strtwoWeightEdit=twoWeightEdit.getText().toString();
                        if(!str_twoFtSpinner.equals("Ft") && !str_twoInchesSpinner.equals("Inches") && !strtwoWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_twoFtSpinner, str_twoInchesSpinner);
                            kg = Double.parseDouble(strtwoWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIChildTwoEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIChildTwoEdit) >= 17.5 && Double.parseDouble(strBMIChildTwoEdit) <= 30.0) {
                                BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                            }else{
                                BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                                Toast.makeText(Super_Member_Self.this, "2nd child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerChildTwoInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                        strtwoWeightEdit=twoWeightEdit.getText().toString();
                        if(!str_twoFtSpinner.equals("Ft") && !str_twoInchesSpinner.equals("Inches") && !strtwoWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_twoFtSpinner, str_twoInchesSpinner);
                            kg = Double.parseDouble(strtwoWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIChildTwoEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIChildTwoEdit) >= 17.5 && Double.parseDouble(strBMIChildTwoEdit) <= 30.0) {
                                BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                            }else{
                                BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                                Toast.makeText(Super_Member_Self.this, "2nd child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
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
                if (s.length()==2){
                    strtwoWeightEdit=twoWeightEdit.getText().toString();
                    if(!str_twoFtSpinner.equals("Ft") && !str_twoInchesSpinner.equals("Inches") && !strtwoWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_twoFtSpinner, str_twoInchesSpinner);
                        kg = Double.parseDouble(strtwoWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIChildTwoEdit=String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIChildTwoEdit) >= 17.5 && Double.parseDouble(strBMIChildTwoEdit) <= 30.0) {
                            BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                        }else{
                            BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                            Toast.makeText(Super_Member_Self.this, "2nd child Weight is not normal", Toast.LENGTH_SHORT).show();
                        }
                    }else if(str_twoFtSpinner.equals("Ft") && str_twoInchesSpinner.equals("Inches")){
                        Toast.makeText(Super_Member_Self.this, "Please Select 2nd Child Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                    }else if (strtwoWeightEdit.equals("")){
                        Toast.makeText(Super_Member_Self.this, "Please Enter 2nd Child Weight", Toast.LENGTH_SHORT).show();
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                    }else {
                        strBMIChildTwoEdit=String.format("%.2f", BMI);
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                    }
                }
            }
        });

        //3rd child
        thirdLinerGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                                if (selectYearChildThird < 1 || (selectYearChildThird > 30)) {
                                    Toast.makeText(Super_Member_Self.this, "3rd Child Age must be between 1 to 30 years", Toast.LENGTH_SHORT).show();
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
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                        str_thirdWeightEdit=thirdWeightEdit.getText().toString();
                        if(!str_thirdFtSpinner.equals("Ft") && !str_thirdInchesSpinner.equals("Inches") && !str_thirdWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_thirdFtSpinner, str_thirdInchesSpinner);
                            kg = Double.parseDouble(str_thirdWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIEChildThreeEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIEChildThreeEdit) >= 17.5 && Double.parseDouble(strBMIEChildThreeEdit) <= 30.0) {
                                BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                            }else{
                                BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                                Toast.makeText(Super_Member_Self.this, "3rd child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                });
                singlePicker.show(); }
        });
        thirdInchesLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                        str_thirdWeightEdit=thirdWeightEdit.getText().toString();
                        if(!str_thirdFtSpinner.equals("Ft") && !str_thirdInchesSpinner.equals("Inches") && !str_thirdWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_thirdFtSpinner, str_thirdInchesSpinner);
                            kg = Double.parseDouble(str_thirdWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIEChildThreeEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIEChildThreeEdit) >= 17.5 && Double.parseDouble(strBMIEChildThreeEdit) <= 30.0) {
                                BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                            }else{
                                BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                                Toast.makeText(Super_Member_Self.this, "3rd child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
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
                if (s.length()==2){
                    str_thirdWeightEdit=thirdWeightEdit.getText().toString();
                    if(!str_thirdFtSpinner.equals("Ft") && !str_thirdInchesSpinner.equals("Inches") && !str_thirdWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_thirdFtSpinner, str_thirdInchesSpinner);
                        kg = Double.parseDouble(str_thirdWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIEChildThreeEdit=String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIEChildThreeEdit) >= 17.5 && Double.parseDouble(strBMIEChildThreeEdit) <= 30.0) {
                            BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                        }else{
                            BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                            Toast.makeText(Super_Member_Self.this, "3rd child Weight is not normal", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_thirdFtSpinner.equals("Ft") && str_thirdInchesSpinner.equals("Inches")){
                        Toast.makeText(Super_Member_Self.this, "Please Select 3rd Child Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                    }else if (str_thirdWeightEdit.equals("")){
                        Toast.makeText(Super_Member_Self.this, "Please Enter 3rd Child Weight", Toast.LENGTH_SHORT).show();
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                    }else {
                        strBMIEChildThreeEdit=String.format("%.2f", BMI);
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                    }
                }
            }
        });

        //4th child
        LinerGenderFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                            if (strChildFour != null){
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
                                if (selectYearChildFour < 1 || (selectYearChildFour > 30)) {
                                    Toast.makeText(Super_Member_Self.this, "4th Child Age must be between 1 to 30 years", Toast.LENGTH_SHORT).show();
                                    fourDob.setText("");
                                }
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerFtFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                        strFourWeightEdit=FourWeightEdit.getText().toString();
                        if(!str_fourFtSpinner.equals("Ft") && !str_fourInchesSpinner.equals("Inches") && !strFourWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_fourFtSpinner, str_fourInchesSpinner);
                            kg = Double.parseDouble(strFourWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIFourChildEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIFourChildEdit) >= 17.5 && Double.parseDouble(strBMIFourChildEdit) <= 30.0) {
                                BMIFourChildEdit.setText(strBMIFourChildEdit);
                            }else{
                                BMIFourChildEdit.setText(strBMIFourChildEdit);
                                Toast.makeText(Super_Member_Self.this, "4th child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerInchesFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Member_Self.this);
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
                        strFourWeightEdit=FourWeightEdit.getText().toString();
                        if(!str_fourFtSpinner.equals("Ft") && !str_fourInchesSpinner.equals("Inches") && !strFourWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_fourFtSpinner, str_fourInchesSpinner);
                            kg = Double.parseDouble(strFourWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIFourChildEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIFourChildEdit) >= 17.5 && Double.parseDouble(strBMIFourChildEdit) <= 30.0) {
                                BMIFourChildEdit.setText(strBMIFourChildEdit);
                            }else{
                                BMIFourChildEdit.setText(strBMIFourChildEdit);
                                Toast.makeText(Super_Member_Self.this, "4th child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
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
                if (s.length()==2){
                    strFourWeightEdit=FourWeightEdit.getText().toString();
                    if(!str_fourFtSpinner.equals("Ft") && !str_fourInchesSpinner.equals("Inches") && !strFourWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_fourFtSpinner, str_fourInchesSpinner);
                        kg = Double.parseDouble(strFourWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIFourChildEdit=String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIFourChildEdit) >= 17.5 && Double.parseDouble(strBMIFourChildEdit) <= 30.0) {
                            BMIFourChildEdit.setText(strBMIFourChildEdit);
                        }else{
                            BMIFourChildEdit.setText(strBMIFourChildEdit);
                            Toast.makeText(Super_Member_Self.this, "4th child Weight is not normal", Toast.LENGTH_SHORT).show();
                        }                    }else if(str_fourFtSpinner.equals("Ft") && str_fourInchesSpinner.equals("Inches")){
                        Toast.makeText(Super_Member_Self.this, "Please Select 4th Child Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIFourChildEdit.setText(strBMIFourChildEdit);
                    }else if (strFourWeightEdit.equals("")){
                        Toast.makeText(Super_Member_Self.this, "Please Enter 4th Child Weight", Toast.LENGTH_SHORT).show();
                        BMIFourChildEdit.setText(strBMIFourChildEdit);
                    }else {
                        strBMIFourChildEdit=String.format("%.2f", BMI);
                        BMIFourChildEdit.setText(strBMIFourChildEdit);
                    }
                }
            }
        });

        proposer_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_family_individual = String.valueOf(yesNo[i]);
                if (str_family_individual.equals("Yes")){
                    proposer_liner.setVisibility(View.GONE);
                }else {
                    proposer_liner.setVisibility(View.VISIBLE);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
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
                if (str_policyType_spinner.equals("Individual")){
                    if (str_edt_name.equals("")){
                        Toast.makeText(Super_Member_Self.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                    }else if(str_edit_dob.equals("")){
                        Toast.makeText(Super_Member_Self.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                    } else if (str_gender.equals("Select Gender")){
                        Toast.makeText(Super_Member_Self.this, "Select Gender", Toast.LENGTH_SHORT).show();
                    }else if (str_occupation.equals("Occupation")){
                        Toast.makeText(Super_Member_Self.this, "Select Occupation", Toast.LENGTH_SHORT).show();
                    } else if(str_ft.equals("Ft") && str_inches.equals("Inches")){
                        Toast.makeText(Super_Member_Self.this, "Enter Ft & Inches", Toast.LENGTH_SHORT).show();
                    }else if (str_weight_edit.equals("")){
                        Toast.makeText(Super_Member_Self.this, "Enter Weight in Kg", Toast.LENGTH_SHORT).show();
                    } else {
                        if (str_edit_dob3String != null){
                            try {
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
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
                            if (selectYearAdult < 18 || (selectYearAdult > 65)) {
                                Toast.makeText(Super_Member_Self.this, "Age must be between 18 to 65 years ", Toast.LENGTH_SHORT).show();
                            }else if(!str_ft.equals("Ft") && !str_inches.equals("Inches")) {
                                cm=convertFeetandInchesToCentimeter(str_ft, str_inches);
                                kg= Double.parseDouble(str_weight_edit);
                                BMI=calculateBMI(kg,cm);
                                if (BMI!=0.0){
                                     if (BMI < 16.0) {
                                        Toast.makeText(Super_Member_Self.this, "BMI is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                    else if (BMI >= 16.0 && BMI <= 33.0) {
                                        Intent intent=new Intent(Super_Member_Self.this, Super_Medicle_details.class);
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
                                        intent.putExtra("strPriceTotal",strPriceTotal);
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
                                        intent.putExtra("strOneChild",strOneChild);
                                        intent.putExtra("strtwoDob",strtwoDob);
                                        intent.putExtra("strthreeDob",strthreeDob);
                                        intent.putExtra("strfourDob",strfourDob);
                                        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
                                        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
                                        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
                                        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
                                        intent.putExtra("str_RelationEdit",str_RelationEdit);
                                        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
                                        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
                                        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
                                        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
                                        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
                                        intent.putExtra("strNominee_dob",strNominee_dob);
                                        intent.putExtra("strBMIEdit",strBMIEdit);
                                        intent.putExtra("strBMIAdultOneEdit",strBMIAdultOneEdit);
                                        intent.putExtra("strBMIChildEdit",strBMIChildEdit);
                                        intent.putExtra("strBMIChildTwoEdit",strBMIChildTwoEdit);
                                        intent.putExtra("strBMIEChildThreeEdit",strBMIEChildThreeEdit);
                                        intent.putExtra("strBMIFourChildEdit",strBMIFourChildEdit);
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
                                        intent.putExtra("PD_Status",PD_Status);
                                        intent.putExtra("ESaleDiscount",ESaleDiscount);
                                        intent.putExtra("LongTermDiscount",LongTermDiscount);
                                        intent.putExtra("nextYear",nextYear);
                                        intent.putExtra("tomorrowDate",tomorrowDate);
                                        intent.putExtra("new_str_age",new_str_age);
                                        intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                        intent.putExtra("BI_Status",BI_Status);
                                        intent.putExtra("BI_Status1",BI_Status1);
                                        intent.putExtra("BI_Status2",BI_Status2);
                                        intent.putExtra("BI_Status3",BI_Status3);
                                        intent.putExtra("BI_Status4",BI_Status4);
                                        intent.putExtra("BI_Status5",BI_Status5);
                                        intent.putExtra("str_Deductible",str_Deductible);
                                        intent.putExtra("str_employeeCodeDiscountValue",str_employeeCodeDiscountValue);
                                        intent.putExtra("str_LoyaltyDiscountEdit",str_LoyaltyDiscountEdit);
                                        intent.putExtra("str_loyalty_spinner",str_loyalty_spinner);
                                        intent.putExtra("str_employeeDiscountEditSpinner",str_employeeDiscountEditSpinner);
                                        intent.putExtra("str_life_style_spinner",str_life_style_spinner);
                                        intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                        intent.putExtra("strGlobalAdultSpinner",strGlobalAdultSpinner);
                                        intent.putExtra("strAdult1OneDiseaseSpinner",strAdult1OneDiseaseSpinner);
                                        intent.putExtra("selectYearAdult",selectYearAdult);
                                        intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                                        intent.putExtra("selectYearChild",selectYearChild);
                                        intent.putExtra("selectYearChildTwo",selectYearChildTwo);
                                        intent.putExtra("selectYearChildThird",selectYearChildThird);
                                        intent.putExtra("selectYearChildFour",selectYearChildFour);
                                        intent.putExtra("for","0");
                                        startActivity(intent);
                                        finish();
                                    }
//                                    else if (BMI >= 24.9 && BMI < 30) {
//                                        Toast.makeText(Super_Member_Self.this, "Weight is not normal", Toast.LENGTH_SHORT).show();
//                                    }
                                    else if (BMI >33) {
                                        Toast.makeText(Super_Member_Self.this, "BMI is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                }
                else {
                    if(str_IndividualTypeEdit.equals("2 Adult")){
                        str_spouse_edit_dob_dob = spouse_edit_dob.getText().toString();
                        str_edt_Spouse_name = edt_Spouse_name.getText().toString();
                        str_spouse_weight_edit = spouse_weight_edit.getText().toString();
                        str_OneEditName = OneEditName.getText().toString();
                        str_twoChildEditName = twoChildEditName.getText().toString();
                        str_thirdNameEdit = thirdNameEdit.getText().toString();
                        str_fourNameEdit = fourNameEdit.getText().toString();
                        if (str_edt_name.equals("")) {
                            Toast.makeText(Super_Member_Self.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                        } else if (str_edit_dob.equals("")) {
                            Toast.makeText(Super_Member_Self.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        } else if (str_gender.equals("Select Gender")) {
                            Toast.makeText(Super_Member_Self.this, "Select Gender", Toast.LENGTH_SHORT).show();
                        } else if (str_occupation.equals("Occupation")) {
                            Toast.makeText(Super_Member_Self.this, "Select Occupation", Toast.LENGTH_SHORT).show();
                        } else if (str_ft.equals("Ft") && str_inches.equals("Inches")) {
                            Toast.makeText(Super_Member_Self.this, "Enter Ft & Inches", Toast.LENGTH_SHORT).show();
                        } else if (str_weight_edit.equals("")) {
                            Toast.makeText(Super_Member_Self.this, "Enter Weight in Kg", Toast.LENGTH_SHORT).show();
                        }else if (str_edt_Spouse_name.equals("")){
                            Toast.makeText(Super_Member_Self.this, "Enter 2nd Adult Name", Toast.LENGTH_SHORT).show();
                        }else if(str_spouse_edit_dob_dob.equals("")){
                            Toast.makeText(Super_Member_Self.this, "Enter 2nd Adult Date of Birth", Toast.LENGTH_SHORT).show();
                        }else if (str_spouse_gender.equals("Select Gender")){
                            Toast.makeText(Super_Member_Self.this, "Select 2nd Adult Gender", Toast.LENGTH_SHORT).show();

                        }else if (str_spouse_occupation_spinner.equals("Occupation")){
                            Toast.makeText(Super_Member_Self.this, "Select 2nd Adult Occupation", Toast.LENGTH_SHORT).show();

                        }else if (str_spouse_ft_spinner.equals("Ft")){
                            Toast.makeText(Super_Member_Self.this, "Select 2nd Adult Ft", Toast.LENGTH_SHORT).show();

                        }else if (str_spouse_inches_spinner.equals("Inches")){
                            Toast.makeText(Super_Member_Self.this, "Select 2nd Adult Inches", Toast.LENGTH_SHORT).show();

                        }else if (str_spouse_weight_edit.equals("")){
                            Toast.makeText(Super_Member_Self.this, "Enter 2nd Adult Weight in Kg", Toast.LENGTH_SHORT).show();
                        }else {
                            Individual_BMI = SuperCalculation(str_edt_name, str_gender, str_occupation, str_edit_dob, str_ft, str_inches, str_weight_edit, str_edit_dob3String, strThirdDString,selectYearAdult, getApplicationContext());
                            twoAdult_BMI = SuperCalculationAdult(str_edt_Spouse_name, str_spouse_edit_dob_dob, str_spouse_gender, str_spouse_occupation_spinner, str_spouse_ft_spinner, str_spouse_inches_spinner, str_spouse_weight_edit, str_edit_dob3StringSpouse, strThirdDString,selectYearSecondAdult,getApplicationContext());
                            if (Individual_BMI != 0.0 && twoAdult_BMI != 0.0) {
                                if (Individual_BMI < 16.0) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                } else if (twoAdult_BMI < 16.0) {
                                    Toast.makeText(Super_Member_Self.this, "2nd Adult  weight is not normal", Toast.LENGTH_SHORT).show();
                                } else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0) {
                                    Intent intent = new Intent(Super_Member_Self.this, Super_Medicle_details.class);
                                    intent.putExtra("str_edt_name", str_edt_name);
                                    intent.putExtra("str_edt_phone", str_edt_phone);
                                    intent.putExtra("str_email", str_email);
                                    intent.putExtra("str_age", str_age);
                                    intent.putExtra("str_reference_no", str_reference_no);
                                    intent.putExtra("str_edit_dob", str_edit_dob);
                                    intent.putExtra("str_edit_dob3String", str_edit_dob3String);
                                    intent.putExtra("str_gender", str_gender);
                                    intent.putExtra("str_occupation", str_occupation);
                                    intent.putExtra("str_ft", str_ft);
                                    intent.putExtra("str_inches", str_inches);
                                    intent.putExtra("str_weight_edit", str_weight_edit);
                                    intent.putExtra("str_edt_Spouse_name", str_edt_Spouse_name);
                                    intent.putExtra("str_spouse_edit_dob_dob", str_spouse_edit_dob_dob);
                                    intent.putExtra("str_spouse_gender", str_spouse_gender);
                                    intent.putExtra("str_spouse_occupation_spinner", str_spouse_occupation_spinner);
                                    intent.putExtra("str_spouse_ft_spinner", str_spouse_ft_spinner);
                                    intent.putExtra("str_spouse_inches_spinner", str_spouse_inches_spinner);
                                    intent.putExtra("str_spouse_weight_edit", str_spouse_weight_edit);
                                    intent.putExtra("str_policyType_spinner", str_policyType_spinner);
                                    intent.putExtra("str_SumInsured", str_SumInsured);
                                    intent.putExtra("str_IndividualTypeEdit", str_IndividualTypeEdit);
                                    intent.putExtra("str_twoChildEditName", str_twoChildEditName);
                                    intent.putExtra("str_thirdNameEdit", str_thirdNameEdit);
                                    intent.putExtra("str_fourNameEdit", str_fourNameEdit);
                                    intent.putExtra("TotalValue", TotalValue);
                                    intent.putExtra("str_policyType_spinner", str_policyType_spinner);
                                    intent.putExtra("str_IndividualTypeEdit", str_IndividualTypeEdit);
                                    intent.putExtra("str_SumInsured", str_SumInsured);
                                    intent.putExtra("strFirstTString", strFirstTString);
                                    intent.putExtra("PosPolicyNo", PosPolicyNo);
                                    intent.putExtra("strChildOne", strChildOne);
                                    intent.putExtra("strChildTwo", strChildTwo);
                                    intent.putExtra("strChildThree", strChildThree);
                                    intent.putExtra("strChildFour", strChildFour);
                                    intent.putExtra("strOneChild", strOneChild);
                                    intent.putExtra("strtwoDob", strtwoDob);
                                    intent.putExtra("strthreeDob", strthreeDob);
                                    intent.putExtra("strfourDob", strfourDob);
                                    intent.putExtra("str_oneWeightEdit", str_oneWeightEdit);
                                    intent.putExtra("strtwoWeightEdit", strtwoWeightEdit);
                                    intent.putExtra("str_thirdWeightEdit", str_thirdWeightEdit);
                                    intent.putExtra("strFourWeightEdit", strFourWeightEdit);
                                    intent.putExtra("NetPremiumValue", NetPremiumValue);
                                    intent.putExtra("strPriceTotal", strPriceTotal);
                                    intent.putExtra("GST", GST);
                                    intent.putExtra("str_RelationEdit", str_RelationEdit);
                                    intent.putExtra("strRelationAdultOneEdit", strRelationAdultOneEdit);
                                    intent.putExtra("strRelationChildEdit", strRelationChildEdit);
                                    intent.putExtra("strRelationChildTwoEdit", strRelationChildTwoEdit);
                                    intent.putExtra("strRelationChildThreeEdit", strRelationChildThreeEdit);
                                    intent.putExtra("strRelationFourChildEdit", strRelationFourChildEdit);
                                    intent.putExtra("strNominee_dob", strNominee_dob);
                                    intent.putExtra("strBMIEdit", strBMIEdit);
                                    intent.putExtra("strBMIAdultOneEdit", strBMIAdultOneEdit);
                                    intent.putExtra("strBMIChildEdit", strBMIChildEdit);
                                    intent.putExtra("strBMIChildTwoEdit", strBMIChildTwoEdit);
                                    intent.putExtra("strBMIEChildThreeEdit", strBMIEChildThreeEdit);
                                    intent.putExtra("strBMIFourChildEdit", strBMIFourChildEdit);
                                    intent.putExtra("str_oneGenderSpinner", str_oneGenderSpinner);
                                    intent.putExtra("str_oneFtSpinner", str_oneFtSpinner);
                                    intent.putExtra("str_oneInchesSpinner", str_oneInchesSpinner);
                                    intent.putExtra("str_twoGenderSpinner", str_twoGenderSpinner);
                                    intent.putExtra("str_twoFtSpinner", str_twoFtSpinner);
                                    intent.putExtra("str_twoInchesSpinner", str_twoInchesSpinner);
                                    intent.putExtra("str_thirdGenderSpinner", str_thirdGenderSpinner);
                                    intent.putExtra("str_thirdFtSpinner", str_thirdFtSpinner);
                                    intent.putExtra("str_thirdInchesSpinner", str_thirdInchesSpinner);
                                    intent.putExtra("str_fourGenderSpinner", str_fourGenderSpinner);
                                    intent.putExtra("str_fourFtSpinner", str_fourFtSpinner);
                                    intent.putExtra("str_fourInchesSpinner", str_fourInchesSpinner);
                                    intent.putExtra("PD_Status", PD_Status);
                                    intent.putExtra("ESaleDiscount", ESaleDiscount);
                                    intent.putExtra("LongTermDiscount", LongTermDiscount);
                                    intent.putExtra("nextYear", nextYear);
                                    intent.putExtra("tomorrowDate", tomorrowDate);
                                    intent.putExtra("strSumInsuredTpeEDit", strSumInsuredTpeEDit);
                                    intent.putExtra("new_str_age", new_str_age);
                                    intent.putExtra("BI_Status",BI_Status);
                                    intent.putExtra("BI_Status1",BI_Status1);
                                    intent.putExtra("BI_Status2",BI_Status2);
                                    intent.putExtra("BI_Status3",BI_Status3);
                                    intent.putExtra("BI_Status4",BI_Status4);
                                    intent.putExtra("BI_Status5",BI_Status5);
                                    intent.putExtra("str_Deductible",str_Deductible);
                                    intent.putExtra("str_employeeCodeDiscountValue",str_employeeCodeDiscountValue);
                                    intent.putExtra("str_LoyaltyDiscountEdit",str_LoyaltyDiscountEdit);
                                    intent.putExtra("str_loyalty_spinner",str_loyalty_spinner);
                                    intent.putExtra("str_employeeDiscountEditSpinner",str_employeeDiscountEditSpinner);
                                    intent.putExtra("str_life_style_spinner",str_life_style_spinner);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("strGlobalAdultSpinner",strGlobalAdultSpinner);
                                    intent.putExtra("strAdult1OneDiseaseSpinner",strAdult1OneDiseaseSpinner);
                                    intent.putExtra("selectYearAdult",selectYearAdult);
                                    intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                                    intent.putExtra("selectYearChild",selectYearChild);
                                    intent.putExtra("selectYearChildTwo",selectYearChildTwo);
                                    intent.putExtra("selectYearChildThird",selectYearChildThird);
                                    intent.putExtra("selectYearChildFour",selectYearChildFour);
                                    intent.putExtra("for", "0");
                                    startActivity(intent);
                                    finish();
                                }
//                               else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                               }
                                else if (Individual_BMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                } else if (twoAdult_BMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= SuperCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            if (Individual_BMI!=0.0 && OneChildBMI!=0.0){
                                if (Individual_BMI < 16.0) {
                                    Toast.makeText(Super_Member_Self.this, "Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (OneChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "1st Child weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0) {
                                    Intent intent=new Intent(Super_Member_Self.this, Super_Medicle_details.class);
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
                                    intent.putExtra("NetPremiumValue",NetPremiumValue);
                                    intent.putExtra("strPriceTotal",strPriceTotal);
                                    intent.putExtra("GST",GST);
                                    intent.putExtra("str_RelationEdit",str_RelationEdit);
                                    intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
                                    intent.putExtra("strRelationChildEdit",strRelationChildEdit);
                                    intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
                                    intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
                                    intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
                                    intent.putExtra("strNominee_dob",strNominee_dob);
                                    intent.putExtra("strBMIEdit",strBMIEdit);
                                    intent.putExtra("strBMIAdultOneEdit",strBMIAdultOneEdit);
                                    intent.putExtra("strBMIChildEdit",strBMIChildEdit);
                                    intent.putExtra("strBMIChildTwoEdit",strBMIChildTwoEdit);
                                    intent.putExtra("strBMIEChildThreeEdit",strBMIEChildThreeEdit);
                                    intent.putExtra("strBMIFourChildEdit",strBMIFourChildEdit);
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
                                    intent.putExtra("PD_Status",PD_Status);
                                    intent.putExtra("ESaleDiscount",ESaleDiscount);
                                    intent.putExtra("LongTermDiscount",LongTermDiscount);
                                    intent.putExtra("nextYear",nextYear);
                                    intent.putExtra("tomorrowDate",tomorrowDate);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("new_str_age",new_str_age);
                                    intent.putExtra("BI_Status",BI_Status);
                                    intent.putExtra("BI_Status1",BI_Status1);
                                    intent.putExtra("BI_Status2",BI_Status2);
                                    intent.putExtra("BI_Status3",BI_Status3);
                                    intent.putExtra("BI_Status4",BI_Status4);
                                    intent.putExtra("BI_Status5",BI_Status5);
                                    intent.putExtra("str_Deductible",str_Deductible);
                                    intent.putExtra("str_employeeCodeDiscountValue",str_employeeCodeDiscountValue);
                                    intent.putExtra("str_LoyaltyDiscountEdit",str_LoyaltyDiscountEdit);
                                    intent.putExtra("str_loyalty_spinner",str_loyalty_spinner);
                                    intent.putExtra("str_employeeDiscountEditSpinner",str_employeeDiscountEditSpinner);
                                    intent.putExtra("str_life_style_spinner",str_life_style_spinner);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("selectYearAdult",selectYearAdult);
                                    intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                                    intent.putExtra("selectYearChild",selectYearChild);
                                    intent.putExtra("selectYearChildTwo",selectYearChildTwo);
                                    intent.putExtra("selectYearChildThird",selectYearChildThird);
                                    intent.putExtra("selectYearChildFour",selectYearChildFour);
                                    intent.putExtra("for","0");
                                    startActivity(intent);
                                    finish();
                                }
//                                else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                    Toast.makeText(Super_Member_Self.this, "Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                                } else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                    Toast.makeText(Super_Member_Self.this, "1st Child weight is not normal", Toast.LENGTH_SHORT).show();
//                                }
                                else if (Individual_BMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (OneChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "1st Child weight is not normal", Toast.LENGTH_SHORT).show();
                                } }
                        }else{
                            Toast.makeText(Super_Member_Self.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= SuperCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            TwoChildBMI= SuperCalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                            if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
                                if (Individual_BMI < 16.0) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                } else  if (OneChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (TwoChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0) {
                                    Intent intent=new Intent(Super_Member_Self.this, Super_Medicle_details.class);
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
                                    intent.putExtra("strPriceTotal",strPriceTotal);
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
                                    intent.putExtra("str_RelationEdit",str_RelationEdit);
                                    intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
                                    intent.putExtra("strRelationChildEdit",strRelationChildEdit);
                                    intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
                                    intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
                                    intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
                                    intent.putExtra("strNominee_dob",strNominee_dob);
                                    intent.putExtra("GST",GST);
                                    intent.putExtra("strBMIEdit",strBMIEdit);
                                    intent.putExtra("strBMIAdultOneEdit",strBMIAdultOneEdit);
                                    intent.putExtra("strBMIChildEdit",strBMIChildEdit);
                                    intent.putExtra("strBMIChildTwoEdit",strBMIChildTwoEdit);
                                    intent.putExtra("strBMIEChildThreeEdit",strBMIEChildThreeEdit);
                                    intent.putExtra("strBMIFourChildEdit",strBMIFourChildEdit);
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
                                    intent.putExtra("PD_Status",PD_Status);
                                    intent.putExtra("ESaleDiscount",ESaleDiscount);
                                    intent.putExtra("LongTermDiscount",LongTermDiscount);
                                    intent.putExtra("nextYear",nextYear);
                                    intent.putExtra("tomorrowDate",tomorrowDate);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("new_str_age",new_str_age);
                                    intent.putExtra("BI_Status",BI_Status);
                                    intent.putExtra("BI_Status1",BI_Status1);
                                    intent.putExtra("BI_Status2",BI_Status2);
                                    intent.putExtra("BI_Status3",BI_Status3);
                                    intent.putExtra("BI_Status4",BI_Status4);
                                    intent.putExtra("BI_Status5",BI_Status5);
                                    intent.putExtra("str_Deductible",str_Deductible);
                                    intent.putExtra("str_employeeCodeDiscountValue",str_employeeCodeDiscountValue);
                                    intent.putExtra("str_LoyaltyDiscountEdit",str_LoyaltyDiscountEdit);
                                    intent.putExtra("str_loyalty_spinner",str_loyalty_spinner);
                                    intent.putExtra("str_employeeDiscountEditSpinner",str_employeeDiscountEditSpinner);
                                    intent.putExtra("str_life_style_spinner",str_life_style_spinner);                                    intent.putExtra("for","0");
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("for","0");
                                    intent.putExtra("strGlobalAdultSpinner",strGlobalAdultSpinner);
                                    intent.putExtra("strAdult1OneDiseaseSpinner",strAdult1OneDiseaseSpinner);
                                    intent.putExtra("selectYearAdult",selectYearAdult);
                                    intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                                    intent.putExtra("selectYearChild",selectYearChild);
                                    intent.putExtra("selectYearChildTwo",selectYearChildTwo);
                                    intent.putExtra("selectYearChildThird",selectYearChildThird);
                                    intent.putExtra("selectYearChildFour",selectYearChildFour);
                                    startActivity(intent);
                                    finish();
                                }
//                               else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               } else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }
                                else if (Individual_BMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (OneChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (TwoChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                } }
                        }else{
                            Toast.makeText(Super_Member_Self.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= SuperCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            TwoChildBMI= SuperCalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                            ThreeChildBMI= SuperCalculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,selectYearChildThird,getApplicationContext());
                            if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                if (Individual_BMI < 16.0) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                } else  if (OneChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (TwoChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (ThreeChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                    Intent intent=new Intent(Super_Member_Self.this, Super_Medicle_details.class);
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
                                    intent.putExtra("GST",GST);
                                    intent.putExtra("str_RelationEdit",str_RelationEdit);
                                    intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
                                    intent.putExtra("strRelationChildEdit",strRelationChildEdit);
                                    intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
                                    intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
                                    intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
                                    intent.putExtra("strNominee_dob",strNominee_dob);
                                    intent.putExtra("strPriceTotal",strPriceTotal);
                                    intent.putExtra("strBMIEdit",strBMIEdit);
                                    intent.putExtra("strBMIAdultOneEdit",strBMIAdultOneEdit);
                                    intent.putExtra("strBMIChildEdit",strBMIChildEdit);
                                    intent.putExtra("strBMIChildTwoEdit",strBMIChildTwoEdit);
                                    intent.putExtra("strBMIEChildThreeEdit",strBMIEChildThreeEdit);
                                    intent.putExtra("strBMIFourChildEdit",strBMIFourChildEdit);
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
                                    intent.putExtra("PD_Status",PD_Status);
                                    intent.putExtra("ESaleDiscount",ESaleDiscount);
                                    intent.putExtra("LongTermDiscount",LongTermDiscount);
                                    intent.putExtra("nextYear",nextYear);
                                    intent.putExtra("tomorrowDate",tomorrowDate);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("new_str_age",new_str_age);
                                    intent.putExtra("BI_Status",BI_Status);
                                    intent.putExtra("BI_Status1",BI_Status1);
                                    intent.putExtra("BI_Status2",BI_Status2);
                                    intent.putExtra("BI_Status3",BI_Status3);
                                    intent.putExtra("BI_Status4",BI_Status4);
                                    intent.putExtra("BI_Status5",BI_Status5);
                                    intent.putExtra("str_Deductible",str_Deductible);
                                    intent.putExtra("str_employeeCodeDiscountValue",str_employeeCodeDiscountValue);
                                    intent.putExtra("str_LoyaltyDiscountEdit",str_LoyaltyDiscountEdit);
                                    intent.putExtra("str_loyalty_spinner",str_loyalty_spinner);
                                    intent.putExtra("str_employeeDiscountEditSpinner",str_employeeDiscountEditSpinner);
                                    intent.putExtra("str_life_style_spinner",str_life_style_spinner);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("strGlobalAdultSpinner",strGlobalAdultSpinner);
                                    intent.putExtra("strAdult1OneDiseaseSpinner",strAdult1OneDiseaseSpinner);
                                    intent.putExtra("selectYearAdult",selectYearAdult);
                                    intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                                    intent.putExtra("selectYearChild",selectYearChild);
                                    intent.putExtra("selectYearChildTwo",selectYearChildTwo);
                                    intent.putExtra("selectYearChildThird",selectYearChildThird);
                                    intent.putExtra("selectYearChildFour",selectYearChildFour);
                                    intent.putExtra("for","0");
                                    startActivity(intent);
                                    finish();
                                }
//                               else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               } else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (ThreeChildBMI >= 24.9 && ThreeChildBMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }
                                else if (Individual_BMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (OneChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (TwoChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                }}else if (ThreeChildBMI > 33) {
                                Toast.makeText(Super_Member_Self.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                            } }
                    }
                    else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= SuperCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            twoAdult_BMI= SuperCalculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,selectYearSecondAdult,getApplicationContext());
                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0){
                                if (Individual_BMI < 16.0) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (twoAdult_BMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (OneChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0) {
                                    Intent intent=new Intent(Super_Member_Self.this, Super_Medicle_details.class);
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
                                    intent.putExtra("str_RelationEdit",str_RelationEdit);
                                    intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
                                    intent.putExtra("strRelationChildEdit",strRelationChildEdit);
                                    intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
                                    intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
                                    intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
                                    intent.putExtra("strNominee_dob",strNominee_dob);
                                    intent.putExtra("strPriceTotal",strPriceTotal);
                                    intent.putExtra("strBMIEdit",strBMIEdit);
                                    intent.putExtra("strBMIAdultOneEdit",strBMIAdultOneEdit);
                                    intent.putExtra("strBMIChildEdit",strBMIChildEdit);
                                    intent.putExtra("strBMIChildTwoEdit",strBMIChildTwoEdit);
                                    intent.putExtra("strBMIEChildThreeEdit",strBMIEChildThreeEdit);
                                    intent.putExtra("strBMIFourChildEdit",strBMIFourChildEdit);
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
                                    intent.putExtra("PD_Status",PD_Status);
                                    intent.putExtra("ESaleDiscount",ESaleDiscount);
                                    intent.putExtra("LongTermDiscount",LongTermDiscount);
                                    intent.putExtra("nextYear",nextYear);
                                    intent.putExtra("tomorrowDate",tomorrowDate);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("new_str_age",new_str_age);
                                    intent.putExtra("BI_Status",BI_Status);
                                    intent.putExtra("BI_Status1",BI_Status1);
                                    intent.putExtra("BI_Status2",BI_Status2);
                                    intent.putExtra("BI_Status3",BI_Status3);
                                    intent.putExtra("BI_Status4",BI_Status4);
                                    intent.putExtra("BI_Status5",BI_Status5);
                                    intent.putExtra("str_Deductible",str_Deductible);
                                    intent.putExtra("str_employeeCodeDiscountValue",str_employeeCodeDiscountValue);
                                    intent.putExtra("str_LoyaltyDiscountEdit",str_LoyaltyDiscountEdit);
                                    intent.putExtra("str_loyalty_spinner",str_loyalty_spinner);
                                    intent.putExtra("str_employeeDiscountEditSpinner",str_employeeDiscountEditSpinner);
                                    intent.putExtra("str_life_style_spinner",str_life_style_spinner);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("strGlobalAdultSpinner",strGlobalAdultSpinner);
                                    intent.putExtra("strAdult1OneDiseaseSpinner",strAdult1OneDiseaseSpinner);
                                    intent.putExtra("selectYearAdult",selectYearAdult);
                                    intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                                    intent.putExtra("selectYearChild",selectYearChild);
                                    intent.putExtra("selectYearChildTwo",selectYearChildTwo);
                                    intent.putExtra("selectYearChildThird",selectYearChildThird);
                                    intent.putExtra("selectYearChildFour",selectYearChildFour);
                                    intent.putExtra("for","0");
                                    startActivity(intent);
                                    finish();
                                }
//                               else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }
                                else if (Individual_BMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (twoAdult_BMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (OneChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                } }
                        }else{
                            Toast.makeText(Super_Member_Self.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= SuperCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            twoAdult_BMI= SuperCalculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,selectYearSecondAdult,getApplicationContext());
                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            TwoChildBMI= SuperCalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
                                if (Individual_BMI < 16.0) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (twoAdult_BMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (OneChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (TwoChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0) {
                                    Intent intent=new Intent(Super_Member_Self.this, Super_Medicle_details.class);
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
                                    intent.putExtra("GST",GST);
                                    intent.putExtra("str_RelationEdit",str_RelationEdit);
                                    intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
                                    intent.putExtra("strRelationChildEdit",strRelationChildEdit);
                                    intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
                                    intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
                                    intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
                                    intent.putExtra("strNominee_dob",strNominee_dob);
                                    intent.putExtra("strPriceTotal",strPriceTotal);
                                    intent.putExtra("strBMIEdit",strBMIEdit);
                                    intent.putExtra("strBMIAdultOneEdit",strBMIAdultOneEdit);
                                    intent.putExtra("strBMIChildEdit",strBMIChildEdit);
                                    intent.putExtra("strBMIChildTwoEdit",strBMIChildTwoEdit);
                                    intent.putExtra("strBMIEChildThreeEdit",strBMIEChildThreeEdit);
                                    intent.putExtra("strBMIFourChildEdit",strBMIFourChildEdit);
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
                                    intent.putExtra("PD_Status",PD_Status);
                                    intent.putExtra("ESaleDiscount",ESaleDiscount);
                                    intent.putExtra("LongTermDiscount",LongTermDiscount);
                                    intent.putExtra("nextYear",nextYear);
                                    intent.putExtra("tomorrowDate",tomorrowDate);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("new_str_age",new_str_age);
                                    intent.putExtra("BI_Status",BI_Status);
                                    intent.putExtra("BI_Status1",BI_Status1);
                                    intent.putExtra("BI_Status2",BI_Status2);
                                    intent.putExtra("BI_Status3",BI_Status3);
                                    intent.putExtra("BI_Status4",BI_Status4);
                                    intent.putExtra("BI_Status5",BI_Status5);
                                    intent.putExtra("str_Deductible",str_Deductible);
                                    intent.putExtra("str_employeeCodeDiscountValue",str_employeeCodeDiscountValue);
                                    intent.putExtra("str_LoyaltyDiscountEdit",str_LoyaltyDiscountEdit);
                                    intent.putExtra("str_loyalty_spinner",str_loyalty_spinner);
                                    intent.putExtra("str_employeeDiscountEditSpinner",str_employeeDiscountEditSpinner);
                                    intent.putExtra("str_life_style_spinner",str_life_style_spinner);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("strGlobalAdultSpinner",strGlobalAdultSpinner);
                                    intent.putExtra("strAdult1OneDiseaseSpinner",strAdult1OneDiseaseSpinner);
                                    intent.putExtra("selectYearAdult",selectYearAdult);
                                    intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                                    intent.putExtra("selectYearChild",selectYearChild);
                                    intent.putExtra("selectYearChildTwo",selectYearChildTwo);
                                    intent.putExtra("selectYearChildThird",selectYearChildThird);
                                    intent.putExtra("selectYearChildFour",selectYearChildFour);
                                    intent.putExtra("for","0");
                                    startActivity(intent);
                                    finish();
                                }
//                               else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }
                                else if (Individual_BMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (twoAdult_BMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (OneChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (TwoChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                } }
                        }else{
                            Toast.makeText(Super_Member_Self.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= SuperCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            twoAdult_BMI= SuperCalculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,selectYearSecondAdult,getApplicationContext());
                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            TwoChildBMI= SuperCalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                            ThreeChildBMI= SuperCalculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,selectYearChildThird,getApplicationContext());
                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                                if (Individual_BMI < 16.0) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (twoAdult_BMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (OneChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (TwoChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (ThreeChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0) {
                                    Intent intent=new Intent(Super_Member_Self.this, Super_Medicle_details.class);
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
                                    intent.putExtra("GST",GST);
                                    intent.putExtra("str_RelationEdit",str_RelationEdit);
                                    intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
                                    intent.putExtra("strRelationChildEdit",strRelationChildEdit);
                                    intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
                                    intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
                                    intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
                                    intent.putExtra("strNominee_dob",strNominee_dob);
                                    intent.putExtra("strPriceTotal",strPriceTotal);
                                    intent.putExtra("strBMIEdit",strBMIEdit);
                                    intent.putExtra("strBMIAdultOneEdit",strBMIAdultOneEdit);
                                    intent.putExtra("strBMIChildEdit",strBMIChildEdit);
                                    intent.putExtra("strBMIChildTwoEdit",strBMIChildTwoEdit);
                                    intent.putExtra("strBMIEChildThreeEdit",strBMIEChildThreeEdit);
                                    intent.putExtra("strBMIFourChildEdit",strBMIFourChildEdit);
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
                                    intent.putExtra("PD_Status",PD_Status);
                                    intent.putExtra("ESaleDiscount",ESaleDiscount);
                                    intent.putExtra("LongTermDiscount",LongTermDiscount);
                                    intent.putExtra("nextYear",nextYear);
                                    intent.putExtra("tomorrowDate",tomorrowDate);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("new_str_age",new_str_age);
                                    intent.putExtra("BI_Status",BI_Status);
                                    intent.putExtra("BI_Status1",BI_Status1);
                                    intent.putExtra("BI_Status2",BI_Status2);
                                    intent.putExtra("BI_Status3",BI_Status3);
                                    intent.putExtra("BI_Status4",BI_Status4);
                                    intent.putExtra("BI_Status5",BI_Status5);
                                    intent.putExtra("str_Deductible",str_Deductible);
                                    intent.putExtra("str_employeeCodeDiscountValue",str_employeeCodeDiscountValue);
                                    intent.putExtra("str_LoyaltyDiscountEdit",str_LoyaltyDiscountEdit);
                                    intent.putExtra("str_loyalty_spinner",str_loyalty_spinner);
                                    intent.putExtra("str_employeeDiscountEditSpinner",str_employeeDiscountEditSpinner);
                                    intent.putExtra("str_life_style_spinner",str_life_style_spinner);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("strGlobalAdultSpinner",strGlobalAdultSpinner);
                                    intent.putExtra("strAdult1OneDiseaseSpinner",strAdult1OneDiseaseSpinner);
                                    intent.putExtra("selectYearAdult",selectYearAdult);
                                    intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                                    intent.putExtra("selectYearChild",selectYearChild);
                                    intent.putExtra("selectYearChildTwo",selectYearChildTwo);
                                    intent.putExtra("selectYearChildThird",selectYearChildThird);
                                    intent.putExtra("selectYearChildFour",selectYearChildFour);
                                    intent.putExtra("for","0");
                                    startActivity(intent);
                                    finish();
                                }
//                               else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Adult 1  weight is not normal", Toast.LENGTH_SHORT).show();
//                               } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (ThreeChildBMI >= 24.9 && ThreeChildBMI < 30) {
//                                   Toast.makeText(Super_Member_Self.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }
                                else if (Individual_BMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (twoAdult_BMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (OneChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (TwoChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (ThreeChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                } }
                        }else{
                            Toast.makeText(Super_Member_Self.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= SuperCalculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            twoAdult_BMI= SuperCalculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,selectYearSecondAdult,getApplicationContext());
                            OneChildBMI= SuperCalculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            TwoChildBMI= SuperCalculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                            ThreeChildBMI= SuperCalculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,selectYearChildThird,getApplicationContext());
                            FourChildBMI= SuperCalculationFour(str_fourNameEdit,strfourDob,str_fourGenderSpinner,str_fourOccupationSpinner,str_fourFtSpinner,str_fourInchesSpinner,strFourWeightEdit,strChildFour,strThirdDString,selectYearChildFour,getApplicationContext());
                            if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                                if (Individual_BMI < 16.0) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (twoAdult_BMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (OneChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (TwoChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (ThreeChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (FourChildBMI < 16.0){
                                    Toast.makeText(Super_Member_Self.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (Individual_BMI >= 16.0 && Individual_BMI <= 33.0 && twoAdult_BMI >= 16.0 && twoAdult_BMI <= 33.0 && OneChildBMI >= 16.0 && OneChildBMI <= 33.0 && TwoChildBMI >= 16.0 && TwoChildBMI <= 33.0 && ThreeChildBMI >= 16.0 && ThreeChildBMI <= 33.0 && FourChildBMI >= 16.0 && FourChildBMI <= 33.0) {
                                    Intent intent=new Intent(Super_Member_Self.this, Super_Medicle_details.class);
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
                                    intent.putExtra("GST",GST);
                                    intent.putExtra("str_RelationEdit",str_RelationEdit);
                                    intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
                                    intent.putExtra("strRelationChildEdit",strRelationChildEdit);
                                    intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
                                    intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
                                    intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
                                    intent.putExtra("strNominee_dob",strNominee_dob);
                                    intent.putExtra("strPriceTotal",strPriceTotal);
                                    intent.putExtra("strBMIEdit",strBMIEdit);
                                    intent.putExtra("strBMIAdultOneEdit",strBMIAdultOneEdit);
                                    intent.putExtra("strBMIChildEdit",strBMIChildEdit);
                                    intent.putExtra("strBMIChildTwoEdit",strBMIChildTwoEdit);
                                    intent.putExtra("strBMIEChildThreeEdit",strBMIEChildThreeEdit);
                                    intent.putExtra("strBMIFourChildEdit",strBMIFourChildEdit);
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
                                    intent.putExtra("PD_Status",PD_Status);
                                    intent.putExtra("ESaleDiscount",ESaleDiscount);
                                    intent.putExtra("LongTermDiscount",LongTermDiscount);
                                    intent.putExtra("nextYear",nextYear);
                                    intent.putExtra("tomorrowDate",tomorrowDate);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("new_str_age",new_str_age);
                                    intent.putExtra("BI_Status",BI_Status);
                                    intent.putExtra("BI_Status1",BI_Status1);
                                    intent.putExtra("BI_Status2",BI_Status2);
                                    intent.putExtra("BI_Status3",BI_Status3);
                                    intent.putExtra("BI_Status4",BI_Status4);
                                    intent.putExtra("BI_Status5",BI_Status5);
                                    intent.putExtra("str_Deductible",str_Deductible);
                                    intent.putExtra("str_employeeCodeDiscountValue",str_employeeCodeDiscountValue);
                                    intent.putExtra("str_LoyaltyDiscountEdit",str_LoyaltyDiscountEdit);
                                    intent.putExtra("str_loyalty_spinner",str_loyalty_spinner);
                                    intent.putExtra("str_employeeDiscountEditSpinner",str_employeeDiscountEditSpinner);
                                    intent.putExtra("str_life_style_spinner",str_life_style_spinner);
                                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                    intent.putExtra("strGlobalAdultSpinner",strGlobalAdultSpinner);
                                    intent.putExtra("strAdult1OneDiseaseSpinner",strAdult1OneDiseaseSpinner);
                                    intent.putExtra("selectYearAdult",selectYearAdult);
                                    intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                                    intent.putExtra("selectYearChild",selectYearChild);
                                    intent.putExtra("selectYearChildTwo",selectYearChildTwo);
                                    intent.putExtra("selectYearChildThird",selectYearChildThird);
                                    intent.putExtra("selectYearChildFour",selectYearChildFour);
                                    intent.putExtra("for","0");
                                    startActivity(intent);
                                    finish();
                                }
                                else if (Individual_BMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (twoAdult_BMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (OneChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (TwoChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (ThreeChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (FourChildBMI > 33) {
                                    Toast.makeText(Super_Member_Self.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                                } }
                        }else{
                            Toast.makeText(Super_Member_Self.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Super_Member_Self.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

    private void showCalenderspouse() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Super_Member_Self.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            str_spouse_edit_dob_dob=dateFormatter.format(newDate.getTime());
            String[] strdDate1=  str_spouse_edit_dob_dob.split("-");
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
//                    if (dateValidation < Integer.parseInt(strFirstString) || (dateValidation > Integer.parseInt(strFourString))) {
                    if (selectYearSecondAdult < Integer.parseInt(strFirstString) || (selectYearSecondAdult > Integer.parseInt(strFourString))) {
//                        str_edit_dob=str_spouse_edit_dob_dob;
                        strOneChild="27-01-2005";
                        strtwoDob="27-01-2005";
                        strthreeDob="27-01-2005";
                        strfourDob="27-01-2005";
                        SuperHealthCareQuote();
                        Toast.makeText(Super_Member_Self.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
                    }else{
                        strOneChild="27-01-2005";
                        strtwoDob="27-01-2005";
                        strthreeDob="27-01-2005";
                        strfourDob="27-01-2005";
                        SuperHealthCareQuote();
                    }
                }
            }
            else if (str_for.equals("1")){
                if (str_edit_dob3StringSpouse != null) {
                    Log.e("str_edit_dob3String",str_edit_dob3StringSpouse);
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3StringSpouse);
//                    if (dateValidation < Integer.parseInt(strFirstString) || (dateValidation > Integer.parseInt(strFourString))) {
                    if (selectYearSecondAdult < Integer.parseInt(strFirstString) || (selectYearSecondAdult > Integer.parseInt(strFourString))) {
                        SuperHealthCareQuote();
                        Toast.makeText(Super_Member_Self.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
                    }else{
                        SuperHealthCareQuote();
                    }
                }
            }



        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Super_Member_Self.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            str_edit_dob=dateFormatter.format(newDate.getTime());
            Log.e("str_edit_dob", str_edit_dob);

            String[] strdDate=  str_edit_dob.split("-");
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
                        strOneChild="27-01-2005";
                        strtwoDob="27-01-2005";
                        strthreeDob="27-01-2005";
                        strfourDob="27-01-2005";
                        SuperHealthCareQuote();
                        Toast.makeText(Super_Member_Self.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
                    }else{
                        str_spouse_edit_dob_dob=str_edit_dob;
                        strOneChild="27-01-2005";
                        strtwoDob="27-01-2005";
                        strthreeDob="27-01-2005";
                        strfourDob="27-01-2005";
                        SuperHealthCareQuote();
                    }
                }
            }
            else if (str_for.equals("1")){
                if (str_edit_dob3String != null) {
                    Log.e("str_edit_dob3String",str_edit_dob3String);
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
//                    if (dateValidation < Integer.parseInt(strFirstString) || (dateValidation > Integer.parseInt(strFourString))) {
                    if (selectYearAdult < Integer.parseInt(strFirstString) || (selectYearAdult > Integer.parseInt(strFourString))) {
                        SuperHealthCareQuote();
                        Toast.makeText(Super_Member_Self.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
                    }else{
                        SuperHealthCareQuote();
                    }
                }
            }




        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalenderchild() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Super_Member_Self.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strOneChild=dateFormatter.format(newDate.getTime());
            String[] strdDate2=  strOneChild.split("-");
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate start = LocalDate.parse(strOneChild,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeft= Integer.parseInt(days);
                Log.e("daysleft", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strChildOne != null) {
                if (daysLeft < 91) {
                    Toast.makeText(Super_Member_Self.this, "1st Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();
                    OneDob.setText("");
                }else{
                    OneDob.setText(strOneChild);
                }
            }
//            if (strChildOne != null) {
//                if (selectYearChild < 1 || (selectYearChild > 30)) {
//                    Toast.makeText(Super_Member_Self.this, "1st Child Age must be between 1 to 30 years", Toast.LENGTH_SHORT).show();
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
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Super_Member_Self.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strtwoDob=dateFormatter.format(newDate.getTime());
            String[] strDateOB2=  strtwoDob.split("-");
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate start = LocalDate.parse(strtwoDob,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild2= Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strChildTwo != null) {
                if (daysLeftChild2 < 91) {
                    Toast.makeText(Super_Member_Self.this, "2nd Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();
                    twoDob.setText("");
                }else{
                    twoDob.setText(strtwoDob);
                }
            }


//            if (strChildTwo != null) {
//                if (selectYearChildTwo < 1 || (selectYearChildTwo > 30)) {
//                    Toast.makeText(Super_Member_Self.this, "2nd Child Age must be between 1 to 30 years", Toast.LENGTH_SHORT).show();
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
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Super_Member_Self.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strthreeDob=dateFormatter.format(newDate.getTime());
            String[] strDateOB2=  strthreeDob.split("-");
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate start = LocalDate.parse(strthreeDob,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild3= Integer.parseInt(days);
                Log.e("daysLeftChild3", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strChildThree != null) {
                if (daysLeftChild3 < 91) {
                    Toast.makeText(Super_Member_Self.this, "3rd Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();
                    thirdDob.setText("");
                }else{
                    thirdDob.setText(strthreeDob);
                }
            }
//            if (strChildThree != null) {
//                if (selectYearChildThird < 1 || (selectYearChildThird > 30)) {
//                    Toast.makeText(Super_Member_Self.this, "3rd Child Age must be between 1 to 30 years", Toast.LENGTH_SHORT).show();
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
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Super_Member_Self.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strfourDob=dateFormatter.format(newDate.getTime());
            String[] strDateOB2=  strfourDob.split("-");
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate start = LocalDate.parse(strfourDob,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild4= Integer.parseInt(days);
                Log.e("daysLeftChild4", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strChildFour != null) {
                if (daysLeftChild4 < 91) {
                    Toast.makeText(Super_Member_Self.this, "4th Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();
                    fourDob.setText("");
                }else{
                    fourDob.setText(strfourDob);
                }
            }
//            if (strChildFour != null) {
//                if (selectYearChildFour < 1 || (selectYearChildFour > 30)) {
//                    Toast.makeText(Super_Member_Self.this, "4th Child Age must be between 1 to 30 years", Toast.LENGTH_SHORT).show();
//                    fourDob.setText("");
//                }else{
//                    fourDob.setText(strfourDob);
//                }
//            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
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
    private void SuperHealthCareQuote() {
        JSONObject object = new JSONObject();
        try {
            JSONObject authenticate_obj=new JSONObject();
            authenticate_obj.put("WACode","20000001");
            authenticate_obj.put("WAAppCode","30000011");
            object.put("Authenticate",authenticate_obj);
            JSONObject QuotationDtls=new JSONObject();
            QuotationDtls.put("strproposerName",str_edt_name);
            QuotationDtls.put("mobileno",str_edt_phone);
            QuotationDtls.put("email_id",str_email);
            QuotationDtls.put("ProductType",str_policyType_spinner);
            QuotationDtls.put("IsLoyalCustomer","N");
            QuotationDtls.put("IsEmployee","N");
            QuotationDtls.put("EmployeeCode","");
            QuotationDtls.put("ExistingHealthPolicyNo","");
            QuotationDtls.put("IsWellnessProgram","N");
            QuotationDtls.put("GlobalCoverApplicable","N");
            QuotationDtls.put("PolicyTenure",strFirstTString);
            QuotationDtls.put("PlanType","Super Top Up");
            QuotationDtls.put("SubPlanType",strSumInsuredTpeEDit);
            JSONArray array=new JSONArray();
            if(str_IndividualTypeEdit.equals("1 Adult")){
                JSONObject obj=new JSONObject();
                obj.put("InsuredName",str_edt_name);
                obj.put("DateOfBirth",str_edit_dob);
                obj.put("Gender",str_gender);
                obj.put("Occupation",str_occupation);
                obj.put("Relation","Self");
                obj.put("SumInsured",str_SumInsured);
                obj.put("deductible",str_Deductible);
                obj.put("MedicalCase","No");
                obj.put("IsWellnessProgram","N");
                obj.put("GlobalCoverApplicable","N");
                obj.put("NomineeName","");
                obj.put("NomineeRelation","");
                array.put(obj);
            }
            else if (str_policyType_spinner.equals("Family Floater")){
                if(str_IndividualTypeEdit.equals("2 Adult")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_name);
                    objAdult2.put("DateOfBirth",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram","N");
                    objAdult2.put("GlobalCoverApplicable","N");
                    objAdult2.put("NomineeName","");
                    objAdult2.put("NomineeRelation","");
                    array.put(objAdult2);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_OneEditName);
                    objChild1.put("DateOfBirth",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_OneEditName);
                    objChild1.put("DateOfBirth",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("InsuredName",str_twoChildEditName);
                    objChild2.put("DateOfBirth",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    objChild2.put("deductible",str_Deductible);
                    objChild2.put("MedicalCase","No");
                    objChild2.put("IsWellnessProgram","N");
                    objChild2.put("GlobalCoverApplicable","N");
                    objChild2.put("NomineeName","");
                    objChild2.put("NomineeRelation","");
                    array.put(objChild2);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_OneEditName);
                    objChild1.put("DateOfBirth",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("InsuredName",str_twoChildEditName);
                    objChild2.put("DateOfBirth",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    objChild2.put("deductible",str_Deductible);
                    objChild2.put("MedicalCase","No");
                    objChild2.put("IsWellnessProgram","N");
                    objChild2.put("GlobalCoverApplicable","N");
                    objChild2.put("NomineeName","");
                    objChild2.put("NomineeRelation","");
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("InsuredName",str_thirdNameEdit);
                    objChild3.put("DateOfBirth",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("Occupation","Student");
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    objChild3.put("deductible",str_Deductible);
                    objChild3.put("MedicalCase","No");
                    objChild3.put("IsWellnessProgram","N");
                    objChild3.put("GlobalCoverApplicable","N");
                    objChild3.put("NomineeName","");
                    objChild3.put("NomineeRelation","");
                    array.put(objChild3);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_name);
                    objAdult2.put("DateOfBirth",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram","N");
                    objAdult2.put("GlobalCoverApplicable","N");
                    objAdult2.put("NomineeName","");
                    objAdult2.put("NomineeRelation","");
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_OneEditName);
                    objChild1.put("DateOfBirth",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_name);
                    objAdult2.put("DateOfBirth",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram","N");
                    objAdult2.put("GlobalCoverApplicable","N");
                    objAdult2.put("NomineeName","");
                    objAdult2.put("NomineeRelation","");
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_OneEditName);
                    objChild1.put("DateOfBirth",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("InsuredName",str_twoChildEditName);
                    objChild2.put("DateOfBirth",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    objChild2.put("deductible",str_Deductible);
                    objChild2.put("MedicalCase","No");
                    objChild2.put("IsWellnessProgram","N");
                    objChild2.put("GlobalCoverApplicable","N");
                    objChild2.put("NomineeName","");
                    objChild2.put("NomineeRelation","");
                    array.put(objChild2);

                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_name);
                    objAdult2.put("DateOfBirth",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram","N");
                    objAdult2.put("GlobalCoverApplicable","N");
                    objAdult2.put("NomineeName","");
                    objAdult2.put("NomineeRelation","");
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_OneEditName);
                    objChild1.put("DateOfBirth",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("InsuredName",str_twoChildEditName);
                    objChild2.put("DateOfBirth",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    objChild2.put("deductible",str_Deductible);
                    objChild2.put("MedicalCase","No");
                    objChild2.put("IsWellnessProgram","N");
                    objChild2.put("GlobalCoverApplicable","N");
                    objChild2.put("NomineeName","");
                    objChild2.put("NomineeRelation","");
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("InsuredName",str_thirdNameEdit);
                    objChild3.put("DateOfBirth",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("Occupation","Student");
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    objChild3.put("deductible",str_Deductible);
                    objChild3.put("MedicalCase","No");
                    objChild3.put("IsWellnessProgram","N");
                    objChild3.put("GlobalCoverApplicable","N");
                    objChild3.put("NomineeName","");
                    objChild3.put("NomineeRelation","");
                    array.put(objChild3);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_name);
                    objAdult2.put("DateOfBirth",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram","N");
                    objAdult2.put("GlobalCoverApplicable","N");
                    objAdult2.put("NomineeName","");
                    objAdult2.put("NomineeRelation","");
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_OneEditName);
                    objChild1.put("DateOfBirth",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("InsuredName",str_twoChildEditName);
                    objChild2.put("DateOfBirth",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    objChild2.put("deductible",str_Deductible);
                    objChild2.put("MedicalCase","No");
                    objChild2.put("IsWellnessProgram","N");
                    objChild2.put("GlobalCoverApplicable","N");
                    objChild2.put("NomineeName","");
                    objChild2.put("NomineeRelation","");
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("InsuredName",str_thirdNameEdit);
                    objChild3.put("DateOfBirth",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("Occupation","Student");
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    objChild3.put("deductible",str_Deductible);
                    objChild3.put("MedicalCase","No");
                    objChild3.put("IsWellnessProgram","N");
                    objChild3.put("GlobalCoverApplicable","N");
                    objChild3.put("NomineeName","");
                    objChild3.put("NomineeRelation","");
                    array.put(objChild3);
                    JSONObject objChild4=new JSONObject();
                    objChild4.put("InsuredName",str_fourNameEdit);
                    objChild4.put("DateOfBirth",strfourDob);
                    objChild4.put("Gender",str_fourGenderSpinner);
                    objChild4.put("Occupation","Student");
                    objChild4.put("Relation",strRelationFourChildEdit);
                    objChild4.put("SumInsured",str_SumInsured);
                    objChild4.put("deductible",str_Deductible);
                    objChild4.put("MedicalCase","No");
                    objChild4.put("IsWellnessProgram","N");
                    objChild4.put("GlobalCoverApplicable","N");
                    objChild4.put("NomineeName","");
                    objChild4.put("NomineeRelation","");
                    array.put(objChild4);
                }

            }
            QuotationDtls.put("Riskdtls",array);
            object.put("QuotationDtls",QuotationDtls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Super_Member_Self.this, object, UrlHealthConstants.SuperHealthCareQuote_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("True")) {
                    if (Tag == RequestHealthConstants.SUPER_HEALTH_QUOTATION) {
                        try {

                            if (object.optString("Status").equals("True")){
                                JSONObject jsonObject  = object.getJSONObject("usgiSuperHealthCare");
                                str_employeeCodeDiscountValue = jsonObject.optString("EmployeeDiscount");
                                str_LoyaltyDiscountEdit = jsonObject.optString("LoyaltyDiscount");
                                PosPolicyNo = jsonObject.optString("QuotationId");
                                String newTotalValue = jsonObject.optString("GrossPremium");
                                String newGST = jsonObject.optString("GST");
                                NetPremiumValue = jsonObject.optString("TotalNetPremium");
//                               LongTermDiscount = jsonObject.optString("TenureDiscount");
                                JSONArray objOutput  = jsonObject.getJSONArray("objOutput");
                                for (int i = 0; i < objOutput.length(); i++) {
                                    JSONObject obj = objOutput.getJSONObject(0);
//                                   TotalValue = obj.optString("TotalPremium");
                                }
                                double newTotalValue1= Double.parseDouble(newTotalValue);
                                double newGST1=Double.parseDouble(newGST);

                                GST=String.format("%.2f", newGST1);
                                TotalValue=String.format("%.2f", newTotalValue1);

                                totalPremiumAmount.setText(TotalValue);

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }else {
//                    Toast.makeText(getApplication(), "Cannot connect to Internet, please try again later", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestHealthConstants.SUPER_HEALTH_QUOTATION);
        req.execute();

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Super_Member_Self.this, SuperBuyPolicySuminsured.class);
        intent.putExtra("for","1");
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
        intent.putExtra("strNominee_dob",strNominee_dob);
        intent.putExtra("strPriceTotal",strPriceTotal);
        intent.putExtra("strBMIEdit",strBMIEdit);
        intent.putExtra("strBMIAdultOneEdit",strBMIAdultOneEdit);
        intent.putExtra("strBMIChildEdit",strBMIChildEdit);
        intent.putExtra("strBMIChildTwoEdit",strBMIChildTwoEdit);
        intent.putExtra("strBMIEChildThreeEdit",strBMIEChildThreeEdit);
        intent.putExtra("strBMIFourChildEdit",strBMIFourChildEdit);
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
        intent.putExtra("PD_Status",PD_Status);
        intent.putExtra("ESaleDiscount",ESaleDiscount);
        intent.putExtra("nextYear",nextYear);
        intent.putExtra("tomorrowDate",tomorrowDate);
        intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
        intent.putExtra("strSubLimitAmount",strSubLimitAmount);
        intent.putExtra("LifeStyleDiscountStr",LifeStyleDiscountStr);
        intent.putExtra("LongTermDiscount",LongTermDiscount);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("BI_Status",BI_Status);
        intent.putExtra("BI_Status1",BI_Status1);
        intent.putExtra("BI_Status2",BI_Status2);
        intent.putExtra("BI_Status3",BI_Status3);
        intent.putExtra("BI_Status4",BI_Status4);
        intent.putExtra("BI_Status5",BI_Status5);
        intent.putExtra("str_Deductible",str_Deductible);
        intent.putExtra("str_employeeCodeDiscountValue",str_employeeCodeDiscountValue);
        intent.putExtra("str_LoyaltyDiscountEdit",str_LoyaltyDiscountEdit);
        intent.putExtra("str_loyalty_spinner",str_loyalty_spinner);
        intent.putExtra("str_employeeDiscountEditSpinner",str_employeeDiscountEditSpinner);
        intent.putExtra("str_life_style_spinner",str_life_style_spinner);
        intent.putExtra("strGlobalAdultSpinner",strGlobalAdultSpinner);
        intent.putExtra("strAdult1OneDiseaseSpinner",strAdult1OneDiseaseSpinner);
        startActivity(intent);
        finish();

    }
}