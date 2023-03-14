package com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya.Arogya_Member_info;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.BuyPolicySumInsured;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Complete_health_member_info;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PolicyTypeCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.CalculatorPlanType;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Member_Self;

import org.joda.time.Period;
import org.joda.time.PeriodType;

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

public class PolicyTypeCHI extends AppCompatActivity {
    LinearLayout policyTypeDropDown,FirstAdultLiner,FamilyTypeDropDown,TextLiner,FloaterLiner,SelfAgeLiner,SpouseAgeLiner,mainSonLiner,SonLiner,LinerSonFirst,FirstSonAgeLiner,SecondSonAgeLiner,LinerSecond,ThirdSonLiner,ThirdSonAgeLiner,FourthLiner,FourSonAgeLiner,mainDaughterLiner,DaughterLiner,LinerFirstDaughter,LinerSecondDaughter,LinerThirdDaughter,LinerFourthDaughter,mainMotherLiner,MotherAgeLiner,mainFatherLiner,FatherAgeLiner,mainMotherInLawLiner,MotherLawAgeLiner,mainFatherInLaw,FatherLawAgeLiner;
    EditText policyType_spinner,FamilyTypeSpinner,SelfAgeEditText,SpouseAgeEditText,FirstSonAgeEditText,SecondSonAgeEditText,ThirdSonAgeEditText,FourSonAgeEditText,FirstDaughterAgeEditText,SecondDaughterAgeEditText,ThirdDaughterAgeEditText,FourDaughterAgeEditText,MotherAgeEditText,FatherAgeEditText,MotherLawAgeEditText,FatherLawAgeEditText;
    String strIDTypeName,strDob,permAndCorresAddSame,uniqueTransactionNumber,ckycNo,firstName, middleName,lastName,strPinCodeEdit,strCityEdit,strStateEdit,address1,address2,address3,corresAddress1,corresAddress2,corresAddress3,streditdob,strEmailIDEditSelf,strProposerEdtName,str_age,FamilyComposition="",ParentComposition="",str_edt_name="",str_edt_phone="",str_email="",strGenderSpinner="",strFor="",str_policyType_spinner="",str_IndividualTypeEdit="",strCheckBoxSelf="",strSelfAgeEditText="",strCheckBoxSpouse="",strSpouseAgeEditText="",strCheckBoxSon="",strFirstSonAgeEditText="",strSecondSonAgeEditText="",strThirdSonAgeEditText="",strFourSonAgeEditText="",strFirstDaughterAgeEditText="",strSecondDaughterAgeEditText="",strThirdDaughterAgeEditText="",strFourDaughterAgeEditText="",strMotherAgeEditText="",strCheckBoxMother="",strFatherAgeEditText="",strCheckBoxFather="",strMotherLawAgeEditText="",strCheckBoxMotherLaw="",strFatherLawAgeEditText="",strCheckBoxFatherLaw="";
    String str_edit_dob3String="",today="";
    CheckBox CheckBoxSelf,CheckBoxSpouse,CheckBoxSon,CheckBoxDaughter,CheckBoxMother,CheckBoxFather,CheckBoxMotherLaw,CheckBoxFatherLaw;
    Button btnNext,minusSonBtn,addSonBtn,minusDaughterBtn,addDaughterBtn;
    TextView SonCounterText,DaughterTextCounter;
    int FamilyTypeCounter = 0;
    int mCounter = 0;
    int DaughterCounter = 0;
    int maxCounter = 4;
    int maxDaughterCounter = 4;
    SimpleDateFormat dateFormatter;
    Format formatter;
    Date date,CurrentDate,SelectDate;
    public Period period;
    ImageView SummeryBack;
    int selectYearProposer,selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectFirstYearChild,daysLeftChild1,selectSecSonChild,daysLeftChild2,daysLeftChild3,selectThirdSonChild,daysLeftChild4,selectYearChildFour,FirstDaughterYearChild,daysLeftDaughter1,SecondDaughterYearChild,daysLeftDaughter2,ThirdDaughterYearChild,daysLeftDaughter3,FourDaughterYearChild,daysLeftDaughter4,selectYearMotherAdult,selectYearFatherAdult,selectMotherLawAdult,selectFatherLawAdult;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_type_chi);
        getWindow().setStatusBarColor(ContextCompat.getColor(PolicyTypeCHI.this, R.color.colorPrimaryDark));
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
          today = formatter.format(date);
          streditdob = getIntent().getStringExtra("streditdob");
          strEmailIDEditSelf = getIntent().getStringExtra("strEmailIDEditSelf");
          strGenderSpinner = getIntent().getStringExtra("strGenderSpinner");
          strFor = getIntent().getStringExtra("strFor");
          str_age = getIntent().getStringExtra("str_age");
          strProposerEdtName = getIntent().getStringExtra("strProposerEdtName");
          str_edt_name = getIntent().getStringExtra("str_edt_name");
          str_edt_phone = getIntent().getStringExtra("str_edt_phone");
          str_email = getIntent().getStringExtra("str_email");
          strCheckBoxSelf = getIntent().getStringExtra("strCheckBoxSelf");
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
          selectYearProposer = getIntent().getIntExtra("selectYearProposer", 0);
          mCounter = getIntent().getIntExtra("mCounter", 0);
          selectYearAdult = getIntent().getIntExtra("selectYearAdult", 0);
          FamilyTypeCounter = getIntent().getIntExtra("FamilyTypeCounter", 0);
          selectYearSecondAdult = getIntent().getIntExtra("selectYearSecondAdult", 0);
          selectYearMotherAdult = getIntent().getIntExtra("selectYearMotherAdult", 0);
          selectMotherLawAdult = getIntent().getIntExtra("selectMotherLawAdult", 0);
          selectFirstYearChild = getIntent().getIntExtra("selectFirstYearChild", 0);
          selectSecSonChild = getIntent().getIntExtra("selectSecSonChild", 0);
          selectThirdSonChild = getIntent().getIntExtra("selectThirdSonChild", 0);
          selectYearChildFour = getIntent().getIntExtra("selectYearChildFour", 0);
          selectFatherLawAdult = getIntent().getIntExtra("selectFatherLawAdult", 0);
          selectYearFatherAdult = getIntent().getIntExtra("selectYearFatherAdult", 0);
          strPinCodeEdit = getIntent().getStringExtra("strPinCodeEdit");
          strCityEdit = getIntent().getStringExtra("strCityEdit");
          strStateEdit = getIntent().getStringExtra("strStateEdit");
          address1 = getIntent().getStringExtra("address1");
          address2 = getIntent().getStringExtra("address2");
          address3 = getIntent().getStringExtra("address3");
          strIDTypeName = getIntent().getStringExtra("strIDTypeName");
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

          initView();
    }
    private void initView() {
        //linerLayout
        SummeryBack=findViewById(R.id.SummeryBack);
        policyTypeDropDown=findViewById(R.id.policyTypeDropDown);
        FirstAdultLiner=findViewById(R.id.FirstAdultLiner);
        FamilyTypeDropDown=findViewById(R.id.FamilyTypeDropDown);
        TextLiner=findViewById(R.id.TextLiner);
        FloaterLiner=findViewById(R.id.FloaterLiner);
        SelfAgeLiner=findViewById(R.id.SelfAgeLiner);
        SpouseAgeLiner=findViewById(R.id.SpouseAgeLiner);
        mainSonLiner=findViewById(R.id.mainSonLiner);
        SonLiner=findViewById(R.id.SonLiner);
        LinerSonFirst=findViewById(R.id.LinerSonFirst);
        FirstSonAgeLiner=findViewById(R.id.FirstSonAgeLiner);
        LinerSecond=findViewById(R.id.LinerSecond);
        SecondSonAgeLiner=findViewById(R.id.SecondSonAgeLiner);
        ThirdSonLiner=findViewById(R.id.ThirdSonLiner);
        ThirdSonAgeLiner=findViewById(R.id.ThirdSonAgeLiner);
        FourthLiner=findViewById(R.id.FourthLiner);
        FourSonAgeLiner=findViewById(R.id.FourSonAgeLiner);
        mainDaughterLiner=findViewById(R.id.mainDaughterLiner);
        DaughterLiner=findViewById(R.id.DaughterLiner);
        LinerFirstDaughter=findViewById(R.id.LinerFirstDaughter);
        LinerSecondDaughter=findViewById(R.id.LinerSecondDaughter);
        LinerThirdDaughter=findViewById(R.id.LinerThirdDaughter);
        LinerFourthDaughter=findViewById(R.id.LinerFourthDaughter);
        mainMotherLiner=findViewById(R.id.mainMotherLiner);
        MotherAgeLiner=findViewById(R.id.MotherAgeLiner);
        mainFatherLiner=findViewById(R.id.mainFatherLiner);
        FatherAgeLiner=findViewById(R.id.FatherAgeLiner);
        mainMotherInLawLiner=findViewById(R.id.mainMotherInLawLiner);
        MotherLawAgeLiner=findViewById(R.id.MotherLawAgeLiner);
        mainFatherInLaw=findViewById(R.id.mainFatherInLaw);
        FatherLawAgeLiner=findViewById(R.id.FatherLawAgeLiner);
        //EditText
        policyType_spinner=findViewById(R.id.policyType_spinner);
        SelfAgeEditText=findViewById(R.id.SelfAgeEditText);
        SpouseAgeEditText=findViewById(R.id.SpouseAgeEditText);
        FirstSonAgeEditText=findViewById(R.id.FirstSonAgeEditText);
        SecondSonAgeEditText=findViewById(R.id.SecondSonAgeEditText);
        ThirdSonAgeEditText=findViewById(R.id.ThirdSonAgeEditText);
        FourSonAgeEditText=findViewById(R.id.FourSonAgeEditText);
        FirstDaughterAgeEditText=findViewById(R.id.FirstDaughterAgeEditText);
        SecondDaughterAgeEditText=findViewById(R.id.SecondDaughterAgeEditText);
        ThirdDaughterAgeEditText=findViewById(R.id.ThirdDaughterAgeEditText);
        FourDaughterAgeEditText=findViewById(R.id.FourDaughterAgeEditText);
        MotherAgeEditText=findViewById(R.id.MotherAgeEditText);
        FatherAgeEditText=findViewById(R.id.FatherAgeEditText);
        MotherLawAgeEditText=findViewById(R.id.MotherLawAgeEditText);
        FatherLawAgeEditText=findViewById(R.id.FatherLawAgeEditText);
        FamilyTypeSpinner=findViewById(R.id.FamilyTypeSpinner);

        //CheckBox
        CheckBoxSelf=findViewById(R.id.CheckBoxSelf);
        CheckBoxSpouse=findViewById(R.id.CheckBoxSpouse);
        CheckBoxSon=findViewById(R.id.CheckBoxSon);
        CheckBoxDaughter=findViewById(R.id.CheckBoxDaughter);
        CheckBoxMother=findViewById(R.id.CheckBoxMother);
        CheckBoxFather=findViewById(R.id.CheckBoxFather);
        CheckBoxMotherLaw=findViewById(R.id.CheckBoxMotherLaw);
        CheckBoxFatherLaw=findViewById(R.id.CheckBoxFatherLaw);

        //Button
        btnNext=findViewById(R.id.btnNext);
        minusSonBtn=findViewById(R.id.minusSonBtn);
        addSonBtn=findViewById(R.id.addSonBtn);
        minusDaughterBtn=findViewById(R.id.minusDaughterBtn);
        addDaughterBtn=findViewById(R.id.addDaughterBtn);
        //TextView
        SonCounterText=findViewById(R.id.SonCounterText);
        DaughterTextCounter=findViewById(R.id.DaughterTextCounter);

        if (strFor.equals("0")){
            str_policyType_spinner="Select Policy Type";
            policyType_spinner.setText(str_policyType_spinner);
            strCheckBoxSelf="UnChecked";
            strCheckBoxSpouse="UnChecked";
            strCheckBoxSon="UnChecked";
            strCheckBoxMother="UnChecked";
            strCheckBoxFather="UnChecked";
            strCheckBoxMotherLaw="UnChecked";
            strCheckBoxFatherLaw="UnChecked";
        }
        else{
            policyType_spinner.setText(str_policyType_spinner);
            if (str_policyType_spinner.equals("Individual")){
                str_IndividualTypeEdit="1 Adult";
                FamilyTypeSpinner.setText(str_IndividualTypeEdit);
                FirstAdultLiner.setVisibility(View.VISIBLE);
                TextLiner.setVisibility(View.GONE);
                FloaterLiner.setVisibility(View.VISIBLE);
                mainSonLiner.setVisibility(View.GONE);
                mainMotherLiner.setVisibility(View.GONE);
                mainFatherLiner.setVisibility(View.GONE);
                mainMotherInLawLiner.setVisibility(View.GONE);
                mainFatherInLaw.setVisibility(View.GONE);
                if (strCheckBoxSelf.equals("Checked")){
                    CheckBoxSelf.setChecked(true);
                    SelfAgeLiner.setVisibility(View.VISIBLE);
                    SelfAgeEditText.setText(strSelfAgeEditText);
                }else{
                    SelfAgeLiner.setVisibility(View.GONE);
                    strSelfAgeEditText="Select Dob";
                    SelfAgeEditText.setText(strSelfAgeEditText);
                    CheckBoxSelf.setChecked(false);
                }

                if (strCheckBoxSpouse.equals("Checked")){
                    SpouseAgeEditText.setText(strSpouseAgeEditText);
                    SpouseAgeLiner.setVisibility(View.VISIBLE);
                    CheckBoxSpouse.setChecked(true);
                }else{
                    SpouseAgeLiner.setVisibility(View.GONE);
                    strSpouseAgeEditText="Select Dob";
                    SpouseAgeEditText.setText(strSpouseAgeEditText);
                    CheckBoxSpouse.setChecked(false);
                }
                if (strCheckBoxMother.equals("Checked")){
                    CheckBoxMother.setChecked(true);
                    MotherAgeLiner.setVisibility(View.VISIBLE);
                    MotherAgeEditText.setText(strMotherAgeEditText);
                }else{
                    MotherAgeLiner.setVisibility(View.GONE);
                    CheckBoxMother.setChecked(false);
                }
                if (strCheckBoxFather.equals("Checked")){
                    CheckBoxFather.setChecked(true);
                    FatherAgeLiner.setVisibility(View.VISIBLE);
                    FatherAgeEditText.setText(strFatherAgeEditText);
                }else{
                    CheckBoxFather.setChecked(false);
                    FatherAgeLiner.setVisibility(View.GONE);
                    strFatherAgeEditText="Select Dob";
                    FatherAgeEditText.setText(strFatherAgeEditText);
                }
                if (strCheckBoxMotherLaw.equals("Checked")){
                    CheckBoxMotherLaw.setChecked(true);
                    MotherLawAgeLiner.setVisibility(View.VISIBLE);
                    MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                }else{
                    CheckBoxMotherLaw.setChecked(false);
                    MotherLawAgeLiner.setVisibility(View.GONE);
                    strMotherLawAgeEditText = "Select Dob";
                    MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                }
                if (strCheckBoxFatherLaw.equals("Checked")){
                    CheckBoxFatherLaw.setChecked(true);
                    FatherLawAgeLiner.setVisibility(View.VISIBLE);
                    FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                }else{
                    CheckBoxFatherLaw.setChecked(false);
                    FatherLawAgeLiner.setVisibility(View.GONE);
                    strFatherLawAgeEditText="Select Dob";
                    FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                }
            }
            else {
                str_IndividualTypeEdit="2 Adult";
                FamilyTypeSpinner.setText(str_IndividualTypeEdit);
                FirstAdultLiner.setVisibility(View.VISIBLE);
                TextLiner.setVisibility(View.VISIBLE);
                FloaterLiner.setVisibility(View.VISIBLE);
                mainMotherLiner.setVisibility(View.VISIBLE);
                mainFatherLiner.setVisibility(View.VISIBLE);
                mainMotherInLawLiner.setVisibility(View.VISIBLE);
                mainFatherInLaw.setVisibility(View.VISIBLE);
                if (strCheckBoxSelf.equals("Checked")){
                    CheckBoxSelf.setChecked(true);
                    SelfAgeLiner.setVisibility(View.VISIBLE);
                    SelfAgeEditText.setText(strSelfAgeEditText);
                }else{
                    SelfAgeLiner.setVisibility(View.GONE);
                    strSelfAgeEditText="Select Dob";
                    SelfAgeEditText.setText(strSelfAgeEditText);
                    CheckBoxSelf.setChecked(false);
                }
                if (strCheckBoxSpouse.equals("Checked")){
                    SpouseAgeEditText.setText(strSpouseAgeEditText);
                    SpouseAgeLiner.setVisibility(View.VISIBLE);
                    CheckBoxSpouse.setChecked(true);
                }else{
                    SpouseAgeLiner.setVisibility(View.GONE);
                    strSpouseAgeEditText="Select Dob";
                    SpouseAgeEditText.setText(strSpouseAgeEditText);
                    CheckBoxSpouse.setChecked(false);
                 }
                if (strCheckBoxSon.equals("Checked")){
                    mainSonLiner.setVisibility(View.VISIBLE);
                    SonLiner.setVisibility(View.VISIBLE);
                    SonCounterText.setText(String.valueOf(mCounter));
                    CheckBoxSon.setChecked(true);
                    if (mCounter==1){
                        LinerSonFirst.setVisibility(View.VISIBLE);
                        FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                    }
                    else if (mCounter==2){
                        LinerSonFirst.setVisibility(View.VISIBLE);
                        LinerSecond.setVisibility(View.VISIBLE);
                        ThirdSonLiner.setVisibility(View.GONE);
                        FourthLiner.setVisibility(View.GONE);
                        FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                        SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                    }
                    else if (mCounter==3){
                        LinerSonFirst.setVisibility(View.VISIBLE);
                        LinerSecond.setVisibility(View.VISIBLE);
                        ThirdSonLiner.setVisibility(View.VISIBLE);
                        FourthLiner.setVisibility(View.GONE);
                        FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                        SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                        ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                    }
                    else if (mCounter==4){
                        LinerSonFirst.setVisibility(View.VISIBLE);
                        LinerSecond.setVisibility(View.VISIBLE);
                        ThirdSonLiner.setVisibility(View.VISIBLE);
                        FourthLiner.setVisibility(View.VISIBLE);
                        FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                        SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                        ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                        FourSonAgeEditText.setText(strFourSonAgeEditText);
                    }
                }
                else{
                    CheckBoxSon.setChecked(false);
                    LinerSonFirst.setVisibility(View.GONE);
                    LinerSecond.setVisibility(View.GONE);
                    ThirdSonLiner.setVisibility(View.GONE);
                    FourthLiner.setVisibility(View.GONE);
                    LinerSonFirst.setVisibility(View.GONE);
                }

                if (strCheckBoxMother.equals("Checked")){
                    CheckBoxMother.setChecked(true);
                    MotherAgeLiner.setVisibility(View.VISIBLE);
                    MotherAgeEditText.setText(strMotherAgeEditText);
                    MotherLawAgeLiner.setVisibility(View.GONE);
                    FatherLawAgeLiner.setVisibility(View.GONE);
                    mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                    mainMotherInLawLiner.setClickable(false);
                    mainFatherInLaw.setClickable(false);
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                }else{
                    MotherAgeLiner.setVisibility(View.GONE);
                    CheckBoxMother.setChecked(false);
                    mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherInLaw.setClickable(true);
                    mainMotherInLawLiner.setClickable(true);
                }
                if (strCheckBoxFather.equals("Checked")){
                    CheckBoxFather.setChecked(true);
                    FatherAgeLiner.setVisibility(View.VISIBLE);
                    FatherAgeEditText.setText(strFatherAgeEditText);
                    MotherLawAgeLiner.setVisibility(View.GONE);
                    FatherLawAgeLiner.setVisibility(View.GONE);
                    mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                    mainMotherInLawLiner.setClickable(false);
                    mainFatherInLaw.setClickable(false);
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                }else{
                    CheckBoxFather.setChecked(false);
                    FatherAgeLiner.setVisibility(View.GONE);
                    mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherInLaw.setClickable(true);
                    mainMotherInLawLiner.setClickable(true);
                    strFatherAgeEditText="Select Dob";
                    FatherAgeEditText.setText(strFatherAgeEditText);
                }
                if (strCheckBoxMotherLaw.equals("Checked")){
                    CheckBoxMotherLaw.setChecked(true);
                    MotherLawAgeLiner.setVisibility(View.VISIBLE);
                    MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                    MotherAgeLiner.setVisibility(View.GONE);
                    FatherAgeLiner.setVisibility(View.GONE);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                }else{
                    CheckBoxMotherLaw.setChecked(false);
                    MotherLawAgeLiner.setVisibility(View.GONE);
                    strMotherLawAgeEditText = "Select Dob";
                    MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                    mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainMotherLiner.setClickable(true);
                    mainFatherLiner.setClickable(true);
                }
                if (strCheckBoxFatherLaw.equals("Checked")){
                    CheckBoxFatherLaw.setChecked(true);
                    FatherLawAgeLiner.setVisibility(View.VISIBLE);
                    FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                    MotherAgeLiner.setVisibility(View.GONE);
                    FatherAgeLiner.setVisibility(View.GONE);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                }else{
                    CheckBoxFatherLaw.setChecked(false);
                    FatherLawAgeLiner.setVisibility(View.GONE);
                    strFatherLawAgeEditText="Select Dob";
                    FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                    mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainMotherLiner.setClickable(true);
                    mainFatherLiner.setClickable(true);
                }
            }
        }
        policyTypeDropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PolicyTypeCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Individual");
                items1.add("Family Floater");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_policyType_spinner=items1.get(options1);
                        policyType_spinner.setText(str_policyType_spinner);
                        if (str_policyType_spinner.equals("Individual")){
                            str_IndividualTypeEdit="1 Adult";
                            FamilyTypeSpinner.setText(str_IndividualTypeEdit);
                            FirstAdultLiner.setVisibility(View.VISIBLE);
                            TextLiner.setVisibility(View.GONE);
                            FloaterLiner.setVisibility(View.VISIBLE);
                            mainSonLiner.setVisibility(View.GONE);
                            LinerSonFirst.setVisibility(View.GONE);
                            LinerSecond.setVisibility(View.GONE);
                            ThirdSonLiner.setVisibility(View.GONE);
                            FourthLiner.setVisibility(View.GONE);
                            LinerSonFirst.setVisibility(View.GONE);
                            mainMotherLiner.setVisibility(View.GONE);
                            mainFatherLiner.setVisibility(View.GONE);
                            mainMotherInLawLiner.setVisibility(View.GONE);
                            mainFatherInLaw.setVisibility(View.GONE);
                        }else {
                            str_IndividualTypeEdit="2 Adult";
                            FamilyTypeSpinner.setText(str_IndividualTypeEdit);
                            TextLiner.setVisibility(View.VISIBLE);
                            mainSonLiner.setVisibility(View.VISIBLE);
                            FirstAdultLiner.setVisibility(View.VISIBLE);
                            FloaterLiner.setVisibility(View.VISIBLE);
                            mainMotherLiner.setVisibility(View.VISIBLE);
                            mainFatherLiner.setVisibility(View.VISIBLE);
                            mainMotherInLawLiner.setVisibility(View.VISIBLE);
                            mainFatherInLaw.setVisibility(View.VISIBLE);
                        }
                    }
                });
                singlePicker.show();
            }
        });
        FamilyTypeDropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(PolicyTypeCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("2 Adult");
                items1.add("1 Adult + 1 Child");
                items1.add("1 Adult + 2 Child");
                items1.add("1 Adult + 3 Child");
                items1.add("2 Adult + 1 Child");
                items1.add("2 Adult + 2 Child");
                items1.add("2 Adult + 3 Child");
                items1.add("2 Adult + 4 Child");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_IndividualTypeEdit=items1.get(options1);
                        FamilyTypeSpinner.setText(str_IndividualTypeEdit);
                        if(str_IndividualTypeEdit.equals("2 Adult")){
                            FirstAdultLiner.setVisibility(View.VISIBLE);
                            SpouseAgeLiner.setVisibility(View.VISIBLE);
                        }
                        else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                            FirstAdultLiner.setVisibility(View.VISIBLE);
                            mainSonLiner.setVisibility(View.VISIBLE);
                        }
                        else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                            FirstAdultLiner.setVisibility(View.VISIBLE);
                            mainSonLiner.setVisibility(View.VISIBLE);

                        }
                        else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                            FirstAdultLiner.setVisibility(View.VISIBLE);
                            mainSonLiner.setVisibility(View.VISIBLE);
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                            FirstAdultLiner.setVisibility(View.VISIBLE);
                            SpouseAgeLiner.setVisibility(View.VISIBLE);
                            mainSonLiner.setVisibility(View.VISIBLE);
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                            FirstAdultLiner.setVisibility(View.VISIBLE);
                            SpouseAgeLiner.setVisibility(View.VISIBLE);
                            mainSonLiner.setVisibility(View.VISIBLE);
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                            FirstAdultLiner.setVisibility(View.VISIBLE);
                            SpouseAgeLiner.setVisibility(View.VISIBLE);
                            mainSonLiner.setVisibility(View.VISIBLE);
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                            FirstAdultLiner.setVisibility(View.VISIBLE);
                            SpouseAgeLiner.setVisibility(View.VISIBLE);
                            mainSonLiner.setVisibility(View.VISIBLE);
                        }else{
                            str_policyType_spinner="Family Floater";
                            policyType_spinner.setText(str_policyType_spinner);
                            str_IndividualTypeEdit="2 Adult";

                        }
                    }
                });
                singlePicker.show(); }
        });
        //Self
        CheckBoxSelf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    strCheckBoxSelf="Checked";
                    SelfAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                }else{
                    strCheckBoxSelf="UnChecked";
                    SelfAgeLiner.setVisibility(View.GONE);
                    FamilyTypeCounter--;

                }
//                strSelfAgeEditText="Select Dob";
                strSelfAgeEditText=strDob;
                SelfAgeEditText.setText(strSelfAgeEditText);
                dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
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
                if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                    str_age="18yrs-25yrs";
                }else if (selectYearAdult >= 26 && selectYearAdult <= 30) {
                    str_age="26yrs-30yrs";
                }else if (selectYearAdult >= 31 && selectYearAdult <= 35) {
                    str_age="31yrs-35yrs";
                }else if (selectYearAdult >= 36 && selectYearAdult <= 40) {
                    str_age="36yrs-40yrs";
                }else if (selectYearAdult >= 41 && selectYearAdult <= 45) {
                    str_age="41yrs-45yrs";
                }else if (selectYearAdult >= 46 && selectYearAdult <= 50) {
                    str_age="46yrs-50yrs";
                }else if (selectYearAdult >= 51 && selectYearAdult <= 55) {
                    str_age="51yrs-55yrs";
                }else if (selectYearAdult >= 56 && selectYearAdult <= 60) {
                    str_age="56yrs-60yrs";
                }else if (selectYearAdult >= 61 && selectYearAdult <= 65) {
                    str_age="61yrs-65yrs";
                }else if (selectYearAdult >= 66 && selectYearAdult <= 70) {
                    str_age="66yrs-70yrs";
                } else if (selectYearAdult >= 71 && selectYearAdult <= 75){
                    str_age="71yrs-75yrs";
                }
            }
        });
        SelfAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    showFirstCalender();
                }

            }
        });
        //spouse
        CheckBoxSpouse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    strCheckBoxSpouse="Checked";
                    SpouseAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                }else{
                    strCheckBoxSpouse="UnChecked";
                    FamilyTypeCounter--;
                    SpouseAgeLiner.setVisibility(View.GONE);

                }
                strSpouseAgeEditText="Select Dob";
                SpouseAgeEditText.setText(strSpouseAgeEditText);
            }
        });
        SpouseAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    showSpouseCalender();
                }
            }
        });
        //son
        CheckBoxSon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (DaughterCounter == 4){
                    CheckBoxSon.setChecked(false);
                    Toast.makeText(PolicyTypeCHI.this, "Can't Select any Son", Toast.LENGTH_SHORT).show();
                }else{
                    if (isChecked){
                        mCounter++;
                        strCheckBoxSon="Checked";
                        SonCounterText.setText(String.valueOf(mCounter));
                        SonLiner.setVisibility(View.VISIBLE);
                        strFirstSonAgeEditText="Select Dob";
                        strSecondSonAgeEditText="Select Dob";
                        strThirdSonAgeEditText="Select Dob";
                        strFourSonAgeEditText="Select Dob";
                        FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                        SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                        ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                        FourSonAgeEditText.setText(strFourSonAgeEditText);
                        LinerSonFirst.setVisibility(View.VISIBLE);
                    }else{
                        mCounter--;
                        SonCounterText.setText(String.valueOf(mCounter));
                        strCheckBoxSon="UnChecked";
                        SonLiner.setVisibility(View.GONE);
                        mCounter = 0;
                        SonCounterText.setText(String.valueOf(mCounter));
                        LinerSonFirst.setVisibility(View.GONE);
                        LinerSecond.setVisibility(View.GONE);
                        ThirdSonLiner.setVisibility(View.GONE);
                        FourthLiner.setVisibility(View.GONE);
                        LinerSonFirst.setVisibility(View.GONE);
                    }
                }



            }
        });
        minusSonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter--;
                if (mCounter < 0) {
                    mCounter = 0;
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.GONE);
                    LinerSecond.setVisibility(View.GONE);
                    ThirdSonLiner.setVisibility(View.GONE);
                    FourthLiner.setVisibility(View.GONE);
                    mainDaughterLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainDaughterLiner.setClickable(true);
                } else if (mCounter == 1) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.GONE);
                    ThirdSonLiner.setVisibility(View.GONE);
                    FourthLiner.setVisibility(View.GONE);
                    mainDaughterLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainDaughterLiner.setClickable(true);
                    DaughterCounter = 0;
                    maxDaughterCounter = 3;
                } else if (mCounter == 2) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.VISIBLE);
                    ThirdSonLiner.setVisibility(View.GONE);
                    FourthLiner.setVisibility(View.GONE);
                    mainDaughterLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainDaughterLiner.setClickable(true);
                } else if (mCounter == 3) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.VISIBLE);
                    ThirdSonLiner.setVisibility(View.VISIBLE);
                    FourthLiner.setVisibility(View.GONE);
                    mainDaughterLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainDaughterLiner.setClickable(true);
                } else if (mCounter == 4) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.VISIBLE);
                    ThirdSonLiner.setVisibility(View.VISIBLE);
                    FourthLiner.setVisibility(View.VISIBLE);
                    mainDaughterLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainDaughterLiner.setClickable(false);
                    CheckBoxDaughter.setChecked(false);
                }
            }
        });
        addSonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter++;
                if (mCounter > maxCounter) {
                    mCounter = 4;
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.VISIBLE);
                    ThirdSonLiner.setVisibility(View.VISIBLE);
                    FourthLiner.setVisibility(View.VISIBLE);
                    mainDaughterLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainDaughterLiner.setClickable(false);
                    CheckBoxDaughter.setChecked(false);

                } else if (mCounter == 1) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.GONE);
                    ThirdSonLiner.setVisibility(View.GONE);
                    FourthLiner.setVisibility(View.GONE);
                    mainDaughterLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainDaughterLiner.setClickable(true);
                    DaughterCounter = 0;
                    maxDaughterCounter = 3;
                } else if (mCounter == 2) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.VISIBLE);
                    ThirdSonLiner.setVisibility(View.GONE);
                    FourthLiner.setVisibility(View.GONE);
                    mainDaughterLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainDaughterLiner.setClickable(true);
                } else if (mCounter == 3) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.VISIBLE);
                    ThirdSonLiner.setVisibility(View.VISIBLE);
                    FourthLiner.setVisibility(View.GONE);
                    mainDaughterLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainDaughterLiner.setClickable(true);
                } else if (mCounter == 4) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.VISIBLE);
                    ThirdSonLiner.setVisibility(View.VISIBLE);
                    FourthLiner.setVisibility(View.VISIBLE);
                    mainDaughterLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainDaughterLiner.setClickable(false);
                    CheckBoxDaughter.setChecked(false);

                }
            }
        });
        FirstSonAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFirstSonCalender();

              /*  MyOptionsPickerView singlePicker = new MyOptionsPickerView(PolicyTypeCHI.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1");items1.add("2");items1.add("2");items1.add("4");items1.add("5");items1.add("6");items1.add("7");items1.add("8");items1.add("9");items1.add("10");items1.add("11");items1.add("12");items1.add("13");items1.add("14");items1.add("15");items1.add("16");
                items1.add("17");items1.add("18");items1.add("19");items1.add("20");items1.add("21");items1.add("22");items1.add("23");items1.add("24");items1.add("25");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strFirstSonAgeEditText=items1.get(options1);
                        FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                    }
                });
                singlePicker.show();

               */
            }
        });
        SecondSonAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSecondSonCalender();
            }
        });
        ThirdSonAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showThirdSonCalender();
            }
        });
        FourSonAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFourSonCalender();
            }
        });
      //daughter
        CheckBoxDaughter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mCounter == 4){
                    CheckBoxDaughter.setChecked(false);
                    Toast.makeText(PolicyTypeCHI.this, "Can't Select any Daughter", Toast.LENGTH_SHORT).show();
                }else{
                    if (isChecked){
                        FamilyTypeCounter++;
                        DaughterLiner.setVisibility(View.VISIBLE);
                        strFirstDaughterAgeEditText="Select Dob";
                        strSecondDaughterAgeEditText="Select Dob";
                        strThirdDaughterAgeEditText="Select Dob";
                        strFourDaughterAgeEditText="Select Dob";
                        FirstDaughterAgeEditText.setText(strFirstDaughterAgeEditText);
                        SecondDaughterAgeEditText.setText(strSecondDaughterAgeEditText);
                        ThirdDaughterAgeEditText.setText(strThirdDaughterAgeEditText);
                        FourDaughterAgeEditText.setText(strFourDaughterAgeEditText);
                    }else{
                        FamilyTypeCounter--;
                        DaughterCounter = 0;
                        DaughterTextCounter.setText(String.valueOf(DaughterCounter));
                        DaughterLiner.setVisibility(View.GONE);
                        LinerFirstDaughter.setVisibility(View.GONE);
                        LinerSecondDaughter.setVisibility(View.GONE);
                        LinerThirdDaughter.setVisibility(View.GONE);
                        LinerFourthDaughter.setVisibility(View.GONE);
                    }
                }
            }
        });
        minusDaughterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaughterCounter--;
                if (DaughterCounter < 0) {
                    DaughterCounter = 0;
                    DaughterTextCounter.setText(String.valueOf(DaughterCounter));
                    LinerFirstDaughter.setVisibility(View.GONE);
                    LinerSecondDaughter.setVisibility(View.GONE);
                    LinerThirdDaughter.setVisibility(View.GONE);
                    LinerFourthDaughter.setVisibility(View.GONE);
                    mainSonLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainSonLiner.setClickable(true);
                } else if (DaughterCounter == 1) {
                    DaughterTextCounter.setText(String.valueOf(DaughterCounter));
                    LinerFirstDaughter.setVisibility(View.VISIBLE);
                    LinerSecondDaughter.setVisibility(View.GONE);
                    LinerThirdDaughter.setVisibility(View.GONE);
                    LinerFourthDaughter.setVisibility(View.GONE);
                    mainSonLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainSonLiner.setClickable(true);
                } else if (DaughterCounter == 2) {
                    DaughterTextCounter.setText(String.valueOf(DaughterCounter));
                    LinerFirstDaughter.setVisibility(View.VISIBLE);
                    LinerSecondDaughter.setVisibility(View.VISIBLE);
                    LinerThirdDaughter.setVisibility(View.GONE);
                    LinerFourthDaughter.setVisibility(View.GONE);
                    mainSonLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainSonLiner.setClickable(true);
                } else if (DaughterCounter == 3) {
                    DaughterTextCounter.setText(String.valueOf(DaughterCounter));
                    LinerFirstDaughter.setVisibility(View.VISIBLE);
                    LinerSecondDaughter.setVisibility(View.VISIBLE);
                    LinerThirdDaughter.setVisibility(View.VISIBLE);
                    LinerFourthDaughter.setVisibility(View.GONE);
                    mainSonLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainSonLiner.setClickable(true);
                } else if (DaughterCounter == 4) {
                    DaughterTextCounter.setText(String.valueOf(DaughterCounter));
                    LinerFirstDaughter.setVisibility(View.VISIBLE);
                    LinerSecondDaughter.setVisibility(View.VISIBLE);
                    LinerThirdDaughter.setVisibility(View.VISIBLE);
                    LinerFourthDaughter.setVisibility(View.VISIBLE);
                    mainSonLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainSonLiner.setClickable(false);
                    CheckBoxSon.setChecked(false);

                }
            }
        });
        addDaughterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaughterCounter++;
                if (DaughterCounter > maxDaughterCounter) {
                    DaughterCounter = 4;
                    DaughterTextCounter.setText(String.valueOf(DaughterCounter));
                    LinerFirstDaughter.setVisibility(View.VISIBLE);
                    LinerSecondDaughter.setVisibility(View.VISIBLE);
                    LinerThirdDaughter.setVisibility(View.VISIBLE);
                    LinerFourthDaughter.setVisibility(View.VISIBLE);
                    mainSonLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainSonLiner.setClickable(false);
                    CheckBoxSon.setChecked(false);
                    SonLiner.setVisibility(View.GONE);
                    mCounter = 0;
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.GONE);
                    LinerSecond.setVisibility(View.GONE);
                    ThirdSonLiner.setVisibility(View.GONE);
                    FourthLiner.setVisibility(View.GONE);
                } else if (DaughterCounter == 1) {
                    DaughterTextCounter.setText(String.valueOf(DaughterCounter));
                    LinerFirstDaughter.setVisibility(View.VISIBLE);
                    LinerSecondDaughter.setVisibility(View.GONE);
                    LinerThirdDaughter.setVisibility(View.GONE);
                    LinerFourthDaughter.setVisibility(View.GONE);
                    mainSonLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainSonLiner.setClickable(true);
                } else if (DaughterCounter == 2) {
                    DaughterTextCounter.setText(String.valueOf(DaughterCounter));
                    LinerFirstDaughter.setVisibility(View.VISIBLE);
                    LinerSecondDaughter.setVisibility(View.VISIBLE);
                    LinerThirdDaughter.setVisibility(View.GONE);
                    LinerFourthDaughter.setVisibility(View.GONE);
                    mainSonLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainSonLiner.setClickable(true);
                } else if (DaughterCounter == 3) {
                    DaughterTextCounter.setText(String.valueOf(DaughterCounter));
                    LinerFirstDaughter.setVisibility(View.VISIBLE);
                    LinerSecondDaughter.setVisibility(View.VISIBLE);
                    LinerThirdDaughter.setVisibility(View.VISIBLE);
                    LinerFourthDaughter.setVisibility(View.GONE);
                    mainSonLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainSonLiner.setClickable(true);
                } else if (DaughterCounter == 4) {
                    DaughterTextCounter.setText(String.valueOf(DaughterCounter));
                    LinerFirstDaughter.setVisibility(View.VISIBLE);
                    LinerSecondDaughter.setVisibility(View.VISIBLE);
                    LinerThirdDaughter.setVisibility(View.VISIBLE);
                    LinerFourthDaughter.setVisibility(View.VISIBLE);
                    mainSonLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainSonLiner.setClickable(false);
                    CheckBoxSon.setChecked(false);
                }
            }
        });
        FirstDaughterAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFirstDaughterCalender();
            }
        });
        SecondDaughterAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSecondDaughterCalender();
            }
        });
        ThirdDaughterAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showThirdDaughterCalender();
            }
        });
        FourDaughterAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFourDaughterCalender();
            }
        });
       //mother
        CheckBoxMother.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CheckBoxMotherLaw.isChecked()&&CheckBoxFatherLaw.isChecked()){
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                    Toast.makeText(PolicyTypeCHI.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                }else if (CheckBoxMotherLaw.isChecked()||CheckBoxFatherLaw.isChecked()){
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                    Toast.makeText(PolicyTypeCHI.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                }else {
                     if (isChecked){
                    FamilyTypeCounter++;
                    MotherAgeLiner.setVisibility(View.VISIBLE);
                    strCheckBoxMother="Checked";
                   MotherLawAgeLiner.setVisibility(View.GONE);
                   FatherLawAgeLiner.setVisibility(View.GONE);
                   if (CheckBoxMother.isChecked()&&CheckBoxFather.isChecked()){
                    mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                    mainMotherInLawLiner.setClickable(false);
                    mainFatherInLaw.setClickable(false);
                    CheckBoxMotherLaw.setChecked(false);
                   CheckBoxFatherLaw.setChecked(false);
              }else if (CheckBoxMother.isChecked()||CheckBoxFather.isChecked()) {
                  mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                  mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                  mainMotherInLawLiner.setClickable(false);
                  mainFatherInLaw.setClickable(false);
                  CheckBoxMotherLaw.setChecked(false);
                  CheckBoxFatherLaw.setChecked(false);
              }else{
                   mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                   mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                   mainMotherInLawLiner.setClickable(true);
                   mainFatherInLaw.setClickable(true);
                   }
               }else{
                 FamilyTypeCounter--;
                 MotherAgeLiner.setVisibility(View.GONE);
                 strCheckBoxMother="UnChecked";
                }
                strMotherAgeEditText="Select Dob";
                MotherAgeEditText.setText(strMotherAgeEditText);
                mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                mainFatherInLaw.setClickable(true);
                mainMotherInLawLiner.setClickable(true);
             }

            }
        });
        MotherAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMotherCalender();
            }
        });
        //father
        CheckBoxFather.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CheckBoxMotherLaw.isChecked()&&CheckBoxFatherLaw.isChecked()){
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                    Toast.makeText(PolicyTypeCHI.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                }else if (CheckBoxMotherLaw.isChecked()||CheckBoxFatherLaw.isChecked()){
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                    Toast.makeText(PolicyTypeCHI.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                }else if (isChecked){
                    if (CheckBoxMother.isChecked()&&CheckBoxFather.isChecked()){
                        mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherInLawLiner.setClickable(false);
                        CheckBoxMotherLaw.setChecked(false);
                        CheckBoxFatherLaw.setChecked(false);
                    }else if (CheckBoxMother.isChecked()||CheckBoxFather.isChecked()){
                        mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherInLawLiner.setClickable(false);
                        CheckBoxMotherLaw.setChecked(false);
                        CheckBoxFatherLaw.setChecked(false);
                    }else{
                        mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                        mainMotherInLawLiner.setClickable(true);
                        mainFatherInLaw.setClickable(true);
                    }
                    FamilyTypeCounter++;
                    FatherAgeLiner.setVisibility(View.VISIBLE);
                    strFatherAgeEditText="Select Dob";
                    FatherAgeEditText.setText(strFatherAgeEditText);
                    strCheckBoxFather="Checked";
                    MotherLawAgeLiner.setVisibility(View.GONE);
                    FatherLawAgeLiner.setVisibility(View.GONE);
                    }else{
                    FamilyTypeCounter--;
                    FatherAgeLiner.setVisibility(View.GONE);
                    mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherInLaw.setClickable(true);
                    mainMotherInLawLiner.setClickable(true);
                    strFatherAgeEditText="Select Dob";
                    FatherAgeEditText.setText(strFatherAgeEditText);
                    strCheckBoxFather="UnChecked";
                    }

            }
        });
        FatherAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFatherCalender();
            }
        });

        //motherInLaw
        CheckBoxMotherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CheckBoxMother.isChecked()&&CheckBoxFather.isChecked()){
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    Toast.makeText(PolicyTypeCHI.this, "Can't Select Mother-In-Law & Father-In-Law", Toast.LENGTH_SHORT).show();
                }else if (CheckBoxMother.isChecked()||CheckBoxFather.isChecked()){
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    Toast.makeText(PolicyTypeCHI.this, "Can't Select Mother-In-Law & Father-In-Law", Toast.LENGTH_SHORT).show();
                }else if (isChecked) {
                    if (CheckBoxMotherLaw.isChecked()&&CheckBoxFatherLaw.isChecked()){
                        mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherLiner.setClickable(false);
                        mainFatherLiner.setClickable(false);
                        CheckBoxMother.setChecked(false);
                        CheckBoxFather.setChecked(false);
                    }else if (CheckBoxMotherLaw.isChecked()||CheckBoxFatherLaw.isChecked()){
                        mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherLiner.setClickable(false);
                        mainFatherLiner.setClickable(false);
                        CheckBoxMother.setChecked(false);
                        CheckBoxFather.setChecked(false);
                    }else{
                        mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainMotherLiner.setClickable(true);
                        mainFatherLiner.setClickable(true);
                    }
                    FamilyTypeCounter++;
                    MotherLawAgeLiner.setVisibility(View.VISIBLE);
                    strMotherLawAgeEditText = "Select Dob";
                    MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                    strCheckBoxMotherLaw="Checked";
                    MotherAgeLiner.setVisibility(View.GONE);
                    FatherAgeLiner.setVisibility(View.GONE);
                     } else {
                    FamilyTypeCounter--;
                    MotherLawAgeLiner.setVisibility(View.GONE);
                    strMotherLawAgeEditText = "Select Dob";
                    MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                    mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainMotherLiner.setClickable(true);
                    mainFatherLiner.setClickable(true);
                    strCheckBoxMotherLaw="UnChecked";
                     }


            }
        });
        MotherLawAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMotherInLawCalender();
            }
        });
       //fatherInLaw
        CheckBoxFatherLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CheckBoxMother.isChecked()&&CheckBoxFather.isChecked()){
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    Toast.makeText(PolicyTypeCHI.this, "Can't Select Mother-In-Law & Father-In-Law", Toast.LENGTH_SHORT).show();
                }if (CheckBoxMother.isChecked()||CheckBoxFather.isChecked()){
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    Toast.makeText(PolicyTypeCHI.this, "Can't Select Mother-In-Law & Father-In-Law", Toast.LENGTH_SHORT).show();
                }else if (isChecked){
                    if (CheckBoxMotherLaw.isChecked()&&CheckBoxFatherLaw.isChecked()){
                        mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherLiner.setClickable(false);
                        mainFatherLiner.setClickable(false);
                        CheckBoxMother.setChecked(false);
                        CheckBoxFather.setChecked(false);
                    }else if (CheckBoxMotherLaw.isChecked()||CheckBoxFatherLaw.isChecked()){
                        mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherLiner.setClickable(false);
                        mainFatherLiner.setClickable(false);
                        CheckBoxMother.setChecked(false);
                        CheckBoxFather.setChecked(false);
                    }else{
                        mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainMotherLiner.setClickable(true);
                        mainFatherLiner.setClickable(true);
                    }
                    FamilyTypeCounter++;
                    strCheckBoxFatherLaw="Checked";
                    FatherLawAgeLiner.setVisibility(View.VISIBLE);
                    strFatherLawAgeEditText="Select Dob";
                    FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                    MotherAgeLiner.setVisibility(View.GONE);
                    FatherAgeLiner.setVisibility(View.GONE);
                    }else{
                    FamilyTypeCounter--;
                     FatherLawAgeLiner.setVisibility(View.GONE);
                    strFatherLawAgeEditText="Select Dob";
                    FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                    mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainMotherLiner.setClickable(true);
                    mainFatherLiner.setClickable(true);
                    strCheckBoxFatherLaw="UnChecked";
                    }


            }
        });
        FatherLawAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFatherInLawCalender();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str_policyType_spinner.equals("Individual")){
                    if (strCheckBoxSelf.equals("Checked")){
                        FamilyComposition="1 Adult";
                        ParentComposition="";
                    }
                    if (strCheckBoxSpouse.equals("Checked")){
                        FamilyComposition="1 Adult";
                        ParentComposition="";
                    }
                    if (strCheckBoxMother.equals("Checked")){
                        FamilyComposition="1 Parent";
                        ParentComposition="";
                    }
                    if (strCheckBoxFather.equals("Checked")){
                        FamilyComposition="1 Parent";
                        ParentComposition="";
                    }
                    if (strCheckBoxMotherLaw.equals("Checked")){
                        FamilyComposition="1 Parent";
                        ParentComposition="";
                    }
                    if (strCheckBoxFatherLaw.equals("Checked")){
                        FamilyComposition="1 Parent";
                        ParentComposition="";
                    }
                }
                else{
                     if (strCheckBoxSelf.equals("Checked")&&strCheckBoxSpouse.equals("Checked")){
                    if (mCounter==1){
                        FamilyComposition="2 Adult + 1 Child";
                    }else if (mCounter==2){
                        FamilyComposition="2 Adult + 2 Child";
                    }else if (mCounter==3){
                        FamilyComposition="2 Adult + 3 Child";
                    }else if (mCounter==4){
                        FamilyComposition="2 Adult + 4 Child";
                    }else{
                        FamilyComposition="2 Adult";
                    }
                }
                 else{
                     if (strCheckBoxSelf.equals("Checked")||strCheckBoxSpouse.equals("Checked")){
                       if (mCounter==1){
                        FamilyComposition="1 Adult + 1 Child";
                     }else if (mCounter==2){
                        FamilyComposition="1 Adult + 2 Child";
                    }else if (mCounter==3){
                        FamilyComposition="1 Adult + 3 Child";
                    }else if (mCounter==4){
                        FamilyComposition="1 Adult + 4 Child";
                    }else{
                        FamilyComposition="1 Adult";
                    }
                   }
                 }
                if (strCheckBoxMother.equals("Checked")) {
                    if (strCheckBoxFather.equals("Checked")) {
                        ParentComposition="2 Parent";
                    }else{
                        ParentComposition="1 Parent";
                    }
                }
                else if (strCheckBoxFather.equals("Checked")) {
                    ParentComposition="1 Parent";
                }
                else if (strCheckBoxMotherLaw.equals("Checked")) {
                    if (strCheckBoxFatherLaw.equals("Checked")) {
                        ParentComposition="2 Parent";
                    } else{
                        ParentComposition="1 Parent";
                    }
                }
                else if (strCheckBoxFatherLaw.equals("Checked")) {
                    ParentComposition="1 Parent";
                }
                else{
                    ParentComposition="";
                }
                }

                if (str_policyType_spinner.equals("Select Policy Type")){
                    Toast.makeText(PolicyTypeCHI.this, "Please Select Policy Type", Toast.LENGTH_SHORT).show();
                }else{
                    if (str_policyType_spinner.equals("Individual")){
                        if (FamilyTypeCounter==0){
                            Toast.makeText(PolicyTypeCHI.this, "Select any insured member", Toast.LENGTH_SHORT).show();
                        }
                        else if (FamilyTypeCounter>1){
                            Toast.makeText(PolicyTypeCHI.this, "You can select only 1 members", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            if (CheckBoxSelf.isChecked()&&strSelfAgeEditText.equals("Select Dob")){
                                Toast.makeText(PolicyTypeCHI.this, "Enter Self DOB", Toast.LENGTH_SHORT).show();
                            }else if (CheckBoxSpouse.isChecked()&&strSpouseAgeEditText.equals("Select Dob")){
                                Toast.makeText(PolicyTypeCHI.this, "Enter Spouse DOB", Toast.LENGTH_SHORT).show();
                            }else if (CheckBoxMother.isChecked()&&strMotherAgeEditText.equals("Select Dob")){
                                Toast.makeText(PolicyTypeCHI.this, "Enter Mother DOB", Toast.LENGTH_SHORT).show();
                            }else if (CheckBoxFather.isChecked()&&strFatherAgeEditText.equals("Select Dob")){
                                Toast.makeText(PolicyTypeCHI.this, "Enter Father DOB", Toast.LENGTH_SHORT).show();
                            }else if (CheckBoxMotherLaw.isChecked()&&strMotherLawAgeEditText.equals("Select Dob")){
                                Toast.makeText(PolicyTypeCHI.this, "Enter Mother-In-Law DOB", Toast.LENGTH_SHORT).show();
                            }else if (CheckBoxFatherLaw.isChecked()&&strFatherLawAgeEditText.equals("Select Dob")){
                                Toast.makeText(PolicyTypeCHI.this, "Enter Father-In-Law DOB", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                nextMethod();
                            }
                        }
                    }
                    else {
                        if (!(CheckBoxSelf.isChecked()||CheckBoxSpouse.isChecked()||CheckBoxSon.isChecked()||CheckBoxDaughter.isChecked()||CheckBoxMother.isChecked()||CheckBoxFather.isChecked()||CheckBoxMotherLaw.isChecked()||CheckBoxFatherLaw.isChecked())){
                            Toast.makeText(PolicyTypeCHI.this, "Please Select Any Insure", Toast.LENGTH_SHORT).show();
                        }else if (FamilyTypeCounter+mCounter<=1){
                            Toast.makeText(PolicyTypeCHI.this, "Please Select Any other Insure", Toast.LENGTH_SHORT).show();
                        }else if (FamilyTypeCounter+mCounter+DaughterCounter>6){
                            Toast.makeText(PolicyTypeCHI.this, "You can select only 6 members", Toast.LENGTH_SHORT).show();
                        }
                        else if (CheckBoxSelf.isChecked()&&strSelfAgeEditText.equals("Select Dob")){
                            Toast.makeText(PolicyTypeCHI.this, "Enter Self DOB", Toast.LENGTH_SHORT).show();
                        }else if (CheckBoxSpouse.isChecked()&&strSpouseAgeEditText.equals("Select Dob")){
                            Toast.makeText(PolicyTypeCHI.this, "Enter Spouse DOB", Toast.LENGTH_SHORT).show();
                        }else if (CheckBoxMother.isChecked()&&strMotherAgeEditText.equals("Select Dob")){
                            Toast.makeText(PolicyTypeCHI.this, "Enter Mother DOB", Toast.LENGTH_SHORT).show();
                        }else if (CheckBoxFather.isChecked()&&strFatherAgeEditText.equals("Select Dob")){
                            Toast.makeText(PolicyTypeCHI.this, "Enter Father DOB", Toast.LENGTH_SHORT).show();
                        }else if (CheckBoxMotherLaw.isChecked()&&strMotherLawAgeEditText.equals("Select Dob")){
                            Toast.makeText(PolicyTypeCHI.this, "Enter Mother-In-Law DOB", Toast.LENGTH_SHORT).show();
                        }else if (CheckBoxFatherLaw.isChecked()&&strFatherLawAgeEditText.equals("Select Dob")){
                            Toast.makeText(PolicyTypeCHI.this, "Enter Father-In-Law DOB", Toast.LENGTH_SHORT).show();
                        }
                        else if (CheckBoxSon.isChecked()){
                            if (mCounter==1&&strFirstSonAgeEditText.equals("Select Dob")){
                                Toast.makeText(PolicyTypeCHI.this, "Enter First Child DOB", Toast.LENGTH_SHORT).show();
                            }else  if (mCounter==2&&strSecondSonAgeEditText.equals("Select Dob")){
                                Toast.makeText(PolicyTypeCHI.this, "Enter Second Child DOB", Toast.LENGTH_SHORT).show();
                            }else  if (mCounter==3&&strThirdSonAgeEditText.equals("Select Dob")){
                                Toast.makeText(PolicyTypeCHI.this, "Enter Third Child DOB", Toast.LENGTH_SHORT).show();
                            }else  if (mCounter==4&&strFourSonAgeEditText.equals("Select Dob")){
                                Toast.makeText(PolicyTypeCHI.this, "Enter Fourth Child DOB", Toast.LENGTH_SHORT).show();
                            }else{
                                if (CheckBoxSpouse.isChecked()&&strSpouseAgeEditText.equals("Select Dob")){
                                    Toast.makeText(PolicyTypeCHI.this, "Enter Spouse DOB", Toast.LENGTH_SHORT).show();
                                }else if (CheckBoxMother.isChecked()&&strMotherAgeEditText.equals("Select Dob")){
                                    Toast.makeText(PolicyTypeCHI.this, "Enter Mother DOB", Toast.LENGTH_SHORT).show();
                                }else if (CheckBoxFather.isChecked()&&strFatherAgeEditText.equals("Select Dob")){
                                    Toast.makeText(PolicyTypeCHI.this, "Enter Father DOB", Toast.LENGTH_SHORT).show();
                                }else if (CheckBoxMotherLaw.isChecked()&&strMotherLawAgeEditText.equals("Select Dob")){
                                    Toast.makeText(PolicyTypeCHI.this, "Enter Mother-In-Law DOB", Toast.LENGTH_SHORT).show();
                                }else if (CheckBoxFatherLaw.isChecked()&&strFatherLawAgeEditText.equals("Select Dob")){
                                    Toast.makeText(PolicyTypeCHI.this, "Enter Father-In-Law DOB", Toast.LENGTH_SHORT).show();
                                }else{
                                    if (CheckBoxMother.isChecked()||CheckBoxFather.isChecked()||CheckBoxMotherLaw.isChecked()||CheckBoxFatherLaw.isChecked()){
                                        if (!(CheckBoxSelf.isChecked()||CheckBoxSpouse.isChecked())){
                                            Toast.makeText(PolicyTypeCHI.this, "Select Self or Spouse", Toast.LENGTH_SHORT).show();
                                        }else{
                                            if (CheckBoxSelf.isChecked()&&strSelfAgeEditText.equals("Select Dob")){
                                                Toast.makeText(PolicyTypeCHI.this, "Enter Self DOB", Toast.LENGTH_SHORT).show();
                                            }else if (CheckBoxSpouse.isChecked()&&strSpouseAgeEditText.equals("Select Dob")){
                                                Toast.makeText(PolicyTypeCHI.this, "Enter Spouse DOB", Toast.LENGTH_SHORT).show();
                                            }else if (CheckBoxMother.isChecked()&&strMotherAgeEditText.equals("Select Dob")){
                                                Toast.makeText(PolicyTypeCHI.this, "Enter Mother DOB", Toast.LENGTH_SHORT).show();
                                            }else if (CheckBoxFather.isChecked()&&strFatherAgeEditText.equals("Select Dob")){
                                                Toast.makeText(PolicyTypeCHI.this, "Enter Father DOB", Toast.LENGTH_SHORT).show();
                                            }else if (CheckBoxMotherLaw.isChecked()&&strMotherLawAgeEditText.equals("Select Dob")){
                                                Toast.makeText(PolicyTypeCHI.this, "Enter Mother-In-Law DOB", Toast.LENGTH_SHORT).show();
                                            }else if (CheckBoxFatherLaw.isChecked()&&strFatherLawAgeEditText.equals("Select Dob")){
                                                Toast.makeText(PolicyTypeCHI.this, "Enter Father-In-Law DOB", Toast.LENGTH_SHORT).show();
                                            }else{
                                                nextMethod();
                                            }
                                        }
                                    }else{
                                        nextMethod();
                                    }

                                 }
                            }
                        }
                        else if (CheckBoxMother.isChecked()||CheckBoxFather.isChecked()||CheckBoxMotherLaw.isChecked()||CheckBoxFatherLaw.isChecked()){
                            if (!(CheckBoxSelf.isChecked()||CheckBoxSpouse.isChecked())){
                                Toast.makeText(PolicyTypeCHI.this, "Select Self or Spouse", Toast.LENGTH_SHORT).show();
                            }else{
                                if (CheckBoxSelf.isChecked()&&strSelfAgeEditText.equals("Select Dob")){
                                    Toast.makeText(PolicyTypeCHI.this, "Enter Self DOB", Toast.LENGTH_SHORT).show();
                                }else if (CheckBoxSpouse.isChecked()&&strSpouseAgeEditText.equals("Select Dob")){
                                    Toast.makeText(PolicyTypeCHI.this, "Enter Spouse DOB", Toast.LENGTH_SHORT).show();
                                }else if (CheckBoxMother.isChecked()&&strMotherAgeEditText.equals("Select Dob")){
                                    Toast.makeText(PolicyTypeCHI.this, "Enter Mother DOB", Toast.LENGTH_SHORT).show();
                                }else if (CheckBoxFather.isChecked()&&strFatherAgeEditText.equals("Select Dob")){
                                    Toast.makeText(PolicyTypeCHI.this, "Enter Father DOB", Toast.LENGTH_SHORT).show();
                                }else if (CheckBoxMotherLaw.isChecked()&&strMotherLawAgeEditText.equals("Select Dob")){
                                    Toast.makeText(PolicyTypeCHI.this, "Enter Mother-In-Law DOB", Toast.LENGTH_SHORT).show();
                                }else if (CheckBoxFatherLaw.isChecked()&&strFatherLawAgeEditText.equals("Select Dob")){
                                    Toast.makeText(PolicyTypeCHI.this, "Enter Father-In-Law DOB", Toast.LENGTH_SHORT).show();
                                }else{
                                    nextMethod();
                                }
                            }
                        }
                        else{
                            nextMethod();
                        }

                    }

                }
            }
        });
        SummeryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PolicyTypeCHI.super.onBackPressed();;
            }
        });
      }
    private void nextMethod() {
        Intent intent=new Intent(PolicyTypeCHI.this,NewCHIAddOns.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("str_edt_phone",str_edt_phone);
        intent.putExtra("str_email",str_email);
        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
        intent.putExtra("strSelfAgeEditText",strSelfAgeEditText);
        intent.putExtra("streditdob",streditdob);
        intent.putExtra("strCheckBoxSelf",strCheckBoxSelf);
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
        intent.putExtra("FamilyTypeCounter",FamilyTypeCounter);
        intent.putExtra("selectYearAdult",selectYearAdult);
        intent.putExtra("FamilyComposition",FamilyComposition);
        intent.putExtra("ParentComposition",ParentComposition);
        intent.putExtra("selectFirstYearChild",selectFirstYearChild);
        intent.putExtra("selectSecSonChild",selectSecSonChild);
        intent.putExtra("selectThirdSonChild",selectThirdSonChild);
        intent.putExtra("selectYearChildFour",selectYearChildFour);
        intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
        intent.putExtra("selectYearMotherAdult",selectYearMotherAdult);
        intent.putExtra("selectMotherLawAdult",selectMotherLawAdult);
        intent.putExtra("selectFatherLawAdult",selectFatherLawAdult);
        intent.putExtra("selectYearFatherAdult",selectYearFatherAdult);
        intent.putExtra("strProposerEdtName",strProposerEdtName);
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
        intent.putExtra("strDob",strDob);
        intent.putExtra("strIDTypeName",strIDTypeName);
        intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
        intent.putExtra("permAndCorresAddSame",permAndCorresAddSame);
        intent.putExtra("str_age",str_age);
        intent.putExtra("selectYearProposer",selectYearProposer);
        intent.putExtra("strFor","0");
        startActivity(intent);
        finish();
    }
    public void showFirstCalender() {

        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSelfAgeEditText=dateFormatter.format(newDate.getTime());
            Log.e("strSelfAgeEditText", strSelfAgeEditText);
            String[] strdDate=  strSelfAgeEditText.split("/");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            str_edit_dob3String = strdDate[2];
            Log.e("str_edit_dob3String", str_edit_dob3String);
            SelfAgeEditText.setText(strSelfAgeEditText);
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
            if (selectYearAdult < 18 || (selectYearAdult > 75)) {
                Toast.makeText(PolicyTypeCHI.this, "Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
                strSelfAgeEditText="Select Dob";
                SelfAgeEditText.setText(strSelfAgeEditText);
            }
            else{
                if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                      str_age="18yrs-25yrs";
            }else if (selectYearAdult >= 26 && selectYearAdult <= 30) {
                str_age="26yrs-30yrs";
            }else if (selectYearAdult >= 31 && selectYearAdult <= 35) {
                str_age="31yrs-35yrs";
            }else if (selectYearAdult >= 36 && selectYearAdult <= 40) {
                str_age="36yrs-40yrs";
            }else if (selectYearAdult >= 41 && selectYearAdult <= 45) {
                str_age="41yrs-45yrs";
            }else if (selectYearAdult >= 46 && selectYearAdult <= 50) {
                str_age="46yrs-50yrs";
            }else if (selectYearAdult >= 51 && selectYearAdult <= 55) {
                str_age="51yrs-55yrs";
            }else if (selectYearAdult >= 56 && selectYearAdult <= 60) {
                str_age="56yrs-60yrs";
            }else if (selectYearAdult >= 61 && selectYearAdult <= 65) {
                str_age="61yrs-65yrs";
            }else if (selectYearAdult >= 66 && selectYearAdult <= 70) {
                str_age="66yrs-70yrs";
            } else if (selectYearAdult >= 71 && selectYearAdult <= 75){
                str_age="71yrs-75yrs";
            }
                SelfAgeEditText.setText(strSelfAgeEditText);
            }
          Log.e("str_age",str_age);

         }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    public void showSpouseCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSpouseAgeEditText=dateFormatter.format(newDate.getTime());
            Log.e("strSelfAgeEditText", strSpouseAgeEditText);
            SpouseAgeEditText.setText(strSpouseAgeEditText);
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
            if (selectYearSecondAdult < 18 || (selectYearSecondAdult > 75)) {
                Toast.makeText(PolicyTypeCHI.this, "Spouse Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
                strSpouseAgeEditText="Select Dob";
                SpouseAgeEditText.setText(strSpouseAgeEditText);
            }else{
                if (str_policyType_spinner.equals("Individual")){
                 if (selectYearSecondAdult >= 18 && (selectYearSecondAdult <= 25)) {
                    str_age="18yrs-25yrs";
                }else if (selectYearSecondAdult >= 26 && selectYearSecondAdult <= 30) {
                    str_age="26yrs-30yrs";
                }else if (selectYearSecondAdult >= 31 && selectYearSecondAdult <= 35) {
                    str_age="31yrs-35yrs";
                }else if (selectYearSecondAdult >= 36 && selectYearSecondAdult <= 40) {
                    str_age="36yrs-40yrs";
                }else if (selectYearSecondAdult >= 41 && selectYearSecondAdult <= 45) {
                    str_age="41yrs-45yrs";
                }else if (selectYearSecondAdult >= 46 && selectYearSecondAdult <= 50) {
                    str_age="46yrs-50yrs";
                }else if (selectYearSecondAdult >= 51 && selectYearSecondAdult <= 55) {
                    str_age="51yrs-55yrs";
                }else if (selectYearSecondAdult >= 56 && selectYearSecondAdult <= 60) {
                    str_age="56yrs-60yrs";
                }else if (selectYearSecondAdult >= 61 && selectYearSecondAdult <= 65) {
                    str_age="61yrs-65yrs";
                }else if (selectYearSecondAdult >= 66 && selectYearSecondAdult <= 70) {
                    str_age="66yrs-70yrs";
                } else if (selectYearSecondAdult >= 71 && selectYearSecondAdult <= 75){
                    str_age="71yrs-75yrs";
                }
                }else {
                  if (!strCheckBoxSelf.equals("Checked")) {
                      if (selectYearSecondAdult >= 18 && (selectYearSecondAdult <= 25)) {
                          str_age="18yrs-25yrs";
                      }else if (selectYearSecondAdult >= 26 && selectYearSecondAdult <= 30) {
                          str_age="26yrs-30yrs";
                      }else if (selectYearSecondAdult >= 31 && selectYearSecondAdult <= 35) {
                          str_age="31yrs-35yrs";
                      }else if (selectYearSecondAdult >= 36 && selectYearSecondAdult <= 40) {
                          str_age="36yrs-40yrs";
                      }else if (selectYearSecondAdult >= 41 && selectYearSecondAdult <= 45) {
                          str_age="41yrs-45yrs";
                      }else if (selectYearSecondAdult >= 46 && selectYearSecondAdult <= 50) {
                          str_age="46yrs-50yrs";
                      }else if (selectYearSecondAdult >= 51 && selectYearSecondAdult <= 55) {
                          str_age="51yrs-55yrs";
                      }else if (selectYearSecondAdult >= 56 && selectYearSecondAdult <= 60) {
                          str_age="56yrs-60yrs";
                      }else if (selectYearSecondAdult >= 61 && selectYearSecondAdult <= 65) {
                          str_age="61yrs-65yrs";
                      }else if (selectYearSecondAdult >= 66 && selectYearSecondAdult <= 70) {
                          str_age="66yrs-70yrs";
                      } else if (selectYearSecondAdult >= 71 && selectYearSecondAdult <= 75){
                          str_age="71yrs-75yrs";
                      }
                  }
                }
                SpouseAgeEditText.setText(strSpouseAgeEditText);
            }
            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showFirstSonCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strFirstSonAgeEditText=dateFormatter.format(newDate.getTime());
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
                LocalDate start = LocalDate.parse(strFirstSonAgeEditText,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild1= Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strFirstSonAgeEditText != null) {
                if (daysLeftChild1 < 91 || (selectFirstYearChild > 25)) {
                    Toast.makeText(PolicyTypeCHI.this, "Son Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strFirstSonAgeEditText="Select Dob";
                    FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                }else{
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
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSecondSonAgeEditText=dateFormatter.format(newDate.getTime());
            SecondSonAgeEditText.setText(strSecondSonAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strSecondSonAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectSecSonChild = period.getYears();
                    Log.e("selectFirstYearChild", String.valueOf(selectSecSonChild));
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strSecondSonAgeEditText,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild2= Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strSecondSonAgeEditText != null) {
                if (daysLeftChild2 < 91 || (selectSecSonChild > 25)) {
                    Toast.makeText(PolicyTypeCHI.this, "Second Son Age greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strSecondSonAgeEditText="Select Dob";
                    SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                }else{
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
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strThirdSonAgeEditText=dateFormatter.format(newDate.getTime());
            ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strThirdSonAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectThirdSonChild = period.getYears();
                    Log.e("selectFirstYearChild", String.valueOf(selectThirdSonChild));
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strThirdSonAgeEditText,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild3= Integer.parseInt(days);
                Log.e("daysLeftChild3", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strThirdSonAgeEditText != null) {
                if (daysLeftChild3 < 91 || (selectThirdSonChild > 25)) {
                    Toast.makeText(PolicyTypeCHI.this, "Third Son Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strThirdSonAgeEditText="Select Dob";
                    ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                }else{
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
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strFourSonAgeEditText=dateFormatter.format(newDate.getTime());
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
                LocalDate start = LocalDate.parse(strFourSonAgeEditText,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild4= Integer.parseInt(days);
                Log.e("daysLeftChild4", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strFourSonAgeEditText != null) {
                if (daysLeftChild4 < 91|| (selectYearChildFour > 25)) {
                    Toast.makeText(PolicyTypeCHI.this, "Fourth Son Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strFourSonAgeEditText="Select Dob";
                    FourSonAgeEditText.setText(strFourSonAgeEditText);
                }else{
                    FourSonAgeEditText.setText(strFourSonAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showFirstDaughterCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strFirstDaughterAgeEditText=dateFormatter.format(newDate.getTime());
            FirstDaughterAgeEditText.setText(strFirstDaughterAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strFirstDaughterAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    FirstDaughterYearChild = period.getYears();
                    Log.e("selectFirstYearChild", String.valueOf(FirstDaughterYearChild));
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strFirstDaughterAgeEditText,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftDaughter1= Integer.parseInt(days);
                Log.e("daysLeftDaughter1", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strFirstDaughterAgeEditText != null) {
                if (daysLeftDaughter1 == 0 || (FirstDaughterYearChild > 25)) {
                    Toast.makeText(PolicyTypeCHI.this, "1'st Daughter Age must be 1 day to 25 Years", Toast.LENGTH_SHORT).show();
                    strFirstDaughterAgeEditText="Select Dob";
                    FirstDaughterAgeEditText.setText(strFirstDaughterAgeEditText);
                }else{
                    FirstDaughterAgeEditText.setText(strFirstDaughterAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showSecondDaughterCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSecondDaughterAgeEditText=dateFormatter.format(newDate.getTime());
            SecondDaughterAgeEditText.setText(strSecondDaughterAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strSecondDaughterAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    SecondDaughterYearChild = period.getYears();
                    Log.e("SecondDaughterYearChild", String.valueOf(SecondDaughterYearChild));
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strSecondDaughterAgeEditText,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftDaughter2= Integer.parseInt(days);
                Log.e("daysLeftDaughter2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strSecondDaughterAgeEditText != null) {
                if (daysLeftDaughter2 == 0 || (SecondDaughterYearChild > 25)) {
                    Toast.makeText(PolicyTypeCHI.this, "2nd Daughter Age must be 1 day to 25 Years", Toast.LENGTH_SHORT).show();
                    strSecondDaughterAgeEditText="Select Dob";
                    SecondDaughterAgeEditText.setText(strSecondDaughterAgeEditText);
                }else{
                    SecondDaughterAgeEditText.setText(strSecondDaughterAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showThirdDaughterCalender(){
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strThirdDaughterAgeEditText=dateFormatter.format(newDate.getTime());
            ThirdDaughterAgeEditText.setText(strThirdDaughterAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strThirdDaughterAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    ThirdDaughterYearChild = period.getYears();
                    Log.e("ThirdDaughterYearChild", String.valueOf(ThirdDaughterYearChild));
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strThirdDaughterAgeEditText,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftDaughter3= Integer.parseInt(days);
                Log.e("daysLeftDaughter3", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strThirdDaughterAgeEditText != null) {
                if (daysLeftDaughter3 == 0 || (ThirdDaughterYearChild > 25)) {
                    Toast.makeText(PolicyTypeCHI.this, "3rd Daughter Age must be 1 day to 25 Years", Toast.LENGTH_SHORT).show();
                    strThirdDaughterAgeEditText="Select Dob";
                    ThirdDaughterAgeEditText.setText(strThirdDaughterAgeEditText);
                }else{
                    ThirdDaughterAgeEditText.setText(strThirdDaughterAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showFourDaughterCalender(){
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strFourDaughterAgeEditText=dateFormatter.format(newDate.getTime());
            FourDaughterAgeEditText.setText(strFourDaughterAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strFourDaughterAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    FourDaughterYearChild = period.getYears();
                    Log.e("FourDaughterYearChild", String.valueOf(FourDaughterYearChild));
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strFourDaughterAgeEditText,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftDaughter4= Integer.parseInt(days);
                Log.e("daysLeftDaughter4", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strFourDaughterAgeEditText != null) {
                if (daysLeftDaughter4 == 0 || (FourDaughterYearChild > 25)) {
                    Toast.makeText(PolicyTypeCHI.this, "4th Daughter Age must be 1 day to 25 Years", Toast.LENGTH_SHORT).show();
                    strFourDaughterAgeEditText="Select Dob";
                    FourDaughterAgeEditText.setText(strFourDaughterAgeEditText);
                }else{
                    FourDaughterAgeEditText.setText(strFourDaughterAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showMotherCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strMotherAgeEditText=dateFormatter.format(newDate.getTime());
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
            if (selectYearMotherAdult < 36 || (selectYearMotherAdult > 75)) {
                Toast.makeText(PolicyTypeCHI.this, "Mother Age must be between 36 to 75 years ", Toast.LENGTH_SHORT).show();
                strMotherAgeEditText="Select Dob";
                MotherAgeEditText.setText(strMotherAgeEditText);
            }else{
                if (str_policyType_spinner.equals("Individual")){
                    if (selectYearMotherAdult >= 18 && (selectYearMotherAdult <= 25)) {
                        str_age="18yrs-25yrs";
                    }else if (selectYearMotherAdult >= 26 && selectYearMotherAdult <= 30) {
                        str_age="26yrs-30yrs";
                    }else if (selectYearMotherAdult >= 31 && selectYearMotherAdult <= 35) {
                        str_age="31yrs-35yrs";
                    }else if (selectYearMotherAdult >= 36 && selectYearMotherAdult <= 40) {
                        str_age="36yrs-40yrs";
                    }else if (selectYearMotherAdult >= 41 && selectYearMotherAdult <= 45) {
                        str_age="41yrs-45yrs";
                    }else if (selectYearMotherAdult >= 46 && selectYearMotherAdult <= 50) {
                        str_age="46yrs-50yrs";
                    }else if (selectYearMotherAdult >= 51 && selectYearMotherAdult <= 55) {
                        str_age="51yrs-55yrs";
                    }else if (selectYearMotherAdult >= 56 && selectYearMotherAdult <= 60) {
                        str_age="56yrs-60yrs";
                    }else if (selectYearMotherAdult >= 61 && selectYearMotherAdult <= 65) {
                        str_age="61yrs-65yrs";
                    }else if (selectYearMotherAdult >= 66 && selectYearMotherAdult <= 70) {
                        str_age="66yrs-70yrs";
                    } else if (selectYearMotherAdult >= 71 && selectYearMotherAdult <= 75){
                        str_age="71yrs-75yrs";
                    }

                }else{
                    if (!strCheckBoxSelf.equals("Checked")) {
                        if (selectYearMotherAdult >= 18 && (selectYearMotherAdult <= 25)) {
                            str_age="18yrs-25yrs";
                        }else if (selectYearMotherAdult >= 26 && selectYearMotherAdult <= 30) {
                            str_age="26yrs-30yrs";
                        }else if (selectYearMotherAdult >= 31 && selectYearMotherAdult <= 35) {
                            str_age="31yrs-35yrs";
                        }else if (selectYearMotherAdult >= 36 && selectYearMotherAdult <= 40) {
                            str_age="36yrs-40yrs";
                        }else if (selectYearMotherAdult >= 41 && selectYearMotherAdult <= 45) {
                            str_age="41yrs-45yrs";
                        }else if (selectYearMotherAdult >= 46 && selectYearMotherAdult <= 50) {
                            str_age="46yrs-50yrs";
                        }else if (selectYearMotherAdult >= 51 && selectYearMotherAdult <= 55) {
                            str_age="51yrs-55yrs";
                        }else if (selectYearMotherAdult >= 56 && selectYearMotherAdult <= 60) {
                            str_age="56yrs-60yrs";
                        }else if (selectYearMotherAdult >= 61 && selectYearMotherAdult <= 65) {
                            str_age="61yrs-65yrs";
                        }else if (selectYearMotherAdult >= 66 && selectYearMotherAdult <= 70) {
                            str_age="66yrs-70yrs";
                        } else if (selectYearMotherAdult >= 71 && selectYearMotherAdult <= 75){
                            str_age="71yrs-75yrs";
                        }
                    }
                }
                MotherAgeEditText.setText(strMotherAgeEditText);
            }



        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    public void showFatherCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
            if (selectYearFatherAdult < 36 || (selectYearFatherAdult > 75)) {
                Toast.makeText(PolicyTypeCHI.this, "Father Age must be between 36 to 75 years ", Toast.LENGTH_SHORT).show();
                strFatherAgeEditText="Select Dob";
                FatherAgeEditText.setText(strFatherAgeEditText);
            }else{
                if (str_policyType_spinner.equals("Individual")){
                    if (selectYearFatherAdult >= 18 && (selectYearFatherAdult <= 25)) {
                        str_age="18yrs-25yrs";
                    }else if (selectYearFatherAdult >= 26 && selectYearFatherAdult <= 30) {
                        str_age="26yrs-30yrs";
                    }else if (selectYearFatherAdult >= 31 && selectYearFatherAdult <= 35) {
                        str_age="31yrs-35yrs";
                    }else if (selectYearFatherAdult >= 36 && selectYearFatherAdult <= 40) {
                        str_age="36yrs-40yrs";
                    }else if (selectYearFatherAdult >= 41 && selectYearFatherAdult <= 45) {
                        str_age="41yrs-45yrs";
                    }else if (selectYearFatherAdult >= 46 && selectYearFatherAdult <= 50) {
                        str_age="46yrs-50yrs";
                    }else if (selectYearFatherAdult >= 51 && selectYearFatherAdult <= 55) {
                        str_age="51yrs-55yrs";
                    }else if (selectYearFatherAdult >= 56 && selectYearFatherAdult <= 60) {
                        str_age="56yrs-60yrs";
                    }else if (selectYearFatherAdult >= 61 && selectYearFatherAdult <= 65) {
                        str_age="61yrs-65yrs";
                    }else if (selectYearFatherAdult >= 66 && selectYearFatherAdult <= 70) {
                        str_age="66yrs-70yrs";
                    } else if (selectYearFatherAdult >= 71 && selectYearFatherAdult <= 75){
                        str_age="71yrs-75yrs";
                    }
                }
                else{
                    if (!strCheckBoxSelf.equals("Checked")) {
                        if (selectYearFatherAdult >= 18 && (selectYearFatherAdult <= 25)) {
                            str_age="18yrs-25yrs";
                        }else if (selectYearFatherAdult >= 26 && selectYearFatherAdult <= 30) {
                            str_age="26yrs-30yrs";
                        }else if (selectYearFatherAdult >= 31 && selectYearFatherAdult <= 35) {
                            str_age="31yrs-35yrs";
                        }else if (selectYearFatherAdult >= 36 && selectYearFatherAdult <= 40) {
                            str_age="36yrs-40yrs";
                        }else if (selectYearFatherAdult >= 41 && selectYearFatherAdult <= 45) {
                            str_age="41yrs-45yrs";
                        }else if (selectYearFatherAdult >= 46 && selectYearFatherAdult <= 50) {
                            str_age="46yrs-50yrs";
                        }else if (selectYearFatherAdult >= 51 && selectYearFatherAdult <= 55) {
                            str_age="51yrs-55yrs";
                        }else if (selectYearFatherAdult >= 56 && selectYearFatherAdult <= 60) {
                            str_age="56yrs-60yrs";
                        }else if (selectYearFatherAdult >= 61 && selectYearFatherAdult <= 65) {
                            str_age="61yrs-65yrs";
                        }else if (selectYearFatherAdult >= 66 && selectYearFatherAdult <= 70) {
                            str_age="66yrs-70yrs";
                        } else if (selectYearFatherAdult >= 71 && selectYearFatherAdult <= 75){
                            str_age="71yrs-75yrs";
                        }
                    }
                }
                FatherAgeEditText.setText(strFatherAgeEditText);
            }



        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    public void showMotherInLawCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strMotherLawAgeEditText=dateFormatter.format(newDate.getTime());
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
            if (selectMotherLawAdult < 36 || (selectMotherLawAdult > 75)) {
                Toast.makeText(PolicyTypeCHI.this, "Mother-In-Law Age must be between 36 to 75 years ", Toast.LENGTH_SHORT).show();
                strMotherLawAgeEditText="Select Dob";
                MotherLawAgeEditText.setText(strMotherLawAgeEditText);
            }else{
                if (str_policyType_spinner.equals("Individual")){
                    if (selectMotherLawAdult >= 18 && (selectMotherLawAdult <= 25)) {
                        str_age="18yrs-25yrs";
                    }else if (selectMotherLawAdult >= 26 && selectMotherLawAdult <= 30) {
                        str_age="26yrs-30yrs";
                    }else if (selectMotherLawAdult >= 31 && selectMotherLawAdult <= 35) {
                        str_age="31yrs-35yrs";
                    }else if (selectMotherLawAdult >= 36 && selectMotherLawAdult <= 40) {
                        str_age="36yrs-40yrs";
                    }else if (selectMotherLawAdult >= 41 && selectMotherLawAdult <= 45) {
                        str_age="41yrs-45yrs";
                    }else if (selectMotherLawAdult >= 46 && selectMotherLawAdult <= 50) {
                        str_age="46yrs-50yrs";
                    }else if (selectMotherLawAdult >= 51 && selectMotherLawAdult <= 55) {
                        str_age="51yrs-55yrs";
                    }else if (selectMotherLawAdult >= 56 && selectMotherLawAdult <= 60) {
                        str_age="56yrs-60yrs";
                    }else if (selectMotherLawAdult >= 61 && selectMotherLawAdult <= 65) {
                        str_age="61yrs-65yrs";
                    }else if (selectMotherLawAdult >= 66 && selectMotherLawAdult <= 70) {
                        str_age="66yrs-70yrs";
                    } else if (selectMotherLawAdult >= 71 && selectMotherLawAdult <= 75){
                        str_age="71yrs-75yrs";
                    }
                }
                else{
                    if (!strCheckBoxSelf.equals("Checked")) {
                        if (selectMotherLawAdult >= 18 && (selectMotherLawAdult <= 25)) {
                            str_age="18yrs-25yrs";
                        }else if (selectMotherLawAdult >= 26 && selectMotherLawAdult <= 30) {
                            str_age="26yrs-30yrs";
                        }else if (selectMotherLawAdult >= 31 && selectMotherLawAdult <= 35) {
                            str_age="31yrs-35yrs";
                        }else if (selectMotherLawAdult >= 36 && selectMotherLawAdult <= 40) {
                            str_age="36yrs-40yrs";
                        }else if (selectMotherLawAdult >= 41 && selectMotherLawAdult <= 45) {
                            str_age="41yrs-45yrs";
                        }else if (selectMotherLawAdult >= 46 && selectMotherLawAdult <= 50) {
                            str_age="46yrs-50yrs";
                        }else if (selectMotherLawAdult >= 51 && selectMotherLawAdult <= 55) {
                            str_age="51yrs-55yrs";
                        }else if (selectMotherLawAdult >= 56 && selectMotherLawAdult <= 60) {
                            str_age="56yrs-60yrs";
                        }else if (selectMotherLawAdult >= 61 && selectMotherLawAdult <= 65) {
                            str_age="61yrs-65yrs";
                        }else if (selectMotherLawAdult >= 66 && selectMotherLawAdult <= 70) {
                            str_age="66yrs-70yrs";
                        } else if (selectMotherLawAdult >= 71 && selectMotherLawAdult <= 75){
                            str_age="71yrs-75yrs";
                        }
                    }
                }
                MotherLawAgeEditText.setText(strMotherLawAgeEditText);
            }



        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    public void showFatherInLawCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(PolicyTypeCHI.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strFatherLawAgeEditText=dateFormatter.format(newDate.getTime());
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
            if (selectFatherLawAdult < 36 || (selectFatherLawAdult > 75)) {
                Toast.makeText(PolicyTypeCHI.this, "Father-In-Law Age must be between 36 to 75 years ", Toast.LENGTH_SHORT).show();
                strFatherLawAgeEditText="Select Dob";
                FatherLawAgeEditText.setText(strFatherLawAgeEditText);
            }else{
                if (str_policyType_spinner.equals("Individual")){
                    if (selectFatherLawAdult >= 18 && (selectFatherLawAdult <= 25)) {
                        str_age="18yrs-25yrs";
                    }else if (selectFatherLawAdult >= 26 && selectFatherLawAdult <= 30) {
                        str_age="26yrs-30yrs";
                    }else if (selectFatherLawAdult >= 31 && selectFatherLawAdult <= 35) {
                        str_age="31yrs-35yrs";
                    }else if (selectFatherLawAdult >= 36 && selectFatherLawAdult <= 40) {
                        str_age="36yrs-40yrs";
                    }else if (selectFatherLawAdult >= 41 && selectFatherLawAdult <= 45) {
                        str_age="41yrs-45yrs";
                    }else if (selectFatherLawAdult >= 46 && selectFatherLawAdult <= 50) {
                        str_age="46yrs-50yrs";
                    }else if (selectFatherLawAdult >= 51 && selectFatherLawAdult <= 55) {
                        str_age="51yrs-55yrs";
                    }else if (selectFatherLawAdult >= 56 && selectFatherLawAdult <= 60) {
                        str_age="56yrs-60yrs";
                    }else if (selectFatherLawAdult >= 61 && selectFatherLawAdult <= 65) {
                        str_age="61yrs-65yrs";
                    }else if (selectFatherLawAdult >= 66 && selectFatherLawAdult <= 70) {
                        str_age="66yrs-70yrs";
                    } else if (selectFatherLawAdult >= 71 && selectFatherLawAdult <= 75){
                        str_age="71yrs-75yrs";
                    }
                }
                else{
                    if (!strCheckBoxSelf.equals("Checked")) {
                        if (selectFatherLawAdult >= 18 && (selectFatherLawAdult <= 25)) {
                            str_age="18yrs-25yrs";
                        }else if (selectFatherLawAdult >= 26 && selectFatherLawAdult <= 30) {
                            str_age="26yrs-30yrs";
                        }else if (selectFatherLawAdult >= 31 && selectFatherLawAdult <= 35) {
                            str_age="31yrs-35yrs";
                        }else if (selectFatherLawAdult >= 36 && selectFatherLawAdult <= 40) {
                            str_age="36yrs-40yrs";
                        }else if (selectFatherLawAdult >= 41 && selectFatherLawAdult <= 45) {
                            str_age="41yrs-45yrs";
                        }else if (selectFatherLawAdult >= 46 && selectFatherLawAdult <= 50) {
                            str_age="46yrs-50yrs";
                        }else if (selectFatherLawAdult >= 51 && selectFatherLawAdult <= 55) {
                            str_age="51yrs-55yrs";
                        }else if (selectFatherLawAdult >= 56 && selectFatherLawAdult <= 60) {
                            str_age="56yrs-60yrs";
                        }else if (selectFatherLawAdult >= 61 && selectFatherLawAdult <= 65) {
                            str_age="61yrs-65yrs";
                        }else if (selectFatherLawAdult >= 66 && selectFatherLawAdult <= 70) {
                            str_age="66yrs-70yrs";
                        } else if (selectFatherLawAdult >= 71 && selectFatherLawAdult <= 75){
                            str_age="71yrs-75yrs";
                        }
                    }
                }
                FatherLawAgeEditText.setText(strFatherLawAgeEditText);
            }



        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
}