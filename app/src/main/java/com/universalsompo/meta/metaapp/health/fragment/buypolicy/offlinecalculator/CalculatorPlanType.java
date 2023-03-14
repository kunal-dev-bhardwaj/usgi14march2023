package com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator;

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
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHIAddOns;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PersonalInformationCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PolicyTypeCHI;
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

public class CalculatorPlanType extends AppCompatActivity {
    LinearLayout GenderDropDown,policyTypeDropDown,FirstAdultLiner,FamilyTypeDropDown,TextLiner,FloaterLiner,SelfAgeLiner,SpouseAgeLiner,mainSonLiner,SonLiner,LinerSonFirst,FirstSonAgeLiner,SecondSonAgeLiner,LinerSecond,ThirdSonLiner,ThirdSonAgeLiner,FourthLiner,FourSonAgeLiner,mainDaughterLiner,DaughterLiner,LinerFirstDaughter,LinerSecondDaughter,LinerThirdDaughter,LinerFourthDaughter,mainMotherLiner,MotherAgeLiner,mainFatherLiner,FatherAgeLiner,mainMotherInLawLiner,MotherLawAgeLiner,mainFatherInLaw,FatherLawAgeLiner;
    EditText GenderEditSpinner,policyType_spinner,FamilyTypeSpinner,SelfAgeEditText,SpouseAgeEditText,FirstSonAgeEditText,SecondSonAgeEditText,ThirdSonAgeEditText,FourSonAgeEditText,FirstDaughterAgeEditText,SecondDaughterAgeEditText,ThirdDaughterAgeEditText,FourDaughterAgeEditText,MotherAgeEditText,FatherAgeEditText,MotherLawAgeEditText,FatherLawAgeEditText;
    String strGenderSpinner="",strFor="",str_policyType_spinner="",str_IndividualTypeEdit="",strSelfAgeEditText="",selfAge="",strCheckBoxSelf="",SpouseAge="",strCheckBoxSpouse="",strSpouseAgeEditText="",ChildOneAge="",strCheckBoxSon="",strFirstDob="",strFirstSonAgeEditText="",ChildTwoAge="",strSecondSonAgeEditText="",strSecondDob="",ChildThirdAge="",strThirdSonAgeEditText="",strThirdDob="",ChildFourAge="",strFourSonAgeEditText="",strFirstDaughterAgeEditText="",strSecondDaughterAgeEditText="",strThirdDaughterAgeEditText="",strFourDaughterAgeEditText="",strMotherAgeEditText="",MotherAge="",strCheckBoxMother="",FatherAge="",strFatherAgeEditText="",MotherLawAge="",strCheckBoxFather="",strMotherLawAgeEditText="",strCheckBoxMotherLaw="",FatherLawAge="",strFatherLawAgeEditText="",strCheckBoxFatherLaw="";
    String str_edit_dob3String="",today="",strGenderEditSpinner="";
    CheckBox CheckBoxSelf,CheckBoxSpouse,CheckBoxSon,CheckBoxDaughter,CheckBoxMother,CheckBoxFather,CheckBoxMotherLaw,CheckBoxFatherLaw;
    Button btnNext,minusSonBtn,addSonBtn,minusDaughterBtn,addDaughterBtn;
    TextView SonCounterText,DaughterTextCounter,SelfAgeTxt,SpouseAgeTxt,FirstSonAgeTxt,SecondSonAgeTxt,ThirdSonAgeTxt,FourSonAgeTxt,MotherAgeTxt,FatherAgeTxt,MotherLawAgeTxt,FatherLawAgeTxt;
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
    int selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectFirstYearChild,daysLeftChild1,selectSecSonChild,daysLeftChild2,daysLeftChild3,selectThirdSonChild,daysLeftChild4,selectYearChildFour,FirstDaughterYearChild,daysLeftDaughter1,SecondDaughterYearChild,daysLeftDaughter2,ThirdDaughterYearChild,daysLeftDaughter3,FourDaughterYearChild,daysLeftDaughter4,selectYearMotherAdult,selectYearFatherAdult,selectMotherLawAdult,selectFatherLawAdult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_plan_type);
        getWindow().setStatusBarColor(ContextCompat.getColor(CalculatorPlanType.this, R.color.colorPrimaryDark));
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        strGenderSpinner = getIntent().getStringExtra("strGenderSpinner");
        str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
        strFor = getIntent().getStringExtra("strFor");

        initView();
    }
    private void initView() {
        //linerLayout
        SummeryBack=findViewById(R.id.SummeryBack);
        policyTypeDropDown=findViewById(R.id.policyTypeDropDown);
        GenderDropDown=findViewById(R.id.GenderDropDown);
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
        GenderEditSpinner=findViewById(R.id.GenderEditSpinner);
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
        SelfAgeTxt=findViewById(R.id.SelfAgeTxt);
        SpouseAgeTxt=findViewById(R.id.SpouseAgeTxt);
        FirstSonAgeTxt=findViewById(R.id.FirstSonAgeTxt);
        SecondSonAgeTxt=findViewById(R.id.SecondSonAgeTxt);
        ThirdSonAgeTxt=findViewById(R.id.ThirdSonAgeTxt);
        FourSonAgeTxt=findViewById(R.id.FourSonAgeTxt);
        MotherAgeTxt=findViewById(R.id.MotherAgeTxt);
        FatherAgeTxt=findViewById(R.id.FatherAgeTxt);
        MotherLawAgeTxt=findViewById(R.id.MotherLawAgeTxt);
        FatherLawAgeTxt=findViewById(R.id.FatherLawAgeTxt);

        if (strFor.equals("0")){
            str_policyType_spinner="Select Policy Type";
            policyType_spinner.setText(str_policyType_spinner);
            strCheckBoxSpouse="UnChecked";
            strCheckBoxSon="UnChecked";
            strCheckBoxMother="UnChecked";
            strCheckBoxFather="UnChecked";
            strCheckBoxMotherLaw="UnChecked";
            strCheckBoxFatherLaw="UnChecked";
        }else{
            policyType_spinner.setText(str_policyType_spinner);
            if (str_policyType_spinner.equals("Individual")){
                str_IndividualTypeEdit="1 Adult";
                FamilyTypeSpinner.setText(str_IndividualTypeEdit);
                FirstAdultLiner.setVisibility(View.VISIBLE);
                TextLiner.setVisibility(View.GONE);
                FloaterLiner.setVisibility(View.GONE);
            }else {
                str_IndividualTypeEdit="2 Adult";
                FamilyTypeSpinner.setText(str_IndividualTypeEdit);
                TextLiner.setVisibility(View.VISIBLE);
                FirstAdultLiner.setVisibility(View.VISIBLE);
                FloaterLiner.setVisibility(View.VISIBLE);
            }
        }


        strGenderEditSpinner="Select Gender";
        GenderEditSpinner.setText(strGenderEditSpinner);

        SummeryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CalculatorPlanType.this, MainActivityHealth.class);
                startActivity(intent);
                finish();
            }
        });


        policyTypeDropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(CalculatorPlanType.this);
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
                            FloaterLiner.setVisibility(View.GONE);
                        }else {
                            str_IndividualTypeEdit="2 Adult";
                            FamilyTypeSpinner.setText(str_IndividualTypeEdit);
                            TextLiner.setVisibility(View.VISIBLE);
                            FirstAdultLiner.setVisibility(View.VISIBLE);
                            FloaterLiner.setVisibility(View.VISIBLE);
                        }
                    }
                });
                singlePicker.show();
            }
        });
        GenderDropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(CalculatorPlanType.this);
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
                        strGenderEditSpinner=items1.get(options1);
                        GenderEditSpinner.setText(strGenderEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });

        FamilyTypeDropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(CalculatorPlanType.this);
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
                strSelfAgeEditText="Select Dob";
                SelfAgeEditText.setText(strSelfAgeEditText);
            }
        });

        SelfAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    showFirstCalender();
                }
              /*  MyOptionsPickerView singlePicker = new MyOptionsPickerView(CalculatorPlanType.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("18");items1.add("19");items1.add("20");items1.add("21");items1.add("22");items1.add("23");items1.add("24");items1.add("25");items1.add("26");items1.add("27");items1.add("28");items1.add("29");items1.add("30");items1.add("31");items1.add("32");items1.add("33");
                items1.add("34");items1.add("35");items1.add("36");items1.add("37");items1.add("38");items1.add("39");items1.add("40");items1.add("41");items1.add("42");items1.add("43");items1.add("44");items1.add("45");items1.add("46");items1.add("47");items1.add("48");items1.add("49");items1.add("50");
                items1.add("51");items1.add("52");items1.add("53");items1.add("54");items1.add("55");items1.add("56");items1.add("57");items1.add("58");items1.add("59");items1.add("60");items1.add("61");items1.add("62");items1.add("63");items1.add("64");items1.add("65");items1.add("66");items1.add("67");
                items1.add("68");items1.add("69");items1.add("70");items1.add("71");items1.add("72");items1.add("73");items1.add("74");items1.add("75");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSelfAgeEditText=items1.get(options1);
                        SelfAgeEditText.setText(strSelfAgeEditText);
                    }
                });
                singlePicker.show();

               */
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
                    Toast.makeText(CalculatorPlanType.this, "Can't Select any Son", Toast.LENGTH_SHORT).show();
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

              /*  MyOptionsPickerView singlePicker = new MyOptionsPickerView(CalculatorPlanType.this);
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
                    Toast.makeText(CalculatorPlanType.this, "Can't Select any Daughter", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(CalculatorPlanType.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                }else if (CheckBoxMother.isChecked()&&CheckBoxFather.isChecked()){
                    mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                    mainMotherInLawLiner.setClickable(false);
                    mainFatherInLaw.setClickable(false);
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    MotherAgeLiner.setVisibility(View.VISIBLE);
                    strMotherAgeEditText="Select Dob";
                    MotherAgeEditText.setText(strMotherAgeEditText);
                    strCheckBoxMother="Checked";
                }else {
                     if (isChecked){
                    FamilyTypeCounter++;
                    MotherAgeLiner.setVisibility(View.VISIBLE);
                    strCheckBoxMother="Checked";
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
                    Toast.makeText(CalculatorPlanType.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                }else if (CheckBoxMother.isChecked()&&CheckBoxFather.isChecked()){
                    mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                    mainMotherInLawLiner.setClickable(false);
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    FatherAgeLiner.setVisibility(View.VISIBLE);
                    strFatherAgeEditText="Select Dob";
                    strCheckBoxFather="Checked";
                    FatherAgeEditText.setText(strFatherAgeEditText);
                }else if (isChecked){
                    FamilyTypeCounter++;
                    FatherAgeLiner.setVisibility(View.VISIBLE);
                    mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherInLaw.setClickable(true);
                    mainMotherInLawLiner.setClickable(true);
                    strFatherAgeEditText="Select Dob";
                    FatherAgeEditText.setText(strFatherAgeEditText);
                     strCheckBoxFather="Checked";
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
                    Toast.makeText(CalculatorPlanType.this, "Can't Select Mother-In-Law & Father-In-Law", Toast.LENGTH_SHORT).show();
                }else if (CheckBoxMotherLaw.isChecked()&&CheckBoxFatherLaw.isChecked()){
                     mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                     mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                     mainMotherLiner.setClickable(false);
                     mainFatherLiner.setClickable(false);
                     CheckBoxMother.setChecked(false);
                     CheckBoxFather.setChecked(false);
                    MotherLawAgeLiner.setVisibility(View.VISIBLE);
                    strMotherLawAgeEditText = "Select Dob";
                    strCheckBoxMotherLaw="Checked";
                    MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                }else if (isChecked) {
                    FamilyTypeCounter++;
                     MotherLawAgeLiner.setVisibility(View.VISIBLE);
                    strMotherLawAgeEditText = "Select Dob";
                    MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                    mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainMotherLiner.setClickable(true);
                    mainFatherLiner.setClickable(true);
                    strCheckBoxMotherLaw="Checked";
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
                    Toast.makeText(CalculatorPlanType.this, "Can't Select Mother-In-Law & Father-In-Law", Toast.LENGTH_SHORT).show();
                }else if (CheckBoxMotherLaw.isChecked()&&CheckBoxFatherLaw.isChecked()){
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainMotherLiner.setClickable(false);
                    mainFatherLiner.setClickable(false);
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    FatherLawAgeLiner.setVisibility(View.VISIBLE);
                    strFatherLawAgeEditText="Select Dob";
                    FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                    strCheckBoxFatherLaw="Checked";
                }else if (isChecked){
                    FamilyTypeCounter++;
                    FatherLawAgeLiner.setVisibility(View.VISIBLE);
                    strFatherLawAgeEditText="Select Dob";
                    FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                    mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainMotherLiner.setClickable(true);
                    mainFatherLiner.setClickable(true);
                    strCheckBoxFatherLaw="Checked";
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
                if (str_policyType_spinner.equals("Select Policy Type")){
                    Toast.makeText(CalculatorPlanType.this, "Please Select Policy Type", Toast.LENGTH_SHORT).show();
                }else if (strGenderEditSpinner.equals("Select Gender")){
                    Toast.makeText(CalculatorPlanType.this, "Select Gender", Toast.LENGTH_SHORT).show();
                }else{
                    if (str_policyType_spinner.equals("Individual")){
                        if (!CheckBoxSelf.isChecked()){
                            Toast.makeText(CalculatorPlanType.this, "Please Select Self", Toast.LENGTH_SHORT).show();
                        }else if(strSelfAgeEditText.equals("Select Dob")){
                            Toast.makeText(CalculatorPlanType.this, "Enter Self DOB", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent=new Intent(CalculatorPlanType.this,OfflineCHIAddOns.class);
                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                            intent.putExtra("strSelfAgeEditText",strSelfAgeEditText);
                            intent.putExtra("strGenderSpinner",strGenderSpinner);
                            intent.putExtra("strCheckBoxSelf",strCheckBoxSelf);
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
                            intent.putExtra("selectYearAdult", selectYearAdult);
                            intent.putExtra("selectYearSecondAdult", selectYearSecondAdult);
                            intent.putExtra("strGenderEditSpinner", strGenderEditSpinner);
                            intent.putExtra("selectYearMotherAdult",selectYearMotherAdult);
                            intent.putExtra("selectYearFatherAdult",selectYearFatherAdult);
                            intent.putExtra("selectMotherLawAdult",selectMotherLawAdult);
                            intent.putExtra("selectFatherLawAdult",selectFatherLawAdult);
                            intent.putExtra("FamilyTypeCounter",FamilyTypeCounter);
                            intent.putExtra("strFor","0");
                            startActivity(intent);
                            finish();
                        }
                    }else {
                        if (!(CheckBoxSelf.isChecked()||CheckBoxSpouse.isChecked()||CheckBoxSon.isChecked()||CheckBoxDaughter.isChecked()||CheckBoxMother.isChecked()||CheckBoxFather.isChecked()||CheckBoxMotherLaw.isChecked()||CheckBoxFatherLaw.isChecked())){
                            Toast.makeText(CalculatorPlanType.this, "Please Select Any Insure", Toast.LENGTH_SHORT).show();
                        }else if (FamilyTypeCounter+mCounter<=1){
                            Toast.makeText(CalculatorPlanType.this, "Please Select Any other Insure", Toast.LENGTH_SHORT).show();
                        }else if (FamilyTypeCounter+mCounter+DaughterCounter>6){
                            Toast.makeText(CalculatorPlanType.this, "You can select only 6 members", Toast.LENGTH_SHORT).show();
                        }else if (!CheckBoxSelf.isChecked()){
                            Toast.makeText(CalculatorPlanType.this, "Please Select Self", Toast.LENGTH_SHORT).show();
                        }else if(strSelfAgeEditText.equals("Select Dob")){
                            Toast.makeText(CalculatorPlanType.this, "Enter Self DOB", Toast.LENGTH_SHORT).show();
                        }else if (CheckBoxSpouse.isChecked()&&strSpouseAgeEditText.equals("Select Dob")){
                            Toast.makeText(CalculatorPlanType.this, "Enter Spouse DOB", Toast.LENGTH_SHORT).show();
                        }else if (CheckBoxMother.isChecked()&&strMotherAgeEditText.equals("Select Dob")){
                            Toast.makeText(CalculatorPlanType.this, "Enter Mother DOB", Toast.LENGTH_SHORT).show();
                        }else if (CheckBoxFather.isChecked()&&strFatherAgeEditText.equals("Select Dob")){
                            Toast.makeText(CalculatorPlanType.this, "Enter Father DOB", Toast.LENGTH_SHORT).show();
                        }else if (CheckBoxMotherLaw.isChecked()&&strMotherLawAgeEditText.equals("Select Dob")){
                            Toast.makeText(CalculatorPlanType.this, "Enter Mother-In-Law DOB", Toast.LENGTH_SHORT).show();
                        }else if (CheckBoxFatherLaw.isChecked()&&strFatherLawAgeEditText.equals("Select Dob")){
                            Toast.makeText(CalculatorPlanType.this, "Enter Father-In-Law DOB", Toast.LENGTH_SHORT).show();
                        }else if (CheckBoxSon.isChecked()){
                            if (mCounter==1&&strFirstSonAgeEditText.equals("Select Dob")){
                                Toast.makeText(CalculatorPlanType.this, "Enter First Child DOB", Toast.LENGTH_SHORT).show();
                            }else  if (mCounter==2&&strSecondSonAgeEditText.equals("Select Dob")){
                                Toast.makeText(CalculatorPlanType.this, "Enter Second Child DOB", Toast.LENGTH_SHORT).show();
                            }else  if (mCounter==3&&strThirdSonAgeEditText.equals("Select Dob")){
                                Toast.makeText(CalculatorPlanType.this, "Enter Third Child DOB", Toast.LENGTH_SHORT).show();
                            }else  if (mCounter==4&&strFourSonAgeEditText.equals("Select Dob")){
                                Toast.makeText(CalculatorPlanType.this, "Enter Fourth Child DOB", Toast.LENGTH_SHORT).show();
                            }else{
                                if (CheckBoxSpouse.isChecked()&&strSpouseAgeEditText.equals("Select Dob")){
                                    Toast.makeText(CalculatorPlanType.this, "Enter Spouse DOB", Toast.LENGTH_SHORT).show();
                                }else if (CheckBoxMother.isChecked()&&strMotherAgeEditText.equals("Select Dob")){
                                    Toast.makeText(CalculatorPlanType.this, "Enter Mother DOB", Toast.LENGTH_SHORT).show();
                                }else if (CheckBoxFather.isChecked()&&strFatherAgeEditText.equals("Select Dob")){
                                    Toast.makeText(CalculatorPlanType.this, "Enter Father DOB", Toast.LENGTH_SHORT).show();
                                }else if (CheckBoxMotherLaw.isChecked()&&strMotherLawAgeEditText.equals("Select Dob")){
                                    Toast.makeText(CalculatorPlanType.this, "Enter Mother-In-Law DOB", Toast.LENGTH_SHORT).show();
                                }else if (CheckBoxFatherLaw.isChecked()&&strFatherLawAgeEditText.equals("Select Dob")){
                                    Toast.makeText(CalculatorPlanType.this, "Enter Father-In-Law DOB", Toast.LENGTH_SHORT).show();
                                }else{
                                    Intent intent=new Intent(CalculatorPlanType.this, OfflineCHIAddOns.class);
                                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                                    intent.putExtra("strSelfAgeEditText",strSelfAgeEditText);
                                    intent.putExtra("strGenderSpinner",strGenderSpinner);
                                    intent.putExtra("strCheckBoxSelf",strCheckBoxSelf);
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
                                    intent.putExtra("selectYearAdult",selectYearAdult);
                                    intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                                    intent.putExtra("strGenderEditSpinner",strGenderEditSpinner);
                                    intent.putExtra("selectYearMotherAdult",selectYearMotherAdult);
                                    intent.putExtra("selectYearFatherAdult",selectYearFatherAdult);
                                    intent.putExtra("selectMotherLawAdult",selectMotherLawAdult);
                                    intent.putExtra("selectFatherLawAdult",selectFatherLawAdult);
                                    intent.putExtra("FamilyTypeCounter",FamilyTypeCounter);
                                    intent.putExtra("strFor","0");
                                    startActivity(intent);
                                    finish();
                                 }
                            }
                        }
                        else{
                            Intent intent=new Intent(CalculatorPlanType.this, OfflineCHIAddOns.class);
                            intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                            intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                            intent.putExtra("strSelfAgeEditText",strSelfAgeEditText);
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
                            intent.putExtra("selectYearAdult",selectYearAdult);
                            intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                            intent.putExtra("strGenderEditSpinner",strGenderEditSpinner);
                            intent.putExtra("selectYearMotherAdult",selectYearMotherAdult);
                            intent.putExtra("selectYearFatherAdult",selectYearFatherAdult);
                            intent.putExtra("selectMotherLawAdult",selectMotherLawAdult);
                            intent.putExtra("selectFatherLawAdult",selectFatherLawAdult);
                            intent.putExtra("FamilyTypeCounter",FamilyTypeCounter);
                            intent.putExtra("strFor","0");
                            startActivity(intent);
                            finish();
                        }

                    }

                }



            }
        });
    }



    public void showFirstCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    selfAge= String.valueOf(selectYearAdult);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearAdult < 18 || (selectYearAdult > 75)) {
                Toast.makeText(CalculatorPlanType.this, "Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
                strSelfAgeEditText="Select Dob";

                SelfAgeEditText.setText(strSelfAgeEditText);
                SelfAgeTxt.setText("Age: "+"");
            }else{
                SelfAgeEditText.setText(strSelfAgeEditText);
                SelfAgeTxt.setText("Age: "+selfAge);

            }



        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    public void showSpouseCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    SpouseAge= String.valueOf(selectYearSecondAdult);

                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearSecondAdult < 18 || (selectYearSecondAdult > 75)) {
                Toast.makeText(CalculatorPlanType.this, "Spouse Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
                strSpouseAgeEditText="Select Dob";
                SpouseAgeEditText.setText(strSpouseAgeEditText);
                SpouseAgeTxt.setText("Age: "+"");
            }else{
                SpouseAgeEditText.setText(strSpouseAgeEditText);
                SpouseAgeTxt.setText("Age: "+SpouseAge);

            }
            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showFirstSonCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strFirstSonAgeEditText=dateFormatter.format(newDate.getTime());
            FirstSonAgeEditText.setText(strFirstSonAgeEditText);
            String[] strDateOB2=  strFirstSonAgeEditText.split("/");
            String strone = strDateOB2[0];
            String strtwo = strDateOB2[1];
            strFirstDob = strDateOB2[2];
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
                    ChildOneAge= String.valueOf(selectFirstYearChild);
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
                    Toast.makeText(CalculatorPlanType.this, "Son Age must be 91 day to 25 Years", Toast.LENGTH_SHORT).show();
                    strFirstSonAgeEditText="Select Dob";
                    FirstSonAgeTxt.setText("Age: "+"");
                    FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                }else{
                    FirstSonAgeTxt.setText("Age: "+ChildOneAge);
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
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSecondSonAgeEditText=dateFormatter.format(newDate.getTime());
            SecondSonAgeEditText.setText(strSecondSonAgeEditText);
            String[] strDateOB2=  strSecondSonAgeEditText.split("/");
            String strone = strDateOB2[0];
            String strtwo = strDateOB2[1];
            strSecondDob = strDateOB2[2];
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
                    ChildTwoAge= String.valueOf(selectSecSonChild);
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
                if (daysLeftChild2 < 91 &&  (selectSecSonChild > 25)) {
                    Toast.makeText(CalculatorPlanType.this, "Second Son Age must be 91 days to 25 Years", Toast.LENGTH_SHORT).show();
                    strSecondSonAgeEditText="Select Dob";
                    SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                    SecondSonAgeTxt.setText("Age: "+"");
                }else{
                    SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                    SecondSonAgeTxt.setText("Age: "+ChildTwoAge);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showThirdSonCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strThirdSonAgeEditText=dateFormatter.format(newDate.getTime());
            ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
            String[] strDateOB2=  strThirdSonAgeEditText.split("/");
            String strone = strDateOB2[0];
            String strtwo = strDateOB2[1];
            strThirdDob = strDateOB2[2];
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
                    ChildThirdAge= String.valueOf(selectThirdSonChild);
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
                    Toast.makeText(CalculatorPlanType.this, "Third Son Age must be 91 days to 25 Years", Toast.LENGTH_SHORT).show();
                    strThirdSonAgeEditText="Select Dob";
                    ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                    ThirdSonAgeTxt.setText("Age: "+"");
                }else{
                    ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                    ThirdSonAgeTxt.setText("Age: "+ChildThirdAge);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showFourSonCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    ChildFourAge= String.valueOf(selectYearChildFour);
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
                if (daysLeftChild3 < 91 || (selectYearChildFour > 25)) {
                    Toast.makeText(CalculatorPlanType.this, "Fourth Son Age must be 91 days to 25 Years", Toast.LENGTH_SHORT).show();
                    strFourSonAgeEditText="Select Dob";
                    FourSonAgeEditText.setText(strFourSonAgeEditText);
                    FourSonAgeTxt.setText("Age: "+"");
                }else{
                    FourSonAgeEditText.setText(strFourSonAgeEditText);
                    FourSonAgeTxt.setText("Age: "+ChildFourAge);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void showFirstDaughterCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    Toast.makeText(CalculatorPlanType.this, "1'st Daughter Age must be 1 day to 25 Years", Toast.LENGTH_SHORT).show();
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
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    Toast.makeText(CalculatorPlanType.this, "2nd Daughter Age must be 1 day to 25 Years", Toast.LENGTH_SHORT).show();
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
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    Toast.makeText(CalculatorPlanType.this, "3rd Daughter Age must be 1 day to 25 Years", Toast.LENGTH_SHORT).show();
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
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    Toast.makeText(CalculatorPlanType.this, "4th Daughter Age must be 1 day to 25 Years", Toast.LENGTH_SHORT).show();
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
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    MotherAge= String.valueOf(selectYearMotherAdult);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearMotherAdult < 36 || (selectYearMotherAdult > 75)) {
                Toast.makeText(CalculatorPlanType.this, "Mother Age must be between 36 to 75 years ", Toast.LENGTH_SHORT).show();
                strMotherAgeEditText="Select Dob";
                MotherAgeEditText.setText(strMotherAgeEditText);
                MotherAgeTxt.setText("Age: "+"");
            }else{
                MotherAgeEditText.setText(strMotherAgeEditText);
                MotherAgeTxt.setText("Age: "+MotherAge);
            }



        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    public void showFatherCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    FatherAge= String.valueOf(selectYearFatherAdult);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearFatherAdult < 36 || (selectYearFatherAdult > 75)) {
                Toast.makeText(CalculatorPlanType.this, "Father Age must be between 36 to 75 years ", Toast.LENGTH_SHORT).show();
                strFatherAgeEditText="Select Dob";
                FatherAgeEditText.setText(strFatherAgeEditText);
                FatherAgeTxt.setText("Age: "+"");
            }else{
                FatherAgeEditText.setText(strFatherAgeEditText);
                FatherAgeTxt.setText("Age: "+FatherAge);
            }



        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    public void showMotherInLawCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    MotherLawAge= String.valueOf(selectMotherLawAdult);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectMotherLawAdult < 36 || (selectMotherLawAdult > 75)) {
                Toast.makeText(CalculatorPlanType.this, "Mother-In-Law Age must be between 36 to 75 years ", Toast.LENGTH_SHORT).show();
                strMotherLawAgeEditText="Select Dob";
                MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                MotherLawAgeTxt.setText("Age: "+"");
            }else{
                MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                MotherLawAgeTxt.setText("Age: "+MotherLawAge);
            }



        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
    public void showFatherInLawCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(CalculatorPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    FatherLawAge= String.valueOf(selectFatherLawAdult);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectFatherLawAdult < 36 || (selectFatherLawAdult > 75)) {
                Toast.makeText(CalculatorPlanType.this, "Father-In-Law Age must be between 36 to 75 years ", Toast.LENGTH_SHORT).show();
                strFatherLawAgeEditText="Select Dob";
                FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                FatherLawAgeTxt.setText("Age: "+"");
            }else{
                FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                FatherLawAgeTxt.setText("Age: "+FatherLawAge);
            }



        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }
}